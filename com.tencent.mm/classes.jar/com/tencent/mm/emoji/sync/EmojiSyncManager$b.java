package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "", "(Ljava/lang/String;I)V", "Init", "Checking", "Syncing", "WaitWifi", "WaitLoadMore", "End", "plugin-emojisdk_release"})
public enum EmojiSyncManager$b
{
  static
  {
    AppMethodBeat.i(105739);
    b localb1 = new b("Init", 0);
    jOA = localb1;
    b localb2 = new b("Checking", 1);
    jOB = localb2;
    b localb3 = new b("Syncing", 2);
    jOC = localb3;
    b localb4 = new b("WaitWifi", 3);
    jOD = localb4;
    b localb5 = new b("WaitLoadMore", 4);
    jOE = localb5;
    b localb6 = new b("End", 5);
    jOF = localb6;
    jOG = new b[] { localb1, localb2, localb3, localb4, localb5, localb6 };
    AppMethodBeat.o(105739);
  }
  
  private EmojiSyncManager$b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.EmojiSyncManager.b
 * JD-Core Version:    0.7.0.1
 */