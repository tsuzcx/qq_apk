package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.bl;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class ar
  extends m
  implements k
{
  private f dmL;
  public final b jvQ;
  
  public ar(int paramInt1, LinkedList<String> paramLinkedList, int paramInt2, boolean paramBoolean)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new com.tencent.mm.plugin.game.d.bk();
    ((b.a)localObject).ecI = new bl();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/newgetlibgamelist";
    ((b.a)localObject).ecG = 1218;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.jvQ = ((b.a)localObject).Kt();
    localObject = (com.tencent.mm.plugin.game.d.bk)this.jvQ.ecE.ecN;
    ((com.tencent.mm.plugin.game.d.bk)localObject).kUT = paramInt1;
    ((com.tencent.mm.plugin.game.d.bk)localObject).kUU = 15;
    ((com.tencent.mm.plugin.game.d.bk)localObject).kUa = x.cqJ();
    ((com.tencent.mm.plugin.game.d.bk)localObject).ffq = com.tencent.mm.sdk.platformtools.bk.fS(ae.getContext());
    ((com.tencent.mm.plugin.game.d.bk)localObject).kUV = paramInt2;
    ((com.tencent.mm.plugin.game.d.bk)localObject).kUD = paramLinkedList;
    ((com.tencent.mm.plugin.game.d.bk)localObject).kUW = paramBoolean;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.jvQ, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetLibGameList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1218;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ar
 * JD-Core Version:    0.7.0.1
 */