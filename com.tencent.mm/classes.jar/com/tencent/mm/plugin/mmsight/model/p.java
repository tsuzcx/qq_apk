package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.ad;

public final class p
{
  public int gbj = 2;
  public int hpj = -1;
  public VideoTransPara hvh;
  public boolean hwb = false;
  public int juM = -1;
  public boolean pQy = true;
  public int vOB = 1;
  public int vOC = -1;
  public boolean vOD = false;
  public boolean vOE = true;
  public boolean vOF = false;
  h.c vOG;
  public boolean vOn = false;
  public int videoBitrate;
  
  public p() {}
  
  private p(int paramInt, VideoTransPara paramVideoTransPara)
  {
    this.hvh = paramVideoTransPara;
    this.gbj = paramInt;
    this.videoBitrate = paramVideoTransPara.videoBitrate;
    this.hpj = paramVideoTransPara.width;
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
        paramVideoTransPara.vOC = paramInt;
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
  
  private p dnd()
  {
    this.hpj = 1080;
    if ((this.juM > 0) && (this.hpj > this.juM)) {
      this.hpj = this.juM;
    }
    return this;
  }
  
  private static p e(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89448);
    ad.i("MicroMsg.RecoderParameter", "setToPresetConfig1");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.vOD = false;
    AppMethodBeat.o(89448);
    return paramVideoTransPara;
  }
  
  private static p f(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89449);
    ad.i("MicroMsg.RecoderParameter", "setToPresetConfig2");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.vOD = false;
    paramVideoTransPara = paramVideoTransPara.dnb().dna();
    AppMethodBeat.o(89449);
    return paramVideoTransPara;
  }
  
  private static p g(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89450);
    ad.i("MicroMsg.RecoderParameter", "setToPresetConfig3");
    paramVideoTransPara = new p(1, paramVideoTransPara);
    paramVideoTransPara.vOD = false;
    AppMethodBeat.o(89450);
    return paramVideoTransPara;
  }
  
  private static p h(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89451);
    ad.i("MicroMsg.RecoderParameter", "setToPresetConfig4");
    paramVideoTransPara = new p(1, paramVideoTransPara);
    paramVideoTransPara.vOD = false;
    paramVideoTransPara = paramVideoTransPara.dnb().dna();
    AppMethodBeat.o(89451);
    return paramVideoTransPara;
  }
  
  private static p i(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89452);
    ad.i("MicroMsg.RecoderParameter", "setToPresetConfig5");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.vOD = true;
    paramVideoTransPara.hwb = false;
    paramVideoTransPara = paramVideoTransPara.dna();
    AppMethodBeat.o(89452);
    return paramVideoTransPara;
  }
  
  private static p j(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89453);
    ad.i("MicroMsg.RecoderParameter", "setToPresetConfig6");
    paramVideoTransPara = new p(1, paramVideoTransPara);
    paramVideoTransPara.vOD = true;
    paramVideoTransPara = paramVideoTransPara.dna();
    AppMethodBeat.o(89453);
    return paramVideoTransPara;
  }
  
  private static p k(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89454);
    ad.i("MicroMsg.RecoderParameter", "setToPresetConfig7");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.vOD = true;
    paramVideoTransPara = paramVideoTransPara.dnc();
    paramVideoTransPara.hwb = false;
    AppMethodBeat.o(89454);
    return paramVideoTransPara;
  }
  
  private static p l(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89455);
    ad.i("MicroMsg.RecoderParameter", "setToPresetConfig8");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.vOD = true;
    paramVideoTransPara = paramVideoTransPara.dnc();
    paramVideoTransPara.hwb = true;
    AppMethodBeat.o(89455);
    return paramVideoTransPara;
  }
  
  private static p m(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89456);
    paramVideoTransPara = new p(1, paramVideoTransPara);
    paramVideoTransPara.vOD = true;
    paramVideoTransPara = paramVideoTransPara.dnc();
    paramVideoTransPara.hwb = false;
    AppMethodBeat.o(89456);
    return paramVideoTransPara;
  }
  
  private static p n(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89457);
    ad.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
    paramVideoTransPara = new p(1, paramVideoTransPara);
    paramVideoTransPara.vOD = true;
    paramVideoTransPara = paramVideoTransPara.dnc();
    paramVideoTransPara.hwb = true;
    AppMethodBeat.o(89457);
    return paramVideoTransPara;
  }
  
  private static p o(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89458);
    ad.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.vOD = true;
    paramVideoTransPara = paramVideoTransPara.dnc();
    paramVideoTransPara.hwb = false;
    paramVideoTransPara = paramVideoTransPara.dnb();
    AppMethodBeat.o(89458);
    return paramVideoTransPara;
  }
  
  private static p p(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89459);
    ad.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.vOD = true;
    paramVideoTransPara = paramVideoTransPara.dnd();
    paramVideoTransPara.hwb = false;
    paramVideoTransPara = paramVideoTransPara.dnb();
    AppMethodBeat.o(89459);
    return paramVideoTransPara;
  }
  
  public final p dna()
  {
    this.hpj = 720;
    if ((this.juM > 0) && (this.hpj > this.juM)) {
      this.hpj = this.juM;
    }
    return this;
  }
  
  public final p dnb()
  {
    this.videoBitrate = (this.hvh.videoBitrate * 2);
    this.vOF = true;
    return this;
  }
  
  public final p dnc()
  {
    this.hpj = (this.hvh.width * 2);
    if ((this.juM > 0) && (this.hpj > this.juM)) {
      this.hpj = this.juM;
    }
    return this;
  }
  
  public final boolean dne()
  {
    return this.hvh.width < this.hpj;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(89460);
    String str = String.format("mediatype %s videoBitrate : %s isEnableLandscapeMode %s needRotateEachFrame %s isNeedRealtimeScale %s resolutionLimit %s videoParams %s", new Object[] { Integer.valueOf(this.gbj), Integer.valueOf(this.videoBitrate), Boolean.valueOf(this.vOn), Boolean.valueOf(this.hwb), Boolean.valueOf(this.vOD), Integer.valueOf(this.hpj), this.hvh });
    AppMethodBeat.o(89460);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.p
 * JD-Core Version:    0.7.0.1
 */