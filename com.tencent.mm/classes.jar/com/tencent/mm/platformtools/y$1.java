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
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.m.f;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.e.h;

public final class y$1
  implements com.tencent.mm.bq.a
{
  public y$1(String paramString1, String paramString2, Bundle paramBundle, String paramString3, String paramString4, int paramInt) {}
  
  public final void onDone()
  {
    AppMethodBeat.i(16670);
    Object localObject1 = new Time();
    ((Time)localObject1).setToNow();
    int i = ((Time)localObject1).hour;
    int j = ((Time)localObject1).minute;
    ah.getContext();
    Object localObject2;
    if (!com.tencent.mm.m.a.bX(i, j))
    {
      ab.i("MiroMsg.NotificationUtil", "no shake & sound notification during background deactive time");
      localObject1 = new Intent();
      ((Intent)localObject1).setClassName(ah.getPackageName(), ah.getPackageName() + ".plugin.webview.ui.tools.WebViewUI");
      ((Intent)localObject1).putExtra("rawUrl", this.val$jumpUrl);
      ((Intent)localObject1).putExtra("useJs", true);
      ((Intent)localObject1).putExtra("vertical_scroll", true);
      ((Intent)localObject1).setFlags(872415232);
      ab.d("MiroMsg.NotificationUtil", "bizFrom: %s, data: %s", new Object[] { this.gjP, this.cax });
      if ((this.gjP != null) && (this.cax != null))
      {
        ((Intent)localObject1).putExtra("bizofstartfrom", this.gjP);
        ((Intent)localObject1).putExtra("startwebviewparams", this.cax);
      }
      localObject1 = PendingIntent.getActivity(ah.getContext(), 0, (Intent)localObject1, 134217728);
      localObject2 = com.tencent.mm.bp.a.br(ah.getContext(), "reminder_channel_id").h(null).g(System.currentTimeMillis()).e(this.cbK).f(this.fOX);
      ((s.c)localObject2).ya = ((PendingIntent)localObject1);
      localObject1 = ((s.c)localObject2).build();
      ((Notification)localObject1).icon = com.tencent.mm.bp.a.bYt();
      ((Notification)localObject1).flags |= 0x10;
      ((NotificationManager)ah.getContext().getSystemService("notification")).notify(this.gjQ, (Notification)localObject1);
      AppMethodBeat.o(16670);
      return;
    }
    for (;;)
    {
      k localk;
      try
      {
        for (;;)
        {
          localObject2 = ah.getContext();
          boolean bool1 = f.MD();
          boolean bool2 = f.MB();
          ab.d("MiroMsg.NotificationUtil", "shake " + bool1 + "sound " + bool2);
          if (bool1)
          {
            ab.i("MiroMsg.NotificationUtil", "notification.shake:  notifyEngageRemind isShake~: true");
            bo.z((Context)localObject2, true);
          }
          if (!bool2) {
            break;
          }
          localObject1 = f.MF();
          if (localObject1 != e.h.etD) {
            break label583;
          }
          localObject1 = RingtoneManager.getDefaultUri(2);
          localk = new k();
          try
          {
            localk.setDataSource((Context)localObject2, (Uri)localObject1);
            localk.setOnCompletionListener(new y.3());
            if (aw.aaA().getStreamVolume(5) == 0) {
              break;
            }
            if (!aw.aaA().KN()) {
              break label593;
            }
            int k = aw.aaA().getStreamVolume(8);
            i = aw.aaA().getStreamMaxVolume(8);
            j = aw.aaA().getStreamVolume(5);
            if (j <= i) {
              break label624;
            }
            aw.aaA().bW(8, i);
            localk.setAudioStreamType(8);
            localk.setLooping(true);
            localk.prepare();
            localk.setLooping(false);
            localk.start();
            aw.aaA().bW(8, k);
            ab.d("MiroMsg.NotificationUtil", "oldVolume is %d, toneVolume is %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
          }
          catch (Exception localException1)
          {
            ab.printErrStackTrace("MiroMsg.NotificationUtil", localException1, "", new Object[0]);
          }
        }
      }
      catch (Exception localException2)
      {
        ab.printErrStackTrace("MiroMsg.NotificationUtil", localException2, "", new Object[0]);
      }
      break;
      label583:
      Uri localUri = Uri.parse(localException2);
      continue;
      label593:
      localk.setAudioStreamType(5);
      localk.setLooping(true);
      localk.prepare();
      localk.setLooping(false);
      localk.start();
      break;
      label624:
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.platformtools.y.1
 * JD-Core Version:    0.7.0.1
 */