package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class IPCallFeedbackScrollView
  extends ScrollView
{
  public IPCallFeedbackScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public IPCallFeedbackScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(25796);
    try
    {
      Display localDisplay = ((Activity)getContext()).getWindowManager().getDefaultDisplay();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      localDisplay.getMetrics(localDisplayMetrics);
      int i = View.MeasureSpec.makeMeasureSpec(localDisplayMetrics.heightPixels / 2, -2147483648);
      paramInt2 = i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.IPCallFeedbackScrollView", localException, "", new Object[0]);
      }
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(25796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallFeedbackScrollView
 * JD-Core Version:    0.7.0.1
 */