package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.a.j;
import d.a.v;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/panel/CaptureItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "hasEntrance", "", "(Z)V", "emojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "kotlin.jvm.PlatformType", "reportCount", "", "getReportCount", "plugin-emojisdk_release"})
public final class c
  extends a
{
  private final List<EmojiInfo> gkK;
  private int gkL;
  
  public c(boolean paramBoolean)
  {
    super(ad.afF());
    AppMethodBeat.i(105526);
    Object localObject1 = i.aeL().dk(true);
    if (localObject1 != null) {}
    for (localObject1 = (List)localObject1;; localObject1 = (List)v.MKE)
    {
      this.gkK = ((List)localObject1);
      this.gkL = this.gkK.size();
      if (!this.gkK.isEmpty()) {
        break;
      }
      if (!paramBoolean) {
        break label228;
      }
      this.gkJ.add(new b());
      AppMethodBeat.o(105526);
      return;
    }
    this.gkJ.add(this.gkI);
    if (paramBoolean) {
      this.gkJ.add(new m(1));
    }
    localObject1 = this.gkJ;
    Object localObject2 = (Iterable)this.gkK;
    Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
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
  
  public final int afm()
  {
    return this.gkL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.c
 * JD-Core Version:    0.7.0.1
 */