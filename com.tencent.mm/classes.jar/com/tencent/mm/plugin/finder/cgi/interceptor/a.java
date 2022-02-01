package com.tencent.mm.plugin.finder.cgi.interceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.finder.cgi.m.e;
import com.tencent.mm.plugin.finder.cgi.m.f;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ass;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/AdjustOrderAvatarInterceptor;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "()V", "MAX_RED_DOT_USER_NUM", "", "getMAX_RED_DOT_USER_NUM", "()I", "redDotFeedId", "", "getRedDotFeedId", "()J", "setRedDotFeedId", "(J)V", "redDotUserNameList", "", "", "getRedDotUserNameList", "()Ljava/util/List;", "setRedDotUserNameList", "(Ljava/util/List;)V", "redDotUsername", "getRedDotUsername", "()Ljava/lang/String;", "setRedDotUsername", "(Ljava/lang/String;)V", "modify", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "modifyLikeList", "onIntercept", "", "onInterceptAfterStore", "loadedInfo", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "onInterceptBeforeStore", "Companion", "plugin-finder_release"})
public final class a
  implements f
{
  public static final a rTl;
  private long rTi;
  private String rTj = "";
  private final int rTk = 3;
  
  static
  {
    AppMethodBeat.i(201645);
    rTl = new a((byte)0);
    AppMethodBeat.o(201645);
  }
  
  public final boolean a(m.f paramf)
  {
    AppMethodBeat.i(201642);
    p.h(paramf, "resp");
    Object localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cKB().value()).intValue() == 1)
    {
      p.h(paramf, "resp");
      localObject1 = paramf.czy().rQB;
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
        l = ((ass)localObject1).GJI;
        this.rTi = l;
        localObject1 = paramf.czy().rQB;
        if (localObject1 != null)
        {
          localObject2 = ((ass)localObject1).username;
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        this.rTj = ((String)localObject1);
        if ((this.rTi == 0L) || (bu.isNullOrNil(this.rTj))) {
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
        if (((FinderObject)paramf).id != this.rTi) {
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
        if (!p.i(((FinderCommentInfo)((Iterator)localObject1).next()).username, v.aAC())) {
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
        if (!p.i(((FinderCommentInfo)((Iterator)localObject1).next()).username, this.rTj)) {
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
        localObject1 = new StringBuilder("meExistIndex=").append(j).append(" friendExistIndex=").append(i).append(" redDotUsername=").append(this.rTj).append(" self=").append(v.aAC()).append("likeList=");
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
      ae.i("Finder.AdjustOrderAvatarInterceptor", (List)paramf);
    }
    label559:
    AppMethodBeat.o(201642);
    return false;
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.feed.model.b paramb)
  {
    AppMethodBeat.i(201643);
    p.h(paramb, "loadedInfo");
    AppMethodBeat.o(201643);
    return false;
  }
  
  public final boolean b(com.tencent.mm.plugin.finder.feed.model.b paramb)
  {
    AppMethodBeat.i(201644);
    p.h(paramb, "loadedInfo");
    AppMethodBeat.o(201644);
    return false;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/AdjustOrderAvatarInterceptor$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.interceptor.a
 * JD-Core Version:    0.7.0.1
 */