package com.tencent.mm.plugin.appbrand.jsapi.video.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class AppBrandDotPercentIndicator
  extends LinearLayout
{
  private int mDG;
  private LayoutInflater mInflater;
  
  public AppBrandDotPercentIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(235146);
    init(paramContext);
    AppMethodBeat.o(235146);
  }
  
  public AppBrandDotPercentIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(235147);
    init(paramContext);
    AppMethodBeat.o(235147);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(235148);
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(235148);
  }
  
  public void setDotsNum(int paramInt)
  {
    AppMethodBeat.i(235149);
    if (paramInt > 1) {}
    for (;;)
    {
      this.mDG = paramInt;
      removeAllViews();
      paramInt = 0;
      while (paramInt < this.mDG)
      {
        addView((ImageView)this.mInflater.inflate(2131493026, this, false));
        paramInt += 1;
      }
      paramInt = 8;
    }
    AppMethodBeat.o(235149);
  }
  
  public void setPercent(float paramFloat)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    AppMethodBeat.i(235150);
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
      int k = (int)Math.rint(this.mDG * paramFloat);
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
        ((ImageView)getChildAt(i)).setImageResource(2131230999);
        i += 1;
      }
      break;
    }
    while (j < getChildCount())
    {
      ((ImageView)getChildAt(j)).setImageResource(2131230998);
      j += 1;
    }
    AppMethodBeat.o(235150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.ui.AppBrandDotPercentIndicator
 * JD-Core Version:    0.7.0.1
 */