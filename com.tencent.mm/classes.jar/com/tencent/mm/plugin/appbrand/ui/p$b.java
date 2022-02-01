package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SuppressLint({"AppCompatCustomView"})
final class p$b
  extends TextView
{
  private String mTitle;
  private String mValue;
  
  public p$b(p paramp, Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(147696);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    setTextSize(1, 12.0F);
    setTextColor(getContext().getResources().getColor(2131099674));
    AppMethodBeat.o(147696);
  }
  
  private void update()
  {
    AppMethodBeat.i(147697);
    setText(String.format("%s: %s", new Object[] { this.mTitle, this.mValue }));
    AppMethodBeat.o(147697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.p.b
 * JD-Core Version:    0.7.0.1
 */