package com.tencent.mm.modelcontrol;

import com.tencent.mm.sdk.platformtools.bk;

public final class e
{
  protected String ejL;
  protected int ejM;
  protected int ejN;
  protected int ejO;
  protected int ejP;
  protected boolean ejQ;
  protected f[] ejR;
  
  protected final boolean Nu()
  {
    if (bk.bl(this.ejL)) {
      return true;
    }
    return b.lO(this.ejL);
  }
  
  protected final VideoTransPara Nv()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (this.ejR != null)
    {
      f[] arrayOff = this.ejR;
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
          if (localf.ejS <= 0)
          {
            localObject2 = localObject1;
            if (localf.ejT >= 0)
            {
              localObject2 = new VideoTransPara();
              ((VideoTransPara)localObject2).width = localf.ejU;
              ((VideoTransPara)localObject2).height = localf.ejV;
              ((VideoTransPara)localObject2).fps = localf.ejW;
              ((VideoTransPara)localObject2).videoBitrate = localf.ejX;
              ((VideoTransPara)localObject2).ejN = this.ejN;
              ((VideoTransPara)localObject2).ejM = this.ejM;
              ((VideoTransPara)localObject2).ejO = this.ejO;
              ((VideoTransPara)localObject2).ejP = this.ejP;
            }
          }
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    return localObject2;
  }
  
  protected final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.ejL = paramString1;
    this.ejM = bk.getInt(paramString2, 0);
    int i;
    if (this.ejM == 0)
    {
      i = 64000;
      this.ejM = i;
      this.ejN = bk.getInt(paramString3, 10);
      this.ejO = bk.getInt(paramString4, 2);
      this.ejP = bk.getInt(paramString5, 1);
      if (bk.getInt(paramString6, 0) <= 0) {
        break label93;
      }
    }
    label93:
    for (boolean bool = true;; bool = false)
    {
      this.ejQ = bool;
      return;
      i = this.ejM * 1000;
      break;
    }
  }
  
  public final String toString()
  {
    return "[ busyTime " + this.ejL + " audioBitrate " + this.ejM + " iFrame " + this.ejN + " profileIndex " + this.ejO + " presetIndex " + this.ejP + " isStepBr " + this.ejQ + " ]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.e
 * JD-Core Version:    0.7.0.1
 */