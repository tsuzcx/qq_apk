package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.protobuf.cnr;
import com.tencent.mm.protocal.protobuf.cns;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.u;

public final class q
  extends m
  implements k
{
  private f callback;
  public String chatroomName;
  public String eeG;
  public int eeH;
  public int eeI;
  public String eev;
  private final b rr;
  
  public q(String paramString)
  {
    AppMethodBeat.i(103953);
    this.callback = null;
    this.chatroomName = null;
    this.eev = null;
    this.eeG = null;
    this.eeH = 0;
    this.eeI = 0;
    b.a locala = new b.a();
    locala.fsX = new cnr();
    locala.fsY = new cns();
    locala.uri = "/cgi-bin/micromsg-bin/upgradechatroom";
    locala.funcId = 482;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    this.chatroomName = paramString;
    ((cnr)this.rr.fsV.fta).wot = paramString;
    AppMethodBeat.o(103953);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(103954);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(103954);
    return i;
  }
  
  public final int getType()
  {
    return 482;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103955);
    cns localcns = (cns)this.rr.fsW.fta;
    ab.d("MicroMsg.NetSceneUpgradeChatroom", "NetSceneUpgradeChatroom onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.eeG = localcns.xts;
    if (!bo.isNullOrNil(this.eeG))
    {
      paramArrayOfByte = ((c)g.E(c.class)).YJ().oU(this.chatroomName);
      paramq = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        paramq = new u();
      }
      paramq.io(r.Zn(), this.eeG);
      n.a(paramq);
    }
    this.eev = localcns.xaz;
    this.eeH = localcns.xay;
    this.eeI = localcns.xaA;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(103955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.q
 * JD-Core Version:    0.7.0.1
 */