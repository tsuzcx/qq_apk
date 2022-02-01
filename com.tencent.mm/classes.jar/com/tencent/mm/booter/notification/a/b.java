package com.tencent.mm.booter.notification.a;

import android.app.Notification;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.k.h;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.f.o;
import com.tencent.mm.vfs.u;
import java.io.File;

public final class b
{
  public int luA = 0;
  
  private int a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, Notification paramNotification)
  {
    AppMethodBeat.i(20039);
    Notification localNotification = paramNotification;
    if (paramNotification == null) {
      localNotification = new Notification();
    }
    Log.i("MicroMsg.NotificationDefaults", "begin initDefaults, isNeedSound: %B, isNeedShake: %B, n.defaults: %d, n.vibrate: %s, n.sound: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(localNotification.defaults), g.c(localNotification.vibrate), localNotification.sound });
    if (paramBoolean2) {
      localNotification.vibrate = Util.VIRBRATOR_PATTERN;
    }
    String str;
    int i;
    if (paramBoolean1)
    {
      paramNotification = h.aQP();
      str = (String)paramNotification.second;
      if (cW(paramContext))
      {
        localNotification.sound = null;
        i = 0;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.NotificationDefaults", "end initDefaults, defaults: %d, n.vibrate: %s, n.sound: %s", new Object[] { Integer.valueOf(i), g.c(localNotification.vibrate), localNotification.sound });
      this.luA = i;
      i = this.luA;
      AppMethodBeat.o(20039);
      return i;
      if ((str != null) && (str != f.o.lZE))
      {
        if (((Boolean)paramNotification.first).booleanValue()) {}
        for (paramContext = FileProviderHelper.getUriForFile(paramContext, u.V(new File((String)paramNotification.second)));; paramContext = Uri.parse(str))
        {
          localNotification.sound = paramContext;
          i = 0;
          break;
        }
      }
      i = 1;
      continue;
      i = 0;
    }
  }
  
  private int b(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, Notification paramNotification, String paramString)
  {
    AppMethodBeat.i(20040);
    Log.i("MicroMsg.NotificationDefaults", "begin initDefaults, isNeedSound: %B, isNeedShake: %B, n.defaults: %d, n.vibrate: %s, n.sound: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramNotification.defaults), paramNotification.vibrate, paramNotification.sound });
    int i = 0;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1;
    if (paramBoolean1) {
      if (cW(paramContext)) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if (paramBoolean2) {
        i |= 0x2;
      }
      for (;;)
      {
        Pair localPair = h.aQP();
        String str = (String)localPair.second;
        if (Util.isNullOrNil(paramString)) {
          Log.d("MicroMsg.NotificationDefaults", "msgContent is null");
        }
        boolean bool2;
        if (af.lYj.lUn != 2)
        {
          bool2 = true;
          label134:
          if (!bool2) {
            break label448;
          }
          if (!qn(i)) {
            break label442;
          }
          i &= 0xFFFFFFFD;
          Util.shake(paramContext, true);
          paramBoolean1 = true;
          label161:
          if ((!qo(i)) || (bool1)) {
            break label434;
          }
          i &= 0xFFFFFFFE;
          f.a.aLo().s(str, ((Boolean)localPair.first).booleanValue());
          bool3 = true;
          paramBoolean2 = paramBoolean1;
          paramBoolean1 = bool3;
        }
        for (;;)
        {
          if (bool1)
          {
            i &= 0xFFFFFFFE;
            f.a.aLo().s(str, ((Boolean)localPair.first).booleanValue());
            paramBoolean1 = true;
          }
          for (;;)
          {
            this.luA = i;
            Log.i("MicroMsg.NotificationDefaults", "end initDefaults, n.defaults: %d, n.vibrate: %s, n.sound: %s, soundUri: %s, headset&Play: %B, SrvDeviceInfo.mCommonInfo.mmnotify is Enable: %B, isMMShake: %B, isMMPlaySound: %B", new Object[] { Integer.valueOf(paramNotification.defaults), g.c(paramNotification.vibrate), paramNotification.sound, str, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
            i = this.luA;
            AppMethodBeat.o(20040);
            return i;
            i = 1;
            bool1 = false;
            break;
            bool2 = false;
            break label134;
            if ((qo(i)) && (str != null))
            {
              i &= 0xFFFFFFFE;
              if (((Boolean)localPair.first).booleanValue()) {}
              for (paramContext = FileProviderHelper.getUriForFile(paramContext, u.V(new File((String)localPair.second)));; paramContext = Uri.parse(str))
              {
                paramNotification.sound = paramContext;
                break;
              }
            }
          }
          label434:
          paramBoolean2 = paramBoolean1;
          paramBoolean1 = bool3;
          continue;
          label442:
          paramBoolean1 = bool4;
          break label161;
          label448:
          paramBoolean2 = false;
          paramBoolean1 = bool3;
        }
      }
      bool1 = false;
    }
  }
  
  private static boolean cW(Context paramContext)
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
  
  private static boolean qn(int paramInt)
  {
    return (paramInt & 0x2) > 0;
  }
  
  private static boolean qo(int paramInt)
  {
    return (paramInt & 0x1) > 0;
  }
  
  public final int a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, Notification paramNotification, String paramString)
  {
    AppMethodBeat.i(20038);
    if (h.aQE())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.b
 * JD-Core Version:    0.7.0.1
 */