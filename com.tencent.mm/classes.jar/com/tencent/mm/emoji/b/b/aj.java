package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.storage.emotion.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.ab;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/panel/SmileyItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "recentMaxCount", "", "(I)V", "hasRecent", "", "getHasRecent", "()Z", "recentTitle", "Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "reportCount", "getReportCount", "plugin-emojisdk_release"})
public final class aj
  extends a
{
  private int gXY;
  private final u gZi;
  public final boolean gZj;
  
  public aj(int paramInt)
  {
    super(ad.avF());
    AppMethodBeat.i(199926);
    this.gZi = new u(ad.avE());
    Object localObject1 = g.ah(d.class);
    kotlin.g.b.p.g(localObject1, "MMKernel.plugin(IPluginEmoji::class.java)");
    localObject1 = ((d)localObject1).getProvider();
    kotlin.g.b.p.g(localObject1, "MMKernel.plugin(IPluginEmoji::class.java).provider");
    localObject1 = ((com.tencent.mm.pluginsdk.a.e)localObject1).cFQ();
    int i;
    if (localObject1 != null)
    {
      i = ((List)localObject1).size();
      paramInt = Math.min(i, paramInt);
      if (paramInt <= 0) {
        break label206;
      }
    }
    Object localObject2;
    label206:
    for (boolean bool = true;; bool = false)
    {
      this.gZj = bool;
      if (paramInt <= 0) {
        break label211;
      }
      this.gXW.add(this.gZi);
      this.gXY += paramInt;
      localObject2 = ((Iterable)kotlin.k.j.mY(0, paramInt)).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramInt = ((ab)localObject2).nextInt();
        this.gXW.add(new ai(new com.tencent.mm.emoji.b.p(((v)((List)localObject1).get(paramInt)).key), true, paramInt + 1));
      }
      i = 0;
      break;
    }
    label211:
    this.gXW.add(this.gXV);
    localObject1 = com.tencent.mm.ce.e.gxR();
    kotlin.g.b.p.g(localObject1, "MergerSmileyManager.getInstance()");
    localObject1 = ((com.tencent.mm.ce.e)localObject1).gxS();
    this.gXY += ((List)localObject1).size();
    kotlin.g.b.p.g(localObject1, "list");
    localObject1 = ((Iterable)localObject1).iterator();
    paramInt = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (paramInt < 0) {
        kotlin.a.j.hxH();
      }
      localObject2 = (SmileyPanelConfigInfo)localObject2;
      this.gXW.add(new ai(new com.tencent.mm.emoji.b.p(((SmileyPanelConfigInfo)localObject2).field_key), false, paramInt + 1));
      paramInt += 1;
    }
    AppMethodBeat.o(199926);
  }
  
  public final int avo()
  {
    return this.gXY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.aj
 * JD-Core Version:    0.7.0.1
 */