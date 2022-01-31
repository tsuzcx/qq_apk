package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ar
  extends a
{
  private long cSN = 0L;
  private long cVc = 0L;
  private long cVd = 0L;
  private long cVe = 0L;
  private String cVf;
  private String cVg;
  
  public final String Ff()
  {
    AppMethodBeat.i(108839);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cVc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVg);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(108839);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(108840);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ComposeTime:").append(this.cVc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ComposeErrorType:").append(this.cVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadTime:").append(this.cSN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadErrorType:").append(this.cVe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ComposeErrorTypeStr:").append(this.cVf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadErrorTypeStr:").append(this.cVg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(108840);
    return localObject;
  }
  
  public final long Fp()
  {
    return this.cVc;
  }
  
  public final long Fq()
  {
    return this.cSN;
  }
  
  public final ar bC(long paramLong)
  {
    this.cVc = paramLong;
    return this;
  }
  
  public final ar bD(long paramLong)
  {
    this.cVd = paramLong;
    return this;
  }
  
  public final ar bE(long paramLong)
  {
    this.cSN = paramLong;
    return this;
  }
  
  public final ar bF(long paramLong)
  {
    this.cVe = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 16688;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ar
 * JD-Core Version:    0.7.0.1
 */