package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jz
  extends a
{
  private long eSQ;
  private long eSR;
  private long eSS;
  private String eSZ = "";
  private long eTb;
  
  public final String abV()
  {
    AppMethodBeat.i(199750);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eSQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eTb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSZ);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(199750);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(199751);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PullStartTimeStamp:").append(this.eSQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PullEndTimeStamp:").append(this.eSR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSuccess:").append(this.eSS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WordSize:").append(this.eTb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WordVersion:").append(this.eSZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(199751);
    return localObject;
  }
  
  public final int getId()
  {
    return 20203;
  }
  
  public final jz td(long paramLong)
  {
    this.eSQ = paramLong;
    return this;
  }
  
  public final jz te(long paramLong)
  {
    this.eSR = paramLong;
    return this;
  }
  
  public final jz tf(long paramLong)
  {
    this.eSS = paramLong;
    return this;
  }
  
  public final jz tg(long paramLong)
  {
    this.eTb = paramLong;
    return this;
  }
  
  public final jz xj(String paramString)
  {
    AppMethodBeat.i(199749);
    this.eSZ = x("WordVersion", paramString, true);
    AppMethodBeat.o(199749);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jz
 * JD-Core Version:    0.7.0.1
 */