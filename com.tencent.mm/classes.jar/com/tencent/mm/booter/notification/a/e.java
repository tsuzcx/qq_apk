package com.tencent.mm.booter.notification.a;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioManager;
import android.text.format.Time;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.g.a.zj.b;
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
  private static final Set<String> gow;
  static final Time goy;
  public boolean gox;
  
  static
  {
    AppMethodBeat.i(20055);
    HashSet localHashSet = new HashSet();
    gow = localHashSet;
    localHashSet.add("readerapp");
    gow.add("blogapp");
    gow.add("newsapp");
    goy = new Time();
    AppMethodBeat.o(20055);
  }
  
  public static boolean Dc(String paramString)
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
  
  public static boolean Dd(String paramString)
  {
    boolean bool1 = true;
    AppMethodBeat.i(20045);
    boolean bool2 = gow.contains(paramString);
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
    if ((g.Er(paramString)) && (!g.p(paramca)))
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
  
  public static boolean alo()
  {
    AppMethodBeat.i(20046);
    goy.setToNow();
    int i = goy.hour;
    int j = goy.minute;
    MMApplicationContext.getContext();
    if (!b.ct(i, j))
    {
      Log.w("MicroMsg.Notification.Silent.Handle", "no shake & sound notification during background deactive time");
      AppMethodBeat.o(20046);
      return true;
    }
    AppMethodBeat.o(20046);
    return false;
  }
  
  public static boolean alp()
  {
    AppMethodBeat.i(20047);
    boolean bool = g.apR();
    Log.i("MicroMsg.Notification.Silent.Handle", "check is Sound Mode: %B", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(20047);
    return bool;
  }
  
  public static boolean alq()
  {
    bool2 = false;
    AppMethodBeat.i(231502);
    bool1 = bool2;
    NotificationManager localNotificationManager;
    if (d.oD(28))
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
        bool1 = localNotificationManager.getNotificationChannel(a.glE()).canBypassDnd();
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
      AppMethodBeat.o(231502);
      return bool1;
      bool1 = false;
    }
  }
  
  public static boolean alr()
  {
    boolean bool2 = true;
    AppMethodBeat.i(20050);
    try
    {
      zj localzj = new zj();
      localzj.efx.dKy = 2;
      EventCenter.instance.publish(localzj);
      bool1 = localzj.efy.calling;
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
  
  public static boolean als()
  {
    AppMethodBeat.i(20052);
    boolean bool = g.apV();
    int i = alt();
    if (i == 0) {
      bool = false;
    }
    Log.i("MicroMsg.Notification.Silent.Handle", "check is Shake Mode: %B, System AudioManager Mode: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
    AppMethodBeat.o(20052);
    return bool;
  }
  
  public static int alt()
  {
    AppMethodBeat.i(20053);
    int i = ((AudioManager)MMApplicationContext.getContext().getSystemService("audio")).getRingerMode();
    AppMethodBeat.o(20053);
    return i;
  }
  
  public static boolean oa(int paramInt)
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
  
  public static boolean ob(int paramInt)
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
  
  public static boolean s(int paramInt, String paramString)
  {
    AppMethodBeat.i(20051);
    boolean bool;
    if (g.oJ(paramInt)) {
      if (g.Em(paramString)) {
        bool = g.aqH();
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.Notification.Silent.Handle", "check is Voip Need Sound: %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(20051);
      return bool;
      if (g.En(paramString)) {
        bool = g.aqI();
      } else {
        bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.e
 * JD-Core Version:    0.7.0.1
 */