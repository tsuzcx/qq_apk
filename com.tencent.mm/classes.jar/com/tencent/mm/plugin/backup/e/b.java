package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.fl;
import com.tencent.mm.protocal.c.fn;
import com.tencent.mm.protocal.c.ri;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class b
  extends m
  implements k
{
  public com.tencent.mm.ah.b dmK;
  protected f dmL;
  
  public b(LinkedList<ri> paramLinkedList, String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new fl();
    ((b.a)localObject).ecI = new fn();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bakchatcreateqrcode";
    ((b.a)localObject).ecG = 704;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (fl)this.dmK.ecE.ecN;
    ((fl)localObject).syY = paramLinkedList.size();
    ((fl)localObject).syZ = paramLinkedList;
    ((fl)localObject).szb = com.tencent.mm.model.q.Gj();
    ((fl)localObject).sza = com.tencent.mm.compatible.e.q.getDeviceID(ae.getContext());
    ((fl)localObject).szc = paramString;
    ((fl)localObject).hQm = 0L;
    ((fl)localObject).pyo = 2;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.BackupCreateQRCodeScene", "err: %d, %d, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramq = (fn)this.dmK.ecF.ecN;
    y.i("MicroMsg.BackupCreateQRCodeScene", "onGYNetEnd QRCodeUrl:%s", new Object[] { paramq.szg });
    d.T(paramq.syK.tFM.oY);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 704;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.e.b
 * JD-Core Version:    0.7.0.1
 */