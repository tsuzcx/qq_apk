package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ea
  extends a
{
  public int iBK;
  public String iBL = "";
  public int iBM;
  public int iBN;
  public String iBO = "";
  public String iBP = "";
  public String iBQ = "";
  public int imW;
  public String inx = "";
  public String inz = "";
  public int iuv;
  
  public final String aIE()
  {
    AppMethodBeat.i(368309);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.inx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iBK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iBL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iBM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iBN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iBO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iBP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iBQ);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368309);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368317);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.inx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickTabContextid:").append(this.inz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentScene:").append(this.iBK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemId:").append(this.iBL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Position:").append(this.iBM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.imW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("myAccountType:").append(this.iBN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionType:").append(this.iuv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reasonId:").append(this.iBO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hotWordId:").append(this.iBP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("requestId:").append(this.iBQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368317);
    return localObject;
  }
  
  public final int getId()
  {
    return 22080;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ea
 * JD-Core Version:    0.7.0.1
 */