package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.i;
import com.tencent.mm.protocal.protobuf.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.model.w;

public final class h
  extends w
{
  private com.tencent.mm.am.h callback;
  public String chatroomName;
  private c nao;
  private i pHe;
  public j pHf;
  
  public h(String paramString1, int paramInt, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(268403);
    c.a locala = new c.a();
    locala.otE = new i();
    locala.otF = new j();
    locala.funcId = 2831;
    locala.uri = "/cgi-bin/mmpay-bin/newaalaunchbypayercustomize";
    locala.otG = 0;
    locala.respCmdId = 0;
    this.nao = locala.bEF();
    this.pHe = ((i)c.b.b(this.nao.otB));
    this.nao.setIsUserCmd(true);
    try
    {
      this.pHe.title = r.as(paramString1, "UTF-8");
      this.pHe.scene = paramInt;
      this.pHe.YzM = paramString2;
      this.pHe.YzR = k.iis();
      this.pHe.YzS = paramLong;
      this.pHe.YzT = paramString3;
      this.pHe.YzU = paramString4;
      this.pHe.YzV = paramString5;
      this.pHe.YzW = paramString6;
      Log.d("MicroMsg.NetSceneAALaunchByPersonCustomize", "location %s", new Object[] { this.pHe.YzR });
      this.chatroomName = paramString2;
      Log.i("MicroMsg.NetSceneAALaunchByPersonCustomize", "NetSceneAALaunchByPersonCustomize, title: %s, scene: %s, groupid: %s, timestamp: %s, pic_cdn_url: %s, pic_cdn_thumb_url: %s, pf_order_no: %s , pic_cdn_md5: %s", new Object[] { this.pHe.title, Integer.valueOf(this.pHe.scene), this.pHe.YzM, Long.valueOf(this.pHe.YzS), Util.nullAs(this.pHe.YzT, ""), Util.nullAs(this.pHe.YzU, ""), Util.nullAs(this.pHe.YzV, ""), Util.nullAs(this.pHe.YzW, "") });
      AppMethodBeat.o(268403);
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
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(268408);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(268408);
    return i;
  }
  
  public final int getType()
  {
    return 2831;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(268412);
    Log.i("MicroMsg.NetSceneAALaunchByPersonCustomize", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.pHf = ((j)c.c.b(((c)params).otC));
    paramInt1 = this.pHf.hAV;
    params = this.pHf.wYI;
    paramArrayOfByte = this.pHf.YzL;
    if (this.pHf.YzN == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.NetSceneAALaunchByPersonCustomize", "retcode: %s, retmsg: %s, bill_no: %s, msgxml==null: %s", new Object[] { Integer.valueOf(paramInt1), params, paramArrayOfByte, Boolean.valueOf(bool) });
      Log.d("MicroMsg.NetSceneAALaunchByPersonCustomize", "msgxml: %s", new Object[] { this.pHf.YzN });
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(268412);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.h
 * JD-Core Version:    0.7.0.1
 */