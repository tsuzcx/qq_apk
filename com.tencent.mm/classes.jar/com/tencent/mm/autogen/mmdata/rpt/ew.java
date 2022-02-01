package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ew
  extends a
{
  public long iCU;
  private String iDx = "";
  private long iFX;
  public String iGe = "";
  private String iGf = "";
  public long ioV;
  public String izG = "";
  public String izH = "";
  public int izI;
  public String izJ = "";
  public long izK;
  
  public final String aIE()
  {
    AppMethodBeat.i(367861);
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
    ((StringBuffer)localObject).append(this.iFX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iDx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGf);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367861);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367870);
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
    ((StringBuffer)localObject).append("ConnectCount:").append(this.iFX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ConnectDuration:").append(this.iDx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Params:").append(this.iGf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367870);
    return localObject;
  }
  
  public final ew eT(long paramLong)
  {
    AppMethodBeat.i(367844);
    this.izK = paramLong;
    super.bw("ActionTimeMs", this.izK);
    AppMethodBeat.o(367844);
    return this;
  }
  
  public final int getId()
  {
    return 21017;
  }
  
  public final ew pq(String paramString)
  {
    AppMethodBeat.i(367822);
    this.izG = F("FinderUsrname", paramString, true);
    AppMethodBeat.o(367822);
    return this;
  }
  
  public final ew pr(String paramString)
  {
    AppMethodBeat.i(367833);
    this.izH = F("FinderWxAppInfo", paramString, true);
    AppMethodBeat.o(367833);
    return this;
  }
  
  public final ew pt(String paramString)
  {
    AppMethodBeat.i(367840);
    this.izJ = F("FinderSessionId", paramString, true);
    AppMethodBeat.o(367840);
    return this;
  }
  
  public final ew pu(String paramString)
  {
    AppMethodBeat.i(367846);
    this.iGe = F("ActionJson", paramString, true);
    AppMethodBeat.o(367846);
    return this;
  }
  
  public final ew pv(String paramString)
  {
    AppMethodBeat.i(367853);
    this.iGf = F("Params", paramString, true);
    AppMethodBeat.o(367853);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ew
 * JD-Core Version:    0.7.0.1
 */