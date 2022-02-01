package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eg
  extends a
{
  public long dPH;
  public long dSy;
  private String ecZ = "";
  public long ehJ;
  private String ehK = "";
  private String ehL = "";
  public long ehM;
  public long ehm;
  
  public final String RD()
  {
    AppMethodBeat.i(184776);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ecZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehL);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(184776);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(184777);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.ecZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.dSy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exit:").append(this.ehJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgType:").append(this.ehm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dPH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openHelp:").append(this.ehM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("todoid:").append(this.ehK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appusername:").append(this.ehL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184777);
    return localObject;
  }
  
  public final int getId()
  {
    return 19442;
  }
  
  public final eg nB(String paramString)
  {
    AppMethodBeat.i(184775);
    this.ecZ = t("roomid", paramString, true);
    AppMethodBeat.o(184775);
    return this;
  }
  
  public final eg nC(String paramString)
  {
    AppMethodBeat.i(213377);
    this.ehK = t("todoid", paramString, true);
    AppMethodBeat.o(213377);
    return this;
  }
  
  public final eg nD(String paramString)
  {
    AppMethodBeat.i(213378);
    this.ehL = t("appusername", paramString, true);
    AppMethodBeat.o(213378);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.eg
 * JD-Core Version:    0.7.0.1
 */