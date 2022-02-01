package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends com.tencent.mm.an.q
  implements com.tencent.mm.network.m
{
  private i callback;
  public String chatroomName;
  private d kwO;
  private com.tencent.mm.protocal.protobuf.k mKu;
  public l mKv;
  
  public g(String paramString1, long paramLong1, List<com.tencent.mm.protocal.protobuf.m> paramList, int paramInt, String paramString2, long paramLong2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(271397);
    d.a locala = new d.a();
    locala.lBU = new com.tencent.mm.protocal.protobuf.k();
    locala.lBV = new l();
    locala.funcId = 1655;
    locala.uri = "/cgi-bin/mmpay-bin/newaalaunchbyperson";
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.kwO = locala.bgN();
    this.mKu = ((com.tencent.mm.protocal.protobuf.k)d.b.b(this.kwO.lBR));
    this.kwO.setIsUserCmd(true);
    try
    {
      this.mKu.title = com.tencent.mm.compatible.util.q.an(paramString1, "UTF-8");
      this.mKu.RDw = paramLong1;
      this.mKu.RDn = new LinkedList();
      this.mKu.RDn.addAll(paramList);
      this.mKu.scene = paramInt;
      this.mKu.RDj = paramString2;
      this.mKu.RDo = com.tencent.mm.plugin.wallet_core.model.k.gJe();
      this.mKu.RDp = paramLong2;
      this.mKu.RDq = paramString3;
      this.mKu.RDr = paramString4;
      this.mKu.RDs = paramString5;
      this.mKu.RDt = paramString6;
      Log.d("MicroMsg.NetSceneAALaunchByPerson", "location %s", new Object[] { this.mKu.RDo });
      this.chatroomName = paramString2;
      Log.i("MicroMsg.NetSceneAALaunchByPerson", "NetSceneAALaunchByPerson, title: %s, total_pay_amount: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s, pic_cdn_url: %s, pic_cdn_thumb_url: %s, pf_order_no: %s , pic_cdn_md5:%s", new Object[] { this.mKu.title, Long.valueOf(this.mKu.RDw), this.mKu.RDn, Integer.valueOf(this.mKu.scene), this.mKu.RDj, Long.valueOf(this.mKu.RDp), Util.nullAs(this.mKu.RDq, ""), Util.nullAs(this.mKu.RDr, ""), Util.nullAs(this.mKu.RDs, ""), Util.nullAs(this.mKu.RDt, "") });
      AppMethodBeat.o(271397);
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
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(63383);
    Log.d("MicroMsg.NetSceneAALaunchByPerson", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, this.kwO, this);
    AppMethodBeat.o(63383);
    return i;
  }
  
  public final int getType()
  {
    return 1655;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63384);
    Log.i("MicroMsg.NetSceneAALaunchByPerson", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.mKv = ((l)d.c.b(((d)params).lBS));
    paramInt1 = this.mKv.fwx;
    params = this.mKv.tVo;
    paramArrayOfByte = this.mKv.RDi;
    if (this.mKv.RDk == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.NetSceneAALaunchByPerson", "retcode: %s, retmsg: %s, bill_no: %s, msgxml==null: %s", new Object[] { Integer.valueOf(paramInt1), params, paramArrayOfByte, Boolean.valueOf(bool) });
      Log.d("MicroMsg.NetSceneAALaunchByPerson", "msgxml: %s", new Object[] { this.mKv.RDk });
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(63384);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.g
 * JD-Core Version:    0.7.0.1
 */