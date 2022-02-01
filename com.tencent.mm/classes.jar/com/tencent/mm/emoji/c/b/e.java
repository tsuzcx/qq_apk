package com.tencent.mm.emoji.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.l;
import com.tencent.mm.emoji.sync.g;
import com.tencent.mm.emoji.sync.g.b;
import com.tencent.mm.emoji.sync.j;
import com.tencent.mm.plugin.emoji.g.d;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/panel/CustomItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "hasEntrance", "", "hasSystem", "(ZZ)V", "emojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "kotlin.jvm.PlatformType", "reportCount", "", "getDataCount", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends a
{
  private final List<EmojiInfo> mip;
  private int miq;
  
  public e(boolean paramBoolean1, boolean paramBoolean2)
  {
    super(af.aVy());
    AppMethodBeat.i(105531);
    Object localObject = l.aUF().aUG();
    int i;
    label127:
    EmojiInfo localEmojiInfo;
    LinkedList localLinkedList;
    if (localObject == null)
    {
      localObject = (List)ab.aivy;
      this.mip = ((List)localObject);
      this.miq = this.mip.size();
      this.mio.add(aVd());
      if (paramBoolean1) {
        this.mio.add(new m(0));
      }
      localObject = g.mmX;
      int j = g.b.aWn().aWj();
      localObject = g.mmX;
      int k = g.b.aWn().aWk();
      localObject = this.mip.iterator();
      i = 0;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localEmojiInfo = (EmojiInfo)((Iterator)localObject).next();
      } while ((!paramBoolean2) && (d.A(localEmojiInfo)));
      if (i >= k) {
        break label251;
      }
      if (i < j) {
        break label219;
      }
      localLinkedList = this.mio;
      s.s(localEmojiInfo, "info");
      localLinkedList.add(new h(localEmojiInfo, 3));
    }
    for (;;)
    {
      i += 1;
      break label127;
      localObject = (List)localObject;
      break;
      label219:
      localLinkedList = this.mio;
      s.s(localEmojiInfo, "info");
      localLinkedList.add(new h(localEmojiInfo, 0));
    }
    label251:
    localObject = g.mmX;
    if (g.b.aWn().aWl()) {
      this.mio.add(new u(0));
    }
    AppMethodBeat.o(105531);
  }
  
  public final int getDataCount()
  {
    return this.miq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.c.b.e
 * JD-Core Version:    0.7.0.1
 */