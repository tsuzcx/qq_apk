package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.h;
import com.tencent.mm.protocal.protobuf.i;
import com.tencent.mm.protocal.protobuf.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.g callback;
  public String chatroomName;
  private b gvE;
  private h iAi;
  public i iAj;
  
  public g(String paramString1, long paramLong1, List<j> paramList, int paramInt, String paramString2, long paramLong2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(63382);
    b.a locala = new b.a();
    locala.hvt = new h();
    locala.hvu = new i();
    locala.funcId = 1655;
    locala.uri = "/cgi-bin/mmpay-bin/newaalaunchbyperson";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.gvE = locala.aAz();
    this.iAi = ((h)this.gvE.hvr.hvw);
    this.gvE.setIsUserCmd(true);
    try
    {
      this.iAi.title = p.encode(paramString1, "UTF-8");
      this.iAi.DKN = paramLong1;
      this.iAi.DKF = new LinkedList();
      this.iAi.DKF.addAll(paramList);
      this.iAi.scene = paramInt;
      this.iAi.DKB = paramString2;
      this.iAi.DKG = com.tencent.mm.plugin.wallet_core.model.k.ero();
      this.iAi.DKH = paramLong2;
      this.iAi.DKI = paramString3;
      this.iAi.DKJ = paramString4;
      this.iAi.DKK = paramString5;
      ac.d("MicroMsg.NetSceneAALaunchByPerson", "location %s", new Object[] { this.iAi.DKG });
      this.chatroomName = paramString2;
      ac.i("MicroMsg.NetSceneAALaunchByPerson", "NetSceneAALaunchByPerson, title: %s, total_pay_amount: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s, pic_cdn_url: %s, pic_cdn_thumb_url: %s, pf_order_no: %s", new Object[] { this.iAi.title, Long.valueOf(this.iAi.DKN), this.iAi.DKF, Integer.valueOf(this.iAi.scene), this.iAi.DKB, Long.valueOf(this.iAi.DKH), bs.bG(this.iAi.DKI, ""), bs.bG(this.iAi.DKJ, ""), bs.bG(this.iAi.DKK, "") });
      AppMethodBeat.o(63382);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ac.e("MicroMsg.NetSceneAALaunchByPerson", "build NetSceneAALaunchByPerson request error: %s", new Object[] { paramString1.getMessage() });
      }
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(63383);
    ac.d("MicroMsg.NetSceneAALaunchByPerson", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
    AppMethodBeat.o(63383);
    return i;
  }
  
  public final int getType()
  {
    return 1655;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63384);
    ac.i("MicroMsg.NetSceneAALaunchByPerson", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.iAj = ((i)((b)paramq).hvs.hvw);
    paramInt1 = this.iAj.dae;
    paramq = this.iAj.oxf;
    paramArrayOfByte = this.iAj.DKA;
    if (this.iAj.DKC == null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.NetSceneAALaunchByPerson", "retcode: %s, retmsg: %s, bill_no: %s, msgxml==null: %s", new Object[] { Integer.valueOf(paramInt1), paramq, paramArrayOfByte, Boolean.valueOf(bool) });
      ac.d("MicroMsg.NetSceneAALaunchByPerson", "msgxml: %s", new Object[] { this.iAj.DKC });
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(63384);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.g
 * JD-Core Version:    0.7.0.1
 */