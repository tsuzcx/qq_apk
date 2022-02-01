package com.tencent.mm.plugin.finder.live.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.b.a;
import com.tencent.mm.plugin.finder.event.recyclerview.FinderRecyclerView;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorRoleUI;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.utils.x;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.findersdk.a.ay;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.protocal.protobuf.cbw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVisitorGameRankSwitchUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveVisitorGameRankSwitchUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVisitorGameRankSwitchUIC$GameRankSwitchFeed;", "Lkotlin/collections/ArrayList;", "isLiveRoleUI", "", "()Z", "setLiveRoleUI", "(Z)V", "liveId", "", "loadingProgress", "Landroid/widget/ProgressBar;", "objectId", "recyclerView", "Lcom/tencent/mm/plugin/finder/event/recyclerview/FinderRecyclerView;", "rootLayout", "Landroid/view/View;", "switchChangedCallback", "Lkotlin/Function2;", "", "getSwitchChangedCallback", "()Lkotlin/jvm/functions/Function2;", "switchInfo", "Lcom/tencent/mm/protocal/protobuf/GameRankSwitchInfo;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "GameRankSwitchConvert", "GameRankSwitchFeed", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends UIComponent
  implements ay
{
  private View DOL;
  private FinderRecyclerView DZA;
  private ProgressBar DZB;
  private cbw DZC;
  boolean DZD;
  final kotlin.g.a.m<b, Boolean, ah> DZE;
  private long hKN;
  private long liveId;
  private ArrayList<b> pUj;
  
  public m(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(356153);
    this.pUj = new ArrayList();
    this.DZE = ((kotlin.g.a.m)new d(this, paramAppCompatActivity));
    AppMethodBeat.o(356153);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(356194);
    super.onCreate(paramBundle);
    this.DZD = (getActivity() instanceof FinderLiveVisitorRoleUI);
    paramBundle = com.tencent.mm.kernel.h.baE().ban().get(at.a.adfm, "");
    if (paramBundle == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(356194);
      throw paramBundle;
    }
    Object localObject = (String)paramBundle;
    if (!Util.isNullOrNil((String)localObject))
    {
      paramBundle = (com.tencent.mm.bx.a)new cbw();
      localObject = Util.decodeHexString((String)localObject);
    }
    try
    {
      paramBundle.parseFrom((byte[])localObject);
      this.DZC = ((cbw)paramBundle);
      paramBundle = this.DZC;
      if (paramBundle != null)
      {
        localObject = x.GgW;
        x.a(paramBundle, "SimpleUIComponent_get");
      }
      this.liveId = getActivity().getIntent().getLongExtra("LIVE_ID", 0L);
      this.hKN = getActivity().getIntent().getLongExtra("OBJECT_ID", 0L);
      this.DOL = getActivity().findViewById(p.e.live_game_rank_switch_group);
      this.DZA = ((FinderRecyclerView)getActivity().findViewById(p.e.live_game_rank_switch_rv));
      this.DZB = ((ProgressBar)findViewById(p.e.loading_progress));
      if (this.DZC != null)
      {
        paramBundle = this.DZC;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.aalh;
          if ((paramBundle != null) && (!paramBundle.isEmpty()))
          {
            i = 1;
            if (i != 0) {
              break label300;
            }
          }
        }
      }
      else
      {
        paramBundle = this.DOL;
        if (paramBundle != null) {
          paramBundle.setVisibility(8);
        }
        if (this.DZD) {
          com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, 4, null, 6);
        }
        AppMethodBeat.o(356194);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { paramBundle });
        paramBundle = null;
        continue;
        int i = 0;
        continue;
        label300:
        paramBundle = this.DOL;
        if (paramBundle != null) {
          paramBundle.setVisibility(0);
        }
        paramBundle = this.DZC;
        if (paramBundle == null) {}
        for (paramBundle = null;; paramBundle = paramBundle.aalh)
        {
          localObject = this.DZA;
          if ((paramBundle == null) || (localObject == null)) {
            break;
          }
          paramBundle = ((Iterable)paramBundle).iterator();
          while (paramBundle.hasNext())
          {
            cbv localcbv = (cbv)paramBundle.next();
            ArrayList localArrayList = this.pUj;
            s.s(localcbv, "it");
            localArrayList.add(new b(localcbv));
          }
        }
        ((FinderRecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new FinderLinearLayoutManager((Context)getActivity()));
        ((FinderRecyclerView)localObject).setAdapter((RecyclerView.a)new WxRecyclerAdapter((g)new c(this), this.pUj));
        paramBundle = new androidx.recyclerview.widget.h((Context)getActivity(), 1);
        paramBundle.w(getActivity().getResources().getDrawable(p.d.BzI));
        ((RecyclerView)localObject).a((RecyclerView.h)paramBundle);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVisitorGameRankSwitchUIC$GameRankSwitchFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "switchInfo", "Lcom/tencent/mm/protocal/protobuf/GameRankSwitch;", "(Lcom/tencent/mm/protocal/protobuf/GameRankSwitch;)V", "getSwitchInfo", "()Lcom/tencent/mm/protocal/protobuf/GameRankSwitch;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements cc
  {
    final cbv DZF;
    
    public b(cbv paramcbv)
    {
      AppMethodBeat.i(356377);
      this.DZF = paramcbv;
      AppMethodBeat.o(356377);
    }
    
    public final int a(com.tencent.mm.plugin.finder.feed.model.internal.k paramk)
    {
      AppMethodBeat.i(356400);
      s.u(paramk, "obj");
      AppMethodBeat.o(356400);
      return -1;
    }
    
    public final long bZA()
    {
      AppMethodBeat.i(356383);
      String str = this.DZF.ZGM;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        long l = i;
        AppMethodBeat.o(356383);
        return l;
      }
    }
    
    public final int bZB()
    {
      AppMethodBeat.i(356392);
      int i = b.class.hashCode();
      AppMethodBeat.o(356392);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVisitorGameRankSwitchUIC$onCreate$1$2", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements g
  {
    c(m paramm) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(356401);
      if (paramInt == m.b.class.hashCode())
      {
        localf = (com.tencent.mm.view.recyclerview.f)new m.a(this.DZG.DZE);
        AppMethodBeat.o(356401);
        return localf;
      }
      com.tencent.mm.view.recyclerview.f localf = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).bUi();
      AppMethodBeat.o(356401);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "item", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVisitorGameRankSwitchUIC$GameRankSwitchFeed;", "isCheck", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.m<m.b, Boolean, ah>
  {
    d(m paramm, AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
    
    private static final ah a(m paramm, boolean paramBoolean, m.b paramb, b.a parama)
    {
      AppMethodBeat.i(356411);
      s.u(paramm, "this$0");
      s.u(paramb, "$item");
      d.uiThread((kotlin.g.a.a)new a(paramm));
      Object localObject2;
      Object localObject3;
      if ((parama.errType == 0) && (parama.errCode == 0))
      {
        parama = m.d(paramm);
        if (parama != null)
        {
          parama = parama.aalh;
          if (parama != null)
          {
            localObject1 = ((Iterable)parama).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              parama = (cbv)((Iterator)localObject1).next();
              if (s.p(parama.ZGM, paramb.DZF.ZGM))
              {
                parama.aalf = paramb.DZF.aalf;
                parama = m.d(paramm);
                if (parama != null)
                {
                  localObject2 = x.GgW;
                  x.a(parama, "SimpleUIComponent_set");
                }
                localObject2 = com.tencent.mm.kernel.h.baE().ban();
                localObject3 = at.a.adfm;
                parama = m.d(paramm);
                if (parama == null) {}
                for (parama = null;; parama = parama.toByteArray())
                {
                  ((aq)localObject2).set((at.a)localObject3, Util.encodeHexString(parama));
                  break;
                }
              }
            }
          }
        }
        if (paramm.DZD)
        {
          if (!paramBoolean) {
            break label239;
          }
          parama = com.tencent.mm.plugin.finder.live.report.k.Doi;
          paramb = paramb.DZF.ZGM;
          paramm = paramb;
          if (paramb == null) {
            paramm = "";
          }
          com.tencent.mm.plugin.finder.live.report.k.a(parama, 5, paramm, 4);
        }
        for (;;)
        {
          paramm = ah.aiuX;
          AppMethodBeat.o(356411);
          return paramm;
          label239:
          parama = com.tencent.mm.plugin.finder.live.report.k.Doi;
          paramb = paramb.DZF.ZGM;
          paramm = paramb;
          if (paramb == null) {
            paramm = "";
          }
          com.tencent.mm.plugin.finder.live.report.k.a(parama, 7, paramm, 4);
        }
      }
      Object localObject1 = paramb.DZF;
      if (paramBoolean) {}
      for (int i = 0;; i = 1)
      {
        ((cbv)localObject1).aalf = i;
        localObject3 = new StringBuilder("CgiFinderLiveModBasicInfo failed, reset ");
        localObject2 = paramb.DZF.ZGM;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        Log.i("SimpleUIComponent", (String)localObject1 + ", " + paramb.DZF.aalf);
        if ((!paramm.DZD) || (!paramBoolean)) {
          break;
        }
        localObject1 = com.tencent.mm.plugin.finder.live.report.k.Doi;
        paramb = paramb.DZF.ZGM;
        paramm = paramb;
        if (paramb == null) {
          paramm = "";
        }
        ((com.tencent.mm.plugin.finder.live.report.k)localObject1).p(6, paramm, parama.errCode);
        break;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(m paramm)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.m
 * JD-Core Version:    0.7.0.1
 */