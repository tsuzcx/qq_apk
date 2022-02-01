package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.ac;

public final class p
{
  public int fHJ = 2;
  public int gXd = -1;
  public VideoTransPara hcZ;
  public boolean hdT = false;
  public int jbD = -1;
  public boolean pmY = true;
  h.c uLA;
  public boolean uLh = false;
  public int uLv = 1;
  public int uLw = -1;
  public boolean uLx = false;
  public boolean uLy = true;
  public boolean uLz = false;
  public int videoBitrate;
  
  public p() {}
  
  private p(int paramInt, VideoTransPara paramVideoTransPara)
  {
    this.hcZ = paramVideoTransPara;
    this.fHJ = paramInt;
    this.videoBitrate = paramVideoTransPara.videoBitrate;
    this.gXd = paramVideoTransPara.width;
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
        paramVideoTransPara.uLw = paramInt;
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
  
  private p ddH()
  {
    this.gXd = 1080;
    if ((this.jbD > 0) && (this.gXd > this.jbD)) {
      this.gXd = this.jbD;
    }
    return this;
  }
  
  private static p e(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89448);
    ac.i("MicroMsg.RecoderParameter", "setToPresetConfig1");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.uLx = false;
    AppMethodBeat.o(89448);
    return paramVideoTransPara;
  }
  
  private static p f(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89449);
    ac.i("MicroMsg.RecoderParameter", "setToPresetConfig2");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.uLx = false;
    paramVideoTransPara = paramVideoTransPara.ddF().ddE();
    AppMethodBeat.o(89449);
    return paramVideoTransPara;
  }
  
  private static p g(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89450);
    ac.i("MicroMsg.RecoderParameter", "setToPresetConfig3");
    paramVideoTransPara = new p(1, paramVideoTransPara);
    paramVideoTransPara.uLx = false;
    AppMethodBeat.o(89450);
    return paramVideoTransPara;
  }
  
  private static p h(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89451);
    ac.i("MicroMsg.RecoderParameter", "setToPresetConfig4");
    paramVideoTransPara = new p(1, paramVideoTransPara);
    paramVideoTransPara.uLx = false;
    paramVideoTransPara = paramVideoTransPara.ddF().ddE();
    AppMethodBeat.o(89451);
    return paramVideoTransPara;
  }
  
  private static p i(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89452);
    ac.i("MicroMsg.RecoderParameter", "setToPresetConfig5");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.uLx = true;
    paramVideoTransPara.hdT = false;
    paramVideoTransPara = paramVideoTransPara.ddE();
    AppMethodBeat.o(89452);
    return paramVideoTransPara;
  }
  
  private static p j(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89453);
    ac.i("MicroMsg.RecoderParameter", "setToPresetConfig6");
    paramVideoTransPara = new p(1, paramVideoTransPara);
    paramVideoTransPara.uLx = true;
    paramVideoTransPara = paramVideoTransPara.ddE();
    AppMethodBeat.o(89453);
    return paramVideoTransPara;
  }
  
  private static p k(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89454);
    ac.i("MicroMsg.RecoderParameter", "setToPresetConfig7");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.uLx = true;
    paramVideoTransPara = paramVideoTransPara.ddG();
    paramVideoTransPara.hdT = false;
    AppMethodBeat.o(89454);
    return paramVideoTransPara;
  }
  
  private static p l(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89455);
    ac.i("MicroMsg.RecoderParameter", "setToPresetConfig8");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.uLx = true;
    paramVideoTransPara = paramVideoTransPara.ddG();
    paramVideoTransPara.hdT = true;
    AppMethodBeat.o(89455);
    return paramVideoTransPara;
  }
  
  private static p m(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89456);
    paramVideoTransPara = new p(1, paramVideoTransPara);
    paramVideoTransPara.uLx = true;
    paramVideoTransPara = paramVideoTransPara.ddG();
    paramVideoTransPara.hdT = false;
    AppMethodBeat.o(89456);
    return paramVideoTransPara;
  }
  
  private static p n(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89457);
    ac.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
    paramVideoTransPara = new p(1, paramVideoTransPara);
    paramVideoTransPara.uLx = true;
    paramVideoTransPara = paramVideoTransPara.ddG();
    paramVideoTransPara.hdT = true;
    AppMethodBeat.o(89457);
    return paramVideoTransPara;
  }
  
  private static p o(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89458);
    ac.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.uLx = true;
    paramVideoTransPara = paramVideoTransPara.ddG();
    paramVideoTransPara.hdT = false;
    paramVideoTransPara = paramVideoTransPara.ddF();
    AppMethodBeat.o(89458);
    return paramVideoTransPara;
  }
  
  private static p p(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89459);
    ac.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
    paramVideoTransPara = new p(2, paramVideoTransPara);
    paramVideoTransPara.uLx = true;
    paramVideoTransPara = paramVideoTransPara.ddH();
    paramVideoTransPara.hdT = false;
    paramVideoTransPara = paramVideoTransPara.ddF();
    AppMethodBeat.o(89459);
    return paramVideoTransPara;
  }
  
  public final p ddE()
  {
    this.gXd = 720;
    if ((this.jbD > 0) && (this.gXd > this.jbD)) {
      this.gXd = this.jbD;
    }
    return this;
  }
  
  public final p ddF()
  {
    this.videoBitrate = (this.hcZ.videoBitrate * 2);
    this.uLz = true;
    return this;
  }
  
  public final p ddG()
  {
    this.gXd = (this.hcZ.width * 2);
    if ((this.jbD > 0) && (this.gXd > this.jbD)) {
      this.gXd = this.jbD;
    }
    return this;
  }
  
  public final boolean ddI()
  {
    return this.hcZ.width < this.gXd;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(89460);
    String str = String.format("mediatype %s videoBitrate : %s isEnableLandscapeMode %s needRotateEachFrame %s isNeedRealtimeScale %s resolutionLimit %s videoParams %s", new Object[] { Integer.valueOf(this.fHJ), Integer.valueOf(this.videoBitrate), Boolean.valueOf(this.uLh), Boolean.valueOf(this.hdT), Boolean.valueOf(this.uLx), Integer.valueOf(this.gXd), this.hcZ });
    AppMethodBeat.o(89460);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.p
 * JD-Core Version:    0.7.0.1
 */