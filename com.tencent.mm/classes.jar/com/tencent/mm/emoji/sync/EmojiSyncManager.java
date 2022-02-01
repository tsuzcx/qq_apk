package com.tencent.mm.emoji.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/sync/EmojiSyncManager;", "", "customType", "", "(I)V", "callbackQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/sync/SyncCallback;", "connectivityReceiver", "Landroid/content/BroadcastReceiver;", "getCustomType", "()I", "downloadCallback", "com/tencent/mm/emoji/sync/EmojiSyncManager$downloadCallback$1", "Lcom/tencent/mm/emoji/sync/EmojiSyncManager$downloadCallback$1;", "downloadList", "", "", "kotlin.jvm.PlatformType", "", "downloadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/emoji/sync/EmojiDownLoadTask;", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "<set-?>", "remainSize", "getRemainSize", "startNonWifi", "Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "syncState", "getSyncState", "()Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "syncedCount", "getSyncedCount", "setSyncedCount", "targetSyncCount", "getTargetSyncCount", "setTargetSyncCount", "totalSize", "getTotalSize", "addDownloadTask", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "checkAutoStart", "checkBroken", "checkLoadMore", "checkNetwork", "checkSync", "checkSyncEmoji", "start", "withBroken", "destroy", "init", "loadMore", "registerCallback", "callback", "force", "startInternal", "stop", "unregisterCallback", "Companion", "ConnectivityReceiver", "SyncState", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EmojiSyncManager
{
  public static final a mnt;
  
  static
  {
    AppMethodBeat.i(105761);
    mnt = new a((byte)0);
    AppMethodBeat.o(105761);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$ConnectivityReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/tencent/mm/emoji/sync/EmojiSyncManager;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class ConnectivityReceiver
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(105738);
      s.u(paramContext, "context");
      s.u(paramIntent, "intent");
      if (!NetStatusUtil.isConnected(paramContext))
      {
        AppMethodBeat.o(105738);
        throw null;
      }
      if (NetStatusUtil.isWifi(paramContext))
      {
        if (MMApplicationContext.isMainProcess())
        {
          AppMethodBeat.o(105738);
          throw null;
        }
        AppMethodBeat.o(105738);
        return;
      }
      if (!EmojiSyncManager.aWw())
      {
        AppMethodBeat.o(105738);
        throw null;
      }
      AppMethodBeat.o(105738);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$Companion;", "", "()V", "MaxNoWifiCount", "", "captureSyncMgr", "Lcom/tencent/mm/emoji/sync/EmojiSyncManager;", "customSyncMgr", "minSyncCount", "", "noWifiCount", "syncMoreCount", "addNoWifiSize", "", "size", "checkNoWifiSize", "", "getCaptureSyncMgr", "getCustomSyncMgr", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.EmojiSyncManager
 * JD-Core Version:    0.7.0.1
 */