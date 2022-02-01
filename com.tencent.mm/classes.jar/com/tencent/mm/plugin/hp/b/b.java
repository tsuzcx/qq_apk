package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;

public final class b
{
  private static long ymo = 0L;
  
  public static void C(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(117394);
    if (paramBoolean) {
      h.CyF.idkeyStat(338L, 3L, 1L, true);
    }
    if (paramBoolean) {
      h.CyF.idkeyStat(338L, 101L, 1L, false);
    }
    for (;;)
    {
      Log.i("Tinker.HotPatchReportHelper", "hp_report report apply cost = %d", new Object[] { Long.valueOf(paramLong) });
      if (paramLong >= 0L) {
        break;
      }
      Log.e("Tinker.HotPatchReportHelper", "hp_report report apply cost failed, invalid cost");
      AppMethodBeat.o(117394);
      return;
      h.CyF.idkeyStat(338L, 103L, 1L, false);
    }
    if (paramLong <= 5000L)
    {
      if (paramBoolean)
      {
        h.CyF.idkeyStat(338L, 117L, 1L, false);
        AppMethodBeat.o(117394);
        return;
      }
      h.CyF.idkeyStat(338L, 122L, 1L, false);
      AppMethodBeat.o(117394);
      return;
    }
    if (paramLong <= 10000L)
    {
      if (paramBoolean)
      {
        h.CyF.idkeyStat(338L, 118L, 1L, false);
        AppMethodBeat.o(117394);
        return;
      }
      h.CyF.idkeyStat(338L, 123L, 1L, false);
      AppMethodBeat.o(117394);
      return;
    }
    if (paramLong <= 30000L)
    {
      if (paramBoolean)
      {
        h.CyF.idkeyStat(338L, 119L, 1L, false);
        AppMethodBeat.o(117394);
        return;
      }
      h.CyF.idkeyStat(338L, 124L, 1L, false);
      AppMethodBeat.o(117394);
      return;
    }
    if (paramLong <= 60000L)
    {
      if (paramBoolean)
      {
        h.CyF.idkeyStat(338L, 120L, 1L, false);
        AppMethodBeat.o(117394);
        return;
      }
      h.CyF.idkeyStat(338L, 125L, 1L, false);
      AppMethodBeat.o(117394);
      return;
    }
    if (paramLong >= 3600000L) {
      h.CyF.idkeyStat(338L, 133L, 1L, false);
    }
    if (paramBoolean)
    {
      h.CyF.idkeyStat(338L, 121L, 1L, false);
      AppMethodBeat.o(117394);
      return;
    }
    h.CyF.idkeyStat(338L, 126L, 1L, false);
    AppMethodBeat.o(117394);
  }
  
  public static void D(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(117401);
    h.CyF.idkeyStat(338L, 4L, 1L, false);
    if (!paramBoolean)
    {
      h.CyF.idkeyStat(338L, 159L, 1L, false);
      AppMethodBeat.o(117401);
      return;
    }
    Log.i("Tinker.HotPatchReportHelper", "hp_report report load cost = %d", new Object[] { Long.valueOf(paramLong) });
    if (paramLong < 0L)
    {
      Log.e("Tinker.HotPatchReportHelper", "hp_report report load cost failed, invalid cost");
      AppMethodBeat.o(117401);
      return;
    }
    if (paramBoolean)
    {
      com.tencent.mm.plugin.hp.tinker.b localb = com.tencent.mm.plugin.hp.tinker.b.ii(com.tencent.mm.loader.j.a.CLIENT_VERSION, BuildInfo.CLIENT_VERSION);
      SharedPreferences localSharedPreferences = com.tencent.mm.plugin.hp.tinker.b.dZh();
      String str = localb.OW(3);
      if (!localSharedPreferences.contains(str))
      {
        localb.aq(3, paramLong);
        localSharedPreferences.edit().putLong(str, paramLong).commit();
      }
    }
    if (paramLong <= 500L)
    {
      h.CyF.idkeyStat(338L, 177L, 1L, false);
      AppMethodBeat.o(117401);
      return;
    }
    if (paramLong <= 1000L)
    {
      h.CyF.idkeyStat(338L, 178L, 1L, false);
      AppMethodBeat.o(117401);
      return;
    }
    if (paramLong <= 3000L)
    {
      h.CyF.idkeyStat(338L, 179L, 1L, false);
      AppMethodBeat.o(117401);
      return;
    }
    if (paramLong <= 5000L)
    {
      h.CyF.idkeyStat(338L, 180L, 1L, false);
      AppMethodBeat.o(117401);
      return;
    }
    h.CyF.idkeyStat(338L, 181L, 1L, false);
    AppMethodBeat.o(117401);
  }
  
