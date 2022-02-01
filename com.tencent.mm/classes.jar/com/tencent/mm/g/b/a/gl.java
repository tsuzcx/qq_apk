package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gl
  extends a
{
  private long epm;
  private long epn;
  private long epo;
  private String epv = "";
  private long epx;
  
  public final String RC()
  {
    AppMethodBeat.i(188496);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.epm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epv);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(188496);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(188497);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PullStartTimeStamp:").append(this.epm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PullEndTimeStamp:").append(this.epn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSuccess:").append(this.epo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WordSize:").append(this.epx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WordVersion:").append(this.epv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(188497);
    return localObject;
  }
  
  public final int getId()
  {
    return 20203;
  }
  
  public final gl mb(long paramLong)
  {
    this.epm = paramLong;
    return this;
  }
  
  public final gl mc(long paramLong)
  {
    this.epn = paramLong;
    return this;
  }
  
  public final gl md(long paramLong)
  {
    this.epo = paramLong;
    return this;
  }
  
  public final gl me(long paramLong)
  {
    this.epx = paramLong;
    return this;
  }
  
  public final gl pB(String paramString)
  {
    AppMethodBeat.i(188495);
    this.epv = t("WordVersion", paramString, true);
    AppMethodBeat.o(188495);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gl
 * JD-Core Version:    0.7.0.1
 */