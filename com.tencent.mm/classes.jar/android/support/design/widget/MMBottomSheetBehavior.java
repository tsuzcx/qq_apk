package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
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
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;

public class MMBottomSheetBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  int mActivePointerId;
  int mState = 4;
  private VelocityTracker mVelocityTracker;
  WeakReference<V> mViewRef;
  private float qI;
  private int qJ;
  private boolean qK;
  private int qL;
  int qM;
  int qN;
  boolean qO;
  private boolean qP;
  android.support.v4.widget.t qQ;
  private boolean qR;
  private int qS;
  private boolean qT;
  int qU;
  WeakReference<View> qV;
  private MMBottomSheetBehavior.a qW;
  private boolean qX;
  private boolean qY;
  private int qZ;
  private int ra;
  boolean rb;
  private boolean rc = false;
  private final t.a rd = new t.a()
  {
    public final void M(int paramAnonymousInt)
    {
      if (paramAnonymousInt == 1) {
        MMBottomSheetBehavior.this.K(1);
      }
    }
    
    public final void a(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      int j = 3;
      int i;
      if (paramAnonymousFloat2 < 0.0F) {
        i = MMBottomSheetBehavior.this.qM;
      }
      while (MMBottomSheetBehavior.this.qQ.A(paramAnonymousView.getLeft(), i))
      {
        MMBottomSheetBehavior.this.K(2);
        android.support.v4.view.t.b(paramAnonymousView, new MMBottomSheetBehavior.c(MMBottomSheetBehavior.this, paramAnonymousView, j));
        return;
        if ((MMBottomSheetBehavior.this.qO) && (MMBottomSheetBehavior.this.a(paramAnonymousView, paramAnonymousFloat2)))
        {
          i = MMBottomSheetBehavior.this.qU;
          j = 5;
        }
        else if (paramAnonymousFloat2 == 0.0F)
        {
          i = paramAnonymousView.getTop();
          if (Math.abs(i - MMBottomSheetBehavior.this.qM) < Math.abs(i - MMBottomSheetBehavior.this.qN))
          {
            i = MMBottomSheetBehavior.this.qM;
          }
          else
          {
            i = MMBottomSheetBehavior.this.qN;
            j = 4;
          }
        }
        else
        {
          i = MMBottomSheetBehavior.this.qN;
          j = 4;
        }
      }
      MMBottomSheetBehavior.this.K(j);
    }
    
    public final void b(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      MMBottomSheetBehavior.this.L(paramAnonymousInt2);
    }
    
    public final int bO()
    {
      if (MMBottomSheetBehavior.this.qO) {
        return MMBottomSheetBehavior.this.qU - MMBottomSheetBehavior.this.qM;
      }
      return MMBottomSheetBehavior.this.qN - MMBottomSheetBehavior.this.qM;
    }
    
    public final boolean c(View paramAnonymousView, int paramAnonymousInt)
    {
      if (MMBottomSheetBehavior.this.mState == 1) {
        return false;
      }
      if (MMBottomSheetBehavior.this.rb) {
        return false;
      }
      if ((MMBottomSheetBehavior.this.mState == 3) && (MMBottomSheetBehavior.this.mActivePointerId == paramAnonymousInt))
      {
        View localView = (View)MMBottomSheetBehavior.this.qV.get();
        if ((localView != null) && (localView.canScrollVertically(-1))) {
          return false;
        }
      }
      return (MMBottomSheetBehavior.this.mViewRef != null) && (MMBottomSheetBehavior.this.mViewRef.get() == paramAnonymousView);
    }
    
    public final int d(View paramAnonymousView, int paramAnonymousInt)
    {
      int j = MMBottomSheetBehavior.this.qM;
      if (MMBottomSheetBehavior.this.qO) {}
      for (int i = MMBottomSheetBehavior.this.qU;; i = MMBottomSheetBehavior.this.qN) {
        return a.clamp(paramAnonymousInt, j, i);
      }
    }
    
    public final int e(View paramAnonymousView, int paramAnonymousInt)
    {
      return paramAnonymousView.getLeft();
    }
  };
  private MMBottomSheetBehavior.b re;
  
  public MMBottomSheetBehavior() {}
  
  public MMBottomSheetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.BottomSheetBehavior_Layout);
    TypedValue localTypedValue = paramAttributeSet.peekValue(2);
    if ((localTypedValue != null) && (localTypedValue.data == -1)) {
      J(localTypedValue.data);
    }
    for (;;)
    {
      this.qO = paramAttributeSet.getBoolean(1, false);
      this.qP = paramAttributeSet.getBoolean(3, false);
      paramAttributeSet.recycle();
      this.qI = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
      return;
      J(paramAttributeSet.getDimensionPixelSize(2, -1));
    }
  }
  
  private void J(int paramInt)
  {
    int i = 1;
    if (paramInt == -1)
    {
      if (this.qK) {
        break label104;
      }
      this.qK = true;
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
      if ((this.qK) || (this.qJ != paramInt))
      {
        this.qK = false;
        this.qJ = Math.max(0, paramInt);
        this.qN = (this.qU - paramInt);
        paramInt = i;
      }
      else
      {
        label104:
        paramInt = 0;
      }
    }
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
  
  private void reset()
  {
    this.mActivePointerId = -1;
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  public static <V extends View> MMBottomSheetBehavior<V> w(V paramV)
  {
    paramV = paramV.getLayoutParams();
    if (!(paramV instanceof CoordinatorLayout.d)) {
      throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }
    paramV = ((CoordinatorLayout.d)paramV).oH;
    if (!(paramV instanceof MMBottomSheetBehavior)) {
      throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }
    return (MMBottomSheetBehavior)paramV;
  }
  
  public final boolean B(int paramInt)
  {
    boolean bool = false;
    this.qS = 0;
    this.qT = false;
    if ((paramInt & 0x2) != 0) {
      bool = true;
    }
    return bool;
  }
  
  final void K(int paramInt)
  {
    if (this.mState == paramInt) {}
    View localView;
    do
    {
      return;
      this.mState = paramInt;
      localView = (View)this.mViewRef.get();
    } while ((localView == null) || (this.qW == null));
    this.qW.k(localView, paramInt);
  }
  
  final void L(int paramInt)
  {
    View localView = (View)this.mViewRef.get();
    if ((localView != null) && (this.qW != null))
    {
      if (paramInt > this.qN) {
        this.qW.b(localView, (this.qN - paramInt) / (this.qU - this.qN));
      }
    }
    else {
      return;
    }
    this.qW.b(localView, (this.qN - paramInt) / (this.qN - this.qM));
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, V paramV, Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.a(paramCoordinatorLayout, paramV, paramParcelable.Nj);
    if ((paramParcelable.state == 1) || (paramParcelable.state == 2))
    {
      this.mState = 4;
      return;
    }
    this.mState = paramParcelable.state;
  }
  
  public final void a(MMBottomSheetBehavior.a parama)
  {
    this.qW = parama;
  }
  
  public final void a(MMBottomSheetBehavior.b paramb)
  {
    this.re = paramb;
  }
  
  public final void a(V paramV, View paramView, int paramInt, int[] paramArrayOfInt)
  {
    if (paramView != (View)this.qV.get()) {
      return;
    }
    int i = paramV.getTop();
    int j = i - paramInt;
    if (paramInt > 0) {
      if (j < this.qM)
      {
        paramArrayOfInt[1] = (i - this.qM);
        android.support.v4.view.t.s(paramV, -paramArrayOfInt[1]);
        K(3);
      }
    }
    for (;;)
    {
      L(paramV.getTop());
      this.qS = paramInt;
      this.qT = true;
      return;
      paramArrayOfInt[1] = paramInt;
      android.support.v4.view.t.s(paramV, -paramInt);
      K(1);
      continue;
      if ((paramInt < 0) && (!paramView.canScrollVertically(-1))) {
        if ((j <= this.qN) || (this.qO))
        {
          paramArrayOfInt[1] = paramInt;
          android.support.v4.view.t.s(paramV, -paramInt);
          K(1);
        }
        else
        {
          paramArrayOfInt[1] = (i - this.qN);
          android.support.v4.view.t.s(paramV, -paramArrayOfInt[1]);
          K(4);
        }
      }
    }
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    if ((android.support.v4.view.t.aq(paramCoordinatorLayout)) && (!android.support.v4.view.t.aq(paramV))) {
      android.support.v4.view.t.e(paramV, true);
    }
    int i = paramV.getTop();
    paramCoordinatorLayout.f(paramV, paramInt);
    this.qU = paramCoordinatorLayout.getHeight();
    if (this.qK)
    {
      if (this.qL == 0) {
        this.qL = paramCoordinatorLayout.getResources().getDimensionPixelSize(2131166105);
      }
      paramInt = Math.max(this.qL, this.qU - paramCoordinatorLayout.getWidth() * 9 / 16);
      this.qM = Math.max(0, this.qU - paramV.getHeight());
      this.qN = Math.max(this.qU - paramInt, this.qM);
      if (this.mState != 3) {
        break label197;
      }
      android.support.v4.view.t.s(paramV, this.qM);
    }
    for (;;)
    {
      if (this.qQ == null) {
        this.qQ = android.support.v4.widget.t.a(paramCoordinatorLayout, this.rd);
      }
      this.mViewRef = new WeakReference(paramV);
      this.qV = new WeakReference(k(paramV));
      return true;
      paramInt = this.qJ;
      break;
      label197:
      if ((this.qO) && (this.mState == 5)) {
        android.support.v4.view.t.s(paramV, this.qU);
      } else if (this.mState == 4) {
        android.support.v4.view.t.s(paramV, this.qN);
      } else if ((this.mState == 1) || (this.mState == 2)) {
        android.support.v4.view.t.s(paramV, i - paramV.getTop());
      }
    }
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    ac.d("microMsg.MMBottomSheetBehavior", "onTouchEvent action: %d, x: %f, y: %f, rawX: %f, rawY: %f.", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()) });
    if (!paramV.isShown()) {}
    do
    {
      return false;
      int i = paramMotionEvent.getActionMasked();
      if ((this.mState == 1) && (i == 0)) {
        return true;
      }
      if (this.qQ != null) {
        this.qQ.h(paramMotionEvent);
      }
      if (i == 0) {
        reset();
      }
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      this.mVelocityTracker.addMovement(paramMotionEvent);
      if ((i == 2) && (!this.qR) && (Math.abs(this.ra - paramMotionEvent.getY()) > this.qQ.mTouchSlop)) {
        this.qQ.y(paramV, paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
      }
    } while (this.qR);
    return true;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2)
  {
    return (paramView == this.qV.get()) && ((this.mState != 3) || (super.a(paramCoordinatorLayout, paramV, paramView, paramFloat1, paramFloat2)));
  }
  
  final boolean a(View paramView, float paramFloat)
  {
    if (this.qP) {}
    do
    {
      return true;
      if (paramView.getTop() < this.qN) {
        return false;
      }
    } while (Math.abs(paramView.getTop() + 0.1F * paramFloat - this.qN) / this.qJ > 0.5F);
    return false;
  }
  
  public final Parcelable b(CoordinatorLayout paramCoordinatorLayout, V paramV)
  {
    return new SavedState(super.b(paramCoordinatorLayout, paramV), this.mState);
  }
  
  final void b(View paramView, int paramInt)
  {
    int i;
    if (paramInt == 4) {
      i = this.qN;
    }
    while (this.qQ.h(paramView, paramView.getLeft(), i))
    {
      K(2);
      android.support.v4.view.t.b(paramView, new c(paramView, paramInt));
      return;
      if (paramInt == 3) {
        i = this.qM;
      } else if ((this.qO) && (paramInt == 5)) {
        i = this.qU;
      } else {
        throw new IllegalArgumentException("Illegal state argument: ".concat(String.valueOf(paramInt)));
      }
    }
    K(paramInt);
  }
  
  public final void b(V paramV, View paramView)
  {
    int j = 3;
    if (paramV.getTop() == this.qM) {
      K(3);
    }
    while ((this.qV == null) || (paramView != this.qV.get()) || (!this.qT)) {
      return;
    }
    int i;
    if (this.qS > 0)
    {
      i = this.qM;
      if (!this.qQ.h(paramV, paramV.getLeft(), i)) {
        break label213;
      }
      K(2);
      android.support.v4.view.t.b(paramV, new c(paramV, j));
    }
    for (;;)
    {
      this.qT = false;
      return;
      if (this.qO)
      {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.qI);
        if (a(paramV, this.mVelocityTracker.getYVelocity(this.mActivePointerId)))
        {
          i = this.qU;
          j = 5;
          break;
        }
      }
      if (this.qS == 0)
      {
        i = paramV.getTop();
        if (Math.abs(i - this.qM) < Math.abs(i - this.qN))
        {
          i = this.qM;
          break;
        }
        i = this.qN;
        j = 4;
        break;
      }
      i = this.qN;
      j = 4;
      break;
      label213:
      K(j);
    }
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    ac.d("microMsg.MMBottomSheetBehavior", "onInterceptTouchEvent action: %d, x: %f, y: %f, rawX: %f, rawY: %f.", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()) });
    if (paramMotionEvent.getAction() == 0) {
      this.rc = false;
    }
    if (this.rc) {
      ac.d("microMsg.MMBottomSheetBehavior", "external deal with, continue.");
    }
    int i;
    label310:
    label469:
    do
    {
      return false;
      if ((this.re != null) && (this.re.onInterceptTouchEvent(paramMotionEvent)))
      {
        ac.d("microMsg.MMBottomSheetBehavior", "external deal with.");
        this.rc = true;
        return false;
      }
      if (!paramV.isShown())
      {
        this.qR = true;
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
      while ((!this.qR) && (this.qQ.g(paramMotionEvent)) && (this.qY))
      {
        return true;
        this.rb = false;
        this.mActivePointerId = -1;
        if (this.qR)
        {
          this.qR = false;
          return false;
          this.qX = false;
          this.qY = false;
          this.qZ = ((int)paramMotionEvent.getX());
          this.ra = ((int)paramMotionEvent.getY());
          View localView;
          if (this.qV != null)
          {
            localView = (View)this.qV.get();
            if ((localView != null) && (paramCoordinatorLayout.d(localView, this.qZ, this.ra)))
            {
              this.mActivePointerId = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
              this.rb = true;
            }
            if ((this.mActivePointerId != -1) || (paramCoordinatorLayout.d(paramV, this.qZ, this.ra))) {
              break label391;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            this.qR = bool;
            break;
            localView = null;
            break label310;
          }
          int k = (int)paramMotionEvent.getX();
          int j = (int)paramMotionEvent.getY();
          k -= this.qZ;
          j -= this.ra;
          if (!this.qX)
          {
            if ((Math.abs(k) > this.qQ.mTouchSlop) || (Math.abs(j) > this.qQ.mTouchSlop))
            {
              bool = true;
              this.qX = bool;
            }
          }
          else
          {
            if (!this.qX) {
              continue;
            }
            if (Math.abs(j) <= Math.abs(k)) {
              break label513;
            }
          }
          for (bool = true;; bool = false)
          {
            this.qY = bool;
            break;
            bool = false;
            break label469;
          }
        }
      }
      paramV = (View)this.qV.get();
    } while ((i != 2) || (paramV == null) || (this.qR) || (this.mState == 1) || (paramCoordinatorLayout.d(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) || (Math.abs(this.ra - paramMotionEvent.getY()) <= this.qQ.mTouchSlop) || (!this.qY));
    label391:
    return true;
  }
  
  public final void cC()
  {
    if (3 == this.mState) {}
    final View localView;
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
    if ((localViewParent != null) && (localViewParent.isLayoutRequested()) && (android.support.v4.view.t.aC(localView)))
    {
      localView.post(new Runnable()
      {
        public final void run()
        {
          MMBottomSheetBehavior.this.b(localView, this.rf);
        }
      });
      return;
    }
    b(localView, 3);
  }
  
  public final int getState()
  {
    return this.mState;
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
    private final View mView;
    private final int rh;
    
    c(View paramView, int paramInt)
    {
      this.mView = paramView;
      this.rh = paramInt;
    }
    
    public final void run()
    {
      if ((MMBottomSheetBehavior.this.qQ != null) && (MMBottomSheetBehavior.this.qQ.fP()))
      {
        android.support.v4.view.t.b(this.mView, this);
        return;
      }
      MMBottomSheetBehavior.this.K(this.rh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.widget.MMBottomSheetBehavior
 * JD-Core Version:    0.7.0.1
 */