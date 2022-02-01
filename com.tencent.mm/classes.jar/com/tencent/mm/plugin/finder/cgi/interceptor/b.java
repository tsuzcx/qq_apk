package com.tencent.mm.plugin.finder.cgi.interceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.aq.c;
import com.tencent.mm.plugin.finder.cgi.aq.d;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI5;
import com.tencent.mm.plugin.finder.model.ai;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.k.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.axn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/FinderFriendsTabBackFoldedInterceptor;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "()V", "onIntercept", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "tabType", "", "onInterceptAfterStore", "loadedInfo", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "onInterceptBeforeStore", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements g
{
  public static final a AEW;
  
  static
  {
    AppMethodBeat.i(336746);
    AEW = new a((byte)0);
    AppMethodBeat.o(336746);
  }
  
  public final boolean a(aq.d paramd, int paramInt)
  {
    AppMethodBeat.i(336750);
    s.u(paramd, "resp");
    AppMethodBeat.o(336750);
    return false;
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.feed.model.d paramd)
  {
    AppMethodBeat.i(336757);
    s.u(paramd, "loadedInfo");
    AppMethodBeat.o(336757);
    return false;
  }
  
  public final boolean b(com.tencent.mm.plugin.finder.feed.model.d paramd, int paramInt)
  {
    AppMethodBeat.i(336764);
    s.u(paramd, "loadedInfo");
    Object localObject1 = paramd.BeG;
    boolean bool;
    label40:
    int i;
    if (localObject1 == null)
    {
      paramInt = 0;
      localObject1 = k.a.FKj;
      if ((k.a.eZe() & paramInt) == 0) {
        break label392;
      }
      bool = true;
      if (bool)
      {
        FinderItem localFinderItem = new FinderItem();
        localObject2 = paramd.Bey;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = (List)ab.aivy;
        }
        localFinderItem.getFeedObject().foldedLayout = new axn();
        localObject2 = localFinderItem.getFoldedLayout();
        if (localObject2 != null)
        {
          localObject2 = ((axn)localObject2).ZIQ;
          if (localObject2 != null) {
            ((LinkedList)localObject2).addAll((Collection)((List)localObject1).subList(0, Math.min(4, ((List)localObject1).size())));
          }
        }
        localObject1 = ah.aiuX;
        localObject1 = OccupyFinderUI5.Bth;
        localObject1 = new ai(localFinderItem, OccupyFinderUI5.egh());
        localObject2 = ((ai)localObject1).feedObject.getFoldedLayout();
        if (localObject2 != null)
        {
          localObject2 = ((axn)localObject2).ZIQ;
          if (localObject2 != null) {
            com.tencent.mm.ae.d.a(paramd.Bex, (kotlin.g.a.b)new b((LinkedList)localObject2));
          }
        }
        paramd.Bex.add(0, localObject1);
      }
      Object localObject2 = new StringBuilder("[onInterceptAfterStore] tabType=").append(paramd.hJx).append(" pullType=").append(paramd.pullType).append(" request=");
      localObject1 = paramd.BeG;
      if (localObject1 != null) {
        break label398;
      }
      localObject1 = null;
      label274:
      if (localObject1 == null) {
        break label408;
      }
      i = localObject1.hashCode();
      label285:
      localObject1 = ((StringBuilder)localObject2).append(i).append(" isAddMachineFoldedCard=").append(bool).append(" exptFlag=").append(paramInt).append(" list=");
      paramd = paramd.Bey;
      if (paramd != null) {
        break label413;
      }
    }
    label392:
    label398:
    label408:
    label413:
    for (paramInt = 0;; paramInt = paramd.size())
    {
      Log.i("Finder.FriendsTabBackFoldedInterceptor", paramInt);
      AppMethodBeat.o(336764);
      return false;
      localObject1 = ((aq.d)localObject1).dVm();
      if (localObject1 == null)
      {
        paramInt = 0;
        break;
      }
      localObject1 = ((aq.c)localObject1).CJv;
      if (localObject1 == null)
      {
        paramInt = 0;
        break;
      }
      paramInt = ((atz)localObject1).ZEr;
      break;
      bool = false;
      break label40;
      localObject1 = ((aq.d)localObject1).dVm();
      break label274;
      i = 0;
      break label285;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/FinderFriendsTabBackFoldedInterceptor$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "rv", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<cc, Boolean>
  {
    b(LinkedList<FinderObject> paramLinkedList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.interceptor.b
 * JD-Core Version:    0.7.0.1
 */