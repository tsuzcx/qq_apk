package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bx
  extends a
{
  public long dFf;
  public long dHG;
  public long dPY;
  private String dQn = "";
  public long dQo;
  private String dQp = "";
  private String dQq = "";
  
  public final String PV()
  {
    AppMethodBeat.i(184773);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQq);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(184773);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(184774);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomId:").append(this.dQn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.dHG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgType:").append(this.dPY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dFf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exit:").append(this.dQo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("todoid:").append(this.dQp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appusername:").append(this.dQq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184774);
    return localObject;
  }
  
  public final int getId()
  {
    return 19444;
  }
  
  public final bx iB(String paramString)
  {
    AppMethodBeat.i(184771);
    this.dQn = t("roomId", paramString, true);
    AppMethodBeat.o(184771);
    return this;
  }
  
  public final bx iC(String paramString)
  {
    AppMethodBeat.i(184772);
    this.dQp = t("todoid", paramString, true);
    AppMethodBeat.o(184772);
    return this;
  }
  
  public final bx iD(String paramString)
  {
    AppMethodBeat.i(196559);
    this.dQq = t("appusername", paramString, true);
    AppMethodBeat.o(196559);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bx
 * JD-Core Version:    0.7.0.1
 */