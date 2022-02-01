package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gc
  extends a
{
  private String dSb = "";
  private String emY = "";
  public long emZ = 0L;
  public long ema = 0L;
  private String ena = "";
  public long enb = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(94854);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.emY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ena);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ema);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(94854);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(94855);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterObjectId:").append(this.emY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeUinCount:").append(this.emZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeUinList:").append(this.ena);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewVideoCount:").append(this.enb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InteractiveUserCount:").append(this.ema);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94855);
    return localObject;
  }
  
  public final int getId()
  {
    return 16843;
  }
  
  public final gc oV(String paramString)
  {
    AppMethodBeat.i(94851);
    this.emY = t("EnterObjectId", paramString, true);
    AppMethodBeat.o(94851);
    return this;
  }
  
  public final gc oW(String paramString)
  {
    AppMethodBeat.i(94852);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(94852);
    return this;
  }
  
  public final gc oX(String paramString)
  {
    AppMethodBeat.i(94853);
    this.ena = t("ExposeUinList", paramString, true);
    AppMethodBeat.o(94853);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gc
 * JD-Core Version:    0.7.0.1
 */