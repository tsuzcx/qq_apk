package androidx.customview.a;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.b.h;
import androidx.core.g.a.d;
import androidx.core.g.a.e;
import androidx.core.g.a.f;
import androidx.core.g.ac;
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
    if (z.R(paramView) == 0) {
      z.p(paramView, 1);
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
    d locald = obtainAccessibilityNodeInfo(paramInt1);
    localAccessibilityEvent.getText().add(locald.getText());
    localAccessibilityEvent.setContentDescription(locald.getContentDescription());
    localAccessibilityEvent.setScrollable(locald.EP());
    localAccessibilityEvent.setPassword(locald.EO());
    localAccessibilityEvent.setEnabled(locald.isEnabled());
    localAccessibilityEvent.setChecked(locald.isChecked());
    onPopulateEventForVirtualView(paramInt1, localAccessibilityEvent);
    if ((localAccessibilityEvent.getText().isEmpty()) && (localAccessibilityEvent.getContentDescription() == null)) {
      throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }
    localAccessibilityEvent.setClassName(locald.ER());
    f.a(localAccessibilityEvent, this.mHost, paramInt1);
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
    d locald1 = d.EI();
    locald1.setEnabled(true);
    locald1.setFocusable(true);
    locald1.v("android.view.View");
    locald1.k(INVALID_PARENT_BOUNDS);
    locald1.m(INVALID_PARENT_BOUNDS);
    locald1.setParent(this.mHost);
    onPopulateNodeForVirtualView(paramInt, locald1);
    if ((locald1.getText() == null) && (locald1.getContentDescription() == null)) {
      throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
    }
    locald1.j(this.mTempParentRect);
    if (this.mTempParentRect.equals(INVALID_PARENT_BOUNDS)) {
      throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    }
    int i = locald1.EJ();
    if ((i & 0x40) != 0) {
      throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    }
    if ((i & 0x80) != 0) {
      throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    }
    locald1.u(this.mHost.getContext().getPackageName());
    locald1.y(this.mHost, paramInt);
    boolean bool;
    if (this.mAccessibilityFocusedVirtualViewId == paramInt)
    {
      locald1.aG(true);
      locald1.eu(128);
      if (this.mKeyboardFocusedVirtualViewId != paramInt) {
        break label379;
      }
      bool = true;
      label216:
      if (!bool) {
        break label384;
      }
      locald1.eu(2);
    }
    d locald2;
    for (;;)
    {
      locald1.aE(bool);
      this.mHost.getLocationOnScreen(this.mTempGlobalRect);
      locald1.l(this.mTempScreenRect);
      if (!this.mTempScreenRect.equals(INVALID_PARENT_BOUNDS)) {
        break label441;
      }
      locald1.j(this.mTempScreenRect);
      if (locald1.buP == -1) {
        break label406;
      }
      locald2 = d.EI();
      for (paramInt = locald1.buP; paramInt != -1; paramInt = locald2.buP)
      {
        locald2.A(this.mHost, -1);
        locald2.k(INVALID_PARENT_BOUNDS);
        onPopulateNodeForVirtualView(paramInt, locald2);
        locald2.j(this.mTempParentRect);
        this.mTempScreenRect.offset(this.mTempParentRect.left, this.mTempParentRect.top);
      }
      locald1.aG(false);
      locald1.eu(64);
      break;
      label379:
      bool = false;
      break label216;
      label384:
      if (locald1.isFocusable()) {
        locald1.eu(1);
      }
    }
    locald2.recycle();
    label406:
    this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
    label441:
    if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect))
    {
      this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
      if (this.mTempScreenRect.intersect(this.mTempVisibleRect))
      {
        locald1.m(this.mTempScreenRect);
        if (isVisibleToUser(this.mTempScreenRect)) {
          locald1.aF(true);
        }
      }
    }
    return locald1;
  }
  
  private d createNodeForHost()
  {
    d locald = d.aK(this.mHost);
    z.onInitializeAccessibilityNodeInfo(this.mHost, locald);
    ArrayList localArrayList = new ArrayList();
    getVisibleVirtualViews(localArrayList);
    if ((locald.getChildCount() > 0) && (localArrayList.size() > 0)) {
      throw new RuntimeException("Views cannot have both real and virtual children");
    }
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      locald.z(this.mHost, ((Integer)localArrayList.get(i)).intValue());
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
    obtainAccessibilityNodeInfo(paramInt).j(paramRect);
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
    for (d locald = null;; locald = (d)localh.d(j, null)) {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      }
    }
    if (z.U(this.mHost) == 1) {}
    Object localObject;
    ArrayList localArrayList;
    for (boolean bool = true;; bool = false)
    {
      paramRect = SPARSE_VALUES_ADAPTER;
      localObject = NODE_ADAPTER;
      j = paramRect.aD(localh);
      localArrayList = new ArrayList(j);
      while (i < j)
      {
        localArrayList.add(paramRect.c(localh, i));
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
    for (paramInt = -2147483648;; paramInt = localh.bo(localh.z(paramRect)))
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
    return z.performAccessibilityAction(this.mHost, paramInt, paramBundle);
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
        ac.a(localViewParent, this.mHost, localAccessibilityEvent);
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
    return ac.a(localViewParent, this.mHost, localAccessibilityEvent);
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
    
    public final d ex(int paramInt)
    {
      AppMethodBeat.i(192436);
      d locald = d.a(a.this.obtainAccessibilityNodeInfo(paramInt));
      AppMethodBeat.o(192436);
      return locald;
    }
    
    public final d ey(int paramInt)
    {
      AppMethodBeat.i(192455);
      if (paramInt == 2) {}
      for (paramInt = a.this.mAccessibilityFocusedVirtualViewId; paramInt == -2147483648; paramInt = a.this.mKeyboardFocusedVirtualViewId)
      {
        AppMethodBeat.o(192455);
        return null;
      }
      d locald = ex(paramInt);
      AppMethodBeat.o(192455);
      return locald;
    }
    
    public final boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      AppMethodBeat.i(192445);
      boolean bool = a.this.performAction(paramInt1, paramInt2, paramBundle);
      AppMethodBeat.o(192445);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.customview.a.a
 * JD-Core Version:    0.7.0.1
 */