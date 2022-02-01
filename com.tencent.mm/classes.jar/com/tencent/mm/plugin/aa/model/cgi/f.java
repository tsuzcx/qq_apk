package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public final class f
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.f callback;
  public String chatroomName;
  private b gRX;
  private com.tencent.mm.protocal.protobuf.f iWj;
  public g iWk;
  
  public f(long paramLong1, String paramString1, int paramInt1, int paramInt2, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(63379);
    b.a locala = new b.a();
    locala.hQF = new com.tencent.mm.protocal.protobuf.f();
    locala.hQG = new g();
    locala.funcId = 1624;
    locala.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.gRX = locala.aDS();
    this.iWj = ((com.tencent.mm.protocal.protobuf.f)this.gRX.hQD.hQJ);
    this.chatroomName = paramString2;
    try
    {
      this.iWj.FIh = paramInt1;
      this.iWj.FIi = paramLong1;
      this.iWj.title = URLEncoder.encode(paramString1, "UTF-8");
      this.iWj.FIj = new LinkedList();
      this.iWj.scene = paramInt2;
      this.iWj.FIf = paramString2;
      this.iWj.FIk = com.tencent.mm.plugin.wallet_core.model.k.eIV();
      ae.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", new Object[] { this.iWj.FIk });
      this.iWj.FIl = paramLong2;
      ae.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp", new Object[] { Integer.valueOf(this.iWj.FIh), Long.valueOf(this.iWj.FIi), this.iWj.title, this.iWj.FIj, Integer.valueOf(this.iWj.scene), this.iWj.FIf, Long.valueOf(this.iWj.FIl) });
      AppMethodBeat.o(63379);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ae.e("MicroMsg.NetSceneAALaunchByMoney", "build NetSceneAALaunchByMoney request error: %s", new Object[] { paramString1.getMessage() });
      }
    }
  }
  
  public f(long paramLong1, String paramString1, List<String> paramList, int paramInt, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(63378);
    b.a locala = new b.a();
    locala.hQF = new com.tencent.mm.protocal.protobuf.f();
    locala.hQG = new g();
    locala.funcId = 1624;
    locala.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.chatroomName = paramString2;
    this.gRX = locala.aDS();
    this.iWj = ((com.tencent.mm.protocal.protobuf.f)this.gRX.hQD.hQJ);
    this.gRX.setIsUserCmd(true);
    if (paramList != null) {}
    try
    {
      if (paramList.size() > 0)
      {
        this.iWj.FIh = paramList.size();
        this.iWj.FIi = paramLong1;
        this.iWj.title = URLEncoder.encode(paramString1, "UTF-8");
        this.iWj.FIj = new LinkedList();
        this.iWj.FIj.addAll(paramList);
        this.iWj.scene = paramInt;
        this.iWj.FIf = paramString2;
        this.iWj.FIk = com.tencent.mm.plugin.wallet_core.model.k.eIV();
        this.iWj.FIl = paramLong2;
        this.iWj.FIm = paramString3;
        this.iWj.FIn = paramString4;
        this.iWj.FIo = paramString5;
        ae.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", new Object[] { this.iWj.FIk });
      }
      ae.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s, pic_cdn_url: %s, pic_cdn_thumb_url: %s, pf_order_no: %s", new Object[] { Integer.valueOf(this.iWj.FIh), Long.valueOf(this.iWj.FIi), this.iWj.title, this.iWj.FIj, Integer.valueOf(this.iWj.scene), this.iWj.FIf, Long.valueOf(this.iWj.FIl), bu.bI(this.iWj.FIm, ""), bu.bI(this.iWj.FIn, ""), bu.bI(this.iWj.FIo, "") });
      AppMethodBeat.o(63378);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ae.e("MicroMsg.NetSceneAALaunchByMoney", "build NetSceneAALaunchByMoney request error: %s", new Object[] { paramString1.getMessage() });
      }
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(63380);
    ae.i("MicroMsg.NetSceneAALaunchByMoney", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
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
    ae.i("MicroMsg.NetSceneAALaunchByMoney", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.iWk = ((g)((b)paramq).hQE.hQJ);
    paramInt1 = this.iWk.dmy;
    paramq = this.iWk.phe;
    if (this.iWk.FIg == null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.NetSceneAALaunchByMoney", "retcode: %s, retmsg: %s, msgxml==null: %s, billNo: %s", new Object[] { Integer.valueOf(paramInt1), paramq, Boolean.valueOf(bool), this.iWk.FIe });
      ae.d("MicroMsg.NetSceneAALaunchByMoney", "msgxml: %s", new Object[] { this.iWk.FIg });
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