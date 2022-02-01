package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qi
  extends a
{
  public long gMa = 0L;
  public long gMe = 0L;
  public String giT = "";
  private String gym = "";
  
  public final String agH()
  {
    AppMethodBeat.i(116494);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.giT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gym);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMa);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(116494);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(116495);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appid:").append(this.giT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.gym);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timecost:").append(this.gMe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasInitData:").append(this.gMa);
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
 * Qualified Name:     com.tencent.mm.f.b.a.qi
 * JD-Core Version:    0.7.0.1
 */