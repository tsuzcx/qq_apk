package com.tencent.mm.platformtools;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.Time;
import androidx.core.app.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.n.b;
import com.tencent.mm.n.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.f.n;

public final class w$1
  implements com.tencent.mm.by.a
{
  public w$1(String paramString1, String paramString2, Bundle paramBundle, String paramString3, String paramString4, int paramInt) {}
  
  public final void onDone()
  {
    AppMethodBeat.i(20713);
    Object localObject1 = new Time();
    ((Time)localObject1).setToNow();
    int i = ((Time)localObject1).hour;
    int j = ((Time)localObject1).minute;
    MMApplicationContext.getContext();
    Object localObject2;
    if (!b.cL(i, j))
    {
      Log.i("MiroMsg.NotificationUtil", "no shake & sound notification during background deactive time");
      localObject1 = new Intent();
      ((Intent)localObject1).setClassName(MMApplicationContext.getPackageName(), MMApplicationContext.getSourcePackageName() + ".plugin.webview.ui.tools.WebViewUI");
      ((Intent)localObject1).putExtra("rawUrl", this.val$jumpUrl);
      ((Intent)localObject1).putExtra("useJs", true);
      ((Intent)localObject1).putExtra("vertical_scroll", true);
      ((Intent)localObject1).setFlags(872415232);
      Log.d("MiroMsg.NotificationUtil", "bizFrom: %s, data: %s", new Object[] { this.mEH, this.fgO });
      if ((this.mEH != null) && (this.fgO != null))
      {
        ((Intent)localObject1).putExtra("bizofstartfrom", this.mEH);
        ((Intent)localObject1).putExtra("startwebviewparams", this.fgO);
      }
      localObject1 = PendingIntent.getActivity(MMApplicationContext.getContext(), 0, (Intent)localObject1, 134217728);
      localObject2 = com.tencent.mm.bx.a.cp(MMApplicationContext.getContext(), "reminder_channel_id").n(null).e(System.currentTimeMillis()).k(this.cWz).l(this.val$content);
      ((e.d)localObject2).Ip = ((PendingIntent)localObject1);
      localObject1 = ((e.d)localObject2).gr();
      ((Notification)localObject1).icon = com.tencent.mm.bx.a.fkG();
      ((Notification)localObject1).flags |= 0x10;
      ((NotificationManager)MMApplicationContext.getContext().getSystemService("notification")).notify(this.mEI, (Notification)localObject1);
      AppMethodBeat.o(20713);
      return;
    }
    for (;;)
    {
      k localk;
      try
      {
        for (;;)
        {
          localObject2 = MMApplicationContext.getContext();
          boolean bool1 = g.awo();
          boolean bool2 = g.awk();
          Log.d("MiroMsg.NotificationUtil", "shake " + bool1 + "sound " + bool2);
          if (bool1)
          {
            Log.i("MiroMsg.NotificationUtil", "notification.shake:  notifyEngageRemind isShake~: true");
            Util.shake((Context)localObject2, true);
          }
          if (!bool2) {
            break;
          }
          localObject1 = g.awq();
          if (localObject1 != f.n.jwm) {
            break label562;
          }
          localObject1 = RingtoneManager.getDefaultUri(2);
          localk = new k();
          try
          {
            localk.setDataSource((Context)localObject2, (Uri)localObject1);
            localk.setOnCompletionListener(new w.3());
            if (com.tencent.mm.plugin.audio.c.a.getStreamVolume(5) == 0) {
              break;
            }
            if (!com.tencent.mm.plugin.audio.c.a.crh()) {
              break label572;
            }
            int k = com.tencent.mm.plugin.audio.c.a.getStreamVolume(8);
            i = com.tencent.mm.plugin.audio.c.a.getStreamMaxVolume(8);
            j = com.tencent.mm.plugin.audio.c.a.getStreamVolume(5);
            if (j <= i) {
              break label603;
            }
            com.tencent.mm.plugin.audio.c.a.fp(8, i);
            localk.setAudioStreamType(8);
            localk.setLooping(true);
            localk.prepare();
            localk.setLooping(false);
            localk.start();
            com.tencent.mm.plugin.audio.c.a.fp(8, k);
            Log.d("MiroMsg.NotificationUtil", "oldVolume is %d, toneVolume is %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
          }
          catch (Exception localException1)
          {
            Log.printErrStackTrace("MiroMsg.NotificationUtil", localException1, "", new Object[0]);
          }
        }
      }
      catch (Exception localException2)
      {
        Log.printErrStackTrace("MiroMsg.NotificationUtil", localException2, "", new Object[0]);
      }
      break;
      label562:
      Uri localUri = Uri.parse(localException2);
      continue;
      label572:
      localk.setAudioStreamType(5);
      localk.setLooping(true);
      localk.prepare();
      localk.setLooping(false);
      localk.start();
      break;
      label603:
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.w.1
 * JD-Core Version:    0.7.0.1
 */