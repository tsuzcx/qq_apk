package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class t
  extends a
{
  public long cSK = 0L;
  public long cSL = 0L;
  public long cSM = 0L;
  public long cSN = 0L;
  public long cSO = 0L;
  public long cSP = 0L;
  public long cSQ = 0L;
  public long cSR = 0L;
  public long cSS = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(138450);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cSK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSS);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(138450);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(138451);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Source:").append(this.cSK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CaptureTime:").append(this.cSL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Result:").append(this.cSM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadTime:").append(this.cSN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OCRTranslateTime:").append(this.cSO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalTime:").append(this.cSP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShowOriginCount:").append(this.cSQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSaveResultImage:").append(this.cSR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSaveOriginImage:").append(this.cSS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(138451);
    return localObject;
  }
  
  public final int getId()
  {
    return 15435;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.t
 * JD-Core Version:    0.7.0.1
 */