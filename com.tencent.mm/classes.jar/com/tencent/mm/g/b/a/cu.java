package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cu
  extends a
{
  private String dGR;
  private String dSJ;
  private String dSO;
  private String dSQ;
  public long dSR = 0L;
  public long dSS = 0L;
  public long dST = 0L;
  public long dSU = 0L;
  public long dSV = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(110282);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dGR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dST);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSO);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(110282);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(110283);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.dGR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LaunchUserName:").append(this.dSJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgUserName:").append(this.dSQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionSvrId:").append(this.dSR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasHeader:").append(this.dSS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasTail:").append(this.dST);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasExample:").append(this.dSU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActiveScene:").append(this.dSV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.dSO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110283);
    return localObject;
  }
  
  public final int getId()
  {
    return 18244;
  }
  
  public final cu jm(String paramString)
  {
    AppMethodBeat.i(110278);
    this.dGR = t("ChatName", paramString, true);
    AppMethodBeat.o(110278);
    return this;
  }
  
  public final cu jn(String paramString)
  {
    AppMethodBeat.i(110279);
    this.dSJ = t("LaunchUserName", paramString, true);
    AppMethodBeat.o(110279);
    return this;
  }
  
  public final cu jo(String paramString)
  {
    AppMethodBeat.i(110280);
    this.dSQ = t("MsgUserName", paramString, true);
    AppMethodBeat.o(110280);
    return this;
  }
  
  public final cu jp(String paramString)
  {
    AppMethodBeat.i(110281);
    this.dSO = t("Identifier", paramString, true);
    AppMethodBeat.o(110281);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cu
 * JD-Core Version:    0.7.0.1
 */