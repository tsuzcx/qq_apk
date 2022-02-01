package com.tencent.mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class a
  implements i
{
  private static a DOf = null;
  private long DOb = -1L;
  private long DOc = -1L;
  private long DOd = -1L;
  private long DOe = -1L;
  private boolean jJQ = false;
  
  public static a eID()
  {
    AppMethodBeat.i(25283);
    if (DOf == null) {
      DOf = new a();
    }
    a locala = DOf;
    AppMethodBeat.o(25283);
    return locala;
  }
  
  private static void eIE()
  {
    AppMethodBeat.i(25286);
    long l = System.currentTimeMillis();
    bh.beI();
    c.aHp().set(ar.a.Vjf, Long.valueOf(l));
    AppMethodBeat.o(25286);
  }
  
  public final void cAr()
  {
    AppMethodBeat.i(25284);
    if (!com.tencent.mm.plugin.ipcall.a.a.byl()) {
      Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, can't sync addr book");
    }
    if (this.jJQ)
    {
      Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, updating");
      AppMethodBeat.o(25284);
      return;
    }
    long l = System.currentTimeMillis();
    bh.beI();
    if (Math.abs(l - ((Long)c.aHp().get(ar.a.Vjf, Long.valueOf(0L))).longValue()) >= 86400000L)
    {
      this.jJQ = true;
      this.DOb = -1L;
      this.DOc = -1L;
      this.DOd = -1L;
      this.DOe = -1L;
      bh.aGY().a(32, this);
      ThreadPool.post(new a.1(this), "IPCallAddressBookUpdater_updateUsername");
      AppMethodBeat.o(25284);
      return;
    }
    Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, not reach time limit");
    AppMethodBeat.o(25284);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(25285);
    Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.jJQ) });
    if (!this.jJQ)
    {
      AppMethodBeat.o(25285);
      return;
    }
    bh.aGY().b(32, this);
    this.DOc = System.currentTimeMillis();
    Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend used %dms", new Object[] { Long.valueOf(this.DOc - this.DOb) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend failed");
      this.jJQ = false;
      eIE();
      AppMethodBeat.o(25285);
      return;
    }
    ThreadPool.post(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a
 * JD-Core Version:    0.7.0.1
 */