package com.tencent.mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ji;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public final class a
  implements f
{
  private static a uVC = null;
  private boolean gnW = false;
  private long uVA = -1L;
  private long uVB = -1L;
  private long uVy = -1L;
  private long uVz = -1L;
  
  public static a dfM()
  {
    AppMethodBeat.i(25283);
    if (uVC == null) {
      uVC = new a();
    }
    a locala = uVC;
    AppMethodBeat.o(25283);
    return locala;
  }
  
  private static void dfN()
  {
    AppMethodBeat.i(25286);
    long l = System.currentTimeMillis();
    bc.aCg();
    c.ajA().set(am.a.INc, Long.valueOf(l));
    AppMethodBeat.o(25286);
  }
  
  public final void bPy()
  {
    AppMethodBeat.i(25284);
    if (!com.tencent.mm.plugin.ipcall.a.a.aTq()) {
      ae.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, can't sync addr book");
    }
    if (this.gnW)
    {
      ae.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, updating");
      AppMethodBeat.o(25284);
      return;
    }
    long l = System.currentTimeMillis();
    bc.aCg();
    if (Math.abs(l - ((Long)c.ajA().get(am.a.INc, Long.valueOf(0L))).longValue()) >= 86400000L)
    {
      this.gnW = true;
      this.uVy = -1L;
      this.uVz = -1L;
      this.uVA = -1L;
      this.uVB = -1L;
      bc.ajj().a(32, this);
      b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25281);
          ae.d("MicroMsg.IPCallAddressBookUsernameUpdater", "start GetMFriend");
          ji localji = new ji();
          localji.dxj.scene = 2;
          com.tencent.mm.sdk.b.a.IvT.l(localji);
          a.a(a.this, System.currentTimeMillis());
          AppMethodBeat.o(25281);
        }
      }, "IPCallAddressBookUpdater_updateUsername");
      AppMethodBeat.o(25284);
      return;
    }
    ae.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, not reach time limit");
    AppMethodBeat.o(25284);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(25285);
    ae.d("MicroMsg.IPCallAddressBookUsernameUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.gnW) });
    if (!this.gnW)
    {
      AppMethodBeat.o(25285);
      return;
    }
    bc.ajj().b(32, this);
    this.uVz = System.currentTimeMillis();
    ae.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend used %dms", new Object[] { Long.valueOf(this.uVz - this.uVy) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ae.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend failed");
      this.gnW = false;
      dfN();
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