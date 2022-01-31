package com.tencent.mm.plugin.brandservice.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.avc;
import com.tencent.mm.protocal.c.avf;
import com.tencent.mm.protocal.c.avg;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class k
  extends m
  implements com.tencent.mm.network.k
{
  public b dmK;
  private f dmL;
  
  public k(String paramString, LinkedList<avc> paramLinkedList)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new avf();
    ((b.a)localObject).ecI = new avg();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/setrecvtmpmsgoption";
    ((b.a)localObject).ecG = 1030;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (avf)this.dmK.ecE.ecN;
    ((avf)localObject).tlP = paramString;
    ((avf)localObject).tqK = paramLinkedList;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    y.i("MicroMsg.brandservice.NetSceneSetRecvTmpMsgOption", "do scene");
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.brandservice.NetSceneSetRecvTmpMsgOption", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1030;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.k
 * JD-Core Version:    0.7.0.1
 */