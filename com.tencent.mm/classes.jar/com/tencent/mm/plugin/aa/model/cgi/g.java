package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.h;
import com.tencent.mm.protocal.protobuf.i;
import com.tencent.mm.protocal.protobuf.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  public String chatroomName;
  private b gPp;
  private h iTs;
  public i iTt;
  
  public g(String paramString1, long paramLong1, List<j> paramList, int paramInt, String paramString2, long paramLong2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(63382);
    b.a locala = new b.a();
    locala.hNM = new h();
    locala.hNN = new i();
    locala.funcId = 1655;
    locala.uri = "/cgi-bin/mmpay-bin/newaalaunchbyperson";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.gPp = locala.aDC();
    this.iTs = ((h)this.gPp.hNK.hNQ);
    this.gPp.setIsUserCmd(true);
    try
    {
      this.iTs.title = com.tencent.mm.compatible.util.q.encode(paramString1, "UTF-8");
      this.iTs.FpT = paramLong1;
      this.iTs.FpL = new LinkedList();
      this.iTs.FpL.addAll(paramList);
      this.iTs.scene = paramInt;
      this.iTs.FpH = paramString2;
      this.iTs.FpM = com.tencent.mm.plugin.wallet_core.model.k.eFo();
      this.iTs.FpN = paramLong2;
      this.iTs.FpO = paramString3;
      this.iTs.FpP = paramString4;
      this.iTs.FpQ = paramString5;
      ad.d("MicroMsg.NetSceneAALaunchByPerson", "location %s", new Object[] { this.iTs.FpM });
      this.chatroomName = paramString2;
      ad.i("MicroMsg.NetSceneAALaunchByPerson", "NetSceneAALaunchByPerson, title: %s, total_pay_amount: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s, pic_cdn_url: %s, pic_cdn_thumb_url: %s, pf_order_no: %s", new Object[] { this.iTs.title, Long.valueOf(this.iTs.FpT), this.iTs.FpL, Integer.valueOf(this.iTs.scene), this.iTs.FpH, Long.valueOf(this.iTs.FpN), bt.bI(this.iTs.FpO, ""), bt.bI(this.iTs.FpP, ""), bt.bI(this.iTs.FpQ, "") });
      AppMethodBeat.o(63382);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ad.e("MicroMsg.NetSceneAALaunchByPerson", "build NetSceneAALaunchByPerson request error: %s", new Object[] { paramString1.getMessage() });
      }
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(63383);
    ad.d("MicroMsg.NetSceneAALaunchByPerson", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
    AppMethodBeat.o(63383);
    return i;
  }
  
  public final int getType()
  {
    return 1655;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63384);
    ad.i("MicroMsg.NetSceneAALaunchByPerson", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.iTt = ((i)((b)paramq).hNL.hNQ);
    paramInt1 = this.iTt.dlw;
    paramq = this.iTt.paA;
    paramArrayOfByte = this.iTt.FpG;
    if (this.iTt.FpI == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.NetSceneAALaunchByPerson", "retcode: %s, retmsg: %s, bill_no: %s, msgxml==null: %s", new Object[] { Integer.valueOf(paramInt1), paramq, paramArrayOfByte, Boolean.valueOf(bool) });
      ad.d("MicroMsg.NetSceneAALaunchByPerson", "msgxml: %s", new Object[] { this.iTt.FpI });
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