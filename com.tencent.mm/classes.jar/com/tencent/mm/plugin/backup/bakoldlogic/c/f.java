package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aje;
import com.tencent.mm.protocal.protobuf.ajf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class f
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  private final com.tencent.mm.ai.b rr;
  
  public f(String paramString)
  {
    AppMethodBeat.i(17895);
    ab.i("MicroMsg.NetSceneGetConnectInfo", "summerbak NetSceneGetConnectInfo init, url[%s], stack[%s]", new Object[] { paramString, bo.dtY() });
    b.a locala = new b.a();
    locala.fsX = new aje();
    locala.fsY = new ajf();
    locala.uri = "/cgi-bin/micromsg-bin/getconnectinfo";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    locala.funcId = 595;
    this.rr = locala.ado();
    ((aje)this.rr.fsV.fta).URL = paramString;
    AppMethodBeat.o(17895);
  }
  
  public final ajf aVn()
  {
    return (ajf)this.rr.fsW.fta;
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(17896);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(17896);
    return i;
  }
  
  public final int getType()
  {
    return 595;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(17897);
    ab.i("MicroMsg.NetSceneGetConnectInfo", "errType %d,  errCode %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (ajf)this.rr.fsW.fta;
      d.an(paramq.wsu.getBuffer().pW);
      ab.i("MicroMsg.NetSceneGetConnectInfo", "id:%s  hello:%s, ok:%s, PCName:%s, PCAcctName:%s, scene:%d", new Object[] { paramq.ID, paramq.wtj, paramq.wtk, paramq.wtc, paramq.wtd, Integer.valueOf(paramq.Scene) });
      ab.i("MicroMsg.NetSceneGetConnectInfo", "resource:%s", new Object[] { paramq.xaK });
      paramq.wsu.getBuffer();
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(17897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.f
 * JD-Core Version:    0.7.0.1
 */