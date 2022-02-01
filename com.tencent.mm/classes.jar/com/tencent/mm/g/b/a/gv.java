package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gv
  extends a
{
  private long erR = 0L;
  private long erS = 0L;
  private String erT = "";
  private long erU = 0L;
  private String erV = "";
  private long erW = 0L;
  private long erX = 0L;
  private long erY = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(74990);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erY);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(74990);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(74991);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SearchID:").append(this.erR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecommentID:").append(this.erS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueryContent:").append(this.erT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinishType:").append(this.erU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Behavior:").append(this.erV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MaxIndex:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewSearchID:").append(this.erX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewRecommentID:").append(this.erY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(74991);
    return localObject;
  }
  
  public final String Uy()
  {
    return this.erV;
  }
  
  public final int getId()
  {
    return 17121;
  }
  
  public final gv mf(long paramLong)
  {
    this.erU = paramLong;
    return this;
  }
  
  public final gv mg(long paramLong)
  {
    this.erW = paramLong;
    return this;
  }
  
  public final gv mh(long paramLong)
  {
    this.erX = paramLong;
    return this;
  }
  
  public final gv mi(long paramLong)
  {
    this.erY = paramLong;
    return this;
  }
  
  public final gv pW(String paramString)
  {
    AppMethodBeat.i(74988);
    this.erT = t("QueryContent", paramString, true);
    AppMethodBeat.o(74988);
    return this;
  }
  
  public final gv pX(String paramString)
  {
    AppMethodBeat.i(74989);
    this.erV = t("Behavior", paramString, true);
    AppMethodBeat.o(74989);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gv
 * JD-Core Version:    0.7.0.1
 */