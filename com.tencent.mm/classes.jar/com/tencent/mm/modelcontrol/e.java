package com.tencent.mm.modelcontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;

public final class e
{
  protected int audioBitrate;
  protected String hXV;
  protected int hXW;
  protected int hXX;
  protected boolean hXY;
  protected f[] hXZ;
  protected int hpl;
  
  protected final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(126774);
    this.hXV = paramString1;
    this.audioBitrate = bu.getInt(paramString2, 0);
    int i;
    if (this.audioBitrate == 0)
    {
      i = 64000;
      this.audioBitrate = i;
      this.hpl = bu.getInt(paramString3, 10);
      this.hXW = bu.getInt(paramString4, 2);
      this.hXX = bu.getInt(paramString5, 1);
      if (bu.getInt(paramString6, 0) <= 0) {
        break label103;
      }
    }
    label103:
    for (boolean bool = true;; bool = false)
    {
      this.hXY = bool;
      AppMethodBeat.o(126774);
      return;
      i = this.audioBitrate * 1000;
      break;
    }
  }
  
  protected final boolean aHv()
  {
    AppMethodBeat.i(126775);
    if (bu.isNullOrNil(this.hXV))
    {
      AppMethodBeat.o(126775);
      return true;
    }
    boolean bool = b.Fv(this.hXV);
    AppMethodBeat.o(126775);
    return bool;
  }
  
  protected final VideoTransPara aHw()
  {
    AppMethodBeat.i(126776);
    Object localObject2 = null;
    Object localObject1 = null;
    if (this.hXZ != null)
    {
      f[] arrayOff = this.hXZ;
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
          if (localf.hYa <= 0)
          {
            localObject2 = localObject1;
            if (localf.hYb >= 0)
            {
              localObject2 = new VideoTransPara();
              ((VideoTransPara)localObject2).width = localf.hYc;
              ((VideoTransPara)localObject2).height = localf.hYd;
              ((VideoTransPara)localObject2).fps = localf.hYe;
              ((VideoTransPara)localObject2).videoBitrate = localf.hYf;
              ((VideoTransPara)localObject2).hpl = this.hpl;
              ((VideoTransPara)localObject2).audioBitrate = this.audioBitrate;
              ((VideoTransPara)localObject2).hXW = this.hXW;
              ((VideoTransPara)localObject2).hXX = this.hXX;
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
  
  protected final VideoTransPara aHx()
  {
    double d1 = 1.0D;
    AppMethodBeat.i(184645);
    VideoTransPara localVideoTransPara = aHw();
    if (localVideoTransPara == null)
    {
      AppMethodBeat.o(184645);
      return null;
    }
    if (localVideoTransPara.fps <= 0)
    {
      localVideoTransPara.hpl = 1;
      AppMethodBeat.o(184645);
      return localVideoTransPara;
    }
    double d2 = localVideoTransPara.hpl / localVideoTransPara.fps;
    if (d2 < 1.0D) {}
    for (;;)
    {
      localVideoTransPara.hpl = ((int)Math.ceil(d1));
      break;
      d1 = d2;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(126777);
    String str = "[ busyTime " + this.hXV + " audioBitrate " + this.audioBitrate + " iFrame " + this.hpl + " profileIndex " + this.hXW + " presetIndex " + this.hXX + " isStepBr " + this.hXY + " ]";
    AppMethodBeat.o(126777);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.e
 * JD-Core Version:    0.7.0.1
 */