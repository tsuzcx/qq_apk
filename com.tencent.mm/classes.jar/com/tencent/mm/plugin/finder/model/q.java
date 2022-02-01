package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.i;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderDraftInfoData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "draftItem", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;)V", "getDraftItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "createTime", "", "getDraftTitle", "", "getItemId", "getItemType", "isMusicTag", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  implements cc
{
  public final i ABX;
  
  public q(i parami)
  {
    AppMethodBeat.i(332207);
    this.ABX = parami;
    AppMethodBeat.o(332207);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(332223);
    s.u(paramk, "obj");
    if ((paramk instanceof q)) {
      paramk = (q)paramk;
    }
    while (paramk != null) {
      if ((paramk.ABX.field_localId > 0L) && (this.ABX.field_localId > 0L) && (paramk.ABX.field_localId == this.ABX.field_localId))
      {
        AppMethodBeat.o(332223);
        return 0;
        paramk = null;
      }
      else if ((this.ABX.field_objectId != 0L) && (paramk.ABX.field_objectId != 0L) && (this.ABX.field_objectId == paramk.ABX.field_objectId))
      {
        AppMethodBeat.o(332223);
        return 0;
      }
    }
    AppMethodBeat.o(332223);
    return -1;
  }
  
  public final long bZA()
  {
    if (this.ABX.field_localId != 0L) {
      return this.ABX.field_localId;
    }
    return this.ABX.field_objectId;
  }
  
  public final int bZB()
  {
    AppMethodBeat.i(332218);
    int i = q.class.getName().hashCode();
    AppMethodBeat.o(332218);
    return i;
  }
  
  public final String eDh()
  {
    AppMethodBeat.i(332230);
    if (eDi())
    {
      localObject = this.ABX.eYK().getFeedObject().objectDesc;
      if (localObject == null) {
        localObject = null;
      }
      for (;;)
      {
        if (localObject == null) {
          break label206;
        }
        if (!Util.isNullOrNil(((boo)localObject).rDl)) {
          break label92;
        }
        localObject = ((boo)localObject).songName;
        if (localObject != null) {
          break;
        }
        AppMethodBeat.o(332230);
        return "";
        localObject = ((FinderObjectDesc)localObject).mvInfo;
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = ((bol)localObject).LWI;
        }
      }
      AppMethodBeat.o(332230);
      return localObject;
      label92:
      if (Util.isNullOrNil(((boo)localObject).songName))
      {
        localObject = String.valueOf(((boo)localObject).rDl);
        AppMethodBeat.o(332230);
        return localObject;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      String str2 = ((boo)localObject).songName;
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localObject = str1 + '-' + ((boo)localObject).rDl;
      AppMethodBeat.o(332230);
      return localObject;
    }
    Object localObject = this.ABX.eYK().getFeedObject().objectDesc;
    if (localObject == null)
    {
      AppMethodBeat.o(332230);
      return null;
    }
    localObject = ((FinderObjectDesc)localObject).description;
    AppMethodBeat.o(332230);
    return localObject;
    label206:
    AppMethodBeat.o(332230);
    return "";
  }
  
  public final boolean eDi()
  {
    return this.ABX.field_objectType == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.q
 * JD-Core Version:    0.7.0.1
 */