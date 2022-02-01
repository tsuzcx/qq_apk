package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lc
  extends a
{
  public String gPW = "";
  public long gPX;
  public int gQc;
  public int gQd;
  public long gQe;
  public long gQf;
  public String gcU = "";
  public String gjX = "";
  
  public final String agH()
  {
    AppMethodBeat.i(213142);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gPW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gPX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQf);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(213142);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(213145);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FoldedBlockId:").append(this.gPW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.gjX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCount:").append(this.gPX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsExploded:").append(this.gQc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsClicked:").append(this.gQd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimelineBrowseFeedCount:").append(this.gQe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LocationIndex:").append(this.gQf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(213145);
    return localObject;
  }
  
  public final int getId()
  {
    return 21340;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.lc
 * JD-Core Version:    0.7.0.1
 */