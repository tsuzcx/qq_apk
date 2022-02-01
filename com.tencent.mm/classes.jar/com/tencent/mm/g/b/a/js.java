package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class js
  extends a
{
  public int dUD = 0;
  private String eCk;
  private String eCl;
  private String eCm;
  public int eCn;
  
  public final String RD()
  {
    AppMethodBeat.i(184124);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dUD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCn);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(184124);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(184125);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.dUD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("oldaccountusername:").append(this.eCk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("newaccountusername:").append(this.eCl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("friendusername:").append(this.eCm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errortype:").append(this.eCn);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184125);
    return localObject;
  }
  
  public final int getId()
  {
    return 19376;
  }
  
  public final js sk(String paramString)
  {
    AppMethodBeat.i(184121);
    this.eCk = t("oldaccountusername", paramString, true);
    AppMethodBeat.o(184121);
    return this;
  }
  
  public final js sl(String paramString)
  {
    AppMethodBeat.i(184122);
    this.eCl = t("newaccountusername", paramString, true);
    AppMethodBeat.o(184122);
    return this;
  }
  
  public final js sm(String paramString)
  {
    AppMethodBeat.i(184123);
    this.eCm = t("friendusername", paramString, true);
    AppMethodBeat.o(184123);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.js
 * JD-Core Version:    0.7.0.1
 */