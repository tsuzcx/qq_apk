package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b.ae;
import com.tencent.mm.emoji.c.b.af;
import com.tencent.mm.emoji.c.b.m;
import com.tencent.mm.emoji.c.b.u;
import com.tencent.mm.emoji.c.b.y;
import com.tencent.mm.emoji.c.l;
import com.tencent.mm.emoji.sync.g;
import com.tencent.mm.emoji.sync.g.b;
import com.tencent.mm.emoji.sync.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/model/EmojiCustomItemGroup;", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "hasEntrance", "", "(Z)V", "TAG", "", "contentList", "", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "dataCount", "", "getDataCount", "getGroupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "getItemList", "", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements y
{
  private final String TAG;
  private final List<ae> oSh;
  private int xMx;
  
  public h(boolean paramBoolean)
  {
    AppMethodBeat.i(269859);
    this.TAG = "MicroMsg.EmojiCustomItem";
    this.oSh = ((List)new LinkedList());
    Object localObject1 = l.aUF().aUG();
    if (localObject1 == null) {}
    Object localObject2;
    int j;
    int k;
    int i;
    for (localObject1 = (List)ab.aivy;; localObject1 = (List)localObject1)
    {
      this.xMx = ((List)localObject1).size();
      if (paramBoolean) {
        this.oSh.add(new m(0));
      }
      localObject2 = g.mmX;
      j = g.b.aWn().aWj();
      localObject2 = g.mmX;
      k = g.b.aWn().aWk();
      Log.i(this.TAG, "sync: " + j + ", " + k);
      localObject1 = ((List)localObject1).iterator();
      i = 0;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label295;
        }
        localObject2 = (EmojiInfo)((Iterator)localObject1).next();
        if (((EmojiInfo)localObject2).field_catalog != EmojiGroupInfo.aklE) {
          break;
        }
        this.xMx -= 1;
      }
    }
    if (i < k)
    {
      List localList;
      if (i >= j)
      {
        localList = this.oSh;
        s.s(localObject2, "info");
        localList.add(new com.tencent.mm.emoji.c.b.h((EmojiInfo)localObject2, 3));
      }
      for (;;)
      {
        i += 1;
        break;
        localList = this.oSh;
        s.s(localObject2, "info");
        localList.add(new com.tencent.mm.emoji.c.b.h((EmojiInfo)localObject2, 0));
      }
    }
    label295:
    localObject1 = g.mmX;
    if (g.b.aWn().aWl()) {
      this.oSh.add(new u(0));
    }
    AppMethodBeat.o(269859);
  }
  
  public final EmojiGroupInfo aVe()
  {
    AppMethodBeat.i(269862);
    EmojiGroupInfo localEmojiGroupInfo = af.aVy();
    AppMethodBeat.o(269862);
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
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.h
 * JD-Core Version:    0.7.0.1
 */