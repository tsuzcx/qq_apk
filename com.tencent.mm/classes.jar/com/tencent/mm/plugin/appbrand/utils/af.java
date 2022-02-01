package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.o;
import com.tencent.mm.ui.widget.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/utils/StringSpanHelper;", "", "()V", "Companion", "plugin-appbrand-integration_release"})
public final class af
{
  public static final a ohG;
  
  static
  {
    AppMethodBeat.i(229598);
    ohG = new a((byte)0);
    AppMethodBeat.o(229598);
  }
  
  public static final Pair<SpannableString, Integer> a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, ClickableSpan paramClickableSpan)
  {
    AppMethodBeat.i(229600);
    paramContext = a.a(paramContext, paramInt1, 4, paramInt2, paramInt3, paramClickableSpan);
    AppMethodBeat.o(229600);
    return paramContext;
  }
  
  public static final List<Point> a(TextPaint paramTextPaint, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(229599);
    p.h(paramTextPaint, "tp");
    p.h(paramCharSequence, "cs");
    paramTextPaint = new StaticLayout(paramCharSequence, paramTextPaint, paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
    int i = paramTextPaint.getLineCount();
    paramCharSequence = (List)new ArrayList();
    paramInt = 0;
    while (paramInt < i)
    {
      paramCharSequence.add(new Point(paramTextPaint.getLineStart(paramInt), paramTextPaint.getLineEnd(paramInt)));
      paramInt += 1;
    }
    AppMethodBeat.o(229599);
    return paramCharSequence;
  }
  
  public static final Pair<SpannableString, Integer> es(Context paramContext)
  {
    AppMethodBeat.i(229601);
    p.h(paramContext, "context");
    paramContext = a.a(paramContext, 2131232188, 1, 0, 0, (ClickableSpan)new af.a.a());
    AppMethodBeat.o(229601);
    return paramContext;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/utils/StringSpanHelper$Companion;", "", "()V", "emptySpanIcon", "Landroid/util/Pair;", "Landroid/text/SpannableString;", "", "context", "Landroid/content/Context;", "getLineStartAndEnd", "", "Landroid/graphics/Point;", "tp", "Landroid/text/TextPaint;", "cs", "", "lineWidth", "makeSpanIcon", "iconResId", "leftMarginDp", "widthDp", "heightDp", "clickableSpan", "Landroid/text/style/ClickableSpan;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static Pair<SpannableString, Integer> a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ClickableSpan paramClickableSpan)
    {
      AppMethodBeat.i(229597);
      p.h(paramContext, "context");
      paramContext = paramContext.getResources().getDrawable(paramInt1);
      p.g(paramContext, "context.resources.getDrawable(iconResId)");
      paramContext.setBounds(o.zE(paramInt2), 0, o.zE(paramInt3 + paramInt2), o.zE(paramInt4));
      a locala = new a(paramContext);
      SpannableString localSpannableString = new SpannableString((CharSequence)"@");
      localSpannableString.setSpan(locala, 0, 1, 33);
      if (paramClickableSpan != null) {
        localSpannableString.setSpan(paramClickableSpan, 0, 1, 33);
      }
      paramContext = new Pair(localSpannableString, Integer.valueOf(paramContext.getBounds().right));
      AppMethodBeat.o(229597);
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.af
 * JD-Core Version:    0.7.0.1
 */