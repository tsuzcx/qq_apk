package com.tencent.mm.plugin.finder.viewmodel.component;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.b;
import com.google.android.material.tabs.TabLayout.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.e.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.ch;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.extension.reddot.h.a;
import com.tencent.mm.plugin.finder.extension.reddot.i.a;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.ui.FinderSelfUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.findersdk.a.ag;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.c;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.HardTouchableLayout.b;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "actionBarColor", "", "fromTabIndex", "fromTabType", "fullScreenIconColor", "isAllHomeTabEnableFullScreenEnjoy", "", "isCurrentResume", "isPreparing", "lastExposeFollowTipsId", "", "lastExposeFriendTipsId", "lastExposeLbsTipsId", "lastExposeMachineTipsId", "lastExposePersonalCenterTipsId", "selected", "selectedInHot", "toTabIndex", "toTabType", "unselected", "unselectedInHot", "buildTab", "", "checkFinderTeenMode", "checkNearbyLiveFriends", "checkPersonCenterRedDotReport", "action", "checkPostEntrance", "doClickPostAction", "doPrepareUser", "status", "fixActionBarStatus", "getFinderTab", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$FinderTab;", "tabType", "getPersonalCenterRect", "outRect", "Landroid/graphics/Rect;", "getRootView", "Landroid/view/View;", "getScrollMask", "handleTabColor", "isFromFullScreenTab", "isToFullScreenTab", "selectedInHot2UnSelected", "selected2UnselectedInHot", "selected2Unselected", "unselected2Selected", "unselected2SelectedInHot", "unselectedInHot2Selected", "unselected2UnSelectedInHot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDestroy", "onFragmentChange", "from", "to", "fromType", "toType", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onUserVisibleFragmentChange", "isUserVisibleFocused", "index", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "overlayStatusBar", "refreshActionBarColor", "registerRedDot", "resetScrollMask", "color", "setPersonalCenterUnreadDot", "count", "redDotCountView", "setTabIndex", "findByTag", "Lcom/google/android/material/tabs/TabLayout$Tab;", "Lcom/google/android/material/tabs/TabLayout;", "any", "", "Companion", "FinderTab", "plugin-finder_release"})
public final class aa
  extends UIComponent
  implements com.tencent.mm.an.i, com.tencent.mm.plugin.finder.view.i
{
  public static final a Blb;
  private final boolean BkL;
  private String BkM;
  private String BkN;
  private String BkO;
  private String BkP;
  private String BkQ;
  private boolean BkR;
  private final int BkS;
  private final int BkT;
  private final int BkU;
  private final int BkV;
  private final int BkW;
  private int BkX;
  private int BkY;
  private int BkZ;
  private int Bla;
  private final int selected;
  private boolean zCu;
  
  static
  {
    AppMethodBeat.i(273314);
    Blb = new a((byte)0);
    AppMethodBeat.o(273314);
  }
  
  public aa(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(273313);
    com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
    this.BkL = com.tencent.mm.plugin.finder.utils.aj.isAllHomeTabEnableFullScreenEnjoy();
    this.BkM = "";
    this.BkN = "";
    this.BkO = "";
    this.BkP = "";
    this.BkQ = "";
    this.BkS = paramAppCompatActivity.getResources().getColor(b.c.hot_tab_selected_color);
    this.BkT = paramAppCompatActivity.getResources().getColor(b.c.hot_tab_BW_100_Alpha_0_5);
    this.BkU = paramAppCompatActivity.getResources().getColor(b.c.hot_tab_unselected_color);
    this.selected = paramAppCompatActivity.getResources().getColor(b.c.black_color);
    this.BkV = paramAppCompatActivity.getResources().getColor(b.c.desc_text_color);
    this.BkW = paramAppCompatActivity.getResources().getColor(b.c.BW_93);
    this.BkX = -1;
    this.BkY = -1;
    this.BkZ = -1;
    this.Bla = -1;
    AppMethodBeat.o(273313);
  }
  
  private final void RO(int paramInt)
  {
    AppMethodBeat.i(273298);
    Object localObject = aj.Bnu;
    localObject = aj.a.fZ((Context)getActivity());
    if (localObject != null) {}
    for (localObject = ((aj)localObject).ekY();; localObject = null)
    {
      i.a locala = com.tencent.mm.plugin.finder.extension.reddot.i.xuG;
      this.BkM = i.a.a(paramInt, (bid)localObject, this.BkM);
      AppMethodBeat.o(273298);
      return;
    }
  }
  
  private final void RP(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(273306);
    Log.i("Finder.HomeActionBarUIC", "[doPrepareUser] isPreparing=" + this.BkR + " status=" + paramInt);
    Object localObject;
    if (!this.BkR)
    {
      this.BkR = true;
      localObject = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      bool1 = bool2;
      if (((PluginFinder)localObject).getRedDotManager().aBe("TLPostCamera") == null)
      {
        localObject = com.tencent.mm.kernel.h.ag(PluginFinder.class);
        p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
        if (((PluginFinder)localObject).getRedDotManager().aBe("TLCamera") == null) {
          break label161;
        }
      }
    }
    label161:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localObject = new ch(3);
      ((ch)localObject).xdV = bool1;
      com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)localObject);
      AppMethodBeat.o(273306);
      return;
    }
  }
  
  private final b RQ(int paramInt)
  {
    AppMethodBeat.i(273312);
    Object localObject1 = (TabLayout)findViewById(b.f.tabLayout);
    if (localObject1 != null)
    {
      localObject1 = c((TabLayout)localObject1, Integer.valueOf(paramInt));
      if (localObject1 == null) {}
    }
    for (localObject1 = ((TabLayout.e)localObject1).getTag();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (!(localObject1 instanceof b)) {
        localObject2 = null;
      }
      localObject1 = (b)localObject2;
      AppMethodBeat.o(273312);
      return localObject1;
    }
  }
  
  private static TabLayout.e c(TabLayout paramTabLayout, Object paramObject)
  {
    AppMethodBeat.i(273304);
    int j = paramTabLayout.getTabCount();
    int i = 0;
    if (i < j)
    {
      TabLayout.e locale = paramTabLayout.gd(i);
      Object localObject;
      if (locale != null) {
        localObject = locale.getTag();
      }
      int k;
      while ((localObject instanceof b))
      {
        localObject = locale.getTag();
        if (localObject == null)
        {
          paramTabLayout = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeActionBarUIC.FinderTab");
          AppMethodBeat.o(273304);
          throw paramTabLayout;
          localObject = null;
        }
        else
        {
          k = ((b)localObject).fEH;
          if ((paramObject instanceof Integer)) {
            break label106;
          }
        }
      }
      label106:
      while (k != ((Integer)paramObject).intValue())
      {
        i += 1;
        break;
      }
      AppMethodBeat.o(273304);
      return locale;
    }
    AppMethodBeat.o(273304);
    return null;
  }
  
  private final void ekJ()
  {
    AppMethodBeat.i(273300);
    TabLayout localTabLayout = (TabLayout)findViewById(b.f.tabLayout);
    if (localTabLayout == null)
    {
      AppMethodBeat.o(273300);
      return;
    }
    Object localObject1 = com.tencent.mm.ui.component.g.Xox;
    localObject1 = ((Iterable)((FinderHomeUIC)com.tencent.mm.ui.component.g.b(getActivity()).i(FinderHomeUIC.class)).fragments).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        kotlin.a.j.iBO();
      }
      localObject2 = (FinderHomeTabFragment)localObject2;
      Object localObject3 = localTabLayout.xz();
      p.j(localObject3, "tabLayout.newTab()");
      localObject3 = new b((TabLayout.e)localObject3, ((FinderHomeTabFragment)localObject2).fEH);
      int j = ((FinderHomeTabFragment)localObject2).title;
      TextView localTextView = ((b)localObject3).titleTv;
      if (localTextView != null)
      {
        Object localObject4 = d.AjH;
        int k = ((b)localObject3).fEH;
        localObject4 = ((b)localObject3).bFQ.getCustomView();
        if (localObject4 == null) {
          p.iCn();
        }
        p.j(localObject4, "tab.customView!!");
        localObject4 = ((View)localObject4).getContext();
        p.j(localObject4, "tab.customView!!.context");
        localObject4 = ((Context)localObject4).getResources().getString(j);
        p.j(localObject4, "tab.customView!!.context.resources.getString(id)");
        localTextView.setText((CharSequence)d.bb(k, (String)localObject4));
      }
      localTextView = ((b)localObject3).Blh;
      if (localTextView != null) {
        localTextView.setTextSize(1, 10.0F);
      }
      ((b)localObject3).index = i;
      if (((FinderHomeTabFragment)localObject2).fEH == 4) {
        ((b)localObject3).Blh = ((TextView)getActivity().findViewById(b.f.outerTabTitleRedDotNew));
      }
      localTabLayout.a(((b)localObject3).bFQ, false);
      i += 1;
    }
    localTabLayout.a((TabLayout.b)new c(this));
    AppMethodBeat.o(273300);
  }
  
  public final void H(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool2 = true;
    AppMethodBeat.i(273309);
    this.BkZ = paramInt2;
    this.Bla = paramInt1;
    this.BkX = paramInt4;
    this.BkY = paramInt3;
    Object localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
    localObject = getActivity().getWindow();
    p.j(localObject, "activity.window");
    if (!ar.isDarkMode()) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      com.tencent.mm.plugin.finder.utils.aj.b((Window)localObject, bool1);
      localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (com.tencent.mm.plugin.finder.utils.aj.isAnyHomeTabEnableFullScreenEnjoy()) {
        break;
      }
      AppMethodBeat.o(273309);
      return;
    }
    localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
    boolean bool3 = com.tencent.mm.plugin.finder.utils.aj.Rm(this.BkX);
    localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
    boolean bool4 = com.tencent.mm.plugin.finder.utils.aj.Rm(this.BkY);
    if (!bool3)
    {
      localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
      localObject = getActivity().getWindow();
      p.j(localObject, "activity.window");
      if (!ar.isDarkMode()) {}
      for (bool1 = bool2;; bool1 = false)
      {
        com.tencent.mm.plugin.finder.utils.aj.b((Window)localObject, bool1);
        localObject = getActivity();
        if (localObject != null) {
          break;
        }
        localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(273309);
        throw ((Throwable)localObject);
      }
      ((MMActivity)localObject).setNavigationbarColor(getActivity().getResources().getColor(b.c.white));
      localObject = getActivity().findViewById(b.f.finderHomeActionbar);
      if (localObject != null) {
        ((View)localObject).setBackgroundColor(this.BkW);
      }
    }
    while ((paramInt1 != -1) && (bool3) && (bool4))
    {
      localObject = RQ(this.BkX);
      TextView localTextView;
      if (localObject != null)
      {
        localTextView = ((b)localObject).titleTv;
        if (localTextView != null) {
          localTextView.setTextColor(this.BkS);
        }
        localObject = ((b)localObject).zCw;
        if (localObject != null) {
          ((WeImageView)localObject).setIconColor(this.BkS);
        }
      }
      localObject = RQ(this.BkY);
      if (localObject != null)
      {
        localTextView = ((b)localObject).titleTv;
        if (localTextView != null) {
          localTextView.setTextColor(this.BkU);
        }
        localObject = ((b)localObject).zCw;
        if (localObject != null)
        {
          ((WeImageView)localObject).setIconColor(this.BkU);
          AppMethodBeat.o(273309);
          return;
          localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
          localObject = getActivity().getWindow();
          p.j(localObject, "activity.window");
          com.tencent.mm.plugin.finder.utils.aj.b((Window)localObject, false);
          localObject = getActivity();
          if (localObject == null)
          {
            localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(273309);
            throw ((Throwable)localObject);
          }
          ((MMActivity)localObject).setNavigationbarColor(getActivity().getResources().getColor(b.c.black));
          localObject = findViewById(b.f.finderHomeActionbar);
          if (localObject != null) {
            ((View)localObject).setBackground(null);
          }
        }
        else
        {
          AppMethodBeat.o(273309);
          return;
        }
      }
    }
    AppMethodBeat.o(273309);
  }
  
  public final void Ok(int paramInt)
  {
    AppMethodBeat.i(273299);
    Object localObject = (TabLayout)findViewById(b.f.tabLayout);
    if (localObject != null)
    {
      localObject = ((TabLayout)localObject).gd(paramInt);
      if (localObject != null)
      {
        p.j(localObject, "this");
        if (!((TabLayout.e)localObject).isSelected()) {
          ((TabLayout.e)localObject).xI();
        }
        AppMethodBeat.o(273299);
        return;
      }
    }
    AppMethodBeat.o(273299);
  }
  
  public final void a(boolean paramBoolean, int paramInt, FinderHomeTabFragment paramFinderHomeTabFragment)
  {
    AppMethodBeat.i(273308);
    p.k(paramFinderHomeTabFragment, "fragment");
    AppMethodBeat.o(273308);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(273296);
    paramBundle = getActivity().getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    paramBundle = getActivity().getWindow();
    p.j(paramBundle, "activity.window");
    paramBundle = paramBundle.getDecorView();
    p.j(paramBundle, "activity.window.decorView");
    paramBundle.setSystemUiVisibility(paramBundle.getSystemUiVisibility() | 0x400 | 0x100);
    paramBundle = getActivity().getWindow();
    p.j(paramBundle, "activity.window");
    paramBundle.setStatusBarColor(0);
    c.f((Activity)getActivity(), false);
    paramBundle = getActivity().getSupportActionBar();
    if (paramBundle != null)
    {
      paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      paramBundle.hide();
    }
    int i = ax.getStatusBarHeight((Context)getActivity());
    paramBundle = findViewById(b.f.finderHomeActionbar);
    if (paramBundle != null)
    {
      ViewGroup.LayoutParams localLayoutParams = paramBundle.getLayoutParams();
      localLayoutParams.height += i;
      paramBundle.setLayoutParams(localLayoutParams);
      paramBundle.setPadding(0, i, 0, 0);
    }
    com.tencent.mm.kernel.h.aGY().a(3761, (com.tencent.mm.an.i)this);
    paramBundle = findViewById(b.f.backBtn);
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new j(this));
    }
    paramBundle = findViewById(b.f.lbsEntranceLayout);
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new k(this));
    }
    paramBundle = findViewById(b.f.postEntranceLayout);
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new l(this));
    }
    paramBundle = findViewById(b.f.searchEntranceLayout);
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new m(this));
    }
    paramBundle = (HardTouchableLayout)findViewById(b.f.tabLayoutContainer);
    if (paramBundle != null) {
      paramBundle.setOnDoubleClickListener((HardTouchableLayout.b)new n(this));
    }
    paramBundle = findViewById(b.f.personalCenter);
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new o(this));
    }
    ekJ();
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
    com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.dqR(), (androidx.lifecycle.l)getActivity(), (androidx.lifecycle.s)new s(this));
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
    com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.dqU(), (androidx.lifecycle.l)getActivity(), (androidx.lifecycle.s)new t(this));
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
    com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.dqV(), (androidx.lifecycle.l)getActivity(), (androidx.lifecycle.s)new u(this));
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
    com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.dqX(), (androidx.lifecycle.l)getActivity(), (androidx.lifecycle.s)new v(this));
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
    com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.dqY(), (androidx.lifecycle.l)getActivity(), (androidx.lifecycle.s)new w(this));
    RO(1);
    paramBundle = findViewById(b.f.searchEntranceLayout);
    if (paramBundle != null) {
      paramBundle.setVisibility(0);
    }
    paramBundle = findViewById(b.f.lbsEntranceLayout);
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = findViewById(b.f.postEntranceLayout);
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = com.tencent.mm.kernel.h.ag(ak.class);
    p.j(paramBundle, "MMKernel.plugin(IPluginFinder::class.java)");
    paramBundle = ((ak)paramBundle).getFinderUtilApi();
    p.j(paramBundle, "MMKernel.plugin(IPluginF…class.java).finderUtilApi");
    if (paramBundle.eeI())
    {
      paramBundle = findViewById(b.f.searchEntranceLayout);
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = findViewById(b.f.lbsEntranceLayout);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = findViewById(b.f.postEntranceLayout);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
    paramBundle = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.findersdk.a.ae.class);
    p.j(paramBundle, "MMKernel.service(IFinder…enModeConfig::class.java)");
    if (((com.tencent.mm.plugin.findersdk.a.ae)paramBundle).dYT())
    {
      paramBundle = findViewById(b.f.lbsEntranceLayout);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = findViewById(b.f.postEntranceLayout);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = findViewById(b.f.searchEntranceLayout);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = findViewById(b.f.tabLayoutContainer);
      if (paramBundle != null) {
        paramBundle.post((Runnable)new d(this));
      }
    }
    if (this.BkL)
    {
      paramBundle = (WeImageView)getActivity().findViewById(b.f.backBtnIv);
      if (paramBundle != null) {
        paramBundle.setIconColor(this.BkT);
      }
      paramBundle = (WeImageView)getActivity().findViewById(b.f.searchEntrance);
      if (paramBundle != null) {
        paramBundle.setIconColor(this.BkT);
      }
      paramBundle = (WeImageView)getActivity().findViewById(b.f.postEntrance);
      if (paramBundle != null) {
        paramBundle.setIconColor(this.BkT);
      }
      paramBundle = (WeImageView)getActivity().findViewById(b.f.personalCenter);
      if (paramBundle != null) {
        paramBundle.setIconColor(this.BkT);
      }
      paramBundle = (WeImageView)getActivity().findViewById(b.f.lbsEntrance);
      if (paramBundle != null) {
        paramBundle.setIconColor(this.BkT);
      }
      paramBundle = getActivity().findViewById(b.f.finderHomeActionbar);
      if (paramBundle != null) {
        paramBundle.setBackground(null);
      }
    }
    if (this.BkL)
    {
      paramBundle = getActivity().findViewById(b.f.viewPager);
      if (paramBundle != null)
      {
        paramBundle.post((Runnable)new p(this));
        AppMethodBeat.o(273296);
        return;
      }
    }
    AppMethodBeat.o(273296);
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(273295);
    super.onCreateBefore(paramBundle);
    paramBundle = com.tencent.mm.ui.component.g.Xox;
    ((FinderHomeUIC)com.tencent.mm.ui.component.g.b(getActivity()).i(FinderHomeUIC.class)).Bls.add(this);
    AppMethodBeat.o(273295);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(273297);
    super.onDestroy();
    com.tencent.mm.kernel.h.aGY().b(3761, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(273297);
  }
  
  public final void onPageScrollStateChanged(int paramInt) {}
  
  public final void onPageScrolled(final int paramInt1, final float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(273310);
    Object localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
    if (!com.tencent.mm.plugin.finder.utils.aj.isAnyHomeTabEnableFullScreenEnjoy())
    {
      AppMethodBeat.o(273310);
      return;
    }
    localObject = (kotlin.g.a.a)new r(this, paramFloat, paramInt1);
    TabLayout localTabLayout = (TabLayout)findViewById(b.f.tabLayout);
    if (localTabLayout != null) {
      paramInt1 = localTabLayout.getHeight();
    }
    while (paramInt1 <= 0)
    {
      localTabLayout = (TabLayout)findViewById(b.f.tabLayout);
      if (localTabLayout != null)
      {
        localTabLayout.post((Runnable)new q((kotlin.g.a.a)localObject));
        AppMethodBeat.o(273310);
        return;
        paramInt1 = 0;
      }
      else
      {
        AppMethodBeat.o(273310);
        return;
      }
    }
    ((kotlin.g.a.a)localObject).invoke();
    AppMethodBeat.o(273310);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(273302);
    super.onPause();
    this.zCu = false;
    AppMethodBeat.o(273302);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(273301);
    super.onResume();
    this.zCu = true;
    Object localObject = d.AjH;
    int i = ((Number)d.dVg().aSr()).intValue();
    if (i == 2)
    {
      localObject = z.bdh();
      p.j(localObject, "ConfigStorageLogic.getMyFinderUsername()");
      if (((CharSequence)localObject).length() > 0)
      {
        i = 1;
        localObject = com.tencent.mm.plugin.report.service.h.IzE;
        if (i == 0) {
          break label116;
        }
      }
      label116:
      for (i = 1;; i = 2)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject).a(20971, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(1) });
        AppMethodBeat.o(273301);
        return;
        i = 0;
        break;
      }
    }
    if (i == 1)
    {
      localObject = k.zWs;
      k.R(true, 1);
    }
    AppMethodBeat.o(273301);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(273307);
    p.k(paramq, "scene");
    if (paramq.getType() == 3761) {
      this.BkR = false;
    }
    AppMethodBeat.o(273307);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$Companion;", "", "()V", "SHEET_MENU_POST", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$FinderTab;", "", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tabType", "", "(Lcom/google/android/material/tabs/TabLayout$Tab;I)V", "bigTabRedIv", "Landroid/widget/ImageView;", "getBigTabRedIv", "()Landroid/widget/ImageView;", "setBigTabRedIv", "(Landroid/widget/ImageView;)V", "changeMargin", "index", "getIndex", "()I", "setIndex", "(I)V", "isAdjust", "", "()Z", "setAdjust", "(Z)V", "newTabRedDotSafeGap", "outerNewRedTv", "Landroid/widget/TextView;", "getOuterNewRedTv", "()Landroid/widget/TextView;", "setOuterNewRedTv", "(Landroid/widget/TextView;)V", "getTab", "()Lcom/google/android/material/tabs/TabLayout$Tab;", "setTab", "(Lcom/google/android/material/tabs/TabLayout$Tab;)V", "tabRedIcon", "Landroid/view/ViewGroup;", "getTabRedIcon", "()Landroid/view/ViewGroup;", "setTabRedIcon", "(Landroid/view/ViewGroup;)V", "tabRedIv", "getTabRedIv", "setTabRedIv", "tabRedTv", "getTabRedTv", "setTabRedTv", "getTabType", "setTabType", "titleIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getTitleIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setTitleIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "titleTv", "getTitleTv", "setTitleTv", "dismissNewRedDot", "", "isNeedExpand", "setTextBold", "isBold", "setTextColor", "id", "isUnSelected", "setTitle", "showNewRedDot", "plugin-finder_release"})
  public static final class b
  {
    final int Blc;
    final int Bld;
    ImageView Ble;
    ViewGroup Blf;
    TextView Blg;
    TextView Blh;
    boolean Bli;
    TabLayout.e bFQ;
    int fEH;
    int index;
    TextView titleTv;
    WeImageView zCw;
    ImageView zCx;
    
    @SuppressLint({"ResourceType"})
    public b(TabLayout.e parame, int paramInt)
    {
      AppMethodBeat.i(281117);
      this.bFQ = parame;
      this.fEH = paramInt;
      parame = MMApplicationContext.getContext();
      p.j(parame, "MMApplicationContext.getContext()");
      this.Blc = ((int)parame.getResources().getDimension(b.d.Edge_3A));
      parame = MMApplicationContext.getContext();
      p.j(parame, "MMApplicationContext.getContext()");
      this.Bld = ((int)parame.getResources().getDimension(b.d.Edge_2_5_A));
      this.bFQ.ac(this);
      parame = com.tencent.mm.plugin.finder.utils.aj.AGc;
      boolean bool = com.tencent.mm.plugin.finder.utils.aj.isAllHomeTabEnableFullScreenEnjoy();
      parame = MMApplicationContext.getContext();
      p.j(parame, "MMApplicationContext.getContext()");
      parame = parame.getResources();
      int i;
      if (bool)
      {
        paramInt = b.c.hot_tab_unselected_color;
        i = parame.getColor(paramInt);
        if (this.fEH != 1) {
          break label347;
        }
        this.bFQ.gk(b.g.finder_home_ui_tab_text_image);
        parame = this.bFQ.getCustomView();
        if (parame == null) {
          break label327;
        }
        parame = (TextView)parame.findViewById(b.f.tabTitle);
        label165:
        this.titleTv = parame;
        parame = this.titleTv;
        if (parame != null) {
          parame.setTextSize(1, 15.0F);
        }
        parame = this.bFQ.getCustomView();
        if (parame == null) {
          break label332;
        }
        parame = (WeImageView)parame.findViewById(b.f.tabTitleImage);
        label209:
        this.zCw = parame;
        parame = this.bFQ.getCustomView();
        if (parame == null) {
          break label337;
        }
        parame = (ImageView)parame.findViewById(b.f.tabTitleImageRed);
        label237:
        this.zCx = parame;
        parame = this.bFQ.getCustomView();
        if (parame == null) {
          break label342;
        }
        parame = (ImageView)parame.findViewById(b.f.bigTabTitleImageRed);
        label265:
        this.Ble = parame;
        parame = this.zCw;
        if (parame != null) {
          parame.setImageResource(b.i.icons_filled_little_like);
        }
      }
      label397:
      label441:
      label575:
      for (;;)
      {
        parame = this.zCw;
        if (parame != null) {
          parame.setIconColor(i);
        }
        parame = this.titleTv;
        if (parame == null) {
          break label674;
        }
        parame.setTextColor(i);
        AppMethodBeat.o(281117);
        return;
        paramInt = b.c.desc_text_color;
        break;
        label327:
        parame = null;
        break label165;
        label332:
        parame = null;
        break label209;
        label337:
        parame = null;
        break label237;
        label342:
        parame = null;
        break label265;
        label347:
        if ((this.fEH == 3) || (this.fEH == 4))
        {
          this.bFQ.gk(b.g.finder_home_ui_tab_text);
          parame = this.bFQ.getCustomView();
          if (parame != null)
          {
            parame = (TextView)parame.findViewById(b.f.tabTitle);
            this.titleTv = parame;
            parame = this.titleTv;
            if (parame != null) {
              parame.setTextSize(1, 15.0F);
            }
            parame = this.bFQ.getCustomView();
            if (parame == null) {
              break label635;
            }
            parame = (ImageView)parame.findViewById(b.f.tabRed);
            this.zCx = parame;
            parame = this.bFQ.getCustomView();
            if (parame == null) {
              break label640;
            }
            parame = (ImageView)parame.findViewById(b.f.bigTabRed);
            this.Ble = parame;
            parame = this.bFQ.getCustomView();
            if (parame == null) {
              break label645;
            }
            parame = (ViewGroup)parame.findViewById(b.f.tabTitleIconRed);
            label497:
            this.Blf = parame;
            parame = this.Blf;
            if (parame != null)
            {
              parame = (ImageView)parame.findViewById(b.f.tabTitleIconIv);
              if (parame != null)
              {
                int j = b.i.finder_icon_live_onlive;
                Object localObject = this.Blf;
                if (localObject == null) {
                  break label650;
                }
                localObject = ((ViewGroup)localObject).getContext();
                if (localObject == null) {
                  break label650;
                }
                localObject = ((Context)localObject).getResources();
                if (localObject == null) {
                  break label650;
                }
                paramInt = ((Resources)localObject).getColor(b.c.white);
                e.a(parame, j, paramInt);
              }
            }
            parame = this.bFQ.getCustomView();
            if (parame == null) {
              break label655;
            }
          }
          for (parame = (TextView)parame.findViewById(b.f.tabTitleTextRed);; parame = null)
          {
            this.Blg = parame;
            parame = this.Blg;
            if (parame == null) {
              break;
            }
            parame.setTextSize(1, 9.0F);
            break;
            parame = null;
            break label397;
            label635:
            parame = null;
            break label441;
            parame = null;
            break label469;
            parame = null;
            break label497;
            paramInt = 0;
            break label575;
          }
        }
        label469:
        this.bFQ.gk(b.g.finder_home_ui_tab_empty);
      }
      label640:
      label645:
      label650:
      label655:
      label674:
      AppMethodBeat.o(281117);
    }
    
    public final void az(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(281113);
      Object localObject = this.bFQ.getCustomView();
      if (localObject == null) {
        p.iCn();
      }
      p.j(localObject, "tab.customView!!");
      localObject = ((View)localObject).getContext();
      p.j(localObject, "tab.customView!!.context");
      paramInt = ((Context)localObject).getResources().getColor(paramInt);
      localObject = this.titleTv;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(paramInt);
      }
      localObject = this.zCw;
      if (localObject != null) {
        ((WeImageView)localObject).setIconColor(paramInt);
      }
      if (!paramBoolean) {
        this.bFQ.bFL.setSelectedTabIndicatorColor(paramInt);
      }
      AppMethodBeat.o(281113);
    }
    
    public final void ekK()
    {
      AppMethodBeat.i(281115);
      Log.i("Finder.HomeActionBarUIC", "dismissNewRedDot :" + this.fEH);
      TextView localTextView = this.Blh;
      if (localTextView != null)
      {
        localTextView.setVisibility(4);
        AppMethodBeat.o(281115);
        return;
      }
      AppMethodBeat.o(281115);
    }
    
    public final void setTextBold(boolean paramBoolean)
    {
      AppMethodBeat.i(281114);
      Object localObject = this.titleTv;
      if (localObject != null)
      {
        if (paramBoolean)
        {
          ar.a((Paint)((TextView)localObject).getPaint(), 0.8F);
          AppMethodBeat.o(281114);
          return;
        }
        TextPaint localTextPaint = ((TextView)localObject).getPaint();
        p.j(localTextPaint, "it.paint");
        localTextPaint.setFakeBoldText(false);
        localObject = ((TextView)localObject).getPaint();
        p.j(localObject, "it.paint");
        ((TextPaint)localObject).setStrokeWidth(0.0F);
        AppMethodBeat.o(281114);
        return;
      }
      AppMethodBeat.o(281114);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$FinderTab$showNewRedDot$1$1"})
    static final class a
      implements Runnable
    {
      a(TextView paramTextView, aa.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(243204);
        Object localObject = this.Blk;
        TextView localTextView = ((aa.b)localObject).Blh;
        ViewParent localViewParent;
        if (localTextView != null)
        {
          if (!(localTextView.getParent() instanceof ViewGroup)) {
            break label260;
          }
          localViewParent = localTextView.getParent();
          if (localViewParent == null)
          {
            localObject = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(243204);
            throw ((Throwable)localObject);
          }
        }
        label260:
        for (int i = ((ViewGroup)localViewParent).getWidth();; i = 0)
        {
          Log.i("Finder.HomeActionBarUIC", "isNeedShrink gap: " + (i - localTextView.getRight()) + "  newTabRedDotSafeGap: " + ((aa.b)localObject).Blc);
          if ((i != 0) && (i - localTextView.getRight() > ((aa.b)localObject).Blc)) {
            i = 1;
          }
          while (i != 0)
          {
            localObject = this.Blj.getLayoutParams();
            if (localObject == null)
            {
              localObject = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
              AppMethodBeat.o(243204);
              throw ((Throwable)localObject);
              i = 0;
              continue;
              i = 0;
            }
            else
            {
              localObject = (RelativeLayout.LayoutParams)localObject;
              Log.i("Finder.HomeActionBarUIC", "showNewRedDot isNeedShrink : " + ((RelativeLayout.LayoutParams)localObject).getMarginStart());
              ((RelativeLayout.LayoutParams)localObject).setMarginStart(((RelativeLayout.LayoutParams)localObject).getMarginStart() + this.Blk.Bld);
              Log.i("Finder.HomeActionBarUIC", "showNewRedDot isNeedShrink after: " + ((RelativeLayout.LayoutParams)localObject).getMarginStart());
              this.Blj.setLayoutParams((ViewGroup.LayoutParams)localObject);
            }
          }
          this.Blj.setVisibility(0);
          AppMethodBeat.o(243204);
          return;
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$buildTab$2", "Lcom/google/android/material/tabs/TabLayout$BaseOnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabReselected", "", "t", "onTabSelected", "onTabUnselected", "plugin-finder_release"})
  public static final class c
    implements TabLayout.b<TabLayout.e>
  {
    @SuppressLint({"ResourceType"})
    public final void i(TabLayout.e parame)
    {
      AppMethodBeat.i(286386);
      p.k(parame, "t");
      parame = parame.getTag();
      Object localObject;
      if ((parame instanceof aa.b))
      {
        if (!aa.b(this.Bll)) {
          break label122;
        }
        ((aa.b)parame).az(b.c.hot_tab_selected_color, false);
        ((aa.b)parame).setTextBold(true);
        localObject = com.tencent.mm.ui.component.g.Xox;
        ((FinderHomeUIC)com.tencent.mm.ui.component.g.b(this.Bll.getActivity()).i(FinderHomeUIC.class)).r(((aa.b)parame).fEH, null);
        switch (((aa.b)parame).fEH)
        {
        }
      }
      label122:
      do
      {
        AppMethodBeat.o(286386);
        return;
        localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (com.tencent.mm.plugin.finder.utils.aj.Rm(((aa.b)parame).fEH))
        {
          ((aa.b)parame).az(b.c.hot_tab_selected_color, false);
          break;
        }
        ((aa.b)parame).az(b.c.normal_text_color, false);
        break;
        parame = ((aa.b)parame).zCw;
        if (parame != null)
        {
          parame.setImageResource(b.i.icons_filled_location);
          AppMethodBeat.o(286386);
          return;
        }
        AppMethodBeat.o(286386);
        return;
        parame = ((aa.b)parame).zCw;
      } while (parame == null);
      parame.setImageResource(b.i.icons_filled_little_like);
      AppMethodBeat.o(286386);
    }
    
    @SuppressLint({"ResourceType"})
    public final void j(TabLayout.e parame)
    {
      AppMethodBeat.i(286385);
      p.k(parame, "t");
      parame = parame.getTag();
      if ((parame instanceof aa.b))
      {
        if (!aa.b(this.Bll)) {
          break label86;
        }
        ((aa.b)parame).az(b.c.hot_tab_unselected_color, true);
        ((aa.b)parame).setTextBold(false);
        switch (((aa.b)parame).fEH)
        {
        }
      }
      label86:
      do
      {
        AppMethodBeat.o(286385);
        return;
        ((aa.b)parame).az(b.c.desc_text_color, true);
        break;
        parame = ((aa.b)parame).zCw;
        if (parame != null)
        {
          parame.setImageResource(b.i.icons_outlined_location);
          AppMethodBeat.o(286385);
          return;
        }
        AppMethodBeat.o(286385);
        return;
        parame = ((aa.b)parame).zCw;
      } while (parame == null);
      parame.setImageResource(b.i.icons_outlined_little_like);
      AppMethodBeat.o(286385);
    }
    
    @SuppressLint({"ResourceType"})
    public final void k(TabLayout.e parame)
    {
      AppMethodBeat.i(286384);
      p.k(parame, "t");
      AppMethodBeat.o(286384);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(aa paramaa) {}
    
    public final void run()
    {
      AppMethodBeat.i(221264);
      Object localObject1 = this.Bll.findViewById(b.f.tabLayoutContainer);
      if (localObject1 != null)
      {
        Object localObject2 = ((View)localObject1).getLayoutParams();
        if (localObject2 == null)
        {
          localObject1 = new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(221264);
          throw ((Throwable)localObject1);
        }
        localObject2 = (LinearLayout.LayoutParams)localObject2;
        ((LinearLayout.LayoutParams)localObject2).leftMargin = 0;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        AppMethodBeat.o(221264);
        return;
      }
      AppMethodBeat.o(221264);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class e
    implements q.f
  {
    public static final e Blm;
    
    static
    {
      AppMethodBeat.i(272031);
      Blm = new e();
      AppMethodBeat.o(272031);
    }
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(272029);
      p.j(paramo, "it");
      if (paramo.hJO()) {
        paramo.mn(1, b.j.finder_post);
      }
      AppMethodBeat.o(272029);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class f
    implements q.g
  {
    f(aa paramaa) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(290934);
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("key_create_scene", 1);
      com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.w((Context)this.Bll.getActivity(), paramMenuItem);
      AppMethodBeat.o(290934);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class g
    implements q.f
  {
    public static final g Bln;
    
    static
    {
      AppMethodBeat.i(276586);
      Bln = new g();
      AppMethodBeat.o(276586);
    }
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(276584);
      p.j(paramo, "it");
      if (paramo.hJO())
      {
        paramo.mn(1001, b.j.app_field_mmsight);
        paramo.mn(1002, b.j.app_field_select_new_pic);
      }
      AppMethodBeat.o(276584);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class h
    implements q.g
  {
    h(String paramString, AppCompatActivity paramAppCompatActivity) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(272476);
      Intent localIntent = new Intent();
      p.j(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == 1001) {
        localIntent.putExtra("key_finder_post_router", 2);
      }
      for (;;)
      {
        localIntent.putExtra("key_finder_post_from", 5);
        localIntent.putExtra("key_finder_post_id", this.xNP);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)this.zQu, localIntent);
        AppMethodBeat.o(272476);
        return;
        if (paramMenuItem.getItemId() == 1002) {
          localIntent.putExtra("key_finder_post_router", 3);
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss"})
  static final class i
    implements e.b
  {
    public static final i Blo;
    
    static
    {
      AppMethodBeat.i(287656);
      Blo = new i();
      AppMethodBeat.o(287656);
    }
    
    public final void onDismiss()
    {
      AppMethodBeat.i(287655);
      k localk = k.zWs;
      k.Pw(6);
      AppMethodBeat.o(287655);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(aa paramaa) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(281572);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.Bll.getActivity().onBackPressed();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(281572);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(aa paramaa) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(279690);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = com.tencent.mm.plugin.finder.report.j.zVy;
      com.tencent.mm.plugin.finder.report.j.dPt();
      paramView = new Intent();
      localObject = aj.Bnu;
      aj.a.a((Context)this.Bll.getActivity(), paramView, 0L, 0, true, 60);
      localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
      localObject = this.Bll.getActivity();
      if (localObject == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(279690);
        throw paramView;
      }
      com.tencent.mm.plugin.finder.utils.a.b((MMActivity)localObject, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(279690);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(aa paramaa) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(274560);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      aa.a(this.Bll);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(274560);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(aa paramaa) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(270919);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = new Intent();
      localObject = aj.Bnu;
      aj.a.a((Context)this.Bll.getActivity(), paramView, 0L, 0, false, 124);
      localObject = d.AjH;
      if (((Number)d.dWR().aSr()).intValue() == 1)
      {
        localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.C((Context)this.Bll.getActivity(), paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(270919);
        return;
      }
      localObject = z.bdh();
      p.j(localObject, "ConfigStorageLogic.getMyFinderUsername()");
      if (((CharSequence)localObject).length() > 0)
      {
        i = 1;
        label145:
        localObject = com.tencent.mm.plugin.report.service.h.IzE;
        if (i == 0) {
          break label213;
        }
      }
      label213:
      for (int i = 1;; i = 2)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject).a(20971, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Integer.valueOf(1) });
        localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.B((Context)this.Bll.getActivity(), paramView);
        break;
        i = 0;
        break label145;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$5", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class n
    implements HardTouchableLayout.b
  {
    public final void a(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(288573);
      p.k(paramView, "view");
      p.k(paramMotionEvent, "e");
      Log.i("Finder.HomeActionBarUIC", "onDoubleClick ...");
      com.tencent.e.h.ZvG.bc((Runnable)new a(this));
      AppMethodBeat.o(288573);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(aa.n paramn) {}
      
      public final void run()
      {
        AppMethodBeat.i(290448);
        com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
        ((FinderHomeUIC)com.tencent.mm.ui.component.g.b(this.Blp.Bll.getActivity()).i(FinderHomeUIC.class)).getActiveFragment().dLu();
        AppMethodBeat.o(290448);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    o(aa paramaa) {}
    
    public final void onClick(View paramView)
    {
      Object localObject1 = null;
      AppMethodBeat.i(238537);
      Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aFi());
      paramView = aj.Bnu;
      paramView = aj.a.fZ((Context)this.Bll.getActivity());
      if (paramView != null)
      {
        paramView = aj.c(paramView);
        if ((paramView instanceof com.tencent.mm.plugin.finder.report.s))
        {
          paramView = (com.tencent.mm.plugin.finder.report.s)paramView;
          localObject2 = com.tencent.mm.plugin.finder.report.g.zUU;
          paramView.aEe(com.tencent.mm.plugin.finder.report.g.a.aa(kotlin.a.ae.d(kotlin.s.M("feedActionType", Integer.valueOf(3)))));
        }
        aa.a(this.Bll, 2);
        localObject2 = new Intent();
        paramView = com.tencent.mm.kernel.h.ag(PluginFinder.class);
        p.j(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        com.tencent.mm.plugin.finder.extension.reddot.l locall = ((PluginFinder)paramView).getRedDotManager().aBf("TLPersonalCenter");
        paramView = localObject1;
        if (locall != null) {
          paramView = locall.aBy("TLPersonalCenter");
        }
        if (paramView == null) {
          break label246;
        }
      }
      label246:
      for (boolean bool = true;; bool = false)
      {
        paramView = FinderSelfUI.Avb;
        ((Intent)localObject2).putExtra(FinderSelfUI.eaU(), bool);
        paramView = aj.Bnu;
        aj.a.a((Context)this.Bll.getActivity(), (Intent)localObject2, 0L, 0, false, 124);
        paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.enterFinderSelfUI((Context)this.Bll.getActivity(), (Intent)localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(238537);
        return;
        paramView = null;
        break;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class p
    implements Runnable
  {
    p(aa paramaa) {}
    
    public final void run()
    {
      AppMethodBeat.i(244428);
      int i = this.Bll.getResources().getColor(b.c.hot_tab_BW_0_Alpha_0_9);
      aa.b(this.Bll, i);
      AppMethodBeat.o(244428);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class q
    implements Runnable
  {
    q(kotlin.g.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(247551);
      this.khf.invoke();
      AppMethodBeat.o(247551);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class r
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    r(aa paramaa, float paramFloat, int paramInt)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class s<T>
    implements androidx.lifecycle.s<h.a>
  {
    s(aa paramaa) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class t<T>
    implements androidx.lifecycle.s<h.a>
  {
    t(aa paramaa) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class u<T>
    implements androidx.lifecycle.s<h.a>
  {
    u(aa paramaa) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class v<T>
    implements androidx.lifecycle.s<h.a>
  {
    v(aa paramaa) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class w<T>
    implements androidx.lifecycle.s<h.a>
  {
    w(aa paramaa) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.aa
 * JD-Core Version:    0.7.0.1
 */