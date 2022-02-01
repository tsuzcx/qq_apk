package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jl
  extends a
{
  public long gKZ = 0L;
  private String gLa = "";
  
  public final jl At(String paramString)
  {
    AppMethodBeat.i(162225);
    this.gLa = z("emoticonMd5", paramString, true);
    AppMethodBeat.o(162225);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(149928);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gKZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLa);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(149928);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(149929);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SendScene:").append(this.gKZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("emoticonMd5:").append(this.gLa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149929);
    return localObject;
  }
  
  public final int getId()
  {
    return 16868;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.jl
 * JD-Core Version:    0.7.0.1
 */