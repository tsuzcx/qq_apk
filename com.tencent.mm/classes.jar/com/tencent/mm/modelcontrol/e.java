package com.tencent.mm.modelcontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public final class e
{
  protected int audioBitrate;
  protected String hVd;
  protected int hVe;
  protected int hVf;
  protected boolean hVg;
  protected f[] hVh;
  protected int hmx;
  
  protected final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(126774);
    this.hVd = paramString1;
    this.audioBitrate = bt.getInt(paramString2, 0);
    int i;
    if (this.audioBitrate == 0)
    {
      i = 64000;
      this.audioBitrate = i;
      this.hmx = bt.getInt(paramString3, 10);
      this.hVe = bt.getInt(paramString4, 2);
      this.hVf = bt.getInt(paramString5, 1);
      if (bt.getInt(paramString6, 0) <= 0) {
        break label103;
      }
    }
    label103:
    for (boolean bool = true;; bool = false)
    {
      this.hVg = bool;
      AppMethodBeat.o(126774);
      return;
      i = this.audioBitrate * 1000;
      break;
    }
  }
  
  protected final boolean aHe()
  {
    AppMethodBeat.i(126775);
    if (bt.isNullOrNil(this.hVd))
    {
      AppMethodBeat.o(126775);
      return true;
    }
    boolean bool = b.ET(this.hVd);
    AppMethodBeat.o(126775);
    return bool;
  }
  
  protected final VideoTransPara aHf()
  {
    AppMethodBeat.i(126776);
    Object localObject2 = null;
    Object localObject1 = null;
    if (this.hVh != null)
    {
      f[] arrayOff = this.hVh;
      int j = arrayOff.length;
      int i = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= j) {
          break;
        }
        f localf = arrayOff[i];
        localObject2 = localObject1;
        if (localf != null)
        {
          localObject2 = localObject1;
          if (localf.hVi <= 0)
          {
            localObject2 = localObject1;
            if (localf.hVj >= 0)
            {
              localObject2 = new VideoTransPara();
              ((VideoTransPara)localObject2).width = localf.hVk;
              ((VideoTransPara)localObject2).height = localf.hVl;
              ((VideoTransPara)localObject2).fps = localf.hVm;
              ((VideoTransPara)localObject2).videoBitrate = localf.hVn;
              ((VideoTransPara)localObject2).hmx = this.hmx;
              ((VideoTransPara)localObject2).audioBitrate = this.audioBitrate;
              ((VideoTransPara)localObject2).hVe = this.hVe;
              ((VideoTransPara)localObject2).hVf = this.hVf;
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
  
  protected final VideoTransPara aHg()
  {
    double d1 = 1.0D;
    AppMethodBeat.i(184645);
    VideoTransPara localVideoTransPara = aHf();
    if (localVideoTransPara == null)
    {
      AppMethodBeat.o(184645);
      return null;
    }
    if (localVideoTransPara.fps <= 0)
    {
      localVideoTransPara.hmx = 1;
      AppMethodBeat.o(184645);
      return localVideoTransPara;
    }
    double d2 = localVideoTransPara.hmx / localVideoTransPara.fps;
    if (d2 < 1.0D) {}
    for (;;)
    {
      localVideoTransPara.hmx = ((int)Math.ceil(d1));
      break;
      d1 = d2;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(126777);
    String str = "[ busyTime " + this.hVd + " audioBitrate " + this.audioBitrate + " iFrame " + this.hmx + " profileIndex " + this.hVe + " presetIndex " + this.hVf + " isStepBr " + this.hVg + " ]";
    AppMethodBeat.o(126777);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.e
 * JD-Core Version:    0.7.0.1
 */