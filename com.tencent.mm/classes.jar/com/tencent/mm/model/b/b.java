package com.tencent.mm.model.b;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class b
{
  private boolean dYp = false;
  public ArrayList<b.a> mListeners = new ArrayList();
  
  public static String IB()
  {
    au.Hx();
    return (String)c.Dz().get(ac.a.uwN, "");
  }
  
  public static String IC()
  {
    au.Hx();
    return (String)c.Dz().get(ac.a.uwO, "");
  }
  
  public static boolean ID()
  {
    au.Hx();
    return ((Boolean)c.Dz().get(ac.a.uwQ, Boolean.valueOf(false))).booleanValue();
  }
  
  public static String IE()
  {
    au.Hx();
    return (String)c.Dz().get(ac.a.uwH, "");
  }
  
  public static String IF()
  {
    au.Hx();
    return (String)c.Dz().get(ac.a.uwI, "");
  }
  
  public static boolean IG()
  {
    au.Hx();
    return ((Boolean)c.Dz().get(ac.a.uwK, Boolean.valueOf(false))).booleanValue();
  }
  
  private static boolean IH()
  {
    au.Hx();
    return ((Boolean)c.Dz().get(ac.a.uwL, Boolean.valueOf(false))).booleanValue();
  }
  
  private static boolean II()
  {
    au.Hx();
    return ((Boolean)c.Dz().get(ac.a.uwU, Boolean.valueOf(false))).booleanValue();
  }
  
  private void IJ()
  {
    try
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        ((b.a)localIterator.next()).IL();
      }
    }
    finally {}
  }
  
  public static boolean a(b.b paramb)
  {
    y.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: is checking monitor banner scene: %s", new Object[] { paramb });
    long l2 = bk.UX();
    au.Hx();
    long l3 = ((Long)c.Dz().get(ac.a.uwT, Long.valueOf(-1L))).longValue();
    long l1;
    boolean bool2;
    boolean bool1;
    if (paramb == b.b.dYr)
    {
      au.Hx();
      l1 = ((Long)c.Dz().get(ac.a.uwJ, Long.valueOf(0L))).longValue();
      au.Hx();
      bool2 = ((Boolean)c.Dz().get(ac.a.uwM, Boolean.valueOf(false))).booleanValue();
      bool1 = IH();
    }
    for (paramb = IE(); bk.bl(paramb); paramb = IB())
    {
      y.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: not get wording");
      return false;
      au.Hx();
      l1 = ((Long)c.Dz().get(ac.a.uwP, Long.valueOf(0L))).longValue();
      au.Hx();
      bool2 = ((Boolean)c.Dz().get(ac.a.uwS, Boolean.valueOf(false))).booleanValue();
      au.Hx();
      bool1 = ((Boolean)c.Dz().get(ac.a.uwR, Boolean.valueOf(false))).booleanValue();
    }
    if (bool2)
    {
      y.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: not check trigger and already closed");
      return false;
    }
    if (l3 < 0L)
    {
      y.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: no msg occurs");
      return false;
    }
    if ((bool1) && (!II()))
    {
      y.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: should check triggered but not triggered");
      return false;
    }
    if (l1 == -1L)
    {
      y.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: should always show");
      return true;
    }
    if (l3 + l1 > l2)
    {
      y.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: still in show time. show banner");
      return true;
    }
    y.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: expired.");
    return false;
  }
  
  public final void IK()
  {
    if (II() != true)
    {
      y.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: monitored illegal set text. mark now as the start time ");
      au.Hx();
      c.Dz().c(ac.a.uwT, Long.valueOf(bk.UX()));
      au.Hx();
      c.Dz().c(ac.a.uwU, Boolean.valueOf(true));
      IJ();
    }
  }
  
  public final void b(b.b paramb)
  {
    if (paramb == b.b.dYq)
    {
      au.Hx();
      c.Dz().c(ac.a.uwS, Boolean.valueOf(false));
    }
    for (;;)
    {
      IJ();
      return;
      au.Hx();
      c.Dz().c(ac.a.uwM, Boolean.valueOf(false));
    }
  }
  
  public final void c(b.b paramb)
  {
    if (paramb == b.b.dYq)
    {
      au.Hx();
      c.Dz().c(ac.a.uwP, Long.valueOf(0L));
    }
    for (;;)
    {
      IJ();
      do
      {
        return;
      } while (paramb != b.b.dYr);
      if (!IH())
      {
        au.Hx();
        c.Dz().c(ac.a.uwJ, Long.valueOf(0L));
      }
      else
      {
        au.Hx();
        c.Dz().c(ac.a.uwM, Boolean.valueOf(true));
      }
    }
  }
  
  public final void k(Map<String, String> paramMap)
  {
    if (paramMap == null) {}
    label111:
    label497:
    for (;;)
    {
      return;
      h.nFQ.a(633L, 3L, 1L, false);
      String str1 = bk.pm((String)paramMap.get(".sysmsg.banner.monitorbanner_n.mainframe.url"));
      String str2 = bk.pm((String)paramMap.get(".sysmsg.banner.monitorbanner_n.mainframe.wording"));
      long l1 = bk.getLong((String)paramMap.get(".sysmsg.banner.monitorbanner_n.mainframe.duration"), 0L);
      boolean bool1;
      boolean bool2;
      String str3;
      String str4;
      long l2;
      boolean bool3;
      if (bk.getInt((String)paramMap.get(".sysmsg.banner.monitorbanner_n.mainframe.autotrigger"), 0) == 1)
      {
        bool1 = true;
        if (bk.getInt((String)paramMap.get(".sysmsg.banner.monitorbanner_n.mainframe.closable"), 0) != 1) {
          break label481;
        }
        bool2 = true;
        str3 = bk.pm((String)paramMap.get(".sysmsg.banner.monitorbanner_n.chatting.url"));
        str4 = bk.pm((String)paramMap.get(".sysmsg.banner.monitorbanner_n.chatting.wording"));
        l2 = bk.getLong((String)paramMap.get(".sysmsg.banner.monitorbanner_n.chatting.duration"), 0L);
        if (bk.getInt((String)paramMap.get(".sysmsg.banner.monitorbanner_n.chatting.autotrigger"), 0) != 1) {
          break label487;
        }
        bool3 = true;
        if (bk.getInt((String)paramMap.get(".sysmsg.banner.monitorbanner_n.chatting.closable"), 0) != 1) {
          break label493;
        }
      }
      for (boolean bool4 = true;; bool4 = false)
      {
        if ((bk.bl(str2)) && (bk.bl(str4))) {
          break label497;
        }
        au.Hx();
        c.Dz().c(ac.a.uwH, str4);
        au.Hx();
        c.Dz().c(ac.a.uwI, str3);
        au.Hx();
        c.Dz().c(ac.a.uwJ, Long.valueOf(l2));
        au.Hx();
        c.Dz().c(ac.a.uwK, Boolean.valueOf(bool4));
        au.Hx();
        c.Dz().c(ac.a.uwL, Boolean.valueOf(bool3));
        au.Hx();
        c.Dz().c(ac.a.uwN, str2);
        au.Hx();
        c.Dz().c(ac.a.uwO, str1);
        au.Hx();
        c.Dz().c(ac.a.uwP, Long.valueOf(l1));
        au.Hx();
        c.Dz().c(ac.a.uwQ, Boolean.valueOf(bool2));
        au.Hx();
        c.Dz().c(ac.a.uwR, Boolean.valueOf(bool1));
        au.Hx();
        c.Dz().c(ac.a.uwT, Long.valueOf(bk.UX()));
        au.Hx();
        c.Dz().c(ac.a.uwM, Boolean.valueOf(false));
        au.Hx();
        c.Dz().c(ac.a.uwS, Boolean.valueOf(false));
        au.Hx();
        c.Dz().c(ac.a.uwU, Boolean.valueOf(false));
        au.Hx();
        c.Dz().mC(true);
        IJ();
        return;
        bool1 = false;
        break;
        bool2 = false;
        break label111;
        bool3 = false;
        break label183;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.model.b.b
 * JD-Core Version:    0.7.0.1
 */