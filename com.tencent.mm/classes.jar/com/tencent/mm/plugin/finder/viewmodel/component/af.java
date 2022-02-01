package com.tencent.mm.plugin.finder.viewmodel.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.b;
import com.google.android.material.tabs.TabLayout.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.f.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.cgi.di;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.extension.reddot.l;
import com.tencent.mm.plugin.finder.extension.reddot.l.a;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.report.ae;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.at;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.findersdk.a.bl;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bwj;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ag;
import com.tencent.mm.ui.ag.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.c;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.HardTouchableLayout.b;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.j;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "actionBarColor", "", "friendsLikeTipsBubble", "Lcom/tencent/mm/plugin/finder/view/FinderTipsBubbleWindow;", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "fromTabIndex", "fromTabType", "fullScreenIconColor", "isCurrentResume", "", "isHasDisposedFriendsAvatarRedDot", "isPreparing", "lastExposeFollowTipsId", "", "lastExposeFriendTipsId", "lastExposeLbsTipsId", "lastExposeMachineTipsId", "lastExposePersonalCenterTipsId", "selected", "selectedInHot", "tlCacheVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "getTlCacheVM", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "tlCacheVM$delegate", "Lkotlin/Lazy;", "toTabIndex", "toTabType", "unselected", "unselectedInHot", "adjustIndicator", "", "adjustTabIndicator", "buildTab", "checkFinderTeenMode", "checkNearbyLiveFriends", "checkPersonCenterRedDotReport", "action", "checkPostEntrance", "doClickPostAction", "doPrepareUser", "status", "fixActionBarStatus", "getFinderTab", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$FinderTab;", "tabType", "getIndicatorView", "Landroid/view/ViewGroup;", "getPersonalCenterRect", "outRect", "Landroid/graphics/Rect;", "getRootView", "Landroid/view/View;", "getScrollMask", "isMagicWindowInExpandStatus", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDestroy", "onFragmentChange", "from", "to", "fromType", "toType", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onUserVisibleFragmentChange", "isUserVisibleFocused", "index", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "overlayStatusBar", "refreshActionBarColor", "registerRedDot", "resetScrollMask", "color", "setMargins", "tabIndicator", "leftMargin", "rightMargin", "setPersonalCenterUnreadDot", "count", "redDotCountView", "setTabIndex", "showFriendsLikeTips", "anchor", "showInfo", "findByTag", "Lcom/google/android/material/tabs/TabLayout$Tab;", "Lcom/google/android/material/tabs/TabLayout;", "any", "", "Companion", "FinderTab", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class af
  extends UIComponent
  implements com.tencent.mm.am.h, com.tencent.mm.plugin.finder.view.h
{
  public static final a GQT;
  private static boolean GRl;
  private boolean EFm;
  private final j GQU;
  private String GQV;
  private String GQW;
  private String GQX;
  private String GQY;
  private String GQZ;
  private boolean GRa;
  private boolean GRb;
  private final int GRc;
  private final int GRd;
  private final int GRe;
  private final int GRf;
  private final int GRg;
  private int GRh;
  private int GRi;
  private int GRj;
  private int GRk;
  private final int selected;
  
  static
  {
    AppMethodBeat.i(339086);
    GQT = new a((byte)0);
    AppMethodBeat.o(339086);
  }
  
  public af(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338809);
    this.GQU = kotlin.k.cm((kotlin.g.a.a)h.GRx);
    this.GQV = "";
    this.GQW = "";
    this.GQX = "";
    this.GQY = "";
    this.GQZ = "";
    this.GRc = paramAppCompatActivity.getResources().getColor(e.b.hot_tab_selected_color);
    this.GRd = paramAppCompatActivity.getResources().getColor(e.b.hot_tab_BW_100_Alpha_0_5);
    this.GRe = paramAppCompatActivity.getResources().getColor(e.b.hot_tab_unselected_color);
    this.selected = paramAppCompatActivity.getResources().getColor(e.b.black_color);
    this.GRf = paramAppCompatActivity.getResources().getColor(e.b.desc_text_color);
    this.GRg = paramAppCompatActivity.getResources().getColor(e.b.BW_93);
    this.GRh = -1;
    this.GRi = -1;
    this.GRj = -1;
    this.GRk = -1;
    AppMethodBeat.o(338809);
  }
  
  private final void Vf(int paramInt)
  {
    AppMethodBeat.i(338825);
    Object localObject = as.GSQ;
    localObject = as.a.hu((Context)getActivity());
    if (localObject == null) {}
    for (localObject = null;; localObject = ((as)localObject).fou())
    {
      com.tencent.mm.plugin.finder.extension.reddot.m.a locala = com.tencent.mm.plugin.finder.extension.reddot.m.ASi;
      this.GQV = com.tencent.mm.plugin.finder.extension.reddot.m.a.a(paramInt, (bui)localObject, this.GQV);
      AppMethodBeat.o(338825);
      return;
    }
  }
  
  private final void Vg(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(338888);
    Log.i("Finder.HomeActionBarUIC", "[doPrepareUser] isPreparing=" + this.GRb + " status=" + paramInt);
    if (!this.GRb)
    {
      this.GRb = true;
      bool1 = bool2;
      if (((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("TLPostCamera") == null) {
        if (((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("TLCamera") == null) {
          break label138;
        }
      }
    }
    label138:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      di localdi = new di(3);
      localdi.ADf = bool1;
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localdi, 0);
      AppMethodBeat.o(338888);
      return;
    }
  }
  
  private static TabLayout.e a(TabLayout paramTabLayout, Object paramObject)
  {
    AppMethodBeat.i(338853);
    int i = 0;
    int k = paramTabLayout.getTabCount();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      TabLayout.e locale = paramTabLayout.js(i);
      Object localObject;
      if (locale == null) {
        localObject = null;
      }
      while ((localObject instanceof b))
      {
        localObject = locale.tag;
        if (localObject == null)
        {
          paramTabLayout = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeActionBarUIC.FinderTab");
          AppMethodBeat.o(338853);
          throw paramTabLayout;
          localObject = locale.tag;
        }
        else
        {
          i = ((b)localObject).hJx;
          if ((paramObject instanceof Integer)) {
            break label117;
          }
        }
      }
      while (j >= k)
      {
        AppMethodBeat.o(338853);
        return null;
        label117:
        if (i == ((Number)paramObject).intValue())
        {
          AppMethodBeat.o(338853);
          return locale;
        }
      }
      i = j;
    }
  }
  
  private static final void a(af paramaf)
  {
    AppMethodBeat.i(338954);
    kotlin.g.b.s.u(paramaf, "this$0");
    int i = paramaf.getResources().getColor(e.b.hot_tab_BW_0_Alpha_0_9);
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    paramaf = ((Iterable)((FinderHomeUIC)com.tencent.mm.ui.component.k.d(paramaf.getActivity()).q(FinderHomeUIC.class)).fragments).iterator();
    while (paramaf.hasNext())
    {
      localObject = ((FinderHomeTabFragment)paramaf.next()).getView();
      if (localObject != null)
      {
        localObject = ((View)localObject).findViewById(e.e.scroll_mask);
        if (localObject != null) {
          ((View)localObject).setBackgroundColor(i);
        }
      }
    }
    AppMethodBeat.o(338954);
  }
  
  private static final void a(af paramaf, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(339028);
    kotlin.g.b.s.u(paramaf, "this$0");
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("key_create_scene", 1);
    com.tencent.mm.plugin.finder.utils.a.GfO.x((Context)paramaf.getActivity(), paramMenuItem);
    AppMethodBeat.o(339028);
  }
  
  private static final void a(af paramaf, View paramView)
  {
    AppMethodBeat.i(338906);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramaf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramaf, "this$0");
    paramaf.getActivity().onBackPressed();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(338906);
  }
  
  private static final void a(af paramaf, l.a parama)
  {
    boolean bool2 = true;
    AppMethodBeat.i(338983);
    kotlin.g.b.s.u(paramaf, "this$0");
    if ((parama != null) && (parama.hBY == true))
    {
      bool1 = true;
      Log.i("Finder.HomeActionBarUIC", kotlin.g.b.s.X("[MENU_ID_PROFILE] red=", Boolean.valueOf(bool1)));
      if (!((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu()) {
        break label132;
      }
      paramaf = new StringBuilder("[MENU_ID_PROFILE] red=");
      if ((parama == null) || (parama.hBY != true)) {
        break label126;
      }
    }
    label126:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Log.i("Finder.HomeActionBarUIC", bool1 + ", return for teen mode.");
      AppMethodBeat.o(338983);
      return;
      bool1 = false;
      break;
    }
    label132:
    label184:
    label224:
    label241:
    int j;
    if ((parama != null) && (parama.hBY == true))
    {
      i = 1;
      if (i == 0) {
        break label737;
      }
      localObject = parama.ASh;
      if (localObject == null) {
        break label407;
      }
      localObject = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject).field_ctrInfo;
      if ((localObject == null) || (((btw)localObject).type != 2)) {
        break label407;
      }
      i = 1;
      if (i == 0)
      {
        localObject = parama.ASh;
        if (localObject == null) {
          break label412;
        }
        localObject = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject).field_ctrInfo;
        if ((localObject == null) || (((btw)localObject).type != 1006)) {
          break label412;
        }
        i = 1;
        if (i == 0) {
          break label691;
        }
      }
      localObject = parama.ASg;
      if (localObject != null) {
        break label417;
      }
      i = 0;
      localObject = parama.ASg;
      if ((localObject == null) || (((bxq)localObject).show_type != 2)) {
        break label426;
      }
      j = 1;
      label263:
      if ((j == 0) || (i <= 0)) {
        break label565;
      }
      parama = paramaf.findViewById(e.e.personalCenterTabRed);
      if (parama != null) {
        parama.setVisibility(4);
      }
      localObject = (TextView)paramaf.findViewById(e.e.personalCenterRedCount);
      if (localObject == null) {
        break label517;
      }
      aw.a((Paint)((TextView)localObject).getPaint(), 0.8F);
      ((TextView)localObject).setTextSize(1, 10.0F);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText((CharSequence)String.valueOf(i));
      if (i <= 999) {
        break label431;
      }
    }
    label407:
    label412:
    label417:
    label426:
    label431:
    for (parama = (CharSequence)"· · ·";; parama = (CharSequence)String.valueOf(i))
    {
      ((TextView)localObject).setText(parama);
      parama = (View)localObject;
      localObject = parama.getLayoutParams();
      if (localObject != null) {
        break label442;
      }
      paramaf = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(338983);
      throw paramaf;
      i = 0;
      break;
      i = 0;
      break label184;
      i = 0;
      break label224;
      i = ((bxq)localObject).count;
      break label241;
      j = 0;
      break label263;
    }
    label442:
    Object localObject = (FrameLayout.LayoutParams)localObject;
    if (i < 10)
    {
      ((FrameLayout.LayoutParams)localObject).setMarginStart(0);
      ((FrameLayout.LayoutParams)localObject).setMarginEnd((int)paramaf.getContext().getResources().getDimension(e.c.Edge_1_5_A));
      ((FrameLayout.LayoutParams)localObject).gravity = 8388613;
    }
    for (;;)
    {
      parama.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = at.GiI;
      parama.setBackgroundResource(at.aE((Context)paramaf.getContext(), i));
      label517:
      paramaf.Vf(1);
      AppMethodBeat.o(338983);
      return;
      ((FrameLayout.LayoutParams)localObject).gravity = 8388611;
      ((FrameLayout.LayoutParams)localObject).setMarginStart((int)paramaf.getContext().getResources().getDimension(e.c.Edge_2A));
      ((FrameLayout.LayoutParams)localObject).setMarginEnd(0);
    }
    label565:
    localObject = com.tencent.mm.plugin.finder.extension.reddot.m.ASi;
    if (!com.tencent.mm.plugin.finder.extension.reddot.m.a.ean())
    {
      parama = parama.ASg;
      if ((parama == null) || (parama.show_type != 1)) {
        break label645;
      }
    }
    label645:
    for (int i = 1; i != 0; i = 0)
    {
      parama = paramaf.findViewById(e.e.personalCenterTabRed);
      if (parama != null) {
        parama.setVisibility(0);
      }
      parama = paramaf.findViewById(e.e.personalCenterRedCount);
      if (parama != null) {
        parama.setVisibility(4);
      }
      paramaf.Vf(1);
      AppMethodBeat.o(338983);
      return;
    }
    parama = paramaf.findViewById(e.e.personalCenterTabRed);
    if (parama != null) {
      parama.setVisibility(4);
    }
    paramaf = paramaf.findViewById(e.e.personalCenterRedCount);
    if (paramaf != null)
    {
      paramaf.setVisibility(4);
      AppMethodBeat.o(338983);
      return;
      label691:
      parama = paramaf.findViewById(e.e.personalCenterTabRed);
      if (parama != null) {
        parama.setVisibility(0);
      }
      parama = paramaf.findViewById(e.e.personalCenterRedCount);
      if (parama != null) {
        parama.setVisibility(4);
      }
      paramaf.Vf(1);
      AppMethodBeat.o(338983);
      return;
      label737:
      parama = paramaf.findViewById(e.e.personalCenterTabRed);
      if (parama != null) {
        parama.setVisibility(4);
      }
      paramaf = paramaf.findViewById(e.e.personalCenterRedCount);
      if (paramaf != null) {
        paramaf.setVisibility(4);
      }
    }
    AppMethodBeat.o(338983);
  }
  
  private static final void a(String paramString, AppCompatActivity paramAppCompatActivity, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(339038);
    kotlin.g.b.s.u(paramString, "$postId");
    kotlin.g.b.s.u(paramAppCompatActivity, "$context");
    Intent localIntent = new Intent();
    if (paramMenuItem.getItemId() == 1001) {
      localIntent.putExtra("key_finder_post_router", 2);
    }
    for (;;)
    {
      localIntent.putExtra("key_finder_post_from", 5);
      localIntent.putExtra("key_finder_post_id", paramString);
      paramString = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)paramAppCompatActivity, localIntent);
      AppMethodBeat.o(339038);
      return;
      if (paramMenuItem.getItemId() == 1002) {
        localIntent.putExtra("key_finder_post_router", 3);
      }
    }
  }
  
  private static final void b(af paramaf)
  {
    AppMethodBeat.i(338960);
    kotlin.g.b.s.u(paramaf, "this$0");
    paramaf = paramaf.findViewById(e.e.tabLayoutContainer);
    if (paramaf != null)
    {
      Object localObject = paramaf.getLayoutParams();
      if (localObject == null)
      {
        paramaf = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(338960);
        throw paramaf;
      }
      localObject = (LinearLayout.LayoutParams)localObject;
      ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
      paramaf.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(338960);
  }
  
  private static final void b(af paramaf, View paramView)
  {
    AppMethodBeat.i(338913);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramaf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramaf, "this$0");
    paramView = com.tencent.mm.plugin.finder.report.s.Fqv;
    com.tencent.mm.plugin.finder.report.s.eMN();
    paramView = new Intent();
    localObject = as.GSQ;
    as.a.a((Context)paramaf.getActivity(), paramView, 0L, 0, true, 60);
    localObject = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.c((MMActivity)paramaf.getActivity(), paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(338913);
  }
  
  private static final void b(af paramaf, l.a parama)
  {
    AppMethodBeat.i(338994);
    kotlin.g.b.s.u(paramaf, "this$0");
    Object localObject1 = (TabLayout)paramaf.findViewById(e.e.tabLayout);
    if (localObject1 != null)
    {
      localObject1 = a((TabLayout)localObject1, Integer.valueOf(3));
      if (localObject1 != null)
      {
        Object localObject2 = ((TabLayout.e)localObject1).tag;
        if (localObject2 != null)
        {
          Object localObject3 = new StringBuilder("[registerRedDot] TAB_TYPE_FOLLOW isShow=");
          label99:
          int i;
          label129:
          label155:
          label173:
          label306:
          label322:
          label359:
          long l;
          if (parama == null)
          {
            localObject1 = null;
            localObject3 = ((StringBuilder)localObject3).append(localObject1).append(" show_type=");
            if (parama != null) {
              break label559;
            }
            localObject1 = null;
            Log.i("Finder.HomeActionBarUIC", localObject1);
            if ((parama == null) || (parama.hBY != true)) {
              break label589;
            }
            i = 1;
            if (i == 0) {
              break label973;
            }
            localObject1 = parama.ASg;
            if ((localObject1 == null) || (((bxq)localObject1).show_type != 3)) {
              break label594;
            }
            i = 1;
            if (i == 0) {
              break label642;
            }
            localObject1 = parama.ASg;
            if (localObject1 != null) {
              break label599;
            }
            localObject1 = null;
            if (Util.isNullOrNil((String)localObject1)) {
              break label642;
            }
            localObject1 = ((b)localObject2).EFo;
            if (localObject1 != null) {
              ((ImageView)localObject1).setVisibility(4);
            }
            localObject1 = ((b)localObject2).GRq;
            if (localObject1 != null) {
              ((ViewGroup)localObject1).setVisibility(4);
            }
            localObject1 = ((b)localObject2).GRt;
            if (localObject1 != null) {
              ((TextView)localObject1).setVisibility(0);
            }
            localObject1 = ((b)localObject2).GRp;
            if (localObject1 != null) {
              ((ImageView)localObject1).setVisibility(4);
            }
            localObject2 = ((b)localObject2).GRt;
            if (localObject2 != null)
            {
              localObject1 = parama.ASg;
              if (localObject1 != null) {
                break label609;
              }
              localObject1 = (CharSequence)"";
              label299:
              ((TextView)localObject2).setText((CharSequence)localObject1);
            }
            localObject1 = parama.ASh;
            if (localObject1 != null) {
              break label896;
            }
            localObject1 = "";
            if ((kotlin.g.b.s.p(paramaf.GQW, localObject1)) || (!paramaf.EFm)) {
              break label1053;
            }
            localObject2 = com.tencent.mm.plugin.finder.report.z.FrZ;
            localObject2 = parama.ASg;
            if (localObject2 != null) {
              break label920;
            }
            i = 1;
            localObject2 = parama.ASh;
            if (localObject2 != null) {
              break label929;
            }
            l = 0L;
            label372:
            localObject2 = as.GSQ;
            localObject2 = as.a.hu((Context)paramaf.getActivity());
            if (localObject2 != null) {
              break label955;
            }
            localObject2 = null;
            label397:
            localObject3 = com.tencent.mm.ui.component.k.aeZF;
            com.tencent.mm.plugin.finder.report.z.a("2", 7, 1, i, 0, 0, (String)localObject1, null, l, (bui)localObject2, ((FinderHomeUIC)com.tencent.mm.ui.component.k.d(paramaf.getActivity()).q(FinderHomeUIC.class)).fnX(), 0, 2176);
            paramaf.GQW = ((String)localObject1);
            localObject1 = parama.ASh;
            localObject2 = parama.ASg;
            if ((localObject1 == null) || (localObject2 == null)) {
              break label1053;
            }
            localObject3 = com.tencent.mm.plugin.finder.report.w.FrV;
            parama = as.GSQ;
            parama = as.a.hu((Context)paramaf.getActivity());
            if (parama != null) {
              break label965;
            }
          }
          label559:
          label955:
          label965:
          for (parama = null;; parama = parama.fou())
          {
            com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
            com.tencent.mm.plugin.finder.report.w.a((com.tencent.mm.plugin.finder.report.w)localObject3, "2", (com.tencent.mm.plugin.finder.extension.reddot.p)localObject1, (bxq)localObject2, 1, parama, 0, null, ((FinderHomeUIC)com.tencent.mm.ui.component.k.d(paramaf.getActivity()).q(FinderHomeUIC.class)).fnX(), 352);
            AppMethodBeat.o(338994);
            return;
            localObject1 = Boolean.valueOf(parama.hBY);
            break;
            localObject1 = parama.ASg;
            if (localObject1 == null)
            {
              localObject1 = null;
              break label99;
            }
            localObject1 = Integer.valueOf(((bxq)localObject1).show_type);
            break label99;
            label589:
            i = 0;
            break label129;
            label594:
            i = 0;
            break label155;
            label599:
            localObject1 = ((bxq)localObject1).title;
            break label173;
            label609:
            localObject1 = ((bxq)localObject1).title;
            if (localObject1 == null)
            {
              localObject1 = (CharSequence)"";
              break label299;
            }
            localObject1 = (CharSequence)localObject1;
            break label299;
            localObject1 = parama.ASg;
            if ((localObject1 != null) && (((bxq)localObject1).show_type == 15)) {}
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label785;
              }
              localObject1 = ((b)localObject2).GRp;
              if (localObject1 != null) {
                ((ImageView)localObject1).setImageResource(e.g.finder_live_icon);
              }
              localObject1 = ((b)localObject2).EFo;
              if (localObject1 != null) {
                ((ImageView)localObject1).setVisibility(4);
              }
              localObject1 = ((b)localObject2).GRp;
              if (localObject1 != null) {
                ((ImageView)localObject1).setVisibility(0);
              }
              localObject1 = ((b)localObject2).GRq;
              if (localObject1 != null) {
                ((ViewGroup)localObject1).setVisibility(4);
              }
              localObject1 = ((b)localObject2).GRt;
              if (localObject1 == null) {
                break;
              }
              ((TextView)localObject1).setVisibility(8);
              break;
            }
            localObject1 = ((b)localObject2).GRp;
            if (localObject1 != null) {
              ((ImageView)localObject1).setVisibility(4);
            }
            localObject1 = ((b)localObject2).EFo;
            if (localObject1 != null) {
              ((ImageView)localObject1).setImageResource(e.d.unread_dot_shape);
            }
            localObject1 = ((b)localObject2).EFo;
            if (localObject1 != null) {
              ((ImageView)localObject1).setVisibility(0);
            }
            localObject1 = ((b)localObject2).GRq;
            if (localObject1 != null) {
              ((ViewGroup)localObject1).setVisibility(4);
            }
            localObject1 = ((b)localObject2).GRt;
            if (localObject1 == null) {
              break label306;
            }
            ((TextView)localObject1).setVisibility(8);
            break label306;
            localObject2 = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).field_tipsId;
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label322;
            }
            localObject1 = "";
            break label322;
            i = ((bxq)localObject2).show_type;
            break label359;
            localObject2 = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject2).field_ctrInfo;
            if (localObject2 == null)
            {
              l = 0L;
              break label372;
            }
            l = ((btw)localObject2).feedId;
            break label372;
            localObject2 = ((as)localObject2).fou();
            break label397;
          }
          label642:
          label785:
          label920:
          label929:
          label973:
          paramaf.GQW = "";
          label896:
          paramaf = ((b)localObject2).GRp;
          if (paramaf != null) {
            paramaf.setVisibility(4);
          }
          paramaf = ((b)localObject2).EFo;
          if (paramaf != null) {
            paramaf.setVisibility(4);
          }
          paramaf = ((b)localObject2).GRq;
          if (paramaf != null) {
            paramaf.setVisibility(4);
          }
          paramaf = ((b)localObject2).GRt;
          if (paramaf != null) {
            paramaf.setVisibility(8);
          }
        }
      }
    }
    label1053:
    AppMethodBeat.o(338994);
  }
  
  private static final void bC(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(339044);
    kotlin.g.b.s.u(parama, "$call");
    parama.invoke();
    AppMethodBeat.o(339044);
  }
  
  private static final void c(af paramaf, View paramView)
  {
    AppMethodBeat.i(338919);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramaf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramaf, "this$0");
    paramaf.efU();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(338919);
  }
  
  private static final void c(af paramaf, l.a parama)
  {
    AppMethodBeat.i(339005);
    kotlin.g.b.s.u(paramaf, "this$0");
    Object localObject1 = (TabLayout)paramaf.findViewById(e.e.tabLayout);
    if (localObject1 != null)
    {
      localObject1 = a((TabLayout)localObject1, Integer.valueOf(1));
      if (localObject1 != null)
      {
        Object localObject3 = ((TabLayout.e)localObject1).tag;
        if (localObject3 != null)
        {
          int i;
          label93:
          label120:
          Object localObject2;
          label189:
          label205:
          long l;
          label242:
          Object localObject4;
          if (parama == null)
          {
            localObject1 = null;
            Log.i("Finder.HomeActionBarUIC", kotlin.g.b.s.X("[registerRedDot] TAB_TYPE_FRIEND isShow=", localObject1));
            if ((parama == null) || (parama.hBY != true)) {
              break label484;
            }
            i = 1;
            if (i == 0) {
              break label630;
            }
            localObject1 = parama.ASg;
            if ((localObject1 == null) || (((bxq)localObject1).show_type != 15)) {
              break label489;
            }
            i = 1;
            if (i == 0) {
              break label494;
            }
            localObject1 = ((b)localObject3).GRp;
            if (localObject1 != null) {
              ((ImageView)localObject1).setImageResource(e.g.finder_live_icon);
            }
            localObject1 = ((b)localObject3).EFo;
            if (localObject1 != null) {
              ((ImageView)localObject1).setVisibility(4);
            }
            localObject1 = ((b)localObject3).GRp;
            if (localObject1 != null) {
              ((ImageView)localObject1).setVisibility(0);
            }
            localObject1 = parama.ASh;
            if (localObject1 != null) {
              break label562;
            }
            localObject1 = "";
            if ((!kotlin.g.b.s.p(paramaf.GQX, localObject1)) && (paramaf.EFm))
            {
              localObject2 = com.tencent.mm.plugin.finder.report.z.FrZ;
              localObject2 = parama.ASh;
              if (localObject2 != null) {
                break label586;
              }
              l = 0L;
              localObject2 = as.GSQ;
              localObject2 = as.a.hu((Context)paramaf.getActivity());
              if (localObject2 != null) {
                break label612;
              }
              localObject2 = null;
              label267:
              localObject4 = com.tencent.mm.ui.component.k.aeZF;
              com.tencent.mm.plugin.finder.report.z.a("2", 8, 1, 1, 0, 0, (String)localObject1, null, l, (bui)localObject2, ((FinderHomeUIC)com.tencent.mm.ui.component.k.d(paramaf.getActivity()).q(FinderHomeUIC.class)).fnX(), 0, 2176);
              paramaf.GQX = ((String)localObject1);
              localObject1 = parama.ASh;
              localObject2 = parama.ASg;
              if ((localObject1 != null) && (localObject2 != null))
              {
                localObject4 = com.tencent.mm.plugin.finder.report.w.FrV;
                parama = as.GSQ;
                parama = as.a.hu((Context)paramaf.getActivity());
                if (parama != null) {
                  break label622;
                }
              }
            }
          }
          label484:
          label489:
          label494:
          label622:
          for (parama = null;; parama = parama.fou())
          {
            com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
            com.tencent.mm.plugin.finder.report.w.a((com.tencent.mm.plugin.finder.report.w)localObject4, "2", (com.tencent.mm.plugin.finder.extension.reddot.p)localObject1, (bxq)localObject2, 1, parama, 0, null, ((FinderHomeUIC)com.tencent.mm.ui.component.k.d(paramaf.getActivity()).q(FinderHomeUIC.class)).fnX(), 352);
            paramaf = ((b)localObject3).GRs;
            if (paramaf != null) {
              paramaf.setTag(null);
            }
            paramaf = ((b)localObject3).GRr;
            if (paramaf != null) {
              paramaf.setVisibility(0);
            }
            paramaf = ((b)localObject3).GRs;
            if (paramaf == null) {
              break label673;
            }
            paramaf.setVisibility(8);
            AppMethodBeat.o(339005);
            return;
            localObject1 = Boolean.valueOf(parama.hBY);
            break;
            i = 0;
            break label93;
            i = 0;
            break label120;
            localObject1 = ((b)localObject3).EFo;
            if (localObject1 != null) {
              ((ImageView)localObject1).setVisibility(0);
            }
            localObject1 = ((b)localObject3).GRp;
            if (localObject1 != null) {
              ((ImageView)localObject1).setVisibility(4);
            }
            localObject1 = ((b)localObject3).EFo;
            if (localObject1 == null) {
              break label189;
            }
            ((ImageView)localObject1).setImageResource(e.d.unread_dot_shape);
            break label189;
            localObject2 = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).field_tipsId;
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label205;
            }
            localObject1 = "";
            break label205;
            localObject2 = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject2).field_ctrInfo;
            if (localObject2 == null)
            {
              l = 0L;
              break label242;
            }
            l = ((btw)localObject2).feedId;
            break label242;
            localObject2 = ((as)localObject2).fou();
            break label267;
          }
          label562:
          label586:
          label612:
          label630:
          paramaf.GQX = "";
          paramaf = ((b)localObject3).EFo;
          if (paramaf != null) {
            paramaf.setVisibility(4);
          }
          paramaf = ((b)localObject3).GRp;
          if (paramaf != null) {
            paramaf.setVisibility(4);
          }
        }
      }
    }
    label673:
    AppMethodBeat.o(339005);
  }
  
  private static final void d(af paramaf, View paramView)
  {
    AppMethodBeat.i(338930);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramaf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramaf, "this$0");
    paramView = new Intent();
    localObject = as.GSQ;
    as.a.a((Context)paramaf.getActivity(), paramView, 0L, 0, false, 124);
    localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eVC().bmg()).intValue() == 1)
    {
      localObject = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.W((Context)paramaf.getActivity(), paramView);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(338930);
      return;
    }
    localObject = com.tencent.mm.model.z.bAW();
    kotlin.g.b.s.s(localObject, "getMyFinderUsername()");
    if (((CharSequence)localObject).length() > 0)
    {
      i = 1;
      label180:
      localObject = com.tencent.mm.plugin.report.service.h.OAn;
      if (i == 0) {
        break label245;
      }
    }
    label245:
    for (int i = 1;; i = 2)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).b(20971, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Integer.valueOf(1) });
      localObject = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.V((Context)paramaf.getActivity(), paramView);
      break;
      i = 0;
      break label180;
    }
  }
  
  private static final void d(af paramaf, l.a parama)
  {
    AppMethodBeat.i(339011);
    kotlin.g.b.s.u(paramaf, "this$0");
    Object localObject1 = (TabLayout)paramaf.findViewById(e.e.tabLayout);
    if (localObject1 != null)
    {
      localObject1 = a((TabLayout)localObject1, Integer.valueOf(4));
      if (localObject1 != null)
      {
        Object localObject2 = ((TabLayout.e)localObject1).tag;
        if (localObject2 != null)
        {
          boolean bool;
          Object localObject3;
          label95:
          int i;
          if (paramaf.getIntent().getIntExtra("FROM_SCENE_KEY", 2) == 6)
          {
            bool = true;
            localObject3 = new StringBuilder("[registerRedDot] TAB_TYPE_MACHINE isShow=");
            if (parama != null) {
              break label410;
            }
            localObject1 = null;
            Log.i("Finder.HomeActionBarUIC", localObject1 + " isFromShareToTimeline=" + bool);
            if ((parama == null) || (parama.hBY != true)) {
              break label422;
            }
            i = 1;
            label135:
            if ((i == 0) || (bool)) {
              break label498;
            }
            localObject1 = parama.ASg;
            if ((localObject1 == null) || (((bxq)localObject1).show_type != 6)) {
              break label427;
            }
            i = 1;
            label166:
            if (i == 0) {
              break label432;
            }
            localObject1 = ((b)localObject2).EFo;
            if (localObject1 != null) {
              ((ImageView)localObject1).setVisibility(4);
            }
            label191:
            localObject1 = parama.ASh;
            if (localObject1 != null) {
              break label456;
            }
            localObject1 = "";
            label207:
            if ((kotlin.g.b.s.p(paramaf.GQY, localObject1)) || (!paramaf.EFm)) {
              break label523;
            }
            localObject2 = com.tencent.mm.plugin.finder.report.z.FrZ;
            localObject2 = as.GSQ;
            localObject2 = as.a.hu((Context)paramaf.getActivity());
            if (localObject2 != null) {
              break label480;
            }
            localObject2 = null;
            label256:
            localObject3 = com.tencent.mm.ui.component.k.aeZF;
            com.tencent.mm.plugin.finder.report.z.a("2", 3, 1, 1, 2, 0, (String)localObject1, null, 0L, (bui)localObject2, ((FinderHomeUIC)com.tencent.mm.ui.component.k.d(paramaf.getActivity()).q(FinderHomeUIC.class)).fnX(), 0, 2432);
            paramaf.GQY = ((String)localObject1);
            localObject1 = parama.ASh;
            localObject2 = parama.ASg;
            if ((localObject1 == null) || (localObject2 == null)) {
              break label523;
            }
            localObject3 = com.tencent.mm.plugin.finder.report.w.FrV;
            parama = as.GSQ;
            parama = as.a.hu((Context)paramaf.getActivity());
            if (parama != null) {
              break label490;
            }
          }
          label410:
          label422:
          label427:
          label432:
          label456:
          label480:
          label490:
          for (parama = null;; parama = parama.fou())
          {
            com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
            com.tencent.mm.plugin.finder.report.w.a((com.tencent.mm.plugin.finder.report.w)localObject3, "2", (com.tencent.mm.plugin.finder.extension.reddot.p)localObject1, (bxq)localObject2, 1, parama, 0, null, ((FinderHomeUIC)com.tencent.mm.ui.component.k.d(paramaf.getActivity()).q(FinderHomeUIC.class)).fnX(), 352);
            AppMethodBeat.o(339011);
            return;
            bool = false;
            break;
            localObject1 = Boolean.valueOf(parama.hBY);
            break label95;
            i = 0;
            break label135;
            i = 0;
            break label166;
            localObject1 = ((b)localObject2).EFo;
            if (localObject1 == null) {
              break label191;
            }
            ((ImageView)localObject1).setVisibility(0);
            break label191;
            localObject2 = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).field_tipsId;
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label207;
            }
            localObject1 = "";
            break label207;
            localObject2 = ((as)localObject2).fou();
            break label256;
          }
          label498:
          paramaf.GQY = "";
          paramaf = ((b)localObject2).EFo;
          if (paramaf != null) {
            paramaf.setVisibility(4);
          }
        }
      }
    }
    label523:
    AppMethodBeat.o(339011);
  }
  
  private static final void e(af paramaf, View paramView)
  {
    AppMethodBeat.i(338936);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramaf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramaf, "this$0");
    ag.a(paramaf.getActivity().getTaskId(), (ag.a)new e(paramaf));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(338936);
  }
  
  private static final void e(af paramaf, l.a parama)
  {
    AppMethodBeat.i(339018);
    kotlin.g.b.s.u(paramaf, "this$0");
    int i;
    Object localObject1;
    label56:
    Object localObject2;
    if ((parama != null) && (parama.hBY == true))
    {
      i = 1;
      if (i == 0) {
        break label260;
      }
      localObject1 = paramaf.findViewById(e.e.lbsEntranceTabRed);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      if (parama != null) {
        break label205;
      }
      localObject1 = "";
      if ((kotlin.g.b.s.p(paramaf.GQZ, localObject1)) || (!paramaf.EFm)) {
        break label284;
      }
      localObject2 = com.tencent.mm.plugin.finder.report.z.FrZ;
      localObject2 = as.GSQ;
      localObject2 = as.a.hu((Context)paramaf.getActivity());
      if (localObject2 != null) {
        break label242;
      }
      localObject2 = null;
      label104:
      com.tencent.mm.plugin.finder.report.z.a("2", 3, 1, 1, 1, 0, (String)localObject1, null, 0L, (bui)localObject2, 0, 0, 3456);
      paramaf.GQZ = ((String)localObject1);
      localObject1 = parama.ASh;
      parama = parama.ASg;
      if ((localObject1 == null) || (parama == null)) {
        break label284;
      }
      localObject2 = com.tencent.mm.plugin.finder.report.w.FrV;
      as.a locala = as.GSQ;
      paramaf = as.a.hu((Context)paramaf.getActivity());
      if (paramaf != null) {
        break label252;
      }
    }
    label205:
    label242:
    label252:
    for (paramaf = null;; paramaf = paramaf.fou())
    {
      com.tencent.mm.plugin.finder.report.w.a((com.tencent.mm.plugin.finder.report.w)localObject2, "2", (com.tencent.mm.plugin.finder.extension.reddot.p)localObject1, parama, 1, paramaf, 0, null, 2, 352);
      AppMethodBeat.o(339018);
      return;
      i = 0;
      break;
      localObject1 = parama.ASh;
      if (localObject1 == null)
      {
        localObject1 = "";
        break label56;
      }
      localObject2 = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).field_tipsId;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label56;
      }
      localObject1 = "";
      break label56;
      localObject2 = ((as)localObject2).fou();
      break label104;
    }
    label260:
    paramaf.GQZ = "";
    paramaf = paramaf.findViewById(e.e.lbsEntranceTabRed);
    if (paramaf != null) {
      paramaf.setVisibility(4);
    }
    label284:
    AppMethodBeat.o(339018);
  }
  
  private final void efU()
  {
    AppMethodBeat.i(338876);
    ((cn)com.tencent.mm.kernel.h.az(cn.class)).getRedDotManager().TL("TLPostCamera");
    Object localObject1 = com.tencent.mm.plugin.finder.report.v.FrN;
    com.tencent.mm.plugin.finder.report.v.T(false, 1);
    localObject1 = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    if (com.tencent.mm.plugin.findersdk.d.a.aDj("post"))
    {
      AppMethodBeat.o(338876);
      return;
    }
    localObject1 = av.GiL;
    switch (av.fgg())
    {
    case 3: 
    default: 
      if (Util.isNullOrNil(com.tencent.mm.model.z.bAW()))
      {
        Log.e("Finder.HomeActionBarUIC", "getMyFinderUsername is null.");
        AppMethodBeat.o(338876);
        return;
      }
      break;
    case 6: 
      aa.makeText((Context)getActivity(), (CharSequence)getActivity().getResources().getString(e.h.account_status_tips_1), 1).show();
      Vg(6);
      AppMethodBeat.o(338876);
      return;
    case 4: 
      aa.makeText((Context)getActivity(), (CharSequence)getActivity().getResources().getString(e.h.account_status_tips_3), 1).show();
      Vg(4);
      AppMethodBeat.o(338876);
      return;
    case 5: 
      aa.makeText((Context)getActivity(), (CharSequence)getActivity().getResources().getString(e.h.account_status_tips_2), 1).show();
      Vg(5);
      AppMethodBeat.o(338876);
      return;
    case 2: 
      localObject1 = new f((Context)getActivity(), 1, true);
      ((f)localObject1).Vtg = af..ExternalSyntheticLambda13.INSTANCE;
      ((f)localObject1).GAC = new af..ExternalSyntheticLambda14(this);
      localObject2 = com.tencent.mm.ui.af.mU((Context)getActivity()).inflate(e.f.finder_sheet_header, null);
      localObject3 = ((View)localObject2).findViewById(e.e.accountLayout);
      if (localObject3 != null) {
        ((View)localObject3).setVisibility(8);
      }
      localObject3 = ((View)localObject2).findViewById(e.e.titleTv2);
      if (localObject3 != null) {
        ((View)localObject3).setVisibility(8);
      }
      localObject3 = ((View)localObject2).findViewById(e.e.titleTv);
      if (localObject3 != null) {
        ((View)localObject3).setVisibility(0);
      }
      localObject3 = (TextView)((View)localObject2).findViewById(e.e.titleTv);
      if (localObject3 != null) {
        ((TextView)localObject3).setText((CharSequence)getActivity().getResources().getString(e.h.finder_account_post_title));
      }
      ((f)localObject1).af((View)localObject2, true);
      ((f)localObject1).dDn();
      AppMethodBeat.o(338876);
      return;
    }
    localObject1 = getActivity();
    Object localObject2 = com.tencent.mm.plugin.finder.utils.a.GfO;
    if (com.tencent.mm.plugin.finder.utils.a.gW((Context)localObject1))
    {
      localObject1 = com.tencent.mm.plugin.finder.report.v.FrN;
      com.tencent.mm.plugin.finder.report.v.aP(3, true);
      AppMethodBeat.o(338876);
      return;
    }
    localObject2 = com.tencent.mm.plugin.finder.report.v.FrN;
    com.tencent.mm.plugin.finder.report.v.aP(3, false);
    localObject2 = new f((Context)localObject1, 1, true);
    Object localObject3 = com.tencent.mm.ui.af.mU((Context)localObject1).inflate(e.f.finder_sheet_header, null);
    Object localObject6 = (TextView)((View)localObject3).findViewById(e.e.nickname);
    Object localObject4 = (ImageView)((View)localObject3).findViewById(e.e.avatar);
    Object localObject5 = ((View)localObject3).findViewById(e.e.titleTv);
    if (localObject5 != null) {
      ((View)localObject5).setVisibility(8);
    }
    localObject5 = ((View)localObject3).findViewById(e.e.titleTv2);
    if (localObject5 != null) {
      ((View)localObject5).setVisibility(0);
    }
    localObject5 = com.tencent.mm.plugin.finder.api.d.AwY;
    localObject5 = d.a.auT(com.tencent.mm.model.z.bAW());
    if (localObject5 != null)
    {
      ((TextView)localObject6).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject1, (CharSequence)((com.tencent.mm.plugin.finder.api.m)localObject5).getNickname()));
      localObject6 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject6 = com.tencent.mm.plugin.finder.loader.p.eCp();
      com.tencent.mm.plugin.finder.loader.b localb = new com.tencent.mm.plugin.finder.loader.b(((com.tencent.mm.plugin.finder.api.m)localObject5).field_avatarUrl);
      kotlin.g.b.s.s(localObject4, "avatarIv");
      com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject6).a(localb, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
      localObject4 = av.GiL;
      kotlin.g.b.s.s(localObject3, "headerView");
      av.a((com.tencent.mm.plugin.finder.api.m)localObject5, (View)localObject3);
    }
    localObject4 = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localObject4 = com.tencent.mm.kernel.b.aZs() + '_' + Util.nowMilliSecond();
    localObject5 = com.tencent.mm.plugin.finder.report.v.FrN;
    com.tencent.mm.plugin.finder.report.v.azP((String)localObject4);
    ((f)localObject2).af((View)localObject3, true);
    ((f)localObject2).Vtg = af..ExternalSyntheticLambda12.INSTANCE;
    ((f)localObject2).GAC = new af..ExternalSyntheticLambda15((String)localObject4, (AppCompatActivity)localObject1);
    ((f)localObject2).aeLi = af..ExternalSyntheticLambda16.INSTANCE;
    ((f)localObject2).dDn();
    AppMethodBeat.o(338876);
  }
  
  private static final void f(af paramaf, View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(338944);
    Object localObject2 = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramaf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject2, localb.aYj());
    kotlin.g.b.s.u(paramaf, "this$0");
    paramView = as.GSQ;
    paramView = as.a.hu((Context)paramaf.getActivity());
    if (paramView == null)
    {
      paramView = null;
      if ((paramView instanceof ae))
      {
        paramView = (ae)paramView;
        localObject2 = com.tencent.mm.plugin.finder.report.m.Fpx;
        paramView.azV(com.tencent.mm.plugin.finder.report.m.a.aj(ak.l(kotlin.v.Y("feedActionType", Integer.valueOf(3)))));
      }
      paramaf.Vf(2);
      localObject2 = new Intent();
      paramView = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("TLPersonalCenter");
      if (paramView != null) {
        break label254;
      }
      paramView = localObject1;
      label164:
      if (paramView == null) {
        break label265;
      }
    }
    label265:
    for (boolean bool = true;; bool = false)
    {
      ((Intent)localObject2).putExtra("RED_DOT_EXIST_ON_ENTER", bool);
      paramView = as.GSQ;
      as.a.a((Context)paramaf.getActivity(), (Intent)localObject2, 0L, 0, false, 124);
      paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.enterFinderSelfUI((Context)paramaf.getActivity(), (Intent)localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(338944);
      return;
      paramView = as.a(paramView);
      break;
      label254:
      paramView = paramView.avK("TLPersonalCenter");
      break label164;
    }
  }
  
  private final void fmv()
  {
    AppMethodBeat.i(338843);
    TabLayout localTabLayout = (TabLayout)findViewById(e.e.tabLayout);
    if (localTabLayout == null)
    {
      AppMethodBeat.o(338843);
      return;
    }
    Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = ((Iterable)((FinderHomeUIC)com.tencent.mm.ui.component.k.d(getActivity()).q(FinderHomeUIC.class)).fragments).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      localObject2 = (FinderHomeTabFragment)localObject2;
      Object localObject3 = localTabLayout.WW();
      kotlin.g.b.s.s(localObject3, "tabLayout.newTab()");
      localObject3 = new b((TabLayout.e)localObject3, ((FinderHomeTabFragment)localObject2).hJx);
      int j = ((FinderHomeTabFragment)localObject2).title;
      TextView localTextView = ((b)localObject3).titleTv;
      if (localTextView != null)
      {
        Object localObject4 = com.tencent.mm.plugin.finder.storage.d.FAy;
        int k = ((b)localObject3).hJx;
        localObject4 = ((b)localObject3).dyQ.dyK;
        kotlin.g.b.s.checkNotNull(localObject4);
        localObject4 = ((View)localObject4).getContext().getResources().getString(j);
        kotlin.g.b.s.s(localObject4, "tab.customView!!.context.resources.getString(id)");
        localTextView.setText((CharSequence)com.tencent.mm.plugin.finder.storage.d.bD(k, (String)localObject4));
      }
      ((b)localObject3).index = i;
      if (((FinderHomeTabFragment)localObject2).hJx == 4) {
        ((b)localObject3).dyQ.E((CharSequence)getString(e.h.finder_tab_machine_desc));
      }
      if (((FinderHomeTabFragment)localObject2).hJx == 1) {
        ((b)localObject3).dyQ.E((CharSequence)getString(e.h.finder_tab_friend_desc));
      }
      if (((FinderHomeTabFragment)localObject2).hJx == 3) {
        ((b)localObject3).dyQ.E((CharSequence)getString(e.h.finder_tab_follow_desc));
      }
      localTabLayout.a(((b)localObject3).dyQ, false);
      i += 1;
    }
    localTabLayout.a((TabLayout.b)new c(this));
    AppMethodBeat.o(338843);
  }
  
  private final com.tencent.mm.plugin.finder.viewmodel.d fnT()
  {
    AppMethodBeat.i(338816);
    com.tencent.mm.plugin.finder.viewmodel.d locald = (com.tencent.mm.plugin.finder.viewmodel.d)this.GQU.getValue();
    AppMethodBeat.o(338816);
    return locald;
  }
  
  private static final void fnU()
  {
    AppMethodBeat.i(339041);
    com.tencent.mm.plugin.finder.report.v localv = com.tencent.mm.plugin.finder.report.v.FrN;
    com.tencent.mm.plugin.finder.report.v.SA(6);
    AppMethodBeat.o(339041);
  }
  
  private static final void g(af paramaf, View paramView)
  {
    AppMethodBeat.i(338949);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramaf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramaf, "this$0");
    paramView = bb.FuK;
    paramView = as.GSQ;
    paramView = as.a.hu((Context)paramaf.getActivity());
    if (paramView == null) {}
    for (paramView = null;; paramView = paramView.fou())
    {
      bb.a(paramView, "button_create_float_frame", 1);
      paramView = com.tencent.mm.ui.component.k.aeZF;
      paramaf = com.tencent.mm.ui.component.k.d(paramaf.getActivity()).q(w.class);
      kotlin.g.b.s.s(paramaf, "UICProvider.of(activity)…allNormalUIC::class.java)");
      w.a((w)paramaf);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(338949);
      return;
    }
  }
  
  private static final void m(com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(339022);
    if (params.jmw()) {
      params.oh(1, e.h.finder_post);
    }
    AppMethodBeat.o(339022);
  }
  
  private static final void n(com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(339034);
    if (params.jmw())
    {
      params.oh(1001, e.h.app_field_mmsight);
      params.oh(1002, e.h.app_field_select_new_pic);
    }
    AppMethodBeat.o(339034);
  }
  
  public final void N(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(339254);
    this.GRj = paramInt2;
    this.GRk = paramInt1;
    this.GRh = paramInt4;
    this.GRi = paramInt3;
    Object localObject = av.GiL;
    localObject = getActivity().getWindow();
    kotlin.g.b.s.s(localObject, "activity.window");
    av.d((Window)localObject);
    ((MMActivity)getActivity()).setNavigationbarColor(getActivity().getResources().getColor(e.b.black));
    localObject = findViewById(e.e.finderHomeActionbar);
    if (localObject != null) {
      ((View)localObject).setBackground(null);
    }
    if (paramInt1 != -1)
    {
      localObject = Vh(this.GRh);
      if (localObject != null) {
        ((b)localObject).aY(this.GRc, false);
      }
      localObject = Vh(this.GRi);
      if (localObject != null) {
        ((b)localObject).aY(this.GRe, true);
      }
    }
    AppMethodBeat.o(339254);
  }
  
  public final void Qw(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(339229);
    Object localObject = (TabLayout)findViewById(e.e.tabLayout);
    if (localObject != null)
    {
      localObject = ((TabLayout)localObject).js(paramInt);
      if ((localObject != null) && (!((TabLayout.e)localObject).isSelected()))
      {
        ((TabLayout.e)localObject).Xf();
        localObject = ((TabLayout.e)localObject).tag;
        if (!(localObject instanceof b)) {
          break label228;
        }
        localObject = (b)localObject;
        if (localObject != null)
        {
          localObject = fnT().GKo;
          ((bwj)localObject).ZJy = 1;
          ((bwj)localObject).aafr = fnT().GKq;
          if (((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("TLRecommendTab") == null) {
            break label234;
          }
          bool1 = true;
          label128:
          ((bwj)localObject).aafq = bool1;
          if (((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("TLFollow") == null) {
            break label239;
          }
          bool1 = true;
          label157:
          ((bwj)localObject).aafp = bool1;
          if (((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("finder_tl_hot_tab") == null) {
            break label244;
          }
          bool1 = true;
          label186:
          ((bwj)localObject).aafo = bool1;
          if (((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("FinderEntrance") == null) {
            break label249;
          }
        }
      }
    }
    label228:
    label234:
    label239:
    label244:
    label249:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((bwj)localObject).aafn = bool1;
      AppMethodBeat.o(339229);
      return;
      localObject = null;
      break;
      bool1 = false;
      break label128;
      bool1 = false;
      break label157;
      bool1 = false;
      break label186;
    }
  }
  
  public final b Vh(int paramInt)
  {
    AppMethodBeat.i(338896);
    Object localObject = (TabLayout)findViewById(e.e.tabLayout);
    if (localObject == null) {
      localObject = null;
    }
    while ((localObject instanceof b))
    {
      localObject = (b)localObject;
      AppMethodBeat.o(338896);
      return localObject;
      localObject = a((TabLayout)localObject, Integer.valueOf(paramInt));
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((TabLayout.e)localObject).tag;
      }
    }
    AppMethodBeat.o(338896);
    return null;
  }
  
  public final void a(boolean paramBoolean, int paramInt, FinderHomeTabFragment paramFinderHomeTabFragment)
  {
    AppMethodBeat.i(339247);
    kotlin.g.b.s.u(paramFinderHomeTabFragment, "fragment");
    AppMethodBeat.o(339247);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(339212);
    paramBundle = getActivity().getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    paramBundle = getActivity().getWindow().getDecorView();
    kotlin.g.b.s.s(paramBundle, "activity.window.decorView");
    paramBundle.setSystemUiVisibility(paramBundle.getSystemUiVisibility() | 0x400 | 0x100);
    getActivity().getWindow().setStatusBarColor(0);
    c.h((Activity)getActivity(), false);
    paramBundle = getActivity().getSupportActionBar();
    if (paramBundle != null)
    {
      paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      paramBundle.hide();
    }
    int i = bf.getStatusBarHeight((Context)getActivity());
    paramBundle = findViewById(e.e.finderHomeActionbar);
    if (paramBundle != null)
    {
      ViewGroup.LayoutParams localLayoutParams = paramBundle.getLayoutParams();
      localLayoutParams.height += i;
      paramBundle.setLayoutParams(localLayoutParams);
      paramBundle.setPadding(0, i, 0, 0);
    }
    com.tencent.mm.kernel.h.aZW().a(3761, (com.tencent.mm.am.h)this);
    paramBundle = findViewById(e.e.backBtn);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new af..ExternalSyntheticLambda5(this));
    }
    paramBundle = findViewById(e.e.lbsEntranceLayout);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new af..ExternalSyntheticLambda1(this));
    }
    paramBundle = findViewById(e.e.postEntranceLayout);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new af..ExternalSyntheticLambda3(this));
    }
    paramBundle = findViewById(e.e.searchEntranceLayout);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new af..ExternalSyntheticLambda0(this));
    }
    paramBundle = findViewById(e.e.splitEntranceLayout);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new af..ExternalSyntheticLambda6(this));
    }
    paramBundle = (HardTouchableLayout)findViewById(e.e.tabLayoutContainer);
    if (paramBundle != null) {
      paramBundle.setOnDoubleClickListener((HardTouchableLayout.b)new f(this));
    }
    paramBundle = findViewById(e.e.personalCenter);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new af..ExternalSyntheticLambda2(this));
    }
    paramBundle = findViewById(e.e.float_ball_btn_layout);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new af..ExternalSyntheticLambda4(this));
    }
    fmv();
    paramBundle = l.ARA;
    com.tencent.mm.ae.d.a((LiveData)l.dZF(), (q)getActivity(), new af..ExternalSyntheticLambda11(this));
    paramBundle = l.ARA;
    com.tencent.mm.ae.d.a((LiveData)l.dZI(), (q)getActivity(), new af..ExternalSyntheticLambda10(this));
    paramBundle = l.ARA;
    com.tencent.mm.ae.d.a((LiveData)l.dZJ(), (q)getActivity(), new af..ExternalSyntheticLambda7(this));
    paramBundle = l.ARA;
    com.tencent.mm.ae.d.a((LiveData)l.dZL(), (q)getActivity(), new af..ExternalSyntheticLambda9(this));
    paramBundle = l.ARA;
    com.tencent.mm.ae.d.a((LiveData)l.dZM(), (q)getActivity(), new af..ExternalSyntheticLambda8(this));
    Vf(1);
    paramBundle = findViewById(e.e.searchEntranceLayout);
    if (paramBundle != null) {
      paramBundle.setVisibility(0);
    }
    if ((aw.jlc()) && ((aw.mO((Context)getActivity())) || ((aw.b(getActivity().getContentResolver())) && (Build.VERSION.SDK_INT >= 24) && (!getActivity().isInMultiWindowMode())))) {}
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramBundle = findViewById(e.e.splitEntranceLayout);
        if (paramBundle != null) {
          paramBundle.setVisibility(0);
        }
        paramBundle = findViewById(e.e.float_ball_btn_layout);
        if (paramBundle != null) {
          paramBundle.setVisibility(8);
        }
      }
      paramBundle = findViewById(e.e.lbsEntranceLayout);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = findViewById(e.e.postEntranceLayout);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      if (((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().fgF())
      {
        paramBundle = findViewById(e.e.searchEntranceLayout);
        if (paramBundle != null) {
          paramBundle.setVisibility(0);
        }
        if ((aw.jlc()) && ((aw.mO((Context)getActivity())) || ((aw.b(getActivity().getContentResolver())) && (Build.VERSION.SDK_INT >= 24) && (!getActivity().isInMultiWindowMode()))))
        {
          paramBundle = findViewById(e.e.splitEntranceLayout);
          if (paramBundle != null) {
            paramBundle.setVisibility(0);
          }
          paramBundle = findViewById(e.e.float_ball_btn_layout);
          if (paramBundle != null) {
            paramBundle.setVisibility(8);
          }
        }
        paramBundle = findViewById(e.e.lbsEntranceLayout);
        if (paramBundle != null) {
          paramBundle.setVisibility(8);
        }
        paramBundle = findViewById(e.e.postEntranceLayout);
        if (paramBundle != null) {
          paramBundle.setVisibility(8);
        }
      }
      if (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu())
      {
        paramBundle = findViewById(e.e.lbsEntranceLayout);
        if (paramBundle != null) {
          paramBundle.setVisibility(8);
        }
        paramBundle = findViewById(e.e.postEntranceLayout);
        if (paramBundle != null) {
          paramBundle.setVisibility(8);
        }
        paramBundle = findViewById(e.e.searchEntranceLayout);
        if (paramBundle != null) {
          paramBundle.setVisibility(8);
        }
        paramBundle = findViewById(e.e.tabLayoutContainer);
        if (paramBundle != null) {
          paramBundle.post(new af..ExternalSyntheticLambda17(this));
        }
      }
      paramBundle = (WeImageView)getActivity().findViewById(e.e.backBtnIv);
      if (paramBundle != null) {
        paramBundle.setIconColor(this.GRd);
      }
      paramBundle = (WeImageView)getActivity().findViewById(e.e.searchEntrance);
      if (paramBundle != null) {
        paramBundle.setIconColor(this.GRd);
      }
      paramBundle = (WeImageView)getActivity().findViewById(e.e.splitEntrance);
      if (paramBundle != null) {
        paramBundle.setIconColor(this.GRd);
      }
      paramBundle = (WeImageView)getActivity().findViewById(e.e.postEntrance);
      if (paramBundle != null) {
        paramBundle.setIconColor(this.GRd);
      }
      paramBundle = (WeImageView)getActivity().findViewById(e.e.personalCenter);
      if (paramBundle != null) {
        paramBundle.setIconColor(this.GRd);
      }
      paramBundle = (WeImageView)getActivity().findViewById(e.e.lbsEntrance);
      if (paramBundle != null) {
        paramBundle.setIconColor(this.GRd);
      }
      paramBundle = (WeImageView)getActivity().findViewById(e.e.float_ball_btn);
      if (paramBundle != null) {
        paramBundle.setIconColor(this.GRd);
      }
      paramBundle = getActivity().findViewById(e.e.finderHomeActionbar);
      if (paramBundle != null) {
        paramBundle.setBackground(null);
      }
      paramBundle = getActivity().findViewById(e.e.viewPager);
      if (paramBundle != null) {
        paramBundle.post(new af..ExternalSyntheticLambda18(this));
      }
      paramBundle = (ViewGroup)getActivity().findViewById(e.e.finderHomeActionbar);
      if (paramBundle != null) {
        com.tencent.mm.ae.d.a((View)paramBundle, (kotlin.g.a.a)new d(paramBundle));
      }
      Log.i("Finder.HomeActionBarUIC", kotlin.g.b.s.X("[onCreate] lastShowFriendsAvatarRedDot=", Boolean.valueOf(GRl)));
      AppMethodBeat.o(339212);
      return;
    }
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(339195);
    super.onCreateBefore(paramBundle);
    paramBundle = com.tencent.mm.ui.component.k.aeZF;
    ((FinderHomeUIC)com.tencent.mm.ui.component.k.d(getActivity()).q(FinderHomeUIC.class)).GRB.add(this);
    AppMethodBeat.o(339195);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(339217);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(3761, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(339217);
  }
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(339262);
    kotlin.g.b.s.u(this, "this");
    AppMethodBeat.o(339262);
  }
  
  public final void onPageScrolled(final int paramInt1, float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(339259);
    kotlin.g.a.a locala = (kotlin.g.a.a)new g(paramFloat, paramInt1, this);
    TabLayout localTabLayout = (TabLayout)findViewById(e.e.tabLayout);
    if (localTabLayout == null) {}
    for (paramInt1 = 0; paramInt1 <= 0; paramInt1 = localTabLayout.getHeight())
    {
      localTabLayout = (TabLayout)findViewById(e.e.tabLayout);
      if (localTabLayout == null) {
        break label100;
      }
      localTabLayout.post(new af..ExternalSyntheticLambda19(locala));
      AppMethodBeat.o(339259);
      return;
    }
    locala.invoke();
    label100:
    AppMethodBeat.o(339259);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(339237);
    super.onPause();
    this.EFm = false;
    AppMethodBeat.o(339237);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(339234);
    super.onResume();
    this.EFm = true;
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    switch (((Number)com.tencent.mm.plugin.finder.storage.d.eTC().bmg()).intValue())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(339234);
      return;
      localObject = com.tencent.mm.model.z.bAW();
      kotlin.g.b.s.s(localObject, "getMyFinderUsername()");
      if (((CharSequence)localObject).length() > 0)
      {
        i = 1;
        localObject = com.tencent.mm.plugin.report.service.h.OAn;
        if (i == 0) {
          break label138;
        }
      }
      label138:
      for (int i = 1;; i = 2)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject).b(20971, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(1) });
        AppMethodBeat.o(339234);
        return;
        i = 0;
        break;
      }
      localObject = com.tencent.mm.plugin.finder.report.v.FrN;
      com.tencent.mm.plugin.finder.report.v.T(true, 1);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(339243);
    kotlin.g.b.s.u(paramp, "scene");
    if (paramp.getType() == 3761) {
      this.GRb = false;
    }
    AppMethodBeat.o(339243);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$Companion;", "", "()V", "SHEET_MENU_POST", "", "TAG", "", "lastShowFriendsAvatarRedDot", "", "getLastShowFriendsAvatarRedDot", "()Z", "setLastShowFriendsAvatarRedDot", "(Z)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$FinderTab;", "", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tabType", "", "(Lcom/google/android/material/tabs/TabLayout$Tab;I)V", "bigTabRedIv", "Landroid/widget/ImageView;", "getBigTabRedIv", "()Landroid/widget/ImageView;", "setBigTabRedIv", "(Landroid/widget/ImageView;)V", "changeMargin", "index", "getIndex", "()I", "setIndex", "(I)V", "isAdjust", "", "()Z", "setAdjust", "(Z)V", "newTabRedDotSafeGap", "styleLayout1", "Landroid/view/ViewGroup;", "getStyleLayout1", "()Landroid/view/ViewGroup;", "setStyleLayout1", "(Landroid/view/ViewGroup;)V", "styleLayout2", "getStyleLayout2", "setStyleLayout2", "getTab", "()Lcom/google/android/material/tabs/TabLayout$Tab;", "setTab", "(Lcom/google/android/material/tabs/TabLayout$Tab;)V", "tabRedIcon", "getTabRedIcon", "setTabRedIcon", "tabRedIv", "getTabRedIv", "setTabRedIv", "tabRedTv", "Landroid/widget/TextView;", "getTabRedTv", "()Landroid/widget/TextView;", "setTabRedTv", "(Landroid/widget/TextView;)V", "getTabType", "setTabType", "titleFriendsTv", "getTitleFriendsTv", "setTitleFriendsTv", "titleIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getTitleIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setTitleIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "titleTv", "getTitleTv", "setTitleTv", "setTextBold", "", "isBold", "setTextColor", "color", "isUnSelected", "setTitle", "id", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    WeImageView EFn;
    ImageView EFo;
    private final int GRm;
    private final int GRn;
    private TextView GRo;
    ImageView GRp;
    ViewGroup GRq;
    ViewGroup GRr;
    ViewGroup GRs;
    TextView GRt;
    TabLayout.e dyQ;
    int hJx;
    int index;
    public TextView titleTv;
    
    public b(TabLayout.e parame, int paramInt)
    {
      AppMethodBeat.i(338072);
      this.dyQ = parame;
      this.hJx = paramInt;
      this.GRm = ((int)MMApplicationContext.getContext().getResources().getDimension(e.c.Edge_3A));
      this.GRn = ((int)MMApplicationContext.getContext().getResources().getDimension(e.c.Edge_2_5_A));
      this.dyQ.tag = this;
      parame = com.tencent.mm.plugin.finder.accessibility.a.Ate;
      parame = MMApplicationContext.getContext();
      kotlin.g.b.s.s(parame, "getContext()");
      float f = com.tencent.mm.plugin.finder.accessibility.a.g(parame, 15.0F);
      int i = MMApplicationContext.getContext().getResources().getColor(e.b.hot_tab_unselected_color);
      if (this.hJx == 1)
      {
        this.dyQ.jw(e.f.finder_home_ui_tab_text_image);
        parame = this.dyQ.dyK;
        if (parame == null)
        {
          parame = null;
          this.titleTv = parame;
          parame = this.titleTv;
          if (parame != null) {
            parame.setTextSize(1, f);
          }
          parame = this.GRo;
          if (parame != null) {
            parame.setTextSize(1, f);
          }
          parame = this.dyQ.dyK;
          if (parame != null) {
            break label277;
          }
          parame = null;
          label190:
          this.EFn = parame;
          parame = this.dyQ.dyK;
          if (parame != null) {
            break label291;
          }
          parame = null;
          label209:
          this.EFo = parame;
          parame = this.dyQ.dyK;
          if (parame != null) {
            break label305;
          }
          parame = (TabLayout.e)localObject2;
          label229:
          this.GRp = parame;
          parame = this.EFn;
          if (parame != null) {
            parame.setImageResource(e.g.icons_filled_little_like);
          }
        }
      }
      for (;;)
      {
        aY(i, false);
        AppMethodBeat.o(338072);
        return;
        parame = (TextView)parame.findViewById(e.e.tabTitle);
        break;
        label277:
        parame = (WeImageView)parame.findViewById(e.e.tabTitleImage);
        break label190;
        label291:
        parame = (ImageView)parame.findViewById(e.e.tabTitleImageRed);
        break label209;
        label305:
        parame = (ImageView)parame.findViewById(e.e.bigTabTitleImageRed);
        break label229;
        if ((this.hJx == 3) || (this.hJx == 4))
        {
          this.dyQ.jw(e.f.finder_home_ui_tab_text);
          parame = this.dyQ.dyK;
          if (parame == null)
          {
            parame = null;
            label360:
            this.titleTv = parame;
            parame = this.titleTv;
            if (parame != null) {
              parame.setTextSize(1, f);
            }
            parame = this.dyQ.dyK;
            if (parame != null) {
              break label540;
            }
            parame = null;
            label394:
            this.EFo = parame;
            parame = this.dyQ.dyK;
            if (parame != null) {
              break label554;
            }
            parame = null;
            label413:
            this.GRp = parame;
            parame = this.dyQ.dyK;
            if (parame != null) {
              break label568;
            }
            parame = null;
            label432:
            this.GRq = parame;
            parame = this.GRq;
            if (parame != null)
            {
              parame = (ImageView)parame.findViewById(e.e.tabTitleIconIv);
              if (parame != null)
              {
                int j = e.g.finder_icon_live_onlive;
                localObject2 = this.GRq;
                if (localObject2 != null) {
                  break label582;
                }
                paramInt = 0;
                label479:
                g.a(parame, j, paramInt);
              }
            }
            parame = this.dyQ.dyK;
            if (parame != null) {
              break label628;
            }
          }
          label540:
          label554:
          label568:
          label582:
          label628:
          for (parame = localObject1;; parame = (TextView)parame.findViewById(e.e.tabTitleTextRed))
          {
            this.GRt = parame;
            parame = this.GRt;
            if (parame == null) {
              break;
            }
            parame.setTextSize(1, 9.0F);
            break;
            parame = (TextView)parame.findViewById(e.e.tabTitle);
            break label360;
            parame = (ImageView)parame.findViewById(e.e.tabRed);
            break label394;
            parame = (ImageView)parame.findViewById(e.e.bigTabRed);
            break label413;
            parame = (ViewGroup)parame.findViewById(e.e.tabTitleIconRed);
            break label432;
            localObject2 = ((ViewGroup)localObject2).getContext();
            if (localObject2 == null)
            {
              paramInt = 0;
              break label479;
            }
            localObject2 = ((Context)localObject2).getResources();
            if (localObject2 == null)
            {
              paramInt = 0;
              break label479;
            }
            paramInt = ((Resources)localObject2).getColor(e.b.white);
            break label479;
          }
        }
        this.dyQ.jw(e.f.finder_home_ui_tab_empty);
      }
    }
    
    public final void aY(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(338086);
      Object localObject = this.titleTv;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(paramInt);
      }
      localObject = this.EFn;
      if (localObject != null) {
        ((WeImageView)localObject).setIconColor(paramInt);
      }
      if (!paramBoolean)
      {
        localObject = this.dyQ.dyL;
        if (localObject != null) {
          ((TabLayout)localObject).setSelectedTabIndicatorColor(paramInt);
        }
      }
      if (this.hJx == 1)
      {
        localObject = this.GRo;
        if (localObject != null) {
          ((TextView)localObject).setTextColor(paramInt);
        }
      }
      AppMethodBeat.o(338086);
    }
    
    public final void setTextBold(boolean paramBoolean)
    {
      AppMethodBeat.i(338102);
      TextView localTextView = this.titleTv;
      if (localTextView != null)
      {
        if (!paramBoolean) {
          break label73;
        }
        aw.a((Paint)localTextView.getPaint(), 0.8F);
      }
      while (this.hJx == 1)
      {
        localTextView = this.GRo;
        if (localTextView != null) {
          if (paramBoolean)
          {
            aw.a((Paint)localTextView.getPaint(), 0.8F);
            AppMethodBeat.o(338102);
            return;
            label73:
            localTextView.getPaint().setFakeBoldText(false);
            localTextView.getPaint().setStrokeWidth(0.0F);
          }
          else
          {
            localTextView.getPaint().setFakeBoldText(false);
            localTextView.getPaint().setStrokeWidth(0.0F);
          }
        }
      }
      AppMethodBeat.o(338102);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$buildTab$2", "Lcom/google/android/material/tabs/TabLayout$BaseOnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabReselected", "", "t", "onTabSelected", "onTabUnselected", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements TabLayout.b<TabLayout.e>
  {
    c(af paramaf) {}
    
    public final void i(TabLayout.e parame)
    {
      AppMethodBeat.i(338027);
      kotlin.g.b.s.u(parame, "t");
      Object localObject1 = parame.tag;
      Object localObject2;
      boolean bool;
      if ((localObject1 instanceof af.b))
      {
        ((af.b)localObject1).aY(this.GRu.getContext().getResources().getColor(e.b.hot_tab_selected_color), false);
        ((af.b)localObject1).setTextBold(true);
        parame = af.c(this.GRu).GKo;
        localObject2 = this.GRu;
        parame.ZJy = 0;
        parame.aafr = af.c((af)localObject2).GKq;
        if (((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("TLRecommendTab") == null) {
          break label262;
        }
        bool = true;
        parame.aafq = bool;
        if (((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("TLFollow") == null) {
          break label267;
        }
        bool = true;
        label136:
        parame.aafp = bool;
        if (((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("finder_tl_hot_tab") == null) {
          break label272;
        }
        bool = true;
        label162:
        parame.aafo = bool;
        if (((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("FinderEntrance") == null) {
          break label277;
        }
        bool = true;
        label188:
        parame.aafn = bool;
        parame = com.tencent.mm.ui.component.k.aeZF;
        ((FinderHomeUIC)com.tencent.mm.ui.component.k.d(this.GRu.getActivity()).q(FinderHomeUIC.class)).u(((af.b)localObject1).hJx, null);
        switch (((af.b)localObject1).hJx)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(338027);
        return;
        label262:
        bool = false;
        break;
        label267:
        bool = false;
        break label136;
        label272:
        bool = false;
        break label162;
        label277:
        bool = false;
        break label188;
        parame = ((af.b)localObject1).EFn;
        if (parame != null)
        {
          parame.setImageResource(e.g.icons_filled_location);
          AppMethodBeat.o(338027);
          return;
          parame = ((af.b)localObject1).EFn;
          if (parame != null) {
            parame.setImageResource(e.g.icons_filled_little_like);
          }
          localObject2 = ((af.b)localObject1).GRs;
          if (localObject2 != null)
          {
            parame = this.GRu;
            if (((ViewGroup)localObject2).getTag() != null)
            {
              af.d(parame);
              parame = as.GSQ;
              parame = ((ViewGroup)localObject2).getContext();
              kotlin.g.b.s.s(parame, "view.context");
              parame = as.a.hu(parame);
              if (parame == null) {}
              Object localObject3;
              for (parame = null;; parame = parame.fou())
              {
                localObject3 = bb.FuK;
                localObject3 = ((ViewGroup)localObject2).getTag();
                if (localObject3 != null) {
                  break;
                }
                parame = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.json.JSONObject");
                AppMethodBeat.o(338027);
                throw parame;
              }
              bb.a(parame, "friendtab_tl_reddot", true, (JSONObject)localObject3);
              parame = ((af.b)localObject1).GRr;
              if (parame != null) {
                parame.setVisibility(0);
              }
              ((ViewGroup)localObject2).setTag(null);
              parame = ((af.b)localObject1).GRs;
              if (parame != null) {
                parame.setVisibility(8);
              }
              parame = ((af.b)localObject1).EFo;
              if (parame != null) {
                parame.setVisibility(8);
              }
            }
          }
        }
      }
    }
    
    public final void j(TabLayout.e parame)
    {
      AppMethodBeat.i(338013);
      kotlin.g.b.s.u(parame, "t");
      parame = parame.tag;
      if ((parame instanceof af.b))
      {
        ((af.b)parame).aY(this.GRu.getContext().getResources().getColor(e.b.hot_tab_unselected_color), true);
        ((af.b)parame).setTextBold(false);
        switch (((af.b)parame).hJx)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(338013);
        return;
        parame = ((af.b)parame).EFn;
        if (parame != null)
        {
          parame.setImageResource(e.g.icons_outlined_location);
          AppMethodBeat.o(338013);
          return;
          parame = ((af.b)parame).EFn;
          if (parame != null) {
            parame.setImageResource(e.g.icons_outlined_little_like);
          }
        }
      }
    }
    
    public final void k(TabLayout.e parame)
    {
      AppMethodBeat.i(338004);
      kotlin.g.b.s.u(parame, "t");
      AppMethodBeat.o(338004);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$5$1", "Lcom/tencent/mm/ui/MagicWindowUtil$ISplitCallBack;", "exitSplit", "", "toSplit", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements ag.a
  {
    e(af paramaf) {}
    
    public final void fnV()
    {
      AppMethodBeat.i(337987);
      WeImageView localWeImageView = (WeImageView)this.GRu.findViewById(e.e.splitEntrance);
      if (localWeImageView != null) {
        localWeImageView.setImageResource(e.g.icons_outlined_merge);
      }
      AppMethodBeat.o(337987);
    }
    
    public final void fnW()
    {
      AppMethodBeat.i(337995);
      WeImageView localWeImageView = (WeImageView)this.GRu.findViewById(e.e.splitEntrance);
      if (localWeImageView != null) {
        localWeImageView.setImageResource(e.g.icons_outlined_sperated);
      }
      AppMethodBeat.o(337995);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$6", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements HardTouchableLayout.b
  {
    f(af paramaf) {}
    
    private static final void i(af paramaf)
    {
      AppMethodBeat.i(337992);
      kotlin.g.b.s.u(paramaf, "this$0");
      com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
      ((FinderHomeUIC)com.tencent.mm.ui.component.k.d(paramaf.getActivity()).q(FinderHomeUIC.class)).getActiveFragment().eEr();
      AppMethodBeat.o(337992);
    }
    
    public final void c(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(338006);
      kotlin.g.b.s.u(paramView, "view");
      kotlin.g.b.s.u(paramMotionEvent, "e");
      Log.i("Finder.HomeActionBarUIC", "onDoubleClick ...");
      com.tencent.threadpool.h.ahAA.bk(new af.f..ExternalSyntheticLambda0(this.GRu));
      AppMethodBeat.o(338006);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(float paramFloat, int paramInt, af paramaf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.viewmodel.d>
  {
    public static final h GRx;
    
    static
    {
      AppMethodBeat.i(338385);
      GRx = new h();
      AppMethodBeat.o(338385);
    }
    
    h()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.af
 * JD-Core Version:    0.7.0.1
 */