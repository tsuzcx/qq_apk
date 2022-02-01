package com.tencent.mm.plugin.finder.cgi.interceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.cgi.m.e;
import com.tencent.mm.plugin.finder.cgi.m.f;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.asd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/AdjustOrderAvatarInterceptor;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "()V", "MAX_RED_DOT_USER_NUM", "", "getMAX_RED_DOT_USER_NUM", "()I", "redDotFeedId", "", "getRedDotFeedId", "()J", "setRedDotFeedId", "(J)V", "redDotUserNameList", "", "", "getRedDotUserNameList", "()Ljava/util/List;", "setRedDotUserNameList", "(Ljava/util/List;)V", "redDotUsername", "getRedDotUsername", "()Ljava/lang/String;", "setRedDotUsername", "(Ljava/lang/String;)V", "modify", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "modifyLikeList", "onIntercept", "", "onInterceptAfterStore", "loadedInfo", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "onInterceptBeforeStore", "Companion", "plugin-finder_release"})
public final class a
  implements e
{
  public static final a EIu;
  private long rKW;
  private String rKX = "";
  private final int rKY = 3;
  
  static
  {
    AppMethodBeat.i(221449);
    EIu = new a((byte)0);
    AppMethodBeat.o(221449);
  }
  
  public final boolean a(m.f paramf)
  {
    AppMethodBeat.i(201218);
    p.h(paramf, "resp");
    Object localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.eQo().value()).intValue() == 1)
    {
      p.h(paramf, "resp");
      localObject1 = paramf.cxX().rIq;
      long l;
      Object localObject2;
      label144:
      int i;
      label179:
      label183:
      label188:
      label219:
      int j;
      if (localObject1 != null)
      {
        l = ((asd)localObject1).Gqn;
        this.rKW = l;
        localObject1 = paramf.cxX().rIq;
        if (localObject1 != null)
        {
          localObject2 = ((asd)localObject1).username;
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        this.rKX = ((String)localObject1);
        if ((this.rKW == 0L) || (bt.isNullOrNil(this.rKX))) {
          break label559;
        }
        paramf = paramf.object;
        if (paramf == null) {
          break label513;
        }
        localObject1 = ((Iterable)paramf).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label508;
        }
        paramf = ((Iterator)localObject1).next();
        if (((FinderObject)paramf).id != this.rKW) {
          break label503;
        }
        i = 1;
        if (i == 0) {
          break label506;
        }
        paramf = (FinderObject)paramf;
        if (paramf == null) {
          break label559;
        }
        localObject1 = paramf.likeList;
        p.g(localObject1, "likeList");
        localObject1 = ((List)localObject1).iterator();
        i = 0;
        if (!((Iterator)localObject1).hasNext()) {
          break label525;
        }
        if (!p.i(((FinderCommentInfo)((Iterator)localObject1).next()).username, u.aAm())) {
          break label518;
        }
        j = i;
        label253:
        if (j > 1)
        {
          localObject1 = (FinderCommentInfo)paramf.likeList.remove(j);
          paramf.likeList.add(1, localObject1);
        }
        localObject1 = paramf.likeList;
        p.g(localObject1, "likeList");
        localObject1 = ((List)localObject1).iterator();
        i = 0;
        label308:
        if (!((Iterator)localObject1).hasNext()) {
          break label537;
        }
        if (!p.i(((FinderCommentInfo)((Iterator)localObject1).next()).username, this.rKX)) {
          break label530;
        }
      }
      for (;;)
      {
        if (i > 0)
        {
          localObject1 = (FinderCommentInfo)paramf.likeList.remove(i);
          paramf.likeList.add(0, localObject1);
        }
        localObject1 = new StringBuilder("meExistIndex=").append(j).append(" friendExistIndex=").append(i).append(" redDotUsername=").append(this.rKX).append(" self=").append(u.aAm()).append("likeList=");
        paramf = paramf.likeList;
        p.g(paramf, "likeList");
        localObject2 = (Iterable)paramf;
        paramf = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramf.add(((FinderCommentInfo)((Iterator)localObject2).next()).username);
        }
        l = 0L;
        break;
        label503:
        i = 0;
        break label179;
        label506:
        break label144;
        label508:
        paramf = null;
        break label183;
        label513:
        paramf = null;
        break label188;
        label518:
        i += 1;
        break label219;
        label525:
        j = -1;
        break label253;
        label530:
        i += 1;
        break label308;
        label537:
        i = -1;
      }
      ad.i("Finder.AdjustOrderAvatarInterceptor", (List)paramf);
    }
    label559:
    AppMethodBeat.o(201218);
    return false;
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.feed.model.b paramb)
  {
    AppMethodBeat.i(201219);
    p.h(paramb, "loadedInfo");
    AppMethodBeat.o(201219);
    return false;
  }
  
  public final boolean b(com.tencent.mm.plugin.finder.feed.model.b paramb)
  {
    AppMethodBeat.i(201220);
    p.h(paramb, "loadedInfo");
    AppMethodBeat.o(201220);
    return false;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/AdjustOrderAvatarInterceptor$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.interceptor.a
 * JD-Core Version:    0.7.0.1
 */