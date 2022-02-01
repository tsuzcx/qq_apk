package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b.ae;
import com.tencent.mm.emoji.c.b.af;
import com.tencent.mm.emoji.c.b.h;
import com.tencent.mm.emoji.c.b.u;
import com.tencent.mm.emoji.c.b.y;
import com.tencent.mm.emoji.c.l;
import com.tencent.mm.emoji.sync.g;
import com.tencent.mm.emoji.sync.g.b;
import com.tencent.mm.emoji.sync.j;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/model/EmojiCaptureItemGroup;", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "()V", "contentList", "", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "dataCount", "", "getDataCount", "getGroupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "getItemList", "", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements y
{
  private final List<ae> oSh;
  private final int xMx;
  
  public f()
  {
    AppMethodBeat.i(269858);
    this.oSh = ((List)new LinkedList());
    Object localObject1 = l.aUF().fe(false);
    Object localObject2;
    label95:
    List localList;
    if (localObject1 == null)
    {
      localObject1 = (List)ab.aivy;
      this.xMx = ((List)localObject1).size();
      localObject2 = g.mmX;
      int j = g.b.aWo().aWj();
      localObject2 = g.mmX;
      int k = g.b.aWo().aWk();
      localObject1 = ((List)localObject1).iterator();
      if (!((Iterator)localObject1).hasNext()) {
        break label209;
      }
      localObject2 = (EmojiInfo)((Iterator)localObject1).next();
      if (i >= k) {
        break label209;
      }
      if (i < j) {
        break label175;
      }
      localList = this.oSh;
      s.s(localObject2, "info");
      localList.add(new h((EmojiInfo)localObject2, 3));
    }
    for (;;)
    {
      i += 1;
      break label95;
      localObject1 = (List)localObject1;
      break;
      label175:
      localList = this.oSh;
      s.s(localObject2, "info");
      localList.add(new h((EmojiInfo)localObject2, 1));
    }
    label209:
    localObject1 = g.mmX;
    if (g.b.aWo().aWl()) {
      this.oSh.add(new u(1));
    }
    AppMethodBeat.o(269858);
  }
  
  public final EmojiGroupInfo aVe()
  {
    AppMethodBeat.i(269861);
    EmojiGroupInfo localEmojiGroupInfo = af.aVz();
    AppMethodBeat.o(269861);
    return localEmojiGroupInfo;
  }
  
  public final List<ae> aVf()
  {
    return this.oSh;
  }
  
  public final int getDataCount()
  {
    return this.xMx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.f
 * JD-Core Version:    0.7.0.1
 */