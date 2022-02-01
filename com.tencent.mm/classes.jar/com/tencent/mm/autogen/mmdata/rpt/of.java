package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class of
  extends a
{
  private String imN = "";
  private String jiW = "";
  private String jjb = "";
  private String jjd = "";
  public long jje = 0L;
  public long jjf = 0L;
  public long jjg = 0L;
  public long jjh = 0L;
  public long jji = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(110282);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jiW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jje);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jji);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjb);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(110282);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(110283);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.imN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LaunchUserName:").append(this.jiW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgUserName:").append(this.jjd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionSvrId:").append(this.jje);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasHeader:").append(this.jjf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasTail:").append(this.jjg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasExample:").append(this.jjh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActiveScene:").append(this.jji);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.jjb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110283);
    return localObject;
  }
  
  public final int getId()
  {
    return 18244;
  }
  
  public final of we(String paramString)
  {
    AppMethodBeat.i(110278);
    this.imN = F("ChatName", paramString, true);
    AppMethodBeat.o(110278);
    return this;
  }
  
  public final of wf(String paramString)
  {
    AppMethodBeat.i(110279);
    this.jiW = F("LaunchUserName", paramString, true);
    AppMethodBeat.o(110279);
    return this;
  }
  
  public final of wg(String paramString)
  {
    AppMethodBeat.i(110280);
    this.jjd = F("MsgUserName", paramString, true);
    AppMethodBeat.o(110280);
    return this;
  }
  
  public final of wh(String paramString)
  {
    AppMethodBeat.i(110281);
    this.jjb = F("Identifier", paramString, true);
    AppMethodBeat.o(110281);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.of
 * JD-Core Version:    0.7.0.1
 */