package com.tencent.mm.plugin.appbrand.utils;

import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/utils/StringSpanHelper$Companion$emptySpanIcon$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class an$a$a
  extends ClickableSpan
{
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(317421);
    s.u(paramView, "widget");
    AppMethodBeat.o(317421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.an.a.a
 * JD-Core Version:    0.7.0.1
 */