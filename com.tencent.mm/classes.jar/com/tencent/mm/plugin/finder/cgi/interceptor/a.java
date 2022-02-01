package com.tencent.mm.plugin.finder.cgi.interceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.aa.e;
import com.tencent.mm.plugin.finder.cgi.aa.f;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/AdjustOrderAvatarInterceptor;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "()V", "MAX_RED_DOT_USER_NUM", "", "getMAX_RED_DOT_USER_NUM", "()I", "redDotFeedId", "", "getRedDotFeedId", "()J", "setRedDotFeedId", "(J)V", "redDotUserNameList", "", "", "getRedDotUserNameList", "()Ljava/util/List;", "setRedDotUserNameList", "(Ljava/util/List;)V", "redDotUsername", "getRedDotUsername", "()Ljava/lang/String;", "setRedDotUsername", "(Ljava/lang/String;)V", "modify", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "modifyLikeList", "onIntercept", "", "tabType", "onInterceptAfterStore", "loadedInfo", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "onInterceptBeforeStore", "Companion", "plugin-finder_release"})
public final class a
  implements f
{
  public static final a txA;
  private long txx;
  private String txy = "";
  private final int txz = 3;
  
  static
  {
    AppMethodBeat.i(242613);
    txA = new a((byte)0);
    AppMethodBeat.o(242613);
  }
  
  public final boolean a(aa.f paramf)
  {
    AppMethodBeat.i(242610);
    p.h(paramf, "resp");
    Object localObject1 = c.vCb;
    if (((Number)c.duv().value()).intValue() == 1)
    {
      p.h(paramf, "resp");
      this.txx = paramf.cXX().LMx;
      Object localObject2 = paramf.cXX().LMC;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.txy = ((String)localObject1);
      if ((this.txx != 0L) && (!Util.isNullOrNil(this.txy)))
      {
        paramf = paramf.object;
        int i;
        label151:
        label155:
        label160:
        label191:
        int j;
        if (paramf != null)
        {
          localObject1 = ((Iterable)paramf).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            paramf = ((Iterator)localObject1).next();
            if (((FinderObject)paramf).id == this.txx)
            {
              i = 1;
              if (i == 0) {
                break label472;
              }
              paramf = (FinderObject)paramf;
              if (paramf == null) {
                break label525;
              }
              localObject1 = paramf.likeList;
              p.g(localObject1, "likeList");
              localObject1 = ((List)localObject1).iterator();
              i = 0;
              if (!((Iterator)localObject1).hasNext()) {
                break label491;
              }
              if (!p.j(((FinderCommentInfo)((Iterator)localObject1).next()).username, z.aTY())) {
                break label484;
              }
              j = i;
              label225:
              if (j > 1)
              {
                localObject1 = (FinderCommentInfo)paramf.likeList.remove(j);
                paramf.likeList.add(1, localObject1);
              }
              localObject1 = paramf.likeList;
              p.g(localObject1, "likeList");
              localObject1 = ((List)localObject1).iterator();
              i = 0;
              label280:
              if (!((Iterator)localObject1).hasNext()) {
                break label503;
              }
              if (!p.j(((FinderCommentInfo)((Iterator)localObject1).next()).username, this.txy)) {
                break label496;
              }
            }
          }
        }
        for (;;)
        {
          if (i > 0)
          {
            localObject1 = (FinderCommentInfo)paramf.likeList.remove(i);
            paramf.likeList.add(0, localObject1);
          }
          localObject1 = new StringBuilder("meExistIndex=").append(j).append(" friendExistIndex=").append(i).append(" redDotUsername=").append(this.txy).append(" self=").append(z.aTY()).append("likeList=");
          paramf = paramf.likeList;
          p.g(paramf, "likeList");
          localObject2 = (Iterable)paramf;
          paramf = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            paramf.add(((FinderCommentInfo)((Iterator)localObject2).next()).username);
          }
          i = 0;
          break label151;
          label472:
          break;
          paramf = null;
          break label155;
          paramf = null;
          break label160;
          label484:
          i += 1;
          break label191;
          label491:
          j = -1;
          break label225;
          label496:
          i += 1;
          break label280;
          label503:
          i = -1;
        }
        Log.i("Finder.AdjustOrderAvatarInterceptor", (List)paramf);
      }
    }
    label525:
    AppMethodBeat.o(242610);
    return false;
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.feed.model.b paramb)
  {
    AppMethodBeat.i(242611);
    p.h(paramb, "loadedInfo");
    AppMethodBeat.o(242611);
    return false;
  }
  
  public final boolean b(com.tencent.mm.plugin.finder.feed.model.b paramb, int paramInt)
  {
    AppMethodBeat.i(242612);
    p.h(paramb, "loadedInfo");
    AppMethodBeat.o(242612);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/AdjustOrderAvatarInterceptor$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.interceptor.a
 * JD-Core Version:    0.7.0.1
 */