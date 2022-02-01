package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ju
  extends a
{
  public int dVT = 0;
  private String eDT = "";
  private String eDU = "";
  private String eDV = "";
  public int eDW;
  
  public final String RC()
  {
    AppMethodBeat.i(184124);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dVT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDW);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(184124);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(184125);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.dVT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("oldaccountusername:").append(this.eDT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("newaccountusername:").append(this.eDU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("friendusername:").append(this.eDV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errortype:").append(this.eDW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184125);
    return localObject;
  }
  
  public final int getId()
  {
    return 19376;
  }
  
  public final ju sF(String paramString)
  {
    AppMethodBeat.i(184121);
    this.eDT = t("oldaccountusername", paramString, true);
    AppMethodBeat.o(184121);
    return this;
  }
  
  public final ju sG(String paramString)
  {
    AppMethodBeat.i(184122);
    this.eDU = t("newaccountusername", paramString, true);
    AppMethodBeat.o(184122);
    return this;
  }
  
  public final ju sH(String paramString)
  {
    AppMethodBeat.i(184123);
    this.eDV = t("friendusername", paramString, true);
    AppMethodBeat.o(184123);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ju
 * JD-Core Version:    0.7.0.1
 */