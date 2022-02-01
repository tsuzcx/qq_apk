package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fd
  extends a
{
  private String dFe = "";
  public long dVJ = 0L;
  private String dWI = "";
  public long dWJ = 0L;
  private String dWK = "";
  public long dWL = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(94854);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVJ);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(94854);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(94855);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterObjectId:").append(this.dWI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeUinCount:").append(this.dWJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeUinList:").append(this.dWK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewVideoCount:").append(this.dWL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InteractiveUserCount:").append(this.dVJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94855);
    return localObject;
  }
  
  public final int getId()
  {
    return 16843;
  }
  
  public final fd mI(String paramString)
  {
    AppMethodBeat.i(94851);
    this.dWI = t("EnterObjectId", paramString, true);
    AppMethodBeat.o(94851);
    return this;
  }
  
  public final fd mJ(String paramString)
  {
    AppMethodBeat.i(94852);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(94852);
    return this;
  }
  
  public final fd mK(String paramString)
  {
    AppMethodBeat.i(94853);
    this.dWK = t("ExposeUinList", paramString, true);
    AppMethodBeat.o(94853);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fd
 * JD-Core Version:    0.7.0.1
 */