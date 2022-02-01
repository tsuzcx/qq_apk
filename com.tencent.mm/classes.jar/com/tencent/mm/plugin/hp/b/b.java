package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;

public final class b
{
  private static long uIa = 0L;
  
  public static void F(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(117403);
    ad.i("Tinker.HotPatchReportHelper", "hp_report package check failed, error = %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramBoolean) {
      g.yhR.idkeyStat(338L, 170L, 1L, false);
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(117403);
      return;
      g.yhR.aq(338, 169, 171);
      AppMethodBeat.o(117403);
      return;
      g.yhR.aq(338, 169, 172);
      AppMethodBeat.o(117403);
      return;
      g.yhR.aq(338, 169, 173);
      AppMethodBeat.o(117403);
      return;
      g.yhR.aq(338, 169, 175);
      AppMethodBeat.o(117403);
      return;
      g.yhR.aq(338, 169, 174);
      AppMethodBeat.o(117403);
      return;
      g.yhR.aq(338, 169, 176);
      AppMethodBeat.o(117403);
      return;
      g.yhR.aq(338, 107, 182);
      AppMethodBeat.o(117403);
      return;
      g.yhR.aq(338, 169, 186);
    }
  }
  
  public static void FZ(int paramInt)
  {
    AppMethodBeat.i(117388);
    ad.i("Tinker.HotPatchReportHelper", "hp_report new hotpatch requested");
    switch (paramInt)
    {
    }
    for (;;)
    {
      uIa = bt.HI();
      AppMethodBeat.o(117388);
      return;
      g.yhR.idkeyStat(338L, 0L, 1L, false);
      continue;
      g.yhR.idkeyStat(338L, 20L, 1L, false);
      continue;
      g.yhR.idkeyStat(614L, 0L, 1L, false);
    }
  }
  
  public static void Io(int paramInt)
  {
    AppMethodBeat.i(117389);
    long l = bt.aO(uIa);
    ad.i("Tinker.HotPatchReportHelper", "hp_report report download cost = %d", new Object[] { Long.valueOf(l) });
    switch (paramInt)
    {
    }
    while (l < 0L)
    {
      ad.e("Tinker.HotPatchReportHelper", "hp_report report download cost failed, invalid cost");
      AppMethodBeat.o(117389);
      return;
      g.yhR.idkeyStat(338L, 40L, 1L, false);
    }
    if (l <= 5000L)
    {
      g.yhR.aq(338, 1, 43);
      AppMethodBeat.o(117389);
      return;
    }
    if (l <= 60000L)
    {
      g.yhR.aq(338, 1, 44);
      AppMethodBeat.o(117389);
      return;
    }
    if (l <= 180000L)
    {
      g.yhR.aq(338, 1, 45);
      AppMethodBeat.o(117389);
      return;
    }
    g.yhR.aq(338, 1, 46);
    AppMethodBeat.o(117389);
  }
  
