package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
{
  public static int vOH = 480;
  public static int vOI = 640;
  public int dGc;
  public int fps;
  public int hHQ;
  public int rmx;
  public int rmy;
  public int vOJ;
  public int vOK;
  public int vOL;
  public int vOM;
  public int vON;
  public String vOO;
  public String vOP;
  public String vOQ;
  public String vOR;
  public String vOS;
  public int vOT;
  public int vOU;
  
  public static q dnf()
  {
    AppMethodBeat.i(89462);
    q localq = new q();
    localq.fps = 30;
    localq.dGc = 0;
    localq.vOK = vOI;
    localq.vOL = vOH;
    localq.rmy = vOI;
    localq.rmx = vOH;
    localq.vOJ = 327680;
    localq.vOM = 4;
    localq.vON = 1;
    localq.vOO = "/sdcard/2.yuv";
    localq.vOS = "/sdcard/2.mp4";
    localq.vOP = "/sdcard/2.pcm";
    localq.vOR = "/sdcard/2.x264";
    localq.vOT = 0;
    localq.hHQ = 0;
    localq.vOU = 0;
    AppMethodBeat.o(89462);
    return localq;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(89461);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fps=").append(this.fps).append('\n');
    ((StringBuilder)localObject).append("width=").append(this.rmx).append('\n');
    ((StringBuilder)localObject).append("height=").append(this.rmy).append('\n');
    ((StringBuilder)localObject).append("bitrate=").append(this.vOJ).append('\n');
    ((StringBuilder)localObject).append("rotate=").append(this.dGc).append('\n');
    ((StringBuilder)localObject).append("yuvWidth=").append(this.vOL).append('\n');
    ((StringBuilder)localObject).append("yuvHeight=").append(this.vOK).append('\n');
    ((StringBuilder)localObject).append("x264Speed=").append(this.vOM).append('\n');
    ((StringBuilder)localObject).append("x264Quality=").append(this.vON).append('\n');
    ((StringBuilder)localObject).append("yuvFile=").append(this.vOO).append('\n');
    ((StringBuilder)localObject).append("pcmFile=").append(this.vOP).append('\n');
    ((StringBuilder)localObject).append("thuFile=").append(this.vOQ).append('\n');
    ((StringBuilder)localObject).append("x264File=").append(this.vOR).append('\n');
    ((StringBuilder)localObject).append("mp4File=").append(this.vOS).append('\n');
    ((StringBuilder)localObject).append("videoFrameCnt=").append(this.vOT).append('\n');
    ((StringBuilder)localObject).append("videoLength=").append(this.hHQ).append('\n');
    ((StringBuilder)localObject).append("cameraCount=").append(this.vOU).append('\n');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(89461);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.q
 * JD-Core Version:    0.7.0.1
 */