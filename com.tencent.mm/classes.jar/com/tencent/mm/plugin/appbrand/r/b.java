package com.tencent.mm.plugin.appbrand.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fik;
import com.tencent.mm.protocal.protobuf.fil;
import com.tencent.mm.protocal.protobuf.fim;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Locale;

public final class b
  extends q
  implements m
{
  private i jQg;
  private d lyx;
  private fil qie;
  
  public b()
  {
    AppMethodBeat.i(47749);
    d.a locala = new d.a();
    locala.lBU = new fik();
    locala.lBV = new fil();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearchtitle";
    locala.funcId = getType();
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.lyx = locala.bgN();
    d.b.b(this.lyx.lBR);
    AppMethodBeat.o(47749);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(47750);
    Log.i("MicroMsg.NetSceneGetWeAppSearchTitle", "doScene");
    this.jQg = parami;
    int i = dispatch(paramg, this.lyx, this);
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
    this.qie = ((fil)d.c.b(this.lyx.lBS));
    if (this.jQg != null) {
      this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.qie.UIk == null)
    {
      AppMethodBeat.o(47751);
      return;
    }
    paramString = h.aHG().aHp();
    paramString.set(ar.a.Vok, Locale.getDefault().getLanguage());
    paramString.set(ar.a.Vol, this.qie.UIk.CNP);
    paramString.set(ar.a.Voo, this.qie.UIk.UIn);
    paramString.set(ar.a.Vop, Long.valueOf(System.currentTimeMillis()));
    paramString.set(ar.a.Vom, this.qie.UIl.CNP);
    paramString.set(ar.a.Von, this.qie.UIm.CNP);
    AppMethodBeat.o(47751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.b
 * JD-Core Version:    0.7.0.1
 */