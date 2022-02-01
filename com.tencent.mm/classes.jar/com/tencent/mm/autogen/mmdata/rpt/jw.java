package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jw
  extends a
{
  public long iUJ;
  private String iUK = "";
  private String iUL = "";
  public long iUM;
  private String imN = "";
  private long ioV;
  
  public final String aIE()
  {
    AppMethodBeat.i(368949);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iUJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUM);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368949);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368953);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("msgid:").append(this.iUJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatName:").append(this.imN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendUser:").append(this.iUK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.ioV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BanDetail:").append(this.iUL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgType:").append(this.iUM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368953);
    return localObject;
  }
  
  public final jw aIO()
  {
    this.ioV = 4L;
    return this;
  }
  
  public final int getId()
  {
    return 23344;
  }
  
  public final jw so(String paramString)
  {
    AppMethodBeat.i(368935);
    this.imN = F("ChatName", paramString, true);
    AppMethodBeat.o(368935);
    return this;
  }
  
  public final jw sp(String paramString)
  {
    AppMethodBeat.i(368939);
    this.iUK = F("SendUser", paramString, true);
    AppMethodBeat.o(368939);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.jw
 * JD-Core Version:    0.7.0.1
 */