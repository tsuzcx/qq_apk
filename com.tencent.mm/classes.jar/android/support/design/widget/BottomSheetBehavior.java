package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.a.a;
import android.support.v4.b.a;
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
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class BottomSheetBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private Map<View, Integer> jZ;
  private boolean kY = true;
  private float kZ;
  private int la;
  private boolean lb;
  private int lc;
  private int ld;
  int le;
  int lf;
  int lg;
  public boolean lh;
  private boolean li;
  android.support.v4.widget.t lj;
  private boolean lk;
  private int ll;
  private boolean lm;
  int ln;
  WeakReference<V> lo;
  WeakReference<View> lp;
  public a lq;
  private VelocityTracker lr;
  int ls;
  private int lt;
  boolean lu;
  private final t.a lv = new t.a()
  {
    public final void M(int paramAnonymousInt)
    {
      if (paramAnonymousInt == 1) {
        BottomSheetBehavior.this.K(1);
      }
    }
    
    public final void a(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      int i = 0;
      int j = 3;
      if (paramAnonymousFloat2 < 0.0F) {
        if (BottomSheetBehavior.a(BottomSheetBehavior.this)) {
          i = BottomSheetBehavior.this.le;
        }
      }
      while (BottomSheetBehavior.this.lj.A(paramAnonymousView.getLeft(), i))
      {
        BottomSheetBehavior.this.K(2);
        android.support.v4.view.t.b(paramAnonymousView, new BottomSheetBehavior.b(BottomSheetBehavior.this, paramAnonymousView, j));
        return;
        if (paramAnonymousView.getTop() > BottomSheetBehavior.this.lf)
        {
          i = BottomSheetBehavior.this.lf;
          j = 6;
          continue;
          if ((BottomSheetBehavior.this.lh) && (BottomSheetBehavior.this.a(paramAnonymousView, paramAnonymousFloat2)) && ((paramAnonymousView.getTop() > BottomSheetBehavior.this.lg) || (Math.abs(paramAnonymousFloat1) < Math.abs(paramAnonymousFloat2))))
          {
            i = BottomSheetBehavior.this.ln;
            j = 5;
          }
          else if ((paramAnonymousFloat2 == 0.0F) || (Math.abs(paramAnonymousFloat1) > Math.abs(paramAnonymousFloat2)))
          {
            int k = paramAnonymousView.getTop();
            if (BottomSheetBehavior.a(BottomSheetBehavior.this))
            {
              if (Math.abs(k - BottomSheetBehavior.this.le) < Math.abs(k - BottomSheetBehavior.this.lg))
              {
                i = BottomSheetBehavior.this.le;
              }
              else
              {
                i = BottomSheetBehavior.this.lg;
                j = 4;
              }
            }
            else if (k < BottomSheetBehavior.this.lf)
            {
              if (k >= Math.abs(k - BottomSheetBehavior.this.lg))
              {
                i = BottomSheetBehavior.this.lf;
                j = 6;
              }
            }
            else if (Math.abs(k - BottomSheetBehavior.this.lf) < Math.abs(k - BottomSheetBehavior.this.lg))
            {
              i = BottomSheetBehavior.this.lf;
              j = 6;
            }
            else
            {
              i = BottomSheetBehavior.this.lg;
              j = 4;
            }
          }
          else
          {
            i = BottomSheetBehavior.this.lg;
            j = 4;
          }
        }
      }
      BottomSheetBehavior.this.K(j);
    }
    
    public final void b(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      BottomSheetBehavior.this.L(paramAnonymousInt2);
    }
    
    public final int bH()
    {
      if (BottomSheetBehavior.this.lh) {
        return BottomSheetBehavior.this.ln;
      }
      return BottomSheetBehavior.this.lg;
    }
    
    public final boolean c(View paramAnonymousView, int paramAnonymousInt)
    {
      if (BottomSheetBehavior.this.state == 1) {
        return false;
      }
      if (BottomSheetBehavior.this.lu) {
        return false;
      }
      if ((BottomSheetBehavior.this.state == 3) && (BottomSheetBehavior.this.ls == paramAnonymousInt))
      {
        View localView = (View)BottomSheetBehavior.this.lp.get();
        if ((localView != null) && (localView.canScrollVertically(-1))) {
          return false;
        }
      }
      return (BottomSheetBehavior.this.lo != null) && (BottomSheetBehavior.this.lo.get() == paramAnonymousView);
    }
    
    public final int d(View paramAnonymousView, int paramAnonymousInt)
    {
      int j = BottomSheetBehavior.b(BottomSheetBehavior.this);
      if (BottomSheetBehavior.this.lh) {}
      for (int i = BottomSheetBehavior.this.ln;; i = BottomSheetBehavior.this.lg) {
        return a.clamp(paramAnonymousInt, j, i);
      }
    }
    
    public final int e(View paramAnonymousView, int paramAnonymousInt)
    {
      return paramAnonymousView.getLeft();
    }
  };
  int state = 4;
  
  public BottomSheetBehavior() {}
  
  public BottomSheetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.BottomSheetBehavior_Layout);
    TypedValue localTypedValue = paramAttributeSet.peekValue(2);
    if ((localTypedValue != null) && (localTypedValue.data == -1))
    {
      J(localTypedValue.data);
      this.lh = paramAttributeSet.getBoolean(1, false);
      boolean bool = paramAttributeSet.getBoolean(0, true);
      if (this.kY != bool)
      {
        this.kY = bool;
        if (this.lo != null) {
          bF();
        }
        if ((!this.kY) || (this.state != 6)) {
          break label174;
        }
      }
    }
    label174:
    for (int i = 3;; i = this.state)
    {
      K(i);
      this.li = paramAttributeSet.getBoolean(3, false);
      paramAttributeSet.recycle();
      this.kZ = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
      return;
      J(paramAttributeSet.getDimensionPixelSize(2, -1));
      break;
    }
  }
  
  private void bF()
  {
    if (this.kY)
    {
      this.lg = Math.max(this.ln - this.ld, this.le);
      return;
    }
    this.lg = (this.ln - this.ld);
  }
  
  private int bG()
  {
    if (this.kY) {
      return this.le;
    }
    return 0;
  }
  
  private View k(View paramView)
  {
    if (android.support.v4.view.t.av(paramView)) {
      return paramView;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = k(paramView.getChildAt(i));
        if (localView != null) {
          return localView;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public static <V extends View> BottomSheetBehavior<V> l(V paramV)
  {
    paramV = paramV.getLayoutParams();
    if (!(paramV instanceof CoordinatorLayout.d)) {
      throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }
    paramV = ((CoordinatorLayout.d)paramV).nG;
    if (!(paramV instanceof BottomSheetBehavior)) {
      throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }
    return (BottomSheetBehavior)paramV;
  }
  
  private void reset()
  {
    this.ls = -1;
    if (this.lr != null)
    {
      this.lr.recycle();
      this.lr = null;
    }
  }
  
  private void v(boolean paramBoolean)
  {
    if (this.lo == null) {}
    label156:
    do
    {
      Object localObject;
      int j;
      do
      {
        do
        {
          return;
          localObject = ((View)this.lo.get()).getParent();
        } while (!(localObject instanceof CoordinatorLayout));
        localObject = (CoordinatorLayout)localObject;
        j = ((CoordinatorLayout)localObject).getChildCount();
        if ((Build.VERSION.SDK_INT < 16) || (!paramBoolean)) {
          break;
        }
      } while (this.jZ != null);
      this.jZ = new HashMap(j);
      int i = 0;
      if (i < j)
      {
        View localView = ((CoordinatorLayout)localObject).getChildAt(i);
        if (localView != this.lo.get())
        {
          if (paramBoolean) {
            break label156;
          }
          if ((this.jZ != null) && (this.jZ.containsKey(localView))) {
            android.support.v4.view.t.p(localView, ((Integer)this.jZ.get(localView)).intValue());
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (Build.VERSION.SDK_INT >= 16) {
            this.jZ.put(localView, Integer.valueOf(localView.getImportantForAccessibility()));
          }
          android.support.v4.view.t.p(localView, 4);
        }
      }
    } while (paramBoolean);
    this.jZ = null;
  }
  
  public final void J(int paramInt)
  {
    int i = 1;
    if (paramInt == -1)
    {
      if (this.lb) {
        break label104;
      }
      this.lb = true;
      paramInt = i;
    }
    for (;;)
    {
      if ((paramInt != 0) && (this.state == 4) && (this.lo != null))
      {
        View localView = (View)this.lo.get();
        if (localView != null) {
          localView.requestLayout();
        }
      }
      return;
      if ((this.lb) || (this.la != paramInt))
      {
        this.lb = false;
        this.la = Math.max(0, paramInt);
        this.lg = (this.ln - paramInt);
        paramInt = i;
      }
      else
      {
        label104:
        paramInt = 0;
      }
    }
  }
  
  final void K(int paramInt)
  {
    if (this.state == paramInt) {}
    for (;;)
    {
      return;
      this.state = paramInt;
      if ((paramInt == 6) || (paramInt == 3)) {
        v(true);
      }
      while (((View)this.lo.get() != null) && (this.lq != null))
      {
        this.lq.N(paramInt);
        return;
        if ((paramInt == 5) || (paramInt == 4)) {
          v(false);
        }
      }
    }
  }
  
  final void L(int paramInt)
  {
    if (((View)this.lo.get() != null) && (this.lq != null))
    {
      if (paramInt > this.lg) {
        this.lq.h((this.lg - paramInt) / (this.ln - this.lg));
      }
    }
    else {
      return;
    }
    this.lq.h((this.lg - paramInt) / (this.lg - bG()));
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, V paramV, Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.a(paramCoordinatorLayout, paramV, paramParcelable.Mm);
    if ((paramParcelable.state == 1) || (paramParcelable.state == 2))
    {
      this.state = 4;
      return;
    }
    this.state = paramParcelable.state;
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt)
  {
    if (paramV.getTop() == bG()) {
      K(3);
    }
    while ((paramView != this.lp.get()) || (!this.lm)) {
      return;
    }
    int i;
    if (this.ll > 0)
    {
      i = bG();
      paramInt = 3;
      if (!this.lj.h(paramV, paramV.getLeft(), i)) {
        break label336;
      }
      K(2);
      android.support.v4.view.t.b(paramV, new b(paramV, paramInt));
    }
    for (;;)
    {
      this.lm = false;
      return;
      if (this.lh)
      {
        if (this.lr == null) {}
        for (float f = 0.0F;; f = this.lr.getYVelocity(this.ls))
        {
          if (!a(paramV, f)) {
            break label163;
          }
          i = this.ln;
          paramInt = 5;
          break;
          this.lr.computeCurrentVelocity(1000, this.kZ);
        }
      }
      label163:
      if (this.ll == 0)
      {
        paramInt = paramV.getTop();
        if (this.kY)
        {
          if (Math.abs(paramInt - this.le) < Math.abs(paramInt - this.lg))
          {
            i = this.le;
            paramInt = 3;
            break;
          }
          i = this.lg;
          paramInt = 4;
          break;
        }
        if (paramInt < this.lf)
        {
          if (paramInt < Math.abs(paramInt - this.lg))
          {
            paramInt = 3;
            i = 0;
            break;
          }
          i = this.lf;
          paramInt = 6;
          break;
        }
        if (Math.abs(paramInt - this.lf) < Math.abs(paramInt - this.lg))
        {
          i = this.lf;
          paramInt = 6;
          break;
        }
        i = this.lg;
        paramInt = 4;
        break;
      }
      i = this.lg;
      paramInt = 4;
      break;
      label336:
      K(paramInt);
    }
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    if (paramInt3 == 1) {}
    while (paramView != (View)this.lp.get()) {
      return;
    }
    paramInt1 = paramV.getTop();
    paramInt3 = paramInt1 - paramInt2;
    if (paramInt2 > 0) {
      if (paramInt3 < bG())
      {
        paramArrayOfInt[1] = (paramInt1 - bG());
        android.support.v4.view.t.s(paramV, -paramArrayOfInt[1]);
        K(3);
      }
    }
    for (;;)
    {
      L(paramV.getTop());
      this.ll = paramInt2;
      this.lm = true;
      return;
      paramArrayOfInt[1] = paramInt2;
      android.support.v4.view.t.s(paramV, -paramInt2);
      K(1);
      continue;
      if ((paramInt2 < 0) && (!paramView.canScrollVertically(-1))) {
        if ((paramInt3 <= this.lg) || (this.lh))
        {
          paramArrayOfInt[1] = paramInt2;
          android.support.v4.view.t.s(paramV, -paramInt2);
          K(1);
        }
        else
        {
          paramArrayOfInt[1] = (paramInt1 - this.lg);
          android.support.v4.view.t.s(paramV, -paramArrayOfInt[1]);
          K(4);
        }
      }
    }
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    if ((android.support.v4.view.t.aq(paramCoordinatorLayout)) && (!android.support.v4.view.t.aq(paramV))) {
      paramV.setFitsSystemWindows(true);
    }
    int i = paramV.getTop();
    paramCoordinatorLayout.f(paramV, paramInt);
    this.ln = paramCoordinatorLayout.getHeight();
    if (this.lb)
    {
      if (this.lc == 0) {
        this.lc = paramCoordinatorLayout.getResources().getDimensionPixelSize(2131166105);
      }
      this.ld = Math.max(this.lc, this.ln - paramCoordinatorLayout.getWidth() * 9 / 16);
      this.le = Math.max(0, this.ln - paramV.getHeight());
      this.lf = (this.ln / 2);
      bF();
      if (this.state != 3) {
        break label200;
      }
      android.support.v4.view.t.s(paramV, bG());
    }
    for (;;)
    {
      if (this.lj == null) {
        this.lj = android.support.v4.widget.t.a(paramCoordinatorLayout, this.lv);
      }
      this.lo = new WeakReference(paramV);
      this.lp = new WeakReference(k(paramV));
      return true;
      this.ld = this.la;
      break;
      label200:
      if (this.state == 6) {
        android.support.v4.view.t.s(paramV, this.lf);
      } else if ((this.lh) && (this.state == 5)) {
        android.support.v4.view.t.s(paramV, this.ln);
      } else if (this.state == 4) {
        android.support.v4.view.t.s(paramV, this.lg);
      } else if ((this.state == 1) || (this.state == 2)) {
        android.support.v4.view.t.s(paramV, i - paramV.getTop());
      }
    }
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (!paramV.isShown()) {}
    do
    {
      return false;
      int i = paramMotionEvent.getActionMasked();
      if ((this.state == 1) && (i == 0)) {
        return true;
      }
      if (this.lj != null) {
        this.lj.h(paramMotionEvent);
      }
      if (i == 0) {
        reset();
      }
      if (this.lr == null) {
        this.lr = VelocityTracker.obtain();
      }
      this.lr.addMovement(paramMotionEvent);
      if ((i == 2) && (!this.lk) && (Math.abs(this.lt - paramMotionEvent.getY()) > this.lj.mTouchSlop)) {
        this.lj.y(paramV, paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
      }
    } while (this.lk);
    return true;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2)
  {
    return (paramView == this.lp.get()) && ((this.state != 3) || (super.a(paramCoordinatorLayout, paramV, paramView, paramFloat1, paramFloat2)));
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    this.ll = 0;
    this.lm = false;
    if ((paramInt1 & 0x2) != 0) {
      bool = true;
    }
    return bool;
  }
  
  final boolean a(View paramView, float paramFloat)
  {
    if (this.li) {}
    do
    {
      return true;
      if (paramView.getTop() < this.lg) {
        return false;
      }
    } while (Math.abs(paramView.getTop() + 0.1F * paramFloat - this.lg) / this.la > 0.5F);
    return false;
  }
  
  public final Parcelable b(CoordinatorLayout paramCoordinatorLayout, V paramV)
  {
    return new SavedState(super.b(paramCoordinatorLayout, paramV), this.state);
  }
  
  final void b(View paramView, int paramInt)
  {
    int i;
    int j;
    if (paramInt == 4)
    {
      i = this.lg;
      j = paramInt;
    }
    while (this.lj.h(paramView, paramView.getLeft(), i))
    {
      K(2);
      android.support.v4.view.t.b(paramView, new b(paramView, j));
      return;
      if (paramInt == 6)
      {
        int k = this.lf;
        i = k;
        j = paramInt;
        if (this.kY)
        {
          i = k;
          j = paramInt;
          if (k <= this.le)
          {
            i = this.le;
            j = 3;
          }
        }
      }
      else if (paramInt == 3)
      {
        i = bG();
        j = paramInt;
      }
      else if ((this.lh) && (paramInt == 5))
      {
        i = this.ln;
        j = paramInt;
      }
      else
      {
        throw new IllegalArgumentException("Illegal state argument: ".concat(String.valueOf(paramInt)));
      }
    }
    K(j);
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (!paramV.isShown()) {
      this.lk = true;
    }
    for (;;)
    {
      return false;
      int i = paramMotionEvent.getActionMasked();
      if (i == 0) {
        reset();
      }
      if (this.lr == null) {
        this.lr = VelocityTracker.obtain();
      }
      this.lr.addMovement(paramMotionEvent);
      switch (i)
      {
      }
      while ((!this.lk) && (this.lj != null) && (this.lj.g(paramMotionEvent)))
      {
        return true;
        this.lu = false;
        this.ls = -1;
        if (this.lk)
        {
          this.lk = false;
          return false;
          int j = (int)paramMotionEvent.getX();
          this.lt = ((int)paramMotionEvent.getY());
          View localView;
          if (this.lp != null)
          {
            localView = (View)this.lp.get();
            label170:
            if ((localView != null) && (paramCoordinatorLayout.d(localView, j, this.lt)))
            {
              this.ls = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
              this.lu = true;
            }
            if ((this.ls != -1) || (paramCoordinatorLayout.d(paramV, j, this.lt))) {
              break label247;
            }
          }
          label247:
          for (boolean bool = true;; bool = false)
          {
            this.lk = bool;
            break;
            localView = null;
            break label170;
          }
        }
      }
      if (this.lp != null) {}
      for (paramV = (View)this.lp.get(); (i == 2) && (paramV != null) && (!this.lk) && (this.state != 1) && (!paramCoordinatorLayout.d(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) && (this.lj != null) && (Math.abs(this.lt - paramMotionEvent.getY()) > this.lj.mTouchSlop); paramV = null) {
        return true;
      }
    }
  }
  
  public final void setState(final int paramInt)
  {
    if (paramInt == this.state) {}
    final View localView;
    do
    {
      do
      {
        return;
        if (this.lo != null) {
          break;
        }
      } while ((paramInt != 4) && (paramInt != 3) && (paramInt != 6) && ((!this.lh) || (paramInt != 5)));
      this.state = paramInt;
      return;
      localView = (View)this.lo.get();
    } while (localView == null);
    ViewParent localViewParent = localView.getParent();
    if ((localViewParent != null) && (localViewParent.isLayoutRequested()) && (android.support.v4.view.t.aC(localView)))
    {
      localView.post(new Runnable()
      {
        public final void run()
        {
          BottomSheetBehavior.this.b(localView, paramInt);
        }
      });
      return;
    }
    b(localView, paramInt);
  }
  
  public final void u(boolean paramBoolean)
  {
    this.lh = paramBoolean;
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
  
  public static abstract class a
  {
    public abstract void N(int paramInt);
    
    public abstract void h(float paramFloat);
  }
  
  final class b
    implements Runnable
  {
    private final int ly;
    private final View view;
    
    b(View paramView, int paramInt)
    {
      this.view = paramView;
      this.ly = paramInt;
    }
    
    public final void run()
    {
      if ((BottomSheetBehavior.this.lj != null) && (BottomSheetBehavior.this.lj.fH()))
      {
        android.support.v4.view.t.b(this.view, this);
        return;
      }
      BottomSheetBehavior.this.K(this.ly);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.BottomSheetBehavior
 * JD-Core Version:    0.7.0.1
 */