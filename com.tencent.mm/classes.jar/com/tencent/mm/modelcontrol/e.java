package com.tencent.mm.modelcontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public final class e
{
  protected int audioBitrate;
  protected String hbV;
  protected int hbW;
  protected int hbX;
  protected int hbY;
  protected boolean hbZ;
  protected f[] hca;
  
  protected final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(126774);
    this.hbV = paramString1;
    this.audioBitrate = bt.getInt(paramString2, 0);
    int i;
    if (this.audioBitrate == 0)
    {
      i = 64000;
      this.audioBitrate = i;
      this.hbW = bt.getInt(paramString3, 10);
      this.hbX = bt.getInt(paramString4, 2);
      this.hbY = bt.getInt(paramString5, 1);
      if (bt.getInt(paramString6, 0) <= 0) {
        break label103;
      }
    }
    label103:
    for (boolean bool = true;; bool = false)
    {
      this.hbZ = bool;
      AppMethodBeat.o(126774);
      return;
      i = this.audioBitrate * 1000;
      break;
    }
  }
  
  protected final boolean axh()
  {
    AppMethodBeat.i(126775);
    if (bt.isNullOrNil(this.hbV))
    {
      AppMethodBeat.o(126775);
      return true;
    }
    boolean bool = b.xO(this.hbV);
    AppMethodBeat.o(126775);
    return bool;
  }
  
  protected final VideoTransPara axi()
  {
    AppMethodBeat.i(126776);
    Object localObject2 = null;
    Object localObject1 = null;
    if (this.hca != null)
    {
      f[] arrayOff = this.hca;
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
          if (localf.hcb <= 0)
          {
            localObject2 = localObject1;
            if (localf.hcc >= 0)
            {
              localObject2 = new VideoTransPara();
              ((VideoTransPara)localObject2).width = localf.hcd;
              ((VideoTransPara)localObject2).height = localf.hce;
              ((VideoTransPara)localObject2).fps = localf.hcf;
              ((VideoTransPara)localObject2).videoBitrate = localf.hcg;
              ((VideoTransPara)localObject2).hbW = this.hbW;
              ((VideoTransPara)localObject2).audioBitrate = this.audioBitrate;
              ((VideoTransPara)localObject2).hbX = this.hbX;
              ((VideoTransPara)localObject2).hbY = this.hbY;
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
  
  protected final VideoTransPara axj()
  {
    double d1 = 1.0D;
    AppMethodBeat.i(184645);
    VideoTransPara localVideoTransPara = axi();
    if (localVideoTransPara == null)
    {
      AppMethodBeat.o(184645);
      return null;
    }
    if (localVideoTransPara.fps <= 0)
    {
      localVideoTransPara.hbW = 1;
      AppMethodBeat.o(184645);
      return localVideoTransPara;
    }
    double d2 = localVideoTransPara.hbW / localVideoTransPara.fps;
    if (d2 < 1.0D) {}
    for (;;)
    {
      localVideoTransPara.hbW = ((int)Math.ceil(d1));
      break;
      d1 = d2;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(126777);
    String str = "[ busyTime " + this.hbV + " audioBitrate " + this.audioBitrate + " iFrame " + this.hbW + " profileIndex " + this.hbX + " presetIndex " + this.hbY + " isStepBr " + this.hbZ + " ]";
    AppMethodBeat.o(126777);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.e
 * JD-Core Version:    0.7.0.1
 */