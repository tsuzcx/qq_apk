package android.support.design.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.a.a;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ab;
import android.support.v4.view.t;
import android.support.v4.widget.h;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.List;

@CoordinatorLayout.b(Behavior.class)
public class AppBarLayout
  extends LinearLayout
{
  private int fo = -1;
  private int fp = -1;
  private int fq = -1;
  boolean fs;
  int ft = 0;
  ab fu;
  List<AppBarLayout.a> fv;
  private boolean fw;
  boolean fx;
  private int[] fy;
  
  public AppBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    n.F(paramContext);
    if (Build.VERSION.SDK_INT >= 21)
    {
      q.v(this);
      q.a(this, paramAttributeSet);
    }
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.AppBarLayout, 0, 2131493834);
    t.a(this, paramContext.getDrawable(0));
    if (paramContext.hasValue(4)) {
      b(paramContext.getBoolean(4, false), false, false);
    }
    if ((Build.VERSION.SDK_INT >= 21) && (paramContext.hasValue(3))) {
      q.c(this, paramContext.getDimensionPixelSize(3, 0));
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      if (paramContext.hasValue(2)) {
        setKeyboardNavigationCluster(paramContext.getBoolean(2, false));
      }
      if (paramContext.hasValue(1)) {
        setTouchscreenBlocksFocus(paramContext.getBoolean(1, false));
      }
    }
    paramContext.recycle();
    t.a(this, new AppBarLayout.1(this));
  }
  
  private static AppBarLayout.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((Build.VERSION.SDK_INT >= 19) && ((paramLayoutParams instanceof LinearLayout.LayoutParams))) {
      return new AppBarLayout.LayoutParams((LinearLayout.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new AppBarLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new AppBarLayout.LayoutParams(paramLayoutParams);
  }
  
  private AppBarLayout.LayoutParams b(AttributeSet paramAttributeSet)
  {
    return new AppBarLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  final void aL()
  {
    this.fo = -1;
    this.fp = -1;
    this.fq = -1;
  }
  
  final void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int k = 0;
    int i;
    if (paramBoolean1)
    {
      i = 1;
      if (!paramBoolean2) {
        break label48;
      }
    }
    label48:
    for (int j = 4;; j = 0)
    {
      if (paramBoolean3) {
        k = 8;
      }
      this.ft = (k | j | i);
      requestLayout();
      return;
      i = 2;
      break;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof AppBarLayout.LayoutParams;
  }
  
  int getDownNestedPreScrollRange()
  {
    if (this.fp != -1) {
      return this.fp;
    }
    int j = getChildCount() - 1;
    int i = 0;
    if (j >= 0)
    {
      View localView = getChildAt(j);
      AppBarLayout.LayoutParams localLayoutParams = (AppBarLayout.LayoutParams)localView.getLayoutParams();
      int k = localView.getMeasuredHeight();
      int m = localLayoutParams.fN;
      if ((m & 0x5) == 5)
      {
        n = localLayoutParams.topMargin;
        i = localLayoutParams.bottomMargin + n + i;
        if ((m & 0x8) != 0) {
          i += t.aa(localView);
        }
      }
      while (i <= 0) {
        for (;;)
        {
          int n;
          j -= 1;
          break;
          if ((m & 0x2) != 0) {
            i += k - t.aa(localView);
          } else {
            i += k - getTopInset();
          }
        }
      }
    }
    i = Math.max(0, i);
    this.fp = i;
    return i;
  }
  
  int getDownNestedScrollRange()
  {
    if (this.fq != -1) {
      return this.fq;
    }
    int k = getChildCount();
    int j = 0;
    int i = 0;
    if (j < k)
    {
      View localView = getChildAt(j);
      AppBarLayout.LayoutParams localLayoutParams = (AppBarLayout.LayoutParams)localView.getLayoutParams();
      int n = localView.getMeasuredHeight();
      int i1 = localLayoutParams.topMargin;
      int i2 = localLayoutParams.bottomMargin;
      int m = localLayoutParams.fN;
      if ((m & 0x1) != 0)
      {
        i += n + (i1 + i2);
        if ((m & 0x2) != 0) {
          i -= t.aa(localView) + getTopInset();
        }
      }
    }
    for (;;)
    {
      i = Math.max(0, i);
      this.fq = i;
      return i;
      j += 1;
      break;
    }
  }
  
  final int getMinimumHeightForVisibleOverlappingContent()
  {
    int j = getTopInset();
    int i = t.aa(this);
    if (i != 0) {
      return i * 2 + j;
    }
    i = getChildCount();
    if (i > 0) {}
    for (i = t.aa(getChildAt(i - 1)); i != 0; i = 0) {
      return i * 2 + j;
    }
    return getHeight() / 3;
  }
  
  int getPendingAction()
  {
    return this.ft;
  }
  
  @Deprecated
  public float getTargetElevation()
  {
    return 0.0F;
  }
  
  final int getTopInset()
  {
    if (this.fu != null) {
      return this.fu.getSystemWindowInsetTop();
    }
    return 0;
  }
  
  public final int getTotalScrollRange()
  {
    if (this.fo != -1) {
      return this.fo;
    }
    int k = getChildCount();
    int j = 0;
    int i = 0;
    if (j < k)
    {
      View localView = getChildAt(j);
      AppBarLayout.LayoutParams localLayoutParams = (AppBarLayout.LayoutParams)localView.getLayoutParams();
      int n = localView.getMeasuredHeight();
      int m = localLayoutParams.fN;
      if ((m & 0x1) != 0)
      {
        int i1 = localLayoutParams.topMargin;
        i += localLayoutParams.bottomMargin + (n + i1);
        if ((m & 0x2) != 0) {
          i -= t.aa(localView);
        }
      }
    }
    for (;;)
    {
      i = Math.max(0, i - getTopInset());
      this.fo = i;
      return i;
      j += 1;
      break;
    }
  }
  
  int getUpNestedPreScrollRange()
  {
    return getTotalScrollRange();
  }
  
  final void n(int paramInt)
  {
    if (this.fv != null)
    {
      int j = this.fv.size();
      int i = 0;
      while (i < j)
      {
        AppBarLayout.a locala = (AppBarLayout.a)this.fv.get(i);
        if (locala != null) {
          locala.q(paramInt);
        }
        i += 1;
      }
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    if (this.fy == null) {
      this.fy = new int[2];
    }
    int[] arrayOfInt1 = this.fy;
    int[] arrayOfInt2 = super.onCreateDrawableState(arrayOfInt1.length + paramInt);
    if (this.fw)
    {
      paramInt = 2130772104;
      arrayOfInt1[0] = paramInt;
      if ((!this.fw) || (!this.fx)) {
        break label78;
      }
    }
    label78:
    for (paramInt = 2130772103;; paramInt = -2130772103)
    {
      arrayOfInt1[1] = paramInt;
      return mergeDrawableStates(arrayOfInt2, arrayOfInt1);
      paramInt = -2130772104;
      break;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    aL();
    this.fs = false;
    paramInt2 = getChildCount();
    paramInt1 = 0;
    if (paramInt1 < paramInt2)
    {
      if (((AppBarLayout.LayoutParams)getChildAt(paramInt1).getLayoutParams()).fO != null) {
        this.fs = true;
      }
    }
    else
    {
      paramInt3 = getChildCount();
      paramInt1 = 0;
      label62:
      if (paramInt1 >= paramInt3) {
        break label148;
      }
      AppBarLayout.LayoutParams localLayoutParams = (AppBarLayout.LayoutParams)getChildAt(paramInt1).getLayoutParams();
      if (((localLayoutParams.fN & 0x1) != 1) || ((localLayoutParams.fN & 0xA) == 0)) {
        break label136;
      }
      paramInt2 = 1;
      label105:
      if (paramInt2 == 0) {
        break label141;
      }
    }
    label136:
    label141:
    label148:
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (this.fw != paramBoolean)
      {
        this.fw = paramBoolean;
        refreshDrawableState();
      }
      return;
      paramInt1 += 1;
      break;
      paramInt2 = 0;
      break label105;
      paramInt1 += 1;
      break label62;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    aL();
  }
  
  public void setExpanded(boolean paramBoolean)
  {
    b(paramBoolean, t.as(this), true);
  }
  
  public void setOrientation(int paramInt)
  {
    if (paramInt != 1) {
      throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }
    super.setOrientation(paramInt);
  }
  
  @Deprecated
  public void setTargetElevation(float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      q.c(this, paramFloat);
    }
  }
  
  public static class Behavior
    extends HeaderBehavior<AppBarLayout>
  {
    private int fA;
    private ValueAnimator fB;
    private int fC = -1;
    private boolean fD;
    private float fE;
    private WeakReference<View> fF;
    private AppBarLayout.Behavior.a fG;
    
    public Behavior() {}
    
    public Behavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    private void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout)
    {
      int n = aM();
      int j = paramAppBarLayout.getChildCount();
      int i = 0;
      View localView;
      label49:
      int i1;
      int m;
      int k;
      if (i < j)
      {
        localView = paramAppBarLayout.getChildAt(i);
        if ((localView.getTop() <= -n) && (localView.getBottom() >= -n)) {
          if (i >= 0)
          {
            localView = paramAppBarLayout.getChildAt(i);
            i1 = ((AppBarLayout.LayoutParams)localView.getLayoutParams()).fN;
            if ((i1 & 0x11) == 17)
            {
              m = -localView.getTop();
              k = -localView.getBottom();
              j = k;
              if (i == paramAppBarLayout.getChildCount() - 1) {
                j = k + paramAppBarLayout.getTopInset();
              }
              if (!g(i1, 2)) {
                break label184;
              }
              i = j + t.aa(localView);
              k = m;
              label144:
              if (n >= (i + k) / 2) {
                break label231;
              }
            }
          }
        }
      }
      for (;;)
      {
        a(paramCoordinatorLayout, paramAppBarLayout, android.support.v4.b.a.clamp(i, -paramAppBarLayout.getTotalScrollRange(), 0));
        return;
        i += 1;
        break;
        i = -1;
        break label49;
        label184:
        i = j;
        k = m;
        if (!g(i1, 5)) {
          break label144;
        }
        i = t.aa(localView) + j;
        if (n < i)
        {
          k = i;
          i = j;
          break label144;
        }
        k = m;
        break label144;
        label231:
        i = k;
      }
    }
    
    private void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, int paramInt)
    {
      int i = Math.abs(aM() - paramInt);
      float f = Math.abs(0.0F);
      if (f > 0.0F) {}
      int j;
      for (i = Math.round(i / f * 1000.0F) * 3;; i = (int)((i / paramAppBarLayout.getHeight() + 1.0F) * 150.0F))
      {
        j = aM();
        if (j != paramInt) {
          break;
        }
        if ((this.fB != null) && (this.fB.isRunning())) {
          this.fB.cancel();
        }
        return;
      }
      if (this.fB == null)
      {
        this.fB = new ValueAnimator();
        this.fB.setInterpolator(a.fn);
        this.fB.addUpdateListener(new AppBarLayout.Behavior.1(this, paramCoordinatorLayout, paramAppBarLayout));
      }
      for (;;)
      {
        this.fB.setDuration(Math.min(i, 600));
        this.fB.setIntValues(new int[] { j, paramInt });
        this.fB.start();
        return;
        this.fB.cancel();
      }
    }
    
    private static void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      int j = 0;
      int k = Math.abs(paramInt1);
      int m = paramAppBarLayout.getChildCount();
      int i = 0;
      Object localObject;
      label53:
      boolean bool;
      if (i < m)
      {
        localObject = paramAppBarLayout.getChildAt(i);
        if ((k >= ((View)localObject).getTop()) && (k <= ((View)localObject).getBottom())) {
          if (localObject != null)
          {
            i = ((AppBarLayout.LayoutParams)((View)localObject).getLayoutParams()).fN;
            if ((i & 0x1) == 0) {
              break label340;
            }
            k = t.aa((View)localObject);
            if ((paramInt2 <= 0) || ((i & 0xC) == 0)) {
              break label291;
            }
            if (-paramInt1 < ((View)localObject).getBottom() - k - paramAppBarLayout.getTopInset()) {
              break label285;
            }
            bool = true;
          }
        }
      }
      for (;;)
      {
        label118:
        if (paramAppBarLayout.fx != bool)
        {
          paramAppBarLayout.fx = bool;
          paramAppBarLayout.refreshDrawableState();
          paramInt1 = 1;
          if (Build.VERSION.SDK_INT >= 11) {
            if (!paramBoolean)
            {
              if (paramInt1 == 0) {
                break label269;
              }
              localObject = paramCoordinatorLayout.iu.H(paramAppBarLayout);
              paramCoordinatorLayout.ix.clear();
              if (localObject != null) {
                paramCoordinatorLayout.ix.addAll((Collection)localObject);
              }
              paramCoordinatorLayout = paramCoordinatorLayout.ix;
              i = paramCoordinatorLayout.size();
              paramInt1 = 0;
            }
          }
        }
        for (;;)
        {
          label139:
          paramInt2 = j;
          if (paramInt1 < i)
          {
            localObject = ((CoordinatorLayout.d)((View)paramCoordinatorLayout.get(paramInt1)).getLayoutParams()).iM;
            if (!(localObject instanceof AppBarLayout.ScrollingViewBehavior)) {
              break label333;
            }
            paramInt2 = j;
            if (((AppBarLayout.ScrollingViewBehavior)localObject).jZ != 0) {
              paramInt2 = 1;
            }
          }
          if (paramInt2 != 0) {
            paramAppBarLayout.jumpDrawablesToCurrentState();
          }
          label269:
          return;
          i += 1;
          break;
          localObject = null;
          break label53;
          label285:
          bool = false;
          break label118;
          label291:
          if ((i & 0x2) == 0) {
            break label340;
          }
          if (-paramInt1 >= ((View)localObject).getBottom() - k - paramAppBarLayout.getTopInset())
          {
            bool = true;
            break label118;
          }
          bool = false;
          break label118;
          paramInt1 = 0;
          break label139;
          label333:
          paramInt1 += 1;
        }
        label340:
        bool = false;
      }
    }
    
    private static boolean g(int paramInt1, int paramInt2)
    {
      return (paramInt1 & paramInt2) == paramInt2;
    }
    
    final int aM()
    {
      return super.aO() + this.fA;
    }
    
    protected static class SavedState
      extends AbsSavedState
    {
      public static final Parcelable.Creator<SavedState> CREATOR = new AppBarLayout.Behavior.SavedState.1();
      int fK;
      float fL;
      boolean fM;
      
      public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        super(paramClassLoader);
        this.fK = paramParcel.readInt();
        this.fL = paramParcel.readFloat();
        if (paramParcel.readByte() != 0) {}
        for (boolean bool = true;; bool = false)
        {
          this.fM = bool;
          return;
        }
      }
      
      public SavedState(Parcelable paramParcelable)
      {
        super();
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        super.writeToParcel(paramParcel, paramInt);
        paramParcel.writeInt(this.fK);
        paramParcel.writeFloat(this.fL);
        if (this.fM) {}
        for (paramInt = 1;; paramInt = 0)
        {
          paramParcel.writeByte((byte)paramInt);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.design.widget.AppBarLayout
 * JD-Core Version:    0.7.0.1
 */