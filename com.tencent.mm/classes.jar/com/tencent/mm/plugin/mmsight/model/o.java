package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.Log;

public final class o
{
  public int Ddk = -1;
  public boolean KVG = false;
  public int KVT = 1;
  public boolean KVU = false;
  public boolean KVV = true;
  public boolean KVW = false;
  h.c KVX;
  public int lWy = 2;
  public int nFY = -1;
  public VideoTransPara nLH;
  public boolean nME = false;
  public int qpX = -1;
  public int videoBitrate;
  public boolean ygy = true;
  
  public o() {}
  
  private o(int paramInt, VideoTransPara paramVideoTransPara)
  {
    this.nLH = paramVideoTransPara;
    this.lWy = paramInt;
    this.videoBitrate = paramVideoTransPara.videoBitrate;
    this.nFY = paramVideoTransPara.width;
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
        paramVideoTransPara.Ddk = paramInt;
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
    paramVideoTransPara.KVU = false;
    AppMethodBeat.o(89448);
    return paramVideoTransPara;
  }
  
  private static o f(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89449);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig2");
    paramVideoTransPara = new o(2, paramVideoTransPara);
    paramVideoTransPara.KVU = false;
    paramVideoTransPara = paramVideoTransPara.gcp().gco();
    AppMethodBeat.o(89449);
    return paramVideoTransPara;
  }
  
  private static o g(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89450);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig3");
    paramVideoTransPara = new o(1, paramVideoTransPara);
    paramVideoTransPara.KVU = false;
    AppMethodBeat.o(89450);
    return paramVideoTransPara;
  }
  
  private o gcr()
  {
    this.nFY = 1080;
    if ((this.qpX > 0) && (this.nFY > this.qpX)) {
      this.nFY = this.qpX;
    }
    return this;
  }
  
  private static o h(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89451);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig4");
    paramVideoTransPara = new o(1, paramVideoTransPara);
    paramVideoTransPara.KVU = false;
    paramVideoTransPara = paramVideoTransPara.gcp().gco();
    AppMethodBeat.o(89451);
    return paramVideoTransPara;
  }
  
  private static o i(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89452);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig5");
    paramVideoTransPara = new o(2, paramVideoTransPara);
    paramVideoTransPara.KVU = true;
    paramVideoTransPara.nME = false;
    paramVideoTransPara = paramVideoTransPara.gco();
    AppMethodBeat.o(89452);
    return paramVideoTransPara;
  }
  
  private static o j(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89453);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig6");
    paramVideoTransPara = new o(1, paramVideoTransPara);
    paramVideoTransPara.KVU = true;
    paramVideoTransPara = paramVideoTransPara.gco();
    AppMethodBeat.o(89453);
    return paramVideoTransPara;
  }
  
  private static o k(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89454);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig7");
    paramVideoTransPara = new o(2, paramVideoTransPara);
    paramVideoTransPara.KVU = true;
    paramVideoTransPara = paramVideoTransPara.gcq();
    paramVideoTransPara.nME = false;
    AppMethodBeat.o(89454);
    return paramVideoTransPara;
  }
  
  private static o l(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89455);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig8");
    paramVideoTransPara = new o(2, paramVideoTransPara);
    paramVideoTransPara.KVU = true;
    paramVideoTransPara = paramVideoTransPara.gcq();
    paramVideoTransPara.nME = true;
    AppMethodBeat.o(89455);
    return paramVideoTransPara;
  }
  
  private static o m(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89456);
    paramVideoTransPara = new o(1, paramVideoTransPara);
    paramVideoTransPara.KVU = true;
    paramVideoTransPara = paramVideoTransPara.gcq();
    paramVideoTransPara.nME = false;
    AppMethodBeat.o(89456);
    return paramVideoTransPara;
  }
  
  private static o n(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89457);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
    paramVideoTransPara = new o(1, paramVideoTransPara);
    paramVideoTransPara.KVU = true;
    paramVideoTransPara = paramVideoTransPara.gcq();
    paramVideoTransPara.nME = true;
    AppMethodBeat.o(89457);
    return paramVideoTransPara;
  }
  
  private static o o(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89458);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
    paramVideoTransPara = new o(2, paramVideoTransPara);
    paramVideoTransPara.KVU = true;
    paramVideoTransPara = paramVideoTransPara.gcq();
    paramVideoTransPara.nME = false;
    paramVideoTransPara = paramVideoTransPara.gcp();
    AppMethodBeat.o(89458);
    return paramVideoTransPara;
  }
  
  private static o p(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89459);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
    paramVideoTransPara = new o(2, paramVideoTransPara);
    paramVideoTransPara.KVU = true;
    paramVideoTransPara = paramVideoTransPara.gcr();
    paramVideoTransPara.nME = false;
    paramVideoTransPara = paramVideoTransPara.gcp();
    AppMethodBeat.o(89459);
    return paramVideoTransPara;
  }
  
  public final o gco()
  {
    this.nFY = 720;
    if ((this.qpX > 0) && (this.nFY > this.qpX)) {
      this.nFY = this.qpX;
    }
    return this;
  }
  
  public final o gcp()
  {
    this.videoBitrate = (this.nLH.videoBitrate * 2);
    this.KVW = true;
    return this;
  }
  
  public final o gcq()
  {
    this.nFY = (this.nLH.width * 2);
    if ((this.qpX > 0) && (this.nFY > this.qpX)) {
      this.nFY = this.qpX;
    }
    return this;
  }
  
  public final boolean gcs()
  {
    return this.nLH.width < this.nFY;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(89460);
    String str = String.format("mediatype %s videoBitrate : %s isEnableLandscapeMode %s needRotateEachFrame %s isNeedRealtimeScale %s resolutionLimit %s videoParams %s", new Object[] { Integer.valueOf(this.lWy), Integer.valueOf(this.videoBitrate), Boolean.valueOf(this.KVG), Boolean.valueOf(this.nME), Boolean.valueOf(this.KVU), Integer.valueOf(this.nFY), this.nLH });
    AppMethodBeat.o(89460);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.o
 * JD-Core Version:    0.7.0.1
 */