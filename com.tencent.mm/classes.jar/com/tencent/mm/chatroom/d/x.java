package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.protobuf.dsb;
import com.tencent.mm.protocal.protobuf.dsc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;

public final class x
  extends n
  implements k
{
  private f callback;
  public String chatroomName;
  public String fKQ;
  public String fLg;
  public int fLh;
  public int maxCount;
  private final b rr;
  
  public x(String paramString)
  {
    AppMethodBeat.i(12498);
    this.callback = null;
    this.chatroomName = null;
    this.fKQ = null;
    this.fLg = null;
    this.maxCount = 0;
    this.fLh = 0;
    b.a locala = new b.a();
    locala.hNM = new dsb();
    locala.hNN = new dsc();
    locala.uri = "/cgi-bin/micromsg-bin/upgradechatroom";
    locala.funcId = 482;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.chatroomName = paramString;
    ((dsb)this.rr.hNK.hNQ).FuL = paramString;
    AppMethodBeat.o(12498);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(12499);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(12499);
    return i;
  }
  
  public final int getType()
  {
    return 482;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12500);
    dsc localdsc = (dsc)this.rr.hNL.hNQ;
    ad.d("MicroMsg.NetSceneUpgradeChatroom", "NetSceneUpgradeChatroom onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.fLg = localdsc.GUq;
    if (!bt.isNullOrNil(this.fLg))
    {
      paramArrayOfByte = ((c)g.ab(c.class)).azz().AN(this.chatroomName);
      paramq = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        paramq = new ab();
      }
      paramq.lV(u.aAm(), this.fLg);
      com.tencent.mm.model.q.a(paramq);
    }
    this.fKQ = localdsc.Gwy;
    this.maxCount = localdsc.Gwx;
    this.fLh = localdsc.Gwz;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.x
 * JD-Core Version:    0.7.0.1
 */