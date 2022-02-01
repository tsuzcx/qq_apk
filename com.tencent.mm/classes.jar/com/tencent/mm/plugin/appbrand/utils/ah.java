package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.graphics.Point;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/utils/StringSpanHelper;", "", "()V", "Companion", "plugin-appbrand-integration_release"})
public final class ah
{
  public static final ah.a rju;
  
  static
  {
    AppMethodBeat.i(280742);
    rju = new ah.a((byte)0);
    AppMethodBeat.o(280742);
  }
  
  public static final Pair<SpannableString, Integer> a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, ClickableSpan paramClickableSpan)
  {
    AppMethodBeat.i(280744);
    paramContext = ah.a.a(paramContext, paramInt1, 4, paramInt2, paramInt3, paramClickableSpan);
    AppMethodBeat.o(280744);
    return paramContext;
  }
  
  public static final List<Point> a(TextPaint paramTextPaint, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(280743);
    p.k(paramTextPaint, "tp");
    p.k(paramCharSequence, "cs");
    paramTextPaint = new StaticLayout(paramCharSequence, paramTextPaint, paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
    int i = paramTextPaint.getLineCount();
    paramCharSequence = (List)new ArrayList();
    paramInt = 0;
    while (paramInt < i)
    {
      paramCharSequence.add(new Point(paramTextPaint.getLineStart(paramInt), paramTextPaint.getLineEnd(paramInt)));
      paramInt += 1;
    }
    AppMethodBeat.o(280743);
    return paramCharSequence;
  }
  
  public static final Pair<SpannableString, Integer> et(Context paramContext)
  {
    AppMethodBeat.i(280745);
    p.k(paramContext, "context");
    paramContext = ah.a.a(paramContext, au.e.empty_drawable, 1, 0, 0, (ClickableSpan)new ah.a.a());
    AppMethodBeat.o(280745);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.ah
 * JD-Core Version:    0.7.0.1
 */