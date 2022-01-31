package com.tencent.mm.plugin.ext.c.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.on;
import com.tencent.mm.protocal.c.oo;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends m
  implements k
{
  private b dmK;
  public f dmL;
  public int jLn = -1;
  public String mUrl = null;
  
  public a(String paramString, int paramInt1, int paramInt2)
  {
    this.mUrl = paramString;
    b.a locala = new b.a();
    locala.ecH = new on();
    locala.ecI = new oo();
    locala.uri = "/cgi-bin/micromsg-bin/checkcamerascan";
    locala.ecG = 782;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    y.i("MicroMsg.NetSceneCheckUrlAvailableInWx", "hy: checking url: %s", new Object[] { paramString });
    paramString = (on)this.dmK.ecE.ecN;
    paramString.URL = this.mUrl;
    paramString.sLZ = paramInt1;
    paramString.sMa = paramInt2;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneCheckUrlAvailableInWx", "hy: on get camera url end. errType; %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (oo)((b)paramq).ecF.ecN;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.jLn = paramq.hQR;
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 782;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.c.a.a
 * JD-Core Version:    0.7.0.1
 */