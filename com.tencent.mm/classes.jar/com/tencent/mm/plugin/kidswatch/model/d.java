package com.tencent.mm.plugin.kidswatch.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dgd;
import com.tencent.mm.protocal.protobuf.dge;

public final class d
  extends p
  implements m
{
  private h callback;
  private final c oDw;
  
  public d(String paramString)
  {
    AppMethodBeat.i(262242);
    c.a locala = new c.a();
    dgd localdgd = new dgd();
    dge localdge = new dge();
    locala.otE = localdgd;
    locala.otF = localdge;
    locala.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmcancel";
    locala.funcId = 973;
    locala.otG = 0;
    locala.respCmdId = 0;
    localdgd.Zwg = paramString;
    this.oDw = locala.bEF();
    AppMethodBeat.o(262242);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(262251);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(262251);
    return i;
  }
  
  public final int getType()
  {
    return 973;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(262259);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(262259);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.model.d
 * JD-Core Version:    0.7.0.1
 */