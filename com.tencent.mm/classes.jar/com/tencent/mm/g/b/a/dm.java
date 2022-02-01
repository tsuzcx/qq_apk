package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dm
  extends a
{
  public long edS = 0L;
  public long edv = 0L;
  public long ehA = 0L;
  public long ehB = 0L;
  public long ehC = 0L;
  public long ehw = 0L;
  public long ehx = 0L;
  public long ehy = 0L;
  public long ehz = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(120836);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.edv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehC);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(120836);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(120837);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Source:").append(this.edv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CaptureTime:").append(this.ehw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Result:").append(this.edS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadTime:").append(this.ehx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OCRTranslateTime:").append(this.ehy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalTime:").append(this.ehz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShowOriginCount:").append(this.ehA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSaveResultImage:").append(this.ehB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSaveOriginImage:").append(this.ehC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(120837);
    return localObject;
  }
  
  public final long Te()
  {
    return this.edS;
  }
  
  public final long Tf()
  {
    return this.ehx;
  }
  
  public final long Tg()
  {
    return this.ehA;
  }
  
  public final dm Th()
  {
    this.ehB = 1L;
    return this;
  }
  
  public final dm Ti()
  {
    this.ehC = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 15435;
  }
  
  public final dm jW(long paramLong)
  {
    this.edv = paramLong;
    return this;
  }
  
  public final dm jX(long paramLong)
  {
    this.ehw = paramLong;
    return this;
  }
  
  public final dm jY(long paramLong)
  {
    this.edS = paramLong;
    return this;
  }
  
  public final dm jZ(long paramLong)
  {
    this.ehx = paramLong;
    return this;
  }
  
  public final dm ka(long paramLong)
  {
    this.ehy = paramLong;
    return this;
  }
  
  public final dm kb(long paramLong)
  {
    this.ehz = paramLong;
    return this;
  }
  
  public final dm kc(long paramLong)
  {
    this.ehA = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dm
 * JD-Core Version:    0.7.0.1
 */