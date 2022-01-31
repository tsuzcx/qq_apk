package com.tencent.mm.emoji.sync;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$Companion;", "", "()V", "captureSyncMgr", "Lcom/tencent/mm/emoji/sync/EmojiSyncManager;", "customSyncMgr", "getCaptureSyncMgr", "getCustomSyncMgr", "plugin-emojisdk_release"})
public final class EmojiSyncManager$a
{
  public static EmojiSyncManager Pg()
  {
    AppMethodBeat.i(63259);
    EmojiSyncManager localEmojiSyncManager2 = EmojiSyncManager.Pe();
    EmojiSyncManager localEmojiSyncManager1 = localEmojiSyncManager2;
    if (localEmojiSyncManager2 == null)
    {
      localEmojiSyncManager1 = new EmojiSyncManager(0);
      EmojiSyncManager.a(localEmojiSyncManager1);
    }
    AppMethodBeat.o(63259);
    return localEmojiSyncManager1;
  }
  
  public static EmojiSyncManager Ph()
  {
    AppMethodBeat.i(63260);
    EmojiSyncManager localEmojiSyncManager2 = EmojiSyncManager.Pf();
    EmojiSyncManager localEmojiSyncManager1 = localEmojiSyncManager2;
    if (localEmojiSyncManager2 == null)
    {
      localEmojiSyncManager1 = new EmojiSyncManager(1);
      EmojiSyncManager.i(localEmojiSyncManager1);
    }
    AppMethodBeat.o(63260);
    return localEmojiSyncManager1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.EmojiSyncManager.a
 * JD-Core Version:    0.7.0.1
 */