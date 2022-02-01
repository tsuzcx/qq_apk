package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.model.w;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.arw;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;

public final class l
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.al.g callback;
  public String foM;
  public int foN;
  public String foO;
  public int foP;
  private String roomId;
  private final b rr;
  
  public l(String paramString)
  {
    AppMethodBeat.i(12470);
    this.roomId = "";
    b.a locala = new b.a();
    this.roomId = paramString;
    arw localarw = new arw();
    localarw.Cxb = paramString;
    locala.gUU = localarw;
    locala.gUV = new arx();
    locala.uri = "/cgi-bin/micromsg-bin/getchatroominfodetail";
    locala.funcId = 223;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    AppMethodBeat.o(12470);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(12472);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(12472);
    return i;
  }
  
  public final int getType()
  {
    return 223;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12471);
    ad.w("MicroMsg.NetSceneGetChatRoomInfoDetail", "errType = " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ad.d("MicroMsg.NetSceneGetChatRoomInfoDetail", "OK");
      this.foM = ((arx)this.rr.gUT.gUX).Dsd;
      this.foN = ((arx)this.rr.gUT.gUX).foN;
      this.foO = ((arx)this.rr.gUT.gUX).foO;
      this.foP = ((arx)this.rr.gUT.gUX).foP;
      paramInt1 = ((arx)this.rr.gUT.gUX).Dse;
      paramq = this.foM;
      int i = this.foN;
      ad.i("MicroMsg.NetSceneGetChatRoomInfoDetail", "dz[onSceneEnd : get announcement successfully!] roomId:%s newVersion:%s AnnouncementPublishTime:%s chatRoomStatus:%s", new Object[] { this.roomId, Integer.valueOf(i), Integer.valueOf(this.foP), Integer.valueOf(paramInt1) });
      com.tencent.mm.model.q.a(this.roomId, bt.nullAsNil(paramq), this.foO, this.foP, i, paramInt1);
      if (w.pF(this.roomId))
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().cc(this.roomId, ((arx)this.rr.gUT.gUX).evU);
        aa.a(this.roomId, (arx)this.rr.gUT.gUX);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12471);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.l
 * JD-Core Version:    0.7.0.1
 */