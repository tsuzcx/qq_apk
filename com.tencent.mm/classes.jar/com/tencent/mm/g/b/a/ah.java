package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ah
  extends a
{
  public String dRJ = "";
  public String dWA = "";
  public String dWC = "";
  public long dWG;
  public long dWP;
  public long dWQ;
  public long dWR;
  public long dWw;
  public String dWx = "";
  public String dWy = "";
  
  public final String RC()
  {
    AppMethodBeat.i(189078);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWR);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189078);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189079);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.dRJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clicktabcontextid:").append(this.dWy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("chatSessionid:").append(this.dWA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("myAccountType:").append(this.dWw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("chatName:").append(this.dWC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("talkerUsername:").append(this.dWx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RejectMsgStatus:").append(this.dWP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openChatInfoCount:").append(this.dWG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clearMsgHistoryClickCount:").append(this.dWQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("complianClickCount:").append(this.dWR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189079);
    return localObject;
  }
  
  public final int getId()
  {
    return 20692;
  }
  
  public final ah hm(String paramString)
  {
    AppMethodBeat.i(189076);
    this.dRJ = t("sessionid", paramString, true);
    AppMethodBeat.o(189076);
    return this;
  }
  
  public final ah hn(String paramString)
  {
    AppMethodBeat.i(189077);
    this.dWy = t("clicktabcontextid", paramString, true);
    AppMethodBeat.o(189077);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ah
 * JD-Core Version:    0.7.0.1
 */