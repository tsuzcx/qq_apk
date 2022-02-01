package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nc
  extends a
{
  private long gXO = 0L;
  private long gXP = 0L;
  private String gXQ = "";
  private long gXR = 0L;
  private String gXS = "";
  private long gXT = 0L;
  private long gXU = 0L;
  private long gXV = 0L;
  
  public final nc DQ(String paramString)
  {
    AppMethodBeat.i(74988);
    this.gXQ = z("QueryContent", paramString, true);
    AppMethodBeat.o(74988);
    return this;
  }
  
  public final nc DR(String paramString)
  {
    AppMethodBeat.i(74989);
    this.gXS = z("Behavior", paramString, true);
    AppMethodBeat.o(74989);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(74990);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gXO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXV);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(74990);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(74991);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SearchID:").append(this.gXO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecommentID:").append(this.gXP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueryContent:").append(this.gXQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinishType:").append(this.gXR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Behavior:").append(this.gXS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MaxIndex:").append(this.gXT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewSearchID:").append(this.gXU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewRecommentID:").append(this.gXV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(74991);
    return localObject;
  }
  
  public final String anP()
  {
    return this.gXS;
  }
  
  public final int getId()
  {
    return 17121;
  }
  
  public final nc yP(long paramLong)
  {
    this.gXR = paramLong;
    return this;
  }
  
  public final nc yQ(long paramLong)
  {
    this.gXT = paramLong;
    return this;
  }
  
  public final nc yR(long paramLong)
  {
    this.gXU = paramLong;
    return this;
  }
  
  public final nc yS(long paramLong)
  {
    this.gXV = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.nc
 * JD-Core Version:    0.7.0.1
 */