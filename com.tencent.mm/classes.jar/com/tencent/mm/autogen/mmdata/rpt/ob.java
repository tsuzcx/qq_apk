package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ob
  extends a
{
  public String ijk = "";
  public String irj = "";
  private String jik = "";
  public long jil;
  public long jim;
  public String jin = "";
  public String jio = "";
  public long jip;
  
  public final String aIE()
  {
    AppMethodBeat.i(368058);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jik);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jil);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jim);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jin);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jio);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jip);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368058);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368066);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FoldedBlockId:").append(this.jik);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.irj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCount:").append(this.jil);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseFeedCount:").append(this.jim);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedList:").append(this.jin);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseFeedList:").append(this.jio);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseTime:").append(this.jip);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368066);
    return localObject;
  }
  
  public final int getId()
  {
    return 21341;
  }
  
  public final ob wd(String paramString)
  {
    AppMethodBeat.i(368052);
    this.jik = F("FoldedBlockId", paramString, true);
    AppMethodBeat.o(368052);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ob
 * JD-Core Version:    0.7.0.1
 */