package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class go
  extends a
{
  public long eDV = 0L;
  private String eDW = "";
  private String eDX = "";
  public long eEt = 0L;
  public long eJT = 0L;
  public long eJU = 0L;
  public long eJV = 0L;
  public long eJW = 0L;
  public long eJX = 0L;
  public long eJY = 0L;
  public long eJZ = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(120836);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eDV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDX);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(120836);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(120837);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Source:").append(this.eDV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CaptureTime:").append(this.eJT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Result:").append(this.eEt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadTime:").append(this.eJU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OCRTranslateTime:").append(this.eJV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalTime:").append(this.eJW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShowOriginCount:").append(this.eJX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSaveResultImage:").append(this.eJY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSaveOriginImage:").append(this.eJZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileID:").append(this.eDW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AesKey:").append(this.eDX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(120837);
    return localObject;
  }
  
  public final long agO()
  {
    return this.eEt;
  }
  
  public final long agP()
  {
    return this.eJU;
  }
  
  public final long agQ()
  {
    return this.eJX;
  }
  
  public final go agR()
  {
    this.eJY = 1L;
    return this;
  }
  
  public final go agS()
  {
    this.eJZ = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 15435;
  }
  
  public final go qA(long paramLong)
  {
    this.eJU = paramLong;
    return this;
  }
  
  public final go qB(long paramLong)
  {
    this.eJV = paramLong;
    return this;
  }
  
  public final go qC(long paramLong)
  {
    this.eJW = paramLong;
    return this;
  }
  
  public final go qD(long paramLong)
  {
    this.eJX = paramLong;
    return this;
  }
  
  public final go qx(long paramLong)
  {
    this.eDV = paramLong;
    return this;
  }
  
  public final go qy(long paramLong)
  {
    this.eJT = paramLong;
    return this;
  }
  
  public final go qz(long paramLong)
  {
    this.eEt = paramLong;
    return this;
  }
  
  public final go uq(String paramString)
  {
    AppMethodBeat.i(200110);
    this.eDW = x("FileID", paramString, true);
    AppMethodBeat.o(200110);
    return this;
  }
  
  public final go ur(String paramString)
  {
    AppMethodBeat.i(200111);
    this.eDX = x("AesKey", paramString, true);
    AppMethodBeat.o(200111);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.go
 * JD-Core Version:    0.7.0.1
 */