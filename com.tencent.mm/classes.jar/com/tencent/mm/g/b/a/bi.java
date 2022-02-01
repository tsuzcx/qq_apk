package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bi
  extends a
{
  public String els = "";
  public long esb;
  public String esc = "";
  public String esd = "";
  public String esf = "";
  public String esh = "";
  public long esl;
  public long esu;
  public long esv;
  public long esw;
  
  public final String abV()
  {
    AppMethodBeat.i(208869);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.els);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esw);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(208869);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(208870);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.els);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clicktabcontextid:").append(this.esd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("chatSessionid:").append(this.esf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("myAccountType:").append(this.esb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("chatName:").append(this.esh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("talkerUsername:").append(this.esc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RejectMsgStatus:").append(this.esu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openChatInfoCount:").append(this.esl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clearMsgHistoryClickCount:").append(this.esv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("complianClickCount:").append(this.esw);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208870);
    return localObject;
  }
  
  public final int getId()
  {
    return 20692;
  }
  
  public final bi jh(String paramString)
  {
    AppMethodBeat.i(208867);
    this.els = x("sessionid", paramString, true);
    AppMethodBeat.o(208867);
    return this;
  }
  
  public final bi ji(String paramString)
  {
    AppMethodBeat.i(208868);
    this.esd = x("clicktabcontextid", paramString, true);
    AppMethodBeat.o(208868);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bi
 * JD-Core Version:    0.7.0.1
 */