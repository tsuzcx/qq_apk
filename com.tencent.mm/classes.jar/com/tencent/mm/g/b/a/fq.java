package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fq
  extends a
{
  private long ehx = 0L;
  private long emQ = 0L;
  private long emR = 0L;
  private long emS = 0L;
  private String emT = "";
  private String emU = "";
  
  public final String RC()
  {
    AppMethodBeat.i(118483);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.emQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emU);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(118483);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(118484);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ComposeTime:").append(this.emQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ComposeErrorType:").append(this.emR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadTime:").append(this.ehx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadErrorType:").append(this.emS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ComposeErrorTypeStr:").append(this.emT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadErrorTypeStr:").append(this.emU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118484);
    return localObject;
  }
  
  public final long Tf()
  {
    return this.ehx;
  }
  
  public final int getId()
  {
    return 16688;
  }
  
  public final fq kq(long paramLong)
  {
    this.ehx = paramLong;
    return this;
  }
  
  public final fq kr(long paramLong)
  {
    this.emS = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fq
 * JD-Core Version:    0.7.0.1
 */