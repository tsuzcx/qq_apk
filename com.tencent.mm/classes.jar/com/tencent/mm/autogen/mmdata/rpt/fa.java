package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fa
  extends a
{
  public long iGp;
  public long iGq;
  public long iGr;
  private String ijk = "";
  private String ipW = "";
  public long ixB;
  
  public final String aIE()
  {
    AppMethodBeat.i(367794);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGr);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367794);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367802);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.ixB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsOverlap:").append(this.iGp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OverlapCount:").append(this.iGq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.ipW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TabType:").append(this.iGr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367802);
    return localObject;
  }
  
  public final int getId()
  {
    return 19946;
  }
  
  public final fa px(String paramString)
  {
    AppMethodBeat.i(367782);
    this.ijk = F("SessionId", paramString, true);
    AppMethodBeat.o(367782);
    return this;
  }
  
  public final fa py(String paramString)
  {
    AppMethodBeat.i(367786);
    this.ipW = F("feedid", paramString, true);
    AppMethodBeat.o(367786);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.fa
 * JD-Core Version:    0.7.0.1
 */