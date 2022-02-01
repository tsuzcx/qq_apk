package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cx
  extends a
{
  public String inx = "";
  public long ixI;
  public String ixJ = "";
  public String ixK = "";
  public String ixM = "";
  public String ixO = "";
  public long ixS;
  public long iyb;
  public long iyc;
  public long iyd;
  
  public final String aIE()
  {
    AppMethodBeat.i(368100);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.inx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyd);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368100);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368108);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.inx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clicktabcontextid:").append(this.ixK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("chatSessionid:").append(this.ixM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("myAccountType:").append(this.ixI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("chatName:").append(this.ixO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("talkerUsername:").append(this.ixJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RejectMsgStatus:").append(this.iyb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openChatInfoCount:").append(this.ixS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clearMsgHistoryClickCount:").append(this.iyc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("complianClickCount:").append(this.iyd);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368108);
    return localObject;
  }
  
  public final int getId()
  {
    return 20692;
  }
  
  public final cx mO(String paramString)
  {
    AppMethodBeat.i(368092);
    this.inx = F("sessionid", paramString, true);
    AppMethodBeat.o(368092);
    return this;
  }
  
  public final cx mP(String paramString)
  {
    AppMethodBeat.i(368096);
    this.ixK = F("clicktabcontextid", paramString, true);
    AppMethodBeat.o(368096);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.cx
 * JD-Core Version:    0.7.0.1
 */