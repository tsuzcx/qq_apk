package com.tencent.mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.lr;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class a
  implements h
{
  private static a JFu = null;
  private long JFq = -1L;
  private long JFr = -1L;
  private long JFs = -1L;
  private long JFt = -1L;
  private boolean mjj = false;
  
  public static a fQE()
  {
    AppMethodBeat.i(25283);
    if (JFu == null) {
      JFu = new a();
    }
    a locala = JFu;
    AppMethodBeat.o(25283);
    return locala;
  }
  
  private static void fQF()
  {
    AppMethodBeat.i(25286);
    long l = System.currentTimeMillis();
    bh.bCz();
    c.ban().set(at.a.acKz, Long.valueOf(l));
    AppMethodBeat.o(25286);
  }
  
  public final void ddr()
  {
    AppMethodBeat.i(25284);
    if (!com.tencent.mm.plugin.ipcall.a.a.bWY()) {
      Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, can't sync addr book");
    }
    if (this.mjj)
    {
      Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, updating");
      AppMethodBeat.o(25284);
      return;
    }
    long l = System.currentTimeMillis();
    bh.bCz();
    if (Math.abs(l - ((Long)c.ban().get(at.a.acKz, Long.valueOf(0L))).longValue()) >= 86400000L)
    {
      this.mjj = true;
      this.JFq = -1L;
      this.JFr = -1L;
      this.JFs = -1L;
      this.JFt = -1L;
      bh.aZW().a(32, this);
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25281);
          Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "start GetMFriend");
          lr locallr = new lr();
          locallr.hNB.scene = 2;
          locallr.publish();
          a.a(a.this, System.currentTimeMillis());
          AppMethodBeat.o(25281);
        }
      }, "IPCallAddressBookUpdater_updateUsername");
      AppMethodBeat.o(25284);
      return;
    }
    Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, not reach time limit");
    AppMethodBeat.o(25284);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(25285);
    Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.mjj) });
    if (!this.mjj)
    {
      AppMethodBeat.o(25285);
      return;
    }
    bh.aZW().b(32, this);
    this.JFr = System.currentTimeMillis();
    Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend used %dms", new Object[] { Long.valueOf(this.JFr - this.JFq) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend failed");
      this.mjj = false;
      fQF();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a
 * JD-Core Version:    0.7.0.1
 */