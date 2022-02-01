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
import android.support.v4.app.s.c;
import android.text.format.Time;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.m.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.e.j;

public final class w$1
  implements com.tencent.mm.bs.a
{
  public w$1(String paramString1, String paramString2, Bundle paramBundle, String paramString3, String paramString4, int paramInt) {}
  
  public final void onDone()
  {
    AppMethodBeat.i(20713);
    Object localObject1 = new Time();
    ((Time)localObject1).setToNow();
    int i = ((Time)localObject1).hour;
    int j = ((Time)localObject1).minute;
    aj.getContext();
    Object localObject2;
    if (!com.tencent.mm.m.a.cr(i, j))
    {
      ad.i("MiroMsg.NotificationUtil", "no shake & sound notification during background deactive time");
      localObject1 = new Intent();
      ((Intent)localObject1).setClassName(aj.getPackageName(), aj.getPackageName() + ".plugin.webview.ui.tools.WebViewUI");
      ((Intent)localObject1).putExtra("rawUrl", this.val$jumpUrl);
      ((Intent)localObject1).putExtra("useJs", true);
      ((Intent)localObject1).putExtra("vertical_scroll", true);
      ((Intent)localObject1).setFlags(872415232);
      ad.d("MiroMsg.NotificationUtil", "bizFrom: %s, data: %s", new Object[] { this.hUD, this.cOb });
      if ((this.hUD != null) && (this.cOb != null))
      {
        ((Intent)localObject1).putExtra("bizofstartfrom", this.hUD);
        ((Intent)localObject1).putExtra("startwebviewparams", this.cOb);
      }
      localObject1 = PendingIntent.getActivity(aj.getContext(), 0, (Intent)localObject1, 134217728);
      localObject2 = com.tencent.mm.br.a.bD(aj.getContext(), "reminder_channel_id").i(null).g(System.currentTimeMillis()).f(this.cPN).g(this.hrB);
      ((s.c)localObject2).Ew = ((PendingIntent)localObject1);
      localObject1 = ((s.c)localObject2).build();
      ((Notification)localObject1).icon = com.tencent.mm.br.a.cYf();
      ((Notification)localObject1).flags |= 0x10;
      ((NotificationManager)aj.getContext().getSystemService("notification")).notify(this.hUE, (Notification)localObject1);
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
          localObject2 = aj.getContext();
          boolean bool1 = f.Yq();
          boolean bool2 = f.Ym();
          ad.d("MiroMsg.NotificationUtil", "shake " + bool1 + "sound " + bool2);
          if (bool1)
          {
            ad.i("MiroMsg.NotificationUtil", "notification.shake:  notifyEngageRemind isShake~: true");
            bt.C((Context)localObject2, true);
          }
          if (!bool2) {
            break;
          }
          localObject1 = f.Ys();
          if (localObject1 != e.j.fHc) {
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
            if (!com.tencent.mm.plugin.audio.c.a.bvw()) {
              break label572;
            }
            int k = com.tencent.mm.plugin.audio.c.a.getStreamVolume(8);
            i = com.tencent.mm.plugin.audio.c.a.getStreamMaxVolume(8);
            j = com.tencent.mm.plugin.audio.c.a.getStreamVolume(5);
            if (j <= i) {
              break label603;
            }
            com.tencent.mm.plugin.audio.c.a.ex(8, i);
            localk.setAudioStreamType(8);
            localk.setLooping(true);
            localk.prepare();
            localk.setLooping(false);
            localk.start();
            com.tencent.mm.plugin.audio.c.a.ex(8, k);
            ad.d("MiroMsg.NotificationUtil", "oldVolume is %d, toneVolume is %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
          }
          catch (Exception localException1)
          {
            ad.printErrStackTrace("MiroMsg.NotificationUtil", localException1, "", new Object[0]);
          }
        }
      }
      catch (Exception localException2)
      {
        ad.printErrStackTrace("MiroMsg.NotificationUtil", localException2, "", new Object[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.w.1
 * JD-Core Version:    0.7.0.1
 */