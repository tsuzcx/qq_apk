package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.l.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SuppressLint({"AppCompatCustomView"})
final class u$b
  extends TextView
{
  private String mTitle;
  private String mValue;
  
  public u$b(u paramu, Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(147696);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    setTextSize(1, 12.0F);
    setTextColor(getContext().getResources().getColor(a.a.BW_100_Alpha_0_9));
    AppMethodBeat.o(147696);
  }
  
  private void update()
  {
    AppMethodBeat.i(147697);
    setText(String.format("%s: %s", new Object[] { this.mTitle, this.mValue }));
    AppMethodBeat.o(147697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.u.b
 * JD-Core Version:    0.7.0.1
 */