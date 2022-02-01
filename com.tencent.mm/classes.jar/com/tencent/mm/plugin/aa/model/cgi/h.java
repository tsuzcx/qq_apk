package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class h
  extends com.tencent.mm.ak.q
  implements m
{
  private com.tencent.mm.ak.i callback;
  public String chatroomName;
  private d hJu;
  private com.tencent.mm.protocal.protobuf.h jTi;
  public com.tencent.mm.protocal.protobuf.i jTj;
  
  public h(String paramString1, int paramInt, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(212945);
    d.a locala = new d.a();
    locala.iLN = new com.tencent.mm.protocal.protobuf.h();
    locala.iLO = new com.tencent.mm.protocal.protobuf.i();
    locala.funcId = 2831;
    locala.uri = "/cgi-bin/mmpay-bin/newaalaunchbypayercustomize";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.hJu = locala.aXF();
    this.jTi = ((com.tencent.mm.protocal.protobuf.h)this.hJu.iLK.iLR);
    this.hJu.setIsUserCmd(true);
    try
    {
      this.jTi.title = com.tencent.mm.compatible.util.q.encode(paramString1, "UTF-8");
      this.jTi.scene = paramInt;
      this.jTi.KBt = paramString2;
      this.jTi.KBy = k.fQy();
      this.jTi.KBz = paramLong;
      this.jTi.KBA = paramString3;
      this.jTi.KBB = paramString4;
      this.jTi.KBC = paramString5;
      Log.d("MicroMsg.NetSceneAALaunchByPersonCustomize", "location %s", new Object[] { this.jTi.KBy });
      this.chatroomName = paramString2;
      Log.i("MicroMsg.NetSceneAALaunchByPersonCustomize", "NetSceneAALaunchByPersonCustomize, title: %s, scene: %s, groupid: %s, timestamp: %s, pic_cdn_url: %s, pic_cdn_thumb_url: %s, pf_order_no: %s", new Object[] { this.jTi.title, Integer.valueOf(this.jTi.scene), this.jTi.KBt, Long.valueOf(this.jTi.KBz), Util.nullAs(this.jTi.KBA, ""), Util.nullAs(this.jTi.KBB, ""), Util.nullAs(this.jTi.KBC, "") });
      AppMethodBeat.o(212945);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Log.e("MicroMsg.NetSceneAALaunchByPersonCustomize", "build NetSceneAALaunchByPerson request error: %s", new Object[] { paramString1.getMessage() });
      }
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(212946);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(212946);
    return i;
  }
  
  public final int getType()
  {
    return 2831;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212947);
    Log.i("MicroMsg.NetSceneAALaunchByPersonCustomize", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.jTj = ((com.tencent.mm.protocal.protobuf.i)((d)params).iLL.iLR);
    paramInt1 = this.jTj.dDN;
    params = this.jTj.qwn;
    paramArrayOfByte = this.jTj.KBs;
    if (this.jTj.KBu == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.NetSceneAALaunchByPersonCustomize", "retcode: %s, retmsg: %s, bill_no: %s, msgxml==null: %s", new Object[] { Integer.valueOf(paramInt1), params, paramArrayOfByte, Boolean.valueOf(bool) });
      Log.d("MicroMsg.NetSceneAALaunchByPersonCustomize", "msgxml: %s", new Object[] { this.jTj.KBu });
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(212947);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.h
 * JD-Core Version:    0.7.0.1
 */