package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class el
  extends a
{
  public long iAO;
  public long iEa;
  public long iEb;
  public String iEc = "";
  public long iEd;
  public String iEe = "";
  public String iEf = "";
  public long iEg;
  public String iEh = "";
  public long ikE;
  public String ipT = "";
  public String ipU = "";
  public String iqO = "";
  public String iqp = "";
  public String irj = "";
  public String iuI = "";
  public String iwO = "";
  public long iwP;
  public long iwV;
  public long iwW;
  public long iwY;
  public String ixf = "";
  public String ixg = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(367955);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.irj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixg);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367955);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367963);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("UserName:").append(this.irj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LiveID:").append(this.iEa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedID:").append(this.iuI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.iqO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTS:").append(this.iwW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.iwO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.iAO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterStatus:").append(this.iwV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareType:").append(this.iEb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareUserName:").append(this.iEc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.ipT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OnlineNum:").append(this.iEd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.ipU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPrivate:").append(this.iwP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionBuffer:").append(this.iqp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LiveIDStr:").append(this.iEe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsFeedId:").append(this.iEf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterSessionId:").append(this.iEg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterIconType:").append(this.iwY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsSessionID:").append(this.iEh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("chnl_extra:").append(this.ixf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickSubTabContextId:").append(this.ixg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367963);
    return localObject;
  }
  
  public final int getId()
  {
    return 21053;
  }
  
  public final el oL(String paramString)
  {
    AppMethodBeat.i(367876);
    this.irj = F("UserName", paramString, true);
    AppMethodBeat.o(367876);
    return this;
  }
  
  public final el oM(String paramString)
  {
    AppMethodBeat.i(367879);
    this.iuI = F("FeedID", paramString, true);
    AppMethodBeat.o(367879);
    return this;
  }
  
  public final el oN(String paramString)
  {
    AppMethodBeat.i(367884);
    this.iqO = F("SessionID", paramString, true);
    AppMethodBeat.o(367884);
    return this;
  }
  
  public final el oO(String paramString)
  {
    AppMethodBeat.i(367890);
    this.iwO = F("CommentScene", paramString, true);
    AppMethodBeat.o(367890);
    return this;
  }
  
  public final el oP(String paramString)
  {
    AppMethodBeat.i(367898);
    this.iEc = F("ShareUserName", paramString, true);
    AppMethodBeat.o(367898);
    return this;
  }
  
  public final el oQ(String paramString)
  {
    AppMethodBeat.i(367904);
    this.ipT = F("ContextId", paramString, true);
    AppMethodBeat.o(367904);
    return this;
  }
  
  public final el oR(String paramString)
  {
    AppMethodBeat.i(367912);
    this.ipU = F("ClickTabContextId", paramString, true);
    AppMethodBeat.o(367912);
    return this;
  }
  
  public final el oS(String paramString)
  {
    AppMethodBeat.i(367919);
    this.iqp = F("SessionBuffer", paramString, true);
    AppMethodBeat.o(367919);
    return this;
  }
  
  public final el oT(String paramString)
  {
    AppMethodBeat.i(367924);
    this.iEe = F("LiveIDStr", paramString, true);
    AppMethodBeat.o(367924);
    return this;
  }
  
  public final el oU(String paramString)
  {
    AppMethodBeat.i(367929);
    this.iEf = F("SnsFeedId", paramString, true);
    AppMethodBeat.o(367929);
    return this;
  }
  
  public final el oV(String paramString)
  {
    AppMethodBeat.i(367934);
    this.iEh = F("SnsSessionID", paramString, true);
    AppMethodBeat.o(367934);
    return this;
  }
  
  public final el oW(String paramString)
  {
    AppMethodBeat.i(367940);
    this.ixf = F("chnl_extra", paramString, true);
    AppMethodBeat.o(367940);
    return this;
  }
  
  public final el oX(String paramString)
  {
    AppMethodBeat.i(367946);
    this.ixg = F("ClickSubTabContextId", paramString, true);
    AppMethodBeat.o(367946);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.el
 * JD-Core Version:    0.7.0.1
 */