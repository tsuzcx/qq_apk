package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class q
  extends a
{
  public long dPH;
  public long dSB;
  public long dSC = 0L;
  public String dSD = "";
  public String dSE = "";
  public long dSF = 0L;
  public String dSG = "";
  public String dSH = "";
  private String dSw = "";
  public long dSy = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(184765);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSH);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(184765);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(184766);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomusrname:").append(this.dSw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dPH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topCount:").append(this.dSB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("usedCount:").append(this.dSC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.dSy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.dSD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appname:").append(this.dSE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isTop:").append(this.dSF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topAppList:").append(this.dSG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("usedAppList:").append(this.dSH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184766);
    return localObject;
  }
  
  public final q gN(String paramString)
  {
    AppMethodBeat.i(184764);
    this.dSw = t("roomusrname", paramString, true);
    AppMethodBeat.o(184764);
    return this;
  }
  
  public final int getId()
  {
    return 19436;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.q
 * JD-Core Version:    0.7.0.1
 */