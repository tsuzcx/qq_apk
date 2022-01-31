package android.support.v4.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.e.n;
import android.support.v4.view.a.b;
import android.support.v4.view.a.c;
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
  private static final k.a<b> NODE_ADAPTER = new j.1();
  private static final k.b<n<b>, b> SPARSE_VALUES_ADAPTER = new j.2();
  int mAccessibilityFocusedVirtualViewId = -2147483648;
  private final View mHost;
  private int mHoveredVirtualViewId = -2147483648;
  int mKeyboardFocusedVirtualViewId = -2147483648;
  private final AccessibilityManager mManager;
  private j.a mNodeProvider;
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
    if (t.S(paramView) == 0) {
      t.o(paramView, 1);
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
    localAccessibilityEvent.getText().add(((b)localObject).Hq.getText());
    localAccessibilityEvent.setContentDescription(((b)localObject).Hq.getContentDescription());
    localAccessibilityEvent.setScrollable(((b)localObject).Hq.isScrollable());
    localAccessibilityEvent.setPassword(((b)localObject).Hq.isPassword());
    localAccessibilityEvent.setEnabled(((b)localObject).Hq.isEnabled());
    localAccessibilityEvent.setChecked(((b)localObject).Hq.isChecked());
    onPopulateEventForVirtualView(paramInt1, localAccessibilityEvent);
    if ((localAccessibilityEvent.getText().isEmpty()) && (localAccessibilityEvent.getContentDescription() == null)) {
      throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }
    localAccessibilityEvent.setClassName(((b)localObject).Hq.getClassName());
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
  
  private b createNodeForChild(int paramInt)
  {
    b localb = b.a(AccessibilityNodeInfo.obtain());
    localb.setEnabled(true);
    localb.setFocusable(true);
    localb.setClassName("android.view.View");
    localb.setBoundsInParent(INVALID_PARENT_BOUNDS);
    localb.setBoundsInScreen(INVALID_PARENT_BOUNDS);
    localb.setParent(this.mHost);
    onPopulateNodeForVirtualView(paramInt, localb);
    if ((localb.Hq.getText() == null) && (localb.Hq.getContentDescription() == null)) {
      throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
    }
    localb.getBoundsInParent(this.mTempParentRect);
    if (this.mTempParentRect.equals(INVALID_PARENT_BOUNDS)) {
      throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    }
    int i = localb.Hq.getActions();
    if ((i & 0x40) != 0) {
      throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    }
    if ((i & 0x80) != 0) {
      throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    }
    localb.setPackageName(this.mHost.getContext().getPackageName());
    Object localObject = this.mHost;
    if (Build.VERSION.SDK_INT >= 16) {
      localb.Hq.setSource((View)localObject, paramInt);
    }
    boolean bool;
    if (this.mAccessibilityFocusedVirtualViewId == paramInt)
    {
      localb.setAccessibilityFocused(true);
      localb.addAction(128);
      if (this.mKeyboardFocusedVirtualViewId != paramInt) {
        break label430;
      }
      bool = true;
      label243:
      if (!bool) {
        break label435;
      }
      localb.addAction(2);
    }
    for (;;)
    {
      localb.setFocused(bool);
      this.mHost.getLocationOnScreen(this.mTempGlobalRect);
      localb.getBoundsInScreen(this.mTempScreenRect);
      if (!this.mTempScreenRect.equals(INVALID_PARENT_BOUNDS)) {
        break label498;
      }
      localb.getBoundsInParent(this.mTempScreenRect);
      if (localb.Hr == -1) {
        break label463;
      }
      localObject = b.a(AccessibilityNodeInfo.obtain());
      for (paramInt = localb.Hr; paramInt != -1; paramInt = ((b)localObject).Hr)
      {
        View localView = this.mHost;
        ((b)localObject).Hr = -1;
        if (Build.VERSION.SDK_INT >= 16) {
          ((b)localObject).Hq.setParent(localView, -1);
        }
        ((b)localObject).setBoundsInParent(INVALID_PARENT_BOUNDS);
        onPopulateNodeForVirtualView(paramInt, (b)localObject);
        ((b)localObject).getBoundsInParent(this.mTempParentRect);
        this.mTempScreenRect.offset(this.mTempParentRect.left, this.mTempParentRect.top);
      }
      localb.setAccessibilityFocused(false);
      localb.addAction(64);
      break;
      label430:
      bool = false;
      break label243;
      label435:
      if (localb.Hq.isFocusable()) {
        localb.addAction(1);
      }
    }
    ((b)localObject).Hq.recycle();
    label463:
    this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
    label498:
    if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect))
    {
      this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
      if (this.mTempScreenRect.intersect(this.mTempVisibleRect))
      {
        localb.setBoundsInScreen(this.mTempScreenRect);
        if (isVisibleToUser(this.mTempScreenRect)) {
          localb.setVisibleToUser(true);
        }
      }
    }
    return localb;
  }
  
  private b createNodeForHost()
  {
    b localb = b.a(AccessibilityNodeInfo.obtain(this.mHost));
    t.onInitializeAccessibilityNodeInfo(this.mHost, localb);
    ArrayList localArrayList = new ArrayList();
    getVisibleVirtualViews(localArrayList);
    if ((localb.Hq.getChildCount() > 0) && (localArrayList.size() > 0)) {
      throw new RuntimeException("Views cannot have both real and virtual children");
    }
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      View localView = this.mHost;
      int k = ((Integer)localArrayList.get(i)).intValue();
      if (Build.VERSION.SDK_INT >= 16) {
        localb.Hq.addChild(localView, k);
      }
      i += 1;
    }
    return localb;
  }
  
  private n<b> getAllNodes()
  {
    ArrayList localArrayList = new ArrayList();
    getVisibleVirtualViews(localArrayList);
    n localn = new n();
    int i = 0;
    while (i < localArrayList.size())
    {
      localn.put(i, createNodeForChild(i));
      i += 1;
    }
    return localn;
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
    n localn = getAllNodes();
    int j = this.mKeyboardFocusedVirtualViewId;
    if (j == -2147483648) {}
    for (b localb = null;; localb = (b)localn.get(j, null)) {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      }
    }
    if (t.T(this.mHost) == 1) {}
    Object localObject;
    ArrayList localArrayList;
    for (boolean bool = true;; bool = false)
    {
      paramRect = SPARSE_VALUES_ADAPTER;
      localObject = NODE_ADAPTER;
      j = paramRect.J(localn);
      localArrayList = new ArrayList(j);
      while (i < j)
      {
        localArrayList.add(paramRect.get(localn, i));
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
      if (localb == null)
      {
        paramInt = -1;
        paramInt += 1;
        if (paramInt >= i) {
          break label297;
        }
        paramRect = localArrayList.get(paramInt);
        label268:
        paramRect = (b)paramRect;
        if (paramRect != null) {
          break label425;
        }
      }
      break;
    }
    label425:
    for (paramInt = -2147483648;; paramInt = localn.keyAt(localn.indexOfValue(paramRect)))
    {
      return requestKeyboardFocusForVirtualView(paramInt);
      paramInt = localArrayList.lastIndexOf(localb);
      break;
      label297:
      paramRect = null;
      break label268;
      paramInt = localArrayList.size();
      if (localb == null) {}
      for (;;)
      {
        paramInt -= 1;
        if (paramInt < 0) {
          break label342;
        }
        paramRect = localArrayList.get(paramInt);
        break;
        paramInt = localArrayList.indexOf(localb);
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
        paramRect = (b)k.a(localn, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, localb, (Rect)localObject, paramInt);
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
  
  private void updateHoveredVirtualView(int paramInt)
  {
    if (this.mHoveredVirtualViewId == paramInt) {
      return;
    }
    int i = this.mHoveredVirtualViewId;
    this.mHoveredVirtualViewId = paramInt;
    sendEventForVirtualView(paramInt, 128);
    sendEventForVirtualView(i, 256);
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
  
  public c getAccessibilityNodeProvider(View paramView)
  {
    if (this.mNodeProvider == null) {
      this.mNodeProvider = new j.a(this);
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
  
  b obtainAccessibilityNodeInfo(int paramInt)
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
  
  public void onInitializeAccessibilityNodeInfo(View paramView, b paramb)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramb);
    onPopulateNodeForHost(paramb);
  }
  
  protected abstract boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle);
  
  protected void onPopulateEventForHost(AccessibilityEvent paramAccessibilityEvent) {}
  
  protected void onPopulateEventForVirtualView(int paramInt, AccessibilityEvent paramAccessibilityEvent) {}
  
  protected void onPopulateNodeForHost(b paramb) {}
  
  protected abstract void onPopulateNodeForVirtualView(int paramInt, b paramb);
  
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v4.widget.j
 * JD-Core Version:    0.7.0.1
 */