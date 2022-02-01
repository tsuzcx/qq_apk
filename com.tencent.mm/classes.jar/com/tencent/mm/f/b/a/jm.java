package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jm
  extends a
{
  public long gLc;
  public long gLd = 0L;
  public long geB;
  public long gzn;
  
  public final String agH()
  {
    AppMethodBeat.i(88783);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.geB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLd);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(88783);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(88784);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.geB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgid:").append(this.gLc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgType:").append(this.gzn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appMsgType:").append(this.gLd);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(88784);
    return localObject;
  }
  
  public final int getId()
  {
    return 18754;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.jm
 * JD-Core Version:    0.7.0.1
 */