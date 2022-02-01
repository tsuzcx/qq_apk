package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
{
  public static int tDe = 480;
  public static int tDf = 640;
  public int dwp;
  public int fps;
  public int gOY;
  public int pUc;
  public int pUd;
  public int tDg;
  public int tDh;
  public int tDi;
  public int tDj;
  public int tDk;
  public String tDl;
  public String tDm;
  public String tDn;
  public String tDo;
  public String tDp;
  public int tDq;
  public int tDr;
  
  public static q cQb()
  {
    AppMethodBeat.i(89462);
    q localq = new q();
    localq.fps = 30;
    localq.dwp = 0;
    localq.tDh = tDf;
    localq.tDi = tDe;
    localq.pUd = tDf;
    localq.pUc = tDe;
    localq.tDg = 327680;
    localq.tDj = 4;
    localq.tDk = 1;
    localq.tDl = "/sdcard/2.yuv";
    localq.tDp = "/sdcard/2.mp4";
    localq.tDm = "/sdcard/2.pcm";
    localq.tDo = "/sdcard/2.x264";
    localq.tDq = 0;
    localq.gOY = 0;
    localq.tDr = 0;
    AppMethodBeat.o(89462);
    return localq;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(89461);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fps=").append(this.fps).append('\n');
    ((StringBuilder)localObject).append("width=").append(this.pUc).append('\n');
    ((StringBuilder)localObject).append("height=").append(this.pUd).append('\n');
    ((StringBuilder)localObject).append("bitrate=").append(this.tDg).append('\n');
    ((StringBuilder)localObject).append("rotate=").append(this.dwp).append('\n');
    ((StringBuilder)localObject).append("yuvWidth=").append(this.tDi).append('\n');
    ((StringBuilder)localObject).append("yuvHeight=").append(this.tDh).append('\n');
    ((StringBuilder)localObject).append("x264Speed=").append(this.tDj).append('\n');
    ((StringBuilder)localObject).append("x264Quality=").append(this.tDk).append('\n');
    ((StringBuilder)localObject).append("yuvFile=").append(this.tDl).append('\n');
    ((StringBuilder)localObject).append("pcmFile=").append(this.tDm).append('\n');
    ((StringBuilder)localObject).append("thuFile=").append(this.tDn).append('\n');
    ((StringBuilder)localObject).append("x264File=").append(this.tDo).append('\n');
    ((StringBuilder)localObject).append("mp4File=").append(this.tDp).append('\n');
    ((StringBuilder)localObject).append("videoFrameCnt=").append(this.tDq).append('\n');
    ((StringBuilder)localObject).append("videoLength=").append(this.gOY).append('\n');
    ((StringBuilder)localObject).append("cameraCount=").append(this.tDr).append('\n');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(89461);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.q
 * JD-Core Version:    0.7.0.1
 */