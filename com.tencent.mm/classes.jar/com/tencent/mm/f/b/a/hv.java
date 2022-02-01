package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hv
  extends a
{
  public long gGS;
  public long gGT;
  public long geB;
  private String ggA = "";
  
  public final String agH()
  {
    AppMethodBeat.i(186729);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gGS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gGT);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(186729);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(186733);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.ggA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.geB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errortype:").append(this.gGS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pageid:").append(this.gGT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(186733);
    return localObject;
  }
  
  public final int getId()
  {
    return 19818;
  }
  
  public final hv xd(String paramString)
  {
    AppMethodBeat.i(186727);
    this.ggA = z("sessionid", paramString, true);
    AppMethodBeat.o(186727);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.hv
 * JD-Core Version:    0.7.0.1
 */