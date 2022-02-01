package com.tencent.mm.modelcontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class f
{
  protected int audioBitrate;
  protected String iST;
  protected int iSU;
  protected int iSV;
  protected boolean iSW;
  protected g[] iSX;
  protected int iiH;
  
  protected final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(126774);
    this.iST = paramString1;
    this.audioBitrate = Util.getInt(paramString2, 0);
    int i;
    if (this.audioBitrate == 0)
    {
      i = 64000;
      this.audioBitrate = i;
      this.iiH = Util.getInt(paramString3, 10);
      this.iSU = Util.getInt(paramString4, 2);
      this.iSV = Util.getInt(paramString5, 1);
      if (Util.getInt(paramString6, 0) <= 0) {
        break label103;
      }
    }
    label103:
    for (boolean bool = true;; bool = false)
    {
      this.iSW = bool;
      AppMethodBeat.o(126774);
      return;
      i = this.audioBitrate * 1000;
      break;
    }
  }
  
  protected final boolean bbo()
  {
    AppMethodBeat.i(126775);
    if (Util.isNullOrNil(this.iST))
    {
      AppMethodBeat.o(126775);
      return true;
    }
    boolean bool = b.Of(this.iST);
    AppMethodBeat.o(126775);
    return bool;
  }
  
  protected final VideoTransPara bbp()
  {
    AppMethodBeat.i(126776);
    Object localObject2 = null;
    Object localObject1 = null;
    if (this.iSX != null)
    {
      g[] arrayOfg = this.iSX;
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
          if (localg.iSY <= 0)
          {
            localObject2 = localObject1;
            if (localg.iSZ >= 0)
            {
              localObject2 = new VideoTransPara();
              ((VideoTransPara)localObject2).width = localg.iTa;
              ((VideoTransPara)localObject2).height = localg.iTb;
              ((VideoTransPara)localObject2).fps = localg.iTc;
              ((VideoTransPara)localObject2).videoBitrate = localg.iTd;
              ((VideoTransPara)localObject2).iiH = this.iiH;
              ((VideoTransPara)localObject2).audioBitrate = this.audioBitrate;
              ((VideoTransPara)localObject2).iSU = this.iSU;
              ((VideoTransPara)localObject2).iSV = this.iSV;
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
  
  protected final VideoTransPara bbq()
  {
    double d1 = 1.0D;
    AppMethodBeat.i(184645);
    VideoTransPara localVideoTransPara = bbp();
    if (localVideoTransPara == null)
    {
      AppMethodBeat.o(184645);
      return null;
    }
    if (localVideoTransPara.fps <= 0)
    {
      localVideoTransPara.iiH = 1;
      AppMethodBeat.o(184645);
      return localVideoTransPara;
    }
    double d2 = localVideoTransPara.iiH / localVideoTransPara.fps;
    if (d2 < 1.0D) {}
    for (;;)
    {
      localVideoTransPara.iiH = ((int)Math.ceil(d1));
      break;
      d1 = d2;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(126777);
    String str = "[ busyTime " + this.iST + " audioBitrate " + this.audioBitrate + " iFrame " + this.iiH + " profileIndex " + this.iSU + " presetIndex " + this.iSV + " isStepBr " + this.iSW + " ]";
    AppMethodBeat.o(126777);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.f
 * JD-Core Version:    0.7.0.1
 */