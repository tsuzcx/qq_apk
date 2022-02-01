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
import android.support.v4.view.u;
import android.support.v4.widget.t;
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
  private Map<View, Integer> mR;
  private boolean nS = true;
  private float nT;
  private int nU;
  private boolean nV;
  private int nW;
  private int nX;
  int nY;
  int nZ;
  int oa;
  public boolean ob;
  private boolean oc;
  t od;
  private boolean oe;
  private int of;
  private boolean og;
  int oh;
  WeakReference<V> oi;
  WeakReference<View> oj;
  public a ok;
  private VelocityTracker ol;
  int om;
  private int oo;
  boolean oq;
  private final t.a or = new t.a()
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
          i = BottomSheetBehavior.this.nY;
        }
      }
      while (BottomSheetBehavior.this.od.H(paramAnonymousView.getLeft(), i))
      {
        BottomSheetBehavior.this.K(2);
        u.b(paramAnonymousView, new BottomSheetBehavior.b(BottomSheetBehavior.this, paramAnonymousView, j));
        return;
        if (paramAnonymousView.getTop() > BottomSheetBehavior.this.nZ)
        {
          i = BottomSheetBehavior.this.nZ;
          j = 6;
          continue;
          if ((BottomSheetBehavior.this.ob) && (BottomSheetBehavior.this.a(paramAnonymousView, paramAnonymousFloat2)) && ((paramAnonymousView.getTop() > BottomSheetBehavior.this.oa) || (Math.abs(paramAnonymousFloat1) < Math.abs(paramAnonymousFloat2))))
          {
            i = BottomSheetBehavior.this.oh;
            j = 5;
          }
          else if ((paramAnonymousFloat2 == 0.0F) || (Math.abs(paramAnonymousFloat1) > Math.abs(paramAnonymousFloat2)))
          {
            int k = paramAnonymousView.getTop();
            if (BottomSheetBehavior.a(BottomSheetBehavior.this))
            {
              if (Math.abs(k - BottomSheetBehavior.this.nY) < Math.abs(k - BottomSheetBehavior.this.oa))
              {
                i = BottomSheetBehavior.this.nY;
              }
              else
              {
                i = BottomSheetBehavior.this.oa;
                j = 4;
              }
            }
            else if (k < BottomSheetBehavior.this.nZ)
            {
              if (k >= Math.abs(k - BottomSheetBehavior.this.oa))
              {
                i = BottomSheetBehavior.this.nZ;
                j = 6;
              }
            }
            else if (Math.abs(k - BottomSheetBehavior.this.nZ) < Math.abs(k - BottomSheetBehavior.this.oa))
            {
              i = BottomSheetBehavior.this.nZ;
              j = 6;
            }
            else
            {
              i = BottomSheetBehavior.this.oa;
              j = 4;
            }
          }
          else
          {
            i = BottomSheetBehavior.this.oa;
            j = 4;
          }
        }
      }
      BottomSheetBehavior.this.K(j);
    }
    
    public final void b(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      BottomSheetBehavior.this.cf();
    }
    
    public final boolean c(View paramAnonymousView, int paramAnonymousInt)
    {
      if (BottomSheetBehavior.this.state == 1) {
        return false;
      }
      if (BottomSheetBehavior.this.oq) {
        return false;
      }
      if ((BottomSheetBehavior.this.state == 3) && (BottomSheetBehavior.this.om == paramAnonymousInt))
      {
        View localView = (View)BottomSheetBehavior.this.oj.get();
        if ((localView != null) && (localView.canScrollVertically(-1))) {
          return false;
        }
      }
      return (BottomSheetBehavior.this.oi != null) && (BottomSheetBehavior.this.oi.get() == paramAnonymousView);
    }
    
    public final int cg()
    {
      if (BottomSheetBehavior.this.ob) {
        return BottomSheetBehavior.this.oh;
      }
      return BottomSheetBehavior.this.oa;
    }
    
    public final int d(View paramAnonymousView, int paramAnonymousInt)
    {
      int j = BottomSheetBehavior.b(BottomSheetBehavior.this);
      if (BottomSheetBehavior.this.ob) {}
      for (int i = BottomSheetBehavior.this.oh;; i = BottomSheetBehavior.this.oa) {
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
      this.ob = paramAttributeSet.getBoolean(1, false);
      boolean bool = paramAttributeSet.getBoolean(0, true);
      if (this.nS != bool)
      {
        this.nS = bool;
        if (this.oi != null) {
          cd();
        }
        if ((!this.nS) || (this.state != 6)) {
          break label174;
        }
      }
    }
    label174:
    for (int i = 3;; i = this.state)
    {
      K(i);
      this.oc = paramAttributeSet.getBoolean(3, false);
      paramAttributeSet.recycle();
      this.nT = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
      return;
      J(paramAttributeSet.getDimensionPixelSize(2, -1));
      break;
    }
  }
  
  private void cd()
  {
    if (this.nS)
    {
      this.oa = Math.max(this.oh - this.nX, this.nY);
      return;
    }
    this.oa = (this.oh - this.nX);
  }
  
  private int ce()
  {
    if (this.nS) {
      return this.nY;
    }
    return 0;
  }
  
  private View k(View paramView)
  {
    if (u.aw(paramView)) {
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
    paramV = ((CoordinatorLayout.d)paramV).qC;
    if (!(paramV instanceof BottomSheetBehavior)) {
      throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }
    return (BottomSheetBehavior)paramV;
  }
  
  private void reset()
  {
    this.om = -1;
    if (this.ol != null)
    {
      this.ol.recycle();
      this.ol = null;
    }
  }
  
  private void v(boolean paramBoolean)
  {
    if (this.oi == null) {}
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
          localObject = ((View)this.oi.get()).getParent();
        } while (!(localObject instanceof CoordinatorLayout));
        localObject = (CoordinatorLayout)localObject;
        j = ((CoordinatorLayout)localObject).getChildCount();
        if ((Build.VERSION.SDK_INT < 16) || (!paramBoolean)) {
          break;
        }
      } while (this.mR != null);
      this.mR = new HashMap(j);
      int i = 0;
      if (i < j)
      {
        View localView = ((CoordinatorLayout)localObject).getChildAt(i);
        if (localView != this.oi.get())
        {
          if (paramBoolean) {
            break label156;
          }
          if ((this.mR != null) && (this.mR.containsKey(localView))) {
            u.p(localView, ((Integer)this.mR.get(localView)).intValue());
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (Build.VERSION.SDK_INT >= 16) {
            this.mR.put(localView, Integer.valueOf(localView.getImportantForAccessibility()));
          }
          u.p(localView, 4);
        }
      }
    } while (paramBoolean);
    this.mR = null;
  }
  
  public final void J(int paramInt)
  {
    int i = 1;
    if (paramInt == -1)
    {
      if (this.nV) {
        break label104;
      }
      this.nV = true;
      paramInt = i;
    }
    for (;;)
    {
      if ((paramInt != 0) && (this.state == 4) && (this.oi != null))
      {
        View localView = (View)this.oi.get();
        if (localView != null) {
          localView.requestLayout();
        }
      }
      return;
      if ((this.nV) || (this.nU != paramInt))
      {
        this.nV = false;
        this.nU = Math.max(0, paramInt);
        this.oa = (this.oh - paramInt);
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
    if (this.state == paramInt) {
      return;
    }
    this.state = paramInt;
    if ((paramInt == 6) || (paramInt == 3)) {
      v(true);
    }
    for (;;)
    {
      View localView = (View)this.oi.get();
      if ((localView == null) || (this.ok == null)) {
        break;
      }
      this.ok.f(localView, paramInt);
      return;
      if ((paramInt == 5) || (paramInt == 4)) {
        v(false);
      }
    }
  }
  
  public final void a(a parama)
  {
    this.ok = parama;
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, V paramV, Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.a(paramCoordinatorLayout, paramV, paramParcelable.Pm);
    if ((paramParcelable.state == 1) || (paramParcelable.state == 2))
    {
      this.state = 4;
      return;
    }
    this.state = paramParcelable.state;
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt)
  {
    if (paramV.getTop() == ce()) {
      K(3);
    }
    while ((paramView != this.oj.get()) || (!this.og)) {
      return;
    }
    int i;
    if (this.of > 0)
    {
      i = ce();
      paramInt = 3;
      if (!this.od.h(paramV, paramV.getLeft(), i)) {
        break label336;
      }
      K(2);
      u.b(paramV, new b(paramV, paramInt));
    }
    for (;;)
    {
      this.og = false;
      return;
      if (this.ob)
      {
        if (this.ol == null) {}
        for (float f = 0.0F;; f = this.ol.getYVelocity(this.om))
        {
          if (!a(paramV, f)) {
            break label163;
          }
          i = this.oh;
          paramInt = 5;
          break;
          this.ol.computeCurrentVelocity(1000, this.nT);
        }
      }
      label163:
      if (this.of == 0)
      {
        paramInt = paramV.getTop();
        if (this.nS)
        {
          if (Math.abs(paramInt - this.nY) < Math.abs(paramInt - this.oa))
          {
            i = this.nY;
            paramInt = 3;
            break;
          }
          i = this.oa;
          paramInt = 4;
          break;
        }
        if (paramInt < this.nZ)
        {
          if (paramInt < Math.abs(paramInt - this.oa))
          {
            paramInt = 3;
            i = 0;
            break;
          }
          i = this.nZ;
          paramInt = 6;
          break;
        }
        if (Math.abs(paramInt - this.nZ) < Math.abs(paramInt - this.oa))
        {
          i = this.nZ;
          paramInt = 6;
          break;
        }
        i = this.oa;
        paramInt = 4;
        break;
      }
      i = this.oa;
      paramInt = 4;
      break;
      label336:
      K(paramInt);
    }
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    if (paramInt3 == 1) {}
    while (paramView != (View)this.oj.get()) {
      return;
    }
    paramInt1 = paramV.getTop();
    paramInt3 = paramInt1 - paramInt2;
    if (paramInt2 > 0) {
      if (paramInt3 < ce())
      {
        paramArrayOfInt[1] = (paramInt1 - ce());
        u.s(paramV, -paramArrayOfInt[1]);
        K(3);
      }
    }
    for (;;)
    {
      paramV.getTop();
      cf();
      this.of = paramInt2;
      this.og = true;
      return;
      paramArrayOfInt[1] = paramInt2;
      u.s(paramV, -paramInt2);
      K(1);
      continue;
      if ((paramInt2 < 0) && (!paramView.canScrollVertically(-1))) {
        if ((paramInt3 <= this.oa) || (this.ob))
        {
          paramArrayOfInt[1] = paramInt2;
          u.s(paramV, -paramInt2);
          K(1);
        }
        else
        {
          paramArrayOfInt[1] = (paramInt1 - this.oa);
          u.s(paramV, -paramArrayOfInt[1]);
          K(4);
        }
      }
    }
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    if ((u.aq(paramCoordinatorLayout)) && (!u.aq(paramV))) {
      paramV.setFitsSystemWindows(true);
    }
    int i = paramV.getTop();
    paramCoordinatorLayout.g(paramV, paramInt);
    this.oh = paramCoordinatorLayout.getHeight();
    if (this.nV)
    {
      if (this.nW == 0) {
        this.nW = paramCoordinatorLayout.getResources().getDimensionPixelSize(2131166146);
      }
      this.nX = Math.max(this.nW, this.oh - paramCoordinatorLayout.getWidth() * 9 / 16);
      this.nY = Math.max(0, this.oh - paramV.getHeight());
      this.nZ = (this.oh / 2);
      cd();
      if (this.state != 3) {
        break label200;
      }
      u.s(paramV, ce());
    }
    for (;;)
    {
      if (this.od == null) {
        this.od = t.a(paramCoordinatorLayout, this.or);
      }
      this.oi = new WeakReference(paramV);
      this.oj = new WeakReference(k(paramV));
      return true;
      this.nX = this.nU;
      break;
      label200:
      if (this.state == 6) {
        u.s(paramV, this.nZ);
      } else if ((this.ob) && (this.state == 5)) {
        u.s(paramV, this.oh);
      } else if (this.state == 4) {
        u.s(paramV, this.oa);
      } else if ((this.state == 1) || (this.state == 2)) {
        u.s(paramV, i - paramV.getTop());
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
      if (this.od != null) {
        this.od.k(paramMotionEvent);
      }
      if (i == 0) {
        reset();
      }
      if (this.ol == null) {
        this.ol = VelocityTracker.obtain();
      }
      this.ol.addMovement(paramMotionEvent);
      if ((i == 2) && (!this.oe) && (Math.abs(this.oo - paramMotionEvent.getY()) > this.od.mTouchSlop)) {
        this.od.y(paramV, paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
      }
    } while (this.oe);
    return true;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2)
  {
    return (paramView == this.oj.get()) && ((this.state != 3) || (super.a(paramCoordinatorLayout, paramV, paramView, paramFloat1, paramFloat2)));
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    this.of = 0;
    this.og = false;
    if ((paramInt1 & 0x2) != 0) {
      bool = true;
    }
    return bool;
  }
  
  final boolean a(View paramView, float paramFloat)
  {
    if (this.oc) {}
    do
    {
      return true;
      if (paramView.getTop() < this.oa) {
        return false;
      }
    } while (Math.abs(paramView.getTop() + 0.1F * paramFloat - this.oa) / this.nU > 0.5F);
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
      i = this.oa;
      j = paramInt;
    }
    while (this.od.h(paramView, paramView.getLeft(), i))
    {
      K(2);
      u.b(paramView, new b(paramView, j));
      return;
      if (paramInt == 6)
      {
        int k = this.nZ;
        i = k;
        j = paramInt;
        if (this.nS)
        {
          i = k;
          j = paramInt;
          if (k <= this.nY)
          {
            i = this.nY;
            j = 3;
          }
        }
      }
      else if (paramInt == 3)
      {
        i = ce();
        j = paramInt;
      }
      else if ((this.ob) && (paramInt == 5))
      {
        i = this.oh;
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
      this.oe = true;
    }
    for (;;)
    {
      return false;
      int i = paramMotionEvent.getActionMasked();
      if (i == 0) {
        reset();
      }
      if (this.ol == null) {
        this.ol = VelocityTracker.obtain();
      }
      this.ol.addMovement(paramMotionEvent);
      switch (i)
      {
      }
      while ((!this.oe) && (this.od != null) && (this.od.j(paramMotionEvent)))
      {
        return true;
        this.oq = false;
        this.om = -1;
        if (this.oe)
        {
          this.oe = false;
          return false;
          int j = (int)paramMotionEvent.getX();
          this.oo = ((int)paramMotionEvent.getY());
          View localView;
          if (this.oj != null)
          {
            localView = (View)this.oj.get();
            label170:
            if ((localView != null) && (paramCoordinatorLayout.d(localView, j, this.oo)))
            {
              this.om = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
              this.oq = true;
            }
            if ((this.om != -1) || (paramCoordinatorLayout.d(paramV, j, this.oo))) {
              break label247;
            }
          }
          label247:
          for (boolean bool = true;; bool = false)
          {
            this.oe = bool;
            break;
            localView = null;
            break label170;
          }
        }
      }
      if (this.oj != null) {}
      for (paramV = (View)this.oj.get(); (i == 2) && (paramV != null) && (!this.oe) && (this.state != 1) && (!paramCoordinatorLayout.d(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) && (this.od != null) && (Math.abs(this.oo - paramMotionEvent.getY()) > this.od.mTouchSlop); paramV = null) {
        return true;
      }
    }
  }
  
  final void cf()
  {
    View localView = (View)this.oi.get();
    if ((localView != null) && (this.ok != null)) {
      this.ok.m(localView);
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
        if (this.oi != null) {
          break;
        }
      } while ((paramInt != 4) && (paramInt != 3) && (paramInt != 6) && ((!this.ob) || (paramInt != 5)));
      this.state = paramInt;
      return;
      localView = (View)this.oi.get();
    } while (localView == null);
    ViewParent localViewParent = localView.getParent();
    if ((localViewParent != null) && (localViewParent.isLayoutRequested()) && (u.aD(localView)))
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
    this.ob = paramBoolean;
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
    public abstract void f(View paramView, int paramInt);
    
    public abstract void m(View paramView);
  }
  
  final class b
    implements Runnable
  {
    private final int ov;
    private final View view;
    
    b(View paramView, int paramInt)
    {
      this.view = paramView;
      this.ov = paramInt;
    }
    
    public final void run()
    {
      if ((BottomSheetBehavior.this.od != null) && (BottomSheetBehavior.this.od.go()))
      {
        u.b(this.view, this);
        return;
      }
      BottomSheetBehavior.this.K(this.ov);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.BottomSheetBehavior
 * JD-Core Version:    0.7.0.1
 */