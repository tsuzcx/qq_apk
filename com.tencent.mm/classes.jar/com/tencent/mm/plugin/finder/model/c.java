package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.b;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.sdk.platformtools.bu;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mixItem", "Lcom/tencent/mm/plugin/finder/storage/FinderMixItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderMixItem;)V", "baseFinderFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getBaseFinderFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setBaseFinderFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "getMixItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderMixItem;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "toString", "", "plugin-finder_release"})
public final class c
  implements am
{
  public BaseFinderFeed ssN;
  public final t ssO;
  
  public c(t paramt)
  {
    AppMethodBeat.i(203419);
    this.ssO = paramt;
    paramt = this.ssO.sJL;
    if (paramt != null) {
      b.a locala = b.sLq;
    }
    for (paramt = b.a.j(paramt);; paramt = null)
    {
      this.ssN = paramt;
      AppMethodBeat.o(203419);
      return;
    }
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(203417);
    d.g.b.p.h(parami, "obj");
    if (!(parami instanceof c)) {}
    for (Object localObject = null;; localObject = parami)
    {
      if ((c)localObject != null)
      {
        localObject = this.ssO;
        parami = ((c)parami).ssO;
        d.g.b.p.h(parami, "otherItem");
        int i;
        com.tencent.mm.plugin.finder.utils.p localp;
        boolean bool;
        if (parami.sJN.dataType == ((t)localObject).sJN.dataType)
        {
          i = parami.sJN.dataType;
          if (i == t.sJO)
          {
            localp = com.tencent.mm.plugin.finder.utils.p.sXz;
            localObject = ((t)localObject).sJK;
            parami = parami.sJK;
            if ((localObject != null) && (parami != null)) {
              if ((!bu.isNullOrNil(((m)localObject).cLa())) && (d.g.b.p.i(((m)localObject).cLa(), parami.cLa()))) {
                bool = true;
              }
            }
          }
        }
        while (bool)
        {
          AppMethodBeat.o(203417);
          return 0;
          bool = false;
          continue;
          bool = false;
          continue;
          if (i == t.sJP)
          {
            localp = com.tencent.mm.plugin.finder.utils.p.sXz;
            localObject = ((t)localObject).sJL;
            parami = parami.sJL;
            if ((localObject != null) && (parami != null))
            {
              if ((((FinderItem)localObject).field_id != 0L) && (parami.field_id != 0L) && (((FinderItem)localObject).field_id == parami.field_id))
              {
                bool = true;
                continue;
              }
              if ((((FinderItem)localObject).getLocalId() > 0L) && (parami.getLocalId() > 0L) && (((FinderItem)localObject).getLocalId() == parami.getLocalId())) {
                bool = true;
              }
            }
          }
          else if (i == t.sJQ)
          {
            localp = com.tencent.mm.plugin.finder.utils.p.sXz;
            localObject = ((t)localObject).ssM;
            parami = parami.ssM;
            if ((localObject != null) && (parami != null))
            {
              bool = ((u)localObject).a(parami);
              continue;
            }
            bool = false;
            continue;
          }
          bool = false;
        }
      }
      AppMethodBeat.o(203417);
      return -1;
    }
  }
  
  public final int bZz()
  {
    return this.ssO.oOD;
  }
  
  public final long lP()
  {
    return this.ssO.sJM;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203418);
    String str = "ItemId=" + this.ssO.sJM + ",ItemType=" + this.ssO.oOD + ' ';
    AppMethodBeat.o(203418);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.c
 * JD-Core Version:    0.7.0.1
 */