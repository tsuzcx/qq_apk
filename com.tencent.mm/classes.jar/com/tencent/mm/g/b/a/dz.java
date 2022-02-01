package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dz
  extends a
{
  public long eiS = 0L;
  public String eiT = "";
  public long eiU = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(149924);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiU);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(149924);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(149925);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SendScene:").append(this.eiS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("emoticonMd5:").append(this.eiT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasTxt:").append(this.eiU);
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
 * Qualified Name:     com.tencent.mm.g.b.a.dz
 * JD-Core Version:    0.7.0.1
 */