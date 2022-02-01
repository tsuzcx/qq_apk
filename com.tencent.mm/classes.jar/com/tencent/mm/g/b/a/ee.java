package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ee
  extends a
{
  public int eCB;
  public int eCC;
  public String ejo = "";
  public String ejr = "";
  
  public final String abV()
  {
    AppMethodBeat.i(241581);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ejo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejr);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(241581);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(241582);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("TipsId:").append(this.ejo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderSyncScene:").append(this.eCB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CmdId:").append(this.eCC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CtrlType:").append(this.ejr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(241582);
    return localObject;
  }
  
  public final int getId()
  {
    return 21611;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ee
 * JD-Core Version:    0.7.0.1
 */