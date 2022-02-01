package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fi
  extends a
{
  private String dFe;
  private long dXn;
  private long dXo;
  private long dXp;
  private long dXq;
  
  public final String PR()
  {
    AppMethodBeat.i(209776);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXq);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(209776);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(209777);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PullStartTimeStamp:").append(this.dXn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PullEndTimeStamp:").append(this.dXo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSuccess:").append(this.dXp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FailedType:").append(this.dXq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209777);
    return localObject;
  }
  
  public final int getId()
  {
    return 20205;
  }
  
  public final fi ka(long paramLong)
  {
    this.dXn = paramLong;
    return this;
  }
  
  public final fi kb(long paramLong)
  {
    this.dXo = paramLong;
    return this;
  }
  
  public final fi kc(long paramLong)
  {
    this.dXp = paramLong;
    return this;
  }
  
  public final fi kd(long paramLong)
  {
    this.dXq = paramLong;
    return this;
  }
  
  public final fi mR(String paramString)
  {
    AppMethodBeat.i(209775);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(209775);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fi
 * JD-Core Version:    0.7.0.1
 */