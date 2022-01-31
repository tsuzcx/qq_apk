package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.ab;

public final class o
{
  public int eZQ = -1;
  public int eqK = 2;
  public VideoTransPara fcu;
  public boolean fdl = false;
  public int gNQ = -1;
  public boolean oHD = false;
  public int oHR = -1;
  public boolean oHS = false;
  public boolean oHT = true;
  public boolean oHU = false;
  g.b oHV;
  public int videoBitrate;
  
  public o() {}
  
  private o(int paramInt, VideoTransPara paramVideoTransPara)
  {
    this.fcu = paramVideoTransPara;
    this.eqK = paramInt;
    this.videoBitrate = paramVideoTransPara.videoBitrate;
    this.eZQ = paramVideoTransPara.width;
  }
  
  public static o a(int paramInt, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(76546);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(76546);
      return null;
    case 1: 
      paramVideoTransPara = e(paramVideoTransPara);
    }
    for (;;)
    {
      if (paramVideoTransPara != null) {
        paramVideoTransPara.oHR = paramInt;
      }
      AppMethodBeat.o(76546);
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
  
  private o bRf()
  {
    this.eZQ = 1080;
    if ((this.gNQ > 0) && (this.eZQ > this.gNQ)) {
      this.eZQ = this.gNQ;
    }
    return this;
  }
  
  private static o e(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(76547);
    ab.i("MicroMsg.RecoderParameter", "setToPresetConfig1");
    paramVideoTransPara = new o(2, paramVideoTransPara);
    paramVideoTransPara.oHS = false;
    AppMethodBeat.o(76547);
    return paramVideoTransPara;
  }
  
  private static o f(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(76548);
    ab.i("MicroMsg.RecoderParameter", "setToPresetConfig2");
    paramVideoTransPara = new o(2, paramVideoTransPara);
    paramVideoTransPara.oHS = false;
    paramVideoTransPara = paramVideoTransPara.bRd().bRc();
    AppMethodBeat.o(76548);
    return paramVideoTransPara;
  }
  
  private static o g(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(76549);
    ab.i("MicroMsg.RecoderParameter", "setToPresetConfig3");
    paramVideoTransPara = new o(1, paramVideoTransPara);
    paramVideoTransPara.oHS = false;
    AppMethodBeat.o(76549);
    return paramVideoTransPara;
  }
  
  private static o h(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(76550);
    ab.i("MicroMsg.RecoderParameter", "setToPresetConfig4");
    paramVideoTransPara = new o(1, paramVideoTransPara);
    paramVideoTransPara.oHS = false;
    paramVideoTransPara = paramVideoTransPara.bRd().bRc();
    AppMethodBeat.o(76550);
    return paramVideoTransPara;
  }
  
  private static o i(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(76551);
    ab.i("MicroMsg.RecoderParameter", "setToPresetConfig5");
    paramVideoTransPara = new o(2, paramVideoTransPara);
    paramVideoTransPara.oHS = true;
    paramVideoTransPara.fdl = false;
    paramVideoTransPara = paramVideoTransPara.bRc();
    AppMethodBeat.o(76551);
    return paramVideoTransPara;
  }
  
  private static o j(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(76552);
    ab.i("MicroMsg.RecoderParameter", "setToPresetConfig6");
    paramVideoTransPara = new o(1, paramVideoTransPara);
    paramVideoTransPara.oHS = true;
    paramVideoTransPara = paramVideoTransPara.bRc();
    AppMethodBeat.o(76552);
    return paramVideoTransPara;
  }
  
  private static o k(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(76553);
    ab.i("MicroMsg.RecoderParameter", "setToPresetConfig7");
    paramVideoTransPara = new o(2, paramVideoTransPara);
    paramVideoTransPara.oHS = true;
    paramVideoTransPara = paramVideoTransPara.bRe();
    paramVideoTransPara.fdl = false;
    AppMethodBeat.o(76553);
    return paramVideoTransPara;
  }
  
  private static o l(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(76554);
    ab.i("MicroMsg.RecoderParameter", "setToPresetConfig8");
    paramVideoTransPara = new o(2, paramVideoTransPara);
    paramVideoTransPara.oHS = true;
    paramVideoTransPara = paramVideoTransPara.bRe();
    paramVideoTransPara.fdl = true;
    AppMethodBeat.o(76554);
    return paramVideoTransPara;
  }
  
  private static o m(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(76555);
    paramVideoTransPara = new o(1, paramVideoTransPara);
    paramVideoTransPara.oHS = true;
    paramVideoTransPara = paramVideoTransPara.bRe();
    paramVideoTransPara.fdl = false;
    AppMethodBeat.o(76555);
    return paramVideoTransPara;
  }
  
  private static o n(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(76556);
    ab.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
    paramVideoTransPara = new o(1, paramVideoTransPara);
    paramVideoTransPara.oHS = true;
    paramVideoTransPara = paramVideoTransPara.bRe();
    paramVideoTransPara.fdl = true;
    AppMethodBeat.o(76556);
    return paramVideoTransPara;
  }
  
  private static o o(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(76557);
    ab.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
    paramVideoTransPara = new o(2, paramVideoTransPara);
    paramVideoTransPara.oHS = true;
    paramVideoTransPara = paramVideoTransPara.bRe();
    paramVideoTransPara.fdl = false;
    paramVideoTransPara = paramVideoTransPara.bRd();
    AppMethodBeat.o(76557);
    return paramVideoTransPara;
  }
  
  private static o p(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(76558);
    ab.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
    paramVideoTransPara = new o(2, paramVideoTransPara);
    paramVideoTransPara.oHS = true;
    paramVideoTransPara = paramVideoTransPara.bRf();
    paramVideoTransPara.fdl = false;
    paramVideoTransPara = paramVideoTransPara.bRd();
    AppMethodBeat.o(76558);
    return paramVideoTransPara;
  }
  
  public final o bRc()
  {
    this.eZQ = 720;
    if ((this.gNQ > 0) && (this.eZQ > this.gNQ)) {
      this.eZQ = this.gNQ;
    }
    return this;
  }
  
  public final o bRd()
  {
    this.videoBitrate = (this.fcu.videoBitrate * 2);
    this.oHU = true;
    return this;
  }
  
  public final o bRe()
  {
    this.eZQ = (this.fcu.width * 2);
    if ((this.gNQ > 0) && (this.eZQ > this.gNQ)) {
      this.eZQ = this.gNQ;
    }
    return this;
  }
  
  public final boolean bRg()
  {
    return this.fcu.width < this.eZQ;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(76559);
    String str = String.format("mediatype %s videoBitrate : %s isEnableLandscapeMode %s needRotateEachFrame %s isNeedRealtimeScale %s resolutionLimit %s videoParams %s", new Object[] { Integer.valueOf(this.eqK), Integer.valueOf(this.videoBitrate), Boolean.valueOf(this.oHD), Boolean.valueOf(this.fdl), Boolean.valueOf(this.oHS), Integer.valueOf(this.eZQ), this.fcu });
    AppMethodBeat.o(76559);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.o
 * JD-Core Version:    0.7.0.1
 */