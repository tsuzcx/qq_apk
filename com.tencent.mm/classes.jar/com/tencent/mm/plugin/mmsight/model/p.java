package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.ad;

public final class p
{
  public int fEc = 2;
  public VideoTransPara gCB;
  public boolean gDs = false;
  public int gwG = -1;
  public int iBC = -1;
  public boolean oJA = true;
  public boolean tCK = false;
  public int tCY = 1;
  public int tCZ = -1;
  public boolean tDa = false;
  public boolean tDb = true;
  public boolean tDc = false;
  h.c tDd;
  public int videoBitrate;
  
  public p() {}
  
  private p(int paramInt, VideoTransPara paramVideoTransPara)
  {
    this.gCB = paramVideoTransPara;
    this.fEc = paramInt;
    this.videoBitrate = paramVideoTransPara.videoBitrate;
    this.gwG = paramVideoTransPara.width;
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
        paramVideoTransPara.tCZ = paramInt;
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
  
  private p cPZ()
  {
    this.gwG = 1080;
    if ((this.iBC > 0) && (this.gwG > this.iBC)) {
      this.gwG = this.iBC;
    }
    return this;
  }
  
  private static p e(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89448);
    ad.i("MicroMsg.RecoderParameter", "setToPresetConfig1");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.tDa = false;
    AppMethodBeat.o(89448);
    return paramVideoTransPara;
  }
  
  private static p f(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89449);
    ad.i("MicroMsg.RecoderParameter", "setToPresetConfig2");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.tDa = false;
    paramVideoTransPara = paramVideoTransPara.cPX().cPW();
    AppMethodBeat.o(89449);
    return paramVideoTransPara;
  }
  
  private static p g(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89450);
    ad.i("MicroMsg.RecoderParameter", "setToPresetConfig3");
    paramVideoTransPara = new p(1, paramVideoTransPara);
    paramVideoTransPara.tDa = false;
    AppMethodBeat.o(89450);
    return paramVideoTransPara;
  }
  
  private static p h(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89451);
    ad.i("MicroMsg.RecoderParameter", "setToPresetConfig4");
    paramVideoTransPara = new p(1, paramVideoTransPara);
    paramVideoTransPara.tDa = false;
    paramVideoTransPara = paramVideoTransPara.cPX().cPW();
    AppMethodBeat.o(89451);
    return paramVideoTransPara;
  }
  
  private static p i(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89452);
    ad.i("MicroMsg.RecoderParameter", "setToPresetConfig5");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.tDa = true;
    paramVideoTransPara.gDs = false;
    paramVideoTransPara = paramVideoTransPara.cPW();
    AppMethodBeat.o(89452);
    return paramVideoTransPara;
  }
  
  private static p j(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89453);
    ad.i("MicroMsg.RecoderParameter", "setToPresetConfig6");
    paramVideoTransPara = new p(1, paramVideoTransPara);
    paramVideoTransPara.tDa = true;
    paramVideoTransPara = paramVideoTransPara.cPW();
    AppMethodBeat.o(89453);
    return paramVideoTransPara;
  }
  
  private static p k(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89454);
    ad.i("MicroMsg.RecoderParameter", "setToPresetConfig7");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.tDa = true;
    paramVideoTransPara = paramVideoTransPara.cPY();
    paramVideoTransPara.gDs = false;
    AppMethodBeat.o(89454);
    return paramVideoTransPara;
  }
  
  private static p l(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89455);
    ad.i("MicroMsg.RecoderParameter", "setToPresetConfig8");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.tDa = true;
    paramVideoTransPara = paramVideoTransPara.cPY();
    paramVideoTransPara.gDs = true;
    AppMethodBeat.o(89455);
    return paramVideoTransPara;
  }
  
  private static p m(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89456);
    paramVideoTransPara = new p(1, paramVideoTransPara);
    paramVideoTransPara.tDa = true;
    paramVideoTransPara = paramVideoTransPara.cPY();
    paramVideoTransPara.gDs = false;
    AppMethodBeat.o(89456);
    return paramVideoTransPara;
  }
  
  private static p n(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89457);
    ad.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
    paramVideoTransPara = new p(1, paramVideoTransPara);
    paramVideoTransPara.tDa = true;
    paramVideoTransPara = paramVideoTransPara.cPY();
    paramVideoTransPara.gDs = true;
    AppMethodBeat.o(89457);
    return paramVideoTransPara;
  }
  
  private static p o(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89458);
    ad.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.tDa = true;
    paramVideoTransPara = paramVideoTransPara.cPY();
    paramVideoTransPara.gDs = false;
    paramVideoTransPara = paramVideoTransPara.cPX();
    AppMethodBeat.o(89458);
    return paramVideoTransPara;
  }
  
  private static p p(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89459);
    ad.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.tDa = true;
    paramVideoTransPara = paramVideoTransPara.cPZ();
    paramVideoTransPara.gDs = false;
    paramVideoTransPara = paramVideoTransPara.cPX();
    AppMethodBeat.o(89459);
    return paramVideoTransPara;
  }
  
  public final p cPW()
  {
    this.gwG = 720;
    if ((this.iBC > 0) && (this.gwG > this.iBC)) {
      this.gwG = this.iBC;
    }
    return this;
  }
  
  public final p cPX()
  {
    this.videoBitrate = (this.gCB.videoBitrate * 2);
    this.tDc = true;
    return this;
  }
  
  public final p cPY()
  {
    this.gwG = (this.gCB.width * 2);
    if ((this.iBC > 0) && (this.gwG > this.iBC)) {
      this.gwG = this.iBC;
    }
    return this;
  }
  
  public final boolean cQa()
  {
    return this.gCB.width < this.gwG;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(89460);
    String str = String.format("mediatype %s videoBitrate : %s isEnableLandscapeMode %s needRotateEachFrame %s isNeedRealtimeScale %s resolutionLimit %s videoParams %s", new Object[] { Integer.valueOf(this.fEc), Integer.valueOf(this.videoBitrate), Boolean.valueOf(this.tCK), Boolean.valueOf(this.gDs), Boolean.valueOf(this.tDa), Integer.valueOf(this.gwG), this.gCB });
    AppMethodBeat.o(89460);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.p
 * JD-Core Version:    0.7.0.1
 */