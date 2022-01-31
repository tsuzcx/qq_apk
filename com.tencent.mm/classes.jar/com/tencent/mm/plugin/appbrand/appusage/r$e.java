package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class r$e
{
  public static final e fJj = new e();
  
  static void a(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    h.nFQ.f(14112, new Object[] { Integer.valueOf(1), bk.pm(paramString), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  static int ado()
  {
    int i;
    if (g.DP().Dz().getBoolean(ac.a.usY, false)) {
      i = 1;
    }
    int j;
    do
    {
      return i;
      j = ((Integer)g.DP().Dz().get(ac.a.usV, Integer.valueOf(0))).intValue();
      i = j;
    } while (j <= 0);
    return j + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.r.e
 * JD-Core Version:    0.7.0.1
 */