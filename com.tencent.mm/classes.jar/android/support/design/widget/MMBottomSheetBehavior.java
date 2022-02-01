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
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

public class MMBottomSheetBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  int mActivePointerId;
  int mState = 4;
  private VelocityTracker mVelocityTracker;
  WeakReference<V> mViewRef;
  private float pI;
  private int pJ;
  private boolean pK;
  private int pL;
  int pM;
  int pN;
  boolean pO;
  private boolean pP;
  android.support.v4.widget.t pQ;
  private boolean pR;
  private int pS;
  private boolean pT;
  int pU;
  WeakReference<View> pV;
  private MMBottomSheetBehavior.a pW;
  private boolean pX;
  private boolean pY;
  private int pZ;
  private int qa;
  boolean qb;
  private boolean qc = false;
  private final t.a qd = new t.a()
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
        i = MMBottomSheetBehavior.this.pM;
      }
      while (MMBottomSheetBehavior.this.pQ.A(paramAnonymousView.getLeft(), i))
      {
        MMBottomSheetBehavior.this.K(2);
        android.support.v4.view.t.b(paramAnonymousView, new MMBottomSheetBehavior.c(MMBottomSheetBehavior.this, paramAnonymousView, j));
        return;
        if ((MMBottomSheetBehavior.this.pO) && (MMBottomSheetBehavior.this.a(paramAnonymousView, paramAnonymousFloat2)))
        {
          i = MMBottomSheetBehavior.this.pU;
          j = 5;
        }
        else if (paramAnonymousFloat2 == 0.0F)
        {
          i = paramAnonymousView.getTop();
          if (Math.abs(i - MMBottomSheetBehavior.this.pM) < Math.abs(i - MMBottomSheetBehavior.this.pN))
          {
            i = MMBottomSheetBehavior.this.pM;
          }
          else
          {
            i = MMBottomSheetBehavior.this.pN;
            j = 4;
          }
        }
        else
        {
          i = MMBottomSheetBehavior.this.pN;
          j = 4;
        }
      }
      MMBottomSheetBehavior.this.K(j);
    }
    
    public final void b(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      MMBottomSheetBehavior.this.L(paramAnonymousInt2);
    }
    
    public final int bH()
    {
      if (MMBottomSheetBehavior.this.pO) {
        return MMBottomSheetBehavior.this.pU - MMBottomSheetBehavior.this.pM;
      }
      return MMBottomSheetBehavior.this.pN - MMBottomSheetBehavior.this.pM;
    }
    
    public final boolean c(View paramAnonymousView, int paramAnonymousInt)
    {
      if (MMBottomSheetBehavior.this.mState == 1) {
        return false;
      }
      if (MMBottomSheetBehavior.this.qb) {
        return false;
      }
      if ((MMBottomSheetBehavior.this.mState == 3) && (MMBottomSheetBehavior.this.mActivePointerId == paramAnonymousInt))
      {
        View localView = (View)MMBottomSheetBehavior.this.pV.get();
        if ((localView != null) && (localView.canScrollVertically(-1))) {
          return false;
        }
      }
      return (MMBottomSheetBehavior.this.mViewRef != null) && (MMBottomSheetBehavior.this.mViewRef.get() == paramAnonymousView);
    }
    
    public final int d(View paramAnonymousView, int paramAnonymousInt)
    {
      int j = MMBottomSheetBehavior.this.pM;
      if (MMBottomSheetBehavior.this.pO) {}
      for (int i = MMBottomSheetBehavior.this.pU;; i = MMBottomSheetBehavior.this.pN) {
        return a.clamp(paramAnonymousInt, j, i);
      }
    }
    
    public final int e(View paramAnonymousView, int paramAnonymousInt)
    {
      return paramAnonymousView.getLeft();
    }
  };
  private MMBottomSheetBehavior.b qe;
  
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
      this.pO = paramAttributeSet.getBoolean(1, false);
      this.pP = paramAttributeSet.getBoolean(3, false);
      paramAttributeSet.recycle();
      this.pI = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
      return;
      J(paramAttributeSet.getDimensionPixelSize(2, -1));
    }
  }
  
  private void J(int paramInt)
  {
    int i = 1;
    if (paramInt == -1)
    {
      if (this.pK) {
        break label104;
      }
      this.pK = true;
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
      if ((this.pK) || (this.pJ != paramInt))
      {
        this.pK = false;
        this.pJ = Math.max(0, paramInt);
        this.pN = (this.pU - paramInt);
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
    paramV = ((CoordinatorLayout.d)paramV).nG;
    if (!(paramV instanceof MMBottomSheetBehavior)) {
      throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }
    return (MMBottomSheetBehavior)paramV;
  }
  
  public final boolean B(int paramInt)
  {
    boolean bool = false;
    this.pS = 0;
    this.pT = false;
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
    } while ((localView == null) || (this.pW == null));
    this.pW.k(localView, paramInt);
  }
  
  final void L(int paramInt)
  {
    View localView = (View)this.mViewRef.get();
    if ((localView != null) && (this.pW != null))
    {
      if (paramInt > this.pN) {
        this.pW.b(localView, (this.pN - paramInt) / (this.pU - this.pN));
      }
    }
    else {
      return;
    }
    this.pW.b(localView, (this.pN - paramInt) / (this.pN - this.pM));
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, V paramV, Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.a(paramCoordinatorLayout, paramV, paramParcelable.Mm);
    if ((paramParcelable.state == 1) || (paramParcelable.state == 2))
    {
      this.mState = 4;
      return;
    }
    this.mState = paramParcelable.state;
  }
  
  public final void a(MMBottomSheetBehavior.a parama)
  {
    this.pW = parama;
  }
  
  public final void a(MMBottomSheetBehavior.b paramb)
  {
    this.qe = paramb;
  }
  
  public final void a(V paramV, View paramView, int paramInt, int[] paramArrayOfInt)
  {
    if (paramView != (View)this.pV.get()) {
      return;
    }
    int i = paramV.getTop();
    int j = i - paramInt;
    if (paramInt > 0) {
      if (j < this.pM)
      {
        paramArrayOfInt[1] = (i - this.pM);
        android.support.v4.view.t.s(paramV, -paramArrayOfInt[1]);
        K(3);
      }
    }
    for (;;)
    {
      L(paramV.getTop());
      this.pS = paramInt;
      this.pT = true;
      return;
      paramArrayOfInt[1] = paramInt;
      android.support.v4.view.t.s(paramV, -paramInt);
      K(1);
      continue;
      if ((paramInt < 0) && (!paramView.canScrollVertically(-1))) {
        if ((j <= this.pN) || (this.pO))
        {
          paramArrayOfInt[1] = paramInt;
          android.support.v4.view.t.s(paramV, -paramInt);
          K(1);
        }
        else
        {
          paramArrayOfInt[1] = (i - this.pN);
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
    this.pU = paramCoordinatorLayout.getHeight();
    if (this.pK)
    {
      if (this.pL == 0) {
        this.pL = paramCoordinatorLayout.getResources().getDimensionPixelSize(2131166105);
      }
      paramInt = Math.max(this.pL, this.pU - paramCoordinatorLayout.getWidth() * 9 / 16);
      this.pM = Math.max(0, this.pU - paramV.getHeight());
      this.pN = Math.max(this.pU - paramInt, this.pM);
      if (this.mState != 3) {
        break label197;
      }
      android.support.v4.view.t.s(paramV, this.pM);
    }
    for (;;)
    {
      if (this.pQ == null) {
        this.pQ = android.support.v4.widget.t.a(paramCoordinatorLayout, this.qd);
      }
      this.mViewRef = new WeakReference(paramV);
      this.pV = new WeakReference(k(paramV));
      return true;
      paramInt = this.pJ;
      break;
      label197:
      if ((this.pO) && (this.mState == 5)) {
        android.support.v4.view.t.s(paramV, this.pU);
      } else if (this.mState == 4) {
        android.support.v4.view.t.s(paramV, this.pN);
      } else if ((this.mState == 1) || (this.mState == 2)) {
        android.support.v4.view.t.s(paramV, i - paramV.getTop());
      }
    }
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    ad.d("microMsg.MMBottomSheetBehavior", "onTouchEvent action: %d, x: %f, y: %f, rawX: %f, rawY: %f.", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()) });
    if (!paramV.isShown()) {}
    do
    {
      return false;
      int i = paramMotionEvent.getActionMasked();
      if ((this.mState == 1) && (i == 0)) {
        return true;
      }
      if (this.pQ != null) {
        this.pQ.h(paramMotionEvent);
      }
      if (i == 0) {
        reset();
      }
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      this.mVelocityTracker.addMovement(paramMotionEvent);
      if ((i == 2) && (!this.pR) && (Math.abs(this.qa - paramMotionEvent.getY()) > this.pQ.mTouchSlop)) {
        this.pQ.y(paramV, paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
      }
    } while (this.pR);
    return true;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2)
  {
    return (paramView == this.pV.get()) && ((this.mState != 3) || (super.a(paramCoordinatorLayout, paramV, paramView, paramFloat1, paramFloat2)));
  }
  
  final boolean a(View paramView, float paramFloat)
  {
    if (this.pP) {}
    do
    {
      return true;
      if (paramView.getTop() < this.pN) {
        return false;
      }
    } while (Math.abs(paramView.getTop() + 0.1F * paramFloat - this.pN) / this.pJ > 0.5F);
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
      i = this.pN;
    }
    while (this.pQ.h(paramView, paramView.getLeft(), i))
    {
      K(2);
      android.support.v4.view.t.b(paramView, new c(paramView, paramInt));
      return;
      if (paramInt == 3) {
        i = this.pM;
      } else if ((this.pO) && (paramInt == 5)) {
        i = this.pU;
      } else {
        throw new IllegalArgumentException("Illegal state argument: ".concat(String.valueOf(paramInt)));
      }
    }
    K(paramInt);
  }
  
  public final void b(V paramV, View paramView)
  {
    int j = 3;
    if (paramV.getTop() == this.pM) {
      K(3);
    }
    while ((this.pV == null) || (paramView != this.pV.get()) || (!this.pT)) {
      return;
    }
    int i;
    if (this.pS > 0)
    {
      i = this.pM;
      if (!this.pQ.h(paramV, paramV.getLeft(), i)) {
        break label213;
      }
      K(2);
      android.support.v4.view.t.b(paramV, new c(paramV, j));
    }
    for (;;)
    {
      this.pT = false;
      return;
      if (this.pO)
      {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.pI);
        if (a(paramV, this.mVelocityTracker.getYVelocity(this.mActivePointerId)))
        {
          i = this.pU;
          j = 5;
          break;
        }
      }
      if (this.pS == 0)
      {
        i = paramV.getTop();
        if (Math.abs(i - this.pM) < Math.abs(i - this.pN))
        {
          i = this.pM;
          break;
        }
        i = this.pN;
        j = 4;
        break;
      }
      i = this.pN;
      j = 4;
      break;
      label213:
      K(j);
    }
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    ad.d("microMsg.MMBottomSheetBehavior", "onInterceptTouchEvent action: %d, x: %f, y: %f, rawX: %f, rawY: %f.", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()) });
    if (paramMotionEvent.getAction() == 0) {
      this.qc = false;
    }
    if (this.qc) {
      ad.d("microMsg.MMBottomSheetBehavior", "external deal with, continue.");
    }
    int i;
    label310:
    label469:
    do
    {
      return false;
      if ((this.qe != null) && (this.qe.onInterceptTouchEvent(paramMotionEvent)))
      {
        ad.d("microMsg.MMBottomSheetBehavior", "external deal with.");
        this.qc = true;
        return false;
      }
      if (!paramV.isShown())
      {
        this.pR = true;
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
      while ((!this.pR) && (this.pQ.g(paramMotionEvent)) && (this.pY))
      {
        return true;
        this.qb = false;
        this.mActivePointerId = -1;
        if (this.pR)
        {
          this.pR = false;
          return false;
          this.pX = false;
          this.pY = false;
          this.pZ = ((int)paramMotionEvent.getX());
          this.qa = ((int)paramMotionEvent.getY());
          View localView;
          if (this.pV != null)
          {
            localView = (View)this.pV.get();
            if ((localView != null) && (paramCoordinatorLayout.d(localView, this.pZ, this.qa)))
            {
              this.mActivePointerId = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
              this.qb = true;
            }
            if ((this.mActivePointerId != -1) || (paramCoordinatorLayout.d(paramV, this.pZ, this.qa))) {
              break label391;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            this.pR = bool;
            break;
            localView = null;
            break label310;
          }
          int k = (int)paramMotionEvent.getX();
          int j = (int)paramMotionEvent.getY();
          k -= this.pZ;
          j -= this.qa;
          if (!this.pX)
          {
            if ((Math.abs(k) > this.pQ.mTouchSlop) || (Math.abs(j) > this.pQ.mTouchSlop))
            {
              bool = true;
              this.pX = bool;
            }
          }
          else
          {
            if (!this.pX) {
              continue;
            }
            if (Math.abs(j) <= Math.abs(k)) {
              break label513;
            }
          }
          for (bool = true;; bool = false)
          {
            this.pY = bool;
            break;
            bool = false;
            break label469;
          }
        }
      }
      paramV = (View)this.pV.get();
    } while ((i != 2) || (paramV == null) || (this.pR) || (this.mState == 1) || (paramCoordinatorLayout.d(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) || (Math.abs(this.qa - paramMotionEvent.getY()) <= this.pQ.mTouchSlop) || (!this.pY));
    label391:
    return true;
  }
  
  public final void cv()
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
          MMBottomSheetBehavior.this.b(localView, this.qf);
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
    private final int qh;
    
    c(View paramView, int paramInt)
    {
      this.mView = paramView;
      this.qh = paramInt;
    }
    
    public final void run()
    {
      if ((MMBottomSheetBehavior.this.pQ != null) && (MMBottomSheetBehavior.this.pQ.fH()))
      {
        android.support.v4.view.t.b(this.mView, this);
        return;
      }
      MMBottomSheetBehavior.this.K(this.qh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.MMBottomSheetBehavior
 * JD-Core Version:    0.7.0.1
 */