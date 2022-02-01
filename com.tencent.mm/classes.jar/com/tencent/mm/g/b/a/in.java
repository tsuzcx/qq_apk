package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class in
  extends a
{
  public int dHA = 0;
  private String eli;
  private String elj;
  private String elk;
  public int ell;
  
  public final String PR()
  {
    AppMethodBeat.i(184124);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eli);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ell);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(184124);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(184125);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.dHA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("oldaccountusername:").append(this.eli);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("newaccountusername:").append(this.elj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("friendusername:").append(this.elk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errortype:").append(this.ell);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184125);
    return localObject;
  }
  
  public final int getId()
  {
    return 19376;
  }
  
  public final in pE(String paramString)
  {
    AppMethodBeat.i(184121);
    this.eli = t("oldaccountusername", paramString, true);
    AppMethodBeat.o(184121);
    return this;
  }
  
  public final in pF(String paramString)
  {
    AppMethodBeat.i(184122);
    this.elj = t("newaccountusername", paramString, true);
    AppMethodBeat.o(184122);
    return this;
  }
  
  public final in pG(String paramString)
  {
    AppMethodBeat.i(184123);
    this.elk = t("friendusername", paramString, true);
    AppMethodBeat.o(184123);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.in
 * JD-Core Version:    0.7.0.1
 */