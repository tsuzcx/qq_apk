package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ej
  extends a
{
  public long dTO;
  public String dTT = "";
  public String dTU = "";
  public String eeu = "";
  public long ejt;
  public long ejw;
  public long ejx;
  
  public final String RC()
  {
    AppMethodBeat.i(184778);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eeu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejt);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(184778);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(184779);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.eeu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.dTO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.dTT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appname:").append(this.dTU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("todo:").append(this.ejx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openHelp:").append(this.ejw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exit:").append(this.ejt);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184779);
    return localObject;
  }
  
  public final int getId()
  {
    return 19440;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ej
 * JD-Core Version:    0.7.0.1
 */