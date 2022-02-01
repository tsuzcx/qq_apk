package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jc
  extends a
{
  public long gKK = 0L;
  private String gKL = "";
  public long gef = 0L;
  
  public final jc Aj(String paramString)
  {
    AppMethodBeat.i(163176);
    this.gKL = z("AppList", paramString, true);
    AppMethodBeat.o(163176);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(163177);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gef);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKL);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(163177);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(163178);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.gef);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsRedDot:").append(this.gKK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppList:").append(this.gKL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(163178);
    return localObject;
  }
  
  public final int getId()
  {
    return 19194;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.jc
 * JD-Core Version:    0.7.0.1
 */