package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.k;
import com.tencent.mm.emoji.sync.g;
import com.tencent.mm.emoji.sync.g.b;
import com.tencent.mm.emoji.sync.j;
import com.tencent.mm.plugin.emoji.i.b;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/panel/CustomItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "hasEntrance", "", "hasSystem", "(ZZ)V", "emojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "kotlin.jvm.PlatformType", "reportCount", "", "getDataCount", "plugin-emojisdk_release"})
public final class e
  extends a
{
  private final List<EmojiInfo> jIX;
  private int jIY;
  
  public e(boolean paramBoolean1, boolean paramBoolean2)
  {
    super(af.aCB());
    AppMethodBeat.i(105531);
    Object localObject = k.aBH().aBK();
    label126:
    EmojiInfo localEmojiInfo;
    LinkedList localLinkedList;
    if (localObject != null)
    {
      localObject = (List)localObject;
      this.jIX = ((List)localObject);
      this.jIY = this.jIX.size();
      this.jIW.add(aCh());
      if (paramBoolean1) {
        this.jIW.add(new m(0));
      }
      localObject = g.jOs;
      int j = g.b.aDr().aDj();
      localObject = g.jOs;
      int k = g.b.aDr().aDk();
      localObject = this.jIX.iterator();
      int i = 0;
      if (!((Iterator)localObject).hasNext()) {
        break label251;
      }
      localEmojiInfo = (EmojiInfo)((Iterator)localObject).next();
      if ((!paramBoolean2) && (b.A(localEmojiInfo))) {
        break label289;
      }
      if (i >= k) {
        break label251;
      }
      if (i < j) {
        break label219;
      }
      localLinkedList = this.jIW;
      p.j(localEmojiInfo, "info");
      localLinkedList.add(new h(localEmojiInfo, 3));
      label201:
      i += 1;
    }
    label289:
    for (;;)
    {
      break label126;
      localObject = (List)v.aaAd;
      break;
      label219:
      localLinkedList = this.jIW;
      p.j(localEmojiInfo, "info");
      localLinkedList.add(new h(localEmojiInfo, 0));
      break label201;
      label251:
      localObject = g.jOs;
      if (g.b.aDr().aDl()) {
        this.jIW.add(new u(0));
      }
      AppMethodBeat.o(105531);
      return;
    }
  }
  
  public final int getDataCount()
  {
    return this.jIY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.e
 * JD-Core Version:    0.7.0.1
 */