package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.protocal.protobuf.brz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class o$3
  implements w.a
{
  o$3(long paramLong, brz parambrz) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    AppMethodBeat.i(78769);
    ab.d("MicroMsg.NetTypeReporter", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Long.valueOf(bo.hl(this.fUw)), this.fUx.qsu });
    AppMethodBeat.o(78769);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.o.3
 * JD-Core Version:    0.7.0.1
 */