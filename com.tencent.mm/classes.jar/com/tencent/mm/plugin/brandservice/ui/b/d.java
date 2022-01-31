package com.tencent.mm.plugin.brandservice.ui.b;

import a.l;
import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/util/BizTimeLineViewUtil;", "", "()V", "setTextViewBold", "", "textView", "Landroid/widget/TextView;", "width", "", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "plugin-brandservice_release"})
public final class d
{
  public static final d kiX;
  
  static
  {
    AppMethodBeat.i(152987);
    kiX = new d();
    AppMethodBeat.o(152987);
  }
  
  public static void a(MMNeat7extView paramMMNeat7extView)
  {
    AppMethodBeat.i(152985);
    if (paramMMNeat7extView != null)
    {
      TextPaint localTextPaint = paramMMNeat7extView.getPaint();
      if (localTextPaint != null) {
        localTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      }
    }
    if (paramMMNeat7extView != null)
    {
      paramMMNeat7extView = paramMMNeat7extView.getPaint();
      if (paramMMNeat7extView != null)
      {
        paramMMNeat7extView.setStrokeWidth(0.8F);
        AppMethodBeat.o(152985);
        return;
      }
    }
    AppMethodBeat.o(152985);
  }
  
  public static void g(TextView paramTextView)
  {
    AppMethodBeat.i(152986);
    if (paramTextView != null)
    {
      TextPaint localTextPaint = paramTextView.getPaint();
      if (localTextPaint != null) {
        localTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      }
    }
    if (paramTextView != null)
    {
      paramTextView = paramTextView.getPaint();
      if (paramTextView != null)
      {
        paramTextView.setStrokeWidth(0.8F);
        AppMethodBeat.o(152986);
        return;
      }
    }
    AppMethodBeat.o(152986);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.d
 * JD-Core Version:    0.7.0.1
 */