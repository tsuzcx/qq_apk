package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
{
  public static int zuP = 480;
  public static int zuQ = 640;
  public int dYT;
  public int fps;
  public int iFw;
  public int ifN;
  public int ifO;
  public int sUA;
  public int sUz;
  public int zuR;
  public int zuS;
  public int zuT;
  public String zuU;
  public String zuV;
  public String zuW;
  public String zuX;
  public String zuY;
  public int zuZ;
  public int zva;
  
  public static q ejT()
  {
    AppMethodBeat.i(89462);
    q localq = new q();
    localq.fps = 30;
    localq.dYT = 0;
    localq.ifO = zuQ;
    localq.ifN = zuP;
    localq.sUA = zuQ;
    localq.sUz = zuP;
    localq.zuR = 327680;
    localq.zuS = 4;
    localq.zuT = 1;
    localq.zuU = "/sdcard/2.yuv";
    localq.zuY = "/sdcard/2.mp4";
    localq.zuV = "/sdcard/2.pcm";
    localq.zuX = "/sdcard/2.x264";
    localq.zuZ = 0;
    localq.iFw = 0;
    localq.zva = 0;
    AppMethodBeat.o(89462);
    return localq;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(89461);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fps=").append(this.fps).append('\n');
    ((StringBuilder)localObject).append("width=").append(this.sUz).append('\n');
    ((StringBuilder)localObject).append("height=").append(this.sUA).append('\n');
    ((StringBuilder)localObject).append("bitrate=").append(this.zuR).append('\n');
    ((StringBuilder)localObject).append("rotate=").append(this.dYT).append('\n');
    ((StringBuilder)localObject).append("yuvWidth=").append(this.ifN).append('\n');
    ((StringBuilder)localObject).append("yuvHeight=").append(this.ifO).append('\n');
    ((StringBuilder)localObject).append("x264Speed=").append(this.zuS).append('\n');
    ((StringBuilder)localObject).append("x264Quality=").append(this.zuT).append('\n');
    ((StringBuilder)localObject).append("yuvFile=").append(this.zuU).append('\n');
    ((StringBuilder)localObject).append("pcmFile=").append(this.zuV).append('\n');
    ((StringBuilder)localObject).append("thuFile=").append(this.zuW).append('\n');
    ((StringBuilder)localObject).append("x264File=").append(this.zuX).append('\n');
    ((StringBuilder)localObject).append("mp4File=").append(this.zuY).append('\n');
    ((StringBuilder)localObject).append("videoFrameCnt=").append(this.zuZ).append('\n');
    ((StringBuilder)localObject).append("videoLength=").append(this.iFw).append('\n');
    ((StringBuilder)localObject).append("cameraCount=").append(this.zva).append('\n');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(89461);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.q
 * JD-Core Version:    0.7.0.1
 */