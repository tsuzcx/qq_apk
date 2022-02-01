package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kf
  extends a
{
  public String eUe = "";
  public long ejA = 0L;
  public long erW = 0L;
  public long ete = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(149930);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ete);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eUe);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(149930);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(149931);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ejA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Status:").append(this.ete);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransferId:").append(this.eUe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149931);
    return localObject;
  }
  
  public final int getId()
  {
    return 16440;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.kf
 * JD-Core Version:    0.7.0.1
 */