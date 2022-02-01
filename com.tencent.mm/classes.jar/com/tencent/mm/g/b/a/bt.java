package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bt
  extends a
{
  public long dFf;
  public long dPX;
  public long dPY;
  public long dPZ = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(88783);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPZ);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(88783);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(88784);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.dFf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgid:").append(this.dPX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgType:").append(this.dPY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appMsgType:").append(this.dPZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(88784);
    return localObject;
  }
  
  public final int getId()
  {
    return 18754;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bt
 * JD-Core Version:    0.7.0.1
 */