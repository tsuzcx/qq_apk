package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.sdk.platformtools.y;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public final class f
  extends m
  implements k
{
  public String chatroomName;
  private com.tencent.mm.ah.f dmL;
  private b eWr;
  private com.tencent.mm.protocal.c.f eWu;
  public g eWv;
  
  public f(long paramLong1, String paramString1, int paramInt1, int paramInt2, long paramLong2, String paramString2)
  {
    b.a locala = new b.a();
    locala.ecH = new com.tencent.mm.protocal.c.f();
    locala.ecI = new g();
    locala.ecG = 1624;
    locala.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.eWr = locala.Kt();
    this.eWu = ((com.tencent.mm.protocal.c.f)this.eWr.ecE.ecN);
    this.chatroomName = paramString2;
    try
    {
      this.eWu.srt = paramInt1;
      this.eWu.sru = paramLong1;
      this.eWu.title = URLEncoder.encode(paramString1, "UTF-8");
      this.eWu.srv = new LinkedList();
      this.eWu.scene = paramInt2;
      this.eWu.srr = paramString2;
      this.eWu.srw = i.bVj();
      y.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", new Object[] { this.eWu.srw });
      this.eWu.srx = paramLong2;
      y.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp", new Object[] { Integer.valueOf(this.eWu.srt), Long.valueOf(this.eWu.sru), this.eWu.title, this.eWu.srv, Integer.valueOf(this.eWu.scene), this.eWu.srr, Long.valueOf(this.eWu.srx) });
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        y.e("MicroMsg.NetSceneAALaunchByMoney", "build NetSceneAALaunchByMoney request error: %s", new Object[] { paramString1.getMessage() });
      }
    }
  }
  
  public f(long paramLong1, String paramString1, List<String> paramList, int paramInt, long paramLong2, String paramString2)
  {
    b.a locala = new b.a();
    locala.ecH = new com.tencent.mm.protocal.c.f();
    locala.ecI = new g();
    locala.ecG = 1624;
    locala.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.chatroomName = paramString2;
    this.eWr = locala.Kt();
    this.eWu = ((com.tencent.mm.protocal.c.f)this.eWr.ecE.ecN);
    this.eWr.ecZ = true;
    if (paramList != null) {}
    try
    {
      if (paramList.size() > 0)
      {
        this.eWu.srt = paramList.size();
        this.eWu.sru = paramLong1;
        this.eWu.title = URLEncoder.encode(paramString1, "UTF-8");
        this.eWu.srv = new LinkedList();
        this.eWu.srv.addAll(paramList);
        this.eWu.scene = paramInt;
        this.eWu.srr = paramString2;
        this.eWu.srw = i.bVj();
        this.eWu.srx = paramLong2;
        y.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", new Object[] { this.eWu.srw });
      }
      y.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s", new Object[] { Integer.valueOf(this.eWu.srt), Long.valueOf(this.eWu.sru), this.eWu.title, this.eWu.srv, Integer.valueOf(this.eWu.scene), this.eWu.srr, Long.valueOf(this.eWu.srx) });
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        y.e("MicroMsg.NetSceneAALaunchByMoney", "build NetSceneAALaunchByMoney request error: %s", new Object[] { paramString1.getMessage() });
      }
    }
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    y.i("MicroMsg.NetSceneAALaunchByMoney", "doScene");
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneAALaunchByMoney", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.eWv = ((g)((b)paramq).ecF.ecN);
    paramInt1 = this.eWv.iHq;
    paramq = this.eWv.iHr;
    if (this.eWv.srs == null) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.NetSceneAALaunchByMoney", "retcode: %s, retmsg: %s, msgxml==null: %s, billNo: %s", new Object[] { Integer.valueOf(paramInt1), paramq, Boolean.valueOf(bool), this.eWv.srq });
      y.d("MicroMsg.NetSceneAALaunchByMoney", "msgxml: %s", new Object[] { this.eWv.srs });
      if (this.dmL != null) {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      return;
    }
  }
  
  public final int getType()
  {
    return 1624;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.a.f
 * JD-Core Version:    0.7.0.1
 */