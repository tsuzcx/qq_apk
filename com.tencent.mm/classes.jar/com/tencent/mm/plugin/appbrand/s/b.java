package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.gex;
import com.tencent.mm.protocal.protobuf.gey;
import com.tencent.mm.protocal.protobuf.gez;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Locale;

public final class b
  extends p
  implements m
{
  private com.tencent.mm.am.h mAY;
  private c opY;
  private gey tmQ;
  
  public b()
  {
    AppMethodBeat.i(47749);
    c.a locala = new c.a();
    locala.otE = new gex();
    locala.otF = new gey();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearchtitle";
    locala.funcId = getType();
    locala.otG = 0;
    locala.respCmdId = 0;
    this.opY = locala.bEF();
    c.b.b(this.opY.otB);
    AppMethodBeat.o(47749);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(47750);
    Log.i("MicroMsg.NetSceneGetWeAppSearchTitle", "doScene");
    this.mAY = paramh;
    int i = dispatch(paramg, this.opY, this);
    AppMethodBeat.o(47750);
    return i;
  }
  
  public final int getType()
  {
    return 1170;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(47751);
    Log.i("MicroMsg.NetSceneGetWeAppSearchTitle", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.tmQ = ((gey)c.c.b(this.opY.otC));
    if (this.mAY != null) {
      this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.tmQ.acct == null)
    {
      AppMethodBeat.o(47751);
      return;
    }
    paramString = com.tencent.mm.kernel.h.baE().ban();
    paramString.set(at.a.acPG, Locale.getDefault().getLanguage());
    paramString.set(at.a.acPH, this.tmQ.acct.IHZ);
    paramString.set(at.a.acPK, this.tmQ.acct.accw);
    paramString.set(at.a.acPL, Long.valueOf(System.currentTimeMillis()));
    paramString.set(at.a.acPI, this.tmQ.accu.IHZ);
    paramString.set(at.a.acPJ, this.tmQ.accv.IHZ);
    AppMethodBeat.o(47751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.b
 * JD-Core Version:    0.7.0.1
 */