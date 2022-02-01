package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gm
  extends a
{
  public String dHL = "";
  private String dQK = "";
  public long dQz = 0L;
  public long eha = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(116494);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eha);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQz);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(116494);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(116495);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appid:").append(this.dHL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.dQK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timecost:").append(this.eha);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasInitData:").append(this.dQz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116495);
    return localObject;
  }
  
  public final int getId()
  {
    return 15831;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gm
 * JD-Core Version:    0.7.0.1
 */