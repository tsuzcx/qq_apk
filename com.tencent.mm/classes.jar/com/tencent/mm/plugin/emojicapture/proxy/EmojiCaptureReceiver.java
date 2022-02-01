package com.tencent.mm.plugin.emojicapture.proxy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "TAG", "", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-emojicapture_release"})
public final class EmojiCaptureReceiver
  extends BroadcastReceiver
{
  private final String TAG = "MicroMsg.EmojiCaptureReceiver";
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(415);
    p.h(paramContext, "context");
    p.h(paramIntent, "intent");
    paramContext = paramIntent.getAction();
    ae.i(this.TAG, "onReceive: ".concat(String.valueOf(paramContext)));
    if (paramContext == null)
    {
      AppMethodBeat.o(415);
      return;
    }
    switch (paramContext.hashCode())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(415);
      return;
      if (paramContext.equals("com.tencent.mm.Emoji_Capture_Res"))
      {
        int i = paramIntent.getIntExtra("res_sub_type", 0);
        boolean bool = paramIntent.getBooleanExtra("res_result", false);
        ae.i(this.TAG, "onReceive: res update " + i + ' ' + bool);
        AppMethodBeat.o(415);
        return;
        if (paramContext.equals("com.tencent.mm.Emoji_Capture_Upload"))
        {
          long l = paramIntent.getLongExtra("upload_time_enter", 0L);
          bool = paramIntent.getBooleanExtra("upload_success", false);
          paramContext = paramIntent.getStringExtra("upload_md5");
          paramIntent = b.gsl;
          b.b(l, bool, paramContext);
          ae.i(this.TAG, "onReceive: upload " + l + ", " + bool + ", " + paramContext);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureReceiver
 * JD-Core Version:    0.7.0.1
 */