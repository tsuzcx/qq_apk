package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jz
  extends a
{
  public int gMj = -1;
  public int giX;
  public String gks = "";
  
  public final String agH()
  {
    AppMethodBeat.i(196973);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gks);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMj);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(196973);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(196975);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Publishid:").append(this.gks);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.giX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstallMiaoJian:").append(this.gMj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(196975);
    return localObject;
  }
  
  public final int getId()
  {
    return 22624;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.jz
 * JD-Core Version:    0.7.0.1
 */