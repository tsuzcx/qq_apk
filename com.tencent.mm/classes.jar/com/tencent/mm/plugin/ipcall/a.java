package com.tencent.mm.plugin.ipcall;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class a
  implements f
{
  private static a lod = null;
  private boolean dZI = false;
  private long lnZ = -1L;
  private long loa = -1L;
  private long lob = -1L;
  private long loc = -1L;
  
  public static a bbv()
  {
    if (lod == null) {
      lod = new a();
    }
    return lod;
  }
  
  private static void bbx()
  {
    long l = System.currentTimeMillis();
    au.Hx();
    c.Dz().c(ac.a.uqd, Long.valueOf(l));
  }
  
  public final void bbw()
  {
    if (!com.tencent.mm.plugin.ipcall.b.a.WS()) {
      y.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, can't sync addr book");
    }
    if (this.dZI)
    {
      y.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, updating");
      return;
    }
    long l = System.currentTimeMillis();
    au.Hx();
    if (Math.abs(l - ((Long)c.Dz().get(ac.a.uqd, Long.valueOf(0L))).longValue()) >= 86400000L)
    {
      this.dZI = true;
      this.lnZ = -1L;
      this.loa = -1L;
      this.lob = -1L;
      this.loc = -1L;
      au.Dk().a(32, this);
      e.post(new a.1(this), "IPCallAddressBookUpdater_updateUsername");
      return;
    }
    y.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, not reach time limit");
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.IPCallAddressBookUsernameUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.dZI) });
    if (!this.dZI) {
      return;
    }
    au.Dk().b(32, this);
    this.loa = System.currentTimeMillis();
    y.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend used %dms", new Object[] { Long.valueOf(this.loa - this.lnZ) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend failed");
      this.dZI = false;
      bbx();
      return;
    }
    e.post(new a.2(this), "IPCallAddressBookUsernameUpdater_updateUsernameAfterGetMFriend");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a
 * JD-Core Version:    0.7.0.1
 */