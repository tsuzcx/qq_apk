package com.tencent.mm.plugin.aa.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.h;
import com.tencent.mm.protocal.protobuf.i;
import com.tencent.mm.protocal.protobuf.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends com.tencent.mm.ai.m
  implements k
{
  private f callback;
  public String chatroomName;
  private b goo;
  private h gou;
  public i gov;
  
  public g(String paramString1, long paramLong1, List<j> paramList, int paramInt, String paramString2, long paramLong2)
  {
    AppMethodBeat.i(40651);
    b.a locala = new b.a();
    locala.fsX = new h();
    locala.fsY = new i();
    locala.funcId = 1655;
    locala.uri = "/cgi-bin/mmpay-bin/newaalaunchbyperson";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.goo = locala.ado();
    this.gou = ((h)this.goo.fsV.fta);
    this.goo.setIsUserCmd(true);
    try
    {
      this.gou.title = com.tencent.mm.compatible.util.q.encode(paramString1, "UTF-8");
      this.gou.wkf = paramLong1;
      this.gou.wkb = new LinkedList();
      this.gou.wkb.addAll(paramList);
      this.gou.scene = paramInt;
      this.gou.wjX = paramString2;
      this.gou.wkc = com.tencent.mm.plugin.wallet_core.model.m.cTC();
      this.gou.wkd = paramLong2;
      ab.d("MicroMsg.NetSceneAALaunchByPerson", "location %s", new Object[] { this.gou.wkc });
      this.chatroomName = paramString2;
      ab.i("MicroMsg.NetSceneAALaunchByPerson", "NetSceneAALaunchByPerson, title: %s, total_pay_amount: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s", new Object[] { this.gou.title, Long.valueOf(this.gou.wkf), this.gou.wkb, Integer.valueOf(this.gou.scene), this.gou.wjX, Long.valueOf(this.gou.wkd) });
      AppMethodBeat.o(40651);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ab.e("MicroMsg.NetSceneAALaunchByPerson", "build NetSceneAALaunchByPerson request error: %s", new Object[] { paramString1.getMessage() });
      }
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(40652);
    ab.d("MicroMsg.NetSceneAALaunchByPerson", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.goo, this);
    AppMethodBeat.o(40652);
    return i;
  }
  
  public final int getType()
  {
    return 1655;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(40653);
    ab.i("MicroMsg.NetSceneAALaunchByPerson", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.gov = ((i)((b)paramq).fsW.fta);
    paramInt1 = this.gov.cnK;
    paramq = this.gov.kNv;
    paramArrayOfByte = this.gov.wjW;
    if (this.gov.wjY == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.NetSceneAALaunchByPerson", "retcode: %s, retmsg: %s, bill_no: %s, msgxml==null: %s", new Object[] { Integer.valueOf(paramInt1), paramq, paramArrayOfByte, Boolean.valueOf(bool) });
      ab.d("MicroMsg.NetSceneAALaunchByPerson", "msgxml: %s", new Object[] { this.gov.wjY });
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(40653);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.a.g
 * JD-Core Version:    0.7.0.1
 */