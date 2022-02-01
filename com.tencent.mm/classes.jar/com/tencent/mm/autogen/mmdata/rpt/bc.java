package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bc
  extends a
{
  public long ikE = 0L;
  private long imq;
  private String inx = "";
  private String iqA = "";
  private String iqB = "";
  public long iqC = 0L;
  public long iqr = 0L;
  private String iqy = "";
  private String iqz = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368943);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iqr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imq);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368943);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368948);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MD5Key:").append(this.iqy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SearchID:").append(this.iqz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DesignerId:").append(this.iqA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Pid:").append(this.iqB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmoticonScene:").append(this.iqC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.inx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("page:").append(this.imq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368948);
    return localObject;
  }
  
  public final int getId()
  {
    return 12787;
  }
  
  public final bc kR(String paramString)
  {
    AppMethodBeat.i(368911);
    this.iqy = F("MD5Key", paramString, true);
    AppMethodBeat.o(368911);
    return this;
  }
  
  public final bc kS(String paramString)
  {
    AppMethodBeat.i(368917);
    this.iqz = F("SearchID", paramString, true);
    AppMethodBeat.o(368917);
    return this;
  }
  
  public final bc kT(String paramString)
  {
    AppMethodBeat.i(368923);
    this.iqA = F("DesignerId", paramString, true);
    AppMethodBeat.o(368923);
    return this;
  }
  
  public final bc kU(String paramString)
  {
    AppMethodBeat.i(368930);
    this.iqB = F("Pid", paramString, true);
    AppMethodBeat.o(368930);
    return this;
  }
  
  public final bc kV(String paramString)
  {
    AppMethodBeat.i(368937);
    this.inx = F("sessionid", paramString, true);
    AppMethodBeat.o(368937);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.bc
 * JD-Core Version:    0.7.0.1
 */