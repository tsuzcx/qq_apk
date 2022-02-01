package com.tencent.mm.plugin.finder.megavideo.convert;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.if;
import com.tencent.mm.autogen.a.it;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.a;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoTimelineUI;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.MegaVideoInputLayout;
import com.tencent.mm.plugin.finder.megavideo.ui.f.d;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.model.t;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.report.ax;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.an.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout.b;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.g;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.brk;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.dnh;
import com.tencent.mm.protocal.protobuf.dno;
import com.tencent.mm.protocal.protobuf.dnq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.HardTouchableLayout.b;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;)V", "blockBgClick", "", "getBlockBgClick", "()Z", "setBlockBgClick", "(Z)V", "miniViewEnable", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "calculateBannerLayoutParam", "", "banner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feedId", "", "convertMedia", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "", "type", "createLikeFloatIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "deleteBullet", "info", "Lcom/tencent/mm/protocal/protobuf/MegaVideoBulletCommentInfo;", "deleteFinish", "Lkotlin/Function0;", "doFav", "doLike", "isPrivate", "likeAction", "e", "Landroid/view/MotionEvent;", "doShare", "getLayoutId", "getLikeIcon", "filled", "private", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "hideBulletInputLayout", "hideBulletOpLayout", "initFoldButtons", "initFooterLayout", "initHeaderLayout", "initPlayCtrlLayout", "initToggleHeaderAndFooter", "isNewsObject", "onBindViewHolder", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onHideSmileyPanel", "onMediaDoubleClick", "view", "Landroid/view/View;", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "openCommentDrawer", "refreshCommentLayout", "totalCommentCount", "refreshDescContent", "refreshFavLayout", "isFav", "favCount", "refreshLikeLayout", "isLike", "likeCount", "setGroupLikeIcon", "imageView", "wordingConfig", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExtInfo;", "showBulletOpLayout", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.view.recyclerview.f<ca>
{
  public static final a Ezn;
  private static final int Ezr;
  private static final kotlin.j<Integer> Ezs;
  private final com.tencent.mm.plugin.finder.video.l AJn;
  private final com.tencent.mm.plugin.finder.megavideo.ui.f Ezo;
  private final boolean Ezp;
  boolean Ezq;
  
  static
  {
    AppMethodBeat.i(342652);
    Ezn = new a((byte)0);
    Ezr = 10003;
    Ezs = kotlin.k.cm((kotlin.g.a.a)b.Ezt);
    AppMethodBeat.o(342652);
  }
  
  public a(com.tencent.mm.plugin.finder.video.l paraml, com.tencent.mm.plugin.finder.megavideo.ui.f paramf)
  {
    AppMethodBeat.i(342321);
    this.AJn = paraml;
    this.Ezo = paramf;
    paraml = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eWl().bmg()).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.Ezp = bool;
      AppMethodBeat.o(342321);
      return;
    }
  }
  
  private final void A(com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(342338);
    Object localObject1 = paramj.UH(e.e.play_speed_ctrl_btn);
    if (localObject1 != null) {
      ((View)localObject1).setOnClickListener(new a..ExternalSyntheticLambda7(paramj, this));
    }
    localObject1 = (TextView)paramj.UH(e.e.speed_0_5);
    if (localObject1 != null) {
      ((TextView)localObject1).setTag(Integer.valueOf(1));
    }
    localObject1 = (TextView)paramj.UH(e.e.speed_1);
    if (localObject1 != null) {
      ((TextView)localObject1).setTag(Integer.valueOf(2));
    }
    localObject1 = (TextView)paramj.UH(e.e.speed_1_5);
    if (localObject1 != null) {
      ((TextView)localObject1).setTag(Integer.valueOf(3));
    }
    localObject1 = (TextView)paramj.UH(e.e.speed_2);
    if (localObject1 != null) {
      ((TextView)localObject1).setTag(Integer.valueOf(4));
    }
    Object localObject2 = kotlin.a.p.listOf(new TextView[] { (TextView)paramj.UH(e.e.speed_0_5), (TextView)paramj.UH(e.e.speed_1), (TextView)paramj.UH(e.e.speed_1_5), (TextView)paramj.UH(e.e.speed_2) });
    localObject1 = new a..ExternalSyntheticLambda6(this, (List)localObject2, paramj);
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      TextView localTextView = (TextView)((Iterator)localObject2).next();
      if (localTextView != null) {
        localTextView.setOnClickListener((View.OnClickListener)localObject1);
      }
    }
    localObject1 = (TextView)paramj.UH(e.e.speed_1);
    if (localObject1 != null) {
      ((TextView)localObject1).setTextColor(paramj.context.getResources().getColor(e.b.hot_tab_Orange_100));
    }
    AppMethodBeat.o(342338);
  }
  
  private static final void B(com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(342457);
    kotlin.g.b.s.u(paramj, "$holder");
    Object localObject = as.GSQ;
    localObject = paramj.context;
    kotlin.g.b.s.s(localObject, "holder.context");
    localObject = as.a.hu((Context)localObject);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((as)localObject).fou())
    {
      paramj = (ca)paramj.CSA;
      com.tencent.mm.plugin.finder.report.z localz = com.tencent.mm.plugin.finder.report.z.FrZ;
      kotlin.g.b.s.s(paramj, "feed");
      com.tencent.mm.plugin.finder.report.z.a(localz, paramj, 2, 3L, "", (bui)localObject);
      AppMethodBeat.o(342457);
      return;
    }
  }
  
  private static final void C(com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(342611);
    kotlin.g.b.s.u(paramj, "$holder");
    Object localObject = as.GSQ;
    localObject = paramj.context;
    kotlin.g.b.s.s(localObject, "holder.context");
    localObject = as.a.hu((Context)localObject);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((as)localObject).fou())
    {
      paramj = (ca)paramj.CSA;
      com.tencent.mm.plugin.finder.report.z localz = com.tencent.mm.plugin.finder.report.z.FrZ;
      kotlin.g.b.s.s(paramj, "feed");
      com.tencent.mm.plugin.finder.report.z.a(localz, paramj, 1, 3L, "", (bui)localObject);
      AppMethodBeat.o(342611);
      return;
    }
  }
  
  private final int a(boolean paramBoolean1, boolean paramBoolean2, FinderObject paramFinderObject)
  {
    Object localObject = null;
    AppMethodBeat.i(342441);
    if (this.Ezo.EAO)
    {
      i = e.g.finder_filled_like_private;
      AppMethodBeat.o(342441);
      return i;
    }
    aw localaw = aw.Gjk;
    paramFinderObject = paramFinderObject.contact;
    if (paramFinderObject == null) {
      paramFinderObject = localObject;
    }
    while (aw.n(paramFinderObject)) {
      if (paramBoolean1)
      {
        i = e.g.finder_filled_like_lock;
        AppMethodBeat.o(342441);
        return i;
        paramFinderObject = com.tencent.mm.plugin.finder.api.c.a(paramFinderObject, null, false);
      }
      else
      {
        i = e.g.finder_outlined_like_lock;
        AppMethodBeat.o(342441);
        return i;
      }
    }
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        i = e.g.finder_filled_like_lock;
        AppMethodBeat.o(342441);
        return i;
      }
      i = e.g.finder_full_like;
      AppMethodBeat.o(342441);
      return i;
    }
    int i = e.g.finder_full_like;
    AppMethodBeat.o(342441);
    return i;
  }
  
  private static final void a(a parama, ca paramca, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(342604);
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramca, "$item");
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(342604);
      return;
      paramMenuItem = parama.Ezo;
      kotlin.g.b.s.u(paramca, "megaVideo");
      parama = com.tencent.mm.plugin.finder.utils.an.GhR;
      paramMenuItem = paramMenuItem.CCa;
      FinderItem.a locala = FinderItem.Companion;
      an.a.a(parama, paramMenuItem, FinderItem.a.e(paramca.getFeedObject(), 32768), null, 0, 28);
      AppMethodBeat.o(342604);
      return;
      paramMenuItem = parama.Ezo;
      kotlin.g.b.s.u(paramca, "megaVideo");
      parama = com.tencent.mm.plugin.finder.utils.an.GhR;
      paramMenuItem = paramMenuItem.CCa;
      locala = FinderItem.Companion;
      an.a.a(parama, paramMenuItem, (BaseFinderFeed)new com.tencent.mm.plugin.finder.model.ah(FinderItem.a.e(paramca.getFeedObject(), 32768)), 4, 0, 20);
    }
  }
  
  private static final void a(a parama, ca paramca, com.tencent.mm.view.recyclerview.j paramj, View paramView)
  {
    AppMethodBeat.i(342518);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramca);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramca, "$item");
    kotlin.g.b.s.u(paramj, "$holder");
    parama.a(paramca, paramj);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(342518);
  }
  
  private static final void a(a parama, ca paramca, com.tencent.mm.view.recyclerview.j paramj, com.tencent.mm.ui.base.s params)
  {
    int i = 1;
    AppMethodBeat.i(342528);
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramca, "$item");
    kotlin.g.b.s.u(paramj, "$holder");
    if (params.jmw())
    {
      if (paramca.getFeedObject().objectType == 1) {}
      while (i != 0)
      {
        params.c(Ezr, (CharSequence)paramj.context.getResources().getString(e.h.finder_awesome_ground_title_news));
        AppMethodBeat.o(342528);
        return;
        i = 0;
      }
      params.c(Ezr, (CharSequence)paramj.context.getResources().getString(e.h.finder_awesome_ground_title));
    }
    AppMethodBeat.o(342528);
  }
  
  private static final void a(a parama, com.tencent.mm.view.recyclerview.j paramj, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(342536);
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramj, "$holder");
    if (paramMenuItem.getItemId() == Ezr) {
      a(parama, paramj, true);
    }
    AppMethodBeat.o(342536);
  }
  
  private static final void a(a parama, com.tencent.mm.view.recyclerview.j paramj, View paramView)
  {
    AppMethodBeat.i(342489);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramj, "$holder");
    if (!parama.Ezo.sN(true))
    {
      paramj = paramj.context;
      if (paramj == null)
      {
        parama = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(342489);
        throw parama;
      }
      ((Activity)paramj).finish();
      ((MMFragmentActivity)parama.Ezo.CCa).overridePendingTransition(e.a.anim_not_change, e.a.sight_slide_bottom_out);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(342489);
  }
  
  private static final void a(a parama, com.tencent.mm.view.recyclerview.j paramj, ca paramca, View paramView)
  {
    AppMethodBeat.i(342555);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramj);
    localb.cH(paramca);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramca, "$item");
    ((MMFragmentActivity)parama.Ezo.CCa).setRequestedOrientation(12);
    parama.d(paramj, paramca);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(342555);
  }
  
  private static final void a(a parama, List paramList, com.tencent.mm.view.recyclerview.j paramj, View paramView)
  {
    AppMethodBeat.i(342512);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramList);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramList, "$viewList");
    kotlin.g.b.s.u(paramj, "$holder");
    localObject = paramView.getTag();
    if (localObject == null)
    {
      parama = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(342512);
      throw parama;
    }
    int i = ((Integer)localObject).intValue();
    parama.Ezo.EAS = i;
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      localObject = (TextView)paramList.next();
      if (kotlin.g.b.s.p(localObject, paramView))
      {
        if (localObject != null) {
          ((TextView)localObject).setTextColor(paramj.context.getResources().getColor(e.b.hot_tab_Orange_100));
        }
      }
      else if (localObject != null) {
        ((TextView)localObject).setTextColor(-1);
      }
    }
    float f = 0.5F * i;
    paramList = (FinderVideoLayout)paramj.UH(e.e.finder_banner_video_layout);
    if (paramList == null)
    {
      paramList = null;
      if (!(paramList instanceof FinderThumbPlayerProxy)) {
        break label442;
      }
      paramList = (FinderThumbPlayerProxy)paramList;
      label257:
      if (paramList != null) {
        paramList.setPlaySpeed(f);
      }
      paramList = com.tencent.mm.plugin.finder.megavideo.floatball.a.Ezy;
      com.tencent.mm.plugin.finder.megavideo.floatball.a.a.eCH().setPlaySpeed(f);
      a.g(paramj, i);
      switch (parama.Ezo.EAS)
      {
      default: 
        i = e.h.mega_video_play_speed_text_land;
        label329:
        ((TextView)paramj.UH(e.e.play_speed_ctrl_btn)).setText(i);
        if (parama.Ezo.EAS != 2) {
          break;
        }
      }
    }
    for (parama = paramj.context.getString(e.h.mega_video_play_speed_normal_times);; parama = paramj.context.getString(e.h.mega_video_play_speed_times, new Object[] { Float.valueOf(f) }))
    {
      kotlin.g.b.s.s(parama, "if (presenter.currentPla…_play_speed_times, ratio)");
      aa.makeText(paramj.context, (CharSequence)paramj.context.getString(e.h.mega_video_play_speed_change_toast, new Object[] { parama }), 0).show();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(342512);
      return;
      paramList = paramList.getVideoView();
      break;
      label442:
      paramList = null;
      break label257;
      i = e.h.mega_video_play_speed_0_5;
      break label329;
      i = e.h.mega_video_play_speed_text_land;
      break label329;
      i = e.h.mega_video_play_speed_1_5;
      break label329;
      i = e.h.mega_video_play_speed_2;
      break label329;
    }
  }
  
  private final void a(ca paramca, com.tencent.mm.view.recyclerview.j paramj)
  {
    int i = 0;
    AppMethodBeat.i(342377);
    Object localObject = av.GiL;
    if (!av.a(paramca.ABK))
    {
      paramca = av.GiL;
      paramca = paramj.context;
      kotlin.g.b.s.s(paramca, "holder.context");
      paramj = paramj.context.getString(e.h.finder_private_ban_share);
      kotlin.g.b.s.s(paramj, "holder.context.getString…finder_private_ban_share)");
      av.aO(paramca, paramj);
      AppMethodBeat.o(342377);
      return;
    }
    if (paramca.isPrivate())
    {
      aa.a(paramj.context, paramj.context.getString(e.h.finder_private_feed_share_click_toast), a..ExternalSyntheticLambda14.INSTANCE);
      AppMethodBeat.o(342377);
      return;
    }
    if (paramca.eDH())
    {
      localObject = av.GiL;
      localObject = av.eX("FinderSafeSelfSeeShare", e.h.finder_self_see_tips_sns);
      paramca = paramca.ABK;
      if (paramca == null)
      {
        paramca = null;
        if (paramca == null) {
          break label303;
        }
        if (paramca.size() > 2) {
          i = 1;
        }
        if (i == 0) {
          break label236;
        }
        label157:
        if (paramca == null) {
          break label303;
        }
      }
    }
    label303:
    for (paramca = paramca.get(1);; paramca = (ca)localObject)
    {
      localObject = av.GiL;
      paramj = paramj.context;
      kotlin.g.b.s.s(paramj, "holder.context");
      av.aO(paramj, (String)paramca);
      AppMethodBeat.o(342377);
      return;
      paramca = paramca.aaUw;
      if (paramca == null)
      {
        paramca = null;
        break;
      }
      paramca = n.a((CharSequence)paramca, new String[] { "#" });
      break;
      label236:
      paramca = null;
      break label157;
      localObject = new com.tencent.mm.ui.widget.a.f(paramj.context, 1, false);
      ((com.tencent.mm.ui.widget.a.f)localObject).Vtg = a..ExternalSyntheticLambda16.INSTANCE;
      ((com.tencent.mm.ui.widget.a.f)localObject).GAC = new a..ExternalSyntheticLambda17(this, paramca);
      ((com.tencent.mm.ui.widget.a.f)localObject).aeLi = new a..ExternalSyntheticLambda20(paramj);
      ((com.tencent.mm.ui.widget.a.f)localObject).dDn();
      AppMethodBeat.o(342377);
      return;
    }
  }
  
  private static void a(WeImageView paramWeImageView, brk parambrk)
  {
    AppMethodBeat.i(342435);
    if (parambrk == null)
    {
      parambrk = null;
      localObject = (CharSequence)parambrk;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label75;
      }
    }
    label75:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label80;
      }
      paramWeImageView.setImageResource(e.g.icons_filled_like_group);
      paramWeImageView.setIconColor(paramWeImageView.getContext().getResources().getColor(e.b.Red_90));
      AppMethodBeat.o(342435);
      return;
      parambrk = parambrk.ZZC;
      break;
    }
    label80:
    Object localObject = paramWeImageView.getDrawable();
    if (localObject != null) {
      ((Drawable)localObject).clearColorFilter();
    }
    paramWeImageView.setClearColorFilter(true);
    paramWeImageView.setIconColor(0);
    localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
    localObject = com.tencent.mm.plugin.finder.loader.p.eCl();
    parambrk = new com.tencent.mm.plugin.finder.loader.s(parambrk, v.FKY);
    paramWeImageView = (ImageView)paramWeImageView;
    com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
    ((com.tencent.mm.loader.d)localObject).a(parambrk, paramWeImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
    AppMethodBeat.o(342435);
  }
  
  private static final void a(com.tencent.mm.view.recyclerview.j paramj, a parama)
  {
    AppMethodBeat.i(342570);
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(parama, "this$0");
    if (paramj.context.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(342570);
      return;
    }
    ((MMFragmentActivity)parama.Ezo.CCa).setRequestedOrientation(-1);
    AppMethodBeat.o(342570);
  }
  
  private static final void a(com.tencent.mm.view.recyclerview.j paramj, a parama, View paramView)
  {
    AppMethodBeat.i(342463);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(parama, "this$0");
    paramView = (ca)paramj.CSA;
    localObject = new com.tencent.mm.ui.widget.a.f(paramj.context, 0, false);
    kotlin.g.b.s.s(paramView, "item");
    parama.c(paramj, paramView);
    a.g(paramj, 0);
    ((com.tencent.mm.ui.widget.a.f)localObject).Vtg = parama.Ezo.a(paramView, (com.tencent.mm.ui.widget.a.f)localObject);
    ((com.tencent.mm.ui.widget.a.f)localObject).GAz = parama.Ezo.a(paramView);
    ((com.tencent.mm.ui.widget.a.f)localObject).GAC = parama.Ezo.b(paramView, paramj);
    ((com.tencent.mm.ui.widget.a.f)localObject).agem = parama.Ezo.b(paramView, paramj);
    ((com.tencent.mm.ui.widget.a.f)localObject).aeLi = new a..ExternalSyntheticLambda19(paramj);
    ((com.tencent.mm.ui.widget.a.f)localObject).dDn();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(342463);
  }
  
  private static final void a(com.tencent.mm.view.recyclerview.j paramj, a parama, ca paramca, View paramView)
  {
    AppMethodBeat.i(342482);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parama);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramca);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramca, "$item");
    paramView = (FinderVideoLayout)paramj.UH(e.e.finder_banner_video_layout);
    int i;
    if (paramView == null)
    {
      i = 0;
      localObject1 = parama.Ezo;
      kotlin.g.b.s.u(paramca, "item");
      kotlin.g.b.s.u(paramj, "holder");
      Log.i("FinderLongVideoTLPresenter", "addVideoFloatBall: id = " + paramca.bZA() + ", videoCurrPlayTimes = " + i);
      if ((!com.tencent.mm.n.a.p((Context)((com.tencent.mm.plugin.finder.megavideo.ui.f)localObject1).CCa, true)) && (!com.tencent.mm.n.a.s((Context)((com.tencent.mm.plugin.finder.megavideo.ui.f)localObject1).CCa, true)) && (!com.tencent.mm.n.a.dp((Context)((com.tencent.mm.plugin.finder.megavideo.ui.f)localObject1).CCa)) && (!com.tencent.mm.n.a.u((Context)((com.tencent.mm.plugin.finder.megavideo.ui.f)localObject1).CCa, true))) {
        break label282;
      }
      Log.w("FinderLongVideoTLPresenter", kotlin.g.b.s.X("addVideoFloatBall: failed to add video float ball, id = ", Long.valueOf(paramca.bZA())));
    }
    label282:
    boolean bool;
    label381:
    dnq localdnq;
    do
    {
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(342482);
        return;
        i = paramView.getCurrentPosSec();
        break;
        bool = false;
        if (com.tencent.mm.n.a.q(null, false))
        {
          parama = com.tencent.mm.kernel.h.ax(g.class);
          kotlin.g.b.s.s(parama, "service(IFinderCommonLiveService::class.java)");
          ((g)parama).bUr();
          bool = true;
        }
        if (com.tencent.mm.compatible.e.b.dh((Context)((com.tencent.mm.plugin.finder.megavideo.ui.f)localObject1).CCa)) {
          break label381;
        }
        Log.w("FinderLongVideoTLPresenter", "showVideoTalking, permission denied");
        RequestFloatWindowPermissionDialog.a((Context)((com.tencent.mm.plugin.finder.megavideo.ui.f)localObject1).CCa, ((com.tencent.mm.plugin.finder.megavideo.ui.f)localObject1).CCa.getString(e.h.mega_video_float_permission_alert_content), (RequestFloatWindowPermissionDialog.a)new f.d(), false, com.tencent.mm.bq.a.aQB());
      }
      if (((com.tencent.mm.plugin.finder.megavideo.ui.f)localObject1).EAN == null) {
        ((com.tencent.mm.plugin.finder.megavideo.ui.f)localObject1).EAN = new dnq();
      }
      parama = com.tencent.mm.plugin.finder.megavideo.floatball.a.Ezy;
      localObject2 = com.tencent.mm.plugin.finder.megavideo.floatball.a.a.eCH();
      localdnq = ((com.tencent.mm.plugin.finder.megavideo.ui.f)localObject1).EAN;
    } while (localdnq == null);
    parama = paramca.contact;
    label438:
    label455:
    int j;
    if (parama == null)
    {
      parama = "";
      ((com.tencent.mm.plugin.finder.megavideo.floatball.a)localObject2).ahT(parama);
      parama = paramca.ABK;
      if (parama != null) {
        break label736;
      }
      parama = null;
      if (!Util.isNullOrNil(parama)) {
        break label766;
      }
      paramView = ((com.tencent.mm.plugin.finder.megavideo.ui.f)localObject1).CCa.getResources();
      j = e.h.mega_video_post_ui_desc_tv_hint;
      Context localContext = (Context)((com.tencent.mm.plugin.finder.megavideo.ui.f)localObject1).CCa;
      parama = paramca.contact;
      if (parama != null) {
        break label758;
      }
      parama = null;
      label497:
      parama = paramView.getString(j, new Object[] { com.tencent.mm.pluginsdk.ui.span.p.b(localContext, (CharSequence)parama) });
      label520:
      ((com.tencent.mm.plugin.finder.megavideo.floatball.a)localObject2).ahU(parama);
      parama = ((com.tencent.mm.plugin.finder.megavideo.ui.f)localObject1).CCa;
      if (!(parama instanceof FinderLongVideoTimelineUI)) {
        break label802;
      }
      parama = (FinderLongVideoTimelineUI)parama;
      label544:
      if (parama != null) {
        break label807;
      }
      j = 0;
      label551:
      localdnq.aaUP = j;
      localdnq.aaUO = i;
      paramView = ((com.tencent.mm.plugin.finder.megavideo.ui.f)localObject1).EzZ;
      parama = paramView;
      if (paramView == null)
      {
        kotlin.g.b.s.bIx("feedLoader");
        parama = null;
      }
      localdnq.lastBuffer = parama.getLastBuffer();
      localdnq.aaUM.clear();
      localdnq.aaUQ.clear();
      localdnq.aaUQ.add(paramca.getFeedObject());
      ((com.tencent.mm.plugin.finder.megavideo.floatball.a)localObject2).q("KEY_VIDEO_FLOAT_BALL_INFO", localdnq.toByteArray());
      ((com.tencent.mm.plugin.finder.megavideo.floatball.a)localObject2).a(paramj, bool, paramca.bZA(), paramca.eDF());
      paramj = new Intent();
      paramj.putExtra("KEY_VIDEO_START_PLAY_TIME_MS", i * 1000L);
      parama = paramca.ABK;
      if (parama != null) {
        break label816;
      }
    }
    label802:
    label807:
    label816:
    for (long l = 0L;; l = parama.id)
    {
      paramj.putExtra("KEY_CACHE_OBJECT_ID", l);
      ((com.tencent.mm.plugin.finder.megavideo.ui.f)localObject1).CCa.setResult(-1, paramj);
      ((com.tencent.mm.plugin.finder.megavideo.ui.f)localObject1).CCa.finish();
      break;
      paramView = parama.headUrl;
      parama = paramView;
      if (paramView != null) {
        break label438;
      }
      parama = "";
      break label438;
      label736:
      parama = parama.aaUt;
      if (parama == null)
      {
        parama = null;
        break label455;
      }
      parama = parama.description;
      break label455;
      label758:
      parama = parama.nickname;
      break label497;
      label766:
      parama = paramca.ABK;
      if (parama == null)
      {
        parama = null;
        break label520;
      }
      parama = parama.aaUt;
      if (parama == null)
      {
        parama = null;
        break label520;
      }
      parama = parama.description;
      break label520;
      parama = null;
      break label544;
      j = parama.Bqi;
      break label551;
    }
  }
  
  private static final void a(com.tencent.mm.view.recyclerview.j paramj, a parama, ca paramca, String paramString, View paramView)
  {
    AppMethodBeat.i(342495);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(parama);
    localb.cH(paramca);
    localb.cH(paramString);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramca, "$item");
    paramView = as.GSQ;
    paramView = paramj.context;
    kotlin.g.b.s.s(paramView, "holder.context");
    paramView = as.a.hu(paramView);
    if (paramView != null)
    {
      paramView = paramView.fou();
      if ((paramView == null) || (paramView.AJo != 48)) {}
    }
    for (int i = 1; i != 0; i = 0)
    {
      ((MMFragmentActivity)parama.Ezo.CCa).finish();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(342495);
      return;
    }
    parama.c(paramj, paramca);
    parama = new Intent();
    parama.putExtra("finder_username", paramString);
    parama.putExtra("KEY_FINDER_SELF_FLAG", kotlin.g.b.s.p(paramString, com.tencent.mm.model.z.bAW()));
    parama.putExtra("key_enter_profile_tab", 2);
    paramString = as.GSQ;
    paramString = paramj.context;
    kotlin.g.b.s.s(paramString, "holder.context");
    as.a.a(paramString, parama, paramca.eDF(), 1, false, 64);
    paramca = com.tencent.mm.plugin.finder.utils.a.GfO;
    paramj = paramj.context;
    kotlin.g.b.s.s(paramj, "holder.context");
    paramca.enterFinderProfileUI(paramj, parama);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(342495);
  }
  
  private final void a(com.tencent.mm.view.recyclerview.j paramj, ca paramca)
  {
    AppMethodBeat.i(342332);
    Object localObject1 = new a..ExternalSyntheticLambda2(this, paramj);
    Object localObject2 = paramj.UH(e.e.close_btn);
    if (localObject2 != null) {
      ((View)localObject2).setOnClickListener((View.OnClickListener)localObject1);
    }
    localObject1 = paramca.contact;
    label64:
    Object localObject3;
    label103:
    Object localObject4;
    Object localObject5;
    if (localObject1 == null)
    {
      localObject2 = null;
      if (localObject2 != null)
      {
        localObject1 = paramca.contact;
        if (localObject1 != null) {
          break label373;
        }
        localObject1 = null;
        localObject1 = Util.nullAsNil((String)localObject1);
        localObject3 = com.tencent.mm.plugin.finder.api.d.AwY;
        localObject3 = d.a.auT((String)localObject2);
        if (localObject3 == null) {
          break label430;
        }
        if (Util.isNullOrNil(((m)localObject3).amx())) {
          break label427;
        }
        localObject1 = ((m)localObject3).amx();
        localObject4 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
        kotlin.g.b.s.s(localObject4, "service(IFinderCommonService::class.java)");
        localObject4 = (com.tencent.mm.plugin.h)localObject4;
        localObject5 = paramj.UH(e.e.auth_icon);
        kotlin.g.b.s.s(localObject5, "holder.getView<ImageView>(R.id.auth_icon)");
        h.a.a((com.tencent.mm.plugin.h)localObject4, (ImageView)localObject5, ((m)localObject3).field_authInfo, 0, null, 12);
      }
    }
    label402:
    label420:
    label427:
    label430:
    for (;;)
    {
      localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject3 = com.tencent.mm.plugin.finder.loader.p.eCp();
      localObject1 = new com.tencent.mm.plugin.finder.loader.b((String)localObject1);
      localObject4 = paramj.UH(e.e.avatar_iv);
      kotlin.g.b.s.s(localObject4, "holder.getView(R.id.avatar_iv)");
      localObject4 = (ImageView)localObject4;
      localObject5 = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject3).a(localObject1, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
      localObject4 = (TextView)paramj.UH(e.e.nickname_tv);
      if (localObject4 != null)
      {
        localObject5 = paramj.context;
        localObject1 = paramca.contact;
        if (localObject1 != null) {
          break label381;
        }
        localObject1 = "";
      }
      for (;;)
      {
        ((TextView)localObject4).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject5, (CharSequence)localObject1));
        if (this.Ezo.EAO)
        {
          localObject1 = paramj.UH(e.e.avatar_layout);
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(8);
          }
        }
        localObject1 = paramj.UH(e.e.avatar_layout);
        if (localObject1 != null) {
          ((View)localObject1).setOnClickListener(new a..ExternalSyntheticLambda11(paramj, this, paramca, (String)localObject2));
        }
        if (!paramca.isPrivate()) {
          break label402;
        }
        paramj = paramj.UH(e.e.lock_icon);
        if (paramj == null) {
          break label420;
        }
        paramj.setVisibility(0);
        AppMethodBeat.o(342332);
        return;
        localObject2 = ((FinderContact)localObject1).username;
        break;
        label373:
        localObject1 = ((FinderContact)localObject1).headUrl;
        break label64;
        label381:
        localObject3 = ((FinderContact)localObject1).nickname;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
      }
      paramj = paramj.UH(e.e.lock_icon);
      if (paramj != null) {
        paramj.setVisibility(8);
      }
      AppMethodBeat.o(342332);
      return;
      break label103;
    }
  }
  
  private final void a(com.tencent.mm.view.recyclerview.j paramj, boolean paramBoolean, int paramInt, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(342396);
    ca localca = (ca)paramj.CSA;
    Object localObject1 = av.GiL;
    if (!av.b(localca.ABK))
    {
      paramMotionEvent = av.GiL;
      paramMotionEvent = paramj.context;
      kotlin.g.b.s.s(paramMotionEvent, "holder.context");
      paramj = paramj.context.getString(e.h.finder_private_ban_like);
      kotlin.g.b.s.s(paramj, "holder.context.getString….finder_private_ban_like)");
      av.aO(paramMotionEvent, paramj);
      AppMethodBeat.o(342396);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.upload.action.l.Gdj;
    boolean bool1 = ((Boolean)com.tencent.mm.plugin.finder.upload.action.l.fek().u(localca.getFeedObject()).bsC).booleanValue();
    WeImageView localWeImageView;
    Object localObject2;
    if (!bool1)
    {
      localWeImageView = i(paramj);
      localWeImageView.setLayerPaint(null);
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.h.FNM;
      localObject2 = com.tencent.mm.plugin.finder.storage.logic.h.TA(localca.getFeedObject().objectType);
      if (localObject2 == null)
      {
        localObject1 = "";
        if (!paramBoolean) {
          break label399;
        }
        a(localWeImageView, (brk)localObject2);
        label164:
        localObject1 = com.tencent.mm.plugin.finder.view.animation.c.GGo;
        com.tencent.mm.plugin.finder.view.animation.c.h((View)localWeImageView, paramMotionEvent);
        paramj.caK.performHapticFeedback(0, 3);
      }
    }
    else
    {
      paramj = this.Ezo;
      kotlin.g.b.s.s(localca, "item");
      if (bool1) {
        break label591;
      }
      bool1 = true;
      label210:
      kotlin.g.b.s.u(localca, "feed");
      paramMotionEvent = com.tencent.mm.ui.component.k.aeZF;
      paramMotionEvent = ((as)com.tencent.mm.ui.component.k.d(paramj.CCa).q(as.class)).fou();
      paramj = com.tencent.mm.plugin.finder.model.an.ECX;
      paramj = FinderItem.Companion;
      localObject1 = FinderItem.a.e(localca.getFeedObject(), 32768);
      paramj = com.tencent.mm.plugin.finder.upload.action.l.Gdj;
      boolean bool2 = ((Boolean)com.tencent.mm.plugin.finder.upload.action.l.fek().u(localca.getFeedObject()).bsD).booleanValue();
      paramj = aw.Gjk;
      paramj = localca.contact;
      if (paramj != null) {
        break label597;
      }
      paramj = null;
      label307:
      com.tencent.mm.plugin.finder.model.an.a(paramMotionEvent, paramInt, (FinderItem)localObject1, bool1, paramBoolean, 2, false, bool2, aw.n(paramj));
      paramj = new if();
      paramj.hJB.id = localca.eDF();
      paramj.hJB.type = 4;
      paramMotionEvent = paramj.hJB;
      if (!bool1) {
        break label612;
      }
      if (!paramBoolean) {
        break label607;
      }
      paramInt = 2;
    }
    for (;;)
    {
      paramMotionEvent.hJE = paramInt;
      paramj.publish();
      AppMethodBeat.o(342396);
      return;
      localObject1 = ((brk)localObject2).ZZx;
      break;
      label399:
      localObject2 = aw.Gjk;
      localObject2 = localca.contact;
      if (localObject2 == null) {}
      for (localObject2 = null;; localObject2 = com.tencent.mm.plugin.finder.api.c.a((FinderContact)localObject2, null, false))
      {
        if (!aw.n((m)localObject2)) {
          break label470;
        }
        localWeImageView.setImageDrawable(bb.m(paramj.context, e.g.finder_filled_like_lock, paramj.context.getResources().getColor(e.b.Red_90)));
        break;
      }
      label470:
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label560;
        }
        localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject2 = com.tencent.mm.plugin.finder.loader.p.eCl();
        localObject1 = new com.tencent.mm.plugin.finder.loader.s((String)localObject1, v.FKY);
        ImageView localImageView = (ImageView)localWeImageView;
        com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((com.tencent.mm.loader.d)localObject2).a(localObject1, localImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
        break;
      }
      label560:
      localWeImageView.setImageDrawable(bb.m(paramj.context, e.g.finder_full_like, paramj.context.getResources().getColor(e.b.Red_90)));
      break label164;
      label591:
      bool1 = false;
      break label210;
      label597:
      paramj = com.tencent.mm.plugin.finder.api.c.a(paramj, null, false);
      break label307;
      label607:
      paramInt = 1;
      continue;
      label612:
      paramInt = 0;
    }
  }
  
  private final void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, com.tencent.mm.view.recyclerview.j paramj, ca paramca)
  {
    int j = 1;
    AppMethodBeat.i(342426);
    Object localObject2 = (WeImageView)paramj.UH(e.e.mega_video_like);
    Object localObject1;
    label79:
    int i;
    int k;
    Object localObject3;
    label143:
    boolean bool;
    if (paramBoolean1) {
      if (paramBoolean2)
      {
        ((WeImageView)localObject2).setTag(Integer.valueOf(2));
        localObject1 = new kotlin.r(Integer.valueOf(a(true, paramBoolean2, paramca.getFeedObject())), Integer.valueOf(paramj.context.getResources().getColor(e.b.Red_90)));
        i = ((Number)((kotlin.r)localObject1).bsC).intValue();
        k = ((Number)((kotlin.r)localObject1).bsD).intValue();
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.h.FNM;
        localObject3 = com.tencent.mm.plugin.finder.storage.logic.h.TA(paramca.getFeedObject().objectType);
        localObject1 = aw.Gjk;
        localObject1 = paramca.contact;
        if (localObject1 != null) {
          break label305;
        }
        localObject1 = null;
        bool = aw.n((m)localObject1);
        if ((!paramBoolean2) || (!paramBoolean1) || (bool)) {
          break label317;
        }
        kotlin.g.b.s.s(localObject2, "likeIv");
        a((WeImageView)localObject2, (brk)localObject3);
        label178:
        if (!this.Ezo.EAO) {
          break label460;
        }
        i = 1;
        label191:
        localObject1 = (TextView)paramj.UH(e.e.mega_video_like_count_tv);
        if (paramInt <= 0) {
          break label466;
        }
        paramj = com.tencent.mm.plugin.finder.utils.r.ip(i, paramInt);
        kotlin.g.b.s.s(paramj, "formatNumber(scene, likeCount)");
      }
    }
    for (;;)
    {
      ((TextView)localObject1).setText((CharSequence)paramj);
      AppMethodBeat.o(342426);
      return;
      ((WeImageView)localObject2).setTag(Integer.valueOf(1));
      break;
      ((WeImageView)localObject2).setTag(Integer.valueOf(0));
      localObject1 = new kotlin.r(Integer.valueOf(a(false, paramBoolean2, paramca.getFeedObject())), Integer.valueOf(paramj.context.getResources().getColor(e.b.hot_tab_BW_100_Alpha_0_8)));
      break label79;
      label305:
      localObject1 = com.tencent.mm.plugin.finder.api.c.a((FinderContact)localObject1, null, false);
      break label143;
      label317:
      if ((localObject3 != null) && (!bool) && (!paramBoolean2))
      {
        if (paramBoolean1) {}
        for (localObject1 = ((brk)localObject3).ZZx;; localObject1 = ((brk)localObject3).ZZE)
        {
          localObject3 = ((WeImageView)localObject2).getDrawable();
          if (localObject3 != null) {
            ((Drawable)localObject3).clearColorFilter();
          }
          ((WeImageView)localObject2).setClearColorFilter(true);
          ((WeImageView)localObject2).setIconColor(0);
          localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
          localObject3 = com.tencent.mm.plugin.finder.loader.p.eCl();
          localObject1 = new com.tencent.mm.plugin.finder.loader.s((String)localObject1, v.FKY);
          kotlin.g.b.s.s(localObject2, "likeIv");
          localObject2 = (ImageView)localObject2;
          com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
          ((com.tencent.mm.loader.d)localObject3).a(localObject1, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
          break;
        }
      }
      ((WeImageView)localObject2).setImageResource(i);
      ((WeImageView)localObject2).setIconColor(k);
      break label178;
      label460:
      i = 2;
      break label191;
      label466:
      localObject2 = com.tencent.mm.plugin.finder.storage.logic.h.FNM;
      paramca = com.tencent.mm.plugin.finder.storage.logic.h.TA(paramca.getFeedObject().objectType);
      if (paramca != null)
      {
        localObject2 = (CharSequence)paramca.ZZB;
        paramInt = j;
        if (localObject2 != null) {
          if (((CharSequence)localObject2).length() != 0) {
            break label548;
          }
        }
      }
      label548:
      for (paramInt = j;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label553;
        }
        paramj = paramj.context.getString(e.h.finder_like_count_text);
        kotlin.g.b.s.s(paramj, "holder.context.getString…g.finder_like_count_text)");
        break;
      }
      label553:
      paramca = paramca.ZZB;
      paramj = paramca;
      if (paramca == null) {
        paramj = "";
      }
    }
  }
  
  private static final boolean a(ca paramca, com.tencent.mm.view.recyclerview.j paramj, a parama, View paramView)
  {
    AppMethodBeat.i(342545);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramca);
    localb.cH(paramj);
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    kotlin.g.b.s.u(paramca, "$item");
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(parama, "this$0");
    paramView = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eTw().bmg()).intValue() == 1)
    {
      paramView = aw.Gjk;
      paramView = paramca.contact;
      if (paramView != null) {
        break label244;
      }
    }
    label244:
    for (paramView = null;; paramView = com.tencent.mm.plugin.finder.api.c.a(paramView))
    {
      if (!aw.n(paramView))
      {
        paramView = (WeImageView)paramj.UH(e.e.mega_video_like);
        if (((paramView.getTag() instanceof Integer)) && (kotlin.g.b.s.p(paramView.getTag(), Integer.valueOf(0))))
        {
          paramView = new com.tencent.mm.ui.widget.a.f(paramj.context, 1, true);
          paramView.Vtg = new a..ExternalSyntheticLambda15(parama, paramca, paramj);
          paramView.GAC = new a..ExternalSyntheticLambda18(parama, paramj);
          paramView.dDn();
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(342545);
      return true;
    }
  }
  
  private static final void b(a parama, com.tencent.mm.view.recyclerview.j paramj, View paramView)
  {
    AppMethodBeat.i(342522);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramj, "$holder");
    if (parama.Ezo.EAO)
    {
      paramView = (ca)paramj.CSA;
      parama = paramj.context;
      if ((parama instanceof Activity))
      {
        parama = (Activity)parama;
        if (parama != null)
        {
          parama = (FinderLikeDrawer)parama.findViewById(e.e.finder_feed_all_like_drawer);
          if (parama != null)
          {
            paramj = FinderItem.Companion;
            parama.a(FinderItem.a.e(paramView.getFeedObject(), 32768), null);
          }
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(342522);
      return;
      parama = null;
      break;
      a(parama, paramj, false);
    }
  }
  
  private static final void b(a parama, com.tencent.mm.view.recyclerview.j paramj, ca paramca, View paramView)
  {
    AppMethodBeat.i(342563);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramj);
    localb.cH(paramca);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramca, "$item");
    parama.d(paramj, paramca);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(342563);
  }
  
  private static final void b(com.tencent.mm.view.recyclerview.j paramj, a parama, View paramView)
  {
    AppMethodBeat.i(342502);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(parama, "this$0");
    a.a(paramj, parama.Ezo);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(342502);
  }
  
  private static final void b(com.tencent.mm.view.recyclerview.j paramj, a parama, ca paramca, View paramView)
  {
    AppMethodBeat.i(342589);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parama);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramca);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramca, "$item");
    paramView = paramj.context;
    if (paramView == null)
    {
      paramj = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(342589);
      throw paramj;
    }
    ((MMActivity)paramView).hideVKB();
    ((MMFragmentActivity)parama.Ezo.CCa).setRequestedOrientation(11);
    a.E(paramj);
    parama = as.GSQ;
    paramj = paramj.context;
    kotlin.g.b.s.s(paramj, "holder.context");
    paramj = as.a.hu(paramj);
    long l;
    if (paramj == null)
    {
      paramView = null;
      paramj = ax.Fur;
      paramj = paramca.ABK;
      if (paramj != null) {
        break label277;
      }
      l = 0L;
      label188:
      localObject1 = com.tencent.mm.ae.d.hF(l);
      localObject2 = com.tencent.mm.ae.d.hF(paramca.bZA());
      if (paramView != null) {
        break label301;
      }
      paramj = "";
      label212:
      if (paramView != null) {
        break label319;
      }
      parama = "";
      label220:
      if (paramView != null) {
        break label337;
      }
      paramca = "";
    }
    for (;;)
    {
      ax.a((String)localObject1, (String)localObject2, 1, 1, paramj, parama, paramca);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(342589);
      return;
      paramView = paramj.fou();
      break;
      label277:
      paramj = paramj.aaUv;
      if (paramj == null)
      {
        l = 0L;
        break label188;
      }
      l = paramj.hKN;
      break label188;
      label301:
      parama = paramView.sessionId;
      paramj = parama;
      if (parama != null) {
        break label212;
      }
      paramj = "";
      break label212;
      label319:
      paramca = paramView.zIO;
      parama = paramca;
      if (paramca != null) {
        break label220;
      }
      parama = "";
      break label220;
      label337:
      paramView = paramView.zIB;
      paramca = paramView;
      if (paramView == null) {
        paramca = "";
      }
    }
  }
  
  private final void b(com.tencent.mm.view.recyclerview.j paramj, ca paramca)
  {
    AppMethodBeat.i(342351);
    Object localObject1 = paramj.UH(e.e.warn_layout);
    Object localObject2 = paramca.ABK;
    int i;
    label69:
    label76:
    NeatTextView localNeatTextView;
    label104:
    int j;
    if (localObject2 == null)
    {
      i = 0;
      if (i == 0) {
        break label555;
      }
      ((View)localObject1).setVisibility(0);
      localObject2 = (TextView)paramj.UH(e.e.warn_word_tv);
      localObject1 = paramca.ABK;
      if (localObject1 != null) {
        break label522;
      }
      localObject1 = (CharSequence)"";
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localNeatTextView = (NeatTextView)paramj.UH(e.e.description_tv);
      localObject1 = paramca.ABK;
      if (localObject1 != null) {
        break label565;
      }
      localObject1 = "";
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label653;
      }
      localNeatTextView.setVisibility(0);
      Context localContext = paramj.context;
      localObject1 = paramca.ABK;
      if (localObject1 != null) {
        break label609;
      }
      localObject1 = "";
      label143:
      localNeatTextView.aZ((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(localContext, (CharSequence)localObject1));
      if (localNeatTextView != null) {
        localNeatTextView.setOnClickListener(new a..ExternalSyntheticLambda5(this, paramj, paramca));
      }
      label181:
      localObject1 = paramj.UH(e.e.mega_video_share_layout);
      if (localObject1 != null)
      {
        ((View)localObject1).setOnClickListener(new a..ExternalSyntheticLambda0(this, paramca, paramj));
        i = paramca.getFeedObject().forwardCount;
        localObject2 = com.tencent.mm.plugin.finder.upload.action.c.GcH;
        j = i + com.tencent.mm.plugin.finder.upload.action.c.fee().t(paramca.getFeedObject()) + paramca.getFeedObject().wx_status_ref_count;
        if (j <= 0) {
          break label668;
        }
        if (!this.Ezo.EAO) {
          break label663;
        }
        i = 1;
      }
    }
    label262:
    label522:
    label653:
    label663:
    label668:
    for (localObject1 = com.tencent.mm.plugin.finder.utils.r.ip(i, j);; localObject1 = ((View)localObject1).getContext().getString(e.h.finder_share_icon_text))
    {
      ((TextView)paramj.UH(e.e.mega_video_share_count_tv)).setText((CharSequence)localObject1);
      localObject1 = paramj.UH(e.e.mega_video_like_layout);
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener(new a..ExternalSyntheticLambda1(this, paramj));
      }
      localObject1 = paramj.UH(e.e.mega_video_like_layout);
      if (localObject1 != null) {
        ((View)localObject1).setOnLongClickListener(new a..ExternalSyntheticLambda12(paramca, paramj, this));
      }
      localObject1 = paramj.UH(e.e.mega_video_like_layout);
      if (localObject1 != null) {
        ((View)localObject1).setHapticFeedbackEnabled(false);
      }
      paramj.UH(e.e.mega_video_comment_layout).setOnClickListener(new a..ExternalSyntheticLambda4(this, paramj, paramca));
      localObject1 = com.tencent.mm.plugin.finder.upload.action.c.GcH;
      com.tencent.mm.plugin.finder.upload.action.c.fee().s(paramca.getFeedObject());
      localObject1 = com.tencent.mm.plugin.finder.upload.action.c.GcH;
      com.tencent.mm.plugin.finder.upload.action.c.fee().t(paramca.getFeedObject());
      localObject1 = com.tencent.mm.plugin.finder.upload.action.l.Gdj;
      boolean bool1 = ((Boolean)com.tencent.mm.plugin.finder.upload.action.l.fek().u(paramca.getFeedObject()).bsC).booleanValue();
      localObject1 = com.tencent.mm.plugin.finder.upload.action.l.Gdj;
      boolean bool2 = ((Boolean)com.tencent.mm.plugin.finder.upload.action.l.fek().u(paramca.getFeedObject()).bsD).booleanValue();
      localObject1 = com.tencent.mm.plugin.finder.upload.action.l.Gdj;
      a(bool1, bool2, com.tencent.mm.plugin.finder.upload.action.l.fek().v(paramca.getFeedObject()), paramj, paramca);
      f(paramj, paramca.getFeedObject().commentCount);
      AppMethodBeat.o(342351);
      return;
      i = ((dne)localObject2).aaUy;
      break;
      localObject1 = ((dne)localObject1).aaUz;
      if (localObject1 == null)
      {
        localObject1 = (CharSequence)"";
        break label69;
      }
      localObject1 = (CharSequence)localObject1;
      break label69;
      label555:
      ((View)localObject1).setVisibility(8);
      break label76;
      label565:
      localObject1 = ((dne)localObject1).aaUt;
      if (localObject1 == null)
      {
        localObject1 = "";
        break label104;
      }
      localObject2 = ((dnh)localObject1).description;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label104;
      }
      localObject1 = "";
      break label104;
      label609:
      localObject1 = ((dne)localObject1).aaUt;
      if (localObject1 == null)
      {
        localObject1 = "";
        break label143;
      }
      localObject2 = ((dnh)localObject1).description;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label143;
      }
      localObject1 = "";
      break label143;
      localNeatTextView.setVisibility(8);
      break label181;
      i = 2;
      break label262;
    }
  }
  
  private static final void c(a parama, com.tencent.mm.view.recyclerview.j paramj, ca paramca, View paramView)
  {
    AppMethodBeat.i(342579);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parama);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramca);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramca, "$item");
    ((MMFragmentActivity)parama.Ezo.CCa).setRequestedOrientation(12);
    paramView.postDelayed(new a..ExternalSyntheticLambda21(paramj, parama), 2000L);
    parama = as.GSQ;
    parama = paramj.context;
    kotlin.g.b.s.s(parama, "holder.context");
    parama = as.a.hu(parama);
    long l;
    if (parama == null)
    {
      paramView = null;
      parama = ax.Fur;
      parama = paramca.ABK;
      if (parama != null) {
        break label255;
      }
      l = 0L;
      label166:
      localObject1 = com.tencent.mm.ae.d.hF(l);
      localObject2 = com.tencent.mm.ae.d.hF(paramca.bZA());
      if (paramView != null) {
        break label279;
      }
      parama = "";
      label190:
      if (paramView != null) {
        break label297;
      }
      paramj = "";
      label198:
      if (paramView != null) {
        break label315;
      }
      paramca = "";
    }
    for (;;)
    {
      ax.a((String)localObject1, (String)localObject2, 1, 2, parama, paramj, paramca);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(342579);
      return;
      paramView = parama.fou();
      break;
      label255:
      parama = parama.aaUv;
      if (parama == null)
      {
        l = 0L;
        break label166;
      }
      l = parama.hKN;
      break label166;
      label279:
      paramj = paramView.sessionId;
      parama = paramj;
      if (paramj != null) {
        break label190;
      }
      parama = "";
      break label190;
      label297:
      paramca = paramView.zIO;
      paramj = paramca;
      if (paramca != null) {
        break label198;
      }
      paramj = "";
      break label198;
      label315:
      paramView = paramView.zIB;
      paramca = paramView;
      if (paramView == null) {
        paramca = "";
      }
    }
  }
  
  private final boolean c(com.tencent.mm.view.recyclerview.j paramj, ca paramca)
  {
    boolean bool = false;
    AppMethodBeat.i(342363);
    Object localObject = paramj.UH(e.e.mega_video_bullet_input_layout);
    if ((localObject == null) || (((View)localObject).getVisibility() != 0))
    {
      AppMethodBeat.o(342363);
      return false;
    }
    a.a(paramj, paramca, (Activity)this.Ezo.CCa, Boolean.TRUE);
    ((View)localObject).setVisibility(8);
    paramca = paramj.context;
    if (paramca == null)
    {
      paramj = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(342363);
      throw paramj;
    }
    ((MMActivity)paramca).hideVKB();
    int i = this.Ezo.EAR;
    paramca = com.tencent.mm.plugin.finder.megavideo.ui.f.EAJ;
    if (i == com.tencent.mm.plugin.finder.megavideo.ui.f.eCV())
    {
      if (paramj.context.getResources().getConfiguration().orientation != 2) {
        break label315;
      }
      i = 1;
      paramca = paramj.getRecyclerView().getLayoutManager();
      if (!(paramca instanceof FinderLinearLayoutManager)) {
        break label320;
      }
    }
    label315:
    label320:
    for (paramca = (FinderLinearLayoutManager)paramca;; paramca = null)
    {
      if (paramca != null)
      {
        if (i == 0) {
          bool = true;
        }
        paramca.GHU = bool;
      }
      paramca = (WeImageView)paramj.UH(e.e.mega_video_input_emoji);
      if (paramca != null)
      {
        paramca.setImageResource(e.g.icons_filled_sticker);
        paramca.setIconColor(-1);
      }
      this.Ezo.getSmileyPanel().animate().alpha(0.0F).setDuration(220L).setListener((Animator.AnimatorListener)new h(this)).start();
      if (paramj.UH(e.e.mega_video_bullet_input_layout).getVisibility() == 0)
      {
        paramca = this.Ezo;
        localObject = com.tencent.mm.plugin.finder.megavideo.ui.f.EAJ;
        paramca.EAR = com.tencent.mm.plugin.finder.megavideo.ui.f.eCU();
      }
      paramca = this.Ezo;
      localObject = com.tencent.mm.plugin.finder.megavideo.ui.f.EAJ;
      paramca.EAR = com.tencent.mm.plugin.finder.megavideo.ui.f.eCT();
      paramj = (MegaVideoInputLayout)paramj.UH(e.e.mega_video_bullet_input_layout);
      if (paramj != null) {
        paramj.eCW();
      }
      AppMethodBeat.o(342363);
      return true;
      i = 0;
      break;
    }
  }
  
  private final void d(final com.tencent.mm.view.recyclerview.j paramj, final ca paramca)
  {
    Object localObject1 = null;
    AppMethodBeat.i(342413);
    Object localObject2;
    if (!this.Ezo.EAO)
    {
      localObject2 = av.GiL;
      if (!av.b(paramca))
      {
        localObject2 = aw.Gjk;
        localObject2 = paramca.contact;
        if (localObject2 == null)
        {
          if (!aw.n((m)localObject1)) {
            break label166;
          }
          localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
          com.tencent.mm.plugin.finder.storage.d.Tl(2);
        }
      }
    }
    label166:
    for (boolean bool = true;; bool = false)
    {
      paramj = new i(this, paramj, paramca);
      localObject1 = this.Ezo;
      localObject2 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.i)com.tencent.mm.ui.component.k.d(((com.tencent.mm.plugin.finder.megavideo.ui.f)localObject1).CCa).q(com.tencent.mm.plugin.finder.viewmodel.component.i.class)).ATy;
      if (localObject1 != null)
      {
        localObject2 = FinderItem.Companion;
        com.tencent.mm.plugin.finder.view.f.a((com.tencent.mm.plugin.finder.view.f)localObject1, FinderItem.a.e(paramca.getFeedObject(), 32768), 0L, false, true, bool, (CommentDrawerContract.CloseDrawerCallback)paramj, 0L, 1710);
      }
      AppMethodBeat.o(342413);
      return;
      localObject1 = com.tencent.mm.plugin.finder.api.c.a((FinderContact)localObject2, null, false);
      break;
    }
  }
  
  private final void f(com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    AppMethodBeat.i(342403);
    int i;
    if (this.Ezo.EAO)
    {
      i = 1;
      if (paramInt <= 0) {
        break label59;
      }
    }
    label59:
    for (String str = com.tencent.mm.plugin.finder.utils.r.ip(i, paramInt);; str = paramj.context.getString(e.h.finder_comment_count_text))
    {
      ((TextView)paramj.UH(e.e.mega_video_comment_count_tv)).setText((CharSequence)str);
      AppMethodBeat.o(342403);
      return;
      i = 2;
      break;
    }
  }
  
  private static final void gu(View paramView)
  {
    AppMethodBeat.i(342594);
    if (paramView != null)
    {
      paramView = (TextView)paramView.findViewById(e.e.toast_text);
      if (paramView != null) {
        paramView.setTextSize(1, 14.0F);
      }
    }
    AppMethodBeat.o(342594);
  }
  
  private static final void h(com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(342596);
    if (params.jmw())
    {
      params.oh(10001, e.h.finder_share_to_friend);
      params.oh(10002, e.h.finder_share_to_sns);
    }
    AppMethodBeat.o(342596);
  }
  
  private static WeImageView i(com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(342420);
    WeImageView localWeImageView = new WeImageView(paramj.context);
    localWeImageView.setVisibility(4);
    int i = (int)paramj.context.getResources().getDimension(e.c.Edge_6_5_A);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, i);
    localLayoutParams.gravity = 17;
    kotlin.ah localah = kotlin.ah.aiuX;
    localWeImageView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
    localWeImageView.setImageResource(e.g.finder_full_like);
    localWeImageView.setIconColor(paramj.context.getResources().getColor(e.b.Red_90));
    paramj = paramj.UH(e.e.media_container);
    if ((paramj instanceof ViewGroup)) {}
    for (paramj = (ViewGroup)paramj;; paramj = null)
    {
      if (paramj != null) {
        paramj.addView((View)localWeImageView);
      }
      AppMethodBeat.o(342420);
      return localWeImageView;
    }
  }
  
  private static final boolean i(com.tencent.mm.view.recyclerview.j paramj, View paramView)
  {
    AppMethodBeat.i(342451);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramj, "$holder");
    localObject1 = (ca)paramj.CSA;
    paramView = (FinderVideoLayout)paramj.UH(e.e.finder_banner_video_layout);
    if (paramView == null) {
      paramView = null;
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.ui.component.k.aeZF;
      localObject2 = paramj.context;
      if (localObject2 != null) {
        break;
      }
      paramj = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
      AppMethodBeat.o(342451);
      throw paramj;
      paramView = paramView.getPlayInfo();
      if (paramView == null) {
        paramView = null;
      } else {
        paramView = paramView.EEv;
      }
    }
    localObject2 = (com.tencent.mm.plugin.finder.viewmodel.component.k)com.tencent.mm.ui.component.k.d((AppCompatActivity)localObject2).q(com.tencent.mm.plugin.finder.viewmodel.component.k.class);
    Context localContext = paramj.context;
    kotlin.g.b.s.s(localContext, "holder.context");
    kotlin.g.b.s.s(localObject1, "item");
    ((com.tencent.mm.plugin.finder.viewmodel.component.k)localObject2).a(localContext, (ca)localObject1, paramView, paramj);
    paramj.caK.requestLayout();
    com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(342451);
    return true;
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    AppMethodBeat.i(342788);
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    kotlin.g.b.s.u(paramj, "holder");
    paramj = (FinderMediaBanner)paramj.UH(e.e.media_banner);
    FinderMediaBannerAdapter localFinderMediaBannerAdapter = new FinderMediaBannerAdapter(this.AJn);
    localFinderMediaBannerAdapter.isLongVideo = true;
    kotlin.ah localah = kotlin.ah.aiuX;
    paramj.setAdapter((RecyclerView.a)localFinderMediaBannerAdapter);
    paramj.setParentRecyclerView(paramRecyclerView);
    paramj.getIndicator().setShowOnlyOneIndicator(false);
    AppMethodBeat.o(342788);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_long_video_item;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$Companion;", "", "()V", "ANIM_DURATION", "", "BULLET_TEXT_LIMIT", "", "getBULLET_TEXT_LIMIT", "()I", "BULLET_TEXT_LIMIT$delegate", "Lkotlin/Lazy;", "FULLSCREEN_FLAG", "MENU_ID_ONLY_POSTER_CAN_SEE", "MENU_ID_SHARE_TO_FRIEND", "MENU_ID_SHARE_TO_SNS", "TAG", "", "payloadsProgressType", "payloadsRefreshBullet", "payloadsRefreshFav", "payloadsRefreshLike", "payloadsRefreshNormalData", "hidePlaySpeedCtrlLayout", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "playTimesTag", "onConfigurationChange", "", "isLandscape", "resetAnimViews", "showPlaySpeedCtrlLayout", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;", "toggleHeaderFooter", "item", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "activity", "Landroid/app/Activity;", "forceShow", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;Landroid/app/Activity;Ljava/lang/Boolean;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void E(com.tencent.mm.view.recyclerview.j paramj)
    {
      AppMethodBeat.i(342264);
      Object localObject = (MegaVideoInputLayout)paramj.UH(e.e.mega_video_bullet_input_layout);
      if (localObject != null)
      {
        ((MegaVideoInputLayout)localObject).setListenKeyBoardChange(false);
        ((MegaVideoInputLayout)localObject).setShowKeyboard(false);
        ((MegaVideoInputLayout)localObject).setTranslationY(0.0F);
      }
      localObject = (FinderMediaBanner)paramj.UH(e.e.media_banner);
      if (localObject != null)
      {
        localObject = ((FinderMediaBanner)localObject).getPagerViewContainer();
        if (localObject != null)
        {
          ((FrameLayout)localObject).setTranslationY(0.0F);
          ((FrameLayout)localObject).setScaleX(1.0F);
          ((FrameLayout)localObject).setScaleY(1.0F);
        }
      }
      localObject = paramj.UH(e.e.unfold_video_button);
      if (localObject != null) {
        ((View)localObject).setTranslationY(0.0F);
      }
      paramj = (MegaVideoInputLayout)paramj.UH(e.e.mega_video_bullet_input_layout);
      if (paramj != null)
      {
        paramj.eCW();
        paramj.reset();
      }
      AppMethodBeat.o(342264);
    }
    
    public static void a(com.tencent.mm.view.recyclerview.j paramj, com.tencent.mm.plugin.finder.megavideo.ui.f paramf)
    {
      AppMethodBeat.i(342288);
      kotlin.g.b.s.u(paramj, "holder");
      kotlin.g.b.s.u(paramf, "presenter");
      Object localObject = paramj.UH(e.e.footer_layout);
      if (localObject != null) {
        ((View)localObject).animate().alpha(0.0F).setDuration(300L).setListener((Animator.AnimatorListener)new b((View)localObject));
      }
      int i;
      Iterator localIterator;
      label167:
      label253:
      int j;
      if (paramj.context.getResources().getConfiguration().orientation == 2)
      {
        i = 1;
        localObject = (LinearLayout)paramj.UH(e.e.play_speed_control_container);
        if (localObject != null) {
          localIterator = ((Iterable)kotlin.a.p.listOf(new TextView[] { (TextView)paramj.UH(e.e.speed_0_5), (TextView)paramj.UH(e.e.speed_1), (TextView)paramj.UH(e.e.speed_1_5), (TextView)paramj.UH(e.e.speed_2) })).iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label267;
          }
          TextView localTextView = (TextView)localIterator.next();
          if (localTextView == null) {}
          for (boolean bool = false;; bool = kotlin.g.b.s.p(localTextView.getTag(), Integer.valueOf(paramf.EAS)))
          {
            if (!bool) {
              break label253;
            }
            if (localTextView == null) {
              break label167;
            }
            localTextView.setTextColor(paramj.context.getResources().getColor(e.b.hot_tab_Orange_100));
            break label167;
            i = 0;
            break;
          }
          if (localTextView != null) {
            localTextView.setTextColor(-1);
          }
        }
        label267:
        j = paramj.context.getResources().getDimensionPixelOffset(e.c.finder_mega_video_play_ctrl_layout_width);
        if (i == 0) {
          break label474;
        }
        paramf = ((LinearLayout)localObject).getLayoutParams();
        if (paramf == null)
        {
          paramj = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(342288);
          throw paramj;
        }
        paramf = (FrameLayout.LayoutParams)paramf;
        paramf.gravity = 5;
        paramf.height = -1;
        paramf.width = j;
        ((LinearLayout)localObject).setPadding(0, 0, paramj.context.getResources().getDimensionPixelOffset(e.c.finder_mega_video_play_ctrl_layout_padding_end), 0);
        ((LinearLayout)localObject).setBackgroundResource(e.d.mega_video_play_ctrl_layout_bg_land);
        ((LinearLayout)localObject).setOrientation(1);
        ((LinearLayout)localObject).requestLayout();
        ((LinearLayout)localObject).setTranslationX(j);
        ((LinearLayout)localObject).animate().translationY(0.0F).translationX(0.0F).setDuration(300L).setListener(null).start();
        ((LinearLayout)localObject).setVisibility(0);
      }
      paramf = (ca)paramj.CSA;
      localObject = as.GSQ;
      paramj = paramj.context;
      kotlin.g.b.s.s(paramj, "holder.context");
      paramj = as.a.hu(paramj);
      if (paramj == null) {}
      for (paramj = null;; paramj = paramj.fou())
      {
        localObject = ax.Fur;
        ax.a(paramj, "speedplay", paramf.eDF(), paramf.bZA());
        AppMethodBeat.o(342288);
        return;
        label474:
        paramf = ((LinearLayout)localObject).getLayoutParams();
        if (paramf == null)
        {
          paramj = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(342288);
          throw paramj;
        }
        paramf = (FrameLayout.LayoutParams)paramf;
        paramf.gravity = 80;
        paramf.height = j;
        paramf.width = -1;
        ((LinearLayout)localObject).setPadding(0, 0, 0, paramj.context.getResources().getDimensionPixelOffset(e.c.Edge_7A));
        ((LinearLayout)localObject).setBackgroundResource(e.d.mega_video_play_ctrl_layout_bg);
        ((LinearLayout)localObject).setOrientation(0);
        ((LinearLayout)localObject).requestLayout();
        ((LinearLayout)localObject).setTranslationY(j);
        break;
      }
    }
    
    public static void a(com.tencent.mm.view.recyclerview.j paramj, ca paramca, Activity paramActivity, Boolean paramBoolean)
    {
      int j = 0;
      AppMethodBeat.i(342275);
      kotlin.g.b.s.u(paramj, "holder");
      kotlin.g.b.s.u(paramca, "item");
      kotlin.g.b.s.u(paramActivity, "activity");
      View localView1 = paramj.UH(e.e.menu_layout);
      View localView2 = paramj.UH(e.e.footer_layout);
      if (localView2.getVisibility() == 0) {}
      for (int i = 8; kotlin.g.b.s.p(paramBoolean, Boolean.TRUE); i = 0)
      {
        i = j;
        if (localView2.getVisibility() != 0) {
          break label125;
        }
        AppMethodBeat.o(342275);
        return;
      }
      if (kotlin.g.b.s.p(paramBoolean, Boolean.FALSE))
      {
        if (localView2.getVisibility() == 8)
        {
          AppMethodBeat.o(342275);
          return;
        }
        i = 8;
      }
      for (;;)
      {
        label125:
        if (paramj.context.getResources().getConfiguration().orientation == 1)
        {
          localView1.setVisibility(i);
          localView2.setVisibility(i);
          if (paramca.ejX())
          {
            paramj.UH(e.e.unfold_video_button).setVisibility(i);
            AppMethodBeat.o(342275);
          }
        }
        else
        {
          if (i != 8) {
            break label227;
          }
          paramActivity.getWindow().getDecorView().setSystemUiVisibility(paramActivity.getWindow().getDecorView().getSystemUiVisibility() | 0x806);
        }
        for (;;)
        {
          localView2.setVisibility(i);
          AppMethodBeat.o(342275);
          return;
          label227:
          paramActivity.getWindow().getDecorView().setSystemUiVisibility(paramActivity.getWindow().getDecorView().getSystemUiVisibility() & 0xFFFFF7F9);
        }
      }
    }
    
    public static boolean g(com.tencent.mm.view.recyclerview.j paramj, int paramInt)
    {
      AppMethodBeat.i(342296);
      kotlin.g.b.s.u(paramj, "holder");
      Object localObject1 = paramj.UH(e.e.play_speed_control_container);
      if (localObject1 != null)
      {
        int i;
        label37:
        label60:
        Object localObject2;
        if (((View)localObject1).getVisibility() == 0)
        {
          i = 1;
          if (i == 0) {
            break label216;
          }
          if (localObject1 == null) {
            break label257;
          }
          if (paramj.context.getResources().getConfiguration().orientation != 2) {
            break label221;
          }
          i = 1;
          if (i == 0) {
            break label226;
          }
          localObject2 = ((View)localObject1).animate().translationX(((View)localObject1).getWidth()).setDuration(300L);
          label84:
          ((ViewPropertyAnimator)localObject2).setListener((Animator.AnimatorListener)new a((View)localObject1)).start();
          localObject1 = paramj.UH(e.e.footer_layout);
          if (localObject1 != null)
          {
            ((View)localObject1).setAlpha(0.0F);
            ((View)localObject1).setVisibility(0);
            ((View)localObject1).animate().alpha(1.0F).setDuration(300L).setListener(null).start();
          }
          localObject1 = (ca)paramj.CSA;
          localObject2 = as.GSQ;
          paramj = paramj.context;
          kotlin.g.b.s.s(paramj, "holder.context");
          paramj = as.a.hu(paramj);
          if (paramj != null) {
            break label249;
          }
        }
        label216:
        label221:
        label226:
        label249:
        for (paramj = null;; paramj = paramj.fou())
        {
          localObject2 = ax.Fur;
          ax.a(paramj, "speedplayresult", ((ca)localObject1).eDF(), ((ca)localObject1).bZA(), paramInt);
          AppMethodBeat.o(342296);
          return true;
          i = 0;
          break;
          localObject1 = null;
          break label37;
          i = 0;
          break label60;
          localObject2 = ((View)localObject1).animate().translationY(((View)localObject1).getHeight()).setDuration(300L);
          break label84;
        }
      }
      label257:
      AppMethodBeat.o(342296);
      return false;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$Companion$hidePlaySpeedCtrlLayout$2$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends AnimatorListenerAdapter
    {
      a(View paramView) {}
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(342245);
        this.DjW.setVisibility(8);
        AppMethodBeat.o(342245);
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$Companion$showPlaySpeedCtrlLayout$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      extends AnimatorListenerAdapter
    {
      b(View paramView) {}
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(342254);
        this.DjW.setVisibility(8);
        this.DjW.setAlpha(1.0F);
        AppMethodBeat.o(342254);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Integer>
  {
    public static final b Ezt;
    
    static
    {
      AppMethodBeat.i(342251);
      Ezt = new b();
      AppMethodBeat.o(342251);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    c(FinderMediaBanner paramFinderMediaBanner, com.tencent.mm.view.recyclerview.j paramj, ca paramca, a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    d(FinderMediaBanner paramFinderMediaBanner)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isLoading", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<Boolean, kotlin.ah>
  {
    e(com.tencent.mm.view.recyclerview.j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initToggleHeaderAndFooter$1$2", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements HardTouchableLayout.b
  {
    g(com.tencent.mm.view.recyclerview.j paramj, a parama) {}
    
    public final void c(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(342250);
      kotlin.g.b.s.u(paramView, "view");
      kotlin.g.b.s.u(paramMotionEvent, "e");
      Log.i("Finder.FinderLongVideoConvert", kotlin.g.b.s.X("onDoubleClick ", this.wHm.CSA));
      a.a(this.Ezv, this.wHm, paramMotionEvent);
      AppMethodBeat.o(342250);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$onHideSmileyPanel$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements Animator.AnimatorListener
  {
    h(a parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(342255);
      a.a(this.Ezv).getSmileyPanel().setAlpha(1.0F);
      a.a(this.Ezv).getSmileyPanel().setVisibility(4);
      AppMethodBeat.o(342255);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$openCommentDrawer$onCloseDrawerCallback$1", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "onClose", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements CommentDrawerContract.CloseDrawerCallback
  {
    i(a parama, com.tencent.mm.view.recyclerview.j paramj, ca paramca) {}
    
    public final void z(int paramInt, List<? extends t> paramList)
    {
      AppMethodBeat.i(342248);
      kotlin.g.b.s.u(paramList, "data");
      a.a(this.Ezv, paramj, paramca.getFeedObject().commentCount);
      paramList = new it();
      paramList.hKk.feedId = paramca.getFeedObject().id;
      paramList.hKk.hKm = paramca.getFeedObject().commentCount;
      paramList.publish();
      ((MMFragmentActivity)a.a(this.Ezv).CCa).setRequestedOrientation(-1);
      AppMethodBeat.o(342248);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.convert.a
 * JD-Core Version:    0.7.0.1
 */