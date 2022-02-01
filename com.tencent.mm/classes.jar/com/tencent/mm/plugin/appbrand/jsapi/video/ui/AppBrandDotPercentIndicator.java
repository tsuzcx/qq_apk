package com.tencent.mm.plugin.appbrand.jsapi.video.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class AppBrandDotPercentIndicator
  extends LinearLayout
{
  private int ktW;
  private LayoutInflater mInflater;
  
  public AppBrandDotPercentIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(194282);
    init(paramContext);
    AppMethodBeat.o(194282);
  }
  
  public AppBrandDotPercentIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(194283);
    init(paramContext);
    AppMethodBeat.o(194283);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(194284);
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(194284);
  }
  
  public void setDotsNum(int paramInt)
  {
    AppMethodBeat.i(194285);
    if (paramInt > 1) {}
    for (;;)
    {
      this.ktW = paramInt;
      removeAllViews();
      paramInt = 0;
      while (paramInt < this.ktW)
      {
        addView((ImageView)this.mInflater.inflate(2131492991, this, false));
        paramInt += 1;
      }
      paramInt = 8;
    }
    AppMethodBeat.o(194285);
  }
  
  public void setPercent(float paramFloat)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    AppMethodBeat.i(194286);
    if (paramFloat < 0.0F)
    {
      paramFloat = f2;
      if (paramFloat <= 1.0F) {
        break label118;
      }
      paramFloat = f1;
    }
    int j;
    label118:
    for (;;)
    {
      int k = (int)Math.rint(this.ktW * paramFloat);
      ad.v("MicroMsg.AppBrandDotPercentIndicator", "setPercent percent:%s dotsOnNum:%d", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(k) });
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
        ((ImageView)getChildAt(i)).setImageResource(2131230970);
        i += 1;
      }
      break;
    }
    while (j < getChildCount())
    {
      ((ImageView)getChildAt(j)).setImageResource(2131230969);
      j += 1;
    }
    AppMethodBeat.o(194286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.ui.AppBrandDotPercentIndicator
 * JD-Core Version:    0.7.0.1
 */