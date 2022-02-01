package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.h;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderDraftInfoData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "draftItem", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;)V", "getDraftItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "createTime", "", "getDraftTitle", "", "getItemId", "getItemType", "isMusicTag", "", "plugin-finder_release"})
public final class q
  implements bu
{
  public final h zAj;
  
  public q(h paramh)
  {
    AppMethodBeat.i(265906);
    this.zAj = paramh;
    AppMethodBeat.o(265906);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(265899);
    p.k(paramk, "obj");
    if (!(paramk instanceof q)) {
      paramk = null;
    }
    for (;;)
    {
      paramk = (q)paramk;
      if (paramk != null)
      {
        if ((paramk.zAj.field_localId > 0L) && (this.zAj.field_localId > 0L) && (paramk.zAj.field_localId == this.zAj.field_localId))
        {
          AppMethodBeat.o(265899);
          return 0;
        }
        AppMethodBeat.o(265899);
        return -1;
      }
      AppMethodBeat.o(265899);
      return -1;
    }
  }
  
  public final int bAQ()
  {
    AppMethodBeat.i(265898);
    int i = q.class.getName().hashCode();
    AppMethodBeat.o(265898);
    return i;
  }
  
  public final String dKt()
  {
    AppMethodBeat.i(265902);
    if (dKu())
    {
      localObject1 = this.zAj.dYm().getFeedObject().objectDesc;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
        if (localObject1 == null) {}
      }
      for (localObject1 = ((bdp)localObject1).GaB;; localObject1 = null)
      {
        if (localObject1 == null) {
          break label196;
        }
        if (!Util.isNullOrNil(((bds)localObject1).ozs)) {
          break;
        }
        localObject2 = ((bds)localObject1).HLH;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label152;
        }
        AppMethodBeat.o(265902);
        return "";
      }
      if (Util.isNullOrNil(((bds)localObject1).HLH))
      {
        localObject1 = String.valueOf(((bds)localObject1).ozs);
        AppMethodBeat.o(265902);
        return localObject1;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      String str = ((bds)localObject1).HLH;
      Object localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      localObject1 = (String)localObject2 + '-' + ((bds)localObject1).ozs;
      label152:
      AppMethodBeat.o(265902);
      return localObject1;
    }
    Object localObject1 = this.zAj.dYm().getFeedObject().objectDesc;
    if (localObject1 != null)
    {
      localObject1 = ((FinderObjectDesc)localObject1).description;
      AppMethodBeat.o(265902);
      return localObject1;
    }
    AppMethodBeat.o(265902);
    return null;
    label196:
    AppMethodBeat.o(265902);
    return "";
  }
  
  public final boolean dKu()
  {
    return this.zAj.field_objectType == 2;
  }
  
  public final long mf()
  {
    return this.zAj.field_localId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.q
 * JD-Core Version:    0.7.0.1
 */