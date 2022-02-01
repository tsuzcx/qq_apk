package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fe
  extends a
{
  private String iCS = "";
  public long iCU;
  public long iGI;
  public String iGe = "";
  public long ioV;
  public String izG = "";
  public String izH = "";
  public int izI;
  public String izJ = "";
  public long izK;
  
  public final String aIE()
  {
    AppMethodBeat.i(367797);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.izG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGI);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367797);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367804);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FinderUsrname:").append(this.izG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderWxAppInfo:").append(this.izH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPrivate:").append(this.izI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderSessionId:").append(this.izJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeMs:").append(this.izK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.ioV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionJson:").append(this.iGe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceScene:").append(this.iCU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Description:").append(this.iCS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Advancetype:").append(this.iGI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367804);
    return localObject;
  }
  
  public final fe eU(long paramLong)
  {
    AppMethodBeat.i(367781);
    this.izK = paramLong;
    super.bw("ActionTimeMs", this.izK);
    AppMethodBeat.o(367781);
    return this;
  }
  
  public final int getId()
  {
    return 21106;
  }
  
  public final fe pA(String paramString)
  {
    AppMethodBeat.i(367774);
    this.izG = F("FinderUsrname", paramString, true);
    AppMethodBeat.o(367774);
    return this;
  }
  
  public final fe pB(String paramString)
  {
    AppMethodBeat.i(367776);
    this.izH = F("FinderWxAppInfo", paramString, true);
    AppMethodBeat.o(367776);
    return this;
  }
  
  public final fe pC(String paramString)
  {
    AppMethodBeat.i(367778);
    this.izJ = F("FinderSessionId", paramString, true);
    AppMethodBeat.o(367778);
    return this;
  }
  
  public final fe pD(String paramString)
  {
    AppMethodBeat.i(367784);
    this.iGe = F("ActionJson", paramString, true);
    AppMethodBeat.o(367784);
    return this;
  }
  
  public final fe pE(String paramString)
  {
    AppMethodBeat.i(367790);
    this.iCS = F("Description", paramString, true);
    AppMethodBeat.o(367790);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.fe
 * JD-Core Version:    0.7.0.1
 */