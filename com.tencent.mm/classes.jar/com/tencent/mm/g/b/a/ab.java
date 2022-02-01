package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ab
  extends a
{
  private String dFe;
  private String dHM;
  private long dHR;
  private String dIa;
  private String dIb;
  private String dIc;
  private long dId;
  private long dIe;
  private long dIf;
  
  public final String PR()
  {
    AppMethodBeat.i(194894);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dId);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIf);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(194894);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(194895);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FeedId:").append(this.dHM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PosterUsername:").append(this.dIa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ViewerUsername:").append(this.dIb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MentionedUsername:").append(this.dIc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dHR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("recommendtype:").append(this.dId);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("likecnt:").append(this.dIe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commcnt:").append(this.dIf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(194895);
    return localObject;
  }
  
  public final ab cp(long paramLong)
  {
    this.dHR = paramLong;
    return this;
  }
  
  public final ab cq(long paramLong)
  {
    this.dId = paramLong;
    return this;
  }
  
  public final ab cr(long paramLong)
  {
    this.dIe = paramLong;
    return this;
  }
  
  public final ab cs(long paramLong)
  {
    this.dIf = paramLong;
    return this;
  }
  
  public final ab gd(String paramString)
  {
    AppMethodBeat.i(194889);
    this.dHM = t("FeedId", paramString, true);
    AppMethodBeat.o(194889);
    return this;
  }
  
  public final ab ge(String paramString)
  {
    AppMethodBeat.i(194890);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(194890);
    return this;
  }
  
  public final int getId()
  {
    return 19793;
  }
  
  public final ab gf(String paramString)
  {
    AppMethodBeat.i(194891);
    this.dIa = t("PosterUsername", paramString, true);
    AppMethodBeat.o(194891);
    return this;
  }
  
  public final ab gg(String paramString)
  {
    AppMethodBeat.i(194892);
    this.dIb = t("ViewerUsername", paramString, true);
    AppMethodBeat.o(194892);
    return this;
  }
  
  public final ab gh(String paramString)
  {
    AppMethodBeat.i(194893);
    this.dIc = t("MentionedUsername", paramString, true);
    AppMethodBeat.o(194893);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ab
 * JD-Core Version:    0.7.0.1
 */