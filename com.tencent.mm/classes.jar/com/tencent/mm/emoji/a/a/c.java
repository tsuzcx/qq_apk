package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.a.j;
import d.a.v;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/panel/CaptureItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "hasEntrance", "", "(Z)V", "emojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "kotlin.jvm.PlatformType", "reportCount", "", "getReportCount", "plugin-emojisdk_release"})
public final class c
  extends a
{
  private final List<EmojiInfo> fRk;
  private int fRl;
  
  public c(boolean paramBoolean)
  {
    super(z.acY());
    AppMethodBeat.i(105526);
    Object localObject1 = i.ach().di(true);
    if (localObject1 != null) {}
    for (localObject1 = (List)localObject1;; localObject1 = (List)v.KTF)
    {
      this.fRk = ((List)localObject1);
      this.fRl = this.fRk.size();
      if (!this.fRk.isEmpty()) {
        break;
      }
      if (!paramBoolean) {
        break label228;
      }
      this.fRj.add(new b());
      AppMethodBeat.o(105526);
      return;
    }
    this.fRj.add(this.fRi);
    if (paramBoolean) {
      this.fRj.add(new m(1));
    }
    localObject1 = this.fRj;
    Object localObject2 = (Iterable)this.fRk;
    Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      EmojiInfo localEmojiInfo = (EmojiInfo)((Iterator)localObject2).next();
      k.g(localEmojiInfo, "it");
      localCollection.add(new h(localEmojiInfo, 1));
    }
    ((LinkedList)localObject1).addAll((Collection)localCollection);
    label228:
    AppMethodBeat.o(105526);
  }
  
  public final int acI()
  {
    return this.fRl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.c
 * JD-Core Version:    0.7.0.1
 */