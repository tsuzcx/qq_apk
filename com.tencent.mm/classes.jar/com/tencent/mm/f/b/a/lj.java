package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lj
  extends a
{
  public long gQB = 0L;
  public String gQF = "";
  public long gQO = 0L;
  public long gQP = 0L;
  public String ggg = "";
  
  public final String agH()
  {
    AppMethodBeat.i(246652);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQP);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(246652);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(246653);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.ggg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.gQB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.gQF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DisplayCount:").append(this.gQO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HideCount:").append(this.gQP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(246653);
    return localObject;
  }
  
  public final int getId()
  {
    return 19964;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.b.a.lj
 * JD-Core Version:    0.7.0.1
 */