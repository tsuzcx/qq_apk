package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.f.a.ih;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.feed.model.a;
import com.tencent.mm.plugin.finder.feed.model.k;
import com.tencent.mm.plugin.finder.live.component.y;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.TouchableLayout;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedMutualAdHandler;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedScrollBaseHandler;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "adCache", "Lcom/tencent/mm/plugin/finder/feed/model/AdMutualCache;", "adFeedUiActionListener", "com/tencent/mm/plugin/finder/feed/FinderFeedMutualAdHandler$adFeedUiActionListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedMutualAdHandler$adFeedUiActionListener$1;", "adLinkVisibleRunnable", "Ljava/lang/Runnable;", "adType", "", "exposeRecord", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedMutualAdHandler$ExposeRecord;", "preLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getAdSize", "Lkotlin/Pair;", "getMutualAdInfo", "", "cache", "getViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onAttach", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView;", "onCenterFeedChange", "ev", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "onDetach", "reportAdExpose", "id", "", "reportClick", "duration", "curPos", "clickPosX", "clickPosY", "reportExpose", "setAdSize", "Companion", "ExposeRecord", "plugin-finder_release"})
public final class l
  extends o
{
  public static final a xyh;
  private final int adType;
  private k xyc;
  private a xyd;
  private l.b xye;
  private final Runnable xyf;
  private final c xyg;
  
  static
  {
    AppMethodBeat.i(267432);
    xyh = new a((byte)0);
    AppMethodBeat.o(267432);
  }
  
  public l(final MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(267431);
    this.adType = 1;
    this.xyf = ((Runnable)new d(this, paramMMActivity));
    this.xyg = new c(this);
    AppMethodBeat.o(267431);
  }
  
  private static String a(a parama)
  {
    AppMethodBeat.i(267430);
    i locali = new i();
    locali.g("uxinfo", parama.jDL);
    parama = locali.toString();
    p.j(parama, "mutualAdInfo.toString()");
    AppMethodBeat.o(267430);
    return parama;
  }
  
  private final void a(long paramLong, a parama)
  {
    AppMethodBeat.i(267429);
    Log.i("Finder.FeedAdHandler", "reportExpose id:" + paramLong + ", cache:" + parama);
    Object localObject = n.zWF;
    localObject = a(parama);
    parama = aj.Bnu;
    parama = aj.a.fZ((Context)getActivity());
    if (parama != null) {}
    for (parama = parama.ekY();; parama = null)
    {
      n.a(paramLong, 1, 1, 0, 0, (String)localObject, parama);
      AppMethodBeat.o(267429);
      return;
    }
  }
  
  private final void dtd()
  {
    Object localObject3 = null;
    AppMethodBeat.i(267425);
    a locala = this.xyd;
    if (locala != null)
    {
      label185:
      if ((locala.xFy <= 0) || (locala.xFz <= 0))
      {
        Object localObject1 = this.jLl;
        int i;
        int j;
        if (localObject1 != null)
        {
          localObject1 = ((RecyclerView)localObject1).getAdapter();
          if (localObject1 != null)
          {
            i = ((RecyclerView.a)localObject1).getItemCount();
            j = this.xyn;
            if (j >= 0) {
              break label185;
            }
          }
        }
        label68:
        for (Object localObject2 = null;; localObject2 = ((RecyclerView)localObject1).cK(this.xyn))
        {
          localObject1 = localObject3;
          if (localObject2 != null)
          {
            localObject2 = ((RecyclerView.v)localObject2).amk;
            localObject1 = localObject3;
            if (localObject2 != null)
            {
              localObject2 = (TouchableLayout)((View)localObject2).findViewById(b.f.finder_feed_ad_link_container);
              localObject1 = localObject3;
              if (localObject2 != null) {
                localObject1 = new kotlin.o(Integer.valueOf(((TouchableLayout)localObject2).getWidth()), Integer.valueOf(((TouchableLayout)localObject2).getHeight()));
              }
            }
          }
          if (localObject1 == null) {
            break label212;
          }
          locala.xFy = ((Number)((kotlin.o)localObject1).Mx).intValue();
          locala.xFz = ((Number)((kotlin.o)localObject1).My).intValue();
          AppMethodBeat.o(267425);
          return;
          i = 0;
          break;
          if (i <= j) {
            break label68;
          }
          localObject1 = this.jLl;
          if (localObject1 == null) {
            break label68;
          }
        }
      }
      label212:
      AppMethodBeat.o(267425);
      return;
    }
    AppMethodBeat.o(267425);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(267428);
    p.k(paramh, "ev");
    if (paramh.xrl == 0L)
    {
      Log.i("Finder.FeedAdHandler", "onCenterFeedChange : ev".concat(String.valueOf(paramh)));
      AppMethodBeat.o(267428);
      return;
    }
    this.xyd = null;
    Object localObject1 = this.xyc;
    if (localObject1 != null) {}
    for (localObject1 = ((k)localObject1).I(paramh.xrl, this.adType);; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (!(localObject1 instanceof a)) {
        localObject2 = null;
      }
      this.xyd = ((a)localObject2);
      this.xye = new l.b(paramh.xrl);
      localObject2 = this.xyd;
      if (localObject2 != null)
      {
        a(paramh.xrl, (a)localObject2);
        dtd();
        paramh = aj.Bnu;
        paramh = aj.a.fZ((Context)getActivity());
        if (paramh != null)
        {
          localObject1 = paramh.wmL;
          paramh = (h)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramh = "";
        }
        localObject1 = n.zWF;
        n.a(paramh, false, ((a)localObject2).xFA, ((a)localObject2).xFy, ((a)localObject2).xFz, ((a)localObject2).xFx);
        ((a)localObject2).xpx = true;
        paramh = this.jLl;
        if (paramh != null) {
          paramh.removeCallbacks(this.xyf);
        }
        paramh = this.jLl;
        if (paramh != null) {
          paramh.postDelayed(this.xyf, 1000L);
        }
        paramh = this.xye;
        if (paramh != null) {
          paramh.xpx = true;
        }
      }
      paramh = this.jLl;
      if (paramh == null) {
        break;
      }
      paramh.removeCallbacks(this.xyf);
      AppMethodBeat.o(267428);
      return;
    }
    AppMethodBeat.o(267428);
  }
  
  public final void m(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(267426);
    g localg = g.Xox;
    this.xyc = ((y)g.b((AppCompatActivity)getActivity()).i(y.class)).yci;
    this.jLl = paramRecyclerView;
    this.xyg.alive();
    AppMethodBeat.o(267426);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(267427);
    this.xyc = null;
    this.xyg.dead();
    AppMethodBeat.o(267427);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedMutualAdHandler$Companion;", "", "()V", "DELAY_EXPOSE_TIME", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderFeedMutualAdHandler$adFeedUiActionListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderFeedUiActionEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends IListener<ih>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(l paraml, MMActivity paramMMActivity) {}
    
    public final void run()
    {
      AppMethodBeat.i(272535);
      l.a(this.xyi);
      a locala = l.b(this.xyi);
      if (locala != null)
      {
        if (!locala.xFv)
        {
          Object localObject1 = aj.Bnu;
          localObject1 = aj.a.fZ((Context)paramMMActivity);
          if (localObject1 != null)
          {
            localObject2 = ((aj)localObject1).wmL;
            localObject1 = localObject2;
            if (localObject2 != null) {}
          }
          else
          {
            localObject1 = "";
          }
          Object localObject2 = n.zWF;
          n.a((String)localObject1, true, locala.xFA, locala.xFy, locala.xFz, locala.xFx);
          locala.xFv = true;
        }
        AppMethodBeat.o(272535);
        return;
      }
      AppMethodBeat.o(272535);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.l
 * JD-Core Version:    0.7.0.1
 */