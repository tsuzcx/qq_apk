package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kl
  extends a
{
  public String iWL = "";
  public int iWM;
  public long iWN;
  public long iWO;
  public long iWP;
  public long iWQ;
  public long iWR;
  
  public final String aIE()
  {
    AppMethodBeat.i(368827);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iWL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWR);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368827);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368833);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("MultitalkGroupId:").append(this.iWL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ScreeningType:").append(this.iWM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Actiontype:").append(this.iWN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Usertype:").append(this.iWO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.iWP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.iWQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomkey:").append(this.iWR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368833);
    return localObject;
  }
  
  public final int getId()
  {
    return 21344;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.kl
 * JD-Core Version:    0.7.0.1
 */