  public static void Ip(int paramInt)
  {
    AppMethodBeat.i(117390);
    ad.i("Tinker.HotPatchReportHelper", "hp_report download failed");
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(117390);
      return;
      g.yhR.idkeyStat(338L, 41L, 1L, false);
      AppMethodBeat.o(117390);
      return;
      g.yhR.idkeyStat(338L, 42L, 1L, false);
      AppMethodBeat.o(117390);
      return;
      g.yhR.idkeyStat(614L, 3L, 1L, false);
    }
  }
  
  public static void Iq(int paramInt)
  {
    AppMethodBeat.i(117392);
    ad.i("Tinker.HotPatchReportHelper", "hp_report try to apply hotpatch fail");
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(117392);
      return;
      g.yhR.idkeyStat(338L, 75L, 1L, false);
      AppMethodBeat.o(117392);
      return;
      g.yhR.idkeyStat(338L, 72L, 1L, false);
      AppMethodBeat.o(117392);
      return;
      g.yhR.idkeyStat(338L, 74L, 1L, false);
      AppMethodBeat.o(117392);
      return;
      g.yhR.idkeyStat(338L, 73L, 1L, false);
      AppMethodBeat.o(117392);
      return;
      g.yhR.idkeyStat(338L, 85L, 1L, false);
      AppMethodBeat.o(117392);
      return;
      g.yhR.idkeyStat(338L, 77L, 1L, false);
      AppMethodBeat.o(117392);
      return;
      g.yhR.idkeyStat(338L, 76L, 1L, false);
      AppMethodBeat.o(117392);
      return;
      g.yhR.idkeyStat(338L, 78L, 1L, false);
      AppMethodBeat.o(117392);
      return;
      g.yhR.idkeyStat(338L, 80L, 1L, false);
      AppMethodBeat.o(117392);
      return;
      g.yhR.idkeyStat(338L, 79L, 1L, false);
      AppMethodBeat.o(117392);
      return;
      g.yhR.idkeyStat(338L, 81L, 1L, false);
      AppMethodBeat.o(117392);
      return;
      g.yhR.idkeyStat(338L, 82L, 1L, false);
      AppMethodBeat.o(117392);
      return;
      g.yhR.idkeyStat(338L, 83L, 1L, false);
      AppMethodBeat.o(117392);
      return;
      g.yhR.idkeyStat(338L, 84L, 1L, false);
    }
  }
  
  public static void Ir(int paramInt)
  {
    AppMethodBeat.i(117395);
    ad.i("Tinker.HotPatchReportHelper", "hp_report package check failed, error = %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(117395);
      return;
      g.yhR.aq(338, 107, 108);
      AppMethodBeat.o(117395);
      return;
      g.yhR.aq(338, 107, 109);
      AppMethodBeat.o(117395);
      return;
      g.yhR.aq(338, 107, 110);
      AppMethodBeat.o(117395);
      return;
      g.yhR.aq(338, 107, 112);
      AppMethodBeat.o(117395);
      return;
      g.yhR.aq(338, 107, 111);
      AppMethodBeat.o(117395);
      return;
      g.yhR.aq(338, 107, 113);
      AppMethodBeat.o(117395);
      return;
      g.yhR.aq(338, 107, 129);
      AppMethodBeat.o(117395);
      return;
      g.yhR.aq(338, 107, 131);
    }
  }
  
  public static void Is(int paramInt)
  {
    AppMethodBeat.i(117400);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(117400);
      return;
      g.yhR.idkeyStat(338L, 114L, 1L, false);
      AppMethodBeat.o(117400);
      return;
      g.yhR.idkeyStat(338L, 115L, 1L, false);
      AppMethodBeat.o(117400);
      return;
      g.yhR.idkeyStat(338L, 130L, 1L, false);
      AppMethodBeat.o(117400);
      return;
      g.yhR.idkeyStat(338L, 132L, 1L, false);
      AppMethodBeat.o(117400);
      return;
      g.yhR.idkeyStat(338L, 136L, 1L, false);
    }
  }
  
  public static void It(int paramInt)
  {
    AppMethodBeat.i(117404);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(117404);
      return;
      g.yhR.idkeyStat(338L, 183L, 1L, false);
      AppMethodBeat.o(117404);
      return;
      g.yhR.idkeyStat(338L, 164L, 1L, false);
      AppMethodBeat.o(117404);
      return;
      g.yhR.idkeyStat(338L, 165L, 1L, false);
      AppMethodBeat.o(117404);
      return;
      g.yhR.idkeyStat(338L, 166L, 1L, false);
      AppMethodBeat.o(117404);
      return;
      g.yhR.idkeyStat(338L, 167L, 1L, false);
      AppMethodBeat.o(117404);
      return;
      g.yhR.idkeyStat(338L, 187L, 1L, false);
    }
  }
  
  public static void Iu(int paramInt)
  {
    AppMethodBeat.i(117405);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(117405);
      return;
      g.yhR.idkeyStat(338L, 162L, 1L, false);
      AppMethodBeat.o(117405);
      return;
      g.yhR.idkeyStat(338L, 163L, 1L, false);
      AppMethodBeat.o(117405);
      return;
      g.yhR.idkeyStat(338L, 185L, 1L, false);
    }
  }
  
  public static void a(int paramInt, Throwable paramThrowable)
  {
    AppMethodBeat.i(117408);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(117408);
      return;
      g.yhR.idkeyStat(338L, 191L, 1L, false);
      g.yhR.g("Tinker", "Tinker Exception:interpret occur instruction exception " + au.getExceptionCauseString(paramThrowable), null);
      AppMethodBeat.o(117408);
      return;
      g.yhR.idkeyStat(338L, 192L, 1L, false);
      g.yhR.g("Tinker", "Tinker Exception:interpret occur command exception " + au.getExceptionCauseString(paramThrowable), null);
      AppMethodBeat.o(117408);
      return;
      g.yhR.idkeyStat(338L, 193L, 1L, false);
    }
  }
  
  public static void a(Throwable paramThrowable, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(117402);
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (i == 0)
      {
        String str1 = au.getExceptionCauseString(paramThrowable);
        paramThrowable = str1;
        if (paramInt == -4)
        {
          Context localContext = aj.getContext();
          String str2 = SharePatchFileUtil.checkTinkerLastUncaughtCrash(localContext);
          paramThrowable = str1;
          if (!ShareTinkerInternals.isNullOrNil(str2))
          {
            paramThrowable = "tinker checkSafeModeCount fail:\n".concat(String.valueOf(str2));
            SharePatchFileUtil.safeDeleteFile(SharePatchFileUtil.getPatchLastCrashFile(localContext));
          }
        }
        g.yhR.g("Tinker", "Tinker Exception:load tinker occur exception ".concat(String.valueOf(paramThrowable)), null);
      }
      AppMethodBeat.o(117402);
      return;
      if (paramThrowable.getMessage().contains("checkDexInstall failed"))
      {
        g.yhR.idkeyStat(338L, 189L, 1L, false);
        ad.i("Tinker.HotPatchReportHelper", "tinker dex check fail:" + paramThrowable.getMessage());
        i = 1;
      }
      else
      {
        g.yhR.idkeyStat(338L, 161L, 1L, false);
        ad.e("Tinker.HotPatchReportHelper", "tinker dex reflect fail:" + paramThrowable.getMessage());
        continue;
        if (paramThrowable.getMessage().contains("checkResInstall failed"))
        {
          g.yhR.idkeyStat(338L, 190L, 1L, false);
          i = 1;
        }
        else
        {
          g.yhR.idkeyStat(338L, 184L, 1L, false);
          continue;
          g.yhR.idkeyStat(338L, 188L, 1L, false);
          continue;
          g.yhR.idkeyStat(338L, 160L, 1L, false);
        }
      }
    }
  }
  
  public static void av(Intent paramIntent)
  {
    AppMethodBeat.i(117393);
    KVCommCrossProcessReceiver.dKi();
    ad.i("Tinker.HotPatchReportHelper", "hp_report try to apply patch service start");
    if (paramIntent == null)
    {
      g.yhR.aq(338, 6, 127);
      AppMethodBeat.o(117393);
      return;
    }
    if (ShareIntentUtil.getStringExtra(paramIntent, "patch_path_extra") == null)
    {
      g.yhR.aq(338, 6, 128);
      AppMethodBeat.o(117393);
      return;
    }
    g.yhR.idkeyStat(338L, 6L, 1L, true);
    AppMethodBeat.o(117393);
  }
  
  public static void dcj()
  {
    AppMethodBeat.i(117387);
    g.yhR.idkeyStat(338L, 9L, 1L, false);
    AppMethodBeat.o(117387);
  }
  
  public static void dck()
  {
    AppMethodBeat.i(117398);
    g.yhR.idkeyStat(338L, 106L, 1L, false);
    AppMethodBeat.o(117398);
  }
  
  public static void dcl()
  {
    AppMethodBeat.i(117399);
    g.yhR.idkeyStat(338L, 116L, 1L, false);
    AppMethodBeat.o(117399);
  }
  
  public static void dcm()
  {
    AppMethodBeat.i(117406);
    g.yhR.idkeyStat(338L, 168L, 1L, false);
    AppMethodBeat.o(117406);
  }
  
  public static void dcn()
  {
    AppMethodBeat.i(117407);
    g.yhR.idkeyStat(338L, 5L, 1L, false);
    AppMethodBeat.o(117407);
  }
  
  public static void e(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117409);
    g.yhR.f(15974, new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.FALSE });
    ad.i("Tinker.HotPatchReportHelper", "CodeVersion:%s PatchVersion:%s TinkerId:%s Scene:%d Result:%d", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(117409);
  }
  
  public static void i(Throwable paramThrowable)
  {
    AppMethodBeat.i(117396);
    g.yhR.idkeyStat(338L, 104L, 1L, false);
    g.yhR.g("Tinker", "Tinker Exception:apply tinker occur unknown exception " + au.getExceptionCauseString(paramThrowable), null);
    AppMethodBeat.o(117396);
  }
  
  public static void j(Throwable paramThrowable)
  {
    AppMethodBeat.i(117397);
    if (paramThrowable.getMessage().contains("checkDexOptExist failed")) {
      g.yhR.idkeyStat(338L, 134L, 1L, false);
    }
    for (;;)
    {
      com.tencent.mm.plugin.hp.c.a.k(paramThrowable);
      AppMethodBeat.o(117397);
      return;
      if (paramThrowable.getMessage().contains("checkDexOptFormat failed"))
      {
        g.yhR.idkeyStat(338L, 135L, 1L, false);
        g.yhR.g("Tinker", "Tinker Exception:apply tinker occur dexOpt format exception " + au.getExceptionCauseString(paramThrowable), null);
      }
      else
      {
        g.yhR.idkeyStat(338L, 105L, 1L, false);
        g.yhR.g("Tinker", "Tinker Exception:apply tinker occur dexOpt exception " + au.getExceptionCauseString(paramThrowable), null);
      }
    }
  }
  
  public static void nw(boolean paramBoolean)
  {
    AppMethodBeat.i(117391);
    ad.i("Tinker.HotPatchReportHelper", "hp_report try to apply hotpatch");
    g.yhR.aq(338, 2, 71);
    if (paramBoolean) {
      g.yhR.idkeyStat(338L, 7L, 1L, true);
    }
    AppMethodBeat.o(117391);
  }
  
  public static void w(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(117394);
    if (paramBoolean) {
      g.yhR.idkeyStat(338L, 3L, 1L, true);
    }
    if (paramBoolean) {
      g.yhR.idkeyStat(338L, 101L, 1L, false);
    }
    for (;;)
    {
      ad.i("Tinker.HotPatchReportHelper", "hp_report report apply cost = %d", new Object[] { Long.valueOf(paramLong) });
      if (paramLong >= 0L) {
        break;
      }
      ad.e("Tinker.HotPatchReportHelper", "hp_report report apply cost failed, invalid cost");
      AppMethodBeat.o(117394);
      return;
      g.yhR.idkeyStat(338L, 103L, 1L, false);
    }
    if (paramLong <= 5000L)
    {
      if (paramBoolean)
      {
        g.yhR.idkeyStat(338L, 117L, 1L, false);
        AppMethodBeat.o(117394);
        return;
      }
      g.yhR.idkeyStat(338L, 122L, 1L, false);
      AppMethodBeat.o(117394);
      return;
    }
    if (paramLong <= 10000L)
    {
      if (paramBoolean)
      {
        g.yhR.idkeyStat(338L, 118L, 1L, false);
        AppMethodBeat.o(117394);
        return;
      }
      g.yhR.idkeyStat(338L, 123L, 1L, false);
      AppMethodBeat.o(117394);
      return;
    }
    if (paramLong <= 30000L)
    {
      if (paramBoolean)
      {
        g.yhR.idkeyStat(338L, 119L, 1L, false);
        AppMethodBeat.o(117394);
        return;
      }
      g.yhR.idkeyStat(338L, 124L, 1L, false);
      AppMethodBeat.o(117394);
      return;
    }
    if (paramLong <= 60000L)
    {
      if (paramBoolean)
      {
        g.yhR.idkeyStat(338L, 120L, 1L, false);
        AppMethodBeat.o(117394);
        return;
      }
      g.yhR.idkeyStat(338L, 125L, 1L, false);
      AppMethodBeat.o(117394);
      return;
    }
    if (paramLong >= 3600000L) {
      g.yhR.idkeyStat(338L, 133L, 1L, false);
    }
    if (paramBoolean)
    {
      g.yhR.idkeyStat(338L, 121L, 1L, false);
      AppMethodBeat.o(117394);
      return;
    }
    g.yhR.idkeyStat(338L, 126L, 1L, false);
    AppMethodBeat.o(117394);
  }
  
  public static void x(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(117401);
    g.yhR.idkeyStat(338L, 4L, 1L, false);
    if (!paramBoolean)
    {
      g.yhR.idkeyStat(338L, 159L, 1L, false);
      AppMethodBeat.o(117401);
      return;
    }
    ad.i("Tinker.HotPatchReportHelper", "hp_report report load cost = %d", new Object[] { Long.valueOf(paramLong) });
    if (paramLong < 0L)
    {
      ad.e("Tinker.HotPatchReportHelper", "hp_report report load cost failed, invalid cost");
      AppMethodBeat.o(117401);
      return;
    }
    if (paramBoolean)
    {
      com.tencent.mm.plugin.hp.tinker.b localb = com.tencent.mm.plugin.hp.tinker.b.ht(com.tencent.mm.loader.j.a.hgG, i.hgG);
      SharedPreferences localSharedPreferences = com.tencent.mm.plugin.hp.tinker.b.dcv();
      String str = localb.Iv(3);
      if (!localSharedPreferences.contains(str))
      {
        localb.ak(3, paramLong);
        localSharedPreferences.edit().putLong(str, paramLong).commit();
      }
    }
    if (paramLong <= 500L)
    {
      g.yhR.idkeyStat(338L, 177L, 1L, false);
      AppMethodBeat.o(117401);
      return;
    }
    if (paramLong <= 1000L)
    {
      g.yhR.idkeyStat(338L, 178L, 1L, false);
      AppMethodBeat.o(117401);
      return;
    }
    if (paramLong <= 3000L)
    {
      g.yhR.idkeyStat(338L, 179L, 1L, false);
      AppMethodBeat.o(117401);
      return;
    }
    if (paramLong <= 5000L)
    {
      g.yhR.idkeyStat(338L, 180L, 1L, false);
      AppMethodBeat.o(117401);
      return;
    }
    g.yhR.idkeyStat(338L, 181L, 1L, false);
    AppMethodBeat.o(117401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.b
 * JD-Core Version:    0.7.0.1
 */