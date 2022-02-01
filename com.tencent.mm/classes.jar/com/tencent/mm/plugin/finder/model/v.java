package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.b;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.storage.p;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.storage.s;
import com.tencent.mm.protocal.protobuf.dzj;
import com.tencent.mm.protocal.protobuf.dzk;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.view.recyclerview.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "mixItem", "Lcom/tencent/mm/plugin/finder/storage/FinderMixItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderMixItem;)V", "baseFinderFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getBaseFinderFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setBaseFinderFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "getMixItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderMixItem;", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class v
  implements com.tencent.mm.plugin.finder.feed.model.internal.i, a
{
  public BaseFinderFeed KTl;
  public final r KTm;
  
  public v(r paramr)
  {
    AppMethodBeat.i(198618);
    this.KTm = paramr;
    paramr = this.KTm.KXc;
    if (paramr != null) {
      b.a locala = b.qKG;
    }
    for (paramr = b.a.h(paramr);; paramr = null)
    {
      this.KTl = paramr;
      AppMethodBeat.o(198618);
      return;
    }
  }
  
  public final int a(com.tencent.mm.plugin.finder.feed.model.internal.i parami)
  {
    AppMethodBeat.i(198617);
    k.h(parami, "obj");
    if (!(parami instanceof v)) {}
    for (Object localObject = null;; localObject = parami)
    {
      if ((v)localObject != null)
      {
        localObject = this.KTm;
        parami = ((v)parami).KTm;
        k.h(parami, "otherItem");
        int i;
        com.tencent.mm.plugin.finder.utils.i locali;
        if (parami.KXe.dataType == ((r)localObject).KXe.dataType)
        {
          i = parami.KXe.dataType;
          if (i == r.KXf)
          {
            locali = com.tencent.mm.plugin.finder.utils.i.qTa;
            localObject = ((r)localObject).KXb;
            parami = parami.KXb;
            if ((localObject != null) && (parami != null)) {
              if ((!bt.isNullOrNil(((p)localObject).fUR())) && (k.g(((p)localObject).fUR(), parami.fUR()))) {
                i = 1;
              }
            }
          }
        }
        while (i != 0)
        {
          AppMethodBeat.o(198617);
          return 0;
          i = 0;
          continue;
          i = 0;
          continue;
          if (i == r.KXg)
          {
            locali = com.tencent.mm.plugin.finder.utils.i.qTa;
            localObject = ((r)localObject).KXc;
            parami = parami.KXc;
            if ((localObject != null) && (parami != null))
            {
              if ((((FinderItem)localObject).getMediaType() == 9999) && (parami.getMediaType() == 9999))
              {
                i = 1;
                continue;
              }
              if ((((FinderItem)localObject).field_id != 0L) && (parami.field_id != 0L) && (((FinderItem)localObject).field_id == parami.field_id))
              {
                i = 1;
                continue;
              }
              if ((((FinderItem)localObject).getLocalId() > 0L) && (parami.getLocalId() > 0L) && (((FinderItem)localObject).getLocalId() == parami.getLocalId())) {
                i = 1;
              }
            }
          }
          else if (i == r.KXh)
          {
            locali = com.tencent.mm.plugin.finder.utils.i.qTa;
            localObject = ((r)localObject).KXd;
            parami = parami.KXd;
            if ((localObject != null) && (parami != null))
            {
              k.h(parami, "other");
              if ((((s)localObject).KXj.LxR == parami.KXj.LxR) && (!bt.isNullOrNil(((s)localObject).getWording())) && (k.g(((s)localObject).getWording(), parami.getWording())))
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
      AppMethodBeat.o(198617);
      return -1;
    }
  }
  
  public final long bMs()
  {
    return this.KTm.trO;
  }
  
  public final int bMt()
  {
    return this.KTm.nBH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.v
 * JD-Core Version:    0.7.0.1
 */