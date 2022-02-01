package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cc
  extends a
{
  public String ilF = "";
  public long iuX = 0L;
  public String iuY = "";
  private long iuZ = 0L;
  public long iva = 0L;
  public long ivb = 0L;
  public long ivc = 0L;
  public long ivd = 0L;
  public long ive = 0L;
  public long ivf = 0L;
  public long ivg = 0L;
  public long ivh = 0L;
  public long ivi = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(368266);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iuX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iva);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ive);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivi);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368266);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368271);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("calledSessionId:").append(this.iuX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("functionName:").append(this.iuY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("interfaceType:").append(this.iuZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("businessType:").append(this.iva);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appId:").append(this.ilF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isFaceDetectVerifySuccess:").append(this.ivb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("totalTime:").append(this.ivc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("faceDetectCount:").append(this.ivd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BeginFaceTime:").append(this.ive);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BeginLivenessTime:").append(this.ivf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BeginVerifyTime:").append(this.ivg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitFaceTime:").append(this.ivh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CheckAliveType:").append(this.ivi);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368271);
    return localObject;
  }
  
  public final int getId()
  {
    return 14560;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.cc
 * JD-Core Version:    0.7.0.1
 */