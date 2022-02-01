package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lp
  extends a
{
  private String eJx = "";
  private String eRc = "";
  private String eZj = "";
  public long eZk;
  public long eZl;
  
  public final String abV()
  {
    AppMethodBeat.i(174645);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eZj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eZk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eZl);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(174645);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(174646);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PagePath:").append(this.eZj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoUrl:").append(this.eRc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventId:").append(this.eZk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventNote:").append(this.eZl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(174646);
    return localObject;
  }
  
  public final int getId()
  {
    return 18837;
  }
  
  public final lp yW(String paramString)
  {
    AppMethodBeat.i(174642);
    this.eJx = x("AppId", paramString, true);
    AppMethodBeat.o(174642);
    return this;
  }
  
  public final lp yX(String paramString)
  {
    AppMethodBeat.i(174643);
    this.eZj = x("PagePath", paramString, true);
    AppMethodBeat.o(174643);
    return this;
  }
  
  public final lp yY(String paramString)
  {
    AppMethodBeat.i(174644);
    this.eRc = x("VideoUrl", paramString, true);
    AppMethodBeat.o(174644);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.lp
 * JD-Core Version:    0.7.0.1
 */