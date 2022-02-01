package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.csh;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderMusicInfoData;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "musicItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "localId", "", "getLocalId", "()J", "setLocalId", "(J)V", "getMusicItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getFeedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getImageUrl", "", "getItemId", "getItemType", "getMvInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVInfo;", "getPostProgress", "isLocal", "", "isPostFailed", "isPostFinish", "isPosting", "plugin-finder_release"})
public final class bi
  extends BaseFinderFeed
{
  public final FinderItem zBk;
  
  public bi(FinderItem paramFinderItem)
  {
    super(paramFinderItem);
    AppMethodBeat.i(280557);
    this.zBk = paramFinderItem;
    FinderContact localFinderContact = this.zBk.getFeedObject().contact;
    paramFinderItem = localObject;
    if (localFinderContact != null) {
      paramFinderItem = c.a(localFinderContact, null);
    }
    this.contact = paramFinderItem;
    AppMethodBeat.o(280557);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(280549);
    p.k(paramk, "obj");
    if (!(paramk instanceof bi)) {
      paramk = null;
    }
    for (;;)
    {
      paramk = (bi)paramk;
      if (paramk != null)
      {
        if ((paramk.zBk.getFeedObject().id != 0L) && (this.zBk.getFeedObject().id != 0L) && (paramk.zBk.getFeedObject().id == this.zBk.getFeedObject().id))
        {
          AppMethodBeat.o(280549);
          return 0;
        }
        if ((paramk.zBk.getLocalId() > 0L) && (this.zBk.getLocalId() > 0L) && (paramk.zBk.getLocalId() == this.zBk.getLocalId()))
        {
          AppMethodBeat.o(280549);
          return 0;
        }
        if (this.zBk.getCreateTime() > paramk.zBk.getCreateTime())
        {
          AppMethodBeat.o(280549);
          return 1;
        }
        AppMethodBeat.o(280549);
        return -1;
      }
      AppMethodBeat.o(280549);
      return -1;
    }
  }
  
  public final int bAQ()
  {
    AppMethodBeat.i(280548);
    int i = bi.class.getName().hashCode();
    AppMethodBeat.o(280548);
    return i;
  }
  
  public final bdp dKQ()
  {
    AppMethodBeat.i(280551);
    Object localObject = this.zBk.getFeedObject().objectDesc;
    if (localObject != null)
    {
      localObject = ((FinderObjectDesc)localObject).mvInfo;
      AppMethodBeat.o(280551);
      return localObject;
    }
    AppMethodBeat.o(280551);
    return null;
  }
  
  public final String dKR()
  {
    AppMethodBeat.i(280553);
    Object localObject = this.zBk.getFeedObject().objectDesc;
    if (localObject != null)
    {
      localObject = ((FinderObjectDesc)localObject).media;
      if (localObject != null)
      {
        localObject = (FinderMedia)j.lp((List)localObject);
        if (localObject != null)
        {
          localObject = ((FinderMedia)localObject).url;
          AppMethodBeat.o(280553);
          return localObject;
        }
      }
    }
    AppMethodBeat.o(280553);
    return null;
  }
  
  public final boolean dKS()
  {
    AppMethodBeat.i(280554);
    if (this.zBk.getFeedObject().id == 0L)
    {
      AppMethodBeat.o(280554);
      return true;
    }
    AppMethodBeat.o(280554);
    return false;
  }
  
  public final boolean dKT()
  {
    AppMethodBeat.i(280555);
    if ((!this.zBk.isPostFailed()) && (!this.zBk.isPostFinish()))
    {
      AppMethodBeat.o(280555);
      return true;
    }
    AppMethodBeat.o(280555);
    return false;
  }
  
  public final int dKU()
  {
    AppMethodBeat.i(280556);
    int i = this.zBk.getPostInfo().TAi;
    AppMethodBeat.o(280556);
    return i;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(280547);
    long l = this.zBk.getId();
    AppMethodBeat.o(280547);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.bi
 * JD-Core Version:    0.7.0.1
 */