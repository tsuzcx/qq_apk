package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jr
  extends a
{
  public String inx = "";
  public String iny = "";
  public long ioV;
  public String ipU = "";
  public String iqk = "";
  public long iyr;
  public String izY = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368519);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iqk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iny);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipU);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368519);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368526);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Feedid:").append(this.iqk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LongVideoId:").append(this.izY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.ioV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Outcome:").append(this.iyr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.inx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextid:").append(this.iny);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.ipU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368526);
    return localObject;
  }
  
  public final int getId()
  {
    return 21151;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.jr
 * JD-Core Version:    0.7.0.1
 */