  public static void K(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(117403);
    Log.i("Tinker.HotPatchReportHelper", "hp_report package check failed, error = %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramBoolean) {
      h.CyF.idkeyStat(338L, 170L, 1L, false);
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(117403);
      return;
      h.CyF.aw(338, 169, 171);
      AppMethodBeat.o(117403);
      return;
      h.CyF.aw(338, 169, 172);
      AppMethodBeat.o(117403);
      return;
      h.CyF.aw(338, 169, 173);
      AppMethodBeat.o(117403);
      return;
      h.CyF.aw(338, 169, 175);
      AppMethodBeat.o(117403);
      return;
      h.CyF.aw(338, 169, 174);
      AppMethodBeat.o(117403);
      return;
      h.CyF.aw(338, 169, 176);
      AppMethodBeat.o(117403);
      return;
      h.CyF.aw(338, 107, 182);
      AppMethodBeat.o(117403);
      return;
      h.CyF.aw(338, 169, 186);
    }
  }
  
  public static void Mg(int paramInt)
  {
    AppMethodBeat.i(117388);
    Log.i("Tinker.HotPatchReportHelper", "hp_report new hotpatch requested");
    switch (paramInt)
    {
    }
    for (;;)
    {
      ymo = Util.currentTicks();
      AppMethodBeat.o(117388);
      return;
      h.CyF.idkeyStat(338L, 0L, 1L, false);
      continue;
      h.CyF.idkeyStat(338L, 20L, 1L, false);
      continue;
      h.CyF.idkeyStat(614L, 0L, 1L, false);
    }
  }
  
  public static void OP(int paramInt)
  {
    AppMethodBeat.i(117389);
    long l = Util.ticksToNow(ymo);
    Log.i("Tinker.HotPatchReportHelper", "hp_report report download cost = %d", new Object[] { Long.valueOf(l) });
    switch (paramInt)
    {
    }
    while (l < 0L)
    {
      Log.e("Tinker.HotPatchReportHelper", "hp_report report download cost failed, invalid cost");
      AppMethodBeat.o(117389);
      return;
      h.CyF.idkeyStat(338L, 40L, 1L, false);
    }
    if (l <= 5000L)
    {
      h.CyF.aw(338, 1, 43);
      AppMethodBeat.o(117389);
      return;
    }
    if (l <= 60000L)
    {
      h.CyF.aw(338, 1, 44);
      AppMethodBeat.o(117389);
      return;
    }
    if (l <= 180000L)
    {
      h.CyF.aw(338, 1, 45);
      AppMethodBeat.o(117389);
      return;
    }
    h.CyF.aw(338, 1, 46);
    AppMethodBeat.o(117389);
  }
  
