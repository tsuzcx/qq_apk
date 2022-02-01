package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/utils/FinderUtil$setToMachineTab$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
public final class p$k
  extends ClickableSpan
{
  p$k(a parama, TextView paramTextView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(205148);
    p.h(paramView, "widget");
    paramView = this.sXV;
    if (paramView != null)
    {
      paramView.invoke();
      AppMethodBeat.o(205148);
      return;
    }
    AppMethodBeat.o(205148);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(205149);
    p.h(paramTextPaint, "ds");
    Context localContext = this.sWG.getContext();
    p.g(localContext, "tv.context");
    paramTextPaint.setColor(localContext.getResources().getColor(2131099773));
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.clearShadowLayer();
    AppMethodBeat.o(205149);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.p.k
 * JD-Core Version:    0.7.0.1
 */