package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mn
  extends a
{
  public long iKD = 0L;
  private String ipx = "";
  private String iso = "";
  private String jbI = "";
  public long jbJ = 0L;
  public long jbK = 0L;
  public long jbL = 0L;
  public long jbM = 0L;
  private String jbN = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(76368);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jbI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iso);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbN);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(76368);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(76369);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("statId:").append(this.jbI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("statEvent:").append(this.jbJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("statTimeStamp:").append(this.jbK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("success:").append(this.jbL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.ipx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchType:").append(this.iKD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasInitData:").append(this.jbM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("netType:").append(this.iso);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("jsError:").append(this.jbN);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(76369);
    return localObject;
  }
  
  public final int getId()
  {
    return 14452;
  }
  
  public final mn uX(String paramString)
  {
    AppMethodBeat.i(76364);
    this.jbI = F("statId", paramString, true);
    AppMethodBeat.o(76364);
    return this;
  }
  
  public final mn uY(String paramString)
  {
    AppMethodBeat.i(76365);
    this.ipx = F("appid", paramString, true);
    AppMethodBeat.o(76365);
    return this;
  }
  
  public final mn uZ(String paramString)
  {
    AppMethodBeat.i(76366);
    this.iso = F("netType", paramString, true);
    AppMethodBeat.o(76366);
    return this;
  }
  
  public final mn va(String paramString)
  {
    AppMethodBeat.i(76367);
    this.jbN = F("jsError", paramString, true);
    AppMethodBeat.o(76367);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.mn
 * JD-Core Version:    0.7.0.1
 */