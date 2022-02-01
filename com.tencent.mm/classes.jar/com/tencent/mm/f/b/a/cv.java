package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cv
  extends a
{
  private String gcV = "";
  private long gjl;
  private String gmO = "";
  private String gnO = "";
  private String gnp = "";
  private String grf = "";
  private long grg;
  private String grh = "";
  private long gri;
  private long grj;
  
  public final String agH()
  {
    AppMethodBeat.i(209228);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gjl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gri);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grj);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209228);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209230);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("CommentScene:").append(this.gjl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.gnO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.gnp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.gcV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.gmO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FlodUsername:").append(this.grf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FlodFeedCnt:").append(this.grg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllFlodFeedItems:").append(this.grh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoreTabClickTimestamp:").append(this.gri);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TopTabClickTimestamp:").append(this.grj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209230);
    return localObject;
  }
  
  public final String ahQ()
  {
    return this.grh;
  }
  
  public final cv gA(long paramLong)
  {
    this.grj = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20027;
  }
  
  public final cv gx(long paramLong)
  {
    this.gjl = paramLong;
    return this;
  }
  
  public final cv gy(long paramLong)
  {
    this.grg = paramLong;
    return this;
  }
  
  public final cv gz(long paramLong)
  {
    this.gri = paramLong;
    return this;
  }
  
  public final cv nB(String paramString)
  {
    AppMethodBeat.i(209222);
    this.gnO = z("Sessionid", paramString, true);
    AppMethodBeat.o(209222);
    return this;
  }
  
  public final cv nC(String paramString)
  {
    AppMethodBeat.i(209223);
    this.gnp = z("Contextid", paramString, true);
    AppMethodBeat.o(209223);
    return this;
  }
  
  public final cv nD(String paramString)
  {
    AppMethodBeat.i(209224);
    this.gcV = z("ClickTabContextid", paramString, true);
    AppMethodBeat.o(209224);
    return this;
  }
  
  public final cv nE(String paramString)
  {
    AppMethodBeat.i(209225);
    this.gmO = z("FeedId", paramString, true);
    AppMethodBeat.o(209225);
    return this;
  }
  
  public final cv nF(String paramString)
  {
    AppMethodBeat.i(209226);
    this.grf = z("FlodUsername", paramString, true);
    AppMethodBeat.o(209226);
    return this;
  }
  
  public final cv nG(String paramString)
  {
    AppMethodBeat.i(209227);
    this.grh = z("AllFlodFeedItems", paramString, true);
    AppMethodBeat.o(209227);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.cv
 * JD-Core Version:    0.7.0.1
 */