package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class uf
  extends a
{
  public long ila = 0L;
  private String ipx = "";
  public long jFQ = 0L;
  public long jbM = 0L;
  public long jbP = 0L;
  
  public final uf Ac(String paramString)
  {
    AppMethodBeat.i(76370);
    this.ipx = F("appid", paramString, true);
    AppMethodBeat.o(76370);
    return this;
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(76371);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ila);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbM);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(76371);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(76372);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.ila);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.ipx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timecost:").append(this.jbP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("drawStrategy:").append(this.jFQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasInitData:").append(this.jbM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(76372);
    return localObject;
  }
  
  public final int getId()
  {
    return 15841;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.uf
 * JD-Core Version:    0.7.0.1
 */