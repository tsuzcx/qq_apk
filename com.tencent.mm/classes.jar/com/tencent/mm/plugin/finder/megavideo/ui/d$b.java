package com.tencent.mm.plugin.finder.megavideo.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderMegaVideoProfileLoader;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.profile.uic.FinderProfileTabUIC;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "rootView", "Landroid/view/View;", "targetUsername", "", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;Ljava/lang/String;)V", "getTargetUsername", "()Ljava/lang/String;", "getActivity", "getEmptyView", "kotlin.jvm.PlatformType", "getHeaderView", "", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "position", "", "onItemDelete", "onViewPrepared", "requestLoadMore", "showEmptyView", "Companion", "plugin-finder_release"})
public final class d$b
  extends a.b
{
  public static final a zxI;
  private final String xcW;
  
  static
  {
    AppMethodBeat.i(277154);
    zxI = new a((byte)0);
    AppMethodBeat.o(277154);
  }
  
  public d$b(MMActivity paramMMActivity, View paramView, String paramString)
  {
    super(paramMMActivity, paramView);
    AppMethodBeat.i(277153);
    this.xcW = paramString;
    AppMethodBeat.o(277153);
  }
  
  public final void b(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(277148);
    p.k(parama, "adapter");
    p.k(paramView, "view");
    Log.i("FinderLikeMegaVideoUIContract.ViewCallback", "onItemClick: position=".concat(String.valueOf(paramInt)));
    paramInt -= ((h)parama).YSk.size();
    if ((paramInt >= 0) && (paramInt < dJS().zxg.getSize()))
    {
      Object localObject = (bu)dJS().zxg.getDataListJustForAdapter().get(paramInt);
      if (!(localObject instanceof bs))
      {
        AppMethodBeat.o(277148);
        return;
      }
      Log.i("FinderLikeMegaVideoUIContract.ViewCallback", "onItemClick " + paramInt + " id:" + ((bu)localObject).mf() + ", pos:" + paramInt);
      if (((bs)localObject).zBs != null)
      {
        parama = ((bs)localObject).zBs;
        if (parama == null) {
          p.iCn();
        }
        if (!parama.isPostFinish())
        {
          parama = new csf();
          paramView = parama.mediaList;
          localObject = ((bs)localObject).zBs;
          if (localObject == null) {
            p.iCn();
          }
          paramView.addAll((Collection)((FinderItem)localObject).getLongVideoMediaList());
          paramView = a.ACH;
          paramView = dlC();
          if (paramView == null)
          {
            parama = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(277148);
            throw parama;
          }
          a.a((Activity)paramView, null, parama, null, true, false, 40);
          AppMethodBeat.o(277148);
          return;
        }
      }
      parama = new Intent();
      parama.putExtra("KEY_ROUTER_UI", 3);
      parama.putExtra("finder_username", this.xcW);
      parama.putExtra("KEY_FINDER_SELF_FLAG", p.h(this.xcW, z.bdh()));
      BaseFeedLoader.saveCache$default(dJS().zxg, parama, paramInt, null, 4, null);
      localObject = aj.Bnu;
      aj.a.a((Context)dlC(), parama, 0L, 0, false, 124);
      localObject = a.ACH;
      paramView = paramView.getContext();
      p.j(paramView, "view.context");
      a.am(paramView, parama);
    }
    AppMethodBeat.o(277148);
  }
  
  public final void bTY()
  {
    AppMethodBeat.i(277149);
    super.bTY();
    g localg = g.Xox;
    ((FinderProfileTabUIC)g.b((AppCompatActivity)dlC()).i(FinderProfileTabUIC.class)).qb(true);
    AppMethodBeat.o(277149);
  }
  
  public final void dsL()
  {
    AppMethodBeat.i(277147);
    if (dJR().zxg.getSize() <= 9)
    {
      Object localObject = dJR().zxg;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.megavideo.loader.FinderMegaVideoProfileLoader");
        AppMethodBeat.o(277147);
        throw ((Throwable)localObject);
      }
      if (((FinderMegaVideoProfileLoader)localObject).hasMore) {
        RefreshLoadMoreLayout.c(this.xvJ);
      }
    }
    AppMethodBeat.o(277147);
  }
  
  public final void dsm()
  {
    AppMethodBeat.i(277146);
    this.xvJ.setSuperNestedScroll(true);
    this.xvJ.setEnableRefresh(false);
    super.dsm();
    AppMethodBeat.o(277146);
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(277151);
    View localView = getRootView().findViewById(b.f.empty_view);
    AppMethodBeat.o(277151);
    return localView;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$ViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.d.b
 * JD-Core Version:    0.7.0.1
 */