package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/utils/FinderUtil$setToMachineTab$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
public final class n$i
  extends ClickableSpan
{
  n$i(a parama, TextView paramTextView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(203646);
    k.h(paramView, "widget");
    paramView = this.rQf;
    if (paramView != null)
    {
      paramView.invoke();
      AppMethodBeat.o(203646);
      return;
    }
    AppMethodBeat.o(203646);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(203647);
    k.h(paramTextPaint, "ds");
    Context localContext = this.rOY.getContext();
    k.g(localContext, "tv.context");
    paramTextPaint.setColor(localContext.getResources().getColor(2131099773));
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.clearShadowLayer();
    AppMethodBeat.o(203647);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.n.i
 * JD-Core Version:    0.7.0.1
 */