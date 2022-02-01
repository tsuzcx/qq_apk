package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ut
  extends a
{
  public long iWQ;
  public long iWR;
  public long jHQ;
  public long jHR;
  public long jHS;
  public long jHT;
  public long jHU;
  public String jHV = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368473);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iWQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHV);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368473);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368480);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.iWQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomkey:").append(this.iWR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomtype:").append(this.jHQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MemberIdx:").append(this.jHR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DialTime:").append(this.jHS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ConnectTime:").append(this.jHT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HangupTime:").append(this.jHU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Background_event:").append(this.jHV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368480);
    return localObject;
  }
  
  public final int getId()
  {
    return 25060;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ut
 * JD-Core Version:    0.7.0.1
 */