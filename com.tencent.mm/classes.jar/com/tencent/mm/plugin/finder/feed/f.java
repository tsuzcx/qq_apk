package com.tencent.mm.plugin.finder.feed;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.c;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.im;
import com.tencent.mm.autogen.a.it;
import com.tencent.mm.autogen.a.it.a;
import com.tencent.mm.autogen.mmdata.rpt.ax;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.feed.model.h.a;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.an;
import com.tencent.mm.plugin.finder.model.t;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.plugin.finder.report.ae;
import com.tencent.mm.plugin.finder.report.m.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.au;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer;
import com.tencent.mm.plugin.finder.view.FinderCommentEditText;
import com.tencent.mm.plugin.finder.view.FinderCommentFooter;
import com.tencent.mm.plugin.finder.view.FinderCommentFooter.b;
import com.tencent.mm.plugin.finder.view.b.d;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.atd;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.protocal.protobuf.brh;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.i.d;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.finder.view.ah;>;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.g.b.ah.d;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "authorMentioned", "", "getAuthorMentioned", "()Z", "setAuthorMentioned", "(Z)V", "blinkDuration", "", "blinkRefComment", "canPreload", "getCanPreload", "setCanPreload", "commentChangeEventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderCommentChangeEvent;", "getCommentChangeEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "commentClose", "getCommentClose", "setCommentClose", "commentCount", "", "getCommentCount", "()I", "commentDataObserver", "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentDataObserver$1", "Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentDataObserver$1;", "commentErrorListener", "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentErrorListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentErrorListener$1;", "getContext", "()Landroid/content/Context;", "dataLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentLoader;", "diffDataChangeHelper", "Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$DiffDataChangeHelper;", "value", "downContinue", "setDownContinue", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;)V", "enterTimeMs", "getEnterTimeMs", "()J", "setEnterTimeMs", "(J)V", "exposeScene", "getExposeScene", "setExposeScene", "(I)V", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "hasExpandComment", "getHasExpandComment", "setHasExpandComment", "hitCache", "isDetached", "setDetached", "isOnlyShowDesc", "isSingleMode", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "oldVersion", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "refCommentId", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "safeMode", "getSafeMode", "setSafeMode", "scene", "getScene", "setScene", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "getTaskExecutor", "()Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "setTaskExecutor", "(Lcom/tencent/mm/loader/loader/SingleTaskExecutor;)V", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "upContinue", "setUpContinue", "useCache", "viewCallback", "Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;)V", "calculateCommentCount", "canExpand", "comment", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "down", "checkDownContinue", "", "checkUpContinue", "deleteComment", "item", "expandLevel2Comments", "rootComment", "expandTopLevel2Comment", "", "respList", "expandWhenRefToLevel2Comment", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getCommentScene", "getCurrentFeed", "getEditText", "Lcom/tencent/mm/plugin/finder/view/FinderCommentEditText;", "getEditTextAvatar", "Landroid/widget/ImageView;", "getFirstFriendPos", "getFirstOtherPos", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getRootComment", "rootId", "getRootCommentIndex", "getUserScene", "insertLevel2CommentsAndNotify", "level2Comments", "", "isCommentClose", "isSafeMode", "isWxScene", "keep", "p0", "loadMoreData", "loadMoreLevel2Comments", "mergeLocalLevel2Comments", "localLevel2Comments", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "onAttach", "builder", "displayScene", "replyCommentObj", "oldVer", "callback", "onClickComment", "view", "Landroid/view/View;", "onClickCommentDelete", "onClickMore", "onClickResendComment", "position", "onDetach", "onExpandClick", "onItemClick", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "holder", "onItemLongClick", "onLikeComment", "onModeChange", "from", "to", "onRecoverRecyclerViewTrans", "onReply", "sceneForReply", "mentionContactList", "Lcom/tencent/mm/plugin/finder/view/MentionContact;", "onScrollIdle", "lastVisiblePosition", "preloadNextPage", "refreshData", "setCommentCountView", "transToDiscoverComment", "Companion", "DiffDataChangeHelper", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements CommentDrawerContract.NPresenter, FinderCommentFooter.b, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>, i.c<com.tencent.mm.view.recyclerview.j>, i.d<com.tencent.mm.view.recyclerview.j>
{
  public static final a AUg;
  private long AAW;
  private com.tencent.mm.loader.f.h ADY;
  private boolean AHL;
  private boolean AHQ;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> ATq;
  public int AUh;
  final com.tencent.mm.plugin.finder.feed.model.h AUi;
  private FinderItem AUj;
  public com.tencent.mm.plugin.finder.view.builder.b AUk;
  private b AUl;
  private CommentDrawerContract.CloseDrawerCallback AUm;
  private boolean AUn;
  private boolean AUo;
  private boolean AUp;
  private boolean AUq;
  private long AUr;
  boolean AUs;
  private boolean AUt;
  boolean AUu;
  private FinderCommentDrawer AUv;
  private FinderCommentDrawerPresenter.commentErrorListener.1 AUw;
  private final IListener<im> AUx;
  private final c AUy;
  private volatile boolean bRv;
  final Context context;
  private boolean igs;
  private volatile com.tencent.mm.bx.b lastBuffer;
  private boolean plm;
  public boolean safeMode;
  int scene;
  Dialog tipDialog;
  private long zIz;
  
  static
  {
    AppMethodBeat.i(165695);
    AUg = new a((byte)0);
    AppMethodBeat.o(165695);
  }
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(362850);
    this.context = paramContext;
    this.AUh = 58;
    this.AUi = new com.tencent.mm.plugin.finder.feed.model.h();
    this.ATq = new CopyOnWriteArraySet();
    this.scene = 2;
    this.AUp = true;
    this.AHL = true;
    this.igs = true;
    this.AUr = 1000L;
    this.bRv = true;
    this.AUw = new FinderCommentDrawerPresenter.commentErrorListener.1(this, com.tencent.mm.app.f.hfK);
    this.AUx = ((IListener)new FinderCommentDrawerPresenter.commentChangeEventListener.1(this, com.tencent.mm.app.f.hfK));
    this.AUy = new c(this);
    AppMethodBeat.o(362850);
  }
  
  private final void A(int paramInt, List<com.tencent.mm.plugin.finder.view.ah> paramList)
  {
    AppMethodBeat.i(362919);
    Object localObject1 = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    if (com.tencent.mm.plugin.findersdk.d.a.aDj("comment"))
    {
      AppMethodBeat.o(362919);
      return;
    }
    Log.i("Finder.DrawerPresenter", s.X("onReply mentionList = ", paramList));
    localObject1 = as.GSQ;
    localObject1 = as.a.hu(this.context);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = null;
      localObject1 = getEditText();
      if (localObject1 != null) {
        break label165;
      }
      localObject1 = null;
      label76:
      localObject3 = (CharSequence)localObject1;
      if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
        break label175;
      }
      i = 1;
      label100:
      if (i != 0) {
        break label1724;
      }
      if (this.AUj == null) {
        s.bIx("feedObj");
      }
      localObject3 = n.bq((CharSequence)localObject1);
      if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
        break label180;
      }
    }
    label165:
    label175:
    label180:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label185;
      }
      AppMethodBeat.o(362919);
      return;
      localObject2 = ((as)localObject1).fou();
      break;
      localObject1 = ((FinderCommentEditText)localObject1).getText();
      break label76;
      i = 0;
      break label100;
    }
    label185:
    Object localObject3 = av.GiL;
    String str1 = av.aBP(localObject1.toString());
    Object localObject4 = getEditText();
    if (localObject4 == null) {
      localObject3 = null;
    }
    Object localObject5;
    while (localObject3 != null)
    {
      localObject1 = ((Iterable)localObject3).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject4 = (String)((Iterator)localObject1).next();
          localObject5 = av.GiL;
          av.aBP((String)localObject4);
          continue;
          localObject3 = this.AUj;
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            s.bIx("feedObj");
            localObject1 = null;
          }
          localObject3 = ((FinderCommentEditText)localObject4).ra(((FinderItem)localObject1).getId());
          break;
        }
      }
      localObject1 = kotlin.ah.aiuX;
    }
    localObject1 = getEditText();
    long l1;
    Object localObject6;
    long l2;
    Object localObject7;
    Object localObject8;
    Object localObject9;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label1176;
      }
      localObject1 = com.tencent.mm.plugin.finder.upload.b.Gbu;
      localObject5 = com.tencent.mm.plugin.finder.upload.b.fdT();
      l1 = cn.bDv();
      localObject4 = this.AUj;
      localObject1 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("feedObj");
        localObject1 = null;
      }
      localObject6 = ((FinderItem)localObject1).getUserName();
      localObject4 = this.AUj;
      localObject1 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("feedObj");
        localObject1 = null;
      }
      l2 = ((FinderItem)localObject1).getId();
      localObject4 = this.AUj;
      localObject1 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("feedObj");
        localObject1 = null;
      }
      localObject7 = ((FinderItem)localObject1).getObjectNonceId();
      localObject4 = this.AUj;
      localObject1 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("feedObj");
        localObject1 = null;
      }
      localObject1 = ((FinderItem)localObject1).getUserName();
      localObject4 = av.GiL;
      localObject4 = av.Ue(paramInt);
      localObject8 = av.GiL;
      localObject8 = av.Ud(paramInt);
      localObject9 = this.AUv;
      if (localObject9 != null) {
        break label1167;
      }
      i = 0;
      label504:
      s.u(localObject6, "feedUsername");
      s.u(localObject7, "objectNonceId");
      s.u(localObject1, "replyUsername");
      s.u(localObject4, "username");
      s.u(localObject8, "nickname");
      s.u(paramList, "mentionList");
      localObject1 = com.tencent.mm.plugin.finder.upload.b.a((com.tencent.mm.plugin.finder.upload.b)localObject5, l1, (String)localObject6, l2, (String)localObject7, str1, (String)localObject1, "", (String)localObject4, (String)localObject8, paramInt, (bui)localObject2, i, paramList, (LinkedList)localObject3);
      if ((this.context instanceof MMFragmentActivity))
      {
        paramList = com.tencent.mm.ui.component.k.aeZF;
        localObject3 = ((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.context).q(as.class)).fou();
        paramList = com.tencent.mm.plugin.finder.report.z.FrZ;
        localObject2 = this.AUj;
        paramList = (List<com.tencent.mm.plugin.finder.view.ah>)localObject2;
        if (localObject2 == null)
        {
          s.bIx("feedObj");
          paramList = null;
        }
        com.tencent.mm.plugin.finder.report.z.a((bui)localObject3, paramList.getId(), 2, 0, 0, "", paramInt);
      }
      paramList = this.AUk;
      if (paramList != null)
      {
        paramList = paramList.getRlLayout();
        if (paramList != null)
        {
          paramList = paramList.getRecyclerView();
          if (paramList != null)
          {
            localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(paramList, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter", "onReply", "(ILjava/util/List;)V", "Undefined", "scrollToPosition", "(I)V");
            paramList.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(paramList, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter", "onReply", "(ILjava/util/List;)V", "Undefined", "scrollToPosition", "(I)V");
            paramList = kotlin.ah.aiuX;
          }
        }
      }
      paramList = this.AUk;
      if (paramList != null)
      {
        paramList = paramList.getRlLayout();
        if (paramList != null)
        {
          paramList.ci((kotlin.g.a.a)f.p.AUM);
          paramList = kotlin.ah.aiuX;
        }
      }
      paramList = (List<com.tencent.mm.plugin.finder.view.ah>)localObject1;
      localObject1 = this.AUk;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).flQ();
        if (localObject1 != null)
        {
          if (((FinderCommentFooter)localObject1).FZu != 1) {
            break label1654;
          }
          ((FinderCommentFooter)localObject1).ur(true);
          label846:
          localObject1 = kotlin.ah.aiuX;
        }
      }
      localObject2 = getEditText();
      localObject1 = paramList;
      if (localObject2 != null) {
        ((FinderCommentEditText)localObject2).setText(null);
      }
    }
    label1167:
    label1176:
    label1717:
    label1724:
    for (localObject1 = paramList;; localObject1 = null)
    {
      paramList = com.tencent.mm.plugin.finder.utils.ak.GhA;
      com.tencent.mm.plugin.finder.utils.ak.ffl();
      if (this.plm)
      {
        paramList = this.AUk;
        if (paramList != null)
        {
          paramList = paramList.flR();
          if (paramList != null)
          {
            paramList.fdh();
            paramList = kotlin.ah.aiuX;
          }
        }
        paramList = this.AUv;
        if ((paramList != null) && (paramList.getReason() == 1)) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label1717;
          }
          paramList = com.tencent.mm.plugin.finder.feed.model.h.Bfb;
          localObject2 = this.AUj;
          paramList = (List<com.tencent.mm.plugin.finder.view.ah>)localObject2;
          if (localObject2 == null)
          {
            s.bIx("feedObj");
            paramList = null;
          }
          l1 = paramList.getId();
          com.tencent.mm.plugin.finder.storage.data.f.FMT.oz(l1);
          if (localObject1 == null) {
            break label1717;
          }
          paramList = com.tencent.mm.plugin.finder.storage.logic.a.FNx;
          localObject2 = com.tencent.mm.plugin.finder.storage.logic.a.e((au)localObject1);
          ((FinderCommentInfo)localObject2).displayid = 9223372036854775807L;
          ((FinderCommentInfo)localObject2).commentId = 0L;
          localObject1 = this.AUj;
          paramList = (List<com.tencent.mm.plugin.finder.view.ah>)localObject1;
          if (localObject1 == null)
          {
            s.bIx("feedObj");
            paramList = null;
          }
          paramList.getCommentList().add(0, localObject2);
          localObject2 = new it();
          localObject3 = ((it)localObject2).hKk;
          localObject1 = this.AUj;
          paramList = (List<com.tencent.mm.plugin.finder.view.ah>)localObject1;
          if (localObject1 == null)
          {
            s.bIx("feedObj");
            paramList = null;
          }
          ((it.a)localObject3).feedId = paramList.field_id;
          localObject3 = ((it)localObject2).hKk;
          localObject4 = new brh();
          localObject1 = this.AUj;
          paramList = (List<com.tencent.mm.plugin.finder.view.ah>)localObject1;
          if (localObject1 == null)
          {
            s.bIx("feedObj");
            paramList = null;
          }
          ((brh)localObject4).commentList = paramList.getCommentList();
          paramList = kotlin.ah.aiuX;
          ((it.a)localObject3).hKl = ((brh)localObject4);
          ((it)localObject2).publish();
          AppMethodBeat.o(362919);
          return;
          localObject1 = ((FinderCommentEditText)localObject1).getTag();
          break;
          i = ((FinderCommentDrawer)localObject9).getReason();
          break label504;
          localObject1 = getEditText();
          if (localObject1 == null) {}
          for (localObject1 = null; localObject1 == null; localObject1 = ((FinderCommentEditText)localObject1).getTag())
          {
            paramList = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.storage.LocalFinderCommentObject");
            AppMethodBeat.o(362919);
            throw paramList;
          }
          localObject6 = (au)localObject1;
          if (((au)localObject6).field_actionInfo.ABa == 0L) {
            localObject1 = ((au)localObject6).eZI();
          }
          while (localObject1 == null)
          {
            AppMethodBeat.o(362919);
            return;
            localObject1 = nq(((au)localObject6).field_actionInfo.ABa);
            if (localObject1 == null)
            {
              localObject1 = null;
            }
            else
            {
              localObject1 = ((t)localObject1).ECu;
              if (localObject1 == null) {
                localObject1 = null;
              } else {
                localObject1 = ((au)localObject1).eZI();
              }
            }
          }
          ((FinderCommentInfo)localObject1).expandCommentCount += 1;
          localObject4 = com.tencent.mm.plugin.finder.upload.b.Gbu;
          localObject7 = com.tencent.mm.plugin.finder.upload.b.fdT();
          l1 = cn.bDv();
          localObject5 = this.AUj;
          localObject4 = localObject5;
          if (localObject5 == null)
          {
            s.bIx("feedObj");
            localObject4 = null;
          }
          localObject8 = ((FinderItem)localObject4).getUserName();
          localObject5 = this.AUj;
          localObject4 = localObject5;
          if (localObject5 == null)
          {
            s.bIx("feedObj");
            localObject4 = null;
          }
          l2 = ((FinderItem)localObject4).getId();
          localObject5 = this.AUj;
          localObject4 = localObject5;
          if (localObject5 == null)
          {
            s.bIx("feedObj");
            localObject4 = null;
          }
          localObject4 = ((FinderItem)localObject4).getObjectNonceId();
          localObject5 = ((au)localObject6).getUsername();
          localObject9 = ((au)localObject6).getNickname();
          long l3 = ((au)localObject6).eZI().commentId;
          String str2 = ((au)localObject6).getContent();
          Object localObject10 = av.GiL;
          localObject10 = av.Ue(paramInt);
          Object localObject11 = av.GiL;
          localObject11 = av.Ud(paramInt);
          boolean bool = ((au)localObject6).eZQ();
          FinderCommentDrawer localFinderCommentDrawer = this.AUv;
          if (localFinderCommentDrawer == null) {}
          for (i = 0;; i = localFinderCommentDrawer.getReason())
          {
            localObject1 = ((com.tencent.mm.plugin.finder.upload.b)localObject7).a(l1, (String)localObject8, l2, (String)localObject4, str1, (String)localObject5, (String)localObject9, Long.valueOf(l3), str2, (String)localObject10, (String)localObject11, paramInt, bool, (FinderCommentInfo)localObject1, (bui)localObject2, i, paramList, (LinkedList)localObject3);
            if ((this.context instanceof MMFragmentActivity))
            {
              paramList = com.tencent.mm.ui.component.k.aeZF;
              localObject3 = ((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.context).q(as.class)).fou();
              paramList = com.tencent.mm.plugin.finder.report.z.FrZ;
              localObject2 = this.AUj;
              paramList = (List<com.tencent.mm.plugin.finder.view.ah>)localObject2;
              if (localObject2 == null)
              {
                s.bIx("feedObj");
                paramList = null;
              }
              com.tencent.mm.plugin.finder.report.z.a((bui)localObject3, paramList.getId(), 2, 0, 0, ((au)localObject6).getUsername(), paramInt);
            }
            this.AUu = true;
            paramList = (List<com.tencent.mm.plugin.finder.view.ah>)localObject1;
            break;
          }
          label1654:
          if (((FinderCommentFooter)localObject1).FZu != 2) {
            break label846;
          }
          ((FinderCommentFooter)localObject1).dP(false);
          break label846;
        }
      }
      paramList = this.AUk;
      if (paramList != null)
      {
        paramList.fdw().setVisibility(8);
        paramList.fdx().setVisibility(8);
        paramList.getLoadingLayout().setVisibility(8);
        paramList = kotlin.ah.aiuX;
      }
      AppMethodBeat.o(362919);
      return;
    }
  }
  
  private static final void a(int paramInt, f paramf)
  {
    Object localObject1 = null;
    AppMethodBeat.i(362979);
    s.u(paramf, "this$0");
    if ((paramInt > 0) && (paramInt < paramf.AUi.data.size()))
    {
      paramf = paramf.AUk;
      if (paramf == null) {
        paramf = localObject1;
      }
      while (paramf == null)
      {
        paramf = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(362979);
        throw paramf;
        Object localObject2 = paramf.getRlLayout();
        paramf = localObject1;
        if (localObject2 != null)
        {
          localObject2 = ((RefreshLoadMoreLayout)localObject2).getRecyclerView();
          paramf = localObject1;
          if (localObject2 != null) {
            paramf = ((RecyclerView)localObject2).getLayoutManager();
          }
        }
      }
      ((LinearLayoutManager)paramf).bo(paramInt, 0);
    }
    AppMethodBeat.o(362979);
  }
  
  private static final void a(final f paramf, final t paramt, final Context paramContext, final DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(363008);
    s.u(paramf, "this$0");
    s.u(paramt, "$item");
    s.u(paramContext, "$context");
    paramDialogInterface = paramf.tipDialog;
    if (paramDialogInterface == null) {}
    for (paramDialogInterface = null;; paramDialogInterface = kotlin.ah.aiuX)
    {
      if (paramDialogInterface == null)
      {
        paramContext.getString(e.h.app_tip);
        paramf.tipDialog = ((Dialog)com.tencent.mm.ui.base.k.a(paramContext, paramContext.getString(e.h.app_waiting), false, f..ExternalSyntheticLambda0.INSTANCE));
      }
      paramDialogInterface = (kotlin.g.a.a)new f(paramf, paramt, paramContext);
      localObject1 = (kotlin.g.a.a)new d(paramContext, paramt, paramf, paramDialogInterface, (kotlin.g.a.a)new e(paramf, paramContext));
      if ((!paramt.ECu.eZO()) && (paramt.ECu.field_localCommentId != 0L)) {
        break;
      }
      ((kotlin.g.a.a)localObject1).invoke();
      AppMethodBeat.o(363008);
      return;
      paramDialogInterface.show();
    }
    Object localObject1 = com.tencent.mm.plugin.finder.upload.b.Gbu;
    Object localObject2 = com.tencent.mm.plugin.finder.upload.b.fdT();
    localObject1 = paramt.ECu;
    s.u(localObject1, "wantDeleteItem");
    ((com.tencent.mm.plugin.finder.upload.b)localObject2).Gag.d((com.tencent.mm.loader.f.c)new com.tencent.mm.plugin.finder.upload.a((au)localObject1));
    paramt = ((com.tencent.mm.plugin.finder.upload.b)localObject2).Gag;
    localObject2 = (com.tencent.mm.loader.f.c)new com.tencent.mm.plugin.finder.upload.a((au)localObject1);
    s.u(localObject2, "t");
    Iterator localIterator = ((Iterable)paramt.nrl).iterator();
    while (localIterator.hasNext())
    {
      paramt = localIterator.next();
      if (s.p(((com.tencent.mm.loader.f.c)((com.tencent.mm.loader.f.f)paramt).bsC).aUE(), ((com.tencent.mm.loader.f.c)localObject2).aUE()))
      {
        if ((com.tencent.mm.loader.f.f)paramt == null) {
          break label379;
        }
        paramInt = 1;
        label300:
        if (paramInt == 0) {
          break label385;
        }
        Log.i(com.tencent.mm.plugin.finder.upload.b.TAG, "removeWhenNotDoingNetScene " + localObject1 + " is running");
      }
    }
    for (paramInt = 0;; paramInt = 1)
    {
      if (paramInt != 0) {
        break label426;
      }
      paramf = paramf.tipDialog;
      if (paramf != null) {
        paramf.dismiss();
      }
      aa.makeText(paramContext, e.h.finder_profile_del_failed_retry, 0).show();
      AppMethodBeat.o(363008);
      return;
      paramt = null;
      break;
      label379:
      paramInt = 0;
      break label300;
      label385:
      Log.i(com.tencent.mm.plugin.finder.upload.b.TAG, s.X("removeWhenNotDoingNetScene ", localObject1));
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderActionStorage().pW(((au)localObject1).field_localCommentId);
    }
    label426:
    paramDialogInterface.invoke();
    AppMethodBeat.o(363008);
  }
  
  private static final void a(f paramf, com.tencent.mm.plugin.finder.view.builder.b paramb, long paramLong, View paramView)
  {
    AppMethodBeat.i(362970);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramf);
    localb.cH(paramb);
    localb.hB(paramLong);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramf, "this$0");
    s.u(paramb, "$builder");
    paramf.A(paramb.flQ().getScene(), paramb.flQ().getMentionListWhenReply());
    paramb = (com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class);
    localObject = v.Y("comment_id", com.tencent.mm.ae.d.hF(paramLong));
    paramf = paramf.getEditText();
    if (paramf == null)
    {
      paramf = null;
      if (paramf != null) {
        break label217;
      }
    }
    label217:
    for (paramf = "comment";; paramf = "reply_comment")
    {
      paramb.a("view_clk", paramView, kotlin.a.ak.e(new kotlin.r[] { localObject, v.Y("action_type", paramf) }), 24617);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(362970);
      return;
      paramf = paramf.getTag();
      break;
    }
  }
  
  private static final void a(FinderCommentEditText paramFinderCommentEditText, f paramf)
  {
    AppMethodBeat.i(362986);
    s.u(paramFinderCommentEditText, "$this_apply");
    s.u(paramf, "this$0");
    paramFinderCommentEditText.requestFocus();
    if ((!paramf.safeMode) && (!paramf.AUt))
    {
      paramFinderCommentEditText = paramf.AUk;
      if (paramFinderCommentEditText != null)
      {
        paramFinderCommentEditText = paramFinderCommentEditText.flQ();
        if (paramFinderCommentEditText != null) {
          paramFinderCommentEditText.dP(true);
        }
      }
    }
    AppMethodBeat.o(362986);
  }
  
  private final ImageView ebU()
  {
    AppMethodBeat.i(165689);
    Object localObject = this.AUk;
    if (localObject == null)
    {
      AppMethodBeat.o(165689);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).flQ();
    if (localObject == null)
    {
      AppMethodBeat.o(165689);
      return null;
    }
    localObject = ((FinderCommentFooter)localObject).getAvatarView();
    AppMethodBeat.o(165689);
    return localObject;
  }
  
  private static final void f(DialogInterface paramDialogInterface) {}
  
  private final int getCommentCount()
  {
    Object localObject2 = null;
    AppMethodBeat.i(165672);
    StringBuilder localStringBuilder = new StringBuilder("calculateCommentCount ").append(this.AUi.data.size()).append(", ");
    FinderItem localFinderItem = this.AUj;
    Object localObject1 = localFinderItem;
    if (localFinderItem == null)
    {
      s.bIx("feedObj");
      localObject1 = null;
    }
    Log.i("Finder.DrawerPresenter", ((FinderItem)localObject1).getCommentCount());
    int j = this.AUi.data.size();
    int i;
    if (this.AUi.Bfe == null)
    {
      i = 0;
      localObject1 = this.AUj;
      if (localObject1 != null) {
        break label145;
      }
      s.bIx("feedObj");
      localObject1 = localObject2;
    }
    label145:
    for (;;)
    {
      i = Math.max(j - i, ((FinderItem)localObject1).getCommentCount());
      AppMethodBeat.o(165672);
      return i;
      i = 1;
      break;
    }
  }
  
  private final FinderCommentEditText getEditText()
  {
    AppMethodBeat.i(362929);
    Object localObject = this.AUk;
    if (localObject == null)
    {
      AppMethodBeat.o(362929);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).flQ();
    if (localObject == null)
    {
      AppMethodBeat.o(362929);
      return null;
    }
    localObject = ((FinderCommentFooter)localObject).getEditText();
    AppMethodBeat.o(362929);
    return localObject;
  }
  
  private final Resources getResources()
  {
    AppMethodBeat.i(165691);
    Object localObject = this.AUk;
    if (localObject == null)
    {
      AppMethodBeat.o(165691);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).getContext();
    if (localObject == null)
    {
      AppMethodBeat.o(165691);
      return null;
    }
    localObject = ((Context)localObject).getResources();
    AppMethodBeat.o(165691);
    return localObject;
  }
  
  private final void pS(boolean paramBoolean)
  {
    AppMethodBeat.i(165670);
    this.AUo = paramBoolean;
    Log.i("Finder.DrawerPresenter", s.X("set upContinue ", Boolean.valueOf(paramBoolean)));
    AppMethodBeat.o(165670);
  }
  
  private final void pT(boolean paramBoolean)
  {
    AppMethodBeat.i(165671);
    this.AUp = paramBoolean;
    Log.i("Finder.DrawerPresenter", s.X("set downContinue ", Boolean.valueOf(paramBoolean)));
    AppMethodBeat.o(165671);
  }
  
  private final void pU(boolean paramBoolean)
  {
    AppMethodBeat.i(165692);
    if (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu())
    {
      Log.i("Finder.DrawerPresenter", "refreshData " + paramBoolean + " return for teen mode");
      AppMethodBeat.o(165692);
      return;
    }
    com.tencent.mm.loader.f.h localh = this.ADY;
    if (localh != null) {
      localh.a(new com.tencent.mm.loader.f.g((kotlin.g.a.b)new r(paramBoolean, this)));
    }
    AppMethodBeat.o(165692);
  }
  
  public final void NE(int paramInt)
  {
    AppMethodBeat.i(178247);
    Object localObject = this.AUi.data;
    Log.i("Finder.DrawerPresenter", "preloadNextPage, onScrollIdle, lastVisiblePosition:" + paramInt + ", dataList size:" + ((ArrayList)localObject).size() + ", canPreload:" + this.AUs);
    if ((paramInt >= 0) && (paramInt < ((ArrayList)localObject).size()))
    {
      int i = ((ArrayList)localObject).size();
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      if ((i - paramInt <= com.tencent.mm.plugin.finder.storage.d.eRw()) && (!this.AHQ))
      {
        if (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu())
        {
          Log.i("Finder.DrawerPresenter", "preloadNextPage return for teen mode.");
          AppMethodBeat.o(178247);
          return;
        }
        if (this.AUs)
        {
          this.AUs = false;
          localObject = this.ADY;
          if (localObject != null) {
            ((com.tencent.mm.loader.f.h)localObject).a(new com.tencent.mm.loader.f.g((kotlin.g.a.b)new q(this)));
          }
        }
      }
    }
    AppMethodBeat.o(178247);
  }
  
  public final void a(View paramView, t paramt)
  {
    AppMethodBeat.i(363318);
    s.u(paramView, "view");
    s.u(paramt, "item");
    com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f(paramView.getContext(), 1, false);
    FinderItem localFinderItem = this.AUj;
    paramView = localFinderItem;
    if (localFinderItem == null)
    {
      s.bIx("feedObj");
      paramView = null;
    }
    localf.Vtg = ((u.g)new com.tencent.mm.plugin.finder.view.b.a(paramt, paramView.getUserName()));
    localf.GAC = ((u.i)new b.d(paramt, this.AUh, (kotlin.g.a.b)new n(this)));
    localf.dDn();
    AppMethodBeat.o(363318);
  }
  
  public final void a(t paramt)
  {
    AppMethodBeat.i(165678);
    s.u(paramt, "item");
    Context localContext = this.context;
    if (localContext != null) {
      com.tencent.mm.ui.base.k.a(localContext, e.h.finder_profile_confirm_del, 0, new f..ExternalSyntheticLambda1(this, paramt, localContext), null);
    }
    AppMethodBeat.o(165678);
  }
  
  public final void a(final t paramt, final boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(178245);
    s.u(paramt, "rootComment");
    this.AUu = true;
    final ah.d locald = new ah.d();
    Object localObject1 = as.GSQ;
    localObject1 = as.a.hu(this.context);
    int i;
    if (localObject1 == null)
    {
      i = 0;
      locald.aixb = i;
      if (!paramBoolean) {
        break label291;
      }
      localObject1 = paramt.ECu.eZI().levelTwoComment;
      if (!Util.isNullOrNil((List)localObject1)) {
        break label122;
      }
      i = j;
    }
    for (;;)
    {
      if (i == 0) {
        break label231;
      }
      localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
      com.tencent.mm.plugin.finder.report.z.a(paramt, 1, locald.aixb);
      AppMethodBeat.o(178245);
      return;
      i = ((as)localObject1).AJo;
      break;
      label122:
      Object localObject2 = ((Iterable)this.AUi.data).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext()) {
          if (((t)((Iterator)localObject2).next()).ECu.eZI().commentId == ((FinderCommentInfo)((LinkedList)localObject1).getFirst()).commentId)
          {
            i = j;
            break;
          }
        }
      }
      localObject2 = this.ADY;
      if (localObject2 != null) {
        ((com.tencent.mm.loader.f.h)localObject2).a(new com.tencent.mm.loader.f.g((kotlin.g.a.b)new g((LinkedList)localObject1, this, paramt)));
      }
      i = 1;
    }
    label231:
    localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
    com.tencent.mm.plugin.finder.report.z.a(paramt, 2, locald.aixb);
    for (;;)
    {
      localObject1 = this.ADY;
      if (localObject1 != null) {
        ((com.tencent.mm.loader.f.h)localObject1).a(new com.tencent.mm.loader.f.g((kotlin.g.a.b)new k(paramt, this, locald, paramBoolean)));
      }
      AppMethodBeat.o(178245);
      return;
      label291:
      localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
      com.tencent.mm.plugin.finder.report.z.a(paramt, 3, locald.aixb);
    }
  }
  
  public final void a(FinderCommentDrawer paramFinderCommentDrawer, com.tencent.mm.plugin.finder.view.builder.b paramb, final FinderItem paramFinderItem, CommentDrawerContract.CloseDrawerCallback paramCloseDrawerCallback, int paramInt, boolean paramBoolean1, long paramLong1, au paramau, boolean paramBoolean2, boolean paramBoolean3, long paramLong2, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    AppMethodBeat.i(363242);
    s.u(paramFinderCommentDrawer, "drawer");
    s.u(paramb, "builder");
    s.u(paramFinderItem, "feedObj");
    this.bRv = false;
    this.zIz = System.currentTimeMillis();
    Log.i("Finder.DrawerPresenter", "onAttach " + paramFinderItem.getId() + ", " + paramInt + ", " + paramBoolean1 + ", " + paramLong1);
    this.AUk = paramb;
    this.AUv = paramFinderCommentDrawer;
    this.AUj = paramFinderItem;
    this.plm = paramBoolean1;
    this.scene = paramInt;
    this.AUm = paramCloseDrawerCallback;
    this.AAW = paramLong1;
    this.igs = paramBoolean2;
    this.AUq = paramBoolean3;
    this.AUr = paramLong2;
    this.ADY = new com.tencent.mm.loader.f.h("FinderCommentExecutor");
    paramCloseDrawerCallback = this.ADY;
    if (paramCloseDrawerCallback != null)
    {
      paramCloseDrawerCallback.start();
      paramCloseDrawerCallback = kotlin.ah.aiuX;
    }
    Object localObject1 = this.AUi.a(this.context, paramFinderItem.getId(), paramFinderItem, paramLong1, paramBoolean2, paramb.AHK.getCommentScene());
    paramCloseDrawerCallback = (com.tencent.mm.plugin.finder.storage.data.f.b)((kotlin.r)localObject1).bsC;
    paramBoolean3 = ((Boolean)((kotlin.r)localObject1).bsD).booleanValue();
    int k = paramCloseDrawerCallback.pos;
    localObject1 = paramCloseDrawerCallback.lastBuffer;
    paramBoolean2 = paramCloseDrawerCallback.AUo;
    boolean bool1 = paramCloseDrawerCallback.AUp;
    boolean bool2 = paramCloseDrawerCallback.FMX;
    this.lastBuffer = ((com.tencent.mm.bx.b)localObject1);
    this.AUn = paramBoolean3;
    pS(paramBoolean2);
    pT(bool1);
    this.AHL = paramBoolean5;
    this.AUs = true;
    this.AUt = paramBoolean4;
    this.AUu = bool2;
    this.AHQ = paramBoolean6;
    if ((this.AUo) && (!((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()))
    {
      paramb.us(true);
      paramb.flQ().setFooterMode(0);
      if (paramLong1 != 0L) {
        break label937;
      }
      paramCloseDrawerCallback = this.AUk;
      if (paramCloseDrawerCallback != null)
      {
        paramCloseDrawerCallback = paramCloseDrawerCallback.flQ();
        if (paramCloseDrawerCallback != null)
        {
          localObject1 = av.GiL;
          paramCloseDrawerCallback.ij(av.Ud(this.scene), paramFinderItem.getNickName());
          paramCloseDrawerCallback = kotlin.ah.aiuX;
        }
      }
      label425:
      if (!paramBoolean6) {
        break label1150;
      }
      paramb.getRlLayout().setEnableLoadMore(false);
      paramCloseDrawerCallback = paramb.getRlLayout();
    }
    label937:
    label961:
    label993:
    label1135:
    label1778:
    for (;;)
    {
      paramBoolean2 = false;
      paramCloseDrawerCallback.setEnableRefresh(paramBoolean2);
      paramb.getRlLayout().getRecyclerView().setLayoutFrozen(false);
      this.AUl = new b(paramb.getRlLayout().getRecyclerView());
      this.AUx.alive();
      try
      {
        paramCloseDrawerCallback = paramb.getRlLayout().getRecyclerView().getAdapter();
        if (paramCloseDrawerCallback != null)
        {
          paramCloseDrawerCallback.a((RecyclerView.c)this.AUy);
          paramCloseDrawerCallback = kotlin.ah.aiuX;
        }
      }
      catch (IllegalStateException paramCloseDrawerCallback)
      {
        for (;;)
        {
          Object localObject2;
          int i;
          int j;
          Log.printErrStackTrace("Finder.DrawerPresenter", (Throwable)paramCloseDrawerCallback, "", new Object[0]);
          continue;
          paramCloseDrawerCallback = paramCloseDrawerCallback.fdt();
          continue;
          localObject1 = ((Resources)localObject1).getString(e.h.finder_gallery_desc);
          continue;
          if (getCommentCount() <= 0)
          {
            paramb.fdt().setText((CharSequence)paramb.getContext().getResources().getString(e.h.finder_comment));
          }
          else
          {
            paramb.fdt().setText((CharSequence)paramb.getContext().getResources().getString(e.h.finder_comment_count_tip, new Object[] { com.tencent.mm.plugin.finder.utils.r.ip(this.scene, getCommentCount()) }));
            continue;
            paramCloseDrawerCallback = com.tencent.mm.plugin.finder.api.d.AwY;
            paramCloseDrawerCallback = d.a.auT(com.tencent.mm.model.z.bAW());
            if (paramCloseDrawerCallback == null) {
              paramCloseDrawerCallback = "";
            }
            for (;;)
            {
              paramau = com.tencent.mm.plugin.finder.loader.p.ExI;
              paramau = com.tencent.mm.plugin.finder.loader.p.eCp();
              paramCloseDrawerCallback = new com.tencent.mm.plugin.finder.loader.b(paramCloseDrawerCallback);
              localObject1 = ebU();
              s.checkNotNull(localObject1);
              localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
              paramau.a(paramCloseDrawerCallback, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
              break;
              paramau = paramCloseDrawerCallback.amx();
              paramCloseDrawerCallback = paramau;
              if (paramau == null) {
                paramCloseDrawerCallback = "";
              }
            }
            paramFinderCommentDrawer = paramFinderCommentDrawer.flQ();
            continue;
            if (!paramBoolean1)
            {
              if (!paramBoolean3)
              {
                pU(true);
                paramCloseDrawerCallback = this.AUk;
                if (paramCloseDrawerCallback != null)
                {
                  paramCloseDrawerCallback.showLoading();
                  paramCloseDrawerCallback = kotlin.ah.aiuX;
                }
                paramCloseDrawerCallback = com.tencent.mm.plugin.finder.storage.d.FAy;
                if (((Number)com.tencent.mm.plugin.finder.storage.d.eRX().bmg()).intValue() != 1) {
                  break label1765;
                }
                paramb.flR().setBackgroundColorRes(e.b.transparent);
              }
              for (;;)
              {
                paramb.flR().setSquaresBackgroundResource(e.d.finder_bottom_corner_shape);
                paramb.getRlLayout().setVisibility(0);
                paramb.getHeaderLayout().setVisibility(0);
                if (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()) {
                  break label1778;
                }
                if ((paramFinderItem.getCommentCount() != 0) || (paramFinderCommentDrawer.getReason() == 4)) {
                  break;
                }
                paramFinderCommentDrawer = getEditText();
                if (paramFinderCommentDrawer == null) {
                  break;
                }
                paramFinderCommentDrawer.postDelayed(new f..ExternalSyntheticLambda4(paramFinderCommentDrawer, this), 200L);
                paramFinderCommentDrawer = kotlin.ah.aiuX;
                break;
                if ((paramBoolean3) && (k == 0) && (paramLong1 == 0L) && (!this.AUu))
                {
                  this.lastBuffer = null;
                  pT(true);
                  pU(true);
                  break label1487;
                }
                paramCloseDrawerCallback = this.AUk;
                if (paramCloseDrawerCallback != null)
                {
                  paramCloseDrawerCallback = paramCloseDrawerCallback.getRlLayout();
                  if (paramCloseDrawerCallback != null)
                  {
                    paramCloseDrawerCallback = paramCloseDrawerCallback.getRecyclerView();
                    if (paramCloseDrawerCallback != null)
                    {
                      paramCloseDrawerCallback = paramCloseDrawerCallback.getAdapter();
                      if (paramCloseDrawerCallback != null)
                      {
                        paramCloseDrawerCallback.bZE.notifyChanged();
                        paramCloseDrawerCallback = kotlin.ah.aiuX;
                      }
                    }
                  }
                }
                paramCloseDrawerCallback = this.AUk;
                if (paramCloseDrawerCallback == null) {
                  break label1487;
                }
                paramCloseDrawerCallback = paramCloseDrawerCallback.getRlLayout();
                if (paramCloseDrawerCallback == null) {
                  break label1487;
                }
                paramCloseDrawerCallback = paramCloseDrawerCallback.getRecyclerView();
                if (paramCloseDrawerCallback == null) {
                  break label1487;
                }
                paramCloseDrawerCallback.post(new f..ExternalSyntheticLambda3(k, this));
                break label1487;
                paramb.flR().setBackgroundColorRes(e.b.UN_BW_0_Alpha_0_5);
              }
              paramFinderCommentDrawer = this.AUk;
              if (paramFinderCommentDrawer == null) {}
              for (paramFinderCommentDrawer = null; paramFinderCommentDrawer != null; paramFinderCommentDrawer = paramFinderCommentDrawer.flQ())
              {
                paramFinderCommentDrawer.setVisibility(8);
                break;
              }
            }
            paramb.flR().setSquaresBackgroundResource(e.b.transparent);
            paramb.flR().setBackgroundColorRes(e.b.transparent);
            paramb.getHeaderLayout().setVisibility(8);
            paramb.getRlLayout().setVisibility(8);
            paramFinderCommentDrawer = getEditText();
            if (paramFinderCommentDrawer != null) {
              paramFinderCommentDrawer.requestFocus();
            }
            if (!this.safeMode)
            {
              paramFinderCommentDrawer = this.AUk;
              if (paramFinderCommentDrawer != null)
              {
                paramFinderCommentDrawer = paramFinderCommentDrawer.flQ();
                if (paramFinderCommentDrawer != null)
                {
                  paramFinderCommentDrawer.dP(true);
                  paramFinderCommentDrawer = kotlin.ah.aiuX;
                }
              }
            }
          }
        }
      }
      com.tencent.mm.view.f.a(paramb.getRlLayout().getRecyclerView(), (com.tencent.mm.view.e.a)new l(this, paramFinderItem));
      paramb.getRlLayout().setActionCallback((RefreshLoadMoreLayout.b)new m(this));
      paramb.flQ().setModeChangeCallback((FinderCommentFooter.b)this);
      paramCloseDrawerCallback = paramb.flQ();
      paramLong2 = paramFinderItem.getId();
      paramCloseDrawerCallback.getEditText().feedId = paramLong2;
      if (paramBoolean6)
      {
        paramCloseDrawerCallback = this.AUk;
        if (paramCloseDrawerCallback == null)
        {
          paramCloseDrawerCallback = null;
          if (paramCloseDrawerCallback != null)
          {
            localObject1 = getResources();
            if (localObject1 != null) {
              break label1251;
            }
            localObject1 = null;
            paramCloseDrawerCallback.setText((CharSequence)localObject1);
          }
          paramb.flQ().getReplyBtn().setOnClickListener(new f..ExternalSyntheticLambda2(this, paramb, paramLong1));
          ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).i(paramb.flQ().getReplyBtn(), "finder_comment_reply_btn");
          if (paramau != null)
          {
            paramCloseDrawerCallback = paramb.flQ();
            localObject1 = av.GiL;
            localObject1 = av.Ud(this.scene);
            localObject2 = av.GiL;
            paramCloseDrawerCallback.i((String)localObject1, av.ip(paramau.getUsername(), paramau.getNickname()), paramau);
            paramCloseDrawerCallback = kotlin.ah.aiuX;
            paramCloseDrawerCallback = kotlin.ah.aiuX;
          }
          if (ebU() != null)
          {
            if (paramInt != 2) {
              break label1341;
            }
            com.tencent.mm.ui.i.a.a.g(ebU(), com.tencent.mm.model.z.bAM());
          }
          paramCloseDrawerCallback = this.AUk;
          if (paramCloseDrawerCallback != null)
          {
            paramCloseDrawerCallback.hideLoading();
            paramCloseDrawerCallback = kotlin.ah.aiuX;
          }
          if (!paramBoolean6) {
            break label1451;
          }
          paramb.getHeaderLayout().setVisibility(0);
          paramb.getRlLayout().setVisibility(0);
          paramFinderCommentDrawer = this.AUk;
          if (paramFinderCommentDrawer != null) {
            break label1443;
          }
          paramFinderCommentDrawer = null;
          if (paramFinderCommentDrawer != null) {
            paramFinderCommentDrawer.setVisibility(8);
          }
          paramb.flR().setSquaresBackgroundResource(e.d.finder_bottom_corner_shape);
          if (!this.AUp)
          {
            paramFinderCommentDrawer = this.AUk;
            if (paramFinderCommentDrawer != null)
            {
              paramFinderCommentDrawer = paramFinderCommentDrawer.getRlLayout();
              if (paramFinderCommentDrawer != null)
              {
                RefreshLoadMoreLayout.e(paramFinderCommentDrawer);
                paramFinderCommentDrawer = kotlin.ah.aiuX;
              }
            }
          }
          this.AUw.alive();
          AppMethodBeat.o(363242);
          return;
          paramb.us(false);
          paramCloseDrawerCallback = this.AUk;
          if (paramCloseDrawerCallback == null) {
            break;
          }
          paramCloseDrawerCallback = paramCloseDrawerCallback.flR();
          if (paramCloseDrawerCallback == null) {
            break;
          }
          paramCloseDrawerCallback.jMR();
          paramCloseDrawerCallback = kotlin.ah.aiuX;
          break;
          paramCloseDrawerCallback = (List)this.AUi.data;
          i = 0;
          paramCloseDrawerCallback = paramCloseDrawerCallback.iterator();
          if (paramCloseDrawerCallback.hasNext()) {
            if (((t)paramCloseDrawerCallback.next()).bZA() == paramLong1)
            {
              j = 1;
              if (j == 0) {
                break label1135;
              }
            }
          }
          for (;;)
          {
            if (i < 0) {
              break label1148;
            }
            localObject2 = (t)this.AUi.data.get(i);
            ((t)localObject2).ECz = true;
            paramCloseDrawerCallback = this.AUk;
            if (paramCloseDrawerCallback == null) {
              break;
            }
            FinderCommentFooter localFinderCommentFooter = paramCloseDrawerCallback.flQ();
            if (localFinderCommentFooter == null) {
              break;
            }
            paramCloseDrawerCallback = av.GiL;
            String str1 = av.Ud(this.scene);
            paramCloseDrawerCallback = av.GiL;
            String str2 = ((t)localObject2).ECu.getUsername();
            localObject1 = ((t)localObject2).ECu.getNickname();
            paramCloseDrawerCallback = (CommentDrawerContract.CloseDrawerCallback)localObject1;
            if (localObject1 == null) {
              paramCloseDrawerCallback = "";
            }
            localFinderCommentFooter.i(str1, av.ip(str2, paramCloseDrawerCallback), ((t)localObject2).ECu);
            paramCloseDrawerCallback = kotlin.ah.aiuX;
            break;
            j = 0;
            break label993;
            i += 1;
            break label961;
            i = -1;
          }
          label1148:
          break label425;
          label1150:
          paramCloseDrawerCallback = paramb.getRlLayout();
          if (!((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()) {}
          for (paramBoolean2 = true;; paramBoolean2 = false)
          {
            paramCloseDrawerCallback.setEnableLoadMore(paramBoolean2);
            paramCloseDrawerCallback = paramb.getRlLayout();
            if (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()) {
              break label1899;
            }
            paramBoolean2 = true;
            break;
          }
        }
      }
    }
  }
  
  public final void as(View paramView, int paramInt)
  {
    AppMethodBeat.i(165681);
    s.u(paramView, "view");
    if (paramInt < 0)
    {
      Log.i("Finder.DrawerPresenter", s.X("onClickResendComment position:", Integer.valueOf(paramInt)));
      AppMethodBeat.o(165681);
      return;
    }
    paramView = this.AUi.Ob(paramInt).ECu;
    if (paramView.field_state == -1)
    {
      Object localObject = com.tencent.mm.plugin.finder.upload.b.Gbu;
      localObject = com.tencent.mm.plugin.finder.upload.b.fdT();
      s.u(paramView, "unsentComment");
      Log.i(com.tencent.mm.plugin.finder.upload.b.TAG, s.X("rePost ", paramView));
      paramView.field_state = 1;
      paramView.field_canRemove = 0;
      paramView.qg(cn.bDu() / 1000L);
      paramView.field_postTime = cn.bDu();
      paramView.field_tryCount = 0L;
      ((com.tencent.mm.plugin.finder.upload.b)localObject).a(new com.tencent.mm.plugin.finder.upload.a(paramView));
      paramView = this.AUk;
      if (paramView != null)
      {
        paramView = paramView.getRlLayout();
        if (paramView != null)
        {
          paramView = paramView.getRecyclerView();
          if (paramView != null)
          {
            localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter", "onClickResendComment", "(Landroid/view/View;I)V", "Undefined", "scrollToPosition", "(I)V");
            paramView.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter", "onClickResendComment", "(Landroid/view/View;I)V", "Undefined", "scrollToPosition", "(I)V");
          }
        }
      }
    }
    AppMethodBeat.o(165681);
  }
  
  public final void b(ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(165677);
    s.u(paramImageView, "view");
    if (paramInt < 0)
    {
      Log.i("Finder.DrawerPresenter", s.X("onLikeComment position:", Integer.valueOf(paramInt)));
      AppMethodBeat.o(165677);
      return;
    }
    t localt = this.AUi.Ob(paramInt);
    Object localObject1 = com.tencent.mm.plugin.finder.upload.action.l.Gdj;
    Object localObject3 = com.tencent.mm.plugin.finder.upload.action.l.fek();
    Object localObject2 = this.AUj;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("feedObj");
      localObject1 = null;
    }
    boolean bool1 = ((com.tencent.mm.plugin.finder.upload.action.l)localObject3).a(((FinderItem)localObject1).getId(), localt.ECu, this.scene);
    Log.i("Finder.DrawerPresenter", "[onLikeComment] position=" + paramInt + " isLike=" + bool1 + " commentObj=" + localt.ECu);
    int i;
    label274:
    label310:
    kotlin.r localr1;
    kotlin.r localr2;
    if (!bool1)
    {
      bool1 = true;
      if ((this.context instanceof MMFragmentActivity))
      {
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        localObject3 = ((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.context).q(as.class)).fou();
        localObject1 = av.GiL;
        localObject2 = this.AUj;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("feedObj");
          localObject1 = null;
        }
        boolean bool2 = av.Iz(((FinderItem)localObject1).getUserName());
        localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eSA().bmg()).intValue() == 1) {
          break label697;
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (com.tencent.mm.plugin.finder.storage.d.eRy() != 1) {
          break label697;
        }
        i = 1;
        if ((bool2) && (i == 1))
        {
          if (!bool1) {
            break label705;
          }
          localt.ECu.Tu(localt.ECu.eZI().displayFlag | 0x1);
        }
        localObject1 = an.ECX;
        localObject2 = this.AUj;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("feedObj");
          localObject1 = null;
        }
        long l = ((FinderItem)localObject1).getId();
        localObject2 = this.AUj;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("feedObj");
          localObject1 = null;
        }
        an.a((bui)localObject3, l, ((FinderItem)localObject1).getObjectNonceId(), localt.ECu, bool1, this.scene, bool2);
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        localObject1 = com.tencent.mm.ui.component.k.d((AppCompatActivity)this.context).q(as.class);
        s.s(localObject1, "UICProvider.of(context).…rReporterUIC::class.java)");
        localObject1 = ((bn)localObject1).foy();
        if (localObject1 != null)
        {
          localObject3 = ((com.tencent.mm.plugin.finder.event.a)localObject1).dYj();
          if (localObject3 != null)
          {
            localObject2 = this.AUj;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("feedObj");
              localObject1 = null;
            }
            ((a.b)localObject3).ni(((FinderItem)localObject1).getId());
          }
        }
      }
      localObject2 = (com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class);
      localObject3 = v.Y("comment_id", com.tencent.mm.ae.d.hF(localt.ECu.eZI().commentId));
      localr1 = v.Y("comment_username", localt.ECu.getUsername());
      localr2 = v.Y("display_flag", Integer.valueOf(localt.ECu.eZI().displayFlag));
      if (!bool1) {
        break label730;
      }
    }
    label697:
    label705:
    label730:
    for (localObject1 = "like";; localObject1 = "unlike")
    {
      ((com.tencent.mm.plugin.datareport.a.b)localObject2).a("comment_like_clk", paramImageView, kotlin.a.ak.e(new kotlin.r[] { localObject3, localr1, localr2, v.Y("action_type", localObject1) }), 24617);
      paramImageView = com.tencent.mm.plugin.finder.utils.ak.GhA;
      com.tencent.mm.plugin.finder.utils.ak.k(bool1, localt.ECu.eZI().commentId);
      paramImageView = this.AUk;
      if (paramImageView != null)
      {
        paramImageView = paramImageView.getRlLayout();
        if (paramImageView != null)
        {
          paramImageView = paramImageView.getRecyclerView();
          if (paramImageView != null)
          {
            paramImageView = paramImageView.getAdapter();
            if (paramImageView != null) {
              paramImageView.t(paramInt, Integer.valueOf(1));
            }
          }
        }
      }
      AppMethodBeat.o(165677);
      return;
      bool1 = false;
      break;
      i = this.scene;
      break label274;
      localt.ECu.Tu(localt.ECu.eZI().displayFlag & 0xFFFFFFFE);
      break label310;
    }
  }
  
  public final boolean b(t paramt, boolean paramBoolean)
  {
    AppMethodBeat.i(178246);
    s.u(paramt, "comment");
    Object localObject1;
    int i;
    if (paramt.ECu.field_actionInfo.ABa == 0L)
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(178246);
        return false;
      }
      localObject1 = this.AUi;
      s.u(paramt, "root");
      if (paramt.bZA() != 0L)
      {
        localObject1 = ((Iterable)((com.tencent.mm.plugin.finder.feed.model.h)localObject1).data).iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
        } while (((t)((Iterator)localObject1).next()).ECu.field_actionInfo.ABa != paramt.bZA());
      }
      for (i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(178246);
        return true;
      }
      AppMethodBeat.o(178246);
      return false;
    }
    if (paramBoolean)
    {
      localObject1 = this.AUi;
      s.u(paramt, "level2Comment");
      Iterator localIterator = ((Iterable)((com.tencent.mm.plugin.finder.feed.model.h)localObject1).data).iterator();
      i = 0;
      int j = -1;
      int k;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Object localObject2 = localIterator.next();
          k = i + 1;
          if (i < 0) {
            kotlin.a.p.kkW();
          }
          localObject2 = (t)localObject2;
          if (com.tencent.mm.plugin.finder.feed.model.h.b((t)localObject2, paramt))
          {
            j = i;
            i = k;
          }
          else if ((j >= 0) && (com.tencent.mm.plugin.finder.feed.model.h.a((t)localObject2, paramt)))
          {
            Log.d(((com.tencent.mm.plugin.finder.feed.model.h)localObject1).TAG, "hasLevel2ItemAfter cur:" + j + ", after:" + i);
          }
        }
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label309;
        }
        AppMethodBeat.o(178246);
        return true;
        i = k;
        break;
      }
      label309:
      AppMethodBeat.o(178246);
      return false;
    }
    if (!this.AUi.c(paramt))
    {
      AppMethodBeat.o(178246);
      return true;
    }
    AppMethodBeat.o(178246);
    return false;
  }
  
  public final int ebS()
  {
    return this.scene;
  }
  
  public final FinderItem ebT()
  {
    AppMethodBeat.i(165684);
    FinderItem localFinderItem = this.AUj;
    if (localFinderItem == null)
    {
      s.bIx("feedObj");
      AppMethodBeat.o(165684);
      return null;
    }
    AppMethodBeat.o(165684);
    return localFinderItem;
  }
  
  public final void ebV()
  {
    Resources localResources = null;
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(178243);
    Object localObject1;
    if (this.AHQ)
    {
      localObject1 = this.AUk;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 == null) {
          break label180;
        }
        localResources = getResources();
        if (localResources != null) {
          break label67;
        }
      }
      for (;;)
      {
        ((TextView)localObject1).setText((CharSequence)localObject2);
        AppMethodBeat.o(178243);
        return;
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).fdt();
        break;
        label67:
        localObject2 = localResources.getString(e.h.finder_gallery_desc);
      }
    }
    else if (getCommentCount() <= 0)
    {
      localObject1 = this.AUk;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 == null) {
          break label180;
        }
        localObject2 = getResources();
        if (localObject2 != null) {
          break label134;
        }
      }
      label134:
      for (localObject2 = localResources;; localObject2 = ((Resources)localObject2).getString(e.h.finder_comment))
      {
        ((TextView)localObject1).setText((CharSequence)localObject2);
        AppMethodBeat.o(178243);
        return;
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).fdt();
        break;
      }
    }
    else
    {
      localObject1 = this.AUk;
      if (localObject1 != null) {
        break label187;
      }
      localObject1 = null;
      if (localObject1 != null)
      {
        localObject2 = getResources();
        if (localObject2 != null) {
          break label195;
        }
      }
    }
    label180:
    label187:
    label195:
    for (localObject2 = localObject3;; localObject2 = ((Resources)localObject2).getString(e.h.finder_comment_count_tip, new Object[] { String.valueOf(getCommentCount()) }))
    {
      ((TextView)localObject1).setText((CharSequence)localObject2);
      AppMethodBeat.o(178243);
      return;
      localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).fdt();
      break;
    }
  }
  
  public final int ebW()
  {
    AppMethodBeat.i(363373);
    Object localObject = this.AUi.data;
    if (!Util.isNullOrNil((List)localObject))
    {
      localObject = (t)kotlin.a.p.oL((List)localObject);
      if (localObject != null)
      {
        localObject = ((t)localObject).ECu;
        if ((localObject != null) && (((au)localObject).eZN() == true))
        {
          i = 1;
          if (i == 0) {
            break label77;
          }
        }
      }
    }
    label77:
    for (int i = 0;; i = -1)
    {
      AppMethodBeat.o(363373);
      return i;
      i = 0;
      break;
    }
  }
  
  public final int ebX()
  {
    AppMethodBeat.i(363381);
    Object localObject1 = this.AUi.data;
    if (!Util.isNullOrNil((List)localObject1))
    {
      localObject1 = ((Iterable)localObject1).iterator();
      int i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          kotlin.a.p.kkW();
        }
        localObject2 = (t)localObject2;
        if ((((t)localObject2).ECu.field_actionInfo.ABa == 0L) && (!((t)localObject2).ECu.eZN()))
        {
          AppMethodBeat.o(363381);
          return i;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(363381);
    return -1;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(363250);
    Object localObject = as.GSQ;
    localObject = as.a.hu(this.context);
    if (localObject == null)
    {
      AppMethodBeat.o(363250);
      return 0;
    }
    int i = ((as)localObject).AJo;
    AppMethodBeat.o(363250);
    return i;
  }
  
  public final RecyclerView.h gl(Context paramContext)
  {
    AppMethodBeat.i(363335);
    s.u(paramContext, "context");
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = ((int)paramContext.getResources().getDimension(e.c.Edge_7A));
    paramContext = (RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.a((Drawable)new ColorDrawable(paramContext.getResources().getColor(e.b.BW_90)), (int)paramContext.getResources().getDimension(e.c.feed_detail_divider), arrayOfInt, (int)paramContext.getResources().getDimension(e.c.feed_detail_divider_last));
    AppMethodBeat.o(363335);
    return paramContext;
  }
  
  public final WxRecyclerAdapter<?> gr(Context paramContext)
  {
    AppMethodBeat.i(165685);
    s.u(paramContext, "context");
    paramContext = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.g)new h(this), this.AUi.data);
    paramContext.bf(false);
    paramContext.agOe = ((i.c)this);
    paramContext.agOd = ((i.d)this);
    AppMethodBeat.o(165685);
    return paramContext;
  }
  
  public final void ht(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(165676);
    Log.i("Finder.DrawerPresenter", "[onModeChange] from=" + paramInt1 + " to=" + paramInt2);
    if (paramInt2 == 0)
    {
      Object localObject = this.AUk;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).flR();
        if (localObject != null)
        {
          localObject = ((FinderCommentDrawer)localObject).getRecyclerView();
          if (localObject != null)
          {
            localObject = ((RecyclerView)localObject).animate();
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).translationY(0.0F);
              if (localObject != null)
              {
                localObject = ((ViewPropertyAnimator)localObject).setDuration(180L);
                if (localObject != null) {
                  ((ViewPropertyAnimator)localObject).start();
                }
              }
            }
          }
        }
      }
      if (this.bRv)
      {
        localObject = this.AUk;
        if (localObject != null)
        {
          FinderCommentFooter localFinderCommentFooter = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).flQ();
          if (localFinderCommentFooter != null)
          {
            localObject = av.GiL;
            String str = av.Ud(this.scene);
            FinderItem localFinderItem = this.AUj;
            localObject = localFinderItem;
            if (localFinderItem == null)
            {
              s.bIx("feedObj");
              localObject = null;
            }
            localFinderCommentFooter.ij(str, ((FinderItem)localObject).getNickName());
          }
        }
      }
    }
    AppMethodBeat.o(165676);
  }
  
  public final boolean isCommentClose()
  {
    return this.AUt;
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(165673);
    s.u(parama, "p0");
    this.ATq.add(parama);
    AppMethodBeat.o(165673);
  }
  
  public final t nq(long paramLong)
  {
    AppMethodBeat.i(178244);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(178244);
      return null;
    }
    Iterator localIterator = ((Iterable)this.AUi.data).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((t)localObject).ECu.eZI().commentId == paramLong)
      {
        i = 1;
        label77:
        if (i == 0) {
          break label100;
        }
      }
    }
    for (;;)
    {
      localObject = (t)localObject;
      AppMethodBeat.o(178244);
      return localObject;
      i = 0;
      break label77;
      label100:
      break;
      localObject = null;
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(165675);
    if (this.bRv)
    {
      Log.i("Finder.DrawerPresenter", "onDetach: can not detach, because it is not attached");
      AppMethodBeat.o(165675);
      return;
    }
    Object localObject1 = as.GSQ;
    localObject1 = as.a.hu(this.context);
    int j;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.finder.report.z.FrZ;
      localObject3 = ((as)localObject1).sessionId;
      String str1 = ((as)localObject1).zIO;
      String str2 = ((as)localObject1).zIB;
      j = ((as)localObject1).AJo;
      localObject2 = this.AUj;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("feedObj");
        localObject1 = null;
      }
      long l1 = ((FinderItem)localObject1).getId();
      long l2 = this.zIz;
      long l3 = System.currentTimeMillis();
      localObject1 = this.AUv;
      if (localObject1 != null) {
        break label337;
      }
      i = 0;
      com.tencent.mm.plugin.finder.report.z.a((String)localObject3, str1, str2, j, l1, l2, l3, i);
      localObject1 = as.GSQ;
      localObject1 = as.a.hu(this.context);
      if (localObject1 != null) {
        break label346;
      }
      localObject1 = null;
      label174:
      if ((localObject1 instanceof ae))
      {
        localObject1 = (ae)localObject1;
        localObject2 = com.tencent.mm.plugin.finder.report.m.Fpx;
        ((ae)localObject1).azV(m.a.aj(kotlin.a.ak.e(new kotlin.r[] { v.Y("feedActionType", Long.valueOf(24L)), v.Y("value", Long.valueOf(System.currentTimeMillis() - this.zIz)) })));
      }
    }
    this.bRv = true;
    this.AUs = false;
    localObject1 = this.ADY;
    if (localObject1 != null) {
      ((com.tencent.mm.loader.f.h)localObject1).stop();
    }
    this.ADY = null;
    localObject1 = this.AUk;
    if (localObject1 == null)
    {
      localObject1 = null;
      label289:
      if (!(localObject1 instanceof LinearLayoutManager)) {
        break label583;
      }
      localObject1 = this.AUk;
      if (localObject1 != null) {
        break label402;
      }
      localObject1 = null;
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label448;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
      AppMethodBeat.o(165675);
      throw ((Throwable)localObject1);
      label337:
      i = ((FinderCommentDrawer)localObject1).getReason();
      break;
      label346:
      localObject1 = as.a((as)localObject1);
      break label174;
      localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).getRlLayout();
      if (localObject1 == null)
      {
        localObject1 = null;
        break label289;
      }
      localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
      if (localObject1 == null)
      {
        localObject1 = null;
        break label289;
      }
      localObject1 = ((RecyclerView)localObject1).getLayoutManager();
      break label289;
      label402:
      localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).getRlLayout();
      if (localObject1 == null)
      {
        localObject1 = null;
      }
      else
      {
        localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = ((RecyclerView)localObject1).getLayoutManager();
        }
      }
    }
    label448:
    int i = ((LinearLayoutManager)localObject1).Ju();
    localObject1 = this.AUk;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).flQ())
    {
      if (localObject1 != null) {
        ((FinderCommentFooter)localObject1).setFooterMode(0);
      }
      localObject1 = this.AUk;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).getRlLayout();
        if (localObject1 != null)
        {
          localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
          if (localObject1 != null)
          {
            localObject1 = ((RecyclerView)localObject1).getAdapter();
            if (localObject1 != null) {
              ((RecyclerView.a)localObject1).b((RecyclerView.c)this.AUy);
            }
          }
        }
      }
      localObject1 = ((Iterable)this.ATq).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.tencent.mm.vending.e.a)((Iterator)localObject1).next()).dead();
      }
      label583:
      i = -1;
      break;
    }
    this.ATq.clear();
    this.AUx.dead();
    Object localObject2 = this.AUj;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("feedObj");
      localObject1 = null;
    }
    ((FinderItem)localObject1).setCommentCount(getCommentCount());
    localObject1 = e.FMN;
    localObject2 = this.AUj;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("feedObj");
      localObject1 = null;
    }
    com.tencent.mm.plugin.finder.storage.data.e.a.s((FinderItem)localObject1);
    Object localObject3 = new StringBuilder("[onDetach] updateFeedCommentCount feedId=");
    localObject2 = this.AUj;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("feedObj");
      localObject1 = null;
    }
    Log.i("Finder.DrawerPresenter", ((FinderItem)localObject1).getId() + " commentCount " + getCommentCount());
    localObject1 = this.AUm;
    if (localObject1 != null) {
      ((CommentDrawerContract.CloseDrawerCallback)localObject1).z(getCommentCount(), (List)this.AUi.data);
    }
    label864:
    int k;
    if ((this.plm) || (!this.igs))
    {
      this.AUi.qb(true);
      this.lastBuffer = null;
      pS(false);
      pT(true);
      localObject1 = getEditText();
      if (localObject1 != null) {
        ((FinderCommentEditText)localObject1).setText(null);
      }
      localObject1 = getEditText();
      if (localObject1 != null) {
        ((FinderCommentEditText)localObject1).fks();
      }
      localObject1 = this.AUk;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          ((RefreshLoadMoreLayout)localObject1).setHasBottomMore(true);
        }
        localObject1 = this.AUk;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).getRlLayout();
          if (localObject1 != null)
          {
            localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
            if (localObject1 != null)
            {
              localObject1 = ((RecyclerView)localObject1).getAdapter();
              if (localObject1 != null) {
                ((RecyclerView.a)localObject1).bZE.notifyChanged();
              }
            }
          }
        }
        localObject1 = this.AUk;
        if (localObject1 != null) {
          break label1240;
        }
        localObject1 = null;
        label944:
        if (localObject1 != null) {
          ((RecyclerView)localObject1).setLayoutFrozen(true);
        }
        localObject1 = this.AUk;
        if (localObject1 != null) {
          break label1268;
        }
        localObject1 = null;
        label969:
        if (localObject1 != null) {
          ((RefreshLoadMoreLayout)localObject1).setActionCallback(null);
        }
        this.AUk = null;
        this.AUw.dead();
        AppMethodBeat.o(165675);
      }
    }
    else
    {
      k = i;
      if (this.AAW != 0L)
      {
        localObject1 = ((Iterable)this.AUi.data).iterator();
        j = 0;
        label1029:
        k = i;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          if (j < 0) {
            kotlin.a.p.kkW();
          }
          localObject2 = (t)localObject2;
          if (((t)localObject2).bZA() != this.AAW) {
            break label1278;
          }
          ((t)localObject2).ECA = false;
          i = j;
        }
      }
    }
    label1240:
    label1268:
    label1278:
    for (;;)
    {
      j += 1;
      break label1029;
      localObject1 = this.AUi;
      localObject2 = this.lastBuffer;
      boolean bool1 = this.AUo;
      boolean bool2 = this.AUp;
      boolean bool3 = this.AUu;
      localObject3 = ((com.tencent.mm.plugin.finder.feed.model.h)localObject1).Bfe;
      if (localObject3 != null) {
        ((com.tencent.mm.plugin.finder.feed.model.h)localObject1).data.remove(localObject3);
      }
      ((com.tencent.mm.plugin.finder.feed.model.h)localObject1).Bfe = null;
      if ((((com.tencent.mm.plugin.finder.feed.model.h)localObject1).data.size() >= 0) && (k >= 0)) {
        h.a.a(((com.tencent.mm.plugin.finder.feed.model.h)localObject1).Bfc, ((com.tencent.mm.plugin.finder.feed.model.h)localObject1).Bfd, ((com.tencent.mm.plugin.finder.feed.model.h)localObject1).data);
      }
      ((com.tencent.mm.plugin.finder.feed.model.h)localObject1).data.clear();
      if ((k < 0) || (com.tencent.mm.plugin.finder.feed.model.h.Bff)) {
        break;
      }
      com.tencent.mm.plugin.finder.storage.data.f.FMT.a(((com.tencent.mm.plugin.finder.feed.model.h)localObject1).Bfc, ((com.tencent.mm.plugin.finder.feed.model.h)localObject1).Bfd, k, (com.tencent.mm.bx.b)localObject2, bool1, bool2, bool3);
      break;
      localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).getRlLayout();
      break label864;
      localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).getRlLayout();
      if (localObject1 == null)
      {
        localObject1 = null;
        break label944;
      }
      localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
      break label944;
      localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).getRlLayout();
      break label969;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$Companion;", "", "()V", "DEFAULT_INIT_COUNT", "", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$DiffDataChangeHelper;", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter;Landroidx/recyclerview/widget/RecyclerView;)V", "onDeleteChange", "", "commentId", "", "localCommentId", "anim", "", "onInsertChange", "target", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "onSecondaryItemRangeInsert", "rootCommentId", "", "onUpdateChange", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
  {
    private final RecyclerView mkw;
    
    public b()
    {
      AppMethodBeat.i(363448);
      this.mkw = localObject;
      AppMethodBeat.o(363448);
    }
    
    public final void a(long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(178222);
      Object localObject1;
      if (paramLong1 != 0L)
      {
        int m = f.o(f.this).data.size();
        localObject1 = f.o(f.this);
        Object localObject3 = (Iterable)((com.tencent.mm.plugin.finder.feed.model.h)localObject1).data;
        Object localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        int i = 0;
        int j = -1;
        if (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = ((Iterator)localObject3).next();
          if (i < 0) {
            kotlin.a.p.kkW();
          }
          t localt = (t)localObject4;
          if (localt.ECu.eZI().commentId == paramLong1) {
            j = i;
          }
          if ((localt.ECu.eZI().commentId == paramLong1) || (localt.ECu.field_actionInfo.ABa == paramLong1)) {}
          for (int k = 1;; k = 0)
          {
            if (k != 0) {
              ((Collection)localObject2).add(localObject4);
            }
            i += 1;
            break;
          }
        }
        localObject2 = (List)localObject2;
        i = ((List)localObject2).size();
        ((com.tencent.mm.plugin.finder.feed.model.h)localObject1).data.removeAll((Collection)localObject2);
        localObject1 = new kotlin.r(Integer.valueOf(j), Integer.valueOf(i));
        if ((paramBoolean) && (((Number)((kotlin.r)localObject1).bsC).intValue() >= 0))
        {
          i = ((Number)((kotlin.r)localObject1).bsC).intValue();
          if (((Number)((kotlin.r)localObject1).bsD).intValue() + i <= m)
          {
            localObject2 = this.mkw.getAdapter();
            if (localObject2 != null) {
              ((RecyclerView.a)localObject2).bB(((Number)((kotlin.r)localObject1).bsC).intValue(), ((Number)((kotlin.r)localObject1).bsD).intValue());
            }
          }
        }
      }
      for (;;)
      {
        localObject1 = this.mkw.getAdapter();
        if (localObject1 != null) {
          ((RecyclerView.a)localObject1).bZE.notifyChanged();
        }
        AppMethodBeat.o(178222);
        return;
        f.o(f.this).nC(paramLong2);
      }
    }
    
    public final boolean a(au paramau)
    {
      AppMethodBeat.i(363458);
      s.u(paramau, "target");
      Object localObject = f.o(f.this);
      s.u(paramau, "item");
      Iterator localIterator;
      int j;
      if (paramau.eZI().commentId == 0L)
      {
        localIterator = ((List)((com.tencent.mm.plugin.finder.feed.model.h)localObject).data).iterator();
        i = 0;
        if (localIterator.hasNext()) {
          if (((t)localIterator.next()).ECu.field_localCommentId == paramau.field_localCommentId)
          {
            j = 1;
            label91:
            if (j == 0) {
              break label231;
            }
            label95:
            if ((i >= 0) && (i < ((com.tencent.mm.plugin.finder.feed.model.h)localObject).data.size()))
            {
              localObject = (t)((com.tencent.mm.plugin.finder.feed.model.h)localObject).data.get(i);
              s.u(paramau, "<set-?>");
              ((t)localObject).ECu = paramau;
            }
            paramau = new kotlin.r(Integer.valueOf(i), Integer.valueOf(1));
            j = ((Number)paramau.bsC).intValue();
            ((Number)paramau.bsD).intValue();
            if (j < 0) {
              break label336;
            }
            paramau = this.mkw.getAdapter();
            if (paramau != null) {
              break label328;
            }
          }
        }
      }
      label260:
      label328:
      for (int i = 0;; i = paramau.getItemCount())
      {
        if (j >= i) {
          break label336;
        }
        paramau = this.mkw.getAdapter();
        if (paramau != null) {
          paramau.t(j, Integer.valueOf(1));
        }
        AppMethodBeat.o(363458);
        return true;
        j = 0;
        break label91;
        label231:
        i += 1;
        break;
        i = -1;
        break label95;
        localIterator = ((List)((com.tencent.mm.plugin.finder.feed.model.h)localObject).data).iterator();
        j = 0;
        if (localIterator.hasNext())
        {
          if (((t)localIterator.next()).ECu.eZI().commentId == paramau.eZI().commentId) {}
          for (int k = 1;; k = 0)
          {
            i = j;
            if (k != 0) {
              break;
            }
            j += 1;
            break label260;
          }
        }
        i = -1;
        break label95;
      }
      label336:
      AppMethodBeat.o(363458);
      return false;
    }
    
    public final boolean b(au paramau)
    {
      AppMethodBeat.i(363469);
      s.u(paramau, "target");
      Object localObject = com.tencent.mm.plugin.finder.storage.logic.a.FNx;
      localObject = com.tencent.mm.plugin.finder.storage.logic.a.d(paramau);
      int i = f.o(f.this).b((t)localObject);
      localObject = this.mkw.getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).bZE.notifyChanged();
      }
      if (paramau.field_actionInfo.ABa != 0L)
      {
        paramau = f.this.AUk;
        if (paramau != null)
        {
          paramau = paramau.getRlLayout();
          if (paramau != null) {
            paramau.ci((kotlin.g.a.a)a.AUA);
          }
        }
        paramau = f.this.AUk;
        if (paramau != null)
        {
          paramau = paramau.getRlLayout();
          if (paramau != null)
          {
            paramau = paramau.getRecyclerView();
            if (paramau != null)
            {
              localObject = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.b(paramau, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$DiffDataChangeHelper", "onInsertChange", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)Z", "Undefined", "scrollToPosition", "(I)V");
              paramau.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.c(paramau, "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$DiffDataChangeHelper", "onInsertChange", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)Z", "Undefined", "scrollToPosition", "(I)V");
            }
          }
        }
      }
      AppMethodBeat.o(363469);
      return true;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<kotlin.ah>
    {
      public static final a AUA;
      
      static
      {
        AppMethodBeat.i(178221);
        AUA = new a();
        AppMethodBeat.o(178221);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$commentDataObserver$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeRemoved", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.c
  {
    c(f paramf) {}
    
    public final void onChanged()
    {
      AppMethodBeat.i(165632);
      super.onChanged();
      this.AUz.ebV();
      AppMethodBeat.o(165632);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(165634);
      super.onItemRangeChanged(paramInt1, paramInt2);
      this.AUz.ebV();
      AppMethodBeat.o(165634);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(165635);
      super.onItemRangeChanged(paramInt1, paramInt2, paramObject);
      this.AUz.ebV();
      AppMethodBeat.o(165635);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(165633);
      super.onItemRangeInserted(paramInt1, paramInt2);
      this.AUz.ebV();
      AppMethodBeat.o(165633);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(165636);
      super.onItemRangeRemoved(paramInt1, paramInt2);
      this.AUz.ebV();
      AppMethodBeat.o(165636);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    d(Context paramContext, t paramt, f paramf, kotlin.g.a.a<kotlin.ah> parama1, kotlin.g.a.a<kotlin.ah> parama2)
    {
      super();
    }
    
    private static final kotlin.ah a(kotlin.g.a.a parama1, kotlin.g.a.a parama2, com.tencent.mm.am.b.a parama)
    {
      AppMethodBeat.i(363431);
      s.u(parama1, "$succCallback");
      s.u(parama2, "$failedCallback");
      if ((parama.errType == 0) && (parama.errCode == 0)) {
        parama1.invoke();
      }
      for (;;)
      {
        parama1 = kotlin.ah.aiuX;
        AppMethodBeat.o(363431);
        return parama1;
        parama2.invoke();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    e(f paramf, Context paramContext)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    f(f paramf, t paramt, Context paramContext)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.b<FinderCommentInfo, Boolean>
    {
      a(t paramt)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.loader.f.g, kotlin.ah>
  {
    g(LinkedList<FinderCommentInfo> paramLinkedList, f paramf, t paramt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$getAdapter$adapter$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements com.tencent.mm.view.recyclerview.g
  {
    h(f paramf) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(165648);
      if (f.f(this.AUz))
      {
        localObject = t.ECt;
        if (paramInt == t.eDl())
        {
          localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.l(this.AUz);
          AppMethodBeat.o(165648);
          return localObject;
        }
        localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.j((CommentDrawerContract.NPresenter)this.AUz, true);
        AppMethodBeat.o(165648);
        return localObject;
      }
      Object localObject = t.ECt;
      if (paramInt == t.eDj())
      {
        localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.j((CommentDrawerContract.NPresenter)this.AUz, false);
        AppMethodBeat.o(165648);
        return localObject;
      }
      localObject = t.ECt;
      if (paramInt == t.eDk())
      {
        localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.m((CommentDrawerContract.NPresenter)this.AUz);
        AppMethodBeat.o(165648);
        return localObject;
      }
      localObject = t.ECt;
      if (paramInt == t.eDl())
      {
        if (f.g(this.AUz))
        {
          localObject = (com.tencent.mm.view.recyclerview.f)new a(this.AUz);
          AppMethodBeat.o(165648);
          return localObject;
        }
        localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.l(this.AUz);
        AppMethodBeat.o(165648);
        return localObject;
      }
      localObject = av.GiL;
      av.eY("Finder.DrawerPresenter", paramInt);
      localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.g();
      AppMethodBeat.o(165648);
      return localObject;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$getAdapter$adapter$1$getItemConvert$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert;", "createDescSpan", "Landroid/text/SpannableString;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedCommentHeaderContent;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "refreshActivity", "refreshLink", "refreshPoi", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends com.tencent.mm.plugin.finder.convert.l
    {
      a(f paramf)
      {
        super(true);
      }
      
      public final SpannableString a(com.tencent.mm.plugin.finder.model.u paramu)
      {
        AppMethodBeat.i(362393);
        s.u(paramu, "item");
        paramu = paramu.ANj.createDescSpanWithoutClick();
        AppMethodBeat.o(362393);
        return paramu;
      }
      
      public final void a(com.tencent.mm.view.recyclerview.j paramj, com.tencent.mm.plugin.finder.model.u paramu)
      {
        AppMethodBeat.i(362388);
        s.u(paramj, "holder");
        s.u(paramu, "item");
        paramj = paramj.UH(e.e.activity_layout);
        if (paramj != null) {
          paramj.setVisibility(8);
        }
        AppMethodBeat.o(362388);
      }
      
      public final void a(com.tencent.mm.view.recyclerview.j paramj, com.tencent.mm.plugin.finder.model.u paramu, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
      {
        AppMethodBeat.i(362368);
        s.u(paramj, "holder");
        s.u(paramu, "item");
        super.a(paramj, paramu, paramInt1, paramInt2, paramBoolean, paramList);
        paramu = (TextView)paramj.caK.findViewById(e.e.nickname);
        paramList = paramj.UH(e.e.avatar_iv);
        FinderCollapsibleTextView localFinderCollapsibleTextView = (FinderCollapsibleTextView)paramj.UH(e.e.text_content);
        paramu.setClickable(false);
        paramu.setEnabled(false);
        paramList.setClickable(false);
        paramList.setEnabled(false);
        localFinderCollapsibleTextView.getContentTextView().setClickable(false);
        localFinderCollapsibleTextView.getContentTextView().setEnabled(false);
        ((LinearLayout)paramj.caK.findViewById(e.e.comment_header_layout)).setBackgroundColor(paramj.context.getResources().getColor(e.b.white));
        paramu.setTextColor(paramj.context.getResources().getColor(e.b.BW_0_Alpha_0_5));
        AppMethodBeat.o(362368);
      }
      
      public final void b(com.tencent.mm.view.recyclerview.j paramj, com.tencent.mm.plugin.finder.model.u paramu)
      {
        AppMethodBeat.i(362376);
        s.u(paramj, "holder");
        s.u(paramu, "item");
        paramj.UH(e.e.link_layout).setVisibility(8);
        AppMethodBeat.o(362376);
      }
      
      public final void c(com.tencent.mm.view.recyclerview.j paramj, com.tencent.mm.plugin.finder.model.u paramu)
      {
        AppMethodBeat.i(362381);
        s.u(paramj, "holder");
        s.u(paramu, "item");
        paramj.UH(e.e.position_layout).setVisibility(8);
        AppMethodBeat.o(362381);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.loader.f.g, kotlin.ah>
  {
    j(f paramf)
    {
      super();
    }
    
    private static final List a(f paramf, com.tencent.mm.am.b.a parama)
    {
      AppMethodBeat.i(363274);
      s.u(paramf, "this$0");
      if (parama == null)
      {
        Log.e("Finder.DrawerPresenter", "loadMoreData resp null");
        paramf = (List)new ArrayList();
        AppMethodBeat.o(363274);
        return paramf;
      }
      if ((parama.errType == 0) && (parama.errCode == 0) && (parama.ott != null))
      {
        if (((ayl)parama.ott).ZJm == 1) {}
        List localList;
        Collection localCollection;
        for (boolean bool = true;; bool = false)
        {
          f.a(paramf, bool);
          f.a(paramf, ((ayl)parama.ott).lastBuffer);
          if (f.j(paramf) != null) {
            break;
          }
          localObject = "null";
          Log.i("Finder.DrawerPresenter", s.X("loadMoreData after lastBuffer ", localObject));
          localList = (List)new ArrayList();
          parama = ((ayl)parama.ott).ZJl;
          s.s(parama, "it.resp.commentInfo");
          parama = (Iterable)parama;
          localCollection = (Collection)new ArrayList(kotlin.a.p.a(parama, 10));
          Iterator localIterator = parama.iterator();
          while (localIterator.hasNext())
          {
            FinderCommentInfo localFinderCommentInfo = (FinderCommentInfo)localIterator.next();
            parama = com.tencent.mm.plugin.finder.storage.logic.a.FNx;
            s.s(localFinderCommentInfo, "commentInfo");
            localObject = f.i(paramf);
            parama = (com.tencent.mm.am.b.a)localObject;
            if (localObject == null)
            {
              s.bIx("feedObj");
              parama = null;
            }
            localCollection.add(com.tencent.mm.plugin.finder.storage.logic.a.a(localFinderCommentInfo, parama.getId()));
          }
        }
        Object localObject = f.j(paramf);
        if (localObject == null) {}
        for (localObject = null;; localObject = ((com.tencent.mm.bx.b)localObject).toByteArray())
        {
          localObject = MD5Util.getMD5String((byte[])localObject);
          break;
        }
        localList.addAll((Collection)localCollection);
        paramf = f.b(paramf, localList);
        AppMethodBeat.o(363274);
        return paramf;
      }
      paramf = (List)new ArrayList();
      AppMethodBeat.o(363274);
      return paramf;
    }
    
    private static final kotlin.ah a(f paramf, com.tencent.mm.loader.f.g paramg, List paramList)
    {
      AppMethodBeat.i(363285);
      s.u(paramf, "this$0");
      s.u(paramg, "$task");
      s.s(paramList, "it");
      int i;
      Object localObject;
      if (!((Collection)paramList).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label218;
        }
        i = f.o(paramf).data.size();
        f.o(paramf).a(paramList, false, true);
        localObject = paramf.AUk;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).getRlLayout();
          if (localObject != null)
          {
            localObject = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
            if (localObject != null)
            {
              localObject = ((RecyclerView)localObject).getAdapter();
              if (localObject != null) {
                ((RecyclerView.a)localObject).bA(i, f.o(paramf).data.size() - i);
              }
            }
          }
        }
      }
      for (;;)
      {
        localObject = new RefreshLoadMoreLayout.d(0);
        ((RefreshLoadMoreLayout.d)localObject).agJu = f.n(paramf);
        ((RefreshLoadMoreLayout.d)localObject).agJv = paramList.size();
        if (((RefreshLoadMoreLayout.d)localObject).agJv > 0) {
          ((RefreshLoadMoreLayout.d)localObject).pzq = false;
        }
        paramf = paramf.AUk;
        if (paramf != null)
        {
          paramf = paramf.getRlLayout();
          if (paramf != null) {
            paramf.onPreFinishLoadMoreSmooth((RefreshLoadMoreLayout.d)localObject);
          }
        }
        paramg.a(com.tencent.mm.loader.f.i.nrG);
        paramf = kotlin.ah.aiuX;
        AppMethodBeat.o(363285);
        return paramf;
        i = 0;
        break;
        label218:
        Log.w("Finder.DrawerPresenter", "[loadMoreData] empty!");
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.loader.f.g, kotlin.ah>
  {
    k(t paramt, f paramf, ah.d paramd, boolean paramBoolean)
    {
      super();
    }
    
    private static final kotlin.ah a(f paramf, t paramt, boolean paramBoolean, com.tencent.mm.loader.f.g paramg, kotlin.r paramr)
    {
      AppMethodBeat.i(363311);
      s.u(paramf, "this$0");
      s.u(paramt, "$rootComment");
      s.u(paramg, "$task");
      int i = ((Number)paramr.bsC).intValue();
      paramr = (List)paramr.bsD;
      switch (i)
      {
      }
      for (;;)
      {
        paramg.a(com.tencent.mm.loader.f.i.nrG);
        paramf = kotlin.ah.aiuX;
        AppMethodBeat.o(363311);
        return paramf;
        f.a(paramf, paramr, paramt, paramBoolean);
        continue;
        paramr = f.p(paramf);
        if (paramr != null) {
          paramr.a(paramt.ECu.eZI().commentId, paramt.ECu.field_localCommentId, true);
        }
        if (paramt.ECu.field_actionInfo.ABa == 0L)
        {
          paramr = e.FMN;
          paramr = com.tencent.mm.plugin.finder.storage.data.e.a.jn(paramt.ECu.field_feedId);
          if (paramr != null)
          {
            paramr.setCommentCount(paramr.getCommentCount() - 1);
            if (paramr.getCommentCount() < 0) {
              paramr.setCommentCount(0);
            }
            if ((paramt.ECu.eZI().expandCommentCount > 0) && (paramt.ECu.eZI().expandCommentCount <= paramr.getCommentCount())) {
              paramr.setCommentCount(paramr.getCommentCount() - paramt.ECu.eZI().expandCommentCount);
            }
            paramt = av.GiL;
            av.G(paramr);
            paramf.ebV();
          }
        }
        aa.makeText(paramf.context, e.h.finder_root_comment_deleted, 0).show();
      }
    }
    
    private static final kotlin.r a(t paramt, f paramf, com.tencent.mm.am.b.a parama)
    {
      AppMethodBeat.i(363299);
      s.u(paramt, "$rootComment");
      s.u(paramf, "this$0");
      if (parama == null)
      {
        Log.e("Finder.DrawerPresenter", "loadMoreLevel2Comments resp null");
        paramt = new kotlin.r(Integer.valueOf(-2), (List)ab.aivy);
        AppMethodBeat.o(363299);
        return paramt;
      }
      if ((parama.errType == 0) && (parama.errCode == 0) && (parama.ott != null))
      {
        Collection localCollection;
        if (paramt.ECu.eZI().lastBuffer == null)
        {
          localObject = "null";
          Log.i("Finder.DrawerPresenter", s.X("loadMoreLevel2Comments after lastBuffer ", localObject));
          parama = ((ayl)parama.ott).ZJl;
          s.s(parama, "it.resp.commentInfo");
          parama = (Iterable)parama;
          localCollection = (Collection)new ArrayList(kotlin.a.p.a(parama, 10));
          Iterator localIterator = parama.iterator();
          while (localIterator.hasNext())
          {
            FinderCommentInfo localFinderCommentInfo = (FinderCommentInfo)localIterator.next();
            parama = com.tencent.mm.plugin.finder.storage.logic.a.FNx;
            s.s(localFinderCommentInfo, "commentInfo");
            localObject = f.i(paramf);
            parama = (com.tencent.mm.am.b.a)localObject;
            if (localObject == null)
            {
              s.bIx("feedObj");
              parama = null;
            }
            localCollection.add(com.tencent.mm.plugin.finder.storage.logic.a.b(localFinderCommentInfo, parama.getId(), paramt.bZA()));
          }
        }
        Object localObject = paramt.ECu.eZI().lastBuffer;
        if (localObject == null) {}
        for (localObject = null;; localObject = ((com.tencent.mm.bx.b)localObject).toByteArray())
        {
          localObject = MD5Util.getMD5String((byte[])localObject);
          break;
        }
        paramt = new kotlin.r(Integer.valueOf(0), (List)localCollection);
        AppMethodBeat.o(363299);
        return paramt;
      }
      if (parama.errCode == -4032)
      {
        paramt = new kotlin.r(Integer.valueOf(-1), (List)ab.aivy);
        AppMethodBeat.o(363299);
        return paramt;
      }
      paramt = new kotlin.r(Integer.valueOf(0), (List)ab.aivy);
      AppMethodBeat.o(363299);
      return paramt;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$2", "Lcom/tencent/mm/view/ExposeElves$OnRecyclerViewChildExposedListener;", "lastExposeSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getLastExposeSet", "()Ljava/util/HashSet;", "ignoreFlingExposed", "", "onChildExposeChanged", "", "parent", "Landroid/view/View;", "exposedHolders", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    extends com.tencent.mm.view.e.a
  {
    private final HashSet<String> AUK;
    
    l(f paramf, FinderItem paramFinderItem)
    {
      AppMethodBeat.i(363302);
      this.AUK = new HashSet();
      AppMethodBeat.o(363302);
    }
    
    public final void b(View paramView, List<? extends RecyclerView.v> paramList)
    {
      AppMethodBeat.i(363316);
      s.u(paramView, "parent");
      s.u(paramList, "exposedHolders");
      HashSet localHashSet = new HashSet();
      paramView = as.GSQ;
      as localas = as.a.hu(this.AUz.context);
      paramView = (Iterable)paramList;
      FinderItem localFinderItem = paramFinderItem;
      Iterator localIterator = paramView.iterator();
      while (localIterator.hasNext())
      {
        paramView = (RecyclerView.v)localIterator.next();
        if ((paramView instanceof com.tencent.mm.view.recyclerview.j))
        {
          paramView = ((com.tencent.mm.view.recyclerview.j)paramView).CSA;
          t localt;
          label110:
          String str;
          label153:
          label161:
          label168:
          int i;
          label175:
          ax localax;
          if ((paramView instanceof t))
          {
            localt = (t)paramView;
            if (localt == null) {
              break label361;
            }
            paramView = String.valueOf(localt.bZA());
            localHashSet.add(paramView);
            if (this.AUK.contains(paramView)) {
              continue;
            }
            paramView = com.tencent.mm.plugin.finder.report.z.FrZ;
            if (localas != null) {
              break label363;
            }
            paramView = null;
            if (localas != null) {
              break label372;
            }
            str = null;
            if (localas != null) {
              break label382;
            }
            paramList = null;
            if (localas != null) {
              break label391;
            }
            i = 0;
            long l = localFinderItem.getFeedObject().id;
            s.u(localt, "comment");
            localax = new ax();
            Object localObject = paramView;
            if (paramView == null) {
              localObject = "";
            }
            localax.ijk = localax.F("SessionId", (String)localObject, true);
            if (str != null) {
              break label400;
            }
            paramView = "";
            label235:
            localax.ipT = localax.F("ContextId", paramView, true);
            if (paramList != null) {
              break label406;
            }
            paramView = "";
            label256:
            localax.ipU = localax.F("ClickTabContextId", paramView, true);
            localax.ipV = i;
            localax.ipW = localax.F("feedid", com.tencent.mm.ae.d.hF(l), true);
            i = localt.bZB();
            paramView = t.ECt;
            if (i != t.eDj()) {
              break label411;
            }
            localax.kL(com.tencent.mm.ae.d.hF(localt.ECu.eZI().commentId));
            localax.kM("");
          }
          for (;;)
          {
            localax.bMH();
            com.tencent.mm.plugin.finder.report.z.a((com.tencent.mm.plugin.report.a)localax);
            break;
            localt = null;
            break label110;
            label361:
            break;
            label363:
            paramView = localas.sessionId;
            break label153;
            label372:
            str = localas.zIO;
            break label161;
            label382:
            paramList = localas.zIB;
            break label168;
            label391:
            i = localas.AJo;
            break label175;
            label400:
            paramView = str;
            break label235;
            label406:
            paramView = paramList;
            break label256;
            label411:
            paramView = t.ECt;
            if (i != t.eDk()) {
              break;
            }
            localax.kL(com.tencent.mm.ae.d.hF(localt.ECu.field_actionInfo.ABa));
            localax.kM(com.tencent.mm.ae.d.hF(localt.ECu.eZI().commentId));
          }
        }
      }
      this.AUK.clear();
      this.AUK.addAll((Collection)localHashSet);
      AppMethodBeat.o(363316);
    }
    
    public final boolean dXG()
    {
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$3", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    extends RefreshLoadMoreLayout.b
  {
    m(f paramf) {}
    
    private static final void q(f paramf)
    {
      AppMethodBeat.i(363169);
      s.u(paramf, "this$0");
      f.d(paramf);
      AppMethodBeat.o(363169);
    }
    
    private static final void r(f paramf)
    {
      AppMethodBeat.i(363177);
      s.u(paramf, "this$0");
      f.e(paramf);
      AppMethodBeat.o(363177);
    }
    
    public final void IH(int paramInt)
    {
      AppMethodBeat.i(363214);
      com.tencent.threadpool.h.ahAA.bm(new f.m..ExternalSyntheticLambda1(this.AUz));
      AppMethodBeat.o(363214);
    }
    
    public final void a(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(363209);
      s.u(paramd, "reason");
      super.a(paramd);
      f.b(this.AUz);
      AppMethodBeat.o(363209);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(363218);
      s.u(paramd, "reason");
      super.onRefreshEnd(paramd);
      f.c(this.AUz);
      AppMethodBeat.o(363218);
    }
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(363201);
      super.qI(paramInt);
      com.tencent.threadpool.h.ahAA.bm(new f.m..ExternalSyntheticLambda0(this.AUz));
      AppMethodBeat.o(363201);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends kotlin.g.b.u
    implements kotlin.g.a.b<t, kotlin.ah>
  {
    n(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends kotlin.g.b.u
    implements kotlin.g.a.b<t, kotlin.ah>
  {
    o(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.loader.f.g, kotlin.ah>
  {
    q(f paramf)
    {
      super();
    }
    
    private static final List a(f paramf, com.tencent.mm.am.b.a parama)
    {
      AppMethodBeat.i(363386);
      s.u(paramf, "this$0");
      if (parama == null)
      {
        Log.e("Finder.DrawerPresenter", "preloadNextPage CgiGetFinderFeedComment resp null");
        paramf = (List)new ArrayList();
        AppMethodBeat.o(363386);
        return paramf;
      }
      if ((parama.errType == 0) && (parama.errCode == 0) && (parama.ott != null))
      {
        if (((ayl)parama.ott).ZJm == 1) {}
        List localList;
        Collection localCollection;
        for (boolean bool = true;; bool = false)
        {
          f.a(paramf, bool);
          f.a(paramf, ((ayl)parama.ott).lastBuffer);
          if (f.j(paramf) != null) {
            break;
          }
          localObject = "null";
          Log.i("Finder.DrawerPresenter", s.X("preloadNextPage after lastBuffer ", localObject));
          localList = (List)new ArrayList();
          parama = ((ayl)parama.ott).ZJl;
          s.s(parama, "it.resp.commentInfo");
          parama = (Iterable)parama;
          localCollection = (Collection)new ArrayList(kotlin.a.p.a(parama, 10));
          Iterator localIterator = parama.iterator();
          while (localIterator.hasNext())
          {
            FinderCommentInfo localFinderCommentInfo = (FinderCommentInfo)localIterator.next();
            parama = com.tencent.mm.plugin.finder.storage.logic.a.FNx;
            s.s(localFinderCommentInfo, "commentInfo");
            localObject = f.i(paramf);
            parama = (com.tencent.mm.am.b.a)localObject;
            if (localObject == null)
            {
              s.bIx("feedObj");
              parama = null;
            }
            localCollection.add(com.tencent.mm.plugin.finder.storage.logic.a.a(localFinderCommentInfo, parama.getId()));
          }
        }
        Object localObject = f.j(paramf);
        if (localObject == null) {}
        for (localObject = null;; localObject = ((com.tencent.mm.bx.b)localObject).toByteArray())
        {
          localObject = MD5Util.getMD5String((byte[])localObject);
          break;
        }
        localList.addAll((Collection)localCollection);
        paramf = f.b(paramf, localList);
        AppMethodBeat.o(363386);
        return paramf;
      }
      paramf = (List)new ArrayList();
      AppMethodBeat.o(363386);
      return paramf;
    }
    
    private static final kotlin.ah a(f paramf, com.tencent.mm.loader.f.g paramg, List paramList)
    {
      AppMethodBeat.i(363392);
      s.u(paramf, "this$0");
      s.u(paramg, "$task");
      s.s(paramList, "it");
      int i;
      Object localObject;
      if (!((Collection)paramList).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label215;
        }
        i = f.o(paramf).data.size();
        f.o(paramf).a(paramList, false, true);
        localObject = paramf.AUk;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).getRlLayout();
          if (localObject != null)
          {
            localObject = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
            if (localObject != null)
            {
              localObject = ((RecyclerView)localObject).getAdapter();
              if (localObject != null) {
                ((RecyclerView.a)localObject).bA(i, f.o(paramf).data.size() - i);
              }
            }
          }
        }
      }
      for (;;)
      {
        localObject = new RefreshLoadMoreLayout.d(0);
        ((RefreshLoadMoreLayout.d)localObject).agJu = f.n(paramf);
        ((RefreshLoadMoreLayout.d)localObject).agJv = paramList.size();
        ((RefreshLoadMoreLayout.d)localObject).pzq = false;
        paramList = paramf.AUk;
        if (paramList != null)
        {
          paramList = paramList.getRlLayout();
          if (paramList != null) {
            paramList.onPreFinishLoadMoreSmooth((RefreshLoadMoreLayout.d)localObject);
          }
        }
        paramg.a(com.tencent.mm.loader.f.i.nrG);
        paramf.AUs = true;
        paramf = kotlin.ah.aiuX;
        AppMethodBeat.o(363392);
        return paramf;
        i = 0;
        break;
        label215:
        Log.w("Finder.DrawerPresenter", "[preloadNextPage] empty!");
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.loader.f.g, kotlin.ah>
  {
    r(boolean paramBoolean, f paramf)
    {
      super();
    }
    
    private static final kotlin.ah a(f paramf, boolean paramBoolean, long paramLong, com.tencent.mm.loader.f.g paramg, kotlin.r paramr)
    {
      AppMethodBeat.i(363429);
      s.u(paramf, "this$0");
      s.u(paramg, "$task");
      boolean bool = ((Boolean)paramr.bsC).booleanValue();
      paramr = (List)paramr.bsD;
      Object localObject1 = paramf.AUk;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).hideLoading();
      }
      if (!paramBoolean)
      {
        localObject1 = paramf.AUk;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).getRlLayout();
          if (localObject1 != null)
          {
            if (paramr != null) {
              break label192;
            }
            i = 0;
            ((RefreshLoadMoreLayout)localObject1).aFV(i);
          }
        }
      }
      Object localObject2;
      for (;;)
      {
        if (paramBoolean) {
          f.c(paramf);
        }
        if ((paramr == null) || (paramr.size() <= 0)) {
          break label826;
        }
        if (f.h(paramf) != 0L) {
          break label347;
        }
        com.tencent.mm.plugin.finder.feed.model.h.a(f.o(paramf));
        localObject1 = f.o(paramf);
        s.u(paramr, "itemList");
        localObject2 = ((Iterable)paramr).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((com.tencent.mm.plugin.finder.feed.model.h)localObject1).b((t)((Iterator)localObject2).next());
        }
        label192:
        i = paramr.size();
        break;
        if (!f.n(paramf))
        {
          localObject1 = paramf.AUk;
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).getRlLayout();
            if (localObject1 != null) {
              RefreshLoadMoreLayout.e((RefreshLoadMoreLayout)localObject1);
            }
          }
        }
      }
      paramf = paramf.AUk;
      if (paramf != null)
      {
        paramf = paramf.getRlLayout();
        if (paramf != null)
        {
          paramf = paramf.getRecyclerView();
          if (paramf != null)
          {
            paramf = paramf.getAdapter();
            if (paramf != null) {
              paramf.bZE.notifyChanged();
            }
          }
        }
      }
      label315:
      label347:
      do
      {
        paramf = new StringBuilder("[refreshData] Cost=").append(System.currentTimeMillis() - paramLong).append("ms, succ:");
        if (paramr == null) {
          break;
        }
        paramBoolean = true;
        Log.i("Finder.DrawerPresenter", paramBoolean);
        paramg.a(com.tencent.mm.loader.f.i.nrG);
        paramf = kotlin.ah.aiuX;
        AppMethodBeat.o(363429);
        return paramf;
        i = f.o(paramf).data.size();
        f.o(paramf).a(paramr, true, false);
        localObject1 = paramf.AUk;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).getRlLayout();
          if (localObject1 != null)
          {
            localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
            if (localObject1 != null)
            {
              localObject1 = ((RecyclerView)localObject1).getAdapter();
              if (localObject1 != null) {
                ((RecyclerView.a)localObject1).bA(0, f.o(paramf).data.size() - i);
              }
            }
          }
        }
      } while (!paramBoolean);
      localObject1 = (List)f.o(paramf).data;
      int i = 0;
      localObject1 = ((List)localObject1).iterator();
      label464:
      int j;
      label498:
      label503:
      int k;
      if (((Iterator)localObject1).hasNext()) {
        if (((t)((Iterator)localObject1).next()).bZA() == f.h(paramf))
        {
          j = 1;
          if (j == 0) {
            break label749;
          }
          if (i < 0) {
            break label762;
          }
          localObject1 = (t)f.o(paramf).data.get(i);
          localObject2 = paramf.AUk;
          if (localObject2 != null)
          {
            localObject2 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject2).flQ();
            if (localObject2 != null)
            {
              Object localObject3 = av.GiL;
              localObject3 = av.Ud(paramf.scene);
              av localav = av.GiL;
              ((FinderCommentFooter)localObject2).i((String)localObject3, av.ip(((t)localObject1).ECu.getUsername(), ((t)localObject1).ECu.getNickname()), ((t)localObject1).ECu);
            }
          }
          if (((t)localObject1).ECu.field_actionInfo.ABa == 0L) {
            break label1012;
          }
          long l = ((t)localObject1).ECu.field_actionInfo.ABa;
          if (l == 0L) {
            break label779;
          }
          localObject1 = (List)paramf.AUi.data;
          j = 0;
          localObject1 = ((List)localObject1).iterator();
          label658:
          if (!((Iterator)localObject1).hasNext()) {
            break label779;
          }
          if (((t)((Iterator)localObject1).next()).ECu.eZI().commentId != l) {
            break label764;
          }
          k = 1;
          label696:
          if (k == 0) {
            break label770;
          }
          label701:
          if (j < 0) {
            break label1012;
          }
        }
      }
      for (;;)
      {
        paramf = paramf.AUk;
        if (paramf == null)
        {
          paramf = null;
          label717:
          if (!(paramf instanceof LinearLayoutManager)) {
            break label821;
          }
        }
        label770:
        label779:
        label821:
        for (paramf = (LinearLayoutManager)paramf;; paramf = null)
        {
          if (paramf == null) {
            break label824;
          }
          paramf.bo(j, 0);
          break;
          j = 0;
          break label498;
          label749:
          i += 1;
          break label464;
          i = -1;
          break label503;
          label762:
          break;
          label764:
          k = 0;
          break label696;
          j += 1;
          break label658;
          j = -1;
          break label701;
          paramf = paramf.getRlLayout();
          if (paramf == null)
          {
            paramf = null;
            break label717;
          }
          paramf = paramf.getRecyclerView();
          if (paramf == null)
          {
            paramf = null;
            break label717;
          }
          paramf = paramf.getLayoutManager();
          break label717;
        }
        label824:
        break;
        label826:
        Log.i("Finder.DrawerPresenter", "refresh header title...");
        paramf.ebV();
        if (!paramBoolean) {
          break;
        }
        com.tencent.mm.plugin.finder.feed.model.h.a(f.o(paramf));
        localObject1 = paramf.AUk;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).getRlLayout();
          if (localObject1 != null)
          {
            localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
            if (localObject1 != null)
            {
              localObject1 = ((RecyclerView)localObject1).getAdapter();
              if (localObject1 != null) {
                ((RecyclerView.a)localObject1).bZE.notifyChanged();
              }
            }
          }
        }
        if (bool)
        {
          paramf = paramf.AUk;
          if (paramf == null) {
            break;
          }
          paramf.getLoadingLayout().setVisibility(0);
          paramf.getLoadingView().setVisibility(8);
          if (paramf.flR().getCloseComment()) {
            paramf.fdw().setVisibility(8);
          }
          for (;;)
          {
            paramf.fdx().setVisibility(8);
            break;
            paramf.fdw().setVisibility(0);
          }
        }
        localObject1 = paramf.AUk;
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.plugin.finder.view.builder.b)localObject1).bv((kotlin.g.a.a)new b(paramf));
        break;
        paramBoolean = false;
        break label315;
        label1012:
        j = i;
      }
    }
    
    private static final kotlin.r a(f paramf, boolean paramBoolean, ah.f paramf1, ah.f paramf2, com.tencent.mm.am.b.a parama)
    {
      AppMethodBeat.i(363418);
      s.u(paramf, "this$0");
      s.u(paramf1, "$localLevel2Comments");
      s.u(paramf2, "$localComments");
      if (parama == null)
      {
        Log.e("Finder.DrawerPresenter", "refreshData resp null");
        paramf = new kotlin.r(Boolean.FALSE, null);
        AppMethodBeat.o(363418);
        return paramf;
      }
      if ((parama.errType == 0) && (parama.errCode == 0) && (parama.ott != null))
      {
        f.a(paramf, ((ayl)parama.ott).lastBuffer);
        Object localObject2 = new StringBuilder("refreshData oldVersion:").append(f.f(paramf)).append(", lastBuffer ");
        label171:
        label193:
        Object localObject3;
        Object localObject4;
        if (f.j(paramf) == null)
        {
          localObject1 = "null";
          Log.i("Finder.DrawerPresenter", localObject1);
          if (!paramBoolean) {
            break label520;
          }
          if (((ayl)parama.ott).ZJm != 1) {
            break label510;
          }
          paramBoolean = true;
          f.a(paramf, paramBoolean);
          if (((ayl)parama.ott).upContinueFlag != 1) {
            break label515;
          }
          paramBoolean = true;
          f.b(paramf, paramBoolean);
          i = ((ayl)parama.ott).commentCount;
          localObject2 = f.i(paramf);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("feedObj");
            localObject1 = null;
          }
          ((FinderItem)localObject1).setCommentCount(i);
          Log.i("Finder.DrawerPresenter", "first fetch, svrCount:" + i + ", oldVersion:" + f.f(paramf));
          localObject3 = (List)new ArrayList();
          localObject1 = ((ayl)parama.ott).ZJl;
          s.s(localObject1, "it.resp.commentInfo");
          localObject1 = (Iterable)localObject1;
          localObject4 = (Collection)localObject3;
          Iterator localIterator = ((Iterable)localObject1).iterator();
          label334:
          if (!localIterator.hasNext()) {
            break label555;
          }
          FinderCommentInfo localFinderCommentInfo = (FinderCommentInfo)localIterator.next();
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.a.FNx;
          s.s(localFinderCommentInfo, "commentInfo");
          localObject2 = f.i(paramf);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("feedObj");
            localObject1 = null;
          }
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.a.a(localFinderCommentInfo, ((FinderItem)localObject1).getId());
          if ((!f.k(paramf)) || (((t)localObject1).bZA() != f.h(paramf)) || (f.h(paramf) == 0L)) {
            break label550;
          }
        }
        label515:
        label520:
        label550:
        for (paramBoolean = true;; paramBoolean = false)
        {
          ((t)localObject1).ECz = paramBoolean;
          ((t)localObject1).AUr = f.l(paramf);
          if (((t)localObject1).ECz) {
            f.m(paramf);
          }
          ((Collection)localObject4).add(localObject1);
          break label334;
          localObject1 = f.j(paramf);
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((com.tencent.mm.bx.b)localObject1).toByteArray())
          {
            localObject1 = MD5Util.getMD5String((byte[])localObject1);
            break;
          }
          label510:
          paramBoolean = false;
          break label171;
          paramBoolean = false;
          break label193;
          if (((ayl)parama.ott).upContinueFlag == 1) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            f.b(paramf, paramBoolean);
            break;
          }
        }
        label555:
        f.a(paramf, (List)localObject3);
        int i = ((List)localObject3).size();
        f.a(paramf, (List)paramf1.aqH, (List)localObject3);
        int j = ((List)localObject3).size() - i;
        Object localObject1 = f.b(paramf, (List)localObject3);
        int k = ((List)localObject1).size();
        paramf2 = ((Iterable)paramf2.aqH).iterator();
        label657:
        label791:
        label796:
        while (paramf2.hasNext())
        {
          localObject2 = (au)paramf2.next();
          localObject3 = ((Iterable)localObject1).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            paramf1 = ((Iterator)localObject3).next();
            localObject4 = (t)paramf1;
            if ((((t)localObject4).ECu.eZM() != null) && (s.p(((t)localObject4).ECu.eZM(), ((au)localObject2).eZM())))
            {
              i = 1;
              label714:
              if (i == 0) {
                break label791;
              }
            }
          }
          for (;;)
          {
            if ((t)paramf1 != null) {
              break label796;
            }
            Log.i("Finder.DrawerPresenter", s.X("merge local item: ", ((au)localObject2).eZM()));
            paramf1 = new t((au)localObject2);
            paramf1.ECw = com.tencent.mm.pluginsdk.ui.span.p.b(MMApplicationContext.getContext(), (CharSequence)((au)localObject2).getContent());
            localObject2 = kotlin.ah.aiuX;
            ((List)localObject1).add(paramf1);
            break;
            i = 0;
            break label714;
            break label657;
            paramf1 = null;
          }
        }
        i = ((List)localObject1).size() - k;
        Log.i("Finder.DrawerPresenter", "merge respCount:" + ((ayl)parama.ott).commentCount + ", preSize: " + ((ayl)parama.ott).ZJl.size() + ", afterSize:" + ((List)localObject1).size() + ", diffsize1:" + j + ", diffSize2:" + i);
        paramf1 = f.i(paramf);
        paramf = paramf1;
        if (paramf1 == null)
        {
          s.bIx("feedObj");
          paramf = null;
        }
        paramf.setCommentCount(i + j + paramf.getCommentCount());
        paramf = new kotlin.r(Boolean.TRUE, localObject1);
        AppMethodBeat.o(363418);
        return paramf;
      }
      if ((parama.errCode == -4014) || (parama.errCode == -4032))
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(paramf));
        paramf = new kotlin.r(Boolean.TRUE, null);
        AppMethodBeat.o(363418);
        return paramf;
      }
      paramf1 = aw.Gjk;
      if (aw.iv(parama.errType, parama.errCode))
      {
        f.a(paramf, false);
        f.b(paramf, false);
        paramf = new kotlin.r(Boolean.TRUE, null);
        AppMethodBeat.o(363418);
        return paramf;
      }
      paramf = new kotlin.r(Boolean.FALSE, null);
      AppMethodBeat.o(363418);
      return paramf;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<kotlin.ah>
    {
      a(f paramf)
      {
        super();
      }
      
      private static final void k(boolean paramBoolean, String paramString) {}
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.g.b.u
      implements kotlin.g.a.a<kotlin.ah>
    {
      b(f paramf)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.f
 * JD-Core Version:    0.7.0.1
 */