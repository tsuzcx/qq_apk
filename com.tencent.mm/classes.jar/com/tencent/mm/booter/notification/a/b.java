package com.tencent.mm.booter.notification.a;

import android.app.Notification;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.e.j;

public final class b
{
  public int fHb = 0;
  
  private int a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, Notification paramNotification)
  {
    AppMethodBeat.i(20039);
    Notification localNotification = paramNotification;
    if (paramNotification == null) {
      localNotification = new Notification();
    }
    ad.i("MicroMsg.NotificationDefaults", "begin initDefaults, isNeedSound: %B, isNeedShake: %B, n.defaults: %d, n.vibrate: %s, n.sound: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(localNotification.defaults), g.a(localNotification.vibrate), localNotification.sound });
    if (paramBoolean2) {
      localNotification.vibrate = bt.iQc;
    }
    int i;
    if (paramBoolean1)
    {
      paramNotification = com.tencent.mm.n.f.abP();
      if (bR(paramContext))
      {
        localNotification.sound = null;
        i = 0;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.NotificationDefaults", "end initDefaults, defaults: %d, n.vibrate: %s, n.sound: %s", new Object[] { Integer.valueOf(i), g.a(localNotification.vibrate), localNotification.sound });
      this.fHb = i;
      i = this.fHb;
      AppMethodBeat.o(20039);
      return i;
      if ((paramNotification != null) && (paramNotification != e.j.gek))
      {
        localNotification.sound = Uri.parse(paramNotification);
        i = 0;
      }
      else
      {
        i = 1;
        continue;
        i = 0;
      }
    }
  }
  
  private int b(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, Notification paramNotification, String paramString)
  {
    AppMethodBeat.i(20040);
    ad.i("MicroMsg.NotificationDefaults", "begin initDefaults, isNeedSound: %B, isNeedShake: %B, n.defaults: %d, n.vibrate: %s, n.sound: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramNotification.defaults), paramNotification.vibrate, paramNotification.sound });
    int j = 0;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1;
    if (paramBoolean1) {
      if (bR(paramContext)) {
        bool1 = true;
      }
    }
    for (;;)
    {
      int i = j;
      if (paramBoolean2) {
        i = j | 0x2;
      }
      String str = com.tencent.mm.n.f.abP();
      if (bt.isNullOrNil(paramString)) {
        ad.d("MicroMsg.NotificationDefaults", "msgContent is null");
      }
      boolean bool2;
      if (ae.gcP.fZo != 2)
      {
        bool2 = true;
        label128:
        if (!bool2) {
          break label378;
        }
        if (!kU(i)) {
          break label372;
        }
        i &= 0xFFFFFFFD;
        bt.F(paramContext, true);
        paramBoolean1 = true;
        label155:
        if ((!kV(i)) || (bool1)) {
          break label364;
        }
        i &= 0xFFFFFFFE;
        f.a.Xz().ut(str);
        bool3 = true;
        paramBoolean2 = paramBoolean1;
        paramBoolean1 = bool3;
      }
      for (;;)
      {
        if (bool1)
        {
          i &= 0xFFFFFFFE;
          f.a.Xz().ut(str);
          paramBoolean1 = true;
        }
        for (;;)
        {
          this.fHb = i;
          ad.i("MicroMsg.NotificationDefaults", "end initDefaults, n.defaults: %d, n.vibrate: %s, n.sound: %s, soundUri: %s, headset&Play: %B, SrvDeviceInfo.mCommonInfo.mmnotify is Enable: %B, isMMShake: %B, isMMPlaySound: %B", new Object[] { Integer.valueOf(paramNotification.defaults), g.a(paramNotification.vibrate), paramNotification.sound, str, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
          i = this.fHb;
          AppMethodBeat.o(20040);
          return i;
          j = 1;
          bool1 = false;
          break;
          bool2 = false;
          break label128;
          if ((kV(i)) && (str != null))
          {
            i &= 0xFFFFFFFE;
            paramNotification.sound = Uri.parse(str);
          }
        }
        label364:
        paramBoolean2 = paramBoolean1;
        paramBoolean1 = bool3;
        continue;
        label372:
        paramBoolean1 = bool4;
        break label155;
        label378:
        paramBoolean2 = false;
        paramBoolean1 = bool3;
      }
      bool1 = false;
    }
  }
  
  private static boolean bR(Context paramContext)
  {
    AppMethodBeat.i(20041);
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    if (paramContext == null)
    {
      AppMethodBeat.o(20041);
      return false;
    }
    boolean bool = paramContext.isWiredHeadsetOn();
    AppMethodBeat.o(20041);
    return bool;
  }
  
  private static boolean kU(int paramInt)
  {
    return (paramInt & 0x2) > 0;
  }
  
  private static boolean kV(int paramInt)
  {
    return (paramInt & 0x1) > 0;
  }
  
  public final int a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, Notification paramNotification, String paramString)
  {
    AppMethodBeat.i(20038);
    if (com.tencent.mm.n.f.abE())
    {
      i = a(paramContext, paramBoolean1, paramBoolean2, paramNotification);
      AppMethodBeat.o(20038);
      return i;
    }
    int i = b(paramContext, paramBoolean1, paramBoolean2, paramNotification, paramString);
    AppMethodBeat.o(20038);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.b
 * JD-Core Version:    0.7.0.1
 */