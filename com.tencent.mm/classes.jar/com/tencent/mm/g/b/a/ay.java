package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ay
  extends a
{
  private long cWi = 0L;
  private long cWj = 0L;
  private long cWk = 0L;
  private long cWl = 0L;
  private int cWm = 0;
  
  public final ay FD()
  {
    this.cWk = 1L;
    return this;
  }
  
  public final String Ff()
  {
    AppMethodBeat.i(155285);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cWi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cWj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cWk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cWl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cWm);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(155285);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(155286);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("StartZipTime:").append(this.cWi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Enable:").append(this.cWj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Exceed:").append(this.cWk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Cost:").append(this.cWl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Result:").append(this.cWm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(155286);
    return localObject;
  }
  
  public final ay cA(long paramLong)
  {
    this.cWj = paramLong;
    return this;
  }
  
  public final ay cB(long paramLong)
  {
    this.cWl = paramLong;
    return this;
  }
  
  public final ay cz(long paramLong)
  {
    this.cWi = paramLong;
    return this;
  }
  
  public final ay gK(int paramInt)
  {
    this.cWm = paramInt;
    return this;
  }
  
  public final int getId()
  {
    return 17654;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ay
 * JD-Core Version:    0.7.0.1
 */