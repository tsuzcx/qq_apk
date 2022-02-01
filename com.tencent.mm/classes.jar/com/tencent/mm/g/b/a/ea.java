package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ea
  extends a
{
  public long dPH;
  public long ehl;
  public long ehm;
  public long ehn = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(88783);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dPH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehn);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(88783);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(88784);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.dPH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgid:").append(this.ehl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgType:").append(this.ehm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appMsgType:").append(this.ehn);
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
 * Qualified Name:     com.tencent.mm.g.b.a.ea
 * JD-Core Version:    0.7.0.1
 */