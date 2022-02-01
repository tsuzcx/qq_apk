package com.tencent.mm.emoji.sync;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/emoji/sync/EmojiSyncLoader$Companion$captureRemoteCallback$1", "Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$LoadCallback;", "onLoadMore", "", "increase", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g$c
  implements g.i
{
  public final void aVL()
  {
    AppMethodBeat.i(242615);
    Object localObject = g.mmX;
    localObject = g.b.rO(1);
    Intent localIntent = new Intent();
    localIntent.setAction(EmojiUpdateReceiver.mnL);
    localIntent.putExtra(EmojiUpdateReceiver.KEY_TYPE, EmojiUpdateReceiver.mnR);
    localIntent.putExtra("data", (Parcelable)localObject);
    MMApplicationContext.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(242615);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.g.c
 * JD-Core Version:    0.7.0.1
 */