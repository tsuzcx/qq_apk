package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mj
  extends a
{
  private long gGa;
  private long gHC;
  private long gIH;
  private long gJD;
  private long gKa;
  private int gKb;
  private long gKe;
  private long gTA;
  private long gTB;
  private long gTC;
  private long gTD;
  private long gTE;
  private long gTF;
  private long gTG;
  private long gTH;
  private long gTI;
  private long gTJ;
  private int gTK;
  private long gTL;
  private long gTM;
  private long gTN;
  private long gTO;
  private long gTP;
  private long gTQ;
  private long gTR;
  private long gTS;
  private long gTT;
  private long gTy;
  private long gTz;
  private String geh = "";
  private String gkb = "";
  private long gki;
  private long gkj;
  private long gkk;
  private long gkm;
  private long gkn;
  private long gnP;
  private long gxo;
  
  public final mj CL(String paramString)
  {
    AppMethodBeat.i(204852);
    this.gkb = z("FileId", paramString, true);
    AppMethodBeat.o(204852);
    return this;
  }
  
  public final mj CM(String paramString)
  {
    AppMethodBeat.i(204853);
    this.geh = z("MediaId", paramString, true);
    AppMethodBeat.o(204853);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(204871);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gKa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gGa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gxo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gki);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTT);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(204871);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(204872);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("UiStayTime:").append(this.gKa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileId:").append(this.gkb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MediaId:").append(this.geh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileLength:").append(this.gJD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgId:").append(this.gGa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayMode:").append(this.gTy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayDuration:").append(this.gIH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayErrorCode:").append(this.gKb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayWaitStartCost:").append(this.gTz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstFrameCost:").append(this.gxo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BufferingCount:").append(this.gTA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BufferingAvgDuration:").append(this.gTB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.gHC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartDownloadCost:").append(this.gTC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndDownloadCost:").append(this.gTD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadRetCode:").append(this.gTE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InitialDownloadLength:").append(this.gKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreloadSize:").append(this.gTF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadCompleted:").append(this.gTG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovWaitCost:").append(this.gTH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovOffset:").append(this.gTI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovLength:").append(this.gTJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovRetCode:").append(this.gTK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadMoovCompleted:").append(this.gTL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoBitrate:").append(this.gkj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoCodec:").append(this.gTM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoWidth:").append(this.gkm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoHeight:").append(this.gkn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoDuration:").append(this.gki);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoFPS:").append(this.gTN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoDecoderType:").append(this.gTO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AudioSampleRate:").append(this.gTP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AudioDecoderType:").append(this.gTQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AudioBitrate:").append(this.gkk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AudioChannel:").append(this.gTR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SeekCount:").append(this.gTS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SeekAvgCost:").append(this.gTT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(204872);
    return localObject;
  }
  
  public final long anL()
  {
    return this.gJD;
  }
  
  public final long anM()
  {
    return this.gTy;
  }
  
  public final long anN()
  {
    return this.gxo;
  }
  
  public final mj anO()
  {
    this.gTL = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 21772;
  }
  
  public final mj nN(int paramInt)
  {
    this.gKb = paramInt;
    return this;
  }
  
  public final mj nO(int paramInt)
  {
    this.gTK = paramInt;
    return this;
  }
  
  public final mj xA(long paramLong)
  {
    this.gTI = paramLong;
    return this;
  }
  
  public final mj xB(long paramLong)
  {
    this.gTJ = paramLong;
    return this;
  }
  
  public final mj xC(long paramLong)
  {
    this.gkj = paramLong;
    return this;
  }
  
  public final mj xD(long paramLong)
  {
    this.gTM = paramLong;
    return this;
  }
  
  public final mj xE(long paramLong)
  {
    this.gkm = paramLong;
    return this;
  }
  
  public final mj xF(long paramLong)
  {
    this.gkn = paramLong;
    return this;
  }
  
  public final mj xG(long paramLong)
  {
    this.gki = paramLong;
    return this;
  }
  
  public final mj xH(long paramLong)
  {
    this.gTN = paramLong;
    return this;
  }
  
  public final mj xI(long paramLong)
  {
    this.gTO = paramLong;
    return this;
  }
  
  public final mj xJ(long paramLong)
  {
    this.gTP = paramLong;
    return this;
  }
  
  public final mj xK(long paramLong)
  {
    this.gTQ = paramLong;
    return this;
  }
  
  public final mj xL(long paramLong)
  {
    this.gkk = paramLong;
    return this;
  }
  
  public final mj xM(long paramLong)
  {
    this.gTR = paramLong;
    return this;
  }
  
  public final mj xN(long paramLong)
  {
    this.gTS = paramLong;
    return this;
  }
  
  public final mj xO(long paramLong)
  {
    this.gTT = paramLong;
    return this;
  }
  
  public final mj xi(long paramLong)
  {
    this.gKa = paramLong;
    return this;
  }
  
  public final mj xj(long paramLong)
  {
    this.gnP = paramLong;
    return this;
  }
  
  public final mj xk(long paramLong)
  {
    this.gJD = paramLong;
    return this;
  }
  
  public final mj xl(long paramLong)
  {
    this.gGa = paramLong;
    return this;
  }
  
  public final mj xm(long paramLong)
  {
    this.gTy = paramLong;
    return this;
  }
  
  public final mj xn(long paramLong)
  {
    this.gIH = paramLong;
    return this;
  }
  
  public final mj xo(long paramLong)
  {
    this.gTz = paramLong;
    return this;
  }
  
  public final mj xp(long paramLong)
  {
    this.gxo = paramLong;
    return this;
  }
  
  public final mj xq(long paramLong)
  {
    this.gTA = paramLong;
    return this;
  }
  
  public final mj xr(long paramLong)
  {
    this.gTB = paramLong;
    return this;
  }
  
  public final mj xs(long paramLong)
  {
    this.gHC = paramLong;
    return this;
  }
  
  public final mj xt(long paramLong)
  {
    this.gTC = paramLong;
    return this;
  }
  
  public final mj xu(long paramLong)
  {
    this.gTD = paramLong;
    return this;
  }
  
  public final mj xv(long paramLong)
  {
    this.gTE = paramLong;
    return this;
  }
  
  public final mj xw(long paramLong)
  {
    this.gKe = paramLong;
    return this;
  }
  
  public final mj xx(long paramLong)
  {
    this.gTF = paramLong;
    return this;
  }
  
  public final mj xy(long paramLong)
  {
    this.gTG = paramLong;
    return this;
  }
  
  public final mj xz(long paramLong)
  {
    this.gTH = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.mj
 * JD-Core Version:    0.7.0.1
 */