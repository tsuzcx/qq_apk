package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "", "(Ljava/lang/String;I)V", "Init", "Checking", "Syncing", "WaitWifi", "WaitLoadMore", "End", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum EmojiSyncManager$b
{
  static
  {
    AppMethodBeat.i(105739);
    mnu = new b("Init", 0);
    mnv = new b("Checking", 1);
    mnw = new b("Syncing", 2);
    mnx = new b("WaitWifi", 3);
    mny = new b("WaitLoadMore", 4);
    mnz = new b("End", 5);
    mnA = new b[] { mnu, mnv, mnw, mnx, mny, mnz };
    AppMethodBeat.o(105739);
  }
  
  private EmojiSyncManager$b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.EmojiSyncManager.b
 * JD-Core Version:    0.7.0.1
 */