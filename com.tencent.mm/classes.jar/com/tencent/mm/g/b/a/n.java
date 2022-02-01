package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class n
  extends a
{
  public String dTC = "";
  public String dTD = "";
  public int dTE = 0;
  
  public final String RC()
  {
    AppMethodBeat.i(121744);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTE);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(121744);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(121745);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatroomName:").append(this.dTC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptScore:").append(this.dTD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptFlag:").append(this.dTE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121745);
    return localObject;
  }
  
  public final int getId()
  {
    return 15459;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.n
 * JD-Core Version:    0.7.0.1
 */