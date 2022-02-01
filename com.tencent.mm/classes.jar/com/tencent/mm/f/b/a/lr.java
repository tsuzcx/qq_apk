package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lr
  extends a
{
  private long gNh = 0L;
  private long gRA = 0L;
  private long gRB = 0L;
  private long gRz = 0L;
  
  public final String agH()
  {
    AppMethodBeat.i(118488);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gRz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gNh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRB);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(118488);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(118489);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExposeViewId:").append(this.gRz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickClearCount:").append(this.gNh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickRenewCount:").append(this.gRA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IfDeleteVideo:").append(this.gRB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118489);
    return localObject;
  }
  
  public final long amL()
  {
    return this.gNh;
  }
  
  public final long amM()
  {
    return this.gRA;
  }
  
  public final int getId()
  {
    return 16913;
  }
  
  public final lr wb(long paramLong)
  {
    this.gRz = paramLong;
    return this;
  }
  
  public final lr wc(long paramLong)
  {
    this.gNh = paramLong;
    return this;
  }
  
  public final lr wd(long paramLong)
  {
    this.gRA = paramLong;
    return this;
  }
  
  public final lr we(long paramLong)
  {
    this.gRB = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.lr
 * JD-Core Version:    0.7.0.1
 */