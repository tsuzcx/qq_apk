package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class n
  extends a
{
  public long dCS;
  public long dFA = 0L;
  public String dFB = "";
  public String dFC = "";
  private String dFr = "";
  public long dFt = 0L;
  public long dFw;
  public long dFx = 0L;
  public String dFy = "";
  public String dFz = "";
  
  public final String PR()
  {
    AppMethodBeat.i(184765);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dCS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFC);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(184765);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(184766);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomusrname:").append(this.dFr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dCS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topCount:").append(this.dFw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("usedCount:").append(this.dFx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.dFt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.dFy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appname:").append(this.dFz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isTop:").append(this.dFA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topAppList:").append(this.dFB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("usedAppList:").append(this.dFC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184766);
    return localObject;
  }
  
  public final n fL(String paramString)
  {
    AppMethodBeat.i(184764);
    this.dFr = t("roomusrname", paramString, true);
    AppMethodBeat.o(184764);
    return this;
  }
  
  public final int getId()
  {
    return 19436;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.n
 * JD-Core Version:    0.7.0.1
 */