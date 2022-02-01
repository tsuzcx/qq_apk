package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.ae;

public final class p
{
  public int gdr = 2;
  public int hrX = -1;
  public VideoTransPara hxV;
  public boolean hyP = false;
  public int jxH = -1;
  public boolean pXd = true;
  public int videoBitrate;
  public int waE = 1;
  public int waF = -1;
  public boolean waG = false;
  public boolean waH = true;
  public boolean waI = false;
  h.c waJ;
  public boolean waq = false;
  
  public p() {}
  
  private p(int paramInt, VideoTransPara paramVideoTransPara)
  {
    this.hxV = paramVideoTransPara;
    this.gdr = paramInt;
    this.videoBitrate = paramVideoTransPara.videoBitrate;
    this.hrX = paramVideoTransPara.width;
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
        paramVideoTransPara.waF = paramInt;
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
  
  private p dqb()
  {
    this.hrX = 1080;
    if ((this.jxH > 0) && (this.hrX > this.jxH)) {
      this.hrX = this.jxH;
    }
    return this;
  }
  
  private static p e(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89448);
    ae.i("MicroMsg.RecoderParameter", "setToPresetConfig1");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.waG = false;
    AppMethodBeat.o(89448);
    return paramVideoTransPara;
  }
  
  private static p f(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89449);
    ae.i("MicroMsg.RecoderParameter", "setToPresetConfig2");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.waG = false;
    paramVideoTransPara = paramVideoTransPara.dpZ().dpY();
    AppMethodBeat.o(89449);
    return paramVideoTransPara;
  }
  
  private static p g(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89450);
    ae.i("MicroMsg.RecoderParameter", "setToPresetConfig3");
    paramVideoTransPara = new p(1, paramVideoTransPara);
    paramVideoTransPara.waG = false;
    AppMethodBeat.o(89450);
    return paramVideoTransPara;
  }
  
  private static p h(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89451);
    ae.i("MicroMsg.RecoderParameter", "setToPresetConfig4");
    paramVideoTransPara = new p(1, paramVideoTransPara);
    paramVideoTransPara.waG = false;
    paramVideoTransPara = paramVideoTransPara.dpZ().dpY();
    AppMethodBeat.o(89451);
    return paramVideoTransPara;
  }
  
  private static p i(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89452);
    ae.i("MicroMsg.RecoderParameter", "setToPresetConfig5");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.waG = true;
    paramVideoTransPara.hyP = false;
    paramVideoTransPara = paramVideoTransPara.dpY();
    AppMethodBeat.o(89452);
    return paramVideoTransPara;
  }
  
  private static p j(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89453);
    ae.i("MicroMsg.RecoderParameter", "setToPresetConfig6");
    paramVideoTransPara = new p(1, paramVideoTransPara);
    paramVideoTransPara.waG = true;
    paramVideoTransPara = paramVideoTransPara.dpY();
    AppMethodBeat.o(89453);
    return paramVideoTransPara;
  }
  
  private static p k(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89454);
    ae.i("MicroMsg.RecoderParameter", "setToPresetConfig7");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.waG = true;
    paramVideoTransPara = paramVideoTransPara.dqa();
    paramVideoTransPara.hyP = false;
    AppMethodBeat.o(89454);
    return paramVideoTransPara;
  }
  
  private static p l(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89455);
    ae.i("MicroMsg.RecoderParameter", "setToPresetConfig8");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.waG = true;
    paramVideoTransPara = paramVideoTransPara.dqa();
    paramVideoTransPara.hyP = true;
    AppMethodBeat.o(89455);
    return paramVideoTransPara;
  }
  
  private static p m(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89456);
    paramVideoTransPara = new p(1, paramVideoTransPara);
    paramVideoTransPara.waG = true;
    paramVideoTransPara = paramVideoTransPara.dqa();
    paramVideoTransPara.hyP = false;
    AppMethodBeat.o(89456);
    return paramVideoTransPara;
  }
  
  private static p n(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89457);
    ae.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
    paramVideoTransPara = new p(1, paramVideoTransPara);
    paramVideoTransPara.waG = true;
    paramVideoTransPara = paramVideoTransPara.dqa();
    paramVideoTransPara.hyP = true;
    AppMethodBeat.o(89457);
    return paramVideoTransPara;
  }
  
  private static p o(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89458);
    ae.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.waG = true;
    paramVideoTransPara = paramVideoTransPara.dqa();
    paramVideoTransPara.hyP = false;
    paramVideoTransPara = paramVideoTransPara.dpZ();
    AppMethodBeat.o(89458);
    return paramVideoTransPara;
  }
  
  private static p p(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89459);
    ae.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.waG = true;
    paramVideoTransPara = paramVideoTransPara.dqb();
    paramVideoTransPara.hyP = false;
    paramVideoTransPara = paramVideoTransPara.dpZ();
    AppMethodBeat.o(89459);
    return paramVideoTransPara;
  }
  
  public final p dpY()
  {
    this.hrX = 720;
    if ((this.jxH > 0) && (this.hrX > this.jxH)) {
      this.hrX = this.jxH;
    }
    return this;
  }
  
  public final p dpZ()
  {
    this.videoBitrate = (this.hxV.videoBitrate * 2);
    this.waI = true;
    return this;
  }
  
  public final p dqa()
  {
    this.hrX = (this.hxV.width * 2);
    if ((this.jxH > 0) && (this.hrX > this.jxH)) {
      this.hrX = this.jxH;
    }
    return this;
  }
  
  public final boolean dqc()
  {
    return this.hxV.width < this.hrX;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(89460);
    String str = String.format("mediatype %s videoBitrate : %s isEnableLandscapeMode %s needRotateEachFrame %s isNeedRealtimeScale %s resolutionLimit %s videoParams %s", new Object[] { Integer.valueOf(this.gdr), Integer.valueOf(this.videoBitrate), Boolean.valueOf(this.waq), Boolean.valueOf(this.hyP), Boolean.valueOf(this.waG), Integer.valueOf(this.hrX), this.hxV });
    AppMethodBeat.o(89460);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.p
 * JD-Core Version:    0.7.0.1
 */