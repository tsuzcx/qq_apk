package com.tencent.mm.plugin.emoji.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.au;

public final class f
{
  public int EI;
  public int mStatus;
  public f.a ouK;
  public EmotionSummary ouL;
  public EmotionBannerSet ouM;
  public int ouN;
  public String ouO;
  public boolean ouP;
  public boolean ouQ = true;
  public boolean ouR = false;
  
  public f(EmotionBannerSet paramEmotionBannerSet)
  {
    this.ouM = paramEmotionBannerSet;
    this.ouK = f.a.ouT;
  }
  
  public f(EmotionSummary paramEmotionSummary)
  {
    this.ouL = paramEmotionSummary;
    this.ouK = f.a.ouS;
  }
  
  public final void a(boolean paramBoolean1, au paramau, boolean paramBoolean2)
  {
    AppMethodBeat.i(108382);
    EmotionSummary localEmotionSummary = this.ouL;
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
      if ((paramBoolean1) && (paramau != null) && (!bt.isNullOrNil(paramau.FyM)))
      {
        this.ouL.PackPrice = paramau.FyM;
        this.ouL.PriceNum = paramau.FyL;
        this.ouL.PriceType = paramau.FyK;
      }
      AppMethodBeat.o(108382);
      return;
      if (paramBoolean2)
      {
        setStatus(3);
        if ((bool1) || ((!paramBoolean1) && (bool3))) {
          this.ouN = 0;
        } else {
          this.ouN = 1;
        }
      }
      else if ((bool1) || ((!paramBoolean1) && (bool3)))
      {
        setStatus(3);
        this.ouN = 0;
      }
      else
      {
        this.ouN = 1;
        if ((paramBoolean1) && (paramau != null)) {}
        switch (paramau.FyI)
        {
        default: 
          if ((paramau.FyG != 7) && (paramau.FyG != 6) && (paramau.FyG != 3)) {
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
    if ((paramInt == 7) && (this.mStatus == 6) && (this.ouQ)) {
      this.ouP = true;
    }
    this.mStatus = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.f
 * JD-Core Version:    0.7.0.1
 */