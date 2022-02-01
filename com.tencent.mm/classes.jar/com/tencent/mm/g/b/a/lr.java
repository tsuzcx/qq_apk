package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lr
  extends a
{
  private String eWa = "";
  public long eZp = 0L;
  public long eZr = 0L;
  public long eZs = 0L;
  public long eZt = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(43481);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eZr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eZs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eZt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eZp);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(43481);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43482);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("DeleteReason:").append(this.eZr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Appid:").append(this.eWa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DebugType:").append(this.eZs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeleteCount:").append(this.eZt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AbtestStatus:").append(this.eZp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43482);
    return localObject;
  }
  
  public final int getId()
  {
    return 15402;
  }
  
  public final lr yZ(String paramString)
  {
    AppMethodBeat.i(43480);
    this.eWa = x("Appid", paramString, true);
    AppMethodBeat.o(43480);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.lr
 * JD-Core Version:    0.7.0.1
 */