  public static void OQ(int paramInt)
  {
    AppMethodBeat.i(117390);
    Log.i("Tinker.HotPatchReportHelper", "hp_report download failed");
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(117390);
      return;
      h.CyF.idkeyStat(338L, 41L, 1L, false);
      AppMethodBeat.o(117390);
      return;
      h.CyF.idkeyStat(338L, 42L, 1L, false);
      AppMethodBeat.o(117390);
      return;
      h.CyF.idkeyStat(614L, 3L, 1L, false);
    }
  }
  
  public static void OR(int paramInt)
  {
    AppMethodBeat.i(117392);
    Log.i("Tinker.HotPatchReportHelper", "hp_report try to apply hotpatch fail");
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(117392);
      return;
      h.CyF.idkeyStat(338L, 75L, 1L, false);
      AppMethodBeat.o(117392);
      return;
      h.CyF.idkeyStat(338L, 72L, 1L, false);
      AppMethodBeat.o(117392);
      return;
      h.CyF.idkeyStat(338L, 74L, 1L, false);
      AppMethodBeat.o(117392);
      return;
      h.CyF.idkeyStat(338L, 73L, 1L, false);
      AppMethodBeat.o(117392);
      return;
      h.CyF.idkeyStat(338L, 85L, 1L, false);
      AppMethodBeat.o(117392);
      return;
      h.CyF.idkeyStat(338L, 77L, 1L, false);
      AppMethodBeat.o(117392);
      return;
      h.CyF.idkeyStat(338L, 76L, 1L, false);
      AppMethodBeat.o(117392);
      return;
      h.CyF.idkeyStat(338L, 78L, 1L, false);
      AppMethodBeat.o(117392);
      return;
      h.CyF.idkeyStat(338L, 80L, 1L, false);
      AppMethodBeat.o(117392);
      return;
      h.CyF.idkeyStat(338L, 79L, 1L, false);
      AppMethodBeat.o(117392);
      return;
      h.CyF.idkeyStat(338L, 81L, 1L, false);
      AppMethodBeat.o(117392);
      return;
      h.CyF.idkeyStat(338L, 82L, 1L, false);
      AppMethodBeat.o(117392);
      return;
      h.CyF.idkeyStat(338L, 83L, 1L, false);
      AppMethodBeat.o(117392);
      return;
      h.CyF.idkeyStat(338L, 84L, 1L, false);
    }
  }
  
  public static void OS(int paramInt)
  {
    AppMethodBeat.i(117395);
    Log.i("Tinker.HotPatchReportHelper", "hp_report package check failed, error = %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(117395);
      return;
      h.CyF.aw(338, 107, 108);
      AppMethodBeat.o(117395);
      return;
      h.CyF.aw(338, 107, 109);
      AppMethodBeat.o(117395);
      return;
      h.CyF.aw(338, 107, 110);
      AppMethodBeat.o(117395);
      return;
      h.CyF.aw(338, 107, 112);
      AppMethodBeat.o(117395);
      return;
      h.CyF.aw(338, 107, 111);
      AppMethodBeat.o(117395);
      return;
      h.CyF.aw(338, 107, 113);
      AppMethodBeat.o(117395);
      return;
      h.CyF.aw(338, 107, 129);
      AppMethodBeat.o(117395);
      return;
      h.CyF.aw(338, 107, 131);
    }
  }
  
  public static void OT(int paramInt)
  {
    AppMethodBeat.i(117400);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(117400);
      return;
      h.CyF.idkeyStat(338L, 114L, 1L, false);
      AppMethodBeat.o(117400);
      return;
      h.CyF.idkeyStat(338L, 115L, 1L, false);
      AppMethodBeat.o(117400);
      return;
      h.CyF.idkeyStat(338L, 130L, 1L, false);
      AppMethodBeat.o(117400);
      return;
      h.CyF.idkeyStat(338L, 132L, 1L, false);
      AppMethodBeat.o(117400);
      return;
      h.CyF.idkeyStat(338L, 136L, 1L, false);
    }
  }
  
  public static void OU(int paramInt)
  {
    AppMethodBeat.i(117404);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(117404);
      return;
      h.CyF.idkeyStat(338L, 183L, 1L, false);
      AppMethodBeat.o(117404);
      return;
      h.CyF.idkeyStat(338L, 164L, 1L, false);
      AppMethodBeat.o(117404);
      return;
      h.CyF.idkeyStat(338L, 165L, 1L, false);
      AppMethodBeat.o(117404);
      return;
      h.CyF.idkeyStat(338L, 166L, 1L, false);
      AppMethodBeat.o(117404);
      return;
      h.CyF.idkeyStat(338L, 167L, 1L, false);
      AppMethodBeat.o(117404);
      return;
      h.CyF.idkeyStat(338L, 187L, 1L, false);
    }
  }
  
  public static void OV(int paramInt)
  {
    AppMethodBeat.i(117405);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(117405);
      return;
      h.CyF.idkeyStat(338L, 162L, 1L, false);
      AppMethodBeat.o(117405);
      return;
      h.CyF.idkeyStat(338L, 163L, 1L, false);
      AppMethodBeat.o(117405);
      return;
      h.CyF.idkeyStat(338L, 185L, 1L, false);
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
      h.CyF.idkeyStat(338L, 191L, 1L, false);
      h.CyF.e("Tinker", "Tinker Exception:interpret occur instruction exception " + MMUncaughtExceptionHandler.getExceptionCauseString(paramThrowable), null);
      AppMethodBeat.o(117408);
      return;
      h.CyF.idkeyStat(338L, 192L, 1L, false);
      h.CyF.e("Tinker", "Tinker Exception:interpret occur command exception " + MMUncaughtExceptionHandler.getExceptionCauseString(paramThrowable), null);
      AppMethodBeat.o(117408);
      return;
      h.CyF.idkeyStat(338L, 193L, 1L, false);
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
        String str1 = MMUncaughtExceptionHandler.getExceptionCauseString(paramThrowable);
        paramThrowable = str1;
        if (paramInt == -4)
        {
          Context localContext = MMApplicationContext.getContext();
          String str2 = SharePatchFileUtil.checkTinkerLastUncaughtCrash(localContext);
          paramThrowable = str1;
          if (!ShareTinkerInternals.isNullOrNil(str2))
          {
            paramThrowable = "tinker checkSafeModeCount fail:\n".concat(String.valueOf(str2));
            SharePatchFileUtil.safeDeleteFile(SharePatchFileUtil.getPatchLastCrashFile(localContext));
          }
        }
        h.CyF.e("Tinker", "Tinker Exception:load tinker occur exception ".concat(String.valueOf(paramThrowable)), null);
      }
      AppMethodBeat.o(117402);
      return;
      if (paramThrowable.getMessage().contains("checkDexInstall failed"))
      {
        h.CyF.idkeyStat(338L, 189L, 1L, false);
        Log.i("Tinker.HotPatchReportHelper", "tinker dex check fail:" + paramThrowable.getMessage());
        i = 1;
      }
      else
      {
        h.CyF.idkeyStat(338L, 161L, 1L, false);
        Log.e("Tinker.HotPatchReportHelper", "tinker dex reflect fail:" + paramThrowable.getMessage());
        continue;
        if (paramThrowable.getMessage().contains("checkResInstall failed"))
        {
          h.CyF.idkeyStat(338L, 190L, 1L, false);
          i = 1;
        }
        else
        {
          h.CyF.idkeyStat(338L, 184L, 1L, false);
          continue;
          h.CyF.idkeyStat(338L, 188L, 1L, false);
          continue;
          h.CyF.idkeyStat(338L, 160L, 1L, false);
        }
      }
    }
  }
  
  public static void aD(Intent paramIntent)
  {
    AppMethodBeat.i(117393);
    KVCommCrossProcessReceiver.eOA();
    Log.i("Tinker.HotPatchReportHelper", "hp_report try to apply patch service start");
    if (paramIntent == null)
    {
      h.CyF.aw(338, 6, 127);
      AppMethodBeat.o(117393);
      return;
    }
    if (ShareIntentUtil.getStringExtra(paramIntent, "patch_path_extra") == null)
    {
      h.CyF.aw(338, 6, 128);
      AppMethodBeat.o(117393);
      return;
    }
    h.CyF.idkeyStat(338L, 6L, 1L, true);
    AppMethodBeat.o(117393);
  }
  
  public static void dYV()
  {
    AppMethodBeat.i(117387);
    h.CyF.idkeyStat(338L, 9L, 1L, false);
    AppMethodBeat.o(117387);
  }
  
  public static void dYW()
  {
    AppMethodBeat.i(117398);
    h.CyF.idkeyStat(338L, 106L, 1L, false);
    AppMethodBeat.o(117398);
  }
  
  public static void dYX()
  {
    AppMethodBeat.i(117399);
    h.CyF.idkeyStat(338L, 116L, 1L, false);
    AppMethodBeat.o(117399);
  }
  
  public static void dYY()
  {
    AppMethodBeat.i(117406);
    h.CyF.idkeyStat(338L, 168L, 1L, false);
    AppMethodBeat.o(117406);
  }
  
  public static void dYZ()
  {
    AppMethodBeat.i(117407);
    h.CyF.idkeyStat(338L, 5L, 1L, false);
    AppMethodBeat.o(117407);
  }
  
  public static void e(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117409);
    h.CyF.a(15974, new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.FALSE });
    Log.i("Tinker.HotPatchReportHelper", "CodeVersion:%s PatchVersion:%s TinkerId:%s Scene:%d Result:%d", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(117409);
  }
  
  public static void k(Throwable paramThrowable)
  {
    AppMethodBeat.i(117396);
    h.CyF.idkeyStat(338L, 104L, 1L, false);
    h.CyF.e("Tinker", "Tinker Exception:apply tinker occur unknown exception " + MMUncaughtExceptionHandler.getExceptionCauseString(paramThrowable), null);
    AppMethodBeat.o(117396);
  }
  
  public static void l(Throwable paramThrowable)
  {
    AppMethodBeat.i(117397);
    if (paramThrowable.getMessage().contains("checkDexOptExist failed")) {
      h.CyF.idkeyStat(338L, 134L, 1L, false);
    }
    for (;;)
    {
      com.tencent.mm.plugin.hp.c.a.m(paramThrowable);
      AppMethodBeat.o(117397);
      return;
      if (paramThrowable.getMessage().contains("checkDexOptFormat failed"))
      {
        h.CyF.idkeyStat(338L, 135L, 1L, false);
        h.CyF.e("Tinker", "Tinker Exception:apply tinker occur dexOpt format exception " + MMUncaughtExceptionHandler.getExceptionCauseString(paramThrowable), null);
      }
      else
      {
        h.CyF.idkeyStat(338L, 105L, 1L, false);
        h.CyF.e("Tinker", "Tinker Exception:apply tinker occur dexOpt exception " + MMUncaughtExceptionHandler.getExceptionCauseString(paramThrowable), null);
      }
    }
  }
  
  public static void qj(boolean paramBoolean)
  {
    AppMethodBeat.i(117391);
    Log.i("Tinker.HotPatchReportHelper", "hp_report try to apply hotpatch");
    h.CyF.aw(338, 2, 71);
    if (paramBoolean) {
      h.CyF.idkeyStat(338L, 7L, 1L, true);
    }
    AppMethodBeat.o(117391);
  }
  
  public static enum a
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(117383);
      ymp = new a("FAILED", 0, 0);
      ymq = new a("SUCCESS", 1, 1);
      ymr = new a[] { ymp, ymq };
      AppMethodBeat.o(117383);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum b
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(117386);
      yms = new b("SCENE_PATCH", 0, 0);
      ymt = new b("SCENE_LOAD", 1, 1);
      ymu = new b("SCENE_CHECK", 2, 2);
      ymv = new b[] { yms, ymt, ymu };
      AppMethodBeat.o(117386);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.b
 * JD-Core Version:    0.7.0.1
 */