package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gz
  extends a
{
  public String eLk = "";
  public int eLl;
  public int enq;
  public String etW = "";
  
  public final String abV()
  {
    AppMethodBeat.i(231494);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.enq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLl);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(231494);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(231495);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.enq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.etW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatUsername:").append(this.eLk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MessageCount:").append(this.eLl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(231495);
    return localObject;
  }
  
  public final int getId()
  {
    return 19963;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gz
 * JD-Core Version:    0.7.0.1
 */