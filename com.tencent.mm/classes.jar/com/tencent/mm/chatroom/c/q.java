package com.tencent.mm.chatroom.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.c.cal;
import com.tencent.mm.protocal.c.cam;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.u;

public final class q
  extends com.tencent.mm.ah.m
  implements k
{
  public String chatroomName = null;
  private final b dmK;
  private f dmL = null;
  public String dmU = null;
  public String dnf = null;
  public int dng = 0;
  public int dnh = 0;
  
  public q(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new cal();
    locala.ecI = new cam();
    locala.uri = "/cgi-bin/micromsg-bin/upgradechatroom";
    locala.ecG = 482;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.chatroomName = paramString;
    ((cal)this.dmK.ecE.ecN).svm = paramString;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    cam localcam = (cam)this.dmK.ecF.ecN;
    y.d("MicroMsg.NetSceneUpgradeChatroom", "NetSceneUpgradeChatroom onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dnf = localcam.tts;
    if (!bk.bl(this.dnf))
    {
      paramArrayOfByte = ((c)g.r(c.class)).FF().in(this.chatroomName);
      paramq = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        paramq = new u();
      }
      paramq.gn(com.tencent.mm.model.q.Gj(), this.dnf);
      com.tencent.mm.model.m.a(paramq);
    }
    this.dmU = localcam.tcg;
    this.dng = localcam.tcf;
    this.dnh = localcam.tch;
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 482;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.q
 * JD-Core Version:    0.7.0.1
 */