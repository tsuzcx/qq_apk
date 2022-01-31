package com.tencent.mm.plugin.mmsight.model;

public final class p
{
  public static int mhQ = 480;
  public static int mhR = 640;
  public int eHH;
  public int fps;
  public int jSV;
  public int jSW;
  public int jlS;
  public int mhS;
  public int mhT;
  public int mhU;
  public int mhV;
  public int mhW;
  public String mhX;
  public String mhY;
  public String mhZ;
  public String mia;
  public String mib;
  public int mic;
  public int rotate;
  
  public static p bje()
  {
    p localp = new p();
    localp.fps = 30;
    localp.rotate = 0;
    localp.mhT = mhR;
    localp.mhU = mhQ;
    localp.jSW = mhR;
    localp.jSV = mhQ;
    localp.mhS = 327680;
    localp.mhV = 4;
    localp.mhW = 1;
    localp.mhX = "/sdcard/2.yuv";
    localp.mib = "/sdcard/2.mp4";
    localp.mhY = "/sdcard/2.pcm";
    localp.mia = "/sdcard/2.x264";
    localp.mic = 0;
    localp.eHH = 0;
    localp.jlS = 0;
    return localp;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fps=").append(this.fps).append('\n');
    localStringBuilder.append("width=").append(this.jSV).append('\n');
    localStringBuilder.append("height=").append(this.jSW).append('\n');
    localStringBuilder.append("bitrate=").append(this.mhS).append('\n');
    localStringBuilder.append("rotate=").append(this.rotate).append('\n');
    localStringBuilder.append("yuvWidth=").append(this.mhU).append('\n');
    localStringBuilder.append("yuvHeight=").append(this.mhT).append('\n');
    localStringBuilder.append("x264Speed=").append(this.mhV).append('\n');
    localStringBuilder.append("x264Quality=").append(this.mhW).append('\n');
    localStringBuilder.append("yuvFile=").append(this.mhX).append('\n');
    localStringBuilder.append("pcmFile=").append(this.mhY).append('\n');
    localStringBuilder.append("thuFile=").append(this.mhZ).append('\n');
    localStringBuilder.append("x264File=").append(this.mia).append('\n');
    localStringBuilder.append("mp4File=").append(this.mib).append('\n');
    localStringBuilder.append("videoFrameCnt=").append(this.mic).append('\n');
    localStringBuilder.append("videoLength=").append(this.eHH).append('\n');
    localStringBuilder.append("cameraCount=").append(this.jlS).append('\n');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.p
 * JD-Core Version:    0.7.0.1
 */