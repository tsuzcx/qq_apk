package com.tencent.mm.modelcontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class f
{
  protected int audioBitrate;
  protected int kXt;
  protected String lJl;
  protected int lJm;
  protected int lJn;
  protected boolean lJo;
  protected g[] lJp;
  
  protected final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(126774);
    this.lJl = paramString1;
    this.audioBitrate = Util.getInt(paramString2, 0);
    int i;
    if (this.audioBitrate == 0)
    {
      i = 64000;
      this.audioBitrate = i;
      this.kXt = Util.getInt(paramString3, 10);
      this.lJm = Util.getInt(paramString4, 2);
      this.lJn = Util.getInt(paramString5, 1);
      if (Util.getInt(paramString6, 0) <= 0) {
        break label103;
      }
    }
    label103:
    for (boolean bool = true;; bool = false)
    {
      this.lJo = bool;
      AppMethodBeat.o(126774);
      return;
      i = this.audioBitrate * 1000;
      break;
    }
  }
  
  protected final boolean bkE()
  {
    AppMethodBeat.i(126775);
    if (Util.isNullOrNil(this.lJl))
    {
      AppMethodBeat.o(126775);
      return true;
    }
    boolean bool = b.VC(this.lJl);
    AppMethodBeat.o(126775);
    return bool;
  }
  
  protected final VideoTransPara bkF()
  {
    AppMethodBeat.i(126776);
    Object localObject2 = null;
    Object localObject1 = null;
    if (this.lJp != null)
    {
      g[] arrayOfg = this.lJp;
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
          if (localg.lJq <= 0)
          {
            localObject2 = localObject1;
            if (localg.lJr >= 0)
            {
              localObject2 = new VideoTransPara();
              ((VideoTransPara)localObject2).width = localg.lJs;
              ((VideoTransPara)localObject2).height = localg.lJt;
              ((VideoTransPara)localObject2).fps = localg.lJu;
              ((VideoTransPara)localObject2).videoBitrate = localg.lJv;
              ((VideoTransPara)localObject2).kXt = this.kXt;
              ((VideoTransPara)localObject2).audioBitrate = this.audioBitrate;
              ((VideoTransPara)localObject2).lJm = this.lJm;
              ((VideoTransPara)localObject2).lJn = this.lJn;
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
  
  protected final VideoTransPara bkG()
  {
    double d1 = 1.0D;
    AppMethodBeat.i(184645);
    VideoTransPara localVideoTransPara = bkF();
    if (localVideoTransPara == null)
    {
      AppMethodBeat.o(184645);
      return null;
    }
    if (localVideoTransPara.fps <= 0)
    {
      localVideoTransPara.kXt = 1;
      AppMethodBeat.o(184645);
      return localVideoTransPara;
    }
    double d2 = localVideoTransPara.kXt / localVideoTransPara.fps;
    if (d2 < 1.0D) {}
    for (;;)
    {
      localVideoTransPara.kXt = ((int)Math.ceil(d1));
      break;
      d1 = d2;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(126777);
    String str = "[ busyTime " + this.lJl + " audioBitrate " + this.audioBitrate + " iFrame " + this.kXt + " profileIndex " + this.lJm + " presetIndex " + this.lJn + " isStepBr " + this.lJo + " ]";
    AppMethodBeat.o(126777);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.f
 * JD-Core Version:    0.7.0.1
 */