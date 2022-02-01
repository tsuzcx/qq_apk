package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class oh
  extends a
{
  public long ilI = 0L;
  private String imN = "";
  private String jiW = "";
  public long jiX = 0L;
  private String jjb = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(110289);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jiW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jiX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjb);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(110289);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(110290);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.imN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LaunchUserName:").append(this.jiW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.jiX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reason:").append(this.ilI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.jjb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110290);
    return localObject;
  }
  
  public final int getId()
  {
    return 18252;
  }
  
  public final oh wi(String paramString)
  {
    AppMethodBeat.i(110286);
    this.imN = F("ChatName", paramString, true);
    AppMethodBeat.o(110286);
    return this;
  }
  
  public final oh wj(String paramString)
  {
    AppMethodBeat.i(110287);
    this.jiW = F("LaunchUserName", paramString, true);
    AppMethodBeat.o(110287);
    return this;
  }
  
  public final oh wk(String paramString)
  {
    AppMethodBeat.i(110288);
    this.jjb = F("Identifier", paramString, true);
    AppMethodBeat.o(110288);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.oh
 * JD-Core Version:    0.7.0.1
 */