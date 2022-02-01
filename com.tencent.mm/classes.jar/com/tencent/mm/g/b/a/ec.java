package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ec
  extends a
{
  public int dSg;
  private String dTi;
  private String ehA;
  private String ehB;
  public int ehC;
  public int ehD;
  public int ehE;
  public long ehx;
  public long ehy;
  private String ehz;
  
  public final String RD()
  {
    AppMethodBeat.i(215647);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehE);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(215647);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(215648);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dSg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PatTime:").append(this.ehx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeTime:").append(this.ehy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.dTi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PattedUserName:").append(this.ehz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PatSuffix:").append(this.ehA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatRoomName:").append(this.ehB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeMethod:").append(this.ehC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSuccess:").append(this.ehD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeAction:").append(this.ehE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(215648);
    return localObject;
  }
  
  public final int getId()
  {
    return 20590;
  }
  
  public final ec nq(String paramString)
  {
    AppMethodBeat.i(215643);
    this.dTi = t("UserName", paramString, true);
    AppMethodBeat.o(215643);
    return this;
  }
  
  public final ec nr(String paramString)
  {
    AppMethodBeat.i(215644);
    this.ehz = t("PattedUserName", paramString, true);
    AppMethodBeat.o(215644);
    return this;
  }
  
  public final ec ns(String paramString)
  {
    AppMethodBeat.i(215645);
    this.ehA = t("PatSuffix", paramString, true);
    AppMethodBeat.o(215645);
    return this;
  }
  
  public final ec nt(String paramString)
  {
    AppMethodBeat.i(215646);
    this.ehB = t("ChatRoomName", paramString, true);
    AppMethodBeat.o(215646);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ec
 * JD-Core Version:    0.7.0.1
 */