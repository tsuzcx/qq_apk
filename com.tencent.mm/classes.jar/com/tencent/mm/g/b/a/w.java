package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class w
  extends a
{
  private String cTF = "";
  public long cTG = 0L;
  public long cTH = 0L;
  public long cTI = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(77591);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cTF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTI);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(77591);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(77592);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionID:").append(this.cTF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionCode:").append(this.cTG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionCodeResult:").append(this.cTH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickAddContact:").append(this.cTI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(77592);
    return localObject;
  }
  
  public final w fr(String paramString)
  {
    AppMethodBeat.i(77590);
    this.cTF = t("sessionID", paramString, true);
    AppMethodBeat.o(77590);
    return this;
  }
  
  public final int getId()
  {
    return 15850;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.w
 * JD-Core Version:    0.7.0.1
 */