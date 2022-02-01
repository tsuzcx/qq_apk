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
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public class MMBottomSheetBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  int mActivePointerId;
  int mState = 4;
  private VelocityTracker mVelocityTracker;
  WeakReference<V> mViewRef;
  private float sH;
  private int sI;
  private boolean sJ;
  private int sK;
  int sL;
  int sM;
  boolean sN;
  private boolean sO;
  t sP;
  private boolean sQ;
  private int sR;
  private boolean sS;
  int sT;
  WeakReference<View> sU;
  private MMBottomSheetBehavior.a sV;
  private boolean sW;
  private boolean sX;
  private int sY;
  private int sZ;
  boolean ta;
  private boolean tb = false;
  private final t.a tc = new t.a()
  {
    public final void L(int paramAnonymousInt)
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
        i = MMBottomSheetBehavior.this.sL;
      }
      while (MMBottomSheetBehavior.this.sP.H(paramAnonymousView.getLeft(), i))
      {
        MMBottomSheetBehavior.this.K(2);
        u.b(paramAnonymousView, new MMBottomSheetBehavior.c(MMBottomSheetBehavior.this, paramAnonymousView, j));
        return;
        if ((MMBottomSheetBehavior.this.sN) && (MMBottomSheetBehavior.this.a(paramAnonymousView, paramAnonymousFloat2)))
        {
          i = MMBottomSheetBehavior.this.sT;
          j = 5;
        }
        else if (paramAnonymousFloat2 == 0.0F)
        {
          i = paramAnonymousView.getTop();
          if (Math.abs(i - MMBottomSheetBehavior.this.sL) < Math.abs(i - MMBottomSheetBehavior.this.sM))
          {
            i = MMBottomSheetBehavior.this.sL;
          }
          else
          {
            i = MMBottomSheetBehavior.this.sM;
            j = 4;
          }
        }
        else
        {
          i = MMBottomSheetBehavior.this.sM;
          j = 4;
        }
      }
      MMBottomSheetBehavior.this.K(j);
    }
    
    public final void b(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      MMBottomSheetBehavior.this.Z(paramAnonymousInt2);
    }
    
    public final boolean c(View paramAnonymousView, int paramAnonymousInt)
    {
      if (MMBottomSheetBehavior.this.mState == 1) {
        return false;
      }
      if (MMBottomSheetBehavior.this.ta) {
        return false;
      }
      if ((MMBottomSheetBehavior.this.mState == 3) && (MMBottomSheetBehavior.this.mActivePointerId == paramAnonymousInt))
      {
        View localView = (View)MMBottomSheetBehavior.this.sU.get();
        if ((localView != null) && (localView.canScrollVertically(-1))) {
          return false;
        }
      }
      return (MMBottomSheetBehavior.this.mViewRef != null) && (MMBottomSheetBehavior.this.mViewRef.get() == paramAnonymousView);
    }
    
    public final int cg()
    {
      if (MMBottomSheetBehavior.this.sN) {
        return MMBottomSheetBehavior.this.sT - MMBottomSheetBehavior.this.sL;
      }
      return MMBottomSheetBehavior.this.sM - MMBottomSheetBehavior.this.sL;
    }
    
    public final int d(View paramAnonymousView, int paramAnonymousInt)
    {
      int j = MMBottomSheetBehavior.this.sL;
      if (MMBottomSheetBehavior.this.sN) {}
      for (int i = MMBottomSheetBehavior.this.sT;; i = MMBottomSheetBehavior.this.sM) {
        return a.clamp(paramAnonymousInt, j, i);
      }
    }
    
    public final int e(View paramAnonymousView, int paramAnonymousInt)
    {
      return paramAnonymousView.getLeft();
    }
  };
  private MMBottomSheetBehavior.b td;
  
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
      this.sN = paramAttributeSet.getBoolean(1, false);
      this.sO = paramAttributeSet.getBoolean(3, false);
      paramAttributeSet.recycle();
      this.sH = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
      return;
      J(paramAttributeSet.getDimensionPixelSize(2, -1));
    }
  }
  
  private void J(int paramInt)
  {
    int i = 1;
    if (paramInt == -1)
    {
      if (this.sJ) {
        break label104;
      }
      this.sJ = true;
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
      if ((this.sJ) || (this.sI != paramInt))
      {
        this.sJ = false;
        this.sI = Math.max(0, paramInt);
        this.sM = (this.sT - paramInt);
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
  
  private void reset()
  {
    this.mActivePointerId = -1;
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  public static <V extends View> MMBottomSheetBehavior<V> x(V paramV)
  {
    paramV = paramV.getLayoutParams();
    if (!(paramV instanceof CoordinatorLayout.d)) {
      throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }
    paramV = ((CoordinatorLayout.d)paramV).qC;
    if (!(paramV instanceof MMBottomSheetBehavior)) {
      throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }
    return (MMBottomSheetBehavior)paramV;
  }
  
  public final boolean B(int paramInt)
  {
    boolean bool = false;
    this.sR = 0;
    this.sS = false;
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
    } while ((localView == null) || (this.sV == null));
    this.sV.f(localView, paramInt);
  }
  
  final void Z(int paramInt)
  {
    View localView = (View)this.mViewRef.get();
    if ((localView != null) && (this.sV != null))
    {
      if (paramInt > this.sM) {
        this.sV.b(localView, (this.sM - paramInt) / (this.sT - this.sM));
      }
    }
    else {
      return;
    }
    this.sV.b(localView, (this.sM - paramInt) / (this.sM - this.sL));
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, V paramV, Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.a(paramCoordinatorLayout, paramV, paramParcelable.Pm);
    if ((paramParcelable.state == 1) || (paramParcelable.state == 2))
    {
      this.mState = 4;
      return;
    }
    this.mState = paramParcelable.state;
  }
  
  public final void a(MMBottomSheetBehavior.a parama)
  {
    this.sV = parama;
  }
  
  public final void a(MMBottomSheetBehavior.b paramb)
  {
    this.td = paramb;
  }
  
  public final void a(V paramV, View paramView, int paramInt, int[] paramArrayOfInt)
  {
    if (paramView != (View)this.sU.get()) {
      return;
    }
    int i = paramV.getTop();
    int j = i - paramInt;
    if (paramInt > 0) {
      if (j < this.sL)
      {
        paramArrayOfInt[1] = (i - this.sL);
        u.s(paramV, -paramArrayOfInt[1]);
        K(3);
      }
    }
    for (;;)
    {
      Z(paramV.getTop());
      this.sR = paramInt;
      this.sS = true;
      return;
      paramArrayOfInt[1] = paramInt;
      u.s(paramV, -paramInt);
      K(1);
      continue;
      if ((paramInt < 0) && (!paramView.canScrollVertically(-1))) {
        if ((j <= this.sM) || (this.sN))
        {
          paramArrayOfInt[1] = paramInt;
          u.s(paramV, -paramInt);
          K(1);
        }
        else
        {
          paramArrayOfInt[1] = (i - this.sM);
          u.s(paramV, -paramArrayOfInt[1]);
          K(4);
        }
      }
    }
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    if ((u.aq(paramCoordinatorLayout)) && (!u.aq(paramV))) {
      u.e(paramV, true);
    }
    int i = paramV.getTop();
    paramCoordinatorLayout.g(paramV, paramInt);
    this.sT = paramCoordinatorLayout.getHeight();
    if (this.sJ)
    {
      if (this.sK == 0) {
        this.sK = paramCoordinatorLayout.getResources().getDimensionPixelSize(2131166146);
      }
      paramInt = Math.max(this.sK, this.sT - paramCoordinatorLayout.getWidth() * 9 / 16);
      this.sL = Math.max(0, this.sT - paramV.getHeight());
      this.sM = Math.max(this.sT - paramInt, this.sL);
      if (this.mState != 3) {
        break label197;
      }
      u.s(paramV, this.sL);
    }
    for (;;)
    {
      if (this.sP == null) {
        this.sP = t.a(paramCoordinatorLayout, this.tc);
      }
      this.mViewRef = new WeakReference(paramV);
      this.sU = new WeakReference(k(paramV));
      return true;
      paramInt = this.sI;
      break;
      label197:
      if ((this.sN) && (this.mState == 5)) {
        u.s(paramV, this.sT);
      } else if (this.mState == 4) {
        u.s(paramV, this.sM);
      } else if ((this.mState == 1) || (this.mState == 2)) {
        u.s(paramV, i - paramV.getTop());
      }
    }
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
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
      if (this.sP != null) {
        this.sP.k(paramMotionEvent);
      }
      if (i == 0) {
        reset();
      }
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      this.mVelocityTracker.addMovement(paramMotionEvent);
      if ((i == 2) && (!this.sQ) && (Math.abs(this.sZ - paramMotionEvent.getY()) > this.sP.mTouchSlop)) {
        this.sP.y(paramV, paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
      }
    } while (this.sQ);
    return true;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2)
  {
    return (paramView == this.sU.get()) && ((this.mState != 3) || (super.a(paramCoordinatorLayout, paramV, paramView, paramFloat1, paramFloat2)));
  }
  
  final boolean a(View paramView, float paramFloat)
  {
    if (this.sO) {}
    do
    {
      return true;
      if (paramView.getTop() < this.sM) {
        return false;
      }
    } while (Math.abs(paramView.getTop() + 0.1F * paramFloat - this.sM) / this.sI > 0.5F);
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
      i = this.sM;
    }
    while (this.sP.h(paramView, paramView.getLeft(), i))
    {
      K(2);
      u.b(paramView, new c(paramView, paramInt));
      return;
      if (paramInt == 3) {
        i = this.sL;
      } else if ((this.sN) && (paramInt == 5)) {
        i = this.sT;
      } else {
        throw new IllegalArgumentException("Illegal state argument: ".concat(String.valueOf(paramInt)));
      }
    }
    K(paramInt);
  }
  
  public final void b(V paramV, View paramView)
  {
    int j = 3;
    if (paramV.getTop() == this.sL) {
      K(3);
    }
    while ((this.sU == null) || (paramView != this.sU.get()) || (!this.sS)) {
      return;
    }
    int i;
    if (this.sR > 0)
    {
      i = this.sL;
      if (!this.sP.h(paramV, paramV.getLeft(), i)) {
        break label213;
      }
      K(2);
      u.b(paramV, new c(paramV, j));
    }
    for (;;)
    {
      this.sS = false;
      return;
      if (this.sN)
      {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.sH);
        if (a(paramV, this.mVelocityTracker.getYVelocity(this.mActivePointerId)))
        {
          i = this.sT;
          j = 5;
          break;
        }
      }
      if (this.sR == 0)
      {
        i = paramV.getTop();
        if (Math.abs(i - this.sL) < Math.abs(i - this.sM))
        {
          i = this.sL;
          break;
        }
        i = this.sM;
        j = 4;
        break;
      }
      i = this.sM;
      j = 4;
      break;
      label213:
      K(j);
    }
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    Log.d("microMsg.MMBottomSheetBehavior", "onInterceptTouchEvent action: %d, x: %f, y: %f, rawX: %f, rawY: %f.", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()) });
    if (paramMotionEvent.getAction() == 0) {
      this.tb = false;
    }
    if (this.tb) {
      Log.d("microMsg.MMBottomSheetBehavior", "external deal with, continue.");
    }
    int i;
    label310:
    label469:
    do
    {
      return false;
      if ((this.td != null) && (this.td.onInterceptTouchEvent(paramMotionEvent)))
      {
        Log.d("microMsg.MMBottomSheetBehavior", "external deal with.");
        this.tb = true;
        return false;
      }
      if (!paramV.isShown())
      {
        this.sQ = true;
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
      while ((!this.sQ) && (this.sP.j(paramMotionEvent)) && (this.sX))
      {
        return true;
        this.ta = false;
        this.mActivePointerId = -1;
        if (this.sQ)
        {
          this.sQ = false;
          return false;
          this.sW = false;
          this.sX = false;
          this.sY = ((int)paramMotionEvent.getX());
          this.sZ = ((int)paramMotionEvent.getY());
          View localView;
          if (this.sU != null)
          {
            localView = (View)this.sU.get();
            if ((localView != null) && (paramCoordinatorLayout.d(localView, this.sY, this.sZ)))
            {
              this.mActivePointerId = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
              this.ta = true;
            }
            if ((this.mActivePointerId != -1) || (paramCoordinatorLayout.d(paramV, this.sY, this.sZ))) {
              break label391;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            this.sQ = bool;
            break;
            localView = null;
            break label310;
          }
          int k = (int)paramMotionEvent.getX();
          int j = (int)paramMotionEvent.getY();
          k -= this.sY;
          j -= this.sZ;
          if (!this.sW)
          {
            if ((Math.abs(k) > this.sP.mTouchSlop) || (Math.abs(j) > this.sP.mTouchSlop))
            {
              bool = true;
              this.sW = bool;
            }
          }
          else
          {
            if (!this.sW) {
              continue;
            }
            if (Math.abs(j) <= Math.abs(k)) {
              break label513;
            }
          }
          for (bool = true;; bool = false)
          {
            this.sX = bool;
            break;
            bool = false;
            break label469;
          }
        }
      }
      paramV = (View)this.sU.get();
    } while ((i != 2) || (paramV == null) || (this.sQ) || (this.mState == 1) || (paramCoordinatorLayout.d(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) || (Math.abs(this.sZ - paramMotionEvent.getY()) <= this.sP.mTouchSlop) || (!this.sX));
    label391:
    return true;
  }
  
  public final void cU()
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
    if ((localViewParent != null) && (localViewParent.isLayoutRequested()) && (u.aD(localView)))
    {
      localView.post(new Runnable()
      {
        public final void run()
        {
          MMBottomSheetBehavior.this.b(localView, this.te);
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
    private final int tg;
    
    c(View paramView, int paramInt)
    {
      this.mView = paramView;
      this.tg = paramInt;
    }
    
    public final void run()
    {
      if ((MMBottomSheetBehavior.this.sP != null) && (MMBottomSheetBehavior.this.sP.go()))
      {
        u.b(this.mView, this);
        return;
      }
      MMBottomSheetBehavior.this.K(this.tg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.MMBottomSheetBehavior
 * JD-Core Version:    0.7.0.1
 */