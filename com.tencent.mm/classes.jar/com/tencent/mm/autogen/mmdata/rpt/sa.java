package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class sa
  extends a
{
  private String iIg = "";
  private String ijk = "";
  private long iuA = 0L;
  public long jlE = 0L;
  public long jxb = 0L;
  private String jxc = "";
  private String jxd = "";
  public long jxe = 0L;
  private long jxf = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(368565);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jlE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iIg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxf);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368565);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368569);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("LogType:").append(this.jlE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SequenceId:").append(this.jxb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("URL:").append(this.jxc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportTimeStamp:").append(this.jxd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LogAction:").append(this.jxe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtInfo:").append(this.iIg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.iuA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("channel:").append(this.jxf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368569);
    return localObject;
  }
  
  public final int getId()
  {
    return 24144;
  }
  
  public final sa yM(String paramString)
  {
    AppMethodBeat.i(368543);
    this.ijk = F("SessionId", paramString, true);
    AppMethodBeat.o(368543);
    return this;
  }
  
  public final sa yN(String paramString)
  {
    AppMethodBeat.i(368548);
    this.jxc = F("URL", paramString, true);
    AppMethodBeat.o(368548);
    return this;
  }
  
  public final sa yO(String paramString)
  {
    AppMethodBeat.i(368552);
    this.jxd = F("ReportTimeStamp", paramString, true);
    AppMethodBeat.o(368552);
    return this;
  }
  
  public final sa yP(String paramString)
  {
    AppMethodBeat.i(368558);
    this.iIg = F("ExtInfo", paramString, true);
    AppMethodBeat.o(368558);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.sa
 * JD-Core Version:    0.7.0.1
 */