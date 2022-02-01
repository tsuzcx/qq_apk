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
import com.tencent.mm.plugin.appbrand.af.q;
import com.tencent.mm.plugin.appbrand.ba.e;
import com.tencent.mm.ui.widget.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/StringSpanHelper;", "", "()V", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class an
{
  public static final a urO;
  
  static
  {
    AppMethodBeat.i(317366);
    urO = new a((byte)0);
    AppMethodBeat.o(317366);
  }
  
  public static final Pair<SpannableString, Integer> a(Context paramContext, int paramInt, ClickableSpan paramClickableSpan)
  {
    AppMethodBeat.i(317356);
    paramContext = a.a(paramContext, paramInt, 4, 36, 20, paramClickableSpan);
    AppMethodBeat.o(317356);
    return paramContext;
  }
  
  public static final List<Point> a(TextPaint paramTextPaint, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(317352);
    s.u(paramTextPaint, "tp");
    s.u(paramCharSequence, "cs");
    paramTextPaint = new StaticLayout(paramCharSequence, paramTextPaint, paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
    int j = paramTextPaint.getLineCount();
    paramCharSequence = (List)new ArrayList();
    paramInt = 0;
    if (j > 0) {}
    for (;;)
    {
      int i = paramInt + 1;
      paramCharSequence.add(new Point(paramTextPaint.getLineStart(paramInt), paramTextPaint.getLineEnd(paramInt)));
      if (i >= j)
      {
        AppMethodBeat.o(317352);
        return paramCharSequence;
      }
      paramInt = i;
    }
  }
  
  public static final Pair<SpannableString, Integer> fp(Context paramContext)
  {
    AppMethodBeat.i(317362);
    s.u(paramContext, "context");
    paramContext = a.a(paramContext, ba.e.empty_drawable, 1, 0, 0, (ClickableSpan)new an.a.a());
    AppMethodBeat.o(317362);
    return paramContext;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/StringSpanHelper$Companion;", "", "()V", "emptySpanIcon", "Landroid/util/Pair;", "Landroid/text/SpannableString;", "", "context", "Landroid/content/Context;", "getLineStartAndEnd", "", "Landroid/graphics/Point;", "tp", "Landroid/text/TextPaint;", "cs", "", "lineWidth", "makeSpanIcon", "iconResId", "leftMarginDp", "widthDp", "heightDp", "clickableSpan", "Landroid/text/style/ClickableSpan;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static Pair<SpannableString, Integer> a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ClickableSpan paramClickableSpan)
    {
      AppMethodBeat.i(317467);
      s.u(paramContext, "context");
      paramContext = paramContext.getResources().getDrawable(paramInt1);
      s.s(paramContext, "context.resources.getDrawable(iconResId)");
      paramContext.setBounds(q.DD(paramInt2), 0, q.DD(paramInt3 + paramInt2), q.DD(paramInt4));
      a locala = new a(paramContext, 1);
      SpannableString localSpannableString = new SpannableString((CharSequence)"@");
      localSpannableString.setSpan(locala, 0, 1, 33);
      if (paramClickableSpan != null) {
        localSpannableString.setSpan(paramClickableSpan, 0, 1, 33);
      }
      paramContext = new Pair(localSpannableString, Integer.valueOf(paramContext.getBounds().right));
      AppMethodBeat.o(317467);
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.an
 * JD-Core Version:    0.7.0.1
 */