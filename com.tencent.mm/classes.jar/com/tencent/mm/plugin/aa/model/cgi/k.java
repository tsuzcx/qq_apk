package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.y;
import com.tencent.mm.protocal.protobuf.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class k
  extends w
{
  private h callback;
  private c nao;
  private y pHk;
  public z pHl;
  
  public k(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(63391);
    c.a locala = new c.a();
    locala.otE = new y();
    locala.otF = new z();
    locala.funcId = 1695;
    locala.uri = "/cgi-bin/mmpay-bin/newaaquerydetail";
    locala.otG = 0;
    locala.respCmdId = 0;
    this.nao = locala.bEF();
    this.pHk = ((y)c.b.b(this.nao.otB));
    this.pHk.YzL = paramString1;
    this.pHk.scene = paramInt1;
    this.pHk.YzM = paramString2;
    if (paramInt1 == 5)
    {
      Log.i("MicroMsg.NetSceneAAQueryDetail", "set sign and ver");
      this.pHk.sign = paramString3;
      this.pHk.ver = paramInt2;
    }
    Log.i("MicroMsg.NetSceneAAQueryDetail", "NetSceneAAQueryDetail, billNo: %s, scene: %s, groupId: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2 });
    AppMethodBeat.o(63391);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(63393);
    Log.i("MicroMsg.NetSceneAAQueryDetail", "doScene");
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(63393);
    return i;
  }
  
  public final int getType()
  {
    return 1695;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(268407);
    Log.i("MicroMsg.NetSceneAAQueryDetail", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.pHl = ((z)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneAAQueryDetail", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.pHl.hAV), this.pHl.wYI });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(268407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.k
 * JD-Core Version:    0.7.0.1
 */