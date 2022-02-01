package com.tencent.mm.plugin.finder.cgi.interceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.aq.c;
import com.tencent.mm.plugin.finder.cgi.aq.d;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/AdjustOrderAvatarInterceptor;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "()V", "MAX_RED_DOT_USER_NUM", "", "getMAX_RED_DOT_USER_NUM", "()I", "redDotFeedId", "", "getRedDotFeedId", "()J", "setRedDotFeedId", "(J)V", "redDotUserNameList", "", "", "getRedDotUserNameList", "()Ljava/util/List;", "setRedDotUserNameList", "(Ljava/util/List;)V", "redDotUsername", "getRedDotUsername", "()Ljava/lang/String;", "setRedDotUsername", "(Ljava/lang/String;)V", "modify", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "modifyLikeList", "onIntercept", "", "tabType", "onInterceptAfterStore", "loadedInfo", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "onInterceptBeforeStore", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements g
{
  public static final a AES;
  private long AET;
  private String AEU = "";
  private final int AEV = 3;
  
  static
  {
    AppMethodBeat.i(336753);
    AES = new a((byte)0);
    AppMethodBeat.o(336753);
  }
  
  public final boolean a(aq.d paramd, int paramInt)
  {
    AppMethodBeat.i(336773);
    s.u(paramd, "resp");
    Object localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eUe().bmg()).intValue() == 1)
    {
      s.u(paramd, "resp");
      this.AET = paramd.dVm().EWw;
      Object localObject2 = paramd.dVm().aaeR;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.AEU = ((String)localObject1);
      if ((this.AET != 0L) && (!Util.isNullOrNil(this.AEU)))
      {
        paramd = paramd.object;
        label138:
        int i;
        if (paramd == null)
        {
          paramd = null;
          if (paramd == null) {
            break label525;
          }
          localObject1 = paramd.likeList;
          s.s(localObject1, "likeList");
          localObject1 = ((List)localObject1).iterator();
          paramInt = 0;
          if (!((Iterator)localObject1).hasNext()) {
            break label491;
          }
          if (!s.p(((FinderCommentInfo)((Iterator)localObject1).next()).username, z.bAM())) {
            break label484;
          }
          i = paramInt;
          label172:
          if (i > 1)
          {
            localObject1 = (FinderCommentInfo)paramd.likeList.remove(i);
            paramd.likeList.add(1, localObject1);
          }
          localObject1 = paramd.likeList;
          s.s(localObject1, "likeList");
          localObject1 = ((List)localObject1).iterator();
          paramInt = 0;
          label227:
          if (!((Iterator)localObject1).hasNext()) {
            break label503;
          }
          if (!s.p(((FinderCommentInfo)((Iterator)localObject1).next()).username, this.AEU)) {
            break label496;
          }
        }
        for (;;)
        {
          if (paramInt > 0)
          {
            localObject1 = (FinderCommentInfo)paramd.likeList.remove(paramInt);
            paramd.likeList.add(0, localObject1);
          }
          localObject1 = new StringBuilder("meExistIndex=").append(i).append(" friendExistIndex=").append(paramInt).append(" redDotUsername=").append(this.AEU).append(" self=").append(z.bAM()).append("likeList=");
          paramd = paramd.likeList;
          s.s(paramd, "likeList");
          localObject2 = (Iterable)paramd;
          paramd = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            paramd.add(((FinderCommentInfo)((Iterator)localObject2).next()).username);
          }
          localObject1 = ((Iterable)paramd).iterator();
          label427:
          if (((Iterator)localObject1).hasNext())
          {
            paramd = ((Iterator)localObject1).next();
            if (((FinderObject)paramd).id == this.AET)
            {
              paramInt = 1;
              label462:
              if (paramInt == 0) {
                break label477;
              }
            }
          }
          for (;;)
          {
            paramd = (FinderObject)paramd;
            break;
            paramInt = 0;
            break label462;
            label477:
            break label427;
            paramd = null;
          }
          label484:
          paramInt += 1;
          break label138;
          label491:
          i = -1;
          break label172;
          label496:
          paramInt += 1;
          break label227;
          label503:
          paramInt = -1;
        }
        Log.i("Finder.AdjustOrderAvatarInterceptor", (List)paramd);
      }
    }
    label525:
    AppMethodBeat.o(336773);
    return false;
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.feed.model.d paramd)
  {
    AppMethodBeat.i(336781);
    s.u(paramd, "loadedInfo");
    AppMethodBeat.o(336781);
    return false;
  }
  
  public final boolean b(com.tencent.mm.plugin.finder.feed.model.d paramd, int paramInt)
  {
    AppMethodBeat.i(336789);
    s.u(paramd, "loadedInfo");
    AppMethodBeat.o(336789);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/AdjustOrderAvatarInterceptor$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.interceptor.a
 * JD-Core Version:    0.7.0.1
 */