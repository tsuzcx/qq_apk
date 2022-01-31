package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.h;
import com.tencent.mm.protocal.c.j;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends m
  implements k
{
  public String chatroomName;
  private f dmL;
  private b eWr;
  private h eWw;
  public com.tencent.mm.protocal.c.i eWx;
  
  public g(String paramString1, long paramLong1, List<j> paramList, int paramInt, String paramString2, long paramLong2)
  {
    b.a locala = new b.a();
    locala.ecH = new h();
    locala.ecI = new com.tencent.mm.protocal.c.i();
    locala.ecG = 1655;
    locala.uri = "/cgi-bin/mmpay-bin/newaalaunchbyperson";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.eWr = locala.Kt();
    this.eWw = ((h)this.eWr.ecE.ecN);
    this.eWr.ecZ = true;
    try
    {
      this.eWw.title = com.tencent.mm.compatible.util.q.encode(paramString1, "UTF-8");
      this.eWw.srz = paramLong1;
      this.eWw.srv = new LinkedList();
      this.eWw.srv.addAll(paramList);
      this.eWw.scene = paramInt;
      this.eWw.srr = paramString2;
      this.eWw.srw = com.tencent.mm.plugin.wallet_core.model.i.bVj();
      this.eWw.srx = paramLong2;
      y.d("MicroMsg.NetSceneAALaunchByPerson", "location %s", new Object[] { this.eWw.srw });
      this.chatroomName = paramString2;
      y.i("MicroMsg.NetSceneAALaunchByPerson", "NetSceneAALaunchByPerson, title: %s, total_pay_amount: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s", new Object[] { this.eWw.title, Long.valueOf(this.eWw.srz), this.eWw.srv, Integer.valueOf(this.eWw.scene), this.eWw.srr, Long.valueOf(this.eWw.srx) });
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        y.e("MicroMsg.NetSceneAALaunchByPerson", "build NetSceneAALaunchByPerson request error: %s", new Object[] { paramString1.getMessage() });
      }
    }
  }
  
  public final int a(e parame, f paramf)
  {
    y.d("MicroMsg.NetSceneAALaunchByPerson", "doScene");
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneAALaunchByPerson", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.eWx = ((com.tencent.mm.protocal.c.i)((b)paramq).ecF.ecN);
    paramInt1 = this.eWx.iHq;
    paramq = this.eWx.iHr;
    paramArrayOfByte = this.eWx.srq;
    if (this.eWx.srs == null) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.NetSceneAALaunchByPerson", "retcode: %s, retmsg: %s, bill_no: %s, msgxml==null: %s", new Object[] { Integer.valueOf(paramInt1), paramq, paramArrayOfByte, Boolean.valueOf(bool) });
      y.d("MicroMsg.NetSceneAALaunchByPerson", "msgxml: %s", new Object[] { this.eWx.srs });
      if (this.dmL != null) {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      return;
    }
  }
  
  public final int getType()
  {
    return 1655;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.a.g
 * JD-Core Version:    0.7.0.1
 */