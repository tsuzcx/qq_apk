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
import com.tencent.mm.plugin.appbrand.y.o;
import com.tencent.mm.ui.widget.a;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/utils/StringSpanHelper;", "", "()V", "Companion", "plugin-appbrand-integration_release"})
public final class af
{
  public static final a mUG;
  
  static
  {
    AppMethodBeat.i(223940);
    mUG = new a((byte)0);
    AppMethodBeat.o(223940);
  }
  
  public static final Pair<SpannableString, Integer> a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, ClickableSpan paramClickableSpan)
  {
    AppMethodBeat.i(223942);
    paramContext = a.a(paramContext, paramInt1, 4, paramInt2, paramInt3, paramClickableSpan);
    AppMethodBeat.o(223942);
    return paramContext;
  }
  
  public static final List<Point> a(TextPaint paramTextPaint, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(223941);
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
    AppMethodBeat.o(223941);
    return paramCharSequence;
  }
  
  public static final Pair<SpannableString, Integer> dV(Context paramContext)
  {
    AppMethodBeat.i(223943);
    p.h(paramContext, "context");
    paramContext = a.a(paramContext, 2131234982, 1, 0, 0, (ClickableSpan)new af.a.a());
    AppMethodBeat.o(223943);
    return paramContext;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/utils/StringSpanHelper$Companion;", "", "()V", "emptySpanIcon", "Landroid/util/Pair;", "Landroid/text/SpannableString;", "", "context", "Landroid/content/Context;", "getLineStartAndEnd", "", "Landroid/graphics/Point;", "tp", "Landroid/text/TextPaint;", "cs", "", "lineWidth", "makeSpanIcon", "iconResId", "leftMarginDp", "widthDp", "heightDp", "clickableSpan", "Landroid/text/style/ClickableSpan;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static Pair<SpannableString, Integer> a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ClickableSpan paramClickableSpan)
    {
      AppMethodBeat.i(223939);
      p.h(paramContext, "context");
      paramContext = paramContext.getResources().getDrawable(paramInt1);
      p.g(paramContext, "context.resources.getDrawable(iconResId)");
      paramContext.setBounds(o.vP(paramInt2), 0, o.vP(paramInt3 + paramInt2), o.vP(paramInt4));
      a locala = new a(paramContext);
      SpannableString localSpannableString = new SpannableString((CharSequence)"@");
      localSpannableString.setSpan(locala, 0, 1, 33);
      if (paramClickableSpan != null) {
        localSpannableString.setSpan(paramClickableSpan, 0, 1, 33);
      }
      paramContext = new Pair(localSpannableString, Integer.valueOf(paramContext.getBounds().right));
      AppMethodBeat.o(223939);
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.af
 * JD-Core Version:    0.7.0.1
 */