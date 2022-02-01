package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dh
  extends a
{
  public long dPH;
  private String dQt;
  public long efl;
  public long efm;
  
  public final String RD()
  {
    AppMethodBeat.i(219286);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efm);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(219286);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(219287);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.dQt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dPH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errortype:").append(this.efl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pageid:").append(this.efm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(219287);
    return localObject;
  }
  
  public final int getId()
  {
    return 19818;
  }
  
  public final dh mw(String paramString)
  {
    AppMethodBeat.i(219285);
    this.dQt = t("sessionid", paramString, true);
    AppMethodBeat.o(219285);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dh
 * JD-Core Version:    0.7.0.1
 */