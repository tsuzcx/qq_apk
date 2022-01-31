package com.tencent.mm.modelappbrand;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bwq;
import com.tencent.mm.protocal.c.hf;
import com.tencent.mm.protocal.c.hg;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class o
  extends m
  implements k
{
  private f dIJ;
  private final b dZP;
  
  public o(LinkedList<bwq> paramLinkedList)
  {
    b.a locala = new b.a();
    locala.ecH = new hf();
    locala.ecI = new hg();
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchswitchservicenotifyoption";
    locala.ecG = 1176;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dZP = locala.Kt();
    ((hf)this.dZP.ecE.ecN).sAM = paramLinkedList;
  }
  
  public final int a(e parame, f paramf)
  {
    y.i("MicroMsg.NetSceneBatchSwitchServiceNotifyOption", "doScene");
    this.dIJ = paramf;
    return a(parame, this.dZP, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneBatchSwitchServiceNotifyOption", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.dIJ != null) {
      this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1176;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.o
 * JD-Core Version:    0.7.0.1
 */