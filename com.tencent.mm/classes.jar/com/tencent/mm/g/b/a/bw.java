package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bw
  extends a
{
  public long dHG;
  public long dKc;
  public long dPY;
  private String dQn = "";
  private long dQo;
  private String dQp = "";
  private String dQq = "";
  
  public final String PV()
  {
    AppMethodBeat.i(184769);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQq);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(184769);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(184770);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomId:").append(this.dQn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.dHG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgType:").append(this.dPY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dKc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exit:").append(this.dQo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("todoid:").append(this.dQp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appusername:").append(this.dQq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184770);
    return localObject;
  }
  
  public final bw QA()
  {
    this.dQo = 2L;
    return this;
  }
  
  public final int getId()
  {
    return 19443;
  }
  
  public final bw iA(String paramString)
  {
    AppMethodBeat.i(196558);
    this.dQq = t("appusername", paramString, true);
    AppMethodBeat.o(196558);
    return this;
  }
  
  public final bw iy(String paramString)
  {
    AppMethodBeat.i(184767);
    this.dQn = t("roomId", paramString, true);
    AppMethodBeat.o(184767);
    return this;
  }
  
  public final bw iz(String paramString)
  {
    AppMethodBeat.i(184768);
    this.dQp = t("todoid", paramString, true);
    AppMethodBeat.o(184768);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bw
 * JD-Core Version:    0.7.0.1
 */