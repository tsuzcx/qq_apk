package com.tencent.mm.booter.notification.a;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioManager;
import android.text.format.Time;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.g.a.yb.b;
import com.tencent.mm.n.f;
import com.tencent.mm.sdk.h.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.storage.bu;
import java.util.HashSet;
import java.util.Set;

public final class e
{
  private static final Set<String> fHd;
  static final Time fHf;
  public boolean fHe;
  
  static
  {
    AppMethodBeat.i(20055);
    HashSet localHashSet = new HashSet();
    fHd = localHashSet;
    localHashSet.add("readerapp");
    fHd.add("blogapp");
    fHd.add("newsapp");
    fHf = new Time();
    AppMethodBeat.o(20055);
  }
  
  public static boolean Xt()
  {
    AppMethodBeat.i(20046);
    fHf.setToNow();
    int i = fHf.hour;
    int j = fHf.minute;
    aj.getContext();
    if (!com.tencent.mm.n.a.cr(i, j))
    {
      ad.w("MicroMsg.Notification.Silent.Handle", "no shake & sound notification during background deactive time");
      AppMethodBeat.o(20046);
      return true;
    }
    AppMethodBeat.o(20046);
    return false;
  }
  
  public static boolean Xu()
  {
    AppMethodBeat.i(20047);
    boolean bool = f.abJ();
    ad.i("MicroMsg.Notification.Silent.Handle", "check is Sound Mode: %B", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(20047);
    return bool;
  }
  
  public static boolean Xv()
  {
    bool2 = false;
    AppMethodBeat.i(193102);
    bool1 = bool2;
    NotificationManager localNotificationManager;
    if (d.ly(28))
    {
      bool1 = bool2;
      if (!b.fmu())
      {
        localNotificationManager = (NotificationManager)aj.getContext().getSystemService("notification");
        bool1 = bool2;
        if (localNotificationManager.getCurrentInterruptionFilter() != 2) {}
      }
    }
    for (;;)
    {
      try
      {
        bool1 = localNotificationManager.getNotificationChannel(com.tencent.mm.br.a.eYF()).canBypassDnd();
        if (bool1) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.Notification.Silent.Handle", "isSystemDoNotDisturb Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        bool1 = bool2;
        continue;
      }
      AppMethodBeat.o(193102);
      return bool1;
      bool1 = false;
    }
  }
  
  public static boolean Xw()
  {
    boolean bool2 = true;
    AppMethodBeat.i(20050);
    try
    {
      yb localyb = new yb();
      localyb.dMo.dsi = 2;
      com.tencent.mm.sdk.b.a.IbL.l(localyb);
      bool1 = localyb.dMp.dMq;
      if (!bool1)
      {
        ad.d("MicroMsg.Notification.Silent.Handle", "check is Voip NOT Calling: %B", new Object[] { Boolean.valueOf(bool2) });
        AppMethodBeat.o(20050);
        return bool1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Notification.Silent.Handle", localException, "", new Object[0]);
        boolean bool1 = false;
        continue;
        bool2 = false;
      }
    }
  }
  
  public static boolean Xx()
  {
    AppMethodBeat.i(20052);
    boolean bool = f.abN();
    int i = Xy();
    if (i == 0) {
      bool = false;
    }
    ad.i("MicroMsg.Notification.Silent.Handle", "check is Shake Mode: %B, System AudioManager Mode: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
    AppMethodBeat.o(20052);
    return bool;
  }
  
  public static int Xy()
  {
    AppMethodBeat.i(20053);
    int i = ((AudioManager)aj.getContext().getSystemService("audio")).getRingerMode();
    AppMethodBeat.o(20053);
    return i;
  }
  
  public static boolean a(String paramString, bu parambu)
  {
    boolean bool2 = true;
    AppMethodBeat.i(20049);
    boolean bool1;
    if ((f.vG(paramString)) && (!f.p(parambu)))
    {
      bool1 = true;
      if (bool1) {
        break label59;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.Notification.Silent.Handle", "check is NOT Must Mute: %B", new Object[] { Boolean.valueOf(bool2) });
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
  
  public static boolean kW(int paramInt)
  {
    AppMethodBeat.i(20048);
    if ((paramInt & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.Notification.Silent.Handle", "check is Service Request Sound: %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(20048);
      return bool;
    }
  }
  
  public static boolean kX(int paramInt)
  {
    AppMethodBeat.i(20054);
    if ((paramInt & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.Notification.Silent.Handle", "check is Service Request Shake: %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(20054);
      return bool;
    }
  }
  
  public static boolean q(int paramInt, String paramString)
  {
    AppMethodBeat.i(20051);
    boolean bool;
    if (f.lE(paramInt)) {
      if (f.vB(paramString)) {
        bool = f.acy();
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.Notification.Silent.Handle", "check is Voip Need Sound: %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(20051);
      return bool;
      if (f.vC(paramString)) {
        bool = f.acz();
      } else {
        bool = true;
      }
    }
  }
  
  public static boolean ur(String paramString)
  {
    AppMethodBeat.i(20044);
    if (an.aQw("keep_chatting_silent".concat(String.valueOf(paramString))))
    {
      ad.i("MicroMsg.Notification.Silent.Handle", "check is Sound NOT Lock: FALSE");
      AppMethodBeat.o(20044);
      return true;
    }
    ad.i("MicroMsg.Notification.Silent.Handle", "check is Sound NOT Lock: TRUE");
    AppMethodBeat.o(20044);
    return false;
  }
  
  public static boolean us(String paramString)
  {
    boolean bool1 = true;
    AppMethodBeat.i(20045);
    boolean bool2 = fHd.contains(paramString);
    if (!bool2) {}
    for (;;)
    {
      ad.i("MicroMsg.Notification.Silent.Handle", "check is NOT Siler User: %B", new Object[] { Boolean.valueOf(bool1) });
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