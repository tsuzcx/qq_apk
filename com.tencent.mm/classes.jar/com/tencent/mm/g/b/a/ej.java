package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ej
  extends a
{
  private String dSD = "";
  private String ehO = "";
  public long ehP = 0L;
  public long ehQ = 0L;
  public long ehR = 0L;
  public long ehS = 0L;
  public long ehT = 0L;
  private String ehU = "";
  private String ehV = "";
  
  public final String RD()
  {
    AppMethodBeat.i(76368);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ehO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehV);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(76368);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(76369);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("statId:").append(this.ehO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("statEvent:").append(this.ehP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("statTimeStamp:").append(this.ehQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("success:").append(this.ehR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.dSD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchType:").append(this.ehS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasInitData:").append(this.ehT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("netType:").append(this.ehU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("jsError:").append(this.ehV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(76369);
    return localObject;
  }
  
  public final int getId()
  {
    return 14452;
  }
  
  public final ej nE(String paramString)
  {
    AppMethodBeat.i(76364);
    this.ehO = t("statId", paramString, true);
    AppMethodBeat.o(76364);
    return this;
  }
  
  public final ej nF(String paramString)
  {
    AppMethodBeat.i(76365);
    this.dSD = t("appid", paramString, true);
    AppMethodBeat.o(76365);
    return this;
  }
  
  public final ej nG(String paramString)
  {
    AppMethodBeat.i(76366);
    this.ehU = t("netType", paramString, true);
    AppMethodBeat.o(76366);
    return this;
  }
  
  public final ej nH(String paramString)
  {
    AppMethodBeat.i(76367);
    this.ehV = t("jsError", paramString, true);
    AppMethodBeat.o(76367);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ej
 * JD-Core Version:    0.7.0.1
 */