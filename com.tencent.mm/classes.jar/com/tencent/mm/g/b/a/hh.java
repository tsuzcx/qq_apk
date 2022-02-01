package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hh
  extends a
{
  public long eLA = 0L;
  public long eLy;
  public long eLz;
  public long ejW;
  
  public final String abV()
  {
    AppMethodBeat.i(88783);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ejW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLA);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(88783);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(88784);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.ejW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgid:").append(this.eLy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgType:").append(this.eLz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appMsgType:").append(this.eLA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(88784);
    return localObject;
  }
  
  public final int getId()
  {
    return 18754;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hh
 * JD-Core Version:    0.7.0.1
 */