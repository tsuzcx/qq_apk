package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bg
  extends a
{
  public String ipW = "";
  public long iqU;
  public String iqV = "";
  public long iqW;
  public String iqX = "";
  public String iqY = "";
  public long iqZ;
  public String ira = "";
  public String irb = "";
  public long irc;
  public int ird;
  
  public final String aIE()
  {
    AppMethodBeat.i(368877);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iqU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ira);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ird);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368877);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368886);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("reddotctrltype:").append(this.iqU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showinfopath:").append(this.iqV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actiontype:").append(this.iqW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.ipW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("username:").append(this.iqX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportext:").append(this.iqY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("businesstype:").append(this.iqZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotTipsID:").append(this.ira);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoTitle:").append(this.irb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotactiontimestamp:").append(this.irc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cleartype:").append(this.ird);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368886);
    return localObject;
  }
  
  public final int getId()
  {
    return 23489;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.bg
 * JD-Core Version:    0.7.0.1
 */