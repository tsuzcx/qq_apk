package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f.a;
import com.tencent.mm.ba.i;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.webwx.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.z;

public final class h
{
  public static void run()
  {
    AppMethodBeat.i(15851);
    Object localObject1 = com.tencent.mm.sdk.platformtools.ah.getContext();
    Object localObject4 = new h.1();
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
          if (((SharedPreferences)localObject3).getInt("googleplaysizelimit", 3072) == i) {
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
        if (!r.Zn().equals(localObject5)) {
          break;
        }
      }
      localObject1 = com.tencent.mm.sdk.platformtools.ah.getContext();
      i = com.tencent.mm.m.g.Nq().getInt("AndroidGooglePlayCrashUploadSizeLimit", 3072);
      if ((localObject1 == null) || (i <= 0))
      {
        aw.aaz();
        if (com.tencent.mm.platformtools.ah.hl(com.tencent.mm.platformtools.ah.d((Long)c.Ru().get(ac.a.yxp, null))) > 21600000L)
        {
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(279L, com.tencent.mm.m.g.Nq().getInt("AndroidDynamicConfigVer", 0) % 16, 1L, false);
          aw.aaz();
          c.Ru().set(ac.a.yxp, Long.valueOf(com.tencent.mm.platformtools.ah.aoy()));
        }
        aw.aaz();
        if (com.tencent.mm.platformtools.ah.hl(com.tencent.mm.platformtools.ah.d((Long)c.Ru().get(ac.a.yxq, null))) > 21600000L)
        {
          aw.aaz();
          c.Ru().set(ac.a.yxq, Long.valueOf(com.tencent.mm.platformtools.ah.aoy()));
          localObject4 = o.alE();
          localObject1 = new int[6];
          Object tmp227_225 = localObject1;
          tmp227_225[0] = 0;
          Object tmp231_227 = tmp227_225;
          tmp231_227[1] = 0;
          Object tmp235_231 = tmp231_227;
          tmp235_231[2] = 0;
          Object tmp239_235 = tmp235_231;
          tmp239_235[3] = 0;
          Object tmp243_239 = tmp239_235;
          tmp243_239[4] = 0;
          Object tmp247_243 = tmp243_239;
          tmp247_243[5] = 0;
          tmp247_243;
          try
          {
            localObject5 = "select status, videofuncflag, human from videoinfo2 where lastmodifytime > ".concat(String.valueOf(bo.aox() - 21600L));
            ab.i("MicroMsg.VideoInfoStorage", "reportVideoMsgCount sql:%s", new Object[] { localObject5 });
            localObject4 = ((t)localObject4).fnw.a((String)localObject5, null, 2);
            if (!((Cursor)localObject4).moveToNext()) {
              break label1150;
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
            l = bo.a((Long)com.tencent.mm.kernel.g.RL().Ru().get(81939, null), 0L);
          }
          catch (Exception localException) {}
        }
        if (bo.aoy() - l <= 86400000L) {
          break label1244;
        }
        i = 1;
        if (i != 0) {
          new i();
        }
        l = System.currentTimeMillis();
        aw.aaz();
        bool = ((Boolean)c.Ru().get(233475, Boolean.FALSE)).booleanValue();
        aw.aaz();
        if (c.YA().dwQ() > 0) {
          break label1249;
        }
        if (!bool)
        {
          aw.aaz();
          c.YF().arF("officialaccounts");
          aw.aaz();
          c.Ru().set(233475, Boolean.TRUE);
        }
        com.tencent.mm.plugin.webwx.a.g.dhh().dhj().dhf();
        ab.i("MicroMsg.PostTaskLightweightJob", "use time %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(15851);
        return;
        localObject2 = localException.edit();
        ((SharedPreferences.Editor)localObject2).putString("crashlist", "");
        ((SharedPreferences.Editor)localObject2).commit();
        i = 0;
        if (i >= localObject5.length) {
          break label1277;
        }
        if (localObject5[i] == null)
        {
          localObject2 = null;
          if ((localObject2 == null) || (localObject2.length < 2)) {
            break label1272;
          }
          if (localObject2[1].equals("anr"))
          {
            ((f.a)localObject4).ge(10);
            break label1272;
          }
        }
        else
        {
          localObject2 = localObject5[i].split(",");
          continue;
        }
        ((f.a)localObject4).ge(11);
        if ("com.tencent.mm".equals(localObject2[0])) {
          ((f.a)localObject4).ge(14);
        }
        if ("com.tencent.mm:push".equals(localObject2[0])) {
          ((f.a)localObject4).ge(17);
        }
        if ("com.tencent.mm:tools".equals(localObject2[0])) {
          ((f.a)localObject4).ge(20);
        }
        if ("com.tencent.mm:toolsmp".equals(localObject2[0])) {
          ((f.a)localObject4).ge(20);
        }
        if (localObject2[1].equals("java"))
        {
          ((f.a)localObject4).ge(12);
          if ("com.tencent.mm".equals(localObject2[0])) {
            ((f.a)localObject4).ge(15);
          }
          if ("com.tencent.mm:push".equals(localObject2[0])) {
            ((f.a)localObject4).ge(18);
          }
          if ("com.tencent.mm:tools".equals(localObject2[0])) {
            ((f.a)localObject4).ge(21);
          }
          if ("com.tencent.mm:toolsmp".equals(localObject2[0])) {
            ((f.a)localObject4).ge(21);
          }
        }
        if (localObject2[1].equals("jni"))
        {
          ((f.a)localObject4).ge(13);
          if ("com.tencent.mm".equals(localObject2[0])) {
            ((f.a)localObject4).ge(16);
          }
          if ("com.tencent.mm:push".equals(localObject2[0])) {
            ((f.a)localObject4).ge(19);
          }
          if ("com.tencent.mm:tools".equals(localObject2[0])) {
            ((f.a)localObject4).ge(22);
          }
          if ("com.tencent.mm:toolsmp".equals(localObject2[0])) {
            ((f.a)localObject4).ge(22);
          }
        }
        if (!localObject2[1].equals("first")) {
          break label1272;
        }
        if ("com.tencent.mm".equals(localObject2[0])) {
          ((f.a)localObject4).ge(23);
        }
        if ("com.tencent.mm:push".equals(localObject2[0])) {
          ((f.a)localObject4).ge(24);
        }
        if ("com.tencent.mm:tools".equals(localObject2[0])) {
          ((f.a)localObject4).ge(25);
        }
        if (!"com.tencent.mm:toolsmp".equals(localObject2[0])) {
          break label1272;
        }
        ((f.a)localObject4).ge(25);
        break label1272;
      }
      if (j == 3)
      {
        i = 1;
        break label1279;
        label1150:
        ((Cursor)localObject4).close();
        com.tencent.mm.plugin.report.service.h.qsU.e(12696, new Object[] { Integer.valueOf(10010), Integer.valueOf(localThrowable2[0]), Integer.valueOf(localThrowable2[1]), Integer.valueOf(localThrowable2[2]), Integer.valueOf(localThrowable2[3]), Integer.valueOf(localThrowable2[4]), Integer.valueOf(localThrowable2[5]) });
        continue;
        label1244:
        i = 0;
        continue;
        label1249:
        if (!bool) {
          continue;
        }
        aw.aaz();
        c.Ru().set(233475, Boolean.FALSE);
        continue;
        label1272:
        i += 1;
        continue;
        label1277:
        continue;
      }
      for (;;)
      {
        label1279:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.h
 * JD-Core Version:    0.7.0.1
 */