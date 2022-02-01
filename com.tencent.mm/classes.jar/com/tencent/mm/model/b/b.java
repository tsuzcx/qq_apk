package com.tencent.mm.model.b;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class b
{
  private boolean gPV;
  public ArrayList<a> mListeners;
  
  public b()
  {
    AppMethodBeat.i(20401);
    this.mListeners = new ArrayList();
    this.gPV = false;
    AppMethodBeat.o(20401);
  }
  
  private void a(String paramString1, String paramString2, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, String paramString3, String paramString4, long paramLong2, boolean paramBoolean3, boolean paramBoolean4, String paramString5)
  {
    AppMethodBeat.i(20410);
    az.arV();
    c.afk().set(ae.a.FpA, paramString3);
    az.arV();
    c.afk().set(ae.a.FpB, paramString4);
    az.arV();
    c.afk().set(ae.a.FpC, Long.valueOf(paramLong2));
    az.arV();
    c.afk().set(ae.a.FpD, Boolean.valueOf(paramBoolean3));
    az.arV();
    c.afk().set(ae.a.FpE, Boolean.valueOf(paramBoolean4));
    az.arV();
    c.afk().set(ae.a.FpG, paramString5);
    az.arV();
    c.afk().set(ae.a.FpF, Boolean.FALSE);
    az.arV();
    c.afk().set(ae.a.FpH, paramString1);
    az.arV();
    c.afk().set(ae.a.FpI, paramString2);
    az.arV();
    c.afk().set(ae.a.FpJ, Long.valueOf(paramLong1));
    az.arV();
    c.afk().set(ae.a.FpK, Boolean.valueOf(paramBoolean1));
    az.arV();
    c.afk().set(ae.a.FpL, Boolean.valueOf(paramBoolean2));
    az.arV();
    c.afk().set(ae.a.FpN, Long.valueOf(bt.aGK()));
    az.arV();
    c.afk().set(ae.a.FpM, Boolean.FALSE);
    az.arV();
    c.afk().set(ae.a.FpO, Boolean.FALSE);
    az.arV();
    c.afk().eKy();
    ati();
    AppMethodBeat.o(20410);
  }
  
  public static boolean a(b paramb)
  {
    AppMethodBeat.i(20413);
    ad.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: is checking monitor banner scene: %s", new Object[] { paramb });
    long l2 = bt.aGK();
    az.arV();
    long l3 = ((Long)c.afk().get(ae.a.FpN, Long.valueOf(-1L))).longValue();
    az.arV();
    String str = (String)c.afk().get(ae.a.FpG, "");
    long l1;
    boolean bool2;
    boolean bool1;
    if (paramb == b.gPX)
    {
      az.arV();
      l1 = ((Long)c.afk().get(ae.a.FpC, Long.valueOf(0L))).longValue();
      az.arV();
      bool2 = ((Boolean)c.afk().get(ae.a.FpF, Boolean.FALSE)).booleanValue();
      bool1 = atg();
      paramb = atd();
    }
    while (!bt.isNullOrNil(str)) {
      if (!str.equals(Build.FINGERPRINT))
      {
        h.vKh.idkeyStat(633L, 5L, 1L, false);
        ad.d("MicroMsg.ChattingMonitoredBannerStorage", "ocr banner: fingerprint [%s] NOT equals current device's [%s] , should NOT show banner", new Object[] { str, Build.FINGERPRINT });
        AppMethodBeat.o(20413);
        return false;
        az.arV();
        l1 = ((Long)c.afk().get(ae.a.FpJ, Long.valueOf(0L))).longValue();
        az.arV();
        bool2 = ((Boolean)c.afk().get(ae.a.FpM, Boolean.FALSE)).booleanValue();
        az.arV();
        bool1 = ((Boolean)c.afk().get(ae.a.FpL, Boolean.FALSE)).booleanValue();
        paramb = ata();
      }
      else
      {
        ad.d("MicroMsg.ChattingMonitoredBannerStorage", "ocr banner: fingerprint [%s] equals current device's [%s] , should show banner", new Object[] { str, Build.FINGERPRINT });
      }
    }
    if (bt.isNullOrNil(paramb))
    {
      ad.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: not get wording");
      AppMethodBeat.o(20413);
      return false;
    }
    if (bool2)
    {
      ad.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: not check trigger and already closed");
      AppMethodBeat.o(20413);
      return false;
    }
    if (l3 < 0L)
    {
      ad.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: no msg occurs");
      AppMethodBeat.o(20413);
      return false;
    }
    if ((bool1) && (!ath()))
    {
      ad.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: should check triggered but not triggered");
      AppMethodBeat.o(20413);
      return false;
    }
    if (l1 == -1L)
    {
      ad.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: should always show");
      AppMethodBeat.o(20413);
      return true;
    }
    if (l3 + l1 > l2)
    {
      ad.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: still in show time. show banner");
      AppMethodBeat.o(20413);
      return true;
    }
    ad.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: expired.");
    AppMethodBeat.o(20413);
    return false;
  }
  
  public static String ata()
  {
    AppMethodBeat.i(20402);
    az.arV();
    String str = (String)c.afk().get(ae.a.FpH, "");
    AppMethodBeat.o(20402);
    return str;
  }
  
  public static String atb()
  {
    AppMethodBeat.i(20403);
    az.arV();
    String str = (String)c.afk().get(ae.a.FpI, "");
    AppMethodBeat.o(20403);
    return str;
  }
  
  public static boolean atc()
  {
    AppMethodBeat.i(20404);
    az.arV();
    boolean bool = ((Boolean)c.afk().get(ae.a.FpK, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(20404);
    return bool;
  }
  
  public static String atd()
  {
    AppMethodBeat.i(20405);
    az.arV();
    String str = (String)c.afk().get(ae.a.FpA, "");
    AppMethodBeat.o(20405);
    return str;
  }
  
  public static String ate()
  {
    AppMethodBeat.i(20406);
    az.arV();
    String str = (String)c.afk().get(ae.a.FpB, "");
    AppMethodBeat.o(20406);
    return str;
  }
  
  public static boolean atf()
  {
    AppMethodBeat.i(20407);
    az.arV();
    boolean bool = ((Boolean)c.afk().get(ae.a.FpD, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(20407);
    return bool;
  }
  
  private static boolean atg()
  {
    AppMethodBeat.i(20408);
    az.arV();
    boolean bool = ((Boolean)c.afk().get(ae.a.FpE, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(20408);
    return bool;
  }
  
  private static boolean ath()
  {
    AppMethodBeat.i(20409);
    az.arV();
    boolean bool = ((Boolean)c.afk().get(ae.a.FpO, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(20409);
    return bool;
  }
  
  private void ati()
  {
    AppMethodBeat.i(20414);
    try
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).atk();
      }
    }
    finally
    {
      AppMethodBeat.o(20414);
    }
    AppMethodBeat.o(20414);
  }
  
  private void g(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(20412);
    String str4 = paramString + "chatting.";
    String str1 = bt.nullAsNil((String)paramMap.get(str4 + "fingerprint"));
    if ((str4.equals(".sysmsg.banner.monitorbanner_n.")) && (!bt.isNullOrNil(str1)))
    {
      ad.e("MicroMsg.ChattingMonitoredBannerStorage", "monitorbanner_n must NOT contain fingerprint.");
      AppMethodBeat.o(20412);
      return;
    }
    String str2 = bt.nullAsNil((String)paramMap.get(str4 + "url"));
    String str3 = bt.nullAsNil((String)paramMap.get(str4 + "wording"));
    long l1 = bt.getLong((String)paramMap.get(str4 + "duration"), 0L);
    boolean bool1;
    boolean bool2;
    label284:
    String str5;
    long l2;
    boolean bool3;
    if (bt.getInt((String)paramMap.get(str4 + "autotrigger"), 0) == 1)
    {
      bool1 = true;
      if (bt.getInt((String)paramMap.get(str4 + "closable"), 0) != 1) {
        break label619;
      }
      bool2 = true;
      paramString = paramString + "mainframe.";
      str4 = bt.nullAsNil((String)paramMap.get(paramString + "url"));
      str5 = bt.nullAsNil((String)paramMap.get(paramString + "wording"));
      l2 = bt.getLong((String)paramMap.get(paramString + "duration"), 0L);
      if (bt.getInt((String)paramMap.get(paramString + "autotrigger"), 0) != 1) {
        break label625;
      }
      bool3 = true;
      label448:
      if (bt.getInt((String)paramMap.get(paramString + "closable"), 0) != 1) {
        break label631;
      }
    }
    label619:
    label625:
    label631:
    for (boolean bool4 = true;; bool4 = false)
    {
      if ((!bt.isNullOrNil(str5)) || (!bt.isNullOrNil(str3)))
      {
        ad.d("MicroMsg.ChattingMonitoredBannerStorage", "received msg:\nchattingUrl = " + str2 + "\nchattingWording = " + str3 + "\nchattingDuration = " + l1 + "\nchattingAutotrigger = " + bool1 + "\nchattingCloseable = " + bool2 + "\nfingerPrint = " + str1);
        a(str5, str4, l2, bool4, bool3, str3, str2, l1, bool2, bool1, str1);
      }
      AppMethodBeat.o(20412);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label284;
      bool3 = false;
      break label448;
    }
  }
  
  public final void atj()
  {
    AppMethodBeat.i(20415);
    if (ath() != true)
    {
      ad.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: monitored illegal set text. mark now as the start time ");
      az.arV();
      c.afk().set(ae.a.FpN, Long.valueOf(bt.aGK()));
      az.arV();
      c.afk().set(ae.a.FpO, Boolean.TRUE);
      ati();
    }
    AppMethodBeat.o(20415);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(20416);
    if (paramb == b.gPW)
    {
      az.arV();
      c.afk().set(ae.a.FpM, Boolean.FALSE);
    }
    for (;;)
    {
      ati();
      AppMethodBeat.o(20416);
      return;
      az.arV();
      c.afk().set(ae.a.FpF, Boolean.FALSE);
    }
  }
  
  public final void c(b paramb)
  {
    AppMethodBeat.i(20417);
    if (paramb == b.gPW)
    {
      az.arV();
      c.afk().set(ae.a.FpJ, Long.valueOf(0L));
    }
    for (;;)
    {
      ati();
      do
      {
        AppMethodBeat.o(20417);
        return;
      } while (paramb != b.gPX);
      if (!atg())
      {
        az.arV();
        c.afk().set(ae.a.FpC, Long.valueOf(0L));
      }
      else
      {
        az.arV();
        c.afk().set(ae.a.FpF, Boolean.TRUE);
      }
    }
  }
  
  public final void t(Map<String, String> paramMap)
  {
    AppMethodBeat.i(20411);
    if (paramMap == null)
    {
      AppMethodBeat.o(20411);
      return;
    }
    h.vKh.idkeyStat(633L, 3L, 1L, false);
    ad.d("MicroMsg.ChattingMonitoredBannerStorage", "origin values: ".concat(String.valueOf(paramMap)));
    g(".sysmsg.banner.monitorbanner_n.", paramMap);
    g(".sysmsg.banner.monitorbanner_o.", paramMap);
    AppMethodBeat.o(20411);
  }
  
  public static abstract interface a
  {
    public abstract void atk();
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(20400);
      gPW = new b("Main", 0);
      gPX = new b("Chatting", 1);
      gPY = new b[] { gPW, gPX };
      AppMethodBeat.o(20400);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.b.b
 * JD-Core Version:    0.7.0.1
 */