package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dt
  extends a
{
  private String gcU = "";
  private long guE;
  private long guF;
  private long guG;
  private long guH;
  private long guI;
  private long guJ;
  private long guK;
  private long guL;
  private long guM;
  private long guN;
  private long guO;
  private long guP;
  private long guQ;
  private long guR;
  
  public final String agH()
  {
    AppMethodBeat.i(209312);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guE);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209312);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209313);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FetchNewCount:").append(this.guF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseTotalCount:").append(this.guG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseNewCount:").append(this.guH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseOldCount:").append(this.guI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseNewFollowCount:").append(this.guJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseNewLikeCount:").append(this.guK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseNewCommentCount:").append(this.guL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseNewAtCount:").append(this.guM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseOldFollowCount:").append(this.guN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseOldLikeCount:").append(this.guO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseOldCommentCount:").append(this.guP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseOldAtCount:").append(this.guQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseDuration:").append(this.guR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TabType:").append(this.guE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209313);
    return localObject;
  }
  
  public final long ajJ()
  {
    return this.guF;
  }
  
  public final long ajK()
  {
    return this.guG;
  }
  
  public final long ajL()
  {
    return this.guH;
  }
  
  public final long ajM()
  {
    return this.guI;
  }
  
  public final long ajN()
  {
    return this.guJ;
  }
  
  public final long ajO()
  {
    return this.guK;
  }
  
  public final long ajP()
  {
    return this.guL;
  }
  
  public final long ajQ()
  {
    return this.guM;
  }
  
  public final long ajR()
  {
    return this.guN;
  }
  
  public final long ajS()
  {
    return this.guO;
  }
  
  public final long ajT()
  {
    return this.guP;
  }
  
  public final long ajU()
  {
    return this.guQ;
  }
  
  public final dt ajV()
  {
    this.guE = 2L;
    return this;
  }
  
  public final int getId()
  {
    return 19948;
  }
  
  public final dt jF(long paramLong)
  {
    this.guF = paramLong;
    return this;
  }
  
  public final dt jG(long paramLong)
  {
    this.guG = paramLong;
    return this;
  }
  
  public final dt jH(long paramLong)
  {
    this.guH = paramLong;
    return this;
  }
  
  public final dt jI(long paramLong)
  {
    this.guI = paramLong;
    return this;
  }
  
  public final dt jJ(long paramLong)
  {
    this.guJ = paramLong;
    return this;
  }
  
  public final dt jK(long paramLong)
  {
    this.guK = paramLong;
    return this;
  }
  
  public final dt jL(long paramLong)
  {
    this.guL = paramLong;
    return this;
  }
  
  public final dt jM(long paramLong)
  {
    this.guM = paramLong;
    return this;
  }
  
  public final dt jN(long paramLong)
  {
    this.guN = paramLong;
    return this;
  }
  
  public final dt jO(long paramLong)
  {
    this.guO = paramLong;
    return this;
  }
  
  public final dt jP(long paramLong)
  {
    this.guP = paramLong;
    return this;
  }
  
  public final dt jQ(long paramLong)
  {
    this.guQ = paramLong;
    return this;
  }
  
  public final dt jR(long paramLong)
  {
    this.guR = paramLong;
    return this;
  }
  
  public final dt qN(String paramString)
  {
    AppMethodBeat.i(209292);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(209292);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.dt
 * JD-Core Version:    0.7.0.1
 */