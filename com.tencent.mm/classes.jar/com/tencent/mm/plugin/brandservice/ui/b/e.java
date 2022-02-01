package com.tencent.mm.plugin.brandservice.ui.b;

import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/util/BizTimeLineViewUtil;", "", "()V", "bizTimeLineTitleBold", "", "getBizTimeLineTitleBold", "()Z", "bizTimeLineTitleBold$delegate", "Lkotlin/Lazy;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "onlyShowStatData", "getOnlyShowStatData", "onlyShowStatData$delegate", "setTextViewBold", "", "textView", "Landroid/widget/TextView;", "width", "", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private static final j exj;
  public static final e vYK;
  private static final j vYL;
  private static final j vYM;
  
  static
  {
    AppMethodBeat.i(7364);
    vYK = new e();
    exj = k.cm((a)e.b.vYO);
    vYL = k.cm((a)e.c.vYP);
    vYM = k.cm((a)a.vYN);
    AppMethodBeat.o(7364);
  }
  
  public static boolean dhU()
  {
    AppMethodBeat.i(301640);
    boolean bool = ((Boolean)vYL.getValue()).booleanValue();
    AppMethodBeat.o(301640);
    return bool;
  }
  
  public static boolean dhV()
  {
    AppMethodBeat.i(301642);
    boolean bool = ((Boolean)vYM.getValue()).booleanValue();
    AppMethodBeat.o(301642);
    return bool;
  }
  
  public static void e(MMNeat7extView paramMMNeat7extView)
  {
    Object localObject = null;
    AppMethodBeat.i(7362);
    TextPaint localTextPaint;
    if (paramMMNeat7extView == null)
    {
      localTextPaint = null;
      if (localTextPaint != null) {
        localTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      }
      if (paramMMNeat7extView != null) {
        break label56;
      }
    }
    label56:
    for (paramMMNeat7extView = localObject;; paramMMNeat7extView = paramMMNeat7extView.getPaint())
    {
      if (paramMMNeat7extView != null) {
        paramMMNeat7extView.setStrokeWidth(0.8F);
      }
      AppMethodBeat.o(7362);
      return;
      localTextPaint = paramMMNeat7extView.getPaint();
      break;
    }
  }
  
  public static void l(TextView paramTextView)
  {
    Object localObject = null;
    AppMethodBeat.i(7363);
    TextPaint localTextPaint;
    if (paramTextView == null)
    {
      localTextPaint = null;
      if (localTextPaint != null) {
        localTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      }
      if (paramTextView != null) {
        break label56;
      }
    }
    label56:
    for (paramTextView = localObject;; paramTextView = paramTextView.getPaint())
    {
      if (paramTextView != null) {
        paramTextView.setStrokeWidth(0.8F);
      }
      AppMethodBeat.o(7363);
      return;
      localTextPaint = paramTextView.getPaint();
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<Boolean>
  {
    public static final a vYN;
    
    static
    {
      AppMethodBeat.i(301641);
      vYN = new a();
      AppMethodBeat.o(301641);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.e
 * JD-Core Version:    0.7.0.1
 */