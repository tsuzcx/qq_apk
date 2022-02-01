package com.tencent.mm.emoji.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.c.d;
import com.tencent.mm.pluginsdk.b.e;
import com.tencent.mm.smiley.o;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.storage.emotion.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ah;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/panel/SmileyItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "recentMaxCount", "", "(I)V", "hasRecent", "", "getHasRecent", "()Z", "recentTitle", "Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "reportCount", "getDataCount", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class al
  extends a
{
  private int miq;
  public final boolean mjA;
  private final w mjz;
  
  public al(int paramInt)
  {
    super(af.aVx());
    AppMethodBeat.i(242702);
    this.mjz = new w(af.aVw());
    Object localObject1 = ((d)h.az(d.class)).getProvider().dzE();
    int i;
    if (localObject1 == null)
    {
      i = 0;
      paramInt = Math.min(i, paramInt);
      if (paramInt <= 0) {
        break label184;
      }
    }
    Object localObject2;
    label184:
    for (boolean bool = true;; bool = false)
    {
      this.mjA = bool;
      if (paramInt <= 0) {
        break label189;
      }
      this.mio.add(this.mjz);
      this.miq += paramInt;
      localObject2 = ((Iterable)k.qt(0, paramInt)).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramInt = ((ah)localObject2).Zo();
        this.mio.add(new ak(new q(((x)((List)localObject1).get(paramInt)).key), true, paramInt + 1));
      }
      i = ((List)localObject1).size();
      break;
    }
    label189:
    this.mio.add(aVd());
    localObject1 = o.iVl().iVm();
    this.miq += ((List)localObject1).size();
    s.s(localObject1, "list");
    localObject1 = ((Iterable)localObject1).iterator();
    paramInt = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (paramInt < 0) {
        p.kkW();
      }
      localObject2 = (SmileyPanelConfigInfo)localObject2;
      this.mio.add(new ak(new q(((SmileyPanelConfigInfo)localObject2).field_key), false, paramInt + 1));
      paramInt += 1;
    }
    AppMethodBeat.o(242702);
  }
  
  public final int getDataCount()
  {
    return this.miq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.c.b.al
 * JD-Core Version:    0.7.0.1
 */