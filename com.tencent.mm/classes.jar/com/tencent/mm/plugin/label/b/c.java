package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aie;
import com.tencent.mm.protocal.protobuf.aif;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aw;
import java.util.ArrayList;

public final class c
  extends p
  implements m
{
  public ArrayList<aw> JUk;
  private String JUl;
  private h callback;
  private final com.tencent.mm.am.c rr;
  
  public c(String paramString)
  {
    AppMethodBeat.i(26146);
    this.JUl = null;
    this.JUk = new ArrayList();
    c.a locala = new c.a();
    locala.otE = new aie();
    locala.otF = new aif();
    locala.uri = "/cgi-bin/micromsg-bin/delcontactlabel";
    locala.funcId = 636;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.JUl = paramString;
    AppMethodBeat.o(26146);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(26148);
    this.callback = paramh;
    aie localaie = (aie)c.b.b(this.rr.otB);
    localaie.ZqN = this.JUl;
    if ((this.JUl != null) && (!Util.isNullOrNil(this.JUl)))
    {
      localaie.ZqN = this.JUl;
      localaie.ZqN = this.JUl;
      int i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(26148);
      return i;
    }
    Log.e("MicroMsg.Label.NetSceneDelContactLabel", "cpan[doScene] label id list is null.");
    paramh.onSceneEnd(3, -1, "[doScene]empty label is list.", this);
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
 * Qualified Name:     com.tencent.mm.plugin.label.b.c
 * JD-Core Version:    0.7.0.1
 */