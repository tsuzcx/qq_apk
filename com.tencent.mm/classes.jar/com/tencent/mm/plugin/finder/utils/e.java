package com.tencent.mm.plugin.finder.utils;

import android.graphics.Paint;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ao;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"setTextBold", "", "Landroid/widget/TextView;", "setTextNormal", "plugin-finder_release"})
public final class e
{
  public static final void n(TextView paramTextView)
  {
    AppMethodBeat.i(253386);
    p.h(paramTextView, "$this$setTextBold");
    ao.a((Paint)paramTextView.getPaint(), 0.8F);
    AppMethodBeat.o(253386);
  }
  
  public static final void o(TextView paramTextView)
  {
    AppMethodBeat.i(253387);
    p.h(paramTextView, "$this$setTextNormal");
    ao.b((Paint)paramTextView.getPaint());
    AppMethodBeat.o(253387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.e
 * JD-Core Version:    0.7.0.1
 */