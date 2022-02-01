package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class av
  extends a
{
  private String dFe;
  private long dKE;
  private long dKF;
  private long dKG;
  private long dKH;
  private long dKI;
  private long dKJ;
  private long dKK;
  private long dKL;
  private long dKM;
  private long dKN;
  private long dKO;
  private long dKP;
  
  public final String PR()
  {
    AppMethodBeat.i(194981);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKP);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(194981);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(194982);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FetchNewCount:").append(this.dKE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseTotalCount:").append(this.dKF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseNewCount:").append(this.dKG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseOldCount:").append(this.dKH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseNewFollowCount:").append(this.dKI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseNewLikeCount:").append(this.dKJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseNewCommentCount:").append(this.dKK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseNewAtCount:").append(this.dKL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseOldFollowCount:").append(this.dKM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseOldLikeCount:").append(this.dKN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseOldCommentCount:").append(this.dKO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseOldAtCount:").append(this.dKP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(194982);
    return localObject;
  }
  
  public final long Qj()
  {
    return this.dKF;
  }
  
  public final long Qk()
  {
    return this.dKG;
  }
  
  public final long Ql()
  {
    return this.dKH;
  }
  
  public final long Qm()
  {
    return this.dKI;
  }
  
  public final long Qn()
  {
    return this.dKJ;
  }
  
  public final long Qo()
  {
    return this.dKK;
  }
  
  public final long Qp()
  {
    return this.dKL;
  }
  
  public final long Qq()
  {
    return this.dKM;
  }
  
  public final long Qr()
  {
    return this.dKN;
  }
  
  public final long Qs()
  {
    return this.dKO;
  }
  
  public final long Qt()
  {
    return this.dKP;
  }
  
  public final av ej(long paramLong)
  {
    this.dKF = paramLong;
    return this;
  }
  
  public final av ek(long paramLong)
  {
    this.dKG = paramLong;
    return this;
  }
  
  public final av el(long paramLong)
  {
    this.dKH = paramLong;
    return this;
  }
  
  public final av em(long paramLong)
  {
    this.dKI = paramLong;
    return this;
  }
  
  public final av en(long paramLong)
  {
    this.dKJ = paramLong;
    return this;
  }
  
  public final av eo(long paramLong)
  {
    this.dKK = paramLong;
    return this;
  }
  
  public final av ep(long paramLong)
  {
    this.dKL = paramLong;
    return this;
  }
  
  public final av eq(long paramLong)
  {
    this.dKM = paramLong;
    return this;
  }
  
  public final av er(long paramLong)
  {
    this.dKN = paramLong;
    return this;
  }
  
  public final av es(long paramLong)
  {
    this.dKO = paramLong;
    return this;
  }
  
  public final av et(long paramLong)
  {
    this.dKP = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19948;
  }
  
  public final av ic(String paramString)
  {
    AppMethodBeat.i(194980);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(194980);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.av
 * JD-Core Version:    0.7.0.1
 */