package com.tencent.mm.plugin.appbrand.utils;

import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/utils/StringSpanHelper$Companion$emptySpanIcon$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "plugin-appbrand-integration_release"})
public final class af$a$a
  extends ClickableSpan
{
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(229596);
    p.h(paramView, "widget");
    AppMethodBeat.o(229596);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.af.a.a
 * JD-Core Version:    0.7.0.1
 */