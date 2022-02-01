package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dk
  extends a
{
  public long dFt;
  public long dHR;
  private String dOn = "";
  public long dRP;
  private long dSe;
  private String dSf = "";
  private String dSg = "";
  
  public final String PR()
  {
    AppMethodBeat.i(184769);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dOn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSg);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(184769);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(184770);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomId:").append(this.dOn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.dFt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgType:").append(this.dRP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dHR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exit:").append(this.dSe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("todoid:").append(this.dSf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appusername:").append(this.dSg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184770);
    return localObject;
  }
  
  public final dk Rc()
  {
    this.dSe = 2L;
    return this;
  }
  
  public final int getId()
  {
    return 19443;
  }
  
  public final dk lo(String paramString)
  {
    AppMethodBeat.i(184767);
    this.dOn = t("roomId", paramString, true);
    AppMethodBeat.o(184767);
    return this;
  }
  
  public final dk lp(String paramString)
  {
    AppMethodBeat.i(184768);
    this.dSf = t("todoid", paramString, true);
    AppMethodBeat.o(184768);
    return this;
  }
  
  public final dk lq(String paramString)
  {
    AppMethodBeat.i(197012);
    this.dSg = t("appusername", paramString, true);
    AppMethodBeat.o(197012);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dk
 * JD-Core Version:    0.7.0.1
 */