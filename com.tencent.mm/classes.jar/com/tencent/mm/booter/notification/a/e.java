package com.tencent.mm.booter.notification.a;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioManager;
import android.text.format.Time;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.g.a.yh.b;
import com.tencent.mm.n.f;
import com.tencent.mm.sdk.h.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.storage.bv;
import java.util.HashSet;
import java.util.Set;

public final class e
{
  private static final Set<String> fJh;
  static final Time fJj;
  public boolean fJi;
  
  static
  {
    AppMethodBeat.i(20055);
    HashSet localHashSet = new HashSet();
    fJh = localHashSet;
    localHashSet.add("readerapp");
    fJh.add("blogapp");
    fJh.add("newsapp");
    fJj = new Time();
    AppMethodBeat.o(20055);
  }
  
  public static boolean XB()
  {
    AppMethodBeat.i(20046);
    fJj.setToNow();
    int i = fJj.hour;
    int j = fJj.minute;
    ak.getContext();
    if (!com.tencent.mm.n.a.cr(i, j))
    {
      ae.w("MicroMsg.Notification.Silent.Handle", "no shake & sound notification during background deactive time");
      AppMethodBeat.o(20046);
      return true;
    }
    AppMethodBeat.o(20046);
    return false;
  }
  
  public static boolean XC()
  {
    AppMethodBeat.i(20047);
    boolean bool = f.abS();
    ae.i("MicroMsg.Notification.Silent.Handle", "check is Sound Mode: %B", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(20047);
    return bool;
  }
  
  public static boolean XD()
  {
    bool2 = false;
    AppMethodBeat.i(186339);
    bool1 = bool2;
    NotificationManager localNotificationManager;
    if (d.lA(28))
    {
      bool1 = bool2;
      if (!b.fqp())
      {
        localNotificationManager = (NotificationManager)ak.getContext().getSystemService("notification");
        bool1 = bool2;
        if (localNotificationManager.getCurrentInterruptionFilter() != 2) {}
      }
    }
    for (;;)
    {
      try
      {
        bool1 = localNotificationManager.getNotificationChannel(com.tencent.mm.bq.a.fct()).canBypassDnd();
        if (bool1) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.Notification.Silent.Handle", "isSystemDoNotDisturb Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        bool1 = bool2;
        continue;
      }
      AppMethodBeat.o(186339);
      return bool1;
      bool1 = false;
    }
  }
  
  public static boolean XE()
  {
    boolean bool2 = true;
    AppMethodBeat.i(20050);
    try
    {
      yh localyh = new yh();
      localyh.dNE.dto = 2;
      com.tencent.mm.sdk.b.a.IvT.l(localyh);
      bool1 = localyh.dNF.dNG;
      if (!bool1)
      {
        ae.d("MicroMsg.Notification.Silent.Handle", "check is Voip NOT Calling: %B", new Object[] { Boolean.valueOf(bool2) });
        AppMethodBeat.o(20050);
        return bool1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.Notification.Silent.Handle", localException, "", new Object[0]);
        boolean bool1 = false;
        continue;
        bool2 = false;
      }
    }
  }
  
  public static boolean XF()
  {
    AppMethodBeat.i(20052);
    boolean bool = f.abW();
    int i = XG();
    if (i == 0) {
      bool = false;
    }
    ae.i("MicroMsg.Notification.Silent.Handle", "check is Shake Mode: %B, System AudioManager Mode: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
    AppMethodBeat.o(20052);
    return bool;
  }
  
  public static int XG()
  {
    AppMethodBeat.i(20053);
    int i = ((AudioManager)ak.getContext().getSystemService("audio")).getRingerMode();
    AppMethodBeat.o(20053);
    return i;
  }
  
  public static boolean a(String paramString, bv parambv)
  {
    boolean bool2 = true;
    AppMethodBeat.i(20049);
    boolean bool1;
    if ((f.wc(paramString)) && (!f.p(parambv)))
    {
      bool1 = true;
      if (bool1) {
        break label59;
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.Notification.Silent.Handle", "check is NOT Must Mute: %B", new Object[] { Boolean.valueOf(bool2) });
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
  
  public static boolean kY(int paramInt)
  {
    AppMethodBeat.i(20048);
    if ((paramInt & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.Notification.Silent.Handle", "check is Service Request Sound: %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(20048);
      return bool;
    }
  }
  
  public static boolean kZ(int paramInt)
  {
    AppMethodBeat.i(20054);
    if ((paramInt & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.Notification.Silent.Handle", "check is Service Request Shake: %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(20054);
      return bool;
    }
  }
  
  public static boolean q(int paramInt, String paramString)
  {
    AppMethodBeat.i(20051);
    boolean bool;
    if (f.lG(paramInt)) {
      if (f.vX(paramString)) {
        bool = f.acJ();
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.Notification.Silent.Handle", "check is Voip Need Sound: %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(20051);
      return bool;
      if (f.vY(paramString)) {
        bool = f.acK();
      } else {
        bool = true;
      }
    }
  }
  
  public static boolean uM(String paramString)
  {
    AppMethodBeat.i(20044);
    if (ao.aRT("keep_chatting_silent".concat(String.valueOf(paramString))))
    {
      ae.i("MicroMsg.Notification.Silent.Handle", "check is Sound NOT Lock: FALSE");
      AppMethodBeat.o(20044);
      return true;
    }
    ae.i("MicroMsg.Notification.Silent.Handle", "check is Sound NOT Lock: TRUE");
    AppMethodBeat.o(20044);
    return false;
  }
  
  public static boolean uN(String paramString)
  {
    boolean bool1 = true;
    AppMethodBeat.i(20045);
    boolean bool2 = fJh.contains(paramString);
    if (!bool2) {}
    for (;;)
    {
      ae.i("MicroMsg.Notification.Silent.Handle", "check is NOT Siler User: %B", new Object[] { Boolean.valueOf(bool1) });
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