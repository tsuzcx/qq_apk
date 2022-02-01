package com.tencent.mm.booter.notification.a;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioManager;
import android.text.format.Time;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.g.a.xh.b;
import com.tencent.mm.m.f;
import com.tencent.mm.sdk.h.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.storage.bo;
import java.util.HashSet;
import java.util.Set;

public final class e
{
  private static final Set<String> foV;
  static final Time foX;
  public boolean foW;
  
  static
  {
    AppMethodBeat.i(20055);
    HashSet localHashSet = new HashSet();
    foV = localHashSet;
    localHashSet.add("readerapp");
    foV.add("blogapp");
    foV.add("newsapp");
    foX = new Time();
    AppMethodBeat.o(20055);
  }
  
  public static boolean Vc()
  {
    AppMethodBeat.i(20046);
    foX.setToNow();
    int i = foX.hour;
    int j = foX.minute;
    ai.getContext();
    if (!com.tencent.mm.m.a.cp(i, j))
    {
      ac.w("MicroMsg.Notification.Silent.Handle", "no shake & sound notification during background deactive time");
      AppMethodBeat.o(20046);
      return true;
    }
    AppMethodBeat.o(20046);
    return false;
  }
  
  public static boolean Vd()
  {
    AppMethodBeat.i(20047);
    boolean bool = f.Zj();
    ac.i("MicroMsg.Notification.Silent.Handle", "check is Sound Mode: %B", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(20047);
    return bool;
  }
  
  public static boolean Ve()
  {
    bool2 = false;
    AppMethodBeat.i(195936);
    bool1 = bool2;
    NotificationManager localNotificationManager;
    if (d.kZ(28))
    {
      bool1 = bool2;
      if (!b.eWK())
      {
        localNotificationManager = (NotificationManager)ai.getContext().getSystemService("notification");
        bool1 = bool2;
        if (localNotificationManager.getCurrentInterruptionFilter() != 2) {}
      }
    }
    for (;;)
    {
      try
      {
        bool1 = localNotificationManager.getNotificationChannel(com.tencent.mm.bq.a.eJR()).canBypassDnd();
        if (bool1) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.Notification.Silent.Handle", "isSystemDoNotDisturb Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        bool1 = bool2;
        continue;
      }
      AppMethodBeat.o(195936);
      return bool1;
      bool1 = false;
    }
  }
  
  public static boolean Vf()
  {
    boolean bool2 = true;
    AppMethodBeat.i(20050);
    try
    {
      xh localxh = new xh();
      localxh.dAb.dgL = 2;
      com.tencent.mm.sdk.b.a.GpY.l(localxh);
      bool1 = localxh.dAc.dAd;
      if (!bool1)
      {
        ac.d("MicroMsg.Notification.Silent.Handle", "check is Voip NOT Calling: %B", new Object[] { Boolean.valueOf(bool2) });
        AppMethodBeat.o(20050);
        return bool1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.Notification.Silent.Handle", localException, "", new Object[0]);
        boolean bool1 = false;
        continue;
        bool2 = false;
      }
    }
  }
  
  public static boolean Vg()
  {
    AppMethodBeat.i(20052);
    boolean bool = f.Zn();
    int i = Vh();
    if (i == 0) {
      bool = false;
    }
    ac.i("MicroMsg.Notification.Silent.Handle", "check is Shake Mode: %B, System AudioManager Mode: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
    AppMethodBeat.o(20052);
    return bool;
  }
  
  public static int Vh()
  {
    AppMethodBeat.i(20053);
    int i = ((AudioManager)ai.getContext().getSystemService("audio")).getRingerMode();
    AppMethodBeat.o(20053);
    return i;
  }
  
  public static boolean a(String paramString, bo parambo)
  {
    boolean bool2 = true;
    AppMethodBeat.i(20049);
    boolean bool1;
    if ((f.sR(paramString)) && (!f.p(parambo)))
    {
      bool1 = true;
      if (bool1) {
        break label59;
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.Notification.Silent.Handle", "check is NOT Must Mute: %B", new Object[] { Boolean.valueOf(bool2) });
      AppMethodBeat.o(20049);
      return bool1;
      bool1 = false;
      break;
      label59:
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
  
  public static boolean kA(int paramInt)
  {
    AppMethodBeat.i(20054);
    if ((paramInt & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.Notification.Silent.Handle", "check is Service Request Shake: %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(20054);
      return bool;
    }
  }
  
  public static boolean kz(int paramInt)
  {
    AppMethodBeat.i(20048);
    if ((paramInt & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.Notification.Silent.Handle", "check is Service Request Sound: %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(20048);
      return bool;
    }
  }
  
  public static boolean q(int paramInt, String paramString)
  {
    AppMethodBeat.i(20051);
    boolean bool;
    if (f.lf(paramInt)) {
      if (f.sM(paramString)) {
        bool = f.ZW();
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.Notification.Silent.Handle", "check is Voip Need Sound: %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(20051);
      return bool;
      if (f.sN(paramString)) {
        bool = f.ZX();
      } else {
        bool = true;
      }
    }
  }
  
  public static boolean rE(String paramString)
  {
    AppMethodBeat.i(20044);
    if (am.aKQ("keep_chatting_silent".concat(String.valueOf(paramString))))
    {
      ac.i("MicroMsg.Notification.Silent.Handle", "check is Sound NOT Lock: FALSE");
      AppMethodBeat.o(20044);
      return true;
    }
    ac.i("MicroMsg.Notification.Silent.Handle", "check is Sound NOT Lock: TRUE");
    AppMethodBeat.o(20044);
    return false;
  }
  
  public static boolean rF(String paramString)
  {
    boolean bool1 = true;
    AppMethodBeat.i(20045);
    boolean bool2 = foV.contains(paramString);
    if (!bool2) {}
    for (;;)
    {
      ac.i("MicroMsg.Notification.Silent.Handle", "check is NOT Siler User: %B", new Object[] { Boolean.valueOf(bool1) });
      AppMethodBeat.o(20045);
      return bool2;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.e
 * JD-Core Version:    0.7.0.1
 */