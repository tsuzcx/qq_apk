package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class it
  extends a
{
  public String ePA = "";
  public long ePB;
  public int ePG;
  public int ePH;
  public long ePI;
  public long ePJ;
  public String eiB = "";
  public String eoK = "";
  
  public final String abV()
  {
    AppMethodBeat.i(201839);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ePA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ePB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ePG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ePH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ePI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ePJ);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(201839);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(201840);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FoldedBlockId:").append(this.ePA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.eoK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCount:").append(this.ePB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsExploded:").append(this.ePG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsClicked:").append(this.ePH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimelineBrowseFeedCount:").append(this.ePI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LocationIndex:").append(this.ePJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(201840);
    return localObject;
  }
  
  public final int getId()
  {
    return 21340;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.it
 * JD-Core Version:    0.7.0.1
 */