package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ie
  extends a
{
  public String dFy = "";
  public long dSo = 0L;
  private String dSz = "";
  public long ejg = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(116494);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSo);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(116494);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(116495);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appid:").append(this.dFy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.dSz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timecost:").append(this.ejg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasInitData:").append(this.dSo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116495);
    return localObject;
  }
  
  public final int getId()
  {
    return 15831;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ie
 * JD-Core Version:    0.7.0.1
 */