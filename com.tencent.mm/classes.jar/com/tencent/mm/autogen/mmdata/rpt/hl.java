package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hl
  extends a
{
  public long iOA;
  private String iOB = "";
  private long iOC;
  public long iOD;
  private long iOE;
  public long iOg;
  public long iOh;
  public long iOi;
  public long iOj;
  public long iOl;
  private String iOm = "";
  private String iOs = "";
  private String iOv = "";
  private long iOw;
  private long iOx;
  public long iOy;
  private String iOz = "";
  private String ijk = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(369050);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iOg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOE);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369050);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369058);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SceneID:").append(this.iOg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UIArea:").append(this.iOh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PositionID:").append(this.iOi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionID:").append(this.iOj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceID:").append(this.iOl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GameID:").append(this.iOm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionStatus:").append(this.iOv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GiftID:").append(this.iOw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GiftType:").append(this.iOx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("from_account_type:").append(this.iOy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("from_username:").append(this.iOz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("to_account_type:").append(this.iOA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("to_username:").append(this.iOB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDot:").append(this.iOC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalNum:").append(this.iOD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExternInfo:").append(this.iOs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Time:").append(this.iOE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369058);
    return localObject;
  }
  
  public final int getId()
  {
    return 20488;
  }
  
  public final hl rA(String paramString)
  {
    AppMethodBeat.i(369045);
    this.iOs = F("ExternInfo", paramString, true);
    AppMethodBeat.o(369045);
    return this;
  }
  
  public final hl rw(String paramString)
  {
    AppMethodBeat.i(369024);
    this.iOv = F("ActionStatus", paramString, true);
    AppMethodBeat.o(369024);
    return this;
  }
  
  public final hl rx(String paramString)
  {
    AppMethodBeat.i(369030);
    this.iOz = F("from_username", paramString, true);
    AppMethodBeat.o(369030);
    return this;
  }
  
  public final hl ry(String paramString)
  {
    AppMethodBeat.i(369035);
    this.iOB = F("to_username", paramString, true);
    AppMethodBeat.o(369035);
    return this;
  }
  
  public final hl rz(String paramString)
  {
    AppMethodBeat.i(369041);
    this.ijk = F("SessionId", paramString, true);
    AppMethodBeat.o(369041);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.hl
 * JD-Core Version:    0.7.0.1
 */