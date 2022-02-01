package com.tencent.mm.plugin.finder.live.c;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.boi;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/convert/LocationCommentConvert$setPoiIconSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$b
  extends ClickableSpan
{
  c$b(c paramc, Context paramContext, boi paramboi) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(371014);
    s.u(paramView, "widget");
    c.b(this.$context, this.aarv);
    AppMethodBeat.o(371014);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(371018);
    s.u(paramTextPaint, "ds");
    AppMethodBeat.o(371018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.c.c.b
 * JD-Core Version:    0.7.0.1
 */