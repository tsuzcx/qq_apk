package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.h.a;
import com.tencent.mm.bb.j;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.webwx.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;

public final class h
{
  public static void run()
  {
    AppMethodBeat.i(19885);
    Object localObject1 = MMApplicationContext.getContext();
    h.a local1 = new h.a()
    {
      public final void iN(int paramAnonymousInt)
      {
        AppMethodBeat.i(19884);
        Log.i("MicroMsg.PostTaskLightweightJob", "CrashStatus report: key %s ", new Object[] { Integer.valueOf(paramAnonymousInt) });
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(25L, paramAnonymousInt, 1L, false);
        AppMethodBeat.o(19884);
      }
    };
    if (localObject1 != null) {}
    label1224:
    label1229:
    for (;;)
    {
      try
      {
        localObject1 = ((Context)localObject1).getSharedPreferences("crash_status_file", 4);
        arrayOfString = ((SharedPreferences)localObject1).getString("crashlist", "").split(";");
        if (arrayOfString != null)
        {
          i = arrayOfString.length;
          if (i > 0) {
            continue;
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        String[] arrayOfString;
        long l;
        boolean bool;
        continue;
        try
        {
          Object localObject2 = localThrowable1.getSharedPreferences("crash_status_file", 4);
          if (((SharedPreferences)localObject2).getInt("googleplaysizelimit", 8192) == i) {
            continue;
          }
          localObject2 = ((SharedPreferences)localObject2).edit();
          ((SharedPreferences.Editor)localObject2).putInt("googleplaysizelimit", i);
          ((SharedPreferences.Editor)localObject2).commit();
        }
        catch (Throwable localThrowable2) {}
        continue;
        i = 0;
        continue;
        if (!bool) {
          continue;
        }
        bg.aVF();
        c.azQ().set(233475, Boolean.FALSE);
        continue;
      }
      localObject1 = MMApplicationContext.getContext();
      int i = com.tencent.mm.n.h.aqJ().getInt("AndroidGooglePlayCrashUploadSizeLimit", 8192);
      if ((localObject1 == null) || (i <= 0))
      {
        bg.aVF();
        if (Util.milliSecondsToNow(Util.nullAs((Long)c.azQ().get(ar.a.NSi, null), 0L)) > 21600000L)
        {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(279L, com.tencent.mm.n.h.aqJ().getInt("AndroidDynamicConfigVer", 0) % 16, 1L, false);
          bg.aVF();
          c.azQ().set(ar.a.NSi, Long.valueOf(Util.nowMilliSecond()));
        }
        bg.aVF();
        if (Util.milliSecondsToNow(Util.nullAs((Long)c.azQ().get(ar.a.NSj, null), 0L)) > 21600000L)
        {
          bg.aVF();
          c.azQ().set(ar.a.NSj, Long.valueOf(Util.nowMilliSecond()));
          o.bhj().bhE();
        }
        l = Util.nullAs((Long)com.tencent.mm.kernel.g.aAh().azQ().get(81939, null), 0L);
        if (Util.nowMilliSecond() - l <= 86400000L) {
          continue;
        }
        i = 1;
        if (i != 0) {
          new j();
        }
        l = System.currentTimeMillis();
        bg.aVF();
        bool = ((Boolean)c.azQ().get(233475, Boolean.FALSE)).booleanValue();
        bg.aVF();
        if (c.aSN().gCe() > 0) {
          continue;
        }
        if (!bool)
        {
          bg.aVF();
          c.aST().bjW("officialaccounts");
          bg.aVF();
          c.azQ().set(233475, Boolean.TRUE);
        }
        com.tencent.mm.plugin.webwx.a.g.gjb().gjd().gja();
        Log.i("MicroMsg.PostTaskLightweightJob", "use time %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(19885);
        return;
        localObject1 = ((SharedPreferences)localObject1).edit();
        ((SharedPreferences.Editor)localObject1).putString("crashlist", "");
        ((SharedPreferences.Editor)localObject1).commit();
        i = 0;
        if (i >= arrayOfString.length) {
          break label1229;
        }
        if (arrayOfString[i] == null)
        {
          localObject1 = null;
          if ((localObject1 == null) || (localObject1.length < 2)) {
            break label1224;
          }
          if (localObject1[1].equals("anr"))
          {
            local1.iN(10);
            break label1224;
          }
        }
        else
        {
          localObject1 = arrayOfString[i].split(",");
          continue;
        }
        local1.iN(11);
        if (MMApplicationContext.getApplicationId().equals(localObject1[0])) {
          local1.iN(14);
        }
        if ((MMApplicationContext.getApplicationId() + ":push").equals(localObject1[0])) {
          local1.iN(17);
        }
        if ((MMApplicationContext.getApplicationId() + ":tools").equals(localObject1[0])) {
          local1.iN(20);
        }
        if ((MMApplicationContext.getApplicationId() + ":toolsmp").equals(localObject1[0])) {
          local1.iN(20);
        }
        if (localObject1[1].equals("java"))
        {
          local1.iN(12);
          if (MMApplicationContext.getApplicationId().equals(localObject1[0])) {
            local1.iN(15);
          }
          if ((MMApplicationContext.getApplicationId() + ":push").equals(localObject1[0])) {
            local1.iN(18);
          }
          if ((MMApplicationContext.getApplicationId() + ":tools").equals(localObject1[0])) {
            local1.iN(21);
          }
          if ((MMApplicationContext.getApplicationId() + ":toolsmp").equals(localObject1[0])) {
            local1.iN(21);
          }
        }
        if (localObject1[1].equals("jni"))
        {
          local1.iN(13);
          if (MMApplicationContext.getApplicationId().equals(localObject1[0])) {
            local1.iN(16);
          }
          if ((MMApplicationContext.getApplicationId() + ":push").equals(localObject1[0])) {
            local1.iN(19);
          }
          if ((MMApplicationContext.getApplicationId() + ":tools").equals(localObject1[0])) {
            local1.iN(22);
          }
          if ((MMApplicationContext.getApplicationId() + ":toolsmp").equals(localObject1[0])) {
            local1.iN(22);
          }
        }
        if (!localObject1[1].equals("first")) {
          break label1224;
        }
        if (MMApplicationContext.getApplicationId().equals(localObject1[0])) {
          local1.iN(23);
        }
        if ((MMApplicationContext.getApplicationId() + ":push").equals(localObject1[0])) {
          local1.iN(24);
        }
        if ((MMApplicationContext.getApplicationId() + ":tools").equals(localObject1[0])) {
          local1.iN(25);
        }
        if (!(MMApplicationContext.getApplicationId() + ":toolsmp").equals(localObject1[0])) {
          break label1224;
        }
        local1.iN(25);
        break label1224;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.h
 * JD-Core Version:    0.7.0.1
 */