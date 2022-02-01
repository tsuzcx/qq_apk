package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class je
  extends a
{
  private long eJU = 0L;
  private String eQA = "";
  private String eQB = "";
  private long eQx = 0L;
  private long eQy = 0L;
  private long eQz = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(118483);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eQx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQB);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(118483);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(118484);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ComposeTime:").append(this.eQx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ComposeErrorType:").append(this.eQy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadTime:").append(this.eJU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadErrorType:").append(this.eQz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ComposeErrorTypeStr:").append(this.eQA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadErrorTypeStr:").append(this.eQB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118484);
    return localObject;
  }
  
  public final long agP()
  {
    return this.eJU;
  }
  
  public final int getId()
  {
    return 16688;
  }
  
  public final je rs(long paramLong)
  {
    this.eJU = paramLong;
    return this;
  }
  
  public final je rt(long paramLong)
  {
    this.eQz = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.je
 * JD-Core Version:    0.7.0.1
 */