package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gl
  extends a
{
  public long iCk;
  public String iEf = "";
  private String iKU = "";
  public long iKV;
  public long iKW;
  private String iKX = "";
  public long iKY;
  public long iKZ;
  private String iLa = "";
  public long iLb;
  public long iLc;
  public long iqr;
  
  public final String aIE()
  {
    AppMethodBeat.i(369168);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iKU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCk);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369168);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369173);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessinId:").append(this.iKU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OperationTimestamp:").append(this.iKV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShootEntranceEndType:").append(this.iKW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsFeedId:").append(this.iEf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderFeedId:").append(this.iKX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HaveFinderUsername:").append(this.iKY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HavePostFinderVideo:").append(this.iKZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Wording:").append(this.iLa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EntraceExposeMaxTimes:").append(this.iLb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EntractExposeTimes:").append(this.iLc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeType:").append(this.iCk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369173);
    return localObject;
  }
  
  public final int getId()
  {
    return 20747;
  }
  
  public final gl rd(String paramString)
  {
    AppMethodBeat.i(369151);
    this.iKU = F("SessinId", paramString, true);
    AppMethodBeat.o(369151);
    return this;
  }
  
  public final gl re(String paramString)
  {
    AppMethodBeat.i(369155);
    this.iKX = F("FinderFeedId", paramString, true);
    AppMethodBeat.o(369155);
    return this;
  }
  
  public final gl rf(String paramString)
  {
    AppMethodBeat.i(369160);
    this.iLa = F("Wording", paramString, true);
    AppMethodBeat.o(369160);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.gl
 * JD-Core Version:    0.7.0.1
 */