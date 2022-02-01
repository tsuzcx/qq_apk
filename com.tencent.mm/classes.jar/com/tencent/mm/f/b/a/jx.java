package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jx
  extends a
{
  private long gMd = 0L;
  private long gMe = 0L;
  private long gMf = 0L;
  private long geB = 0L;
  
  public final String agH()
  {
    AppMethodBeat.i(268373);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gMd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMf);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(268373);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(268374);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("biz:").append(this.gMd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.geB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timecost:").append(this.gMe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isUseSysWebview:").append(this.gMf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(268374);
    return localObject;
  }
  
  public final int getId()
  {
    return 15005;
  }
  
  public final jx uA(long paramLong)
  {
    this.gMe = paramLong;
    return this;
  }
  
  public final jx uB(long paramLong)
  {
    this.gMf = paramLong;
    return this;
  }
  
  public final jx uy(long paramLong)
  {
    this.gMd = paramLong;
    return this;
  }
  
  public final jx uz(long paramLong)
  {
    this.geB = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.b.a.jx
 * JD-Core Version:    0.7.0.1
 */