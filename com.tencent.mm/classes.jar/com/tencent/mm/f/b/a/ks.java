package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ks
  extends a
{
  private long gOW;
  private String ggA = "";
  
  public final ks BH(String paramString)
  {
    AppMethodBeat.i(224127);
    this.ggA = z("sessionid", paramString, true);
    AppMethodBeat.o(224127);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(224130);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOW);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(224130);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(224131);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.ggA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exposeType:").append(this.gOW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(224131);
    return localObject;
  }
  
  public final int getId()
  {
    return 21183;
  }
  
  public final ks vk(long paramLong)
  {
    this.gOW = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ks
 * JD-Core Version:    0.7.0.1
 */