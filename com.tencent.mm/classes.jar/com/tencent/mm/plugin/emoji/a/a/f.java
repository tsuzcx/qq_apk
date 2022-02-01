package com.tencent.mm.plugin.emoji.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bb;

public final class f
{
  public int Hx;
  public int mStatus;
  public f.a pBU;
  public EmotionSummary pBV;
  public EmotionBannerSet pBW;
  public int pBX;
  public String pBY;
  public boolean pBZ;
  public boolean pCa = true;
  public boolean pCb = false;
  
  public f(EmotionBannerSet paramEmotionBannerSet)
  {
    this.pBW = paramEmotionBannerSet;
    this.pBU = f.a.pCd;
  }
  
  public f(EmotionSummary paramEmotionSummary)
  {
    this.pBV = paramEmotionSummary;
    this.pBU = f.a.pCc;
  }
  
  public final void a(boolean paramBoolean1, bb parambb, boolean paramBoolean2)
  {
    AppMethodBeat.i(108382);
    EmotionSummary localEmotionSummary = this.pBV;
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
      if ((paramBoolean1) && (parambb != null) && (!bt.isNullOrNil(parambb.ILb)))
      {
        this.pBV.PackPrice = parambb.ILb;
        this.pBV.PriceNum = parambb.ILa;
        this.pBV.PriceType = parambb.IKZ;
      }
      AppMethodBeat.o(108382);
      return;
      if (paramBoolean2)
      {
        setStatus(3);
        if ((bool1) || ((!paramBoolean1) && (bool3))) {
          this.pBX = 0;
        } else {
          this.pBX = 1;
        }
      }
      else if ((bool1) || ((!paramBoolean1) && (bool3)))
      {
        setStatus(3);
        this.pBX = 0;
      }
      else
      {
        this.pBX = 1;
        if ((paramBoolean1) && (parambb != null)) {}
        switch (parambb.IKX)
        {
        default: 
          if ((parambb.IKV != 7) && (parambb.IKV != 6) && (parambb.IKV != 3)) {
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
    if ((paramInt == 7) && (this.mStatus == 6) && (this.pCa)) {
      this.pBZ = true;
    }
    this.mStatus = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.f
 * JD-Core Version:    0.7.0.1
 */