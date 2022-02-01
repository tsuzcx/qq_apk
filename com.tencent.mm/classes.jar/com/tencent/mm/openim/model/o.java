package com.tencent.mm.openim.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.dya;
import com.tencent.mm.protocal.protobuf.dyb;
import com.tencent.mm.sdk.platformtools.Log;

public final class o
  extends p
  implements m
{
  private h callback;
  private int opType;
  public k.b psA;
  private final c rr;
  
  public o(k.b paramb)
  {
    AppMethodBeat.i(116859);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dya();
    ((c.a)localObject).otF = new dyb();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/openimoplog";
    ((c.a)localObject).funcId = 806;
    this.rr = ((c.a)localObject).bEF();
    this.opType = paramb.KRq;
    this.psA = paramb;
    Log.i("MicroMsg.Openim.NetSceneOpenIMOPLog", "type: %d", new Object[] { Integer.valueOf(this.opType) });
    localObject = (dya)c.b.b(this.rr.otB);
    ((dya)localObject).type = this.opType;
    ((dya)localObject).abdx = new b(paramb.getBuffer());
    AppMethodBeat.o(116859);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(116860);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(116860);
    return i;
  }
  
  public final int getType()
  {
    return 806;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(116861);
    Log.i("MicroMsg.Openim.NetSceneOpenIMOPLog", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, opType:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.opType) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(116861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.model.o
 * JD-Core Version:    0.7.0.1
 */