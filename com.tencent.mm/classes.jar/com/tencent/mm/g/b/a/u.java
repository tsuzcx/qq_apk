package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class u
  extends a
{
  public long eli;
  public long elj;
  public long elk;
  public String ell = "";
  public long elm;
  public long eln;
  public long elo;
  public String elp = "";
  public String elq = "";
  public long elr;
  public String els = "";
  
  public final String abV()
  {
    AppMethodBeat.i(231469);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eli);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ell);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eln);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.els);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(231469);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(231470);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("actioncode:").append(this.eli);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("selectfriendnum:").append(this.elj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("modifiedsucfriendnum:").append(this.elk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("modifiedsucfriendlist:").append(this.ell);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("beforsocialblackfriendnum:").append(this.elm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("aftersocialblackfriendnum:").append(this.eln);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionnum:").append(this.elo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("selecttagname:").append(this.elp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("selecttagid:").append(this.elq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("staytime:").append(this.elr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.els);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(231470);
    return localObject;
  }
  
  public final int getId()
  {
    return 19824;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.u
 * JD-Core Version:    0.7.0.1
 */