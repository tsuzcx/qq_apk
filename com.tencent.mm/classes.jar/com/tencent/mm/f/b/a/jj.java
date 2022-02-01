package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jj
  extends a
{
  public long gKZ = 0L;
  private String gLa = "";
  public long gLb = 0L;
  
  public final jj As(String paramString)
  {
    AppMethodBeat.i(197499);
    this.gLa = z("emoticonMd5", paramString, true);
    AppMethodBeat.o(197499);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(149924);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gKZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLb);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(149924);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(149925);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SendScene:").append(this.gKZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("emoticonMd5:").append(this.gLa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasTxt:").append(this.gLb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149925);
    return localObject;
  }
  
  public final int getId()
  {
    return 16872;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.jj
 * JD-Core Version:    0.7.0.1
 */