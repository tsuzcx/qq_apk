package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class is
  extends a
{
  private String ePA = "";
  public long ePB;
  public long ePC;
  public String ePD = "";
  public String ePE = "";
  public long ePF;
  public String eiB = "";
  public String eoK = "";
  
  public final String abV()
  {
    AppMethodBeat.i(201837);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ePA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ePB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ePC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ePD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ePE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ePF);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(201837);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(201838);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FoldedBlockId:").append(this.ePA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.eoK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCount:").append(this.ePB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseFeedCount:").append(this.ePC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedList:").append(this.ePD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseFeedList:").append(this.ePE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseTime:").append(this.ePF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(201838);
    return localObject;
  }
  
  public final int getId()
  {
    return 21341;
  }
  
  public final is ws(String paramString)
  {
    AppMethodBeat.i(201836);
    this.ePA = x("FoldedBlockId", paramString, true);
    AppMethodBeat.o(201836);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.is
 * JD-Core Version:    0.7.0.1
 */