package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fb
  extends a
{
  public long iGA;
  public long iGB;
  public long iGC;
  public long iGD;
  public long iGE;
  public long iGr;
  public long iGs;
  public long iGt;
  public long iGu;
  public long iGv;
  public long iGw;
  public long iGx;
  public long iGy;
  public long iGz;
  private String ijk = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(367796);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGr);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367796);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367805);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FetchNewCount:").append(this.iGs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseTotalCount:").append(this.iGt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseNewCount:").append(this.iGu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseOldCount:").append(this.iGv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseNewFollowCount:").append(this.iGw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseNewLikeCount:").append(this.iGx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseNewCommentCount:").append(this.iGy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseNewAtCount:").append(this.iGz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseOldFollowCount:").append(this.iGA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseOldLikeCount:").append(this.iGB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseOldCommentCount:").append(this.iGC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseOldAtCount:").append(this.iGD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseDuration:").append(this.iGE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TabType:").append(this.iGr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367805);
    return localObject;
  }
  
  public final int getId()
  {
    return 19948;
  }
  
  public final fb pz(String paramString)
  {
    AppMethodBeat.i(367787);
    this.ijk = F("SessionId", paramString, true);
    AppMethodBeat.o(367787);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.fb
 * JD-Core Version:    0.7.0.1
 */