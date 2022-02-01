package com.tencent.mm.plugin.finder.megavideo.ui;

import android.app.Activity;
import android.app.Dialog;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.m;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.av;
import com.tencent.mm.plugin.finder.event.c.a;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.megavideo.convert.a.a;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ad;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bn;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.report.af;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.utils.s.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.k;
import com.tencent.mm.plugin.finder.video.k.b;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.TestPreloadPreview;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.thumbplayer.view.MMThumbPlayerTextureView;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cnu;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.o;
import kotlin.r;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "context", "Landroid/support/v7/app/AppCompatActivity;", "uic", "Lcom/tencent/mm/ui/component/UIComponent;", "(Landroid/support/v7/app/AppCompatActivity;Lcom/tencent/mm/ui/component/UIComponent;)V", "MENU_ID_ADD_TO_MULTITASK", "", "MENU_ID_CLOSE_BULLET", "MENU_ID_DELETE", "MENU_ID_DELETE_TO_MULTITASK", "MENU_ID_EXPOSE", "MENU_ID_OPEN_BULLET", "MENU_ID_SET_PRIVATE", "MENU_ID_SET_PUBLIC", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_TIMELINE", "addToHistoryOffset", "getAddToHistoryOffset", "()I", "addToHistoryOffset$delegate", "Lkotlin/Lazy;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "commentPreloader$delegate", "configPosition", "deleteFromHistoryOffset", "getDeleteFromHistoryOffset", "deleteFromHistoryOffset$delegate", "feedLoader", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "floatBallInfo", "Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;", "getFloatBallInfo", "()Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;", "setFloatBallInfo", "(Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;)V", "isAutoLoadingMore", "", "isInMultiTask", "()Z", "setInMultiTask", "(Z)V", "isSelfProfile", "setSelfProfile", "loadingFooterData", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "mediaBannerViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "multiTaskHelper", "Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;", "getMultiTaskHelper", "()Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;", "setMultiTaskHelper", "(Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;)V", "oldStatus", "getOldStatus", "setOldStatus", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint$delegate", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "tipDialog", "Landroid/app/Dialog;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "viewCallback", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$ViewCallback;", "addToMultiTask", "", "item", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "videoCurrPlayTimes", "isHistory", "isUpdate", "bindMultiTaskInfo", "info", "isMultiTask", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkEmpty", "genMultiTaskCover", "Landroid/graphics/Bitmap;", "getActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "getCommentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "feed", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getCurrentSnapshotView", "Landroid/view/View;", "getMediaBannerRecyclerViewPool", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getVideoCore", "getViewCallback", "initViewCallback", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "loadInitData", "loadMoreData", "onAttach", "callback", "onBackPressed", "isFromCloseBtn", "onConfigurationChanged", "isLandScape", "onDetach", "onEventHappen", "ev", "onFavMegaVideo", "megaVideo", "isFav", "onLikeMegaVideo", "isLike", "isPrivate", "onMultiTaskPause", "onMultiTaskResume", "onUIPause", "onUIResume", "postCheckPlay", "refreshMsgNotify", "releaseResource", "currPos", "requestRefresh", "shareFeed", "shareFeedToSns", "updateMultiHistoryTask", "Lkotlin/Pair;", "isFromMultiTask", "Companion", "plugin-finder_release"})
public final class f
  extends com.tencent.mm.plugin.finder.event.base.d
  implements h.a
{
  public static final a uMm;
  private final int jUx;
  private final int pLU;
  private final int pMa;
  private final k tCD;
  private RecyclerView.m tLO;
  private com.tencent.mm.view.j tMe;
  private final int tPA;
  private final int tPB;
  private final kotlin.f tRX;
  private final int tSl;
  private boolean tSn;
  private Dialog tipDialog;
  private final int tqv;
  private BaseMegaVideoLoader uLF;
  public h.b uLW;
  public com.tencent.mm.plugin.finder.megavideo.multitask.a uLX;
  private cnu uLY;
  public boolean uLZ;
  private boolean uMa;
  private final kotlin.f uMb;
  private final kotlin.f uMc;
  private final int uMd;
  private final int uMe;
  private final int uMf;
  private final int uMg;
  private g.b uMh;
  private boolean uMi;
  private final kotlin.f uMj;
  public final AppCompatActivity uMk;
  private final UIComponent uMl;
  
  static
  {
    AppMethodBeat.i(248589);
    uMm = new a((byte)0);
    AppMethodBeat.o(248589);
  }
  
  public f(AppCompatActivity paramAppCompatActivity, UIComponent paramUIComponent)
  {
    AppMethodBeat.i(248588);
    this.uMk = paramAppCompatActivity;
    this.uMl = paramUIComponent;
    this.tCD = new k();
    paramAppCompatActivity = com.tencent.mm.ui.component.a.PRN;
    this.tLO = ((FinderRecyclerViewPool)com.tencent.mm.ui.component.a.b(this.uMk).get(FinderRecyclerViewPool.class)).tLO;
    this.tRX = kotlin.g.ah((kotlin.g.a.a)new e(this));
    this.uMb = kotlin.g.ah((kotlin.g.a.a)b.uMo);
    this.uMc = kotlin.g.ah((kotlin.g.a.a)f.uMp);
    this.tqv = 102;
    this.pLU = 103;
    this.jUx = 104;
    this.uMd = 105;
    this.uMe = 106;
    this.tPA = 107;
    this.tPB = 108;
    this.pMa = 109;
    this.uMf = 110;
    this.uMg = 111;
    this.tMe = ((com.tencent.mm.view.j)new com.tencent.mm.view.j()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(248536);
        RecyclerView.a locala = f.a(this.uMn).getRecyclerView().getAdapter();
        if (locala != null)
        {
          locala.notifyDataSetChanged();
          AppMethodBeat.o(248536);
          return;
        }
        AppMethodBeat.o(248536);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(248537);
        Log.i("FinderLongVideoTLPresenter", hashCode() + " onItemRangeChanged fromPosition:" + paramAnonymousInt1 + " itemCount" + paramAnonymousInt2);
        if (paramAnonymousInt2 > 0)
        {
          RecyclerView.a locala = f.a(this.uMn).getRecyclerView().getAdapter();
          if (locala != null)
          {
            locala.aq(paramAnonymousInt1, paramAnonymousInt2);
            AppMethodBeat.o(248537);
            return;
          }
        }
        AppMethodBeat.o(248537);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(248538);
        Log.i("FinderLongVideoTLPresenter", hashCode() + " onItemRangeChanged payload fromPosition:" + paramAnonymousInt1 + " itemCount" + paramAnonymousInt2);
        if (paramAnonymousInt2 > 0)
        {
          RecyclerView.a locala = f.a(this.uMn).getRecyclerView().getAdapter();
          if (locala != null)
          {
            locala.e(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
            AppMethodBeat.o(248538);
            return;
          }
        }
        AppMethodBeat.o(248538);
      }
      
      public final void onItemRangeInserted(final int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(248539);
        Log.i("FinderLongVideoTLPresenter", hashCode() + " onItemRangeInserted fromPosition:" + paramAnonymousInt1 + " itemCount" + paramAnonymousInt2);
        if (paramAnonymousInt2 > 0)
        {
          RecyclerView localRecyclerView = f.a(this.uMn).getRecyclerView();
          RecyclerView.a locala = localRecyclerView.getAdapter();
          if (locala != null) {
            locala.as(paramAnonymousInt1, paramAnonymousInt2);
          }
          localRecyclerView.post((Runnable)new a(localRecyclerView, paramAnonymousInt1));
        }
        AppMethodBeat.o(248539);
      }
      
      public final void onItemRangeRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(248540);
        Log.i("FinderLongVideoTLPresenter", hashCode() + " onItemRangeRemoved fromPosition:" + paramAnonymousInt1 + " itemCount" + paramAnonymousInt2);
        if (paramAnonymousInt2 > 0)
        {
          RecyclerView.a locala = f.a(this.uMn).getRecyclerView().getAdapter();
          if (locala != null) {
            locala.at(paramAnonymousInt1, paramAnonymousInt2);
          }
          f.o(this.uMn);
        }
        AppMethodBeat.o(248540);
      }
      
      public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(248534);
        p.h(paramAnonymousc, "reason");
        f.n(this.uMn);
        AppMethodBeat.o(248534);
      }
      
      public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(248535);
        p.h(paramAnonymousc, "reason");
        f.n(this.uMn);
        AppMethodBeat.o(248535);
      }
      
      public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(248533);
        p.h(paramAnonymousc, "reason");
        f.n(this.uMn);
        AppMethodBeat.o(248533);
      }
      
      @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
      static final class a
        implements Runnable
      {
        a(RecyclerView paramRecyclerView, int paramInt) {}
        
        public final void run()
        {
          AppMethodBeat.i(248532);
          Object localObject1 = this.tST;
          Object localObject2 = this.tST.getLayoutManager();
          if (localObject2 == null)
          {
            localObject1 = new kotlin.t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
            AppMethodBeat.o(248532);
            throw ((Throwable)localObject1);
          }
          localObject2 = ((RecyclerView)localObject1).cg(((LinearLayoutManager)localObject2).ku());
          localObject1 = localObject2;
          if (!(localObject2 instanceof com.tencent.mm.view.recyclerview.h)) {
            localObject1 = null;
          }
          localObject1 = (com.tencent.mm.view.recyclerview.h)localObject1;
          if (localObject1 != null)
          {
            if ((((com.tencent.mm.view.recyclerview.h)localObject1).hgv() instanceof bn))
            {
              localObject1 = this.tST;
              localObject2 = com.tencent.mm.hellhoundlib.b.c.a(paramAnonymousInt1, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter$1$onItemRangeInserted$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
              ((RecyclerView)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter$1$onItemRangeInserted$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
            }
            AppMethodBeat.o(248532);
            return;
          }
          AppMethodBeat.o(248532);
        }
      }
    });
    paramAppCompatActivity = com.tencent.mm.kernel.g.aAh();
    p.g(paramAppCompatActivity, "MMKernel.storage()");
    this.tSl = paramAppCompatActivity.azQ().getInt(ar.a.Olf, 0);
    this.uMh = ((g.b)new bn());
    this.uMj = kotlin.g.ah((kotlin.g.a.a)o.uMx);
    AppMethodBeat.o(248588);
  }
  
  private void a(h.b paramb)
  {
    int k = 0;
    AppMethodBeat.i(248571);
    p.h(paramb, "callback");
    this.uLW = paramb;
    dcb();
    k.a(this.tCD, this.uMk, (k.b)new k(this), 4);
    Object localObject = com.tencent.mm.ui.component.a.PRN;
    localObject = FinderReporterUIC.a((FinderReporterUIC)com.tencent.mm.ui.component.a.b(this.uMk).get(FinderReporterUIC.class));
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject).a((com.tencent.mm.plugin.finder.event.base.d)this);
      ((com.tencent.mm.plugin.finder.event.base.c)localObject).a((com.tencent.mm.plugin.finder.event.base.d)dcW());
    }
    localObject = MediaPreloadCore.uTV;
    if (MediaPreloadCore.dlF())
    {
      localObject = this.uLW;
      if (localObject == null) {
        p.btv("viewCallback");
      }
      TestPreloadPreview localTestPreloadPreview = (TestPreloadPreview)((h.b)localObject).getRootView().findViewById(2131308975);
      if (localTestPreloadPreview != null)
      {
        localTestPreloadPreview.setVisibility(0);
        localObject = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.plugin.finder.event.base.f localf = FinderReporterUIC.d((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)dcl()).get(FinderReporterUIC.class));
        if (localf != null)
        {
          localObject = this.uLF;
          if (localObject == null) {
            p.btv("feedLoader");
          }
          DataBuffer localDataBuffer = ((BaseMegaVideoLoader)localObject).getDataListJustForAdapter();
          localObject = paramb.getRecyclerView().getAdapter();
          paramb = (h.b)localObject;
          if (!(localObject instanceof WxRecyclerAdapter)) {
            paramb = null;
          }
          paramb = (WxRecyclerAdapter)paramb;
          if (paramb == null) {
            break label358;
          }
          i = paramb.RqM.size();
          localTestPreloadPreview.a(localDataBuffer, i, this.tCD, localf.tId, -1);
        }
      }
    }
    paramb = dcW();
    if (this.uLZ) {}
    for (int i = 1;; i = 2)
    {
      localObject = FinderReporterUIC.wzC;
      localObject = FinderReporterUIC.a.fH((Context)this.uMk);
      int j = k;
      if (localObject != null)
      {
        localObject = ((FinderReporterUIC)localObject).dIx();
        j = k;
        if (localObject != null) {
          j = ((bbn)localObject).tCE;
        }
      }
      paramb.a(i, j, (kotlin.g.a.b)new l(this));
      AppMethodBeat.o(248571);
      return;
      label358:
      i = 0;
      break;
    }
  }
  
  private void a(bm parambm, com.tencent.mm.view.recyclerview.h paramh, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(248577);
    p.h(parambm, "item");
    p.h(paramh, "holder");
    if (this.uLY == null)
    {
      ((f)this).uLY = new cnu();
      paramh = x.SXb;
    }
    paramh = parambm.tuP;
    if (paramh != null)
    {
      paramh = paramh.MtG;
      if (paramh != null)
      {
        paramh = paramh.description;
        if (!Util.isNullOrNil(paramh)) {
          break label605;
        }
        Object localObject1 = this.uMk.getResources();
        Object localObject2 = (Context)this.uMk;
        paramh = parambm.contact;
        if (paramh == null) {
          break label600;
        }
        paramh = paramh.nickname;
        label107:
        paramh = ((Resources)localObject1).getString(2131763020, new Object[] { com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject2, (CharSequence)paramh) });
        label132:
        localObject1 = this.uLY;
        if (localObject1 != null) {
          ((cnu)localObject1).Mue = 0;
        }
        localObject1 = this.uLY;
        if (localObject1 != null) {
          ((cnu)localObject1).Mud = paramInt;
        }
        localObject1 = this.uLY;
        if (localObject1 != null)
        {
          localObject1 = ((cnu)localObject1).Mub;
          if (localObject1 != null) {
            ((LinkedList)localObject1).clear();
          }
        }
        localObject1 = this.uLY;
        if (localObject1 != null)
        {
          localObject1 = ((cnu)localObject1).Muf;
          if (localObject1 != null) {
            ((LinkedList)localObject1).clear();
          }
        }
        localObject1 = this.uLY;
        if (localObject1 != null)
        {
          localObject1 = ((cnu)localObject1).Muf;
          if (localObject1 != null) {
            ((LinkedList)localObject1).add(parambm.getFeedObject());
          }
        }
        localObject1 = this.uLY;
        if (localObject1 != null) {
          ((cnu)localObject1).Mug = (parambm.uOV + parambm.getFeedObject().urlValidDuration * 1000L);
        }
        localObject1 = this.uLX;
        if (localObject1 == null) {
          p.btv("multiTaskHelper");
        }
        localObject2 = ((com.tencent.mm.plugin.multitask.b.a)localObject1).Abp;
        if (localObject2 != null)
        {
          ((MultiTaskInfo)localObject2).field_id = com.tencent.mm.ac.d.zs(parambm.dkW());
          ((MultiTaskInfo)localObject2).erh().title = paramh;
          cru localcru = ((MultiTaskInfo)localObject2).erh();
          paramh = parambm.contact;
          if (paramh != null)
          {
            localObject1 = paramh.headUrl;
            paramh = (com.tencent.mm.view.recyclerview.h)localObject1;
            if (localObject1 != null) {}
          }
          else
          {
            paramh = "";
          }
          localcru.MwR = paramh;
          paramh = this.uLY;
          if (paramh == null) {
            break label636;
          }
          paramh = paramh.toByteArray();
          label392:
          ((MultiTaskInfo)localObject2).field_data = paramh;
          paramh = parambm.contact;
          if (paramh != null)
          {
            ((MultiTaskInfo)localObject2).erh().nickname = paramh.nickname;
            paramh = paramh.authInfo;
            if (paramh != null)
            {
              if (paramh.authIconType <= 0) {
                break label641;
              }
              paramInt = 1;
              label437:
              if (paramInt == 0) {
                break label646;
              }
              label441:
              if (paramh != null)
              {
                ((MultiTaskInfo)localObject2).erh().MwS = paramh.authIconType;
                ((MultiTaskInfo)localObject2).erh().MwQ = paramh.authIconUrl;
              }
            }
          }
          paramh = ((MultiTaskInfo)localObject2).erh();
          parambm = parambm.tuP;
          if (parambm == null) {
            break label651;
          }
          parambm = parambm.MtG;
          if (parambm == null) {
            break label651;
          }
          parambm = parambm.media;
          if (parambm == null) {
            break label651;
          }
          parambm = (cod)kotlin.a.j.kt((List)parambm);
          if (parambm == null) {
            break label651;
          }
          paramInt = parambm.Mur;
          label522:
          paramh.Eso = paramInt;
        }
        if (!paramBoolean2)
        {
          if (!paramBoolean1) {
            break label666;
          }
          parambm = this.uLX;
          if (parambm == null) {
            p.btv("multiTaskHelper");
          }
          parambm = parambm.Abp;
          if (parambm == null) {
            break label661;
          }
          if (((com.tencent.mm.plugin.taskbar.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.taskbar.d.class)).getTaskInfoById(parambm.field_id) == null) {
            break label656;
          }
          paramInt = 1;
        }
      }
    }
    for (;;)
    {
      if (paramInt == 0) {
        break label666;
      }
      AppMethodBeat.o(248577);
      return;
      paramh = null;
      break;
      label600:
      paramh = null;
      break label107;
      label605:
      paramh = parambm.tuP;
      if (paramh != null)
      {
        paramh = paramh.MtG;
        if (paramh != null)
        {
          paramh = paramh.description;
          break label132;
        }
      }
      paramh = null;
      break label132;
      label636:
      paramh = null;
      break label392;
      label641:
      paramInt = 0;
      break label437;
      label646:
      paramh = null;
      break label441;
      label651:
      paramInt = 0;
      break label522;
      label656:
      paramInt = 0;
      continue;
      label661:
      paramInt = 0;
    }
    label666:
    if (!paramBoolean1)
    {
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new c(this));
      AppMethodBeat.o(248577);
      return;
    }
    parambm = this.uLX;
    if (parambm == null) {
      p.btv("multiTaskHelper");
    }
    parambm.dkj();
    AppMethodBeat.o(248577);
  }
  
  private void boE()
  {
    AppMethodBeat.i(248582);
    BaseMegaVideoLoader localBaseMegaVideoLoader = this.uLF;
    if (localBaseMegaVideoLoader == null) {
      p.btv("feedLoader");
    }
    localBaseMegaVideoLoader.requestLoadMore();
    this.tSn = true;
    AppMethodBeat.o(248582);
  }
  
  private final com.tencent.mm.plugin.finder.feed.model.d dcW()
  {
    AppMethodBeat.i(248566);
    com.tencent.mm.plugin.finder.feed.model.d locald = (com.tencent.mm.plugin.finder.feed.model.d)this.tRX.getValue();
    AppMethodBeat.o(248566);
    return locald;
  }
  
  private void dcb()
  {
    AppMethodBeat.i(248575);
    if (this.uLW == null) {
      p.btv("viewCallback");
    }
    Object localObject = this.uLF;
    if (localObject == null) {
      p.btv("feedLoader");
    }
    ((BaseMegaVideoLoader)localObject).register(this.tMe);
    localObject = this.uLW;
    if (localObject == null) {
      p.btv("viewCallback");
    }
    BaseMegaVideoLoader localBaseMegaVideoLoader = this.uLF;
    if (localBaseMegaVideoLoader == null) {
      p.btv("feedLoader");
    }
    ((h.b)localObject).ab((ArrayList)localBaseMegaVideoLoader.getDataListJustForAdapter());
    AppMethodBeat.o(248575);
  }
  
  public final o<Boolean, Boolean> O(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(248579);
    Object localObject1 = this.uLW;
    if (localObject1 == null) {
      p.btv("viewCallback");
    }
    localObject1 = ((h.b)localObject1).getRecyclerView();
    Object localObject2 = ((RecyclerView)localObject1).getLayoutManager();
    if (localObject2 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
      AppMethodBeat.o(248579);
      throw ((Throwable)localObject1);
    }
    localObject2 = ((RecyclerView)localObject1).ch(((LinearLayoutManager)localObject2).ks());
    localObject1 = localObject2;
    if (!(localObject2 instanceof com.tencent.mm.view.recyclerview.h)) {
      localObject1 = null;
    }
    localObject1 = (com.tencent.mm.view.recyclerview.h)localObject1;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.view.recyclerview.h)localObject1).hgv();
      if (((localObject2 instanceof bm)) && ((((bm)localObject2).uOU) || (paramBoolean2) || (this.uMa)))
      {
        FinderVideoLayout localFinderVideoLayout = (FinderVideoLayout)((com.tencent.mm.view.recyclerview.h)localObject1).Mn(2131300776);
        if (localFinderVideoLayout != null) {}
        for (int i = localFinderVideoLayout.getCurrentPosSec();; i = 0)
        {
          a((bm)localObject2, (com.tencent.mm.view.recyclerview.h)localObject1, i, true, paramBoolean1);
          localObject1 = new o(Boolean.TRUE, Boolean.valueOf(((bm)localObject2).uOT));
          AppMethodBeat.o(248579);
          return localObject1;
        }
      }
    }
    localObject1 = Boolean.FALSE;
    localObject1 = new o(localObject1, localObject1);
    AppMethodBeat.o(248579);
    return localObject1;
  }
  
  public final o.g a(final bm parambm, final com.tencent.mm.view.recyclerview.h paramh)
  {
    AppMethodBeat.i(248585);
    p.h(parambm, "feed");
    p.h(paramh, "holder");
    parambm = (o.g)new i(this, parambm, paramh);
    AppMethodBeat.o(248585);
    return parambm;
  }
  
  public final void a(final com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(248567);
    p.h(paramb, "ev");
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h)) {
      switch (((com.tencent.mm.plugin.finder.event.base.h)paramb).type)
      {
      case 3: 
      case 4: 
      default: 
        label60:
        if ((((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 0) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 4))
        {
          localObject1 = this.uLW;
          if (localObject1 == null) {
            p.btv("viewCallback");
          }
          localObject2 = ((h.b)localObject1).getRecyclerView().cg(((com.tencent.mm.plugin.finder.event.base.h)paramb).tIy);
          localObject1 = localObject2;
          if (!(localObject2 instanceof com.tencent.mm.view.recyclerview.h)) {
            localObject1 = null;
          }
          localObject1 = (com.tencent.mm.view.recyclerview.h)localObject1;
          if (localObject1 != null)
          {
            if (!(((com.tencent.mm.view.recyclerview.h)localObject1).hgv() instanceof bn)) {
              break label478;
            }
            Log.i("FinderLongVideoTLPresenter", "[onAutoToLoadMore] configPosition=" + this.tSl + ", firstVisibleItemPosition=" + ((com.tencent.mm.plugin.finder.event.base.h)paramb).tIy + ",  isAutoLoadingMore=" + this.tSn);
            if (!this.tSn) {
              boE();
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
        AppMethodBeat.o(248567);
        return;
        Log.i("FinderLongVideoTLPresenter", "onEventHappen: set orientation portrait");
        this.uMk.setRequestedOrientation(1);
        break label60;
        if (this.tSl <= 0) {
          break label60;
        }
        localObject1 = this.uLW;
        if (localObject1 == null) {
          p.btv("viewCallback");
        }
        localObject2 = ((h.b)localObject1).getRecyclerView().getAdapter();
        localObject1 = localObject2;
        if (!(localObject2 instanceof com.tencent.mm.view.recyclerview.g)) {
          localObject1 = null;
        }
        localObject1 = (com.tencent.mm.view.recyclerview.g)localObject1;
        if (localObject1 != null) {}
        for (i = ((com.tencent.mm.view.recyclerview.g)localObject1).getItemCount() - ((com.tencent.mm.view.recyclerview.g)localObject1).RqN.size();; i = 0)
        {
          int j = i - this.tSl;
          if ((((com.tencent.mm.plugin.finder.event.base.h)paramb).tIA < j) || (i < 4)) {
            break;
          }
          Log.i("FinderLongVideoTLPresenter", "[onAutoToLoadMore] configPosition=" + this.tSl + ", lastVisibleItemPosition=" + ((com.tencent.mm.plugin.finder.event.base.h)paramb).tIA + ", preLoadBeginPosition=" + j + ", count=" + i + " isAutoLoadingMore=" + this.tSn);
          if (this.tSn) {
            break;
          }
          boE();
          break;
        }
        label478:
        localObject1 = ((com.tencent.mm.view.recyclerview.h)localObject1).Mn(2131309575);
        if (localObject1 != null) {
          if (((View)localObject1).getVisibility() == 0)
          {
            Log.i("FinderLongVideoTLPresenter", "onEventHappen: set orientation unspecified");
            this.uMk.setRequestedOrientation(-1);
          }
          else
          {
            Log.i("FinderLongVideoTLPresenter", "onEventHappen: set orientation portrait");
            this.uMk.setRequestedOrientation(1);
          }
        }
        break;
      }
    }
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new n(this));
    AppMethodBeat.o(248567);
    return;
    Object localObject1 = this.uLF;
    if (localObject1 == null) {
      p.btv("feedLoader");
    }
    Object localObject2 = ((Iterable)((BaseMegaVideoLoader)localObject1).getDataListJustForAdapter()).iterator();
    label594:
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (((bo)localObject1).lT() == ((c.a)paramb).feedId)
      {
        i = 1;
        label636:
        if (i == 0) {
          break label891;
        }
      }
    }
    for (;;)
    {
      localObject2 = (bo)localObject1;
      localObject1 = localObject2;
      if (!(localObject2 instanceof bm)) {
        localObject1 = null;
      }
      localObject1 = (bm)localObject1;
      if (localObject1 == null) {
        break;
      }
      if ((((c.a)paramb).offset >= ((Number)this.uMb.getValue()).intValue()) && (!((bm)localObject1).uOU))
      {
        Log.i("FinderLongVideoTLPresenter", "onEventHappen: add to history, offset = " + ((c.a)paramb).offset + ", feedId = " + ((c.a)paramb).feedId);
        ((bm)localObject1).uOU = true;
        com.tencent.mm.ac.d.h((kotlin.g.a.a)new m(this, paramb));
      }
      if ((((c.a)paramb).offset >= ((c.a)paramb).jcu - ((Number)this.uMc.getValue()).intValue()) && (!((bm)localObject1).uOT))
      {
        Log.i("FinderLongVideoTLPresenter", "onEventHappen: delete from history, offset = " + ((c.a)paramb).offset + ", total = " + ((c.a)paramb).jcu + ", feedId = " + ((c.a)paramb).feedId);
        ((bm)localObject1).uOT = true;
      }
      AppMethodBeat.o(248567);
      return;
      i = 0;
      break label636;
      label891:
      break label594;
      localObject1 = null;
    }
  }
  
  public final void a(BaseMegaVideoLoader paramBaseMegaVideoLoader, h.b paramb)
  {
    AppMethodBeat.i(248570);
    p.h(paramBaseMegaVideoLoader, "feedLoader");
    p.h(paramb, "callback");
    this.uLF = paramBaseMegaVideoLoader;
    paramBaseMegaVideoLoader.fetchEndCallback = ((kotlin.g.a.b)new j(this));
    a(paramb);
    AppMethodBeat.o(248570);
  }
  
  public final void a(com.tencent.mm.plugin.finder.megavideo.multitask.a parama, cnu paramcnu, boolean paramBoolean)
  {
    AppMethodBeat.i(248576);
    p.h(parama, "multiTaskHelper");
    p.h(paramcnu, "info");
    this.uLY = paramcnu;
    this.uLX = parama;
    this.uMa = paramBoolean;
    f localf = (f)this;
    com.tencent.mm.plugin.multitask.a.a locala = parama.Aak;
    paramcnu = locala;
    if (!(locala instanceof com.tencent.mm.plugin.finder.megavideo.multitask.b)) {
      paramcnu = null;
    }
    paramcnu = (com.tencent.mm.plugin.finder.megavideo.multitask.b)paramcnu;
    if (paramcnu != null) {
      paramcnu.uKk = localf;
    }
    parama.uKk = localf;
    AppMethodBeat.o(248576);
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(248568);
    p.h(paramc, "dispatcher");
    p.h(paramb, "event");
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
    {
      if ((((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 0) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 1) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 2) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 4))
      {
        AppMethodBeat.o(248568);
        return true;
      }
      AppMethodBeat.o(248568);
      return false;
    }
    if (((paramb instanceof c.a)) && ((((c.a)paramb).type == 2) || (((c.a)paramb).type == 3)))
    {
      AppMethodBeat.o(248568);
      return true;
    }
    AppMethodBeat.o(248568);
    return false;
  }
  
  public final com.tencent.mm.view.recyclerview.f dce()
  {
    AppMethodBeat.i(248569);
    com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new d(this);
    AppMethodBeat.o(248569);
    return localf;
  }
  
  public final MMFragmentActivity dcl()
  {
    AppMethodBeat.i(248586);
    Object localObject = this.uMk;
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
      AppMethodBeat.o(248586);
      throw ((Throwable)localObject);
    }
    localObject = (MMFragmentActivity)localObject;
    AppMethodBeat.o(248586);
    return localObject;
  }
  
  public final void dcp()
  {
    AppMethodBeat.i(248583);
    BaseMegaVideoLoader localBaseMegaVideoLoader = this.uLF;
    if (localBaseMegaVideoLoader == null) {
      p.btv("feedLoader");
    }
    BaseFeedLoader.requestInit$default(localBaseMegaVideoLoader, false, 1, null);
    AppMethodBeat.o(248583);
  }
  
  public final h.b dko()
  {
    AppMethodBeat.i(248573);
    h.b localb = this.uLW;
    if (localb == null) {
      p.btv("viewCallback");
    }
    AppMethodBeat.o(248573);
    return localb;
  }
  
  public final void dkp()
  {
    AppMethodBeat.i(248587);
    h.b localb = this.uLW;
    if (localb == null) {
      p.btv("viewCallback");
    }
    localb.getRecyclerView().post((Runnable)new p(this));
    AppMethodBeat.o(248587);
  }
  
  public final void nI(boolean paramBoolean)
  {
    AppMethodBeat.i(248580);
    Log.i("FinderLongVideoTLPresenter", "onConfigurationChanged: isLandScape = ".concat(String.valueOf(paramBoolean)));
    if (this.uMi == paramBoolean)
    {
      AppMethodBeat.o(248580);
      return;
    }
    this.uMi = paramBoolean;
    Object localObject1 = this.uLW;
    if (localObject1 == null) {
      p.btv("viewCallback");
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
      Object localObject3;
      if (!paramBoolean)
      {
        bool = true;
        ((FinderLinearLayoutManager)localObject1).wtl = bool;
        i = ((FinderLinearLayoutManager)localObject1).ks();
        Log.i("FinderLongVideoTLPresenter", "onConfigurationChanged: isLandScape = " + paramBoolean + ", firstIndex = " + i);
        localObject1 = this.uLW;
        if (localObject1 == null) {
          p.btv("viewCallback");
        }
        localObject2 = ((h.b)localObject1).getRecyclerView().cg(i);
        localObject1 = localObject2;
        if (!(localObject2 instanceof com.tencent.mm.view.recyclerview.h)) {
          localObject1 = null;
        }
        localObject3 = (com.tencent.mm.view.recyclerview.h)localObject1;
        if (localObject3 == null) {
          break label1635;
        }
        localObject1 = com.tencent.mm.plugin.finder.megavideo.convert.a.uKl;
        p.h(localObject3, "holder");
        if (!paramBoolean) {
          break label574;
        }
        localObject1 = ((com.tencent.mm.view.recyclerview.h)localObject3).Mn(2131304619);
        p.g(localObject1, "holder.getView<View>(R.id.menu_layout)");
        ((View)localObject1).setVisibility(8);
        localObject1 = ((com.tencent.mm.view.recyclerview.h)localObject3).Mn(2131299513);
        p.g(localObject1, "holder.getView<View>(R.id.description_tv)");
        ((View)localObject1).setVisibility(8);
        localObject1 = ((com.tencent.mm.view.recyclerview.h)localObject3).Mn(2131298980);
        p.g(localObject1, "holder.getView<View>(R.i…etely_description_layout)");
        ((View)localObject1).setVisibility(8);
        localObject1 = ((com.tencent.mm.view.recyclerview.h)localObject3).Mn(2131310329);
        p.g(localObject1, "holder.getView<View>(R.id.warn_layout)");
        ((View)localObject1).setVisibility(8);
        localObject1 = ((com.tencent.mm.view.recyclerview.h)localObject3).Mn(2131304586);
        p.g(localObject1, "holder.getView<View>(R.id.mega_video_op_layout)");
        ((View)localObject1).setVisibility(8);
        localObject1 = ((com.tencent.mm.view.recyclerview.h)localObject3).Mn(2131309575);
        p.g(localObject1, "holder.getView<View>(R.id.unfold_video_button)");
        ((View)localObject1).setVisibility(8);
        localObject1 = ((com.tencent.mm.view.recyclerview.h)localObject3).Mn(2131301629);
        p.g(localObject1, "holder.getView<View>(R.id.fold_video_button)");
        ((View)localObject1).setVisibility(0);
        localObject1 = ((com.tencent.mm.view.recyclerview.h)localObject3).Mn(2131301669);
        p.g(localObject1, "holder.getView<View>(R.id.footer_layout)");
        ((View)localObject1).setVisibility(0);
        ((LinearLayout)((com.tencent.mm.view.recyclerview.h)localObject3).Mn(2131302294)).setPadding(0, 0, 0, 0);
        if (com.tencent.mm.ui.ao.aQ(((com.tencent.mm.view.recyclerview.h)localObject3).getContext()))
        {
          localObject1 = ((com.tencent.mm.view.recyclerview.h)localObject3).Mn(2131304587);
          j = com.tencent.mm.ui.ao.aP(((com.tencent.mm.view.recyclerview.h)localObject3).getContext());
          p.g(localObject1, "it");
          ((View)localObject1).setPadding(j, ((View)localObject1).getPaddingTop(), 0, ((View)localObject1).getPaddingBottom());
        }
      }
      Object localObject5;
      for (;;)
      {
        a.a.p((com.tencent.mm.view.recyclerview.h)localObject3);
        localObject5 = (FinderMediaBanner)((com.tencent.mm.view.recyclerview.h)localObject3).Mn(2131304549);
        localObject1 = this.uLF;
        if (localObject1 == null) {
          p.btv("feedLoader");
        }
        localObject1 = ((BaseMegaVideoLoader)localObject1).getDataList().get(i);
        if (localObject1 != null) {
          break label1061;
        }
        localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.MegaVideoFeed");
        AppMethodBeat.o(248580);
        throw ((Throwable)localObject1);
        bool = false;
        break;
        label574:
        localObject1 = ((com.tencent.mm.view.recyclerview.h)localObject3).Mn(2131301669);
        p.g(localObject1, "holder.getView<View>(R.id.footer_layout)");
        if (((View)localObject1).getVisibility() == 0)
        {
          localObject1 = ((com.tencent.mm.view.recyclerview.h)localObject3).Mn(2131304619);
          p.g(localObject1, "holder.getView<View>(R.id.menu_layout)");
          ((View)localObject1).setVisibility(0);
          localObject1 = ((com.tencent.mm.view.recyclerview.h)localObject3).Mn(2131309575);
          p.g(localObject1, "holder.getView<View>(R.id.unfold_video_button)");
          ((View)localObject1).setVisibility(0);
        }
        for (;;)
        {
          localObject1 = ((com.tencent.mm.view.recyclerview.h)localObject3).Mn(2131299513);
          p.g(localObject1, "holder.getView<View>(R.id.description_tv)");
          ((View)localObject1).setVisibility(0);
          localObject1 = (TextView)((com.tencent.mm.view.recyclerview.h)localObject3).Mn(2131310332);
          p.g(localObject1, "this");
          if (!TextUtils.isEmpty(((TextView)localObject1).getText()))
          {
            localObject1 = ((com.tencent.mm.view.recyclerview.h)localObject3).Mn(2131310329);
            p.g(localObject1, "holder.getView<View>(R.id.warn_layout)");
            ((View)localObject1).setVisibility(0);
          }
          localObject1 = ((com.tencent.mm.view.recyclerview.h)localObject3).Mn(2131304586);
          p.g(localObject1, "holder.getView<View>(R.id.mega_video_op_layout)");
          ((View)localObject1).setVisibility(0);
          localObject1 = ((com.tencent.mm.view.recyclerview.h)localObject3).Mn(2131301629);
          p.g(localObject1, "holder.getView<View>(R.id.fold_video_button)");
          ((View)localObject1).setVisibility(8);
          localObject1 = (LinearLayout)((com.tencent.mm.view.recyclerview.h)localObject3).Mn(2131302294);
          localObject2 = ((com.tencent.mm.view.recyclerview.h)localObject3).getContext();
          p.g(localObject2, "holder.context");
          ((LinearLayout)localObject1).setPadding(0, ((Context)localObject2).getResources().getDimensionPixelOffset(2131165307), 0, 0);
          localObject1 = ((com.tencent.mm.view.recyclerview.h)localObject3).Mn(2131304587);
          p.g(localObject1, "it");
          ((View)localObject1).setPadding(0, ((View)localObject1).getPaddingTop(), 0, ((View)localObject1).getPaddingBottom());
          localObject1 = ((com.tencent.mm.view.recyclerview.h)localObject3).getContext();
          if (localObject1 != null) {
            break;
          }
          localObject1 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(248580);
          throw ((Throwable)localObject1);
          localObject1 = ((com.tencent.mm.view.recyclerview.h)localObject3).Mn(2131304619);
          p.g(localObject1, "holder.getView<View>(R.id.menu_layout)");
          ((View)localObject1).setVisibility(8);
          localObject1 = ((com.tencent.mm.view.recyclerview.h)localObject3).Mn(2131309575);
          p.g(localObject1, "holder.getView<View>(R.id.unfold_video_button)");
          ((View)localObject1).setVisibility(8);
        }
        localObject1 = ((Activity)localObject1).getWindow();
        p.g(localObject1, "(holder.context as Activity).window");
        localObject1 = ((Window)localObject1).getDecorView();
        p.g(localObject1, "(holder.context as Activity).window.decorView");
        localObject2 = ((com.tencent.mm.view.recyclerview.h)localObject3).getContext();
        if (localObject2 == null)
        {
          localObject1 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(248580);
          throw ((Throwable)localObject1);
        }
        localObject2 = ((Activity)localObject2).getWindow();
        p.g(localObject2, "(holder.context as Activity).window");
        localObject2 = ((Window)localObject2).getDecorView();
        p.g(localObject2, "(holder.context as Activity).window.decorView");
        ((View)localObject1).setSystemUiVisibility(((View)localObject2).getSystemUiVisibility() & 0xFFFFF7F9);
      }
      label1061:
      Object localObject4 = (bm)localObject1;
      localObject1 = (cjl)kotlin.a.j.kt((List)((bm)localObject4).dkV());
      if (localObject1 == null)
      {
        Log.e("FinderLongVideoTLPresenter", "onConfigurationChanged: mega video media is null, id = " + ((bm)localObject4).lT());
        AppMethodBeat.o(248580);
        return;
      }
      localObject2 = y.vXH;
      localObject1 = y.a((Activity)this.uMk, ((cjl)localObject1).width, ((cjl)localObject1).height);
      int j = ((Number)((r)localObject1).second).intValue();
      int k = ((Number)((r)localObject1).SWY).intValue();
      Log.i("FinderLongVideoTLPresenter", "onConfigurationChanged: resize width = " + j + ", height = " + k + ", firstIndex = " + i);
      localObject2 = ((FinderMediaBanner)localObject5).getPagerView().getLayoutParams();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ViewGroup.LayoutParams(j, k);
      }
      ((ViewGroup.LayoutParams)localObject1).width = j;
      ((ViewGroup.LayoutParams)localObject1).height = k;
      localObject1 = (FinderVideoLayout)((com.tencent.mm.view.recyclerview.h)localObject3).Mn(2131300776);
      label1487:
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
          ((View)localObject1).getLayoutParams().width = j;
          ((View)localObject1).getLayoutParams().height = k;
          if ((localObject1 instanceof FinderThumbPlayerProxy))
          {
            localObject1 = (FinderThumbPlayerProxy)localObject1;
            localObject2 = ((FinderThumbPlayerProxy)localObject1).wdE;
            if (localObject2 == null) {
              p.btv("textureView");
            }
            ((MMThumbPlayerTextureView)localObject2).getLayoutParams().width = j;
            localObject2 = ((FinderThumbPlayerProxy)localObject1).wdE;
            if (localObject2 == null) {
              p.btv("textureView");
            }
            ((MMThumbPlayerTextureView)localObject2).getLayoutParams().height = k;
            localObject2 = ((FinderThumbPlayerProxy)localObject1).wdE;
            if (localObject2 == null) {
              p.btv("textureView");
            }
            ((MMThumbPlayerTextureView)localObject2).jk(j, k);
            localObject1 = ((FinderThumbPlayerProxy)localObject1).wdE;
            if (localObject1 == null) {
              p.btv("textureView");
            }
            ((MMThumbPlayerTextureView)localObject1).requestLayout();
          }
        }
        ((FinderMediaBanner)localObject5).requestLayout();
        localObject1 = FinderReporterUIC.wzC;
        localObject1 = FinderReporterUIC.a.fH((Context)this.uMk);
        if (localObject1 == null) {
          break label1624;
        }
        localObject1 = ((FinderReporterUIC)localObject1).dIx();
        localObject2 = af.viA;
        localObject5 = com.tencent.mm.ac.d.zs(((bm)localObject4).dkW());
        str = com.tencent.mm.ac.d.zs(((bm)localObject4).lT());
        if (!paramBoolean) {
          break label1630;
        }
      }
      label1624:
      label1630:
      for (int i = 1;; i = 2)
      {
        if (localObject1 != null)
        {
          localObject3 = ((bbn)localObject1).sessionId;
          localObject2 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject2 = "";
        }
        if (localObject1 != null)
        {
          localObject4 = ((bbn)localObject1).sGQ;
          localObject3 = localObject4;
          if (localObject4 != null) {}
        }
        else
        {
          localObject3 = "";
        }
        if (localObject1 != null)
        {
          localObject4 = ((bbn)localObject1).sGE;
          localObject1 = localObject4;
          if (localObject4 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        af.a((String)localObject5, str, 2, i, (String)localObject2, (String)localObject3, (String)localObject1);
        AppMethodBeat.o(248580);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label1487;
      }
      label1635:
      AppMethodBeat.o(248580);
      return;
    }
    AppMethodBeat.o(248580);
  }
  
  public final boolean nJ(boolean paramBoolean)
  {
    AppMethodBeat.i(248584);
    Object localObject = O(true, false);
    boolean bool1 = ((Boolean)((o)localObject).first).booleanValue();
    boolean bool2 = ((Boolean)((o)localObject).second).booleanValue();
    int i;
    if ((bool1) || (this.uMa))
    {
      localObject = this.uLX;
      if (localObject == null) {
        p.btv("multiTaskHelper");
      }
      if (paramBoolean) {
        i = 1;
      }
    }
    for (paramBoolean = ((com.tencent.mm.plugin.finder.megavideo.multitask.a)localObject).O(i, bool2);; paramBoolean = false)
    {
      if ((paramBoolean) && (this.uMa))
      {
        AppMethodBeat.o(248584);
        return true;
        i = 2;
        break;
      }
      AppMethodBeat.o(248584);
      return false;
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(248574);
    Object localObject = com.tencent.mm.ui.component.a.PRN;
    localObject = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b(this.uMk).get(FinderReporterUIC.class)).MA(-1);
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this);
      ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)dcW());
    }
    localObject = this.uLF;
    if (localObject == null) {
      p.btv("feedLoader");
    }
    if (this.uLW == null) {
      p.btv("viewCallback");
    }
    ((BaseMegaVideoLoader)localObject).unregister(this.tMe);
    dcW().onDetach();
    AppMethodBeat.o(248574);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(248581);
    BaseMegaVideoLoader localBaseMegaVideoLoader = this.uLF;
    if (localBaseMegaVideoLoader == null) {
      p.btv("feedLoader");
    }
    localBaseMegaVideoLoader.requestRefresh();
    AppMethodBeat.o(248581);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    public static final b uMo;
    
    static
    {
      AppMethodBeat.i(248542);
      uMo = new b();
      AppMethodBeat.o(248542);
    }
    
    b()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(f paramf)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class d
    implements com.tencent.mm.view.recyclerview.f
  {
    public final com.tencent.mm.view.recyclerview.e<?> EC(int paramInt)
    {
      AppMethodBeat.i(248544);
      if (paramInt == bn.class.hashCode())
      {
        locale = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.megavideo.convert.c(this.uMn);
        AppMethodBeat.o(248544);
        return locale;
      }
      com.tencent.mm.view.recyclerview.e locale = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.megavideo.convert.a(f.b(this.uMn), this.uMn);
      AppMethodBeat.o(248544);
      return locale;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.feed.model.d>
  {
    e(f paramf)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    public static final f uMp;
    
    static
    {
      AppMethodBeat.i(248547);
      uMp = new f();
      AppMethodBeat.o(248547);
    }
    
    f()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  public static final class g
    implements o.f
  {
    public g(f paramf, bm parambm) {}
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(248548);
      Object localObject1 = f.e(this.uMn).getString(2131755985);
      p.g(localObject1, "context.getString(R.string.app_share_to_weixin)");
      Object localObject2 = f.e(this.uMn).getString(2131760572);
      p.g(localObject2, "context.getString(R.string.finder_share_timeline)");
      Object localObject3 = y.vXH;
      boolean bool2;
      if ((!y.b(this.uMq)) || (!this.uMq.isPrivate()))
      {
        localObject3 = y.vXH;
        if (y.b(this.uMq.tuP)) {}
      }
      else
      {
        localObject1 = y.vXH;
        localObject1 = y.dP("FinderSafeSelfSeeForward", 2131760540);
        localObject2 = y.vXH;
        localObject2 = y.dP("FinderSafeSelfSeeShare", 2131760541);
        bool2 = true;
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        int i;
        if (this.uMq.dkY())
        {
          localObject1 = y.vXH;
          localObject2 = y.dP("FinderSafeSelfSeeForward", 2131760540);
          localObject1 = y.vXH;
          localObject3 = y.dP("FinderSafeSelfSeeShare", 2131760541);
          localObject1 = this.uMq.tuP;
          if (localObject1 != null)
          {
            localObject1 = ((cng)localObject1).MtJ;
            if (localObject1 != null)
            {
              localObject1 = n.a((CharSequence)localObject1, new String[] { "#" });
              if (localObject1 == null) {
                break label348;
              }
              if (((List)localObject1).size() <= 2) {
                break label337;
              }
              i = 1;
              label224:
              if (i == 0) {
                break label342;
              }
              label228:
              if (localObject1 == null) {
                break label348;
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
          paramm.a(f.f(this.uMn), (CharSequence)localObject1, 2131690251, f.e(this.uMn).getResources().getColor(2131099710), bool1);
          paramm.a(f.g(this.uMn), (CharSequence)localObject2, 2131689830, 0, bool2);
          AppMethodBeat.o(248548);
          return;
          localObject1 = null;
          break;
          label337:
          i = 0;
          break label224;
          label342:
          localObject1 = null;
          break label228;
          label348:
          bool2 = true;
          bool1 = true;
          localObject1 = localObject2;
          localObject2 = localObject3;
        }
        bool2 = false;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  public static final class h
    implements o.f
  {
    public h(f paramf, bm parambm) {}
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(248549);
      paramm.b(f.h(this.uMn), (CharSequence)f.e(this.uMn).getString(2131758719), 2131690846);
      Object localObject = y.vXH;
      if (y.b(this.uMq))
      {
        paramm.aS(f.i(this.uMn), 2131755778, 2131690780);
        localObject = com.tencent.mm.plugin.finder.utils.q.vWb;
        p.g(paramm, "menu");
        localObject = (Context)f.e(this.uMn);
        kotlin.a.j.kt((List)this.uMq.dkV());
        com.tencent.mm.plugin.finder.utils.q.a(paramm, (Context)localObject, f.j(this.uMn), f.k(this.uMn), this.uMq.isPrivate(), this.uMq.dkZ());
        AppMethodBeat.o(248549);
        return;
      }
      paramm.b(f.l(this.uMn), (CharSequence)f.e(this.uMn).getString(2131763159), 2131690898);
      AppMethodBeat.o(248549);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "index", "", "onMMMenuItemSelected"})
  static final class i
    implements o.g
  {
    i(f paramf, bm parambm, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      int i = 0;
      AppMethodBeat.i(248554);
      p.h(paramMenuItem, "menuItem");
      Log.i("FinderLongVideoTLPresenter", "[getMoreMenuItemSelectedListener] feed " + parambm + ' ' + paramInt + " menuItem:" + paramMenuItem.getItemId());
      paramInt = paramMenuItem.getItemId();
      Object localObject;
      if (paramInt == f.f(this.uMn))
      {
        paramMenuItem = s.vWt;
        localObject = f.e(this.uMn);
        FinderItem.a locala = FinderItem.Companion;
        s.a.a(paramMenuItem, (AppCompatActivity)localObject, FinderItem.a.a(parambm.getFeedObject(), 32768), 3, 4);
        AppMethodBeat.o(248554);
        return;
      }
      if (paramInt == f.g(this.uMn))
      {
        paramMenuItem = s.vWt;
        paramMenuItem = f.e(this.uMn);
        localObject = FinderItem.Companion;
        s.a.a(paramMenuItem, (BaseFinderFeed)new ad(FinderItem.a.a(parambm.getFeedObject(), 32768)), 2, 0, 20);
        AppMethodBeat.o(248554);
        return;
      }
      if (paramInt == f.i(this.uMn))
      {
        com.tencent.mm.ui.base.h.a((Context)f.e(this.uMn), 2131759663, 0, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
        {
          public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(248552);
            Object localObject2 = z.aUg();
            p.g(localObject2, "ConfigStorageLogic.getMyFinderUsername()");
            Object localObject1 = this.uMr.uMq.tuP;
            paramAnonymousDialogInterface = (DialogInterface)localObject1;
            if (localObject1 == null) {
              paramAnonymousDialogInterface = new cng();
            }
            paramAnonymousDialogInterface = new av((String)localObject2, paramAnonymousDialogInterface);
            localObject1 = f.m(this.uMr.uMn);
            if (localObject1 != null) {
              ((Dialog)localObject1).show();
            }
            for (;;)
            {
              com.tencent.mm.kernel.g.azz().a(paramAnonymousDialogInterface.getType(), (i)new i()
              {
                public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.ak.q paramAnonymous2q)
                {
                  AppMethodBeat.i(248551);
                  if (((paramAnonymous2q instanceof av)) && (((av)paramAnonymous2q).hFK == paramAnonymousDialogInterface.hFK))
                  {
                    com.tencent.mm.kernel.g.azz().b(paramAnonymousDialogInterface.getType(), (i)this);
                    if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0)) {
                      u.makeText((Context)f.e(this.uMt.uMr.uMn), 2131760456, 0).show();
                    }
                  }
                  paramAnonymous2String = f.m(this.uMt.uMr.uMn);
                  if (paramAnonymous2String != null)
                  {
                    paramAnonymous2String.dismiss();
                    AppMethodBeat.o(248551);
                    return;
                  }
                  AppMethodBeat.o(248551);
                }
              });
              com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)paramAnonymousDialogInterface);
              AppMethodBeat.o(248552);
              return;
              localObject1 = this.uMr.uMn;
              localObject2 = (Context)f.e((f)localObject1);
              f.e((f)localObject1).getString(2131755998);
              f.a((f)localObject1, (Dialog)com.tencent.mm.ui.base.h.a((Context)localObject2, f.e((f)localObject1).getString(2131756029), false, (DialogInterface.OnCancelListener)a.uMs));
            }
          }
          
          @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
          static final class a
            implements DialogInterface.OnCancelListener
          {
            public static final a uMs;
            
            static
            {
              AppMethodBeat.i(248550);
              uMs = new a();
              AppMethodBeat.o(248550);
            }
            
            public final void onCancel(DialogInterface paramDialogInterface) {}
          }
        }, null);
        AppMethodBeat.o(248554);
        return;
      }
      if (paramInt == f.j(this.uMn))
      {
        paramMenuItem = com.tencent.mm.plugin.finder.storage.data.e.vFX;
        e.a.j(parambm.getFeedObject());
        paramMenuItem = com.tencent.mm.plugin.finder.utils.q.vWb;
        com.tencent.mm.plugin.finder.utils.q.a((Context)f.e(this.uMn), parambm.lT(), parambm.dkW(), parambm.dkX(), false);
        AppMethodBeat.o(248554);
        return;
      }
      if (paramInt == f.k(this.uMn))
      {
        paramMenuItem = com.tencent.mm.plugin.finder.storage.data.e.vFX;
        e.a.j(parambm.getFeedObject());
        com.tencent.mm.ui.base.h.a((Context)f.e(this.uMn), 2131760546, 0, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(248553);
            paramAnonymousDialogInterface = com.tencent.mm.plugin.finder.utils.q.vWb;
            com.tencent.mm.plugin.finder.utils.q.a((Context)f.e(this.uMr.uMn), this.uMr.uMq.lT(), this.uMr.uMq.dkW(), this.uMr.uMq.dkX(), true);
            AppMethodBeat.o(248553);
          }
        }, null);
        AppMethodBeat.o(248554);
        return;
      }
      if (paramInt == f.l(this.uMn))
      {
        paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
        com.tencent.mm.plugin.finder.feed.logic.a.a((Context)f.e(this.uMn), parambm.lT(), 0L, 0, 12);
        AppMethodBeat.o(248554);
        return;
      }
      if (paramInt == f.h(this.uMn))
      {
        paramMenuItem = (FinderVideoLayout)paramh.Mn(2131300776);
        paramInt = i;
        if (paramMenuItem != null) {
          paramInt = paramMenuItem.getCurrentPosSec();
        }
        f.a(this.uMn, parambm, paramh, paramInt);
      }
      AppMethodBeat.o(248554);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.b<IResponse<bo>, x>
  {
    j(f paramf)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter$onAttach$2", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
  public static final class k
    implements k.b
  {
    public final RecyclerView dch()
    {
      AppMethodBeat.i(248558);
      RecyclerView localRecyclerView = f.a(this.uMn).getRecyclerView();
      AppMethodBeat.o(248558);
      return localRecyclerView;
    }
    
    public final DataBuffer<bo> dci()
    {
      AppMethodBeat.i(248559);
      DataBuffer localDataBuffer = f.d(this.uMn).getDataListJustForAdapter();
      AppMethodBeat.o(248559);
      return localDataBuffer;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Integer, bo>
  {
    l(f paramf)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter$onEventHappen$3$1"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    m(f paramf, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class n
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    n(f paramf)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/graphics/Paint;", "invoke"})
  static final class o
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Paint>
  {
    public static final o uMx;
    
    static
    {
      AppMethodBeat.i(248564);
      uMx = new o();
      AppMethodBeat.o(248564);
    }
    
    o()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class p
    implements Runnable
  {
    p(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(248565);
      FinderVideoAutoPlayManager localFinderVideoAutoPlayManager = f.b(this.uMn).weS;
      if (localFinderVideoAutoPlayManager != null)
      {
        localFinderVideoAutoPlayManager.awI("FinderLongVideoTLPresenter");
        AppMethodBeat.o(248565);
        return;
      }
      AppMethodBeat.o(248565);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.f
 * JD-Core Version:    0.7.0.1
 */