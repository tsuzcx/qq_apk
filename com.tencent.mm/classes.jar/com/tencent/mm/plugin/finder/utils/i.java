package com.tencent.mm.plugin.finder.utils;

import android.graphics.Paint;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"setTextBold", "", "Landroid/widget/TextView;", "setTextRegular", "plugin-finder-base_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final void setTextBold(TextView paramTextView)
  {
    AppMethodBeat.i(333777);
    s.u(paramTextView, "<this>");
    aw.a((Paint)paramTextView.getPaint(), 0.8F);
    AppMethodBeat.o(333777);
  }
  
  public static final void w(TextView paramTextView)
  {
    AppMethodBeat.i(333781);
    s.u(paramTextView, "<this>");
    aw.e((Paint)paramTextView.getPaint());
    AppMethodBeat.o(333781);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.i
 * JD-Core Version:    0.7.0.1
 */