package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ep
  extends a
{
  private long dQq = 0L;
  private long dUR = 0L;
  private long dUS = 0L;
  private long dUT = 0L;
  private String dUU;
  private String dUV;
  
  public final String PR()
  {
    AppMethodBeat.i(118483);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dUR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUV);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(118483);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(118484);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ComposeTime:").append(this.dUR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ComposeErrorType:").append(this.dUS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadTime:").append(this.dQq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadErrorType:").append(this.dUT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ComposeErrorTypeStr:").append(this.dUU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadErrorTypeStr:").append(this.dUV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118484);
    return localObject;
  }
  
  public final long QS()
  {
    return this.dQq;
  }
  
  public final int getId()
  {
    return 16688;
  }
  
  public final ep it(long paramLong)
  {
    this.dQq = paramLong;
    return this;
  }
  
  public final ep iu(long paramLong)
  {
    this.dUT = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ep
 * JD-Core Version:    0.7.0.1
 */