package com.tencent.mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.is;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class a
  implements g
{
  private static a szs = null;
  private boolean fOm = false;
  private long szo = -1L;
  private long szp = -1L;
  private long szq = -1L;
  private long szr = -1L;
  
  private static void cGA()
  {
    AppMethodBeat.i(25286);
    long l = System.currentTimeMillis();
    az.arV();
    c.afk().set(ae.a.Fiz, Long.valueOf(l));
    AppMethodBeat.o(25286);
  }
  
  public static a cGy()
  {
    AppMethodBeat.i(25283);
    if (szs == null) {
      szs = new a();
    }
    a locala = szs;
    AppMethodBeat.o(25283);
    return locala;
  }
  
  public final void cGz()
  {
    AppMethodBeat.i(25284);
    if (!com.tencent.mm.plugin.ipcall.a.a.aIO()) {
      ad.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, can't sync addr book");
    }
    if (this.fOm)
    {
      ad.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, updating");
      AppMethodBeat.o(25284);
      return;
    }
    long l = System.currentTimeMillis();
    az.arV();
    if (Math.abs(l - ((Long)c.afk().get(ae.a.Fiz, Long.valueOf(0L))).longValue()) >= 86400000L)
    {
      this.fOm = true;
      this.szo = -1L;
      this.szp = -1L;
      this.szq = -1L;
      this.szr = -1L;
      az.aeS().a(32, this);
      b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25281);
          ad.d("MicroMsg.IPCallAddressBookUsernameUpdater", "start GetMFriend");
          is localis = new is();
          localis.dmJ.scene = 2;
          com.tencent.mm.sdk.b.a.ESL.l(localis);
          a.a(a.this, System.currentTimeMillis());
          AppMethodBeat.o(25281);
        }
      }, "IPCallAddressBookUpdater_updateUsername");
      AppMethodBeat.o(25284);
      return;
    }
    ad.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, not reach time limit");
    AppMethodBeat.o(25284);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(25285);
    ad.d("MicroMsg.IPCallAddressBookUsernameUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.fOm) });
    if (!this.fOm)
    {
      AppMethodBeat.o(25285);
      return;
    }
    az.aeS().b(32, this);
    this.szp = System.currentTimeMillis();
    ad.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend used %dms", new Object[] { Long.valueOf(this.szp - this.szo) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend failed");
      this.fOm = false;
      cGA();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a
 * JD-Core Version:    0.7.0.1
 */