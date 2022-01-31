package com.tencent.mm.emoji.sync;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "", "(Ljava/lang/String;I)V", "Init", "Syncing", "Wait", "WaitOffline", "End", "plugin-emojisdk_release"})
public enum EmojiSyncManager$b
{
  static
  {
    AppMethodBeat.i(63262);
    b localb1 = new b("Init", 0);
    exI = localb1;
    b localb2 = new b("Syncing", 1);
    exJ = localb2;
    b localb3 = new b("Wait", 2);
    exK = localb3;
    b localb4 = new b("WaitOffline", 3);
    exL = localb4;
    b localb5 = new b("End", 4);
    exM = localb5;
    exN = new b[] { localb1, localb2, localb3, localb4, localb5 };
    AppMethodBeat.o(63262);
  }
  
  private EmojiSyncManager$b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.EmojiSyncManager.b
 * JD-Core Version:    0.7.0.1
 */