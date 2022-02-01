package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.dfu;
import com.tencent.mm.protocal.protobuf.dfv;
import com.tencent.mm.sdk.platformtools.Log;

public final class l
  extends q
  implements m
{
  private i callback;
  public k.b myi;
  private int opType;
  private final d rr;
  
  public l(k.b paramb)
  {
    AppMethodBeat.i(116859);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dfu();
    ((d.a)localObject).lBV = new dfv();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/openimoplog";
    ((d.a)localObject).funcId = 806;
    this.rr = ((d.a)localObject).bgN();
    this.opType = paramb.EVQ;
    this.myi = paramb;
    Log.i("MicroMsg.Openim.NetSceneOpenIMOPLog", "type: %d", new Object[] { Integer.valueOf(this.opType) });
    localObject = (dfu)d.b.b(this.rr.lBR);
    ((dfu)localObject).type = this.opType;
    ((dfu)localObject).TNe = new b(paramb.getBuffer());
    AppMethodBeat.o(116859);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(116860);
    this.callback = parami;
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
 * Qualified Name:     com.tencent.mm.openim.b.l
 * JD-Core Version:    0.7.0.1
 */