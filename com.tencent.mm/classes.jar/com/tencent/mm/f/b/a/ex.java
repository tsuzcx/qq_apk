package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ex
  extends a
{
  private long gnP;
  private long grP;
  private String gtk = "";
  private String gyF = "";
  private long gyG;
  private long gyH;
  private String gyI = "";
  private long gyJ;
  private long gyK;
  private String gyL = "";
  private long gyM;
  private long gyN;
  
  public final String agH()
  {
    AppMethodBeat.i(208050);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gyF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grP);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(208050);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208051);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessinId:").append(this.gyF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OperationTimestamp:").append(this.gyG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShootEntranceEndType:").append(this.gyH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsFeedId:").append(this.gtk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderFeedId:").append(this.gyI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HaveFinderUsername:").append(this.gyJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HavePostFinderVideo:").append(this.gyK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Wording:").append(this.gyL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EntraceExposeMaxTimes:").append(this.gyM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EntractExposeTimes:").append(this.gyN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeType:").append(this.grP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208051);
    return localObject;
  }
  
  public final long akh()
  {
    return this.gyJ;
  }
  
  public final int getId()
  {
    return 20747;
  }
  
  public final ex ms(long paramLong)
  {
    this.gnP = paramLong;
    return this;
  }
  
  public final ex mt(long paramLong)
  {
    this.gyG = paramLong;
    return this;
  }
  
  public final ex mu(long paramLong)
  {
    this.gyH = paramLong;
    return this;
  }
  
  public final ex mv(long paramLong)
  {
    this.gyJ = paramLong;
    return this;
  }
  
  public final ex mw(long paramLong)
  {
    this.gyK = paramLong;
    return this;
  }
  
  public final ex mx(long paramLong)
  {
    this.gyM = paramLong;
    return this;
  }
  
  public final ex my(long paramLong)
  {
    this.gyN = paramLong;
    return this;
  }
  
  public final ex mz(long paramLong)
  {
    this.grP = paramLong;
    return this;
  }
  
  public final ex to(String paramString)
  {
    AppMethodBeat.i(208035);
    this.gyF = z("SessinId", paramString, true);
    AppMethodBeat.o(208035);
    return this;
  }
  
  public final ex tp(String paramString)
  {
    AppMethodBeat.i(208042);
    this.gtk = z("SnsFeedId", paramString, true);
    AppMethodBeat.o(208042);
    return this;
  }
  
  public final ex tq(String paramString)
  {
    AppMethodBeat.i(208043);
    this.gyI = z("FinderFeedId", paramString, true);
    AppMethodBeat.o(208043);
    return this;
  }
  
  public final ex tr(String paramString)
  {
    AppMethodBeat.i(208048);
    this.gyL = z("Wording", paramString, true);
    AppMethodBeat.o(208048);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ex
 * JD-Core Version:    0.7.0.1
 */