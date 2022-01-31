package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.i;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
  extends a
{
  public final void b(c paramc)
  {
    AppMethodBeat.i(21904);
    if (paramc != null)
    {
      if (paramc.nNc == 0) {
        paramc.nNc = ((int)System.currentTimeMillis());
      }
      i locali = new i(paramc.cGY, paramc.nNB, paramc.nNc, paramc.nNd, paramc.nNe);
      aw.Rc().a(locali, 0);
      ab.d("MicroMsg.IPCallInviteService", "start invite, toUsername: %s, toPhoneNumber: %s, inviteid: %d", new Object[] { paramc.cGY, paramc.nNB, Integer.valueOf(paramc.nNc) });
    }
    AppMethodBeat.o(21904);
  }
  
  public final int[] bJz()
  {
    return new int[] { 991 };
  }
  
  public final int getServiceType()
  {
    return 1;
  }
  
  public final void onDestroy() {}
  
  public final void tW() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.f.d
 * JD-Core Version:    0.7.0.1
 */