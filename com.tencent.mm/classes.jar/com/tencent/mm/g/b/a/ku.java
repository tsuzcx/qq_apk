package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ku
  extends a
{
  private String eXq = "";
  public long eXr = 0L;
  private long eXs = 0L;
  private long eXt = 0L;
  private String eXu = "";
  public long eXv = 0L;
  private String eXw = "";
  public long erW = 0L;
  public long evl = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(149935);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXw);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(149935);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(149936);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BiilNo:").append(this.eXq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("failReason:").append(this.eXr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("playerErrCode:").append(this.eXs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.evl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("retCode:").append(this.eXt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("content:").append(this.eXu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("amount:").append(this.eXv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("packId:").append(this.eXw);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149936);
    return localObject;
  }
  
  public final int getId()
  {
    return 14404;
  }
  
  public final ku ym(String paramString)
  {
    AppMethodBeat.i(149932);
    this.eXq = x("BiilNo", paramString, true);
    AppMethodBeat.o(149932);
    return this;
  }
  
  public final ku yn(String paramString)
  {
    AppMethodBeat.i(149933);
    this.eXu = x("content", paramString, true);
    AppMethodBeat.o(149933);
    return this;
  }
  
  public final ku yo(String paramString)
  {
    AppMethodBeat.i(149934);
    this.eXw = x("packId", paramString, true);
    AppMethodBeat.o(149934);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ku
 * JD-Core Version:    0.7.0.1
 */