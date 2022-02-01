package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.n;
import com.tencent.mm.emoji.panel.a.o;
import com.tencent.mm.emoji.panel.a.v;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.storage.emotion.u;
import d.a.ab;
import d.a.j;
import d.g.b.k;
import d.k.h;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/panel/SmileyItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "()V", "hasRecent", "", "getHasRecent", "()Z", "recentTitle", "Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "reportCount", "", "getReportCount", "plugin-emojisdk_release"})
public final class af
  extends a
{
  private int fNA;
  private final q fOE;
  public final boolean fOF;
  
  public af()
  {
    super(z.abW());
    AppMethodBeat.i(105583);
    this.fOE = new q(z.abV());
    Object localObject1 = g.ad(d.class);
    k.g(localObject1, "MMKernel.plugin(IPluginEmoji::class.java)");
    localObject1 = ((d)localObject1).getProvider();
    k.g(localObject1, "MMKernel.plugin(IPluginEmoji::class.java).provider");
    localObject1 = ((com.tencent.mm.pluginsdk.a.e)localObject1).bUL();
    if (localObject1 != null)
    {
      i = ((List)localObject1).size();
      i = Math.min(i, v.fQI.aqI);
      if (i <= 0) {
        break label201;
      }
    }
    Object localObject2;
    label201:
    for (boolean bool = true;; bool = false)
    {
      this.fOF = bool;
      if (i <= 0) {
        break label206;
      }
      this.fNy.add(this.fOE);
      this.fNA += i;
      localObject2 = ((Iterable)h.kJ(0, i)).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        i = ((ab)localObject2).nextInt();
        this.fNy.add(new ae(new n(((u)((List)localObject1).get(i)).key), true, i + 1));
      }
      i = 0;
      break;
    }
    label206:
    this.fNy.add(this.fNx);
    localObject1 = com.tencent.mm.cg.e.eHT();
    k.g(localObject1, "MergerSmileyManager.getInstance()");
    localObject1 = ((com.tencent.mm.cg.e)localObject1).eHU();
    this.fNA += ((List)localObject1).size();
    k.g(localObject1, "list");
    localObject1 = ((Iterable)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.fvx();
      }
      localObject2 = (SmileyPanelConfigInfo)localObject2;
      this.fNy.add(new ae(new n(((SmileyPanelConfigInfo)localObject2).field_key), false, i + 1));
      i += 1;
    }
    AppMethodBeat.o(105583);
  }
  
  public final int abI()
  {
    return this.fNA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.af
 * JD-Core Version:    0.7.0.1
 */