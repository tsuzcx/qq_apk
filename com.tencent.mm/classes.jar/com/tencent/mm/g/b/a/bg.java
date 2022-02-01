package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bg
  extends a
{
  private String dTr = "";
  private long dZZ;
  private long eaa;
  private long eab;
  private long eac;
  private long ead;
  private long eae;
  private long eaf;
  private long eag;
  private long eah;
  private long eai;
  private long eaj;
  private long eak;
  private long eal;
  
  public final String RC()
  {
    AppMethodBeat.i(189204);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eab);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eac);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ead);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eae);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eah);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eai);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eak);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eal);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189204);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189205);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FetchNewCount:").append(this.dZZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseTotalCount:").append(this.eaa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseNewCount:").append(this.eab);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseOldCount:").append(this.eac);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseNewFollowCount:").append(this.ead);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseNewLikeCount:").append(this.eae);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseNewCommentCount:").append(this.eaf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseNewAtCount:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseOldFollowCount:").append(this.eah);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseOldLikeCount:").append(this.eai);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseOldCommentCount:").append(this.eaj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseOldAtCount:").append(this.eak);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseDuration:").append(this.eal);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189205);
    return localObject;
  }
  
  public final long Sf()
  {
    return this.eaa;
  }
  
  public final long Sg()
  {
    return this.eab;
  }
  
  public final long Sh()
  {
    return this.eac;
  }
  
  public final long Si()
  {
    return this.ead;
  }
  
  public final long Sj()
  {
    return this.eae;
  }
  
  public final long Sk()
  {
    return this.eaf;
  }
  
  public final long Sl()
  {
    return this.eag;
  }
  
  public final long Sm()
  {
    return this.eah;
  }
  
  public final long Sn()
  {
    return this.eai;
  }
  
  public final long So()
  {
    return this.eaj;
  }
  
  public final long Sp()
  {
    return this.eak;
  }
  
  public final bg fh(long paramLong)
  {
    this.eaa = paramLong;
    return this;
  }
  
  public final bg fi(long paramLong)
  {
    this.eab = paramLong;
    return this;
  }
  
  public final bg fj(long paramLong)
  {
    this.eac = paramLong;
    return this;
  }
  
  public final bg fk(long paramLong)
  {
    this.ead = paramLong;
    return this;
  }
  
  public final bg fl(long paramLong)
  {
    this.eae = paramLong;
    return this;
  }
  
  public final bg fm(long paramLong)
  {
    this.eaf = paramLong;
    return this;
  }
  
  public final bg fn(long paramLong)
  {
    this.eag = paramLong;
    return this;
  }
  
  public final bg fo(long paramLong)
  {
    this.eah = paramLong;
    return this;
  }
  
  public final bg fp(long paramLong)
  {
    this.eai = paramLong;
    return this;
  }
  
  public final bg fq(long paramLong)
  {
    this.eaj = paramLong;
    return this;
  }
  
  public final bg fr(long paramLong)
  {
    this.eak = paramLong;
    return this;
  }
  
  public final bg fs(long paramLong)
  {
    this.eal = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19948;
  }
  
  public final bg jM(String paramString)
  {
    AppMethodBeat.i(189203);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(189203);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bg
 * JD-Core Version:    0.7.0.1
 */