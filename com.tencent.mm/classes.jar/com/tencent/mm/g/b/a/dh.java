package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dh
  extends a
{
  public long dQX;
  private String dRJ = "";
  public long egM;
  public long egN;
  
  public final String RC()
  {
    AppMethodBeat.i(218186);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egN);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(218186);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(218187);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.dRJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dQX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errortype:").append(this.egM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pageid:").append(this.egN);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(218187);
    return localObject;
  }
  
  public final int getId()
  {
    return 19818;
  }
  
  public final dh mO(String paramString)
  {
    AppMethodBeat.i(218185);
    this.dRJ = t("sessionid", paramString, true);
    AppMethodBeat.o(218185);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dh
 * JD-Core Version:    0.7.0.1
 */