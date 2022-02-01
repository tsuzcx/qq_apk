package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ef
  extends a
{
  public long dPH;
  public long dSy;
  private String edC = "";
  public long ehJ;
  private String ehK = "";
  private String ehL = "";
  public long ehm;
  
  public final String RD()
  {
    AppMethodBeat.i(184773);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.edC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehL);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(184773);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(184774);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomId:").append(this.edC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.dSy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgType:").append(this.ehm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dPH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exit:").append(this.ehJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("todoid:").append(this.ehK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appusername:").append(this.ehL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184774);
    return localObject;
  }
  
  public final int getId()
  {
    return 19444;
  }
  
  public final ef nA(String paramString)
  {
    AppMethodBeat.i(213376);
    this.ehL = t("appusername", paramString, true);
    AppMethodBeat.o(213376);
    return this;
  }
  
  public final ef ny(String paramString)
  {
    AppMethodBeat.i(184771);
    this.edC = t("roomId", paramString, true);
    AppMethodBeat.o(184771);
    return this;
  }
  
  public final ef nz(String paramString)
  {
    AppMethodBeat.i(184772);
    this.ehK = t("todoid", paramString, true);
    AppMethodBeat.o(184772);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ef
 * JD-Core Version:    0.7.0.1
 */