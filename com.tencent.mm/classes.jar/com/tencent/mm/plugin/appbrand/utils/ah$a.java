package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.o;
import com.tencent.mm.ui.widget.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/utils/StringSpanHelper$Companion;", "", "()V", "emptySpanIcon", "Landroid/util/Pair;", "Landroid/text/SpannableString;", "", "context", "Landroid/content/Context;", "getLineStartAndEnd", "", "Landroid/graphics/Point;", "tp", "Landroid/text/TextPaint;", "cs", "", "lineWidth", "makeSpanIcon", "iconResId", "leftMarginDp", "widthDp", "heightDp", "clickableSpan", "Landroid/text/style/ClickableSpan;", "plugin-appbrand-integration_release"})
public final class ah$a
{
  public static Pair<SpannableString, Integer> a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ClickableSpan paramClickableSpan)
  {
    AppMethodBeat.i(278597);
    p.k(paramContext, "context");
    paramContext = paramContext.getResources().getDrawable(paramInt1);
    p.j(paramContext, "context.resources.getDrawable(iconResId)");
    paramContext.setBounds(o.Dj(paramInt2), 0, o.Dj(paramInt3 + paramInt2), o.Dj(paramInt4));
    a locala = new a(paramContext, 1);
    SpannableString localSpannableString = new SpannableString((CharSequence)"@");
    localSpannableString.setSpan(locala, 0, 1, 33);
    if (paramClickableSpan != null) {
      localSpannableString.setSpan(paramClickableSpan, 0, 1, 33);
    }
    paramContext = new Pair(localSpannableString, Integer.valueOf(paramContext.getBounds().right));
    AppMethodBeat.o(278597);
    return paramContext;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/utils/StringSpanHelper$Companion$emptySpanIcon$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "plugin-appbrand-integration_release"})
  public static final class a
    extends ClickableSpan
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(283074);
      p.k(paramView, "widget");
      AppMethodBeat.o(283074);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.ah.a
 * JD-Core Version:    0.7.0.1
 */