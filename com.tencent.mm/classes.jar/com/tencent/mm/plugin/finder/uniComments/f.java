package com.tencent.mm.plugin.finder.uniComments;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.c;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.autogen.a.abj;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.uniComments.model.a.c;
import com.tencent.mm.plugin.finder.uniComments.report.a.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.view.FinderCommentEditText;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.atd;
import com.tencent.mm.protocal.protobuf.byd;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.i.d;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawerPresenter;", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawerContract$NPresenter;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentFooter$IModeChangeCallback;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "authorMentioned", "", "getAuthorMentioned", "()Z", "setAuthorMentioned", "(Z)V", "blinkRefComment", "canPreload", "getCanPreload", "setCanPreload", "commentChangeEventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/UniCommentChangeEvent;", "getCommentChangeEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "commentClose", "getCommentClose", "setCommentClose", "commentCount", "", "getCommentCount", "()I", "setCommentCount", "(I)V", "commentDataObserver", "com/tencent/mm/plugin/finder/uniComments/UniCommentDrawerPresenter$commentDataObserver$1", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawerPresenter$commentDataObserver$1;", "getContext", "()Landroid/content/Context;", "dataLoader", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentLoader;", "diffDataChangeHelper", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawerPresenter$DiffDataChangeHelper;", "value", "downContinue", "setDownContinue", "drawer", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawer;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawer;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawer;)V", "enterTimeMs", "", "getEnterTimeMs", "()J", "setEnterTimeMs", "(J)V", "exposeScene", "getExposeScene", "setExposeScene", "feedObj", "Lcom/tencent/mm/plugin/finder/uniComments/model/UniEntityItem;", "hasExpandComment", "getHasExpandComment", "setHasExpandComment", "hitCache", "isDetached", "setDetached", "isOnlyShowDesc", "isSingleMode", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawerContract$CloseDrawerCallback;", "refCommentId", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "safeMode", "getSafeMode", "setSafeMode", "scene", "getScene", "setScene", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "getTaskExecutor", "()Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "setTaskExecutor", "(Lcom/tencent/mm/loader/loader/SingleTaskExecutor;)V", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "upContinue", "setUpContinue", "useCache", "viewCallback", "Lcom/tencent/mm/plugin/finder/uniComments/UniTimelineDrawerBuilder;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/uniComments/UniTimelineDrawerBuilder;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/uniComments/UniTimelineDrawerBuilder;)V", "calculateCommentCount", "canExpand", "comment", "Lcom/tencent/mm/plugin/finder/uniComments/storge/UniFeedComment;", "down", "checkDownContinue", "", "checkUpContinue", "deleteComment", "item", "expandLevel2Comments", "rootComment", "expandTopLevel2Comment", "", "respList", "expandWhenRefToLevel2Comment", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getCommentScene", "getCurrentFeed", "getEditText", "Lcom/tencent/mm/plugin/finder/view/FinderCommentEditText;", "getEditTextAvatar", "Landroid/widget/ImageView;", "getFirstFriendPos", "getFirstOtherPos", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getRootComment", "rootId", "getRootCommentIndex", "getUserScene", "insertLevel2CommentsAndNotify", "level2Comments", "", "isCommentClose", "isSafeMode", "isWxScene", "keep", "p0", "loadMoreData", "loadMoreLevel2Comments", "mergeLocalLevel2Comments", "localLevel2Comments", "Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;", "onAttach", "builder", "displayScene", "replyCommentObj", "oldVer", "callback", "onClickComment", "view", "Landroid/view/View;", "onClickCommentDelete", "onClickMore", "onClickResendComment", "position", "onDetach", "onExpandClick", "onItemClick", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "holder", "onItemLongClick", "onLikeComment", "onModeChange", "from", "to", "onRecoverRecyclerViewTrans", "onReply", "sceneForReply", "mentionContactList", "Lcom/tencent/mm/plugin/finder/uniComments/MentionContact;", "onScrollIdle", "lastVisiblePosition", "preloadNextPage", "refreshData", "setCommentCountView", "transToDiscoverComment", "Companion", "DiffDataChangeHelper", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements UniCommentFooter.b, e.b, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>, i.c<j>, i.d<j>
{
  public static final a FYQ;
  private long AAW;
  private com.tencent.mm.loader.f.h ADY;
  private boolean AHQ;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> ATq;
  int AUh;
  private boolean AUn;
  private boolean AUo;
  private boolean AUp;
  private boolean AUq;
  private boolean AUs;
  private boolean AUt;
  boolean AUu;
  private final IListener<abj> AUx;
  private UniCommentDrawer FYA;
  private e.a FYE;
  private com.tencent.mm.plugin.finder.uniComments.model.b FYH;
  final g FYR;
  i FYS;
  private b FYT;
  private final c FYU;
  private volatile boolean bRv;
  final Context context;
  private boolean igs;
  private volatile com.tencent.mm.bx.b lastBuffer;
  private boolean plm;
  boolean safeMode;
  int scene;
  Dialog tipDialog;
  private long zIz;
  
  static
  {
    AppMethodBeat.i(341847);
    FYQ = new a((byte)0);
    AppMethodBeat.o(341847);
  }
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(341486);
    this.context = paramContext;
    this.AUh = 58;
    this.FYR = new g();
    this.ATq = new CopyOnWriteArraySet();
    this.scene = 2;
    this.AUp = true;
    this.igs = true;
    this.bRv = true;
    this.AUx = ((IListener)new UniCommentDrawerPresenter.commentChangeEventListener.1(this, com.tencent.mm.app.f.hfK));
    this.FYU = new c(this);
    AppMethodBeat.o(341486);
  }
  
  private final void A(int paramInt, List<a> paramList)
  {
    AppMethodBeat.i(341560);
    Object localObject1 = getEditText();
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label109;
      }
      i = 1;
      label44:
      if (i != 0) {
        break label731;
      }
      if (this.FYH == null) {
        s.bIx("feedObj");
      }
      localObject2 = n.bq((CharSequence)localObject1);
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label114;
      }
    }
    label109:
    label114:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label119;
      }
      AppMethodBeat.o(341560);
      return;
      localObject1 = ((FinderCommentEditText)localObject1).getText();
      break;
      i = 0;
      break label44;
    }
    label119:
    Object localObject2 = av.GiL;
    String str1 = av.aBP(localObject1.toString());
    Object localObject3 = getEditText();
    if (localObject3 == null) {}
    Object localObject4;
    for (localObject2 = null; localObject2 != null; localObject2 = ((FinderCommentEditText)localObject3).ra(((com.tencent.mm.plugin.finder.uniComments.model.b)localObject1).id))
    {
      localObject1 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (String)((Iterator)localObject1).next();
        localObject4 = av.GiL;
        av.aBP((String)localObject3);
      }
      localObject2 = this.FYH;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("feedObj");
        localObject1 = null;
      }
    }
    localObject1 = getEditText();
    long l1;
    Object localObject5;
    long l2;
    Object localObject6;
    String str2;
    String str3;
    String str4;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label809;
      }
      localObject1 = com.tencent.mm.plugin.finder.uniComments.action.b.Gaf;
      localObject4 = com.tencent.mm.plugin.finder.uniComments.action.b.fdy();
      l1 = cn.bDv();
      localObject3 = this.FYH;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("feedObj");
        localObject1 = null;
      }
      localObject5 = ((com.tencent.mm.plugin.finder.uniComments.model.b)localObject1).userName;
      localObject3 = this.FYH;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("feedObj");
        localObject1 = null;
      }
      l2 = ((com.tencent.mm.plugin.finder.uniComments.model.b)localObject1).id;
      localObject3 = this.FYH;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("feedObj");
        localObject1 = null;
      }
      localObject6 = ((com.tencent.mm.plugin.finder.uniComments.model.b)localObject1).objectNonceId;
      localObject3 = this.FYH;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("feedObj");
        localObject1 = null;
      }
      str2 = ((com.tencent.mm.plugin.finder.uniComments.model.b)localObject1).userName;
      localObject1 = av.GiL;
      str3 = av.Ue(paramInt);
      localObject1 = av.GiL;
      str4 = av.Ud(paramInt);
      localObject1 = this.FYA;
      if (localObject1 != null) {
        break label800;
      }
      i = 0;
      label435:
      localObject3 = this.FYH;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("feedObj");
        localObject1 = null;
      }
      s.u(localObject5, "feedUsername");
      s.u(localObject6, "objectNonceId");
      s.u(str2, "replyUsername");
      s.u(str3, "username");
      s.u(str4, "nickname");
      s.u(paramList, "mentionList");
      s.u(localObject1, "uniEntityItem");
      ((com.tencent.mm.plugin.finder.uniComments.action.b)localObject4).Gah = ((com.tencent.mm.plugin.finder.uniComments.model.b)localObject1);
      com.tencent.mm.plugin.finder.uniComments.action.b.a((com.tencent.mm.plugin.finder.uniComments.action.b)localObject4, l1, (String)localObject5, l2, (String)localObject6, str1, str2, "", str3, str4, paramInt, i, paramList, (LinkedList)localObject2, (com.tencent.mm.plugin.finder.uniComments.model.b)localObject1);
      paramList = this.FYS;
      if (paramList != null)
      {
        paramList = paramList.getRlLayout();
        if (paramList != null)
        {
          paramList = paramList.getRecyclerView();
          if (paramList != null)
          {
            localObject1 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(paramList, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/finder/uniComments/UniCommentDrawerPresenter", "onReply", "(ILjava/util/List;)V", "Undefined", "scrollToPosition", "(I)V");
            paramList.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(paramList, "com/tencent/mm/plugin/finder/uniComments/UniCommentDrawerPresenter", "onReply", "(ILjava/util/List;)V", "Undefined", "scrollToPosition", "(I)V");
          }
        }
      }
      paramList = this.FYS;
      if (paramList != null)
      {
        paramList = paramList.getRlLayout();
        if (paramList != null) {
          paramList.ci((kotlin.g.a.a)f.o.FZb);
        }
      }
      paramList = this.FYS;
      if (paramList != null)
      {
        paramList = paramList.fdu();
        if (paramList != null)
        {
          if (paramList.FZu != 1) {
            break label1226;
          }
          paramList.ur(true);
        }
      }
      label717:
      paramList = getEditText();
      if (paramList != null) {
        paramList.setText(null);
      }
      label731:
      if (!this.plm) {
        break label1247;
      }
      paramList = this.FYS;
      if (paramList != null)
      {
        paramList = paramList.fdv();
        if (paramList != null) {
          paramList.fdh();
        }
      }
      paramList = this.FYA;
      if ((paramList == null) || (paramList.getReason() != 1)) {
        break label1242;
      }
    }
    label800:
    label809:
    label1226:
    label1242:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label1283;
      }
      AppMethodBeat.o(341560);
      return;
      localObject1 = ((FinderCommentEditText)localObject1).getTag();
      break;
      i = ((UniCommentDrawer)localObject1).getReason();
      break label435;
      localObject1 = getEditText();
      if (localObject1 == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = ((FinderCommentEditText)localObject1).getTag())
      {
        paramList = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.uniComments.storge.LocalUniCommentObject");
        AppMethodBeat.o(341560);
        throw paramList;
      }
      localObject5 = (com.tencent.mm.plugin.finder.uniComments.storge.b)localObject1;
      if (((com.tencent.mm.plugin.finder.uniComments.storge.b)localObject5).field_actionInfo.ABa == 0L) {
        localObject1 = ((com.tencent.mm.plugin.finder.uniComments.storge.b)localObject5).eZI();
      }
      while (localObject1 == null)
      {
        AppMethodBeat.o(341560);
        return;
        localObject1 = qx(((com.tencent.mm.plugin.finder.uniComments.storge.b)localObject5).field_actionInfo.ABa);
        if (localObject1 == null)
        {
          localObject1 = null;
        }
        else
        {
          localObject1 = ((com.tencent.mm.plugin.finder.uniComments.storge.d)localObject1).Gbp;
          if (localObject1 == null) {
            localObject1 = null;
          } else {
            localObject1 = ((com.tencent.mm.plugin.finder.uniComments.storge.b)localObject1).eZI();
          }
        }
      }
      ((FinderCommentInfo)localObject1).expandCommentCount += 1;
      localObject3 = com.tencent.mm.plugin.finder.uniComments.action.b.Gaf;
      localObject6 = com.tencent.mm.plugin.finder.uniComments.action.b.fdy();
      l1 = cn.bDv();
      localObject4 = this.FYH;
      localObject3 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("feedObj");
        localObject3 = null;
      }
      str2 = ((com.tencent.mm.plugin.finder.uniComments.model.b)localObject3).userName;
      localObject4 = this.FYH;
      localObject3 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("feedObj");
        localObject3 = null;
      }
      l2 = ((com.tencent.mm.plugin.finder.uniComments.model.b)localObject3).id;
      localObject4 = this.FYH;
      localObject3 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("feedObj");
        localObject3 = null;
      }
      str3 = ((com.tencent.mm.plugin.finder.uniComments.model.b)localObject3).objectNonceId;
      str4 = ((com.tencent.mm.plugin.finder.uniComments.storge.b)localObject5).getUsername();
      String str5 = ((com.tencent.mm.plugin.finder.uniComments.storge.b)localObject5).getNickname();
      long l3 = ((com.tencent.mm.plugin.finder.uniComments.storge.b)localObject5).eZI().commentId;
      String str6 = ((com.tencent.mm.plugin.finder.uniComments.storge.b)localObject5).getContent();
      localObject3 = av.GiL;
      String str7 = av.Ue(paramInt);
      localObject3 = av.GiL;
      String str8 = av.Ud(paramInt);
      boolean bool = ((com.tencent.mm.plugin.finder.uniComments.storge.b)localObject5).eZQ();
      localObject3 = this.FYA;
      if (localObject3 == null) {}
      for (i = 0;; i = ((UniCommentDrawer)localObject3).getReason())
      {
        localObject4 = this.FYH;
        localObject3 = localObject4;
        if (localObject4 == null)
        {
          s.bIx("feedObj");
          localObject3 = null;
        }
        ((com.tencent.mm.plugin.finder.uniComments.action.b)localObject6).a(l1, str2, l2, str3, str1, str4, str5, Long.valueOf(l3), str6, str7, str8, paramInt, bool, (FinderCommentInfo)localObject1, i, paramList, (LinkedList)localObject2, (com.tencent.mm.plugin.finder.uniComments.model.b)localObject3);
        this.AUu = true;
        break;
      }
      if (paramList.FZu != 2) {
        break label717;
      }
      paramList.dP(false);
      break label717;
    }
    label1247:
    paramList = this.FYS;
    if (paramList != null)
    {
      paramList.fdw().setVisibility(8);
      paramList.fdx().setVisibility(8);
      paramList.getLoadingLayout().setVisibility(8);
    }
    label1283:
    AppMethodBeat.o(341560);
  }
  
  private static final void a(int paramInt, f paramf)
  {
    Object localObject1 = null;
    AppMethodBeat.i(341610);
    s.u(paramf, "this$0");
    if ((paramInt > 0) && (paramInt < paramf.FYR.data.size()))
    {
      paramf = paramf.FYS;
      if (paramf == null) {
        paramf = localObject1;
      }
      while (paramf == null)
      {
        paramf = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(341610);
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
    AppMethodBeat.o(341610);
  }
  
  private static final void a(f paramf, i parami, View paramView)
  {
    AppMethodBeat.i(341603);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramf);
    localb.cH(parami);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/UniCommentDrawerPresenter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramf, "this$0");
    s.u(parami, "$builder");
    paramf.A(parami.fdu().getScene(), parami.fdu().getMentionListWhenReply());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/UniCommentDrawerPresenter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(341603);
  }
  
  private static final void a(f paramf, final com.tencent.mm.plugin.finder.uniComments.storge.d paramd, final Context paramContext, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(341639);
    s.u(paramf, "this$0");
    s.u(paramd, "$item");
    s.u(paramContext, "$context");
    paramDialogInterface = paramf.tipDialog;
    if (paramDialogInterface == null) {}
    for (paramDialogInterface = null;; paramDialogInterface = ah.aiuX)
    {
      if (paramDialogInterface == null)
      {
        paramContext.getString(e.h.app_tip);
        paramf.tipDialog = ((Dialog)k.a(paramContext, paramContext.getString(e.h.app_waiting), false, f..ExternalSyntheticLambda0.INSTANCE));
      }
      paramf = (kotlin.g.a.a)new d(paramf, paramd, (kotlin.g.a.a)new f(paramf, paramd, paramContext), (kotlin.g.a.a)new e(paramf, paramContext));
      if ((paramd.Gbp.eZO()) || (paramd.Gbp.field_localCommentId == 0L)) {
        paramf.invoke();
      }
      AppMethodBeat.o(341639);
      return;
      paramDialogInterface.show();
    }
  }
  
  private static final void a(FinderCommentEditText paramFinderCommentEditText, f paramf)
  {
    AppMethodBeat.i(341619);
    s.u(paramFinderCommentEditText, "$this_apply");
    s.u(paramf, "this$0");
    paramFinderCommentEditText.requestFocus();
    if ((!paramf.safeMode) && (!paramf.AUt))
    {
      paramFinderCommentEditText = paramf.FYS;
      if (paramFinderCommentEditText != null)
      {
        paramFinderCommentEditText = paramFinderCommentEditText.fdu();
        if (paramFinderCommentEditText != null) {
          paramFinderCommentEditText.dP(true);
        }
      }
    }
    AppMethodBeat.o(341619);
  }
  
  private final ImageView ebU()
  {
    AppMethodBeat.i(341574);
    Object localObject = this.FYS;
    if (localObject == null)
    {
      AppMethodBeat.o(341574);
      return null;
    }
    localObject = ((i)localObject).fdu();
    if (localObject == null)
    {
      AppMethodBeat.o(341574);
      return null;
    }
    localObject = ((UniCommentFooter)localObject).getAvatarView();
    AppMethodBeat.o(341574);
    return localObject;
  }
  
  private int getCommentCount()
  {
    Object localObject2 = null;
    AppMethodBeat.i(341523);
    StringBuilder localStringBuilder = new StringBuilder("calculateCommentCount ").append(this.FYR.data.size()).append(", ");
    com.tencent.mm.plugin.finder.uniComments.model.b localb = this.FYH;
    Object localObject1 = localb;
    if (localb == null)
    {
      s.bIx("feedObj");
      localObject1 = null;
    }
    Log.i("MicroMsg.MusicUni.DrawerPresenter", ((com.tencent.mm.plugin.finder.uniComments.model.b)localObject1).commentCount);
    int i = this.FYR.data.size();
    localObject1 = this.FYH;
    if (localObject1 == null)
    {
      s.bIx("feedObj");
      localObject1 = localObject2;
    }
    for (;;)
    {
      i = Math.max(i + 0, ((com.tencent.mm.plugin.finder.uniComments.model.b)localObject1).commentCount);
      AppMethodBeat.o(341523);
      return i;
    }
  }
  
  private final FinderCommentEditText getEditText()
  {
    AppMethodBeat.i(341566);
    Object localObject = this.FYS;
    if (localObject == null)
    {
      AppMethodBeat.o(341566);
      return null;
    }
    localObject = ((i)localObject).fdu();
    if (localObject == null)
    {
      AppMethodBeat.o(341566);
      return null;
    }
    localObject = ((UniCommentFooter)localObject).getEditText();
    AppMethodBeat.o(341566);
    return localObject;
  }
  
  private final Resources getResources()
  {
    AppMethodBeat.i(341580);
    Object localObject = this.FYS;
    if (localObject == null)
    {
      AppMethodBeat.o(341580);
      return null;
    }
    localObject = ((i)localObject).getContext();
    if (localObject == null)
    {
      AppMethodBeat.o(341580);
      return null;
    }
    localObject = ((Context)localObject).getResources();
    AppMethodBeat.o(341580);
    return localObject;
  }
  
  private final void pS(boolean paramBoolean)
  {
    AppMethodBeat.i(341493);
    this.AUo = paramBoolean;
    Log.i("MicroMsg.MusicUni.DrawerPresenter", s.X("set upContinue ", Boolean.valueOf(paramBoolean)));
    AppMethodBeat.o(341493);
  }
  
  private final void pT(boolean paramBoolean)
  {
    AppMethodBeat.i(341508);
    this.AUp = paramBoolean;
    Log.i("MicroMsg.MusicUni.DrawerPresenter", s.X("set downContinue ", Boolean.valueOf(paramBoolean)));
    AppMethodBeat.o(341508);
  }
  
  private final void pU(boolean paramBoolean)
  {
    AppMethodBeat.i(341590);
    if (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu())
    {
      Log.i("MicroMsg.MusicUni.DrawerPresenter", "refreshData " + paramBoolean + " return for teen mode");
      AppMethodBeat.o(341590);
      return;
    }
    com.tencent.mm.loader.f.h localh = this.ADY;
    if (localh != null) {
      localh.a(new com.tencent.mm.loader.f.g((kotlin.g.a.b)new p(paramBoolean, this)));
    }
    AppMethodBeat.o(341590);
  }
  
  private static final void t(DialogInterface paramDialogInterface) {}
  
  public final void NE(int paramInt)
  {
    AppMethodBeat.i(342155);
    Object localObject = this.FYR.data;
    Log.i("MicroMsg.MusicUni.DrawerPresenter", "preloadNextPage, onScrollIdle, lastVisiblePosition:" + paramInt + ", dataList size:" + ((ArrayList)localObject).size() + ", canPreload:" + this.AUs);
    if ((paramInt >= 0) && (paramInt < ((ArrayList)localObject).size()))
    {
      ((ArrayList)localObject).size();
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      com.tencent.mm.plugin.finder.storage.d.eRw();
    }
    AppMethodBeat.o(342155);
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.finder.uniComments.storge.d paramd)
  {
    AppMethodBeat.i(342057);
    s.u(paramView, "view");
    s.u(paramd, "item");
    com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f(paramView.getContext(), 1, false);
    com.tencent.mm.plugin.finder.uniComments.model.b localb = this.FYH;
    paramView = localb;
    if (localb == null)
    {
      s.bIx("feedObj");
      paramView = null;
    }
    localf.Vtg = ((u.g)new h.a(paramd, paramView.userName));
    localf.GAC = ((u.i)new h.d(paramd, this.AUh, (kotlin.g.a.b)new m(this)));
    localf.dDn();
    AppMethodBeat.o(342057);
  }
  
  public final void a(UniCommentDrawer paramUniCommentDrawer, i parami, com.tencent.mm.plugin.finder.uniComments.model.b paramb, e.a parama, int paramInt, boolean paramBoolean1, long paramLong, com.tencent.mm.plugin.finder.uniComments.storge.b paramb1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    AppMethodBeat.i(341957);
    s.u(paramUniCommentDrawer, "drawer");
    s.u(parami, "builder");
    s.u(paramb, "feedObj");
    this.bRv = false;
    this.zIz = System.currentTimeMillis();
    this.FYS = parami;
    this.FYA = paramUniCommentDrawer;
    this.FYH = paramb;
    this.plm = paramBoolean1;
    this.scene = paramInt;
    this.FYE = parama;
    this.AAW = paramLong;
    this.igs = paramBoolean2;
    this.AUq = paramBoolean3;
    this.ADY = new com.tencent.mm.loader.f.h("UniCommentExecutor");
    parama = this.ADY;
    if (parama != null)
    {
      parama.start();
      parama = ah.aiuX;
    }
    parama = this.FYR;
    Object localObject1 = this.context;
    long l = paramb.id;
    parami.FZO.getCommentScene();
    s.u(localObject1, "context");
    s.u(paramb, "feedObj");
    parama.Bfc = l;
    parama.Bfd = paramLong;
    if (parama.data.size() > 0) {
      parama.data.clear();
    }
    paramBoolean2 = true;
    if (paramLong == 0L) {
      paramBoolean2 = false;
    }
    Log.i(parama.TAG, "miss cache, upContinue:" + paramBoolean2 + ", downContinue:true");
    localObject1 = new kotlin.r(new c.a(paramBoolean2), Boolean.FALSE);
    parama = (c.a)((kotlin.r)localObject1).bsC;
    paramBoolean3 = ((Boolean)((kotlin.r)localObject1).bsD).booleanValue();
    int k = parama.pos;
    localObject1 = parama.lastBuffer;
    paramBoolean2 = parama.AUo;
    boolean bool1 = parama.AUp;
    boolean bool2 = parama.FMX;
    this.lastBuffer = ((com.tencent.mm.bx.b)localObject1);
    this.AUn = paramBoolean3;
    pS(paramBoolean2);
    pT(bool1);
    this.AUs = true;
    this.AUt = paramBoolean4;
    this.AUu = bool2;
    this.AHQ = paramBoolean5;
    if ((this.AUo) && (!((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()))
    {
      parami.us(true);
      parami.fdu().setFooterMode(0);
      if (paramLong != 0L) {
        break label924;
      }
      parama = this.FYS;
      if (parama != null)
      {
        parama = parama.fdu();
        if (parama != null)
        {
          localObject1 = av.GiL;
          parama.ij(av.Ud(this.scene), paramb.nickName);
          parama = ah.aiuX;
        }
      }
      label466:
      if (!paramBoolean5) {
        break label1143;
      }
      parami.getRlLayout().setEnableLoadMore(false);
      parama = parami.getRlLayout();
    }
    label924:
    label948:
    label986:
    label1128:
    label1771:
    for (;;)
    {
      paramBoolean2 = false;
      parama.setEnableRefresh(paramBoolean2);
      parami.getRlLayout().getRecyclerView().setLayoutFrozen(false);
      this.FYT = new b(parami.getRlLayout().getRecyclerView());
      this.AUx.alive();
      try
      {
        parama = parami.getRlLayout().getRecyclerView().getAdapter();
        if (parama != null)
        {
          parama.a((RecyclerView.c)this.FYU);
          parama = ah.aiuX;
        }
      }
      catch (IllegalStateException parama)
      {
        for (;;)
        {
          Object localObject2;
          int i;
          int j;
          label1141:
          label1143:
          Log.printErrStackTrace("MicroMsg.MusicUni.DrawerPresenter", (Throwable)parama, "", new Object[0]);
          continue;
          parama = parama.fdt();
          continue;
          localObject1 = ((Resources)localObject1).getString(e.h.finder_gallery_desc);
          continue;
          if (getCommentCount() <= 0)
          {
            parami.fdt().setText((CharSequence)parami.getContext().getResources().getString(e.h.finder_comment));
          }
          else
          {
            parami.fdt().setText((CharSequence)parami.getContext().getResources().getString(e.h.finder_comment_count_tip, new Object[] { com.tencent.mm.plugin.finder.utils.r.ip(this.scene, getCommentCount()) }));
            continue;
            parama = com.tencent.mm.plugin.finder.api.d.AwY;
            parama = d.a.auT(z.bAW());
            if (parama == null) {
              parama = "";
            }
            for (;;)
            {
              paramb1 = com.tencent.mm.plugin.finder.loader.p.ExI;
              paramb1 = com.tencent.mm.plugin.finder.loader.p.eCp();
              parama = new com.tencent.mm.plugin.finder.loader.b(parama);
              localObject1 = ebU();
              s.checkNotNull(localObject1);
              localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
              paramb1.a(parama, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
              break;
              paramb1 = parama.amx();
              parama = paramb1;
              if (paramb1 == null) {
                parama = "";
              }
            }
            paramUniCommentDrawer = paramUniCommentDrawer.fdu();
            continue;
            if (!paramBoolean1)
            {
              if (!paramBoolean3)
              {
                pU(true);
                parama = this.FYS;
                if (parama != null)
                {
                  parama.showLoading();
                  parama = ah.aiuX;
                }
                parama = com.tencent.mm.plugin.finder.storage.d.FAy;
                if (((Number)com.tencent.mm.plugin.finder.storage.d.eRX().bmg()).intValue() != 1) {
                  break label1758;
                }
                parami.fdv().setBackgroundColorRes(com.tencent.mm.plugin.finder.e.b.transparent);
              }
              for (;;)
              {
                parami.fdv().setSquaresBackgroundResource(e.d.finder_bottom_corner_shape);
                parami.getRlLayout().setVisibility(0);
                parami.getHeaderLayout().setVisibility(0);
                if (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()) {
                  break label1771;
                }
                if ((paramb.commentCount != 0) || (paramUniCommentDrawer.getReason() == 4)) {
                  break;
                }
                paramUniCommentDrawer = getEditText();
                if (paramUniCommentDrawer == null) {
                  break;
                }
                paramUniCommentDrawer.postDelayed(new f..ExternalSyntheticLambda4(paramUniCommentDrawer, this), 200L);
                paramUniCommentDrawer = ah.aiuX;
                break;
                if ((paramBoolean3) && (k == 0) && (paramLong == 0L) && (!this.AUu))
                {
                  this.lastBuffer = null;
                  pT(true);
                  pU(true);
                  break label1480;
                }
                parama = this.FYS;
                if (parama != null)
                {
                  parama = parama.getRlLayout();
                  if (parama != null)
                  {
                    parama = parama.getRecyclerView();
                    if (parama != null)
                    {
                      parama = parama.getAdapter();
                      if (parama != null)
                      {
                        parama.bZE.notifyChanged();
                        parama = ah.aiuX;
                      }
                    }
                  }
                }
                parama = this.FYS;
                if (parama == null) {
                  break label1480;
                }
                parama = parama.getRlLayout();
                if (parama == null) {
                  break label1480;
                }
                parama = parama.getRecyclerView();
                if (parama == null) {
                  break label1480;
                }
                parama.post(new f..ExternalSyntheticLambda3(k, this));
                break label1480;
                parami.fdv().setBackgroundColorRes(com.tencent.mm.plugin.finder.e.b.UN_BW_0_Alpha_0_5);
              }
              paramUniCommentDrawer = this.FYS;
              if (paramUniCommentDrawer == null) {}
              for (paramUniCommentDrawer = null; paramUniCommentDrawer != null; paramUniCommentDrawer = paramUniCommentDrawer.fdu())
              {
                paramUniCommentDrawer.setVisibility(8);
                break;
              }
            }
            parami.fdv().setSquaresBackgroundResource(com.tencent.mm.plugin.finder.e.b.transparent);
            parami.fdv().setBackgroundColorRes(com.tencent.mm.plugin.finder.e.b.transparent);
            parami.getHeaderLayout().setVisibility(8);
            parami.getRlLayout().setVisibility(8);
            paramUniCommentDrawer = getEditText();
            if (paramUniCommentDrawer != null) {
              paramUniCommentDrawer.requestFocus();
            }
            if (!this.safeMode)
            {
              paramUniCommentDrawer = this.FYS;
              if (paramUniCommentDrawer != null)
              {
                paramUniCommentDrawer = paramUniCommentDrawer.fdu();
                if (paramUniCommentDrawer != null)
                {
                  paramUniCommentDrawer.dP(true);
                  paramUniCommentDrawer = ah.aiuX;
                }
              }
            }
          }
        }
      }
      parami.getRlLayout().setActionCallback((RefreshLoadMoreLayout.b)new l(this));
      parami.fdu().setModeChangeCallback((UniCommentFooter.b)this);
      parama = parami.fdu();
      l = paramb.id;
      parama.getEditText().feedId = l;
      if (paramBoolean5)
      {
        parama = this.FYS;
        if (parama == null)
        {
          parama = null;
          if (parama != null)
          {
            localObject1 = getResources();
            if (localObject1 != null) {
              break label1244;
            }
            localObject1 = null;
            parama.setText((CharSequence)localObject1);
          }
          parami.fdu().getReplyBtn().setOnClickListener(new f..ExternalSyntheticLambda2(this, parami));
          if (paramb1 != null)
          {
            parama = parami.fdu();
            localObject1 = av.GiL;
            localObject1 = av.Ud(this.scene);
            localObject2 = av.GiL;
            parama.i((String)localObject1, av.ip(paramb1.getUsername(), paramb1.getNickname()), paramb1);
            parama = ah.aiuX;
            parama = ah.aiuX;
          }
          if (ebU() != null)
          {
            if (paramInt != 2) {
              break label1334;
            }
            com.tencent.mm.ui.i.a.a.g(ebU(), z.bAM());
          }
          parama = this.FYS;
          if (parama != null)
          {
            parama.hideLoading();
            parama = ah.aiuX;
          }
          if (!paramBoolean5) {
            break label1444;
          }
          parami.getHeaderLayout().setVisibility(0);
          parami.getRlLayout().setVisibility(0);
          paramUniCommentDrawer = this.FYS;
          if (paramUniCommentDrawer != null) {
            break label1436;
          }
          paramUniCommentDrawer = null;
          if (paramUniCommentDrawer != null) {
            paramUniCommentDrawer.setVisibility(8);
          }
          parami.fdv().setSquaresBackgroundResource(e.d.finder_bottom_corner_shape);
          if (!this.AUp)
          {
            paramUniCommentDrawer = this.FYS;
            if (paramUniCommentDrawer != null)
            {
              paramUniCommentDrawer = paramUniCommentDrawer.getRlLayout();
              if (paramUniCommentDrawer != null)
              {
                RefreshLoadMoreLayout.e(paramUniCommentDrawer);
                paramUniCommentDrawer = ah.aiuX;
              }
            }
          }
          AppMethodBeat.o(341957);
          return;
          parami.us(false);
          parama = this.FYS;
          if (parama == null) {
            break;
          }
          parama = parama.fdv();
          if (parama == null) {
            break;
          }
          parama.jMR();
          parama = ah.aiuX;
          break;
          parama = (List)this.FYR.data;
          i = 0;
          parama = parama.iterator();
          if (parama.hasNext()) {
            if (((com.tencent.mm.plugin.finder.uniComments.storge.d)parama.next()).Gbp.eZI().commentId == paramLong)
            {
              j = 1;
              if (j == 0) {
                break label1128;
              }
            }
          }
          for (;;)
          {
            if (i < 0) {
              break label1141;
            }
            localObject2 = (com.tencent.mm.plugin.finder.uniComments.storge.d)this.FYR.data.get(i);
            ((com.tencent.mm.plugin.finder.uniComments.storge.d)localObject2).ECz = true;
            parama = this.FYS;
            if (parama == null) {
              break;
            }
            UniCommentFooter localUniCommentFooter = parama.fdu();
            if (localUniCommentFooter == null) {
              break;
            }
            parama = av.GiL;
            String str1 = av.Ud(this.scene);
            parama = av.GiL;
            String str2 = ((com.tencent.mm.plugin.finder.uniComments.storge.d)localObject2).Gbp.getUsername();
            localObject1 = ((com.tencent.mm.plugin.finder.uniComments.storge.d)localObject2).Gbp.getNickname();
            parama = (e.a)localObject1;
            if (localObject1 == null) {
              parama = "";
            }
            localUniCommentFooter.i(str1, av.ip(str2, parama), ((com.tencent.mm.plugin.finder.uniComments.storge.d)localObject2).Gbp);
            parama = ah.aiuX;
            break;
            j = 0;
            break label986;
            i += 1;
            break label948;
            i = -1;
          }
          break label466;
          parama = parami.getRlLayout();
          if (!((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()) {}
          for (paramBoolean2 = true;; paramBoolean2 = false)
          {
            parama.setEnableLoadMore(paramBoolean2);
            parama = parami.getRlLayout();
            if (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()) {
              break label1892;
            }
            paramBoolean2 = true;
            break;
          }
        }
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.finder.uniComments.storge.d paramd)
  {
    AppMethodBeat.i(342030);
    s.u(paramd, "item");
    Context localContext = this.context;
    if (localContext != null) {
      k.a(localContext, e.h.finder_profile_confirm_del, 0, new f..ExternalSyntheticLambda1(this, paramd, localContext), null);
    }
    AppMethodBeat.o(342030);
  }
  
  public final void a(final com.tencent.mm.plugin.finder.uniComments.storge.d paramd, final boolean paramBoolean)
  {
    AppMethodBeat.i(342112);
    s.u(paramd, "rootComment");
    this.AUu = true;
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = paramd.Gbp.eZI().levelTwoComment;
      if (!Util.isNullOrNil((List)localObject1))
      {
        localObject2 = ((Iterable)this.FYR.data).iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
        } while (((com.tencent.mm.plugin.finder.uniComments.storge.d)((Iterator)localObject2).next()).Gbp.eZI().commentId != ((FinderCommentInfo)((LinkedList)localObject1).getFirst()).commentId);
      }
    }
    for (;;)
    {
      localObject1 = this.ADY;
      if (localObject1 != null) {
        ((com.tencent.mm.loader.f.h)localObject1).a(new com.tencent.mm.loader.f.g((kotlin.g.a.b)new k(paramd, this, paramBoolean)));
      }
      AppMethodBeat.o(342112);
      return;
      localObject2 = this.ADY;
      if (localObject2 != null) {
        ((com.tencent.mm.loader.f.h)localObject2).a(new com.tencent.mm.loader.f.g((kotlin.g.a.b)new g((LinkedList)localObject1, this, paramd)));
      }
    }
  }
  
  public final void as(View paramView, int paramInt)
  {
    AppMethodBeat.i(342043);
    s.u(paramView, "view");
    if (paramInt < 0)
    {
      Log.i("MicroMsg.MusicUni.DrawerPresenter", s.X("onClickResendComment position:", Integer.valueOf(paramInt)));
      AppMethodBeat.o(342043);
      return;
    }
    if (this.FYR.TL(paramInt).Gbp.field_state == -1)
    {
      paramView = this.FYS;
      if (paramView != null)
      {
        paramView = paramView.getRlLayout();
        if (paramView != null)
        {
          paramView = paramView.getRecyclerView();
          if (paramView != null)
          {
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(paramView, locala.aYi(), "com/tencent/mm/plugin/finder/uniComments/UniCommentDrawerPresenter", "onClickResendComment", "(Landroid/view/View;I)V", "Undefined", "scrollToPosition", "(I)V");
            paramView.scrollToPosition(((Integer)locala.sb(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/finder/uniComments/UniCommentDrawerPresenter", "onClickResendComment", "(Landroid/view/View;I)V", "Undefined", "scrollToPosition", "(I)V");
          }
        }
      }
    }
    AppMethodBeat.o(342043);
  }
  
  public final void b(ImageView paramImageView, int paramInt)
  {
    Object localObject1 = null;
    AppMethodBeat.i(342019);
    s.u(paramImageView, "view");
    if (paramInt < 0)
    {
      AppMethodBeat.o(342019);
      return;
    }
    com.tencent.mm.plugin.finder.uniComments.storge.d locald = this.FYR.TL(paramInt);
    paramImageView = com.tencent.mm.plugin.finder.uniComments.action.d.Gao;
    com.tencent.mm.plugin.finder.uniComments.action.d locald1 = com.tencent.mm.plugin.finder.uniComments.action.d.fdB();
    Object localObject2 = this.FYH;
    paramImageView = (ImageView)localObject2;
    if (localObject2 == null)
    {
      s.bIx("feedObj");
      paramImageView = null;
    }
    boolean bool;
    long l;
    label139:
    int i;
    if (!locald1.a(paramImageView.id, locald.Gbp, this.scene))
    {
      bool = true;
      paramImageView = com.tencent.mm.plugin.finder.uniComments.report.a.Gbf;
      localObject2 = this.FYH;
      paramImageView = (ImageView)localObject2;
      if (localObject2 == null)
      {
        s.bIx("feedObj");
        paramImageView = null;
      }
      paramImageView = paramImageView.Gbe;
      if (!bool) {
        break label263;
      }
      localObject2 = a.a.Gbg;
      l = a.a.fdN();
      com.tencent.mm.plugin.finder.uniComments.report.a.a(paramImageView, l);
      if ((this.context instanceof MMFragmentActivity))
      {
        if (this.scene != 2) {
          break label276;
        }
        paramImageView = a.c.GaW;
        i = a.c.fdG();
        label171:
        paramImageView = com.tencent.mm.plugin.finder.uniComments.logic.c.GaO;
        paramImageView = this.FYH;
        if (paramImageView != null) {
          break label287;
        }
        s.bIx("feedObj");
        paramImageView = localObject1;
      }
    }
    label263:
    label276:
    label287:
    for (;;)
    {
      com.tencent.mm.plugin.finder.uniComments.logic.c.a(paramImageView, locald.Gbp, bool, i);
      paramImageView = this.FYS;
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
      AppMethodBeat.o(342019);
      return;
      bool = false;
      break;
      localObject2 = a.a.Gbg;
      l = a.a.fdO();
      break label139;
      paramImageView = a.c.GaW;
      i = a.c.fdH();
      break label171;
    }
  }
  
  public final boolean b(com.tencent.mm.plugin.finder.uniComments.storge.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(342125);
    s.u(paramd, "comment");
    Object localObject1;
    int i;
    if (paramd.Gbp.field_actionInfo.ABa == 0L)
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(342125);
        return false;
      }
      localObject1 = this.FYR;
      s.u(paramd, "root");
      if (paramd.Gbp.eZI().commentId != 0L)
      {
        localObject1 = ((Iterable)((g)localObject1).data).iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
        } while (((com.tencent.mm.plugin.finder.uniComments.storge.d)((Iterator)localObject1).next()).Gbp.field_actionInfo.ABa != paramd.Gbp.eZI().commentId);
      }
      for (i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(342125);
        return true;
      }
      AppMethodBeat.o(342125);
      return false;
    }
    if (paramBoolean)
    {
      localObject1 = this.FYR;
      s.u(paramd, "level2Comment");
      Iterator localIterator = ((Iterable)((g)localObject1).data).iterator();
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
          localObject2 = (com.tencent.mm.plugin.finder.uniComments.storge.d)localObject2;
          if (g.b((com.tencent.mm.plugin.finder.uniComments.storge.d)localObject2, paramd))
          {
            j = i;
            i = k;
          }
          else if ((j >= 0) && (g.a((com.tencent.mm.plugin.finder.uniComments.storge.d)localObject2, paramd)))
          {
            Log.d(((g)localObject1).TAG, "hasLevel2ItemAfter cur:" + j + ", after:" + i);
          }
        }
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label321;
        }
        AppMethodBeat.o(342125);
        return true;
        i = k;
        break;
      }
      label321:
      AppMethodBeat.o(342125);
      return false;
    }
    if (!this.FYR.c(paramd))
    {
      AppMethodBeat.o(342125);
      return true;
    }
    AppMethodBeat.o(342125);
    return false;
  }
  
  public final int ebS()
  {
    return this.scene;
  }
  
  public final void ebV()
  {
    Resources localResources = null;
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(342090);
    Object localObject1;
    if (this.AHQ)
    {
      localObject1 = this.FYS;
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
        AppMethodBeat.o(342090);
        return;
        localObject1 = ((i)localObject1).fdt();
        break;
        label67:
        localObject2 = localResources.getString(e.h.finder_gallery_desc);
      }
    }
    else if (getCommentCount() <= 0)
    {
      localObject1 = this.FYS;
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
        AppMethodBeat.o(342090);
        return;
        localObject1 = ((i)localObject1).fdt();
        break;
      }
    }
    else
    {
      localObject1 = this.FYS;
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
      AppMethodBeat.o(342090);
      return;
      localObject1 = ((i)localObject1).fdt();
      break;
    }
  }
  
  public final int ebW()
  {
    AppMethodBeat.i(342135);
    Object localObject = this.FYR.data;
    if (!Util.isNullOrNil((List)localObject))
    {
      localObject = (com.tencent.mm.plugin.finder.uniComments.storge.d)kotlin.a.p.oL((List)localObject);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.uniComments.storge.d)localObject).Gbp;
        if ((localObject != null) && (((com.tencent.mm.plugin.finder.uniComments.storge.b)localObject).eZN() == true))
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
      AppMethodBeat.o(342135);
      return i;
      i = 0;
      break;
    }
  }
  
  public final int ebX()
  {
    AppMethodBeat.i(342145);
    Object localObject1 = this.FYR.data;
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
        localObject2 = (com.tencent.mm.plugin.finder.uniComments.storge.d)localObject2;
        if ((((com.tencent.mm.plugin.finder.uniComments.storge.d)localObject2).Gbp.field_actionInfo.ABa == 0L) && (!((com.tencent.mm.plugin.finder.uniComments.storge.d)localObject2).Gbp.eZN()))
        {
          AppMethodBeat.o(342145);
          return i;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(342145);
    return -1;
  }
  
  public final com.tencent.mm.plugin.finder.uniComments.model.b fdi()
  {
    AppMethodBeat.i(342063);
    com.tencent.mm.plugin.finder.uniComments.model.b localb = this.FYH;
    if (localb == null)
    {
      s.bIx("feedObj");
      AppMethodBeat.o(342063);
      return null;
    }
    AppMethodBeat.o(342063);
    return localb;
  }
  
  public final int getCommentScene()
  {
    return this.scene;
  }
  
  public final RecyclerView.h gl(Context paramContext)
  {
    AppMethodBeat.i(342081);
    s.u(paramContext, "context");
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = ((int)paramContext.getResources().getDimension(e.c.Edge_7A));
    paramContext = (RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.a((Drawable)new ColorDrawable(paramContext.getResources().getColor(com.tencent.mm.plugin.finder.e.b.BW_90)), (int)paramContext.getResources().getDimension(e.c.feed_detail_divider), arrayOfInt, (int)paramContext.getResources().getDimension(e.c.feed_detail_divider_last));
    AppMethodBeat.o(342081);
    return paramContext;
  }
  
  public final WxRecyclerAdapter<?> gr(Context paramContext)
  {
    AppMethodBeat.i(342071);
    s.u(paramContext, "context");
    paramContext = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.g)new h(this), this.FYR.data);
    paramContext.bf(false);
    paramContext.agOe = ((i.c)this);
    paramContext.agOd = ((i.d)this);
    AppMethodBeat.o(342071);
    return paramContext;
  }
  
  public final void ht(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(342004);
    Log.i("MicroMsg.MusicUni.DrawerPresenter", "[onModeChange] from=" + paramInt1 + " to=" + paramInt2);
    if (paramInt2 == 0)
    {
      Object localObject = this.FYS;
      if (localObject != null)
      {
        localObject = ((i)localObject).fdv();
        if (localObject != null)
        {
          localObject = ((UniCommentDrawer)localObject).getRecyclerView();
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
        localObject = this.FYS;
        if (localObject != null)
        {
          UniCommentFooter localUniCommentFooter = ((i)localObject).fdu();
          if (localUniCommentFooter != null)
          {
            localObject = av.GiL;
            String str = av.Ud(this.scene);
            com.tencent.mm.plugin.finder.uniComments.model.b localb = this.FYH;
            localObject = localb;
            if (localb == null)
            {
              s.bIx("feedObj");
              localObject = null;
            }
            localUniCommentFooter.ij(str, ((com.tencent.mm.plugin.finder.uniComments.model.b)localObject).nickName);
          }
        }
      }
    }
    AppMethodBeat.o(342004);
  }
  
  public final boolean isCommentClose()
  {
    return this.AUt;
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(341908);
    s.u(parama, "p0");
    this.ATq.add(parama);
    AppMethodBeat.o(341908);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(341993);
    if (this.bRv)
    {
      Log.i("MicroMsg.MusicUni.DrawerPresenter", "onDetach: can not detach, because it is not attached");
      AppMethodBeat.o(341993);
      return;
    }
    this.bRv = true;
    this.AUs = false;
    Object localObject1 = this.ADY;
    if (localObject1 != null) {
      ((com.tencent.mm.loader.f.h)localObject1).stop();
    }
    this.ADY = null;
    localObject1 = this.FYS;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!(localObject1 instanceof LinearLayoutManager)) {
        break label349;
      }
      localObject1 = this.FYS;
      if (localObject1 != null) {
        break label168;
      }
      localObject1 = null;
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label214;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
      AppMethodBeat.o(341993);
      throw ((Throwable)localObject1);
      localObject1 = ((i)localObject1).getRlLayout();
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((RecyclerView)localObject1).getLayoutManager();
      break;
      label168:
      localObject1 = ((i)localObject1).getRlLayout();
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
    label214:
    int i = ((LinearLayoutManager)localObject1).Ju();
    localObject1 = this.FYS;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((i)localObject1).fdu())
    {
      if (localObject1 != null) {
        ((UniCommentFooter)localObject1).setFooterMode(0);
      }
      localObject1 = this.FYS;
      if (localObject1 != null)
      {
        localObject1 = ((i)localObject1).getRlLayout();
        if (localObject1 != null)
        {
          localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
          if (localObject1 != null)
          {
            localObject1 = ((RecyclerView)localObject1).getAdapter();
            if (localObject1 != null) {
              ((RecyclerView.a)localObject1).b((RecyclerView.c)this.FYU);
            }
          }
        }
      }
      localObject1 = ((Iterable)this.ATq).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.tencent.mm.vending.e.a)((Iterator)localObject1).next()).dead();
      }
      label349:
      i = -1;
      break;
    }
    this.ATq.clear();
    this.AUx.dead();
    Object localObject2 = this.FYH;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("feedObj");
      localObject1 = null;
    }
    ((com.tencent.mm.plugin.finder.uniComments.model.b)localObject1).commentCount = getCommentCount();
    localObject1 = b.FYx;
    localObject2 = this.FYH;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("feedObj");
      localObject1 = null;
    }
    s.u(localObject1, "finder");
    localObject2 = b.eZY();
    s.s(localObject2, "cacheItems");
    ((Map)localObject2).put(Long.valueOf(((com.tencent.mm.plugin.finder.uniComments.model.b)localObject1).field_id), localObject1);
    StringBuilder localStringBuilder = new StringBuilder("[onDetach] updateFeedCommentCount feedId=");
    localObject2 = this.FYH;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("feedObj");
      localObject1 = null;
    }
    Log.i("MicroMsg.MusicUni.DrawerPresenter", ((com.tencent.mm.plugin.finder.uniComments.model.b)localObject1).id + " commentCount " + getCommentCount());
    localObject1 = this.FYE;
    if (localObject1 != null) {
      ((e.a)localObject1).z(getCommentCount(), (List)this.FYR.data);
    }
    label666:
    label746:
    int k;
    label771:
    int j;
    if ((this.plm) || (!this.igs))
    {
      this.FYR.data.clear();
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
      localObject1 = this.FYS;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          ((RefreshLoadMoreLayout)localObject1).setHasBottomMore(true);
        }
        localObject1 = this.FYS;
        if (localObject1 != null)
        {
          localObject1 = ((i)localObject1).getRlLayout();
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
        localObject1 = this.FYS;
        if (localObject1 != null) {
          break label941;
        }
        localObject1 = null;
        if (localObject1 != null) {
          ((RecyclerView)localObject1).setLayoutFrozen(true);
        }
        localObject1 = this.FYS;
        if (localObject1 != null) {
          break label969;
        }
        localObject1 = null;
        if (localObject1 != null) {
          ((RefreshLoadMoreLayout)localObject1).setActionCallback(null);
        }
        this.FYS = null;
        AppMethodBeat.o(341993);
      }
    }
    else
    {
      k = i;
      if (this.AAW != 0L)
      {
        localObject1 = ((Iterable)this.FYR.data).iterator();
        j = 0;
        label824:
        k = i;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          if (j < 0) {
            kotlin.a.p.kkW();
          }
          localObject2 = (com.tencent.mm.plugin.finder.uniComments.storge.d)localObject2;
          if (((com.tencent.mm.plugin.finder.uniComments.storge.d)localObject2).Gbp.eZI().commentId != this.AAW) {
            break label979;
          }
          ((com.tencent.mm.plugin.finder.uniComments.storge.d)localObject2).ECA = false;
          i = j;
        }
      }
    }
    label941:
    label969:
    label979:
    for (;;)
    {
      j += 1;
      break label824;
      localObject1 = this.FYR;
      localObject2 = this.lastBuffer;
      ((g)localObject1).Bfe = null;
      ((g)localObject1).data.clear();
      if (k < 0) {
        break;
      }
      boolean bool = g.Bff;
      break;
      localObject1 = ((i)localObject1).getRlLayout();
      break label666;
      localObject1 = ((i)localObject1).getRlLayout();
      if (localObject1 == null)
      {
        localObject1 = null;
        break label746;
      }
      localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
      break label746;
      localObject1 = ((i)localObject1).getRlLayout();
      break label771;
    }
  }
  
  public final com.tencent.mm.plugin.finder.uniComments.storge.d qx(long paramLong)
  {
    AppMethodBeat.i(342096);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(342096);
      return null;
    }
    Iterator localIterator = ((Iterable)this.FYR.data).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((com.tencent.mm.plugin.finder.uniComments.storge.d)localObject).Gbp.eZI().commentId == paramLong)
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
      localObject = (com.tencent.mm.plugin.finder.uniComments.storge.d)localObject;
      AppMethodBeat.o(342096);
      return localObject;
      i = 0;
      break label77;
      label100:
      break;
      localObject = null;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawerPresenter$Companion;", "", "()V", "DEFAULT_INIT_COUNT", "", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawerPresenter$DiffDataChangeHelper;", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawerPresenter;Landroidx/recyclerview/widget/RecyclerView;)V", "onDeleteChange", "", "commentId", "", "localCommentId", "anim", "", "onInsertChange", "target", "Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;", "onSecondaryItemRangeInsert", "rootCommentId", "", "onUpdateChange", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
  {
    private final RecyclerView mkw;
    
    public b()
    {
      AppMethodBeat.i(341500);
      this.mkw = localObject;
      AppMethodBeat.o(341500);
    }
    
    public final void a(long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(341534);
      Object localObject1;
      if (paramLong1 != 0L)
      {
        int m = f.l(f.this).data.size();
        localObject1 = f.l(f.this);
        Object localObject3 = (Iterable)((g)localObject1).data;
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
          com.tencent.mm.plugin.finder.uniComments.storge.d locald = (com.tencent.mm.plugin.finder.uniComments.storge.d)localObject4;
          if (locald.Gbp.eZI().commentId == paramLong1) {
            j = i;
          }
          if ((locald.Gbp.eZI().commentId == paramLong1) || (locald.Gbp.field_actionInfo.ABa == paramLong1)) {}
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
        ((g)localObject1).data.removeAll((Collection)localObject2);
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
        AppMethodBeat.o(341534);
        return;
        f.l(f.this).nC(paramLong2);
      }
    }
    
    public final boolean a(com.tencent.mm.plugin.finder.uniComments.storge.b paramb)
    {
      AppMethodBeat.i(341512);
      s.u(paramb, "target");
      Object localObject = f.l(f.this);
      s.u(paramb, "item");
      Iterator localIterator;
      int j;
      if (paramb.eZI().commentId == 0L)
      {
        localIterator = ((List)((g)localObject).data).iterator();
        i = 0;
        if (localIterator.hasNext()) {
          if (((com.tencent.mm.plugin.finder.uniComments.storge.d)localIterator.next()).Gbp.field_localCommentId == paramb.field_localCommentId)
          {
            j = 1;
            label91:
            if (j == 0) {
              break label231;
            }
            label95:
            if ((i >= 0) && (i < ((g)localObject).data.size()))
            {
              localObject = (com.tencent.mm.plugin.finder.uniComments.storge.d)((g)localObject).data.get(i);
              s.u(paramb, "<set-?>");
              ((com.tencent.mm.plugin.finder.uniComments.storge.d)localObject).Gbp = paramb;
            }
            paramb = new kotlin.r(Integer.valueOf(i), Integer.valueOf(1));
            j = ((Number)paramb.bsC).intValue();
            ((Number)paramb.bsD).intValue();
            if (j < 0) {
              break label336;
            }
            paramb = this.mkw.getAdapter();
            if (paramb != null) {
              break label328;
            }
          }
        }
      }
      label260:
      label328:
      for (int i = 0;; i = paramb.getItemCount())
      {
        if (j >= i) {
          break label336;
        }
        paramb = this.mkw.getAdapter();
        if (paramb != null) {
          paramb.t(j, Integer.valueOf(1));
        }
        AppMethodBeat.o(341512);
        return true;
        j = 0;
        break label91;
        label231:
        i += 1;
        break;
        i = -1;
        break label95;
        localIterator = ((List)((g)localObject).data).iterator();
        j = 0;
        if (localIterator.hasNext())
        {
          if (((com.tencent.mm.plugin.finder.uniComments.storge.d)localIterator.next()).Gbp.eZI().commentId == paramb.eZI().commentId) {}
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
      AppMethodBeat.o(341512);
      return false;
    }
    
    public final boolean b(com.tencent.mm.plugin.finder.uniComments.storge.b paramb)
    {
      AppMethodBeat.i(341521);
      s.u(paramb, "target");
      Object localObject = com.tencent.mm.plugin.finder.uniComments.logic.a.GaM;
      localObject = com.tencent.mm.plugin.finder.uniComments.logic.a.c(paramb);
      int i = f.l(f.this).b((com.tencent.mm.plugin.finder.uniComments.storge.d)localObject);
      localObject = this.mkw.getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).bZE.notifyChanged();
      }
      if (paramb.field_actionInfo.ABa != 0L)
      {
        paramb = f.this.FYS;
        if (paramb != null)
        {
          paramb = paramb.getRlLayout();
          if (paramb != null) {
            paramb.ci((kotlin.g.a.a)a.FYW);
          }
        }
        paramb = f.this.FYS;
        if (paramb != null)
        {
          paramb = paramb.getRlLayout();
          if (paramb != null)
          {
            paramb = paramb.getRecyclerView();
            if (paramb != null)
            {
              localObject = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.b(paramb, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/finder/uniComments/UniCommentDrawerPresenter$DiffDataChangeHelper", "onInsertChange", "(Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;)Z", "Undefined", "scrollToPosition", "(I)V");
              paramb.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.c(paramb, "com/tencent/mm/plugin/finder/uniComments/UniCommentDrawerPresenter$DiffDataChangeHelper", "onInsertChange", "(Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;)Z", "Undefined", "scrollToPosition", "(I)V");
            }
          }
        }
      }
      AppMethodBeat.o(341521);
      return true;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      public static final a FYW;
      
      static
      {
        AppMethodBeat.i(341408);
        FYW = new a();
        AppMethodBeat.o(341408);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/uniComments/UniCommentDrawerPresenter$commentDataObserver$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeRemoved", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.c
  {
    c(f paramf) {}
    
    public final void onChanged()
    {
      AppMethodBeat.i(341502);
      super.onChanged();
      this.FYV.ebV();
      AppMethodBeat.o(341502);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(341513);
      super.onItemRangeChanged(paramInt1, paramInt2);
      this.FYV.ebV();
      AppMethodBeat.o(341513);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(341518);
      super.onItemRangeChanged(paramInt1, paramInt2, paramObject);
      this.FYV.ebV();
      AppMethodBeat.o(341518);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(341507);
      super.onItemRangeInserted(paramInt1, paramInt2);
      this.FYV.ebV();
      AppMethodBeat.o(341507);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(341526);
      super.onItemRangeRemoved(paramInt1, paramInt2);
      this.FYV.ebV();
      AppMethodBeat.o(341526);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(f paramf, com.tencent.mm.plugin.finder.uniComments.storge.d paramd, kotlin.g.a.a<ah> parama1, kotlin.g.a.a<ah> parama2)
    {
      super();
    }
    
    private static final ah a(kotlin.g.a.a parama1, kotlin.g.a.a parama2, b.a parama)
    {
      AppMethodBeat.i(341514);
      s.u(parama1, "$succCallback");
      s.u(parama2, "$failedCallback");
      if ((parama.errType == 0) && (parama.errCode == 0)) {
        parama1.invoke();
      }
      for (;;)
      {
        parama1 = ah.aiuX;
        AppMethodBeat.o(341514);
        return parama1;
        parama2.invoke();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(f paramf, Context paramContext)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(f paramf, com.tencent.mm.plugin.finder.uniComments.storge.d paramd, Context paramContext)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<FinderCommentInfo, Boolean>
    {
      a(com.tencent.mm.plugin.finder.uniComments.storge.d paramd)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<com.tencent.mm.loader.f.g, ah>
  {
    g(LinkedList<FinderCommentInfo> paramLinkedList, f paramf, com.tencent.mm.plugin.finder.uniComments.storge.d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/uniComments/UniCommentDrawerPresenter$getAdapter$adapter$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements com.tencent.mm.view.recyclerview.g
  {
    h(f paramf) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(341506);
      Object localObject = com.tencent.mm.plugin.finder.uniComments.storge.d.Gbo;
      if (paramInt == com.tencent.mm.plugin.finder.uniComments.storge.d.eDj())
      {
        localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.uniComments.convert.a((e.b)this.FYV);
        AppMethodBeat.o(341506);
        return localObject;
      }
      localObject = com.tencent.mm.plugin.finder.uniComments.storge.d.Gbo;
      if (paramInt == com.tencent.mm.plugin.finder.uniComments.storge.d.eDk())
      {
        localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.uniComments.convert.b((e.b)this.FYV);
        AppMethodBeat.o(341506);
        return localObject;
      }
      localObject = av.GiL;
      av.eY("MicroMsg.MusicUni.DrawerPresenter", paramInt);
      localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.g();
      AppMethodBeat.o(341506);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.b<com.tencent.mm.loader.f.g, ah>
  {
    j(f paramf)
    {
      super();
    }
    
    private static final List a(f paramf, b.a parama)
    {
      AppMethodBeat.i(341539);
      s.u(paramf, "this$0");
      if (parama == null)
      {
        Log.e("MicroMsg.MusicUni.DrawerPresenter", "loadMoreData resp null");
        paramf = (List)new ArrayList();
        AppMethodBeat.o(341539);
        return paramf;
      }
      if ((parama.errType == 0) && (parama.errCode == 0) && (parama.ott != null))
      {
        if (((byd)parama.ott).aaha == 1) {}
        List localList;
        Collection localCollection;
        for (boolean bool = true;; bool = false)
        {
          f.a(paramf, bool);
          f.a(paramf, ((byd)parama.ott).ZEQ);
          if (f.h(paramf) != null) {
            break;
          }
          localObject = "null";
          Log.i("MicroMsg.MusicUni.DrawerPresenter", s.X("loadMoreData after lastBuffer ", localObject));
          localList = (List)new ArrayList();
          parama = ((byd)parama.ott).aagX;
          s.s(parama, "it.resp.comment_info");
          parama = (Iterable)parama;
          localCollection = (Collection)new ArrayList(kotlin.a.p.a(parama, 10));
          Iterator localIterator = parama.iterator();
          while (localIterator.hasNext())
          {
            FinderCommentInfo localFinderCommentInfo = (FinderCommentInfo)localIterator.next();
            parama = com.tencent.mm.plugin.finder.uniComments.logic.a.GaM;
            s.s(localFinderCommentInfo, "commentInfo");
            localObject = f.g(paramf);
            parama = (b.a)localObject;
            if (localObject == null)
            {
              s.bIx("feedObj");
              parama = null;
            }
            localCollection.add(com.tencent.mm.plugin.finder.uniComments.logic.a.b(localFinderCommentInfo, parama.id));
          }
        }
        Object localObject = f.h(paramf);
        if (localObject == null) {}
        for (localObject = null;; localObject = ((com.tencent.mm.bx.b)localObject).toByteArray())
        {
          localObject = MD5Util.getMD5String((byte[])localObject);
          break;
        }
        localList.addAll((Collection)localCollection);
        paramf = f.b(paramf, localList);
        AppMethodBeat.o(341539);
        return paramf;
      }
      paramf = (List)new ArrayList();
      AppMethodBeat.o(341539);
      return paramf;
    }
    
    private static final ah a(f paramf, com.tencent.mm.loader.f.g paramg, List paramList)
    {
      AppMethodBeat.i(341549);
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
        i = f.l(paramf).data.size();
        f.l(paramf).a(paramList, false, true);
        localObject = paramf.FYS;
        if (localObject != null)
        {
          localObject = ((i)localObject).getRlLayout();
          if (localObject != null)
          {
            localObject = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
            if (localObject != null)
            {
              localObject = ((RecyclerView)localObject).getAdapter();
              if (localObject != null) {
                ((RecyclerView.a)localObject).bA(i, f.l(paramf).data.size() - i);
              }
            }
          }
        }
      }
      for (;;)
      {
        localObject = new RefreshLoadMoreLayout.d(0);
        ((RefreshLoadMoreLayout.d)localObject).agJu = f.k(paramf);
        ((RefreshLoadMoreLayout.d)localObject).agJv = paramList.size();
        if (((RefreshLoadMoreLayout.d)localObject).agJv > 0) {
          ((RefreshLoadMoreLayout.d)localObject).pzq = false;
        }
        paramf = paramf.FYS;
        if (paramf != null)
        {
          paramf = paramf.getRlLayout();
          if (paramf != null) {
            paramf.onPreFinishLoadMoreSmooth((RefreshLoadMoreLayout.d)localObject);
          }
        }
        paramg.a(com.tencent.mm.loader.f.i.nrG);
        paramf = ah.aiuX;
        AppMethodBeat.o(341549);
        return paramf;
        i = 0;
        break;
        label218:
        Log.w("MicroMsg.MusicUni.DrawerPresenter", "[loadMoreData] empty!");
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.b<com.tencent.mm.loader.f.g, ah>
  {
    k(com.tencent.mm.plugin.finder.uniComments.storge.d paramd, f paramf, boolean paramBoolean)
    {
      super();
    }
    
    private static final ah a(f paramf, com.tencent.mm.plugin.finder.uniComments.storge.d paramd, boolean paramBoolean, com.tencent.mm.loader.f.g paramg, kotlin.r paramr)
    {
      AppMethodBeat.i(341562);
      s.u(paramf, "this$0");
      s.u(paramd, "$rootComment");
      s.u(paramg, "$task");
      int i = ((Number)paramr.bsC).intValue();
      paramr = (List)paramr.bsD;
      switch (i)
      {
      }
      for (;;)
      {
        paramg.a(com.tencent.mm.loader.f.i.nrG);
        paramf = ah.aiuX;
        AppMethodBeat.o(341562);
        return paramf;
        f.a(paramf, paramr, paramd, paramBoolean);
        continue;
        paramr = f.m(paramf);
        if (paramr != null) {
          paramr.a(paramd.Gbp.eZI().commentId, paramd.Gbp.field_localCommentId, true);
        }
        aa.makeText(paramf.context, e.h.finder_root_comment_deleted, 0).show();
      }
    }
    
    private static final kotlin.r a(com.tencent.mm.plugin.finder.uniComments.storge.d paramd, f paramf, b.a parama)
    {
      AppMethodBeat.i(341552);
      s.u(paramd, "$rootComment");
      s.u(paramf, "this$0");
      if (parama == null)
      {
        Log.e("MicroMsg.MusicUni.DrawerPresenter", "loadMoreLevel2Comments resp null");
        paramd = new kotlin.r(Integer.valueOf(-2), (List)ab.aivy);
        AppMethodBeat.o(341552);
        return paramd;
      }
      if ((parama.errType == 0) && (parama.errCode == 0) && (parama.ott != null))
      {
        Collection localCollection;
        if (paramd.Gbp.eZI().lastBuffer == null)
        {
          localObject = "null";
          Log.i("MicroMsg.MusicUni.DrawerPresenter", s.X("loadMoreLevel2Comments after lastBuffer ", localObject));
          parama = ((byd)parama.ott).aagX;
          s.s(parama, "it.resp.comment_info");
          parama = (Iterable)parama;
          localCollection = (Collection)new ArrayList(kotlin.a.p.a(parama, 10));
          Iterator localIterator = parama.iterator();
          while (localIterator.hasNext())
          {
            FinderCommentInfo localFinderCommentInfo = (FinderCommentInfo)localIterator.next();
            parama = com.tencent.mm.plugin.finder.uniComments.logic.a.GaM;
            s.s(localFinderCommentInfo, "commentInfo");
            localObject = f.g(paramf);
            parama = (b.a)localObject;
            if (localObject == null)
            {
              s.bIx("feedObj");
              parama = null;
            }
            localCollection.add(com.tencent.mm.plugin.finder.uniComments.logic.a.d(localFinderCommentInfo, parama.id, paramd.Gbp.eZI().commentId));
          }
        }
        Object localObject = paramd.Gbp.eZI().lastBuffer;
        if (localObject == null) {}
        for (localObject = null;; localObject = ((com.tencent.mm.bx.b)localObject).toByteArray())
        {
          localObject = MD5Util.getMD5String((byte[])localObject);
          break;
        }
        paramd = new kotlin.r(Integer.valueOf(0), (List)localCollection);
        AppMethodBeat.o(341552);
        return paramd;
      }
      if (parama.errCode == -4032)
      {
        paramd = new kotlin.r(Integer.valueOf(-1), (List)ab.aivy);
        AppMethodBeat.o(341552);
        return paramd;
      }
      paramd = new kotlin.r(Integer.valueOf(0), (List)ab.aivy);
      AppMethodBeat.o(341552);
      return paramd;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/uniComments/UniCommentDrawerPresenter$onAttach$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    extends RefreshLoadMoreLayout.b
  {
    l(f paramf) {}
    
    private static final void n(f paramf)
    {
      AppMethodBeat.i(341530);
      s.u(paramf, "this$0");
      f.d(paramf);
      AppMethodBeat.o(341530);
    }
    
    private static final void o(f paramf)
    {
      AppMethodBeat.i(341536);
      s.u(paramf, "this$0");
      f.e(paramf);
      AppMethodBeat.o(341536);
    }
    
    public final void IH(int paramInt)
    {
      AppMethodBeat.i(341563);
      com.tencent.threadpool.h.ahAA.bm(new f.l..ExternalSyntheticLambda1(this.FYV));
      AppMethodBeat.o(341563);
    }
    
    public final void a(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(341557);
      s.u(paramd, "reason");
      super.a(paramd);
      f.b(this.FYV);
      AppMethodBeat.o(341557);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(341565);
      s.u(paramd, "reason");
      super.onRefreshEnd(paramd);
      f.c(this.FYV);
      AppMethodBeat.o(341565);
    }
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(341551);
      super.qI(paramInt);
      com.tencent.threadpool.h.ahAA.bm(new f.l..ExternalSyntheticLambda0(this.FYV));
      AppMethodBeat.o(341551);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "commentItem", "Lcom/tencent/mm/plugin/finder/uniComments/storge/UniFeedComment;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.uniComments.storge.d, ah>
  {
    m(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "commentItem", "Lcom/tencent/mm/plugin/finder/uniComments/storge/UniFeedComment;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.uniComments.storge.d, ah>
  {
    n(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends u
    implements kotlin.g.a.b<com.tencent.mm.loader.f.g, ah>
  {
    p(boolean paramBoolean, f paramf)
    {
      super();
    }
    
    private static final ah a(f paramf, boolean paramBoolean, long paramLong, com.tencent.mm.loader.f.g paramg, kotlin.r paramr)
    {
      AppMethodBeat.i(341584);
      s.u(paramf, "this$0");
      s.u(paramg, "$task");
      boolean bool = ((Boolean)paramr.bsC).booleanValue();
      paramr = (List)paramr.bsD;
      Object localObject1 = paramf.FYS;
      if (localObject1 != null) {
        ((i)localObject1).hideLoading();
      }
      if (!paramBoolean)
      {
        localObject1 = paramf.FYS;
        if (localObject1 != null)
        {
          localObject1 = ((i)localObject1).getRlLayout();
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
          break label832;
        }
        if (f.f(paramf) != 0L) {
          break label347;
        }
        g.a(f.l(paramf));
        localObject1 = f.l(paramf);
        s.u(paramr, "itemList");
        localObject2 = ((Iterable)paramr).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((g)localObject1).b((com.tencent.mm.plugin.finder.uniComments.storge.d)((Iterator)localObject2).next());
        }
        label192:
        i = paramr.size();
        break;
        if (!f.k(paramf))
        {
          localObject1 = paramf.FYS;
          if (localObject1 != null)
          {
            localObject1 = ((i)localObject1).getRlLayout();
            if (localObject1 != null) {
              RefreshLoadMoreLayout.e((RefreshLoadMoreLayout)localObject1);
            }
          }
        }
      }
      paramf = paramf.FYS;
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
        Log.i("MicroMsg.MusicUni.DrawerPresenter", paramBoolean);
        paramg.a(com.tencent.mm.loader.f.i.nrG);
        paramf = ah.aiuX;
        AppMethodBeat.o(341584);
        return paramf;
        i = f.l(paramf).data.size();
        f.l(paramf).a(paramr, true, false);
        localObject1 = paramf.FYS;
        if (localObject1 != null)
        {
          localObject1 = ((i)localObject1).getRlLayout();
          if (localObject1 != null)
          {
            localObject1 = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
            if (localObject1 != null)
            {
              localObject1 = ((RecyclerView)localObject1).getAdapter();
              if (localObject1 != null) {
                ((RecyclerView.a)localObject1).bA(0, f.l(paramf).data.size() - i);
              }
            }
          }
        }
      } while (!paramBoolean);
      localObject1 = (List)f.l(paramf).data;
      int i = 0;
      localObject1 = ((List)localObject1).iterator();
      label464:
      int j;
      label504:
      label509:
      int k;
      if (((Iterator)localObject1).hasNext()) {
        if (((com.tencent.mm.plugin.finder.uniComments.storge.d)((Iterator)localObject1).next()).Gbp.eZI().commentId == f.f(paramf))
        {
          j = 1;
          if (j == 0) {
            break label755;
          }
          if (i < 0) {
            break label768;
          }
          localObject1 = (com.tencent.mm.plugin.finder.uniComments.storge.d)f.l(paramf).data.get(i);
          localObject2 = paramf.FYS;
          if (localObject2 != null)
          {
            localObject2 = ((i)localObject2).fdu();
            if (localObject2 != null)
            {
              Object localObject3 = av.GiL;
              localObject3 = av.Ud(paramf.scene);
              av localav = av.GiL;
              ((UniCommentFooter)localObject2).i((String)localObject3, av.ip(((com.tencent.mm.plugin.finder.uniComments.storge.d)localObject1).Gbp.getUsername(), ((com.tencent.mm.plugin.finder.uniComments.storge.d)localObject1).Gbp.getNickname()), ((com.tencent.mm.plugin.finder.uniComments.storge.d)localObject1).Gbp);
            }
          }
          if (((com.tencent.mm.plugin.finder.uniComments.storge.d)localObject1).Gbp.field_actionInfo.ABa == 0L) {
            break label1018;
          }
          long l = ((com.tencent.mm.plugin.finder.uniComments.storge.d)localObject1).Gbp.field_actionInfo.ABa;
          if (l == 0L) {
            break label785;
          }
          localObject1 = (List)paramf.FYR.data;
          j = 0;
          localObject1 = ((List)localObject1).iterator();
          label664:
          if (!((Iterator)localObject1).hasNext()) {
            break label785;
          }
          if (((com.tencent.mm.plugin.finder.uniComments.storge.d)((Iterator)localObject1).next()).Gbp.eZI().commentId != l) {
            break label770;
          }
          k = 1;
          label702:
          if (k == 0) {
            break label776;
          }
          label707:
          if (j < 0) {
            break label1018;
          }
        }
      }
      for (;;)
      {
        paramf = paramf.FYS;
        if (paramf == null)
        {
          paramf = null;
          label723:
          if (!(paramf instanceof LinearLayoutManager)) {
            break label827;
          }
        }
        label768:
        label770:
        label776:
        label785:
        label827:
        for (paramf = (LinearLayoutManager)paramf;; paramf = null)
        {
          if (paramf == null) {
            break label830;
          }
          paramf.bo(j, 0);
          break;
          j = 0;
          break label504;
          label755:
          i += 1;
          break label464;
          i = -1;
          break label509;
          break;
          k = 0;
          break label702;
          j += 1;
          break label664;
          j = -1;
          break label707;
          paramf = paramf.getRlLayout();
          if (paramf == null)
          {
            paramf = null;
            break label723;
          }
          paramf = paramf.getRecyclerView();
          if (paramf == null)
          {
            paramf = null;
            break label723;
          }
          paramf = paramf.getLayoutManager();
          break label723;
        }
        label830:
        break;
        label832:
        Log.i("MicroMsg.MusicUni.DrawerPresenter", "refresh header title...");
        paramf.ebV();
        if (!paramBoolean) {
          break;
        }
        g.a(f.l(paramf));
        localObject1 = paramf.FYS;
        if (localObject1 != null)
        {
          localObject1 = ((i)localObject1).getRlLayout();
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
          paramf = paramf.FYS;
          if (paramf == null) {
            break;
          }
          paramf.getLoadingLayout().setVisibility(0);
          paramf.getLoadingView().setVisibility(8);
          if (paramf.fdv().getCloseComment()) {
            paramf.fdw().setVisibility(8);
          }
          for (;;)
          {
            paramf.fdx().setVisibility(8);
            break;
            paramf.fdw().setVisibility(0);
          }
        }
        localObject1 = paramf.FYS;
        if (localObject1 == null) {
          break;
        }
        ((i)localObject1).bv((kotlin.g.a.a)new b(paramf));
        break;
        paramBoolean = false;
        break label315;
        label1018:
        j = i;
      }
    }
    
    private static final kotlin.r a(f paramf, boolean paramBoolean, ah.f paramf1, ah.f paramf2, b.a parama)
    {
      AppMethodBeat.i(341570);
      s.u(paramf, "this$0");
      s.u(paramf1, "$localLevel2Comments");
      s.u(paramf2, "$localComments");
      if (parama == null)
      {
        Log.e("MicroMsg.MusicUni.DrawerPresenter", "refreshData resp null");
        paramf = new kotlin.r(Boolean.FALSE, null);
        AppMethodBeat.o(341570);
        return paramf;
      }
      if ((parama.errType == 0) && (parama.errCode == 0) && (parama.ott != null))
      {
        f.a(paramf, ((byd)parama.ott).ZEQ);
        label141:
        Object localObject2;
        Object localObject1;
        Object localObject3;
        label246:
        Object localObject4;
        if (paramBoolean) {
          if (((byd)parama.ott).aaha == 1)
          {
            paramBoolean = true;
            f.a(paramf, paramBoolean);
            if (((byd)parama.ott).aagZ != 1) {
              break label429;
            }
            paramBoolean = true;
            f.b(paramf, paramBoolean);
            i = ((byd)parama.ott).aagY;
            localObject2 = f.g(paramf);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("feedObj");
              localObject1 = null;
            }
            ((com.tencent.mm.plugin.finder.uniComments.model.b)localObject1).commentCount = i;
            localObject2 = (List)new ArrayList();
            parama = ((byd)parama.ott).aagX;
            s.s(parama, "it.resp.comment_info");
            parama = (Iterable)parama;
            localObject3 = (Collection)localObject2;
            Iterator localIterator = parama.iterator();
            if (!localIterator.hasNext()) {
              break label469;
            }
            localObject4 = (FinderCommentInfo)localIterator.next();
            parama = com.tencent.mm.plugin.finder.uniComments.logic.a.GaM;
            s.s(localObject4, "commentInfo");
            localObject1 = f.g(paramf);
            parama = (b.a)localObject1;
            if (localObject1 == null)
            {
              s.bIx("feedObj");
              parama = null;
            }
            localObject4 = com.tencent.mm.plugin.finder.uniComments.logic.a.b((FinderCommentInfo)localObject4, parama.id);
            if ((!f.i(paramf)) || (((com.tencent.mm.plugin.finder.uniComments.storge.d)localObject4).Gbp.eZI().commentId != f.f(paramf)) || (f.f(paramf) == 0L)) {
              break label464;
            }
          }
        }
        label429:
        label464:
        for (paramBoolean = true;; paramBoolean = false)
        {
          ((com.tencent.mm.plugin.finder.uniComments.storge.d)localObject4).ECz = paramBoolean;
          if (((com.tencent.mm.plugin.finder.uniComments.storge.d)localObject4).ECz) {
            f.j(paramf);
          }
          com.tencent.mm.plugin.finder.uniComments.storge.b localb = ((com.tencent.mm.plugin.finder.uniComments.storge.d)localObject4).Gbp;
          localObject1 = f.g(paramf);
          parama = (b.a)localObject1;
          if (localObject1 == null)
          {
            s.bIx("feedObj");
            parama = null;
          }
          localb.Gah = parama;
          ((Collection)localObject3).add(localObject4);
          break label246;
          paramBoolean = false;
          break;
          paramBoolean = false;
          break label141;
          if (((byd)parama.ott).aagZ == 1) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            f.b(paramf, paramBoolean);
            break;
          }
        }
        label469:
        f.a(paramf, (List)localObject2);
        int j = ((List)localObject2).size();
        f.a(paramf, (List)paramf1.aqH, (List)localObject2);
        int k = ((List)localObject2).size();
        parama = f.b(paramf, (List)localObject2);
        int m = parama.size();
        paramf2 = ((Iterable)paramf2.aqH).iterator();
        label568:
        label702:
        label707:
        while (paramf2.hasNext())
        {
          localObject1 = (com.tencent.mm.plugin.finder.uniComments.storge.b)paramf2.next();
          localObject2 = ((Iterable)parama).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            paramf1 = ((Iterator)localObject2).next();
            localObject3 = (com.tencent.mm.plugin.finder.uniComments.storge.d)paramf1;
            if ((((com.tencent.mm.plugin.finder.uniComments.storge.d)localObject3).Gbp.eZM() != null) && (s.p(((com.tencent.mm.plugin.finder.uniComments.storge.d)localObject3).Gbp.eZM(), ((com.tencent.mm.plugin.finder.uniComments.storge.b)localObject1).eZM())))
            {
              i = 1;
              label625:
              if (i == 0) {
                break label702;
              }
            }
          }
          for (;;)
          {
            if ((com.tencent.mm.plugin.finder.uniComments.storge.d)paramf1 != null) {
              break label707;
            }
            Log.i("MicroMsg.MusicUni.DrawerPresenter", s.X("merge local item: ", ((com.tencent.mm.plugin.finder.uniComments.storge.b)localObject1).eZM()));
            paramf1 = new com.tencent.mm.plugin.finder.uniComments.storge.d((com.tencent.mm.plugin.finder.uniComments.storge.b)localObject1);
            paramf1.ECw = com.tencent.mm.pluginsdk.ui.span.p.b(MMApplicationContext.getContext(), (CharSequence)((com.tencent.mm.plugin.finder.uniComments.storge.b)localObject1).getContent());
            localObject1 = ah.aiuX;
            parama.add(paramf1);
            break;
            i = 0;
            break label625;
            break label568;
            paramf1 = null;
          }
        }
        int i = parama.size();
        paramf1 = f.g(paramf);
        paramf = paramf1;
        if (paramf1 == null)
        {
          s.bIx("feedObj");
          paramf = null;
        }
        paramf.commentCount = (i - m + (k - j) + paramf.commentCount);
        paramf = new kotlin.r(Boolean.TRUE, parama);
        AppMethodBeat.o(341570);
        return paramf;
      }
      if ((parama.errCode == -4014) || (parama.errCode == -4032))
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(paramf));
        paramf = new kotlin.r(Boolean.TRUE, null);
        AppMethodBeat.o(341570);
        return paramf;
      }
      paramf1 = aw.Gjk;
      if (aw.iv(parama.errType, parama.errCode))
      {
        f.a(paramf, false);
        f.b(paramf, false);
        paramf = new kotlin.r(Boolean.TRUE, null);
        AppMethodBeat.o(341570);
        return paramf;
      }
      paramf = new kotlin.r(Boolean.FALSE, null);
      AppMethodBeat.o(341570);
      return paramf;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(f paramf)
      {
        super();
      }
      
      private static final void k(boolean paramBoolean, String paramString) {}
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<ah>
    {
      b(f paramf)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.f
 * JD-Core Version:    0.7.0.1
 */