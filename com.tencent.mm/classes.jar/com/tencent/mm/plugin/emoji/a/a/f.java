package com.tencent.mm.plugin.emoji.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ax;

public final class f
{
  public int FG;
  public int mStatus;
  public a oYk;
  public EmotionSummary oYl;
  public EmotionBannerSet oYm;
  public int oYn;
  public String oYo;
  public boolean oYp;
  public boolean oYq = true;
  public boolean oYr = false;
  
  public f(EmotionBannerSet paramEmotionBannerSet)
  {
    this.oYm = paramEmotionBannerSet;
    this.oYk = a.oYt;
  }
  
  public f(EmotionSummary paramEmotionSummary)
  {
    this.oYl = paramEmotionSummary;
    this.oYk = a.oYs;
  }
  
  public final void a(boolean paramBoolean1, ax paramax, boolean paramBoolean2)
  {
    AppMethodBeat.i(108382);
    EmotionSummary localEmotionSummary = this.oYl;
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
      if ((paramBoolean1) && (paramax != null) && (!bs.isNullOrNil(paramax.GXN)))
      {
        this.oYl.PackPrice = paramax.GXN;
        this.oYl.PriceNum = paramax.GXM;
        this.oYl.PriceType = paramax.GXL;
      }
      AppMethodBeat.o(108382);
      return;
      if (paramBoolean2)
      {
        setStatus(3);
        if ((bool1) || ((!paramBoolean1) && (bool3))) {
          this.oYn = 0;
        } else {
          this.oYn = 1;
        }
      }
      else if ((bool1) || ((!paramBoolean1) && (bool3)))
      {
        setStatus(3);
        this.oYn = 0;
      }
      else
      {
        this.oYn = 1;
        if ((paramBoolean1) && (paramax != null)) {}
        switch (paramax.GXJ)
        {
        default: 
          if ((paramax.GXH != 7) && (paramax.GXH != 6) && (paramax.GXH != 3)) {
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
    if ((paramInt == 7) && (this.mStatus == 6) && (this.oYq)) {
      this.oYp = true;
    }
    this.mStatus = paramInt;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(108381);
      oYs = new a("summary", 0);
      oYt = new a("cellset", 1);
      oYu = new a[] { oYs, oYt };
      AppMethodBeat.o(108381);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.f
 * JD-Core Version:    0.7.0.1
 */