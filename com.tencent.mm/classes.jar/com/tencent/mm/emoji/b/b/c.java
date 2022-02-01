package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/panel/CaptureItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "hasEntrance", "", "(Z)V", "emojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "kotlin.jvm.PlatformType", "reportCount", "", "getReportCount", "plugin-emojisdk_release"})
public final class c
  extends a
{
  private final List<EmojiInfo> gXX;
  private int gXY;
  
  public c(boolean paramBoolean)
  {
    super(ad.avH());
    AppMethodBeat.i(105526);
    Object localObject1 = com.tencent.mm.emoji.b.j.auL().dU(true);
    if (localObject1 != null) {}
    for (localObject1 = (List)localObject1;; localObject1 = (List)v.SXr)
    {
      this.gXX = ((List)localObject1);
      this.gXY = this.gXX.size();
      if (!this.gXX.isEmpty()) {
        break;
      }
      if (!paramBoolean) {
        break label228;
      }
      this.gXW.add(new b());
      AppMethodBeat.o(105526);
      return;
    }
    this.gXW.add(this.gXV);
    if (paramBoolean) {
      this.gXW.add(new m(1));
    }
    localObject1 = this.gXW;
    Object localObject2 = (Iterable)this.gXX;
    Collection localCollection = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      EmojiInfo localEmojiInfo = (EmojiInfo)((Iterator)localObject2).next();
      p.g(localEmojiInfo, "it");
      localCollection.add(new h(localEmojiInfo, 1));
    }
    ((LinkedList)localObject1).addAll((Collection)localCollection);
    label228:
    AppMethodBeat.o(105526);
  }
  
  public final int avo()
  {
    return this.gXY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.c
 * JD-Core Version:    0.7.0.1
 */