package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.j;
import com.tencent.mm.protocal.protobuf.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends com.tencent.mm.ak.q
  implements m
{
  private i callback;
  public String chatroomName;
  private d hJu;
  private j jTg;
  public com.tencent.mm.protocal.protobuf.k jTh;
  
  public g(String paramString1, long paramLong1, List<l> paramList, int paramInt, String paramString2, long paramLong2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(63382);
    d.a locala = new d.a();
    locala.iLN = new j();
    locala.iLO = new com.tencent.mm.protocal.protobuf.k();
    locala.funcId = 1655;
    locala.uri = "/cgi-bin/mmpay-bin/newaalaunchbyperson";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.hJu = locala.aXF();
    this.jTg = ((j)this.hJu.iLK.iLR);
    this.hJu.setIsUserCmd(true);
    try
    {
      this.jTg.title = com.tencent.mm.compatible.util.q.encode(paramString1, "UTF-8");
      this.jTg.KBF = paramLong1;
      this.jTg.KBx = new LinkedList();
      this.jTg.KBx.addAll(paramList);
      this.jTg.scene = paramInt;
      this.jTg.KBt = paramString2;
      this.jTg.KBy = com.tencent.mm.plugin.wallet_core.model.k.fQy();
      this.jTg.KBz = paramLong2;
      this.jTg.KBA = paramString3;
      this.jTg.KBB = paramString4;
      this.jTg.KBC = paramString5;
      Log.d("MicroMsg.NetSceneAALaunchByPerson", "location %s", new Object[] { this.jTg.KBy });
      this.chatroomName = paramString2;
      Log.i("MicroMsg.NetSceneAALaunchByPerson", "NetSceneAALaunchByPerson, title: %s, total_pay_amount: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s, pic_cdn_url: %s, pic_cdn_thumb_url: %s, pf_order_no: %s", new Object[] { this.jTg.title, Long.valueOf(this.jTg.KBF), this.jTg.KBx, Integer.valueOf(this.jTg.scene), this.jTg.KBt, Long.valueOf(this.jTg.KBz), Util.nullAs(this.jTg.KBA, ""), Util.nullAs(this.jTg.KBB, ""), Util.nullAs(this.jTg.KBC, "") });
      AppMethodBeat.o(63382);
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
    int i = dispatch(paramg, this.hJu, this);
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
    this.jTh = ((com.tencent.mm.protocal.protobuf.k)((d)params).iLL.iLR);
    paramInt1 = this.jTh.dDN;
    params = this.jTh.qwn;
    paramArrayOfByte = this.jTh.KBs;
    if (this.jTh.KBu == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.NetSceneAALaunchByPerson", "retcode: %s, retmsg: %s, bill_no: %s, msgxml==null: %s", new Object[] { Integer.valueOf(paramInt1), params, paramArrayOfByte, Boolean.valueOf(bool) });
      Log.d("MicroMsg.NetSceneAALaunchByPerson", "msgxml: %s", new Object[] { this.jTh.KBu });
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(63384);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.g
 * JD-Core Version:    0.7.0.1
 */