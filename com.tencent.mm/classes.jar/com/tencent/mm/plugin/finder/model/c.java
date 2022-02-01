package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.aa;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.storage.o;
import com.tencent.mm.plugin.finder.storage.z;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.ayr;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mixItem", "Lcom/tencent/mm/plugin/finder/storage/FinderMixItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderMixItem;)V", "baseFinderFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getBaseFinderFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setBaseFinderFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "getMixItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderMixItem;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "toString", "", "plugin-finder_release"})
public final class c
  implements bo
{
  public BaseFinderFeed uNI;
  public final z uNJ;
  
  public c(z paramz)
  {
    AppMethodBeat.i(248695);
    this.uNJ = paramz;
    paramz = this.uNJ.vEG;
    if (paramz != null) {
      c.a locala = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
    }
    for (paramz = c.a.s(paramz);; paramz = null)
    {
      this.uNI = paramz;
      AppMethodBeat.o(248695);
      return;
    }
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(248693);
    p.h(parami, "obj");
    if (!(parami instanceof c)) {}
    for (Object localObject = null;; localObject = parami)
    {
      if ((c)localObject != null)
      {
        localObject = this.uNJ;
        parami = ((c)parami).uNJ;
        p.h(parami, "otherItem");
        int i;
        y localy;
        boolean bool;
        if (parami.vEI.dataType == ((z)localObject).vEI.dataType)
        {
          i = parami.vEI.dataType;
          if (i == z.vEJ)
          {
            localy = y.vXH;
            localObject = ((z)localObject).vEF;
            parami = parami.vEF;
            if ((localObject != null) && (parami != null)) {
              if ((!Util.isNullOrNil(((o)localObject).dxF())) && (p.j(((o)localObject).dxF(), parami.dxF()))) {
                bool = true;
              }
            }
          }
        }
        while (bool)
        {
          AppMethodBeat.o(248693);
          return 0;
          bool = false;
          continue;
          bool = false;
          continue;
          if (i == z.vEK)
          {
            localy = y.vXH;
            localObject = ((z)localObject).vEG;
            parami = parami.vEG;
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
          else if (i == z.vEL)
          {
            localy = y.vXH;
            localObject = ((z)localObject).uNH;
            parami = parami.uNH;
            if ((localObject != null) && (parami != null))
            {
              bool = ((aa)localObject).a(parami);
              continue;
            }
            bool = false;
            continue;
          }
          bool = false;
        }
      }
      AppMethodBeat.o(248693);
      return -1;
    }
  }
  
  public final int cxn()
  {
    return this.uNJ.qcr;
  }
  
  public final long lT()
  {
    return this.uNJ.vEH;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(248694);
    String str = "ItemId=" + this.uNJ.vEH + ",ItemType=" + this.uNJ.qcr + ' ';
    AppMethodBeat.o(248694);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.c
 * JD-Core Version:    0.7.0.1
 */