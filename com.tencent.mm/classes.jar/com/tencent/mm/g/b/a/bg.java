package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bg
  extends a
{
  public String els = "";
  public long esa;
  public long esb;
  public String esc = "";
  public String esd = "";
  public String ese = "";
  public String esf = "";
  public long esg;
  public String esh = "";
  public long esi;
  private long esj;
  private long esk;
  public long esl;
  
  public final String abV()
  {
    AppMethodBeat.i(208862);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.els);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ese);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esl);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(208862);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(208863);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("fromCommentScene:").append(this.esa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("myAccountType:").append(this.esb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("talkerUsername:").append(this.esc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.els);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clicktabcontextid:").append(this.esd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("chatListSessionid:").append(this.ese);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("chatSessionid:").append(this.esf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("stayDuration:").append(this.esg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("chatName:").append(this.esh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reddotCount:").append(this.esi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("newReceiveMsgCount:").append(this.esj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("newSendMsgCount:").append(this.esk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openChatInfoCount:").append(this.esl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208863);
    return localObject;
  }
  
  public final bg dw(long paramLong)
  {
    this.esj = paramLong;
    return this;
  }
  
  public final bg dx(long paramLong)
  {
    this.esk = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20691;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bg
 * JD-Core Version:    0.7.0.1
 */