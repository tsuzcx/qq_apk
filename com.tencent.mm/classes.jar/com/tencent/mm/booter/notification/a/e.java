package com.tencent.mm.booter.notification.a;

import android.content.Context;
import android.media.AudioManager;
import android.text.format.Time;
import com.tencent.mm.h.a.td;
import com.tencent.mm.h.a.td.b;
import com.tencent.mm.m.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.HashSet;
import java.util.Set;

public final class e
{
  private static final Set<String> djV;
  public boolean djW;
  
  static
  {
    HashSet localHashSet = new HashSet();
    djV = localHashSet;
    localHashSet.add("readerapp");
    djV.add("blogapp");
    djV.add("newsapp");
  }
  
  public static boolean a(String paramString, bi parambi)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((f.fo(paramString)) && (!f.e(parambi)))
    {
      bool1 = true;
      if (bool1) {
        break label47;
      }
    }
    for (;;)
    {
      y.i("MicroMsg.Notification.Silent.Handle", "check is NOT Must Mute: %B", new Object[] { Boolean.valueOf(bool2) });
      return bool1;
      bool1 = false;
      break;
      label47:
      bool2 = false;
    }
  }
  
  public static boolean a(boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      paramArrayOfBoolean[0] &= paramBoolean;
      paramArrayOfBoolean[1] &= paramBoolean;
      return bool;
    }
  }
  
  public static boolean a(boolean[] paramArrayOfBoolean, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (!paramBoolean2)) {}
    for (boolean bool = true;; bool = false)
    {
      paramArrayOfBoolean[0] &= paramBoolean1;
      paramArrayOfBoolean[1] &= paramBoolean2;
      return bool;
    }
  }
  
  public static boolean eB(String paramString)
  {
    if (ag.Zo("keep_chatting_silent" + paramString))
    {
      y.i("MicroMsg.Notification.Silent.Handle", "check is Sound NOT Lock: FALSE");
      return true;
    }
    y.i("MicroMsg.Notification.Silent.Handle", "check is Sound NOT Lock: TRUE");
    return false;
  }
  
  public static boolean eC(String paramString)
  {
    boolean bool1 = true;
    boolean bool2 = djV.contains(paramString);
    if (!bool2) {}
    for (;;)
    {
      y.i("MicroMsg.Notification.Silent.Handle", "check is NOT Siler User: %B", new Object[] { Boolean.valueOf(bool1) });
      return bool2;
      bool1 = false;
    }
  }
  
  public static boolean ga(int paramInt)
  {
    if ((paramInt & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.Notification.Silent.Handle", "check is Service Request Sound: %B", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  public static boolean gb(int paramInt)
  {
    if ((paramInt & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.Notification.Silent.Handle", "check is Service Request Shake: %B", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  public static boolean l(int paramInt, String paramString)
  {
    boolean bool;
    if (f.gK(paramInt)) {
      if (f.fj(paramString)) {
        bool = f.Ay();
      }
    }
    for (;;)
    {
      y.i("MicroMsg.Notification.Silent.Handle", "check is Voip Need Sound: %B", new Object[] { Boolean.valueOf(bool) });
      return bool;
      if (f.fk(paramString)) {
        bool = f.Az();
      } else {
        bool = true;
      }
    }
  }
  
  public static boolean wE()
  {
    Time localTime = new Time();
    localTime.setToNow();
    if (!com.tencent.mm.m.a.aY(localTime.hour, localTime.minute))
    {
      y.w("MicroMsg.Notification.Silent.Handle", "no shake & sound notification during background deactive time");
      return true;
    }
    return false;
  }
  
  public static boolean wF()
  {
    boolean bool = f.zT();
    y.i("MicroMsg.Notification.Silent.Handle", "check is Sound Mode: %B", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public static boolean wG()
  {
    boolean bool2 = true;
    try
    {
      td localtd = new td();
      localtd.ccJ.bNb = 2;
      com.tencent.mm.sdk.b.a.udP.m(localtd);
      bool1 = localtd.ccK.ccL;
      if (!bool1)
      {
        y.d("MicroMsg.Notification.Silent.Handle", "check is Voip NOT Calling: %B", new Object[] { Boolean.valueOf(bool2) });
        return bool1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.Notification.Silent.Handle", localException, "", new Object[0]);
        boolean bool1 = false;
        continue;
        bool2 = false;
      }
    }
  }
  
  public static boolean wH()
  {
    boolean bool = f.zV();
    int i = wI();
    if (i == 0) {
      bool = false;
    }
    y.i("MicroMsg.Notification.Silent.Handle", "check is Shake Mode: %B, System AudioManager Mode: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
    return bool;
  }
  
  public static int wI()
  {
    return ((AudioManager)ae.getContext().getSystemService("audio")).getRingerMode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.e
 * JD-Core Version:    0.7.0.1
 */