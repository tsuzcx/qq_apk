package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import com.tencent.mm.app.f.a;
import com.tencent.mm.az.i;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.webwx.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.z;

public final class g
{
  public static void run()
  {
    Object localObject1 = ae.getContext();
    Object localObject4 = new g.1();
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
        if (!q.Gj().equals(localObject5)) {
          break;
        }
      }
      localObject1 = ae.getContext();
      i = com.tencent.mm.m.g.AA().getInt("AndroidGooglePlayCrashUploadSizeLimit", 3072);
      if ((localObject1 == null) || (i <= 0))
      {
        au.Hx();
        if (ah.co(ah.d((Long)c.Dz().get(ac.a.uny, null))) > 21600000L)
        {
          com.tencent.mm.plugin.report.service.h.nFQ.a(279L, com.tencent.mm.m.g.AA().getInt("AndroidDynamicConfigVer", 0) % 16, 1L, false);
          au.Hx();
          c.Dz().c(ac.a.uny, Long.valueOf(ah.UY()));
        }
        au.Hx();
        if (ah.co(ah.d((Long)c.Dz().get(ac.a.unz, null))) > 21600000L)
        {
          au.Hx();
          c.Dz().c(ac.a.unz, Long.valueOf(ah.UY()));
          localObject4 = o.Sr();
          localObject1 = new int[6];
          Object tmp221_219 = localObject1;
          tmp221_219[0] = 0;
          Object tmp225_221 = tmp221_219;
          tmp225_221[1] = 0;
          Object tmp229_225 = tmp225_221;
          tmp229_225[2] = 0;
          Object tmp233_229 = tmp229_225;
          tmp233_229[3] = 0;
          Object tmp237_233 = tmp233_229;
          tmp237_233[4] = 0;
          Object tmp241_237 = tmp237_233;
          tmp241_237[5] = 0;
          tmp241_237;
          try
          {
            l = bk.UX();
            localObject5 = "select status, videofuncflag, human from videoinfo2 where lastmodifytime > " + (l - 21600L);
            y.i("MicroMsg.VideoInfoStorage", "reportVideoMsgCount sql:%s", new Object[] { localObject5 });
            localObject4 = ((t)localObject4).dXo.a((String)localObject5, null, 2);
            if (!((Cursor)localObject4).moveToNext()) {
              break label1149;
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
            l = bk.a((Long)com.tencent.mm.kernel.g.DP().Dz().get(81939, null), 0L);
          }
          catch (Exception localException) {}
        }
        if (bk.UY() - l <= 86400000L) {
          break label1243;
        }
        i = 1;
        if (i != 0) {
          new i();
        }
        l = System.currentTimeMillis();
        au.Hx();
        bool = ((Boolean)c.Dz().get(233475, Boolean.valueOf(false))).booleanValue();
        au.Hx();
        if (c.Fw().cur() > 0) {
          break label1248;
        }
        if (!bool)
        {
          au.Hx();
          c.FB().abu("officialaccounts");
          au.Hx();
          c.Dz().o(233475, Boolean.valueOf(true));
        }
        com.tencent.mm.plugin.webwx.a.g.cgZ().chb().cgX();
        y.i("MicroMsg.PostTaskLightweightJob", "use time %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
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
            ((f.a)localObject4).er(10);
            break label1272;
          }
        }
        else
        {
          localObject2 = localObject5[i].split(",");
          continue;
        }
        ((f.a)localObject4).er(11);
        if ("com.tencent.mm".equals(localObject2[0])) {
          ((f.a)localObject4).er(14);
        }
        if ("com.tencent.mm:push".equals(localObject2[0])) {
          ((f.a)localObject4).er(17);
        }
        if ("com.tencent.mm:tools".equals(localObject2[0])) {
          ((f.a)localObject4).er(20);
        }
        if ("com.tencent.mm:toolsmp".equals(localObject2[0])) {
          ((f.a)localObject4).er(20);
        }
        if (localObject2[1].equals("java"))
        {
          ((f.a)localObject4).er(12);
          if ("com.tencent.mm".equals(localObject2[0])) {
            ((f.a)localObject4).er(15);
          }
          if ("com.tencent.mm:push".equals(localObject2[0])) {
            ((f.a)localObject4).er(18);
          }
          if ("com.tencent.mm:tools".equals(localObject2[0])) {
            ((f.a)localObject4).er(21);
          }
          if ("com.tencent.mm:toolsmp".equals(localObject2[0])) {
            ((f.a)localObject4).er(21);
          }
        }
        if (localObject2[1].equals("jni"))
        {
          ((f.a)localObject4).er(13);
          if ("com.tencent.mm".equals(localObject2[0])) {
            ((f.a)localObject4).er(16);
          }
          if ("com.tencent.mm:push".equals(localObject2[0])) {
            ((f.a)localObject4).er(19);
          }
          if ("com.tencent.mm:tools".equals(localObject2[0])) {
            ((f.a)localObject4).er(22);
          }
          if ("com.tencent.mm:toolsmp".equals(localObject2[0])) {
            ((f.a)localObject4).er(22);
          }
        }
        if (!localObject2[1].equals("first")) {
          break label1272;
        }
        if ("com.tencent.mm".equals(localObject2[0])) {
          ((f.a)localObject4).er(23);
        }
        if ("com.tencent.mm:push".equals(localObject2[0])) {
          ((f.a)localObject4).er(24);
        }
        if ("com.tencent.mm:tools".equals(localObject2[0])) {
          ((f.a)localObject4).er(25);
        }
        if (!"com.tencent.mm:toolsmp".equals(localObject2[0])) {
          break label1272;
        }
        ((f.a)localObject4).er(25);
        break label1272;
      }
      if (j == 3)
      {
        i = 1;
        break label1279;
        label1149:
        ((Cursor)localObject4).close();
        com.tencent.mm.plugin.report.service.h.nFQ.f(12696, new Object[] { Integer.valueOf(10010), Integer.valueOf(localThrowable2[0]), Integer.valueOf(localThrowable2[1]), Integer.valueOf(localThrowable2[2]), Integer.valueOf(localThrowable2[3]), Integer.valueOf(localThrowable2[4]), Integer.valueOf(localThrowable2[5]) });
        continue;
        label1243:
        i = 0;
        continue;
        label1248:
        if (!bool) {
          continue;
        }
        au.Hx();
        c.Dz().o(233475, Boolean.valueOf(false));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.booter.g
 * JD-Core Version:    0.7.0.1
 */