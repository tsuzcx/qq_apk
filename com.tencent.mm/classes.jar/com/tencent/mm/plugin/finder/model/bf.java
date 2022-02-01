package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.cjm;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderMusicInfoData;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "musicItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "localId", "", "getLocalId", "()J", "setLocalId", "(J)V", "getMusicItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getFeedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getImageUrl", "", "getItemId", "getItemType", "getMvInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVInfo;", "getPostProgress", "isLocal", "", "isPostFailed", "isPostFinish", "isPosting", "plugin-finder_release"})
public final class bf
  extends BaseFinderFeed
{
  public final FinderItem uOO;
  
  public bf(FinderItem paramFinderItem)
  {
    super(paramFinderItem);
    AppMethodBeat.i(248841);
    this.uOO = paramFinderItem;
    AppMethodBeat.o(248841);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(248835);
    p.h(parami, "obj");
    if (!(parami instanceof FinderItem)) {
      parami = null;
    }
    for (;;)
    {
      parami = (FinderItem)parami;
      if (parami != null)
      {
        if ((parami.getFeedObject().id != 0L) && (this.uOO.getFeedObject().id != 0L) && (parami.getFeedObject().id == this.uOO.getFeedObject().id))
        {
          AppMethodBeat.o(248835);
          return 0;
        }
        if ((parami.getLocalId() > 0L) && (this.uOO.getLocalId() > 0L) && (parami.getLocalId() == this.uOO.getLocalId()))
        {
          AppMethodBeat.o(248835);
          return 0;
        }
        if (this.uOO.getCreateTime() > parami.getCreateTime())
        {
          AppMethodBeat.o(248835);
          return 1;
        }
        AppMethodBeat.o(248835);
        return -1;
      }
      AppMethodBeat.o(248835);
      return -1;
    }
  }
  
  public final int cxn()
  {
    AppMethodBeat.i(248834);
    int i = bf.class.getName().hashCode();
    AppMethodBeat.o(248834);
    return i;
  }
  
  public final axw dkQ()
  {
    AppMethodBeat.i(248836);
    Object localObject = this.uOO.getFeedObject().objectDesc;
    if (localObject != null)
    {
      localObject = ((FinderObjectDesc)localObject).mvInfo;
      AppMethodBeat.o(248836);
      return localObject;
    }
    AppMethodBeat.o(248836);
    return null;
  }
  
  public final String dkR()
  {
    AppMethodBeat.i(248837);
    Object localObject = this.uOO.getFeedObject().objectDesc;
    if (localObject != null)
    {
      localObject = ((FinderObjectDesc)localObject).media;
      if (localObject != null)
      {
        localObject = (FinderMedia)j.kt((List)localObject);
        if (localObject != null)
        {
          localObject = ((FinderMedia)localObject).url;
          AppMethodBeat.o(248837);
          return localObject;
        }
      }
    }
    AppMethodBeat.o(248837);
    return null;
  }
  
  public final boolean dkS()
  {
    AppMethodBeat.i(248838);
    if (this.uOO.getFeedObject().id == 0L)
    {
      AppMethodBeat.o(248838);
      return true;
    }
    AppMethodBeat.o(248838);
    return false;
  }
  
  public final boolean dkT()
  {
    AppMethodBeat.i(248839);
    if ((!this.uOO.isPostFailed()) && (!this.uOO.isPostFinish()))
    {
      AppMethodBeat.o(248839);
      return true;
    }
    AppMethodBeat.o(248839);
    return false;
  }
  
  public final int dkU()
  {
    AppMethodBeat.i(248840);
    int i = this.uOO.getPostInfo().Mpc;
    AppMethodBeat.o(248840);
    return i;
  }
  
  public final long lT()
  {
    AppMethodBeat.i(248833);
    long l = this.uOO.getId();
    AppMethodBeat.o(248833);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.bf
 * JD-Core Version:    0.7.0.1
 */