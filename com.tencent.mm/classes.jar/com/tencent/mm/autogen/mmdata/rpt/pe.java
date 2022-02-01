package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class pe
  extends a
{
  public long iSA = 0L;
  public long iSD = 0L;
  public long iSz = 0L;
  public String jjT = "";
  public long jlA = 0L;
  public long jlB = 0L;
  public long jlC = 0L;
  public long jlD = 0L;
  public String jlm = "";
  public String jln = "";
  public long jlo = 0L;
  public long jlp = 0L;
  public long jlq = 0L;
  public long jlr = 0L;
  private long jls = 0L;
  public long jlt = 0L;
  public long jlu = 0L;
  public long jlv = 0L;
  public long jlw = 0L;
  private long jlx = 0L;
  public long jly = 0L;
  public long jlz = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(118526);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jlm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jln);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jls);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jly);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlD);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(118526);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(118527);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FileUrl:").append(this.jlm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoMd5:").append(this.jln);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tid:").append(this.jjT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadStartTime:").append(this.jlo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadEndTime:").append(this.jlp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginSize:").append(this.iSD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginDuration:").append(this.jlq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginVideoBitrate:").append(this.jlr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginAudioBitrate:").append(this.jls);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginFps:").append(this.jlt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginWidth:").append(this.iSz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginHeight:").append(this.iSA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CPSize:").append(this.jlu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CPDuration:").append(this.jlv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CPVideoBitrate:").append(this.jlw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CPAudioBitrate:").append(this.jlx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CPFps:").append(this.jly);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CPWidth:").append(this.jlz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CPHight:").append(this.jlA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendSource:").append(this.jlB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginAudioChannel:").append(this.jlC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetWorkType:").append(this.jlD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118527);
    return localObject;
  }
  
  public final int getId()
  {
    return 16664;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.pe
 * JD-Core Version:    0.7.0.1
 */