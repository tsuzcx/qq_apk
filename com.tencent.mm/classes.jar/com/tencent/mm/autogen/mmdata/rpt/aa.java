package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class aa
  extends a
{
  private String ijk = "";
  public int ilm;
  public int imM;
  private String imN = "";
  public int imO;
  public long imP;
  public long imQ;
  public int imR;
  private String imS = "";
  private String imT = "";
  private String imU = "";
  private String imV = "";
  public int imW;
  public long imX;
  
  public final String aIE()
  {
    AppMethodBeat.i(368711);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ilm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imX);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368711);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368718);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.ilm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatType:").append(this.imM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatName:").append(this.imN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatRoomUserCount:").append(this.imO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgId:").append(this.imP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CardId:").append(this.imQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CardType:").append(this.imR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SenderUsername:").append(this.imS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.imT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.imU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterPath:").append(this.imV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.imW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposePeriod:").append(this.imX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368718);
    return localObject;
  }
  
  public final int getId()
  {
    return 24822;
  }
  
  public final aa km(String paramString)
  {
    AppMethodBeat.i(368677);
    this.imN = F("ChatName", paramString, true);
    AppMethodBeat.o(368677);
    return this;
  }
  
  public final aa kn(String paramString)
  {
    AppMethodBeat.i(368681);
    this.ijk = F("SessionId", paramString, true);
    AppMethodBeat.o(368681);
    return this;
  }
  
  public final aa ko(String paramString)
  {
    AppMethodBeat.i(368684);
    this.imS = F("SenderUsername", paramString, true);
    AppMethodBeat.o(368684);
    return this;
  }
  
  public final aa kp(String paramString)
  {
    AppMethodBeat.i(368692);
    this.imT = F("AppId", paramString, true);
    AppMethodBeat.o(368692);
    return this;
  }
  
  public final aa kq(String paramString)
  {
    AppMethodBeat.i(368697);
    this.imU = F("Username", paramString, true);
    AppMethodBeat.o(368697);
    return this;
  }
  
  public final aa kr(String paramString)
  {
    AppMethodBeat.i(368703);
    this.imV = F("EnterPath", paramString, true);
    AppMethodBeat.o(368703);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.aa
 * JD-Core Version:    0.7.0.1
 */