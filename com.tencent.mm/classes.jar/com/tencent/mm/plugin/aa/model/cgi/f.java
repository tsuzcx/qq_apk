package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.model.w;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public final class f
  extends w
{
  private com.tencent.mm.am.h callback;
  public String chatroomName;
  private c nao;
  private com.tencent.mm.protocal.protobuf.g pHa;
  public com.tencent.mm.protocal.protobuf.h pHb;
  
  public f(long paramLong1, String paramString1, int paramInt1, int paramInt2, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(63379);
    c.a locala = new c.a();
    locala.otE = new com.tencent.mm.protocal.protobuf.g();
    locala.otF = new com.tencent.mm.protocal.protobuf.h();
    locala.funcId = 1624;
    locala.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
    locala.otG = 0;
    locala.respCmdId = 0;
    this.nao = locala.bEF();
    this.pHa = ((com.tencent.mm.protocal.protobuf.g)c.b.b(this.nao.otB));
    this.chatroomName = paramString2;
    try
    {
      this.pHa.YzO = paramInt1;
      this.pHa.YzP = paramLong1;
      this.pHa.title = URLEncoder.encode(paramString1, "UTF-8");
      this.pHa.YzQ = new LinkedList();
      this.pHa.scene = paramInt2;
      this.pHa.YzM = paramString2;
      this.pHa.YzR = k.iis();
      Log.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", new Object[] { this.pHa.YzR });
      this.pHa.YzS = paramLong2;
      Log.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp", new Object[] { Integer.valueOf(this.pHa.YzO), Long.valueOf(this.pHa.YzP), this.pHa.title, this.pHa.YzQ, Integer.valueOf(this.pHa.scene), this.pHa.YzM, Long.valueOf(this.pHa.YzS) });
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
    AppMethodBeat.i(268401);
    c.a locala = new c.a();
    locala.otE = new com.tencent.mm.protocal.protobuf.g();
    locala.otF = new com.tencent.mm.protocal.protobuf.h();
    locala.funcId = 1624;
    locala.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
    locala.otG = 0;
    locala.respCmdId = 0;
    this.chatroomName = paramString2;
    this.nao = locala.bEF();
    this.pHa = ((com.tencent.mm.protocal.protobuf.g)c.b.b(this.nao.otB));
    this.nao.setIsUserCmd(true);
    if (paramList != null) {}
    try
    {
      if (paramList.size() > 0)
      {
        this.pHa.YzO = paramList.size();
        this.pHa.YzP = paramLong1;
        this.pHa.title = URLEncoder.encode(paramString1, "UTF-8");
        this.pHa.YzQ = new LinkedList();
        this.pHa.YzQ.addAll(paramList);
        this.pHa.scene = paramInt;
        this.pHa.YzM = paramString2;
        this.pHa.YzR = k.iis();
        this.pHa.YzS = paramLong2;
        this.pHa.YzT = paramString3;
        this.pHa.YzU = paramString4;
        this.pHa.YzV = paramString5;
        this.pHa.YzW = paramString6;
        Log.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", new Object[] { this.pHa.YzR });
      }
      Log.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s, pic_cdn_url: %s, pic_cdn_thumb_url: %s, pf_order_no: %s,pic_cdn_md5:%s", new Object[] { Integer.valueOf(this.pHa.YzO), Long.valueOf(this.pHa.YzP), this.pHa.title, this.pHa.YzQ, Integer.valueOf(this.pHa.scene), this.pHa.YzM, Long.valueOf(this.pHa.YzS), Util.nullAs(this.pHa.YzT, ""), Util.nullAs(this.pHa.YzU, ""), Util.nullAs(this.pHa.YzV, ""), Util.nullAs(this.pHa.YzW, "") });
      AppMethodBeat.o(268401);
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
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(63380);
    Log.i("MicroMsg.NetSceneAALaunchByMoney", "doScene");
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(63380);
    return i;
  }
  
  public final int getType()
  {
    return 1624;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(268415);
    Log.i("MicroMsg.NetSceneAALaunchByMoney", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.pHb = ((com.tencent.mm.protocal.protobuf.h)c.c.b(((c)params).otC));
    paramInt1 = this.pHb.hAV;
    params = this.pHb.wYI;
    if (this.pHb.YzN == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.NetSceneAALaunchByMoney", "retcode: %s, retmsg: %s, msgxml==null: %s, billNo: %s", new Object[] { Integer.valueOf(paramInt1), params, Boolean.valueOf(bool), this.pHb.YzL });
      Log.d("MicroMsg.NetSceneAALaunchByMoney", "msgxml: %s", new Object[] { this.pHb.YzN });
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(268415);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.f
 * JD-Core Version:    0.7.0.1
 */