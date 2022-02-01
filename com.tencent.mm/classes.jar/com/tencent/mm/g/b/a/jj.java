package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jj
  extends a
{
  private String dSD = "";
  private long eAh = 0L;
  private long eAi = 0L;
  private int eAj = 0;
  private String eAk = "";
  private String eAl = "";
  private String eAm = "";
  private String eAn = "";
  private long eAo = 0L;
  private String eAp = "";
  private String eAq = "";
  private String eif = "";
  private long ewX = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(43769);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eAh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eAi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eAj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eAk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eAl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eAm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eAn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eAo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eAp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eif);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eAq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewX);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(43769);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(43770);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appid:").append(this.dSD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appversion:").append(this.eAh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appstate:").append(this.eAi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorType:").append(this.eAj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorName:").append(this.eAk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorMessage:").append(this.eAl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorStack:").append(this.eAm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sdkversion:").append(this.eAn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("apptype:").append(this.eAo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("route:").append(this.eAp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.eif);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sdkupdatetime:").append(this.eAq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sceneId:").append(this.ewX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43770);
    return localObject;
  }
  
  public final jj Vr()
  {
    this.eAj = 9;
    return this;
  }
  
  public final int getId()
  {
    return 13582;
  }
  
  public final jj pG(long paramLong)
  {
    this.eAh = paramLong;
    return this;
  }
  
  public final jj pH(long paramLong)
  {
    this.eAi = paramLong;
    return this;
  }
  
  public final jj pI(long paramLong)
  {
    this.eAo = paramLong;
    return this;
  }
  
  public final jj pJ(long paramLong)
  {
    this.ewX = paramLong;
    return this;
  }
  
  public final jj rN(String paramString)
  {
    AppMethodBeat.i(43763);
    this.dSD = t("appid", paramString, true);
    AppMethodBeat.o(43763);
    return this;
  }
  
  public final jj rO(String paramString)
  {
    AppMethodBeat.i(43764);
    this.eAl = t("errorMessage", paramString, true);
    AppMethodBeat.o(43764);
    return this;
  }
  
  public final jj rP(String paramString)
  {
    AppMethodBeat.i(43765);
    this.eAm = t("errorStack", paramString, true);
    AppMethodBeat.o(43765);
    return this;
  }
  
  public final jj rQ(String paramString)
  {
    AppMethodBeat.i(43766);
    this.eAn = t("sdkversion", paramString, true);
    AppMethodBeat.o(43766);
    return this;
  }
  
  public final jj rR(String paramString)
  {
    AppMethodBeat.i(43767);
    this.eAp = t("route", paramString, true);
    AppMethodBeat.o(43767);
    return this;
  }
  
  public final jj rS(String paramString)
  {
    AppMethodBeat.i(43768);
    this.eif = t("query", paramString, true);
    AppMethodBeat.o(43768);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jj
 * JD-Core Version:    0.7.0.1
 */