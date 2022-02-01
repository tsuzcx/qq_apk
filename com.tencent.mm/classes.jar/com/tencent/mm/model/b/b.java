package com.tencent.mm.model.b;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class b
{
  private boolean iGI;
  public ArrayList<a> mListeners;
  
  public b()
  {
    AppMethodBeat.i(20401);
    this.mListeners = new ArrayList();
    this.iGI = false;
    AppMethodBeat.o(20401);
  }
  
  private void a(String paramString1, String paramString2, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, String paramString3, String paramString4, long paramLong2, boolean paramBoolean3, boolean paramBoolean4, String paramString5)
  {
    AppMethodBeat.i(20410);
    bg.aVF();
    c.azQ().set(ar.a.Ocu, paramString3);
    bg.aVF();
    c.azQ().set(ar.a.Ocv, paramString4);
    bg.aVF();
    c.azQ().set(ar.a.Ocw, Long.valueOf(paramLong2));
    bg.aVF();
    c.azQ().set(ar.a.Ocx, Boolean.valueOf(paramBoolean3));
    bg.aVF();
    c.azQ().set(ar.a.Ocy, Boolean.valueOf(paramBoolean4));
    bg.aVF();
    c.azQ().set(ar.a.OcA, paramString5);
    bg.aVF();
    c.azQ().set(ar.a.Ocz, Boolean.FALSE);
    bg.aVF();
    c.azQ().set(ar.a.OcB, paramString1);
    bg.aVF();
    c.azQ().set(ar.a.OcC, paramString2);
    bg.aVF();
    c.azQ().set(ar.a.OcD, Long.valueOf(paramLong1));
    bg.aVF();
    c.azQ().set(ar.a.OcE, Boolean.valueOf(paramBoolean1));
    bg.aVF();
    c.azQ().set(ar.a.OcF, Boolean.valueOf(paramBoolean2));
    bg.aVF();
    c.azQ().set(ar.a.OcH, Long.valueOf(Util.nowSecond()));
    bg.aVF();
    c.azQ().set(ar.a.OcG, Boolean.FALSE);
    bg.aVF();
    c.azQ().set(ar.a.OcI, Boolean.FALSE);
    bg.aVF();
    c.azQ().gBI();
    aXe();
    AppMethodBeat.o(20410);
  }
  
  public static boolean a(b paramb)
  {
    AppMethodBeat.i(20413);
    Log.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: is checking monitor banner scene: %s", new Object[] { paramb });
    long l2 = Util.nowSecond();
    bg.aVF();
    long l3 = ((Long)c.azQ().get(ar.a.OcH, Long.valueOf(-1L))).longValue();
    bg.aVF();
    String str = (String)c.azQ().get(ar.a.OcA, "");
    long l1;
    boolean bool2;
    boolean bool1;
    if (paramb == b.iGK)
    {
      bg.aVF();
      l1 = ((Long)c.azQ().get(ar.a.Ocw, Long.valueOf(0L))).longValue();
      bg.aVF();
      bool2 = ((Boolean)c.azQ().get(ar.a.Ocz, Boolean.FALSE)).booleanValue();
      bool1 = aXc();
      paramb = aWZ();
    }
    while (!Util.isNullOrNil(str)) {
      if (!str.equals(Build.FINGERPRINT))
      {
        h.CyF.idkeyStat(633L, 5L, 1L, false);
        Log.d("MicroMsg.ChattingMonitoredBannerStorage", "ocr banner: fingerprint [%s] NOT equals current device's [%s] , should NOT show banner", new Object[] { str, Build.FINGERPRINT });
        AppMethodBeat.o(20413);
        return false;
        bg.aVF();
        l1 = ((Long)c.azQ().get(ar.a.OcD, Long.valueOf(0L))).longValue();
        bg.aVF();
        bool2 = ((Boolean)c.azQ().get(ar.a.OcG, Boolean.FALSE)).booleanValue();
        bg.aVF();
        bool1 = ((Boolean)c.azQ().get(ar.a.OcF, Boolean.FALSE)).booleanValue();
        paramb = aWW();
      }
      else
      {
        Log.d("MicroMsg.ChattingMonitoredBannerStorage", "ocr banner: fingerprint [%s] equals current device's [%s] , should show banner", new Object[] { str, Build.FINGERPRINT });
      }
    }
    if (Util.isNullOrNil(paramb))
    {
      Log.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: not get wording");
      AppMethodBeat.o(20413);
      return false;
    }
    if (bool2)
    {
      Log.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: not check trigger and already closed");
      AppMethodBeat.o(20413);
      return false;
    }
    if (l3 < 0L)
    {
      Log.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: no msg occurs");
      AppMethodBeat.o(20413);
      return false;
    }
    if ((bool1) && (!aXd()))
    {
      Log.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: should check triggered but not triggered");
      AppMethodBeat.o(20413);
      return false;
    }
    if (l1 == -1L)
    {
      Log.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: should always show");
      AppMethodBeat.o(20413);
      return true;
    }
    if (l3 + l1 > l2)
    {
      Log.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: still in show time. show banner");
      AppMethodBeat.o(20413);
      return true;
    }
    Log.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: expired.");
    AppMethodBeat.o(20413);
    return false;
  }
  
  public static String aWW()
  {
    AppMethodBeat.i(20402);
    bg.aVF();
    String str = (String)c.azQ().get(ar.a.OcB, "");
    AppMethodBeat.o(20402);
    return str;
  }
  
  public static String aWX()
  {
    AppMethodBeat.i(20403);
    bg.aVF();
    String str = (String)c.azQ().get(ar.a.OcC, "");
    AppMethodBeat.o(20403);
    return str;
  }
  
  public static boolean aWY()
  {
    AppMethodBeat.i(20404);
    bg.aVF();
    boolean bool = ((Boolean)c.azQ().get(ar.a.OcE, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(20404);
    return bool;
  }
  
  public static String aWZ()
  {
    AppMethodBeat.i(20405);
    bg.aVF();
    String str = (String)c.azQ().get(ar.a.Ocu, "");
    AppMethodBeat.o(20405);
    return str;
  }
  
  public static String aXa()
  {
    AppMethodBeat.i(20406);
    bg.aVF();
    String str = (String)c.azQ().get(ar.a.Ocv, "");
    AppMethodBeat.o(20406);
    return str;
  }
  
  public static boolean aXb()
  {
    AppMethodBeat.i(20407);
    bg.aVF();
    boolean bool = ((Boolean)c.azQ().get(ar.a.Ocx, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(20407);
    return bool;
  }
  
  private static boolean aXc()
  {
    AppMethodBeat.i(20408);
    bg.aVF();
    boolean bool = ((Boolean)c.azQ().get(ar.a.Ocy, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(20408);
    return bool;
  }
  
  private static boolean aXd()
  {
    AppMethodBeat.i(20409);
    bg.aVF();
    boolean bool = ((Boolean)c.azQ().get(ar.a.OcI, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(20409);
    return bool;
  }
  
  private void aXe()
  {
    AppMethodBeat.i(20414);
    try
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).aXg();
      }
    }
    finally
    {
      AppMethodBeat.o(20414);
    }
    AppMethodBeat.o(20414);
  }
  
  private void i(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(20412);
    String str4 = paramString + "chatting.";
    String str1 = Util.nullAsNil((String)paramMap.get(str4 + "fingerprint"));
    if ((str4.equals(".sysmsg.banner.monitorbanner_n.")) && (!Util.isNullOrNil(str1)))
    {
      Log.e("MicroMsg.ChattingMonitoredBannerStorage", "monitorbanner_n must NOT contain fingerprint.");
      AppMethodBeat.o(20412);
      return;
    }
    String str2 = Util.nullAsNil((String)paramMap.get(str4 + "url"));
    String str3 = Util.nullAsNil((String)paramMap.get(str4 + "wording"));
    long l1 = Util.getLong((String)paramMap.get(str4 + "duration"), 0L);
    boolean bool1;
    boolean bool2;
    label284:
    String str5;
    long l2;
    boolean bool3;
    if (Util.getInt((String)paramMap.get(str4 + "autotrigger"), 0) == 1)
    {
      bool1 = true;
      if (Util.getInt((String)paramMap.get(str4 + "closable"), 0) != 1) {
        break label619;
      }
      bool2 = true;
      paramString = paramString + "mainframe.";
      str4 = Util.nullAsNil((String)paramMap.get(paramString + "url"));
      str5 = Util.nullAsNil((String)paramMap.get(paramString + "wording"));
      l2 = Util.getLong((String)paramMap.get(paramString + "duration"), 0L);
      if (Util.getInt((String)paramMap.get(paramString + "autotrigger"), 0) != 1) {
        break label625;
      }
      bool3 = true;
      label448:
      if (Util.getInt((String)paramMap.get(paramString + "closable"), 0) != 1) {
        break label631;
      }
    }
    label619:
    label625:
    label631:
    for (boolean bool4 = true;; bool4 = false)
    {
      if ((!Util.isNullOrNil(str5)) || (!Util.isNullOrNil(str3)))
      {
        Log.d("MicroMsg.ChattingMonitoredBannerStorage", "received msg:\nchattingUrl = " + str2 + "\nchattingWording = " + str3 + "\nchattingDuration = " + l1 + "\nchattingAutotrigger = " + bool1 + "\nchattingCloseable = " + bool2 + "\nfingerPrint = " + str1);
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
  
  public final void C(Map<String, String> paramMap)
  {
    AppMethodBeat.i(20411);
    if (paramMap == null)
    {
      AppMethodBeat.o(20411);
      return;
    }
    h.CyF.idkeyStat(633L, 3L, 1L, false);
    Log.d("MicroMsg.ChattingMonitoredBannerStorage", "origin values: ".concat(String.valueOf(paramMap)));
    i(".sysmsg.banner.monitorbanner_n.", paramMap);
    i(".sysmsg.banner.monitorbanner_o.", paramMap);
    AppMethodBeat.o(20411);
  }
  
  public final void aXf()
  {
    AppMethodBeat.i(20415);
    if (aXd() != true)
    {
      Log.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: monitored illegal set text. mark now as the start time ");
      bg.aVF();
      c.azQ().set(ar.a.OcH, Long.valueOf(Util.nowSecond()));
      bg.aVF();
      c.azQ().set(ar.a.OcI, Boolean.TRUE);
      aXe();
    }
    AppMethodBeat.o(20415);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(20416);
    if (paramb == b.iGJ)
    {
      bg.aVF();
      c.azQ().set(ar.a.OcG, Boolean.FALSE);
    }
    for (;;)
    {
      aXe();
      AppMethodBeat.o(20416);
      return;
      bg.aVF();
      c.azQ().set(ar.a.Ocz, Boolean.FALSE);
    }
  }
  
  public final void c(b paramb)
  {
    AppMethodBeat.i(20417);
    if (paramb == b.iGJ)
    {
      bg.aVF();
      c.azQ().set(ar.a.OcD, Long.valueOf(0L));
    }
    for (;;)
    {
      aXe();
      do
      {
        AppMethodBeat.o(20417);
        return;
      } while (paramb != b.iGK);
      if (!aXc())
      {
        bg.aVF();
        c.azQ().set(ar.a.Ocw, Long.valueOf(0L));
      }
      else
      {
        bg.aVF();
        c.azQ().set(ar.a.Ocz, Boolean.TRUE);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void aXg();
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(20400);
      iGJ = new b("Main", 0);
      iGK = new b("Chatting", 1);
      iGL = new b[] { iGJ, iGK };
      AppMethodBeat.o(20400);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.b.b
 * JD-Core Version:    0.7.0.1
 */