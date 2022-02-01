package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nl
  extends a
{
  public long eMl = 0L;
  public long eMp = 0L;
  public long ejW = 0L;
  private String enR = "";
  public long fgF = 0L;
  
  public final nl AA(String paramString)
  {
    AppMethodBeat.i(76370);
    this.enR = x("appid", paramString, true);
    AppMethodBeat.o(76370);
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(76371);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ejW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMl);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(76371);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(76372);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.ejW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.enR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timecost:").append(this.eMp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("drawStrategy:").append(this.fgF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasInitData:").append(this.eMl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(76372);
    return localObject;
  }
  
  public final int getId()
  {
    return 15841;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.nl
 * JD-Core Version:    0.7.0.1
 */