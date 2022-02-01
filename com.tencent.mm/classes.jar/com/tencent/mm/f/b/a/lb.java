package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lb
  extends a
{
  private String gPW = "";
  public long gPX;
  public long gPY;
  public String gPZ = "";
  public String gQa = "";
  public long gQb;
  public String gcU = "";
  public String gjX = "";
  
  public final lb BT(String paramString)
  {
    AppMethodBeat.i(216729);
    this.gPW = z("FoldedBlockId", paramString, true);
    AppMethodBeat.o(216729);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(216731);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gPW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gPX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gPY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gPZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQb);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(216731);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(216732);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FoldedBlockId:").append(this.gPW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.gjX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCount:").append(this.gPX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseFeedCount:").append(this.gPY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedList:").append(this.gPZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseFeedList:").append(this.gQa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseTime:").append(this.gQb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(216732);
    return localObject;
  }
  
  public final int getId()
  {
    return 21341;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.lb
 * JD-Core Version:    0.7.0.1
 */