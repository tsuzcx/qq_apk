package com.tencent.mm.plugin.finder.live.c;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.protocal.protobuf.boi;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/convert/LocationCommentConvert$setCitySpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$a
  extends ClickableSpan
{
  c$a(c paramc, Context paramContext, boi paramboi) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(371008);
    s.u(paramView, "widget");
    c.b(this.$context, this.aarv);
    AppMethodBeat.o(371008);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(371011);
    s.u(paramTextPaint, "ds");
    paramTextPaint.setColor(this.$context.getResources().getColor(p.b.ByU));
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.clearShadowLayer();
    AppMethodBeat.o(371011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.c.c.a
 * JD-Core Version:    0.7.0.1
 */