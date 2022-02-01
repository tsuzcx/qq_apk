package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.djj;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderMusicInfoData;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "musicItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "localId", "", "getLocalId", "()J", "setLocalId", "(J)V", "getMusicItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getFeedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getImageUrl", "", "getItemId", "getItemType", "getMvInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVInfo;", "getPostProgress", "isLocal", "", "isPostFailed", "isPostFinish", "isPosting", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bm
  extends BaseFinderFeed
{
  public final FinderItem EDt;
  
  public bm(FinderItem paramFinderItem)
  {
    super(paramFinderItem);
    AppMethodBeat.i(331940);
    this.EDt = paramFinderItem;
    paramFinderItem = this.EDt.getFeedObject().contact;
    if (paramFinderItem == null) {}
    for (paramFinderItem = localObject;; paramFinderItem = c.a(paramFinderItem, null, false))
    {
      this.contact = paramFinderItem;
      AppMethodBeat.o(331940);
      return;
    }
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(331964);
    s.u(paramk, "obj");
    if ((paramk instanceof bm)) {
      paramk = (bm)paramk;
    }
    while (paramk != null) {
      if ((paramk.EDt.getFeedObject().id != 0L) && (this.EDt.getFeedObject().id != 0L) && (paramk.EDt.getFeedObject().id == this.EDt.getFeedObject().id))
      {
        AppMethodBeat.o(331964);
        return 0;
        paramk = null;
      }
      else
      {
        if ((paramk.EDt.getLocalId() > 0L) && (this.EDt.getLocalId() > 0L) && (paramk.EDt.getLocalId() == this.EDt.getLocalId()))
        {
          AppMethodBeat.o(331964);
          return 0;
        }
        if (this.EDt.getCreateTime() > paramk.EDt.getCreateTime())
        {
          AppMethodBeat.o(331964);
          return 1;
        }
        AppMethodBeat.o(331964);
        return -1;
      }
    }
    AppMethodBeat.o(331964);
    return -1;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(331948);
    long l = this.EDt.getId();
    AppMethodBeat.o(331948);
    return l;
  }
  
  public final int bZB()
  {
    AppMethodBeat.i(331955);
    int i = bm.class.getName().hashCode();
    AppMethodBeat.o(331955);
    return i;
  }
  
  public final String eDA()
  {
    AppMethodBeat.i(331977);
    Object localObject = this.EDt.getFeedObject().objectDesc;
    if (localObject == null)
    {
      AppMethodBeat.o(331977);
      return null;
    }
    localObject = ((FinderObjectDesc)localObject).media;
    if (localObject == null)
    {
      AppMethodBeat.o(331977);
      return null;
    }
    localObject = (FinderMedia)p.oL((List)localObject);
    if (localObject == null)
    {
      AppMethodBeat.o(331977);
      return null;
    }
    localObject = ((FinderMedia)localObject).url;
    AppMethodBeat.o(331977);
    return localObject;
  }
  
  public final boolean eDB()
  {
    AppMethodBeat.i(331982);
    if (this.EDt.getFeedObject().id == 0L)
    {
      AppMethodBeat.o(331982);
      return true;
    }
    AppMethodBeat.o(331982);
    return false;
  }
  
  public final int eDC()
  {
    AppMethodBeat.i(331991);
    int i = this.EDt.getPostInfo().aaPw;
    AppMethodBeat.o(331991);
    return i;
  }
  
  public final bol eDz()
  {
    AppMethodBeat.i(331971);
    Object localObject = this.EDt.getFeedObject().objectDesc;
    if (localObject == null)
    {
      AppMethodBeat.o(331971);
      return null;
    }
    localObject = ((FinderObjectDesc)localObject).mvInfo;
    AppMethodBeat.o(331971);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.bm
 * JD-Core Version:    0.7.0.1
 */