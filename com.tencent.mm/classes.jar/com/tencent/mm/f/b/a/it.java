package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class it
  extends a
{
  public long gBP = 0L;
  public long gBe = 0L;
  private String gBf = "";
  private String gBg = "";
  public long gCN = 0L;
  public long gJA = 0L;
  public long gJB = 0L;
  public long gJw = 0L;
  public long gJx = 0L;
  public long gJy = 0L;
  public long gJz = 0L;
  
  public final String agH()
  {
    AppMethodBeat.i(120836);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gBe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBg);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(120836);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(120837);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Source:").append(this.gBe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CaptureTime:").append(this.gJw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Result:").append(this.gBP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadTime:").append(this.gJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OCRTranslateTime:").append(this.gJy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalTime:").append(this.gCN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShowOriginCount:").append(this.gJz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSaveResultImage:").append(this.gJA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSaveOriginImage:").append(this.gJB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileID:").append(this.gBf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AesKey:").append(this.gBg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(120837);
    return localObject;
  }
  
  public final long alV()
  {
    return this.gBP;
  }
  
  public final long alW()
  {
    return this.gJx;
  }
  
  public final long alX()
  {
    return this.gJz;
  }
  
  public final it alY()
  {
    this.gJA = 1L;
    return this;
  }
  
  public final it alZ()
  {
    this.gJB = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 15435;
  }
  
  public final it ue(long paramLong)
  {
    this.gBe = paramLong;
    return this;
  }
  
  public final it uf(long paramLong)
  {
    this.gJw = paramLong;
    return this;
  }
  
  public final it ug(long paramLong)
  {
    this.gBP = paramLong;
    return this;
  }
  
  public final it uh(long paramLong)
  {
    this.gJx = paramLong;
    return this;
  }
  
  public final it ui(long paramLong)
  {
    this.gJy = paramLong;
    return this;
  }
  
  public final it uj(long paramLong)
  {
    this.gCN = paramLong;
    return this;
  }
  
  public final it uk(long paramLong)
  {
    this.gJz = paramLong;
    return this;
  }
  
  public final it zP(String paramString)
  {
    AppMethodBeat.i(211830);
    this.gBf = z("FileID", paramString, true);
    AppMethodBeat.o(211830);
    return this;
  }
  
  public final it zQ(String paramString)
  {
    AppMethodBeat.i(211831);
    this.gBg = z("AesKey", paramString, true);
    AppMethodBeat.o(211831);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.f.b.a.it
 * JD-Core Version:    0.7.0.1
 */