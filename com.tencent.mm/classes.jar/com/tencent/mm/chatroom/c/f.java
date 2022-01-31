package com.tencent.mm.chatroom.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aoa;
import com.tencent.mm.protocal.c.qy;
import com.tencent.mm.protocal.c.qz;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
  extends com.tencent.mm.ah.m
  implements k
{
  private LinkedList<aoa> bSI;
  private final b dmK;
  private com.tencent.mm.ah.f dmL;
  
  public f(LinkedList<aoa> paramLinkedList)
  {
    this.bSI = paramLinkedList;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new qy();
    ((b.a)localObject).ecI = new qz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/collectchatroom";
    ((b.a)localObject).ecG = 181;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (qy)this.dmK.ecE.ecN;
    ((qy)localObject).sOG = paramLinkedList;
    ((qy)localObject).sOF = paramLinkedList.size();
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneCollectChatRoom", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if (paramq.HF().spN != 0)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if (this.bSI != null)
    {
      paramq = this.bSI.iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (aoa)paramq.next();
        y.d("MicroMsg.NetSceneCollectChatRoom", "del groupcard Name :" + paramArrayOfByte.tjT);
        com.tencent.mm.model.m.gH(paramArrayOfByte.tjT);
      }
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 181;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.f
 * JD-Core Version:    0.7.0.1
 */