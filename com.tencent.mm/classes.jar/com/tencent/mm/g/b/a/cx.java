package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cx
  extends a
{
  private String edC;
  private long edD;
  private String edE;
  private long edF;
  private long edG;
  private long edH;
  private int edI;
  private long edy;
  
  public final String RD()
  {
    AppMethodBeat.i(211901);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.edC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edI);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(211901);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(211902);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomId:").append(this.edC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveId:").append(this.edD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("micId:").append(this.edE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveRole:").append(this.edy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("groupRole:").append(this.edF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("linkStatus:").append(this.edG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceMode:").append(this.edH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorCode:").append(this.edI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(211902);
    return localObject;
  }
  
  public final int getId()
  {
    return 19968;
  }
  
  public final cx iC(int paramInt)
  {
    this.edI = paramInt;
    return this;
  }
  
  public final cx iM(long paramLong)
  {
    this.edD = paramLong;
    return this;
  }
  
  public final cx iN(long paramLong)
  {
    this.edy = paramLong;
    return this;
  }
  
  public final cx iO(long paramLong)
  {
    this.edF = paramLong;
    return this;
  }
  
  public final cx iP(long paramLong)
  {
    this.edG = paramLong;
    return this;
  }
  
  public final cx iQ(long paramLong)
  {
    this.edH = paramLong;
    return this;
  }
  
  public final cx mc(String paramString)
  {
    AppMethodBeat.i(211900);
    this.edE = t("micId", paramString, true);
    AppMethodBeat.o(211900);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cx
 * JD-Core Version:    0.7.0.1
 */