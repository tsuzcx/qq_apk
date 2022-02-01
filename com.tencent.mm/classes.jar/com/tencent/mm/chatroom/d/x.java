package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.protobuf.dgv;
import com.tencent.mm.protocal.protobuf.dgw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.w;

public final class x
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  public String chatroomName;
  public String foR;
  public String fpg;
  public int fph;
  public int maxCount;
  private final b rr;
  
  public x(String paramString)
  {
    AppMethodBeat.i(12498);
    this.callback = null;
    this.chatroomName = null;
    this.foR = null;
    this.fpg = null;
    this.maxCount = 0;
    this.fph = 0;
    b.a locala = new b.a();
    locala.gUU = new dgv();
    locala.gUV = new dgw();
    locala.uri = "/cgi-bin/micromsg-bin/upgradechatroom";
    locala.funcId = 482;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    this.chatroomName = paramString;
    ((dgv)this.rr.gUS.gUX).Cxb = paramString;
    AppMethodBeat.o(12498);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
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
    dgw localdgw = (dgw)this.rr.gUT.gUX;
    ad.d("MicroMsg.NetSceneUpgradeChatroom", "NetSceneUpgradeChatroom onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.fpg = localdgw.DOr;
    if (!bt.isNullOrNil(this.fpg))
    {
      paramArrayOfByte = ((c)com.tencent.mm.kernel.g.ab(c.class)).apV().tH(this.chatroomName);
      paramq = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        paramq = new w();
      }
      paramq.la(u.aqG(), this.fpg);
      com.tencent.mm.model.q.a(paramq);
    }
    this.foR = localdgw.Dsq;
    this.maxCount = localdgw.Dsp;
    this.fph = localdgw.Dsr;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.x
 * JD-Core Version:    0.7.0.1
 */