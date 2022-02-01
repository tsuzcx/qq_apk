package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.k;
import com.tencent.mm.emoji.sync.g;
import com.tencent.mm.emoji.sync.g.b;
import com.tencent.mm.emoji.sync.j;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/panel/CaptureItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "hasEntrance", "", "(Z)V", "emojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "kotlin.jvm.PlatformType", "reportCount", "", "getDataCount", "plugin-emojisdk_release"})
public final class c
  extends a
{
  private final List<EmojiInfo> jIX;
  private int jIY;
  
  public c(boolean paramBoolean)
  {
    super(af.aCC());
    AppMethodBeat.i(105526);
    Object localObject = k.aBH().es(true);
    if (localObject != null) {}
    for (localObject = (List)localObject;; localObject = (List)v.aaAd)
    {
      this.jIX = ((List)localObject);
      this.jIY = this.jIX.size();
      if (!this.jIX.isEmpty()) {
        break;
      }
      if (!paramBoolean) {
        break label307;
      }
      this.jIW.add(new b());
      AppMethodBeat.o(105526);
      return;
    }
    this.jIW.add(aCh());
    if (paramBoolean) {
      this.jIW.add(new m(1));
    }
    localObject = g.jOs;
    int j = g.b.aDs().aDj();
    localObject = g.jOs;
    int k = g.b.aDs().aDk();
    localObject = this.jIX.iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      EmojiInfo localEmojiInfo = (EmojiInfo)((Iterator)localObject).next();
      if (i < k)
      {
        LinkedList localLinkedList;
        if (i >= j)
        {
          localLinkedList = this.jIW;
          p.j(localEmojiInfo, "info");
          localLinkedList.add(new h(localEmojiInfo, 3));
        }
        for (;;)
        {
          i += 1;
          break;
          localLinkedList = this.jIW;
          p.j(localEmojiInfo, "info");
          localLinkedList.add(new h(localEmojiInfo, 1));
        }
      }
    }
    localObject = g.jOs;
    if (g.b.aDs().aDl()) {
      this.jIW.add(new u(1));
    }
    label307:
    AppMethodBeat.o(105526);
  }
  
  public final int getDataCount()
  {
    return this.jIY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.c
 * JD-Core Version:    0.7.0.1
 */