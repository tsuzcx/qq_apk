package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bd
  extends a
{
  private String dFJ;
  public long dFf;
  public long dOw;
  public long dOx;
  
  public final String PV()
  {
    AppMethodBeat.i(190176);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOx);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(190176);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(190177);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.dFJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dFf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errortype:").append(this.dOw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pageid:").append(this.dOx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(190177);
    return localObject;
  }
  
  public final int getId()
  {
    return 19818;
  }
  
  public final bd hY(String paramString)
  {
    AppMethodBeat.i(190175);
    this.dFJ = t("sessionid", paramString, true);
    AppMethodBeat.o(190175);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bd
 * JD-Core Version:    0.7.0.1
 */