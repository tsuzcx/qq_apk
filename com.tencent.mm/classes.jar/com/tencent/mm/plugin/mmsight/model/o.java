package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.Log;

public final class o
{
  public boolean EZU = false;
  public int Fai = 1;
  public int Faj = -1;
  public boolean Fak = false;
  public boolean Fal = true;
  public boolean Fam = false;
  h.c Fan;
  public int jth = 2;
  public int laT = -1;
  public VideoTransPara lgX;
  public boolean lhV = false;
  public int nrq = -1;
  public boolean uTJ = true;
  public int videoBitrate;
  
  public o() {}
  
  private o(int paramInt, VideoTransPara paramVideoTransPara)
  {
    this.lgX = paramVideoTransPara;
    this.jth = paramInt;
    this.videoBitrate = paramVideoTransPara.videoBitrate;
    this.laT = paramVideoTransPara.width;
  }
  
  public static o a(int paramInt, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89447);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(89447);
      return null;
    case 1: 
      paramVideoTransPara = e(paramVideoTransPara);
    }
    for (;;)
    {
      if (paramVideoTransPara != null) {
        paramVideoTransPara.Faj = paramInt;
      }
      AppMethodBeat.o(89447);
      return paramVideoTransPara;
      paramVideoTransPara = f(paramVideoTransPara);
      continue;
      paramVideoTransPara = g(paramVideoTransPara);
      continue;
      paramVideoTransPara = h(paramVideoTransPara);
      continue;
      paramVideoTransPara = i(paramVideoTransPara);
      continue;
      paramVideoTransPara = j(paramVideoTransPara);
      continue;
      paramVideoTransPara = k(paramVideoTransPara);
      continue;
      paramVideoTransPara = l(paramVideoTransPara);
      continue;
      paramVideoTransPara = m(paramVideoTransPara);
      continue;
      paramVideoTransPara = n(paramVideoTransPara);
      continue;
      paramVideoTransPara = o(paramVideoTransPara);
      continue;
      paramVideoTransPara = p(paramVideoTransPara);
    }
  }
  
  private static o e(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89448);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig1");
    paramVideoTransPara = new o(2, paramVideoTransPara);
    paramVideoTransPara.Fak = false;
    AppMethodBeat.o(89448);
    return paramVideoTransPara;
  }
  
  private o eTy()
  {
    this.laT = 1080;
    if ((this.nrq > 0) && (this.laT > this.nrq)) {
      this.laT = this.nrq;
    }
    return this;
  }
  
  private static o f(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89449);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig2");
    paramVideoTransPara = new o(2, paramVideoTransPara);
    paramVideoTransPara.Fak = false;
    paramVideoTransPara = paramVideoTransPara.eTw().eTv();
    AppMethodBeat.o(89449);
    return paramVideoTransPara;
  }
  
  private static o g(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89450);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig3");
    paramVideoTransPara = new o(1, paramVideoTransPara);
    paramVideoTransPara.Fak = false;
    AppMethodBeat.o(89450);
    return paramVideoTransPara;
  }
  
  private static o h(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89451);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig4");
    paramVideoTransPara = new o(1, paramVideoTransPara);
    paramVideoTransPara.Fak = false;
    paramVideoTransPara = paramVideoTransPara.eTw().eTv();
    AppMethodBeat.o(89451);
    return paramVideoTransPara;
  }
  
  private static o i(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89452);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig5");
    paramVideoTransPara = new o(2, paramVideoTransPara);
    paramVideoTransPara.Fak = true;
    paramVideoTransPara.lhV = false;
    paramVideoTransPara = paramVideoTransPara.eTv();
    AppMethodBeat.o(89452);
    return paramVideoTransPara;
  }
  
  private static o j(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89453);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig6");
    paramVideoTransPara = new o(1, paramVideoTransPara);
    paramVideoTransPara.Fak = true;
    paramVideoTransPara = paramVideoTransPara.eTv();
    AppMethodBeat.o(89453);
    return paramVideoTransPara;
  }
  
  private static o k(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89454);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig7");
    paramVideoTransPara = new o(2, paramVideoTransPara);
    paramVideoTransPara.Fak = true;
    paramVideoTransPara = paramVideoTransPara.eTx();
    paramVideoTransPara.lhV = false;
    AppMethodBeat.o(89454);
    return paramVideoTransPara;
  }
  
  private static o l(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89455);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig8");
    paramVideoTransPara = new o(2, paramVideoTransPara);
    paramVideoTransPara.Fak = true;
    paramVideoTransPara = paramVideoTransPara.eTx();
    paramVideoTransPara.lhV = true;
    AppMethodBeat.o(89455);
    return paramVideoTransPara;
  }
  
  private static o m(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89456);
    paramVideoTransPara = new o(1, paramVideoTransPara);
    paramVideoTransPara.Fak = true;
    paramVideoTransPara = paramVideoTransPara.eTx();
    paramVideoTransPara.lhV = false;
    AppMethodBeat.o(89456);
    return paramVideoTransPara;
  }
  
  private static o n(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89457);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
    paramVideoTransPara = new o(1, paramVideoTransPara);
    paramVideoTransPara.Fak = true;
    paramVideoTransPara = paramVideoTransPara.eTx();
    paramVideoTransPara.lhV = true;
    AppMethodBeat.o(89457);
    return paramVideoTransPara;
  }
  
  private static o o(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89458);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
    paramVideoTransPara = new o(2, paramVideoTransPara);
    paramVideoTransPara.Fak = true;
    paramVideoTransPara = paramVideoTransPara.eTx();
    paramVideoTransPara.lhV = false;
    paramVideoTransPara = paramVideoTransPara.eTw();
    AppMethodBeat.o(89458);
    return paramVideoTransPara;
  }
  
  private static o p(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89459);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
    paramVideoTransPara = new o(2, paramVideoTransPara);
    paramVideoTransPara.Fak = true;
    paramVideoTransPara = paramVideoTransPara.eTy();
    paramVideoTransPara.lhV = false;
    paramVideoTransPara = paramVideoTransPara.eTw();
    AppMethodBeat.o(89459);
    return paramVideoTransPara;
  }
  
  public final o eTv()
  {
    this.laT = 720;
    if ((this.nrq > 0) && (this.laT > this.nrq)) {
      this.laT = this.nrq;
    }
    return this;
  }
  
  public final o eTw()
  {
    this.videoBitrate = (this.lgX.videoBitrate * 2);
    this.Fam = true;
    return this;
  }
  
  public final o eTx()
  {
    this.laT = (this.lgX.width * 2);
    if ((this.nrq > 0) && (this.laT > this.nrq)) {
      this.laT = this.nrq;
    }
    return this;
  }
  
  public final boolean eTz()
  {
    return this.lgX.width < this.laT;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(89460);
    String str = String.format("mediatype %s videoBitrate : %s isEnableLandscapeMode %s needRotateEachFrame %s isNeedRealtimeScale %s resolutionLimit %s videoParams %s", new Object[] { Integer.valueOf(this.jth), Integer.valueOf(this.videoBitrate), Boolean.valueOf(this.EZU), Boolean.valueOf(this.lhV), Boolean.valueOf(this.Fak), Integer.valueOf(this.laT), this.lgX });
    AppMethodBeat.o(89460);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.o
 * JD-Core Version:    0.7.0.1
 */