package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class it
  extends a
{
  public String iCb = "";
  public String iNB = "";
  public long iQE;
  public long iQK;
  public long iQL;
  public long iQM;
  public long iQN;
  public long iQO;
  public long iQP;
  public long iQx;
  public long ipr;
  public long iuA;
  
  public final String aIE()
  {
    AppMethodBeat.i(368691);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iuA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQE);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368691);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368698);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.iuA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.iNB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("rulePop:").append(this.iQK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ruleCheck:").append(this.iQL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.iCb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("customTopic:").append(this.iQM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cameraStatus:").append(this.iQN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("horizontalStatus:").append(this.iQO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitType:").append(this.ipr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errcode:").append(this.iQP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.iQx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomCount:").append(this.iQE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368698);
    return localObject;
  }
  
  public final int getId()
  {
    return 19890;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.it
 * JD-Core Version:    0.7.0.1
 */