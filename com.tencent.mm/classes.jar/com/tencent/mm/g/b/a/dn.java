package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dn
  extends a
{
  public long dFt;
  public String dFy = "";
  public String dFz = "";
  public String dNK = "";
  public long dSe;
  public long dSh;
  public long dSi;
  
  public final String PR()
  {
    AppMethodBeat.i(184778);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dNK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSe);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(184778);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(184779);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.dNK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.dFt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.dFy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appname:").append(this.dFz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("todo:").append(this.dSi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openHelp:").append(this.dSh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exit:").append(this.dSe);
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
 * Qualified Name:     com.tencent.mm.g.b.a.dn
 * JD-Core Version:    0.7.0.1
 */