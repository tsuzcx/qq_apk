package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.cb.a;

final class j$a
  extends TextView
{
  public j$a(j paramj, Context paramContext)
  {
    super(paramContext);
    paramj = new LinearLayout.LayoutParams(-1, -2);
    int i = a.fromDPToPix(getContext(), 5);
    paramj.setMargins(0, i, 0, i);
    setLayoutParams(paramj);
    setTextSize(1, 12.0F);
    setTextColor(-7171438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.j.a
 * JD-Core Version:    0.7.0.1
 */