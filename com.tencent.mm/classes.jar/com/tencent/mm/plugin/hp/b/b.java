package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;

public final class b
{
  private static long nJW = 0L;
  
  public static void a(int paramInt, Throwable paramThrowable)
  {
    AppMethodBeat.i(90576);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(90576);
      return;
      h.qsU.idkeyStat(338L, 191L, 1L, false);
      h.qsU.g("Tinker", "Tinker Exception:interpret occur instruction exception " + ao.m(paramThrowable), null);
      AppMethodBeat.o(90576);
      return;
      h.qsU.idkeyStat(338L, 192L, 1L, false);
      h.qsU.g("Tinker", "Tinker Exception:interpret occur command exception " + ao.m(paramThrowable), null);
      AppMethodBeat.o(90576);
      return;
      h.qsU.idkeyStat(338L, 193L, 1L, false);
    }
  }
  
  public static void a(Throwable paramThrowable, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(90570);
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (i == 0)
      {
        String str1 = ao.m(paramThrowable);
        paramThrowable = str1;
        if (paramInt == -4)
        {
          Context localContext = ah.getContext();
          String str2 = SharePatchFileUtil.jB(localContext);
          paramThrowable = str1;
          if (!ShareTinkerInternals.isNullOrNil(str2))
          {
            paramThrowable = "tinker checkSafeModeCount fail:\n".concat(String.valueOf(str2));
            SharePatchFileUtil.aq(SharePatchFileUtil.jA(localContext));
          }
        }
        h.qsU.g("Tinker", "Tinker Exception:load tinker occur exception ".concat(String.valueOf(paramThrowable)), null);
      }
      AppMethodBeat.o(90570);
      return;
      if (paramThrowable.getMessage().contains("checkDexInstall failed"))
      {
        h.qsU.idkeyStat(338L, 189L, 1L, false);
        ab.i("Tinker.HotPatchReportHelper", "tinker dex check fail:" + paramThrowable.getMessage());
        i = 1;
      }
      else
      {
        h.qsU.idkeyStat(338L, 161L, 1L, false);
        ab.e("Tinker.HotPatchReportHelper", "tinker dex reflect fail:" + paramThrowable.getMessage());
        continue;
        if (paramThrowable.getMessage().contains("checkResInstall failed"))
        {
          h.qsU.idkeyStat(338L, 190L, 1L, false);
          i = 1;
        }
        else
        {
          h.qsU.idkeyStat(338L, 184L, 1L, false);
          continue;
          h.qsU.idkeyStat(338L, 188L, 1L, false);
          continue;
          h.qsU.idkeyStat(338L, 160L, 1L, false);
        }
      }
    }
  }
  
  public static void ab(Intent paramIntent)
  {
    AppMethodBeat.i(90561);
    KVCommCrossProcessReceiver.chJ();
    ab.i("Tinker.HotPatchReportHelper", "hp_report try to apply patch service start");
    if (paramIntent == null)
    {
      h.qsU.af(338, 6, 127);
      AppMethodBeat.o(90561);
      return;
    }
    if (ShareIntentUtil.n(paramIntent, "patch_path_extra") == null)
    {
      h.qsU.af(338, 6, 128);
      AppMethodBeat.o(90561);
      return;
    }
    h.qsU.idkeyStat(338L, 6L, 1L, true);
    AppMethodBeat.o(90561);
  }
  
  public static void bIb()
  {
    AppMethodBeat.i(90555);
    h.qsU.idkeyStat(338L, 9L, 1L, false);
    AppMethodBeat.o(90555);
  }
  
  public static void bIc()
  {
    AppMethodBeat.i(90566);
    h.qsU.idkeyStat(338L, 106L, 1L, false);
    AppMethodBeat.o(90566);
  }
  
  public static void bId()
  {
    AppMethodBeat.i(90567);
    h.qsU.idkeyStat(338L, 116L, 1L, false);
    AppMethodBeat.o(90567);
  }
  
  public static void bIe()
  {
    AppMethodBeat.i(90574);
    h.qsU.idkeyStat(338L, 168L, 1L, false);
    AppMethodBeat.o(90574);
  }
  
  public static void bIf()
  {
    AppMethodBeat.i(90575);
    h.qsU.idkeyStat(338L, 5L, 1L, false);
    AppMethodBeat.o(90575);
  }
  
  public static void e(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90577);
    h.qsU.e(15974, new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.FALSE });
    ab.i("Tinker.HotPatchReportHelper", "CodeVersion:%s PatchVersion:%s TinkerId:%s Scene:%d Result:%d", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(90577);
  }
  
  public static void h(Throwable paramThrowable)
  {
    AppMethodBeat.i(90564);
    h.qsU.idkeyStat(338L, 104L, 1L, false);
    h.qsU.g("Tinker", "Tinker Exception:apply tinker occur unknown exception " + ao.m(paramThrowable), null);
    AppMethodBeat.o(90564);
  }
  
  public static void i(Throwable paramThrowable)
  {
    AppMethodBeat.i(90565);
    if (paramThrowable.getMessage().contains("checkDexOptExist failed"))
    {
      h.qsU.idkeyStat(338L, 134L, 1L, false);
      AppMethodBeat.o(90565);
      return;
    }
    if (paramThrowable.getMessage().contains("checkDexOptFormat failed"))
    {
      h.qsU.idkeyStat(338L, 135L, 1L, false);
      h.qsU.g("Tinker", "Tinker Exception:apply tinker occur dexOpt format exception " + ao.m(paramThrowable), null);
      AppMethodBeat.o(90565);
      return;
    }
    h.qsU.idkeyStat(338L, 105L, 1L, false);
    h.qsU.g("Tinker", "Tinker Exception:apply tinker occur dexOpt exception " + ao.m(paramThrowable), null);
    AppMethodBeat.o(90565);
  }
  
  public static void iu(boolean paramBoolean)
  {
    AppMethodBeat.i(90559);
    ab.i("Tinker.HotPatchReportHelper", "hp_report try to apply hotpatch");
    h.qsU.af(338, 2, 71);
    if (paramBoolean) {
      h.qsU.idkeyStat(338L, 7L, 1L, true);
    }
    AppMethodBeat.o(90559);
  }
  
  public static void s(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(90562);
    if (paramBoolean) {
      h.qsU.idkeyStat(338L, 3L, 1L, true);
    }
    if (paramBoolean) {
      h.qsU.idkeyStat(338L, 101L, 1L, false);
    }
    for (;;)
    {
      ab.i("Tinker.HotPatchReportHelper", "hp_report report apply cost = %d", new Object[] { Long.valueOf(paramLong) });
      if (paramLong >= 0L) {
        break;
      }
      ab.e("Tinker.HotPatchReportHelper", "hp_report report apply cost failed, invalid cost");
      AppMethodBeat.o(90562);
      return;
      h.qsU.idkeyStat(338L, 103L, 1L, false);
    }
    if (paramLong <= 5000L)
    {
      if (paramBoolean)
      {
        h.qsU.idkeyStat(338L, 117L, 1L, false);
        AppMethodBeat.o(90562);
        return;
      }
      h.qsU.idkeyStat(338L, 122L, 1L, false);
      AppMethodBeat.o(90562);
      return;
    }
    if (paramLong <= 10000L)
    {
      if (paramBoolean)
      {
        h.qsU.idkeyStat(338L, 118L, 1L, false);
        AppMethodBeat.o(90562);
        return;
      }
      h.qsU.idkeyStat(338L, 123L, 1L, false);
      AppMethodBeat.o(90562);
      return;
    }
    if (paramLong <= 30000L)
    {
      if (paramBoolean)
      {
        h.qsU.idkeyStat(338L, 119L, 1L, false);
        AppMethodBeat.o(90562);
        return;
      }
      h.qsU.idkeyStat(338L, 124L, 1L, false);
      AppMethodBeat.o(90562);
      return;
    }
    if (paramLong <= 60000L)
    {
      if (paramBoolean)
      {
        h.qsU.idkeyStat(338L, 120L, 1L, false);
        AppMethodBeat.o(90562);
        return;
      }
      h.qsU.idkeyStat(338L, 125L, 1L, false);
      AppMethodBeat.o(90562);
      return;
    }
    if (paramLong >= 3600000L) {
      h.qsU.idkeyStat(338L, 133L, 1L, false);
    }
    if (paramBoolean)
    {
      h.qsU.idkeyStat(338L, 121L, 1L, false);
      AppMethodBeat.o(90562);
      return;
    }
    h.qsU.idkeyStat(338L, 126L, 1L, false);
    AppMethodBeat.o(90562);
  }
  
  public static void t(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(90569);
    h.qsU.idkeyStat(338L, 4L, 1L, false);
    if (!paramBoolean)
    {
      h.qsU.idkeyStat(338L, 159L, 1L, false);
      AppMethodBeat.o(90569);
      return;
    }
    ab.i("Tinker.HotPatchReportHelper", "hp_report report load cost = %d", new Object[] { Long.valueOf(paramLong) });
    if (paramLong < 0L)
    {
      ab.e("Tinker.HotPatchReportHelper", "hp_report report load cost failed, invalid cost");
      AppMethodBeat.o(90569);
      return;
    }
    if (paramBoolean)
    {
      com.tencent.mm.plugin.hp.tinker.b localb = com.tencent.mm.plugin.hp.tinker.b.eP(a.CLIENT_VERSION, f.CLIENT_VERSION);
      SharedPreferences localSharedPreferences = com.tencent.mm.plugin.hp.tinker.b.bIl();
      String str = localb.xC(3);
      if (!localSharedPreferences.contains(str))
      {
        localb.T(3, paramLong);
        localSharedPreferences.edit().putLong(str, paramLong).commit();
      }
    }
    if (paramLong <= 500L)
    {
      h.qsU.idkeyStat(338L, 177L, 1L, false);
      AppMethodBeat.o(90569);
      return;
    }
    if (paramLong <= 1000L)
    {
      h.qsU.idkeyStat(338L, 178L, 1L, false);
      AppMethodBeat.o(90569);
      return;
    }
    if (paramLong <= 3000L)
    {
      h.qsU.idkeyStat(338L, 179L, 1L, false);
      AppMethodBeat.o(90569);
      return;
    }
    if (paramLong <= 5000L)
    {
      h.qsU.idkeyStat(338L, 180L, 1L, false);
      AppMethodBeat.o(90569);
      return;
    }
    h.qsU.idkeyStat(338L, 181L, 1L, false);
    AppMethodBeat.o(90569);
  }
  
  public static void w(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(90571);
    ab.i("Tinker.HotPatchReportHelper", "hp_report package check failed, error = %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramBoolean) {
      h.qsU.idkeyStat(338L, 170L, 1L, false);
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(90571);
      return;
      h.qsU.af(338, 169, 171);
      AppMethodBeat.o(90571);
      return;
      h.qsU.af(338, 169, 172);
      AppMethodBeat.o(90571);
      return;
      h.qsU.af(338, 169, 173);
      AppMethodBeat.o(90571);
      return;
      h.qsU.af(338, 169, 175);
      AppMethodBeat.o(90571);
      return;
      h.qsU.af(338, 169, 174);
      AppMethodBeat.o(90571);
      return;
      h.qsU.af(338, 169, 176);
      AppMethodBeat.o(90571);
      return;
      h.qsU.af(338, 107, 182);
      AppMethodBeat.o(90571);
      return;
      h.qsU.af(338, 169, 186);
    }
  }
  
  public static void xA(int paramInt)
  {
    AppMethodBeat.i(90572);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(90572);
      return;
      h.qsU.idkeyStat(338L, 183L, 1L, false);
      AppMethodBeat.o(90572);
      return;
      h.qsU.idkeyStat(338L, 164L, 1L, false);
      AppMethodBeat.o(90572);
      return;
      h.qsU.idkeyStat(338L, 165L, 1L, false);
      AppMethodBeat.o(90572);
      return;
      h.qsU.idkeyStat(338L, 166L, 1L, false);
      AppMethodBeat.o(90572);
      return;
      h.qsU.idkeyStat(338L, 167L, 1L, false);
      AppMethodBeat.o(90572);
      return;
      h.qsU.idkeyStat(338L, 187L, 1L, false);
    }
  }
  
  public static void xB(int paramInt)
  {
    AppMethodBeat.i(90573);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(90573);
      return;
      h.qsU.idkeyStat(338L, 162L, 1L, false);
      AppMethodBeat.o(90573);
      return;
      h.qsU.idkeyStat(338L, 163L, 1L, false);
      AppMethodBeat.o(90573);
      return;
      h.qsU.idkeyStat(338L, 185L, 1L, false);
    }
  }
  
  public static void xu(int paramInt)
  {
    AppMethodBeat.i(90556);
    ab.i("Tinker.HotPatchReportHelper", "hp_report new hotpatch requested");
    switch (paramInt)
    {
    }
    for (;;)
    {
      nJW = bo.yB();
      AppMethodBeat.o(90556);
      return;
      h.qsU.idkeyStat(338L, 0L, 1L, false);
      continue;
      h.qsU.idkeyStat(338L, 20L, 1L, false);
      continue;
      h.qsU.idkeyStat(614L, 0L, 1L, false);
    }
  }
  
  public static void xv(int paramInt)
  {
    AppMethodBeat.i(90557);
    long l = bo.av(nJW);
    ab.i("Tinker.HotPatchReportHelper", "hp_report report download cost = %d", new Object[] { Long.valueOf(l) });
    switch (paramInt)
    {
    }
    while (l < 0L)
    {
      ab.e("Tinker.HotPatchReportHelper", "hp_report report download cost failed, invalid cost");
      AppMethodBeat.o(90557);
      return;
      h.qsU.idkeyStat(338L, 40L, 1L, false);
    }
    if (l <= 5000L)
    {
      h.qsU.af(338, 1, 43);
      AppMethodBeat.o(90557);
      return;
    }
    if (l <= 60000L)
    {
      h.qsU.af(338, 1, 44);
      AppMethodBeat.o(90557);
      return;
    }
    if (l <= 180000L)
    {
      h.qsU.af(338, 1, 45);
      AppMethodBeat.o(90557);
      return;
    }
    h.qsU.af(338, 1, 46);
    AppMethodBeat.o(90557);
  }
  
  public static void xw(int paramInt)
  {
    AppMethodBeat.i(90558);
    ab.i("Tinker.HotPatchReportHelper", "hp_report download failed");
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(90558);
      return;
      h.qsU.idkeyStat(338L, 41L, 1L, false);
      AppMethodBeat.o(90558);
      return;
      h.qsU.idkeyStat(338L, 42L, 1L, false);
      AppMethodBeat.o(90558);
      return;
      h.qsU.idkeyStat(614L, 3L, 1L, false);
    }
  }
  
  public static void xx(int paramInt)
  {
    AppMethodBeat.i(90560);
    ab.i("Tinker.HotPatchReportHelper", "hp_report try to apply hotpatch fail");
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(90560);
      return;
      h.qsU.idkeyStat(338L, 75L, 1L, false);
      AppMethodBeat.o(90560);
      return;
      h.qsU.idkeyStat(338L, 72L, 1L, false);
      AppMethodBeat.o(90560);
      return;
      h.qsU.idkeyStat(338L, 74L, 1L, false);
      AppMethodBeat.o(90560);
      return;
      h.qsU.idkeyStat(338L, 73L, 1L, false);
      AppMethodBeat.o(90560);
      return;
      h.qsU.idkeyStat(338L, 85L, 1L, false);
      AppMethodBeat.o(90560);
      return;
      h.qsU.idkeyStat(338L, 77L, 1L, false);
      AppMethodBeat.o(90560);
      return;
      h.qsU.idkeyStat(338L, 76L, 1L, false);
      AppMethodBeat.o(90560);
      return;
      h.qsU.idkeyStat(338L, 78L, 1L, false);
      AppMethodBeat.o(90560);
      return;
      h.qsU.idkeyStat(338L, 80L, 1L, false);
      AppMethodBeat.o(90560);
      return;
      h.qsU.idkeyStat(338L, 79L, 1L, false);
      AppMethodBeat.o(90560);
      return;
      h.qsU.idkeyStat(338L, 81L, 1L, false);
      AppMethodBeat.o(90560);
      return;
      h.qsU.idkeyStat(338L, 82L, 1L, false);
      AppMethodBeat.o(90560);
      return;
      h.qsU.idkeyStat(338L, 83L, 1L, false);
      AppMethodBeat.o(90560);
      return;
      h.qsU.idkeyStat(338L, 84L, 1L, false);
    }
  }
  
  public static void xy(int paramInt)
  {
    AppMethodBeat.i(90563);
    ab.i("Tinker.HotPatchReportHelper", "hp_report package check failed, error = %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(90563);
      return;
      h.qsU.af(338, 107, 108);
      AppMethodBeat.o(90563);
      return;
      h.qsU.af(338, 107, 109);
      AppMethodBeat.o(90563);
      return;
      h.qsU.af(338, 107, 110);
      AppMethodBeat.o(90563);
      return;
      h.qsU.af(338, 107, 112);
      AppMethodBeat.o(90563);
      return;
      h.qsU.af(338, 107, 111);
      AppMethodBeat.o(90563);
      return;
      h.qsU.af(338, 107, 113);
      AppMethodBeat.o(90563);
      return;
      h.qsU.af(338, 107, 129);
      AppMethodBeat.o(90563);
      return;
      h.qsU.af(338, 107, 131);
    }
  }
  
  public static void xz(int paramInt)
  {
    AppMethodBeat.i(90568);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(90568);
      return;
      h.qsU.idkeyStat(338L, 114L, 1L, false);
      AppMethodBeat.o(90568);
      return;
      h.qsU.idkeyStat(338L, 115L, 1L, false);
      AppMethodBeat.o(90568);
      return;
      h.qsU.idkeyStat(338L, 130L, 1L, false);
      AppMethodBeat.o(90568);
      return;
      h.qsU.idkeyStat(338L, 132L, 1L, false);
      AppMethodBeat.o(90568);
      return;
      h.qsU.idkeyStat(338L, 136L, 1L, false);
    }
  }
  
  public static enum a
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(90551);
      nJX = new a("FAILED", 0, 0);
      nJY = new a("SUCCESS", 1, 1);
      nJZ = new a[] { nJX, nJY };
      AppMethodBeat.o(90551);
    }
    
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