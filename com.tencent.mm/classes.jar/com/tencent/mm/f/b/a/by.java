package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class by
  extends a
{
  public String ggA = "";
  public long goB;
  public long goC;
  public long goD;
  public long goh;
  public String goi = "";
  public String goj = "";
  public String gol = "";
  public String gon = "";
  public long gos;
  
  public final String agH()
  {
    AppMethodBeat.i(210036);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gol);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gon);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gos);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goD);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(210036);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(210038);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.ggA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clicktabcontextid:").append(this.goj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("chatSessionid:").append(this.gol);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("myAccountType:").append(this.goh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("chatName:").append(this.gon);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("talkerUsername:").append(this.goi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RejectMsgStatus:").append(this.goB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openChatInfoCount:").append(this.gos);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clearMsgHistoryClickCount:").append(this.goC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("complianClickCount:").append(this.goD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(210038);
    return localObject;
  }
  
  public final int getId()
  {
    return 20692;
  }
  
  public final by lr(String paramString)
  {
    AppMethodBeat.i(210031);
    this.ggA = z("sessionid", paramString, true);
    AppMethodBeat.o(210031);
    return this;
  }
  
  public final by ls(String paramString)
  {
    AppMethodBeat.i(210032);
    this.goj = z("clicktabcontextid", paramString, true);
    AppMethodBeat.o(210032);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.b.a.by
 * JD-Core Version:    0.7.0.1
 */