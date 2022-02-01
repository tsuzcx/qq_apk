package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hk
  extends a
{
  public long iLO;
  public long iOg;
  public long iOh;
  public long iOi;
  public long iOj;
  public long iOk;
  public long iOl;
  private String iOm = "";
  private String iOn = "";
  public long iOo;
  private String iOp = "";
  private String iOq = "";
  private int iOr;
  public String iOs = "";
  public long iOt;
  public int iOu;
  private String imU = "";
  public long iuR;
  
  public final String aIE()
  {
    AppMethodBeat.i(369042);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iOg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOu);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369042);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369046);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SceneID:").append(this.iOg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UIArea:").append(this.iOh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PositionID:").append(this.iOi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionID:").append(this.iOj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionStatus:").append(this.iLO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Ssid:").append(this.iOk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceID:").append(this.iOl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GameID:").append(this.iOm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatroomID:").append(this.iOn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MessageID:").append(this.iOo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GameLeval:").append(this.iOp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GameTitle:").append(this.iOq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserState:").append(this.iOr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.imU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTime:").append(this.iuR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExternInfo:").append(this.iOs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NoticeID:").append(this.iOt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TalkTab:").append(this.iOu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369046);
    return localObject;
  }
  
  public final int getId()
  {
    return 23070;
  }
  
  public final hk rs(String paramString)
  {
    AppMethodBeat.i(369017);
    this.iOm = F("GameID", paramString, true);
    AppMethodBeat.o(369017);
    return this;
  }
  
  public final hk rt(String paramString)
  {
    AppMethodBeat.i(369022);
    this.iOn = F("ChatroomID", paramString, true);
    AppMethodBeat.o(369022);
    return this;
  }
  
  public final hk ru(String paramString)
  {
    AppMethodBeat.i(369027);
    this.imU = F("Username", paramString, true);
    AppMethodBeat.o(369027);
    return this;
  }
  
  public final hk rv(String paramString)
  {
    AppMethodBeat.i(369033);
    this.iOs = F("ExternInfo", paramString, true);
    AppMethodBeat.o(369033);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.hk
 * JD-Core Version:    0.7.0.1
 */