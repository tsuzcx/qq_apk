package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public final class f
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.al.f callback;
  public String chatroomName;
  private b gPp;
  private com.tencent.mm.protocal.protobuf.f iTq;
  public g iTr;
  
  public f(long paramLong1, String paramString1, int paramInt1, int paramInt2, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(63379);
    b.a locala = new b.a();
    locala.hNM = new com.tencent.mm.protocal.protobuf.f();
    locala.hNN = new g();
    locala.funcId = 1624;
    locala.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.gPp = locala.aDC();
    this.iTq = ((com.tencent.mm.protocal.protobuf.f)this.gPp.hNK.hNQ);
    this.chatroomName = paramString2;
    try
    {
      this.iTq.FpJ = paramInt1;
      this.iTq.FpK = paramLong1;
      this.iTq.title = URLEncoder.encode(paramString1, "UTF-8");
      this.iTq.FpL = new LinkedList();
      this.iTq.scene = paramInt2;
      this.iTq.FpH = paramString2;
      this.iTq.FpM = com.tencent.mm.plugin.wallet_core.model.k.eFo();
      ad.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", new Object[] { this.iTq.FpM });
      this.iTq.FpN = paramLong2;
      ad.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp", new Object[] { Integer.valueOf(this.iTq.FpJ), Long.valueOf(this.iTq.FpK), this.iTq.title, this.iTq.FpL, Integer.valueOf(this.iTq.scene), this.iTq.FpH, Long.valueOf(this.iTq.FpN) });
      AppMethodBeat.o(63379);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ad.e("MicroMsg.NetSceneAALaunchByMoney", "build NetSceneAALaunchByMoney request error: %s", new Object[] { paramString1.getMessage() });
      }
    }
  }
  
  public f(long paramLong1, String paramString1, List<String> paramList, int paramInt, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(63378);
    b.a locala = new b.a();
    locala.hNM = new com.tencent.mm.protocal.protobuf.f();
    locala.hNN = new g();
    locala.funcId = 1624;
    locala.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.chatroomName = paramString2;
    this.gPp = locala.aDC();
    this.iTq = ((com.tencent.mm.protocal.protobuf.f)this.gPp.hNK.hNQ);
    this.gPp.setIsUserCmd(true);
    if (paramList != null) {}
    try
    {
      if (paramList.size() > 0)
      {
        this.iTq.FpJ = paramList.size();
        this.iTq.FpK = paramLong1;
        this.iTq.title = URLEncoder.encode(paramString1, "UTF-8");
        this.iTq.FpL = new LinkedList();
        this.iTq.FpL.addAll(paramList);
        this.iTq.scene = paramInt;
        this.iTq.FpH = paramString2;
        this.iTq.FpM = com.tencent.mm.plugin.wallet_core.model.k.eFo();
        this.iTq.FpN = paramLong2;
        this.iTq.FpO = paramString3;
        this.iTq.FpP = paramString4;
        this.iTq.FpQ = paramString5;
        ad.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", new Object[] { this.iTq.FpM });
      }
      ad.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s, pic_cdn_url: %s, pic_cdn_thumb_url: %s, pf_order_no: %s", new Object[] { Integer.valueOf(this.iTq.FpJ), Long.valueOf(this.iTq.FpK), this.iTq.title, this.iTq.FpL, Integer.valueOf(this.iTq.scene), this.iTq.FpH, Long.valueOf(this.iTq.FpN), bt.bI(this.iTq.FpO, ""), bt.bI(this.iTq.FpP, ""), bt.bI(this.iTq.FpQ, "") });
      AppMethodBeat.o(63378);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ad.e("MicroMsg.NetSceneAALaunchByMoney", "build NetSceneAALaunchByMoney request error: %s", new Object[] { paramString1.getMessage() });
      }
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(63380);
    ad.i("MicroMsg.NetSceneAALaunchByMoney", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
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
    ad.i("MicroMsg.NetSceneAALaunchByMoney", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.iTr = ((g)((b)paramq).hNL.hNQ);
    paramInt1 = this.iTr.dlw;
    paramq = this.iTr.paA;
    if (this.iTr.FpI == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.NetSceneAALaunchByMoney", "retcode: %s, retmsg: %s, msgxml==null: %s, billNo: %s", new Object[] { Integer.valueOf(paramInt1), paramq, Boolean.valueOf(bool), this.iTr.FpG });
      ad.d("MicroMsg.NetSceneAALaunchByMoney", "msgxml: %s", new Object[] { this.iTr.FpI });
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(63381);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.f
 * JD-Core Version:    0.7.0.1
 */