package com.tencent.mm.modelcontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class e
{
  protected String fzS;
  protected int fzT;
  protected int fzU;
  protected int fzV;
  protected int fzW;
  protected boolean fzX;
  protected f[] fzY;
  
  protected final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(50617);
    this.fzS = paramString1;
    this.fzT = bo.getInt(paramString2, 0);
    int i;
    if (this.fzT == 0)
    {
      i = 64000;
      this.fzT = i;
      this.fzU = bo.getInt(paramString3, 10);
      this.fzV = bo.getInt(paramString4, 2);
      this.fzW = bo.getInt(paramString5, 1);
      if (bo.getInt(paramString6, 0) <= 0) {
        break label103;
      }
    }
    label103:
    for (boolean bool = true;; bool = false)
    {
      this.fzX = bool;
      AppMethodBeat.o(50617);
      return;
      i = this.fzT * 1000;
      break;
    }
  }
  
  protected final boolean agh()
  {
    AppMethodBeat.i(50618);
    if (bo.isNullOrNil(this.fzS))
    {
      AppMethodBeat.o(50618);
      return true;
    }
    boolean bool = b.sM(this.fzS);
    AppMethodBeat.o(50618);
    return bool;
  }
  
  protected final VideoTransPara agi()
  {
    AppMethodBeat.i(50619);
    Object localObject2 = null;
    Object localObject1 = null;
    if (this.fzY != null)
    {
      f[] arrayOff = this.fzY;
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
          if (localf.fzZ <= 0)
          {
            localObject2 = localObject1;
            if (localf.fAa >= 0)
            {
              localObject2 = new VideoTransPara();
              ((VideoTransPara)localObject2).width = localf.fAb;
              ((VideoTransPara)localObject2).height = localf.fAc;
              ((VideoTransPara)localObject2).fps = localf.fAd;
              ((VideoTransPara)localObject2).videoBitrate = localf.fAe;
              ((VideoTransPara)localObject2).fzU = this.fzU;
              ((VideoTransPara)localObject2).fzT = this.fzT;
              ((VideoTransPara)localObject2).fzV = this.fzV;
              ((VideoTransPara)localObject2).fzW = this.fzW;
            }
          }
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    AppMethodBeat.o(50619);
    return localObject2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(50620);
    String str = "[ busyTime " + this.fzS + " audioBitrate " + this.fzT + " iFrame " + this.fzU + " profileIndex " + this.fzV + " presetIndex " + this.fzW + " isStepBr " + this.fzX + " ]";
    AppMethodBeat.o(50620);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.e
 * JD-Core Version:    0.7.0.1
 */