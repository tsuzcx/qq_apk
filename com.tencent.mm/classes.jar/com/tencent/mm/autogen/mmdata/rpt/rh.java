package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class rh
  extends a
{
  public long ikE = 0L;
  private String iqO = "";
  private String iuI = "";
  public long izR = 0L;
  private String jgg = "";
  public long jgk = 0L;
  public long jvB = 0L;
  public long jvC = 0L;
  private String jvD = "";
  private String jvE = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(369203);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jvB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jvC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jvD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jvE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izR);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369203);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369206);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionScene:").append(this.jvB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterSource:").append(this.jvC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedAuthorUsername:").append(this.jvD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedID:").append(this.iuI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedAuthorType:").append(this.jgk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CreatedCommentID:").append(this.jgg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.iqO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueryKey:").append(this.jvE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStamp:").append(this.izR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369206);
    return localObject;
  }
  
  public final int getId()
  {
    return 21192;
  }
  
  public final rh yh(String paramString)
  {
    AppMethodBeat.i(369177);
    this.jvD = F("FeedAuthorUsername", paramString, true);
    AppMethodBeat.o(369177);
    return this;
  }
  
  public final rh yi(String paramString)
  {
    AppMethodBeat.i(369182);
    this.iuI = F("FeedID", paramString, true);
    AppMethodBeat.o(369182);
    return this;
  }
  
  public final rh yj(String paramString)
  {
    AppMethodBeat.i(369186);
    this.jgg = F("CreatedCommentID", paramString, true);
    AppMethodBeat.o(369186);
    return this;
  }
  
  public final rh yk(String paramString)
  {
    AppMethodBeat.i(369194);
    this.iqO = F("SessionID", paramString, true);
    AppMethodBeat.o(369194);
    return this;
  }
  
  public final rh yl(String paramString)
  {
    AppMethodBeat.i(369198);
    this.jvE = F("QueryKey", paramString, true);
    AppMethodBeat.o(369198);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.rh
 * JD-Core Version:    0.7.0.1
 */