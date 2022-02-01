package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hp
  extends a
{
  public String eFc = "";
  public long eMc;
  public long eMf;
  public long eMg;
  public long enM;
  public String enR = "";
  public String enS = "";
  
  public final String abV()
  {
    AppMethodBeat.i(184778);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eFc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMc);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(184778);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(184779);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.eFc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.enM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.enR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appname:").append(this.enS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("todo:").append(this.eMg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openHelp:").append(this.eMf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exit:").append(this.eMc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184779);
    return localObject;
  }
  
  public final int getId()
  {
    return 19440;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hp
 * JD-Core Version:    0.7.0.1
 */