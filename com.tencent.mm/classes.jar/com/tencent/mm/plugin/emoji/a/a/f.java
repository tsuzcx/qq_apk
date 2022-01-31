package com.tencent.mm.plugin.emoji.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ar;

public final class f
{
  public f.a leZ;
  public EmotionSummary lfa;
  public EmotionBannerSet lfb;
  public int lfc;
  public String lfd;
  public boolean lfe;
  public boolean lff = true;
  public boolean lfg = false;
  public int mStatus;
  public int ym;
  
  public f(EmotionBannerSet paramEmotionBannerSet)
  {
    this.lfb = paramEmotionBannerSet;
    this.leZ = f.a.lfi;
  }
  
  public f(EmotionSummary paramEmotionSummary)
  {
    this.lfa = paramEmotionSummary;
    this.leZ = f.a.lfh;
  }
  
  public final void a(boolean paramBoolean1, ar paramar, boolean paramBoolean2)
  {
    AppMethodBeat.i(52806);
    EmotionSummary localEmotionSummary = this.lfa;
    if (localEmotionSummary == null)
    {
      AppMethodBeat.o(52806);
      return;
    }
    if (paramBoolean2)
    {
      setStatus(7);
      AppMethodBeat.o(52806);
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
      if ((paramBoolean1) && (paramar != null) && (!bo.isNullOrNil(paramar.yNb)))
      {
        this.lfa.PackPrice = paramar.yNb;
        this.lfa.PriceNum = paramar.yNa;
        this.lfa.PriceType = paramar.yMZ;
      }
      AppMethodBeat.o(52806);
      return;
      if (paramBoolean2)
      {
        setStatus(3);
        if ((bool1) || ((!paramBoolean1) && (bool3))) {
          this.lfc = 0;
        } else {
          this.lfc = 1;
        }
      }
      else if ((bool1) || ((!paramBoolean1) && (bool3)))
      {
        setStatus(3);
        this.lfc = 0;
      }
      else
      {
        this.lfc = 1;
        if ((paramBoolean1) && (paramar != null)) {}
        switch (paramar.yMX)
        {
        default: 
          if ((paramar.yMV != 7) && (paramar.yMV != 6) && (paramar.yMV != 3)) {
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
    if ((paramInt == 7) && (this.mStatus == 6) && (this.lff)) {
      this.lfe = true;
    }
    this.mStatus = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.f
 * JD-Core Version:    0.7.0.1
 */