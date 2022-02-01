package com.tencent.mm.plugin.emoji.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bc;

public final class f
{
  public int Hx;
  public int mStatus;
  public EmotionBannerSet pIA;
  public int pIB;
  public String pIC;
  public boolean pID;
  public boolean pIE = true;
  public boolean pIF = false;
  public f.a pIy;
  public EmotionSummary pIz;
  
  public f(EmotionBannerSet paramEmotionBannerSet)
  {
    this.pIA = paramEmotionBannerSet;
    this.pIy = f.a.pIH;
  }
  
  public f(EmotionSummary paramEmotionSummary)
  {
    this.pIz = paramEmotionSummary;
    this.pIy = f.a.pIG;
  }
  
  public final void a(boolean paramBoolean1, bc parambc, boolean paramBoolean2)
  {
    AppMethodBeat.i(108382);
    EmotionSummary localEmotionSummary = this.pIz;
    if (localEmotionSummary == null)
    {
      AppMethodBeat.o(108382);
      return;
    }
    if (paramBoolean2)
    {
      setStatus(7);
      AppMethodBeat.o(108382);
      return;
    }
    paramBoolean2 = e.a(localEmotionSummary);
    boolean bool1 = e.b(localEmotionSummary);
    boolean bool2 = e.e(localEmotionSummary);
    boolean bool3 = TextUtils.isEmpty(localEmotionSummary.PackPrice);
    if ((bool2) && (bool1)) {
      setStatus(8);
    }
    for (;;)
    {
      if ((paramBoolean1) && (parambc != null) && (!bu.isNullOrNil(parambc.JfI)))
      {
        this.pIz.PackPrice = parambc.JfI;
        this.pIz.PriceNum = parambc.JfH;
        this.pIz.PriceType = parambc.JfG;
      }
      AppMethodBeat.o(108382);
      return;
      if (paramBoolean2)
      {
        setStatus(3);
        if ((bool1) || ((!paramBoolean1) && (bool3))) {
          this.pIB = 0;
        } else {
          this.pIB = 1;
        }
      }
      else if ((bool1) || ((!paramBoolean1) && (bool3)))
      {
        setStatus(3);
        this.pIB = 0;
      }
      else
      {
        this.pIB = 1;
        if ((paramBoolean1) && (parambc != null)) {}
        switch (parambc.JfE)
        {
        default: 
          if ((parambc.JfC != 7) && (parambc.JfC != 6) && (parambc.JfC != 3)) {
            setStatus(10);
          }
          break;
        case 11: 
          setStatus(11);
          break;
        case 12: 
          setStatus(4);
          continue;
          if (paramBoolean1) {
            setStatus(11);
          } else {
            setStatus(4);
          }
          break;
        }
      }
    }
  }
  
  public final void setStatus(int paramInt)
  {
    if ((paramInt == 7) && (this.mStatus == 6) && (this.pIE)) {
      this.pID = true;
    }
    this.mStatus = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.f
 * JD-Core Version:    0.7.0.1
 */