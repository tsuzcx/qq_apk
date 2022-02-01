package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cb
  extends a
{
  private long gcX;
  private long goO;
  private long goP;
  private long goQ;
  private long gof;
  
  public final String agH()
  {
    AppMethodBeat.i(208100);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.goO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gof);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(208100);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208101);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickTimestamps:").append(this.goO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickType:").append(this.goP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Outcome:").append(this.goQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentScene:").append(this.gcX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Followcount:").append(this.gof);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208101);
    return localObject;
  }
  
  public final cb eD(long paramLong)
  {
    this.goO = paramLong;
    return this;
  }
  
  public final cb eE(long paramLong)
  {
    this.goP = paramLong;
    return this;
  }
  
  public final cb eF(long paramLong)
  {
    this.goQ = paramLong;
    return this;
  }
  
  public final cb eG(long paramLong)
  {
    this.gcX = paramLong;
    return this;
  }
  
  public final cb eH(long paramLong)
  {
    this.gof = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 21077;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.cb
 * JD-Core Version:    0.7.0.1
 */