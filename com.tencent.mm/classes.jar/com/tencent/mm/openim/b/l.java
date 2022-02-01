package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.cwk;
import com.tencent.mm.protocal.protobuf.cwl;
import com.tencent.mm.sdk.platformtools.Log;

public final class l
  extends q
  implements m
{
  private i callback;
  public k.b jHe;
  private int opType;
  private final d rr;
  
  public l(k.b paramb)
  {
    AppMethodBeat.i(116859);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cwk();
    ((d.a)localObject).iLO = new cwl();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/openimoplog";
    ((d.a)localObject).funcId = 806;
    this.rr = ((d.a)localObject).aXF();
    this.opType = paramb.zqr;
    this.jHe = paramb;
    Log.i("MicroMsg.Openim.NetSceneOpenIMOPLog", "type: %d", new Object[] { Integer.valueOf(this.opType) });
    localObject = (cwk)this.rr.iLK.iLR;
    ((cwk)localObject).type = this.opType;
    ((cwk)localObject).MBx = new b(paramb.getBuffer());
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