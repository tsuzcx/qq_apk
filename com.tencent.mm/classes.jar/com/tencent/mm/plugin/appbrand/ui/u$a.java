package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.l.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;

@SuppressLint({"AppCompatCustomView"})
final class u$a
  extends TextView
{
  public u$a(u paramu, Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(147694);
    paramu = new LinearLayout.LayoutParams(-1, -2);
    int i = a.fromDPToPix(getContext(), 5);
    paramu.setMargins(0, i, 0, i);
    setLayoutParams(paramu);
    setTextSize(1, 12.0F);
    setTextColor(getContext().getResources().getColor(a.a.desc_text_color));
    AppMethodBeat.o(147694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.u.a
 * JD-Core Version:    0.7.0.1
 */