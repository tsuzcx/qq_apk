package com.tencent.mm.plugin.finder.utils;

import android.graphics.Paint;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"setTextBold", "", "Landroid/widget/TextView;", "setTextRegular", "plugin-finder_release"})
public final class f
{
  public static final void i(TextView paramTextView)
  {
    AppMethodBeat.i(290787);
    p.k(paramTextView, "$this$setTextBold");
    ar.a((Paint)paramTextView.getPaint(), 0.8F);
    AppMethodBeat.o(290787);
  }
  
  public static final void t(TextView paramTextView)
  {
    AppMethodBeat.i(290788);
    p.k(paramTextView, "$this$setTextRegular");
    ar.b((Paint)paramTextView.getPaint());
    AppMethodBeat.o(290788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.f
 * JD-Core Version:    0.7.0.1
 */