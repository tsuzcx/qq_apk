package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bgd;
import com.tencent.mm.protocal.protobuf.bio;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderSingleFeedReportHandler;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedScrollBaseHandler;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "onAttach", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView;", "onCenterFeedChange", "ev", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "onDetach", "Companion", "plugin-finder_release"})
public final class al
  extends o
{
  public static final a xBC;
  
  static
  {
    AppMethodBeat.i(280187);
    xBC = new a((byte)0);
    AppMethodBeat.o(280187);
  }
  
  public al(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(280186);
    AppMethodBeat.o(280186);
  }
  
  public final void a(com.tencent.mm.plugin.finder.event.base.h paramh)
  {
    Object localObject3 = null;
    AppMethodBeat.i(280185);
    p.k(paramh, "ev");
    if (paramh.xro != null)
    {
      Log.i("Finder.SingleFeedReport", "onCenterFeedChange: " + d.Fw(paramh.xrl));
      Object localObject1 = this.jLl;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((RecyclerView)localObject1).getAdapter();
        localObject2 = localObject1;
        if (!(localObject1 instanceof WxRecyclerAdapter)) {
          localObject2 = null;
        }
        localObject1 = (WxRecyclerAdapter)localObject2;
        localObject2 = aj.Bnu;
        localObject2 = aj.a.fZ((Context)getActivity());
        if (localObject2 == null) {
          break label132;
        }
      }
      label132:
      for (int i = ((aj)localObject2).xkX;; i = 0)
      {
        if ((i != 23) && (i != 6)) {
          break label137;
        }
        AppMethodBeat.o(280185);
        return;
        localObject1 = null;
        break;
      }
      label137:
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.view.recyclerview.i)com.tencent.mm.view.recyclerview.h.c((com.tencent.mm.view.recyclerview.h)localObject1, paramh.xrl);
        if (localObject1 != null)
        {
          localObject2 = ((com.tencent.mm.view.recyclerview.i)localObject1).ihX();
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (!(localObject2 instanceof BaseFinderFeed)) {
              localObject1 = null;
            }
            localObject1 = (BaseFinderFeed)localObject1;
            if (localObject1 != null)
            {
              localObject2 = ((BaseFinderFeed)localObject1).feedObject.getFinderObject().hotWordInfo;
              if (localObject2 != null)
              {
                localObject1 = ((bgd)localObject2).SRb;
                if (localObject1 != null)
                {
                  localObject1 = ((bgd)localObject2).SRb;
                  if (localObject1 == null) {
                    break label358;
                  }
                  localObject1 = ((bio)localObject1).SSO;
                  label232:
                  if (!Util.isNullOrNil((String)localObject1))
                  {
                    localObject1 = new com.tencent.mm.ad.i();
                    ((com.tencent.mm.ad.i)localObject1).g("feedid", d.Fw(paramh.xrl));
                    paramh = ((bgd)localObject2).SRb;
                    if (paramh == null) {
                      break label363;
                    }
                  }
                }
              }
              label358:
              label363:
              for (paramh = paramh.SSO;; paramh = null)
              {
                ((com.tencent.mm.ad.i)localObject1).g("query_word", paramh);
                paramh = com.tencent.mm.plugin.finder.report.n.zWF;
                paramh = ((com.tencent.mm.ad.i)localObject1).toString();
                p.j(paramh, "kvJson.toString()");
                localObject1 = kotlin.n.n.l(paramh, ",", ";", false);
                paramh = aj.Bnu;
                localObject2 = aj.a.fZ((Context)getActivity());
                paramh = localObject3;
                if (localObject2 != null) {
                  paramh = ((aj)localObject2).ekY();
                }
                com.tencent.mm.plugin.finder.report.n.b(0, "hotsearch_timelinespot", (String)localObject1, paramh);
                AppMethodBeat.o(280185);
                return;
                localObject1 = null;
                break;
                localObject1 = null;
                break label232;
              }
            }
            AppMethodBeat.o(280185);
            return;
          }
          AppMethodBeat.o(280185);
          return;
        }
      }
    }
    AppMethodBeat.o(280185);
  }
  
  public final void m(RecyclerView paramRecyclerView)
  {
    this.jLl = paramRecyclerView;
  }
  
  public final void onDetach()
  {
    this.jLl = null;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderSingleFeedReportHandler$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.al
 * JD-Core Version:    0.7.0.1
 */