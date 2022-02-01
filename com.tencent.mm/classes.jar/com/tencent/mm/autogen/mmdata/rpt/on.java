package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class on
  extends a
{
  public long iYN = 0L;
  private long jjp = 0L;
  private long jjq = 0L;
  public long jjr = 0L;
  private String jjs = "";
  private String jjt = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(118483);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jjp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjt);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(118483);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(118484);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ComposeTime:").append(this.jjp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ComposeErrorType:").append(this.jjq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadTime:").append(this.iYN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadErrorType:").append(this.jjr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ComposeErrorTypeStr:").append(this.jjs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadErrorTypeStr:").append(this.jjt);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118484);
    return localObject;
  }
  
  public final int getId()
  {
    return 16688;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.on
 * JD-Core Version:    0.7.0.1
 */