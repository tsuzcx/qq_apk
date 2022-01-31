package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class AppBrandDotPercentIndicator
  extends LinearLayout
{
  private int ibJ;
  private LayoutInflater mInflater;
  
  public AppBrandDotPercentIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(126436);
    init(paramContext);
    AppMethodBeat.o(126436);
  }
  
  public AppBrandDotPercentIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(126437);
    init(paramContext);
    AppMethodBeat.o(126437);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(126438);
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(126438);
  }
  
  public void setDotsNum(int paramInt)
  {
    AppMethodBeat.i(126439);
    if (paramInt > 1) {}
    for (;;)
    {
      this.ibJ = paramInt;
      removeAllViews();
      paramInt = 0;
      while (paramInt < this.ibJ)
      {
        addView((ImageView)this.mInflater.inflate(2130968681, this, false));
        paramInt += 1;
      }
      paramInt = 8;
    }
    AppMethodBeat.o(126439);
  }
  
  public void setPercent(float paramFloat)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    AppMethodBeat.i(126440);
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
      int k = (int)Math.rint(this.ibJ * paramFloat);
      ab.v("MicroMsg.AppBrandDotPercentIndicator", "setPercent percent:%s dotsOnNum:%d", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(k) });
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
        ((ImageView)getChildAt(i)).setImageResource(2130837733);
        i += 1;
      }
      break;
    }
    while (j < getChildCount())
    {
      ((ImageView)getChildAt(j)).setImageResource(2130837732);
      j += 1;
    }
    AppMethodBeat.o(126440);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandDotPercentIndicator
 * JD-Core Version:    0.7.0.1
 */