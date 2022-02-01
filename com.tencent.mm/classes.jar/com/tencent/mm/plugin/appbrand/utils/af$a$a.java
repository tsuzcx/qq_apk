package com.tencent.mm.plugin.appbrand.utils;

import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/utils/StringSpanHelper$Companion$emptySpanIcon$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "plugin-appbrand-integration_release"})
public final class af$a$a
  extends ClickableSpan
{
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(223938);
    p.h(paramView, "widget");
    AppMethodBeat.o(223938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.af.a.a
 * JD-Core Version:    0.7.0.1
 */