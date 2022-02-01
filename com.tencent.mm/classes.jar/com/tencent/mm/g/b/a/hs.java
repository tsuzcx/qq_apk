package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hs
  extends a
{
  private String dHr;
  private long lYA;
  private long lYB;
  private long lYC;
  private long lYD;
  private long lYE;
  private long lYF;
  private long lYG;
  private long lYu;
  private long lYv;
  private long lYw;
  private long lYx;
  private long lYy;
  
  public final String PV()
  {
    AppMethodBeat.i(203764);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lYu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lYv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lYw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lYx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lYy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lYA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lYB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lYC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lYD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lYE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lYF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lYG);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(203764);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(203765);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FetchNewCount:").append(this.lYu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseTotalCount:").append(this.lYv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseNewCount:").append(this.lYw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseOldCount:").append(this.lYx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseNewFollowCount:").append(this.lYy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseNewLikeCount:").append(this.lYA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseNewCommentCount:").append(this.lYB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseNewAtCount:").append(this.lYC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseOldFollowCount:").append(this.lYD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseOldLikeCount:").append(this.lYE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseOldCommentCount:").append(this.lYF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseOldAtCount:").append(this.lYG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(203765);
    return localObject;
  }
  
  public final long aFC()
  {
    return this.lYy;
  }
  
  public final long aKM()
  {
    return this.lYA;
  }
  
  public final long aKN()
  {
    return this.lYB;
  }
  
  public final long aLF()
  {
    return this.lYC;
  }
  
  public final long aQV()
  {
    return this.lYD;
  }
  
  public final long aQW()
  {
    return this.lYE;
  }
  
  public final long aRc()
  {
    return this.lYF;
  }
  
  public final long aRd()
  {
    return this.lYG;
  }
  
  public final hs aSb(String paramString)
  {
    AppMethodBeat.i(203763);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(203763);
    return this;
  }
  
  public final long aky()
  {
    return this.lYv;
  }
  
  public final long aod()
  {
    return this.lYw;
  }
  
  public final long azA()
  {
    return this.lYx;
  }
  
  public final int getId()
  {
    return 19948;
  }
  
  public final hs yQ(long paramLong)
  {
    this.lYv = paramLong;
    return this;
  }
  
  public final hs yR(long paramLong)
  {
    this.lYw = paramLong;
    return this;
  }
  
  public final hs yS(long paramLong)
  {
    this.lYx = paramLong;
    return this;
  }
  
  public final hs yT(long paramLong)
  {
    this.lYy = paramLong;
    return this;
  }
  
  public final hs yU(long paramLong)
  {
    this.lYA = paramLong;
    return this;
  }
  
  public final hs yV(long paramLong)
  {
    this.lYB = paramLong;
    return this;
  }
  
  public final hs yW(long paramLong)
  {
    this.lYC = paramLong;
    return this;
  }
  
  public final hs yX(long paramLong)
  {
    this.lYD = paramLong;
    return this;
  }
  
  public final hs yY(long paramLong)
  {
    this.lYE = paramLong;
    return this;
  }
  
  public final hs yZ(long paramLong)
  {
    this.lYF = paramLong;
    return this;
  }
  
  public final hs za(long paramLong)
  {
    this.lYG = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hs
 * JD-Core Version:    0.7.0.1
 */