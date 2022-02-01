package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.Log;

public final class p
{
  public int gIP = 2;
  public int ilT = -1;
  public VideoTransPara irT;
  public boolean isQ = false;
  public int kyq = -1;
  public boolean roc = true;
  public int videoBitrate;
  public int zuJ = 1;
  public int zuK = -1;
  public boolean zuL = false;
  public boolean zuM = true;
  public boolean zuN = false;
  h.c zuO;
  public boolean zuv = false;
  
  public p() {}
  
  private p(int paramInt, VideoTransPara paramVideoTransPara)
  {
    this.irT = paramVideoTransPara;
    this.gIP = paramInt;
    this.videoBitrate = paramVideoTransPara.videoBitrate;
    this.ilT = paramVideoTransPara.width;
  }
  
  public static p a(int paramInt, VideoTransPara paramVideoTransPara)
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
        paramVideoTransPara.zuK = paramInt;
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
  
  private static p e(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89448);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig1");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.zuL = false;
    AppMethodBeat.o(89448);
    return paramVideoTransPara;
  }
  
  private p ejR()
  {
    this.ilT = 1080;
    if ((this.kyq > 0) && (this.ilT > this.kyq)) {
      this.ilT = this.kyq;
    }
    return this;
  }
  
  private static p f(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89449);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig2");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.zuL = false;
    paramVideoTransPara = paramVideoTransPara.ejP().ejO();
    AppMethodBeat.o(89449);
    return paramVideoTransPara;
  }
  
  private static p g(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89450);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig3");
    paramVideoTransPara = new p(1, paramVideoTransPara);
    paramVideoTransPara.zuL = false;
    AppMethodBeat.o(89450);
    return paramVideoTransPara;
  }
  
  private static p h(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89451);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig4");
    paramVideoTransPara = new p(1, paramVideoTransPara);
    paramVideoTransPara.zuL = false;
    paramVideoTransPara = paramVideoTransPara.ejP().ejO();
    AppMethodBeat.o(89451);
    return paramVideoTransPara;
  }
  
  private static p i(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89452);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig5");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.zuL = true;
    paramVideoTransPara.isQ = false;
    paramVideoTransPara = paramVideoTransPara.ejO();
    AppMethodBeat.o(89452);
    return paramVideoTransPara;
  }
  
  private static p j(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89453);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig6");
    paramVideoTransPara = new p(1, paramVideoTransPara);
    paramVideoTransPara.zuL = true;
    paramVideoTransPara = paramVideoTransPara.ejO();
    AppMethodBeat.o(89453);
    return paramVideoTransPara;
  }
  
  private static p k(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89454);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig7");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.zuL = true;
    paramVideoTransPara = paramVideoTransPara.ejQ();
    paramVideoTransPara.isQ = false;
    AppMethodBeat.o(89454);
    return paramVideoTransPara;
  }
  
  private static p l(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89455);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig8");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.zuL = true;
    paramVideoTransPara = paramVideoTransPara.ejQ();
    paramVideoTransPara.isQ = true;
    AppMethodBeat.o(89455);
    return paramVideoTransPara;
  }
  
  private static p m(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89456);
    paramVideoTransPara = new p(1, paramVideoTransPara);
    paramVideoTransPara.zuL = true;
    paramVideoTransPara = paramVideoTransPara.ejQ();
    paramVideoTransPara.isQ = false;
    AppMethodBeat.o(89456);
    return paramVideoTransPara;
  }
  
  private static p n(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89457);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
    paramVideoTransPara = new p(1, paramVideoTransPara);
    paramVideoTransPara.zuL = true;
    paramVideoTransPara = paramVideoTransPara.ejQ();
    paramVideoTransPara.isQ = true;
    AppMethodBeat.o(89457);
    return paramVideoTransPara;
  }
  
  private static p o(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89458);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.zuL = true;
    paramVideoTransPara = paramVideoTransPara.ejQ();
    paramVideoTransPara.isQ = false;
    paramVideoTransPara = paramVideoTransPara.ejP();
    AppMethodBeat.o(89458);
    return paramVideoTransPara;
  }
  
  private static p p(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89459);
    Log.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.zuL = true;
    paramVideoTransPara = paramVideoTransPara.ejR();
    paramVideoTransPara.isQ = false;
    paramVideoTransPara = paramVideoTransPara.ejP();
    AppMethodBeat.o(89459);
    return paramVideoTransPara;
  }
  
  public final p ejO()
  {
    this.ilT = 720;
    if ((this.kyq > 0) && (this.ilT > this.kyq)) {
      this.ilT = this.kyq;
    }
    return this;
  }
  
  public final p ejP()
  {
    this.videoBitrate = (this.irT.videoBitrate * 2);
    this.zuN = true;
    return this;
  }
  
  public final p ejQ()
  {
    this.ilT = (this.irT.width * 2);
    if ((this.kyq > 0) && (this.ilT > this.kyq)) {
      this.ilT = this.kyq;
    }
    return this;
  }
  
  public final boolean ejS()
  {
    return this.irT.width < this.ilT;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(89460);
    String str = String.format("mediatype %s videoBitrate : %s isEnableLandscapeMode %s needRotateEachFrame %s isNeedRealtimeScale %s resolutionLimit %s videoParams %s", new Object[] { Integer.valueOf(this.gIP), Integer.valueOf(this.videoBitrate), Boolean.valueOf(this.zuv), Boolean.valueOf(this.isQ), Boolean.valueOf(this.zuL), Integer.valueOf(this.ilT), this.irT });
    AppMethodBeat.o(89460);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.p
 * JD-Core Version:    0.7.0.1
 */