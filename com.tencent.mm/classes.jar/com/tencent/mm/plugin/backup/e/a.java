package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.protocal.c.fm;
import com.tencent.mm.protocal.c.ri;
import com.tencent.mm.protocal.j.a;
import com.tencent.mm.protocal.j.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class a
  extends m
  implements k
{
  private f dmL;
  public com.tencent.mm.network.q edR = new a.a();
  
  public a(LinkedList<ri> paramLinkedList, String paramString1, String paramString2)
  {
    j.a locala = (j.a)this.edR.Kv();
    locala.spC = d.atr();
    locala.spB.syY = paramLinkedList.size();
    locala.spB.syZ = paramLinkedList;
    locala.spB.sza = com.tencent.mm.compatible.e.q.getDeviceID(ae.getContext());
    locala.spB.szb = com.tencent.mm.model.q.Gj();
    locala.spB.pyo = 2;
    locala.spB.hQm = 0L;
    locala.spB.szc = paramString1;
    locala.spB.szd = paramString2;
    locala.spL = locala.spC;
    locala.spK = new a.1(this, locala);
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.edR, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.BackupCreateQRCodeOfflineScene", "err: %d, %d, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    y.i("MicroMsg.BackupCreateQRCodeOfflineScene", "onGYNetEnd QRCodeUrl:%s", new Object[] { ((j.b)paramq.HF()).spD.szg });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.e.a
 * JD-Core Version:    0.7.0.1
 */