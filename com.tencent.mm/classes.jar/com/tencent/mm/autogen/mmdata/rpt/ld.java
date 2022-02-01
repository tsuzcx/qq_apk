package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ld
  extends a
{
  public long iOQ = 0L;
  public long iOd = 0L;
  private String iOe = "";
  private String iOf = "";
  public long iPP = 0L;
  public long iYM = 0L;
  public long iYN = 0L;
  public long iYO = 0L;
  public long iYP = 0L;
  public long iYQ = 0L;
  public long iYR = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(120836);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iOd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOf);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(120836);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(120837);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Source:").append(this.iOd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CaptureTime:").append(this.iYM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Result:").append(this.iOQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadTime:").append(this.iYN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OCRTranslateTime:").append(this.iYO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalTime:").append(this.iPP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShowOriginCount:").append(this.iYP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSaveResultImage:").append(this.iYQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSaveOriginImage:").append(this.iYR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileID:").append(this.iOe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AesKey:").append(this.iOf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(120837);
    return localObject;
  }
  
  public final int getId()
  {
    return 15435;
  }
  
  public final ld ua(String paramString)
  {
    AppMethodBeat.i(368169);
    this.iOe = F("FileID", paramString, true);
    AppMethodBeat.o(368169);
    return this;
  }
  
  public final ld ub(String paramString)
  {
    AppMethodBeat.i(368174);
    this.iOf = F("AesKey", paramString, true);
    AppMethodBeat.o(368174);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ld
 * JD-Core Version:    0.7.0.1
 */