package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ae;
import com.tencent.mm.emoji.b.b.af;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.emoji.b.b.u;
import com.tencent.mm.emoji.b.b.y;
import com.tencent.mm.emoji.b.k;
import com.tencent.mm.emoji.sync.g;
import com.tencent.mm.emoji.sync.g.b;
import com.tencent.mm.emoji.sync.j;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emoji/model/EmojiCaptureItemGroup;", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "()V", "contentList", "", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "dataCount", "", "getDataCount", "getGroupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "getItemList", "", "plugin-emoji_release"})
public final class f
  implements y
{
  private final List<ae> lYY;
  private final int uEg;
  
  public f()
  {
    AppMethodBeat.i(256581);
    this.lYY = ((List)new LinkedList());
    Object localObject1 = k.aBH().es(false);
    Object localObject2;
    label94:
    List localList;
    if (localObject1 != null)
    {
      localObject1 = (List)localObject1;
      this.uEg = ((List)localObject1).size();
      localObject2 = g.jOs;
      int j = g.b.aDs().aDj();
      localObject2 = g.jOs;
      int k = g.b.aDs().aDk();
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
      localList = this.lYY;
      p.j(localObject2, "info");
      localList.add(new h((EmojiInfo)localObject2, 3));
    }
    for (;;)
    {
      i += 1;
      break label94;
      localObject1 = (List)v.aaAd;
      break;
      label175:
      localList = this.lYY;
      p.j(localObject2, "info");
      localList.add(new h((EmojiInfo)localObject2, 1));
    }
    label209:
    localObject1 = g.jOs;
    if (g.b.aDs().aDl()) {
      this.lYY.add(new u(1));
    }
    AppMethodBeat.o(256581);
  }
  
  public final EmojiGroupInfo aCi()
  {
    AppMethodBeat.i(256576);
    EmojiGroupInfo localEmojiGroupInfo = af.aCC();
    AppMethodBeat.o(256576);
    return localEmojiGroupInfo;
  }
  
  public final List<ae> aCj()
  {
    return this.lYY;
  }
  
  public final int getDataCount()
  {
    return this.uEg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.f
 * JD-Core Version:    0.7.0.1
 */