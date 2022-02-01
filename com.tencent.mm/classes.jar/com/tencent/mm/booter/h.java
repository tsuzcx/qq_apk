package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.h.a;
import com.tencent.mm.bb.i;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.webwx.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;

public final class h
{
  public static void run()
  {
    AppMethodBeat.i(19885);
    Object localObject1 = ai.getContext();
    Object localObject4 = new h.a()
    {
      public final void hl(int paramAnonymousInt)
      {
        AppMethodBeat.i(19884);
        ac.i("MicroMsg.PostTaskLightweightJob", "CrashStatus report: key %s ", new Object[] { Integer.valueOf(paramAnonymousInt) });
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(25L, paramAnonymousInt, 1L, false);
        AppMethodBeat.o(19884);
      }
    };
    if (localObject1 != null) {}
    int j;
    for (;;)
    {
      boolean bool;
      try
      {
        localObject1 = ((Context)localObject1).getSharedPreferences("crash_status_file", 4);
        localObject5 = ((SharedPreferences)localObject1).getString("crashlist", "").split(";");
        if (localObject5 != null)
        {
          i = localObject5.length;
          if (i > 0) {
            continue;
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        Object localObject5;
        long l;
        Object localObject2;
        continue;
        try
        {
          Object localObject3 = localThrowable1.getSharedPreferences("crash_status_file", 4);
          if (((SharedPreferences)localObject3).getInt("googleplaysizelimit", 8192) == i) {
            continue;
          }
          localObject3 = ((SharedPreferences)localObject3).edit();
          ((SharedPreferences.Editor)localObject3).putInt("googleplaysizelimit", i);
          ((SharedPreferences.Editor)localObject3).commit();
        }
        catch (Throwable localThrowable2) {}
        continue;
        i = 3;
        continue;
        if (199 != i) {
          continue;
        }
        if (!u.axw().equals(localObject5)) {
          break;
        }
      }
      localObject1 = ai.getContext();
      i = com.tencent.mm.m.g.ZY().getInt("AndroidGooglePlayCrashUploadSizeLimit", 8192);
      if ((localObject1 == null) || (i <= 0))
      {
        az.ayM();
        if (bs.Ap(bs.a((Long)c.agA().get(ah.a.GDx, null), 0L)) > 21600000L)
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(279L, com.tencent.mm.m.g.ZY().getInt("AndroidDynamicConfigVer", 0) % 16, 1L, false);
          az.ayM();
          c.agA().set(ah.a.GDx, Long.valueOf(bs.eWj()));
        }
        az.ayM();
        if (bs.Ap(bs.a((Long)c.agA().get(ah.a.GDy, null), 0L)) > 21600000L)
        {
          az.ayM();
          c.agA().set(ah.a.GDy, Long.valueOf(bs.eWj()));
          localObject4 = o.aJy();
          localObject1 = new int[6];
          Object tmp229_227 = localObject1;
          tmp229_227[0] = 0;
          Object tmp233_229 = tmp229_227;
          tmp233_229[1] = 0;
          Object tmp237_233 = tmp233_229;
          tmp237_233[2] = 0;
          Object tmp241_237 = tmp237_233;
          tmp241_237[3] = 0;
          Object tmp245_241 = tmp241_237;
          tmp245_241[4] = 0;
          Object tmp249_245 = tmp245_241;
          tmp249_245[5] = 0;
          tmp249_245;
          try
          {
            localObject5 = "select status, videofuncflag, human from videoinfo2 where lastmodifytime > ".concat(String.valueOf(bs.aNx() - 21600L));
            ac.i("MicroMsg.VideoInfoStorage", "reportVideoMsgCount sql:%s", new Object[] { localObject5 });
            localObject4 = ((t)localObject4).hpA.a((String)localObject5, null, 2);
            if (!((Cursor)localObject4).moveToNext()) {
              break label1152;
            }
            i = ((Cursor)localObject4).getInt(0);
            j = ((Cursor)localObject4).getInt(1);
            localObject5 = ((Cursor)localObject4).getString(2);
            if (111 != i) {
              continue;
            }
            if (j != 3) {
              continue;
            }
            i = 0;
            localObject1[i] += 1;
            continue;
            l = bs.a((Long)com.tencent.mm.kernel.g.agR().agA().get(81939, null), 0L);
          }
          catch (Exception localException) {}
        }
        if (bs.eWj() - l <= 86400000L) {
          break label1246;
        }
        i = 1;
        if (i != 0) {
          new i();
        }
        l = System.currentTimeMillis();
        az.ayM();
        bool = ((Boolean)c.agA().get(233475, Boolean.FALSE)).booleanValue();
        az.ayM();
        if (c.awB().fav() > 0) {
          break label1251;
        }
        if (!bool)
        {
          az.ayM();
          c.awG().aNG("officialaccounts");
          az.ayM();
          c.agA().set(233475, Boolean.TRUE);
        }
        com.tencent.mm.plugin.webwx.a.g.eHq().eHs().eHp();
        ac.i("MicroMsg.PostTaskLightweightJob", "use time %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(19885);
        return;
        localObject2 = localException.edit();
        ((SharedPreferences.Editor)localObject2).putString("crashlist", "");
        ((SharedPreferences.Editor)localObject2).commit();
        i = 0;
        if (i >= localObject5.length) {
          break label1279;
        }
        if (localObject5[i] == null)
        {
          localObject2 = null;
          if ((localObject2 == null) || (localObject2.length < 2)) {
            break label1274;
          }
          if (localObject2[1].equals("anr"))
          {
            ((h.a)localObject4).hl(10);
            break label1274;
          }
        }
        else
        {
          localObject2 = localObject5[i].split(",");
          continue;
        }
        ((h.a)localObject4).hl(11);
        if ("com.tencent.mm".equals(localObject2[0])) {
          ((h.a)localObject4).hl(14);
        }
        if ("com.tencent.mm:push".equals(localObject2[0])) {
          ((h.a)localObject4).hl(17);
        }
        if ("com.tencent.mm:tools".equals(localObject2[0])) {
          ((h.a)localObject4).hl(20);
        }
        if ("com.tencent.mm:toolsmp".equals(localObject2[0])) {
          ((h.a)localObject4).hl(20);
        }
        if (localObject2[1].equals("java"))
        {
          ((h.a)localObject4).hl(12);
          if ("com.tencent.mm".equals(localObject2[0])) {
            ((h.a)localObject4).hl(15);
          }
          if ("com.tencent.mm:push".equals(localObject2[0])) {
            ((h.a)localObject4).hl(18);
          }
          if ("com.tencent.mm:tools".equals(localObject2[0])) {
            ((h.a)localObject4).hl(21);
          }
          if ("com.tencent.mm:toolsmp".equals(localObject2[0])) {
            ((h.a)localObject4).hl(21);
          }
        }
        if (localObject2[1].equals("jni"))
        {
          ((h.a)localObject4).hl(13);
          if ("com.tencent.mm".equals(localObject2[0])) {
            ((h.a)localObject4).hl(16);
          }
          if ("com.tencent.mm:push".equals(localObject2[0])) {
            ((h.a)localObject4).hl(19);
          }
          if ("com.tencent.mm:tools".equals(localObject2[0])) {
            ((h.a)localObject4).hl(22);
          }
          if ("com.tencent.mm:toolsmp".equals(localObject2[0])) {
            ((h.a)localObject4).hl(22);
          }
        }
        if (!localObject2[1].equals("first")) {
          break label1274;
        }
        if ("com.tencent.mm".equals(localObject2[0])) {
          ((h.a)localObject4).hl(23);
        }
        if ("com.tencent.mm:push".equals(localObject2[0])) {
          ((h.a)localObject4).hl(24);
        }
        if ("com.tencent.mm:tools".equals(localObject2[0])) {
          ((h.a)localObject4).hl(25);
        }
        if (!"com.tencent.mm:toolsmp".equals(localObject2[0])) {
          break label1274;
        }
        ((h.a)localObject4).hl(25);
        break label1274;
      }
      if (j == 3)
      {
        i = 1;
        break label1281;
        label1152:
        ((Cursor)localObject4).close();
        com.tencent.mm.plugin.report.service.h.wUl.f(12696, new Object[] { Integer.valueOf(10010), Integer.valueOf(localThrowable2[0]), Integer.valueOf(localThrowable2[1]), Integer.valueOf(localThrowable2[2]), Integer.valueOf(localThrowable2[3]), Integer.valueOf(localThrowable2[4]), Integer.valueOf(localThrowable2[5]) });
        continue;
        label1246:
        i = 0;
        continue;
        label1251:
        if (!bool) {
          continue;
        }
        az.ayM();
        c.agA().set(233475, Boolean.FALSE);
        continue;
        label1274:
        i += 1;
        continue;
        label1279:
        continue;
      }
      for (;;)
      {
        label1281:
        localThrowable2[i] += 1;
        break;
        i = 4;
      }
    }
    if (j == 3) {}
    for (int i = 2;; i = 5)
    {
      localThrowable2[i] += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.h
 * JD-Core Version:    0.7.0.1
 */