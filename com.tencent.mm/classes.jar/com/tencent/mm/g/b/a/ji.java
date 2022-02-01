package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ji
  extends a
{
  private long eNd = 0L;
  private long eRd = 0L;
  private long eRe = 0L;
  private long eRf = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(118488);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eRd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eNd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRf);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(118488);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(118489);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExposeViewId:").append(this.eRd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickClearCount:").append(this.eNd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickRenewCount:").append(this.eRe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IfDeleteVideo:").append(this.eRf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118489);
    return localObject;
  }
  
  public final long ahp()
  {
    return this.eNd;
  }
  
  public final long ahq()
  {
    return this.eRe;
  }
  
  public final int getId()
  {
    return 16913;
  }
  
  public final ji rZ(long paramLong)
  {
    this.eRd = paramLong;
    return this;
  }
  
  public final ji sa(long paramLong)
  {
    this.eNd = paramLong;
    return this;
  }
  
  public final ji sb(long paramLong)
  {
    this.eRe = paramLong;
    return this;
  }
  
  public final ji sc(long paramLong)
  {
    this.eRf = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ji
 * JD-Core Version:    0.7.0.1
 */