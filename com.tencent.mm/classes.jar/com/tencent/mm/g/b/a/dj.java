package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dj
  extends a
{
  private long dUo = 0L;
  private long dUp = 0L;
  private long dUq = 0L;
  private long dUr = 0L;
  private int dUs = 0;
  
  public final String PV()
  {
    AppMethodBeat.i(118500);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dUo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUs);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(118500);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(118501);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("StartZipTime:").append(this.dUo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Enable:").append(this.dUp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Exceed:").append(this.dUq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Cost:").append(this.dUr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Result:").append(this.dUs);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118501);
    return localObject;
  }
  
  public final dj QQ()
  {
    this.dUq = 1L;
    return this;
  }
  
  public final dj fU(long paramLong)
  {
    this.dUo = paramLong;
    return this;
  }
  
  public final dj fV(long paramLong)
  {
    this.dUp = paramLong;
    return this;
  }
  
  public final dj fW(long paramLong)
  {
    this.dUr = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 17654;
  }
  
  public final dj iD(int paramInt)
  {
    this.dUs = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dj
 * JD-Core Version:    0.7.0.1
 */