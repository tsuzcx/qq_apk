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
import android.util.Pair;
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.k.b;
import com.tencent.mm.k.h;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.f.o;
import com.tencent.mm.vfs.u;
import java.io.File;

public final class t$1
  implements com.tencent.mm.br.a
{
  public t$1(String paramString1, String paramString2, Bundle paramBundle, String paramString3, String paramString4, int paramInt) {}
  
  public final void onDone()
  {
    AppMethodBeat.i(20713);
    Object localObject1 = new Time();
    ((Time)localObject1).setToNow();
    int i = ((Time)localObject1).hour;
    int j = ((Time)localObject1).minute;
    MMApplicationContext.getContext();
    Object localObject2;
    if (!b.dB(i, j))
    {
      Log.i("MiroMsg.NotificationUtil", "no shake & sound notification during background deactive time");
      localObject1 = new Intent();
      ((Intent)localObject1).setClassName(MMApplicationContext.getPackageName(), MMApplicationContext.getSourcePackageName() + ".plugin.webview.ui.tools.WebViewUI");
      ((Intent)localObject1).putExtra("rawUrl", this.val$jumpUrl);
      ((Intent)localObject1).putExtra("useJs", true);
      ((Intent)localObject1).putExtra("vertical_scroll", true);
      ((Intent)localObject1).setFlags(872415232);
      Log.d("MiroMsg.NotificationUtil", "bizFrom: %s, data: %s", new Object[] { this.pBk, this.hkZ });
      if ((this.pBk != null) && (this.hkZ != null))
      {
        ((Intent)localObject1).putExtra("bizofstartfrom", this.pBk);
        ((Intent)localObject1).putExtra("startwebviewparams", this.hkZ);
      }
      localObject1 = PendingIntent.getActivity(MMApplicationContext.getContext(), 0, (Intent)localObject1, 134217728);
      localObject2 = com.tencent.mm.bq.a.cA(MMApplicationContext.getContext(), "reminder_channel_id").o(null).bt(System.currentTimeMillis()).l(this.eSG).m(this.val$content);
      ((f.d)localObject2).bor = ((PendingIntent)localObject1);
      localObject1 = ((f.d)localObject2).DA();
      ((Notification)localObject1).icon = com.tencent.mm.bq.a.guX();
      ((Notification)localObject1).flags |= 0x10;
      ((NotificationManager)MMApplicationContext.getContext().getSystemService("notification")).notify(this.pBl, (Notification)localObject1);
      AppMethodBeat.o(20713);
      return;
    }
    for (;;)
    {
      boolean bool1;
      Object localObject3;
      try
      {
        for (;;)
        {
          localObject2 = MMApplicationContext.getContext();
          bool1 = h.aQN();
          boolean bool2 = h.aQL();
          Log.d("MiroMsg.NotificationUtil", "shake " + bool1 + "sound " + bool2);
          if (bool1)
          {
            Log.i("MiroMsg.NotificationUtil", "notification.shake:  notifyEngageRemind isShake~: true");
            Util.shake((Context)localObject2, true);
          }
          if (!bool2) {
            break;
          }
          localObject1 = h.aQP();
          localObject3 = (String)((Pair)localObject1).second;
          bool1 = ((Boolean)((Pair)localObject1).first).booleanValue();
          if (localObject3 != f.o.lZE) {
            break label585;
          }
          localObject1 = RingtoneManager.getDefaultUri(2);
          localObject3 = new k();
          try
          {
            ((MediaPlayer)localObject3).setDataSource((Context)localObject2, (Uri)localObject1);
            ((MediaPlayer)localObject3).setOnCompletionListener(new t.3());
            if (com.tencent.mm.plugin.audio.c.a.getStreamVolume(5) == 0) {
              break;
            }
            if (!com.tencent.mm.plugin.audio.c.a.cTQ()) {
              break label622;
            }
            int k = com.tencent.mm.plugin.audio.c.a.getStreamVolume(8);
            i = com.tencent.mm.plugin.audio.c.a.getStreamMaxVolume(8);
            j = com.tencent.mm.plugin.audio.c.a.getStreamVolume(5);
            if (j <= i) {
              break label653;
            }
            com.tencent.mm.plugin.audio.c.a.gi(8, i);
            ((MediaPlayer)localObject3).setAudioStreamType(8);
            ((MediaPlayer)localObject3).setLooping(true);
            ((MediaPlayer)localObject3).prepare();
            ((MediaPlayer)localObject3).setLooping(false);
            ((MediaPlayer)localObject3).start();
            com.tencent.mm.plugin.audio.c.a.gi(8, k);
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
      label585:
      Uri localUri;
      if (bool1)
      {
        localUri = FileProviderHelper.getUriForFile((Context)localObject2, u.V(new File((String)localObject3)));
      }
      else
      {
        localUri = Uri.parse((String)localObject3);
        continue;
        label622:
        ((MediaPlayer)localObject3).setAudioStreamType(5);
        ((MediaPlayer)localObject3).setLooping(true);
        ((MediaPlayer)localObject3).prepare();
        ((MediaPlayer)localObject3).setLooping(false);
        ((MediaPlayer)localObject3).start();
        break;
        label653:
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.t.1
 * JD-Core Version:    0.7.0.1
 */