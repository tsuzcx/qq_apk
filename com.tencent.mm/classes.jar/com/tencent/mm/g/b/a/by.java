package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class by
  extends a
{
  public long dFf;
  public long dHG;
  public long dPY;
  public long dQo;
  private String dQp = "";
  private String dQq = "";
  private String dQr = "";
  public long dQs;
  
  public final String PV()
  {
    AppMethodBeat.i(184776);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQq);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(184776);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(184777);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.dQr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.dHG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exit:").append(this.dQo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgType:").append(this.dPY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dFf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openHelp:").append(this.dQs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("todoid:").append(this.dQp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appusername:").append(this.dQq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184777);
    return localObject;
  }
  
  public final int getId()
  {
    return 19442;
  }
  
  public final by iE(String paramString)
  {
    AppMethodBeat.i(184775);
    this.dQr = t("roomid", paramString, true);
    AppMethodBeat.o(184775);
    return this;
  }
  
  public final by iF(String paramString)
  {
    AppMethodBeat.i(196560);
    this.dQp = t("todoid", paramString, true);
    AppMethodBeat.o(196560);
    return this;
  }
  
  public final by iG(String paramString)
  {
    AppMethodBeat.i(196561);
    this.dQq = t("appusername", paramString, true);
    AppMethodBeat.o(196561);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.by
 * JD-Core Version:    0.7.0.1
 */