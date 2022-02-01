package androidx.customview.a;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;
import androidx.b.h;
import androidx.core.g.a.d;
import androidx.core.g.a.e;
import androidx.core.g.w;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class a
  extends androidx.core.g.a
{
  private static final String DEFAULT_CLASS_NAME = "android.view.View";
  public static final int HOST_ID = -1;
  public static final int INVALID_ID = -2147483648;
  private static final Rect INVALID_PARENT_BOUNDS = new Rect(2147483647, 2147483647, -2147483648, -2147483648);
  private static final b.a<d> NODE_ADAPTER = new b.a() {};
  private static final b.b<h<d>, d> SPARSE_VALUES_ADAPTER = new b.b() {};
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
  
  public a(View paramView)
  {
    if (paramView == null) {
      throw new IllegalArgumentException("View may not be null");
    }
    this.mHost = paramView;
    this.mManager = ((AccessibilityManager)paramView.getContext().getSystemService("accessibility"));
    paramView.setFocusable(true);
    if (w.H(paramView) == 0) {
      w.p(paramView, 1);
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
    localAccessibilityEvent.getText().add(((d)localObject).getText());
    localAccessibilityEvent.setContentDescription(((d)localObject).Ov.getContentDescription());
    localAccessibilityEvent.setScrollable(((d)localObject).Ov.isScrollable());
    localAccessibilityEvent.setPassword(((d)localObject).Ov.isPassword());
    localAccessibilityEvent.setEnabled(((d)localObject).Ov.isEnabled());
    localAccessibilityEvent.setChecked(((d)localObject).Ov.isChecked());
    onPopulateEventForVirtualView(paramInt1, localAccessibilityEvent);
    if ((localAccessibilityEvent.getText().isEmpty()) && (localAccessibilityEvent.getContentDescription() == null)) {
      throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }
    localAccessibilityEvent.setClassName(((d)localObject).Ov.getClassName());
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
  
  private d createNodeForChild(int paramInt)
  {
    d locald = d.hr();
    locald.setEnabled(true);
    locald.setFocusable(true);
    locald.t("android.view.View");
    locald.f(INVALID_PARENT_BOUNDS);
    locald.h(INVALID_PARENT_BOUNDS);
    locald.setParent(this.mHost);
    onPopulateNodeForVirtualView(paramInt, locald);
    if ((locald.getText() == null) && (locald.Ov.getContentDescription() == null)) {
      throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
    }
    locald.e(this.mTempParentRect);
    if (this.mTempParentRect.equals(INVALID_PARENT_BOUNDS)) {
      throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    }
    int i = locald.Ov.getActions();
    if ((i & 0x40) != 0) {
      throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    }
    if ((i & 0x80) != 0) {
      throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    }
    locald.s(this.mHost.getContext().getPackageName());
    Object localObject = this.mHost;
    locald.Ox = paramInt;
    if (Build.VERSION.SDK_INT >= 16) {
      locald.Ov.setSource((View)localObject, paramInt);
    }
    boolean bool;
    if (this.mAccessibilityFocusedVirtualViewId == paramInt)
    {
      locald.aa(true);
      locald.bA(128);
      if (this.mKeyboardFocusedVirtualViewId != paramInt) {
        break label427;
      }
      bool = true;
      label243:
      if (!bool) {
        break label432;
      }
      locald.bA(2);
    }
    for (;;)
    {
      locald.Y(bool);
      this.mHost.getLocationOnScreen(this.mTempGlobalRect);
      locald.g(this.mTempScreenRect);
      if (!this.mTempScreenRect.equals(INVALID_PARENT_BOUNDS)) {
        break label495;
      }
      locald.e(this.mTempScreenRect);
      if (locald.Ow == -1) {
        break label460;
      }
      localObject = d.hr();
      for (paramInt = locald.Ow; paramInt != -1; paramInt = ((d)localObject).Ow)
      {
        View localView = this.mHost;
        ((d)localObject).Ow = -1;
        if (Build.VERSION.SDK_INT >= 16) {
          ((d)localObject).Ov.setParent(localView, -1);
        }
        ((d)localObject).f(INVALID_PARENT_BOUNDS);
        onPopulateNodeForVirtualView(paramInt, (d)localObject);
        ((d)localObject).e(this.mTempParentRect);
        this.mTempScreenRect.offset(this.mTempParentRect.left, this.mTempParentRect.top);
      }
      locald.aa(false);
      locald.bA(64);
      break;
      label427:
      bool = false;
      break label243;
      label432:
      if (locald.Ov.isFocusable()) {
        locald.bA(1);
      }
    }
    ((d)localObject).Ov.recycle();
    label460:
    this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
    label495:
    if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect))
    {
      this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
      if (this.mTempScreenRect.intersect(this.mTempVisibleRect))
      {
        locald.h(this.mTempScreenRect);
        if (isVisibleToUser(this.mTempScreenRect)) {
          locald.Z(true);
        }
      }
    }
    return locald;
  }
  
  private d createNodeForHost()
  {
    d locald = d.aw(this.mHost);
    w.onInitializeAccessibilityNodeInfo(this.mHost, locald);
    ArrayList localArrayList = new ArrayList();
    getVisibleVirtualViews(localArrayList);
    if ((locald.Ov.getChildCount() > 0) && (localArrayList.size() > 0)) {
      throw new RuntimeException("Views cannot have both real and virtual children");
    }
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      View localView = this.mHost;
      int k = ((Integer)localArrayList.get(i)).intValue();
      if (Build.VERSION.SDK_INT >= 16) {
        locald.Ov.addChild(localView, k);
      }
      i += 1;
    }
    return locald;
  }
  
  private h<d> getAllNodes()
  {
    ArrayList localArrayList = new ArrayList();
    getVisibleVirtualViews(localArrayList);
    h localh = new h();
    int i = 0;
    while (i < localArrayList.size())
    {
      localh.put(i, createNodeForChild(i));
      i += 1;
    }
    return localh;
  }
  
  private void getBoundsInParent(int paramInt, Rect paramRect)
  {
    obtainAccessibilityNodeInfo(paramInt).e(paramRect);
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
    h localh = getAllNodes();
    int j = this.mKeyboardFocusedVirtualViewId;
    if (j == -2147483648) {}
    for (d locald = null;; locald = (d)localh.b(j, null)) {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      }
    }
    if (w.I(this.mHost) == 1) {}
    Object localObject;
    ArrayList localArrayList;
    for (boolean bool = true;; bool = false)
    {
      paramRect = SPARSE_VALUES_ADAPTER;
      localObject = NODE_ADAPTER;
      j = paramRect.E(localh);
      localArrayList = new ArrayList(j);
      while (i < j)
      {
        localArrayList.add(paramRect.b(localh, i));
        i += 1;
      }
    }
    Collections.sort(localArrayList, new b.c(bool, (b.a)localObject));
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    case 2: 
      i = localArrayList.size();
      if (locald == null)
      {
        paramInt = -1;
        paramInt += 1;
        if (paramInt >= i) {
          break label297;
        }
        paramRect = localArrayList.get(paramInt);
        label268:
        paramRect = (d)paramRect;
        if (paramRect != null) {
          break label425;
        }
      }
      break;
    }
    label425:
    for (paramInt = -2147483648;; paramInt = localh.aP(localh.r(paramRect)))
    {
      return requestKeyboardFocusForVirtualView(paramInt);
      paramInt = localArrayList.lastIndexOf(locald);
      break;
      label297:
      paramRect = null;
      break label268;
      paramInt = localArrayList.size();
      if (locald == null) {}
      for (;;)
      {
        paramInt -= 1;
        if (paramInt < 0) {
          break label342;
        }
        paramRect = localArrayList.get(paramInt);
        break;
        paramInt = localArrayList.indexOf(locald);
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
        paramRect = (d)b.a(localh, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, locald, (Rect)localObject, paramInt);
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
    return w.performAccessibilityAction(this.mHost, paramInt, paramBundle);
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
  
  public e getAccessibilityNodeProvider(View paramView)
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
        androidx.core.g.a.b.a(localAccessibilityEvent, paramInt2);
        z.a(localViewParent, this.mHost, localAccessibilityEvent);
      }
    }
  }
  
  d obtainAccessibilityNodeInfo(int paramInt)
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
  
  public void onInitializeAccessibilityNodeInfo(View paramView, d paramd)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramd);
    onPopulateNodeForHost(paramd);
  }
  
  protected abstract boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle);
  
  protected void onPopulateEventForHost(AccessibilityEvent paramAccessibilityEvent) {}
  
  protected void onPopulateEventForVirtualView(int paramInt, AccessibilityEvent paramAccessibilityEvent) {}
  
  protected void onPopulateNodeForHost(d paramd) {}
  
  protected abstract void onPopulateNodeForVirtualView(int paramInt, d paramd);
  
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
    return z.a(localViewParent, this.mHost, localAccessibilityEvent);
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
  
  class a
    extends e
  {
    a() {}
    
    public final d bC(int paramInt)
    {
      AppMethodBeat.i(197606);
      d locald = d.a(a.this.obtainAccessibilityNodeInfo(paramInt));
      AppMethodBeat.o(197606);
      return locald;
    }
    
    public final d bD(int paramInt)
    {
      AppMethodBeat.i(197608);
      if (paramInt == 2) {}
      for (paramInt = a.this.mAccessibilityFocusedVirtualViewId; paramInt == -2147483648; paramInt = a.this.mKeyboardFocusedVirtualViewId)
      {
        AppMethodBeat.o(197608);
        return null;
      }
      d locald = bC(paramInt);
      AppMethodBeat.o(197608);
      return locald;
    }
    
    public final boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      AppMethodBeat.i(197607);
      boolean bool = a.this.performAction(paramInt1, paramInt2, paramBundle);
      AppMethodBeat.o(197607);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.customview.a.a
 * JD-Core Version:    0.7.0.1
 */