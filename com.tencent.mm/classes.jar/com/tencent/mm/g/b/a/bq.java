package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bq
  extends a
{
  public long dPU = 0L;
  public String dPV = "";
  public long dPW = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(149924);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dPU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPW);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(149924);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(149925);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SendScene:").append(this.dPU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("emoticonMd5:").append(this.dPV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasTxt:").append(this.dPW);
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
 * Qualified Name:     com.tencent.mm.g.b.a.bq
 * JD-Core Version:    0.7.0.1
 */