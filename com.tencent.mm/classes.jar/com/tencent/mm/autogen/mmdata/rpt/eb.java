package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eb
  extends a
{
  public long iBR;
  public long iBS;
  public long iBT;
  private long iBU;
  public long iBV;
  public String ijl = "";
  public long ila;
  public long iqr;
  public String iwI = "";
  private String ixm = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368321);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iqr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ila);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iBR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iBS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iBT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iBU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iBV);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368321);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368329);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.ixm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.iwI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.ijl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ila);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionTimeStamp:").append(this.iBR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("messageType:").append(this.iBS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedIndex:").append(this.iBT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isfloat:").append(this.iBU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("innerVersion:").append(this.iBV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368329);
    return localObject;
  }
  
  public final int getId()
  {
    return 19998;
  }
  
  public final eb oi(String paramString)
  {
    AppMethodBeat.i(368312);
    this.ixm = F("Sessionid", paramString, true);
    AppMethodBeat.o(368312);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.eb
 * JD-Core Version:    0.7.0.1
 */