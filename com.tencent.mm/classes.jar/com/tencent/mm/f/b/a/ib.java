package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ib
  extends a
{
  private long gHQ;
  private long gHR;
  private long gsB;
  private long gsS;
  
  public final String agH()
  {
    AppMethodBeat.i(248778);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gHQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHR);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(248778);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(248780);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EduType:").append(this.gHQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitType:").append(this.gsS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Duration:").append(this.gsB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ListEduType:").append(this.gHR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(248780);
    return localObject;
  }
  
  public final int getId()
  {
    return 22591;
  }
  
  public final ib so(long paramLong)
  {
    this.gHQ = paramLong;
    return this;
  }
  
  public final ib sp(long paramLong)
  {
    this.gsS = paramLong;
    return this;
  }
  
  public final ib sq(long paramLong)
  {
    this.gsB = paramLong;
    return this;
  }
  
  public final ib sr(long paramLong)
  {
    this.gHR = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ib
 * JD-Core Version:    0.7.0.1
 */