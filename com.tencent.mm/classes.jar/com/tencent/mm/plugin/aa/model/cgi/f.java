package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public final class f
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.al.g callback;
  public String chatroomName;
  private b iaa;
  private com.tencent.mm.protocal.protobuf.f iad;
  public com.tencent.mm.protocal.protobuf.g iae;
  
  public f(long paramLong1, String paramString1, int paramInt1, int paramInt2, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(63379);
    b.a locala = new b.a();
    locala.gUU = new com.tencent.mm.protocal.protobuf.f();
    locala.gUV = new com.tencent.mm.protocal.protobuf.g();
    locala.funcId = 1624;
    locala.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.iaa = locala.atI();
    this.iad = ((com.tencent.mm.protocal.protobuf.f)this.iaa.gUS.gUX);
    this.chatroomName = paramString2;
    try
    {
      this.iad.Csl = paramInt1;
      this.iad.Csm = paramLong1;
      this.iad.title = URLEncoder.encode(paramString1, "UTF-8");
      this.iad.Csn = new LinkedList();
      this.iad.scene = paramInt2;
      this.iad.Csj = paramString2;
      this.iad.Cso = com.tencent.mm.plugin.wallet_core.model.k.ebS();
      ad.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", new Object[] { this.iad.Cso });
      this.iad.Csp = paramLong2;
      ad.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp", new Object[] { Integer.valueOf(this.iad.Csl), Long.valueOf(this.iad.Csm), this.iad.title, this.iad.Csn, Integer.valueOf(this.iad.scene), this.iad.Csj, Long.valueOf(this.iad.Csp) });
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
    locala.gUU = new com.tencent.mm.protocal.protobuf.f();
    locala.gUV = new com.tencent.mm.protocal.protobuf.g();
    locala.funcId = 1624;
    locala.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.chatroomName = paramString2;
    this.iaa = locala.atI();
    this.iad = ((com.tencent.mm.protocal.protobuf.f)this.iaa.gUS.gUX);
    this.iaa.setIsUserCmd(true);
    if (paramList != null) {}
    try
    {
      if (paramList.size() > 0)
      {
        this.iad.Csl = paramList.size();
        this.iad.Csm = paramLong1;
        this.iad.title = URLEncoder.encode(paramString1, "UTF-8");
        this.iad.Csn = new LinkedList();
        this.iad.Csn.addAll(paramList);
        this.iad.scene = paramInt;
        this.iad.Csj = paramString2;
        this.iad.Cso = com.tencent.mm.plugin.wallet_core.model.k.ebS();
        this.iad.Csp = paramLong2;
        this.iad.Csq = paramString3;
        this.iad.Csr = paramString4;
        this.iad.Css = paramString5;
        ad.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", new Object[] { this.iad.Cso });
      }
      ad.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s, pic_cdn_url: %s, pic_cdn_thumb_url: %s, pf_order_no: %s", new Object[] { Integer.valueOf(this.iad.Csl), Long.valueOf(this.iad.Csm), this.iad.title, this.iad.Csn, Integer.valueOf(this.iad.scene), this.iad.Csj, Long.valueOf(this.iad.Csp), bt.by(this.iad.Csq, ""), bt.by(this.iad.Csr, ""), bt.by(this.iad.Css, "") });
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
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(63380);
    ad.i("MicroMsg.NetSceneAALaunchByMoney", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, this.iaa, this);
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
    this.iae = ((com.tencent.mm.protocal.protobuf.g)((b)paramq).gUT.gUX);
    paramInt1 = this.iae.dcG;
    paramq = this.iae.nTK;
    if (this.iae.Csk == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.NetSceneAALaunchByMoney", "retcode: %s, retmsg: %s, msgxml==null: %s, billNo: %s", new Object[] { Integer.valueOf(paramInt1), paramq, Boolean.valueOf(bool), this.iae.Csi });
      ad.d("MicroMsg.NetSceneAALaunchByMoney", "msgxml: %s", new Object[] { this.iae.Csk });
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(63381);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.f
 * JD-Core Version:    0.7.0.1
 */