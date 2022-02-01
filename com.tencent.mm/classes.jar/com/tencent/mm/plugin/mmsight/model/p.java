package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
{
  public static int KVY = 480;
  public static int KVZ = 640;
  public int KWa;
  public int KWb;
  public int KWc;
  public String KWd;
  public String KWe;
  public String KWf;
  public String KWg;
  public String KWh;
  public int KWi;
  public int fps;
  public int hYK;
  public int nAg;
  public int nAh;
  public int nvv;
  public int omT;
  public int zWH;
  public int zWI;
  
  public static p gct()
  {
    AppMethodBeat.i(89462);
    p localp = new p();
    localp.fps = 30;
    localp.hYK = 0;
    localp.nAh = KVZ;
    localp.nAg = KVY;
    localp.zWI = KVZ;
    localp.zWH = KVY;
    localp.KWa = 327680;
    localp.KWb = 4;
    localp.KWc = 1;
    localp.KWd = "/sdcard/2.yuv";
    localp.KWh = "/sdcard/2.mp4";
    localp.KWe = "/sdcard/2.pcm";
    localp.KWg = "/sdcard/2.x264";
    localp.KWi = 0;
    localp.omT = 0;
    localp.nvv = 0;
    AppMethodBeat.o(89462);
    return localp;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(89461);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fps=").append(this.fps).append('\n');
    ((StringBuilder)localObject).append("width=").append(this.zWH).append('\n');
    ((StringBuilder)localObject).append("height=").append(this.zWI).append('\n');
    ((StringBuilder)localObject).append("bitrate=").append(this.KWa).append('\n');
    ((StringBuilder)localObject).append("rotate=").append(this.hYK).append('\n');
    ((StringBuilder)localObject).append("yuvWidth=").append(this.nAg).append('\n');
    ((StringBuilder)localObject).append("yuvHeight=").append(this.nAh).append('\n');
    ((StringBuilder)localObject).append("x264Speed=").append(this.KWb).append('\n');
    ((StringBuilder)localObject).append("x264Quality=").append(this.KWc).append('\n');
    ((StringBuilder)localObject).append("yuvFile=").append(this.KWd).append('\n');
    ((StringBuilder)localObject).append("pcmFile=").append(this.KWe).append('\n');
    ((StringBuilder)localObject).append("thuFile=").append(this.KWf).append('\n');
    ((StringBuilder)localObject).append("x264File=").append(this.KWg).append('\n');
    ((StringBuilder)localObject).append("mp4File=").append(this.KWh).append('\n');
    ((StringBuilder)localObject).append("videoFrameCnt=").append(this.KWi).append('\n');
    ((StringBuilder)localObject).append("videoLength=").append(this.omT).append('\n');
    ((StringBuilder)localObject).append("cameraCount=").append(this.nvv).append('\n');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(89461);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.p
 * JD-Core Version:    0.7.0.1
 */