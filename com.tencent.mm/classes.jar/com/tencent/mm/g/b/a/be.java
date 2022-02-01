package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class be
  extends a
{
  public long dMB = 0L;
  public long dMH = 0L;
  public long dOA = 0L;
  public long dOB = 0L;
  public long dOC = 0L;
  public long dOD = 0L;
  public long dOE = 0L;
  public long dOy = 0L;
  public long dOz = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(120836);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dMB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOE);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(120836);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(120837);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Source:").append(this.dMB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CaptureTime:").append(this.dOy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Result:").append(this.dMH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadTime:").append(this.dOz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OCRTranslateTime:").append(this.dOA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalTime:").append(this.dOB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShowOriginCount:").append(this.dOC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSaveResultImage:").append(this.dOD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSaveOriginImage:").append(this.dOE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(120837);
    return localObject;
  }
  
  public final long Qp()
  {
    return this.dMH;
  }
  
  public final long Qq()
  {
    return this.dOz;
  }
  
  public final long Qr()
  {
    return this.dOC;
  }
  
  public final be Qs()
  {
    this.dOD = 1L;
    return this;
  }
  
  public final be Qt()
  {
    this.dOE = 1L;
    return this;
  }
  
  public final be eN(long paramLong)
  {
    this.dMB = paramLong;
    return this;
  }
  
  public final be eO(long paramLong)
  {
    this.dOy = paramLong;
    return this;
  }
  
  public final be eP(long paramLong)
  {
    this.dMH = paramLong;
    return this;
  }
  
  public final be eQ(long paramLong)
  {
    this.dOz = paramLong;
    return this;
  }
  
  public final be eR(long paramLong)
  {
    this.dOA = paramLong;
    return this;
  }
  
  public final be eS(long paramLong)
  {
    this.dOB = paramLong;
    return this;
  }
  
  public final be eT(long paramLong)
  {
    this.dOC = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 15435;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.be
 * JD-Core Version:    0.7.0.1
 */