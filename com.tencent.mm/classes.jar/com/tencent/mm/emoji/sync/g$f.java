package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.l;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$CustomEmojiDataProvider;", "Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$IDataProvider;", "()V", "getEmojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
final class g$f
  implements g.h
{
  public final List<EmojiInfo> aWt()
  {
    AppMethodBeat.i(242619);
    Object localObject = l.aUF().aUG();
    if (localObject == null)
    {
      localObject = (List)new ArrayList();
      AppMethodBeat.o(242619);
      return localObject;
    }
    localObject = (List)localObject;
    AppMethodBeat.o(242619);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.g.f
 * JD-Core Version:    0.7.0.1
 */