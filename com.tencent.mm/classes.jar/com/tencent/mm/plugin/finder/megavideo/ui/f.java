package com.tencent.mm.plugin.finder.megavideo.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bt;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.event.c.a;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.megavideo.convert.a.a;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.model.cb;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.report.ax;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.utils.ag;
import com.tencent.mm.plugin.finder.utils.an;
import com.tencent.mm.plugin.finder.utils.an.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.bf;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.autoplay.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.video.l;
import com.tencent.mm.plugin.finder.video.l.b;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.dnh;
import com.tencent.mm.protocal.protobuf.dnq;
import com.tencent.mm.protocal.protobuf.dnv;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.n.n;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "uic", "Lcom/tencent/mm/ui/component/UIComponent;", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/tencent/mm/ui/component/UIComponent;)V", "addToHistoryOffset", "", "getAddToHistoryOffset", "()I", "addToHistoryOffset$delegate", "Lkotlin/Lazy;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "commentPreloader$delegate", "configPosition", "currentPlaySpeed", "getCurrentPlaySpeed", "setCurrentPlaySpeed", "(I)V", "deleteFromHistoryOffset", "getDeleteFromHistoryOffset", "deleteFromHistoryOffset$delegate", "feedLoader", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "floatBallInfo", "Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;", "getFloatBallInfo", "()Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;", "setFloatBallInfo", "(Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;)V", "inputMode", "getInputMode", "setInputMode", "isAutoLoadingMore", "", "isInMultiTask", "()Z", "setInMultiTask", "(Z)V", "isSelfProfile", "setSelfProfile", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "getKeyboardHeightProvider", "()Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "setKeyboardHeightProvider", "(Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;)V", "loadingFooterData", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "mediaBannerViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "multiTaskHelper", "Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;", "getMultiTaskHelper", "()Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;", "setMultiTaskHelper", "(Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;)V", "oldStatus", "getOldStatus", "setOldStatus", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint$delegate", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "getSmileyPanel", "()Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "smileyPanel$delegate", "tipDialog", "Landroid/app/Dialog;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "videoFloatBallInfo", "getVideoFloatBallInfo", "setVideoFloatBallInfo", "viewCallback", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$ViewCallback;", "addToMultiTask", "", "item", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "videoCurrPlayTimes", "isHistory", "isUpdate", "addVideoFloatBall", "bindMultiTaskInfo", "info", "isMultiTask", "bindVideoFloatBall", "floatBallHelper", "Lcom/tencent/mm/plugin/finder/megavideo/floatball/MegaVideoFloatBallHelper;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkEmpty", "genMultiTaskCover", "Landroid/graphics/Bitmap;", "getActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "getCommentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "feed", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getCurrentSnapshotView", "Landroid/view/View;", "getCurrentVideoPosSec", "getMediaBannerRecyclerViewPool", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getVideoCore", "getViewCallback", "initViewCallback", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "loadInitData", "loadMoreData", "onAttach", "callback", "onBackPressed", "isFromCloseBtn", "onConfigurationChanged", "isLandScape", "onDetach", "onEventHappen", "ev", "onFavMegaVideo", "megaVideo", "isFav", "onLikeMegaVideo", "isLike", "isPrivate", "likeAction", "onMultiTaskPause", "onMultiTaskResume", "onUIPause", "onUIResume", "postCheckPlay", "refreshMsgNotify", "releaseResource", "currPos", "requestRefresh", "ratio", "", "setupEmojiPanel", "shareFeed", "shareFeedToSns", "updateMultiHistoryTask", "Lkotlin/Pair;", "isFromMultiTask", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends com.tencent.mm.plugin.finder.event.base.d
  implements h.a
{
  private static final int ASV;
  private static final int ATc;
  private static final int ATd;
  private static final int AYc;
  private static final int AYd;
  private static final int Auf;
  private static final int Aug;
  public static final a EAJ;
  private static final int EAX;
  private static final int EAY;
  private static final int EAZ;
  private static final int EBa;
  private static final int EBb;
  private static final int EBc = 0;
  private static final int EBd;
  private static final int nin;
  private static final int pIs;
  private final l AJn;
  private com.tencent.mm.view.k ATF;
  private RecyclerView.m ATp;
  private final kotlin.j Bae;
  private boolean Bat;
  private final int Baw;
  private dnq BtU;
  public final AppCompatActivity CCa;
  private final kotlin.j DMl;
  private final UIComponent EAK;
  public h.b EAL;
  public com.tencent.mm.plugin.finder.megavideo.multitask.a EAM;
  public dnq EAN;
  public boolean EAO;
  private boolean EAP;
  private final kotlin.j EAQ;
  public int EAR;
  public int EAS;
  private final kotlin.j EAT;
  private final kotlin.j EAU;
  private i.b EAV;
  private boolean EAW;
  public BaseMegaVideoLoader EzZ;
  private com.tencent.mm.ui.tools.i lKz;
  private Dialog tipDialog;
  
  static
  {
    AppMethodBeat.i(342289);
    EAJ = new a((byte)0);
    Auf = 102;
    Aug = 103;
    pIs = 104;
    EAX = 105;
    EAY = 106;
    AYc = 107;
    AYd = 108;
    ASV = 109;
    EAZ = 110;
    EBa = 111;
    ATc = 112;
    ATd = 113;
    EBb = 114;
    EBd = 1;
    nin = 2;
    AppMethodBeat.o(342289);
  }
  
  public f(AppCompatActivity paramAppCompatActivity, UIComponent paramUIComponent)
  {
    AppMethodBeat.i(342109);
    this.CCa = paramAppCompatActivity;
    this.EAK = paramUIComponent;
    this.AJn = new l();
    paramAppCompatActivity = com.tencent.mm.ui.component.k.aeZF;
    this.ATp = ((com.tencent.mm.plugin.finder.viewmodel.e)com.tencent.mm.ui.component.k.d(this.CCa).q(com.tencent.mm.plugin.finder.viewmodel.e.class)).ATp;
    this.lKz = new com.tencent.mm.ui.tools.i((Activity)this.CCa);
    this.EAQ = kotlin.k.cm((kotlin.g.a.a)new n(this));
    this.EAR = EBc;
    this.EAS = 2;
    this.Bae = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.EAT = kotlin.k.cm((kotlin.g.a.a)b.EBf);
    this.EAU = kotlin.k.cm((kotlin.g.a.a)g.EBg);
    this.ATF = ((com.tencent.mm.view.k)new com.tencent.mm.view.k()
    {
      private static final void p(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(341980);
        kotlin.g.b.s.u(paramAnonymousRecyclerView, "$rv");
        Object localObject = paramAnonymousRecyclerView.getLayoutManager();
        if (localObject == null)
        {
          paramAnonymousRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
          AppMethodBeat.o(341980);
          throw paramAnonymousRecyclerView;
        }
        localObject = paramAnonymousRecyclerView.fT(((LinearLayoutManager)localObject).Jw());
        if ((localObject instanceof com.tencent.mm.view.recyclerview.j)) {}
        for (localObject = (com.tencent.mm.view.recyclerview.j)localObject;; localObject = null)
        {
          if ((localObject != null) && ((((com.tencent.mm.view.recyclerview.j)localObject).CSA instanceof cb)))
          {
            localObject = com.tencent.mm.hellhoundlib.b.c.a(paramAnonymousInt, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousRecyclerView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter$1", "onItemRangeInserted$lambda-1", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "Undefined", "scrollToPosition", "(I)V");
            paramAnonymousRecyclerView.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousRecyclerView, "com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter$1", "onItemRangeInserted$lambda-1", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "Undefined", "scrollToPosition", "(I)V");
          }
          AppMethodBeat.o(341980);
          return;
        }
      }
      
      public final void onChanged()
      {
        AppMethodBeat.i(342009);
        h.b localb = f.d(this.EBe);
        Object localObject = localb;
        if (localb == null)
        {
          kotlin.g.b.s.bIx("viewCallback");
          localObject = null;
        }
        localObject = ((h.b)localObject).getRecyclerView().getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).bZE.notifyChanged();
        }
        AppMethodBeat.o(342009);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(342016);
        Log.i("FinderLongVideoTLPresenter", hashCode() + " onItemRangeChanged fromPosition:" + paramAnonymousInt1 + " itemCount" + paramAnonymousInt2);
        if (paramAnonymousInt2 > 0)
        {
          h.b localb = f.d(this.EBe);
          Object localObject = localb;
          if (localb == null)
          {
            kotlin.g.b.s.bIx("viewCallback");
            localObject = null;
          }
          localObject = ((h.b)localObject).getRecyclerView().getAdapter();
          if (localObject != null) {
            ((RecyclerView.a)localObject).by(paramAnonymousInt1, paramAnonymousInt2);
          }
        }
        AppMethodBeat.o(342016);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(342024);
        Log.i("FinderLongVideoTLPresenter", hashCode() + " onItemRangeChanged payload fromPosition:" + paramAnonymousInt1 + " itemCount" + paramAnonymousInt2);
        if (paramAnonymousInt2 > 0)
        {
          h.b localb = f.d(this.EBe);
          Object localObject = localb;
          if (localb == null)
          {
            kotlin.g.b.s.bIx("viewCallback");
            localObject = null;
          }
          localObject = ((h.b)localObject).getRecyclerView().getAdapter();
          if (localObject != null) {
            ((RecyclerView.a)localObject).e(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
          }
        }
        AppMethodBeat.o(342024);
      }
      
      public final void onItemRangeInserted(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(342031);
        Log.i("FinderLongVideoTLPresenter", hashCode() + " onItemRangeInserted fromPosition:" + paramAnonymousInt1 + " itemCount" + paramAnonymousInt2);
        if (paramAnonymousInt2 > 0)
        {
          Object localObject2 = f.d(this.EBe);
          Object localObject1 = localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("viewCallback");
            localObject1 = null;
          }
          localObject1 = ((h.b)localObject1).getRecyclerView();
          localObject2 = ((RecyclerView)localObject1).getAdapter();
          if (localObject2 != null) {
            ((RecyclerView.a)localObject2).bA(paramAnonymousInt1, paramAnonymousInt2);
          }
          ((RecyclerView)localObject1).post(new f.1..ExternalSyntheticLambda0((RecyclerView)localObject1, paramAnonymousInt1));
        }
        AppMethodBeat.o(342031);
      }
      
      public final void onItemRangeRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(342038);
        Log.i("FinderLongVideoTLPresenter", hashCode() + " onItemRangeRemoved fromPosition:" + paramAnonymousInt1 + " itemCount" + paramAnonymousInt2);
        if (paramAnonymousInt2 > 0)
        {
          h.b localb = f.d(this.EBe);
          Object localObject = localb;
          if (localb == null)
          {
            kotlin.g.b.s.bIx("viewCallback");
            localObject = null;
          }
          localObject = ((h.b)localObject).getRecyclerView().getAdapter();
          if (localObject != null) {
            ((RecyclerView.a)localObject).bB(paramAnonymousInt1, paramAnonymousInt2);
          }
          f.j(this.EBe);
        }
        AppMethodBeat.o(342038);
      }
      
      public final void onPreFinishLoadMore(RefreshLoadMoreLayout.d<Object> paramAnonymousd)
      {
        AppMethodBeat.i(341999);
        kotlin.g.b.s.u(paramAnonymousd, "reason");
        f.i(this.EBe);
        AppMethodBeat.o(341999);
      }
      
      public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.d<Object> paramAnonymousd)
      {
        AppMethodBeat.i(342005);
        kotlin.g.b.s.u(paramAnonymousd, "reason");
        f.i(this.EBe);
        AppMethodBeat.o(342005);
      }
      
      public final void onPreFinishRefresh(RefreshLoadMoreLayout.d<Object> paramAnonymousd)
      {
        AppMethodBeat.i(341994);
        kotlin.g.b.s.u(paramAnonymousd, "reason");
        f.i(this.EBe);
        AppMethodBeat.o(341994);
      }
    });
    this.Baw = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcp, 0);
    this.EAV = ((i.b)new cb());
    this.DMl = kotlin.k.cm((kotlin.g.a.a)m.EBh);
    AppMethodBeat.o(342109);
  }
  
  private static final void a(f paramf)
  {
    AppMethodBeat.i(342161);
    kotlin.g.b.s.u(paramf, "this$0");
    paramf.lKz.start();
    AppMethodBeat.o(342161);
  }
  
  private static final void a(f paramf, ca paramca, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(342200);
    kotlin.g.b.s.u(paramf, "this$0");
    kotlin.g.b.s.u(paramca, "$feed");
    paramDialogInterface = ag.Ghl;
    ag.a((Context)paramf.CCa, paramca.bZA(), paramca.eDF(), paramca.eDG(), true);
    AppMethodBeat.o(342200);
  }
  
  private static final void a(f paramf, ca paramca, com.tencent.mm.ui.base.s params)
  {
    int j = 1;
    AppMethodBeat.i(342173);
    kotlin.g.b.s.u(paramf, "this$0");
    kotlin.g.b.s.u(paramca, "$feed");
    Object localObject1 = paramf.CCa.getString(e.h.app_share_to_weixin);
    kotlin.g.b.s.s(localObject1, "context.getString(R.string.app_share_to_weixin)");
    Object localObject2 = paramf.CCa.getString(e.h.finder_share_timeline);
    kotlin.g.b.s.s(localObject2, "context.getString(R.string.finder_share_timeline)");
    Object localObject3 = av.GiL;
    boolean bool2;
    if ((!av.b(paramca)) || (!paramca.isPrivate()))
    {
      localObject3 = av.GiL;
      if (av.a(paramca.ABK)) {}
    }
    else
    {
      localObject1 = av.GiL;
      localObject1 = av.eX("FinderSafeSelfSeeForward", e.h.finder_self_see_tips_forward);
      localObject2 = av.GiL;
      localObject2 = av.eX("FinderSafeSelfSeeShare", e.h.finder_self_see_tips_sns);
      bool2 = true;
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      int i;
      if (paramca.eDH())
      {
        localObject1 = av.GiL;
        localObject2 = av.eX("FinderSafeSelfSeeForward", e.h.finder_self_see_tips_forward);
        localObject1 = av.GiL;
        localObject3 = av.eX("FinderSafeSelfSeeShare", e.h.finder_self_see_tips_sns);
        localObject1 = paramca.ABK;
        if (localObject1 == null)
        {
          localObject1 = null;
          if (localObject1 == null) {
            break label484;
          }
          if (((List)localObject1).size() <= 2) {
            break label424;
          }
          i = 1;
          label206:
          if (i == 0) {
            break label429;
          }
          label210:
          if (localObject1 == null) {
            break label484;
          }
          localObject3 = ((List)localObject1).get(0);
          localObject2 = ((List)localObject1).get(1);
          bool2 = true;
          bool1 = true;
          localObject1 = localObject3;
        }
      }
      for (;;)
      {
        params.a(Auf, (CharSequence)localObject1, e.g.finder_icons_filled_share, paramf.CCa.getResources().getColor(e.b.Brand), bool1);
        params.a(Aug, (CharSequence)localObject2, e.g.bottomsheet_icon_moment, 0, bool2);
        localObject1 = com.tencent.mm.plugin.finder.upload.action.c.GcH;
        if (!com.tencent.mm.plugin.finder.upload.action.c.fee().s(paramca.getFeedObject())) {}
        for (i = j;; i = 0)
        {
          paramca = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() != 0) {
            break label477;
          }
          if (i == 0) {
            break label440;
          }
          params.a(ATc, (CharSequence)paramf.CCa.getString(e.h.favorite), e.g.finder_icons_filled_star2, paramf.CCa.getResources().getColor(e.b.orange_100));
          AppMethodBeat.o(342173);
          return;
          localObject1 = ((dne)localObject1).aaUw;
          if (localObject1 == null)
          {
            localObject1 = null;
            break;
          }
          localObject1 = n.a((CharSequence)localObject1, new String[] { "#" });
          break;
          label424:
          i = 0;
          break label206;
          label429:
          localObject1 = null;
          break label210;
        }
        label440:
        params.a(ATd, (CharSequence)paramf.CCa.getString(e.h.finder_cancel_fav_title), e.g.finder_icons_filled_unstar2, paramf.CCa.getResources().getColor(e.b.orange_100));
        label477:
        AppMethodBeat.o(342173);
        return;
        label484:
        bool2 = true;
        bool1 = true;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
      bool2 = false;
    }
  }
  
  private void a(h.b paramb)
  {
    int j = 0;
    AppMethodBeat.i(342124);
    kotlin.g.b.s.u(paramb, "callback");
    this.EAL = paramb;
    dUM();
    l.a(this.AJn, this.CCa, (l.b)new j(this), 4);
    paramb = com.tencent.mm.ui.component.k.aeZF;
    paramb = com.tencent.mm.ui.component.k.d(this.CCa).q(as.class);
    kotlin.g.b.s.s(paramb, "UICProvider.of(context).…rReporterUIC::class.java)");
    paramb = ((bn)paramb).Vm(-1);
    if (paramb != null)
    {
      paramb.a((com.tencent.mm.plugin.finder.event.base.d)this);
      paramb.a((com.tencent.mm.plugin.finder.event.base.d)ecL());
    }
    Object localObject = this.EAL;
    paramb = (h.b)localObject;
    if (localObject == null)
    {
      kotlin.g.b.s.bIx("viewCallback");
      paramb = null;
    }
    paramb.getRecyclerView().post(new f..ExternalSyntheticLambda9(this));
    paramb = ecL();
    int i;
    if (this.EAO)
    {
      i = 1;
      localObject = as.GSQ;
      localObject = as.a.hu((Context)this.CCa);
      if (localObject != null) {
        break label211;
      }
    }
    for (;;)
    {
      paramb.a(i, j, (kotlin.g.a.b)new k(this));
      AppMethodBeat.o(342124);
      return;
      i = 2;
      break;
      label211:
      localObject = ((as)localObject).fou();
      if (localObject != null) {
        j = ((bui)localObject).AJo;
      }
    }
  }
  
  private static final void a(ca paramca, final f paramf, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(342193);
    kotlin.g.b.s.u(paramca, "$feed");
    kotlin.g.b.s.u(paramf, "this$0");
    String str = z.bAW();
    kotlin.g.b.s.s(str, "getMyFinderUsername()");
    paramDialogInterface = paramca.ABK;
    paramca = paramDialogInterface;
    if (paramDialogInterface == null) {
      paramca = new dne();
    }
    paramDialogInterface = new bt(str, paramca);
    paramca = paramf.tipDialog;
    if (paramca == null) {}
    for (paramca = null;; paramca = kotlin.ah.aiuX)
    {
      if (paramca == null)
      {
        paramca = (Context)paramf.CCa;
        paramf.CCa.getString(e.h.app_tip);
        paramf.tipDialog = ((Dialog)com.tencent.mm.ui.base.k.a(paramca, paramf.CCa.getString(e.h.app_waiting), false, f..ExternalSyntheticLambda0.INSTANCE));
      }
      com.tencent.mm.kernel.h.aZW().a(paramDialogInterface.getType(), (com.tencent.mm.am.h)new h(paramDialogInterface, paramf));
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramDialogInterface, 0);
      AppMethodBeat.o(342193);
      return;
      paramca.show();
    }
  }
  
  private static final void a(ca paramca, f paramf, com.tencent.mm.view.recyclerview.j paramj, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(342230);
    kotlin.g.b.s.u(paramca, "$feed");
    kotlin.g.b.s.u(paramf, "this$0");
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramMenuItem, "menuItem");
    Log.i("FinderLongVideoTLPresenter", "[getMoreMenuItemSelectedListener] feed " + paramca + ' ' + paramInt + " menuItem:" + paramMenuItem.getItemId());
    paramInt = paramMenuItem.getItemId();
    if (paramInt == Auf)
    {
      paramj = an.GhR;
      paramf = paramf.CCa;
      paramMenuItem = FinderItem.Companion;
      an.a.a(paramj, paramf, FinderItem.a.e(paramca.getFeedObject(), 32768), null, 3, 20);
      AppMethodBeat.o(342230);
      return;
    }
    if (paramInt == Aug)
    {
      paramj = an.GhR;
      paramf = paramf.CCa;
      paramMenuItem = FinderItem.Companion;
      an.a.a(paramj, paramf, (BaseFinderFeed)new com.tencent.mm.plugin.finder.model.ah(FinderItem.a.e(paramca.getFeedObject(), 32768)), 2, 0, 20);
      AppMethodBeat.o(342230);
      return;
    }
    if (paramInt == pIs)
    {
      com.tencent.mm.ui.base.k.a((Context)paramf.CCa, e.h.finder_delete_mega_video_confirm, 0, new f..ExternalSyntheticLambda2(paramca, paramf), null);
      AppMethodBeat.o(342230);
      return;
    }
    if (paramInt == EAX)
    {
      paramj = com.tencent.mm.plugin.finder.storage.data.e.FMN;
      e.a.r(paramca.getFeedObject());
      paramj = bf.GlJ;
      bf.a((Context)paramf.CCa, paramca.bZA(), true);
      AppMethodBeat.o(342230);
      return;
    }
    if (paramInt == EAY)
    {
      paramj = com.tencent.mm.plugin.finder.storage.data.e.FMN;
      e.a.r(paramca.getFeedObject());
      paramj = bf.GlJ;
      bf.a((Context)paramf.CCa, paramca.bZA(), false);
      AppMethodBeat.o(342230);
      return;
    }
    if (paramInt == AYd)
    {
      paramj = com.tencent.mm.plugin.finder.storage.data.e.FMN;
      e.a.r(paramca.getFeedObject());
      paramj = ag.Ghl;
      ag.a((Context)paramf.CCa, paramca.bZA(), paramca.eDF(), paramca.eDG(), false);
      AppMethodBeat.o(342230);
      return;
    }
    if (paramInt == AYc)
    {
      paramj = com.tencent.mm.plugin.finder.storage.data.e.FMN;
      e.a.r(paramca.getFeedObject());
      com.tencent.mm.ui.base.k.a((Context)paramf.CCa, e.h.finder_set_mega_video_private_confirm, 0, new f..ExternalSyntheticLambda1(paramf, paramca), null);
      AppMethodBeat.o(342230);
      return;
    }
    if (paramInt == ASV)
    {
      paramj = com.tencent.mm.plugin.finder.feed.logic.a.Bem;
      com.tencent.mm.plugin.finder.feed.logic.a.a((Context)paramf.CCa, paramca.bZA(), 0L, 0, 0, 28);
      AppMethodBeat.o(342230);
      return;
    }
    if (paramInt == EAZ)
    {
      paramMenuItem = (FinderVideoLayout)paramj.UH(e.e.finder_banner_video_layout);
      if (paramMenuItem == null) {}
      for (paramInt = 0;; paramInt = paramMenuItem.getCurrentPosSec())
      {
        paramf.a(paramca, paramj, paramInt, false, false);
        AppMethodBeat.o(342230);
        return;
      }
    }
    if (paramInt == ATc)
    {
      paramMenuItem = av.GiL;
      if (!av.c(paramca.ABK))
      {
        paramca = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() == 0)
        {
          paramca = av.GiL;
          paramca = paramj.context;
          kotlin.g.b.s.s(paramca, "holder.context");
          paramf = paramj.context.getString(e.h.finder_private_ban_fav);
          kotlin.g.b.s.s(paramf, "holder.context.getString…g.finder_private_ban_fav)");
          av.aO(paramca, paramf);
          AppMethodBeat.o(342230);
          return;
        }
        paramca = av.GiL;
        paramca = paramj.context;
        kotlin.g.b.s.s(paramca, "holder.context");
        paramf = paramj.context.getString(e.h.finder_private_ban_fav2);
        kotlin.g.b.s.s(paramf, "holder.context.getString….finder_private_ban_fav2)");
        av.aO(paramca, paramf);
        AppMethodBeat.o(342230);
        return;
      }
      paramj = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() == 0) {}
      for (paramj = paramf.CCa.getResources().getString(e.h.finder_has_fav_title);; paramj = paramf.CCa.getResources().getString(e.h.finder_has_fav_title2))
      {
        kotlin.g.b.s.s(paramj, "if (FinderConfig.FINDER_…title2)\n                }");
        aa.a((Context)paramf.CCa, paramj, f..ExternalSyntheticLambda4.INSTANCE);
        paramf.a(paramca, true);
        AppMethodBeat.o(342230);
        return;
      }
    }
    if (paramInt == ATd)
    {
      paramj = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() == 0) {}
      for (paramj = paramf.CCa.getResources().getString(e.h.finder_has_cancel_fav_title);; paramj = paramf.CCa.getResources().getString(e.h.finder_has_cancel_fav_title2))
      {
        kotlin.g.b.s.s(paramj, "if (FinderConfig.FINDER_…title2)\n                }");
        aa.a((Context)paramf.CCa, paramj, f..ExternalSyntheticLambda3.INSTANCE);
        paramf.a(paramca, false);
        AppMethodBeat.o(342230);
        return;
      }
    }
    if (paramInt == EBb)
    {
      paramca = com.tencent.mm.plugin.finder.megavideo.convert.a.Ezn;
      a.a.a(paramj, paramf);
    }
    AppMethodBeat.o(342230);
  }
  
  private void a(ca paramca, com.tencent.mm.view.recyclerview.j paramj, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(342143);
    kotlin.g.b.s.u(paramca, "item");
    kotlin.g.b.s.u(paramj, "holder");
    if (this.BtU == null) {
      ((f)this).BtU = new dnq();
    }
    paramj = paramca.ABK;
    Object localObject1;
    if (paramj == null)
    {
      paramj = null;
      if (!Util.isNullOrNil(paramj)) {
        break label530;
      }
      localObject1 = this.CCa.getResources();
      int i = e.h.mega_video_post_ui_desc_tv_hint;
      Object localObject2 = (Context)this.CCa;
      paramj = paramca.contact;
      if (paramj != null) {
        break label522;
      }
      paramj = null;
      label93:
      paramj = ((Resources)localObject1).getString(i, new Object[] { com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject2, (CharSequence)paramj) });
      label117:
      localObject1 = this.BtU;
      if (localObject1 != null) {
        ((dnq)localObject1).aaUP = 0;
      }
      localObject1 = this.BtU;
      if (localObject1 != null) {
        ((dnq)localObject1).aaUO = paramInt;
      }
      localObject1 = this.BtU;
      if (localObject1 != null)
      {
        localObject1 = ((dnq)localObject1).aaUM;
        if (localObject1 != null) {
          ((LinkedList)localObject1).clear();
        }
      }
      localObject1 = this.BtU;
      if (localObject1 != null)
      {
        localObject1 = ((dnq)localObject1).aaUQ;
        if (localObject1 != null) {
          ((LinkedList)localObject1).clear();
        }
      }
      localObject1 = this.BtU;
      if (localObject1 != null)
      {
        localObject1 = ((dnq)localObject1).aaUQ;
        if (localObject1 != null) {
          ((LinkedList)localObject1).add(paramca.getFeedObject());
        }
      }
      localObject1 = this.BtU;
      if (localObject1 != null) {
        ((dnq)localObject1).aaUR = (paramca.hlB + paramca.getFeedObject().urlValidDuration * 1000L);
      }
      localObject2 = eCQ().LCE;
      if (localObject2 != null)
      {
        ((MultiTaskInfo)localObject2).field_id = com.tencent.mm.ae.d.hF(paramca.eDF());
        ((MultiTaskInfo)localObject2).gkh().title = paramj;
        drz localdrz = ((MultiTaskInfo)localObject2).gkh();
        paramj = paramca.contact;
        if (paramj != null) {
          break label566;
        }
        paramj = "";
        label328:
        localdrz.aaXP = paramj;
        paramj = this.BtU;
        if (paramj != null) {
          break label587;
        }
        paramj = null;
        label345:
        ((MultiTaskInfo)localObject2).field_data = paramj;
        paramj = paramca.contact;
        if (paramj != null)
        {
          ((MultiTaskInfo)localObject2).gkh().nickname = paramj.nickname;
          paramj = paramj.authInfo;
          if (paramj != null)
          {
            if (paramj.authIconType <= 0) {
              break label595;
            }
            paramInt = 1;
            label390:
            if (paramInt == 0) {
              break label600;
            }
            label394:
            if (paramj != null)
            {
              ((MultiTaskInfo)localObject2).gkh().aaXQ = paramj.authIconType;
              ((MultiTaskInfo)localObject2).gkh().aaXO = paramj.authIconUrl;
            }
          }
        }
        paramj = ((MultiTaskInfo)localObject2).gkh();
        paramca = paramca.ABK;
        if (paramca != null) {
          break label605;
        }
        paramInt = 0;
        label439:
        paramj.Rfk = paramInt;
      }
      if (!paramBoolean2)
      {
        if (!paramBoolean1) {
          break label666;
        }
        paramca = eCQ().LCE;
        if ((paramca == null) || (((com.tencent.mm.plugin.taskbar.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.taskbar.c.class)).getTaskInfoById(paramca.field_id) == null)) {
          break label661;
        }
      }
    }
    label522:
    label530:
    label661:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label666;
      }
      AppMethodBeat.o(342143);
      return;
      paramj = paramj.aaUt;
      if (paramj == null)
      {
        paramj = null;
        break;
      }
      paramj = paramj.description;
      break;
      paramj = paramj.nickname;
      break label93;
      paramj = paramca.ABK;
      if (paramj == null)
      {
        paramj = null;
        break label117;
      }
      paramj = paramj.aaUt;
      if (paramj == null)
      {
        paramj = null;
        break label117;
      }
      paramj = paramj.description;
      break label117;
      label566:
      localObject1 = paramj.headUrl;
      paramj = (com.tencent.mm.view.recyclerview.j)localObject1;
      if (localObject1 != null) {
        break label328;
      }
      paramj = "";
      break label328;
      label587:
      paramj = paramj.toByteArray();
      break label345;
      label595:
      paramInt = 0;
      break label390;
      label600:
      paramj = null;
      break label394;
      label605:
      paramca = paramca.aaUt;
      if (paramca == null)
      {
        paramInt = 0;
        break label439;
      }
      paramca = paramca.media;
      if (paramca == null)
      {
        paramInt = 0;
        break label439;
      }
      paramca = (dnv)kotlin.a.p.oL((List)paramca);
      if (paramca == null)
      {
        paramInt = 0;
        break label439;
      }
      paramInt = paramca.aaUX;
      break label439;
    }
    label666:
    if (!paramBoolean1)
    {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this));
      AppMethodBeat.o(342143);
      return;
    }
    eCQ().eCK();
    AppMethodBeat.o(342143);
  }
  
  private void a(ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(342153);
    kotlin.g.b.s.u(paramca, "megaVideo");
    Object localObject = com.tencent.mm.plugin.finder.model.s.ECs;
    localObject = this.CCa;
    FinderItem.a locala = FinderItem.Companion;
    com.tencent.mm.plugin.finder.model.s.a((AppCompatActivity)localObject, FinderItem.a.e(paramca.getFeedObject(), 32768), paramBoolean);
    AppMethodBeat.o(342153);
  }
  
  private static final void b(f paramf)
  {
    AppMethodBeat.i(342237);
    kotlin.g.b.s.u(paramf, "this$0");
    paramf = paramf.AJn.GpZ;
    if (paramf != null) {
      paramf.aCs("FinderLongVideoTLPresenter");
    }
    AppMethodBeat.o(342237);
  }
  
  private static final void b(f paramf, ca paramca, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(342179);
    kotlin.g.b.s.u(paramf, "this$0");
    kotlin.g.b.s.u(paramca, "$feed");
    params.a(EAZ, (CharSequence)paramf.CCa.getString(e.h.enter_multi_task_float_ball), e.g.icons_outlined_multitask);
    Object localObject;
    switch (paramf.EAS)
    {
    default: 
      localObject = paramf.CCa.getString(e.h.mega_video_play_speed_text);
    }
    for (;;)
    {
      kotlin.g.b.s.s(localObject, "when (currentPlaySpeed) …lay_speed_text)\n        }");
      params.a(EBb, (CharSequence)localObject, e.g.icons_outlined_play_control);
      localObject = av.GiL;
      if (!av.b(paramca)) {
        break;
      }
      params.bx(pIs, e.h.app_delete, e.g.icons_outlined_delete);
      localObject = ag.Ghl;
      kotlin.g.b.s.s(params, "menu");
      paramf = (Context)paramf.CCa;
      kotlin.a.p.oL((List)paramca.eDE());
      ag.a(params, paramf, AYd, AYc, paramca.isPrivate(), paramca.eDI());
      AppMethodBeat.o(342179);
      return;
      localObject = paramf.CCa.getString(e.h.mega_video_play_speed_0_5);
      continue;
      localObject = paramf.CCa.getString(e.h.mega_video_play_speed_text);
      continue;
      localObject = paramf.CCa.getString(e.h.mega_video_play_speed_1_5);
      continue;
      localObject = paramf.CCa.getString(e.h.mega_video_play_speed_2);
    }
    params.a(ASV, (CharSequence)paramf.CCa.getString(e.h.more_menu_back), e.g.icons_outlined_report_problem);
    AppMethodBeat.o(342179);
  }
  
  private void bXB()
  {
    AppMethodBeat.i(342148);
    BaseMegaVideoLoader localBaseMegaVideoLoader2 = this.EzZ;
    BaseMegaVideoLoader localBaseMegaVideoLoader1 = localBaseMegaVideoLoader2;
    if (localBaseMegaVideoLoader2 == null)
    {
      kotlin.g.b.s.bIx("feedLoader");
      localBaseMegaVideoLoader1 = null;
    }
    BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)localBaseMegaVideoLoader1, false, 1, null);
    this.Bat = true;
    AppMethodBeat.o(342148);
  }
  
  private void dUM()
  {
    Object localObject2 = null;
    AppMethodBeat.i(342130);
    Object localObject3 = this.EAL;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("viewCallback");
      localObject1 = null;
    }
    com.tencent.mm.view.k localk = ((h.b)localObject1).ecd();
    if (localk == null)
    {
      localObject1 = null;
      if (localObject1 == null)
      {
        localObject3 = this.EzZ;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("feedLoader");
          localObject1 = null;
        }
        ((BaseMegaVideoLoader)localObject1).register(this.ATF);
      }
      localObject1 = this.EAL;
      if (localObject1 != null) {
        break label157;
      }
      kotlin.g.b.s.bIx("viewCallback");
      localObject1 = null;
      label90:
      localObject3 = this.EzZ;
      if (localObject3 != null) {
        break label160;
      }
      kotlin.g.b.s.bIx("feedLoader");
    }
    for (;;)
    {
      ((h.b)localObject1).ae((ArrayList)localObject2.getDataListJustForAdapter());
      AppMethodBeat.o(342130);
      return;
      localObject3 = this.EzZ;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("feedLoader");
        localObject1 = null;
      }
      ((BaseMegaVideoLoader)localObject1).register(localk);
      localObject1 = kotlin.ah.aiuX;
      break;
      label157:
      break label90;
      label160:
      localObject2 = localObject3;
    }
  }
  
  private final com.tencent.mm.plugin.finder.feed.model.i ecL()
  {
    AppMethodBeat.i(342116);
    com.tencent.mm.plugin.finder.feed.model.i locali = (com.tencent.mm.plugin.finder.feed.model.i)this.Bae.getValue();
    AppMethodBeat.o(342116);
    return locali;
  }
  
  private static final void gv(View paramView)
  {
    AppMethodBeat.i(342209);
    if (paramView != null)
    {
      TextView localTextView = (TextView)paramView.findViewById(e.e.toast_text);
      if (localTextView != null) {
        localTextView.setTextSize(1, 14.0F);
      }
    }
    if (paramView != null)
    {
      paramView = (WeImageView)paramView.findViewById(e.e.toast_img);
      if (paramView != null)
      {
        paramView.setImageResource(e.g.icons_filled_done);
        paramView.setIconColor(paramView.getContext().getResources().getColor(e.b.White));
      }
    }
    AppMethodBeat.o(342209);
  }
  
  private static final void gw(View paramView)
  {
    AppMethodBeat.i(342212);
    if (paramView != null)
    {
      TextView localTextView = (TextView)paramView.findViewById(e.e.toast_text);
      if (localTextView != null) {
        localTextView.setTextSize(1, 14.0F);
      }
    }
    if (paramView != null)
    {
      paramView = (WeImageView)paramView.findViewById(e.e.toast_img);
      if (paramView != null)
      {
        paramView.setImageResource(e.g.icons_filled_done);
        paramView.setIconColor(paramView.getContext().getResources().getColor(e.b.White));
      }
    }
    AppMethodBeat.o(342212);
  }
  
  private static final void n(DialogInterface paramDialogInterface) {}
  
  public final u.g a(ca paramca)
  {
    AppMethodBeat.i(342475);
    kotlin.g.b.s.u(paramca, "feed");
    paramca = new f..ExternalSyntheticLambda5(this, paramca);
    AppMethodBeat.o(342475);
    return paramca;
  }
  
  public final u.g a(ca paramca, com.tencent.mm.ui.widget.a.f paramf)
  {
    AppMethodBeat.i(342471);
    kotlin.g.b.s.u(paramca, "feed");
    kotlin.g.b.s.u(paramf, "sheet");
    paramca = new f..ExternalSyntheticLambda6(this, paramca);
    AppMethodBeat.o(342471);
    return paramca;
  }
  
  public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(342360);
    kotlin.g.b.s.u(paramb, "ev");
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h)) {
      switch (((com.tencent.mm.plugin.finder.event.base.h)paramb).type)
      {
      case 3: 
      case 4: 
      default: 
        label64:
        if ((((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 0) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 4))
        {
          localObject3 = this.EAL;
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            kotlin.g.b.s.bIx("viewCallback");
            localObject1 = null;
          }
          localObject1 = ((h.b)localObject1).getRecyclerView().fT(((com.tencent.mm.plugin.finder.event.base.h)paramb).AOr);
          if (!(localObject1 instanceof com.tencent.mm.view.recyclerview.j)) {
            break label488;
          }
          localObject1 = (com.tencent.mm.view.recyclerview.j)localObject1;
          if (localObject1 != null)
          {
            if (!(((com.tencent.mm.view.recyclerview.j)localObject1).CSA instanceof cb)) {
              break label494;
            }
            Log.i("FinderLongVideoTLPresenter", "[onAutoToLoadMore] configPosition=" + this.Baw + ", firstVisibleItemPosition=" + ((com.tencent.mm.plugin.finder.event.base.h)paramb).AOr + ",  isAutoLoadingMore=" + this.Bat);
            if (!this.Bat) {
              bXB();
            }
          }
        }
        label143:
        break;
      }
    }
    label345:
    int i;
    for (;;)
    {
      if ((paramb instanceof c.a)) {}
      switch (((c.a)paramb).type)
      {
      default: 
        AppMethodBeat.o(342360);
        return;
        Log.i("FinderLongVideoTLPresenter", "onEventHappen: set orientation portrait");
        this.CCa.setRequestedOrientation(1);
        break label64;
        if (this.Baw <= 0) {
          break label64;
        }
        localObject3 = this.EAL;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("viewCallback");
          localObject1 = null;
        }
        localObject1 = ((h.b)localObject1).getRecyclerView().getAdapter();
        if ((localObject1 instanceof com.tencent.mm.view.recyclerview.i))
        {
          localObject1 = (com.tencent.mm.view.recyclerview.i)localObject1;
          if (localObject1 != null) {
            break label470;
          }
        }
        label470:
        for (i = 0;; i = ((com.tencent.mm.view.recyclerview.i)localObject1).getItemCount() - ((com.tencent.mm.view.recyclerview.i)localObject1).agOc.size())
        {
          int j = i - this.Baw;
          if ((((com.tencent.mm.plugin.finder.event.base.h)paramb).AOt < j) || (i < 4)) {
            break;
          }
          Log.i("FinderLongVideoTLPresenter", "[onAutoToLoadMore] configPosition=" + this.Baw + ", lastVisibleItemPosition=" + ((com.tencent.mm.plugin.finder.event.base.h)paramb).AOt + ", preLoadBeginPosition=" + j + ", count=" + i + " isAutoLoadingMore=" + this.Bat);
          if (this.Bat) {
            break;
          }
          bXB();
          break;
          localObject1 = null;
          break label345;
        }
        label488:
        localObject1 = null;
        break label143;
        label494:
        localObject1 = ((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.unfold_video_button);
        if (localObject1 != null) {
          if (((View)localObject1).getVisibility() == 0)
          {
            Log.i("FinderLongVideoTLPresenter", "onEventHappen: set orientation unspecified");
            this.CCa.setRequestedOrientation(-1);
          }
          else
          {
            Log.i("FinderLongVideoTLPresenter", "onEventHappen: set orientation portrait");
            this.CCa.setRequestedOrientation(1);
          }
        }
        break;
      }
    }
    AppMethodBeat.o(342360);
    return;
    Object localObject3 = this.EzZ;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("feedLoader");
      localObject1 = null;
    }
    localObject3 = ((Iterable)((BaseMegaVideoLoader)localObject1).getDataListJustForAdapter()).iterator();
    label603:
    if (((Iterator)localObject3).hasNext())
    {
      localObject1 = ((Iterator)localObject3).next();
      if (((cc)localObject1).bZA() == ((c.a)paramb).feedId)
      {
        i = 1;
        if (i == 0) {
          break label892;
        }
      }
    }
    for (;;)
    {
      label645:
      localObject3 = (cc)localObject1;
      localObject1 = localObject2;
      if ((localObject3 instanceof ca)) {
        localObject1 = (ca)localObject3;
      }
      if (localObject1 == null) {
        break;
      }
      if ((((c.a)paramb).offset >= ((Number)this.EAT.getValue()).intValue()) && (!((ca)localObject1).EDF))
      {
        Log.i("FinderLongVideoTLPresenter", "onEventHappen: add to history, offset = " + ((c.a)paramb).offset + ", feedId = " + ((c.a)paramb).feedId);
        ((ca)localObject1).EDF = true;
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new l(this));
      }
      if ((((c.a)paramb).offset < ((c.a)paramb).total - ((Number)this.EAU.getValue()).intValue()) || (((ca)localObject1).ECR)) {
        break;
      }
      Log.i("FinderLongVideoTLPresenter", "onEventHappen: delete from history, offset = " + ((c.a)paramb).offset + ", total = " + ((c.a)paramb).total + ", feedId = " + ((c.a)paramb).feedId);
      ((ca)localObject1).ECR = true;
      break;
      i = 0;
      break label645;
      label892:
      break label603;
      localObject1 = null;
    }
  }
  
  public final void a(com.tencent.mm.plugin.finder.megavideo.floatball.b paramb, dnq paramdnq)
  {
    AppMethodBeat.i(342401);
    kotlin.g.b.s.u(paramb, "floatBallHelper");
    kotlin.g.b.s.u(paramdnq, "info");
    this.EAN = paramdnq;
    AppMethodBeat.o(342401);
  }
  
  public final void a(BaseMegaVideoLoader paramBaseMegaVideoLoader, h.b paramb)
  {
    AppMethodBeat.i(342381);
    kotlin.g.b.s.u(paramBaseMegaVideoLoader, "feedLoader");
    kotlin.g.b.s.u(paramb, "callback");
    this.EzZ = paramBaseMegaVideoLoader;
    paramBaseMegaVideoLoader.fetchEndCallback = ((kotlin.g.a.b)new i(this));
    a(paramb);
    AppMethodBeat.o(342381);
  }
  
  public final void a(com.tencent.mm.plugin.finder.megavideo.multitask.a parama, dnq paramdnq, boolean paramBoolean)
  {
    AppMethodBeat.i(342407);
    kotlin.g.b.s.u(parama, "multiTaskHelper");
    kotlin.g.b.s.u(paramdnq, "info");
    this.BtU = paramdnq;
    kotlin.g.b.s.u(parama, "<set-?>");
    this.EAM = parama;
    this.EAP = paramBoolean;
    paramdnq = parama.LBU;
    if ((paramdnq instanceof com.tencent.mm.plugin.finder.megavideo.multitask.b)) {}
    for (paramdnq = (com.tencent.mm.plugin.finder.megavideo.multitask.b)paramdnq;; paramdnq = null)
    {
      if (paramdnq != null) {
        paramdnq.Ezo = this;
      }
      parama.Ezo = this;
      AppMethodBeat.o(342407);
      return;
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(342367);
    kotlin.g.b.s.u(paramc, "dispatcher");
    kotlin.g.b.s.u(paramb, "event");
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
    {
      if ((((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 0) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 1) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 2) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 4))
      {
        AppMethodBeat.o(342367);
        return true;
      }
      AppMethodBeat.o(342367);
      return false;
    }
    if (((paramb instanceof c.a)) && ((((c.a)paramb).type == 2) || (((c.a)paramb).type == 3)))
    {
      AppMethodBeat.o(342367);
      return true;
    }
    AppMethodBeat.o(342367);
    return false;
  }
  
  public final r<Boolean, Boolean> ai(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(342415);
    Object localObject2 = this.EAL;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("viewCallback");
      localObject1 = null;
    }
    localObject1 = ((h.b)localObject1).getRecyclerView();
    localObject2 = ((RecyclerView)localObject1).getLayoutManager();
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
      AppMethodBeat.o(342415);
      throw ((Throwable)localObject1);
    }
    localObject1 = ((RecyclerView)localObject1).fU(((LinearLayoutManager)localObject2).Ju());
    FinderVideoLayout localFinderVideoLayout;
    if ((localObject1 instanceof com.tencent.mm.view.recyclerview.j))
    {
      localObject1 = (com.tencent.mm.view.recyclerview.j)localObject1;
      if (localObject1 == null) {
        break label225;
      }
      localObject2 = ((com.tencent.mm.view.recyclerview.j)localObject1).CSA;
      if ((!(localObject2 instanceof ca)) || ((!((ca)localObject2).EDF) && (!paramBoolean2) && (!this.EAP))) {
        break label225;
      }
      localFinderVideoLayout = (FinderVideoLayout)((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.finder_banner_video_layout);
      if (localFinderVideoLayout != null) {
        break label216;
      }
    }
    label216:
    for (int i = 0;; i = localFinderVideoLayout.getCurrentPosSec())
    {
      a((ca)localObject2, (com.tencent.mm.view.recyclerview.j)localObject1, i, true, paramBoolean1);
      localObject1 = new r(Boolean.TRUE, Boolean.valueOf(((ca)localObject2).ECR));
      AppMethodBeat.o(342415);
      return localObject1;
      localObject1 = null;
      break;
    }
    label225:
    localObject1 = Boolean.FALSE;
    localObject1 = new r(localObject1, localObject1);
    AppMethodBeat.o(342415);
    return localObject1;
  }
  
  public final u.i b(ca paramca, com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(342481);
    kotlin.g.b.s.u(paramca, "feed");
    kotlin.g.b.s.u(paramj, "holder");
    paramca = new f..ExternalSyntheticLambda7(paramca, this, paramj);
    AppMethodBeat.o(342481);
    return paramca;
  }
  
  public final g dUK()
  {
    AppMethodBeat.i(342375);
    g localg = (g)new e(this);
    AppMethodBeat.o(342375);
    return localg;
  }
  
  public final void dUL()
  {
    AppMethodBeat.i(342443);
    BaseMegaVideoLoader localBaseMegaVideoLoader2 = this.EzZ;
    BaseMegaVideoLoader localBaseMegaVideoLoader1 = localBaseMegaVideoLoader2;
    if (localBaseMegaVideoLoader2 == null)
    {
      kotlin.g.b.s.bIx("feedLoader");
      localBaseMegaVideoLoader1 = null;
    }
    BaseFeedLoader.requestInit$default((BaseFeedLoader)localBaseMegaVideoLoader1, false, 1, null);
    AppMethodBeat.o(342443);
  }
  
  public final com.tencent.mm.plugin.finder.megavideo.multitask.a eCQ()
  {
    AppMethodBeat.i(342340);
    com.tencent.mm.plugin.finder.megavideo.multitask.a locala = this.EAM;
    if (locala != null)
    {
      AppMethodBeat.o(342340);
      return locala;
    }
    kotlin.g.b.s.bIx("multiTaskHelper");
    AppMethodBeat.o(342340);
    return null;
  }
  
  public final h.b eCR()
  {
    AppMethodBeat.i(342389);
    h.b localb = this.EAL;
    if (localb == null)
    {
      kotlin.g.b.s.bIx("viewCallback");
      AppMethodBeat.o(342389);
      return null;
    }
    AppMethodBeat.o(342389);
    return localb;
  }
  
  public final void eCS()
  {
    AppMethodBeat.i(342487);
    h.b localb2 = this.EAL;
    h.b localb1 = localb2;
    if (localb2 == null)
    {
      kotlin.g.b.s.bIx("viewCallback");
      localb1 = null;
    }
    localb1.getRecyclerView().post(new f..ExternalSyntheticLambda8(this));
    AppMethodBeat.o(342487);
  }
  
  public final int ecg()
  {
    AppMethodBeat.i(342460);
    Object localObject2 = this.EAL;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("viewCallback");
      localObject1 = null;
    }
    localObject1 = ((h.b)localObject1).getRecyclerView();
    localObject2 = ((RecyclerView)localObject1).getLayoutManager();
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
      AppMethodBeat.o(342460);
      throw ((Throwable)localObject1);
    }
    localObject1 = ((RecyclerView)localObject1).fU(((LinearLayoutManager)localObject2).Ju());
    if ((localObject1 instanceof com.tencent.mm.view.recyclerview.j)) {
      localObject1 = (com.tencent.mm.view.recyclerview.j)localObject1;
    }
    while ((localObject1 != null) && ((((com.tencent.mm.view.recyclerview.j)localObject1).CSA instanceof ca)))
    {
      localObject1 = (FinderVideoLayout)((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.finder_banner_video_layout);
      if (localObject1 == null)
      {
        AppMethodBeat.o(342460);
        return 0;
        localObject1 = null;
      }
      else
      {
        int i = ((FinderVideoLayout)localObject1).getCurrentPosSec();
        AppMethodBeat.o(342460);
        return i;
      }
    }
    AppMethodBeat.o(342460);
    return 0;
  }
  
  public final ChatFooterPanel getSmileyPanel()
  {
    AppMethodBeat.i(342343);
    Object localObject = this.EAQ.getValue();
    kotlin.g.b.s.s(localObject, "<get-smileyPanel>(...)");
    localObject = (ChatFooterPanel)localObject;
    AppMethodBeat.o(342343);
    return localObject;
  }
  
  public final void onDetach()
  {
    Object localObject2 = null;
    AppMethodBeat.i(342397);
    this.lKz.close();
    Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = ((as)com.tencent.mm.ui.component.k.d(this.CCa).q(as.class)).Vm(-1);
    if (localObject1 != null)
    {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).b((com.tencent.mm.plugin.finder.event.base.d)this);
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).b((com.tencent.mm.plugin.finder.event.base.d)ecL());
    }
    Object localObject3 = this.EzZ;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("feedLoader");
      localObject1 = null;
    }
    localObject3 = this.EAL;
    if (localObject3 == null) {
      kotlin.g.b.s.bIx("viewCallback");
    }
    for (;;)
    {
      localObject3 = ((h.b)localObject2).ecd();
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = this.ATF;
      }
      ((BaseMegaVideoLoader)localObject1).unregister((com.tencent.mm.view.k)localObject2);
      ecL().onDetach();
      AppMethodBeat.o(342397);
      return;
      localObject2 = localObject3;
    }
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(342462);
    this.CCa.isFinishing();
    AppMethodBeat.o(342462);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(342437);
    BaseMegaVideoLoader localBaseMegaVideoLoader2 = this.EzZ;
    BaseMegaVideoLoader localBaseMegaVideoLoader1 = localBaseMegaVideoLoader2;
    if (localBaseMegaVideoLoader2 == null)
    {
      kotlin.g.b.s.bIx("feedLoader");
      localBaseMegaVideoLoader1 = null;
    }
    localBaseMegaVideoLoader1.requestRefresh();
    AppMethodBeat.o(342437);
  }
  
  public final void sM(boolean paramBoolean)
  {
    AppMethodBeat.i(342433);
    Log.i("FinderLongVideoTLPresenter", kotlin.g.b.s.X("onConfigurationChanged: isLandScape = ", Boolean.valueOf(paramBoolean)));
    if (this.EAW == paramBoolean)
    {
      AppMethodBeat.o(342433);
      return;
    }
    this.EAW = paramBoolean;
    Object localObject2 = this.EAL;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("viewCallback");
      localObject1 = null;
    }
    localObject1 = ((h.b)localObject1).getRecyclerView().getLayoutManager();
    boolean bool;
    label105:
    int j;
    if ((localObject1 instanceof FinderLinearLayoutManager))
    {
      localObject1 = (FinderLinearLayoutManager)localObject1;
      if (localObject1 == null) {
        break label1433;
      }
      if (paramBoolean) {
        break label514;
      }
      bool = true;
      ((FinderLinearLayoutManager)localObject1).GHU = bool;
      j = ((FinderLinearLayoutManager)localObject1).Ju();
      Log.i("FinderLongVideoTLPresenter", "onConfigurationChanged: isLandScape = " + paramBoolean + ", firstIndex = " + j);
      localObject2 = this.EAL;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("viewCallback");
        localObject1 = null;
      }
      localObject1 = ((h.b)localObject1).getRecyclerView().fT(j);
      if (!(localObject1 instanceof com.tencent.mm.view.recyclerview.j)) {
        break label520;
      }
      localObject1 = (com.tencent.mm.view.recyclerview.j)localObject1;
      label203:
      if (localObject1 == null) {
        break label1433;
      }
      localObject2 = com.tencent.mm.plugin.finder.megavideo.convert.a.Ezn;
      kotlin.g.b.s.u(localObject1, "holder");
      if (!paramBoolean) {
        break label526;
      }
      localObject2 = ((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.menu_layout);
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      localObject2 = ((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.description_tv);
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      localObject2 = ((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.warn_layout);
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      localObject2 = ((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.mega_video_op_layout);
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      localObject2 = ((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.unfold_video_button);
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      localObject2 = ((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.fold_video_button);
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(0);
      }
      localObject2 = ((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.footer_layout);
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(0);
      }
      localObject2 = ((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.play_speed_ctrl_btn);
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(0);
      }
      localObject2 = (LinearLayout)((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.header_layout);
      if (localObject2 != null) {
        ((LinearLayout)localObject2).setPadding(0, 0, 0, 0);
      }
      if (com.tencent.mm.ui.aw.bx(((com.tencent.mm.view.recyclerview.j)localObject1).context))
      {
        localObject2 = ((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.mega_video_seek_bar_layout);
        if (localObject2 != null) {
          ((View)localObject2).setPadding(com.tencent.mm.ui.aw.bw(((com.tencent.mm.view.recyclerview.j)localObject1).context), ((View)localObject2).getPaddingTop(), 0, ((View)localObject2).getPaddingBottom());
        }
      }
    }
    for (;;)
    {
      localObject2 = ((com.tencent.mm.view.recyclerview.j)localObject1).context;
      if (localObject2 != null) {
        break label953;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(342433);
      throw ((Throwable)localObject1);
      localObject1 = null;
      break;
      label514:
      bool = false;
      break label105;
      label520:
      localObject1 = null;
      break label203;
      label526:
      localObject2 = ((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.footer_layout);
      if ((localObject2 != null) && (((View)localObject2).getVisibility() == 0))
      {
        i = 1;
        if (i == 0) {
          break label834;
        }
        localObject2 = ((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.menu_layout);
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(0);
        }
        localObject2 = ((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.unfold_video_button);
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(0);
        }
      }
      for (;;)
      {
        localObject2 = ((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.description_tv);
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(0);
        }
        localObject2 = (TextView)((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.warn_word_tv);
        if ((localObject2 != null) && (!TextUtils.isEmpty(((TextView)localObject2).getText()))) {
          ((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.warn_layout).setVisibility(0);
        }
        localObject2 = ((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.mega_video_op_layout);
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(0);
        }
        localObject2 = ((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.fold_video_button);
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(8);
        }
        localObject2 = ((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.play_speed_ctrl_btn);
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(8);
        }
        localObject2 = (LinearLayout)((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.header_layout);
        if (localObject2 != null) {
          ((LinearLayout)localObject2).setPadding(0, ((com.tencent.mm.view.recyclerview.j)localObject1).context.getResources().getDimensionPixelOffset(e.c.Edge_5_5_A), 0, 0);
        }
        localObject2 = ((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.mega_video_seek_bar_layout);
        if (localObject2 != null) {
          ((View)localObject2).setPadding(0, ((View)localObject2).getPaddingTop(), 0, ((View)localObject2).getPaddingBottom());
        }
        localObject2 = ((com.tencent.mm.view.recyclerview.j)localObject1).context;
        if (localObject2 != null) {
          break label881;
        }
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(342433);
        throw ((Throwable)localObject1);
        i = 0;
        break;
        label834:
        localObject2 = ((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.menu_layout);
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(8);
        }
        localObject2 = ((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.unfold_video_button);
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(8);
        }
      }
      label881:
      localObject2 = ((Activity)localObject2).getWindow().getDecorView();
      localObject3 = ((com.tencent.mm.view.recyclerview.j)localObject1).context;
      if (localObject3 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(342433);
        throw ((Throwable)localObject1);
      }
      ((View)localObject2).setSystemUiVisibility(((Activity)localObject3).getWindow().getDecorView().getSystemUiVisibility() & 0xFFFFF7F9);
    }
    label953:
    ((MMActivity)localObject2).hideVKB();
    a.a.E((com.tencent.mm.view.recyclerview.j)localObject1);
    localObject2 = ((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.mega_video_bullet_input_layout);
    if (localObject2 != null) {
      ((View)localObject2).setVisibility(8);
    }
    this.lKz.close();
    this.lKz.start();
    this.EAR = EBc;
    Object localObject5 = (FinderMediaBanner)((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.media_banner);
    Object localObject3 = this.EzZ;
    localObject2 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("feedLoader");
      localObject2 = null;
    }
    Object localObject4 = (ca)((BaseMegaVideoLoader)localObject2).getDataList().get(j);
    localObject2 = (dji)kotlin.a.p.oL((List)((ca)localObject4).eDE());
    if (localObject2 == null)
    {
      Log.e("FinderLongVideoTLPresenter", kotlin.g.b.s.X("onConfigurationChanged: mega video media is null, id = ", Long.valueOf(((ca)localObject4).bZA())));
      AppMethodBeat.o(342433);
      return;
    }
    localObject3 = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    localObject2 = com.tencent.mm.plugin.finder.utils.aw.a((Context)this.CCa, ((dji)localObject2).width, ((dji)localObject2).height);
    int i = ((Number)((kotlin.u)localObject2).bsD).intValue();
    int k = ((Number)((kotlin.u)localObject2).aiuN).intValue();
    Log.i("FinderLongVideoTLPresenter", "onConfigurationChanged: resize width = " + i + ", height = " + k + ", firstIndex = " + j);
    localObject3 = ((FinderMediaBanner)localObject5).getPagerView().getLayoutParams();
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = new ViewGroup.LayoutParams(i, k);
    }
    ((ViewGroup.LayoutParams)localObject2).width = i;
    ((ViewGroup.LayoutParams)localObject2).height = k;
    localObject1 = (FinderVideoLayout)((com.tencent.mm.view.recyclerview.j)localObject1).UH(e.e.finder_banner_video_layout);
    label1284:
    label1357:
    String str;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!(localObject1 instanceof View)) {
        break label1450;
      }
      localObject1 = (View)localObject1;
      if (localObject1 != null)
      {
        ((View)localObject1).getLayoutParams().width = i;
        ((View)localObject1).getLayoutParams().height = k;
        if ((localObject1 instanceof FinderThumbPlayerProxy)) {
          ((FinderThumbPlayerProxy)localObject1).ib(i, k);
        }
      }
      ((FinderMediaBanner)localObject5).requestLayout();
      localObject1 = as.GSQ;
      localObject1 = as.a.hu((Context)this.CCa);
      if (localObject1 != null) {
        break label1456;
      }
      localObject3 = null;
      localObject1 = ax.Fur;
      localObject5 = com.tencent.mm.ae.d.hF(((ca)localObject4).eDF());
      str = com.tencent.mm.ae.d.hF(((ca)localObject4).bZA());
      if (!paramBoolean) {
        break label1466;
      }
      i = 1;
      label1388:
      if (localObject3 != null) {
        break label1471;
      }
      localObject1 = "";
      label1398:
      if (localObject3 != null) {
        break label1495;
      }
      localObject2 = "";
      label1408:
      if (localObject3 != null) {
        break label1519;
      }
      localObject3 = "";
    }
    for (;;)
    {
      ax.a((String)localObject5, str, 2, i, (String)localObject1, (String)localObject2, (String)localObject3);
      label1433:
      AppMethodBeat.o(342433);
      return;
      localObject1 = ((FinderVideoLayout)localObject1).getVideoView();
      break;
      label1450:
      localObject1 = null;
      break label1284;
      label1456:
      localObject3 = ((as)localObject1).fou();
      break label1357;
      label1466:
      i = 2;
      break label1388;
      label1471:
      localObject2 = ((bui)localObject3).sessionId;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label1398;
      }
      localObject1 = "";
      break label1398;
      label1495:
      localObject4 = ((bui)localObject3).zIO;
      localObject2 = localObject4;
      if (localObject4 != null) {
        break label1408;
      }
      localObject2 = "";
      break label1408;
      label1519:
      localObject4 = ((bui)localObject3).zIB;
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = "";
      }
    }
  }
  
  public final boolean sN(boolean paramBoolean)
  {
    AppMethodBeat.i(342450);
    Object localObject = ai(true, false);
    boolean bool1 = ((Boolean)((r)localObject).bsC).booleanValue();
    boolean bool2 = ((Boolean)((r)localObject).bsD).booleanValue();
    int i;
    if ((bool1) || (this.EAP))
    {
      localObject = eCQ();
      if (paramBoolean) {
        i = 1;
      }
    }
    for (paramBoolean = ((com.tencent.mm.plugin.finder.megavideo.multitask.a)localObject).af(i, bool2);; paramBoolean = false)
    {
      if ((paramBoolean) && (this.EAP))
      {
        AppMethodBeat.o(342450);
        return true;
        i = 2;
        break;
      }
      AppMethodBeat.o(342450);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter$Companion;", "", "()V", "INPUT_MODE_CLOSE", "", "getINPUT_MODE_CLOSE", "()I", "INPUT_MODE_OPEN", "getINPUT_MODE_OPEN", "INPUT_MODE_SMILEY", "getINPUT_MODE_SMILEY", "MENU_ID_ADD_TO_MULTITASK", "MENU_ID_CANCEL_FAV_TO_FINDER", "MENU_ID_CHANGE_PLAY_SPEED", "MENU_ID_CLOSE_BULLET", "MENU_ID_DELETE", "MENU_ID_DELETE_TO_MULTITASK", "MENU_ID_EXPOSE", "MENU_ID_FAV_TO_FINDER", "MENU_ID_OPEN_BULLET", "MENU_ID_SET_PRIVATE", "MENU_ID_SET_PUBLIC", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_TIMELINE", "PLAY_SPEED_0_5", "PLAY_SPEED_1", "PLAY_SPEED_1_5", "PLAY_SPEED_2", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Integer>
  {
    public static final b EBf;
    
    static
    {
      AppMethodBeat.i(341933);
      EBf = new b();
      AppMethodBeat.o(341933);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    c(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements g
  {
    e(f paramf) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(341916);
      if (paramInt == cb.class.hashCode())
      {
        localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.megavideo.convert.c(this.EBe);
        AppMethodBeat.o(341916);
        return localf;
      }
      com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.megavideo.convert.a(f.c(this.EBe), this.EBe);
      AppMethodBeat.o(341916);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.feed.model.i>
  {
    f(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Integer>
  {
    public static final g EBg;
    
    static
    {
      AppMethodBeat.i(341903);
      EBg = new g();
      AppMethodBeat.o(341903);
    }
    
    g()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter$getMoreMenuItemSelectedListener$1$1$3", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements com.tencent.mm.am.h
  {
    h(bt parambt, f paramf) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(341917);
      if (((paramp instanceof bt)) && (((bt)paramp).hKN == this.AVi.hKN))
      {
        com.tencent.mm.kernel.h.aZW().b(this.AVi.getType(), (com.tencent.mm.am.h)this);
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          aa.makeText((Context)f.g(paramf), e.h.finder_profile_del_feed_failed, 0).show();
        }
      }
      paramString = f.h(paramf);
      if (paramString != null) {
        paramString.dismiss();
      }
      AppMethodBeat.o(341917);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.b<IResponse<cc>, kotlin.ah>
  {
    i(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter$onAttach$2", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements l.b
  {
    j(f paramf) {}
    
    public final RecyclerView ebB()
    {
      AppMethodBeat.i(341955);
      h.b localb = f.d(this.EBe);
      Object localObject = localb;
      if (localb == null)
      {
        kotlin.g.b.s.bIx("viewCallback");
        localObject = null;
      }
      localObject = ((h.b)localObject).getRecyclerView();
      AppMethodBeat.o(341955);
      return localObject;
    }
    
    public final boolean ebC()
    {
      return true;
    }
    
    public final boolean ebD()
    {
      return true;
    }
    
    public final DataBuffer<cc> ebE()
    {
      AppMethodBeat.i(341968);
      BaseMegaVideoLoader localBaseMegaVideoLoader = f.f(this.EBe);
      Object localObject = localBaseMegaVideoLoader;
      if (localBaseMegaVideoLoader == null)
      {
        kotlin.g.b.s.bIx("feedLoader");
        localObject = null;
      }
      localObject = ((BaseMegaVideoLoader)localObject).getDataListJustForAdapter();
      AppMethodBeat.o(341968);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Integer, cc>
  {
    k(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    l(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/graphics/Paint;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Paint>
  {
    public static final m EBh;
    
    static
    {
      AppMethodBeat.i(341945);
      EBh = new m();
      AppMethodBeat.o(341945);
    }
    
    m()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/api/SmileyPanel;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends kotlin.g.b.u
    implements kotlin.g.a.a<SmileyPanel>
  {
    n(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.f
 * JD-Core Version:    0.7.0.1
 */