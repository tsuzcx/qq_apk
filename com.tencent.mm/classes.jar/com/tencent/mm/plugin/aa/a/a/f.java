package com.tencent.mm.plugin.aa.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public final class f
  extends com.tencent.mm.ai.m
  implements k
{
  private com.tencent.mm.ai.f callback;
  public String chatroomName;
  private b goo;
  private com.tencent.mm.protocal.protobuf.f gos;
  public g got;
  
  public f(long paramLong1, String paramString1, int paramInt1, int paramInt2, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(40648);
    b.a locala = new b.a();
    locala.fsX = new com.tencent.mm.protocal.protobuf.f();
    locala.fsY = new g();
    locala.funcId = 1624;
    locala.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.goo = locala.ado();
    this.gos = ((com.tencent.mm.protocal.protobuf.f)this.goo.fsV.fta);
    this.chatroomName = paramString2;
    try
    {
      this.gos.wjZ = paramInt1;
      this.gos.wka = paramLong1;
      this.gos.title = URLEncoder.encode(paramString1, "UTF-8");
      this.gos.wkb = new LinkedList();
      this.gos.scene = paramInt2;
      this.gos.wjX = paramString2;
      this.gos.wkc = com.tencent.mm.plugin.wallet_core.model.m.cTC();
      ab.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", new Object[] { this.gos.wkc });
      this.gos.wkd = paramLong2;
      ab.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp", new Object[] { Integer.valueOf(this.gos.wjZ), Long.valueOf(this.gos.wka), this.gos.title, this.gos.wkb, Integer.valueOf(this.gos.scene), this.gos.wjX, Long.valueOf(this.gos.wkd) });
      AppMethodBeat.o(40648);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ab.e("MicroMsg.NetSceneAALaunchByMoney", "build NetSceneAALaunchByMoney request error: %s", new Object[] { paramString1.getMessage() });
      }
    }
  }
  
  public f(long paramLong1, String paramString1, List<String> paramList, int paramInt, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(40647);
    b.a locala = new b.a();
    locala.fsX = new com.tencent.mm.protocal.protobuf.f();
    locala.fsY = new g();
    locala.funcId = 1624;
    locala.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.chatroomName = paramString2;
    this.goo = locala.ado();
    this.gos = ((com.tencent.mm.protocal.protobuf.f)this.goo.fsV.fta);
    this.goo.setIsUserCmd(true);
    if (paramList != null) {}
    try
    {
      if (paramList.size() > 0)
      {
        this.gos.wjZ = paramList.size();
        this.gos.wka = paramLong1;
        this.gos.title = URLEncoder.encode(paramString1, "UTF-8");
        this.gos.wkb = new LinkedList();
        this.gos.wkb.addAll(paramList);
        this.gos.scene = paramInt;
        this.gos.wjX = paramString2;
        this.gos.wkc = com.tencent.mm.plugin.wallet_core.model.m.cTC();
        this.gos.wkd = paramLong2;
        ab.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", new Object[] { this.gos.wkc });
      }
      ab.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s", new Object[] { Integer.valueOf(this.gos.wjZ), Long.valueOf(this.gos.wka), this.gos.title, this.gos.wkb, Integer.valueOf(this.gos.scene), this.gos.wjX, Long.valueOf(this.gos.wkd) });
      AppMethodBeat.o(40647);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ab.e("MicroMsg.NetSceneAALaunchByMoney", "build NetSceneAALaunchByMoney request error: %s", new Object[] { paramString1.getMessage() });
      }
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(40649);
    ab.i("MicroMsg.NetSceneAALaunchByMoney", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.goo, this);
    AppMethodBeat.o(40649);
    return i;
  }
  
  public final int getType()
  {
    return 1624;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(40650);
    ab.i("MicroMsg.NetSceneAALaunchByMoney", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.got = ((g)((b)paramq).fsW.fta);
    paramInt1 = this.got.cnK;
    paramq = this.got.kNv;
    if (this.got.wjY == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.NetSceneAALaunchByMoney", "retcode: %s, retmsg: %s, msgxml==null: %s, billNo: %s", new Object[] { Integer.valueOf(paramInt1), paramq, Boolean.valueOf(bool), this.got.wjW });
      ab.d("MicroMsg.NetSceneAALaunchByMoney", "msgxml: %s", new Object[] { this.got.wjY });
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(40650);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.a.f
 * JD-Core Version:    0.7.0.1
 */