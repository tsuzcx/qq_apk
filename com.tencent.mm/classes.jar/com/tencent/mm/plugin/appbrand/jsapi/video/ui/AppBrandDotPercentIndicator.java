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
  private int sIe;
  
  public AppBrandDotPercentIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(328146);
    init(paramContext);
    AppMethodBeat.o(328146);
  }
  
  public AppBrandDotPercentIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(328149);
    init(paramContext);
    AppMethodBeat.o(328149);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(328153);
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(328153);
  }
  
  public void setDotsNum(int paramInt)
  {
    AppMethodBeat.i(328159);
    if (paramInt > 1) {}
    for (;;)
    {
      this.sIe = paramInt;
      removeAllViews();
      paramInt = 0;
      while (paramInt < this.sIe)
      {
        addView((ImageView)this.mInflater.inflate(a.d.app_brand_dot_percent_indicator_dot, this, false));
        paramInt += 1;
      }
      paramInt = 8;
    }
    AppMethodBeat.o(328159);
  }
  
  public void setPercent(float paramFloat)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    AppMethodBeat.i(328161);
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
      int k = (int)Math.rint(this.sIe * paramFloat);
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
    AppMethodBeat.o(328161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.ui.AppBrandDotPercentIndicator
 * JD-Core Version:    0.7.0.1
 */