package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
{
  public static int Fao = 480;
  public static int Fap = 640;
  public int Faq;
  public int Far;
  public int Fas;
  public String Fat;
  public String Fau;
  public String Fav;
  public String Faw;
  public String Fax;
  public int Fay;
  public int Faz;
  public int fSM;
  public int fps;
  public int kUB;
  public int kUC;
  public int lvw;
  public int wAw;
  public int wAx;
  
  public static p eTA()
  {
    AppMethodBeat.i(89462);
    p localp = new p();
    localp.fps = 30;
    localp.fSM = 0;
    localp.kUC = Fap;
    localp.kUB = Fao;
    localp.wAx = Fap;
    localp.wAw = Fao;
    localp.Faq = 327680;
    localp.Far = 4;
    localp.Fas = 1;
    localp.Fat = "/sdcard/2.yuv";
    localp.Fax = "/sdcard/2.mp4";
    localp.Fau = "/sdcard/2.pcm";
    localp.Faw = "/sdcard/2.x264";
    localp.Fay = 0;
    localp.lvw = 0;
    localp.Faz = 0;
    AppMethodBeat.o(89462);
    return localp;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(89461);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fps=").append(this.fps).append('\n');
    ((StringBuilder)localObject).append("width=").append(this.wAw).append('\n');
    ((StringBuilder)localObject).append("height=").append(this.wAx).append('\n');
    ((StringBuilder)localObject).append("bitrate=").append(this.Faq).append('\n');
    ((StringBuilder)localObject).append("rotate=").append(this.fSM).append('\n');
    ((StringBuilder)localObject).append("yuvWidth=").append(this.kUB).append('\n');
    ((StringBuilder)localObject).append("yuvHeight=").append(this.kUC).append('\n');
    ((StringBuilder)localObject).append("x264Speed=").append(this.Far).append('\n');
    ((StringBuilder)localObject).append("x264Quality=").append(this.Fas).append('\n');
    ((StringBuilder)localObject).append("yuvFile=").append(this.Fat).append('\n');
    ((StringBuilder)localObject).append("pcmFile=").append(this.Fau).append('\n');
    ((StringBuilder)localObject).append("thuFile=").append(this.Fav).append('\n');
    ((StringBuilder)localObject).append("x264File=").append(this.Faw).append('\n');
    ((StringBuilder)localObject).append("mp4File=").append(this.Fax).append('\n');
    ((StringBuilder)localObject).append("videoFrameCnt=").append(this.Fay).append('\n');
    ((StringBuilder)localObject).append("videoLength=").append(this.lvw).append('\n');
    ((StringBuilder)localObject).append("cameraCount=").append(this.Faz).append('\n');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(89461);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.p
 * JD-Core Version:    0.7.0.1
 */