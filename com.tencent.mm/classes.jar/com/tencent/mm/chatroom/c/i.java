package com.tencent.mm.chatroom.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.adv;
import com.tencent.mm.protocal.c.adw;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class i
  extends com.tencent.mm.ah.m
  implements k
{
  private final b dmK;
  private f dmL;
  public String dmP;
  public int dmQ;
  public String dmR;
  public int dmS;
  private String dmT = "";
  
  public i(String paramString)
  {
    b.a locala = new b.a();
    this.dmT = paramString;
    adv localadv = new adv();
    localadv.svm = paramString;
    locala.ecH = localadv;
    locala.ecI = new adw();
    locala.uri = "/cgi-bin/micromsg-bin/getchatroominfodetail";
    locala.ecG = 223;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.w("MicroMsg.NetSceneGetChatRoomInfoDetail", "errType = " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      y.d("MicroMsg.NetSceneGetChatRoomInfoDetail", "OK");
      this.dmP = ((adw)this.dmK.ecF.ecN).tbU;
      this.dmQ = ((adw)this.dmK.ecF.ecN).dmQ;
      this.dmR = ((adw)this.dmK.ecF.ecN).dmR;
      this.dmS = ((adw)this.dmK.ecF.ecN).dmS;
      paramInt1 = ((adw)this.dmK.ecF.ecN).tbV;
      paramq = this.dmP;
      int i = this.dmQ;
      y.i("MicroMsg.NetSceneGetChatRoomInfoDetail", "dz[onSceneEnd : get announcement successfully!] roomId:%s newVersion:%s AnnouncementPublishTime:%s chatRoomStatus:%s", new Object[] { this.dmT, Integer.valueOf(i), Integer.valueOf(this.dmS), Integer.valueOf(paramInt1) });
      com.tencent.mm.model.m.a(this.dmT, bk.pm(paramq), this.dmR, this.dmS, i, paramInt1);
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 223;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.i
 * JD-Core Version:    0.7.0.1
 */