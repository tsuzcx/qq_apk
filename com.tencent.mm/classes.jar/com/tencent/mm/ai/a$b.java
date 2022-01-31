package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class a$b<_Resp extends bvk>
  extends m
{
  f eGj;
  final m fsP;
  b fsQ;
  com.tencent.mm.vending.g.b fsR;
  a fsS;
  private k fsT;
  final long mStartTime;
  
  public a$b(a parama)
  {
    AppMethodBeat.i(58151);
    this.eGj = null;
    this.fsP = this;
    this.mStartTime = bo.aoy();
    this.fsT = new a.b.1(this);
    this.fsS = parama;
    AppMethodBeat.o(58151);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(58152);
    this.eGj = paramf;
    int i = dispatch(parame, this.fsQ, this.fsT);
    ab.i("MicroMsg.Cgi", "Start doScene:%d func:%d netid:%d time:%d", new Object[] { Integer.valueOf(this.fsP.hashCode()), Integer.valueOf(getType()), Integer.valueOf(i), Long.valueOf(bo.aoy() - this.mStartTime) });
    if (i < 0) {
      com.tencent.mm.vending.g.f.a(this.fsR, new Object[] { a.a.a(3, -1, "", (bvk)this.fsQ.fsW.fta, this, this.fsS) });
    }
    AppMethodBeat.o(58152);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(146116);
    int i = this.fsQ.getType();
    AppMethodBeat.o(146116);
    return i;
  }
  
  protected final int securityLimitCount()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ai.a.b
 * JD-Core Version:    0.7.0.1
 */