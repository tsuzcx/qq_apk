package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class db
  extends a
{
  private long dOz = 0L;
  private long dTf = 0L;
  private long dTg = 0L;
  private long dTh = 0L;
  private String dTi;
  private String dTj;
  
  public final String PV()
  {
    AppMethodBeat.i(118483);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTj);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(118483);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(118484);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ComposeTime:").append(this.dTf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ComposeErrorType:").append(this.dTg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadTime:").append(this.dOz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadErrorType:").append(this.dTh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ComposeErrorTypeStr:").append(this.dTi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadErrorTypeStr:").append(this.dTj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118484);
    return localObject;
  }
  
  public final long Qq()
  {
    return this.dOz;
  }
  
  public final db fg(long paramLong)
  {
    this.dOz = paramLong;
    return this;
  }
  
  public final db fh(long paramLong)
  {
    this.dTh = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 16688;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.db
 * JD-Core Version:    0.7.0.1
 */