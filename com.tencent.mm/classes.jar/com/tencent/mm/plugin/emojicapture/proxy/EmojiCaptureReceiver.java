package com.tencent.mm.plugin.emojicapture.proxy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.e.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "TAG", "", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EmojiCaptureReceiver
  extends BroadcastReceiver
{
  private final String TAG = "MicroMsg.EmojiCaptureReceiver";
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(415);
    s.u(paramContext, "context");
    s.u(paramIntent, "intent");
    paramContext = paramIntent.getAction();
    Log.i(this.TAG, s.X("onReceive: ", paramContext));
    boolean bool;
    if (s.p(paramContext, "com.tencent.mm.Emoji_Capture_Res"))
    {
      int i = paramIntent.getIntExtra("res_sub_type", 0);
      bool = paramIntent.getBooleanExtra("res_result", false);
      Log.i(this.TAG, "onReceive: res update " + i + ' ' + bool);
      AppMethodBeat.o(415);
      return;
    }
    if (s.p(paramContext, "com.tencent.mm.Emoji_Capture_Upload"))
    {
      long l = paramIntent.getLongExtra("upload_time_enter", 0L);
      bool = paramIntent.getBooleanExtra("upload_success", false);
      paramContext = paramIntent.getStringExtra("upload_md5");
      paramIntent = b.mnS;
      b.b(l, bool, paramContext);
      Log.i(this.TAG, "onReceive: upload " + l + ", " + bool + ", " + paramContext);
    }
    AppMethodBeat.o(415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureReceiver
 * JD-Core Version:    0.7.0.1
 */