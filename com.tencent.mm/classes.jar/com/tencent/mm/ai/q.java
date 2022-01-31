package com.tencent.mm.ai;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.model.bf;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.qj;
import com.tencent.mm.protocal.c.qk;
import com.tencent.mm.protocal.c.ql;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.s;
import java.util.LinkedList;

public final class q
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  
  public q(String paramString1, int paramInt1, String paramString2, LinkedList<qj> paramLinkedList, int paramInt2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new qk();
    ((b.a)localObject).ecI = new ql();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/clickcommand";
    ((b.a)localObject).ecG = 359;
    ((b.a)localObject).ecJ = 176;
    ((b.a)localObject).ecK = 1000000176;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (qk)this.dmK.ecE.ecN;
    ((qk)localObject).sOl = paramInt1;
    ((qk)localObject).sOm = paramString2;
    ((qk)localObject).sCE = paramString1;
    ((qk)localObject).svK = bf.HR();
    ((qk)localObject).scene = paramInt2;
    ((qk)localObject).sOo = s.getSessionId();
    if (paramLinkedList != null) {
      ((qk)localObject).sOn = paramLinkedList;
    }
    y.i("MicroMsg.NetSceneBizClickCommand", "click command : %s, type: %s, info: %s, MsgSource : %s, MsgReport size %d, scene %d", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, ((qk)localObject).svK, Integer.valueOf(((qk)localObject).sOn.size()), Integer.valueOf(paramInt2) });
  }
  
  public q(String paramString1, String paramString2)
  {
    this(paramString1, 1, paramString2, null, 0);
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 359;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ai.q
 * JD-Core Version:    0.7.0.1
 */