package com.tencent.matrix.a.a.a;

import android.content.Context;
import com.tencent.matrix.a.b.m;

public final class o
  extends a
{
  public static a bT(Context paramContext)
  {
    paramContext = m.cg(paramContext);
    if (paramContext == null) {
      return null;
    }
    a locala = new a();
    locala.eSK = m.a.c.b.c(Long.valueOf(paramContext.eUg));
    locala.eSL = m.a.c.b.c(Long.valueOf(paramContext.eUh));
    locala.eSM = m.a.c.b.c(Long.valueOf(paramContext.eUi));
    locala.eSN = m.a.c.b.c(Long.valueOf(paramContext.eUj));
    return locala;
  }
  
  public final int awQ()
  {
    return -2147483648;
  }
  
  protected final String getTag()
  {
    return "Matrix.battery.TrafficMonitorFeature";
  }
  
  public static class a
    extends m.a<a>
  {
    public m.a.c.b<Long> eSK = m.a.c.b.c(Long.valueOf(0L));
    public m.a.c.b<Long> eSL = m.a.c.b.c(Long.valueOf(0L));
    public m.a.c.b<Long> eSM = m.a.c.b.c(Long.valueOf(0L));
    public m.a.c.b<Long> eSN = m.a.c.b.c(Long.valueOf(0L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.a.a.o
 * JD-Core Version:    0.7.0.1
 */