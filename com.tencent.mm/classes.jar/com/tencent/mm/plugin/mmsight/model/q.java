package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
{
  public static int uLB = 480;
  public static int uLC = 640;
  public int duc;
  public int fps;
  public int hpy;
  public int qCH;
  public int qCI;
  public int uLD;
  public int uLE;
  public int uLF;
  public int uLG;
  public int uLH;
  public String uLI;
  public String uLJ;
  public String uLK;
  public String uLL;
  public String uLM;
  public int uLN;
  public int uLO;
  
  public static q ddJ()
  {
    AppMethodBeat.i(89462);
    q localq = new q();
    localq.fps = 30;
    localq.duc = 0;
    localq.uLE = uLC;
    localq.uLF = uLB;
    localq.qCI = uLC;
    localq.qCH = uLB;
    localq.uLD = 327680;
    localq.uLG = 4;
    localq.uLH = 1;
    localq.uLI = "/sdcard/2.yuv";
    localq.uLM = "/sdcard/2.mp4";
    localq.uLJ = "/sdcard/2.pcm";
    localq.uLL = "/sdcard/2.x264";
    localq.uLN = 0;
    localq.hpy = 0;
    localq.uLO = 0;
    AppMethodBeat.o(89462);
    return localq;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(89461);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fps=").append(this.fps).append('\n');
    ((StringBuilder)localObject).append("width=").append(this.qCH).append('\n');
    ((StringBuilder)localObject).append("height=").append(this.qCI).append('\n');
    ((StringBuilder)localObject).append("bitrate=").append(this.uLD).append('\n');
    ((StringBuilder)localObject).append("rotate=").append(this.duc).append('\n');
    ((StringBuilder)localObject).append("yuvWidth=").append(this.uLF).append('\n');
    ((StringBuilder)localObject).append("yuvHeight=").append(this.uLE).append('\n');
    ((StringBuilder)localObject).append("x264Speed=").append(this.uLG).append('\n');
    ((StringBuilder)localObject).append("x264Quality=").append(this.uLH).append('\n');
    ((StringBuilder)localObject).append("yuvFile=").append(this.uLI).append('\n');
    ((StringBuilder)localObject).append("pcmFile=").append(this.uLJ).append('\n');
    ((StringBuilder)localObject).append("thuFile=").append(this.uLK).append('\n');
    ((StringBuilder)localObject).append("x264File=").append(this.uLL).append('\n');
    ((StringBuilder)localObject).append("mp4File=").append(this.uLM).append('\n');
    ((StringBuilder)localObject).append("videoFrameCnt=").append(this.uLN).append('\n');
    ((StringBuilder)localObject).append("videoLength=").append(this.hpy).append('\n');
    ((StringBuilder)localObject).append("cameraCount=").append(this.uLO).append('\n');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(89461);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.q
 * JD-Core Version:    0.7.0.1
 */