package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cpn;
import com.tencent.mm.protocal.protobuf.cpo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;
import java.util.LinkedList;

public final class h
  extends w
{
  private cpn KJk;
  public cpo KJl;
  private com.tencent.mm.am.h callback;
  private c nao;
  
  public h()
  {
    AppMethodBeat.i(65997);
    c.a locala = new c.a();
    locala.otE = new cpn();
    locala.otF = new cpo();
    locala.funcId = 1754;
    locala.uri = "/cgi-bin/mmpay-bin/tenpay/getpaymenu";
    locala.otG = 0;
    locala.respCmdId = 0;
    this.nao = locala.bEF();
    this.KJk = ((cpn)c.b.b(this.nao.otB));
    AppMethodBeat.o(65997);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(65998);
    Log.d("MicroMsg.NetSceneGetPayMenu", "doScene");
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(65998);
    return i;
  }
  
  public final int getType()
  {
    return 1754;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(262383);
    Log.i("MicroMsg.NetSceneGetPayMenu", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.KJl = ((cpo)c.c.b(this.nao.otC));
      params = this.KJl.title;
      paramArrayOfByte = this.KJl.aawj;
      if (this.KJl.aawj == null) {
        break label142;
      }
    }
    label142:
    for (paramInt1 = this.KJl.aawj.size();; paramInt1 = 0)
    {
      Log.i("MicroMsg.NetSceneGetPayMenu", "onGYNetEnd, title: %s, sectors: %s, sectors.size: %s", new Object[] { params, paramArrayOfByte, Integer.valueOf(paramInt1) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(262383);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.h
 * JD-Core Version:    0.7.0.1
 */