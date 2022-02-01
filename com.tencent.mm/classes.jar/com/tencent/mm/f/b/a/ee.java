package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ee
  extends a
{
  private long geB;
  private long gqu;
  private long gwW;
  private long gwX;
  private long gwY;
  private long gwZ;
  private long gxa;
  
  public final String agH()
  {
    AppMethodBeat.i(208090);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gqu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gwW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gwX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gwY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gwZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gxa);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(208090);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208091);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("pullType:").append(this.gqu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("curTabType:").append(this.gwW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.geB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("abandonReasonType:").append(this.gwX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("prefetchWithRedDot:").append(this.gwY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("rejectPrefetchReasonType:").append(this.gwZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("localHasPrefetchData:").append(this.gxa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208091);
    return localObject;
  }
  
  public final ee ajZ()
  {
    this.gwW = 0L;
    return this;
  }
  
  public final ee aka()
  {
    this.gwZ = 0L;
    return this;
  }
  
  public final ee akb()
  {
    this.gxa = 0L;
    return this;
  }
  
  public final int getId()
  {
    return 23105;
  }
  
  public final ee lh(long paramLong)
  {
    this.gqu = paramLong;
    return this;
  }
  
  public final ee li(long paramLong)
  {
    this.geB = paramLong;
    return this;
  }
  
  public final ee lj(long paramLong)
  {
    this.gwX = paramLong;
    return this;
  }
  
  public final ee lk(long paramLong)
  {
    this.gwY = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ee
 * JD-Core Version:    0.7.0.1
 */