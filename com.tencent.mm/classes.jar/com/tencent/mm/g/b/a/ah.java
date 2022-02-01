package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ah
  extends a
{
  public String dQt;
  public long dVA;
  public long dVB;
  public long dVg;
  public String dVh;
  public String dVi;
  public String dVk;
  public String dVm;
  public long dVq;
  public long dVz;
  
  public final String RD()
  {
    AppMethodBeat.i(209050);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVB);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209050);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209051);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.dQt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clicktabcontextid:").append(this.dVi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("chatSessionid:").append(this.dVk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("myAccountType:").append(this.dVg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("chatName:").append(this.dVm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("talkerUsername:").append(this.dVh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RejectMsgStatus:").append(this.dVz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openChatInfoCount:").append(this.dVq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clearMsgHistoryClickCount:").append(this.dVA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("complianClickCount:").append(this.dVB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209051);
    return localObject;
  }
  
  public final int getId()
  {
    return 20692;
  }
  
  public final ah hg(String paramString)
  {
    AppMethodBeat.i(209048);
    this.dQt = t("sessionid", paramString, true);
    AppMethodBeat.o(209048);
    return this;
  }
  
  public final ah hh(String paramString)
  {
    AppMethodBeat.i(209049);
    this.dVi = t("clicktabcontextid", paramString, true);
    AppMethodBeat.o(209049);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ah
 * JD-Core Version:    0.7.0.1
 */