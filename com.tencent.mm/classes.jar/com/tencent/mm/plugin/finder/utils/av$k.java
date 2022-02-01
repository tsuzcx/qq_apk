package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/utils/FinderUtil$setToTargetTab$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class av$k
  extends ClickableSpan
{
  av$k(a<ah> parama, TextView paramTextView, boolean paramBoolean) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(333384);
    s.u(paramView, "widget");
    paramView = this.Yu;
    if (paramView != null) {
      paramView.invoke();
    }
    AppMethodBeat.o(333384);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(333394);
    s.u(paramTextPaint, "ds");
    Resources localResources = this.AXx.getContext().getResources();
    if (this.Gjf) {}
    for (int i = e.b.Link_100_Night_Mode;; i = e.b.Link_100)
    {
      paramTextPaint.setColor(localResources.getColor(i));
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.clearShadowLayer();
      AppMethodBeat.o(333394);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.av.k
 * JD-Core Version:    0.7.0.1
 */