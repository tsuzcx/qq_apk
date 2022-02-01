package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ji
  extends a
{
  public String dSD = "";
  public long eAg = 0L;
  public long ehT = 0L;
  private String eif = "";
  
  public final String RD()
  {
    AppMethodBeat.i(116494);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eif);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eAg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehT);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(116494);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(116495);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appid:").append(this.dSD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.eif);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timecost:").append(this.eAg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasInitData:").append(this.ehT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116495);
    return localObject;
  }
  
  public final int getId()
  {
    return 15831;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ji
 * JD-Core Version:    0.7.0.1
 */