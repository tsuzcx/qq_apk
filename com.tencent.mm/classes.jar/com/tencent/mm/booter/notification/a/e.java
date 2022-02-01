package com.tencent.mm.booter.notification.a;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioManager;
import android.text.format.Time;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.f.a.aaq.b;
import com.tencent.mm.n.b;
import com.tencent.mm.n.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.vendor.MIUI;
import com.tencent.mm.storage.ca;
import java.util.HashSet;
import java.util.Set;

public final class e
{
  private static final Set<String> iSF;
  static final Time iSH;
  public boolean iSG;
  
  static
  {
    AppMethodBeat.i(20055);
    HashSet localHashSet = new HashSet();
    iSF = localHashSet;
    localHashSet.add("readerapp");
    iSF.add("blogapp");
    iSF.add("newsapp");
    iSH = new Time();
    AppMethodBeat.o(20055);
  }
  
  public static boolean JT(String paramString)
  {
    AppMethodBeat.i(20044);
    if (MMEntryLock.isLocked("keep_chatting_silent".concat(String.valueOf(paramString))))
    {
      Log.i("MicroMsg.Notification.Silent.Handle", "check is Sound NOT Lock: FALSE");
      AppMethodBeat.o(20044);
      return true;
    }
    Log.i("MicroMsg.Notification.Silent.Handle", "check is Sound NOT Lock: TRUE");
    AppMethodBeat.o(20044);
    return false;
  }
  
  public static boolean JU(String paramString)
  {
    boolean bool1 = true;
    AppMethodBeat.i(20045);
    boolean bool2 = iSF.contains(paramString);
    if (!bool2) {}
    for (;;)
    {
      Log.i("MicroMsg.Notification.Silent.Handle", "check is NOT Siler User: %B", new Object[] { Boolean.valueOf(bool1) });
      AppMethodBeat.o(20045);
      return bool2;
      bool1 = false;
    }
  }
  
  public static boolean a(String paramString, ca paramca)
  {
    boolean bool2 = true;
    AppMethodBeat.i(20049);
    boolean bool1;
    if ((g.Lk(paramString)) && (!g.p(paramca)))
    {
      bool1 = true;
      if (bool1) {
        break label59;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.Notification.Silent.Handle", "check is NOT Must Mute: %B", new Object[] { Boolean.valueOf(bool2) });
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
  
  public static boolean arm()
  {
    AppMethodBeat.i(20046);
    iSH.setToNow();
    int i = iSH.hour;
    int j = iSH.minute;
    MMApplicationContext.getContext();
    if (!b.cL(i, j))
    {
      Log.w("MicroMsg.Notification.Silent.Handle", "no shake & sound notification during background deactive time");
      AppMethodBeat.o(20046);
      return true;
    }
    AppMethodBeat.o(20046);
    return false;
  }
  
  public static boolean arn()
  {
    AppMethodBeat.i(20047);
    boolean bool = g.awk();
    Log.i("MicroMsg.Notification.Silent.Handle", "check is Sound Mode: %B", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(20047);
    return bool;
  }
  
  public static boolean aro()
  {
    bool2 = false;
    AppMethodBeat.i(292128);
    bool1 = bool2;
    NotificationManager localNotificationManager;
    if (d.qV(28))
    {
      bool1 = bool2;
      if (!MIUI.ifMIUI())
      {
        localNotificationManager = (NotificationManager)MMApplicationContext.getContext().getSystemService("notification");
        bool1 = bool2;
        if (localNotificationManager.getCurrentInterruptionFilter() != 2) {}
      }
    }
    for (;;)
    {
      try
      {
        bool1 = localNotificationManager.getNotificationChannel(a.hfv()).canBypassDnd();
        if (bool1) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.Notification.Silent.Handle", "isSystemDoNotDisturb Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        bool1 = bool2;
        continue;
      }
      AppMethodBeat.o(292128);
      return bool1;
      bool1 = false;
    }
  }
  
  public static boolean arp()
  {
    boolean bool2 = true;
    AppMethodBeat.i(20050);
    try
    {
      aaq localaaq = new aaq();
      localaaq.fZM.fDn = 2;
      EventCenter.instance.publish(localaaq);
      bool1 = localaaq.fZN.calling;
      if (!bool1)
      {
        Log.d("MicroMsg.Notification.Silent.Handle", "check is Voip NOT Calling: %B", new Object[] { Boolean.valueOf(bool2) });
        AppMethodBeat.o(20050);
        return bool1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Notification.Silent.Handle", localException, "", new Object[0]);
        boolean bool1 = false;
        continue;
        bool2 = false;
      }
    }
  }
  
  public static boolean arq()
  {
    AppMethodBeat.i(20052);
    boolean bool = g.awo();
    int i = arr();
    if (i == 0) {
      bool = false;
    }
    Log.i("MicroMsg.Notification.Silent.Handle", "check is Shake Mode: %B, System AudioManager Mode: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
    AppMethodBeat.o(20052);
    return bool;
  }
  
  public static int arr()
  {
    AppMethodBeat.i(20053);
    int i = ((AudioManager)MMApplicationContext.getContext().getSystemService("audio")).getRingerMode();
    AppMethodBeat.o(20053);
    return i;
  }
  
  public static boolean qp(int paramInt)
  {
    AppMethodBeat.i(20048);
    if ((paramInt & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.Notification.Silent.Handle", "check is Service Request Sound: %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(20048);
      return bool;
    }
  }
  
  public static boolean qq(int paramInt)
  {
    AppMethodBeat.i(20054);
    if ((paramInt & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.Notification.Silent.Handle", "check is Service Request Shake: %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(20054);
      return bool;
    }
  }
  
  public static boolean t(int paramInt, String paramString)
  {
    AppMethodBeat.i(20051);
    boolean bool;
    if (g.rc(paramInt)) {
      if (g.Lf(paramString)) {
        bool = g.axa();
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.Notification.Silent.Handle", "check is Voip Need Sound: %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(20051);
      return bool;
      if (g.Lg(paramString)) {
        bool = g.axb();
      } else {
        bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.e
 * JD-Core Version:    0.7.0.1
 */