package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import d.a.ab;
import d.a.j;
import d.g.b.p;
import d.k.h;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/panel/SmileyItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "()V", "hasRecent", "", "getHasRecent", "()Z", "recentTitle", "Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "reportCount", "", "getReportCount", "plugin-emojisdk_release"})
public final class aj
  extends a
{
  private int gkL;
  private final u glT;
  public final boolean glU;
  
  public aj()
  {
    super(ad.afD());
    AppMethodBeat.i(105583);
    this.glT = new u(ad.afC());
    Object localObject1 = g.ad(d.class);
    p.g(localObject1, "MMKernel.plugin(IPluginEmoji::class.java)");
    localObject1 = ((d)localObject1).getProvider();
    p.g(localObject1, "MMKernel.plugin(IPluginEmoji::class.java).provider");
    localObject1 = ((com.tencent.mm.pluginsdk.a.e)localObject1).cgC();
    if (localObject1 != null)
    {
      i = ((List)localObject1).size();
      i = Math.min(i, com.tencent.mm.emoji.panel.a.v.gof.atv);
      if (i <= 0) {
        break label201;
      }
    }
    Object localObject2;
    label201:
    for (boolean bool = true;; bool = false)
    {
      this.glU = bool;
      if (i <= 0) {
        break label206;
      }
      this.gkJ.add(this.glT);
      this.gkL += i;
      localObject2 = ((Iterable)h.lo(0, i)).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        i = ((ab)localObject2).nextInt();
        this.gkJ.add(new ai(new com.tencent.mm.emoji.a.o(((com.tencent.mm.storage.emotion.v)((List)localObject1).get(i)).key), true, i + 1));
      }
      i = 0;
      break;
    }
    label206:
    this.gkJ.add(this.gkI);
    localObject1 = com.tencent.mm.cf.e.fmZ();
    p.g(localObject1, "MergerSmileyManager.getInstance()");
    localObject1 = ((com.tencent.mm.cf.e)localObject1).fna();
    this.gkL += ((List)localObject1).size();
    p.g(localObject1, "list");
    localObject1 = ((Iterable)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.gfB();
      }
      localObject2 = (SmileyPanelConfigInfo)localObject2;
      this.gkJ.add(new ai(new com.tencent.mm.emoji.a.o(((SmileyPanelConfigInfo)localObject2).field_key), false, i + 1));
      i += 1;
    }
    AppMethodBeat.o(105583);
  }
  
  public final int afm()
  {
    return this.gkL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.aj
 * JD-Core Version:    0.7.0.1
 */