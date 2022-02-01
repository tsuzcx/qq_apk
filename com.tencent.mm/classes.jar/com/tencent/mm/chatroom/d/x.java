package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.protobuf.emw;
import com.tencent.mm.protocal.protobuf.emx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;

public final class x
  extends q
  implements m
{
  private i callback;
  public String chatroomName;
  public String gsv;
  public int gsw;
  public int maxCount;
  public String resultMsg;
  private final d rr;
  
  public x(String paramString)
  {
    AppMethodBeat.i(12498);
    this.callback = null;
    this.chatroomName = null;
    this.resultMsg = null;
    this.gsv = null;
    this.maxCount = 0;
    this.gsw = 0;
    d.a locala = new d.a();
    locala.iLN = new emw();
    locala.iLO = new emx();
    locala.uri = "/cgi-bin/micromsg-bin/upgradechatroom";
    locala.funcId = 482;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.chatroomName = paramString;
    ((emw)this.rr.iLK.iLR).KGO = paramString;
    AppMethodBeat.o(12498);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
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
    emx localemx = (emx)this.rr.iLL.iLR;
    Log.d("MicroMsg.NetSceneUpgradeChatroom", "NetSceneUpgradeChatroom onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gsv = localemx.Mvl;
    if (!Util.isNullOrNil(this.gsv))
    {
      paramArrayOfByte = ((c)com.tencent.mm.kernel.g.af(c.class)).aSX().Kd(this.chatroomName);
      params = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        params = new ah();
      }
      params.mQ(z.aTY(), this.gsv);
      v.a(params);
    }
    this.resultMsg = localemx.LUf;
    this.maxCount = localemx.LUe;
    this.gsw = localemx.LUg;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.x
 * JD-Core Version:    0.7.0.1
 */