package com.tencent.mm.emoji.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.l;
import com.tencent.mm.emoji.sync.g;
import com.tencent.mm.emoji.sync.g.b;
import com.tencent.mm.emoji.sync.j;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/panel/CaptureItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "hasEntrance", "", "(Z)V", "emojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "kotlin.jvm.PlatformType", "reportCount", "", "getDataCount", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a
{
  private final List<EmojiInfo> mip;
  private int miq;
  
  public c(boolean paramBoolean)
  {
    super(af.aVz());
    AppMethodBeat.i(105526);
    Object localObject = l.aUF().fe(true);
    if (localObject == null) {}
    for (localObject = (List)ab.aivy;; localObject = (List)localObject)
    {
      this.mip = ((List)localObject);
      this.miq = this.mip.size();
      if (!this.mip.isEmpty()) {
        break;
      }
      if (!paramBoolean) {
        break label307;
      }
      this.mio.add(new b());
      AppMethodBeat.o(105526);
      return;
    }
    this.mio.add(aVd());
    if (paramBoolean) {
      this.mio.add(new m(1));
    }
    localObject = g.mmX;
    int j = g.b.aWo().aWj();
    localObject = g.mmX;
    int k = g.b.aWo().aWk();
    localObject = this.mip.iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      EmojiInfo localEmojiInfo = (EmojiInfo)((Iterator)localObject).next();
      if (i < k)
      {
        LinkedList localLinkedList;
        if (i >= j)
        {
          localLinkedList = this.mio;
          s.s(localEmojiInfo, "info");
          localLinkedList.add(new h(localEmojiInfo, 3));
        }
        for (;;)
        {
          i += 1;
          break;
          localLinkedList = this.mio;
          s.s(localEmojiInfo, "info");
          localLinkedList.add(new h(localEmojiInfo, 1));
        }
      }
    }
    localObject = g.mmX;
    if (g.b.aWo().aWl()) {
      this.mio.add(new u(1));
    }
    label307:
    AppMethodBeat.o(105526);
  }
  
  public final int getDataCount()
  {
    return this.miq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.c.b.c
 * JD-Core Version:    0.7.0.1
 */