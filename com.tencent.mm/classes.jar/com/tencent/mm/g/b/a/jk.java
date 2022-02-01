package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jk
  extends a
{
  public String dTT = "";
  public long eBP = 0L;
  public long ejD = 0L;
  private String ejP = "";
  
  public final String RC()
  {
    AppMethodBeat.i(116494);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejD);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(116494);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(116495);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appid:").append(this.dTT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.ejP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timecost:").append(this.eBP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasInitData:").append(this.ejD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116495);
    return localObject;
  }
  
  public final int getId()
  {
    return 15831;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jk
 * JD-Core Version:    0.7.0.1
 */