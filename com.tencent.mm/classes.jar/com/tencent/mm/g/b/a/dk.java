package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dk
  extends a
{
  public long eca = 0L;
  public long ecx = 0L;
  public long efL = 0L;
  public long efM = 0L;
  public long efN = 0L;
  public long efO = 0L;
  public long efP = 0L;
  public long efQ = 0L;
  public long efR = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(120836);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eca);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efR);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(120836);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(120837);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Source:").append(this.eca);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CaptureTime:").append(this.efL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Result:").append(this.ecx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadTime:").append(this.efM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OCRTranslateTime:").append(this.efN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalTime:").append(this.efO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShowOriginCount:").append(this.efP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSaveResultImage:").append(this.efQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSaveOriginImage:").append(this.efR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(120837);
    return localObject;
  }
  
  public final long SY()
  {
    return this.ecx;
  }
  
  public final long SZ()
  {
    return this.efM;
  }
  
  public final long Ta()
  {
    return this.efP;
  }
  
  public final dk Tb()
  {
    this.efQ = 1L;
    return this;
  }
  
  public final dk Tc()
  {
    this.efR = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 15435;
  }
  
  public final dk jL(long paramLong)
  {
    this.eca = paramLong;
    return this;
  }
  
  public final dk jM(long paramLong)
  {
    this.efL = paramLong;
    return this;
  }
  
  public final dk jN(long paramLong)
  {
    this.ecx = paramLong;
    return this;
  }
  
  public final dk jO(long paramLong)
  {
    this.efM = paramLong;
    return this;
  }
  
  public final dk jP(long paramLong)
  {
    this.efN = paramLong;
    return this;
  }
  
  public final dk jQ(long paramLong)
  {
    this.efO = paramLong;
    return this;
  }
  
  public final dk jR(long paramLong)
  {
    this.efP = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dk
 * JD-Core Version:    0.7.0.1
 */