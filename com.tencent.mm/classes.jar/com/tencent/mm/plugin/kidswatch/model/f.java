package com.tencent.mm.plugin.kidswatch.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dgc;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.protocal.protobuf.dgi;

public final class f
  extends p
  implements m
{
  private boolean JTq;
  private h callback;
  private final c oDw;
  
  public f(String paramString1, String paramString2, int paramInt, dgc paramdgc)
  {
    AppMethodBeat.i(262252);
    this.JTq = false;
    c.a locala = new c.a();
    dgh localdgh = new dgh();
    dgi localdgi = new dgi();
    locala.otE = localdgh;
    locala.otF = localdgi;
    locala.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmok";
    locala.funcId = 972;
    locala.otG = 0;
    locala.respCmdId = 0;
    localdgh.Zwg = paramString1;
    localdgh.Zws = paramString2;
    localdgh.Zwu = false;
    localdgh.Zwv = paramInt;
    localdgh.Zww = paramdgc;
    this.oDw = locala.bEF();
    AppMethodBeat.o(262252);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(262270);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(262270);
    return i;
  }
  
  public final int getType()
  {
    return 972;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(262279);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(262279);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.model.f
 * JD-Core Version:    0.7.0.1
 */