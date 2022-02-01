package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dgk;
import com.tencent.mm.protocal.protobuf.fro;
import com.tencent.mm.protocal.protobuf.frp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class f
  extends p
  implements m
{
  private dgk JUn;
  private h callback;
  private final c rr;
  
  public f(int paramInt, String paramString)
  {
    AppMethodBeat.i(26155);
    this.JUn = null;
    c.a locala = new c.a();
    locala.otE = new fro();
    locala.otF = new frp();
    locala.uri = "/cgi-bin/micromsg-bin/updatecontactlabel";
    locala.funcId = 637;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    if ((paramInt >= 0) && (!Util.isNullOrNil(paramString)))
    {
      this.JUn = new dgk();
      this.JUn.aaLB = paramInt;
      this.JUn.aaLA = paramString;
    }
    AppMethodBeat.o(26155);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(26157);
    this.callback = paramh;
    fro localfro = (fro)c.b.b(this.rr.otB);
    if (this.JUn != null)
    {
      localfro.abQX = this.JUn;
      int i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(26157);
      return i;
    }
    Log.e("MicroMsg.Label.NetSceneUpdateContactLabel", "cpan[doScene] label pair is null.");
    paramh.onSceneEnd(3, -1, "[doScene]empty label pair.", this);
    AppMethodBeat.o(26157);
    return 0;
  }
  
  public final int getType()
  {
    return 637;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26156);
    Log.d("MicroMsg.Label.NetSceneUpdateContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.f
 * JD-Core Version:    0.7.0.1
 */