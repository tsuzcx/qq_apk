package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a.k;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;

public class CollapsingToolbarLayout$LayoutParams
  extends FrameLayout.LayoutParams
{
  int hq = 0;
  float hr = 0.5F;
  
  public CollapsingToolbarLayout$LayoutParams()
  {
    super(-1, -1);
  }
  
  public CollapsingToolbarLayout$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.CollapsingToolbarLayout_Layout);
    this.hq = paramContext.getInt(a.k.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
    this.hr = paramContext.getFloat(a.k.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5F);
    paramContext.recycle();
  }
  
  public CollapsingToolbarLayout$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.design.widget.CollapsingToolbarLayout.LayoutParams
 * JD-Core Version:    0.7.0.1
 */