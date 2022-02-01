package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dx
  extends a
{
  public long ehi = 0L;
  public String ehj = "";
  public long ehk = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(149924);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ehi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehk);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(149924);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(149925);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SendScene:").append(this.ehi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("emoticonMd5:").append(this.ehj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasTxt:").append(this.ehk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149925);
    return localObject;
  }
  
  public final int getId()
  {
    return 16872;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dx
 * JD-Core Version:    0.7.0.1
 */