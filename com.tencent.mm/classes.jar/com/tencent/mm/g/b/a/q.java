package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class q
  extends a
{
  public long dQX;
  private String dTM = "";
  public long dTO = 0L;
  public long dTR;
  public long dTS = 0L;
  public String dTT = "";
  public String dTU = "";
  public long dTV = 0L;
  public String dTW = "";
  public String dTX = "";
  
  public final String RC()
  {
    AppMethodBeat.i(184765);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTX);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(184765);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(184766);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomusrname:").append(this.dTM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dQX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topCount:").append(this.dTR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("usedCount:").append(this.dTS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.dTO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.dTT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appname:").append(this.dTU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isTop:").append(this.dTV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topAppList:").append(this.dTW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("usedAppList:").append(this.dTX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184766);
    return localObject;
  }
  
  public final q gT(String paramString)
  {
    AppMethodBeat.i(184764);
    this.dTM = t("roomusrname", paramString, true);
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