package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.profile.g;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.d;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.storage.q;
import com.tencent.mm.plugin.finder.storage.y;
import com.tencent.mm.plugin.finder.storage.z;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.bpm;
import com.tencent.mm.protocal.protobuf.bsg;
import com.tencent.mm.protocal.protobuf.eee;
import com.tencent.mm.protocal.protobuf.eel;
import com.tencent.mm.protocal.protobuf.fes;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mixItem", "Lcom/tencent/mm/plugin/finder/storage/FinderMixItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderMixItem;)V", "baseFinderFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getBaseFinderFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setBaseFinderFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "getMixItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderMixItem;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements cc
{
  public final y ECd;
  public BaseFinderFeed ECe;
  
  public c(y paramy)
  {
    AppMethodBeat.i(332174);
    this.ECd = paramy;
    paramy = this.ECd.FLM;
    if (paramy == null) {}
    for (paramy = null;; paramy = d.a.a(paramy))
    {
      this.ECe = paramy;
      AppMethodBeat.o(332174);
      return;
      d.a locala = d.FND;
    }
  }
  
  public final int a(k paramk)
  {
    Object localObject2 = null;
    AppMethodBeat.i(332194);
    s.u(paramk, "obj");
    Object localObject1;
    int i;
    boolean bool;
    if ((paramk instanceof c))
    {
      localObject1 = (c)paramk;
      if (localObject1 == null) {
        break label515;
      }
      localObject1 = this.ECd;
      paramk = ((c)paramk).ECd;
      s.u(paramk, "otherItem");
      if (paramk.FLK.dataType != ((y)localObject1).FLK.dataType) {
        break label510;
      }
      i = paramk.FLK.dataType;
      if (i != y.FLP) {
        break label171;
      }
      localObject2 = av.GiL;
      localObject1 = ((y)localObject1).FLL;
      paramk = paramk.FLL;
      localObject2 = aw.Gjk;
      if ((localObject1 == null) || (paramk == null)) {
        break label166;
      }
      if ((Util.isNullOrNil(((q)localObject1).eZo())) || (!s.p(((q)localObject1).eZo(), paramk.eZo()))) {
        break label161;
      }
      bool = true;
    }
    for (;;)
    {
      if (!bool) {
        break label515;
      }
      AppMethodBeat.o(332194);
      return 0;
      localObject1 = null;
      break;
      label161:
      bool = false;
      continue;
      label166:
      bool = false;
      continue;
      label171:
      if (i == y.FLQ)
      {
        localObject2 = av.GiL;
        localObject1 = ((y)localObject1).FLM;
        paramk = paramk.FLM;
        localObject2 = aw.Gjk;
        if ((localObject1 != null) && (paramk != null))
        {
          if ((((FinderItem)localObject1).field_id != 0L) && (paramk.field_id != 0L) && (((FinderItem)localObject1).field_id == paramk.field_id))
          {
            bool = true;
            continue;
          }
          if ((((FinderItem)localObject1).getLocalId() > 0L) && (paramk.getLocalId() > 0L) && (((FinderItem)localObject1).getLocalId() == paramk.getLocalId())) {
            bool = true;
          }
        }
      }
      else
      {
        if (i == y.FLR)
        {
          localObject2 = av.GiL;
          localObject1 = ((y)localObject1).ECc;
          paramk = paramk.ECc;
          localObject2 = aw.Gjk;
          if ((localObject1 != null) && (paramk != null))
          {
            bool = ((z)localObject1).a(paramk);
            continue;
          }
          bool = false;
          continue;
        }
        if (i == y.FLS)
        {
          Object localObject3 = av.GiL;
          localObject3 = ((y)localObject1).FLN;
          localObject1 = paramk.FLN;
          paramk = aw.Gjk;
          if ((localObject3 != null) && (localObject1 != null))
          {
            s.u(localObject1, "other");
            paramk = ((g)localObject3).FaZ.aaae;
            if (paramk == null)
            {
              paramk = null;
              localObject1 = ((g)localObject1).FaZ.aaae;
              if (localObject1 != null) {
                break label463;
              }
              localObject1 = localObject2;
            }
            for (;;)
            {
              bool = n.T(paramk, (String)localObject1, false);
              break;
              paramk = paramk.abEh;
              if (paramk == null)
              {
                paramk = null;
                break label397;
              }
              paramk = paramk.abjy;
              if (paramk == null)
              {
                paramk = null;
                break label397;
              }
              paramk = paramk.UID;
              break label397;
              label463:
              localObject3 = ((fes)localObject1).abEh;
              localObject1 = localObject2;
              if (localObject3 != null)
              {
                localObject3 = ((eel)localObject3).abjy;
                localObject1 = localObject2;
                if (localObject3 != null) {
                  localObject1 = ((eee)localObject3).UID;
                }
              }
            }
          }
          bool = false;
          continue;
        }
      }
      label397:
      label510:
      bool = false;
    }
    label515:
    AppMethodBeat.o(332194);
    return -1;
  }
  
  public final long bZA()
  {
    return this.ECd.FLO;
  }
  
  public final int bZB()
  {
    return this.ECd.viewType;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(332206);
    String str = "ItemId=" + this.ECd.FLO + ",ItemType=" + this.ECd.viewType + ' ';
    AppMethodBeat.o(332206);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.c
 * JD-Core Version:    0.7.0.1
 */