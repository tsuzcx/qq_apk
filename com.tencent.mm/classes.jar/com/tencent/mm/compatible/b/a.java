package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
{
  public static void a(AudioManager paramAudioManager, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(155545);
    if (d.qV(24))
    {
      Log.i("MicroMsg.AudioAdaptNHelp", "adjustStreamVolume()");
      try
      {
        paramAudioManager.adjustStreamVolume(paramInt1, paramInt2, 5);
        AppMethodBeat.o(155545);
        return;
      }
      catch (Exception paramAudioManager)
      {
        Log.e("MicroMsg.AudioAdaptNHelp", "adjustStreamVolume() Exception: %s", new Object[] { paramAudioManager.getMessage() });
        atE();
        AppMethodBeat.o(155545);
        return;
      }
    }
    paramAudioManager.adjustStreamVolume(paramInt1, paramInt2, 5);
    AppMethodBeat.o(155545);
  }
  
  public static void a(AudioManager paramAudioManager, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(209964);
    if (d.qV(24))
    {
      Log.i("MicroMsg.AudioAdaptNHelp", "setStreamVolume()");
      try
      {
        paramAudioManager.setStreamVolume(paramInt1, paramInt2, 0);
        AppMethodBeat.o(209964);
        return;
      }
      catch (Exception paramAudioManager)
      {
        Log.e("MicroMsg.AudioAdaptNHelp", "setStreamVolume() Exception:%s", new Object[] { paramAudioManager.getMessage() });
        atE();
        AppMethodBeat.o(209964);
        return;
      }
    }
    paramAudioManager.setStreamVolume(paramInt1, paramInt2, 0);
    AppMethodBeat.o(209964);
  }
  
  @TargetApi(26)
  private static void atE()
  {
    AppMethodBeat.i(155547);
    if (Build.VERSION.SDK_INT >= 23)
    {
      boolean bool = ((NotificationManager)MMApplicationContext.getContext().getSystemService("notification")).isNotificationPolicyAccessGranted();
      Log.i("MicroMsg.AudioAdaptNHelp", "requestPermission() result:%s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        try
        {
          Object localObject = new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS");
          ((Intent)localObject).putExtra("android.provider.extra.APP_PACKAGE", MMApplicationContext.getPackageName());
          Context localContext = MMApplicationContext.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/compatible/audio/AudioAdaptNHelp", "requestPermission", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/compatible/audio/AudioAdaptNHelp", "requestPermission", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(155547);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.AudioAdaptNHelp", "requestPermission() Exception:%s", new Object[] { localException.getMessage() });
        }
      }
    }
    AppMethodBeat.o(155547);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.b.a
 * JD-Core Version:    0.7.0.1
 */