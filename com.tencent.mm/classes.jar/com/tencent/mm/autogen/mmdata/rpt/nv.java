package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nv
  extends a
{
  public long ioV = 0L;
  private String iqO = "";
  private String iuI = "";
  private String jgf = "";
  private String jgg = "";
  private String jgh = "";
  public int jgi = 1;
  public int jgj = 0;
  public long jgk = 0L;
  public long jgl = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(367842);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iqO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgl);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367842);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367847);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionID:").append(this.iqO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedID:").append(this.iuI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedUin:").append(this.jgf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CreatedCommentID:").append(this.jgg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HotWord:").append(this.jgh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HotWordCnt:").append(this.jgi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HotWordNo:").append(this.jgj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.ioV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedAuthorType:").append(this.jgk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagSource:").append(this.jgl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367847);
    return localObject;
  }
  
  public final int getId()
  {
    return 23569;
  }
  
  public final nv vQ(String paramString)
  {
    AppMethodBeat.i(367809);
    this.iqO = F("SessionID", paramString, true);
    AppMethodBeat.o(367809);
    return this;
  }
  
  public final nv vR(String paramString)
  {
    AppMethodBeat.i(367811);
    this.iuI = F("FeedID", paramString, true);
    AppMethodBeat.o(367811);
    return this;
  }
  
  public final nv vS(String paramString)
  {
    AppMethodBeat.i(367818);
    this.jgf = F("FeedUin", paramString, true);
    AppMethodBeat.o(367818);
    return this;
  }
  
  public final nv vT(String paramString)
  {
    AppMethodBeat.i(367829);
    this.jgg = F("CreatedCommentID", paramString, true);
    AppMethodBeat.o(367829);
    return this;
  }
  
  public final nv vU(String paramString)
  {
    AppMethodBeat.i(367836);
    this.jgh = F("HotWord", paramString, true);
    AppMethodBeat.o(367836);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.nv
 * JD-Core Version:    0.7.0.1
 */