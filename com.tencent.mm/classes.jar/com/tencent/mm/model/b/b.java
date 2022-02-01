package com.tencent.mm.model.b;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class b
{
  private boolean hIN;
  public ArrayList<a> mListeners;
  
  public b()
  {
    AppMethodBeat.i(20401);
    this.mListeners = new ArrayList();
    this.hIN = false;
    AppMethodBeat.o(20401);
  }
  
  private void a(String paramString1, String paramString2, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, String paramString3, String paramString4, long paramLong2, boolean paramBoolean3, boolean paramBoolean4, String paramString5)
  {
    AppMethodBeat.i(20410);
    ba.aBQ();
    c.ajl().set(al.a.IzH, paramString3);
    ba.aBQ();
    c.ajl().set(al.a.IzI, paramString4);
    ba.aBQ();
    c.ajl().set(al.a.IzJ, Long.valueOf(paramLong2));
    ba.aBQ();
    c.ajl().set(al.a.IzK, Boolean.valueOf(paramBoolean3));
    ba.aBQ();
    c.ajl().set(al.a.IzL, Boolean.valueOf(paramBoolean4));
    ba.aBQ();
    c.ajl().set(al.a.IzN, paramString5);
    ba.aBQ();
    c.ajl().set(al.a.IzM, Boolean.FALSE);
    ba.aBQ();
    c.ajl().set(al.a.IzO, paramString1);
    ba.aBQ();
    c.ajl().set(al.a.IzP, paramString2);
    ba.aBQ();
    c.ajl().set(al.a.IzQ, Long.valueOf(paramLong1));
    ba.aBQ();
    c.ajl().set(al.a.IzR, Boolean.valueOf(paramBoolean1));
    ba.aBQ();
    c.ajl().set(al.a.IzS, Boolean.valueOf(paramBoolean2));
    ba.aBQ();
    c.ajl().set(al.a.IzU, Long.valueOf(bt.aQJ()));
    ba.aBQ();
    c.ajl().set(al.a.IzT, Boolean.FALSE);
    ba.aBQ();
    c.ajl().set(al.a.IzV, Boolean.FALSE);
    ba.aBQ();
    c.ajl().fqc();
    aDc();
    AppMethodBeat.o(20410);
  }
  
  public static boolean a(b paramb)
  {
    AppMethodBeat.i(20413);
    ad.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: is checking monitor banner scene: %s", new Object[] { paramb });
    long l2 = bt.aQJ();
    ba.aBQ();
    long l3 = ((Long)c.ajl().get(al.a.IzU, Long.valueOf(-1L))).longValue();
    ba.aBQ();
    String str = (String)c.ajl().get(al.a.IzN, "");
    long l1;
    boolean bool2;
    boolean bool1;
    if (paramb == b.hIP)
    {
      ba.aBQ();
      l1 = ((Long)c.ajl().get(al.a.IzJ, Long.valueOf(0L))).longValue();
      ba.aBQ();
      bool2 = ((Boolean)c.ajl().get(al.a.IzM, Boolean.FALSE)).booleanValue();
      bool1 = aDa();
      paramb = aCX();
    }
    while (!bt.isNullOrNil(str)) {
      if (!str.equals(Build.FINGERPRINT))
      {
        g.yhR.idkeyStat(633L, 5L, 1L, false);
        ad.d("MicroMsg.ChattingMonitoredBannerStorage", "ocr banner: fingerprint [%s] NOT equals current device's [%s] , should NOT show banner", new Object[] { str, Build.FINGERPRINT });
        AppMethodBeat.o(20413);
        return false;
        ba.aBQ();
        l1 = ((Long)c.ajl().get(al.a.IzQ, Long.valueOf(0L))).longValue();
        ba.aBQ();
        bool2 = ((Boolean)c.ajl().get(al.a.IzT, Boolean.FALSE)).booleanValue();
        ba.aBQ();
        bool1 = ((Boolean)c.ajl().get(al.a.IzS, Boolean.FALSE)).booleanValue();
        paramb = aCU();
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
    if ((bool1) && (!aDb()))
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
  
  public static String aCU()
  {
    AppMethodBeat.i(20402);
    ba.aBQ();
    String str = (String)c.ajl().get(al.a.IzO, "");
    AppMethodBeat.o(20402);
    return str;
  }
  
  public static String aCV()
  {
    AppMethodBeat.i(20403);
    ba.aBQ();
    String str = (String)c.ajl().get(al.a.IzP, "");
    AppMethodBeat.o(20403);
    return str;
  }
  
  public static boolean aCW()
  {
    AppMethodBeat.i(20404);
    ba.aBQ();
    boolean bool = ((Boolean)c.ajl().get(al.a.IzR, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(20404);
    return bool;
  }
  
  public static String aCX()
  {
    AppMethodBeat.i(20405);
    ba.aBQ();
    String str = (String)c.ajl().get(al.a.IzH, "");
    AppMethodBeat.o(20405);
    return str;
  }
  
  public static String aCY()
  {
    AppMethodBeat.i(20406);
    ba.aBQ();
    String str = (String)c.ajl().get(al.a.IzI, "");
    AppMethodBeat.o(20406);
    return str;
  }
  
  public static boolean aCZ()
  {
    AppMethodBeat.i(20407);
    ba.aBQ();
    boolean bool = ((Boolean)c.ajl().get(al.a.IzK, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(20407);
    return bool;
  }
  
  private static boolean aDa()
  {
    AppMethodBeat.i(20408);
    ba.aBQ();
    boolean bool = ((Boolean)c.ajl().get(al.a.IzL, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(20408);
    return bool;
  }
  
  private static boolean aDb()
  {
    AppMethodBeat.i(20409);
    ba.aBQ();
    boolean bool = ((Boolean)c.ajl().get(al.a.IzV, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(20409);
    return bool;
  }
  
  private void aDc()
  {
    AppMethodBeat.i(20414);
    try
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).aDe();
      }
    }
    finally
    {
      AppMethodBeat.o(20414);
    }
    AppMethodBeat.o(20414);
  }
  
  private void h(String paramString, Map<String, String> paramMap)
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
  
  public final void aDd()
  {
    AppMethodBeat.i(20415);
    if (aDb() != true)
    {
      ad.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: monitored illegal set text. mark now as the start time ");
      ba.aBQ();
      c.ajl().set(al.a.IzU, Long.valueOf(bt.aQJ()));
      ba.aBQ();
      c.ajl().set(al.a.IzV, Boolean.TRUE);
      aDc();
    }
    AppMethodBeat.o(20415);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(20416);
    if (paramb == b.hIO)
    {
      ba.aBQ();
      c.ajl().set(al.a.IzT, Boolean.FALSE);
    }
    for (;;)
    {
      aDc();
      AppMethodBeat.o(20416);
      return;
      ba.aBQ();
      c.ajl().set(al.a.IzM, Boolean.FALSE);
    }
  }
  
  public final void c(b paramb)
  {
    AppMethodBeat.i(20417);
    if (paramb == b.hIO)
    {
      ba.aBQ();
      c.ajl().set(al.a.IzQ, Long.valueOf(0L));
    }
    for (;;)
    {
      aDc();
      do
      {
        AppMethodBeat.o(20417);
        return;
      } while (paramb != b.hIP);
      if (!aDa())
      {
        ba.aBQ();
        c.ajl().set(al.a.IzJ, Long.valueOf(0L));
      }
      else
      {
        ba.aBQ();
        c.ajl().set(al.a.IzM, Boolean.TRUE);
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
    g.yhR.idkeyStat(633L, 3L, 1L, false);
    ad.d("MicroMsg.ChattingMonitoredBannerStorage", "origin values: ".concat(String.valueOf(paramMap)));
    h(".sysmsg.banner.monitorbanner_n.", paramMap);
    h(".sysmsg.banner.monitorbanner_o.", paramMap);
    AppMethodBeat.o(20411);
  }
  
  public static abstract interface a
  {
    public abstract void aDe();
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(20400);
      hIO = new b("Main", 0);
      hIP = new b("Chatting", 1);
      hIQ = new b[] { hIO, hIP };
      AppMethodBeat.o(20400);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.b.b
 * JD-Core Version:    0.7.0.1
 */