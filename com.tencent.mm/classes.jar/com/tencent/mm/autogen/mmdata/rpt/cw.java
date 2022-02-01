package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cw
  extends a
{
  public long ixH;
  public long ixI;
  public long ixN;
  public long ixT;
  private String ixU = "";
  public long ixV;
  public long ixW;
  public long ixX;
  public long ixY;
  public long ixZ;
  public long iya;
  
  public final String aIE()
  {
    AppMethodBeat.i(368089);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ixI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iya);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368089);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368093);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("myAccountType:").append(this.ixI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isGreetSession:").append(this.ixT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fromCommentScene:").append(this.ixH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("chatlistSessionid:").append(this.ixU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exposeSessionCount:").append(this.ixV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exposeChatCount:").append(this.ixW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionClickCount:").append(this.ixX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openSessionCount:").append(this.ixY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("delSessionCount:").append(this.ixZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("stayDuration:").append(this.ixN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("dotClickCount:").append(this.iya);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368093);
    return localObject;
  }
  
  public final int getId()
  {
    return 20688;
  }
  
  public final cw mN(String paramString)
  {
    AppMethodBeat.i(368085);
    this.ixU = F("chatlistSessionid", paramString, true);
    AppMethodBeat.o(368085);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.cw
 * JD-Core Version:    0.7.0.1
 */