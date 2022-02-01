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
  private Map<View, Integer> mP;
  private boolean nQ = true;
  private float nR;
  private int nS;
  private boolean nT;
  private int nU;
  private int nV;
  int nW;
  int nX;
  int nY;
  public boolean nZ;
  private boolean oa;
  android.support.v4.widget.t ob;
  private boolean oc;
  private int od;
  private boolean oe;
  int of;
  WeakReference<V> og;
  WeakReference<View> oh;
  public a oi;
  private VelocityTracker oj;
  int ok;
  private int ol;
  boolean om;
  private final t.a oo = new t.a()
  {
    public final void L(int paramAnonymousInt)
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
          i = BottomSheetBehavior.this.nW;
        }
      }
      while (BottomSheetBehavior.this.ob.H(paramAnonymousView.getLeft(), i))
      {
        BottomSheetBehavior.this.K(2);
        android.support.v4.view.t.b(paramAnonymousView, new BottomSheetBehavior.b(BottomSheetBehavior.this, paramAnonymousView, j));
        return;
        if (paramAnonymousView.getTop() > BottomSheetBehavior.this.nX)
        {
          i = BottomSheetBehavior.this.nX;
          j = 6;
          continue;
          if ((BottomSheetBehavior.this.nZ) && (BottomSheetBehavior.this.a(paramAnonymousView, paramAnonymousFloat2)) && ((paramAnonymousView.getTop() > BottomSheetBehavior.this.nY) || (Math.abs(paramAnonymousFloat1) < Math.abs(paramAnonymousFloat2))))
          {
            i = BottomSheetBehavior.this.of;
            j = 5;
          }
          else if ((paramAnonymousFloat2 == 0.0F) || (Math.abs(paramAnonymousFloat1) > Math.abs(paramAnonymousFloat2)))
          {
            int k = paramAnonymousView.getTop();
            if (BottomSheetBehavior.a(BottomSheetBehavior.this))
            {
              if (Math.abs(k - BottomSheetBehavior.this.nW) < Math.abs(k - BottomSheetBehavior.this.nY))
              {
                i = BottomSheetBehavior.this.nW;
              }
              else
              {
                i = BottomSheetBehavior.this.nY;
                j = 4;
              }
            }
            else if (k < BottomSheetBehavior.this.nX)
            {
              if (k >= Math.abs(k - BottomSheetBehavior.this.nY))
              {
                i = BottomSheetBehavior.this.nX;
                j = 6;
              }
            }
            else if (Math.abs(k - BottomSheetBehavior.this.nX) < Math.abs(k - BottomSheetBehavior.this.nY))
            {
              i = BottomSheetBehavior.this.nX;
              j = 6;
            }
            else
            {
              i = BottomSheetBehavior.this.nY;
              j = 4;
            }
          }
          else
          {
            i = BottomSheetBehavior.this.nY;
            j = 4;
          }
        }
      }
      BottomSheetBehavior.this.K(j);
    }
    
    public final void b(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      BottomSheetBehavior.this.cd();
    }
    
    public final boolean c(View paramAnonymousView, int paramAnonymousInt)
    {
      if (BottomSheetBehavior.this.state == 1) {
        return false;
      }
      if (BottomSheetBehavior.this.om) {
        return false;
      }
      if ((BottomSheetBehavior.this.state == 3) && (BottomSheetBehavior.this.ok == paramAnonymousInt))
      {
        View localView = (View)BottomSheetBehavior.this.oh.get();
        if ((localView != null) && (localView.canScrollVertically(-1))) {
          return false;
        }
      }
      return (BottomSheetBehavior.this.og != null) && (BottomSheetBehavior.this.og.get() == paramAnonymousView);
    }
    
    public final int ce()
    {
      if (BottomSheetBehavior.this.nZ) {
        return BottomSheetBehavior.this.of;
      }
      return BottomSheetBehavior.this.nY;
    }
    
    public final int d(View paramAnonymousView, int paramAnonymousInt)
    {
      int j = BottomSheetBehavior.b(BottomSheetBehavior.this);
      if (BottomSheetBehavior.this.nZ) {}
      for (int i = BottomSheetBehavior.this.of;; i = BottomSheetBehavior.this.nY) {
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
      this.nZ = paramAttributeSet.getBoolean(1, false);
      boolean bool = paramAttributeSet.getBoolean(0, true);
      if (this.nQ != bool)
      {
        this.nQ = bool;
        if (this.og != null) {
          cb();
        }
        if ((!this.nQ) || (this.state != 6)) {
          break label174;
        }
      }
    }
    label174:
    for (int i = 3;; i = this.state)
    {
      K(i);
      this.oa = paramAttributeSet.getBoolean(3, false);
      paramAttributeSet.recycle();
      this.nR = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
      return;
      J(paramAttributeSet.getDimensionPixelSize(2, -1));
      break;
    }
  }
  
  private void cb()
  {
    if (this.nQ)
    {
      this.nY = Math.max(this.of - this.nV, this.nW);
      return;
    }
    this.nY = (this.of - this.nV);
  }
  
  private int cc()
  {
    if (this.nQ) {
      return this.nW;
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
    paramV = ((CoordinatorLayout.d)paramV).qA;
    if (!(paramV instanceof BottomSheetBehavior)) {
      throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }
    return (BottomSheetBehavior)paramV;
  }
  
  private void reset()
  {
    this.ok = -1;
    if (this.oj != null)
    {
      this.oj.recycle();
      this.oj = null;
    }
  }
  
  private void v(boolean paramBoolean)
  {
    if (this.og == null) {}
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
          localObject = ((View)this.og.get()).getParent();
        } while (!(localObject instanceof CoordinatorLayout));
        localObject = (CoordinatorLayout)localObject;
        j = ((CoordinatorLayout)localObject).getChildCount();
        if ((Build.VERSION.SDK_INT < 16) || (!paramBoolean)) {
          break;
        }
      } while (this.mP != null);
      this.mP = new HashMap(j);
      int i = 0;
      if (i < j)
      {
        View localView = ((CoordinatorLayout)localObject).getChildAt(i);
        if (localView != this.og.get())
        {
          if (paramBoolean) {
            break label156;
          }
          if ((this.mP != null) && (this.mP.containsKey(localView))) {
            android.support.v4.view.t.p(localView, ((Integer)this.mP.get(localView)).intValue());
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (Build.VERSION.SDK_INT >= 16) {
            this.mP.put(localView, Integer.valueOf(localView.getImportantForAccessibility()));
          }
          android.support.v4.view.t.p(localView, 4);
        }
      }
    } while (paramBoolean);
    this.mP = null;
  }
  
  public final void J(int paramInt)
  {
    int i = 1;
    if (paramInt == -1)
    {
      if (this.nT) {
        break label104;
      }
      this.nT = true;
      paramInt = i;
    }
    for (;;)
    {
      if ((paramInt != 0) && (this.state == 4) && (this.og != null))
      {
        View localView = (View)this.og.get();
        if (localView != null) {
          localView.requestLayout();
        }
      }
      return;
      if ((this.nT) || (this.nS != paramInt))
      {
        this.nT = false;
        this.nS = Math.max(0, paramInt);
        this.nY = (this.of - paramInt);
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
      while (((View)this.og.get() != null) && (this.oi != null))
      {
        this.oi.M(paramInt);
        return;
        if ((paramInt == 5) || (paramInt == 4)) {
          v(false);
        }
      }
    }
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, V paramV, Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.a(paramCoordinatorLayout, paramV, paramParcelable.Pa);
    if ((paramParcelable.state == 1) || (paramParcelable.state == 2))
    {
      this.state = 4;
      return;
    }
    this.state = paramParcelable.state;
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt)
  {
    if (paramV.getTop() == cc()) {
      K(3);
    }
    while ((paramView != this.oh.get()) || (!this.oe)) {
      return;
    }
    int i;
    if (this.od > 0)
    {
      i = cc();
      paramInt = 3;
      if (!this.ob.h(paramV, paramV.getLeft(), i)) {
        break label336;
      }
      K(2);
      android.support.v4.view.t.b(paramV, new b(paramV, paramInt));
    }
    for (;;)
    {
      this.oe = false;
      return;
      if (this.nZ)
      {
        if (this.oj == null) {}
        for (float f = 0.0F;; f = this.oj.getYVelocity(this.ok))
        {
          if (!a(paramV, f)) {
            break label163;
          }
          i = this.of;
          paramInt = 5;
          break;
          this.oj.computeCurrentVelocity(1000, this.nR);
        }
      }
      label163:
      if (this.od == 0)
      {
        paramInt = paramV.getTop();
        if (this.nQ)
        {
          if (Math.abs(paramInt - this.nW) < Math.abs(paramInt - this.nY))
          {
            i = this.nW;
            paramInt = 3;
            break;
          }
          i = this.nY;
          paramInt = 4;
          break;
        }
        if (paramInt < this.nX)
        {
          if (paramInt < Math.abs(paramInt - this.nY))
          {
            paramInt = 3;
            i = 0;
            break;
          }
          i = this.nX;
          paramInt = 6;
          break;
        }
        if (Math.abs(paramInt - this.nX) < Math.abs(paramInt - this.nY))
        {
          i = this.nX;
          paramInt = 6;
          break;
        }
        i = this.nY;
        paramInt = 4;
        break;
      }
      i = this.nY;
      paramInt = 4;
      break;
      label336:
      K(paramInt);
    }
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    if (paramInt3 == 1) {}
    while (paramView != (View)this.oh.get()) {
      return;
    }
    paramInt1 = paramV.getTop();
    paramInt3 = paramInt1 - paramInt2;
    if (paramInt2 > 0) {
      if (paramInt3 < cc())
      {
        paramArrayOfInt[1] = (paramInt1 - cc());
        android.support.v4.view.t.s(paramV, -paramArrayOfInt[1]);
        K(3);
      }
    }
    for (;;)
    {
      paramV.getTop();
      cd();
      this.od = paramInt2;
      this.oe = true;
      return;
      paramArrayOfInt[1] = paramInt2;
      android.support.v4.view.t.s(paramV, -paramInt2);
      K(1);
      continue;
      if ((paramInt2 < 0) && (!paramView.canScrollVertically(-1))) {
        if ((paramInt3 <= this.nY) || (this.nZ))
        {
          paramArrayOfInt[1] = paramInt2;
          android.support.v4.view.t.s(paramV, -paramInt2);
          K(1);
        }
        else
        {
          paramArrayOfInt[1] = (paramInt1 - this.nY);
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
    this.of = paramCoordinatorLayout.getHeight();
    if (this.nT)
    {
      if (this.nU == 0) {
        this.nU = paramCoordinatorLayout.getResources().getDimensionPixelSize(2131166105);
      }
      this.nV = Math.max(this.nU, this.of - paramCoordinatorLayout.getWidth() * 9 / 16);
      this.nW = Math.max(0, this.of - paramV.getHeight());
      this.nX = (this.of / 2);
      cb();
      if (this.state != 3) {
        break label200;
      }
      android.support.v4.view.t.s(paramV, cc());
    }
    for (;;)
    {
      if (this.ob == null) {
        this.ob = android.support.v4.widget.t.a(paramCoordinatorLayout, this.oo);
      }
      this.og = new WeakReference(paramV);
      this.oh = new WeakReference(k(paramV));
      return true;
      this.nV = this.nS;
      break;
      label200:
      if (this.state == 6) {
        android.support.v4.view.t.s(paramV, this.nX);
      } else if ((this.nZ) && (this.state == 5)) {
        android.support.v4.view.t.s(paramV, this.of);
      } else if (this.state == 4) {
        android.support.v4.view.t.s(paramV, this.nY);
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
      if (this.ob != null) {
        this.ob.h(paramMotionEvent);
      }
      if (i == 0) {
        reset();
      }
      if (this.oj == null) {
        this.oj = VelocityTracker.obtain();
      }
      this.oj.addMovement(paramMotionEvent);
      if ((i == 2) && (!this.oc) && (Math.abs(this.ol - paramMotionEvent.getY()) > this.ob.mTouchSlop)) {
        this.ob.y(paramV, paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
      }
    } while (this.oc);
    return true;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2)
  {
    return (paramView == this.oh.get()) && ((this.state != 3) || (super.a(paramCoordinatorLayout, paramV, paramView, paramFloat1, paramFloat2)));
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    this.od = 0;
    this.oe = false;
    if ((paramInt1 & 0x2) != 0) {
      bool = true;
    }
    return bool;
  }
  
  final boolean a(View paramView, float paramFloat)
  {
    if (this.oa) {}
    do
    {
      return true;
      if (paramView.getTop() < this.nY) {
        return false;
      }
    } while (Math.abs(paramView.getTop() + 0.1F * paramFloat - this.nY) / this.nS > 0.5F);
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
      i = this.nY;
      j = paramInt;
    }
    while (this.ob.h(paramView, paramView.getLeft(), i))
    {
      K(2);
      android.support.v4.view.t.b(paramView, new b(paramView, j));
      return;
      if (paramInt == 6)
      {
        int k = this.nX;
        i = k;
        j = paramInt;
        if (this.nQ)
        {
          i = k;
          j = paramInt;
          if (k <= this.nW)
          {
            i = this.nW;
            j = 3;
          }
        }
      }
      else if (paramInt == 3)
      {
        i = cc();
        j = paramInt;
      }
      else if ((this.nZ) && (paramInt == 5))
      {
        i = this.of;
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
      this.oc = true;
    }
    for (;;)
    {
      return false;
      int i = paramMotionEvent.getActionMasked();
      if (i == 0) {
        reset();
      }
      if (this.oj == null) {
        this.oj = VelocityTracker.obtain();
      }
      this.oj.addMovement(paramMotionEvent);
      switch (i)
      {
      }
      while ((!this.oc) && (this.ob != null) && (this.ob.g(paramMotionEvent)))
      {
        return true;
        this.om = false;
        this.ok = -1;
        if (this.oc)
        {
          this.oc = false;
          return false;
          int j = (int)paramMotionEvent.getX();
          this.ol = ((int)paramMotionEvent.getY());
          View localView;
          if (this.oh != null)
          {
            localView = (View)this.oh.get();
            label170:
            if ((localView != null) && (paramCoordinatorLayout.d(localView, j, this.ol)))
            {
              this.ok = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
              this.om = true;
            }
            if ((this.ok != -1) || (paramCoordinatorLayout.d(paramV, j, this.ol))) {
              break label247;
            }
          }
          label247:
          for (boolean bool = true;; bool = false)
          {
            this.oc = bool;
            break;
            localView = null;
            break label170;
          }
        }
      }
      if (this.oh != null) {}
      for (paramV = (View)this.oh.get(); (i == 2) && (paramV != null) && (!this.oc) && (this.state != 1) && (!paramCoordinatorLayout.d(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) && (this.ob != null) && (Math.abs(this.ol - paramMotionEvent.getY()) > this.ob.mTouchSlop); paramV = null) {
        return true;
      }
    }
  }
  
  final void cd()
  {
    this.og.get();
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
        if (this.og != null) {
          break;
        }
      } while ((paramInt != 4) && (paramInt != 3) && (paramInt != 6) && ((!this.nZ) || (paramInt != 5)));
      this.state = paramInt;
      return;
      localView = (View)this.og.get();
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
    this.nZ = paramBoolean;
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
    public abstract void M(int paramInt);
  }
  
  final class b
    implements Runnable
  {
    private final int ot;
    private final View view;
    
    b(View paramView, int paramInt)
    {
      this.view = paramView;
      this.ot = paramInt;
    }
    
    public final void run()
    {
      if ((BottomSheetBehavior.this.ob != null) && (BottomSheetBehavior.this.ob.gh()))
      {
        android.support.v4.view.t.b(this.view, this);
        return;
      }
      BottomSheetBehavior.this.K(this.ot);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.BottomSheetBehavior
 * JD-Core Version:    0.7.0.1
 */