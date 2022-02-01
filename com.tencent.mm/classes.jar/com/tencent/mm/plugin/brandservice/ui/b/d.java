package com.tencent.mm.plugin.brandservice.ui.b;

import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/util/BizTimeLineViewUtil;", "", "()V", "bizTimeLineTitleBold", "", "getBizTimeLineTitleBold", "()Z", "bizTimeLineTitleBold$delegate", "Lkotlin/Lazy;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "onlyShowStatData", "getOnlyShowStatData", "onlyShowStatData$delegate", "setTextViewBold", "", "textView", "Landroid/widget/TextView;", "width", "", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "plugin-brandservice_release"})
public final class d
{
  private static final f lrB;
  public static final f sTu;
  private static final f sTv;
  public static final d sTw;
  
  static
  {
    AppMethodBeat.i(7364);
    sTw = new d();
    lrB = g.ar((a)d.b.sTy);
    sTu = g.ar((a)d.c.sTz);
    sTv = g.ar((a)a.sTx);
    AppMethodBeat.o(7364);
  }
  
  public static boolean cEs()
  {
    AppMethodBeat.i(257334);
    boolean bool = ((Boolean)sTv.getValue()).booleanValue();
    AppMethodBeat.o(257334);
    return bool;
  }
  
  public static void e(MMNeat7extView paramMMNeat7extView)
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
  
  public static void l(TextView paramTextView)
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Boolean>
  {
    public static final a sTx;
    
    static
    {
      AppMethodBeat.i(265209);
      sTx = new a();
      AppMethodBeat.o(265209);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.d
 * JD-Core Version:    0.7.0.1
 */