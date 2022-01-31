package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.support.design.a.a;
import android.support.v4.view.AbsSavedState;
import android.support.v4.widget.t.a;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

public class MMBottomSheetBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private float gi;
  private int gj;
  private boolean gk;
  private int gl;
  int gm;
  int gn;
  boolean go;
  private boolean gp;
  android.support.v4.widget.t gq;
  private boolean gr;
  private int gs;
  private boolean gt;
  int gu;
  WeakReference<View> gv;
  private int gx;
  boolean gy;
  private final t.a gz = new MMBottomSheetBehavior.2(this);
  private a ka;
  private boolean kb;
  private boolean kc;
  private int kd;
  private boolean ke = false;
  private b kf;
  int mActivePointerId;
  int mState = 4;
  private VelocityTracker mVelocityTracker;
  WeakReference<V> mViewRef;
  
  public MMBottomSheetBehavior() {}
  
  public MMBottomSheetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.BottomSheetBehavior_Layout);
    TypedValue localTypedValue = paramAttributeSet.peekValue(0);
    if ((localTypedValue != null) && (localTypedValue.data == -1)) {
      t(localTypedValue.data);
    }
    for (;;)
    {
      this.go = paramAttributeSet.getBoolean(1, false);
      this.gp = paramAttributeSet.getBoolean(2, false);
      paramAttributeSet.recycle();
      this.gi = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
      return;
      t(paramAttributeSet.getDimensionPixelSize(0, -1));
    }
  }
  
  private View h(View paramView)
  {
    if (android.support.v4.view.t.aq(paramView)) {
      return paramView;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = h(paramView.getChildAt(i));
        if (localView != null) {
          return localView;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public static <V extends View> MMBottomSheetBehavior<V> r(V paramV)
  {
    paramV = paramV.getLayoutParams();
    if (!(paramV instanceof CoordinatorLayout.d)) {
      throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }
    paramV = ((CoordinatorLayout.d)paramV).iM;
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
  
  private void t(int paramInt)
  {
    int i = 1;
    if (paramInt == -1)
    {
      if (this.gk) {
        break label104;
      }
      this.gk = true;
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
      if ((this.gk) || (this.gj != paramInt))
      {
        this.gk = false;
        this.gj = Math.max(0, paramInt);
        this.gn = (this.gu - paramInt);
        paramInt = i;
      }
      else
      {
        label104:
        paramInt = 0;
      }
    }
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, V paramV, Parcelable paramParcelable)
  {
    paramParcelable = (MMBottomSheetBehavior.SavedState)paramParcelable;
    super.a(paramCoordinatorLayout, paramV, paramParcelable.Fo);
    if ((paramParcelable.state == 1) || (paramParcelable.state == 2))
    {
      this.mState = 4;
      return;
    }
    this.mState = paramParcelable.state;
  }
  
  public final void a(a parama)
  {
    this.ka = parama;
  }
  
  public final void a(b paramb)
  {
    this.kf = paramb;
  }
  
  final void a(View paramView, int paramInt)
  {
    int i;
    if (paramInt == 4) {
      i = this.gn;
    }
    while (this.gq.i(paramView, paramView.getLeft(), i))
    {
      u(2);
      android.support.v4.view.t.b(paramView, new MMBottomSheetBehavior.c(this, paramView, paramInt));
      return;
      if (paramInt == 3) {
        i = this.gm;
      } else if ((this.go) && (paramInt == 5)) {
        i = this.gu;
      } else {
        throw new IllegalArgumentException("Illegal state argument: ".concat(String.valueOf(paramInt)));
      }
    }
    u(paramInt);
  }
  
  public final void a(V paramV, View paramView)
  {
    int j = 3;
    if (paramV.getTop() == this.gm) {
      u(3);
    }
    while ((this.gv == null) || (paramView != this.gv.get()) || (!this.gt)) {
      return;
    }
    int i;
    if (this.gs > 0)
    {
      i = this.gm;
      if (!this.gq.i(paramV, paramV.getLeft(), i)) {
        break label213;
      }
      u(2);
      android.support.v4.view.t.b(paramV, new MMBottomSheetBehavior.c(this, paramV, j));
    }
    for (;;)
    {
      this.gt = false;
      return;
      if (this.go)
      {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.gi);
        if (a(paramV, this.mVelocityTracker.getYVelocity(this.mActivePointerId)))
        {
          i = this.gu;
          j = 5;
          break;
        }
      }
      if (this.gs == 0)
      {
        i = paramV.getTop();
        if (Math.abs(i - this.gm) < Math.abs(i - this.gn))
        {
          i = this.gm;
          break;
        }
        i = this.gn;
        j = 4;
        break;
      }
      i = this.gn;
      j = 4;
      break;
      label213:
      u(j);
    }
  }
  
  public final void a(V paramV, View paramView, int paramInt, int[] paramArrayOfInt)
  {
    if (paramView != (View)this.gv.get()) {
      return;
    }
    int i = paramV.getTop();
    int j = i - paramInt;
    if (paramInt > 0) {
      if (j < this.gm)
      {
        paramArrayOfInt[1] = (i - this.gm);
        android.support.v4.view.t.q(paramV, -paramArrayOfInt[1]);
        u(3);
      }
    }
    for (;;)
    {
      v(paramV.getTop());
      this.gs = paramInt;
      this.gt = true;
      return;
      paramArrayOfInt[1] = paramInt;
      android.support.v4.view.t.q(paramV, -paramInt);
      u(1);
      continue;
      if ((paramInt < 0) && (!paramView.canScrollVertically(-1))) {
        if ((j <= this.gn) || (this.go))
        {
          paramArrayOfInt[1] = paramInt;
          android.support.v4.view.t.q(paramV, -paramInt);
          u(1);
        }
        else
        {
          paramArrayOfInt[1] = (i - this.gn);
          android.support.v4.view.t.q(paramV, -paramArrayOfInt[1]);
          u(4);
        }
      }
    }
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    if ((android.support.v4.view.t.al(paramCoordinatorLayout)) && (!android.support.v4.view.t.al(paramV))) {
      android.support.v4.view.t.e(paramV, true);
    }
    int i = paramV.getTop();
    paramCoordinatorLayout.e(paramV, paramInt);
    this.gu = paramCoordinatorLayout.getHeight();
    if (this.gk)
    {
      if (this.gl == 0) {
        this.gl = paramCoordinatorLayout.getResources().getDimensionPixelSize(2131428288);
      }
      paramInt = Math.max(this.gl, this.gu - paramCoordinatorLayout.getWidth() * 9 / 16);
      this.gm = Math.max(0, this.gu - paramV.getHeight());
      this.gn = Math.max(this.gu - paramInt, this.gm);
      if (this.mState != 3) {
        break label197;
      }
      android.support.v4.view.t.q(paramV, this.gm);
    }
    for (;;)
    {
      if (this.gq == null) {
        this.gq = android.support.v4.widget.t.a(paramCoordinatorLayout, this.gz);
      }
      this.mViewRef = new WeakReference(paramV);
      this.gv = new WeakReference(h(paramV));
      return true;
      paramInt = this.gj;
      break;
      label197:
      if ((this.go) && (this.mState == 5)) {
        android.support.v4.view.t.q(paramV, this.gu);
      } else if (this.mState == 4) {
        android.support.v4.view.t.q(paramV, this.gn);
      } else if ((this.mState == 1) || (this.mState == 2)) {
        android.support.v4.view.t.q(paramV, i - paramV.getTop());
      }
    }
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    ab.d("microMsg.MMBottomSheetBehavior", "onInterceptTouchEvent action: %d, x: %f, y: %f, rawX: %f, rawY: %f.", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()) });
    if (paramMotionEvent.getAction() == 0) {
      this.ke = false;
    }
    if (this.ke) {
      ab.d("microMsg.MMBottomSheetBehavior", "external deal with, continue.");
    }
    int i;
    label310:
    label469:
    do
    {
      return false;
      if ((this.kf != null) && (this.kf.onInterceptTouchEvent(paramMotionEvent)))
      {
        ab.d("microMsg.MMBottomSheetBehavior", "external deal with.");
        this.ke = true;
        return false;
      }
      if (!paramV.isShown())
      {
        this.gr = true;
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
      while ((!this.gr) && (this.gq.f(paramMotionEvent)) && (this.kc))
      {
        return true;
        this.gy = false;
        this.mActivePointerId = -1;
        if (this.gr)
        {
          this.gr = false;
          return false;
          this.kb = false;
          this.kc = false;
          this.kd = ((int)paramMotionEvent.getX());
          this.gx = ((int)paramMotionEvent.getY());
          View localView;
          if (this.gv != null)
          {
            localView = (View)this.gv.get();
            if ((localView != null) && (paramCoordinatorLayout.d(localView, this.kd, this.gx)))
            {
              this.mActivePointerId = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
              this.gy = true;
            }
            if ((this.mActivePointerId != -1) || (paramCoordinatorLayout.d(paramV, this.kd, this.gx))) {
              break label391;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            this.gr = bool;
            break;
            localView = null;
            break label310;
          }
          int k = (int)paramMotionEvent.getX();
          int j = (int)paramMotionEvent.getY();
          k -= this.kd;
          j -= this.gx;
          if (!this.kb)
          {
            if ((Math.abs(k) > this.gq.mTouchSlop) || (Math.abs(j) > this.gq.mTouchSlop))
            {
              bool = true;
              this.kb = bool;
            }
          }
          else
          {
            if (!this.kb) {
              continue;
            }
            if (Math.abs(j) <= Math.abs(k)) {
              break label513;
            }
          }
          for (bool = true;; bool = false)
          {
            this.kc = bool;
            break;
            bool = false;
            break label469;
          }
        }
      }
      paramV = (View)this.gv.get();
    } while ((i != 2) || (paramV == null) || (this.gr) || (this.mState == 1) || (paramCoordinatorLayout.d(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) || (Math.abs(this.gx - paramMotionEvent.getY()) <= this.gq.mTouchSlop) || (!this.kc));
    label391:
    return true;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2)
  {
    return (paramView == this.gv.get()) && ((this.mState != 3) || (super.a(paramCoordinatorLayout, paramV, paramView, paramFloat1, paramFloat2)));
  }
  
  final boolean a(View paramView, float paramFloat)
  {
    if (this.gp) {}
    do
    {
      return true;
      if (paramView.getTop() < this.gn) {
        return false;
      }
    } while (Math.abs(paramView.getTop() + 0.1F * paramFloat - this.gn) / this.gj > 0.5F);
    return false;
  }
  
  public final Parcelable b(CoordinatorLayout paramCoordinatorLayout, V paramV)
  {
    return new MMBottomSheetBehavior.SavedState(super.b(paramCoordinatorLayout, paramV), this.mState);
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    ab.d("microMsg.MMBottomSheetBehavior", "onTouchEvent action: %d, x: %f, y: %f, rawX: %f, rawY: %f.", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()) });
    if (!paramV.isShown()) {}
    do
    {
      return false;
      int i = paramMotionEvent.getActionMasked();
      if ((this.mState == 1) && (i == 0)) {
        return true;
      }
      if (this.gq != null) {
        this.gq.g(paramMotionEvent);
      }
      if (i == 0) {
        reset();
      }
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      this.mVelocityTracker.addMovement(paramMotionEvent);
      if ((i == 2) && (!this.gr) && (Math.abs(this.gx - paramMotionEvent.getY()) > this.gq.mTouchSlop)) {
        this.gq.w(paramV, paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
      }
    } while (this.gr);
    return true;
  }
  
  public final void bC()
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
    if ((localViewParent != null) && (localViewParent.isLayoutRequested()) && (android.support.v4.view.t.aw(localView)))
    {
      localView.post(new MMBottomSheetBehavior.1(this, localView));
      return;
    }
    a(localView, 3);
  }
  
  public final int getState()
  {
    return this.mState;
  }
  
  public final boolean s(int paramInt)
  {
    boolean bool = false;
    this.gs = 0;
    this.gt = false;
    if ((paramInt & 0x2) != 0) {
      bool = true;
    }
    return bool;
  }
  
  final void u(int paramInt)
  {
    if (this.mState == paramInt) {}
    View localView;
    do
    {
      return;
      this.mState = paramInt;
      localView = (View)this.mViewRef.get();
    } while ((localView == null) || (this.ka == null));
    this.ka.j(localView, paramInt);
  }
  
  final void v(int paramInt)
  {
    View localView = (View)this.mViewRef.get();
    if ((localView != null) && (this.ka != null))
    {
      if (paramInt > this.gn) {
        this.ka.b(localView, (this.gn - paramInt) / (this.gu - this.gn));
      }
    }
    else {
      return;
    }
    this.ka.b(localView, (this.gn - paramInt) / (this.gn - this.gm));
  }
  
  public static abstract class a
  {
    public abstract void b(View paramView, float paramFloat);
    
    public abstract void j(View paramView, int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract boolean onInterceptTouchEvent(MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.design.widget.MMBottomSheetBehavior
 * JD-Core Version:    0.7.0.1
 */