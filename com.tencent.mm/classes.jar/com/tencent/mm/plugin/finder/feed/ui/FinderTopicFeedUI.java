package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout.d;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.a;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.bi.b;
import com.tencent.mm.plugin.finder.feed.bi.c;
import com.tencent.mm.plugin.finder.feed.bi.d;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.b;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.f;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.an;
import com.tencent.mm.plugin.finder.utils.an.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bbg;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.bve;
import com.tencent.mm.protocal.protobuf.bxt;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.protocal.protobuf.efb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.c;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.y;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.a.ak;
import kotlin.ah;
import org.apache.commons.c.i;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$RefreshCallback;", "()V", "TAG", "", "appBarLayoutOffset", "", "backIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "customActionBar", "Landroid/widget/RelativeLayout;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;", "firstRsp", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "initTotalCount", "", "lastActionBarProgress", "", "moreIv", "onHellScroller", "com/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$onHellScroller$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$onHellScroller$1;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "tabType", "titleTv", "Landroid/widget/TextView;", "topicId", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback;", "fixActionBarStatus", "", "getCommentScene", "getFollowPatShareTitle", "getLayoutId", "getReportType", "goBack", "hideActionBar", "initCount", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "initCustomActionBar", "isHideStatusBar", "", "notShare", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "refreshHeadImage", "setActionBarTransparent", "setIconMenu", "updateStatusBar", "Companion", "OnOffsetChangedListener", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderTopicFeedUI
  extends MMFinderUI
  implements bi.b
{
  private static ConcurrentHashMap<Long, FinderItem> BlP;
  public static final a Bst;
  private bve ACr;
  private long ADo;
  private bi.c Aup;
  bi.d Auq;
  private FinderTopicFeedLoader Aur;
  private float Awe;
  private int Awf;
  private bbg Bsu;
  private RelativeLayout Bsv;
  private WeImageView Bsw;
  private WeImageView Bsx;
  private long Bsy;
  private final d Bsz;
  private final String TAG;
  private int hJx;
  private TextView titleTv;
  
  static
  {
    AppMethodBeat.i(178306);
    Bst = new a((byte)0);
    BlP = new ConcurrentHashMap();
    AppMethodBeat.o(178306);
  }
  
  public FinderTopicFeedUI()
  {
    AppMethodBeat.i(365690);
    this.TAG = "Finder.FinderTopicFeedUI";
    this.Bsz = new d();
    AppMethodBeat.o(365690);
  }
  
  private static final Map a(FinderTopicFeedUI paramFinderTopicFeedUI, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(365732);
    kotlin.g.b.s.u(paramFinderTopicFeedUI, "this$0");
    paramString = paramFinderTopicFeedUI.getIntent();
    if (paramString == null)
    {
      paramString = null;
      paramString = String.valueOf(paramString);
      if (!i.hm(paramString)) {
        break label211;
      }
      paramString = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.zIX;
      paramString = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.dKW();
    }
    label211:
    for (;;)
    {
      String str = ((com.tencent.mm.plugin.expt.b.d)h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
      Object localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      kotlin.r localr1 = kotlin.v.Y("session_id", localObject1);
      str = com.tencent.mm.plugin.expt.hellhound.core.b.bys();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      kotlin.r localr2 = kotlin.v.Y("finder_context_id", localObject1);
      str = com.tencent.mm.plugin.expt.hellhound.core.b.dIX();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      localObject1 = kotlin.v.Y("finder_tab_context_id", localObject1);
      paramString = kotlin.v.Y("extra_info", paramString);
      paramFinderTopicFeedUI = paramFinderTopicFeedUI.getIntent();
      if (paramFinderTopicFeedUI == null) {}
      for (paramFinderTopicFeedUI = localObject2;; paramFinderTopicFeedUI = paramFinderTopicFeedUI.getStringExtra("key_enter_source_info"))
      {
        paramFinderTopicFeedUI = ak.e(new kotlin.r[] { localr1, localr2, localObject1, paramString, kotlin.v.Y("enter_source_info", String.valueOf(paramFinderTopicFeedUI)) });
        AppMethodBeat.o(365732);
        return paramFinderTopicFeedUI;
        paramString = paramString.getStringExtra("key_extra_info");
        break;
      }
    }
  }
  
  private static final void a(FinderTopicFeedUI paramFinderTopicFeedUI, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(365750);
    kotlin.g.b.s.u(paramFinderTopicFeedUI, "this$0");
    Object localObject2 = paramFinderTopicFeedUI.Aup;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("presenter");
      localObject1 = null;
    }
    long l;
    if (((bi.c)localObject1).Bbb > 0L)
    {
      localObject2 = paramFinderTopicFeedUI.Aup;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("presenter");
        localObject1 = null;
      }
      l = ((bi.c)localObject1).Bbb;
      switch (paramMenuItem.getItemId())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(365750);
      return;
      l = paramFinderTopicFeedUI.Bsy;
      break;
      if (paramFinderTopicFeedUI.dTs())
      {
        aa.makeText((Context)paramFinderTopicFeedUI, e.h.finder_self_see_tips_forward, 0).show();
        AppMethodBeat.o(365750);
        return;
      }
      localObject1 = paramFinderTopicFeedUI.Aup;
      paramMenuItem = (MenuItem)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("presenter");
        paramMenuItem = null;
      }
      String str3;
      if (paramMenuItem.type == 4)
      {
        paramMenuItem = an.GhR;
        localObject2 = (MMActivity)paramFinderTopicFeedUI;
        str1 = paramFinderTopicFeedUI.efX();
        localObject1 = paramFinderTopicFeedUI.Aup;
        paramMenuItem = (MenuItem)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("presenter");
          paramMenuItem = null;
        }
        paramInt = paramMenuItem.type;
        localObject1 = paramFinderTopicFeedUI.Aup;
        paramMenuItem = (MenuItem)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("presenter");
          paramMenuItem = null;
        }
        str2 = paramMenuItem.getIconUrl();
        i = e.h.finder_topic_count_tip;
        localObject1 = paramFinderTopicFeedUI.Aup;
        paramMenuItem = (MenuItem)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("presenter");
          paramMenuItem = null;
        }
        str3 = paramFinderTopicFeedUI.getString(i, new Object[] { com.tencent.mm.plugin.finder.utils.r.qE(paramMenuItem.Bbb) });
        localObject1 = paramFinderTopicFeedUI.Aur;
        paramMenuItem = (MenuItem)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("feedLoader");
          paramMenuItem = null;
        }
        localObject1 = paramMenuItem.Bjw;
        paramMenuItem = paramFinderTopicFeedUI.Auq;
        paramFinderTopicFeedUI = paramMenuItem;
        if (paramMenuItem == null)
        {
          kotlin.g.b.s.bIx("viewCallback");
          paramFinderTopicFeedUI = null;
        }
        an.a.a((MMActivity)localObject2, str1, paramInt, l, str2, str3, (boi)localObject1, 49, paramFinderTopicFeedUI.Bbs);
        AppMethodBeat.o(365750);
        return;
      }
      paramMenuItem = an.GhR;
      localObject2 = (MMActivity)paramFinderTopicFeedUI;
      localObject1 = paramFinderTopicFeedUI.Aup;
      paramMenuItem = (MenuItem)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("presenter");
        paramMenuItem = null;
      }
      String str1 = paramMenuItem.topic;
      localObject1 = paramFinderTopicFeedUI.Aup;
      paramMenuItem = (MenuItem)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("presenter");
        paramMenuItem = null;
      }
      paramInt = paramMenuItem.type;
      localObject1 = paramFinderTopicFeedUI.Aup;
      paramMenuItem = (MenuItem)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("presenter");
        paramMenuItem = null;
      }
      String str2 = paramMenuItem.getIconUrl();
      int i = e.h.finder_topic_count_tip;
      localObject1 = paramFinderTopicFeedUI.Aup;
      paramMenuItem = (MenuItem)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("presenter");
        paramMenuItem = null;
      }
      localObject1 = paramFinderTopicFeedUI.getString(i, new Object[] { com.tencent.mm.plugin.finder.utils.r.qE(paramMenuItem.Bbb) });
      paramMenuItem = paramFinderTopicFeedUI.Aur;
      paramFinderTopicFeedUI = paramMenuItem;
      if (paramMenuItem == null)
      {
        kotlin.g.b.s.bIx("feedLoader");
        paramFinderTopicFeedUI = null;
      }
      an.a.a((MMActivity)localObject2, str1, paramInt, l, str2, (String)localObject1, paramFinderTopicFeedUI.Bjw, 9, "");
      AppMethodBeat.o(365750);
      return;
      if (paramFinderTopicFeedUI.dTs())
      {
        aa.makeText((Context)paramFinderTopicFeedUI, e.h.finder_self_see_tips_sns, 0).show();
        AppMethodBeat.o(365750);
        return;
      }
      localObject1 = paramFinderTopicFeedUI.Aup;
      paramMenuItem = (MenuItem)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("presenter");
        paramMenuItem = null;
      }
      if (paramMenuItem.type == 4)
      {
        paramMenuItem = an.GhR;
        localObject2 = (MMActivity)paramFinderTopicFeedUI;
        str1 = paramFinderTopicFeedUI.efX();
        localObject1 = paramFinderTopicFeedUI.Aup;
        paramMenuItem = (MenuItem)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("presenter");
          paramMenuItem = null;
        }
        paramInt = paramMenuItem.type;
        localObject1 = paramFinderTopicFeedUI.Aup;
        paramMenuItem = (MenuItem)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("presenter");
          paramMenuItem = null;
        }
        str2 = paramMenuItem.getIconUrl();
        i = e.h.finder_topic_count_tip;
        localObject1 = paramFinderTopicFeedUI.Aup;
        paramMenuItem = (MenuItem)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("presenter");
          paramMenuItem = null;
        }
        str3 = paramFinderTopicFeedUI.getString(i, new Object[] { com.tencent.mm.plugin.finder.utils.r.qE(paramMenuItem.Bbb) });
        localObject1 = paramFinderTopicFeedUI.Aur;
        paramMenuItem = (MenuItem)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("feedLoader");
          paramMenuItem = null;
        }
        localObject1 = paramMenuItem.Bjw;
        paramMenuItem = paramFinderTopicFeedUI.Auq;
        paramFinderTopicFeedUI = paramMenuItem;
        if (paramMenuItem == null)
        {
          kotlin.g.b.s.bIx("viewCallback");
          paramFinderTopicFeedUI = null;
        }
        an.a.b((MMActivity)localObject2, str1, paramInt, l, str2, str3, (boi)localObject1, 49, paramFinderTopicFeedUI.Bbs);
        AppMethodBeat.o(365750);
        return;
      }
      paramMenuItem = an.GhR;
      localObject2 = (MMActivity)paramFinderTopicFeedUI;
      localObject1 = paramFinderTopicFeedUI.Aup;
      paramMenuItem = (MenuItem)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("presenter");
        paramMenuItem = null;
      }
      str1 = paramMenuItem.topic;
      localObject1 = paramFinderTopicFeedUI.Aup;
      paramMenuItem = (MenuItem)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("presenter");
        paramMenuItem = null;
      }
      paramInt = paramMenuItem.type;
      localObject1 = paramFinderTopicFeedUI.Aup;
      paramMenuItem = (MenuItem)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("presenter");
        paramMenuItem = null;
      }
      str2 = paramMenuItem.getIconUrl();
      i = e.h.finder_topic_count_tip;
      localObject1 = paramFinderTopicFeedUI.Aup;
      paramMenuItem = (MenuItem)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("presenter");
        paramMenuItem = null;
      }
      localObject1 = paramFinderTopicFeedUI.getString(i, new Object[] { com.tencent.mm.plugin.finder.utils.r.qE(paramMenuItem.Bbb) });
      paramMenuItem = paramFinderTopicFeedUI.Aur;
      paramFinderTopicFeedUI = paramMenuItem;
      if (paramMenuItem == null)
      {
        kotlin.g.b.s.bIx("feedLoader");
        paramFinderTopicFeedUI = null;
      }
      an.a.b((MMActivity)localObject2, str1, paramInt, l, str2, (String)localObject1, paramFinderTopicFeedUI.Bjw, 9, "");
    }
  }
  
  private static final void a(FinderTopicFeedUI paramFinderTopicFeedUI, View paramView)
  {
    AppMethodBeat.i(365784);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderTopicFeedUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderTopicFeedUI, "this$0");
    paramFinderTopicFeedUI.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(365784);
  }
  
  private static final void a(FinderTopicFeedUI paramFinderTopicFeedUI, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(365739);
    kotlin.g.b.s.u(paramFinderTopicFeedUI, "this$0");
    Object localObject1;
    Object localObject2;
    boolean bool2;
    if (params.jmw())
    {
      localObject1 = paramFinderTopicFeedUI.getContext().getString(e.h.app_share_to_weixin);
      kotlin.g.b.s.s(localObject1, "context.getString(R.string.app_share_to_weixin)");
      localObject2 = paramFinderTopicFeedUI.getContext().getString(e.h.finder_share_timeline);
      kotlin.g.b.s.s(localObject2, "context.getString(R.string.finder_share_timeline)");
      if (!paramFinderTopicFeedUI.dTs()) {
        break label155;
      }
      localObject1 = av.GiL;
      localObject1 = av.eX("", e.h.finder_self_see_tips_forward);
      localObject2 = av.GiL;
      localObject2 = av.eX("", e.h.finder_self_see_tips_sns);
      bool2 = true;
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      params.a(10002, (CharSequence)localObject1, e.g.finder_icons_filled_share, paramFinderTopicFeedUI.getContext().getResources().getColor(e.b.Brand), bool1);
      params.a(10003, (CharSequence)localObject2, e.g.bottomsheet_icon_moment, 0, bool2);
      AppMethodBeat.o(365739);
      return;
      label155:
      bool2 = false;
    }
  }
  
  private static final void a(f paramf, View paramView)
  {
    AppMethodBeat.i(365776);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramf, "$bottomSheet");
    paramf.dDn();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(365776);
  }
  
  private static final void b(FinderTopicFeedUI paramFinderTopicFeedUI, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(365763);
    kotlin.g.b.s.u(paramFinderTopicFeedUI, "this$0");
    if (paramMenuItem.getItemId() == 10004)
    {
      Object localObject = paramFinderTopicFeedUI.Auq;
      paramMenuItem = (MenuItem)localObject;
      if (localObject == null)
      {
        kotlin.g.b.s.bIx("viewCallback");
        paramMenuItem = null;
      }
      paramMenuItem = paramMenuItem.Bbs;
      if (paramMenuItem != null)
      {
        localObject = com.tencent.mm.plugin.finder.feed.logic.a.Bem;
        com.tencent.mm.plugin.finder.feed.logic.a.aB((Context)paramFinderTopicFeedUI, paramMenuItem);
      }
    }
    AppMethodBeat.o(365763);
  }
  
  private static final void b(FinderTopicFeedUI paramFinderTopicFeedUI, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(365756);
    kotlin.g.b.s.u(paramFinderTopicFeedUI, "this$0");
    if (params.jmw()) {
      params.a(10004, (CharSequence)paramFinderTopicFeedUI.getContext().getString(e.h.more_menu_back), e.g.icons_outlined_report_problem);
    }
    AppMethodBeat.o(365756);
  }
  
  private final boolean dTs()
  {
    Object localObject2 = null;
    AppMethodBeat.i(365710);
    Object localObject3 = this.Aup;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("presenter");
      localObject1 = null;
    }
    boolean bool;
    StringBuilder localStringBuilder;
    if (!Util.isNullOrNil(((bi.c)localObject1).topic))
    {
      localObject3 = this.Aup;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("presenter");
        localObject1 = null;
      }
      if (!Util.isNullOrNil(((bi.c)localObject1).getIconUrl())) {}
    }
    else
    {
      bool = true;
      localObject3 = this.TAG;
      localStringBuilder = new StringBuilder("notShare ").append(bool).append(", ");
      localObject1 = this.Aup;
      if (localObject1 != null) {
        break label152;
      }
      kotlin.g.b.s.bIx("presenter");
      localObject1 = localObject2;
    }
    label152:
    for (;;)
    {
      Log.i((String)localObject3, Util.isNullOrNil(((bi.c)localObject1).topic));
      AppMethodBeat.o(365710);
      return bool;
      bool = false;
      break;
    }
  }
  
  private final String efX()
  {
    Object localObject2 = null;
    AppMethodBeat.i(365700);
    Object localObject3 = this.Aup;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("presenter");
      localObject1 = null;
    }
    localObject1 = ((bi.c)localObject1).bgmInfo;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label169;
      }
      localObject1 = ((FinderTopicFeedUI)this).Aup;
      if (localObject1 != null) {
        break label166;
      }
      kotlin.g.b.s.bIx("presenter");
      localObject1 = localObject2;
    }
    label166:
    for (;;)
    {
      localObject1 = ((bi.c)localObject1).topic;
      AppMethodBeat.o(365700);
      return localObject1;
      if (((bxt)localObject1).musicInfo != null)
      {
        localObject1 = ((bxt)localObject1).musicInfo;
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = ((bqj)localObject1).name)
        {
          localObject1 = String.valueOf(localObject1);
          break;
        }
      }
      localObject3 = getContext();
      int i = e.h.finder_follow_header_title;
      localObject1 = ((bxt)localObject1).contact;
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = ((FinderContact)localObject1).nickname)
      {
        localObject1 = ((AppCompatActivity)localObject3).getString(i, new Object[] { localObject1 });
        kotlin.g.b.s.s(localObject1, "{\n                contex…?.nickname)\n            }");
        break;
      }
    }
    label169:
    AppMethodBeat.o(365700);
    return localObject1;
  }
  
  private final void efY()
  {
    AppMethodBeat.i(365718);
    Object localObject = this.Bsv;
    if (localObject != null) {
      ((RelativeLayout)localObject).setBackgroundColor(getResources().getColor(e.b.transparent));
    }
    localObject = this.Bsx;
    if (localObject != null) {
      ((WeImageView)localObject).setIconColor(getResources().getColor(e.b.BW_BG_100));
    }
    localObject = this.Bsw;
    if (localObject != null) {
      ((WeImageView)localObject).setIconColor(getResources().getColor(e.b.BW_BG_100));
    }
    localObject = this.titleTv;
    if (localObject != null) {
      ((TextView)localObject).setTextColor(getResources().getColor(e.b.BW_BG_100));
    }
    AppMethodBeat.o(365718);
  }
  
  private final void efZ()
  {
    AppMethodBeat.i(365724);
    getController().updataStatusBarIcon(aw.isDarkMode());
    getController().s((Activity)this, getResources().getColor(e.b.transparent));
    AppMethodBeat.o(365724);
  }
  
  private static final void ega() {}
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void d(bxv parambxv)
  {
    AppMethodBeat.i(365975);
    int i;
    if (parambxv == null)
    {
      parambxv = "";
      if (((CharSequence)parambxv).length() <= 0) {
        break label213;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        efY();
        Object localObject1 = (AppBarLayout)findViewById(e.e.appbar_layout);
        Object localObject2 = new b();
        kotlin.g.b.s.s(localObject1, "appBarLayout");
        ((b)localObject2).onOffsetChanged((AppBarLayout)localObject1, 0);
        Object localObject3 = ah.aiuX;
        ((AppBarLayout)localObject1).a((AppBarLayout.b)localObject2);
        localObject1 = (ImageView)getContext().findViewById(e.e.cover_iv);
        localObject2 = (RefreshLoadMoreLayout)getContext().findViewById(e.e.rl_layout);
        localObject3 = (RoundedCornerFrameLayout)getContext().findViewById(e.e.corner_layout);
        ((RefreshLoadMoreLayout)localObject2).setSuperNestedScroll(true);
        float f = getContext().getResources().getDimension(e.c.Edge_1_5_A);
        ((RoundedCornerFrameLayout)localObject3).A(f, f, 0.0F, 0.0F);
        localObject2 = ((RoundedCornerFrameLayout)localObject3).getLayoutParams();
        if (localObject2 == null)
        {
          parambxv = new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
          AppMethodBeat.o(365975);
          throw parambxv;
          localObject1 = parambxv.mdQ;
          parambxv = (bxv)localObject1;
          if (localObject1 != null) {
            break;
          }
          parambxv = "";
          break;
          label213:
          i = 0;
          continue;
        }
        ((CoordinatorLayout.d)localObject2).topMargin = (-(int)f);
        localObject2 = ((ImageView)localObject1).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).height = getContext().getResources().getDimensionPixelSize(e.c.finder_topic_head_image_max_height);
        ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (localObject1 != null)
        {
          localObject2 = p.ExI;
          localObject2 = p.eCn();
          parambxv = new com.tencent.mm.plugin.finder.loader.s(parambxv, com.tencent.mm.plugin.finder.storage.v.FKY);
          localObject3 = p.ExI;
          ((com.tencent.mm.loader.d)localObject2).a(parambxv, p.a(p.a.ExJ)).d((ImageView)localObject1);
        }
      }
    }
    AppMethodBeat.o(365975);
  }
  
  public final int edC()
  {
    return 3;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(365947);
    switch (getIntent().getIntExtra("key_topic_type", 1))
    {
    case 2: 
    case 3: 
    default: 
      AppMethodBeat.o(365947);
      return 26;
    case 1: 
      AppMethodBeat.o(365947);
      return 22;
    case 4: 
      AppMethodBeat.o(365947);
      return 49;
    }
    AppMethodBeat.o(365947);
    return 64;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_topic_feed_hot_ui;
  }
  
  public final boolean isHideStatusBar()
  {
    return true;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(166276);
    super.onCreate(paramBundle);
    overridePendingTransition(e.a.slide_right_in, e.a.anim_not_change);
    BlP.clear();
    int i = getIntent().getIntExtra("key_topic_type", 1);
    int j = getIntent().getIntExtra("key_topic_extra_type", 1);
    String str = getIntent().getStringExtra("key_topic_title");
    if (str == null) {
      str = "";
    }
    for (;;)
    {
      Object localObject2 = getIntent().getStringExtra("KEY_FOLLOW_ID");
      this.ADo = getIntent().getLongExtra("KEY_TOPIC_ID", 0L);
      final long l1 = getIntent().getLongExtra("key_ref_object_id", 0L);
      Object localObject3 = getIntent().getStringExtra("KEY_TOPIC_NONCE_ID");
      Object localObject1 = getIntent().getStringExtra("key_by_pass_info");
      this.hJx = getIntent().getIntExtra("KEY_TAB_TYPE", 0);
      Log.i(this.TAG, "type:" + i + ", topicName:" + str + " topicId:" + this.ADo);
      this.Bsv = ((RelativeLayout)findViewById(e.e.customActionBar));
      paramBundle = getWindow().getDecorView();
      kotlin.g.b.s.s(paramBundle, "this.window.decorView");
      paramBundle.setSystemUiVisibility(1280);
      getWindow().setStatusBarColor(0);
      c.h((Activity)this, false);
      paramBundle = getSupportActionBar();
      if (paramBundle != null)
      {
        paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
        paramBundle.hide();
      }
      int k = bf.getStatusBarHeight((Context)this);
      paramBundle = this.Bsv;
      if (paramBundle != null)
      {
        localObject4 = paramBundle.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject4).height += k;
        paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject4);
        paramBundle.setPadding(0, k, 0, 0);
      }
      paramBundle = (ImageView)getContext().findViewById(e.e.cover_iv);
      Object localObject4 = paramBundle.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject4).height = (k + ((ViewGroup.LayoutParams)localObject4).height);
      paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject4);
      efZ();
      ((LinearLayout)findViewById(e.e.backBtn)).setOnClickListener(new FinderTopicFeedUI..ExternalSyntheticLambda0(this));
      this.Bsw = ((WeImageView)findViewById(e.e.backIv));
      this.Bsx = ((WeImageView)findViewById(e.e.moreIv));
      this.titleTv = ((TextView)findViewById(e.e.actionbar_title_tv));
      paramBundle = this.Bsw;
      if (paramBundle != null) {
        paramBundle.setIconColor(getResources().getColor(e.b.black_color));
      }
      paramBundle = this.Bsx;
      if (paramBundle != null) {
        paramBundle.setIconColor(getResources().getColor(e.b.black_color));
      }
      paramBundle = this.titleTv;
      if (paramBundle != null) {
        paramBundle.setTextColor(getResources().getColor(e.b.black_color));
      }
      paramBundle = (com.tencent.mm.bx.a)new bve();
      localObject4 = getIntent().getByteArrayExtra("KEY_SECTION_INFO");
      try
      {
        paramBundle.parseFrom((byte[])localObject4);
        this.ACr = ((bve)paramBundle);
        paramBundle = (com.tencent.mm.bx.a)new bbg();
        localObject4 = getIntent().getByteArrayExtra("KEY_TOPIC_RSP");
      }
      catch (Exception paramBundle)
      {
        try
        {
          paramBundle.parseFrom((byte[])localObject4);
          this.Bsu = ((bbg)paramBundle);
          paramBundle = k.aeZF;
          paramBundle = new FinderTopicFeedLoader(i, str, ((as)k.d((AppCompatActivity)this).q(as.class)).fou(), (String)localObject1);
          localObject1 = getIntent();
          kotlin.g.b.s.s(localObject1, "intent");
          paramBundle.initFromCache((Intent)localObject1);
          paramBundle.Bbs = ((String)localObject2);
          paramBundle.setInitDone((j)new c(this, l1, str));
          localObject1 = ah.aiuX;
          this.Aur = paramBundle;
          localObject4 = (MMActivity)this;
          k = getCommentScene();
          localObject1 = this.Aur;
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null)
          {
            kotlin.g.b.s.bIx("feedLoader");
            paramBundle = null;
          }
          paramBundle = new bi.c((MMActivity)localObject4, k, (BaseFinderFeedLoader)paramBundle);
          paramBundle.ADo = this.ADo;
          paramBundle.avQ(str);
          paramBundle.type = i;
          paramBundle.BaZ = j;
          localObject1 = ah.aiuX;
          this.Aup = paramBundle;
          localObject1 = this.Aup;
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null)
          {
            kotlin.g.b.s.bIx("presenter");
            paramBundle = null;
          }
          paramBundle.Bba = this.hJx;
          paramBundle = new bi.d((MMActivity)this, getCommentScene(), (bi.b)this, 8);
          paramBundle.avQ(str);
          paramBundle.type = i;
          paramBundle.BaZ = j;
          paramBundle.Bbs = ((String)localObject2);
          paramBundle.ADo = this.ADo;
          paramBundle.ADp = ((String)localObject3);
          localObject1 = ah.aiuX;
          this.Auq = paramBundle;
          paramBundle = this.Auq;
          if (paramBundle == null)
          {
            kotlin.g.b.s.bIx("viewCallback");
            paramBundle = null;
            localObject2 = this.Aup;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              kotlin.g.b.s.bIx("presenter");
              localObject1 = null;
            }
            paramBundle.a((c.a)localObject1);
            localObject1 = this.Auq;
            paramBundle = (Bundle)localObject1;
            if (localObject1 == null)
            {
              kotlin.g.b.s.bIx("viewCallback");
              paramBundle = null;
            }
            if (this.Bsu != null) {
              break label1645;
            }
            bool = true;
            paramBundle.AWd = bool;
            paramBundle = this.Aup;
            if (paramBundle != null) {
              break label1651;
            }
            kotlin.g.b.s.bIx("presenter");
            paramBundle = null;
            localObject2 = this.Auq;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              kotlin.g.b.s.bIx("viewCallback");
              localObject1 = null;
            }
            paramBundle.a((c.b)localObject1);
            localObject2 = this.Bsu;
            if (localObject2 != null)
            {
              localObject1 = this.Aup;
              if (localObject1 != null) {
                break label1654;
              }
              kotlin.g.b.s.bIx("presenter");
              localObject1 = null;
              localObject3 = this.ACr;
              kotlin.g.b.s.u(localObject2, "rsp");
              localObject4 = new FinderTopicFeedLoader.f(0, 0, null, null);
              paramBundle = ((c.a)localObject1).ALH.getCache();
              if (paramBundle != null) {
                break label1657;
              }
              paramBundle = null;
              ((FinderTopicFeedLoader.f)localObject4).setLastBuffer(paramBundle);
              ((FinderTopicFeedLoader.f)localObject4).Bbb = ((bbg)localObject2).Bbb;
              paramBundle = av.GiL;
              paramBundle = ((c.a)localObject1).ALH.getCache();
              if (paramBundle != null) {
                break label1665;
              }
              paramBundle = null;
              if (paramBundle != null) {
                break label1673;
              }
              paramBundle = (List)ab.aivy;
              ((FinderTopicFeedLoader.f)localObject4).setIncrementList(av.a(paramBundle, BaseFinderFeed.class));
              ((FinderTopicFeedLoader.f)localObject4).setHasMore(true);
              ((FinderTopicFeedLoader.f)localObject4).BjA = ((bbg)localObject2).BbC;
              ((FinderTopicFeedLoader.f)localObject4).setPullType(1);
              paramBundle = ((bbg)localObject2).ZLY;
              if (paramBundle != null) {
                break label1681;
              }
              paramBundle = "";
              ((FinderTopicFeedLoader.f)localObject4).uCW = paramBundle;
              ((FinderTopicFeedLoader)((c.a)localObject1).ALH).ACr = ((bve)localObject3);
              ((c.a)localObject1).ALH.onFetchDone((IResponse)localObject4);
            }
            localObject2 = new f((Context)this, 0, false);
            ((f)localObject2).Vtg = new FinderTopicFeedUI..ExternalSyntheticLambda3(this);
            ((f)localObject2).GAC = new FinderTopicFeedUI..ExternalSyntheticLambda6(this);
            localObject1 = this.Aup;
            paramBundle = (Bundle)localObject1;
            if (localObject1 == null)
            {
              kotlin.g.b.s.bIx("presenter");
              paramBundle = null;
            }
            if (paramBundle.type == 4)
            {
              ((f)localObject2).GAz = new FinderTopicFeedUI..ExternalSyntheticLambda4(this);
              ((f)localObject2).agem = new FinderTopicFeedUI..ExternalSyntheticLambda5(this);
            }
            ((f)localObject2).aeLi = FinderTopicFeedUI..ExternalSyntheticLambda7.INSTANCE;
            ((LinearLayout)findViewById(e.e.moreBtn)).setOnClickListener(new FinderTopicFeedUI..ExternalSyntheticLambda1((f)localObject2));
            j = getIntent().getIntExtra("key_report_scene", 0);
            if (j != 0)
            {
              localObject1 = getIntent().getStringExtra("key_from_user");
              paramBundle = (Bundle)localObject1;
              if (localObject1 == null) {
                paramBundle = "";
              }
              localObject1 = z.FrZ;
              z.d(j, paramBundle, str, i);
              if (getIntent().getIntExtra("key_topic_type", 1) == 4)
              {
                localObject1 = z.FrZ;
                long l2 = getIntent().getLongExtra("key_ref_object_id", 0L);
                localObject1 = k.aeZF;
                localObject1 = getContext();
                kotlin.g.b.s.s(localObject1, "context");
                z.a(l2, j, 4L, paramBundle, 0, 2, null, ((as)k.d((AppCompatActivity)localObject1).q(as.class)).zIO);
              }
            }
            localObject1 = this.Auq;
            paramBundle = (Bundle)localObject1;
            if (localObject1 == null)
            {
              kotlin.g.b.s.bIx("viewCallback");
              paramBundle = null;
            }
            paramBundle.ATx.getRecyclerView().a((RecyclerView.l)this.Bsz);
            paramBundle = com.tencent.mm.plugin.finder.topic.a.FNS;
            com.tencent.mm.plugin.finder.topic.a.a((Context)this, l1, this.ADo, str);
            ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a(this, com.tencent.mm.plugin.datareport.a.a.a.xgv);
            ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).g(this, getClass().getSimpleName());
            ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).eE(this);
            ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a(this, new FinderTopicFeedUI..ExternalSyntheticLambda2(this));
            AppMethodBeat.o(166276);
            return;
            continue;
            paramBundle = paramBundle;
            Log.printDebugStack("safeParser", "", new Object[] { paramBundle });
            paramBundle = null;
          }
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            Log.printDebugStack("safeParser", "", new Object[] { paramBundle });
            paramBundle = null;
            continue;
            continue;
            label1645:
            boolean bool = false;
            continue;
            label1651:
            continue;
            label1654:
            continue;
            label1657:
            paramBundle = paramBundle.lastBuffer;
            continue;
            label1665:
            paramBundle = paramBundle.pUj;
            continue;
            label1673:
            paramBundle = (List)paramBundle;
            continue;
            label1681:
            localObject2 = paramBundle.abky;
            paramBundle = (Bundle)localObject2;
            if (localObject2 == null) {
              paramBundle = "";
            }
          }
        }
      }
    }
  }
  
  public final void onDestroy()
  {
    Object localObject2 = null;
    AppMethodBeat.i(166278);
    bi.c localc = this.Aup;
    Object localObject1 = localc;
    if (localc == null)
    {
      kotlin.g.b.s.bIx("presenter");
      localObject1 = null;
    }
    ((bi.c)localObject1).onDetach();
    BlP.clear();
    localObject1 = this.Auq;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("viewCallback");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((c.b)localObject1).ATx.getRecyclerView().b((RecyclerView.l)this.Bsz);
      super.onDestroy();
      AppMethodBeat.o(166278);
      return;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(365966);
    super.onPause();
    ((ce)h.ax(ce.class)).b(null, q.w.DwP, "26", com.tencent.mm.plugin.finder.live.report.d.Dng);
    AppMethodBeat.o(365966);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(365959);
    super.onResume();
    ((ce)h.ax(ce.class)).b(null, q.w.DwP, "26", com.tencent.mm.plugin.finder.live.report.d.Dnf);
    bi.c localc2 = this.Aup;
    bi.c localc1 = localc2;
    if (localc2 == null)
    {
      kotlin.g.b.s.bIx("presenter");
      localc1 = null;
    }
    localc1.onUIResume();
    AppMethodBeat.o(365959);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$Companion;", "", "()V", "MENU_ID_COMPLAINT", "", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_TIMELINE", "finderFeedCacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFinderFeedCacheMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setFinderFeedCacheMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$OnOffsetChangedListener;", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "(Lcom/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI;)V", "onOffsetChanged", "", "view", "Lcom/google/android/material/appbar/AppBarLayout;", "offset", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements AppBarLayout.b
  {
    public b()
    {
      AppMethodBeat.i(365114);
      AppMethodBeat.o(365114);
    }
    
    public final void onOffsetChanged(AppBarLayout paramAppBarLayout, int paramInt)
    {
      AppMethodBeat.i(365127);
      kotlin.g.b.s.u(paramAppBarLayout, "view");
      FinderTopicFeedUI.a(this.BsA, paramInt);
      float f = 1.0F * Math.abs(paramInt) / paramAppBarLayout.getTotalScrollRange();
      if (f == FinderTopicFeedUI.a(this.BsA)) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        AppMethodBeat.o(365127);
        return;
      }
      FinderTopicFeedUI.a(this.BsA, f);
      if (f < 0.5F)
      {
        FinderTopicFeedUI.b(this.BsA);
        FinderTopicFeedUI.c(this.BsA);
        AppMethodBeat.o(365127);
        return;
      }
      paramInt = this.BsA.getResources().getColor(e.b.BG_2);
      int i = (int)((f - 0.5F) / 0.5F * 255.0F);
      paramAppBarLayout = FinderTopicFeedUI.d(this.BsA);
      if (paramAppBarLayout != null) {
        paramAppBarLayout.setBackgroundColor(bb.gy(paramInt, i));
      }
      this.BsA.getController().setStatusBarColor(bb.gy(paramInt, i));
      paramAppBarLayout = FinderTopicFeedUI.e(this.BsA);
      if (paramAppBarLayout != null) {
        paramAppBarLayout.setIconColor(this.BsA.getResources().getColor(e.b.black_color));
      }
      paramAppBarLayout = FinderTopicFeedUI.f(this.BsA);
      if (paramAppBarLayout != null) {
        paramAppBarLayout.setIconColor(this.BsA.getResources().getColor(e.b.black_color));
      }
      paramAppBarLayout = FinderTopicFeedUI.g(this.BsA);
      if (paramAppBarLayout != null) {
        paramAppBarLayout.setTextColor(this.BsA.getResources().getColor(e.b.black_color));
      }
      AppMethodBeat.o(365127);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$onCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$TopicIInitDone;", "call", "", "incrementCount", "", "callInfo", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements FinderTopicFeedLoader.b
  {
    c(FinderTopicFeedUI paramFinderTopicFeedUI, long paramLong, String paramString) {}
    
    public final void call(int paramInt) {}
    
    public final void g(bxv parambxv)
    {
      Object localObject2 = null;
      long l2 = 0L;
      AppMethodBeat.i(365119);
      Object localObject1 = this.BsA;
      long l1;
      label54:
      FinderTopicFeedUI localFinderTopicFeedUI;
      Object localObject3;
      int i;
      if (parambxv == null)
      {
        l1 = 0L;
        FinderTopicFeedUI.a((FinderTopicFeedUI)localObject1, l1);
        if (FinderTopicFeedUI.h(this.BsA) == 0L)
        {
          localObject1 = this.BsA;
          if (parambxv != null) {
            break label207;
          }
          l1 = l2;
          FinderTopicFeedUI.b((FinderTopicFeedUI)localObject1, l1);
        }
        localObject1 = com.tencent.mm.plugin.finder.topic.a.FNS;
        com.tencent.mm.plugin.finder.topic.a.a((Context)this.BsA, l1, FinderTopicFeedUI.h(this.BsA), this.BsC);
        localFinderTopicFeedUI = this.BsA;
        localObject3 = localFinderTopicFeedUI.Auq;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("viewCallback");
          localObject1 = null;
        }
        localObject1 = ((bi.d)localObject1).getHeaderView();
        if (parambxv != null) {
          break label215;
        }
        i = 0;
        label133:
        localObject3 = com.tencent.mm.plugin.finder.utils.r.TQ(i);
        if (localObject1 != null) {
          break label223;
        }
      }
      label207:
      label215:
      label223:
      for (localObject1 = localObject2;; localObject1 = (TextView)((View)localObject1).findViewById(e.e.topic_count))
      {
        if (localObject1 != null) {
          ((TextView)localObject1).setText((CharSequence)localFinderTopicFeedUI.getContext().getResources().getString(e.h.finder_topic_count_tip, new Object[] { localObject3 }));
        }
        this.BsA.d(parambxv);
        AppMethodBeat.o(365119);
        return;
        l1 = parambxv.feedCount;
        break;
        l1 = parambxv.ADo;
        break label54;
        i = parambxv.feedCount;
        break label133;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$onHellScroller$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(365145);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$onHellScroller$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$onHellScroller$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(365145);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(365138);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$onHellScroller$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      ((ce)h.ax(ce.class)).b(paramRecyclerView, q.w.DwP, "26", com.tencent.mm.plugin.finder.live.report.d.Dne);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderTopicFeedUI$onHellScroller$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(365138);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI
 * JD-Core Version:    0.7.0.1
 */