package com.tencent.matrix.a.a.a;

import android.content.Context;
import com.tencent.matrix.a.b.i;
import com.tencent.matrix.a.b.i.a;

public final class l
  extends a
{
  public static a bj(Context paramContext)
  {
    paramContext = i.bt(paramContext);
    if (paramContext == null) {
      return null;
    }
    a locala = new a();
    locala.cWD = j.a.c.b.c(Long.valueOf(paramContext.cXH));
    locala.cWE = j.a.c.b.c(Long.valueOf(paramContext.cXI));
    locala.cWF = j.a.c.b.c(Long.valueOf(paramContext.cXJ));
    locala.cWG = j.a.c.b.c(Long.valueOf(paramContext.cXK));
    return locala;
  }
  
  public final int Wh()
  {
    return -2147483648;
  }
  
  protected final String getTag()
  {
    return "Matrix.battery.TrafficMonitorFeature";
  }
  
  public static final class a
    extends j.a<a>
  {
    public j.a.c.b<Long> cWD = j.a.c.b.c(Long.valueOf(0L));
    public j.a.c.b<Long> cWE = j.a.c.b.c(Long.valueOf(0L));
    public j.a.c.b<Long> cWF = j.a.c.b.c(Long.valueOf(0L));
    public j.a.c.b<Long> cWG = j.a.c.b.c(Long.valueOf(0L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.a.a.l
 * JD-Core Version:    0.7.0.1
 */