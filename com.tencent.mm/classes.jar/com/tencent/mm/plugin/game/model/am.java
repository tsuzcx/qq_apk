package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.zu;
import com.tencent.mm.protocal.c.zv;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class am
  extends m
  implements k
{
  public String bGm;
  private f dmL;
  public final b jvQ;
  
  public am(String paramString1, String paramString2, LinkedList<String> paramLinkedList)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new zu();
    ((b.a)localObject).ecI = new zv();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/gamecentersearchrecommend";
    ((b.a)localObject).ecG = 1329;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    if (paramString2 == null) {}
    for (this.bGm = "";; this.bGm = paramString2.trim())
    {
      this.jvQ = ((b.a)localObject).Kt();
      localObject = (zu)this.jvQ.ecE.ecN;
      ((zu)localObject).kUa = paramString1;
      ((zu)localObject).sYZ = paramString2;
      ((zu)localObject).sZa = paramLinkedList;
      return;
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.jvQ, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGameSearchRecmd", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1329;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.am
 * JD-Core Version:    0.7.0.1
 */