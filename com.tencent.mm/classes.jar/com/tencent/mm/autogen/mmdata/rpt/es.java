package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class es
  extends a
{
  public long iEd;
  private long iEg;
  public long ikE;
  public long ikr;
  private String inx = "";
  private String ipT = "";
  private String ipU = "";
  private String iqp = "";
  private String irj = "";
  private String iuI = "";
  private String iuJ = "";
  private String iwO = "";
  public long iwV;
  public long iwW;
  private String ixf = "";
  private String ixg = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(367903);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.irj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixg);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367903);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367915);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("UserName:").append(this.irj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LiveID:").append(this.iuJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedID:").append(this.iuI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.inx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTS:").append(this.iwW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.iwO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("index:").append(this.ikr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterStatus:").append(this.iwV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.ipT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.ipU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionBuffer:").append(this.iqp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OnlineNum:").append(this.iEd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterSessionId:").append(this.iEg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("chnl_extra:").append(this.ixf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickSubTabContextId:").append(this.ixg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367915);
    return localObject;
  }
  
  public final int getId()
  {
    return 22648;
  }
  
  public final es pg(String paramString)
  {
    AppMethodBeat.i(367854);
    this.irj = F("UserName", paramString, true);
    AppMethodBeat.o(367854);
    return this;
  }
  
  public final es ph(String paramString)
  {
    AppMethodBeat.i(367862);
    this.iuJ = F("LiveID", paramString, true);
    AppMethodBeat.o(367862);
    return this;
  }
  
  public final es pi(String paramString)
  {
    AppMethodBeat.i(367868);
    this.iuI = F("FeedID", paramString, true);
    AppMethodBeat.o(367868);
    return this;
  }
  
  public final es pj(String paramString)
  {
    AppMethodBeat.i(367872);
    this.inx = F("sessionid", paramString, true);
    AppMethodBeat.o(367872);
    return this;
  }
  
  public final es pk(String paramString)
  {
    AppMethodBeat.i(367878);
    this.iwO = F("CommentScene", paramString, true);
    AppMethodBeat.o(367878);
    return this;
  }
  
  public final es pl(String paramString)
  {
    AppMethodBeat.i(367881);
    this.ipT = F("ContextId", paramString, true);
    AppMethodBeat.o(367881);
    return this;
  }
  
  public final es pm(String paramString)
  {
    AppMethodBeat.i(367886);
    this.ipU = F("ClickTabContextId", paramString, true);
    AppMethodBeat.o(367886);
    return this;
  }
  
  public final es pn(String paramString)
  {
    AppMethodBeat.i(367893);
    this.iqp = F("SessionBuffer", paramString, true);
    AppMethodBeat.o(367893);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.es
 * JD-Core Version:    0.7.0.1
 */