package com.tencent.mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.iz;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public final class a
  implements g
{
  private static a tHc = null;
  private boolean fRX = false;
  private long tGY = -1L;
  private long tGZ = -1L;
  private long tHa = -1L;
  private long tHb = -1L;
  
  public static a cTI()
  {
    AppMethodBeat.i(25283);
    if (tHc == null) {
      tHc = new a();
    }
    a locala = tHc;
    AppMethodBeat.o(25283);
    return locala;
  }
  
  private static void cTK()
  {
    AppMethodBeat.i(25286);
    long l = System.currentTimeMillis();
    az.ayM();
    c.agA().set(ah.a.GGo, Long.valueOf(l));
    AppMethodBeat.o(25286);
  }
  
  public final void cTJ()
  {
    AppMethodBeat.i(25284);
    if (!com.tencent.mm.plugin.ipcall.a.a.aPF()) {
      ac.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, can't sync addr book");
    }
    if (this.fRX)
    {
      ac.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, updating");
      AppMethodBeat.o(25284);
      return;
    }
    long l = System.currentTimeMillis();
    az.ayM();
    if (Math.abs(l - ((Long)c.agA().get(ah.a.GGo, Long.valueOf(0L))).longValue()) >= 86400000L)
    {
      this.fRX = true;
      this.tGY = -1L;
      this.tGZ = -1L;
      this.tHa = -1L;
      this.tHb = -1L;
      az.agi().a(32, this);
      b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25281);
          ac.d("MicroMsg.IPCallAddressBookUsernameUpdater", "start GetMFriend");
          iz localiz = new iz();
          localiz.dkr.scene = 2;
          com.tencent.mm.sdk.b.a.GpY.l(localiz);
          a.a(a.this, System.currentTimeMillis());
          AppMethodBeat.o(25281);
        }
      }, "IPCallAddressBookUpdater_updateUsername");
      AppMethodBeat.o(25284);
      return;
    }
    ac.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, not reach time limit");
    AppMethodBeat.o(25284);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(25285);
    ac.d("MicroMsg.IPCallAddressBookUsernameUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.fRX) });
    if (!this.fRX)
    {
      AppMethodBeat.o(25285);
      return;
    }
    az.agi().b(32, this);
    this.tGZ = System.currentTimeMillis();
    ac.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend used %dms", new Object[] { Long.valueOf(this.tGZ - this.tGY) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ac.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend failed");
      this.fRX = false;
      cTK();
      AppMethodBeat.o(25285);
      return;
    }
    b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25282);
        a.a(a.this);
        AppMethodBeat.o(25282);
      }
    }, "IPCallAddressBookUsernameUpdater_updateUsernameAfterGetMFriend");
    AppMethodBeat.o(25285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a
 * JD-Core Version:    0.7.0.1
 */