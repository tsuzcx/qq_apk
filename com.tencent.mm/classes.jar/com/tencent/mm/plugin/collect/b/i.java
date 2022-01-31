package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.mx;
import com.tencent.mm.protocal.c.my;
import com.tencent.mm.sdk.platformtools.y;

public final class i
  extends m
  implements k
{
  public String bHZ;
  public long brn;
  private f dmL;
  private com.tencent.mm.ah.b eWr;
  public my iHk;
  public long iHl;
  private long iHm;
  public int source;
  
  public i(int paramInt1, com.tencent.mm.bv.b paramb, String paramString, int paramInt2, long paramLong)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new mx();
    ((b.a)localObject).ecI = new my();
    ((b.a)localObject).ecG = 1384;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/getf2frcvvoice";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.eWr = ((b.a)localObject).Kt();
    localObject = (mx)this.eWr.ecE.ecN;
    ((mx)localObject).amount = paramInt1;
    ((mx)localObject).sKB = 0;
    ((mx)localObject).iHQ = paramString;
    ((mx)localObject).sKz = null;
    ((mx)localObject).sKA = paramb;
    this.bHZ = paramString;
    this.source = paramInt2;
    this.brn = paramLong;
    this.iHm = System.currentTimeMillis();
    y.i("MicroMsg.NetSceneF2FRcvVoice", "amount: %d, outtradeno: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneF2FRcvVoice", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.iHk = ((my)((com.tencent.mm.ah.b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneF2FRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", new Object[] { Integer.valueOf(this.iHk.iHq), this.iHk.iHr, Integer.valueOf(this.iHk.sKB) });
    this.iHl = (System.currentTimeMillis() - this.iHm);
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1384;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.b.i
 * JD-Core Version:    0.7.0.1
 */