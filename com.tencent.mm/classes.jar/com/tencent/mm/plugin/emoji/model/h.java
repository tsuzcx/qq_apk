package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ae;
import com.tencent.mm.emoji.b.b.af;
import com.tencent.mm.emoji.b.b.m;
import com.tencent.mm.emoji.b.b.u;
import com.tencent.mm.emoji.b.b.y;
import com.tencent.mm.emoji.b.k;
import com.tencent.mm.emoji.sync.g;
import com.tencent.mm.emoji.sync.g.b;
import com.tencent.mm.emoji.sync.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emoji/model/EmojiCustomItemGroup;", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "hasEntrance", "", "(Z)V", "TAG", "", "contentList", "", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "dataCount", "", "getDataCount", "getGroupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "getItemList", "", "plugin-emoji_release"})
public final class h
  implements y
{
  private final String TAG;
  private final List<ae> lYY;
  private int uEg;
  
  public h(boolean paramBoolean)
  {
    AppMethodBeat.i(256434);
    this.TAG = "MicroMsg.EmojiCustomItem";
    this.lYY = ((List)new LinkedList());
    Object localObject1 = k.aBH().aBK();
    if (localObject1 != null) {}
    Object localObject2;
    int j;
    int k;
    int i;
    for (localObject1 = (List)localObject1;; localObject1 = (List)v.aaAd)
    {
      this.uEg = ((List)localObject1).size();
      if (paramBoolean) {
        this.lYY.add(new m(0));
      }
      localObject2 = g.jOs;
      j = g.b.aDr().aDj();
      localObject2 = g.jOs;
      k = g.b.aDr().aDk();
      Log.i(this.TAG, "sync: " + j + ", " + k);
      localObject1 = ((List)localObject1).iterator();
      i = 0;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label295;
        }
        localObject2 = (EmojiInfo)((Iterator)localObject1).next();
        if (((EmojiInfo)localObject2).field_catalog != EmojiGroupInfo.YCv) {
          break;
        }
        this.uEg -= 1;
      }
    }
    if (i < k)
    {
      List localList;
      if (i >= j)
      {
        localList = this.lYY;
        p.j(localObject2, "info");
        localList.add(new com.tencent.mm.emoji.b.b.h((EmojiInfo)localObject2, 3));
      }
      for (;;)
      {
        i += 1;
        break;
        localList = this.lYY;
        p.j(localObject2, "info");
        localList.add(new com.tencent.mm.emoji.b.b.h((EmojiInfo)localObject2, 0));
      }
    }
    label295:
    localObject1 = g.jOs;
    if (g.b.aDr().aDl()) {
      this.lYY.add(new u(0));
    }
    AppMethodBeat.o(256434);
  }
  
  public final EmojiGroupInfo aCi()
  {
    AppMethodBeat.i(256425);
    EmojiGroupInfo localEmojiGroupInfo = af.aCB();
    AppMethodBeat.o(256425);
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
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.h
 * JD-Core Version:    0.7.0.1
 */