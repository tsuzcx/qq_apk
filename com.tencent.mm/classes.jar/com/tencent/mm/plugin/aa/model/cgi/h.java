package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class h
  extends com.tencent.mm.an.q
  implements m
{
  private com.tencent.mm.an.i callback;
  public String chatroomName;
  private d kwO;
  private com.tencent.mm.protocal.protobuf.i mKw;
  public j mKx;
  
  public h(String paramString1, int paramInt, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(271106);
    d.a locala = new d.a();
    locala.lBU = new com.tencent.mm.protocal.protobuf.i();
    locala.lBV = new j();
    locala.funcId = 2831;
    locala.uri = "/cgi-bin/mmpay-bin/newaalaunchbypayercustomize";
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.kwO = locala.bgN();
    this.mKw = ((com.tencent.mm.protocal.protobuf.i)d.b.b(this.kwO.lBR));
    this.kwO.setIsUserCmd(true);
    try
    {
      this.mKw.title = com.tencent.mm.compatible.util.q.an(paramString1, "UTF-8");
      this.mKw.scene = paramInt;
      this.mKw.RDj = paramString2;
      this.mKw.RDo = k.gJe();
      this.mKw.RDp = paramLong;
      this.mKw.RDq = paramString3;
      this.mKw.RDr = paramString4;
      this.mKw.RDs = paramString5;
      this.mKw.RDt = paramString6;
      Log.d("MicroMsg.NetSceneAALaunchByPersonCustomize", "location %s", new Object[] { this.mKw.RDo });
      this.chatroomName = paramString2;
      Log.i("MicroMsg.NetSceneAALaunchByPersonCustomize", "NetSceneAALaunchByPersonCustomize, title: %s, scene: %s, groupid: %s, timestamp: %s, pic_cdn_url: %s, pic_cdn_thumb_url: %s, pf_order_no: %s , pic_cdn_md5: %s", new Object[] { this.mKw.title, Integer.valueOf(this.mKw.scene), this.mKw.RDj, Long.valueOf(this.mKw.RDp), Util.nullAs(this.mKw.RDq, ""), Util.nullAs(this.mKw.RDr, ""), Util.nullAs(this.mKw.RDs, ""), Util.nullAs(this.mKw.RDt, "") });
      AppMethodBeat.o(271106);
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
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(271107);
    this.callback = parami;
    int i = dispatch(paramg, this.kwO, this);
    AppMethodBeat.o(271107);
    return i;
  }
  
  public final int getType()
  {
    return 2831;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(271108);
    Log.i("MicroMsg.NetSceneAALaunchByPersonCustomize", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.mKx = ((j)d.c.b(((d)params).lBS));
    paramInt1 = this.mKx.fwx;
    params = this.mKx.tVo;
    paramArrayOfByte = this.mKx.RDi;
    if (this.mKx.RDk == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.NetSceneAALaunchByPersonCustomize", "retcode: %s, retmsg: %s, bill_no: %s, msgxml==null: %s", new Object[] { Integer.valueOf(paramInt1), params, paramArrayOfByte, Boolean.valueOf(bool) });
      Log.d("MicroMsg.NetSceneAALaunchByPersonCustomize", "msgxml: %s", new Object[] { this.mKx.RDk });
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(271108);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.h
 * JD-Core Version:    0.7.0.1
 */