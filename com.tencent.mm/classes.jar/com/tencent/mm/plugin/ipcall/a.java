package com.tencent.mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.jh;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class a
  implements f
{
  private static a uJP = null;
  private boolean glB = false;
  private long uJL = -1L;
  private long uJM = -1L;
  private long uJN = -1L;
  private long uJO = -1L;
  
  public static a dcU()
  {
    AppMethodBeat.i(25283);
    if (uJP == null) {
      uJP = new a();
    }
    a locala = uJP;
    AppMethodBeat.o(25283);
    return locala;
  }
  
  private static void dcV()
  {
    AppMethodBeat.i(25286);
    long l = System.currentTimeMillis();
    ba.aBQ();
    c.ajl().set(al.a.IsG, Long.valueOf(l));
    AppMethodBeat.o(25286);
  }
  
  public final void bOA()
  {
    AppMethodBeat.i(25284);
    if (!com.tencent.mm.plugin.ipcall.a.a.aSR()) {
      ad.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, can't sync addr book");
    }
    if (this.glB)
    {
      ad.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, updating");
      AppMethodBeat.o(25284);
      return;
    }
    long l = System.currentTimeMillis();
    ba.aBQ();
    if (Math.abs(l - ((Long)c.ajl().get(al.a.IsG, Long.valueOf(0L))).longValue()) >= 86400000L)
    {
      this.glB = true;
      this.uJL = -1L;
      this.uJM = -1L;
      this.uJN = -1L;
      this.uJO = -1L;
      ba.aiU().a(32, this);
      b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25281);
          ad.d("MicroMsg.IPCallAddressBookUsernameUpdater", "start GetMFriend");
          jh localjh = new jh();
          localjh.dwe.scene = 2;
          com.tencent.mm.sdk.b.a.IbL.l(localjh);
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
    ad.d("MicroMsg.IPCallAddressBookUsernameUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.glB) });
    if (!this.glB)
    {
      AppMethodBeat.o(25285);
      return;
    }
    ba.aiU().b(32, this);
    this.uJM = System.currentTimeMillis();
    ad.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend used %dms", new Object[] { Long.valueOf(this.uJM - this.uJL) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend failed");
      this.glB = false;
      dcV();
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