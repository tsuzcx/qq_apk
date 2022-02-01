package com.tencent.mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.jx;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class a
  implements i
{
  private static a yod = null;
  private boolean gYQ = false;
  private long ynZ = -1L;
  private long yoa = -1L;
  private long yob = -1L;
  private long yoc = -1L;
  
  public static a dZG()
  {
    AppMethodBeat.i(25283);
    if (yod == null) {
      yod = new a();
    }
    a locala = yod;
    AppMethodBeat.o(25283);
    return locala;
  }
  
  private static void dZH()
  {
    AppMethodBeat.i(25286);
    long l = System.currentTimeMillis();
    bg.aVF();
    c.azQ().set(ar.a.NVf, Long.valueOf(l));
    AppMethodBeat.o(25286);
  }
  
  public final void cmK()
  {
    AppMethodBeat.i(25284);
    if (!com.tencent.mm.plugin.ipcall.a.a.boc()) {
      Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, can't sync addr book");
    }
    if (this.gYQ)
    {
      Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, updating");
      AppMethodBeat.o(25284);
      return;
    }
    long l = System.currentTimeMillis();
    bg.aVF();
    if (Math.abs(l - ((Long)c.azQ().get(ar.a.NVf, Long.valueOf(0L))).longValue()) >= 86400000L)
    {
      this.gYQ = true;
      this.ynZ = -1L;
      this.yoa = -1L;
      this.yob = -1L;
      this.yoc = -1L;
      bg.azz().a(32, this);
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25281);
          Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "start GetMFriend");
          jx localjx = new jx();
          localjx.dOQ.scene = 2;
          EventCenter.instance.publish(localjx);
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
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(25285);
    Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.gYQ) });
    if (!this.gYQ)
    {
      AppMethodBeat.o(25285);
      return;
    }
    bg.azz().b(32, this);
    this.yoa = System.currentTimeMillis();
    Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend used %dms", new Object[] { Long.valueOf(this.yoa - this.ynZ) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend failed");
      this.gYQ = false;
      dZH();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a
 * JD-Core Version:    0.7.0.1
 */