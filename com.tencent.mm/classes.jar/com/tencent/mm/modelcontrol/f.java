package com.tencent.mm.modelcontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class f
{
  protected int audioBitrate;
  protected int nCd;
  protected String oBN;
  protected int oBO;
  protected int oBP;
  protected boolean oBQ;
  protected g[] oBR;
  
  protected final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(126774);
    this.oBN = paramString1;
    this.audioBitrate = Util.getInt(paramString2, 0);
    int i;
    if (this.audioBitrate == 0)
    {
      i = 64000;
      this.audioBitrate = i;
      this.nCd = Util.getInt(paramString3, 10);
      this.oBO = Util.getInt(paramString4, 2);
      this.oBP = Util.getInt(paramString5, 1);
      if (Util.getInt(paramString6, 0) <= 0) {
        break label103;
      }
    }
    label103:
    for (boolean bool = true;; bool = false)
    {
      this.oBQ = bool;
      AppMethodBeat.o(126774);
      return;
      i = this.audioBitrate * 1000;
      break;
    }
  }
  
  protected final VideoTransPara bIA()
  {
    double d1 = 1.0D;
    AppMethodBeat.i(184645);
    VideoTransPara localVideoTransPara = bIz();
    if (localVideoTransPara == null)
    {
      AppMethodBeat.o(184645);
      return null;
    }
    if (localVideoTransPara.fps <= 0)
    {
      localVideoTransPara.nCd = 1;
      AppMethodBeat.o(184645);
      return localVideoTransPara;
    }
    double d2 = localVideoTransPara.nCd / localVideoTransPara.fps;
    if (d2 < 1.0D) {}
    for (;;)
    {
      localVideoTransPara.nCd = ((int)Math.ceil(d1));
      break;
      d1 = d2;
    }
  }
  
  protected final boolean bIy()
  {
    AppMethodBeat.i(126775);
    if (Util.isNullOrNil(this.oBN))
    {
      AppMethodBeat.o(126775);
      return true;
    }
    boolean bool = b.NB(this.oBN);
    AppMethodBeat.o(126775);
    return bool;
  }
  
  protected final VideoTransPara bIz()
  {
    AppMethodBeat.i(126776);
    Object localObject2 = null;
    Object localObject1 = null;
    if (this.oBR != null)
    {
      g[] arrayOfg = this.oBR;
      int j = arrayOfg.length;
      int i = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= j) {
          break;
        }
        g localg = arrayOfg[i];
        localObject2 = localObject1;
        if (localg != null)
        {
          localObject2 = localObject1;
          if (localg.oBS <= 0)
          {
            localObject2 = localObject1;
            if (localg.oBT >= 0)
            {
              localObject2 = new VideoTransPara();
              ((VideoTransPara)localObject2).width = localg.oBU;
              ((VideoTransPara)localObject2).height = localg.oBV;
              ((VideoTransPara)localObject2).fps = localg.oBW;
              ((VideoTransPara)localObject2).videoBitrate = localg.oBX;
              ((VideoTransPara)localObject2).nCd = this.nCd;
              ((VideoTransPara)localObject2).audioBitrate = this.audioBitrate;
              ((VideoTransPara)localObject2).oBO = this.oBO;
              ((VideoTransPara)localObject2).oBP = this.oBP;
            }
          }
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    AppMethodBeat.o(126776);
    return localObject2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(126777);
    String str = "[ busyTime " + this.oBN + " audioBitrate " + this.audioBitrate + " iFrame " + this.nCd + " profileIndex " + this.oBO + " presetIndex " + this.oBP + " isStepBr " + this.oBQ + " ]";
    AppMethodBeat.o(126777);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.f
 * JD-Core Version:    0.7.0.1
 */