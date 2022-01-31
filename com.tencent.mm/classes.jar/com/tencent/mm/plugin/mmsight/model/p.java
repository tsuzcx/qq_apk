package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
{
  public static int oHW = 480;
  public static int oHX = 640;
  public int fXx;
  public int fps;
  public int mnr;
  public int mns;
  public int oHY;
  public int oHZ;
  public int oIa;
  public int oIb;
  public int oIc;
  public String oId;
  public String oIe;
  public String oIf;
  public String oIg;
  public String oIh;
  public int oIi;
  public int oIj;
  public int rotate;
  
  public static p bRh()
  {
    AppMethodBeat.i(76561);
    p localp = new p();
    localp.fps = 30;
    localp.rotate = 0;
    localp.oHZ = oHX;
    localp.oIa = oHW;
    localp.mns = oHX;
    localp.mnr = oHW;
    localp.oHY = 327680;
    localp.oIb = 4;
    localp.oIc = 1;
    localp.oId = "/sdcard/2.yuv";
    localp.oIh = "/sdcard/2.mp4";
    localp.oIe = "/sdcard/2.pcm";
    localp.oIg = "/sdcard/2.x264";
    localp.oIi = 0;
    localp.fXx = 0;
    localp.oIj = 0;
    AppMethodBeat.o(76561);
    return localp;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(76560);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fps=").append(this.fps).append('\n');
    ((StringBuilder)localObject).append("width=").append(this.mnr).append('\n');
    ((StringBuilder)localObject).append("height=").append(this.mns).append('\n');
    ((StringBuilder)localObject).append("bitrate=").append(this.oHY).append('\n');
    ((StringBuilder)localObject).append("rotate=").append(this.rotate).append('\n');
    ((StringBuilder)localObject).append("yuvWidth=").append(this.oIa).append('\n');
    ((StringBuilder)localObject).append("yuvHeight=").append(this.oHZ).append('\n');
    ((StringBuilder)localObject).append("x264Speed=").append(this.oIb).append('\n');
    ((StringBuilder)localObject).append("x264Quality=").append(this.oIc).append('\n');
    ((StringBuilder)localObject).append("yuvFile=").append(this.oId).append('\n');
    ((StringBuilder)localObject).append("pcmFile=").append(this.oIe).append('\n');
    ((StringBuilder)localObject).append("thuFile=").append(this.oIf).append('\n');
    ((StringBuilder)localObject).append("x264File=").append(this.oIg).append('\n');
    ((StringBuilder)localObject).append("mp4File=").append(this.oIh).append('\n');
    ((StringBuilder)localObject).append("videoFrameCnt=").append(this.oIi).append('\n');
    ((StringBuilder)localObject).append("videoLength=").append(this.fXx).append('\n');
    ((StringBuilder)localObject).append("cameraCount=").append(this.oIj).append('\n');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(76560);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.p
 * JD-Core Version:    0.7.0.1
 */