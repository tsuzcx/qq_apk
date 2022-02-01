package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dl
  extends a
{
  public long dCS;
  public long dFt;
  private String dOn = "";
  public long dRP;
  public long dSe;
  private String dSf = "";
  private String dSg = "";
  
  public final String PR()
  {
    AppMethodBeat.i(184773);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dOn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dCS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSg);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(184773);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(184774);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomId:").append(this.dOn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.dFt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgType:").append(this.dRP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dCS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exit:").append(this.dSe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("todoid:").append(this.dSf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appusername:").append(this.dSg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184774);
    return localObject;
  }
  
  public final int getId()
  {
    return 19444;
  }
  
  public final dl lr(String paramString)
  {
    AppMethodBeat.i(184771);
    this.dOn = t("roomId", paramString, true);
    AppMethodBeat.o(184771);
    return this;
  }
  
  public final dl ls(String paramString)
  {
    AppMethodBeat.i(184772);
    this.dSf = t("todoid", paramString, true);
    AppMethodBeat.o(184772);
    return this;
  }
  
  public final dl lt(String paramString)
  {
    AppMethodBeat.i(197013);
    this.dSg = t("appusername", paramString, true);
    AppMethodBeat.o(197013);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dl
 * JD-Core Version:    0.7.0.1
 */