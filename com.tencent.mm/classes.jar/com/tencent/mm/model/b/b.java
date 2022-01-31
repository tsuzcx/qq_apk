package com.tencent.mm.model.b;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class b
{
  private boolean fot;
  public ArrayList<b.a> mListeners;
  
  public b()
  {
    AppMethodBeat.i(16355);
    this.mListeners = new ArrayList();
    this.fot = false;
    AppMethodBeat.o(16355);
  }
  
  private void a(String paramString1, String paramString2, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, String paramString3, String paramString4, long paramLong2, boolean paramBoolean3, boolean paramBoolean4, String paramString5)
  {
    AppMethodBeat.i(16364);
    aw.aaz();
    c.Ru().set(ac.a.yGP, paramString3);
    aw.aaz();
    c.Ru().set(ac.a.yGQ, paramString4);
    aw.aaz();
    c.Ru().set(ac.a.yGR, Long.valueOf(paramLong2));
    aw.aaz();
    c.Ru().set(ac.a.yGS, Boolean.valueOf(paramBoolean3));
    aw.aaz();
    c.Ru().set(ac.a.yGT, Boolean.valueOf(paramBoolean4));
    aw.aaz();
    c.Ru().set(ac.a.yGV, paramString5);
    aw.aaz();
    c.Ru().set(ac.a.yGU, Boolean.FALSE);
    aw.aaz();
    c.Ru().set(ac.a.yGW, paramString1);
    aw.aaz();
    c.Ru().set(ac.a.yGX, paramString2);
    aw.aaz();
    c.Ru().set(ac.a.yGY, Long.valueOf(paramLong1));
    aw.aaz();
    c.Ru().set(ac.a.yGZ, Boolean.valueOf(paramBoolean1));
    aw.aaz();
    c.Ru().set(ac.a.yHa, Boolean.valueOf(paramBoolean2));
    aw.aaz();
    c.Ru().set(ac.a.yHc, Long.valueOf(bo.aox()));
    aw.aaz();
    c.Ru().set(ac.a.yHb, Boolean.FALSE);
    aw.aaz();
    c.Ru().set(ac.a.yHd, Boolean.FALSE);
    aw.aaz();
    c.Ru().dww();
    abG();
    AppMethodBeat.o(16364);
  }
  
  public static boolean a(b.b paramb)
  {
    AppMethodBeat.i(16367);
    ab.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: is checking monitor banner scene: %s", new Object[] { paramb });
    long l2 = bo.aox();
    aw.aaz();
    long l3 = ((Long)c.Ru().get(ac.a.yHc, Long.valueOf(-1L))).longValue();
    aw.aaz();
    String str = (String)c.Ru().get(ac.a.yGV, "");
    long l1;
    boolean bool2;
    boolean bool1;
    if (paramb == b.b.fow)
    {
      aw.aaz();
      l1 = ((Long)c.Ru().get(ac.a.yGR, Long.valueOf(0L))).longValue();
      aw.aaz();
      bool2 = ((Boolean)c.Ru().get(ac.a.yGU, Boolean.FALSE)).booleanValue();
      bool1 = abF();
      paramb = abC();
    }
    while (!bo.isNullOrNil(str)) {
      if (!str.equals(Build.FINGERPRINT))
      {
        h.qsU.idkeyStat(633L, 5L, 1L, false);
        ab.d("MicroMsg.ChattingMonitoredBannerStorage", "ocr banner: fingerprint [%s] NOT equals current device's [%s] , should NOT show banner", new Object[] { str, Build.FINGERPRINT });
        AppMethodBeat.o(16367);
        return false;
        aw.aaz();
        l1 = ((Long)c.Ru().get(ac.a.yGY, Long.valueOf(0L))).longValue();
        aw.aaz();
        bool2 = ((Boolean)c.Ru().get(ac.a.yHb, Boolean.FALSE)).booleanValue();
        aw.aaz();
        bool1 = ((Boolean)c.Ru().get(ac.a.yHa, Boolean.FALSE)).booleanValue();
        paramb = abz();
      }
      else
      {
        ab.d("MicroMsg.ChattingMonitoredBannerStorage", "ocr banner: fingerprint [%s] equals current device's [%s] , should show banner", new Object[] { str, Build.FINGERPRINT });
      }
    }
    if (bo.isNullOrNil(paramb))
    {
      ab.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: not get wording");
      AppMethodBeat.o(16367);
      return false;
    }
    if (bool2)
    {
      ab.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: not check trigger and already closed");
      AppMethodBeat.o(16367);
      return false;
    }
    if (l3 < 0L)
    {
      ab.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: no msg occurs");
      AppMethodBeat.o(16367);
      return false;
    }
    if ((bool1) && (!isTriggered()))
    {
      ab.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: should check triggered but not triggered");
      AppMethodBeat.o(16367);
      return false;
    }
    if (l1 == -1L)
    {
      ab.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: should always show");
      AppMethodBeat.o(16367);
      return true;
    }
    if (l3 + l1 > l2)
    {
      ab.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: still in show time. show banner");
      AppMethodBeat.o(16367);
      return true;
    }
    ab.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: expired.");
    AppMethodBeat.o(16367);
    return false;
  }
  
  public static String abA()
  {
    AppMethodBeat.i(16357);
    aw.aaz();
    String str = (String)c.Ru().get(ac.a.yGX, "");
    AppMethodBeat.o(16357);
    return str;
  }
  
  public static boolean abB()
  {
    AppMethodBeat.i(16358);
    aw.aaz();
    boolean bool = ((Boolean)c.Ru().get(ac.a.yGZ, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(16358);
    return bool;
  }
  
  public static String abC()
  {
    AppMethodBeat.i(16359);
    aw.aaz();
    String str = (String)c.Ru().get(ac.a.yGP, "");
    AppMethodBeat.o(16359);
    return str;
  }
  
  public static String abD()
  {
    AppMethodBeat.i(16360);
    aw.aaz();
    String str = (String)c.Ru().get(ac.a.yGQ, "");
    AppMethodBeat.o(16360);
    return str;
  }
  
  public static boolean abE()
  {
    AppMethodBeat.i(16361);
    aw.aaz();
    boolean bool = ((Boolean)c.Ru().get(ac.a.yGS, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(16361);
    return bool;
  }
  
  private static boolean abF()
  {
    AppMethodBeat.i(16362);
    aw.aaz();
    boolean bool = ((Boolean)c.Ru().get(ac.a.yGT, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(16362);
    return bool;
  }
  
  private void abG()
  {
    AppMethodBeat.i(16368);
    try
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        ((b.a)localIterator.next()).abI();
      }
    }
    finally
    {
      AppMethodBeat.o(16368);
    }
    AppMethodBeat.o(16368);
  }
  
  public static String abz()
  {
    AppMethodBeat.i(16356);
    aw.aaz();
    String str = (String)c.Ru().get(ac.a.yGW, "");
    AppMethodBeat.o(16356);
    return str;
  }
  
  private void h(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(16366);
    String str4 = paramString + "chatting.";
    String str1 = bo.nullAsNil((String)paramMap.get(str4 + "fingerprint"));
    if ((str4.equals(".sysmsg.banner.monitorbanner_n.")) && (!bo.isNullOrNil(str1)))
    {
      ab.e("MicroMsg.ChattingMonitoredBannerStorage", "monitorbanner_n must NOT contain fingerprint.");
      AppMethodBeat.o(16366);
      return;
    }
    String str2 = bo.nullAsNil((String)paramMap.get(str4 + "url"));
    String str3 = bo.nullAsNil((String)paramMap.get(str4 + "wording"));
    long l1 = bo.getLong((String)paramMap.get(str4 + "duration"), 0L);
    boolean bool1;
    boolean bool2;
    label284:
    String str5;
    long l2;
    boolean bool3;
    if (bo.getInt((String)paramMap.get(str4 + "autotrigger"), 0) == 1)
    {
      bool1 = true;
      if (bo.getInt((String)paramMap.get(str4 + "closable"), 0) != 1) {
        break label619;
      }
      bool2 = true;
      paramString = paramString + "mainframe.";
      str4 = bo.nullAsNil((String)paramMap.get(paramString + "url"));
      str5 = bo.nullAsNil((String)paramMap.get(paramString + "wording"));
      l2 = bo.getLong((String)paramMap.get(paramString + "duration"), 0L);
      if (bo.getInt((String)paramMap.get(paramString + "autotrigger"), 0) != 1) {
        break label625;
      }
      bool3 = true;
      label448:
      if (bo.getInt((String)paramMap.get(paramString + "closable"), 0) != 1) {
        break label631;
      }
    }
    label619:
    label625:
    label631:
    for (boolean bool4 = true;; bool4 = false)
    {
      if ((!bo.isNullOrNil(str5)) || (!bo.isNullOrNil(str3)))
      {
        ab.d("MicroMsg.ChattingMonitoredBannerStorage", "received msg:\nchattingUrl = " + str2 + "\nchattingWording = " + str3 + "\nchattingDuration = " + l1 + "\nchattingAutotrigger = " + bool1 + "\nchattingCloseable = " + bool2 + "\nfingerPrint = " + str1);
        a(str5, str4, l2, bool4, bool3, str3, str2, l1, bool2, bool1, str1);
      }
      AppMethodBeat.o(16366);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label284;
      bool3 = false;
      break label448;
    }
  }
  
  private static boolean isTriggered()
  {
    AppMethodBeat.i(16363);
    aw.aaz();
    boolean bool = ((Boolean)c.Ru().get(ac.a.yHd, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(16363);
    return bool;
  }
  
  public final void abH()
  {
    AppMethodBeat.i(16369);
    if (isTriggered() != true)
    {
      ab.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: monitored illegal set text. mark now as the start time ");
      aw.aaz();
      c.Ru().set(ac.a.yHc, Long.valueOf(bo.aox()));
      aw.aaz();
      c.Ru().set(ac.a.yHd, Boolean.TRUE);
      abG();
    }
    AppMethodBeat.o(16369);
  }
  
  public final void b(b.b paramb)
  {
    AppMethodBeat.i(16370);
    if (paramb == b.b.fou)
    {
      aw.aaz();
      c.Ru().set(ac.a.yHb, Boolean.FALSE);
    }
    for (;;)
    {
      abG();
      AppMethodBeat.o(16370);
      return;
      aw.aaz();
      c.Ru().set(ac.a.yGU, Boolean.FALSE);
    }
  }
  
  public final void c(b.b paramb)
  {
    AppMethodBeat.i(16371);
    if (paramb == b.b.fou)
    {
      aw.aaz();
      c.Ru().set(ac.a.yGY, Long.valueOf(0L));
    }
    for (;;)
    {
      abG();
      do
      {
        AppMethodBeat.o(16371);
        return;
      } while (paramb != b.b.fow);
      if (!abF())
      {
        aw.aaz();
        c.Ru().set(ac.a.yGR, Long.valueOf(0L));
      }
      else
      {
        aw.aaz();
        c.Ru().set(ac.a.yGU, Boolean.TRUE);
      }
    }
  }
  
  public final void o(Map<String, String> paramMap)
  {
    AppMethodBeat.i(16365);
    if (paramMap == null)
    {
      AppMethodBeat.o(16365);
      return;
    }
    h.qsU.idkeyStat(633L, 3L, 1L, false);
    ab.d("MicroMsg.ChattingMonitoredBannerStorage", "origin values: ".concat(String.valueOf(paramMap)));
    h(".sysmsg.banner.monitorbanner_n.", paramMap);
    h(".sysmsg.banner.monitorbanner_o.", paramMap);
    AppMethodBeat.o(16365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.model.b.b
 * JD-Core Version:    0.7.0.1
 */