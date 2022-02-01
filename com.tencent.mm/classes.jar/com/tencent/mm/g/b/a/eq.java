package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eq
  extends a
{
  public long ein;
  public int eio;
  public int eip;
  public int eiq;
  
  public final String RD()
  {
    AppMethodBeat.i(19866);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ein);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eio);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eip);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiq);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(19866);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(19867);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("msgId:").append(this.ein);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("selectLen:").append(this.eio);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("totalLen:").append(this.eip);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clipLen:").append(this.eiq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(19867);
    return localObject;
  }
  
  public final int getId()
  {
    return 18617;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.eq
 * JD-Core Version:    0.7.0.1
 */