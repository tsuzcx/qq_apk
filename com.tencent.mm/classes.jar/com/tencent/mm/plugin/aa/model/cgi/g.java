package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.h;
import com.tencent.mm.protocal.protobuf.i;
import com.tencent.mm.protocal.protobuf.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  public String chatroomName;
  private b gRX;
  private h iWl;
  public i iWm;
  
  public g(String paramString1, long paramLong1, List<j> paramList, int paramInt, String paramString2, long paramLong2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(63382);
    b.a locala = new b.a();
    locala.hQF = new h();
    locala.hQG = new i();
    locala.funcId = 1655;
    locala.uri = "/cgi-bin/mmpay-bin/newaalaunchbyperson";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.gRX = locala.aDS();
    this.iWl = ((h)this.gRX.hQD.hQJ);
    this.gRX.setIsUserCmd(true);
    try
    {
      this.iWl.title = com.tencent.mm.compatible.util.q.encode(paramString1, "UTF-8");
      this.iWl.FIr = paramLong1;
      this.iWl.FIj = new LinkedList();
      this.iWl.FIj.addAll(paramList);
      this.iWl.scene = paramInt;
      this.iWl.FIf = paramString2;
      this.iWl.FIk = com.tencent.mm.plugin.wallet_core.model.k.eIV();
      this.iWl.FIl = paramLong2;
      this.iWl.FIm = paramString3;
      this.iWl.FIn = paramString4;
      this.iWl.FIo = paramString5;
      ae.d("MicroMsg.NetSceneAALaunchByPerson", "location %s", new Object[] { this.iWl.FIk });
      this.chatroomName = paramString2;
      ae.i("MicroMsg.NetSceneAALaunchByPerson", "NetSceneAALaunchByPerson, title: %s, total_pay_amount: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s, pic_cdn_url: %s, pic_cdn_thumb_url: %s, pf_order_no: %s", new Object[] { this.iWl.title, Long.valueOf(this.iWl.FIr), this.iWl.FIj, Integer.valueOf(this.iWl.scene), this.iWl.FIf, Long.valueOf(this.iWl.FIl), bu.bI(this.iWl.FIm, ""), bu.bI(this.iWl.FIn, ""), bu.bI(this.iWl.FIo, "") });
      AppMethodBeat.o(63382);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ae.e("MicroMsg.NetSceneAALaunchByPerson", "build NetSceneAALaunchByPerson request error: %s", new Object[] { paramString1.getMessage() });
      }
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(63383);
    ae.d("MicroMsg.NetSceneAALaunchByPerson", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
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
    ae.i("MicroMsg.NetSceneAALaunchByPerson", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.iWm = ((i)((b)paramq).hQE.hQJ);
    paramInt1 = this.iWm.dmy;
    paramq = this.iWm.phe;
    paramArrayOfByte = this.iWm.FIe;
    if (this.iWm.FIg == null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.NetSceneAALaunchByPerson", "retcode: %s, retmsg: %s, bill_no: %s, msgxml==null: %s", new Object[] { Integer.valueOf(paramInt1), paramq, paramArrayOfByte, Boolean.valueOf(bool) });
      ae.d("MicroMsg.NetSceneAALaunchByPerson", "msgxml: %s", new Object[] { this.iWm.FIg });
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