package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ia
  extends a
{
  public long eMJ;
  public int eMK;
  public int eML;
  public int eMM;
  
  public final String abV()
  {
    AppMethodBeat.i(19866);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eMJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eML);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMM);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(19866);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(19867);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("msgId:").append(this.eMJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("selectLen:").append(this.eMK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("totalLen:").append(this.eML);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clipLen:").append(this.eMM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(19867);
    return localObject;
  }
  
  public final int getId()
  {
    return 18617;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ia
 * JD-Core Version:    0.7.0.1
 */