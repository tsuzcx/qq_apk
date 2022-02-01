package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ec
  extends a
{
  public long dQX;
  public long eiV;
  public long eiW;
  public long eiX = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(88783);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiX);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(88783);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(88784);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.dQX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgid:").append(this.eiV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgType:").append(this.eiW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appMsgType:").append(this.eiX);
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
 * Qualified Name:     com.tencent.mm.g.b.a.ec
 * JD-Core Version:    0.7.0.1
 */