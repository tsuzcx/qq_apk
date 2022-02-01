package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.l;
import com.tencent.mm.protocal.protobuf.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.model.w;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends w
{
  private h callback;
  public String chatroomName;
  private c nao;
  private com.tencent.mm.protocal.protobuf.k pHc;
  public l pHd;
  
  public g(String paramString1, long paramLong1, List<m> paramList, int paramInt, String paramString2, long paramLong2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(268406);
    c.a locala = new c.a();
    locala.otE = new com.tencent.mm.protocal.protobuf.k();
    locala.otF = new l();
    locala.funcId = 1655;
    locala.uri = "/cgi-bin/mmpay-bin/newaalaunchbyperson";
    locala.otG = 0;
    locala.respCmdId = 0;
    this.nao = locala.bEF();
    this.pHc = ((com.tencent.mm.protocal.protobuf.k)c.b.b(this.nao.otB));
    this.nao.setIsUserCmd(true);
    try
    {
      this.pHc.title = r.as(paramString1, "UTF-8");
      this.pHc.YzZ = paramLong1;
      this.pHc.YzQ = new LinkedList();
      this.pHc.YzQ.addAll(paramList);
      this.pHc.scene = paramInt;
      this.pHc.YzM = paramString2;
      this.pHc.YzR = com.tencent.mm.plugin.wallet_core.model.k.iis();
      this.pHc.YzS = paramLong2;
      this.pHc.YzT = paramString3;
      this.pHc.YzU = paramString4;
      this.pHc.YzV = paramString5;
      this.pHc.YzW = paramString6;
      Log.d("MicroMsg.NetSceneAALaunchByPerson", "location %s", new Object[] { this.pHc.YzR });
      this.chatroomName = paramString2;
      Log.i("MicroMsg.NetSceneAALaunchByPerson", "NetSceneAALaunchByPerson, title: %s, total_pay_amount: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s, pic_cdn_url: %s, pic_cdn_thumb_url: %s, pf_order_no: %s , pic_cdn_md5:%s", new Object[] { this.pHc.title, Long.valueOf(this.pHc.YzZ), this.pHc.YzQ, Integer.valueOf(this.pHc.scene), this.pHc.YzM, Long.valueOf(this.pHc.YzS), Util.nullAs(this.pHc.YzT, ""), Util.nullAs(this.pHc.YzU, ""), Util.nullAs(this.pHc.YzV, ""), Util.nullAs(this.pHc.YzW, "") });
      AppMethodBeat.o(268406);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Log.e("MicroMsg.NetSceneAALaunchByPerson", "build NetSceneAALaunchByPerson request error: %s", new Object[] { paramString1.getMessage() });
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(63383);
    Log.d("MicroMsg.NetSceneAALaunchByPerson", "doScene");
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(63383);
    return i;
  }
  
  public final int getType()
  {
    return 1655;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(268416);
    Log.i("MicroMsg.NetSceneAALaunchByPerson", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.pHd = ((l)c.c.b(((c)params).otC));
    paramInt1 = this.pHd.hAV;
    params = this.pHd.wYI;
    paramArrayOfByte = this.pHd.YzL;
    if (this.pHd.YzN == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.NetSceneAALaunchByPerson", "retcode: %s, retmsg: %s, bill_no: %s, msgxml==null: %s", new Object[] { Integer.valueOf(paramInt1), params, paramArrayOfByte, Boolean.valueOf(bool) });
      Log.d("MicroMsg.NetSceneAALaunchByPerson", "msgxml: %s", new Object[] { this.pHd.YzN });
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(268416);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.g
 * JD-Core Version:    0.7.0.1
 */