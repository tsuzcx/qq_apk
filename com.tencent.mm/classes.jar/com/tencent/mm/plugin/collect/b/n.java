package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ne;
import com.tencent.mm.protocal.c.nf;
import com.tencent.mm.sdk.platformtools.y;

public final class n
  extends m
  implements k
{
  private final String TAG = "MicroMsg.NetSceneMDRcvVoice";
  public String bHZ;
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  public nf iHG;
  
  public n(int paramInt, com.tencent.mm.bv.b paramb, String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ne();
    ((b.a)localObject).ecI = new nf();
    ((b.a)localObject).ecG = 1317;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/getmdrcvvoice";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (ne)this.dmK.ecE.ecN;
    ((ne)localObject).amount = paramInt;
    ((ne)localObject).sKB = 0;
    ((ne)localObject).iHQ = paramString;
    ((ne)localObject).sKz = null;
    ((ne)localObject).sKA = paramb;
    this.bHZ = paramString;
    y.i("MicroMsg.NetSceneMDRcvVoice", "amount: %d, outtradeno: %s", new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneMDRcvVoice", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.iHG = ((nf)((com.tencent.mm.ah.b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneMDRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", new Object[] { Integer.valueOf(this.iHG.iHq), this.iHG.iHr, Integer.valueOf(this.iHG.sKB) });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1317;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.b.n
 * JD-Core Version:    0.7.0.1
 */