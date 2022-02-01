package com.tencent.mm.plugin.finder.feed;

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

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback$setClickSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ai$b$f
  extends ClickableSpan
{
  ai$b$f(a<ah> parama, TextView paramTextView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(362719);
    s.u(paramView, "widget");
    this.Yu.invoke();
    AppMethodBeat.o(362719);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(362728);
    s.u(paramTextPaint, "ds");
    paramTextPaint.setColor(this.AXx.getContext().getResources().getColor(e.b.Link_100));
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.clearShadowLayer();
    AppMethodBeat.o(362728);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ai.b.f
 * JD-Core Version:    0.7.0.1
 */