package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bc
  extends a
{
  public int giX = 0;
  public int glH = 0;
  public int glI = 0;
  
  public final String agH()
  {
    AppMethodBeat.i(253249);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.glH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giX);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(253249);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(253250);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExptAppId:").append(this.glH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptSeq:").append(this.glI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.giX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(253250);
    return localObject;
  }
  
  public final int getId()
  {
    return 19988;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.bc
 * JD-Core Version:    0.7.0.1
 */