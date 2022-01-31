package com.tencent.mm.plugin.ipcall;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.f;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class c$3
  implements Runnable
{
  c$3(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(21667);
    if (!i.bJr().bJk())
    {
      ab.i("MicroMsg.IPCallManager", "timeout! still not accept!");
      if (this.nLN.ex(9, 12)) {
        this.nLN.d(9, null, ah.getContext().getString(2131297835), 2);
      }
    }
    AppMethodBeat.o(21667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.c.3
 * JD-Core Version:    0.7.0.1
 */