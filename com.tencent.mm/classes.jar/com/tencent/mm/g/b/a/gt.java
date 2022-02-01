package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gt
  extends a
{
  private long eqk = 0L;
  private long eql = 0L;
  private String eqm = "";
  private long eqn = 0L;
  private String eqo = "";
  private long eqp = 0L;
  private long eqq = 0L;
  private long eqr = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(74990);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eql);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqr);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(74990);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(74991);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SearchID:").append(this.eqk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecommentID:").append(this.eql);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueryContent:").append(this.eqm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinishType:").append(this.eqn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Behavior:").append(this.eqo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MaxIndex:").append(this.eqp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewSearchID:").append(this.eqq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewRecommentID:").append(this.eqr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(74991);
    return localObject;
  }
  
  public final String Us()
  {
    return this.eqo;
  }
  
  public final int getId()
  {
    return 17121;
  }
  
  public final gt lU(long paramLong)
  {
    this.eqn = paramLong;
    return this;
  }
  
  public final gt lV(long paramLong)
  {
    this.eqp = paramLong;
    return this;
  }
  
  public final gt lW(long paramLong)
  {
    this.eqq = paramLong;
    return this;
  }
  
  public final gt lX(long paramLong)
  {
    this.eqr = paramLong;
    return this;
  }
  
  public final gt pB(String paramString)
  {
    AppMethodBeat.i(74988);
    this.eqm = t("QueryContent", paramString, true);
    AppMethodBeat.o(74988);
    return this;
  }
  
  public final gt pC(String paramString)
  {
    AppMethodBeat.i(74989);
    this.eqo = t("Behavior", paramString, true);
    AppMethodBeat.o(74989);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gt
 * JD-Core Version:    0.7.0.1
 */