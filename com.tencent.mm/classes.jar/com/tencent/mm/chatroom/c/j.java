package com.tencent.mm.chatroom.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.adz;
import com.tencent.mm.protocal.c.aea;
import com.tencent.mm.sdk.platformtools.y;

public final class j
  extends m
  implements k
{
  public String chatroomName;
  private final b dmK;
  private f dmL = null;
  public String dmU;
  public int dmV;
  public int dmW;
  public int status;
  
  public j(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new adz();
    locala.ecI = new aea();
    locala.uri = "/cgi-bin/micromsg-bin/getchatroomupgradestatus";
    locala.ecG = 519;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.chatroomName = paramString;
    ((adz)this.dmK.ecE.ecN).svm = paramString;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramq = (aea)this.dmK.ecF.ecN;
    y.d("MicroMsg.NetSceneGetChatRoomUpgradeStatus", "NetSceneGetChatRoomUpgradeStatus onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.status = paramq.hQq;
    this.dmU = paramq.tcg;
    this.dmW = paramq.tch;
    this.dmU = paramq.tcg;
    this.dmV = paramq.tcf;
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 519;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.j
 * JD-Core Version:    0.7.0.1
 */