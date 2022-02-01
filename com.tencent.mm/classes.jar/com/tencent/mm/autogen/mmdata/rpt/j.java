package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class j
  extends a
{
  public long ikr = 0L;
  public String iks = "";
  public long ikt = 0L;
  public long iku;
  public long ikv = 0L;
  public long ikw = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(368630);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ikr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iks);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iku);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikw);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368630);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368639);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("index:").append(this.ikr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("usrType:").append(this.iks);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isTop:").append(this.ikt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lastTime:").append(this.iku);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sil:").append(this.ikv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("unread:").append(this.ikw);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368639);
    return localObject;
  }
  
  public final int getId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.j
 * JD-Core Version:    0.7.0.1
 */