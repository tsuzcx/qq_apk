package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
{
  public static int waK = 480;
  public static int waL = 640;
  public int dHi;
  public int fps;
  public int hKI;
  public int ruC;
  public int ruD;
  public int waM;
  public int waN;
  public int waO;
  public int waP;
  public int waQ;
  public String waR;
  public String waS;
  public String waT;
  public String waU;
  public String waV;
  public int waW;
  public int waX;
  
  public static q dqd()
  {
    AppMethodBeat.i(89462);
    q localq = new q();
    localq.fps = 30;
    localq.dHi = 0;
    localq.waN = waL;
    localq.waO = waK;
    localq.ruD = waL;
    localq.ruC = waK;
    localq.waM = 327680;
    localq.waP = 4;
    localq.waQ = 1;
    localq.waR = "/sdcard/2.yuv";
    localq.waV = "/sdcard/2.mp4";
    localq.waS = "/sdcard/2.pcm";
    localq.waU = "/sdcard/2.x264";
    localq.waW = 0;
    localq.hKI = 0;
    localq.waX = 0;
    AppMethodBeat.o(89462);
    return localq;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(89461);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fps=").append(this.fps).append('\n');
    ((StringBuilder)localObject).append("width=").append(this.ruC).append('\n');
    ((StringBuilder)localObject).append("height=").append(this.ruD).append('\n');
    ((StringBuilder)localObject).append("bitrate=").append(this.waM).append('\n');
    ((StringBuilder)localObject).append("rotate=").append(this.dHi).append('\n');
    ((StringBuilder)localObject).append("yuvWidth=").append(this.waO).append('\n');
    ((StringBuilder)localObject).append("yuvHeight=").append(this.waN).append('\n');
    ((StringBuilder)localObject).append("x264Speed=").append(this.waP).append('\n');
    ((StringBuilder)localObject).append("x264Quality=").append(this.waQ).append('\n');
    ((StringBuilder)localObject).append("yuvFile=").append(this.waR).append('\n');
    ((StringBuilder)localObject).append("pcmFile=").append(this.waS).append('\n');
    ((StringBuilder)localObject).append("thuFile=").append(this.waT).append('\n');
    ((StringBuilder)localObject).append("x264File=").append(this.waU).append('\n');
    ((StringBuilder)localObject).append("mp4File=").append(this.waV).append('\n');
    ((StringBuilder)localObject).append("videoFrameCnt=").append(this.waW).append('\n');
    ((StringBuilder)localObject).append("videoLength=").append(this.hKI).append('\n');
    ((StringBuilder)localObject).append("cameraCount=").append(this.waX).append('\n');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(89461);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.q
 * JD-Core Version:    0.7.0.1
 */