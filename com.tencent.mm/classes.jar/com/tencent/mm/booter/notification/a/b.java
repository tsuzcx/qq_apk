package com.tencent.mm.booter.notification.a;

import android.app.Notification;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.e.h;
import java.io.File;

public final class b
{
  public int ebn = 0;
  
  private int a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, Notification paramNotification)
  {
    AppMethodBeat.i(16007);
    Notification localNotification = paramNotification;
    if (paramNotification == null) {
      localNotification = new Notification();
    }
    ab.i("MicroMsg.NotificationDefaults", "begin initDefaults, isNeedSound: %B, isNeedShake: %B, n.defaults: %d, n.vibrate: %s, n.sound: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(localNotification.defaults), g.b(localNotification.vibrate), localNotification.sound });
    if (paramBoolean2) {
      localNotification.vibrate = bo.glS;
    }
    int i;
    if (paramBoolean1)
    {
      paramNotification = com.tencent.mm.m.f.MF();
      if (bB(paramContext))
      {
        localNotification.sound = null;
        i = 0;
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.NotificationDefaults", "end initDefaults, defaults: %d, n.vibrate: %s, n.sound: %s", new Object[] { Integer.valueOf(i), g.b(localNotification.vibrate), localNotification.sound });
      this.ebn = i;
      i = this.ebn;
      AppMethodBeat.o(16007);
      return i;
      if ((paramNotification != null) && (paramNotification != e.h.etD))
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
    AppMethodBeat.i(16008);
    ab.i("MicroMsg.NotificationDefaults", "begin initDefaults, isNeedSound: %B, isNeedShake: %B, n.defaults: %d, n.vibrate: %s, n.sound: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramNotification.defaults), paramNotification.vibrate, paramNotification.sound });
    int j = 0;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1;
    if (paramBoolean1) {
      if (bB(paramContext)) {
        bool1 = true;
      }
    }
    for (;;)
    {
      int i = j;
      if (paramBoolean2) {
        i = j | 0x2;
      }
      String str = com.tencent.mm.m.f.MF();
      if (bo.isNullOrNil(paramString)) {
        ab.d("MicroMsg.NotificationDefaults", "msgContent is null");
      }
      paramString = str;
      if (str != null)
      {
        paramString = str;
        if (new File(str).exists()) {
          paramString = e.h.etD;
        }
      }
      boolean bool2;
      if (ac.erF.epd != 2)
      {
        bool2 = true;
        label161:
        if (!bool2) {
          break label411;
        }
        if (!io(i)) {
          break label405;
        }
        i &= 0xFFFFFFFD;
        bo.z(paramContext, true);
        paramBoolean1 = true;
        label188:
        if ((!ip(i)) || (bool1)) {
          break label397;
        }
        i &= 0xFFFFFFFE;
        f.a.IY().kI(paramString);
        bool3 = true;
        paramBoolean2 = paramBoolean1;
        paramBoolean1 = bool3;
      }
      for (;;)
      {
        if (bool1)
        {
          i &= 0xFFFFFFFE;
          f.a.IY().kI(paramString);
          paramBoolean1 = true;
        }
        for (;;)
        {
          this.ebn = i;
          ab.i("MicroMsg.NotificationDefaults", "end initDefaults, n.defaults: %d, n.vibrate: %s, n.sound: %s, soundUri: %s, headset&Play: %B, SrvDeviceInfo.mCommonInfo.mmnotify is Enable: %B, isMMShake: %B, isMMPlaySound: %B", new Object[] { Integer.valueOf(paramNotification.defaults), g.b(paramNotification.vibrate), paramNotification.sound, paramString, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
          i = this.ebn;
          AppMethodBeat.o(16008);
          return i;
          j = 1;
          bool1 = false;
          break;
          bool2 = false;
          break label161;
          if ((ip(i)) && (paramString != null))
          {
            i &= 0xFFFFFFFE;
            paramNotification.sound = Uri.parse(paramString);
          }
        }
        label397:
        paramBoolean2 = paramBoolean1;
        paramBoolean1 = bool3;
        continue;
        label405:
        paramBoolean1 = bool4;
        break label188;
        label411:
        paramBoolean2 = false;
        paramBoolean1 = bool3;
      }
      bool1 = false;
    }
  }
  
  private static boolean bB(Context paramContext)
  {
    AppMethodBeat.i(16009);
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    if (paramContext == null)
    {
      AppMethodBeat.o(16009);
      return false;
    }
    boolean bool = paramContext.isWiredHeadsetOn();
    AppMethodBeat.o(16009);
    return bool;
  }
  
  private static boolean io(int paramInt)
  {
    return (paramInt & 0x2) > 0;
  }
  
  private static boolean ip(int paramInt)
  {
    return (paramInt & 0x1) > 0;
  }
  
  public final int a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, Notification paramNotification, String paramString)
  {
    AppMethodBeat.i(16006);
    if (com.tencent.mm.m.f.Mw())
    {
      i = a(paramContext, paramBoolean1, paramBoolean2, paramNotification);
      AppMethodBeat.o(16006);
      return i;
    }
    int i = b(paramContext, paramBoolean1, paramBoolean2, paramNotification, paramString);
    AppMethodBeat.o(16006);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.b
 * JD-Core Version:    0.7.0.1
 */