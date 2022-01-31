package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;

public final class d
  extends com.tencent.mm.plugin.backup.b.a
{
  private static String TAG = "MicroMsg.BackupStorageModel";
  private static d hMX;
  private b hMY;
  private a hMZ;
  
  public static d avi()
  {
    if (hMX == null)
    {
      d locald = new d();
      hMX = locald;
      a(locald);
    }
    return hMX;
  }
  
  public final void ati()
  {
    hMX = null;
  }
  
  public final b avj()
  {
    if (this.hMY == null) {
      this.hMY = new b();
    }
    return this.hMY;
  }
  
  public final a avk()
  {
    if (this.hMZ == null) {
      this.hMZ = new a();
    }
    return this.hMZ;
  }
  
  public final void avl()
  {
    y.i(TAG, "backupInitStorage");
    b localb = avj();
    au.Hx();
    String str = com.tencent.mm.model.c.FU();
    au.Hx();
    int i = com.tencent.mm.model.c.CK();
    y.i("MicroMsg.BackupStorage", "setBackupStorage, accPath:%s, accUin:%d, caller:%s", new Object[] { str, Integer.valueOf(i), bk.csb() });
    localb.uin = i;
    localb.dKt = str;
    au.Hx();
    localb.dKu = com.tencent.mm.model.c.Dv();
    au.Hx();
    localb.hMK = com.tencent.mm.model.c.Dz();
    au.Hx();
    localb.hML = com.tencent.mm.model.c.Fw();
    au.Hx();
    localb.hMN = com.tencent.mm.model.c.FB();
    au.Hx();
    localb.hMM = com.tencent.mm.model.c.Fy();
    au.Hx();
    localb.hMQ = com.tencent.mm.model.c.FE();
    localb.hMO = com.tencent.mm.as.o.OJ();
    localb.hMP = i.getEmojiStorageMgr().uBb;
    localb.hMS = ((com.tencent.mm.plugin.chatroom.a.c)g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF();
    localb.hMR = com.tencent.mm.modelvideo.o.Sr();
    localb.hMT = com.tencent.mm.plugin.z.a.bro();
    localb.hMU = com.tencent.mm.plugin.z.a.brn();
    localb.hMV = com.tencent.mm.plugin.z.a.avh();
    au.Hx();
    localb.hMW = com.tencent.mm.model.c.Gb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.d
 * JD-Core Version:    0.7.0.1
 */