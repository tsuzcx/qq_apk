package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ni
  extends a
{
  private String eBQ = "";
  public long eMl = 0L;
  public long eMp = 0L;
  public String enR = "";
  
  public final String abV()
  {
    AppMethodBeat.i(116494);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.enR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMl);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(116494);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(116495);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appid:").append(this.enR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.eBQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timecost:").append(this.eMp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasInitData:").append(this.eMl);
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
 * Qualified Name:     com.tencent.mm.g.b.a.ni
 * JD-Core Version:    0.7.0.1
 */