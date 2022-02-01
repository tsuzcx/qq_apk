package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.b;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.protocal.protobuf.apj;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mixItem", "Lcom/tencent/mm/plugin/finder/storage/FinderMixItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderMixItem;)V", "baseFinderFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getBaseFinderFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setBaseFinderFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "getMixItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderMixItem;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "toString", "", "plugin-finder_release"})
public final class c
  implements al
{
  public BaseFinderFeed sjQ;
  public final t sjR;
  
  public c(t paramt)
  {
    AppMethodBeat.i(202939);
    this.sjR = paramt;
    paramt = this.sjR.syU;
    if (paramt != null) {
      b.a locala = b.sAs;
    }
    for (paramt = b.a.j(paramt);; paramt = null)
    {
      this.sjQ = paramt;
      AppMethodBeat.o(202939);
      return;
    }
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(202937);
    d.g.b.p.h(parami, "obj");
    if (!(parami instanceof c)) {}
    for (Object localObject = null;; localObject = parami)
    {
      if ((c)localObject != null)
      {
        localObject = this.sjR;
        parami = ((c)parami).sjR;
        d.g.b.p.h(parami, "otherItem");
        int i;
        com.tencent.mm.plugin.finder.utils.p localp;
        boolean bool;
        if (parami.syW.dataType == ((t)localObject).syW.dataType)
        {
          i = parami.syW.dataType;
          if (i == t.syX)
          {
            localp = com.tencent.mm.plugin.finder.utils.p.sMo;
            localObject = ((t)localObject).syT;
            parami = parami.syT;
            if ((localObject != null) && (parami != null)) {
              if ((!bt.isNullOrNil(((m)localObject).cIv())) && (d.g.b.p.i(((m)localObject).cIv(), parami.cIv()))) {
                bool = true;
              }
            }
          }
        }
        while (bool)
        {
          AppMethodBeat.o(202937);
          return 0;
          bool = false;
          continue;
          bool = false;
          continue;
          if (i == t.syY)
          {
            localp = com.tencent.mm.plugin.finder.utils.p.sMo;
            localObject = ((t)localObject).syU;
            parami = parami.syU;
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
          else if (i == t.syZ)
          {
            localp = com.tencent.mm.plugin.finder.utils.p.sMo;
            localObject = ((t)localObject).sjP;
            parami = parami.sjP;
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
      AppMethodBeat.o(202937);
      return -1;
    }
  }
  
  public final int bYk()
  {
    return this.sjR.oIb;
  }
  
  public final long lP()
  {
    return this.sjR.syV;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(202938);
    String str = "ItemId=" + this.sjR.syV + ",ItemType=" + this.sjR.oIb + ' ';
    AppMethodBeat.o(202938);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.c
 * JD-Core Version:    0.7.0.1
 */