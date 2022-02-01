package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ek
  extends a
{
  public int dSg;
  private String dSm;
  private String dWK;
  private String ehA;
  public int ehC;
  public int ehE;
  public int ehW;
  public long ehX;
  public int ehY;
  public int ehZ;
  public long ehx;
  private String ehz;
  public int eia;
  public int eib;
  
  public final String RD()
  {
    AppMethodBeat.i(215653);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eia);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eib);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(215653);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(215654);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dSg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PatTime:").append(this.ehx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.dWK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PattedUserName:").append(this.ehz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatroomName:").append(this.dSm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrorCode:").append(this.ehW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeInterval:").append(this.ehX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsHitLocalFrequency:").append(this.ehY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsCreateNewChat:").append(this.ehZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PatSequence:").append(this.eia);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PatSuffix:").append(this.ehA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeAction:").append(this.ehE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeMethod:").append(this.ehC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsEducationGuidance:").append(this.eib);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(215654);
    return localObject;
  }
  
  public final int getId()
  {
    return 19878;
  }
  
  public final ek nI(String paramString)
  {
    AppMethodBeat.i(215649);
    this.dWK = t("Username", paramString, true);
    AppMethodBeat.o(215649);
    return this;
  }
  
  public final ek nJ(String paramString)
  {
    AppMethodBeat.i(215650);
    this.ehz = t("PattedUserName", paramString, true);
    AppMethodBeat.o(215650);
    return this;
  }
  
  public final ek nK(String paramString)
  {
    AppMethodBeat.i(215651);
    this.dSm = t("ChatroomName", paramString, true);
    AppMethodBeat.o(215651);
    return this;
  }
  
  public final ek nL(String paramString)
  {
    AppMethodBeat.i(215652);
    this.ehA = t("PatSuffix", paramString, true);
    AppMethodBeat.o(215652);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ek
 * JD-Core Version:    0.7.0.1
 */