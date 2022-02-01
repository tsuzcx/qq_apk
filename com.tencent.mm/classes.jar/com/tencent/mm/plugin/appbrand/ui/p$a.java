package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;

@SuppressLint({"AppCompatCustomView"})
final class p$a
  extends TextView
{
  public p$a(p paramp, Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(147694);
    paramp = new LinearLayout.LayoutParams(-1, -2);
    int i = a.fromDPToPix(getContext(), 5);
    paramp.setMargins(0, i, 0, i);
    setLayoutParams(paramp);
    setTextSize(1, 12.0F);
    setTextColor(getContext().getResources().getColor(2131100212));
    AppMethodBeat.o(147694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.p.a
 * JD-Core Version:    0.7.0.1
 */