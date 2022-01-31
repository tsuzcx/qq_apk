package com.tencent.mm.modelstat;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.protocal.c.bjh;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class o$3
  implements w.a
{
  o$3(long paramLong, bjh parambjh) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    y.d("MicroMsg.NetTypeReporter", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Long.valueOf(bk.co(this.eEF)), this.eEG.nFs });
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.o.3
 * JD-Core Version:    0.7.0.1
 */