package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
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
  private d hJu;
  private com.tencent.mm.protocal.protobuf.f jTe;
  public com.tencent.mm.protocal.protobuf.g jTf;
  
  public f(long paramLong1, String paramString1, int paramInt1, int paramInt2, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(63379);
    d.a locala = new d.a();
    locala.iLN = new com.tencent.mm.protocal.protobuf.f();
    locala.iLO = new com.tencent.mm.protocal.protobuf.g();
    locala.funcId = 1624;
    locala.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.hJu = locala.aXF();
    this.jTe = ((com.tencent.mm.protocal.protobuf.f)this.hJu.iLK.iLR);
    this.chatroomName = paramString2;
    try
    {
      this.jTe.KBv = paramInt1;
      this.jTe.KBw = paramLong1;
      this.jTe.title = URLEncoder.encode(paramString1, "UTF-8");
      this.jTe.KBx = new LinkedList();
      this.jTe.scene = paramInt2;
      this.jTe.KBt = paramString2;
      this.jTe.KBy = k.fQy();
      Log.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", new Object[] { this.jTe.KBy });
      this.jTe.KBz = paramLong2;
      Log.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp", new Object[] { Integer.valueOf(this.jTe.KBv), Long.valueOf(this.jTe.KBw), this.jTe.title, this.jTe.KBx, Integer.valueOf(this.jTe.scene), this.jTe.KBt, Long.valueOf(this.jTe.KBz) });
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
  
  public f(long paramLong1, String paramString1, List<String> paramList, int paramInt, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(63378);
    d.a locala = new d.a();
    locala.iLN = new com.tencent.mm.protocal.protobuf.f();
    locala.iLO = new com.tencent.mm.protocal.protobuf.g();
    locala.funcId = 1624;
    locala.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.chatroomName = paramString2;
    this.hJu = locala.aXF();
    this.jTe = ((com.tencent.mm.protocal.protobuf.f)this.hJu.iLK.iLR);
    this.hJu.setIsUserCmd(true);
    if (paramList != null) {}
    try
    {
      if (paramList.size() > 0)
      {
        this.jTe.KBv = paramList.size();
        this.jTe.KBw = paramLong1;
        this.jTe.title = URLEncoder.encode(paramString1, "UTF-8");
        this.jTe.KBx = new LinkedList();
        this.jTe.KBx.addAll(paramList);
        this.jTe.scene = paramInt;
        this.jTe.KBt = paramString2;
        this.jTe.KBy = k.fQy();
        this.jTe.KBz = paramLong2;
        this.jTe.KBA = paramString3;
        this.jTe.KBB = paramString4;
        this.jTe.KBC = paramString5;
        Log.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", new Object[] { this.jTe.KBy });
      }
      Log.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s, pic_cdn_url: %s, pic_cdn_thumb_url: %s, pf_order_no: %s", new Object[] { Integer.valueOf(this.jTe.KBv), Long.valueOf(this.jTe.KBw), this.jTe.title, this.jTe.KBx, Integer.valueOf(this.jTe.scene), this.jTe.KBt, Long.valueOf(this.jTe.KBz), Util.nullAs(this.jTe.KBA, ""), Util.nullAs(this.jTe.KBB, ""), Util.nullAs(this.jTe.KBC, "") });
      AppMethodBeat.o(63378);
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
    int i = dispatch(paramg, this.hJu, this);
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
    this.jTf = ((com.tencent.mm.protocal.protobuf.g)((d)params).iLL.iLR);
    paramInt1 = this.jTf.dDN;
    params = this.jTf.qwn;
    if (this.jTf.KBu == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.NetSceneAALaunchByMoney", "retcode: %s, retmsg: %s, msgxml==null: %s, billNo: %s", new Object[] { Integer.valueOf(paramInt1), params, Boolean.valueOf(bool), this.jTf.KBs });
      Log.d("MicroMsg.NetSceneAALaunchByMoney", "msgxml: %s", new Object[] { this.jTf.KBu });
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(63381);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.f
 * JD-Core Version:    0.7.0.1
 */