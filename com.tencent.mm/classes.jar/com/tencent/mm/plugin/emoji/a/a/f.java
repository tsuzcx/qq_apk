package com.tencent.mm.plugin.emoji.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bh;

public final class f
{
  public int HH;
  public int mStatus;
  public a qYk;
  public EmotionSummary qYl;
  public EmotionBannerSet qYm;
  public int qYn;
  public String qYo;
  public boolean qYp;
  public boolean qYq = true;
  public boolean qYr = false;
  
  public f(EmotionBannerSet paramEmotionBannerSet)
  {
    this.qYm = paramEmotionBannerSet;
    this.qYk = a.qYt;
  }
  
  public f(EmotionSummary paramEmotionSummary)
  {
    this.qYl = paramEmotionSummary;
    this.qYk = a.qYs;
  }
  
  public final void a(boolean paramBoolean1, bh parambh, boolean paramBoolean2)
  {
    AppMethodBeat.i(108382);
    EmotionSummary localEmotionSummary = this.qYl;
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
      if ((paramBoolean1) && (parambh != null) && (!Util.isNullOrNil(parambh.OpB)))
      {
        this.qYl.PackPrice = parambh.OpB;
        this.qYl.PriceNum = parambh.OpA;
        this.qYl.PriceType = parambh.Opz;
      }
      AppMethodBeat.o(108382);
      return;
      if (paramBoolean2)
      {
        setStatus(3);
        if ((bool1) || ((!paramBoolean1) && (bool3))) {
          this.qYn = 0;
        } else {
          this.qYn = 1;
        }
      }
      else if ((bool1) || ((!paramBoolean1) && (bool3)))
      {
        setStatus(3);
        this.qYn = 0;
      }
      else
      {
        this.qYn = 1;
        if ((paramBoolean1) && (parambh != null)) {}
        switch (parambh.Opx)
        {
        default: 
          if ((parambh.Opv != 7) && (parambh.Opv != 6) && (parambh.Opv != 3)) {
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
    if ((paramInt == 7) && (this.mStatus == 6) && (this.qYq)) {
      this.qYp = true;
    }
    this.mStatus = paramInt;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(108381);
      qYs = new a("summary", 0);
      qYt = new a("cellset", 1);
      qYu = new a[] { qYs, qYt };
      AppMethodBeat.o(108381);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.f
 * JD-Core Version:    0.7.0.1
 */