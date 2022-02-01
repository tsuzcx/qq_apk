package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class en
  extends a
{
  public String iCS = "";
  public String iEl = "";
  public String iEm = "";
  public String iEn = "";
  public long iEo;
  public String iEp = "";
  public String iEq = "";
  private String iEr = "";
  public String iEs = "";
  public String iEt = "";
  public String iny = "";
  public long ioV;
  public String ipU = "";
  public long iwV;
  public String ixa = "";
  public String ixb = "";
  public String ixs = "";
  private String izF = "";
  public String izJ = "";
  public long izK;
  
  public final String aIE()
  {
    AppMethodBeat.i(367926);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iEl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iny);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEt);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367926);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367938);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FinderUsrName:").append(this.iEl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderSessionId:").append(this.izJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeMs:").append(this.izK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.ioV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterLiveId:").append(this.iEm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterStatus:").append(this.iwV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentscene:").append(this.ixs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextid:").append(this.iny);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.ipU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AdData:").append(this.ixa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scenenote:").append(this.ixb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForcePushId:").append(this.iEn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Noticetype:").append(this.iEo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NotificationId:").append(this.iEp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportContent:").append(this.iEq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedID:").append(this.iEr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionBuffer:").append(this.izF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Description:").append(this.iCS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.iEs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("chnlExtra:").append(this.iEt);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367938);
    return localObject;
  }
  
  public final en eO(long paramLong)
  {
    AppMethodBeat.i(367896);
    this.izK = paramLong;
    super.bw("ActionTimeMs", this.izK);
    AppMethodBeat.o(367896);
    return this;
  }
  
  public final int getId()
  {
    return 21158;
  }
  
  public final en oY(String paramString)
  {
    AppMethodBeat.i(367889);
    this.iEl = F("FinderUsrName", paramString, true);
    AppMethodBeat.o(367889);
    return this;
  }
  
  public final en oZ(String paramString)
  {
    AppMethodBeat.i(367905);
    this.ixs = F("commentscene", paramString, true);
    AppMethodBeat.o(367905);
    return this;
  }
  
  public final en pa(String paramString)
  {
    AppMethodBeat.i(367913);
    this.iny = F("contextid", paramString, true);
    AppMethodBeat.o(367913);
    return this;
  }
  
  public final en pb(String paramString)
  {
    AppMethodBeat.i(367920);
    this.iEp = F("NotificationId", paramString, true);
    AppMethodBeat.o(367920);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.en
 * JD-Core Version:    0.7.0.1
 */