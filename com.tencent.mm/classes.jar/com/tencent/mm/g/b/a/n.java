package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class n
  extends a
{
  public long dFf;
  private String dHE = "";
  public long dHG = 0L;
  public long dHJ;
  public long dHK = 0L;
  public String dHL = "";
  public String dHM = "";
  public long dHN = 0L;
  public String dHO = "";
  public String dHP = "";
  
  public final String PV()
  {
    AppMethodBeat.i(184765);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHP);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(184765);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(184766);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomusrname:").append(this.dHE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dFf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topCount:").append(this.dHJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("usedCount:").append(this.dHK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.dHG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.dHL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appname:").append(this.dHM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isTop:").append(this.dHN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topAppList:").append(this.dHO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("usedAppList:").append(this.dHP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184766);
    return localObject;
  }
  
  public final n fV(String paramString)
  {
    AppMethodBeat.i(184764);
    this.dHE = t("roomusrname", paramString, true);
    AppMethodBeat.o(184764);
    return this;
  }
  
  public final int getId()
  {
    return 19436;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.n
 * JD-Core Version:    0.7.0.1
 */