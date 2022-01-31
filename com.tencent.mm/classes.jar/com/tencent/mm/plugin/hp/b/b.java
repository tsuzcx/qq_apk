package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;

public final class b
{
  private static long lmE = 0L;
  
  public static void I(Intent paramIntent)
  {
    KVCommCrossProcessReceiver.bwP();
    y.i("Tinker.HotPatchReportHelper", "hp_report try to apply patch service start");
    if (paramIntent == null)
    {
      h.nFQ.U(338, 6, 127);
      return;
    }
    if (ShareIntentUtil.j(paramIntent, "patch_path_extra") == null)
    {
      h.nFQ.U(338, 6, 128);
      return;
    }
    h.nFQ.a(338L, 6L, 1L, true);
  }
  
  public static void a(int paramInt, Throwable paramThrowable)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      h.nFQ.a(338L, 191L, 1L, false);
      h.nFQ.d("Tinker", "Tinker Exception:interpret occur instruction exception " + al.k(paramThrowable), null);
      return;
    case 2: 
      h.nFQ.a(338L, 192L, 1L, false);
      h.nFQ.d("Tinker", "Tinker Exception:interpret occur command exception " + al.k(paramThrowable), null);
      return;
    }
    h.nFQ.a(338L, 193L, 1L, false);
  }
  
  public static void a(Throwable paramThrowable, int paramInt)
  {
    int i = 0;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (i == 0)
      {
        String str1 = al.k(paramThrowable);
        paramThrowable = str1;
        if (paramInt == -4)
        {
          Context localContext = ae.getContext();
          String str2 = SharePatchFileUtil.ia(localContext);
          paramThrowable = str1;
          if (!ShareTinkerInternals.bl(str2))
          {
            paramThrowable = "tinker checkSafeModeCount fail:\n" + str2;
            SharePatchFileUtil.ah(SharePatchFileUtil.hZ(localContext));
          }
        }
        h.nFQ.d("Tinker", "Tinker Exception:load tinker occur exception " + paramThrowable, null);
      }
      return;
      if (paramThrowable.getMessage().contains("checkDexInstall failed"))
      {
        h.nFQ.a(338L, 189L, 1L, false);
        y.i("Tinker.HotPatchReportHelper", "tinker dex check fail:" + paramThrowable.getMessage());
        i = 1;
      }
      else
      {
        h.nFQ.a(338L, 161L, 1L, false);
        y.e("Tinker.HotPatchReportHelper", "tinker dex reflect fail:" + paramThrowable.getMessage());
        continue;
        if (paramThrowable.getMessage().contains("checkResInstall failed"))
        {
          h.nFQ.a(338L, 190L, 1L, false);
          i = 1;
        }
        else
        {
          h.nFQ.a(338L, 184L, 1L, false);
          continue;
          h.nFQ.a(338L, 188L, 1L, false);
          continue;
          h.nFQ.a(338L, 160L, 1L, false);
        }
      }
    }
  }
  
  public static void bba()
  {
    h.nFQ.a(338L, 9L, 1L, false);
  }
  
  public static void bbb()
  {
    h.nFQ.a(338L, 106L, 1L, false);
  }
  
  public static void bbc()
  {
    h.nFQ.a(338L, 116L, 1L, false);
  }
  
  public static void bbd()
  {
    h.nFQ.a(338L, 168L, 1L, false);
  }
  
  public static void bbe()
  {
    h.nFQ.a(338L, 5L, 1L, false);
  }
  
  public static void d(Throwable paramThrowable)
  {
    h.nFQ.a(338L, 104L, 1L, false);
    h.nFQ.d("Tinker", "Tinker Exception:apply tinker occur unknown exception " + al.k(paramThrowable), null);
  }
  
  public static void e(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    h.nFQ.f(15974, new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(false) });
    y.i("Tinker.HotPatchReportHelper", "CodeVersion:%s PatchVersion:%s TinkerId:%s Scene:%d Result:%d", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public static void f(Throwable paramThrowable)
  {
    if (paramThrowable.getMessage().contains("checkDexOptExist failed"))
    {
      h.nFQ.a(338L, 134L, 1L, false);
      return;
    }
    if (paramThrowable.getMessage().contains("checkDexOptFormat failed"))
    {
      h.nFQ.a(338L, 135L, 1L, false);
      h.nFQ.d("Tinker", "Tinker Exception:apply tinker occur dexOpt format exception " + al.k(paramThrowable), null);
      return;
    }
    h.nFQ.a(338L, 105L, 1L, false);
    h.nFQ.d("Tinker", "Tinker Exception:apply tinker occur dexOpt exception " + al.k(paramThrowable), null);
  }
  
  public static void gM(boolean paramBoolean)
  {
    y.i("Tinker.HotPatchReportHelper", "hp_report try to apply hotpatch");
    h.nFQ.U(338, 2, 71);
    if (paramBoolean) {
      h.nFQ.a(338L, 7L, 1L, true);
    }
  }
  
  public static void m(boolean paramBoolean, int paramInt)
  {
    y.i("Tinker.HotPatchReportHelper", "hp_report package check failed, error = %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramBoolean) {
      h.nFQ.a(338L, 170L, 1L, false);
    }
    switch (paramInt)
    {
    default: 
      return;
    case -1: 
      h.nFQ.U(338, 169, 171);
      return;
    case -3: 
      h.nFQ.U(338, 169, 172);
      return;
    case -4: 
      h.nFQ.U(338, 169, 173);
      return;
    case -6: 
      h.nFQ.U(338, 169, 175);
      return;
    case -5: 
      h.nFQ.U(338, 169, 174);
      return;
    case -7: 
      h.nFQ.U(338, 169, 176);
      return;
    case -2: 
      h.nFQ.U(338, 107, 182);
      return;
    }
    h.nFQ.U(338, 169, 186);
  }
  
  public static void n(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {
      h.nFQ.a(338L, 3L, 1L, true);
    }
    if (paramBoolean) {
      h.nFQ.a(338L, 101L, 1L, false);
    }
    for (;;)
    {
      y.i("Tinker.HotPatchReportHelper", "hp_report report apply cost = %d", new Object[] { Long.valueOf(paramLong) });
      if (paramLong >= 0L) {
        break;
      }
      y.e("Tinker.HotPatchReportHelper", "hp_report report apply cost failed, invalid cost");
      return;
      h.nFQ.a(338L, 103L, 1L, false);
    }
    if (paramLong <= 5000L)
    {
      if (paramBoolean)
      {
        h.nFQ.a(338L, 117L, 1L, false);
        return;
      }
      h.nFQ.a(338L, 122L, 1L, false);
      return;
    }
    if (paramLong <= 10000L)
    {
      if (paramBoolean)
      {
        h.nFQ.a(338L, 118L, 1L, false);
        return;
      }
      h.nFQ.a(338L, 123L, 1L, false);
      return;
    }
    if (paramLong <= 30000L)
    {
      if (paramBoolean)
      {
        h.nFQ.a(338L, 119L, 1L, false);
        return;
      }
      h.nFQ.a(338L, 124L, 1L, false);
      return;
    }
    if (paramLong <= 60000L)
    {
      if (paramBoolean)
      {
        h.nFQ.a(338L, 120L, 1L, false);
        return;
      }
      h.nFQ.a(338L, 125L, 1L, false);
      return;
    }
    if (paramLong >= 3600000L) {
      h.nFQ.a(338L, 133L, 1L, false);
    }
    if (paramBoolean)
    {
      h.nFQ.a(338L, 121L, 1L, false);
      return;
    }
    h.nFQ.a(338L, 126L, 1L, false);
  }
  
  public static void o(long paramLong, boolean paramBoolean)
  {
    h.nFQ.a(338L, 4L, 1L, false);
    if (!paramBoolean)
    {
      h.nFQ.a(338L, 159L, 1L, false);
      return;
    }
    y.i("Tinker.HotPatchReportHelper", "hp_report report load cost = %d", new Object[] { Long.valueOf(paramLong) });
    if (paramLong < 0L)
    {
      y.e("Tinker.HotPatchReportHelper", "hp_report report load cost failed, invalid cost");
      return;
    }
    if (paramLong <= 500L)
    {
      h.nFQ.a(338L, 177L, 1L, false);
      return;
    }
    if (paramLong <= 1000L)
    {
      h.nFQ.a(338L, 178L, 1L, false);
      return;
    }
    if (paramLong <= 3000L)
    {
      h.nFQ.a(338L, 179L, 1L, false);
      return;
    }
    if (paramLong <= 5000L)
    {
      h.nFQ.a(338L, 180L, 1L, false);
      return;
    }
    h.nFQ.a(338L, 181L, 1L, false);
  }
  
  public static void sA(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    case 4: 
    default: 
      return;
    case 3: 
      h.nFQ.a(338L, 114L, 1L, false);
      return;
    case 5: 
      h.nFQ.a(338L, 115L, 1L, false);
      return;
    case 1: 
      h.nFQ.a(338L, 130L, 1L, false);
      return;
    case 6: 
      h.nFQ.a(338L, 132L, 1L, false);
      return;
    }
    h.nFQ.a(338L, 136L, 1L, false);
  }
  
  public static void sB(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      h.nFQ.a(338L, 183L, 1L, false);
      return;
    case 3: 
      h.nFQ.a(338L, 164L, 1L, false);
      return;
    case 5: 
      h.nFQ.a(338L, 165L, 1L, false);
      return;
    case 1: 
      h.nFQ.a(338L, 166L, 1L, false);
      return;
    case 2: 
      h.nFQ.a(338L, 167L, 1L, false);
      return;
    }
    h.nFQ.a(338L, 187L, 1L, false);
  }
  
  public static void sC(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    default: 
      return;
    case 3: 
      h.nFQ.a(338L, 162L, 1L, false);
      return;
    case 5: 
      h.nFQ.a(338L, 163L, 1L, false);
      return;
    }
    h.nFQ.a(338L, 185L, 1L, false);
  }
  
  public static void sv(int paramInt)
  {
    y.i("Tinker.HotPatchReportHelper", "hp_report new hotpatch requested");
    switch (paramInt)
    {
    }
    for (;;)
    {
      lmE = bk.UZ();
      return;
      h.nFQ.a(338L, 0L, 1L, false);
      continue;
      h.nFQ.a(338L, 20L, 1L, false);
      continue;
      h.nFQ.a(614L, 0L, 1L, false);
    }
  }
  
  public static void sw(int paramInt)
  {
    long l = bk.cp(lmE);
    y.i("Tinker.HotPatchReportHelper", "hp_report report download cost = %d", new Object[] { Long.valueOf(l) });
    switch (paramInt)
    {
    }
    while (l < 0L)
    {
      y.e("Tinker.HotPatchReportHelper", "hp_report report download cost failed, invalid cost");
      return;
      h.nFQ.a(338L, 40L, 1L, false);
    }
    if (l <= 5000L)
    {
      h.nFQ.U(338, 1, 43);
      return;
    }
    if (l <= 60000L)
    {
      h.nFQ.U(338, 1, 44);
      return;
    }
    if (l <= 180000L)
    {
      h.nFQ.U(338, 1, 45);
      return;
    }
    h.nFQ.U(338, 1, 46);
  }
  
  public static void sx(int paramInt)
  {
    y.i("Tinker.HotPatchReportHelper", "hp_report download failed");
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      h.nFQ.a(338L, 41L, 1L, false);
      return;
    case 1: 
      h.nFQ.a(338L, 42L, 1L, false);
      return;
    }
    h.nFQ.a(614L, 3L, 1L, false);
  }
  
  public static void sy(int paramInt)
  {
    y.i("Tinker.HotPatchReportHelper", "hp_report try to apply hotpatch fail");
    switch (paramInt)
    {
    case -19: 
    case -18: 
    case -17: 
    case -16: 
    case -15: 
    case -14: 
    case -13: 
    case -12: 
    case -11: 
    case -10: 
    case -9: 
    case -8: 
    default: 
      return;
    case -2: 
      h.nFQ.a(338L, 75L, 1L, false);
      return;
    case -1: 
      h.nFQ.a(338L, 72L, 1L, false);
      return;
    case -4: 
      h.nFQ.a(338L, 74L, 1L, false);
      return;
    case -3: 
      h.nFQ.a(338L, 73L, 1L, false);
      return;
    case -5: 
      h.nFQ.a(338L, 85L, 1L, false);
      return;
    case -21: 
      h.nFQ.a(338L, 77L, 1L, false);
      return;
    case -20: 
      h.nFQ.a(338L, 76L, 1L, false);
      return;
    case -6: 
      h.nFQ.a(338L, 78L, 1L, false);
      return;
    case -22: 
      h.nFQ.a(338L, 80L, 1L, false);
      return;
    case -23: 
      h.nFQ.a(338L, 79L, 1L, false);
      return;
    case -24: 
      h.nFQ.a(338L, 81L, 1L, false);
      return;
    case -25: 
      h.nFQ.a(338L, 82L, 1L, false);
      return;
    case -26: 
      h.nFQ.a(338L, 83L, 1L, false);
      return;
    }
    h.nFQ.a(338L, 84L, 1L, false);
  }
  
  public static void sz(int paramInt)
  {
    y.i("Tinker.HotPatchReportHelper", "hp_report package check failed, error = %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      return;
    case -1: 
      h.nFQ.U(338, 107, 108);
      return;
    case -3: 
      h.nFQ.U(338, 107, 109);
      return;
    case -4: 
      h.nFQ.U(338, 107, 110);
      return;
    case -6: 
      h.nFQ.U(338, 107, 112);
      return;
    case -5: 
      h.nFQ.U(338, 107, 111);
      return;
    case -7: 
      h.nFQ.U(338, 107, 113);
      return;
    case -2: 
      h.nFQ.U(338, 107, 129);
      return;
    }
    h.nFQ.U(338, 107, 131);
  }
  
  public static enum a
  {
    public final int value;
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.b
 * JD-Core Version:    0.7.0.1
 */