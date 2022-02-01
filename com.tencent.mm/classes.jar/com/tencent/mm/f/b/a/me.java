package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class me
  extends a
{
  private long gFA = 0L;
  private long gFD = 0L;
  private long gFz = 0L;
  private String gRx = "";
  private String gSQ = "";
  private String gSR = "";
  private long gSS = 0L;
  private long gST = 0L;
  private long gSU = 0L;
  private long gSV = 0L;
  private long gSW = 0L;
  private long gSX = 0L;
  private long gSY = 0L;
  private long gSZ = 0L;
  private long gTa = 0L;
  private long gTb = 0L;
  private long gTc = 0L;
  private long gTd = 0L;
  private long gTe = 0L;
  private long gTf = 0L;
  private long gTg = 0L;
  private long gTh = 0L;
  
  public final me CH(String paramString)
  {
    AppMethodBeat.i(118524);
    this.gSQ = z("FileUrl", paramString, true);
    AppMethodBeat.o(118524);
    return this;
  }
  
  public final me CI(String paramString)
  {
    AppMethodBeat.i(118525);
    this.gRx = z("Tid", paramString, true);
    AppMethodBeat.o(118525);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(118526);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gSQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gST);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTh);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(118526);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(118527);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FileUrl:").append(this.gSQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoMd5:").append(this.gSR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tid:").append(this.gRx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadStartTime:").append(this.gSS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadEndTime:").append(this.gST);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginSize:").append(this.gFD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginDuration:").append(this.gSU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginVideoBitrate:").append(this.gSV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginAudioBitrate:").append(this.gSW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginFps:").append(this.gSX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginWidth:").append(this.gFz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginHeight:").append(this.gFA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CPSize:").append(this.gSY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CPDuration:").append(this.gSZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CPVideoBitrate:").append(this.gTa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CPAudioBitrate:").append(this.gTb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CPFps:").append(this.gTc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CPWidth:").append(this.gTd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CPHight:").append(this.gTe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendSource:").append(this.gTf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginAudioChannel:").append(this.gTg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetWorkType:").append(this.gTh);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118527);
    return localObject;
  }
  
  public final long anA()
  {
    return this.gFz;
  }
  
  public final long anB()
  {
    return this.gFA;
  }
  
  public final long anC()
  {
    return this.gSY;
  }
  
  public final long anD()
  {
    return this.gSZ;
  }
  
  public final long anE()
  {
    return this.gTa;
  }
  
  public final long anF()
  {
    return this.gTc;
  }
  
  public final long anG()
  {
    return this.gTd;
  }
  
  public final long anH()
  {
    return this.gTe;
  }
  
  public final long anI()
  {
    return this.gTf;
  }
  
  public final long anJ()
  {
    return this.gTg;
  }
  
  public final long anK()
  {
    return this.gTh;
  }
  
  public final String anq()
  {
    return this.gSQ;
  }
  
  public final String ans()
  {
    return this.gSR;
  }
  
  public final String ant()
  {
    return this.gRx;
  }
  
  public final long anu()
  {
    return this.gSS;
  }
  
  public final long anv()
  {
    return this.gST;
  }
  
  public final long anw()
  {
    return this.gFD;
  }
  
  public final long anx()
  {
    return this.gSU;
  }
  
  public final long any()
  {
    return this.gSV;
  }
  
  public final long anz()
  {
    return this.gSX;
  }
  
  public final int getId()
  {
    return 16664;
  }
  
  public final me wX(long paramLong)
  {
    this.gSS = paramLong;
    return this;
  }
  
  public final me wY(long paramLong)
  {
    this.gST = paramLong;
    return this;
  }
  
  public final me wZ(long paramLong)
  {
    this.gTh = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.me
 * JD-Core Version:    0.7.0.1
 */