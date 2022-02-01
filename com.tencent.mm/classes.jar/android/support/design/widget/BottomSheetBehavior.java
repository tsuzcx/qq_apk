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
  private Map<View, Integer> kY;
  private boolean lX = true;
  private float lY;
  private int lZ;
  private boolean ma;
  private int mb;
  private int mc;
  int md;
  int me;
  int mf;
  public boolean mg;
  private boolean mh;
  android.support.v4.widget.t mi;
  private boolean mj;
  private int mk;
  private boolean ml;
  int mm;
  WeakReference<V> mn;
  WeakReference<View> mo;
  public a mp;
  private VelocityTracker mq;
  int mr;
  private int ms;
  boolean mt;
  private final t.a mu = new t.a()
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
          i = BottomSheetBehavior.this.md;
        }
      }
      while (BottomSheetBehavior.this.mi.A(paramAnonymousView.getLeft(), i))
      {
        BottomSheetBehavior.this.K(2);
        android.support.v4.view.t.b(paramAnonymousView, new BottomSheetBehavior.b(BottomSheetBehavior.this, paramAnonymousView, j));
        return;
        if (paramAnonymousView.getTop() > BottomSheetBehavior.this.me)
        {
          i = BottomSheetBehavior.this.me;
          j = 6;
          continue;
          if ((BottomSheetBehavior.this.mg) && (BottomSheetBehavior.this.a(paramAnonymousView, paramAnonymousFloat2)) && ((paramAnonymousView.getTop() > BottomSheetBehavior.this.mf) || (Math.abs(paramAnonymousFloat1) < Math.abs(paramAnonymousFloat2))))
          {
            i = BottomSheetBehavior.this.mm;
            j = 5;
          }
          else if ((paramAnonymousFloat2 == 0.0F) || (Math.abs(paramAnonymousFloat1) > Math.abs(paramAnonymousFloat2)))
          {
            int k = paramAnonymousView.getTop();
            if (BottomSheetBehavior.a(BottomSheetBehavior.this))
            {
              if (Math.abs(k - BottomSheetBehavior.this.md) < Math.abs(k - BottomSheetBehavior.this.mf))
              {
                i = BottomSheetBehavior.this.md;
              }
              else
              {
                i = BottomSheetBehavior.this.mf;
                j = 4;
              }
            }
            else if (k < BottomSheetBehavior.this.me)
            {
              if (k >= Math.abs(k - BottomSheetBehavior.this.mf))
              {
                i = BottomSheetBehavior.this.me;
                j = 6;
              }
            }
            else if (Math.abs(k - BottomSheetBehavior.this.me) < Math.abs(k - BottomSheetBehavior.this.mf))
            {
              i = BottomSheetBehavior.this.me;
              j = 6;
            }
            else
            {
              i = BottomSheetBehavior.this.mf;
              j = 4;
            }
          }
          else
          {
            i = BottomSheetBehavior.this.mf;
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
    
    public final int bO()
    {
      if (BottomSheetBehavior.this.mg) {
        return BottomSheetBehavior.this.mm;
      }
      return BottomSheetBehavior.this.mf;
    }
    
    public final boolean c(View paramAnonymousView, int paramAnonymousInt)
    {
      if (BottomSheetBehavior.this.state == 1) {
        return false;
      }
      if (BottomSheetBehavior.this.mt) {
        return false;
      }
      if ((BottomSheetBehavior.this.state == 3) && (BottomSheetBehavior.this.mr == paramAnonymousInt))
      {
        View localView = (View)BottomSheetBehavior.this.mo.get();
        if ((localView != null) && (localView.canScrollVertically(-1))) {
          return false;
        }
      }
      return (BottomSheetBehavior.this.mn != null) && (BottomSheetBehavior.this.mn.get() == paramAnonymousView);
    }
    
    public final int d(View paramAnonymousView, int paramAnonymousInt)
    {
      int j = BottomSheetBehavior.b(BottomSheetBehavior.this);
      if (BottomSheetBehavior.this.mg) {}
      for (int i = BottomSheetBehavior.this.mm;; i = BottomSheetBehavior.this.mf) {
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
      this.mg = paramAttributeSet.getBoolean(1, false);
      boolean bool = paramAttributeSet.getBoolean(0, true);
      if (this.lX != bool)
      {
        this.lX = bool;
        if (this.mn != null) {
          bM();
        }
        if ((!this.lX) || (this.state != 6)) {
          break label174;
        }
      }
    }
    label174:
    for (int i = 3;; i = this.state)
    {
      K(i);
      this.mh = paramAttributeSet.getBoolean(3, false);
      paramAttributeSet.recycle();
      this.lY = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
      return;
      J(paramAttributeSet.getDimensionPixelSize(2, -1));
      break;
    }
  }
  
  private void bM()
  {
    if (this.lX)
    {
      this.mf = Math.max(this.mm - this.mc, this.md);
      return;
    }
    this.mf = (this.mm - this.mc);
  }
  
  private int bN()
  {
    if (this.lX) {
      return this.md;
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
    paramV = ((CoordinatorLayout.d)paramV).oH;
    if (!(paramV instanceof BottomSheetBehavior)) {
      throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }
    return (BottomSheetBehavior)paramV;
  }
  
  private void reset()
  {
    this.mr = -1;
    if (this.mq != null)
    {
      this.mq.recycle();
      this.mq = null;
    }
  }
  
  private void v(boolean paramBoolean)
  {
    if (this.mn == null) {}
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
          localObject = ((View)this.mn.get()).getParent();
        } while (!(localObject instanceof CoordinatorLayout));
        localObject = (CoordinatorLayout)localObject;
        j = ((CoordinatorLayout)localObject).getChildCount();
        if ((Build.VERSION.SDK_INT < 16) || (!paramBoolean)) {
          break;
        }
      } while (this.kY != null);
      this.kY = new HashMap(j);
      int i = 0;
      if (i < j)
      {
        View localView = ((CoordinatorLayout)localObject).getChildAt(i);
        if (localView != this.mn.get())
        {
          if (paramBoolean) {
            break label156;
          }
          if ((this.kY != null) && (this.kY.containsKey(localView))) {
            android.support.v4.view.t.p(localView, ((Integer)this.kY.get(localView)).intValue());
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (Build.VERSION.SDK_INT >= 16) {
            this.kY.put(localView, Integer.valueOf(localView.getImportantForAccessibility()));
          }
          android.support.v4.view.t.p(localView, 4);
        }
      }
    } while (paramBoolean);
    this.kY = null;
  }
  
  public final void J(int paramInt)
  {
    int i = 1;
    if (paramInt == -1)
    {
      if (this.ma) {
        break label104;
      }
      this.ma = true;
      paramInt = i;
    }
    for (;;)
    {
      if ((paramInt != 0) && (this.state == 4) && (this.mn != null))
      {
        View localView = (View)this.mn.get();
        if (localView != null) {
          localView.requestLayout();
        }
      }
      return;
      if ((this.ma) || (this.lZ != paramInt))
      {
        this.ma = false;
        this.lZ = Math.max(0, paramInt);
        this.mf = (this.mm - paramInt);
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
      while (((View)this.mn.get() != null) && (this.mp != null))
      {
        this.mp.N(paramInt);
        return;
        if ((paramInt == 5) || (paramInt == 4)) {
          v(false);
        }
      }
    }
  }
  
  final void L(int paramInt)
  {
    if (((View)this.mn.get() != null) && (this.mp != null))
    {
      if (paramInt > this.mf) {
        this.mp.l((this.mf - paramInt) / (this.mm - this.mf));
      }
    }
    else {
      return;
    }
    this.mp.l((this.mf - paramInt) / (this.mf - bN()));
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, V paramV, Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.a(paramCoordinatorLayout, paramV, paramParcelable.Nj);
    if ((paramParcelable.state == 1) || (paramParcelable.state == 2))
    {
      this.state = 4;
      return;
    }
    this.state = paramParcelable.state;
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt)
  {
    if (paramV.getTop() == bN()) {
      K(3);
    }
    while ((paramView != this.mo.get()) || (!this.ml)) {
      return;
    }
    int i;
    if (this.mk > 0)
    {
      i = bN();
      paramInt = 3;
      if (!this.mi.h(paramV, paramV.getLeft(), i)) {
        break label336;
      }
      K(2);
      android.support.v4.view.t.b(paramV, new b(paramV, paramInt));
    }
    for (;;)
    {
      this.ml = false;
      return;
      if (this.mg)
      {
        if (this.mq == null) {}
        for (float f = 0.0F;; f = this.mq.getYVelocity(this.mr))
        {
          if (!a(paramV, f)) {
            break label163;
          }
          i = this.mm;
          paramInt = 5;
          break;
          this.mq.computeCurrentVelocity(1000, this.lY);
        }
      }
      label163:
      if (this.mk == 0)
      {
        paramInt = paramV.getTop();
        if (this.lX)
        {
          if (Math.abs(paramInt - this.md) < Math.abs(paramInt - this.mf))
          {
            i = this.md;
            paramInt = 3;
            break;
          }
          i = this.mf;
          paramInt = 4;
          break;
        }
        if (paramInt < this.me)
        {
          if (paramInt < Math.abs(paramInt - this.mf))
          {
            paramInt = 3;
            i = 0;
            break;
          }
          i = this.me;
          paramInt = 6;
          break;
        }
        if (Math.abs(paramInt - this.me) < Math.abs(paramInt - this.mf))
        {
          i = this.me;
          paramInt = 6;
          break;
        }
        i = this.mf;
        paramInt = 4;
        break;
      }
      i = this.mf;
      paramInt = 4;
      break;
      label336:
      K(paramInt);
    }
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    if (paramInt3 == 1) {}
    while (paramView != (View)this.mo.get()) {
      return;
    }
    paramInt1 = paramV.getTop();
    paramInt3 = paramInt1 - paramInt2;
    if (paramInt2 > 0) {
      if (paramInt3 < bN())
      {
        paramArrayOfInt[1] = (paramInt1 - bN());
        android.support.v4.view.t.s(paramV, -paramArrayOfInt[1]);
        K(3);
      }
    }
    for (;;)
    {
      L(paramV.getTop());
      this.mk = paramInt2;
      this.ml = true;
      return;
      paramArrayOfInt[1] = paramInt2;
      android.support.v4.view.t.s(paramV, -paramInt2);
      K(1);
      continue;
      if ((paramInt2 < 0) && (!paramView.canScrollVertically(-1))) {
        if ((paramInt3 <= this.mf) || (this.mg))
        {
          paramArrayOfInt[1] = paramInt2;
          android.support.v4.view.t.s(paramV, -paramInt2);
          K(1);
        }
        else
        {
          paramArrayOfInt[1] = (paramInt1 - this.mf);
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
    this.mm = paramCoordinatorLayout.getHeight();
    if (this.ma)
    {
      if (this.mb == 0) {
        this.mb = paramCoordinatorLayout.getResources().getDimensionPixelSize(2131166105);
      }
      this.mc = Math.max(this.mb, this.mm - paramCoordinatorLayout.getWidth() * 9 / 16);
      this.md = Math.max(0, this.mm - paramV.getHeight());
      this.me = (this.mm / 2);
      bM();
      if (this.state != 3) {
        break label200;
      }
      android.support.v4.view.t.s(paramV, bN());
    }
    for (;;)
    {
      if (this.mi == null) {
        this.mi = android.support.v4.widget.t.a(paramCoordinatorLayout, this.mu);
      }
      this.mn = new WeakReference(paramV);
      this.mo = new WeakReference(k(paramV));
      return true;
      this.mc = this.lZ;
      break;
      label200:
      if (this.state == 6) {
        android.support.v4.view.t.s(paramV, this.me);
      } else if ((this.mg) && (this.state == 5)) {
        android.support.v4.view.t.s(paramV, this.mm);
      } else if (this.state == 4) {
        android.support.v4.view.t.s(paramV, this.mf);
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
      if (this.mi != null) {
        this.mi.h(paramMotionEvent);
      }
      if (i == 0) {
        reset();
      }
      if (this.mq == null) {
        this.mq = VelocityTracker.obtain();
      }
      this.mq.addMovement(paramMotionEvent);
      if ((i == 2) && (!this.mj) && (Math.abs(this.ms - paramMotionEvent.getY()) > this.mi.mTouchSlop)) {
        this.mi.y(paramV, paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
      }
    } while (this.mj);
    return true;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2)
  {
    return (paramView == this.mo.get()) && ((this.state != 3) || (super.a(paramCoordinatorLayout, paramV, paramView, paramFloat1, paramFloat2)));
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    this.mk = 0;
    this.ml = false;
    if ((paramInt1 & 0x2) != 0) {
      bool = true;
    }
    return bool;
  }
  
  final boolean a(View paramView, float paramFloat)
  {
    if (this.mh) {}
    do
    {
      return true;
      if (paramView.getTop() < this.mf) {
        return false;
      }
    } while (Math.abs(paramView.getTop() + 0.1F * paramFloat - this.mf) / this.lZ > 0.5F);
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
      i = this.mf;
      j = paramInt;
    }
    while (this.mi.h(paramView, paramView.getLeft(), i))
    {
      K(2);
      android.support.v4.view.t.b(paramView, new b(paramView, j));
      return;
      if (paramInt == 6)
      {
        int k = this.me;
        i = k;
        j = paramInt;
        if (this.lX)
        {
          i = k;
          j = paramInt;
          if (k <= this.md)
          {
            i = this.md;
            j = 3;
          }
        }
      }
      else if (paramInt == 3)
      {
        i = bN();
        j = paramInt;
      }
      else if ((this.mg) && (paramInt == 5))
      {
        i = this.mm;
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
      this.mj = true;
    }
    for (;;)
    {
      return false;
      int i = paramMotionEvent.getActionMasked();
      if (i == 0) {
        reset();
      }
      if (this.mq == null) {
        this.mq = VelocityTracker.obtain();
      }
      this.mq.addMovement(paramMotionEvent);
      switch (i)
      {
      }
      while ((!this.mj) && (this.mi != null) && (this.mi.g(paramMotionEvent)))
      {
        return true;
        this.mt = false;
        this.mr = -1;
        if (this.mj)
        {
          this.mj = false;
          return false;
          int j = (int)paramMotionEvent.getX();
          this.ms = ((int)paramMotionEvent.getY());
          View localView;
          if (this.mo != null)
          {
            localView = (View)this.mo.get();
            label170:
            if ((localView != null) && (paramCoordinatorLayout.d(localView, j, this.ms)))
            {
              this.mr = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
              this.mt = true;
            }
            if ((this.mr != -1) || (paramCoordinatorLayout.d(paramV, j, this.ms))) {
              break label247;
            }
          }
          label247:
          for (boolean bool = true;; bool = false)
          {
            this.mj = bool;
            break;
            localView = null;
            break label170;
          }
        }
      }
      if (this.mo != null) {}
      for (paramV = (View)this.mo.get(); (i == 2) && (paramV != null) && (!this.mj) && (this.state != 1) && (!paramCoordinatorLayout.d(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) && (this.mi != null) && (Math.abs(this.ms - paramMotionEvent.getY()) > this.mi.mTouchSlop); paramV = null) {
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
        if (this.mn != null) {
          break;
        }
      } while ((paramInt != 4) && (paramInt != 3) && (paramInt != 6) && ((!this.mg) || (paramInt != 5)));
      this.state = paramInt;
      return;
      localView = (View)this.mn.get();
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
    this.mg = paramBoolean;
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
    
    public abstract void l(float paramFloat);
  }
  
  final class b
    implements Runnable
  {
    private final int mx;
    private final View view;
    
    b(View paramView, int paramInt)
    {
      this.view = paramView;
      this.mx = paramInt;
    }
    
    public final void run()
    {
      if ((BottomSheetBehavior.this.mi != null) && (BottomSheetBehavior.this.mi.fP()))
      {
        android.support.v4.view.t.b(this.view, this);
        return;
      }
      BottomSheetBehavior.this.K(this.mx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.BottomSheetBehavior
 * JD-Core Version:    0.7.0.1
 */