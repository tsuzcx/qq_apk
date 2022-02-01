package android.support.v4.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.e.o;
import android.support.v4.view.a.c;
import android.support.v4.view.a.d;
import android.support.v4.view.t;
import android.support.v4.view.w;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class j
  extends android.support.v4.view.a
{
  private static final String DEFAULT_CLASS_NAME = "android.view.View";
  public static final int HOST_ID = -1;
  public static final int INVALID_ID = -2147483648;
  private static final Rect INVALID_PARENT_BOUNDS = new Rect(2147483647, 2147483647, -2147483648, -2147483648);
  private static final k.a<c> NODE_ADAPTER = new k.a() {};
  private static final k.b<o<c>, c> SPARSE_VALUES_ADAPTER = new k.b() {};
  int mAccessibilityFocusedVirtualViewId = -2147483648;
  private final View mHost;
  public int mHoveredVirtualViewId = -2147483648;
  int mKeyboardFocusedVirtualViewId = -2147483648;
  private final AccessibilityManager mManager;
  private a mNodeProvider;
  private final int[] mTempGlobalRect = new int[2];
  private final Rect mTempParentRect = new Rect();
  private final Rect mTempScreenRect = new Rect();
  private final Rect mTempVisibleRect = new Rect();
  
  public j(View paramView)
  {
    if (paramView == null) {
      throw new IllegalArgumentException("View may not be null");
    }
    this.mHost = paramView;
    this.mManager = ((AccessibilityManager)paramView.getContext().getSystemService("accessibility"));
    paramView.setFocusable(true);
    if (t.X(paramView) == 0) {
      t.p(paramView, 1);
    }
  }
  
  private boolean clearAccessibilityFocus(int paramInt)
  {
    if (this.mAccessibilityFocusedVirtualViewId == paramInt)
    {
      this.mAccessibilityFocusedVirtualViewId = -2147483648;
      this.mHost.invalidate();
      sendEventForVirtualView(paramInt, 65536);
      return true;
    }
    return false;
  }
  
  private boolean clickKeyboardFocusedVirtualView()
  {
    return (this.mKeyboardFocusedVirtualViewId != -2147483648) && (onPerformActionForVirtualView(this.mKeyboardFocusedVirtualViewId, 16, null));
  }
  
  private AccessibilityEvent createEvent(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return createEventForChild(paramInt1, paramInt2);
    }
    return createEventForHost(paramInt2);
  }
  
  private AccessibilityEvent createEventForChild(int paramInt1, int paramInt2)
  {
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramInt2);
    Object localObject = obtainAccessibilityNodeInfo(paramInt1);
    localAccessibilityEvent.getText().add(((c)localObject).Pm.getText());
    localAccessibilityEvent.setContentDescription(((c)localObject).Pm.getContentDescription());
    localAccessibilityEvent.setScrollable(((c)localObject).Pm.isScrollable());
    localAccessibilityEvent.setPassword(((c)localObject).Pm.isPassword());
    localAccessibilityEvent.setEnabled(((c)localObject).Pm.isEnabled());
    localAccessibilityEvent.setChecked(((c)localObject).Pm.isChecked());
    onPopulateEventForVirtualView(paramInt1, localAccessibilityEvent);
    if ((localAccessibilityEvent.getText().isEmpty()) && (localAccessibilityEvent.getContentDescription() == null)) {
      throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }
    localAccessibilityEvent.setClassName(((c)localObject).Pm.getClassName());
    localObject = this.mHost;
    if (Build.VERSION.SDK_INT >= 16) {
      localAccessibilityEvent.setSource((View)localObject, paramInt1);
    }
    localAccessibilityEvent.setPackageName(this.mHost.getContext().getPackageName());
    return localAccessibilityEvent;
  }
  
  private AccessibilityEvent createEventForHost(int paramInt)
  {
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramInt);
    this.mHost.onInitializeAccessibilityEvent(localAccessibilityEvent);
    return localAccessibilityEvent;
  }
  
  private c createNodeForChild(int paramInt)
  {
    c localc = c.a(AccessibilityNodeInfo.obtain());
    localc.setEnabled(true);
    localc.setFocusable(true);
    localc.setClassName("android.view.View");
    localc.setBoundsInParent(INVALID_PARENT_BOUNDS);
    localc.setBoundsInScreen(INVALID_PARENT_BOUNDS);
    localc.setParent(this.mHost);
    onPopulateNodeForVirtualView(paramInt, localc);
    if ((localc.Pm.getText() == null) && (localc.Pm.getContentDescription() == null)) {
      throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
    }
    localc.getBoundsInParent(this.mTempParentRect);
    if (this.mTempParentRect.equals(INVALID_PARENT_BOUNDS)) {
      throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    }
    int i = localc.Pm.getActions();
    if ((i & 0x40) != 0) {
      throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    }
    if ((i & 0x80) != 0) {
      throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    }
    localc.setPackageName(this.mHost.getContext().getPackageName());
    Object localObject = this.mHost;
    if (Build.VERSION.SDK_INT >= 16) {
      localc.Pm.setSource((View)localObject, paramInt);
    }
    boolean bool;
    if (this.mAccessibilityFocusedVirtualViewId == paramInt)
    {
      localc.setAccessibilityFocused(true);
      localc.addAction(128);
      if (this.mKeyboardFocusedVirtualViewId != paramInt) {
        break label430;
      }
      bool = true;
      label243:
      if (!bool) {
        break label435;
      }
      localc.addAction(2);
    }
    for (;;)
    {
      localc.setFocused(bool);
      this.mHost.getLocationOnScreen(this.mTempGlobalRect);
      localc.getBoundsInScreen(this.mTempScreenRect);
      if (!this.mTempScreenRect.equals(INVALID_PARENT_BOUNDS)) {
        break label498;
      }
      localc.getBoundsInParent(this.mTempScreenRect);
      if (localc.Pn == -1) {
        break label463;
      }
      localObject = c.a(AccessibilityNodeInfo.obtain());
      for (paramInt = localc.Pn; paramInt != -1; paramInt = ((c)localObject).Pn)
      {
        View localView = this.mHost;
        ((c)localObject).Pn = -1;
        if (Build.VERSION.SDK_INT >= 16) {
          ((c)localObject).Pm.setParent(localView, -1);
        }
        ((c)localObject).setBoundsInParent(INVALID_PARENT_BOUNDS);
        onPopulateNodeForVirtualView(paramInt, (c)localObject);
        ((c)localObject).getBoundsInParent(this.mTempParentRect);
        this.mTempScreenRect.offset(this.mTempParentRect.left, this.mTempParentRect.top);
      }
      localc.setAccessibilityFocused(false);
      localc.addAction(64);
      break;
      label430:
      bool = false;
      break label243;
      label435:
      if (localc.Pm.isFocusable()) {
        localc.addAction(1);
      }
    }
    ((c)localObject).Pm.recycle();
    label463:
    this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
    label498:
    if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect))
    {
      this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
      if (this.mTempScreenRect.intersect(this.mTempVisibleRect))
      {
        localc.setBoundsInScreen(this.mTempScreenRect);
        if (isVisibleToUser(this.mTempScreenRect)) {
          localc.setVisibleToUser(true);
        }
      }
    }
    return localc;
  }
  
  private c createNodeForHost()
  {
    c localc = c.a(AccessibilityNodeInfo.obtain(this.mHost));
    t.onInitializeAccessibilityNodeInfo(this.mHost, localc);
    ArrayList localArrayList = new ArrayList();
    getVisibleVirtualViews(localArrayList);
    if ((localc.Pm.getChildCount() > 0) && (localArrayList.size() > 0)) {
      throw new RuntimeException("Views cannot have both real and virtual children");
    }
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      View localView = this.mHost;
      int k = ((Integer)localArrayList.get(i)).intValue();
      if (Build.VERSION.SDK_INT >= 16) {
        localc.Pm.addChild(localView, k);
      }
      i += 1;
    }
    return localc;
  }
  
  private o<c> getAllNodes()
  {
    ArrayList localArrayList = new ArrayList();
    getVisibleVirtualViews(localArrayList);
    o localo = new o();
    int i = 0;
    while (i < localArrayList.size())
    {
      localo.put(i, createNodeForChild(i));
      i += 1;
    }
    return localo;
  }
  
  private void getBoundsInParent(int paramInt, Rect paramRect)
  {
    obtainAccessibilityNodeInfo(paramInt).getBoundsInParent(paramRect);
  }
  
  private static Rect guessPreviouslyFocusedRect(View paramView, int paramInt, Rect paramRect)
  {
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    case 17: 
      paramRect.set(i, 0, i, j);
      return paramRect;
    case 33: 
      paramRect.set(0, j, i, j);
      return paramRect;
    case 66: 
      paramRect.set(-1, 0, -1, j);
      return paramRect;
    }
    paramRect.set(0, -1, i, -1);
    return paramRect;
  }
  
  private boolean isVisibleToUser(Rect paramRect)
  {
    if ((paramRect == null) || (paramRect.isEmpty())) {
      return false;
    }
    if (this.mHost.getWindowVisibility() != 0) {
      return false;
    }
    for (paramRect = this.mHost.getParent(); (paramRect instanceof View); paramRect = paramRect.getParent())
    {
      paramRect = (View)paramRect;
      if ((paramRect.getAlpha() <= 0.0F) || (paramRect.getVisibility() != 0)) {
        return false;
      }
    }
    return paramRect != null;
  }
  
  private static int keyToDirection(int paramInt)
  {
    switch (paramInt)
    {
    case 20: 
    default: 
      return 130;
    case 21: 
      return 17;
    case 19: 
      return 33;
    }
    return 66;
  }
  
  private boolean moveFocus(int paramInt, Rect paramRect)
  {
    int i = 0;
    o localo = getAllNodes();
    int j = this.mKeyboardFocusedVirtualViewId;
    if (j == -2147483648) {}
    for (c localc = null;; localc = (c)localo.get(j, null)) {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      }
    }
    if (t.Y(this.mHost) == 1) {}
    Object localObject;
    ArrayList localArrayList;
    for (boolean bool = true;; bool = false)
    {
      paramRect = SPARSE_VALUES_ADAPTER;
      localObject = NODE_ADAPTER;
      j = paramRect.K(localo);
      localArrayList = new ArrayList(j);
      while (i < j)
      {
        localArrayList.add(paramRect.get(localo, i));
        i += 1;
      }
    }
    Collections.sort(localArrayList, new k.c(bool, (k.a)localObject));
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    case 2: 
      i = localArrayList.size();
      if (localc == null)
      {
        paramInt = -1;
        paramInt += 1;
        if (paramInt >= i) {
          break label297;
        }
        paramRect = localArrayList.get(paramInt);
        label268:
        paramRect = (c)paramRect;
        if (paramRect != null) {
          break label425;
        }
      }
      break;
    }
    label425:
    for (paramInt = -2147483648;; paramInt = localo.keyAt(localo.indexOfValue(paramRect)))
    {
      return requestKeyboardFocusForVirtualView(paramInt);
      paramInt = localArrayList.lastIndexOf(localc);
      break;
      label297:
      paramRect = null;
      break label268;
      paramInt = localArrayList.size();
      if (localc == null) {}
      for (;;)
      {
        paramInt -= 1;
        if (paramInt < 0) {
          break label342;
        }
        paramRect = localArrayList.get(paramInt);
        break;
        paramInt = localArrayList.indexOf(localc);
      }
      label342:
      paramRect = null;
      break label268;
      localObject = new Rect();
      if (this.mKeyboardFocusedVirtualViewId != -2147483648) {
        getBoundsInParent(this.mKeyboardFocusedVirtualViewId, (Rect)localObject);
      }
      for (;;)
      {
        paramRect = (c)k.a(localo, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, localc, (Rect)localObject, paramInt);
        break;
        if (paramRect != null) {
          ((Rect)localObject).set(paramRect);
        } else {
          guessPreviouslyFocusedRect(this.mHost, paramInt, (Rect)localObject);
        }
      }
    }
  }
  
  private boolean performActionForChild(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    switch (paramInt2)
    {
    default: 
      return onPerformActionForVirtualView(paramInt1, paramInt2, paramBundle);
    case 64: 
      return requestAccessibilityFocus(paramInt1);
    case 128: 
      return clearAccessibilityFocus(paramInt1);
    case 1: 
      return requestKeyboardFocusForVirtualView(paramInt1);
    }
    return clearKeyboardFocusForVirtualView(paramInt1);
  }
  
  private boolean performActionForHost(int paramInt, Bundle paramBundle)
  {
    return t.performAccessibilityAction(this.mHost, paramInt, paramBundle);
  }
  
  private boolean requestAccessibilityFocus(int paramInt)
  {
    if ((!this.mManager.isEnabled()) || (!this.mManager.isTouchExplorationEnabled())) {}
    while (this.mAccessibilityFocusedVirtualViewId == paramInt) {
      return false;
    }
    if (this.mAccessibilityFocusedVirtualViewId != -2147483648) {
      clearAccessibilityFocus(this.mAccessibilityFocusedVirtualViewId);
    }
    this.mAccessibilityFocusedVirtualViewId = paramInt;
    this.mHost.invalidate();
    sendEventForVirtualView(paramInt, 32768);
    return true;
  }
  
  public final boolean clearKeyboardFocusForVirtualView(int paramInt)
  {
    if (this.mKeyboardFocusedVirtualViewId != paramInt) {
      return false;
    }
    this.mKeyboardFocusedVirtualViewId = -2147483648;
    onVirtualViewKeyboardFocusChanged(paramInt, false);
    sendEventForVirtualView(paramInt, 8);
    return true;
  }
  
  public final boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if ((!this.mManager.isEnabled()) || (!this.mManager.isTouchExplorationEnabled())) {
      bool = false;
    }
    int i;
    do
    {
      return bool;
      switch (paramMotionEvent.getAction())
      {
      case 8: 
      default: 
        return false;
      case 7: 
      case 9: 
        i = getVirtualViewAt(paramMotionEvent.getX(), paramMotionEvent.getY());
        updateHoveredVirtualView(i);
      }
    } while (i != -2147483648);
    return false;
    if (this.mHoveredVirtualViewId != -2147483648)
    {
      updateHoveredVirtualView(-2147483648);
      return true;
    }
    return false;
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int i;
    if (paramKeyEvent.getAction() != 1)
    {
      i = paramKeyEvent.getKeyCode();
      switch (i)
      {
      }
    }
    do
    {
      do
      {
        boolean bool2;
        do
        {
          bool2 = false;
          return bool2;
        } while (!paramKeyEvent.hasNoModifiers());
        int j = keyToDirection(i);
        int k = paramKeyEvent.getRepeatCount();
        i = 0;
        for (boolean bool1 = false;; bool1 = true)
        {
          bool2 = bool1;
          if (i >= k + 1) {
            break;
          }
          bool2 = bool1;
          if (!moveFocus(j, null)) {
            break;
          }
          i += 1;
        }
      } while ((!paramKeyEvent.hasNoModifiers()) || (paramKeyEvent.getRepeatCount() != 0));
      clickKeyboardFocusedVirtualView();
      return true;
      if (paramKeyEvent.hasNoModifiers()) {
        return moveFocus(2, null);
      }
    } while (!paramKeyEvent.hasModifiers(1));
    return moveFocus(1, null);
  }
  
  public final int getAccessibilityFocusedVirtualViewId()
  {
    return this.mAccessibilityFocusedVirtualViewId;
  }
  
  public d getAccessibilityNodeProvider(View paramView)
  {
    if (this.mNodeProvider == null) {
      this.mNodeProvider = new a();
    }
    return this.mNodeProvider;
  }
  
  @Deprecated
  public int getFocusedVirtualView()
  {
    return getAccessibilityFocusedVirtualViewId();
  }
  
  public final int getKeyboardFocusedVirtualViewId()
  {
    return this.mKeyboardFocusedVirtualViewId;
  }
  
  protected abstract int getVirtualViewAt(float paramFloat1, float paramFloat2);
  
  protected abstract void getVisibleVirtualViews(List<Integer> paramList);
  
  public final void invalidateRoot()
  {
    invalidateVirtualView(-1, 1);
  }
  
  public final void invalidateVirtualView(int paramInt)
  {
    invalidateVirtualView(paramInt, 0);
  }
  
  public final void invalidateVirtualView(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != -2147483648) && (this.mManager.isEnabled()))
    {
      ViewParent localViewParent = this.mHost.getParent();
      if (localViewParent != null)
      {
        AccessibilityEvent localAccessibilityEvent = createEvent(paramInt1, 2048);
        android.support.v4.view.a.a.a(localAccessibilityEvent, paramInt2);
        w.a(localViewParent, this.mHost, localAccessibilityEvent);
      }
    }
  }
  
  c obtainAccessibilityNodeInfo(int paramInt)
  {
    if (paramInt == -1) {
      return createNodeForHost();
    }
    return createNodeForChild(paramInt);
  }
  
  public final void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    if (this.mKeyboardFocusedVirtualViewId != -2147483648) {
      clearKeyboardFocusForVirtualView(this.mKeyboardFocusedVirtualViewId);
    }
    if (paramBoolean) {
      moveFocus(paramInt, paramRect);
    }
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    onPopulateEventForHost(paramAccessibilityEvent);
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, c paramc)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramc);
    onPopulateNodeForHost(paramc);
  }
  
  protected abstract boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle);
  
  protected void onPopulateEventForHost(AccessibilityEvent paramAccessibilityEvent) {}
  
  protected void onPopulateEventForVirtualView(int paramInt, AccessibilityEvent paramAccessibilityEvent) {}
  
  protected void onPopulateNodeForHost(c paramc) {}
  
  protected abstract void onPopulateNodeForVirtualView(int paramInt, c paramc);
  
  protected void onVirtualViewKeyboardFocusChanged(int paramInt, boolean paramBoolean) {}
  
  boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    switch (paramInt1)
    {
    default: 
      return performActionForChild(paramInt1, paramInt2, paramBundle);
    }
    return performActionForHost(paramInt2, paramBundle);
  }
  
  public final boolean requestKeyboardFocusForVirtualView(int paramInt)
  {
    if ((!this.mHost.isFocused()) && (!this.mHost.requestFocus())) {}
    while (this.mKeyboardFocusedVirtualViewId == paramInt) {
      return false;
    }
    if (this.mKeyboardFocusedVirtualViewId != -2147483648) {
      clearKeyboardFocusForVirtualView(this.mKeyboardFocusedVirtualViewId);
    }
    this.mKeyboardFocusedVirtualViewId = paramInt;
    onVirtualViewKeyboardFocusChanged(paramInt, true);
    sendEventForVirtualView(paramInt, 8);
    return true;
  }
  
  public final boolean sendEventForVirtualView(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == -2147483648) || (!this.mManager.isEnabled())) {}
    ViewParent localViewParent;
    do
    {
      return false;
      localViewParent = this.mHost.getParent();
    } while (localViewParent == null);
    AccessibilityEvent localAccessibilityEvent = createEvent(paramInt1, paramInt2);
    return w.a(localViewParent, this.mHost, localAccessibilityEvent);
  }
  
  public void updateHoveredVirtualView(int paramInt)
  {
    if (this.mHoveredVirtualViewId == paramInt) {
      return;
    }
    int i = this.mHoveredVirtualViewId;
    this.mHoveredVirtualViewId = paramInt;
    sendEventForVirtualView(paramInt, 128);
    sendEventForVirtualView(i, 256);
  }
  
  final class a
    extends d
  {
    a() {}
    
    public final c aP(int paramInt)
    {
      return c.a(j.this.obtainAccessibilityNodeInfo(paramInt));
    }
    
    public final c aQ(int paramInt)
    {
      if (paramInt == 2) {}
      for (paramInt = j.this.mAccessibilityFocusedVirtualViewId; paramInt == -2147483648; paramInt = j.this.mKeyboardFocusedVirtualViewId) {
        return null;
      }
      return aP(paramInt);
    }
    
    public final boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      return j.this.performAction(paramInt1, paramInt2, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.widget.j
 * JD-Core Version:    0.7.0.1
 */