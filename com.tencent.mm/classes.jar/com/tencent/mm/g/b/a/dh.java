package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dh
  extends a
{
  public long dCS;
  public long dRO;
  public long dRP;
  public long dRQ = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(88783);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dCS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRQ);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(88783);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(88784);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.dCS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgid:").append(this.dRO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgType:").append(this.dRP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appMsgType:").append(this.dRQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(88784);
    return localObject;
  }
  
  public final int getId()
  {
    return 18754;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dh
 * JD-Core Version:    0.7.0.1
 */