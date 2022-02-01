package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.storage.w;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.bem;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mixItem", "Lcom/tencent/mm/plugin/finder/storage/FinderMixItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderMixItem;)V", "baseFinderFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getBaseFinderFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setBaseFinderFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "getMixItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderMixItem;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "toString", "", "plugin-finder_release"})
public final class c
  implements bu
{
  public BaseFinderFeed zzW;
  public final w zzX;
  
  public c(w paramw)
  {
    AppMethodBeat.i(288419);
    this.zzX = paramw;
    paramw = this.zzX.AlU;
    if (paramw != null) {
      c.a locala = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
    }
    for (paramw = c.a.a(paramw);; paramw = null)
    {
      this.zzW = paramw;
      AppMethodBeat.o(288419);
      return;
    }
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(288415);
    kotlin.g.b.p.k(paramk, "obj");
    if (!(paramk instanceof c)) {}
    for (Object localObject = null;; localObject = paramk)
    {
      if ((c)localObject != null)
      {
        localObject = this.zzX;
        paramk = ((c)paramk).zzX;
        kotlin.g.b.p.k(paramk, "otherItem");
        int i;
        aj localaj;
        boolean bool;
        if (paramk.AlW.dataType == ((w)localObject).AlW.dataType)
        {
          i = paramk.AlW.dataType;
          if (i == w.AlX)
          {
            localaj = aj.AGc;
            localObject = ((w)localObject).AlT;
            paramk = paramk.AlT;
            if ((localObject != null) && (paramk != null)) {
              if ((!Util.isNullOrNil(((com.tencent.mm.plugin.finder.storage.p)localObject).dYH())) && (kotlin.g.b.p.h(((com.tencent.mm.plugin.finder.storage.p)localObject).dYH(), paramk.dYH()))) {
                bool = true;
              }
            }
          }
        }
        while (bool)
        {
          AppMethodBeat.o(288415);
          return 0;
          bool = false;
          continue;
          bool = false;
          continue;
          if (i == w.AlY)
          {
            localaj = aj.AGc;
            localObject = ((w)localObject).AlU;
            paramk = paramk.AlU;
            if ((localObject != null) && (paramk != null))
            {
              if ((((FinderItem)localObject).field_id != 0L) && (paramk.field_id != 0L) && (((FinderItem)localObject).field_id == paramk.field_id))
              {
                bool = true;
                continue;
              }
              if ((((FinderItem)localObject).getLocalId() > 0L) && (paramk.getLocalId() > 0L) && (((FinderItem)localObject).getLocalId() == paramk.getLocalId())) {
                bool = true;
              }
            }
          }
          else if (i == w.AlZ)
          {
            localaj = aj.AGc;
            localObject = ((w)localObject).zzV;
            paramk = paramk.zzV;
            if ((localObject != null) && (paramk != null))
            {
              bool = ((x)localObject).a(paramk);
              continue;
            }
            bool = false;
            continue;
          }
          bool = false;
        }
      }
      AppMethodBeat.o(288415);
      return -1;
    }
  }
  
  public final int bAQ()
  {
    return this.zzX.viewType;
  }
  
  public final long mf()
  {
    return this.zzX.AlV;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(288417);
    String str = "ItemId=" + this.zzX.AlV + ",ItemType=" + this.zzX.viewType + ' ';
    AppMethodBeat.o(288417);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.c
 * JD-Core Version:    0.7.0.1
 */