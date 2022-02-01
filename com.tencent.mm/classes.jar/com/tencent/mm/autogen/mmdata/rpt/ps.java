package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ps
  extends a
{
  public long iOI;
  public long ikE;
  public String iqO = "";
  public String iwX = "";
  public long izg;
  public String joB = "";
  public long joC;
  public long joD;
  public long joE;
  public long joF;
  public String joG = "";
  public String joH = "";
  public String joI = "";
  public String joJ = "";
  public String joK = "";
  public String joL = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(369097);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iqO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.joB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.joC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.joD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.joE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.joF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.joG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.joH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.joI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.joJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.joK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.joL);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369097);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369111);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionID:").append(this.iqO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NotificationSessionID:").append(this.joB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionResult:").append(this.iwX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTs:").append(this.iOI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterScene:").append(this.izg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterPosition:").append(this.joC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadInteractCount:").append(this.joD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadMsgCount:").append(this.joE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadHelloToMeCount:").append(this.joF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToUserSessionID:").append(this.joG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToUserIconID:").append(this.joH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToUserSourceID:").append(this.joI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToUserHashTag:").append(this.joJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToUserStatusID:").append(this.joK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MyCurrentStatusID:").append(this.joL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369111);
    return localObject;
  }
  
  public final int getId()
  {
    return 23836;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ps
 * JD-Core Version:    0.7.0.1
 */