package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.support.design.a.d;
import android.support.design.a.k;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.q;
import android.support.v4.widget.r;
import android.support.v4.widget.r.a;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  public BottomSheetBehavior.a fA;
  private VelocityTracker fB;
  int fC;
  private int fD;
  boolean fE;
  private final r.a fF = new BottomSheetBehavior.2(this);
  private float fj;
  private int fk;
  private boolean fl;
  private int fn;
  int fo;
  int fp;
  public boolean fq;
  private boolean fs;
  r ft;
  private boolean fu;
  private int fv;
  private boolean fw;
  int fx;
  WeakReference<V> fy;
  WeakReference<View> fz;
  int mState = 4;
  
  public BottomSheetBehavior() {}
  
  public BottomSheetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.BottomSheetBehavior_Layout);
    TypedValue localTypedValue = paramAttributeSet.peekValue(a.k.BottomSheetBehavior_Layout_behavior_peekHeight);
    if ((localTypedValue != null) && (localTypedValue.data == -1)) {
      u(localTypedValue.data);
    }
    for (;;)
    {
      this.fq = paramAttributeSet.getBoolean(a.k.BottomSheetBehavior_Layout_behavior_hideable, false);
      this.fs = paramAttributeSet.getBoolean(a.k.BottomSheetBehavior_Layout_behavior_skipCollapsed, false);
      paramAttributeSet.recycle();
      this.fj = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
      return;
      u(paramAttributeSet.getDimensionPixelSize(a.k.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
    }
  }
  
  private View h(View paramView)
  {
    if (q.aj(paramView)) {
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
  
  public static <V extends View> BottomSheetBehavior<V> i(V paramV)
  {
    paramV = paramV.getLayoutParams();
    if (!(paramV instanceof CoordinatorLayout.d)) {
      throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }
    paramV = ((CoordinatorLayout.d)paramV).hP;
    if (!(paramV instanceof BottomSheetBehavior)) {
      throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }
    return (BottomSheetBehavior)paramV;
  }
  
  private void reset()
  {
    this.fC = -1;
    if (this.fB != null)
    {
      this.fB.recycle();
      this.fB = null;
    }
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, V paramV, Parcelable paramParcelable)
  {
    paramParcelable = (BottomSheetBehavior.SavedState)paramParcelable;
    super.a(paramCoordinatorLayout, paramV, paramParcelable.EA);
    if ((paramParcelable.state == 1) || (paramParcelable.state == 2))
    {
      this.mState = 4;
      return;
    }
    this.mState = paramParcelable.state;
  }
  
  final void a(View paramView, int paramInt)
  {
    int i;
    if (paramInt == 4) {
      i = this.fp;
    }
    while (this.ft.e(paramView, paramView.getLeft(), i))
    {
      v(2);
      q.b(paramView, new BottomSheetBehavior.b(this, paramView, paramInt));
      return;
      if (paramInt == 3) {
        i = this.fo;
      } else if ((this.fq) && (paramInt == 5)) {
        i = this.fx;
      } else {
        throw new IllegalArgumentException("Illegal state argument: " + paramInt);
      }
    }
    v(paramInt);
  }
  
  public final void a(V paramV, View paramView)
  {
    int j = 3;
    if (paramV.getTop() == this.fo) {
      v(3);
    }
    while ((this.fz == null) || (paramView != this.fz.get()) || (!this.fw)) {
      return;
    }
    int i;
    if (this.fv > 0)
    {
      i = this.fo;
      if (!this.ft.e(paramV, paramV.getLeft(), i)) {
        break label213;
      }
      v(2);
      q.b(paramV, new BottomSheetBehavior.b(this, paramV, j));
    }
    for (;;)
    {
      this.fw = false;
      return;
      if (this.fq)
      {
        this.fB.computeCurrentVelocity(1000, this.fj);
        if (a(paramV, this.fB.getYVelocity(this.fC)))
        {
          i = this.fx;
          j = 5;
          break;
        }
      }
      if (this.fv == 0)
      {
        i = paramV.getTop();
        if (Math.abs(i - this.fo) < Math.abs(i - this.fp))
        {
          i = this.fo;
          break;
        }
        i = this.fp;
        j = 4;
        break;
      }
      i = this.fp;
      j = 4;
      break;
      label213:
      v(j);
    }
  }
  
  public final void a(V paramV, View paramView, int paramInt, int[] paramArrayOfInt)
  {
    if (paramView != (View)this.fz.get()) {
      return;
    }
    int i = paramV.getTop();
    int j = i - paramInt;
    if (paramInt > 0) {
      if (j < this.fo)
      {
        paramArrayOfInt[1] = (i - this.fo);
        q.p(paramV, -paramArrayOfInt[1]);
        v(3);
      }
    }
    for (;;)
    {
      w(paramV.getTop());
      this.fv = paramInt;
      this.fw = true;
      return;
      paramArrayOfInt[1] = paramInt;
      q.p(paramV, -paramInt);
      v(1);
      continue;
      if ((paramInt < 0) && (!paramView.canScrollVertically(-1))) {
        if ((j <= this.fp) || (this.fq))
        {
          paramArrayOfInt[1] = paramInt;
          q.p(paramV, -paramInt);
          v(1);
        }
        else
        {
          paramArrayOfInt[1] = (i - this.fp);
          q.p(paramV, -paramArrayOfInt[1]);
          v(4);
        }
      }
    }
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    if ((q.ae(paramCoordinatorLayout)) && (!q.ae(paramV))) {
      q.e(paramV, true);
    }
    int i = paramV.getTop();
    paramCoordinatorLayout.e(paramV, paramInt);
    this.fx = paramCoordinatorLayout.getHeight();
    if (this.fl)
    {
      if (this.fn == 0) {
        this.fn = paramCoordinatorLayout.getResources().getDimensionPixelSize(a.d.design_bottom_sheet_peek_height_min);
      }
      paramInt = Math.max(this.fn, this.fx - paramCoordinatorLayout.getWidth() * 9 / 16);
      this.fo = Math.max(0, this.fx - paramV.getHeight());
      this.fp = Math.max(this.fx - paramInt, this.fo);
      if (this.mState != 3) {
        break label197;
      }
      q.p(paramV, this.fo);
    }
    for (;;)
    {
      if (this.ft == null) {
        this.ft = r.a(paramCoordinatorLayout, this.fF);
      }
      this.fy = new WeakReference(paramV);
      this.fz = new WeakReference(h(paramV));
      return true;
      paramInt = this.fk;
      break;
      label197:
      if ((this.fq) && (this.mState == 5)) {
        q.p(paramV, this.fx);
      } else if (this.mState == 4) {
        q.p(paramV, this.fp);
      } else if ((this.mState == 1) || (this.mState == 2)) {
        q.p(paramV, i - paramV.getTop());
      }
    }
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (!paramV.isShown()) {
      this.fu = true;
    }
    int i;
    label163:
    label240:
    do
    {
      return false;
      i = paramMotionEvent.getActionMasked();
      if (i == 0) {
        reset();
      }
      if (this.fB == null) {
        this.fB = VelocityTracker.obtain();
      }
      this.fB.addMovement(paramMotionEvent);
      switch (i)
      {
      }
      while ((!this.fu) && (this.ft.f(paramMotionEvent)))
      {
        return true;
        this.fE = false;
        this.fC = -1;
        if (this.fu)
        {
          this.fu = false;
          return false;
          int j = (int)paramMotionEvent.getX();
          this.fD = ((int)paramMotionEvent.getY());
          View localView;
          if (this.fz != null)
          {
            localView = (View)this.fz.get();
            if ((localView != null) && (paramCoordinatorLayout.b(localView, j, this.fD)))
            {
              this.fC = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
              this.fE = true;
            }
            if ((this.fC != -1) || (paramCoordinatorLayout.b(paramV, j, this.fD))) {
              break label240;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            this.fu = bool;
            break;
            localView = null;
            break label163;
          }
        }
      }
      paramV = (View)this.fz.get();
    } while ((i != 2) || (paramV == null) || (this.fu) || (this.mState == 1) || (paramCoordinatorLayout.b(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) || (Math.abs(this.fD - paramMotionEvent.getY()) <= this.ft.jb));
    return true;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2)
  {
    return (paramView == this.fz.get()) && ((this.mState != 3) || (super.a(paramCoordinatorLayout, paramV, paramView, paramFloat1, paramFloat2)));
  }
  
  final boolean a(View paramView, float paramFloat)
  {
    if (this.fs) {}
    do
    {
      return true;
      if (paramView.getTop() < this.fp) {
        return false;
      }
    } while (Math.abs(paramView.getTop() + 0.1F * paramFloat - this.fp) / this.fk > 0.5F);
    return false;
  }
  
  public final Parcelable b(CoordinatorLayout paramCoordinatorLayout, V paramV)
  {
    return new BottomSheetBehavior.SavedState(super.b(paramCoordinatorLayout, paramV), this.mState);
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (!paramV.isShown()) {}
    do
    {
      return false;
      int i = paramMotionEvent.getActionMasked();
      if ((this.mState == 1) && (i == 0)) {
        return true;
      }
      if (this.ft != null) {
        this.ft.g(paramMotionEvent);
      }
      if (i == 0) {
        reset();
      }
      if (this.fB == null) {
        this.fB = VelocityTracker.obtain();
      }
      this.fB.addMovement(paramMotionEvent);
      if ((i == 2) && (!this.fu) && (Math.abs(this.fD - paramMotionEvent.getY()) > this.ft.jb)) {
        this.ft.t(paramV, paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
      }
    } while (this.fu);
    return true;
  }
  
  public final void setState(int paramInt)
  {
    if (paramInt == this.mState) {}
    View localView;
    do
    {
      do
      {
        return;
        if (this.fy != null) {
          break;
        }
      } while ((paramInt != 4) && (paramInt != 3) && ((!this.fq) || (paramInt != 5)));
      this.mState = paramInt;
      return;
      localView = (View)this.fy.get();
    } while (localView == null);
    ViewParent localViewParent = localView.getParent();
    if ((localViewParent != null) && (localViewParent.isLayoutRequested()) && (q.ao(localView)))
    {
      localView.post(new BottomSheetBehavior.1(this, localView, paramInt));
      return;
    }
    a(localView, paramInt);
  }
  
  public final boolean t(int paramInt)
  {
    boolean bool = false;
    this.fv = 0;
    this.fw = false;
    if ((paramInt & 0x2) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public final void u(int paramInt)
  {
    int i = 1;
    if (paramInt == -1)
    {
      if (this.fl) {
        break label104;
      }
      this.fl = true;
      paramInt = i;
    }
    for (;;)
    {
      if ((paramInt != 0) && (this.mState == 4) && (this.fy != null))
      {
        View localView = (View)this.fy.get();
        if (localView != null) {
          localView.requestLayout();
        }
      }
      return;
      if ((this.fl) || (this.fk != paramInt))
      {
        this.fl = false;
        this.fk = Math.max(0, paramInt);
        this.fp = (this.fx - paramInt);
        paramInt = i;
      }
      else
      {
        label104:
        paramInt = 0;
      }
    }
  }
  
  final void v(int paramInt)
  {
    if (this.mState == paramInt) {}
    do
    {
      return;
      this.mState = paramInt;
    } while (((View)this.fy.get() == null) || (this.fA == null));
    this.fA.y(paramInt);
  }
  
  final void w(int paramInt)
  {
    if (((View)this.fy.get() != null) && (this.fA != null))
    {
      if (paramInt > this.fp) {
        this.fA.g((this.fp - paramInt) / (this.fx - this.fp));
      }
    }
    else {
      return;
    }
    this.fA.g((this.fp - paramInt) / (this.fp - this.fo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.design.widget.BottomSheetBehavior
 * JD-Core Version:    0.7.0.1
 */