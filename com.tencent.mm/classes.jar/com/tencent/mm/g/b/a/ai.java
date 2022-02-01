package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ai
  extends a
{
  private long dQX;
  private String dRJ = "";
  private String dWS = "";
  private String dWT = "";
  private String dWU = "";
  private long dWV;
  private long dWW;
  private String dWy = "";
  
  public final String RC()
  {
    AppMethodBeat.i(189085);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWW);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189085);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189086);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("finderUsername:").append(this.dWS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("toUsername:").append(this.dWT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("toFinderUsername:").append(this.dWU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dQX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("result:").append(this.dWV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.dRJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clicktabcontextid:").append(this.dWy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickScene:").append(this.dWW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189086);
    return localObject;
  }
  
  public final String RJ()
  {
    return this.dRJ;
  }
  
  public final String RK()
  {
    return this.dWy;
  }
  
  public final ai cG(long paramLong)
  {
    this.dQX = paramLong;
    return this;
  }
  
  public final ai cH(long paramLong)
  {
    this.dWV = paramLong;
    return this;
  }
  
  public final ai cI(long paramLong)
  {
    this.dWW = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20671;
  }
  
  public final ai ho(String paramString)
  {
    AppMethodBeat.i(189080);
    this.dWS = t("finderUsername", paramString, true);
    AppMethodBeat.o(189080);
    return this;
  }
  
  public final ai hp(String paramString)
  {
    AppMethodBeat.i(189081);
    this.dWT = t("toUsername", paramString, true);
    AppMethodBeat.o(189081);
    return this;
  }
  
  public final ai hq(String paramString)
  {
    AppMethodBeat.i(189082);
    this.dWU = t("toFinderUsername", paramString, true);
    AppMethodBeat.o(189082);
    return this;
  }
  
  public final ai hr(String paramString)
  {
    AppMethodBeat.i(189083);
    this.dRJ = t("sessionid", paramString, true);
    AppMethodBeat.o(189083);
    return this;
  }
  
  public final ai hs(String paramString)
  {
    AppMethodBeat.i(189084);
    this.dWy = t("clicktabcontextid", paramString, true);
    AppMethodBeat.o(189084);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ai
 * JD-Core Version:    0.7.0.1
 */