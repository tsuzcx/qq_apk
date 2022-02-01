package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.g;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderDraftInfoData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "draftItem", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;)V", "getDraftItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "createTime", "", "getDraftTitle", "", "getItemId", "getItemType", "isMusicTag", "", "plugin-finder_release"})
public final class q
  implements bo
{
  public final g uNV;
  
  public q(g paramg)
  {
    AppMethodBeat.i(248729);
    this.uNV = paramg;
    AppMethodBeat.o(248729);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(248727);
    p.h(parami, "obj");
    if (!(parami instanceof q)) {
      parami = null;
    }
    for (;;)
    {
      parami = (q)parami;
      if (parami != null)
      {
        if ((parami.uNV.field_localId > 0L) && (this.uNV.field_localId > 0L) && (parami.uNV.field_localId == this.uNV.field_localId))
        {
          AppMethodBeat.o(248727);
          return 0;
        }
        if ((parami.uNV.dxn().getId() != 0L) && (parami.uNV.dxn().getId() != 0L) && (parami.uNV.dxn().getId() == parami.uNV.dxn().getId()))
        {
          AppMethodBeat.o(248727);
          return 0;
        }
        if ((this.uNV.field_createTime != 0) && (parami.uNV.field_createTime != 0) && (this.uNV.field_createTime == parami.uNV.field_createTime))
        {
          AppMethodBeat.o(248727);
          return 1;
        }
        AppMethodBeat.o(248727);
        return -1;
      }
      AppMethodBeat.o(248727);
      return -1;
    }
  }
  
  public final int cxn()
  {
    AppMethodBeat.i(248726);
    int i = q.class.getName().hashCode();
    AppMethodBeat.o(248726);
    return i;
  }
  
  public final String dkw()
  {
    AppMethodBeat.i(248728);
    if (dkx())
    {
      localObject1 = this.uNV.dxn().getFeedObject().objectDesc;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
        if (localObject1 == null) {}
      }
      for (localObject1 = ((axw)localObject1).Aqo;; localObject1 = null)
      {
        if (localObject1 == null) {
          break label196;
        }
        if (!Util.isNullOrNil(((axy)localObject1).lDR)) {
          break;
        }
        localObject2 = ((axy)localObject1).BPc;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label152;
        }
        AppMethodBeat.o(248728);
        return "";
      }
      if (Util.isNullOrNil(((axy)localObject1).BPc))
      {
        localObject1 = String.valueOf(((axy)localObject1).lDR);
        AppMethodBeat.o(248728);
        return localObject1;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      String str = ((axy)localObject1).BPc;
      Object localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      localObject1 = (String)localObject2 + '-' + ((axy)localObject1).lDR;
      label152:
      AppMethodBeat.o(248728);
      return localObject1;
    }
    Object localObject1 = this.uNV.dxn().getFeedObject().objectDesc;
    if (localObject1 != null)
    {
      localObject1 = ((FinderObjectDesc)localObject1).description;
      AppMethodBeat.o(248728);
      return localObject1;
    }
    AppMethodBeat.o(248728);
    return null;
    label196:
    AppMethodBeat.o(248728);
    return "";
  }
  
  public final boolean dkx()
  {
    return this.uNV.field_objectType == 2;
  }
  
  public final long lT()
  {
    return this.uNV.field_localId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.q
 * JD-Core Version:    0.7.0.1
 */