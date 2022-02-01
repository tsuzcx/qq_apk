package com.tencent.mm.plugin.finder.megavideo.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderMegaVideoProfileLoader;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.profile.uic.FinderProfileTabUIC;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "rootView", "Landroid/view/View;", "targetUsername", "", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;Ljava/lang/String;)V", "getTargetUsername", "()Ljava/lang/String;", "getActivity", "getEmptyView", "kotlin.jvm.PlatformType", "getHeaderView", "", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "", "onItemDelete", "onViewPrepared", "requestLoadMore", "showEmptyView", "Companion", "plugin-finder_release"})
public final class d$b
  extends a.b
{
  public static final a uLV;
  private final String tvp;
  
  static
  {
    AppMethodBeat.i(248529);
    uLV = new a((byte)0);
    AppMethodBeat.o(248529);
  }
  
  public d$b(MMActivity paramMMActivity, View paramView, String paramString)
  {
    super(paramMMActivity, paramView);
    AppMethodBeat.i(248528);
    this.tvp = paramString;
    AppMethodBeat.o(248528);
  }
  
  public final void b(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(248525);
    p.h(parama, "adapter");
    p.h(paramView, "view");
    Log.i("FinderLikeMegaVideoUIContract.ViewCallback", "onItemClick: position=".concat(String.valueOf(paramInt)));
    paramInt -= ((g)parama).RqM.size();
    if ((paramInt >= 0) && (paramInt < dkn().uLF.getSize()))
    {
      Object localObject = (bo)dkn().uLF.getDataListJustForAdapter().get(paramInt);
      if (!(localObject instanceof bm))
      {
        AppMethodBeat.o(248525);
        return;
      }
      Log.i("FinderLikeMegaVideoUIContract.ViewCallback", "onItemClick " + paramInt + " id:" + ((bo)localObject).lT() + ", pos:" + paramInt);
      if (((bm)localObject).uOW != null)
      {
        parama = ((bm)localObject).uOW;
        if (parama == null) {
          p.hyc();
        }
        if (!parama.isPostFinish())
        {
          parama = new cjk();
          paramView = parama.mediaList;
          localObject = ((bm)localObject).uOW;
          if (localObject == null) {
            p.hyc();
          }
          paramView.addAll((Collection)((FinderItem)localObject).getLongVideoMediaList());
          paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
          paramView = this.gte;
          if (paramView == null)
          {
            parama = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(248525);
            throw parama;
          }
          com.tencent.mm.plugin.finder.utils.a.a((Activity)paramView, null, parama, null, true, 8);
          AppMethodBeat.o(248525);
          return;
        }
      }
      parama = new Intent();
      parama.putExtra("KEY_ROUTER_UI", 3);
      parama.putExtra("finder_username", this.tvp);
      parama.putExtra("KEY_FINDER_SELF_FLAG", p.j(this.tvp, z.aUg()));
      BaseFeedLoader.saveCache$default(dkn().uLF, parama, paramInt, null, 4, null);
      localObject = FinderReporterUIC.wzC;
      FinderReporterUIC.a.a((Context)this.gte, parama, 0L, 0, false, 124);
      localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
      paramView = paramView.getContext();
      p.g(paramView, "view.context");
      com.tencent.mm.plugin.finder.utils.a.ag(paramView, parama);
    }
    AppMethodBeat.o(248525);
  }
  
  public final void bIo()
  {
    AppMethodBeat.i(248526);
    super.bIo();
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
    ((FinderProfileTabUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.gte).get(FinderProfileTabUIC.class)).nR(true);
    AppMethodBeat.o(248526);
  }
  
  public final void dbY()
  {
    AppMethodBeat.i(248523);
    this.tLS.setSuperNestedScroll(true);
    this.tLS.setEnableRefresh(false);
    super.dbY();
    AppMethodBeat.o(248523);
  }
  
  public final void dcv()
  {
    AppMethodBeat.i(248524);
    if (dkm().uLF.getSize() <= 9)
    {
      Object localObject = dkm().uLF;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.megavideo.loader.FinderMegaVideoProfileLoader");
        AppMethodBeat.o(248524);
        throw ((Throwable)localObject);
      }
      if (((FinderMegaVideoProfileLoader)localObject).hasMore) {
        RefreshLoadMoreLayout.c(this.tLS);
      }
    }
    AppMethodBeat.o(248524);
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(248527);
    View localView = this.lJI.findViewById(2131300111);
    AppMethodBeat.o(248527);
    return localView;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$ViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.d.b
 * JD-Core Version:    0.7.0.1
 */