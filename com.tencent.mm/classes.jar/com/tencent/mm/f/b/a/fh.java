package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fh
  extends a
{
  private String gcV = "";
  private long gjl;
  private String gnO = "";
  private long gnP;
  private String gnp = "";
  private String gzs = "";
  private String gzt = "";
  private long gzu;
  private long gzv;
  private long gzw;
  
  public final String agH()
  {
    AppMethodBeat.i(208604);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gnP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjl);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(208604);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208606);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.gnO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.gnp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.gcV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PoiText:").append(this.gzs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FilterTextItems:").append(this.gzt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsUnflodtab:").append(this.gzu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsUnflodopen:").append(this.gzv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FliterPageType:").append(this.gzw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.gjl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208606);
    return localObject;
  }
  
  public final int getId()
  {
    return 19996;
  }
  
  public final fh ng(long paramLong)
  {
    this.gnP = paramLong;
    return this;
  }
  
  public final fh nh(long paramLong)
  {
    this.gzu = paramLong;
    return this;
  }
  
  public final fh ni(long paramLong)
  {
    this.gzv = paramLong;
    return this;
  }
  
  public final fh nj(long paramLong)
  {
    this.gzw = paramLong;
    return this;
  }
  
  public final fh nk(long paramLong)
  {
    this.gjl = paramLong;
    return this;
  }
  
  public final fh ua(String paramString)
  {
    AppMethodBeat.i(208594);
    this.gnO = z("Sessionid", paramString, true);
    AppMethodBeat.o(208594);
    return this;
  }
  
  public final fh ub(String paramString)
  {
    AppMethodBeat.i(208596);
    this.gnp = z("Contextid", paramString, true);
    AppMethodBeat.o(208596);
    return this;
  }
  
  public final fh uc(String paramString)
  {
    AppMethodBeat.i(208597);
    this.gcV = z("ClickTabContextid", paramString, true);
    AppMethodBeat.o(208597);
    return this;
  }
  
  public final fh ud(String paramString)
  {
    AppMethodBeat.i(208599);
    this.gzs = z("PoiText", paramString, true);
    AppMethodBeat.o(208599);
    return this;
  }
  
  public final fh ue(String paramString)
  {
    AppMethodBeat.i(208600);
    this.gzt = z("FilterTextItems", paramString, true);
    AppMethodBeat.o(208600);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.fh
 * JD-Core Version:    0.7.0.1
 */