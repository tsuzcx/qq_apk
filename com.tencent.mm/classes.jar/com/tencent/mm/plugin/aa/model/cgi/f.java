package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public final class f
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.g callback;
  public String chatroomName;
  private b gvE;
  private com.tencent.mm.protocal.protobuf.f iAg;
  public com.tencent.mm.protocal.protobuf.g iAh;
  
  public f(long paramLong1, String paramString1, int paramInt1, int paramInt2, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(63379);
    b.a locala = new b.a();
    locala.hvt = new com.tencent.mm.protocal.protobuf.f();
    locala.hvu = new com.tencent.mm.protocal.protobuf.g();
    locala.funcId = 1624;
    locala.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.gvE = locala.aAz();
    this.iAg = ((com.tencent.mm.protocal.protobuf.f)this.gvE.hvr.hvw);
    this.chatroomName = paramString2;
    try
    {
      this.iAg.DKD = paramInt1;
      this.iAg.DKE = paramLong1;
      this.iAg.title = URLEncoder.encode(paramString1, "UTF-8");
      this.iAg.DKF = new LinkedList();
      this.iAg.scene = paramInt2;
      this.iAg.DKB = paramString2;
      this.iAg.DKG = com.tencent.mm.plugin.wallet_core.model.k.ero();
      ac.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", new Object[] { this.iAg.DKG });
      this.iAg.DKH = paramLong2;
      ac.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp", new Object[] { Integer.valueOf(this.iAg.DKD), Long.valueOf(this.iAg.DKE), this.iAg.title, this.iAg.DKF, Integer.valueOf(this.iAg.scene), this.iAg.DKB, Long.valueOf(this.iAg.DKH) });
      AppMethodBeat.o(63379);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ac.e("MicroMsg.NetSceneAALaunchByMoney", "build NetSceneAALaunchByMoney request error: %s", new Object[] { paramString1.getMessage() });
      }
    }
  }
  
  public f(long paramLong1, String paramString1, List<String> paramList, int paramInt, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(63378);
    b.a locala = new b.a();
    locala.hvt = new com.tencent.mm.protocal.protobuf.f();
    locala.hvu = new com.tencent.mm.protocal.protobuf.g();
    locala.funcId = 1624;
    locala.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.chatroomName = paramString2;
    this.gvE = locala.aAz();
    this.iAg = ((com.tencent.mm.protocal.protobuf.f)this.gvE.hvr.hvw);
    this.gvE.setIsUserCmd(true);
    if (paramList != null) {}
    try
    {
      if (paramList.size() > 0)
      {
        this.iAg.DKD = paramList.size();
        this.iAg.DKE = paramLong1;
        this.iAg.title = URLEncoder.encode(paramString1, "UTF-8");
        this.iAg.DKF = new LinkedList();
        this.iAg.DKF.addAll(paramList);
        this.iAg.scene = paramInt;
        this.iAg.DKB = paramString2;
        this.iAg.DKG = com.tencent.mm.plugin.wallet_core.model.k.ero();
        this.iAg.DKH = paramLong2;
        this.iAg.DKI = paramString3;
        this.iAg.DKJ = paramString4;
        this.iAg.DKK = paramString5;
        ac.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", new Object[] { this.iAg.DKG });
      }
      ac.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s, pic_cdn_url: %s, pic_cdn_thumb_url: %s, pf_order_no: %s", new Object[] { Integer.valueOf(this.iAg.DKD), Long.valueOf(this.iAg.DKE), this.iAg.title, this.iAg.DKF, Integer.valueOf(this.iAg.scene), this.iAg.DKB, Long.valueOf(this.iAg.DKH), bs.bG(this.iAg.DKI, ""), bs.bG(this.iAg.DKJ, ""), bs.bG(this.iAg.DKK, "") });
      AppMethodBeat.o(63378);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ac.e("MicroMsg.NetSceneAALaunchByMoney", "build NetSceneAALaunchByMoney request error: %s", new Object[] { paramString1.getMessage() });
      }
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(63380);
    ac.i("MicroMsg.NetSceneAALaunchByMoney", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
    AppMethodBeat.o(63380);
    return i;
  }
  
  public final int getType()
  {
    return 1624;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63381);
    ac.i("MicroMsg.NetSceneAALaunchByMoney", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.iAh = ((com.tencent.mm.protocal.protobuf.g)((b)paramq).hvs.hvw);
    paramInt1 = this.iAh.dae;
    paramq = this.iAh.oxf;
    if (this.iAh.DKC == null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.NetSceneAALaunchByMoney", "retcode: %s, retmsg: %s, msgxml==null: %s, billNo: %s", new Object[] { Integer.valueOf(paramInt1), paramq, Boolean.valueOf(bool), this.iAh.DKA });
      ac.d("MicroMsg.NetSceneAALaunchByMoney", "msgxml: %s", new Object[] { this.iAh.DKC });
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(63381);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.f
 * JD-Core Version:    0.7.0.1
 */