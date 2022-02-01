package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ck
  extends a
{
  public String ipW = "";
  public long iqW;
  public long iwD;
  public long iwE;
  public String iwF = "";
  public String iwG = "";
  public String iwH = "";
  public String iwI = "";
  public String iwJ = "";
  public String iwK = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368179);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ipW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwK);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368179);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368184);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("feedid:").append(this.ipW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentscene:").append(this.iwD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IconType:").append(this.iwE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actiontype:").append(this.iqW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedplayinfo:").append(this.iwF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MutualAdInfo:").append(this.iwG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionbuffer:").append(this.iwH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.iwI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtraInfo:").append(this.iwJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("enterSourceInfo:").append(this.iwK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368184);
    return localObject;
  }
  
  public final int getId()
  {
    return 22955;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ck
 * JD-Core Version:    0.7.0.1
 */