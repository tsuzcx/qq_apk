package com.tencent.mm.plugin.ipcall;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.ipcall.a.f;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.ui.a;
import com.tencent.mm.plugin.voip.ui.h;
import com.tencent.mm.sdk.platformtools.ae;

final class c$5
  implements a
{
  c$5(c paramc) {}
  
  public final void a(Intent paramIntent, h paramh)
  {
    if (!i.bck().bcd())
    {
      paramh.Qb(ae.getContext().getString(R.l.multitalk_waiting_wording));
      return;
    }
    int i = this.lor.bbK();
    paramh.Qc(String.format("%02d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }));
  }
  
  public final boolean bbL()
  {
    return i.bck().bca();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.c.5
 * JD-Core Version:    0.7.0.1
 */