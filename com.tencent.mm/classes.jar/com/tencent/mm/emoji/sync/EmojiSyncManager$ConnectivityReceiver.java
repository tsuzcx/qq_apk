package com.tencent.mm.emoji.sync;

import a.f.b.j;
import a.l;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.at;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$ConnectivityReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-emojisdk_release"})
public final class EmojiSyncManager$ConnectivityReceiver
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(63261);
    j.q(paramContext, "context");
    j.q(paramIntent, "intent");
    if (!at.isConnected(paramContext))
    {
      paramContext = EmojiSyncManager.Pe();
      if (paramContext != null)
      {
        paramContext.stop();
        AppMethodBeat.o(63261);
        return;
      }
      AppMethodBeat.o(63261);
      return;
    }
    if (at.isWifi(paramContext))
    {
      paramContext = EmojiSyncManager.Pe();
      if (paramContext != null)
      {
        paramContext.start(false);
        AppMethodBeat.o(63261);
        return;
      }
      AppMethodBeat.o(63261);
      return;
    }
    paramContext = EmojiSyncManager.Pe();
    if (paramContext != null)
    {
      if (!EmojiSyncManager.b(paramContext))
      {
        paramContext = EmojiSyncManager.Pe();
        if (paramContext != null)
        {
          paramContext.stop();
          AppMethodBeat.o(63261);
        }
      }
    }
    else
    {
      AppMethodBeat.o(63261);
      return;
    }
    AppMethodBeat.o(63261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.EmojiSyncManager.ConnectivityReceiver
 * JD-Core Version:    0.7.0.1
 */