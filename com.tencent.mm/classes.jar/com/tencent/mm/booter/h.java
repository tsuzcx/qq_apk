package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.h.a;
import com.tencent.mm.be.k;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.webwx.a.a;
import com.tencent.mm.plugin.webwx.a.g;
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
      public final void kb(int paramAnonymousInt)
      {
        AppMethodBeat.i(19884);
        Log.i("MicroMsg.PostTaskLightweightJob", "CrashStatus report: key %s ", new Object[] { Integer.valueOf(paramAnonymousInt) });
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(25L, paramAnonymousInt, 1L, false);
        AppMethodBeat.o(19884);
      }
    };
    if (localObject1 != null) {}
    label1175:
    label1180:
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
        if (!bool) {
          continue;
        }
        bh.beI();
        c.aHp().i(233475, Boolean.FALSE);
        continue;
      }
      localObject1 = MMApplicationContext.getContext();
      int i = com.tencent.mm.n.h.axc().getInt("AndroidGooglePlayCrashUploadSizeLimit", 8192);
      if ((localObject1 == null) || (i <= 0))
      {
        bh.beI();
        if (Util.milliSecondsToNow(Util.nullAs((Long)c.aHp().get(ar.a.Vgg, null), 0L)) > 21600000L)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(279L, com.tencent.mm.n.h.axc().getInt("AndroidDynamicConfigVer", 0) % 16, 1L, false);
          bh.beI();
          c.aHp().set(ar.a.Vgg, Long.valueOf(Util.nowMilliSecond()));
        }
        bh.beI();
        if (Util.milliSecondsToNow(Util.nullAs((Long)c.aHp().get(ar.a.Vgh, null), 0L)) > 21600000L)
        {
          bh.beI();
          c.aHp().set(ar.a.Vgh, Long.valueOf(Util.nowMilliSecond()));
          s.bqB().bra();
        }
        k.update();
        l = System.currentTimeMillis();
        bh.beI();
        bool = ((Boolean)c.aHp().b(233475, Boolean.FALSE)).booleanValue();
        bh.beI();
        if (c.bbL().hyq() > 0) {
          continue;
        }
        if (!bool)
        {
          bh.beI();
          c.bbR().bwv("officialaccounts");
          bh.beI();
          c.aHp().i(233475, Boolean.TRUE);
        }
        g.hcM().hcO().hcL();
        Log.i("MicroMsg.PostTaskLightweightJob", "use time %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(19885);
        return;
        localObject1 = ((SharedPreferences)localObject1).edit();
        ((SharedPreferences.Editor)localObject1).putString("crashlist", "");
        ((SharedPreferences.Editor)localObject1).commit();
        i = 0;
        if (i >= arrayOfString.length) {
          break label1180;
        }
        if (arrayOfString[i] == null)
        {
          localObject1 = null;
          if ((localObject1 == null) || (localObject1.length < 2)) {
            break label1175;
          }
          if (localObject1[1].equals("anr"))
          {
            local1.kb(10);
            break label1175;
          }
        }
        else
        {
          localObject1 = arrayOfString[i].split(",");
          continue;
        }
        local1.kb(11);
        if (MMApplicationContext.getApplicationId().equals(localObject1[0])) {
          local1.kb(14);
        }
        if ((MMApplicationContext.getApplicationId() + ":push").equals(localObject1[0])) {
          local1.kb(17);
        }
        if ((MMApplicationContext.getApplicationId() + ":tools").equals(localObject1[0])) {
          local1.kb(20);
        }
        if ((MMApplicationContext.getApplicationId() + ":toolsmp").equals(localObject1[0])) {
          local1.kb(20);
        }
        if (localObject1[1].equals("java"))
        {
          local1.kb(12);
          if (MMApplicationContext.getApplicationId().equals(localObject1[0])) {
            local1.kb(15);
          }
          if ((MMApplicationContext.getApplicationId() + ":push").equals(localObject1[0])) {
            local1.kb(18);
          }
          if ((MMApplicationContext.getApplicationId() + ":tools").equals(localObject1[0])) {
            local1.kb(21);
          }
          if ((MMApplicationContext.getApplicationId() + ":toolsmp").equals(localObject1[0])) {
            local1.kb(21);
          }
        }
        if (localObject1[1].equals("jni"))
        {
          local1.kb(13);
          if (MMApplicationContext.getApplicationId().equals(localObject1[0])) {
            local1.kb(16);
          }
          if ((MMApplicationContext.getApplicationId() + ":push").equals(localObject1[0])) {
            local1.kb(19);
          }
          if ((MMApplicationContext.getApplicationId() + ":tools").equals(localObject1[0])) {
            local1.kb(22);
          }
          if ((MMApplicationContext.getApplicationId() + ":toolsmp").equals(localObject1[0])) {
            local1.kb(22);
          }
        }
        if (!localObject1[1].equals("first")) {
          break label1175;
        }
        if (MMApplicationContext.getApplicationId().equals(localObject1[0])) {
          local1.kb(23);
        }
        if ((MMApplicationContext.getApplicationId() + ":push").equals(localObject1[0])) {
          local1.kb(24);
        }
        if ((MMApplicationContext.getApplicationId() + ":tools").equals(localObject1[0])) {
          local1.kb(25);
        }
        if (!(MMApplicationContext.getApplicationId() + ":toolsmp").equals(localObject1[0])) {
          break label1175;
        }
        local1.kb(25);
        break label1175;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.h
 * JD-Core Version:    0.7.0.1
 */