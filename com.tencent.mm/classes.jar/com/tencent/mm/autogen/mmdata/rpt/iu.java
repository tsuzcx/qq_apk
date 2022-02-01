package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class iu
  extends a
{
  private String iGf = "";
  public int iQQ;
  private String iQR = "";
  public String ipT = "";
  public String iqO = "";
  public String iqp = "";
  private String irj = "";
  private String iuI = "";
  private String iuJ = "";
  public String iwO = "";
  public String ixf = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368722);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iuJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGf);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368722);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368732);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("LiveID:").append(this.iuJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedID:").append(this.iuI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.irj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.iqO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.iwO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.ipT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionBuffer:").append(this.iqp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterIconType:").append(this.iQQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("chnl_extra:").append(this.ixf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Event:").append(this.iQR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Params:").append(this.iGf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368732);
    return localObject;
  }
  
  public final int getId()
  {
    return 23782;
  }
  
  public final iu rU(String paramString)
  {
    AppMethodBeat.i(368693);
    this.iuJ = F("LiveID", paramString, true);
    AppMethodBeat.o(368693);
    return this;
  }
  
  public final iu rV(String paramString)
  {
    AppMethodBeat.i(368701);
    this.iuI = F("FeedID", paramString, true);
    AppMethodBeat.o(368701);
    return this;
  }
  
  public final iu rW(String paramString)
  {
    AppMethodBeat.i(368706);
    this.irj = F("UserName", paramString, true);
    AppMethodBeat.o(368706);
    return this;
  }
  
  public final iu rX(String paramString)
  {
    AppMethodBeat.i(368709);
    this.iQR = F("Event", paramString, true);
    AppMethodBeat.o(368709);
    return this;
  }
  
  public final iu rY(String paramString)
  {
    AppMethodBeat.i(368714);
    this.iGf = F("Params", paramString, true);
    AppMethodBeat.o(368714);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.iu
 * JD-Core Version:    0.7.0.1
 */