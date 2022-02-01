package com.tencent.mm.live.view.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/view/adapter/LiveCommentAdapter$sysSpan$1", "Landroid/text/style/CharacterStyle;", "updateDrawState", "", "tp", "Landroid/text/TextPaint;", "plugin-logic_release"})
public final class c$b
  extends CharacterStyle
{
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(216689);
    Context localContext = ak.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    int i = localContext.getResources().getColor(2131100483);
    if (paramTextPaint != null) {
      paramTextPaint.setColor(i);
    }
    if (paramTextPaint != null)
    {
      paramTextPaint.setUnderlineText(false);
      AppMethodBeat.o(216689);
      return;
    }
    AppMethodBeat.o(216689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.a.c.b
 * JD-Core Version:    0.7.0.1
 */