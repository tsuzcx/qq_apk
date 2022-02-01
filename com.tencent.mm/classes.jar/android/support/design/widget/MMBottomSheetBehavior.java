package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.d;
import androidx.core.b.a;
import androidx.core.g.z;
import androidx.customview.a.c;
import androidx.customview.a.c.a;
import androidx.customview.view.AbsSavedState;
import com.tencent.mm.plugin.transvoice.a.b;
import com.tencent.mm.plugin.transvoice.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public class MMBottomSheetBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private float bN;
  private int bO;
  private boolean bP;
  private int bQ;
  int bR;
  int bS;
  boolean bT;
  private boolean bU;
  c bV;
  private boolean bW;
  private int bX;
  private boolean bY;
  int bZ;
  WeakReference<View> ca;
  public MMBottomSheetBehavior.a cb;
  private boolean cc;
  private boolean cd;
  private int ce;
  private int cf;
  boolean cg;
  private boolean ch = false;
  private final c.a ci = new c.a()
  {
    public final void F(int paramAnonymousInt)
    {
      if (paramAnonymousInt == 1) {
        MMBottomSheetBehavior.this.D(1);
      }
    }
    
    public final void a(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      MMBottomSheetBehavior.this.E(paramAnonymousInt2);
    }
    
    public final int aM()
    {
      if (MMBottomSheetBehavior.this.bT) {
        return MMBottomSheetBehavior.this.bZ - MMBottomSheetBehavior.this.bR;
      }
      return MMBottomSheetBehavior.this.bS - MMBottomSheetBehavior.this.bR;
    }
    
    public final void b(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      int j = 3;
      int i;
      if (paramAnonymousFloat2 < 0.0F) {
        i = MMBottomSheetBehavior.this.bR;
      }
      while (MMBottomSheetBehavior.this.bV.aD(paramAnonymousView.getLeft(), i))
      {
        MMBottomSheetBehavior.this.D(2);
        z.b(paramAnonymousView, new MMBottomSheetBehavior.c(MMBottomSheetBehavior.this, paramAnonymousView, j));
        return;
        if ((MMBottomSheetBehavior.this.bT) && (MMBottomSheetBehavior.this.b(paramAnonymousView, paramAnonymousFloat2)))
        {
          i = MMBottomSheetBehavior.this.bZ;
          j = 5;
        }
        else if (paramAnonymousFloat2 == 0.0F)
        {
          i = paramAnonymousView.getTop();
          if (Math.abs(i - MMBottomSheetBehavior.this.bR) < Math.abs(i - MMBottomSheetBehavior.this.bS))
          {
            i = MMBottomSheetBehavior.this.bR;
          }
          else
          {
            i = MMBottomSheetBehavior.this.bS;
            j = 4;
          }
        }
        else
        {
          i = MMBottomSheetBehavior.this.bS;
          j = 4;
        }
      }
      MMBottomSheetBehavior.this.D(j);
    }
    
    public final boolean b(View paramAnonymousView, int paramAnonymousInt)
    {
      if (MMBottomSheetBehavior.this.mState == 1) {
        return false;
      }
      if (MMBottomSheetBehavior.this.cg) {
        return false;
      }
      if ((MMBottomSheetBehavior.this.mState == 3) && (MMBottomSheetBehavior.this.mActivePointerId == paramAnonymousInt))
      {
        View localView = (View)MMBottomSheetBehavior.this.ca.get();
        if ((localView != null) && (localView.canScrollVertically(-1))) {
          return false;
        }
      }
      return (MMBottomSheetBehavior.this.mViewRef != null) && (MMBottomSheetBehavior.this.mViewRef.get() == paramAnonymousView);
    }
    
    public final int c(View paramAnonymousView, int paramAnonymousInt)
    {
      int j = MMBottomSheetBehavior.this.bR;
      if (MMBottomSheetBehavior.this.bT) {}
      for (int i = MMBottomSheetBehavior.this.bZ;; i = MMBottomSheetBehavior.this.bS) {
        return a.clamp(paramAnonymousInt, j, i);
      }
    }
    
    public final int d(View paramAnonymousView, int paramAnonymousInt)
    {
      return paramAnonymousView.getLeft();
    }
  };
  public MMBottomSheetBehavior.b cj;
  int mActivePointerId;
  public int mState = 4;
  private VelocityTracker mVelocityTracker;
  WeakReference<V> mViewRef;
  
  public MMBottomSheetBehavior() {}
  
  public MMBottomSheetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.h.BottomSheetBehavior_Layout);
    TypedValue localTypedValue = paramAttributeSet.peekValue(a.h.BottomSheetBehavior_Layout_behavior_peekHeight);
    if ((localTypedValue != null) && (localTypedValue.data == -1)) {
      setPeekHeight(localTypedValue.data);
    }
    for (;;)
    {
      this.bT = paramAttributeSet.getBoolean(a.h.BottomSheetBehavior_Layout_behavior_hideable, false);
      this.bU = paramAttributeSet.getBoolean(a.h.BottomSheetBehavior_Layout_behavior_skipCollapsed, false);
      paramAttributeSet.recycle();
      this.bN = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
      return;
      setPeekHeight(paramAttributeSet.getDimensionPixelSize(a.h.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
    }
  }
  
  private View b(View paramView)
  {
    if (z.ar(paramView)) {
      return paramView;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = b(paramView.getChildAt(i));
        if (localView != null) {
          return localView;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public static <V extends View> MMBottomSheetBehavior<V> c(V paramV)
  {
    paramV = paramV.getLayoutParams();
    if (!(paramV instanceof CoordinatorLayout.d)) {
      throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }
    paramV = ((CoordinatorLayout.d)paramV).bnr;
    if (!(paramV instanceof MMBottomSheetBehavior)) {
      throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }
    return (MMBottomSheetBehavior)paramV;
  }
  
  private void reset()
  {
    this.mActivePointerId = -1;
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  private void setPeekHeight(int paramInt)
  {
    int i = 1;
    if (paramInt == -1)
    {
      if (this.bP) {
        break label104;
      }
      this.bP = true;
      paramInt = i;
    }
    for (;;)
    {
      if ((paramInt != 0) && (this.mState == 4) && (this.mViewRef != null))
      {
        View localView = (View)this.mViewRef.get();
        if (localView != null) {
          localView.requestLayout();
        }
      }
      return;
      if ((this.bP) || (this.bO != paramInt))
      {
        this.bP = false;
        this.bO = Math.max(0, paramInt);
        this.bS = (this.bZ - paramInt);
        paramInt = i;
      }
      else
      {
        label104:
        paramInt = 0;
      }
    }
  }
  
  public final boolean C(int paramInt)
  {
    boolean bool = false;
    this.bX = 0;
    this.bY = false;
    if ((paramInt & 0x2) != 0) {
      bool = true;
    }
    return bool;
  }
  
  final void D(int paramInt)
  {
    if (this.mState == paramInt) {}
    View localView;
    do
    {
      return;
      this.mState = paramInt;
      localView = (View)this.mViewRef.get();
    } while ((localView == null) || (this.cb == null));
    this.cb.e(localView, paramInt);
  }
  
  final void E(int paramInt)
  {
    View localView = (View)this.mViewRef.get();
    if ((localView != null) && (this.cb != null))
    {
      if (paramInt > this.bS) {
        this.cb.c(localView, (this.bS - paramInt) / (this.bZ - this.bS));
      }
    }
    else {
      return;
    }
    this.cb.c(localView, (this.bS - paramInt) / (this.bS - this.bR));
  }
  
  public final Parcelable a(CoordinatorLayout paramCoordinatorLayout, V paramV)
  {
    return new SavedState(super.a(paramCoordinatorLayout, paramV), this.mState);
  }
  
  final void a(View paramView, int paramInt)
  {
    int i;
    if (paramInt == 4) {
      i = this.bS;
    }
    while (this.bV.f(paramView, paramView.getLeft(), i))
    {
      D(2);
      z.b(paramView, new c(paramView, paramInt));
      return;
      if (paramInt == 3) {
        i = this.bR;
      } else if ((this.bT) && (paramInt == 5)) {
        i = this.bZ;
      } else {
        throw new IllegalArgumentException("Illegal state argument: ".concat(String.valueOf(paramInt)));
      }
    }
    D(paramInt);
  }
  
  public final void a(V paramV, View paramView)
  {
    int j = 3;
    if (paramV.getTop() == this.bR) {
      D(3);
    }
    while ((this.ca == null) || (paramView != this.ca.get()) || (!this.bY)) {
      return;
    }
    int i;
    if (this.bX > 0)
    {
      i = this.bR;
      if (!this.bV.f(paramV, paramV.getLeft(), i)) {
        break label213;
      }
      D(2);
      z.b(paramV, new c(paramV, j));
    }
    for (;;)
    {
      this.bY = false;
      return;
      if (this.bT)
      {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.bN);
        if (b(paramV, this.mVelocityTracker.getYVelocity(this.mActivePointerId)))
        {
          i = this.bZ;
          j = 5;
          break;
        }
      }
      if (this.bX == 0)
      {
        i = paramV.getTop();
        if (Math.abs(i - this.bR) < Math.abs(i - this.bS))
        {
          i = this.bR;
          break;
        }
        i = this.bS;
        j = 4;
        break;
      }
      i = this.bS;
      j = 4;
      break;
      label213:
      D(j);
    }
  }
  
  public final void a(V paramV, View paramView, int paramInt, int[] paramArrayOfInt)
  {
    if (paramView != (View)this.ca.get()) {
      return;
    }
    int i = paramV.getTop();
    int j = i - paramInt;
    if (paramInt > 0) {
      if (j < this.bR)
      {
        paramArrayOfInt[1] = (i - this.bR);
        z.s(paramV, -paramArrayOfInt[1]);
        D(3);
      }
    }
    for (;;)
    {
      E(paramV.getTop());
      this.bX = paramInt;
      this.bY = true;
      return;
      paramArrayOfInt[1] = paramInt;
      z.s(paramV, -paramInt);
      D(1);
      continue;
      if ((paramInt < 0) && (!paramView.canScrollVertically(-1))) {
        if ((j <= this.bS) || (this.bT))
        {
          paramArrayOfInt[1] = paramInt;
          z.s(paramV, -paramInt);
          D(1);
        }
        else
        {
          paramArrayOfInt[1] = (i - this.bS);
          z.s(paramV, -paramArrayOfInt[1]);
          D(4);
        }
      }
    }
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, V paramV, Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.a(paramCoordinatorLayout, paramV, paramParcelable.bxs);
    if ((paramParcelable.state == 1) || (paramParcelable.state == 2))
    {
      this.mState = 4;
      return;
    }
    this.mState = paramParcelable.state;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    if ((z.al(paramCoordinatorLayout)) && (!z.al(paramV))) {
      z.c(paramV, true);
    }
    int i = paramV.getTop();
    paramCoordinatorLayout.h(paramV, paramInt);
    this.bZ = paramCoordinatorLayout.getHeight();
    if (this.bP)
    {
      if (this.bQ == 0) {
        this.bQ = paramCoordinatorLayout.getResources().getDimensionPixelSize(a.b.design_bottom_sheet_peek_height_min);
      }
      paramInt = Math.max(this.bQ, this.bZ - paramCoordinatorLayout.getWidth() * 9 / 16);
      this.bR = Math.max(0, this.bZ - paramV.getHeight());
      this.bS = Math.max(this.bZ - paramInt, this.bR);
      if (this.mState != 3) {
        break label197;
      }
      z.s(paramV, this.bR);
    }
    for (;;)
    {
      if (this.bV == null) {
        this.bV = c.a(paramCoordinatorLayout, this.ci);
      }
      this.mViewRef = new WeakReference(paramV);
      this.ca = new WeakReference(b(paramV));
      return true;
      paramInt = this.bO;
      break;
      label197:
      if ((this.bT) && (this.mState == 5)) {
        z.s(paramV, this.bZ);
      } else if (this.mState == 4) {
        z.s(paramV, this.bS);
      } else if ((this.mState == 1) || (this.mState == 2)) {
        z.s(paramV, i - paramV.getTop());
      }
    }
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    Log.d("microMsg.MMBottomSheetBehavior", "onInterceptTouchEvent action: %d, x: %f, y: %f, rawX: %f, rawY: %f.", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()) });
    if (paramMotionEvent.getAction() == 0) {
      this.ch = false;
    }
    if (this.ch) {
      Log.d("microMsg.MMBottomSheetBehavior", "external deal with, continue.");
    }
    int i;
    label310:
    label469:
    do
    {
      return false;
      if ((this.cj != null) && (this.cj.onInterceptTouchEvent(paramMotionEvent)))
      {
        Log.d("microMsg.MMBottomSheetBehavior", "external deal with.");
        this.ch = true;
        return false;
      }
      if (!paramV.isShown())
      {
        this.bW = true;
        return false;
      }
      i = paramMotionEvent.getActionMasked();
      if (i == 0) {
        reset();
      }
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      this.mVelocityTracker.addMovement(paramMotionEvent);
      switch (i)
      {
      }
      while ((!this.bW) && (this.bV.i(paramMotionEvent)) && (this.cd))
      {
        return true;
        this.cg = false;
        this.mActivePointerId = -1;
        if (this.bW)
        {
          this.bW = false;
          return false;
          this.cc = false;
          this.cd = false;
          this.ce = ((int)paramMotionEvent.getX());
          this.cf = ((int)paramMotionEvent.getY());
          View localView;
          if (this.ca != null)
          {
            localView = (View)this.ca.get();
            if ((localView != null) && (paramCoordinatorLayout.d(localView, this.ce, this.cf)))
            {
              this.mActivePointerId = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
              this.cg = true;
            }
            if ((this.mActivePointerId != -1) || (paramCoordinatorLayout.d(paramV, this.ce, this.cf))) {
              break label391;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            this.bW = bool;
            break;
            localView = null;
            break label310;
          }
          int k = (int)paramMotionEvent.getX();
          int j = (int)paramMotionEvent.getY();
          k -= this.ce;
          j -= this.cf;
          if (!this.cc)
          {
            if ((Math.abs(k) > this.bV.mTouchSlop) || (Math.abs(j) > this.bV.mTouchSlop))
            {
              bool = true;
              this.cc = bool;
            }
          }
          else
          {
            if (!this.cc) {
              continue;
            }
            if (Math.abs(j) <= Math.abs(k)) {
              break label513;
            }
          }
          for (bool = true;; bool = false)
          {
            this.cd = bool;
            break;
            bool = false;
            break label469;
          }
        }
      }
      paramV = (View)this.ca.get();
    } while ((i != 2) || (paramV == null) || (this.bW) || (this.mState == 1) || (paramCoordinatorLayout.d(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) || (Math.abs(this.cf - paramMotionEvent.getY()) <= this.bV.mTouchSlop) || (!this.cd));
    label391:
    return true;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2)
  {
    return (paramView == this.ca.get()) && ((this.mState != 3) || (super.a(paramCoordinatorLayout, paramV, paramView, paramFloat1, paramFloat2)));
  }
  
  public final void aL()
  {
    if (3 == this.mState) {}
    View localView;
    do
    {
      return;
      if (this.mViewRef == null)
      {
        this.mState = 3;
        return;
      }
      localView = (View)this.mViewRef.get();
    } while (localView == null);
    ViewParent localViewParent = localView.getParent();
    if ((localViewParent != null) && (localViewParent.isLayoutRequested()) && (z.ay(localView)))
    {
      localView.post(new MMBottomSheetBehavior.1(this, localView));
      return;
    }
    a(localView, 3);
  }
  
  final boolean b(View paramView, float paramFloat)
  {
    if (this.bU) {}
    do
    {
      return true;
      if (paramView.getTop() < this.bS) {
        return false;
      }
    } while (Math.abs(paramView.getTop() + 0.1F * paramFloat - this.bS) / this.bO > 0.5F);
    return false;
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    Log.d("microMsg.MMBottomSheetBehavior", "onTouchEvent action: %d, x: %f, y: %f, rawX: %f, rawY: %f.", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()) });
    if (!paramV.isShown()) {}
    do
    {
      return false;
      int i = paramMotionEvent.getActionMasked();
      if ((this.mState == 1) && (i == 0)) {
        return true;
      }
      if (this.bV != null) {
        this.bV.j(paramMotionEvent);
      }
      if (i == 0) {
        reset();
      }
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      this.mVelocityTracker.addMovement(paramMotionEvent);
      if ((i == 2) && (!this.bW) && (Math.abs(this.cf - paramMotionEvent.getY()) > this.bV.mTouchSlop)) {
        this.bV.B(paramV, paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
      }
    } while (this.bW);
    return true;
  }
  
  protected static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    final int state;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.state = paramParcel.readInt();
    }
    
    public SavedState(Parcelable paramParcelable, int paramInt)
    {
      super();
      this.state = paramInt;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.state);
    }
  }
  
  final class c
    implements Runnable
  {
    private final int cn;
    private final View mView;
    
    c(View paramView, int paramInt)
    {
      this.mView = paramView;
      this.cn = paramInt;
    }
    
    public final void run()
    {
      if ((MMBottomSheetBehavior.this.bV != null) && (MMBottomSheetBehavior.this.bV.Fx()))
      {
        z.b(this.mView, this);
        return;
      }
      MMBottomSheetBehavior.this.D(this.cn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     android.support.design.widget.MMBottomSheetBehavior
 * JD-Core Version:    0.7.0.1
 */