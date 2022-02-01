package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fo
  extends a
{
  private long efM = 0L;
  private long elj = 0L;
  private long elk = 0L;
  private long ell = 0L;
  private String elm;
  private String eln;
  
  public final String RD()
  {
    AppMethodBeat.i(118483);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.elj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ell);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eln);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(118483);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(118484);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ComposeTime:").append(this.elj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ComposeErrorType:").append(this.elk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadTime:").append(this.efM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadErrorType:").append(this.ell);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ComposeErrorTypeStr:").append(this.elm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadErrorTypeStr:").append(this.eln);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118484);
    return localObject;
  }
  
  public final long SZ()
  {
    return this.efM;
  }
  
  public final int getId()
  {
    return 16688;
  }
  
  public final fo kf(long paramLong)
  {
    this.efM = paramLong;
    return this;
  }
  
  public final fo kg(long paramLong)
  {
    this.ell = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fo
 * JD-Core Version:    0.7.0.1
 */