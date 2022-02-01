package com.tencent.mm.plugin.finder.feed;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bt;
import com.tencent.mm.plugin.finder.convert.q;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ba;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.report.az;
import com.tencent.mm.plugin.finder.report.az.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "isSelf", "(ILcom/tencent/mm/ui/MMActivity;ZZ)V", "feedChangeListener", "com/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$feedChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$feedChangeListener$1;", "feedList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "()Z", "getSafeMode", "getScene", "()I", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "createSecondMenu", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "dealMenuClick", "menuItem", "Landroid/view/MenuItem;", "index", "from", "getDataAt", "getDataIndex", "getFeed", "getFeedList", "getVideoData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "initViewCallback", "isFinderSelfScene", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "onDetach", "removeDataAt", "requestRefresh", "updateFeed", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class k$a
  extends b.a
{
  private final FinderFeedDetailUIContract.Presenter.feedChangeListener.1 AVg;
  public ArrayList<cc> feedList;
  private final boolean hHq;
  final boolean safeMode;
  private final int scene;
  Dialog tipDialog;
  
  private k$a(int paramInt, MMActivity paramMMActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramMMActivity);
    AppMethodBeat.i(363872);
    this.scene = paramInt;
    this.safeMode = paramBoolean1;
    this.hHq = paramBoolean2;
    this.feedList = new ArrayList();
    this.AVg = new FinderFeedDetailUIContract.Presenter.feedChangeListener.1(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(363872);
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(363884);
    kotlin.g.b.s.u(parama, "this$0");
    as.a locala = as.GSQ;
    parama = as.a.hu((Context)parama.lzt);
    if (parama != null)
    {
      parama = ((bn)parama).Vm(-1);
      if (parama != null) {
        new az(parama).eNW().ST(0);
      }
    }
    AppMethodBeat.o(363884);
  }
  
  private static final void a(BaseFinderFeed paramBaseFinderFeed, final a parama, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(363897);
    kotlin.g.b.s.u(paramBaseFinderFeed, "$feed");
    kotlin.g.b.s.u(parama, "this$0");
    paramDialogInterface = z.bAW();
    kotlin.g.b.s.s(paramDialogInterface, "getMyFinderUsername()");
    paramDialogInterface = new bt(paramDialogInterface, paramBaseFinderFeed.feedObject.getFeedObject());
    paramBaseFinderFeed = parama.tipDialog;
    if (paramBaseFinderFeed == null) {}
    for (paramBaseFinderFeed = null;; paramBaseFinderFeed = ah.aiuX)
    {
      if (paramBaseFinderFeed == null)
      {
        paramBaseFinderFeed = (Context)parama.lzt;
        parama.lzt.getString(e.h.app_tip);
        parama.tipDialog = ((Dialog)com.tencent.mm.ui.base.k.a(paramBaseFinderFeed, parama.lzt.getString(e.h.app_waiting), false, k.a..ExternalSyntheticLambda0.INSTANCE));
      }
      com.tencent.mm.kernel.h.aZW().a(paramDialogInterface.getType(), (com.tencent.mm.am.h)new b(paramDialogInterface, parama));
      com.tencent.mm.kernel.h.aZW().a((p)paramDialogInterface, 0);
      AppMethodBeat.o(363897);
      return;
      paramBaseFinderFeed.show();
    }
  }
  
  private static final void g(DialogInterface paramDialogInterface) {}
  
  public final cc NC(int paramInt)
  {
    AppMethodBeat.i(363945);
    cc localcc = dYK();
    AppMethodBeat.o(363945);
    return localcc;
  }
  
  public final void a(b.b paramb)
  {
    AppMethodBeat.i(165714);
    kotlin.g.b.s.u(paramb, "callback");
    super.a(paramb);
    this.AVg.alive();
    com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
    ((com.tencent.mm.plugin.finder.viewmodel.component.t)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.t.class)).E(paramb.ATx.getRecyclerView());
    AppMethodBeat.o(165714);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, MenuItem paramMenuItem, int paramInt1, int paramInt2, j paramj)
  {
    AppMethodBeat.i(363992);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramMenuItem, "menuItem");
    kotlin.g.b.s.u(paramj, "holder");
    super.a(paramBaseFinderFeed, paramMenuItem, paramInt1, paramInt2, paramj);
    if (paramMenuItem.getItemId() == ebo())
    {
      paramInt1 = e.h.finder_profile_confirm_del;
      com.tencent.mm.ui.base.k.a((Context)this.lzt, paramInt1, 0, new k.a..ExternalSyntheticLambda1(paramBaseFinderFeed, this), null);
      AppMethodBeat.o(363992);
      return;
    }
    if (paramMenuItem.getItemId() == ebu())
    {
      paramMenuItem = ba.EDs;
      ba.a((Context)this.lzt, paramBaseFinderFeed.feedObject.getId(), 1, (b)new c(paramBaseFinderFeed, this));
      AppMethodBeat.o(363992);
      return;
    }
    if (paramMenuItem.getItemId() == ebt())
    {
      paramMenuItem = ba.EDs;
      ba.a((Context)this.lzt, paramBaseFinderFeed.feedObject.getId(), 0, (b)new d(paramBaseFinderFeed, this));
    }
    AppMethodBeat.o(363992);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.base.s params, com.tencent.mm.ui.widget.a.f paramf, j paramj)
  {
    AppMethodBeat.i(363985);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(params, "menu");
    kotlin.g.b.s.u(paramf, "sheet");
    kotlin.g.b.s.u(paramj, "holder");
    if (this.lzt.getIntent().getBooleanExtra("force_show_ad_tip", false))
    {
      if (paramBaseFinderFeed.feedObject.getMentionListSelected() == 2) {
        params.bx(ebu(), e.h.finder_mention_not_show_tip, e.g.icons_outlined_display_off);
      }
    }
    else
    {
      super.a(paramBaseFinderFeed, params, paramf, paramj);
      if (this.hHq)
      {
        params.bx(ebo(), e.h.app_delete, e.g.icons_outlined_delete);
        if (!paramBaseFinderFeed.feedObject.isCommentClose()) {
          break label203;
        }
        params.a(ebn(), (CharSequence)this.lzt.getString(e.h.finder_feed_open_comment), e.g.icons_outlined_comment);
      }
    }
    for (;;)
    {
      Log.i(getTAG(), kotlin.g.b.s.X("createSecond MenumentionListSelected : ", Integer.valueOf(paramBaseFinderFeed.feedObject.getMentionListSelected())));
      AppMethodBeat.o(363985);
      return;
      if (paramBaseFinderFeed.feedObject.getMentionListSelected() != 3) {
        break;
      }
      params.bx(ebt(), e.h.finder_mention_show_tip, e.g.icons_outlined_display_on);
      break;
      label203:
      params.a(ebm(), (CharSequence)this.lzt.getString(e.h.finder_feed_close_comment), e.g.finder_feed_discomment);
    }
  }
  
  public final void bXB() {}
  
  public com.tencent.mm.view.recyclerview.g dUK()
  {
    AppMethodBeat.i(165713);
    com.tencent.mm.view.recyclerview.g localg = (com.tencent.mm.view.recyclerview.g)new a(this);
    AppMethodBeat.o(165713);
    return localg;
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(165708);
    b.b localb = this.ATo;
    if (localb != null) {
      localb.ae(this.feedList);
    }
    AppMethodBeat.o(165708);
  }
  
  public final cc dYK()
  {
    AppMethodBeat.i(363933);
    if (Util.isNullOrNil((List)this.feedList))
    {
      AppMethodBeat.o(363933);
      return null;
    }
    cc localcc = (cc)this.feedList.get(0);
    AppMethodBeat.o(363933);
    return localcc;
  }
  
  public final boolean ebw()
  {
    return this.hHq;
  }
  
  public final DataBuffer<cc> ebx()
  {
    AppMethodBeat.i(363941);
    Object localObject = dYK();
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = new DataBuffer(localObject, null, 2, null))
    {
      localObject = new DataBuffer(null, 1, null);
      AppMethodBeat.o(363941);
      return localObject;
    }
    AppMethodBeat.o(363941);
    return localObject;
  }
  
  public final ArrayList<cc> ecc()
  {
    return this.feedList;
  }
  
  public final void g(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(363926);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    if (this.feedList.size() > 0) {
      this.feedList.set(0, paramBaseFinderFeed);
    }
    for (;;)
    {
      paramBaseFinderFeed = this.ATo;
      if (paramBaseFinderFeed != null)
      {
        paramBaseFinderFeed = paramBaseFinderFeed.ATx.getRecyclerView();
        if (paramBaseFinderFeed != null)
        {
          paramBaseFinderFeed = paramBaseFinderFeed.getAdapter();
          if (paramBaseFinderFeed != null) {
            paramBaseFinderFeed.t(0, Integer.valueOf(1));
          }
        }
      }
      paramBaseFinderFeed = this.ATo;
      if (paramBaseFinderFeed != null)
      {
        paramBaseFinderFeed = paramBaseFinderFeed.ATx.getRecyclerView();
        if (paramBaseFinderFeed != null) {
          paramBaseFinderFeed.post(new k.a..ExternalSyntheticLambda2(this));
        }
      }
      AppMethodBeat.o(363926);
      return;
      this.feedList.add(paramBaseFinderFeed);
    }
  }
  
  public final int h(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(165710);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    long l = paramBaseFinderFeed.bZA();
    paramBaseFinderFeed = dYK();
    if ((paramBaseFinderFeed != null) && (l == paramBaseFinderFeed.bZA())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(165710);
      return 0;
    }
    AppMethodBeat.o(165710);
    return -1;
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(165716);
    super.onDetach();
    this.AVg.dead();
    AppMethodBeat.o(165716);
  }
  
  public final void requestRefresh() {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.view.recyclerview.g
  {
    a(k.a parama) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(165706);
      switch (paramInt)
      {
      default: 
        localObject = av.GiL;
        av.eY(this.AVh.getTAG(), paramInt);
        localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.g();
        AppMethodBeat.o(165706);
        return localObject;
      case 4: 
      case 3002: 
        localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.t(this.AVh.AJn, (i)this.AVh, this.AVh.safeMode, 0, 8);
        AppMethodBeat.o(165706);
        return localObject;
      }
      Object localObject = (com.tencent.mm.view.recyclerview.f)new q((i)this.AVh, this.AVh.safeMode, 0, 4);
      AppMethodBeat.o(165706);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$dealMenuClick$1$3", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.am.h
  {
    b(bt parambt, k.a parama) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(363882);
      if (((paramp instanceof bt)) && (((bt)paramp).hKN == this.AVi.hKN)) {
        com.tencent.mm.kernel.h.aZW().b(this.AVi.getType(), (com.tencent.mm.am.h)this);
      }
      paramString = parama.tipDialog;
      if (paramString != null) {
        paramString.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        parama.lzt.finish();
        AppMethodBeat.o(363882);
        return;
      }
      aa.makeText((Context)parama.lzt, e.h.finder_profile_del_feed_failed, 0).show();
      AppMethodBeat.o(363882);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<Boolean, ah>
  {
    c(BaseFinderFeed paramBaseFinderFeed, k.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements b<Boolean, ah>
  {
    d(BaseFinderFeed paramBaseFinderFeed, k.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.k.a
 * JD-Core Version:    0.7.0.1
 */