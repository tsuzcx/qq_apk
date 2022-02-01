package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.protocal.protobuf.chr;
import com.tencent.mm.protocal.protobuf.chs;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
  extends p
  implements m
{
  private h callback;
  private final c rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(21717);
    Log.i("MicroMsg.NetSceneGetConnectInfo", "BackupGetConnectInfoNetScene init, url[%s], stack[%s]", new Object[] { paramString, Util.getStack() });
    c.a locala = new c.a();
    locala.otE = new chr();
    locala.otF = new chs();
    locala.uri = "/cgi-bin/micromsg-bin/getconnectinfo";
    locala.otG = 0;
    locala.respCmdId = 0;
    locala.funcId = 595;
    this.rr = locala.bEF();
    ((chr)c.b.b(this.rr.otB)).URL = paramString;
    AppMethodBeat.o(21717);
  }
  
  public final chs cWE()
  {
    AppMethodBeat.i(300720);
    chs localchs = (chs)c.c.b(this.rr.otC);
    AppMethodBeat.o(300720);
    return localchs;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(21718);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(21718);
    return i;
  }
  
  public final int getType()
  {
    return 595;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21719);
    Log.i("MicroMsg.NetSceneGetConnectInfo", "onGYNetEnd errType[%d], errCode[%d]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = cWE();
      d.bf(params.YKf.aaxD.Op);
      Log.i("MicroMsg.NetSceneGetConnectInfo", "onGYNetEnd id[%s], hello[%s], ok[%s], PCName[%s], PCAcctName[%s], scene[%d], resource[%s]", new Object[] { params.vgy, params.YKT, params.YKU, params.YKM, params.YKN, Integer.valueOf(params.IJG), params.aaqq });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(21719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.e
 * JD-Core Version:    0.7.0.1
 */