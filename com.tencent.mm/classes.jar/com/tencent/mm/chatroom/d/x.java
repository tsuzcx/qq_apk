package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.protocal.protobuf.exe;
import com.tencent.mm.protocal.protobuf.exf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;

public final class x
  extends q
  implements m
{
  private i callback;
  public String chatroomName;
  public String iWG;
  public int iWH;
  public int iWI;
  public String resultMsg;
  private final d rr;
  
  public x(String paramString)
  {
    AppMethodBeat.i(12498);
    this.callback = null;
    this.chatroomName = null;
    this.resultMsg = null;
    this.iWG = null;
    this.iWH = 0;
    this.iWI = 0;
    d.a locala = new d.a();
    locala.lBU = new exe();
    locala.lBV = new exf();
    locala.uri = "/cgi-bin/micromsg-bin/upgradechatroom";
    locala.funcId = 482;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    this.chatroomName = paramString;
    ((exe)d.b.b(this.rr.lBR)).RIi = paramString;
    AppMethodBeat.o(12498);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(12499);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(12499);
    return i;
  }
  
  public final int getType()
  {
    return 482;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12500);
    exf localexf = (exf)d.c.b(this.rr.lBS);
    Log.d("MicroMsg.NetSceneUpgradeChatroom", "NetSceneUpgradeChatroom onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.iWG = localexf.TGj;
    if (!Util.isNullOrNil(this.iWG))
    {
      paramArrayOfByte = ((b)h.ae(b.class)).bbV().Rw(this.chatroomName);
      params = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        params = new ah();
      }
      params.nH(z.bcZ(), this.iWG);
      v.a(params);
    }
    this.resultMsg = localexf.TcN;
    this.iWH = localexf.TcM;
    this.iWI = localexf.TcO;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.x
 * JD-Core Version:    0.7.0.1
 */