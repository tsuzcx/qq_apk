package com.tencent.mm.plugin.box.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.byc;
import com.tencent.mm.protocal.protobuf.byd;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends q
  implements m
{
  private i callback;
  public String dPI;
  private d iUB;
  private long plM;
  public byd plN;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76328);
    this.dPI = paramString1;
    d.a locala = new d.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getweappbox";
    locala.iLN = new byc();
    locala.iLO = new byd();
    this.iUB = locala.aXF();
    ((byc)this.iUB.iLK.iLR).MdD = paramString2;
    Log.i("MicroMsg.Box.NetSceneBox", "Create NetSceneBox %s %s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(76328);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(76329);
    this.plM = System.currentTimeMillis();
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(76329);
    return i;
  }
  
  public final int getType()
  {
    return 1869;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(76330);
    Log.i("MicroMsg.Box.NetSceneBox", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.plM) });
    this.plN = ((byd)this.iUB.iLL.iLR);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(76330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.box.b.a
 * JD-Core Version:    0.7.0.1
 */