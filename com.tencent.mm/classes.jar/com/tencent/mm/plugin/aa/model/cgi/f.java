package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public final class f
  extends q
  implements m
{
  private i callback;
  public String chatroomName;
  private d kwO;
  private com.tencent.mm.protocal.protobuf.g mKs;
  public h mKt;
  
  public f(long paramLong1, String paramString1, int paramInt1, int paramInt2, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(63379);
    d.a locala = new d.a();
    locala.lBU = new com.tencent.mm.protocal.protobuf.g();
    locala.lBV = new h();
    locala.funcId = 1624;
    locala.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.kwO = locala.bgN();
    this.mKs = ((com.tencent.mm.protocal.protobuf.g)d.b.b(this.kwO.lBR));
    this.chatroomName = paramString2;
    try
    {
      this.mKs.RDl = paramInt1;
      this.mKs.RDm = paramLong1;
      this.mKs.title = URLEncoder.encode(paramString1, "UTF-8");
      this.mKs.RDn = new LinkedList();
      this.mKs.scene = paramInt2;
      this.mKs.RDj = paramString2;
      this.mKs.RDo = k.gJe();
      Log.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", new Object[] { this.mKs.RDo });
      this.mKs.RDp = paramLong2;
      Log.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp", new Object[] { Integer.valueOf(this.mKs.RDl), Long.valueOf(this.mKs.RDm), this.mKs.title, this.mKs.RDn, Integer.valueOf(this.mKs.scene), this.mKs.RDj, Long.valueOf(this.mKs.RDp) });
      AppMethodBeat.o(63379);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Log.e("MicroMsg.NetSceneAALaunchByMoney", "build NetSceneAALaunchByMoney request error: %s", new Object[] { paramString1.getMessage() });
      }
    }
  }
  
  public f(long paramLong1, String paramString1, List<String> paramList, int paramInt, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(247236);
    d.a locala = new d.a();
    locala.lBU = new com.tencent.mm.protocal.protobuf.g();
    locala.lBV = new h();
    locala.funcId = 1624;
    locala.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.chatroomName = paramString2;
    this.kwO = locala.bgN();
    this.mKs = ((com.tencent.mm.protocal.protobuf.g)d.b.b(this.kwO.lBR));
    this.kwO.setIsUserCmd(true);
    if (paramList != null) {}
    try
    {
      if (paramList.size() > 0)
      {
        this.mKs.RDl = paramList.size();
        this.mKs.RDm = paramLong1;
        this.mKs.title = URLEncoder.encode(paramString1, "UTF-8");
        this.mKs.RDn = new LinkedList();
        this.mKs.RDn.addAll(paramList);
        this.mKs.scene = paramInt;
        this.mKs.RDj = paramString2;
        this.mKs.RDo = k.gJe();
        this.mKs.RDp = paramLong2;
        this.mKs.RDq = paramString3;
        this.mKs.RDr = paramString4;
        this.mKs.RDs = paramString5;
        this.mKs.RDt = paramString6;
        Log.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", new Object[] { this.mKs.RDo });
      }
      Log.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s, pic_cdn_url: %s, pic_cdn_thumb_url: %s, pf_order_no: %s,pic_cdn_md5:%s", new Object[] { Integer.valueOf(this.mKs.RDl), Long.valueOf(this.mKs.RDm), this.mKs.title, this.mKs.RDn, Integer.valueOf(this.mKs.scene), this.mKs.RDj, Long.valueOf(this.mKs.RDp), Util.nullAs(this.mKs.RDq, ""), Util.nullAs(this.mKs.RDr, ""), Util.nullAs(this.mKs.RDs, ""), Util.nullAs(this.mKs.RDt, "") });
      AppMethodBeat.o(247236);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Log.e("MicroMsg.NetSceneAALaunchByMoney", "build NetSceneAALaunchByMoney request error: %s", new Object[] { paramString1.getMessage() });
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(63380);
    Log.i("MicroMsg.NetSceneAALaunchByMoney", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, this.kwO, this);
    AppMethodBeat.o(63380);
    return i;
  }
  
  public final int getType()
  {
    return 1624;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63381);
    Log.i("MicroMsg.NetSceneAALaunchByMoney", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.mKt = ((h)d.c.b(((d)params).lBS));
    paramInt1 = this.mKt.fwx;
    params = this.mKt.tVo;
    if (this.mKt.RDk == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.NetSceneAALaunchByMoney", "retcode: %s, retmsg: %s, msgxml==null: %s, billNo: %s", new Object[] { Integer.valueOf(paramInt1), params, Boolean.valueOf(bool), this.mKt.RDi });
      Log.d("MicroMsg.NetSceneAALaunchByMoney", "msgxml: %s", new Object[] { this.mKt.RDk });
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