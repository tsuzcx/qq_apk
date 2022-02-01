package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.j;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.storage.o;
import com.tencent.mm.protocal.protobuf.amd;
import com.tencent.mm.protocal.protobuf.ame;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.view.recyclerview.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "mixItem", "Lcom/tencent/mm/plugin/finder/storage/FinderMixItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderMixItem;)V", "baseFinderFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getBaseFinderFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setBaseFinderFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "getMixItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderMixItem;", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class b
  implements h, a
{
  public BaseFinderFeed rux;
  public final com.tencent.mm.plugin.finder.storage.n ruy;
  
  public b(com.tencent.mm.plugin.finder.storage.n paramn)
  {
    AppMethodBeat.i(202545);
    this.ruy = paramn;
    paramn = this.ruy.rEg;
    if (paramn != null) {
      b.a locala = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
    }
    for (paramn = b.a.i(paramn);; paramn = null)
    {
      this.rux = paramn;
      AppMethodBeat.o(202545);
      return;
    }
  }
  
  public final int a(h paramh)
  {
    AppMethodBeat.i(202544);
    k.h(paramh, "obj");
    if (!(paramh instanceof b)) {}
    for (Object localObject = null;; localObject = paramh)
    {
      if ((b)localObject != null)
      {
        localObject = this.ruy;
        paramh = ((b)paramh).ruy;
        k.h(paramh, "otherItem");
        int i;
        com.tencent.mm.plugin.finder.utils.n localn;
        if (paramh.rEj.dataType == ((com.tencent.mm.plugin.finder.storage.n)localObject).rEj.dataType)
        {
          i = paramh.rEj.dataType;
          if (i == com.tencent.mm.plugin.finder.storage.n.rEk)
          {
            localn = com.tencent.mm.plugin.finder.utils.n.rPN;
            localObject = ((com.tencent.mm.plugin.finder.storage.n)localObject).rEf;
            paramh = paramh.rEf;
            if ((localObject != null) && (paramh != null)) {
              if ((!bs.isNullOrNil(((j)localObject).cAA())) && (k.g(((j)localObject).cAA(), paramh.cAA()))) {
                i = 1;
              }
            }
          }
        }
        while (i != 0)
        {
          AppMethodBeat.o(202544);
          return 0;
          i = 0;
          continue;
          i = 0;
          continue;
          if (i == com.tencent.mm.plugin.finder.storage.n.rEl)
          {
            localn = com.tencent.mm.plugin.finder.utils.n.rPN;
            localObject = ((com.tencent.mm.plugin.finder.storage.n)localObject).rEg;
            paramh = paramh.rEg;
            if ((localObject != null) && (paramh != null))
            {
              if ((((FinderItem)localObject).getMediaType() == 9999) && (paramh.getMediaType() == 9999))
              {
                i = 1;
                continue;
              }
              if ((((FinderItem)localObject).field_id != 0L) && (paramh.field_id != 0L) && (((FinderItem)localObject).field_id == paramh.field_id))
              {
                i = 1;
                continue;
              }
              if ((((FinderItem)localObject).getLocalId() > 0L) && (paramh.getLocalId() > 0L) && (((FinderItem)localObject).getLocalId() == paramh.getLocalId())) {
                i = 1;
              }
            }
          }
          else if (i == com.tencent.mm.plugin.finder.storage.n.rEm)
          {
            localn = com.tencent.mm.plugin.finder.utils.n.rPN;
            localObject = ((com.tencent.mm.plugin.finder.storage.n)localObject).rEh;
            paramh = paramh.rEh;
            if ((localObject != null) && (paramh != null))
            {
              k.h(paramh, "other");
              if ((((o)localObject).rEo.EFD == paramh.rEo.EFD) && (!bs.isNullOrNil(((o)localObject).getWording())) && (k.g(((o)localObject).getWording(), paramh.getWording())))
              {
                i = 1;
                continue;
              }
              i = 0;
              continue;
            }
            i = 0;
            continue;
          }
          i = 0;
        }
      }
      AppMethodBeat.o(202544);
      return -1;
    }
  }
  
  public final int bTF()
  {
    return this.ruy.oeH;
  }
  
  public final long lx()
  {
    return this.ruy.rEi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.b
 * JD-Core Version:    0.7.0.1
 */