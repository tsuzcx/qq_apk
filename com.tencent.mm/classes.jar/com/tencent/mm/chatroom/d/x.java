package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class x
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  public String chatroomName;
  public String fsG;
  public int fsH;
  public String fsq;
  public int maxCount;
  private final b rr;
  
  public x(String paramString)
  {
    AppMethodBeat.i(12498);
    this.callback = null;
    this.chatroomName = null;
    this.fsq = null;
    this.fsG = null;
    this.maxCount = 0;
    this.fsH = 0;
    b.a locala = new b.a();
    locala.hvt = new dmk();
    locala.hvu = new dml();
    locala.uri = "/cgi-bin/micromsg-bin/upgradechatroom";
    locala.funcId = 482;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.chatroomName = paramString;
    ((dmk)this.rr.hvr.hvw).DPx = paramString;
    AppMethodBeat.o(12498);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(12499);
    this.callback = paramg;
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
    dml localdml = (dml)this.rr.hvs.hvw;
    ac.d("MicroMsg.NetSceneUpgradeChatroom", "NetSceneUpgradeChatroom onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.fsG = localdml.FkI;
    if (!bs.isNullOrNil(this.fsG))
    {
      paramArrayOfByte = ((c)com.tencent.mm.kernel.g.ab(c.class)).awK().xN(this.chatroomName);
      paramq = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        paramq = new com.tencent.mm.storage.x();
      }
      paramq.lx(u.axw(), this.fsG);
      com.tencent.mm.model.q.a(paramq);
    }
    this.fsq = localdml.ENt;
    this.maxCount = localdml.ENs;
    this.fsH = localdml.ENu;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.x
 * JD-Core Version:    0.7.0.1
 */