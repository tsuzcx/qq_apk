package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gx
  extends a
{
  public long eLg = 0L;
  private String eLh = "";
  public long ejA = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(163177);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ejA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLh);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(163177);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(163178);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.ejA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsRedDot:").append(this.eLg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppList:").append(this.eLh);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(163178);
    return localObject;
  }
  
  public final int getId()
  {
    return 19194;
  }
  
  public final gx uM(String paramString)
  {
    AppMethodBeat.i(163176);
    this.eLh = x("AppList", paramString, true);
    AppMethodBeat.o(163176);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gx
 * JD-Core Version:    0.7.0.1
 */