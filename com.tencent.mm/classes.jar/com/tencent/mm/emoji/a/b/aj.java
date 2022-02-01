package com.tencent.mm.emoji.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import d.a.ab;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/panel/SmileyItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "()V", "hasRecent", "", "getHasRecent", "()Z", "recentTitle", "Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "reportCount", "", "getReportCount", "plugin-emojisdk_release"})
public final class aj
  extends a
{
  private int gng;
  private final u goo;
  public final boolean goq;
  
  public aj()
  {
    super(ad.afR());
    AppMethodBeat.i(105583);
    this.goo = new u(ad.afQ());
    Object localObject1 = g.ad(d.class);
    p.g(localObject1, "MMKernel.plugin(IPluginEmoji::class.java)");
    localObject1 = ((d)localObject1).getProvider();
    p.g(localObject1, "MMKernel.plugin(IPluginEmoji::class.java).provider");
    localObject1 = ((com.tencent.mm.pluginsdk.a.e)localObject1).chS();
    if (localObject1 != null)
    {
      i = ((List)localObject1).size();
      i = Math.min(i, com.tencent.mm.emoji.panel.a.v.gqB.atv);
      if (i <= 0) {
        break label201;
      }
    }
    Object localObject2;
    label201:
    for (boolean bool = true;; bool = false)
    {
      this.goq = bool;
      if (i <= 0) {
        break label206;
      }
      this.gne.add(this.goo);
      this.gng += i;
      localObject2 = ((Iterable)d.k.j.lv(0, i)).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        i = ((ab)localObject2).nextInt();
        this.gne.add(new ai(new com.tencent.mm.emoji.a.o(((com.tencent.mm.storage.emotion.v)((List)localObject1).get(i)).key), true, i + 1));
      }
      i = 0;
      break;
    }
    label206:
    this.gne.add(this.gnd);
    localObject1 = com.tencent.mm.ce.e.fqT();
    p.g(localObject1, "MergerSmileyManager.getInstance()");
    localObject1 = ((com.tencent.mm.ce.e)localObject1).fqU();
    this.gng += ((List)localObject1).size();
    p.g(localObject1, "list");
    localObject1 = ((Iterable)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        d.a.j.gkd();
      }
      localObject2 = (SmileyPanelConfigInfo)localObject2;
      this.gne.add(new ai(new com.tencent.mm.emoji.a.o(((SmileyPanelConfigInfo)localObject2).field_key), false, i + 1));
      i += 1;
    }
    AppMethodBeat.o(105583);
  }
  
  public final int afA()
  {
    return this.gng;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.aj
 * JD-Core Version:    0.7.0.1
 */