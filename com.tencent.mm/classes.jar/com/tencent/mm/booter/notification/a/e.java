package com.tencent.mm.booter.notification.a;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioManager;
import android.text.format.Time;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.autogen.a.acn.b;
import com.tencent.mm.bq.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.k.b;
import com.tencent.mm.k.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.vendor.MIUI;
import com.tencent.mm.storage.cc;
import java.util.HashSet;
import java.util.Set;

public final class e
{
  private static final Set<String> luC;
  static final Time luE;
  private boolean luD;
  
  static
  {
    AppMethodBeat.i(20055);
    HashSet localHashSet = new HashSet();
    luC = localHashSet;
    localHashSet.add("readerapp");
    luC.add("blogapp");
    luC.add("newsapp");
    luE = new Time();
    AppMethodBeat.o(20055);
  }
  
  public static boolean CA(String paramString)
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
  
  public static boolean CB(String paramString)
  {
    boolean bool1 = true;
    AppMethodBeat.i(20045);
    boolean bool2 = luC.contains(paramString);
    if (!bool2) {}
    for (;;)
    {
      Log.i("MicroMsg.Notification.Silent.Handle", "check is NOT Siler User: %B", new Object[] { Boolean.valueOf(bool1) });
      AppMethodBeat.o(20045);
      return bool2;
      bool1 = false;
    }
  }
  
  public static boolean a(String paramString, cc paramcc)
  {
    boolean bool2 = true;
    AppMethodBeat.i(20049);
    boolean bool1;
    if ((h.DR(paramString)) && (!h.p(paramcc)))
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
  
  public static boolean aLi()
  {
    AppMethodBeat.i(20046);
    luE.setToNow();
    int i = luE.hour;
    int j = luE.minute;
    MMApplicationContext.getContext();
    if (!b.dB(i, j))
    {
      Log.w("MicroMsg.Notification.Silent.Handle", "no shake & sound notification during background deactive time");
      AppMethodBeat.o(20046);
      return true;
    }
    AppMethodBeat.o(20046);
    return false;
  }
  
  public static boolean aLj()
  {
    AppMethodBeat.i(20047);
    boolean bool = h.aQL();
    Log.i("MicroMsg.Notification.Silent.Handle", "check is Sound Mode: %B", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(20047);
    return bool;
  }
  
  public static boolean aLk()
  {
    bool2 = false;
    AppMethodBeat.i(238932);
    bool1 = bool2;
    NotificationManager localNotificationManager;
    if (d.rb(28))
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
        bool1 = localNotificationManager.getNotificationChannel(a.iGp()).canBypassDnd();
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
      AppMethodBeat.o(238932);
      return bool1;
      bool1 = false;
    }
  }
  
  public static boolean aLl()
  {
    boolean bool2 = true;
    AppMethodBeat.i(20050);
    try
    {
      acn localacn = new acn();
      localacn.ifU.hId = 2;
      localacn.publish();
      bool1 = localacn.ifV.calling;
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
  
  public static boolean aLm()
  {
    AppMethodBeat.i(20052);
    boolean bool = h.aQN();
    int i = aLn();
    if (i == 0) {
      bool = false;
    }
    Log.i("MicroMsg.Notification.Silent.Handle", "check is Shake Mode: %B, System AudioManager Mode: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
    AppMethodBeat.o(20052);
    return bool;
  }
  
  public static int aLn()
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
    if (h.rk(paramInt)) {
      if (h.DM(paramString)) {
        bool = h.aRA();
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.Notification.Silent.Handle", "check is Voip Need Sound: %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(20051);
      return bool;
      if (h.DN(paramString)) {
        bool = h.aRB();
      } else {
        bool = true;
      }
    }
  }
  
  public final boolean c(boolean paramBoolean, long paramLong)
  {
    boolean bool = true;
    AppMethodBeat.i(238936);
    this.luD = false;
    if (MMEntryLock.isLocked("keep_app_silent"))
    {
      this.luD = true;
      if (this.luD) {
        break label112;
      }
    }
    label112:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      Log.i("MicroMsg.Notification.Silent.Handle", "check Refresh Keep is NOT Silent: %B", new Object[] { Boolean.valueOf(paramBoolean) });
      paramBoolean = this.luD;
      AppMethodBeat.o(238936);
      return paramBoolean;
      if (paramLong <= 0L)
      {
        this.luD = false;
        break;
      }
      if ((System.currentTimeMillis() <= paramLong) || (System.currentTimeMillis() >= 5000L + paramLong)) {
        break;
      }
      this.luD = paramBoolean;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.e
 * JD-Core Version:    0.7.0.1
 */