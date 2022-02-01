package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.afr;
import com.tencent.mm.protocal.protobuf.afs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
  extends q
  implements m
{
  public String Edk;
  private i callback;
  private final d rr;
  
  public b(String paramString)
  {
    AppMethodBeat.i(26146);
    this.Edk = null;
    d.a locala = new d.a();
    locala.lBU = new afr();
    locala.lBV = new afs();
    locala.uri = "/cgi-bin/micromsg-bin/delcontactlabel";
    locala.funcId = 636;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    this.Edk = paramString;
    AppMethodBeat.o(26146);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(26148);
    this.callback = parami;
    afr localafr = (afr)d.b.b(this.rr.lBR);
    localafr.SrJ = this.Edk;
    if ((this.Edk != null) && (!Util.isNullOrNil(this.Edk)))
    {
      localafr.SrJ = this.Edk;
      localafr.SrJ = this.Edk;
      int i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(26148);
      return i;
    }
    Log.e("MicroMsg.Label.NetSceneDelContactLabel", "cpan[doScene] label id list is null.");
    parami.onSceneEnd(3, -1, "[doScene]empty label is list.", this);
    AppMethodBeat.o(26148);
    return 0;
  }
  
  public final int getType()
  {
    return 636;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26147);
    Log.d("MicroMsg.Label.NetSceneDelContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.b
 * JD-Core Version:    0.7.0.1
 */