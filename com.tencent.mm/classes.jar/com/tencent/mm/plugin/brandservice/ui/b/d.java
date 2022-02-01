package com.tencent.mm.plugin.brandservice.ui.b;

import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/util/BizTimeLineViewUtil;", "", "()V", "setTextViewBold", "", "textView", "Landroid/widget/TextView;", "width", "", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "plugin-brandservice_release"})
public final class d
{
  public static final d nmK;
  
  static
  {
    AppMethodBeat.i(7364);
    nmK = new d();
    AppMethodBeat.o(7364);
  }
  
  public static void a(MMNeat7extView paramMMNeat7extView)
  {
    AppMethodBeat.i(7362);
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
        AppMethodBeat.o(7362);
        return;
      }
    }
    AppMethodBeat.o(7362);
  }
  
  public static void i(TextView paramTextView)
  {
    AppMethodBeat.i(7363);
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
        AppMethodBeat.o(7363);
        return;
      }
    }
    AppMethodBeat.o(7363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.d
 * JD-Core Version:    0.7.0.1
 */