package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bro;
import com.tencent.mm.protocal.protobuf.bux;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderSingleFeedReportHandler;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedScrollBaseHandler;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "onAttach", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView;", "onCenterFeedChange", "ev", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "onDetach", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class as
  extends n
{
  public static final a AYT;
  
  static
  {
    AppMethodBeat.i(363046);
    AYT = new a((byte)0);
    AppMethodBeat.o(363046);
  }
  
  public as(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(363036);
    AppMethodBeat.o(363036);
  }
  
  public final void a(h paramh)
  {
    Object localObject2 = null;
    AppMethodBeat.i(363091);
    s.u(paramh, "ev");
    Object localObject1;
    label61:
    Object localObject3;
    int i;
    if (paramh.AOy != null)
    {
      Log.i("Finder.SingleFeedReport", s.X("onCenterFeedChange: ", d.hF(paramh.AOv)));
      localObject1 = this.mkw;
      if (localObject1 != null) {
        break label305;
      }
      localObject1 = null;
      if (!(localObject1 instanceof WxRecyclerAdapter)) {
        break label313;
      }
      localObject1 = (WxRecyclerAdapter)localObject1;
      localObject3 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      localObject3 = com.tencent.mm.plugin.finder.viewmodel.component.as.a.hu((Context)getActivity());
      if (localObject3 != null) {
        break label318;
      }
      i = 0;
      switch (i)
      {
      default: 
        label85:
        if (localObject1 != null)
        {
          localObject1 = (j)com.tencent.mm.view.recyclerview.i.c((com.tencent.mm.view.recyclerview.i)localObject1, paramh.AOv);
          if (localObject1 != null)
          {
            localObject1 = ((j)localObject1).CSA;
            if (localObject1 != null)
            {
              if (!(localObject1 instanceof BaseFinderFeed)) {
                break label333;
              }
              localObject1 = (BaseFinderFeed)localObject1;
              if (localObject1 != null)
              {
                localObject3 = ((BaseFinderFeed)localObject1).feedObject.getFinderObject().hotWordInfo;
                if (localObject3 != null) {
                  break label338;
                }
                localObject1 = null;
                if (localObject1 != null)
                {
                  localObject1 = ((bro)localObject3).ZZO;
                  if (localObject1 != null) {
                    break label347;
                  }
                  localObject1 = null;
                  if (!Util.isNullOrNil((String)localObject1))
                  {
                    localObject1 = new com.tencent.mm.ad.i();
                    ((com.tencent.mm.ad.i)localObject1).m("feedid", d.hF(paramh.AOv));
                    paramh = ((bro)localObject3).ZZO;
                    if (paramh != null) {
                      break label355;
                    }
                    paramh = null;
                    label236:
                    ((com.tencent.mm.ad.i)localObject1).m("query_word", paramh);
                    paramh = z.FrZ;
                    paramh = ((com.tencent.mm.ad.i)localObject1).toString();
                    s.s(paramh, "kvJson.toString()");
                    localObject1 = kotlin.n.n.m(paramh, ",", ";", false);
                    paramh = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
                    paramh = com.tencent.mm.plugin.finder.viewmodel.component.as.a.hu((Context)getActivity());
                    if (paramh != null) {
                      break label363;
                    }
                  }
                }
              }
            }
          }
        }
        label156:
        label179:
        label195:
        break;
      }
    }
    label305:
    label313:
    label318:
    label333:
    label338:
    label347:
    label355:
    label363:
    for (paramh = localObject2;; paramh = paramh.fou())
    {
      z.b(0, "hotsearch_timelinespot", (String)localObject1, paramh);
      AppMethodBeat.o(363091);
      return;
      localObject1 = ((RecyclerView)localObject1).getAdapter();
      break;
      localObject1 = null;
      break label61;
      i = ((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject3).AJo;
      break label85;
      AppMethodBeat.o(363091);
      return;
      localObject1 = null;
      break label156;
      localObject1 = ((bro)localObject3).ZZO;
      break label179;
      localObject1 = ((bux)localObject1).aacq;
      break label195;
      paramh = paramh.aacq;
      break label236;
    }
  }
  
  public final void onDetach()
  {
    this.mkw = null;
  }
  
  public final void q(RecyclerView paramRecyclerView)
  {
    this.mkw = paramRecyclerView;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderSingleFeedReportHandler$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.as
 * JD-Core Version:    0.7.0.1
 */