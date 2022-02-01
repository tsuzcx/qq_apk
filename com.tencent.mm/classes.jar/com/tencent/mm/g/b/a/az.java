package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class az
  extends a
{
  private long dCQ;
  private String dFY;
  private String dFe;
  private long dHT;
  private String dHX;
  private String dJQ;
  private String dJb;
  
  public final String PR()
  {
    AppMethodBeat.i(194998);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dCQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHT);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(194998);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(194999);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.dCQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.dJb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Feedid:").append(this.dJQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dFY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dHX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dHT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(194999);
    return localObject;
  }
  
  public final az eQ(long paramLong)
  {
    this.dCQ = paramLong;
    return this;
  }
  
  public final az eR(long paramLong)
  {
    this.dHT = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19956;
  }
  
  public final az iA(String paramString)
  {
    AppMethodBeat.i(194994);
    this.dJQ = t("Feedid", paramString, true);
    AppMethodBeat.o(194994);
    return this;
  }
  
  public final az iB(String paramString)
  {
    AppMethodBeat.i(194995);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(194995);
    return this;
  }
  
  public final az iC(String paramString)
  {
    AppMethodBeat.i(194996);
    this.dFY = t("ContextId", paramString, true);
    AppMethodBeat.o(194996);
    return this;
  }
  
  public final az iD(String paramString)
  {
    AppMethodBeat.i(194997);
    this.dHX = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(194997);
    return this;
  }
  
  public final az iz(String paramString)
  {
    AppMethodBeat.i(194993);
    this.dJb = t("Username", paramString, true);
    AppMethodBeat.o(194993);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.az
 * JD-Core Version:    0.7.0.1
 */