package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.djz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class o$3
  implements aa.a
{
  o$3(long paramLong, djz paramdjz) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, d paramd, q paramq)
  {
    AppMethodBeat.i(151112);
    Log.d("MicroMsg.NetTypeReporter", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Long.valueOf(Util.milliSecondsToNow(this.jpi)), this.jpj.Cyk });
    AppMethodBeat.o(151112);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelstat.o.3
 * JD-Core Version:    0.7.0.1
 */