package com.tencent.mm.plugin.emojicapture.proxy;

import a.f.b.j;
import a.l;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.d.b;
import com.tencent.mm.plugin.emojicapture.model.a.c;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "TAG", "", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-emojicapture_release"})
public final class EmojiCaptureReceiver
  extends BroadcastReceiver
{
  private final String TAG = "MicroMsg.EmojiCaptureReceiver";
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(2838);
    j.q(paramContext, "context");
    j.q(paramIntent, "intent");
    paramContext = paramIntent.getAction();
    ab.i(this.TAG, "onReceive: ".concat(String.valueOf(paramContext)));
    if (paramContext == null)
    {
      AppMethodBeat.o(2838);
      return;
    }
    switch (paramContext.hashCode())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(2838);
      return;
      if (paramContext.equals("com.tencent.mm.Emoji_Capture_Res"))
      {
        int i = paramIntent.getIntExtra("res_sub_type", 0);
        boolean bool = paramIntent.getBooleanExtra("res_result", false);
        ab.i(this.TAG, "onReceive: res update " + i + ' ' + bool);
        if (bool)
        {
          paramContext = c.ltQ;
          c.uG(i);
          AppMethodBeat.o(2838);
          return;
          if (paramContext.equals("com.tencent.mm.Emoji_Capture_Upload"))
          {
            long l = paramIntent.getLongExtra("upload_time_enter", 0L);
            bool = paramIntent.getBooleanExtra("upload_success", false);
            paramContext = paramIntent.getStringExtra("upload_md5");
            paramIntent = b.eyc;
            b.b(l, bool, paramContext);
            ab.i(this.TAG, "onReceive: upload " + l + ", " + bool + ", " + paramContext);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureReceiver
 * JD-Core Version:    0.7.0.1
 */