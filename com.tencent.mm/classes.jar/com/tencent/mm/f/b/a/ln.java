package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ln
  extends a
{
  private long gJx = 0L;
  private long gQT = 0L;
  private long gQU = 0L;
  private long gQV = 0L;
  private String gQW = "";
  private String gQX = "";
  
  public final String agH()
  {
    AppMethodBeat.i(118483);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gQT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQX);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(118483);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(118484);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ComposeTime:").append(this.gQT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ComposeErrorType:").append(this.gQU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadTime:").append(this.gJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadErrorType:").append(this.gQV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ComposeErrorTypeStr:").append(this.gQW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadErrorTypeStr:").append(this.gQX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118484);
    return localObject;
  }
  
  public final long alW()
  {
    return this.gJx;
  }
  
  public final int getId()
  {
    return 16688;
  }
  
  public final ln vu(long paramLong)
  {
    this.gJx = paramLong;
    return this;
  }
  
  public final ln vv(long paramLong)
  {
    this.gQV = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ln
 * JD-Core Version:    0.7.0.1
 */