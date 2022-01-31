package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.a.b;
import android.support.design.a.j;
import android.support.design.a.k;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.q;
import android.support.v4.view.y;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.List;

@CoordinatorLayout.b(AppBarLayout.Behavior.class)
public class AppBarLayout
  extends LinearLayout
{
  private int eq = -1;
  private int er = -1;
  private int es = -1;
  boolean et;
  int eu = 0;
  y ev;
  private boolean ew;
  boolean ex;
  private int[] ey;
  List<AppBarLayout.a> mListeners;
  
  public AppBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    o.G(paramContext);
    if (Build.VERSION.SDK_INT >= 21)
    {
      r.s(this);
      r.a(this, paramAttributeSet, a.j.Widget_Design_AppBarLayout);
    }
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.AppBarLayout, 0, a.j.Widget_Design_AppBarLayout);
    q.a(this, paramContext.getDrawable(a.k.AppBarLayout_android_background));
    if (paramContext.hasValue(a.k.AppBarLayout_expanded)) {
      d(paramContext.getBoolean(a.k.AppBarLayout_expanded, false), false, false);
    }
    if ((Build.VERSION.SDK_INT >= 21) && (paramContext.hasValue(a.k.AppBarLayout_elevation))) {
      r.b(this, paramContext.getDimensionPixelSize(a.k.AppBarLayout_elevation, 0));
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      if (paramContext.hasValue(a.k.AppBarLayout_android_keyboardNavigationCluster)) {
        setKeyboardNavigationCluster(paramContext.getBoolean(a.k.AppBarLayout_android_keyboardNavigationCluster, false));
      }
      if (paramContext.hasValue(a.k.AppBarLayout_android_touchscreenBlocksFocus)) {
        setTouchscreenBlocksFocus(paramContext.getBoolean(a.k.AppBarLayout_android_touchscreenBlocksFocus, false));
      }
    }
    paramContext.recycle();
    q.a(this, new AppBarLayout.1(this));
  }
  
  private static LayoutParams a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((Build.VERSION.SDK_INT >= 19) && ((paramLayoutParams instanceof LinearLayout.LayoutParams))) {
      return new LayoutParams((LinearLayout.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  private LayoutParams b(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  final void aa()
  {
    this.eq = -1;
    this.er = -1;
    this.es = -1;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  final void d(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
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
      this.eu = (k | j | i);
      requestLayout();
      return;
      i = 2;
      break;
    }
  }
  
  int getDownNestedPreScrollRange()
  {
    if (this.er != -1) {
      return this.er;
    }
    int j = getChildCount() - 1;
    int i = 0;
    if (j >= 0)
    {
      View localView = getChildAt(j);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int k = localView.getMeasuredHeight();
      int m = localLayoutParams.eN;
      if ((m & 0x5) == 5)
      {
        n = localLayoutParams.topMargin;
        i = localLayoutParams.bottomMargin + n + i;
        if ((m & 0x8) != 0) {
          i += q.X(localView);
        }
      }
      while (i <= 0) {
        for (;;)
        {
          int n;
          j -= 1;
          break;
          if ((m & 0x2) != 0) {
            i += k - q.X(localView);
          } else {
            i += k - getTopInset();
          }
        }
      }
    }
    i = Math.max(0, i);
    this.er = i;
    return i;
  }
  
  int getDownNestedScrollRange()
  {
    if (this.es != -1) {
      return this.es;
    }
    int k = getChildCount();
    int j = 0;
    int i = 0;
    if (j < k)
    {
      View localView = getChildAt(j);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int n = localView.getMeasuredHeight();
      int i1 = localLayoutParams.topMargin;
      int i2 = localLayoutParams.bottomMargin;
      int m = localLayoutParams.eN;
      if ((m & 0x1) != 0)
      {
        i += n + (i1 + i2);
        if ((m & 0x2) != 0) {
          i -= q.X(localView) + getTopInset();
        }
      }
    }
    for (;;)
    {
      i = Math.max(0, i);
      this.es = i;
      return i;
      j += 1;
      break;
    }
  }
  
  final int getMinimumHeightForVisibleOverlappingContent()
  {
    int j = getTopInset();
    int i = q.X(this);
    if (i != 0) {
      return i * 2 + j;
    }
    i = getChildCount();
    if (i > 0) {}
    for (i = q.X(getChildAt(i - 1)); i != 0; i = 0) {
      return i * 2 + j;
    }
    return getHeight() / 3;
  }
  
  int getPendingAction()
  {
    return this.eu;
  }
  
  @Deprecated
  public float getTargetElevation()
  {
    return 0.0F;
  }
  
  final int getTopInset()
  {
    if (this.ev != null) {
      return this.ev.getSystemWindowInsetTop();
    }
    return 0;
  }
  
  public final int getTotalScrollRange()
  {
    if (this.eq != -1) {
      return this.eq;
    }
    int k = getChildCount();
    int j = 0;
    int i = 0;
    if (j < k)
    {
      View localView = getChildAt(j);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int n = localView.getMeasuredHeight();
      int m = localLayoutParams.eN;
      if ((m & 0x1) != 0)
      {
        int i1 = localLayoutParams.topMargin;
        i += localLayoutParams.bottomMargin + (n + i1);
        if ((m & 0x2) != 0) {
          i -= q.X(localView);
        }
      }
    }
    for (;;)
    {
      i = Math.max(0, i - getTopInset());
      this.eq = i;
      return i;
      j += 1;
      break;
    }
  }
  
  int getUpNestedPreScrollRange()
  {
    return getTotalScrollRange();
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    if (this.ey == null) {
      this.ey = new int[2];
    }
    int[] arrayOfInt1 = this.ey;
    int[] arrayOfInt2 = super.onCreateDrawableState(arrayOfInt1.length + paramInt);
    if (this.ew)
    {
      paramInt = a.b.state_collapsible;
      arrayOfInt1[0] = paramInt;
      if ((!this.ew) || (!this.ex)) {
        break label79;
      }
    }
    label79:
    for (paramInt = a.b.state_collapsed;; paramInt = -a.b.state_collapsed)
    {
      arrayOfInt1[1] = paramInt;
      return mergeDrawableStates(arrayOfInt2, arrayOfInt1);
      paramInt = -a.b.state_collapsible;
      break;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    aa();
    this.et = false;
    paramInt2 = getChildCount();
    paramInt1 = 0;
    if (paramInt1 < paramInt2)
    {
      if (((LayoutParams)getChildAt(paramInt1).getLayoutParams()).eO != null) {
        this.et = true;
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
      LayoutParams localLayoutParams = (LayoutParams)getChildAt(paramInt1).getLayoutParams();
      if (((localLayoutParams.eN & 0x1) != 1) || ((localLayoutParams.eN & 0xA) == 0)) {
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
      if (this.ew != paramBoolean)
      {
        this.ew = paramBoolean;
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
    aa();
  }
  
  final void p(int paramInt)
  {
    if (this.mListeners != null)
    {
      int j = this.mListeners.size();
      int i = 0;
      while (i < j)
      {
        AppBarLayout.a locala = (AppBarLayout.a)this.mListeners.get(i);
        if (locala != null) {
          locala.r(paramInt);
        }
        i += 1;
      }
    }
  }
  
  public void setExpanded(boolean paramBoolean)
  {
    d(paramBoolean, q.al(this), true);
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
      r.b(this, paramFloat);
    }
  }
  
  protected static class Behavior$SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new AppBarLayout.Behavior.SavedState.1();
    int eK;
    float eL;
    boolean eM;
    
    public Behavior$SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.eK = paramParcel.readInt();
      this.eL = paramParcel.readFloat();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.eM = bool;
        return;
      }
    }
    
    public Behavior$SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.eK);
      paramParcel.writeFloat(this.eL);
      if (this.eM) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        return;
      }
    }
  }
  
  public static class LayoutParams
    extends LinearLayout.LayoutParams
  {
    int eN = 1;
    Interpolator eO;
    
    public LayoutParams()
    {
      super(-2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.AppBarLayout_Layout);
      this.eN = paramAttributeSet.getInt(a.k.AppBarLayout_Layout_layout_scrollFlags, 0);
      if (paramAttributeSet.hasValue(a.k.AppBarLayout_Layout_layout_scrollInterpolator)) {
        this.eO = AnimationUtils.loadInterpolator(paramContext, paramAttributeSet.getResourceId(a.k.AppBarLayout_Layout_layout_scrollInterpolator, 0));
      }
      paramAttributeSet.recycle();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public LayoutParams(LinearLayout.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.design.widget.AppBarLayout
 * JD-Core Version:    0.7.0.1
 */