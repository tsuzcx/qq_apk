package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bps;
import com.tencent.mm.protocal.c.bpt;
import com.tencent.mm.protocal.c.chm;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class m
  extends com.tencent.mm.ah.m
  implements k
{
  private b dmK = null;
  private f dmL;
  private bps lrN = null;
  public bpt lrO = null;
  
  public m(int paramInt1, int paramInt2, LinkedList<chm> paramLinkedList)
  {
    b.a locala = new b.a();
    locala.ecH = new bps();
    locala.ecI = new bpt();
    locala.ecG = 871;
    locala.uri = "/cgi-bin/micromsg-bin/sendwcofeedback";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.lrN = ((bps)this.dmK.ecE.ecN);
    this.lrN.ttq = paramInt2;
    this.lrN.tHt = paramLinkedList;
    this.lrN.tHs = paramLinkedList.size();
    this.lrN.tHu = paramInt1;
    y.i("MicroMsg.NetSceneIPCallSendFeedback", "NetSceneIPCallSendFeedback roomid=%d, level=%d, feedbackCount=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramLinkedList.size()) });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneIPCallSendFeedback", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.lrO = ((bpt)((b)paramq).ecF.ecN);
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 871;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.d.m
 * JD-Core Version:    0.7.0.1
 */