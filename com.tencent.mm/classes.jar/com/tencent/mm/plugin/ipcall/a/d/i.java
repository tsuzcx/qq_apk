package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.protocal.c.bfz;
import com.tencent.mm.protocal.c.bga;
import com.tencent.mm.sdk.platformtools.y;

public final class i
  extends m
  implements k
{
  private b dmK = null;
  private f dmL = null;
  public bfz lrF = null;
  public bga lrG = null;
  
  public i(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bfz();
    ((b.a)localObject).ecI = new bga();
    ((b.a)localObject).ecG = 991;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/pstninvite";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    long l = System.currentTimeMillis();
    int i = c.bdq();
    localObject = (bfz)this.dmK.ecE.ecN;
    ((bfz)localObject).kWn = com.tencent.mm.model.q.Gj();
    ((bfz)localObject).tAD = paramString2;
    ((bfz)localObject).kWm = paramString1;
    ((bfz)localObject).tAC = paramInt1;
    ((bfz)localObject).sNU = i;
    ((bfz)localObject).tAL = 1;
    ((bfz)localObject).tAB = l;
    ((bfz)localObject).tAK = paramInt2;
    ((bfz)localObject).tAM = paramInt3;
    this.lrF = ((bfz)localObject);
    y.i("MicroMsg.NetSceneIPCallInvite", "toUsername: %s, phoneNumber: %s, invitedId: %s, netType: %d, dialScene: %d, countryType: %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneIPCallInvite", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.lrG = ((bga)((b)paramq).ecF.ecN);
    if ((paramInt2 != 0) && (paramInt3 != 0)) {
      if (this.dmL != null) {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
    }
    while (this.dmL == null) {
      return;
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 991;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.d.i
 * JD-Core Version:    0.7.0.1
 */