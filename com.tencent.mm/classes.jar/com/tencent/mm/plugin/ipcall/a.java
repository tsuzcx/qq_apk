package com.tencent.mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class a
  implements f
{
  private static a nLA = null;
  private boolean fpN = false;
  private long nLw = -1L;
  private long nLx = -1L;
  private long nLy = -1L;
  private long nLz = -1L;
  
  public static a bID()
  {
    AppMethodBeat.i(21660);
    if (nLA == null) {
      nLA = new a();
    }
    a locala = nLA;
    AppMethodBeat.o(21660);
    return locala;
  }
  
  private static void bIF()
  {
    AppMethodBeat.i(21663);
    long l = System.currentTimeMillis();
    aw.aaz();
    c.Ru().set(ac.a.yAd, Long.valueOf(l));
    AppMethodBeat.o(21663);
  }
  
  public final void bIE()
  {
    AppMethodBeat.i(21661);
    if (!com.tencent.mm.plugin.ipcall.b.a.aqt()) {
      ab.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, can't sync addr book");
    }
    if (this.fpN)
    {
      ab.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, updating");
      AppMethodBeat.o(21661);
      return;
    }
    long l = System.currentTimeMillis();
    aw.aaz();
    if (Math.abs(l - ((Long)c.Ru().get(ac.a.yAd, Long.valueOf(0L))).longValue()) >= 86400000L)
    {
      this.fpN = true;
      this.nLw = -1L;
      this.nLx = -1L;
      this.nLy = -1L;
      this.nLz = -1L;
      aw.Rc().a(32, this);
      d.post(new a.1(this), "IPCallAddressBookUpdater_updateUsername");
      AppMethodBeat.o(21661);
      return;
    }
    ab.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, not reach time limit");
    AppMethodBeat.o(21661);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(21662);
    ab.d("MicroMsg.IPCallAddressBookUsernameUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.fpN) });
    if (!this.fpN)
    {
      AppMethodBeat.o(21662);
      return;
    }
    aw.Rc().b(32, this);
    this.nLx = System.currentTimeMillis();
    ab.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend used %dms", new Object[] { Long.valueOf(this.nLx - this.nLw) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend failed");
      this.fpN = false;
      bIF();
      AppMethodBeat.o(21662);
      return;
    }
    d.post(new a.2(this), "IPCallAddressBookUsernameUpdater_updateUsernameAfterGetMFriend");
    AppMethodBeat.o(21662);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a
 * JD-Core Version:    0.7.0.1
 */