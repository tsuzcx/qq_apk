package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a.a;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;

public class CollapsingToolbarLayout$LayoutParams
  extends FrameLayout.LayoutParams
{
  int ik = 0;
  float il = 0.5F;
  
  public CollapsingToolbarLayout$LayoutParams()
  {
    super(-1, -1);
  }
  
  public CollapsingToolbarLayout$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.CollapsingToolbarLayout_Layout);
    this.ik = paramContext.getInt(0, 0);
    this.il = paramContext.getFloat(1, 0.5F);
    paramContext.recycle();
  }
  
  public CollapsingToolbarLayout$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.design.widget.CollapsingToolbarLayout.LayoutParams
 * JD-Core Version:    0.7.0.1
 */