package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hg
  extends a
{
  private String dHr;
  private String dJL;
  private long dKc;
  private String fmK;
  private String foQ;
  private String ghA;
  private long ghO;
  private long ghQ;
  private long ghR;
  
  public final hg EL(String paramString)
  {
    AppMethodBeat.i(203673);
    this.dJL = t("FeedId", paramString, true);
    AppMethodBeat.o(203673);
    return this;
  }
  
  public final hg NC(String paramString)
  {
    AppMethodBeat.i(203674);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(203674);
    return this;
  }
  
  public final hg ND(String paramString)
  {
    AppMethodBeat.i(203675);
    this.fmK = t("PosterUsername", paramString, true);
    AppMethodBeat.o(203675);
    return this;
  }
  
  public final hg NE(String paramString)
  {
    AppMethodBeat.i(203676);
    this.foQ = t("ViewerUsername", paramString, true);
    AppMethodBeat.o(203676);
    return this;
  }
  
  public final hg NF(String paramString)
  {
    AppMethodBeat.i(203677);
    this.ghA = t("MentionedUsername", paramString, true);
    AppMethodBeat.o(203677);
    return this;
  }
  
  public final String PV()
  {
    AppMethodBeat.i(203678);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dJL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fmK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.foQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ghA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ghO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ghQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ghR);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(203678);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(203679);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FeedId:").append(this.dJL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PosterUsername:").append(this.fmK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ViewerUsername:").append(this.foQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MentionedUsername:").append(this.ghA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dKc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("recommendtype:").append(this.ghO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("likecnt:").append(this.ghQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commcnt:").append(this.ghR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(203679);
    return localObject;
  }
  
  public final int getId()
  {
    return 19793;
  }
  
  public final hg qJ(long paramLong)
  {
    this.ghO = paramLong;
    return this;
  }
  
  public final hg qd(long paramLong)
  {
    this.dKc = paramLong;
    return this;
  }
  
  public final hg uj(long paramLong)
  {
    this.ghQ = paramLong;
    return this;
  }
  
  public final hg uk(long paramLong)
  {
    this.ghR = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hg
 * JD-Core Version:    0.7.0.1
 */