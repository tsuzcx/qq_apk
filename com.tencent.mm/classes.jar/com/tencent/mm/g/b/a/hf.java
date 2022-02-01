package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hf
  extends a
{
  public long ets = 0L;
  public long ett = 0L;
  public String etu = "";
  public String etv = "";
  public String etw = "";
  public String etx = "";
  public String ety = "";
  
  public final String RC()
  {
    AppMethodBeat.i(91243);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ets);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ett);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ety);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(91243);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(91244);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PayType:").append(this.ets);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CallbackType:").append(this.ett);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceH5Url:").append(this.etu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceAppUsername:").append(this.etv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceAppPath:").append(this.etw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TargetAppUsername:").append(this.etx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TargetAppPath:").append(this.ety);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91244);
    return localObject;
  }
  
  public final int getId()
  {
    return 16310;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hf
 * JD-Core Version:    0.7.0.1
 */