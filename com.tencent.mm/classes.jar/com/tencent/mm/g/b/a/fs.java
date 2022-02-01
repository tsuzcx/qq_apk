package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fs
  extends a
{
  private long dZL = 0L;
  private long dZM = 0L;
  private String dZN = "";
  private long dZO = 0L;
  private String dZP = "";
  private long dZQ = 0L;
  private long dZR = 0L;
  private long dZS = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(74990);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZS);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(74990);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(74991);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SearchID:").append(this.dZL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecommentID:").append(this.dZM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueryContent:").append(this.dZN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinishType:").append(this.dZO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Behavior:").append(this.dZP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MaxIndex:").append(this.dZQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewSearchID:").append(this.dZR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewRecommentID:").append(this.dZS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(74991);
    return localObject;
  }
  
  public final String Sl()
  {
    return this.dZP;
  }
  
  public final int getId()
  {
    return 17121;
  }
  
  public final fs ki(long paramLong)
  {
    this.dZO = paramLong;
    return this;
  }
  
  public final fs kj(long paramLong)
  {
    this.dZQ = paramLong;
    return this;
  }
  
  public final fs kk(long paramLong)
  {
    this.dZR = paramLong;
    return this;
  }
  
  public final fs kl(long paramLong)
  {
    this.dZS = paramLong;
    return this;
  }
  
  public final fs nk(String paramString)
  {
    AppMethodBeat.i(74988);
    this.dZN = t("QueryContent", paramString, true);
    AppMethodBeat.o(74988);
    return this;
  }
  
  public final fs nl(String paramString)
  {
    AppMethodBeat.i(74989);
    this.dZP = t("Behavior", paramString, true);
    AppMethodBeat.o(74989);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fs
 * JD-Core Version:    0.7.0.1
 */