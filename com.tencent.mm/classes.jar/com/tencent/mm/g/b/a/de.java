package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class de
  extends a
{
  public long dRL = 0L;
  public String dRM = "";
  public long dRN = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(149924);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRN);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(149924);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(149925);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SendScene:").append(this.dRL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("emoticonMd5:").append(this.dRM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasTxt:").append(this.dRN);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149925);
    return localObject;
  }
  
  public final int getId()
  {
    return 16872;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.de
 * JD-Core Version:    0.7.0.1
 */