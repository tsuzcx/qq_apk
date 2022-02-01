package com.tencent.mm.plugin.finder.megavideo.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
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
import androidx.recyclerview.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.danmaku.c.m;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.ay;
import com.tencent.mm.plugin.finder.event.c.a;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.megavideo.bullet.MegaVideoBulletView;
import com.tencent.mm.plugin.finder.megavideo.bullet.b.a;
import com.tencent.mm.plugin.finder.megavideo.convert.a.a;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.af;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.model.bt;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.report.ai;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.utils.ac;
import com.tencent.mm.plugin.finder.utils.ac.a;
import com.tencent.mm.plugin.finder.utils.as;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.autoplay.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.video.l.b;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.TestPreloadPreview;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.protocal.protobuf.cwl;
import com.tencent.mm.protocal.protobuf.cwq;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.base.w.b;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "uic", "Lcom/tencent/mm/ui/component/UIComponent;", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/tencent/mm/ui/component/UIComponent;)V", "addToHistoryOffset", "", "getAddToHistoryOffset", "()I", "addToHistoryOffset$delegate", "Lkotlin/Lazy;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "commentPreloader$delegate", "configPosition", "currentPlaySpeed", "getCurrentPlaySpeed", "setCurrentPlaySpeed", "(I)V", "deleteFromHistoryOffset", "getDeleteFromHistoryOffset", "deleteFromHistoryOffset$delegate", "feedLoader", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "floatBallInfo", "Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;", "getFloatBallInfo", "()Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;", "setFloatBallInfo", "(Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;)V", "inputMode", "getInputMode", "setInputMode", "isAutoLoadingMore", "", "isInMultiTask", "()Z", "setInMultiTask", "(Z)V", "isSelfProfile", "setSelfProfile", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "getKeyboardHeightProvider", "()Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "setKeyboardHeightProvider", "(Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;)V", "loadingFooterData", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "mediaBannerViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "multiTaskHelper", "Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;", "getMultiTaskHelper", "()Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;", "setMultiTaskHelper", "(Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;)V", "oldStatus", "getOldStatus", "setOldStatus", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint$delegate", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "getSmileyPanel", "()Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "smileyPanel$delegate", "tipDialog", "Landroid/app/Dialog;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "videoFloatBallInfo", "getVideoFloatBallInfo", "setVideoFloatBallInfo", "viewCallback", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$ViewCallback;", "addToMultiTask", "", "item", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "videoCurrPlayTimes", "isHistory", "isUpdate", "addVideoFloatBall", "bindMultiTaskInfo", "info", "isMultiTask", "bindVideoFloatBall", "floatBallHelper", "Lcom/tencent/mm/plugin/finder/megavideo/floatball/MegaVideoFloatBallHelper;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkEmpty", "genMultiTaskCover", "Landroid/graphics/Bitmap;", "getActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "getCommentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "feed", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getCurrentSnapshotView", "Landroid/view/View;", "getCurrentVideoPosSec", "getMediaBannerRecyclerViewPool", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getVideoCore", "getViewCallback", "initViewCallback", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "loadInitData", "loadMoreData", "onAttach", "callback", "onBackPressed", "isFromCloseBtn", "onConfigurationChanged", "isLandScape", "onDetach", "onEventHappen", "ev", "onFavMegaVideo", "megaVideo", "isFav", "onLikeMegaVideo", "isLike", "isPrivate", "likeAction", "onMultiTaskPause", "onMultiTaskResume", "onUIPause", "onUIResume", "postCheckPlay", "refreshMsgNotify", "releaseResource", "currPos", "requestRefresh", "ratio", "", "setupEmojiPanel", "shareFeed", "shareFeedToSns", "updateMultiHistoryTask", "Lkotlin/Pair;", "isFromMultiTask", "Companion", "plugin-finder_release"})
public final class f
  extends com.tencent.mm.plugin.finder.event.base.d
  implements h.a
{
  private static final int kFh = 2;
  private static final int mLK = 104;
  private static final int wXf = 102;
  private static final int wXg = 103;
  private static final int xAr = 107;
  private static final int xAs = 108;
  private static final int xvk = 109;
  private static final int xvr = 112;
  private static final int xvs = 113;
  private static final int zxW = 105;
  private static final int zxX = 106;
  private static final int zxY = 110;
  private static final int zxZ = 111;
  private static final int zya = 114;
  private static final int zyb = 0;
  private static final int zyc = 1;
  public static final a zyd;
  com.tencent.mm.ui.tools.i jij;
  private Dialog tipDialog;
  private final kotlin.f xCQ;
  private final int xDe;
  private boolean xDf;
  public com.tencent.mm.plugin.finder.megavideo.multitask.a xMw;
  private cwl xMx;
  private final com.tencent.mm.plugin.finder.video.l xkW;
  private RecyclerView.m xvD;
  private com.tencent.mm.view.j xvV;
  public final AppCompatActivity ycV;
  public h.b zxJ;
  public cwl zxK;
  public boolean zxL;
  private boolean zxM;
  private final kotlin.f zxN;
  public int zxO;
  public int zxP;
  private final kotlin.f zxQ;
  private final kotlin.f zxR;
  private com.tencent.mm.view.recyclerview.h.b zxS;
  private boolean zxT;
  private final kotlin.f zxU;
  private final UIComponent zxV;
  public BaseMegaVideoLoader zxg;
  
  static
  {
    AppMethodBeat.i(263097);
    zyd = new a((byte)0);
    wXf = 102;
    wXg = 103;
    mLK = 104;
    zxW = 105;
    zxX = 106;
    xAr = 107;
    xAs = 108;
    xvk = 109;
    zxY = 110;
    zxZ = 111;
    xvr = 112;
    xvs = 113;
    zya = 114;
    zyc = 1;
    kFh = 2;
    AppMethodBeat.o(263097);
  }
  
  public f(AppCompatActivity paramAppCompatActivity, UIComponent paramUIComponent)
  {
    AppMethodBeat.i(263095);
    this.ycV = paramAppCompatActivity;
    this.zxV = paramUIComponent;
    this.xkW = new com.tencent.mm.plugin.finder.video.l();
    paramAppCompatActivity = com.tencent.mm.ui.component.g.Xox;
    this.xvD = ((com.tencent.mm.plugin.finder.viewmodel.c)com.tencent.mm.ui.component.g.b(this.ycV).i(com.tencent.mm.plugin.finder.viewmodel.c.class)).xvD;
    paramAppCompatActivity = this.ycV;
    if (paramAppCompatActivity == null)
    {
      paramAppCompatActivity = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(263095);
      throw paramAppCompatActivity;
    }
    this.jij = new com.tencent.mm.ui.tools.i((Activity)paramAppCompatActivity);
    this.zxN = kotlin.g.ar((kotlin.g.a.a)new r(this));
    this.zxO = zyb;
    this.zxP = 2;
    this.xCQ = kotlin.g.ar((kotlin.g.a.a)new f(this));
    this.zxQ = kotlin.g.ar((kotlin.g.a.a)b.zyf);
    this.zxR = kotlin.g.ar((kotlin.g.a.a)g.zyg);
    this.xvV = ((com.tencent.mm.view.j)new com.tencent.mm.view.j()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(288012);
        RecyclerView.a locala = f.b(this.zye).getRecyclerView().getAdapter();
        if (locala != null)
        {
          locala.notifyDataSetChanged();
          AppMethodBeat.o(288012);
          return;
        }
        AppMethodBeat.o(288012);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(288013);
        Log.i("FinderLongVideoTLPresenter", hashCode() + " onItemRangeChanged fromPosition:" + paramAnonymousInt1 + " itemCount" + paramAnonymousInt2);
        if (paramAnonymousInt2 > 0)
        {
          RecyclerView.a locala = f.b(this.zye).getRecyclerView().getAdapter();
          if (locala != null)
          {
            locala.aE(paramAnonymousInt1, paramAnonymousInt2);
            AppMethodBeat.o(288013);
            return;
          }
        }
        AppMethodBeat.o(288013);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(288014);
        Log.i("FinderLongVideoTLPresenter", hashCode() + " onItemRangeChanged payload fromPosition:" + paramAnonymousInt1 + " itemCount" + paramAnonymousInt2);
        if (paramAnonymousInt2 > 0)
        {
          RecyclerView.a locala = f.b(this.zye).getRecyclerView().getAdapter();
          if (locala != null)
          {
            locala.e(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
            AppMethodBeat.o(288014);
            return;
          }
        }
        AppMethodBeat.o(288014);
      }
      
      public final void onItemRangeInserted(final int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(288015);
        Log.i("FinderLongVideoTLPresenter", hashCode() + " onItemRangeInserted fromPosition:" + paramAnonymousInt1 + " itemCount" + paramAnonymousInt2);
        if (paramAnonymousInt2 > 0)
        {
          RecyclerView localRecyclerView = f.b(this.zye).getRecyclerView();
          RecyclerView.a locala = localRecyclerView.getAdapter();
          if (locala != null) {
            locala.aG(paramAnonymousInt1, paramAnonymousInt2);
          }
          localRecyclerView.post((Runnable)new a(localRecyclerView, paramAnonymousInt1));
        }
        AppMethodBeat.o(288015);
      }
      
      public final void onItemRangeRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(288016);
        Log.i("FinderLongVideoTLPresenter", hashCode() + " onItemRangeRemoved fromPosition:" + paramAnonymousInt1 + " itemCount" + paramAnonymousInt2);
        if (paramAnonymousInt2 > 0)
        {
          RecyclerView.a locala = f.b(this.zye).getRecyclerView().getAdapter();
          if (locala != null) {
            locala.aH(paramAnonymousInt1, paramAnonymousInt2);
          }
          f.h(this.zye);
        }
        AppMethodBeat.o(288016);
      }
      
      public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(288010);
        p.k(paramAnonymousc, "reason");
        f.g(this.zye);
        AppMethodBeat.o(288010);
      }
      
      public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(288011);
        p.k(paramAnonymousc, "reason");
        f.g(this.zye);
        AppMethodBeat.o(288011);
      }
      
      public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(288009);
        p.k(paramAnonymousc, "reason");
        f.g(this.zye);
        AppMethodBeat.o(288009);
      }
      
      @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
      static final class a
        implements Runnable
      {
        a(RecyclerView paramRecyclerView, int paramInt) {}
        
        public final void run()
        {
          AppMethodBeat.i(283440);
          Object localObject1 = this.xDK;
          Object localObject2 = this.xDK.getLayoutManager();
          if (localObject2 == null)
          {
            localObject1 = new kotlin.t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            AppMethodBeat.o(283440);
            throw ((Throwable)localObject1);
          }
          localObject2 = ((RecyclerView)localObject1).cJ(((LinearLayoutManager)localObject2).kL());
          localObject1 = localObject2;
          if (!(localObject2 instanceof com.tencent.mm.view.recyclerview.i)) {
            localObject1 = null;
          }
          localObject1 = (com.tencent.mm.view.recyclerview.i)localObject1;
          if (localObject1 != null)
          {
            if ((((com.tencent.mm.view.recyclerview.i)localObject1).ihX() instanceof bt))
            {
              localObject1 = this.xDK;
              localObject2 = com.tencent.mm.hellhoundlib.b.c.a(paramAnonymousInt1, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter$1$onItemRangeInserted$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
              ((RecyclerView)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter$1$onItemRangeInserted$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
            }
            AppMethodBeat.o(283440);
            return;
          }
          AppMethodBeat.o(283440);
        }
      }
    });
    paramAppCompatActivity = com.tencent.mm.kernel.h.aHG();
    p.j(paramAppCompatActivity, "MMKernel.storage()");
    this.xDe = paramAppCompatActivity.aHp().getInt(ar.a.VAa, 0);
    this.zxS = ((com.tencent.mm.view.recyclerview.h.b)new bt());
    this.zxU = kotlin.g.ar((kotlin.g.a.a)p.zyp);
    AppMethodBeat.o(263095);
  }
  
  private void a(h.b paramb)
  {
    int k = 0;
    AppMethodBeat.i(263051);
    p.k(paramb, "callback");
    Object localObject = com.tencent.mm.plugin.finder.megavideo.bullet.b.zvH;
    b.a.dJA().fB((Context)this.ycV);
    this.zxJ = paramb;
    dsr();
    com.tencent.mm.plugin.finder.video.l.a(this.xkW, this.ycV, (l.b)new l(this), 4);
    localObject = com.tencent.mm.ui.component.g.Xox;
    localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.a((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b(this.ycV).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class));
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject).a((com.tencent.mm.plugin.finder.event.base.d)this);
      ((com.tencent.mm.plugin.finder.event.base.c)localObject).a((com.tencent.mm.plugin.finder.event.base.d)dty());
    }
    localObject = this.zxJ;
    if (localObject == null) {
      p.bGy("viewCallback");
    }
    ((h.b)localObject).getRecyclerView().post((Runnable)new m(this));
    localObject = com.tencent.mm.plugin.finder.preload.c.zKl;
    if (com.tencent.mm.plugin.finder.preload.c.dMG())
    {
      localObject = this.zxJ;
      if (localObject == null) {
        p.bGy("viewCallback");
      }
      TestPreloadPreview localTestPreloadPreview = (TestPreloadPreview)((h.b)localObject).getRootView().findViewById(b.f.test_preload_view);
      if (localTestPreloadPreview != null)
      {
        localTestPreloadPreview.setVisibility(0);
        localObject = com.tencent.mm.ui.component.g.Xox;
        com.tencent.mm.plugin.finder.event.base.f localf = com.tencent.mm.plugin.finder.viewmodel.component.aj.d((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)dsB()).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class));
        if (localf != null)
        {
          localObject = this.zxg;
          if (localObject == null) {
            p.bGy("feedLoader");
          }
          DataBuffer localDataBuffer = ((BaseMegaVideoLoader)localObject).getDataListJustForAdapter();
          localObject = paramb.getRecyclerView().getAdapter();
          paramb = (h.b)localObject;
          if (!(localObject instanceof WxRecyclerAdapter)) {
            paramb = null;
          }
          paramb = (WxRecyclerAdapter)paramb;
          if (paramb == null) {
            break label415;
          }
          i = paramb.YSk.size();
          localTestPreloadPreview.a(localDataBuffer, i, this.xkW, localf.xqM, -1);
        }
      }
    }
    paramb = dty();
    if (this.zxL) {}
    for (int i = 1;; i = 2)
    {
      localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      localObject = aj.a.fZ((Context)this.ycV);
      int j = k;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject).ekY();
        j = k;
        if (localObject != null) {
          j = ((bid)localObject).xkX;
        }
      }
      paramb.a(i, j, (kotlin.g.a.b)new n(this));
      AppMethodBeat.o(263051);
      return;
      label415:
      i = 0;
      break;
    }
  }
  
  private void a(bs parambs, com.tencent.mm.view.recyclerview.i parami, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(263066);
    p.k(parambs, "item");
    p.k(parami, "holder");
    if (this.xMx == null)
    {
      ((f)this).xMx = new cwl();
      parami = x.aazN;
    }
    parami = parambs.xcy;
    if (parami != null)
    {
      parami = parami.TEM;
      if (parami != null)
      {
        parami = parami.description;
        if (!Util.isNullOrNil(parami)) {
          break label609;
        }
        Object localObject1 = this.ycV.getResources();
        int i = b.j.mega_video_post_ui_desc_tv_hint;
        Object localObject2 = (Context)this.ycV;
        parami = parambs.contact;
        if (parami == null) {
          break label604;
        }
        parami = parami.nickname;
        label112:
        parami = ((Resources)localObject1).getString(i, new Object[] { com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject2, (CharSequence)parami) });
        label136:
        localObject1 = this.xMx;
        if (localObject1 != null) {
          ((cwl)localObject1).TFj = 0;
        }
        localObject1 = this.xMx;
        if (localObject1 != null) {
          ((cwl)localObject1).TFi = paramInt;
        }
        localObject1 = this.xMx;
        if (localObject1 != null)
        {
          localObject1 = ((cwl)localObject1).TFg;
          if (localObject1 != null) {
            ((LinkedList)localObject1).clear();
          }
        }
        localObject1 = this.xMx;
        if (localObject1 != null)
        {
          localObject1 = ((cwl)localObject1).TFk;
          if (localObject1 != null) {
            ((LinkedList)localObject1).clear();
          }
        }
        localObject1 = this.xMx;
        if (localObject1 != null)
        {
          localObject1 = ((cwl)localObject1).TFk;
          if (localObject1 != null) {
            ((LinkedList)localObject1).add(parambs.getFeedObject());
          }
        }
        localObject1 = this.xMx;
        if (localObject1 != null) {
          ((cwl)localObject1).TFl = (parambs.fhq + parambs.getFeedObject().urlValidDuration * 1000L);
        }
        localObject1 = this.xMw;
        if (localObject1 == null) {
          p.bGy("multiTaskHelper");
        }
        localObject2 = ((com.tencent.mm.plugin.multitask.b.a)localObject1).FHd;
        if (localObject2 != null)
        {
          ((MultiTaskInfo)localObject2).field_id = com.tencent.mm.ae.d.Fw(parambs.dKW());
          ((MultiTaskInfo)localObject2).fbc().title = parami;
          dar localdar = ((MultiTaskInfo)localObject2).fbc();
          parami = parambs.contact;
          if (parami != null)
          {
            localObject1 = parami.headUrl;
            parami = (com.tencent.mm.view.recyclerview.i)localObject1;
            if (localObject1 != null) {}
          }
          else
          {
            parami = "";
          }
          localdar.TIg = parami;
          parami = this.xMx;
          if (parami == null) {
            break label640;
          }
          parami = parami.toByteArray();
          label396:
          ((MultiTaskInfo)localObject2).field_data = parami;
          parami = parambs.contact;
          if (parami != null)
          {
            ((MultiTaskInfo)localObject2).fbc().nickname = parami.nickname;
            parami = parami.authInfo;
            if (parami != null)
            {
              if (parami.authIconType <= 0) {
                break label645;
              }
              paramInt = 1;
              label441:
              if (paramInt == 0) {
                break label650;
              }
              label445:
              if (parami != null)
              {
                ((MultiTaskInfo)localObject2).fbc().TIh = parami.authIconType;
                ((MultiTaskInfo)localObject2).fbc().TIf = parami.authIconUrl;
              }
            }
          }
          parami = ((MultiTaskInfo)localObject2).fbc();
          parambs = parambs.xcy;
          if (parambs == null) {
            break label655;
          }
          parambs = parambs.TEM;
          if (parambs == null) {
            break label655;
          }
          parambs = parambs.media;
          if (parambs == null) {
            break label655;
          }
          parambs = (cwq)kotlin.a.j.lp((List)parambs);
          if (parambs == null) {
            break label655;
          }
          paramInt = parambs.TFq;
          label526:
          parami.KFK = paramInt;
        }
        if (!paramBoolean2)
        {
          if (!paramBoolean1) {
            break label670;
          }
          parambs = this.xMw;
          if (parambs == null) {
            p.bGy("multiTaskHelper");
          }
          parambs = parambs.FHd;
          if (parambs == null) {
            break label665;
          }
          if (((com.tencent.mm.plugin.taskbar.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.taskbar.c.class)).getTaskInfoById(parambs.field_id) == null) {
            break label660;
          }
          paramInt = 1;
        }
      }
    }
    for (;;)
    {
      if (paramInt == 0) {
        break label670;
      }
      AppMethodBeat.o(263066);
      return;
      parami = null;
      break;
      label604:
      parami = null;
      break label112;
      label609:
      parami = parambs.xcy;
      if (parami != null)
      {
        parami = parami.TEM;
        if (parami != null)
        {
          parami = parami.description;
          break label136;
        }
      }
      parami = null;
      break label136;
      label640:
      parami = null;
      break label396;
      label645:
      paramInt = 0;
      break label441;
      label650:
      parami = null;
      break label445;
      label655:
      paramInt = 0;
      break label526;
      label660:
      paramInt = 0;
      continue;
      label665:
      paramInt = 0;
    }
    label670:
    if (!paramBoolean1)
    {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this));
      AppMethodBeat.o(263066);
      return;
    }
    parambs = this.xMw;
    if (parambs == null) {
      p.bGy("multiTaskHelper");
    }
    parambs.dJO();
    AppMethodBeat.o(263066);
  }
  
  private void byN()
  {
    AppMethodBeat.i(263077);
    BaseMegaVideoLoader localBaseMegaVideoLoader = this.zxg;
    if (localBaseMegaVideoLoader == null) {
      p.bGy("feedLoader");
    }
    localBaseMegaVideoLoader.requestLoadMore();
    this.xDf = true;
    AppMethodBeat.o(263077);
  }
  
  private void dsr()
  {
    AppMethodBeat.i(263058);
    if (this.zxJ == null) {
      p.bGy("viewCallback");
    }
    Object localObject = this.zxg;
    if (localObject == null) {
      p.bGy("feedLoader");
    }
    ((BaseMegaVideoLoader)localObject).register(this.xvV);
    localObject = this.zxJ;
    if (localObject == null) {
      p.bGy("viewCallback");
    }
    BaseMegaVideoLoader localBaseMegaVideoLoader = this.zxg;
    if (localBaseMegaVideoLoader == null) {
      p.bGy("feedLoader");
    }
    ((h.b)localObject).ab((ArrayList)localBaseMegaVideoLoader.getDataListJustForAdapter());
    AppMethodBeat.o(263058);
  }
  
  private final com.tencent.mm.plugin.finder.feed.model.i dty()
  {
    AppMethodBeat.i(263043);
    com.tencent.mm.plugin.finder.feed.model.i locali = (com.tencent.mm.plugin.finder.feed.model.i)this.xCQ.getValue();
    AppMethodBeat.o(263043);
    return locali;
  }
  
  public final kotlin.o<Boolean, Boolean> X(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(263069);
    Object localObject1 = this.zxJ;
    if (localObject1 == null) {
      p.bGy("viewCallback");
    }
    localObject1 = ((h.b)localObject1).getRecyclerView();
    Object localObject2 = ((RecyclerView)localObject1).getLayoutManager();
    if (localObject2 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
      AppMethodBeat.o(263069);
      throw ((Throwable)localObject1);
    }
    localObject2 = ((RecyclerView)localObject1).cK(((LinearLayoutManager)localObject2).kJ());
    localObject1 = localObject2;
    if (!(localObject2 instanceof com.tencent.mm.view.recyclerview.i)) {
      localObject1 = null;
    }
    localObject1 = (com.tencent.mm.view.recyclerview.i)localObject1;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.view.recyclerview.i)localObject1).ihX();
      if (((localObject2 instanceof bs)) && ((((bs)localObject2).zBr) || (paramBoolean2) || (this.zxM)))
      {
        FinderVideoLayout localFinderVideoLayout = (FinderVideoLayout)((com.tencent.mm.view.recyclerview.i)localObject1).RD(b.f.finder_banner_video_layout);
        if (localFinderVideoLayout != null) {}
        for (int i = localFinderVideoLayout.getCurrentPosSec();; i = 0)
        {
          a((bs)localObject2, (com.tencent.mm.view.recyclerview.i)localObject1, i, true, paramBoolean1);
          localObject1 = new kotlin.o(Boolean.TRUE, Boolean.valueOf(((bs)localObject2).zBq));
          AppMethodBeat.o(263069);
          return localObject1;
        }
      }
    }
    localObject1 = Boolean.FALSE;
    localObject1 = new kotlin.o(localObject1, localObject1);
    AppMethodBeat.o(263069);
    return localObject1;
  }
  
  public final q.g a(final bs parambs, final com.tencent.mm.view.recyclerview.i parami)
  {
    AppMethodBeat.i(263087);
    p.k(parambs, "feed");
    p.k(parami, "holder");
    parambs = (q.g)new j(this, parambs, parami);
    AppMethodBeat.o(263087);
    return parambs;
  }
  
  public final void a(final com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(263046);
    p.k(paramb, "ev");
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h)) {
      switch (((com.tencent.mm.plugin.finder.event.base.h)paramb).type)
      {
      case 3: 
      case 4: 
      default: 
        label60:
        if ((((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 0) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 4))
        {
          localObject1 = this.zxJ;
          if (localObject1 == null) {
            p.bGy("viewCallback");
          }
          localObject2 = ((h.b)localObject1).getRecyclerView().cJ(((com.tencent.mm.plugin.finder.event.base.h)paramb).xrh);
          localObject1 = localObject2;
          if (!(localObject2 instanceof com.tencent.mm.view.recyclerview.i)) {
            localObject1 = null;
          }
          localObject1 = (com.tencent.mm.view.recyclerview.i)localObject1;
          if (localObject1 != null)
          {
            if (!(((com.tencent.mm.view.recyclerview.i)localObject1).ihX() instanceof bt)) {
              break label478;
            }
            Log.i("FinderLongVideoTLPresenter", "[onAutoToLoadMore] configPosition=" + this.xDe + ", firstVisibleItemPosition=" + ((com.tencent.mm.plugin.finder.event.base.h)paramb).xrh + ",  isAutoLoadingMore=" + this.xDf);
            if (!this.xDf) {
              byN();
            }
          }
        }
        break;
      }
    }
    int i;
    for (;;)
    {
      if ((paramb instanceof c.a)) {}
      switch (((c.a)paramb).type)
      {
      default: 
        AppMethodBeat.o(263046);
        return;
        Log.i("FinderLongVideoTLPresenter", "onEventHappen: set orientation portrait");
        this.ycV.setRequestedOrientation(1);
        break label60;
        if (this.xDe <= 0) {
          break label60;
        }
        localObject1 = this.zxJ;
        if (localObject1 == null) {
          p.bGy("viewCallback");
        }
        localObject2 = ((h.b)localObject1).getRecyclerView().getAdapter();
        localObject1 = localObject2;
        if (!(localObject2 instanceof com.tencent.mm.view.recyclerview.h)) {
          localObject1 = null;
        }
        localObject1 = (com.tencent.mm.view.recyclerview.h)localObject1;
        if (localObject1 != null) {}
        for (i = ((com.tencent.mm.view.recyclerview.h)localObject1).getItemCount() - ((com.tencent.mm.view.recyclerview.h)localObject1).YSl.size();; i = 0)
        {
          int j = i - this.xDe;
          if ((((com.tencent.mm.plugin.finder.event.base.h)paramb).xrj < j) || (i < 4)) {
            break;
          }
          Log.i("FinderLongVideoTLPresenter", "[onAutoToLoadMore] configPosition=" + this.xDe + ", lastVisibleItemPosition=" + ((com.tencent.mm.plugin.finder.event.base.h)paramb).xrj + ", preLoadBeginPosition=" + j + ", count=" + i + " isAutoLoadingMore=" + this.xDf);
          if (this.xDf) {
            break;
          }
          byN();
          break;
        }
        label478:
        localObject1 = ((com.tencent.mm.view.recyclerview.i)localObject1).RD(b.f.unfold_video_button);
        if (localObject1 != null) {
          if (((View)localObject1).getVisibility() == 0)
          {
            Log.i("FinderLongVideoTLPresenter", "onEventHappen: set orientation unspecified");
            this.ycV.setRequestedOrientation(-1);
          }
          else
          {
            Log.i("FinderLongVideoTLPresenter", "onEventHappen: set orientation portrait");
            this.ycV.setRequestedOrientation(1);
          }
        }
        break;
      }
    }
    AppMethodBeat.o(263046);
    return;
    Object localObject1 = this.zxg;
    if (localObject1 == null) {
      p.bGy("feedLoader");
    }
    Object localObject2 = ((Iterable)((BaseMegaVideoLoader)localObject1).getDataListJustForAdapter()).iterator();
    label580:
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (((bu)localObject1).mf() == ((c.a)paramb).feedId)
      {
        i = 1;
        label622:
        if (i == 0) {
          break label877;
        }
      }
    }
    for (;;)
    {
      localObject2 = (bu)localObject1;
      localObject1 = localObject2;
      if (!(localObject2 instanceof bs)) {
        localObject1 = null;
      }
      localObject1 = (bs)localObject1;
      if (localObject1 == null) {
        break;
      }
      if ((((c.a)paramb).offset >= ((Number)this.zxQ.getValue()).intValue()) && (!((bs)localObject1).zBr))
      {
        Log.i("FinderLongVideoTLPresenter", "onEventHappen: add to history, offset = " + ((c.a)paramb).offset + ", feedId = " + ((c.a)paramb).feedId);
        ((bs)localObject1).zBr = true;
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new o(this, paramb));
      }
      if ((((c.a)paramb).offset >= ((c.a)paramb).total - ((Number)this.zxR.getValue()).intValue()) && (!((bs)localObject1).zBq))
      {
        Log.i("FinderLongVideoTLPresenter", "onEventHappen: delete from history, offset = " + ((c.a)paramb).offset + ", total = " + ((c.a)paramb).total + ", feedId = " + ((c.a)paramb).feedId);
        ((bs)localObject1).zBq = true;
      }
      AppMethodBeat.o(263046);
      return;
      i = 0;
      break label622;
      label877:
      break label580;
      localObject1 = null;
    }
  }
  
  public final void a(com.tencent.mm.plugin.finder.megavideo.floatball.b paramb, cwl paramcwl)
  {
    AppMethodBeat.i(263060);
    p.k(paramb, "floatBallHelper");
    p.k(paramcwl, "info");
    this.zxK = paramcwl;
    AppMethodBeat.o(263060);
  }
  
  public final void a(BaseMegaVideoLoader paramBaseMegaVideoLoader, h.b paramb)
  {
    AppMethodBeat.i(263049);
    p.k(paramBaseMegaVideoLoader, "feedLoader");
    p.k(paramb, "callback");
    this.zxg = paramBaseMegaVideoLoader;
    paramBaseMegaVideoLoader.fetchEndCallback = ((kotlin.g.a.b)new k(this));
    a(paramb);
    AppMethodBeat.o(263049);
  }
  
  public final void a(com.tencent.mm.plugin.finder.megavideo.multitask.a parama, cwl paramcwl, boolean paramBoolean)
  {
    AppMethodBeat.i(263062);
    p.k(parama, "multiTaskHelper");
    p.k(paramcwl, "info");
    this.xMx = paramcwl;
    this.xMw = parama;
    this.zxM = paramBoolean;
    f localf = (f)this;
    com.tencent.mm.plugin.multitask.a.a locala = parama.FGb;
    paramcwl = locala;
    if (!(locala instanceof com.tencent.mm.plugin.finder.megavideo.multitask.b)) {
      paramcwl = null;
    }
    paramcwl = (com.tencent.mm.plugin.finder.megavideo.multitask.b)paramcwl;
    if (paramcwl != null) {
      paramcwl.zvV = localf;
    }
    parama.zvV = localf;
    AppMethodBeat.o(263062);
  }
  
  public final void a(bs parambs, boolean paramBoolean)
  {
    AppMethodBeat.i(263092);
    p.k(parambs, "megaVideo");
    Object localObject = com.tencent.mm.plugin.finder.model.r.zAk;
    localObject = this.ycV;
    FinderItem.a locala = FinderItem.Companion;
    com.tencent.mm.plugin.finder.model.r.a((AppCompatActivity)localObject, FinderItem.a.b(parambs.getFeedObject(), 32768), paramBoolean);
    AppMethodBeat.o(263092);
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(263047);
    p.k(paramc, "dispatcher");
    p.k(paramb, "event");
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
    {
      if ((((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 0) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 1) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 2) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 4))
      {
        AppMethodBeat.o(263047);
        return true;
      }
      AppMethodBeat.o(263047);
      return false;
    }
    if (((paramb instanceof c.a)) && ((((c.a)paramb).type == 2) || (((c.a)paramb).type == 3)))
    {
      AppMethodBeat.o(263047);
      return true;
    }
    AppMethodBeat.o(263047);
    return false;
  }
  
  public final ChatFooterPanel dJX()
  {
    AppMethodBeat.i(263041);
    ChatFooterPanel localChatFooterPanel = (ChatFooterPanel)this.zxN.getValue();
    AppMethodBeat.o(263041);
    return localChatFooterPanel;
  }
  
  public final h.b dJY()
  {
    AppMethodBeat.i(263055);
    h.b localb = this.zxJ;
    if (localb == null) {
      p.bGy("viewCallback");
    }
    AppMethodBeat.o(263055);
    return localb;
  }
  
  public final void dJZ()
  {
    AppMethodBeat.i(263093);
    h.b localb = this.zxJ;
    if (localb == null) {
      p.bGy("viewCallback");
    }
    localb.getRecyclerView().post((Runnable)new q(this));
    AppMethodBeat.o(263093);
  }
  
  public final MMFragmentActivity dsB()
  {
    AppMethodBeat.i(263090);
    Object localObject = this.ycV;
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
      AppMethodBeat.o(263090);
      throw ((Throwable)localObject);
    }
    localObject = (MMFragmentActivity)localObject;
    AppMethodBeat.o(263090);
    return localObject;
  }
  
  public final void dsF()
  {
    AppMethodBeat.i(263079);
    BaseMegaVideoLoader localBaseMegaVideoLoader = this.zxg;
    if (localBaseMegaVideoLoader == null) {
      p.bGy("feedLoader");
    }
    BaseFeedLoader.requestInit$default(localBaseMegaVideoLoader, false, 1, null);
    AppMethodBeat.o(263079);
  }
  
  public final com.tencent.mm.view.recyclerview.f dsu()
  {
    AppMethodBeat.i(263048);
    com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new e(this);
    AppMethodBeat.o(263048);
    return localf;
  }
  
  public final int dtf()
  {
    AppMethodBeat.i(263081);
    Object localObject1 = this.zxJ;
    if (localObject1 == null) {
      p.bGy("viewCallback");
    }
    localObject1 = ((h.b)localObject1).getRecyclerView();
    Object localObject2 = ((RecyclerView)localObject1).getLayoutManager();
    if (localObject2 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
      AppMethodBeat.o(263081);
      throw ((Throwable)localObject1);
    }
    localObject2 = ((RecyclerView)localObject1).cK(((LinearLayoutManager)localObject2).kJ());
    localObject1 = localObject2;
    if (!(localObject2 instanceof com.tencent.mm.view.recyclerview.i)) {
      localObject1 = null;
    }
    localObject1 = (com.tencent.mm.view.recyclerview.i)localObject1;
    if ((localObject1 != null) && ((((com.tencent.mm.view.recyclerview.i)localObject1).ihX() instanceof bs)))
    {
      localObject1 = (FinderVideoLayout)((com.tencent.mm.view.recyclerview.i)localObject1).RD(b.f.finder_banner_video_layout);
      if (localObject1 != null)
      {
        int i = ((FinderVideoLayout)localObject1).getCurrentPosSec();
        AppMethodBeat.o(263081);
        return i;
      }
      AppMethodBeat.o(263081);
      return 0;
    }
    AppMethodBeat.o(263081);
    return 0;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(263057);
    Object localObject = com.tencent.mm.plugin.finder.megavideo.bullet.b.zvH;
    com.tencent.mm.plugin.finder.megavideo.bullet.b localb = b.a.dJA();
    Context localContext = (Context)this.ycV;
    p.k(localContext, "context");
    Iterator localIterator = ((Iterable)localb.zvF).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!p.h((Context)((WeakReference)localObject).get(), localContext));
    for (;;)
    {
      localObject = (WeakReference)localObject;
      if (localObject != null)
      {
        Log.i("MegaVideoBulletThreadManager", "detach: context = ".concat(String.valueOf(localContext)));
        localb.zvF.remove(localObject);
      }
      if (localb.zvF.isEmpty())
      {
        Log.i("MegaVideoBulletThreadManager", "detach: attachContextSet is empty, release threads");
        localb.dJy();
      }
      this.jij.close();
      localObject = com.tencent.mm.ui.component.g.Xox;
      localObject = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b(this.ycV).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).RU(-1);
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this);
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)dty());
      }
      localObject = this.zxg;
      if (localObject == null) {
        p.bGy("feedLoader");
      }
      if (this.zxJ == null) {
        p.bGy("viewCallback");
      }
      ((BaseMegaVideoLoader)localObject).unregister(this.xvV);
      dty().onDetach();
      AppMethodBeat.o(263057);
      return;
      localObject = null;
    }
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(263084);
    this.ycV.isFinishing();
    AppMethodBeat.o(263084);
  }
  
  public final void pP(boolean paramBoolean)
  {
    AppMethodBeat.i(263073);
    Log.i("FinderLongVideoTLPresenter", "onConfigurationChanged: isLandScape = ".concat(String.valueOf(paramBoolean)));
    if (this.zxT == paramBoolean)
    {
      AppMethodBeat.o(263073);
      return;
    }
    this.zxT = paramBoolean;
    Object localObject1 = this.zxJ;
    if (localObject1 == null) {
      p.bGy("viewCallback");
    }
    Object localObject2 = ((h.b)localObject1).getRecyclerView().getLayoutManager();
    localObject1 = localObject2;
    if (!(localObject2 instanceof FinderLinearLayoutManager)) {
      localObject1 = null;
    }
    localObject1 = (FinderLinearLayoutManager)localObject1;
    if (localObject1 != null)
    {
      boolean bool;
      int j;
      Object localObject3;
      if (!paramBoolean)
      {
        bool = true;
        ((FinderLinearLayoutManager)localObject1).BfC = bool;
        j = ((FinderLinearLayoutManager)localObject1).kJ();
        Log.i("FinderLongVideoTLPresenter", "onConfigurationChanged: isLandScape = " + paramBoolean + ", firstIndex = " + j);
        localObject1 = this.zxJ;
        if (localObject1 == null) {
          p.bGy("viewCallback");
        }
        localObject2 = ((h.b)localObject1).getRecyclerView().cJ(j);
        localObject1 = localObject2;
        if (!(localObject2 instanceof com.tencent.mm.view.recyclerview.i)) {
          localObject1 = null;
        }
        localObject3 = (com.tencent.mm.view.recyclerview.i)localObject1;
        if (localObject3 == null) {
          break label1714;
        }
        localObject1 = com.tencent.mm.plugin.finder.megavideo.convert.a.zvX;
        p.k(localObject3, "holder");
        if (!paramBoolean) {
          break label517;
        }
        localObject1 = ((com.tencent.mm.view.recyclerview.i)localObject3).RD(b.f.menu_layout);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        localObject1 = ((com.tencent.mm.view.recyclerview.i)localObject3).RD(b.f.description_tv);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        localObject1 = ((com.tencent.mm.view.recyclerview.i)localObject3).RD(b.f.warn_layout);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        localObject1 = ((com.tencent.mm.view.recyclerview.i)localObject3).RD(b.f.mega_video_op_layout);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        localObject1 = ((com.tencent.mm.view.recyclerview.i)localObject3).RD(b.f.unfold_video_button);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        localObject1 = ((com.tencent.mm.view.recyclerview.i)localObject3).RD(b.f.fold_video_button);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
        localObject1 = ((com.tencent.mm.view.recyclerview.i)localObject3).RD(b.f.footer_layout);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
        localObject1 = ((com.tencent.mm.view.recyclerview.i)localObject3).RD(b.f.play_speed_ctrl_btn);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
        localObject1 = (LinearLayout)((com.tencent.mm.view.recyclerview.i)localObject3).RD(b.f.header_layout);
        if (localObject1 != null) {
          ((LinearLayout)localObject1).setPadding(0, 0, 0, 0);
        }
        if (ar.aN(((com.tencent.mm.view.recyclerview.i)localObject3).getContext()))
        {
          localObject1 = ((com.tencent.mm.view.recyclerview.i)localObject3).RD(b.f.mega_video_seek_bar_layout);
          if (localObject1 != null) {
            ((View)localObject1).setPadding(ar.aM(((com.tencent.mm.view.recyclerview.i)localObject3).getContext()), ((View)localObject1).getPaddingTop(), 0, ((View)localObject1).getPaddingBottom());
          }
        }
      }
      for (;;)
      {
        localObject1 = ((com.tencent.mm.view.recyclerview.i)localObject3).getContext();
        if (localObject1 != null) {
          break label1001;
        }
        localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(263073);
        throw ((Throwable)localObject1);
        bool = false;
        break;
        label517:
        localObject1 = ((com.tencent.mm.view.recyclerview.i)localObject3).RD(b.f.footer_layout);
        if ((localObject1 != null) && (((View)localObject1).getVisibility() == 0))
        {
          localObject1 = ((com.tencent.mm.view.recyclerview.i)localObject3).RD(b.f.menu_layout);
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(0);
          }
          localObject1 = ((com.tencent.mm.view.recyclerview.i)localObject3).RD(b.f.unfold_video_button);
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(0);
          }
        }
        for (;;)
        {
          localObject1 = ((com.tencent.mm.view.recyclerview.i)localObject3).RD(b.f.description_tv);
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(0);
          }
          localObject1 = (TextView)((com.tencent.mm.view.recyclerview.i)localObject3).RD(b.f.warn_word_tv);
          if ((localObject1 != null) && (!TextUtils.isEmpty(((TextView)localObject1).getText())))
          {
            localObject1 = ((com.tencent.mm.view.recyclerview.i)localObject3).RD(b.f.warn_layout);
            p.j(localObject1, "holder.getView<View>(R.id.warn_layout)");
            ((View)localObject1).setVisibility(0);
          }
          localObject1 = ((com.tencent.mm.view.recyclerview.i)localObject3).RD(b.f.mega_video_op_layout);
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(0);
          }
          localObject1 = ((com.tencent.mm.view.recyclerview.i)localObject3).RD(b.f.fold_video_button);
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(8);
          }
          localObject1 = ((com.tencent.mm.view.recyclerview.i)localObject3).RD(b.f.play_speed_ctrl_btn);
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(8);
          }
          localObject1 = (LinearLayout)((com.tencent.mm.view.recyclerview.i)localObject3).RD(b.f.header_layout);
          if (localObject1 != null)
          {
            localObject2 = ((com.tencent.mm.view.recyclerview.i)localObject3).getContext();
            p.j(localObject2, "holder.context");
            ((LinearLayout)localObject1).setPadding(0, ((Context)localObject2).getResources().getDimensionPixelOffset(b.d.Edge_5_5_A), 0, 0);
          }
          localObject1 = ((com.tencent.mm.view.recyclerview.i)localObject3).RD(b.f.mega_video_seek_bar_layout);
          if (localObject1 != null) {
            ((View)localObject1).setPadding(0, ((View)localObject1).getPaddingTop(), 0, ((View)localObject1).getPaddingBottom());
          }
          localObject1 = ((com.tencent.mm.view.recyclerview.i)localObject3).getContext();
          if (localObject1 != null) {
            break;
          }
          localObject1 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(263073);
          throw ((Throwable)localObject1);
          localObject1 = ((com.tencent.mm.view.recyclerview.i)localObject3).RD(b.f.menu_layout);
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(8);
          }
          localObject1 = ((com.tencent.mm.view.recyclerview.i)localObject3).RD(b.f.unfold_video_button);
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(8);
          }
        }
        localObject1 = ((Activity)localObject1).getWindow();
        p.j(localObject1, "(holder.context as Activity).window");
        localObject1 = ((Window)localObject1).getDecorView();
        p.j(localObject1, "(holder.context as Activity).window.decorView");
        localObject2 = ((com.tencent.mm.view.recyclerview.i)localObject3).getContext();
        if (localObject2 == null)
        {
          localObject1 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(263073);
          throw ((Throwable)localObject1);
        }
        localObject2 = ((Activity)localObject2).getWindow();
        p.j(localObject2, "(holder.context as Activity).window");
        localObject2 = ((Window)localObject2).getDecorView();
        p.j(localObject2, "(holder.context as Activity).window.decorView");
        ((View)localObject1).setSystemUiVisibility(((View)localObject2).getSystemUiVisibility() & 0xFFFFF7F9);
      }
      label1001:
      ((MMActivity)localObject1).hideVKB();
      a.a.s((com.tencent.mm.view.recyclerview.i)localObject3);
      localObject1 = ((com.tencent.mm.view.recyclerview.i)localObject3).RD(b.f.mega_video_bullet_input_layout);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      this.jij.close();
      this.jij.start();
      this.zxO = zyb;
      localObject1 = (MegaVideoBulletView)((com.tencent.mm.view.recyclerview.i)localObject3).RD(b.f.bullet_layout);
      float f = this.zxP;
      localObject1 = ((MegaVideoBulletView)localObject1).zvK;
      if (paramBoolean) {}
      Object localObject5;
      for (int i = 12000;; i = 6000)
      {
        localObject2 = com.tencent.mm.danmaku.c.a.azC();
        p.j(localObject2, "DanmakuContext.getWindowConfig()");
        ((m)localObject2).setDuration((int)(i / (f * 0.5F)));
        localObject2 = ((com.tencent.mm.plugin.finder.megavideo.bullet.a)localObject1).zvw;
        if (localObject2 == null) {
          p.bGy("danmakuManager");
        }
        ((com.tencent.mm.danmaku.a.g)localObject2).ayH();
        localObject1 = ((com.tencent.mm.plugin.finder.megavideo.bullet.a)localObject1).zvw;
        if (localObject1 == null) {
          p.bGy("danmakuManager");
        }
        ((com.tencent.mm.danmaku.a.g)localObject1).ayG();
        localObject5 = (FinderMediaBanner)((com.tencent.mm.view.recyclerview.i)localObject3).RD(b.f.media_banner);
        localObject1 = this.zxg;
        if (localObject1 == null) {
          p.bGy("feedLoader");
        }
        localObject1 = ((BaseMegaVideoLoader)localObject1).getDataList().get(j);
        if (localObject1 != null) {
          break;
        }
        localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.MegaVideoFeed");
        AppMethodBeat.o(263073);
        throw ((Throwable)localObject1);
      }
      Object localObject4 = (bs)localObject1;
      localObject1 = (csg)kotlin.a.j.lp((List)((bs)localObject4).dKV());
      if (localObject1 == null)
      {
        Log.e("FinderLongVideoTLPresenter", "onConfigurationChanged: mega video media is null, id = " + ((bs)localObject4).mf());
        AppMethodBeat.o(263073);
        return;
      }
      localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      localObject1 = com.tencent.mm.plugin.finder.utils.aj.a((Context)this.ycV, ((csg)localObject1).width, ((csg)localObject1).height);
      i = ((Number)((kotlin.r)localObject1).My).intValue();
      int k = ((Number)((kotlin.r)localObject1).aazK).intValue();
      Log.i("FinderLongVideoTLPresenter", "onConfigurationChanged: resize width = " + i + ", height = " + k + ", firstIndex = " + j);
      localObject2 = ((FinderMediaBanner)localObject5).getPagerView().getLayoutParams();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ViewGroup.LayoutParams(i, k);
      }
      ((ViewGroup.LayoutParams)localObject1).width = i;
      ((ViewGroup.LayoutParams)localObject1).height = k;
      localObject1 = (FinderVideoLayout)((com.tencent.mm.view.recyclerview.i)localObject3).RD(b.f.finder_banner_video_layout);
      label1566:
      String str;
      if (localObject1 != null)
      {
        localObject1 = ((FinderVideoLayout)localObject1).getVideoView();
        localObject2 = localObject1;
        if (!(localObject1 instanceof View)) {
          localObject2 = null;
        }
        localObject1 = (View)localObject2;
        if (localObject1 != null)
        {
          ((View)localObject1).getLayoutParams().width = i;
          ((View)localObject1).getLayoutParams().height = k;
          if ((localObject1 instanceof FinderThumbPlayerProxy)) {
            ((FinderThumbPlayerProxy)localObject1).hg(i, k);
          }
        }
        ((FinderMediaBanner)localObject5).requestLayout();
        localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        localObject1 = aj.a.fZ((Context)this.ycV);
        if (localObject1 == null) {
          break label1703;
        }
        localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1).ekY();
        localObject2 = ai.zZt;
        localObject5 = com.tencent.mm.ae.d.Fw(((bs)localObject4).dKW());
        str = com.tencent.mm.ae.d.Fw(((bs)localObject4).mf());
        if (!paramBoolean) {
          break label1709;
        }
      }
      label1703:
      label1709:
      for (i = 1;; i = 2)
      {
        if (localObject1 != null)
        {
          localObject3 = ((bid)localObject1).sessionId;
          localObject2 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject2 = "";
        }
        if (localObject1 != null)
        {
          localObject4 = ((bid)localObject1).wmL;
          localObject3 = localObject4;
          if (localObject4 != null) {}
        }
        else
        {
          localObject3 = "";
        }
        if (localObject1 != null)
        {
          localObject4 = ((bid)localObject1).wmz;
          localObject1 = localObject4;
          if (localObject4 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        ai.a((String)localObject5, str, 2, i, (String)localObject2, (String)localObject3, (String)localObject1);
        AppMethodBeat.o(263073);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label1566;
      }
      label1714:
      AppMethodBeat.o(263073);
      return;
    }
    AppMethodBeat.o(263073);
  }
  
  public final boolean pQ(boolean paramBoolean)
  {
    AppMethodBeat.i(263080);
    Object localObject = X(true, false);
    boolean bool1 = ((Boolean)((kotlin.o)localObject).Mx).booleanValue();
    boolean bool2 = ((Boolean)((kotlin.o)localObject).My).booleanValue();
    int i;
    if ((bool1) || (this.zxM))
    {
      localObject = this.xMw;
      if (localObject == null) {
        p.bGy("multiTaskHelper");
      }
      if (paramBoolean) {
        i = 1;
      }
    }
    for (paramBoolean = ((com.tencent.mm.plugin.finder.megavideo.multitask.a)localObject).Q(i, bool2);; paramBoolean = false)
    {
      if ((paramBoolean) && (this.zxM))
      {
        AppMethodBeat.o(263080);
        return true;
        i = 2;
        break;
      }
      AppMethodBeat.o(263080);
      return false;
    }
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(263076);
    BaseMegaVideoLoader localBaseMegaVideoLoader = this.zxg;
    if (localBaseMegaVideoLoader == null) {
      p.bGy("feedLoader");
    }
    localBaseMegaVideoLoader.requestRefresh();
    AppMethodBeat.o(263076);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter$Companion;", "", "()V", "INPUT_MODE_CLOSE", "", "getINPUT_MODE_CLOSE", "()I", "INPUT_MODE_OPEN", "getINPUT_MODE_OPEN", "INPUT_MODE_SMILEY", "getINPUT_MODE_SMILEY", "MENU_ID_ADD_TO_MULTITASK", "MENU_ID_CANCEL_FAV_TO_FINDER", "MENU_ID_CHANGE_PLAY_SPEED", "MENU_ID_CLOSE_BULLET", "MENU_ID_DELETE", "MENU_ID_DELETE_TO_MULTITASK", "MENU_ID_EXPOSE", "MENU_ID_FAV_TO_FINDER", "MENU_ID_OPEN_BULLET", "MENU_ID_SET_PRIVATE", "MENU_ID_SET_PUBLIC", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_TIMELINE", "PLAY_SPEED_0_5", "PLAY_SPEED_1", "PLAY_SPEED_1_5", "PLAY_SPEED_2", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    public static final b zyf;
    
    static
    {
      AppMethodBeat.i(268728);
      zyf = new b();
      AppMethodBeat.o(268728);
    }
    
    b()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(f paramf)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class e
    implements com.tencent.mm.view.recyclerview.f
  {
    public final com.tencent.mm.view.recyclerview.e<?> yx(int paramInt)
    {
      AppMethodBeat.i(288470);
      if (paramInt == bt.class.hashCode())
      {
        locale = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.megavideo.convert.c(this.zye);
        AppMethodBeat.o(288470);
        return locale;
      }
      com.tencent.mm.view.recyclerview.e locale = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.megavideo.convert.a(f.a(this.zye), this.zye);
      AppMethodBeat.o(288470);
      return locale;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.feed.model.i>
  {
    f(f paramf)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    public static final g zyg;
    
    static
    {
      AppMethodBeat.i(285499);
      zyg = new g();
      AppMethodBeat.o(285499);
    }
    
    g()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  public static final class h
    implements q.f
  {
    public h(f paramf, bs parambs) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramo)
    {
      int j = 1;
      AppMethodBeat.i(276055);
      Object localObject1 = f.e(this.zye).getString(b.j.app_share_to_weixin);
      p.j(localObject1, "context.getString(R.string.app_share_to_weixin)");
      Object localObject2 = f.e(this.zye).getString(b.j.finder_share_timeline);
      p.j(localObject2, "context.getString(R.string.finder_share_timeline)");
      Object localObject3 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      boolean bool2;
      if ((!com.tencent.mm.plugin.finder.utils.aj.a(this.zyh)) || (!this.zyh.isPrivate()))
      {
        localObject3 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (com.tencent.mm.plugin.finder.utils.aj.a(this.zyh.xcy)) {}
      }
      else
      {
        localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        localObject1 = com.tencent.mm.plugin.finder.utils.aj.el("FinderSafeSelfSeeForward", b.j.finder_self_see_tips_forward);
        localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        localObject2 = com.tencent.mm.plugin.finder.utils.aj.el("FinderSafeSelfSeeShare", b.j.finder_self_see_tips_sns);
        bool2 = true;
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        int i;
        if (this.zyh.dKY())
        {
          localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          localObject2 = com.tencent.mm.plugin.finder.utils.aj.el("FinderSafeSelfSeeForward", b.j.finder_self_see_tips_forward);
          localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          localObject3 = com.tencent.mm.plugin.finder.utils.aj.el("FinderSafeSelfSeeShare", b.j.finder_self_see_tips_sns);
          localObject1 = this.zyh.xcy;
          if (localObject1 != null)
          {
            localObject1 = ((cvy)localObject1).TEP;
            if (localObject1 != null)
            {
              localObject1 = n.a((CharSequence)localObject1, new String[] { "#" });
              if (localObject1 == null) {
                break label424;
              }
              if (((List)localObject1).size() <= 2) {
                break label413;
              }
              i = 1;
              label233:
              if (i == 0) {
                break label418;
              }
              label237:
              if (localObject1 == null) {
                break label424;
              }
              localObject3 = (String)((List)localObject1).get(0);
              localObject2 = (String)((List)localObject1).get(1);
              bool2 = true;
              bool1 = true;
              localObject1 = localObject3;
            }
          }
        }
        for (;;)
        {
          label278:
          paramo.a(f.dmA(), (CharSequence)localObject1, b.i.finder_icons_filled_share, f.e(this.zye).getResources().getColor(b.c.Brand), bool1);
          paramo.a(f.dmB(), (CharSequence)localObject2, b.i.bottomsheet_icon_moment, 0, bool2);
          localObject1 = com.tencent.mm.plugin.finder.upload.action.c.ABD;
          if (!com.tencent.mm.plugin.finder.upload.action.c.ecy().p(this.zyh.getFeedObject())) {}
          for (i = j;; i = 0)
          {
            if (i == 0) {
              break label446;
            }
            paramo.a(f.dtO(), (CharSequence)f.e(this.zye).getString(b.j.favorite), b.i.finder_icons_filled_star2, f.e(this.zye).getResources().getColor(b.c.orange_100));
            AppMethodBeat.o(276055);
            return;
            localObject1 = null;
            break;
            label413:
            i = 0;
            break label233;
            label418:
            localObject1 = null;
            break label237;
            label424:
            bool2 = true;
            bool1 = true;
            localObject1 = localObject2;
            localObject2 = localObject3;
            break label278;
          }
          label446:
          paramo.a(f.dtP(), (CharSequence)f.e(this.zye).getString(b.j.finder_cancel_fav_title), b.i.finder_icons_filled_unstar2, f.e(this.zye).getResources().getColor(b.c.orange_100));
          AppMethodBeat.o(276055);
          return;
        }
        bool2 = false;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  public static final class i
    implements q.f
  {
    public i(f paramf, bs parambs) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramo)
    {
      AppMethodBeat.i(277789);
      paramo.b(f.dKa(), (CharSequence)f.e(this.zye).getString(b.j.enter_multi_task_float_ball), b.i.icons_outlined_multitask);
      Object localObject;
      switch (this.zye.zxP)
      {
      default: 
        localObject = f.e(this.zye).getString(b.j.mega_video_play_speed_text);
      }
      for (;;)
      {
        p.j(localObject, "when (currentPlaySpeed) …lay_speed_text)\n        }");
        paramo.b(f.dKb(), (CharSequence)localObject, b.i.icons_outlined_play_control);
        localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (!com.tencent.mm.plugin.finder.utils.aj.a(this.zyh)) {
          break;
        }
        paramo.aW(f.dtM(), b.j.app_delete, b.i.icons_outlined_delete);
        localObject = y.AEi;
        p.j(paramo, "menu");
        localObject = (Context)f.e(this.zye);
        kotlin.a.j.lp((List)this.zyh.dKV());
        y.a(paramo, (Context)localObject, f.dKc(), f.dKd(), this.zyh.isPrivate(), this.zyh.dKZ());
        AppMethodBeat.o(277789);
        return;
        localObject = f.e(this.zye).getString(b.j.mega_video_play_speed_0_5);
        continue;
        localObject = f.e(this.zye).getString(b.j.mega_video_play_speed_text);
        continue;
        localObject = f.e(this.zye).getString(b.j.mega_video_play_speed_1_5);
        continue;
        localObject = f.e(this.zye).getString(b.j.mega_video_play_speed_2);
      }
      paramo.b(f.dtH(), (CharSequence)f.e(this.zye).getString(b.j.more_menu_back), b.i.icons_outlined_report_problem);
      AppMethodBeat.o(277789);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "index", "", "onMMMenuItemSelected"})
  static final class j
    implements q.g
  {
    j(f paramf, bs parambs, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(282677);
      p.k(paramMenuItem, "menuItem");
      Log.i("FinderLongVideoTLPresenter", "[getMoreMenuItemSelectedListener] feed " + parambs + ' ' + paramInt + " menuItem:" + paramMenuItem.getItemId());
      paramInt = paramMenuItem.getItemId();
      Object localObject;
      FinderItem.a locala;
      if (paramInt == f.dmA())
      {
        paramMenuItem = ac.AEJ;
        localObject = f.e(this.zye);
        locala = FinderItem.Companion;
        ac.a.a(paramMenuItem, (AppCompatActivity)localObject, FinderItem.a.b(parambs.getFeedObject(), 32768), null, 3, null, 20);
        AppMethodBeat.o(282677);
        return;
      }
      if (paramInt == f.dmB())
      {
        paramMenuItem = ac.AEJ;
        localObject = f.e(this.zye);
        locala = FinderItem.Companion;
        ac.a.a(paramMenuItem, (AppCompatActivity)localObject, (BaseFinderFeed)new af(FinderItem.a.b(parambs.getFeedObject(), 32768)), 2, 0, 20);
        AppMethodBeat.o(282677);
        return;
      }
      if (paramInt == f.dtM())
      {
        com.tencent.mm.ui.base.h.a((Context)f.e(this.zye), b.j.finder_delete_mega_video_confirm, 0, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
        {
          public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(271330);
            Object localObject2 = z.bdh();
            p.j(localObject2, "ConfigStorageLogic.getMyFinderUsername()");
            Object localObject1 = this.zyi.zyh.xcy;
            paramAnonymousDialogInterface = (DialogInterface)localObject1;
            if (localObject1 == null) {
              paramAnonymousDialogInterface = new cvy();
            }
            paramAnonymousDialogInterface = new ay((String)localObject2, paramAnonymousDialogInterface);
            localObject1 = f.f(this.zyi.zye);
            if (localObject1 != null) {
              ((Dialog)localObject1).show();
            }
            for (;;)
            {
              com.tencent.mm.kernel.h.aGY().a(paramAnonymousDialogInterface.getType(), (com.tencent.mm.an.i)new com.tencent.mm.an.i()
              {
                public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.an.q paramAnonymous2q)
                {
                  AppMethodBeat.i(288693);
                  if (((paramAnonymous2q instanceof ay)) && (((ay)paramAnonymous2q).xbk == paramAnonymousDialogInterface.xbk))
                  {
                    com.tencent.mm.kernel.h.aGY().b(paramAnonymousDialogInterface.getType(), (com.tencent.mm.an.i)this);
                    if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0)) {
                      w.makeText((Context)f.e(this.zyk.zyi.zye), b.j.finder_profile_del_feed_failed, 0).show();
                    }
                  }
                  paramAnonymous2String = f.f(this.zyk.zyi.zye);
                  if (paramAnonymous2String != null)
                  {
                    paramAnonymous2String.dismiss();
                    AppMethodBeat.o(288693);
                    return;
                  }
                  AppMethodBeat.o(288693);
                }
              });
              com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)paramAnonymousDialogInterface);
              AppMethodBeat.o(271330);
              return;
              localObject1 = this.zyi.zye;
              localObject2 = (Context)f.e((f)localObject1);
              f.e((f)localObject1).getString(b.j.app_tip);
              f.a((f)localObject1, (Dialog)com.tencent.mm.ui.base.h.a((Context)localObject2, f.e((f)localObject1).getString(b.j.app_waiting), false, (DialogInterface.OnCancelListener)a.zyj));
            }
          }
          
          @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
          static final class a
            implements DialogInterface.OnCancelListener
          {
            public static final a zyj;
            
            static
            {
              AppMethodBeat.i(272525);
              zyj = new a();
              AppMethodBeat.o(272525);
            }
            
            public final void onCancel(DialogInterface paramDialogInterface) {}
          }
        }, null);
        AppMethodBeat.o(282677);
        return;
      }
      if (paramInt == f.dKe())
      {
        paramMenuItem = com.tencent.mm.plugin.finder.storage.data.e.AmW;
        e.a.o(parambs.getFeedObject());
        paramMenuItem = as.AJf;
        as.a((Context)f.e(this.zye), parambs.mf(), true);
        AppMethodBeat.o(282677);
        return;
      }
      if (paramInt == f.dKf())
      {
        paramMenuItem = com.tencent.mm.plugin.finder.storage.data.e.AmW;
        e.a.o(parambs.getFeedObject());
        paramMenuItem = as.AJf;
        as.a((Context)f.e(this.zye), parambs.mf(), false);
        AppMethodBeat.o(282677);
        return;
      }
      if (paramInt == f.dKc())
      {
        paramMenuItem = com.tencent.mm.plugin.finder.storage.data.e.AmW;
        e.a.o(parambs.getFeedObject());
        paramMenuItem = y.AEi;
        y.a((Context)f.e(this.zye), parambs.mf(), parambs.dKW(), parambs.dKX(), false);
        AppMethodBeat.o(282677);
        return;
      }
      if (paramInt == f.dKd())
      {
        paramMenuItem = com.tencent.mm.plugin.finder.storage.data.e.AmW;
        e.a.o(parambs.getFeedObject());
        com.tencent.mm.ui.base.h.a((Context)f.e(this.zye), b.j.finder_set_mega_video_private_confirm, 0, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(289826);
            paramAnonymousDialogInterface = y.AEi;
            y.a((Context)f.e(this.zyi.zye), this.zyi.zyh.mf(), this.zyi.zyh.dKW(), this.zyi.zyh.dKX(), true);
            AppMethodBeat.o(289826);
          }
        }, null);
        AppMethodBeat.o(282677);
        return;
      }
      if (paramInt == f.dtH())
      {
        paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.a.xFq;
        com.tencent.mm.plugin.finder.feed.logic.a.a((Context)f.e(this.zye), parambs.mf(), 0L, 0, 12);
        AppMethodBeat.o(282677);
        return;
      }
      if (paramInt == f.dKa())
      {
        paramMenuItem = (FinderVideoLayout)parami.RD(b.f.finder_banner_video_layout);
        if (paramMenuItem != null) {}
        for (paramInt = paramMenuItem.getCurrentPosSec();; paramInt = 0)
        {
          f.a(this.zye, parambs, parami, paramInt);
          AppMethodBeat.o(282677);
          return;
        }
      }
      if (paramInt == f.dtO())
      {
        paramMenuItem = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (!com.tencent.mm.plugin.finder.utils.aj.c(parambs.xcy))
        {
          paramMenuItem = com.tencent.mm.plugin.finder.utils.aj.AGc;
          paramMenuItem = parami.getContext();
          p.j(paramMenuItem, "holder.context");
          localObject = parami.getContext().getString(b.j.finder_private_ban_fav);
          p.j(localObject, "holder.context.getString…g.finder_private_ban_fav)");
          com.tencent.mm.plugin.finder.utils.aj.aL(paramMenuItem, (String)localObject);
          AppMethodBeat.o(282677);
          return;
        }
        w.a((Context)f.e(this.zye), f.e(this.zye).getResources().getString(b.j.finder_has_fav_title), (w.b)3.zyl);
        this.zye.a(parambs, true);
        AppMethodBeat.o(282677);
        return;
      }
      if (paramInt == f.dtP())
      {
        w.a((Context)f.e(this.zye), f.e(this.zye).getResources().getString(b.j.finder_has_cancel_fav_title), (w.b)4.zym);
        this.zye.a(parambs, false);
        AppMethodBeat.o(282677);
        return;
      }
      if (paramInt == f.dKb())
      {
        paramMenuItem = com.tencent.mm.plugin.finder.megavideo.convert.a.zvX;
        a.a.a(parami, this.zye);
      }
      AppMethodBeat.o(282677);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.b<IResponse<bu>, x>
  {
    k(f paramf)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter$onAttach$2", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"})
  public static final class l
    implements l.b
  {
    public final RecyclerView dsx()
    {
      AppMethodBeat.i(245780);
      RecyclerView localRecyclerView = f.b(this.zye).getRecyclerView();
      AppMethodBeat.o(245780);
      return localRecyclerView;
    }
    
    public final DataBuffer<bu> dsy()
    {
      AppMethodBeat.i(245781);
      DataBuffer localDataBuffer = f.d(this.zye).getDataListJustForAdapter();
      AppMethodBeat.o(245781);
      return localDataBuffer;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    m(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(273954);
      this.zye.jij.start();
      AppMethodBeat.o(273954);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
  static final class n
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Integer, bu>
  {
    n(f paramf)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter$onEventHappen$2$1"})
  static final class o
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    o(f paramf, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/graphics/Paint;", "invoke"})
  static final class p
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Paint>
  {
    public static final p zyp;
    
    static
    {
      AppMethodBeat.i(291987);
      zyp = new p();
      AppMethodBeat.o(291987);
    }
    
    p()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class q
    implements Runnable
  {
    q(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(285443);
      FinderVideoAutoPlayManager localFinderVideoAutoPlayManager = f.a(this.zye).ANA;
      if (localFinderVideoAutoPlayManager != null)
      {
        localFinderVideoAutoPlayManager.aGl("FinderLongVideoTLPresenter");
        AppMethodBeat.o(285443);
        return;
      }
      AppMethodBeat.o(285443);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/api/SmileyPanel;", "kotlin.jvm.PlatformType", "invoke"})
  static final class r
    extends kotlin.g.b.q
    implements kotlin.g.a.a<SmileyPanel>
  {
    r(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.f
 * JD-Core Version:    0.7.0.1
 */