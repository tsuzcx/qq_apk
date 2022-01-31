package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i$a
  implements i.b
{
  i$a(i parami) {}
  
  public final void a(i.c paramc, Context paramContext)
  {
    AppMethodBeat.i(43029);
    int i = paramContext.getResources().getColor(2131690232);
    int j = paramContext.getResources().getColor(2131690233);
    int k = paramContext.getResources().getColor(2131690247);
    paramc.ldP.setBackgroundResource(2131690605);
    paramc.ldP.setPadding(0, paramContext.getResources().getDimensionPixelOffset(2131427792), 0, paramContext.getResources().getDimensionPixelOffset(2131427792));
    paramc.nzx.setTextColor(i);
    paramc.ojf.setTextColor(j);
    paramc.ojg.setTextColor(i);
    paramc.ojh.setTextColor(i);
    paramc.oji.setTextColor(k);
    AppMethodBeat.o(43029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.i.a
 * JD-Core Version:    0.7.0.1
 */