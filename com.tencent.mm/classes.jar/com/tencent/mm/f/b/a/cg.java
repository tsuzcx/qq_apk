package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cg
  extends a
{
  private String gcU = "";
  private String gmO = "";
  private String goS = "";
  private String goZ = "";
  private String gpA = "";
  private long gpB;
  private String gpC = "";
  private String gpD = "";
  private String gpa = "";
  private long gpb;
  private long gpc;
  private long gpu;
  private long gpv;
  private String gpw = "";
  private long gpx;
  private long gpy;
  private long gpz;
  
  public final String agH()
  {
    AppMethodBeat.i(209718);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpD);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209718);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209721);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterScene:").append(this.gpu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CardType:").append(this.gpv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceUsr:").append(this.gpw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.gmO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedUsr:").append(this.goS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tag:").append(this.goZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagId:").append(this.gpa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPoi:").append(this.gpb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagFeedCnt:").append(this.gpc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsHaveCover:").append(this.gpx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsCgiEnd:").append(this.gpy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UIType:").append(this.gpz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GroupID:").append(this.gpA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TrackType:").append(this.gpB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ColumnId:").append(this.gpC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActivityID:").append(this.gpD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209721);
    return localObject;
  }
  
  public final cg fe(long paramLong)
  {
    this.gpu = paramLong;
    return this;
  }
  
  public final cg ff(long paramLong)
  {
    this.gpv = paramLong;
    return this;
  }
  
  public final cg fg(long paramLong)
  {
    this.gpx = paramLong;
    return this;
  }
  
  public final cg fh(long paramLong)
  {
    this.gpy = paramLong;
    return this;
  }
  
  public final cg fi(long paramLong)
  {
    this.gpz = paramLong;
    return this;
  }
  
  public final cg fj(long paramLong)
  {
    this.gpB = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 18944;
  }
  
  public final cg lZ(String paramString)
  {
    AppMethodBeat.i(209694);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(209694);
    return this;
  }
  
  public final cg ma(String paramString)
  {
    AppMethodBeat.i(209696);
    this.gpw = z("SourceUsr", paramString, true);
    AppMethodBeat.o(209696);
    return this;
  }
  
  public final cg mb(String paramString)
  {
    AppMethodBeat.i(209699);
    this.gmO = z("FeedId", paramString, true);
    AppMethodBeat.o(209699);
    return this;
  }
  
  public final cg mc(String paramString)
  {
    AppMethodBeat.i(209701);
    this.goS = z("FeedUsr", paramString, true);
    AppMethodBeat.o(209701);
    return this;
  }
  
  public final cg md(String paramString)
  {
    AppMethodBeat.i(209703);
    this.goZ = z("Tag", paramString, true);
    AppMethodBeat.o(209703);
    return this;
  }
  
  public final cg me(String paramString)
  {
    AppMethodBeat.i(209709);
    this.gpA = z("GroupID", paramString, true);
    AppMethodBeat.o(209709);
    return this;
  }
  
  public final cg mf(String paramString)
  {
    AppMethodBeat.i(209713);
    this.gpC = z("ColumnId", paramString, true);
    AppMethodBeat.o(209713);
    return this;
  }
  
  public final cg mg(String paramString)
  {
    AppMethodBeat.i(209715);
    this.gpD = z("ActivityID", paramString, true);
    AppMethodBeat.o(209715);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.cg
 * JD-Core Version:    0.7.0.1
 */