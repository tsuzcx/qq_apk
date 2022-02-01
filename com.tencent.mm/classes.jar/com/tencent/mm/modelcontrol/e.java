package com.tencent.mm.modelcontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;

public final class e
{
  protected int audioBitrate;
  protected int hCA;
  protected boolean hCB;
  protected f[] hCC;
  protected String hCx;
  protected int hCy;
  protected int hCz;
  
  protected final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(126774);
    this.hCx = paramString1;
    this.audioBitrate = bs.getInt(paramString2, 0);
    int i;
    if (this.audioBitrate == 0)
    {
      i = 64000;
      this.audioBitrate = i;
      this.hCy = bs.getInt(paramString3, 10);
      this.hCz = bs.getInt(paramString4, 2);
      this.hCA = bs.getInt(paramString5, 1);
      if (bs.getInt(paramString6, 0) <= 0) {
        break label103;
      }
    }
    label103:
    for (boolean bool = true;; bool = false)
    {
      this.hCB = bool;
      AppMethodBeat.o(126774);
      return;
      i = this.audioBitrate * 1000;
      break;
    }
  }
  
  protected final boolean aDZ()
  {
    AppMethodBeat.i(126775);
    if (bs.isNullOrNil(this.hCx))
    {
      AppMethodBeat.o(126775);
      return true;
    }
    boolean bool = b.BU(this.hCx);
    AppMethodBeat.o(126775);
    return bool;
  }
  
  protected final VideoTransPara aEa()
  {
    AppMethodBeat.i(126776);
    Object localObject2 = null;
    Object localObject1 = null;
    if (this.hCC != null)
    {
      f[] arrayOff = this.hCC;
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
          if (localf.hCD <= 0)
          {
            localObject2 = localObject1;
            if (localf.hCE >= 0)
            {
              localObject2 = new VideoTransPara();
              ((VideoTransPara)localObject2).width = localf.hCF;
              ((VideoTransPara)localObject2).height = localf.hCG;
              ((VideoTransPara)localObject2).fps = localf.hCH;
              ((VideoTransPara)localObject2).videoBitrate = localf.hCI;
              ((VideoTransPara)localObject2).hCy = this.hCy;
              ((VideoTransPara)localObject2).audioBitrate = this.audioBitrate;
              ((VideoTransPara)localObject2).hCz = this.hCz;
              ((VideoTransPara)localObject2).hCA = this.hCA;
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
  
  protected final VideoTransPara aEb()
  {
    double d1 = 1.0D;
    AppMethodBeat.i(184645);
    VideoTransPara localVideoTransPara = aEa();
    if (localVideoTransPara == null)
    {
      AppMethodBeat.o(184645);
      return null;
    }
    if (localVideoTransPara.fps <= 0)
    {
      localVideoTransPara.hCy = 1;
      AppMethodBeat.o(184645);
      return localVideoTransPara;
    }
    double d2 = localVideoTransPara.hCy / localVideoTransPara.fps;
    if (d2 < 1.0D) {}
    for (;;)
    {
      localVideoTransPara.hCy = ((int)Math.ceil(d1));
      break;
      d1 = d2;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(126777);
    String str = "[ busyTime " + this.hCx + " audioBitrate " + this.audioBitrate + " iFrame " + this.hCy + " profileIndex " + this.hCz + " presetIndex " + this.hCA + " isStepBr " + this.hCB + " ]";
    AppMethodBeat.o(126777);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.e
 * JD-Core Version:    0.7.0.1
 */