package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ql
  extends a
{
  public long gMa = 0L;
  public long gMe = 0L;
  public long geB = 0L;
  private String giT = "";
  public long hjR = 0L;
  
  public final ql Hm(String paramString)
  {
    AppMethodBeat.i(76370);
    this.giT = z("appid", paramString, true);
    AppMethodBeat.o(76370);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(76371);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.geB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMa);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(76371);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(76372);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.geB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.giT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timecost:").append(this.gMe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("drawStrategy:").append(this.hjR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasInitData:").append(this.gMa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(76372);
    return localObject;
  }
  
  public final int getId()
  {
    return 15841;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ql
 * JD-Core Version:    0.7.0.1
 */