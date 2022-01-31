package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class a
{
  public static void a(AudioManager paramAudioManager, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92826);
    if (d.fv(24))
    {
      ab.i("MicroMsg.AudioAdaptNHelp", "adjustStreamVolume()");
      try
      {
        paramAudioManager.adjustStreamVolume(paramInt1, paramInt2, 5);
        AppMethodBeat.o(92826);
        return;
      }
      catch (Exception paramAudioManager)
      {
        ab.e("MicroMsg.AudioAdaptNHelp", "adjustStreamVolume() Exception: %s", new Object[] { paramAudioManager.getMessage() });
        requestPermission();
        AppMethodBeat.o(92826);
        return;
      }
    }
    paramAudioManager.adjustStreamVolume(paramInt1, paramInt2, 5);
    AppMethodBeat.o(92826);
  }
  
  public static void b(AudioManager paramAudioManager, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92827);
    if (d.fv(24))
    {
      ab.i("MicroMsg.AudioAdaptNHelp", "setStreamVolume()");
      try
      {
        paramAudioManager.setStreamVolume(paramInt1, paramInt2, 0);
        AppMethodBeat.o(92827);
        return;
      }
      catch (Exception paramAudioManager)
      {
        ab.e("MicroMsg.AudioAdaptNHelp", "setStreamVolume() Exception:%s", new Object[] { paramAudioManager.getMessage() });
        requestPermission();
        AppMethodBeat.o(92827);
        return;
      }
    }
    paramAudioManager.setStreamVolume(paramInt1, paramInt2, 0);
    AppMethodBeat.o(92827);
  }
  
  @TargetApi(26)
  private static void requestPermission()
  {
    AppMethodBeat.i(92828);
    if (Build.VERSION.SDK_INT >= 23)
    {
      boolean bool = ((NotificationManager)ah.getContext().getSystemService("notification")).isNotificationPolicyAccessGranted();
      ab.i("MicroMsg.AudioAdaptNHelp", "requestPermission() result:%s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        try
        {
          Intent localIntent = new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS");
          localIntent.putExtra("android.provider.extra.APP_PACKAGE", ah.getPackageName());
          ah.getContext().startActivity(localIntent);
          AppMethodBeat.o(92828);
          return;
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.AudioAdaptNHelp", "requestPermission() Exception:%s", new Object[] { localException.getMessage() });
        }
      }
    }
    AppMethodBeat.o(92828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.b.a
 * JD-Core Version:    0.7.0.1
 */