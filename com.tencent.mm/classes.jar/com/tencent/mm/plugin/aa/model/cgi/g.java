package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
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
  private com.tencent.mm.al.g callback;
  public String chatroomName;
  private b iaa;
  private h iaf;
  public i iag;
  
  public g(String paramString1, long paramLong1, List<j> paramList, int paramInt, String paramString2, long paramLong2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(63382);
    b.a locala = new b.a();
    locala.gUU = new h();
    locala.gUV = new i();
    locala.funcId = 1655;
    locala.uri = "/cgi-bin/mmpay-bin/newaalaunchbyperson";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.iaa = locala.atI();
    this.iaf = ((h)this.iaa.gUS.gUX);
    this.iaa.setIsUserCmd(true);
    try
    {
      this.iaf.title = p.encode(paramString1, "UTF-8");
      this.iaf.Csv = paramLong1;
      this.iaf.Csn = new LinkedList();
      this.iaf.Csn.addAll(paramList);
      this.iaf.scene = paramInt;
      this.iaf.Csj = paramString2;
      this.iaf.Cso = com.tencent.mm.plugin.wallet_core.model.k.ebS();
      this.iaf.Csp = paramLong2;
      this.iaf.Csq = paramString3;
      this.iaf.Csr = paramString4;
      this.iaf.Css = paramString5;
      ad.d("MicroMsg.NetSceneAALaunchByPerson", "location %s", new Object[] { this.iaf.Cso });
      this.chatroomName = paramString2;
      ad.i("MicroMsg.NetSceneAALaunchByPerson", "NetSceneAALaunchByPerson, title: %s, total_pay_amount: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s, pic_cdn_url: %s, pic_cdn_thumb_url: %s, pf_order_no: %s", new Object[] { this.iaf.title, Long.valueOf(this.iaf.Csv), this.iaf.Csn, Integer.valueOf(this.iaf.scene), this.iaf.Csj, Long.valueOf(this.iaf.Csp), bt.by(this.iaf.Csq, ""), bt.by(this.iaf.Csr, ""), bt.by(this.iaf.Css, "") });
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
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(63383);
    ad.d("MicroMsg.NetSceneAALaunchByPerson", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, this.iaa, this);
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
    ad.i("MicroMsg.NetSceneAALaunchByPerson", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.iag = ((i)((b)paramq).gUT.gUX);
    paramInt1 = this.iag.dcG;
    paramq = this.iag.nTK;
    paramArrayOfByte = this.iag.Csi;
    if (this.iag.Csk == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.NetSceneAALaunchByPerson", "retcode: %s, retmsg: %s, bill_no: %s, msgxml==null: %s", new Object[] { Integer.valueOf(paramInt1), paramq, paramArrayOfByte, Boolean.valueOf(bool) });
      ad.d("MicroMsg.NetSceneAALaunchByPerson", "msgxml: %s", new Object[] { this.iag.Csk });
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(63384);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.g
 * JD-Core Version:    0.7.0.1
 */