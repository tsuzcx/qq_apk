package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gv
  extends a
{
  public int dJy = 0;
  private String eje;
  private String ejf;
  private String ejg;
  public int ejh;
  
  public final String PV()
  {
    AppMethodBeat.i(184124);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dJy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eje);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejh);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(184124);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(184125);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.dJy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("oldaccountusername:").append(this.eje);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("newaccountusername:").append(this.ejf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("friendusername:").append(this.ejg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errortype:").append(this.ejh);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184125);
    return localObject;
  }
  
  public final int getId()
  {
    return 19376;
  }
  
  public final gv mA(String paramString)
  {
    AppMethodBeat.i(184123);
    this.ejg = t("friendusername", paramString, true);
    AppMethodBeat.o(184123);
    return this;
  }
  
  public final gv my(String paramString)
  {
    AppMethodBeat.i(184121);
    this.eje = t("oldaccountusername", paramString, true);
    AppMethodBeat.o(184121);
    return this;
  }
  
  public final gv mz(String paramString)
  {
    AppMethodBeat.i(184122);
    this.ejf = t("newaccountusername", paramString, true);
    AppMethodBeat.o(184122);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gv
 * JD-Core Version:    0.7.0.1
 */