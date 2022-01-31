package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.j.d;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bpi;
import com.tencent.mm.protocal.c.bpj;
import com.tencent.mm.protocal.c.bxz;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class e
  extends m
  implements k
{
  private String clientId = "";
  private b dmK;
  private f dmL;
  private long eFV = -1L;
  private s eFW = null;
  private d eFX = null;
  
  public e(long paramLong, s params, d paramd, String paramString)
  {
    y.i("MicroMsg.NetSceneMassUploadSight", "massSendId %d, clientId %s", new Object[] { Long.valueOf(paramLong), paramString });
    this.eFV = paramLong;
    this.eFW = params;
    this.eFX = paramd;
    this.clientId = paramString;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    int i = 0;
    this.dmL = paramf;
    paramf = new b.a();
    paramf.ecH = new bpi();
    paramf.ecI = new bpj();
    paramf.uri = "/cgi-bin/micromsg-bin/sendsight";
    paramf.ecG = 245;
    this.dmK = paramf.Kt();
    paramf = (bpi)this.dmK.ecE.ecN;
    paramf.dQR = this.eFX.field_aesKey;
    paramf.owY = this.clientId;
    paramf.bIW = this.eFW.bZs;
    paramf.tHm = this.eFW.eHH;
    o.Sr();
    Object localObject = t.nT(this.eFW.getFileName());
    BitmapFactory.Options localOptions = c.YU((String)localObject);
    if (localOptions != null)
    {
      paramf.dQQ = localOptions.outWidth;
      paramf.dQP = localOptions.outHeight;
    }
    for (;;)
    {
      paramf.eGn = this.eFW.eHE;
      localObject = bk.aM(this.eFW.eHP, "").split(",");
      if ((localObject != null) && (localObject.length > 0)) {
        break;
      }
      y.e("MicroMsg.NetSceneMassUploadSight", "cdn upload video done, massSendId[%d], split username fail", new Object[] { Long.valueOf(this.eFV) });
      return -1;
      y.w("MicroMsg.NetSceneMassUploadSight", "sight send getImageOptions for thumb failed path:%s", new Object[] { localObject });
    }
    int j = localObject.length;
    while (i < j)
    {
      localOptions = localObject[i];
      bxz localbxz = new bxz();
      localbxz.username = localOptions;
      paramf.tHl.add(localbxz);
      i += 1;
    }
    paramf.url = this.eFX.field_fileId;
    paramf.eHH = this.eFW.ebK;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneMassUploadSight", "cdntra onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " useCdnTransClientId:" + this.clientId + " massSendId " + this.eFV);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 245;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvideo.e
 * JD-Core Version:    0.7.0.1
 */