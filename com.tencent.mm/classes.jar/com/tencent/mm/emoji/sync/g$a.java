package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.l;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$CaptureEmojiDataProvider;", "Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$IDataProvider;", "()V", "getEmojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
final class g$a
  implements g.h
{
  public final List<EmojiInfo> aWt()
  {
    AppMethodBeat.i(242620);
    Object localObject = l.aUF().fe(false);
    s.s(localObject, "getInstance().getCaptureEmoji(false)");
    localObject = (List)localObject;
    AppMethodBeat.o(242620);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.g.a
 * JD-Core Version:    0.7.0.1
 */