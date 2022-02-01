package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ec
  extends a
{
  private long dXS = 0L;
  private long dXT = 0L;
  private String dXU = "";
  private long dXV = 0L;
  private String dXW = "";
  private long dXX = 0L;
  private long dXY = 0L;
  private long dXZ = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(74990);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dXS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXZ);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(74990);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(74991);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SearchID:").append(this.dXS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecommentID:").append(this.dXT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueryContent:").append(this.dXU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinishType:").append(this.dXV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Behavior:").append(this.dXW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MaxIndex:").append(this.dXX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewSearchID:").append(this.dXY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewRecommentID:").append(this.dXZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(74991);
    return localObject;
  }
  
  public final String RJ()
  {
    return this.dXW;
  }
  
  public final ec gN(long paramLong)
  {
    this.dXV = paramLong;
    return this;
  }
  
  public final ec gO(long paramLong)
  {
    this.dXX = paramLong;
    return this;
  }
  
  public final ec gP(long paramLong)
  {
    this.dXY = paramLong;
    return this;
  }
  
  public final ec gQ(long paramLong)
  {
    this.dXZ = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 17121;
  }
  
  public final ec ks(String paramString)
  {
    AppMethodBeat.i(74988);
    this.dXU = t("QueryContent", paramString, true);
    AppMethodBeat.o(74988);
    return this;
  }
  
  public final ec kt(String paramString)
  {
    AppMethodBeat.i(74989);
    this.dXW = t("Behavior", paramString, true);
    AppMethodBeat.o(74989);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ec
 * JD-Core Version:    0.7.0.1
 */