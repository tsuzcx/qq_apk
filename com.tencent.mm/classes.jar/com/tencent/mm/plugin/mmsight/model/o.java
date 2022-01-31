package com.tencent.mm.plugin.mmsight.model;

import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.y;

public final class o
{
  public int dys = 1;
  public VideoTransPara mfr;
  public int mgf = -1;
  public int mhK = -1;
  public boolean mhL = false;
  public boolean mhM = false;
  public boolean mhN = true;
  public boolean mhO = false;
  g.b mhP;
  public boolean mhy = false;
  public int videoBitrate;
  
  public o() {}
  
  private o(int paramInt, VideoTransPara paramVideoTransPara)
  {
    this.mfr = paramVideoTransPara;
    this.dys = paramInt;
    this.videoBitrate = paramVideoTransPara.videoBitrate;
    this.mgf = paramVideoTransPara.width;
  }
  
  public static o a(int paramInt, VideoTransPara paramVideoTransPara)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = null;
      return localObject;
    case 1: 
      y.i("MicroMsg.RecoderParameter", "setToPresetConfig1");
      paramVideoTransPara = new o(2, paramVideoTransPara);
      paramVideoTransPara.mhM = false;
    }
    for (;;)
    {
      localObject = paramVideoTransPara;
      if (paramVideoTransPara == null) {
        break;
      }
      paramVideoTransPara.mhK = paramInt;
      return paramVideoTransPara;
      y.i("MicroMsg.RecoderParameter", "setToPresetConfig2");
      paramVideoTransPara = new o(2, paramVideoTransPara);
      paramVideoTransPara.mhM = false;
      paramVideoTransPara = paramVideoTransPara.bjb().bja();
      continue;
      y.i("MicroMsg.RecoderParameter", "setToPresetConfig3");
      paramVideoTransPara = new o(1, paramVideoTransPara);
      paramVideoTransPara.mhM = false;
      continue;
      y.i("MicroMsg.RecoderParameter", "setToPresetConfig4");
      paramVideoTransPara = new o(1, paramVideoTransPara);
      paramVideoTransPara.mhM = false;
      paramVideoTransPara = paramVideoTransPara.bjb().bja();
      continue;
      y.i("MicroMsg.RecoderParameter", "setToPresetConfig5");
      paramVideoTransPara = new o(2, paramVideoTransPara);
      paramVideoTransPara.mhM = true;
      paramVideoTransPara.mhL = false;
      paramVideoTransPara = paramVideoTransPara.bja();
      continue;
      y.i("MicroMsg.RecoderParameter", "setToPresetConfig6");
      paramVideoTransPara = new o(1, paramVideoTransPara);
      paramVideoTransPara.mhM = true;
      paramVideoTransPara = paramVideoTransPara.bja();
      continue;
      y.i("MicroMsg.RecoderParameter", "setToPresetConfig7");
      paramVideoTransPara = new o(2, paramVideoTransPara);
      paramVideoTransPara.mhM = true;
      paramVideoTransPara = paramVideoTransPara.bjc();
      paramVideoTransPara.mhL = false;
      continue;
      y.i("MicroMsg.RecoderParameter", "setToPresetConfig8");
      paramVideoTransPara = new o(2, paramVideoTransPara);
      paramVideoTransPara.mhM = true;
      paramVideoTransPara = paramVideoTransPara.bjc();
      paramVideoTransPara.mhL = true;
      continue;
      paramVideoTransPara = new o(1, paramVideoTransPara);
      paramVideoTransPara.mhM = true;
      paramVideoTransPara = paramVideoTransPara.bjc();
      paramVideoTransPara.mhL = false;
      continue;
      y.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
      paramVideoTransPara = new o(1, paramVideoTransPara);
      paramVideoTransPara.mhM = true;
      paramVideoTransPara = paramVideoTransPara.bjc();
      paramVideoTransPara.mhL = true;
      continue;
      y.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
      paramVideoTransPara = new o(2, paramVideoTransPara);
      paramVideoTransPara.mhM = true;
      paramVideoTransPara = paramVideoTransPara.bjc();
      paramVideoTransPara.mhL = false;
      paramVideoTransPara = paramVideoTransPara.bjb();
    }
  }
  
  public final o bja()
  {
    this.mgf = 720;
    return this;
  }
  
  public final o bjb()
  {
    this.videoBitrate = (this.mfr.videoBitrate * 2);
    this.mhO = true;
    return this;
  }
  
  public final o bjc()
  {
    this.mgf = (this.mfr.width * 2);
    return this;
  }
  
  public final boolean bjd()
  {
    return this.mfr.width < this.mgf;
  }
  
  public final String toString()
  {
    return String.format("mediatype %s videoBitrate : %s isEnableLandscapeMode %s needRotateEachFrame %s isNeedRealtimeScale %s resolutionLimit %s videoParams %s", new Object[] { Integer.valueOf(this.dys), Integer.valueOf(this.videoBitrate), Boolean.valueOf(this.mhy), Boolean.valueOf(this.mhL), Boolean.valueOf(this.mhM), Integer.valueOf(this.mgf), this.mfr });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.o
 * JD-Core Version:    0.7.0.1
 */