package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cr
  extends a
{
  public long dNc = 0L;
  public long dNi = 0L;
  public long dQp = 0L;
  public long dQq = 0L;
  public long dQr = 0L;
  public long dQs = 0L;
  public long dQt = 0L;
  public long dQu = 0L;
  public long dQv = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(120836);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dNc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQv);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(120836);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(120837);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Source:").append(this.dNc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CaptureTime:").append(this.dQp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Result:").append(this.dNi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadTime:").append(this.dQq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OCRTranslateTime:").append(this.dQr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalTime:").append(this.dQs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShowOriginCount:").append(this.dQt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSaveResultImage:").append(this.dQu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSaveOriginImage:").append(this.dQv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(120837);
    return localObject;
  }
  
  public final long QR()
  {
    return this.dNi;
  }
  
  public final long QS()
  {
    return this.dQq;
  }
  
  public final long QT()
  {
    return this.dQt;
  }
  
  public final cr QU()
  {
    this.dQu = 1L;
    return this;
  }
  
  public final cr QV()
  {
    this.dQv = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 15435;
  }
  
  public final cr ia(long paramLong)
  {
    this.dNc = paramLong;
    return this;
  }
  
  public final cr ib(long paramLong)
  {
    this.dQp = paramLong;
    return this;
  }
  
  public final cr ic(long paramLong)
  {
    this.dNi = paramLong;
    return this;
  }
  
  public final cr id(long paramLong)
  {
    this.dQq = paramLong;
    return this;
  }
  
  public final cr ie(long paramLong)
  {
    this.dQr = paramLong;
    return this;
  }
  
  public final cr jdMethod_if(long paramLong)
  {
    this.dQs = paramLong;
    return this;
  }
  
  public final cr ig(long paramLong)
  {
    this.dQt = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cr
 * JD-Core Version:    0.7.0.1
 */