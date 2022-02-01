package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class do
  extends a
{
  private String dQt = "";
  private String egI = "";
  public long egJ = 0L;
  public long egK = 0L;
  public long egL = 0L;
  public long egM = 0L;
  public long egN = 0L;
  public long egO = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(149920);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egO);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(149920);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(149921);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.dQt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("userName:").append(this.egI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("succeedStatus:").append(this.egJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("userStatus:").append(this.egK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showSucceedMethod:").append(this.egL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickSucceedAction:").append(this.egM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("watchMessageRecord:").append(this.egN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sendMessageStatus:").append(this.egO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149921);
    return localObject;
  }
  
  public final int getId()
  {
    return 15855;
  }
  
  public final do mU(String paramString)
  {
    AppMethodBeat.i(149918);
    this.dQt = t("sessionid", paramString, true);
    AppMethodBeat.o(149918);
    return this;
  }
  
  public final do mV(String paramString)
  {
    AppMethodBeat.i(149919);
    this.egI = t("userName", paramString, true);
    AppMethodBeat.o(149919);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.do
 * JD-Core Version:    0.7.0.1
 */