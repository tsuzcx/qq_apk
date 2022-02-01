package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.protocal.protobuf.fsx;
import com.tencent.mm.protocal.protobuf.fsy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;

public final class aa
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  public String chatroomName;
  public String lyK;
  public int lyL;
  public int lyM;
  public String resultMsg;
  private final c rr;
  
  public aa(String paramString)
  {
    AppMethodBeat.i(12498);
    this.callback = null;
    this.chatroomName = null;
    this.resultMsg = null;
    this.lyK = null;
    this.lyL = 0;
    this.lyM = 0;
    c.a locala = new c.a();
    locala.otE = new fsx();
    locala.otF = new fsy();
    locala.uri = "/cgi-bin/micromsg-bin/upgradechatroom";
    locala.funcId = 482;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.chatroomName = paramString;
    ((fsx)c.b.b(this.rr.otB)).YFk = paramString;
    AppMethodBeat.o(12498);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(12499);
    this.callback = paramh;
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
    fsy localfsy = (fsy)c.c.b(this.rr.otC);
    Log.d("MicroMsg.NetSceneUpgradeChatroom", "NetSceneUpgradeChatroom onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.lyK = localfsy.aaVP;
    if (!Util.isNullOrNil(this.lyK))
    {
      paramArrayOfByte = ((b)com.tencent.mm.kernel.h.ax(b.class)).bzK().Ju(this.chatroomName);
      params = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        params = new aj();
      }
      params.pG(z.bAM(), this.lyK);
      v.a(params);
    }
    this.resultMsg = localfsy.aaqc;
    this.lyL = localfsy.aaqb;
    this.lyM = localfsy.aaqd;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.aa
 * JD-Core Version:    0.7.0.1
 */