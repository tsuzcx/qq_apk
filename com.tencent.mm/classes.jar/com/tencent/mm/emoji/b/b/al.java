package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cl.f;
import com.tencent.mm.emoji.b.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.b.e;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.storage.emotion.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.ab;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/panel/SmileyItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "recentMaxCount", "", "(I)V", "hasRecent", "", "getHasRecent", "()Z", "recentTitle", "Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "reportCount", "getDataCount", "plugin-emojisdk_release"})
public final class al
  extends a
{
  private int jIY;
  private final w jKj;
  public final boolean jKk;
  
  public al(int paramInt)
  {
    super(af.aCA());
    AppMethodBeat.i(224556);
    this.jKj = new w(af.aCz());
    Object localObject1 = h.ag(d.class);
    p.j(localObject1, "MMKernel.plugin(IPluginEmoji::class.java)");
    localObject1 = ((d)localObject1).getProvider();
    p.j(localObject1, "MMKernel.plugin(IPluginEmoji::class.java).provider");
    localObject1 = ((e)localObject1).cUx();
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
      this.jKk = bool;
      if (paramInt <= 0) {
        break label211;
      }
      this.jIW.add(this.jKj);
      this.jIY += paramInt;
      localObject2 = ((Iterable)i.ou(0, paramInt)).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramInt = ((ab)localObject2).zD();
        this.jIW.add(new ak(new q(((v)((List)localObject1).get(paramInt)).key), true, paramInt + 1));
      }
      i = 0;
      break;
    }
    label211:
    this.jIW.add(aCh());
    localObject1 = f.htQ();
    p.j(localObject1, "MergerSmileyManager.getInstance()");
    localObject1 = ((f)localObject1).htR();
    this.jIY += ((List)localObject1).size();
    p.j(localObject1, "list");
    localObject1 = ((Iterable)localObject1).iterator();
    paramInt = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (paramInt < 0) {
        j.iBO();
      }
      localObject2 = (SmileyPanelConfigInfo)localObject2;
      this.jIW.add(new ak(new q(((SmileyPanelConfigInfo)localObject2).field_key), false, paramInt + 1));
      paramInt += 1;
    }
    AppMethodBeat.o(224556);
  }
  
  public final int getDataCount()
  {
    return this.jIY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.al
 * JD-Core Version:    0.7.0.1
 */