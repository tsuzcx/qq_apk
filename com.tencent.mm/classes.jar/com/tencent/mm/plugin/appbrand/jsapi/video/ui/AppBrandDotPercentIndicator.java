package com.tencent.mm.plugin.appbrand.jsapi.video.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.luggage.b.d.a.b;
import com.tencent.luggage.b.d.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class AppBrandDotPercentIndicator
  extends LinearLayout
{
  private LayoutInflater mInflater;
  private int pCR;
  
  public AppBrandDotPercentIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(228391);
    init(paramContext);
    AppMethodBeat.o(228391);
  }
  
  public AppBrandDotPercentIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(228393);
    init(paramContext);
    AppMethodBeat.o(228393);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(228394);
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(228394);
  }
  
  public void setDotsNum(int paramInt)
  {
    AppMethodBeat.i(228395);
    if (paramInt > 1) {}
    for (;;)
    {
      this.pCR = paramInt;
      removeAllViews();
      paramInt = 0;
      while (paramInt < this.pCR)
      {
        addView((ImageView)this.mInflater.inflate(a.d.app_brand_dot_percent_indicator_dot, this, false));
        paramInt += 1;
      }
      paramInt = 8;
    }
    AppMethodBeat.o(228395);
  }
  
  public void setPercent(float paramFloat)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    AppMethodBeat.i(228401);
    if (paramFloat < 0.0F)
    {
      paramFloat = f2;
      if (paramFloat <= 1.0F) {
        break label119;
      }
      paramFloat = f1;
    }
    int j;
    label119:
    for (;;)
    {
      int k = (int)Math.rint(this.pCR * paramFloat);
      Log.v("MicroMsg.AppBrandDotPercentIndicator", "setPercent percent:%s dotsOnNum:%d", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(k) });
      int i = 0;
      for (;;)
      {
        j = i;
        if (i >= k) {
          break;
        }
        j = i;
        if (i >= getChildCount()) {
          break;
        }
        ((ImageView)getChildAt(i)).setImageResource(a.b.app_brand_dot_percent_indicator_dot_on_shape);
        i += 1;
      }
      break;
    }
    while (j < getChildCount())
    {
      ((ImageView)getChildAt(j)).setImageResource(a.b.app_brand_dot_percent_indicator_dot_off_shape);
      j += 1;
    }
    AppMethodBeat.o(228401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.ui.AppBrandDotPercentIndicator
 * JD-Core Version:    0.7.0.1
 */