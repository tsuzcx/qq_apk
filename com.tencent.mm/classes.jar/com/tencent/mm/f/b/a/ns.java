package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ns
  extends a
{
  public long had = 0L;
  public long hae = 0L;
  public String haf = "";
  public String hag = "";
  public String hah = "";
  public String hai = "";
  public String haj = "";
  
  public final String agH()
  {
    AppMethodBeat.i(91243);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.had);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hae);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.haf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hah);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hai);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.haj);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(91243);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(91244);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PayType:").append(this.had);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CallbackType:").append(this.hae);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceH5Url:").append(this.haf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceAppUsername:").append(this.hag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceAppPath:").append(this.hah);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TargetAppUsername:").append(this.hai);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TargetAppPath:").append(this.haj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91244);
    return localObject;
  }
  
  public final int getId()
  {
    return 16310;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ns
 * JD-Core Version:    0.7.0.1
 */