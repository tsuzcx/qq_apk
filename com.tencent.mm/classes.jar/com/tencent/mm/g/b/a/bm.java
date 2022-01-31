package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bm
  extends a
{
  private long cXR = 0L;
  private long cXS = 0L;
  private String cXT = "";
  private long cXU = 0L;
  private String cXV = "";
  private long cXW = 0L;
  private long cXX = 0L;
  private long cXY = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(108889);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cXR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXY);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(108889);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(108890);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SearchID:").append(this.cXR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecommentID:").append(this.cXS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueryContent:").append(this.cXT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinishType:").append(this.cXU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Behavior:").append(this.cXV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MaxIndex:").append(this.cXW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewSearchID:").append(this.cXX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewRecommentID:").append(this.cXY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(108890);
    return localObject;
  }
  
  public final String Gw()
  {
    return this.cXV;
  }
  
  public final bm dI(long paramLong)
  {
    this.cXU = paramLong;
    return this;
  }
  
  public final bm dJ(long paramLong)
  {
    this.cXW = paramLong;
    return this;
  }
  
  public final bm dK(long paramLong)
  {
    this.cXX = paramLong;
    return this;
  }
  
  public final bm dL(long paramLong)
  {
    this.cXY = paramLong;
    return this;
  }
  
  public final bm gG(String paramString)
  {
    AppMethodBeat.i(108887);
    this.cXT = t("QueryContent", paramString, true);
    AppMethodBeat.o(108887);
    return this;
  }
  
  public final bm gH(String paramString)
  {
    AppMethodBeat.i(108888);
    this.cXV = t("Behavior", paramString, true);
    AppMethodBeat.o(108888);
    return this;
  }
  
  public final int getId()
  {
    return 17121;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bm
 * JD-Core Version:    0.7.0.1
 */