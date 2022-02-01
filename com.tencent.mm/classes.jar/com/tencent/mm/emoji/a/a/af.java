package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import d.a.ab;
import d.a.j;
import d.g.b.k;
import d.k.h;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/panel/SmileyItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "()V", "hasRecent", "", "getHasRecent", "()Z", "recentTitle", "Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "reportCount", "", "getReportCount", "plugin-emojisdk_release"})
public final class af
  extends a
{
  private int fRl;
  private final q fSp;
  public final boolean fSq;
  
  public af()
  {
    super(z.acW());
    AppMethodBeat.i(105583);
    this.fSp = new q(z.acV());
    Object localObject1 = g.ad(d.class);
    k.g(localObject1, "MMKernel.plugin(IPluginEmoji::class.java)");
    localObject1 = ((d)localObject1).getProvider();
    k.g(localObject1, "MMKernel.plugin(IPluginEmoji::class.java).provider");
    localObject1 = ((com.tencent.mm.pluginsdk.a.e)localObject1).cbY();
    if (localObject1 != null)
    {
      i = ((List)localObject1).size();
      i = Math.min(i, com.tencent.mm.emoji.panel.a.v.fUD.arE);
      if (i <= 0) {
        break label201;
      }
    }
    Object localObject2;
    label201:
    for (boolean bool = true;; bool = false)
    {
      this.fSq = bool;
      if (i <= 0) {
        break label206;
      }
      this.fRj.add(this.fSp);
      this.fRl += i;
      localObject2 = ((Iterable)h.kZ(0, i)).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        i = ((ab)localObject2).nextInt();
        this.fRj.add(new ae(new com.tencent.mm.emoji.a.o(((com.tencent.mm.storage.emotion.v)((List)localObject1).get(i)).key), true, i + 1));
      }
      i = 0;
      break;
    }
    label206:
    this.fRj.add(this.fRi);
    localObject1 = com.tencent.mm.cf.e.eXp();
    k.g(localObject1, "MergerSmileyManager.getInstance()");
    localObject1 = ((com.tencent.mm.cf.e)localObject1).eXq();
    this.fRl += ((List)localObject1).size();
    k.g(localObject1, "list");
    localObject1 = ((Iterable)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.fOc();
      }
      localObject2 = (SmileyPanelConfigInfo)localObject2;
      this.fRj.add(new ae(new com.tencent.mm.emoji.a.o(((SmileyPanelConfigInfo)localObject2).field_key), false, i + 1));
      i += 1;
    }
    AppMethodBeat.o(105583);
  }
  
  public final int acI()
  {
    return this.fRl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.af
 * JD-Core Version:    0.7.0.1
 */