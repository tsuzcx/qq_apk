package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a.a;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout.LayoutParams;

public class AppBarLayout$LayoutParams
  extends LinearLayout.LayoutParams
{
  int fN = 1;
  Interpolator fO;
  
  public AppBarLayout$LayoutParams()
  {
    super(-1, -2);
  }
  
  public AppBarLayout$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.AppBarLayout_Layout);
    this.fN = paramAttributeSet.getInt(0, 0);
    if (paramAttributeSet.hasValue(1)) {
      this.fO = AnimationUtils.loadInterpolator(paramContext, paramAttributeSet.getResourceId(1, 0));
    }
    paramAttributeSet.recycle();
  }
  
  public AppBarLayout$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public AppBarLayout$LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
  
  public AppBarLayout$LayoutParams(LinearLayout.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.design.widget.AppBarLayout.LayoutParams
 * JD-Core Version:    0.7.0.1
 */