package com.tencent.mm.plugin.finder.viewmodel.component;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.b;
import android.support.design.widget.TabLayout.f;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.cd;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.extension.reddot.h.a;
import com.tencent.mm.plugin.finder.extension.reddot.i.a;
import com.tencent.mm.plugin.finder.extension.reddot.k;
import com.tencent.mm.plugin.finder.report.e.a;
import com.tencent.mm.plugin.finder.report.o;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.ui.FinderSelfUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.plugin.i.a.af;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.HardTouchableLayout.b;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.s;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "actionBarColor", "", "fromTabIndex", "fromTabType", "fullScreenIconColor", "isAllHomeTabEnableFullScreenEnjoy", "", "isCurrentResume", "isPreparing", "lastExposeFollowTipsId", "", "lastExposeFriendTipsId", "lastExposeLbsTipsId", "lastExposeMachineTipsId", "lastExposePersonalCenterTipsId", "selected", "selectedInHot", "toTabIndex", "toTabType", "unselected", "unselectedInHot", "buildTab", "", "checkFinderTeenMode", "checkNearbyLiveFriends", "checkPersonCenterRedDotReport", "action", "checkPostEntrance", "doClickPostAction", "doPrepareUser", "status", "fixActionBarStatus", "getFinderTab", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$FinderTab;", "tabType", "getPersonalCenterRect", "outRect", "Landroid/graphics/Rect;", "getRootView", "Landroid/view/View;", "getScrollMask", "handleTabColor", "isFromFullScreenTab", "isToFullScreenTab", "selectedInHot2UnSelected", "selected2UnselectedInHot", "selected2Unselected", "unselected2Selected", "unselected2SelectedInHot", "unselectedInHot2Selected", "unselected2UnSelectedInHot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDestroy", "onFragmentChange", "from", "to", "fromType", "toType", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onUserVisibleFragmentChange", "isUserVisibleFocused", "index", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "overlayStatusBar", "refreshActionBarColor", "registerRedDot", "resetScrollMask", "color", "setTabIndex", "findByTag", "Landroid/support/design/widget/TabLayout$Tab;", "Landroid/support/design/widget/TabLayout;", "any", "", "Companion", "FinderTab", "plugin-finder_release"})
public final class FinderHomeActionBarUIC
  extends UIComponent
  implements com.tencent.mm.ak.i, com.tencent.mm.plugin.finder.view.h
{
  public static final a wwL;
  private final int selected;
  private boolean uPU;
  private String wwA;
  private boolean wwB;
  private final int wwC;
  private final int wwD;
  private final int wwE;
  private final int wwF;
  private final int wwG;
  private int wwH;
  private int wwI;
  private int wwJ;
  private int wwK;
  private final boolean wwv;
  private String www;
  private String wwx;
  private String wwy;
  private String wwz;
  
  static
  {
    AppMethodBeat.i(255595);
    wwL = new a((byte)0);
    AppMethodBeat.o(255595);
  }
  
  public FinderHomeActionBarUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(255594);
    y localy = y.vXH;
    this.wwv = y.isAllHomeTabEnableFullScreenEnjoy();
    this.www = "";
    this.wwx = "";
    this.wwy = "";
    this.wwz = "";
    this.wwA = "";
    this.wwC = paramAppCompatActivity.getResources().getColor(2131100629);
    this.wwD = paramAppCompatActivity.getResources().getColor(2131100617);
    this.wwE = paramAppCompatActivity.getResources().getColor(2131100632);
    this.selected = paramAppCompatActivity.getResources().getColor(2131100044);
    this.wwF = paramAppCompatActivity.getResources().getColor(2131100245);
    this.wwG = paramAppCompatActivity.getResources().getColor(2131099689);
    this.wwH = -1;
    this.wwI = -1;
    this.wwJ = -1;
    this.wwK = -1;
    AppMethodBeat.o(255594);
  }
  
  private final void Mu(int paramInt)
  {
    AppMethodBeat.i(255582);
    Object localObject = FinderReporterUIC.wzC;
    localObject = FinderReporterUIC.a.fH((Context)getActivity());
    if (localObject != null) {}
    for (localObject = ((FinderReporterUIC)localObject).dIx();; localObject = null)
    {
      i.a locala = com.tencent.mm.plugin.finder.extension.reddot.i.tLi;
      this.www = i.a.a(paramInt, (bbn)localObject, this.www);
      AppMethodBeat.o(255582);
      return;
    }
  }
  
  private final void Mv(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(255588);
    Log.i("Finder.HomeActionBarUIC", "[doPrepareUser] isPreparing=" + this.wwB + " status=" + paramInt);
    Object localObject;
    if (!this.wwB)
    {
      this.wwB = true;
      localObject = g.ah(PluginFinder.class);
      p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      bool1 = bool2;
      if (((PluginFinder)localObject).getRedDotManager().asW("TLPostCamera") == null)
      {
        localObject = g.ah(PluginFinder.class);
        p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
        if (((PluginFinder)localObject).getRedDotManager().asW("TLCamera") == null) {
          break label161;
        }
      }
    }
    label161:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localObject = new cd(3);
      ((cd)localObject).twh = bool1;
      g.azz().b((com.tencent.mm.ak.q)localObject);
      AppMethodBeat.o(255588);
      return;
    }
  }
  
  private final b Mw(int paramInt)
  {
    AppMethodBeat.i(255593);
    Object localObject1 = (TabLayout)findViewById(2131308820);
    if (localObject1 != null)
    {
      localObject1 = a((TabLayout)localObject1, Integer.valueOf(paramInt));
      if (localObject1 == null) {}
    }
    for (localObject1 = ((TabLayout.f)localObject1).getTag();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (!(localObject1 instanceof b)) {
        localObject2 = null;
      }
      localObject1 = (b)localObject2;
      AppMethodBeat.o(255593);
      return localObject1;
    }
  }
  
  private static TabLayout.f a(TabLayout paramTabLayout, Object paramObject)
  {
    AppMethodBeat.i(255587);
    int j = paramTabLayout.getTabCount();
    int i = 0;
    if (i < j)
    {
      TabLayout.f localf = paramTabLayout.ab(i);
      Object localObject;
      if (localf != null) {
        localObject = localf.getTag();
      }
      int k;
      while ((localObject instanceof b))
      {
        localObject = localf.getTag();
        if (localObject == null)
        {
          paramTabLayout = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeActionBarUIC.FinderTab");
          AppMethodBeat.o(255587);
          throw paramTabLayout;
          localObject = null;
        }
        else
        {
          k = ((b)localObject).dLS;
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
      AppMethodBeat.o(255587);
      return localf;
    }
    AppMethodBeat.o(255587);
    return null;
  }
  
  private final void dId()
  {
    AppMethodBeat.i(255584);
    TabLayout localTabLayout = (TabLayout)findViewById(2131308820);
    if (localTabLayout == null)
    {
      AppMethodBeat.o(255584);
      return;
    }
    Object localObject1 = com.tencent.mm.ui.component.a.PRN;
    localObject1 = ((Iterable)((FinderHomeUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderHomeUIC.class)).fragments).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.hxH();
      }
      localObject2 = (FinderHomeTabFragment)localObject2;
      Object localObject3 = localTabLayout.cW();
      p.g(localObject3, "tabLayout.newTab()");
      localObject3 = new b((TabLayout.f)localObject3, ((FinderHomeTabFragment)localObject2).dLS);
      int j = ((FinderHomeTabFragment)localObject2).title;
      TextView localTextView = ((b)localObject3).titleTv;
      if (localTextView != null)
      {
        Object localObject4 = c.vCb;
        int k = ((b)localObject3).dLS;
        localObject4 = ((b)localObject3).vq.getCustomView();
        if (localObject4 == null) {
          p.hyc();
        }
        p.g(localObject4, "tab.customView!!");
        localObject4 = ((View)localObject4).getContext();
        p.g(localObject4, "tab.customView!!.context");
        localObject4 = ((Context)localObject4).getResources().getString(j);
        p.g(localObject4, "tab.customView!!.context.resources.getString(id)");
        localTextView.setText((CharSequence)c.bb(k, (String)localObject4));
      }
      localTextView = ((b)localObject3).wwR;
      if (localTextView != null) {
        localTextView.setTextSize(1, 10.0F);
      }
      ((b)localObject3).index = i;
      if (((FinderHomeTabFragment)localObject2).dLS == 4) {
        ((b)localObject3).wwR = ((TextView)getActivity().findViewById(2131305745));
      }
      localTabLayout.a(((b)localObject3).vq, false);
      i += 1;
    }
    localTabLayout.a((TabLayout.b)new c(this));
    AppMethodBeat.o(255584);
  }
  
  public final void D(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool2 = true;
    AppMethodBeat.i(255591);
    this.wwJ = paramInt2;
    this.wwK = paramInt1;
    this.wwH = paramInt4;
    this.wwI = paramInt3;
    Object localObject = y.vXH;
    localObject = getActivity().getWindow();
    p.g(localObject, "activity.window");
    if (!ao.isDarkMode()) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      y.b((Window)localObject, bool1);
      localObject = y.vXH;
      if (y.isAnyHomeTabEnableFullScreenEnjoy()) {
        break;
      }
      AppMethodBeat.o(255591);
      return;
    }
    localObject = y.vXH;
    boolean bool3 = y.LY(this.wwH);
    localObject = y.vXH;
    boolean bool4 = y.LY(this.wwI);
    if (!bool3)
    {
      localObject = y.vXH;
      localObject = getActivity().getWindow();
      p.g(localObject, "activity.window");
      if (!ao.isDarkMode()) {}
      for (bool1 = bool2;; bool1 = false)
      {
        y.b((Window)localObject, bool1);
        localObject = getActivity();
        if (localObject != null) {
          break;
        }
        localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(255591);
        throw ((Throwable)localObject);
      }
      ((MMActivity)localObject).setNavigationbarColor(getActivity().getResources().getColor(2131101424));
      localObject = getActivity().findViewById(2131300730);
      if (localObject != null) {
        ((View)localObject).setBackgroundColor(this.wwG);
      }
    }
    while ((paramInt1 != -1) && (bool3) && (bool4))
    {
      localObject = Mw(this.wwH);
      TextView localTextView;
      if (localObject != null)
      {
        localTextView = ((b)localObject).titleTv;
        if (localTextView != null) {
          localTextView.setTextColor(this.wwC);
        }
        localObject = ((b)localObject).uPW;
        if (localObject != null) {
          ((WeImageView)localObject).setIconColor(this.wwC);
        }
      }
      localObject = Mw(this.wwI);
      if (localObject != null)
      {
        localTextView = ((b)localObject).titleTv;
        if (localTextView != null) {
          localTextView.setTextColor(this.wwE);
        }
        localObject = ((b)localObject).uPW;
        if (localObject != null)
        {
          ((WeImageView)localObject).setIconColor(this.wwE);
          AppMethodBeat.o(255591);
          return;
          localObject = y.vXH;
          localObject = getActivity().getWindow();
          p.g(localObject, "activity.window");
          y.b((Window)localObject, false);
          localObject = getActivity();
          if (localObject == null)
          {
            localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(255591);
            throw ((Throwable)localObject);
          }
          ((MMActivity)localObject).setNavigationbarColor(getActivity().getResources().getColor(2131100042));
          localObject = findViewById(2131300730);
          if (localObject != null) {
            ((View)localObject).setBackground(null);
          }
        }
        else
        {
          AppMethodBeat.o(255591);
          return;
        }
      }
    }
    AppMethodBeat.o(255591);
  }
  
  public final void Jx(int paramInt)
  {
    AppMethodBeat.i(255583);
    Object localObject = (TabLayout)findViewById(2131308820);
    if (localObject != null)
    {
      localObject = ((TabLayout)localObject).ab(paramInt);
      if (localObject != null)
      {
        p.g(localObject, "this");
        if (!((TabLayout.f)localObject).isSelected()) {
          ((TabLayout.f)localObject).select();
        }
        AppMethodBeat.o(255583);
        return;
      }
    }
    AppMethodBeat.o(255583);
  }
  
  public final void a(boolean paramBoolean, int paramInt, FinderHomeTabFragment paramFinderHomeTabFragment)
  {
    AppMethodBeat.i(255590);
    p.h(paramFinderHomeTabFragment, "fragment");
    AppMethodBeat.o(255590);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(255580);
    paramBundle = getActivity().getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    paramBundle = getActivity().getWindow();
    p.g(paramBundle, "activity.window");
    paramBundle = paramBundle.getDecorView();
    p.g(paramBundle, "activity.window.decorView");
    paramBundle.setSystemUiVisibility(paramBundle.getSystemUiVisibility() | 0x400 | 0x100);
    paramBundle = getActivity().getWindow();
    p.g(paramBundle, "activity.window");
    paramBundle.setStatusBarColor(0);
    com.tencent.mm.ui.b.e((Activity)getActivity(), false);
    paramBundle = getActivity().getSupportActionBar();
    if (paramBundle != null)
    {
      paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      paramBundle.hide();
    }
    int i = au.getStatusBarHeight((Context)getActivity());
    paramBundle = findViewById(2131300730);
    if (paramBundle != null)
    {
      ViewGroup.LayoutParams localLayoutParams = paramBundle.getLayoutParams();
      localLayoutParams.height += i;
      paramBundle.setLayoutParams(localLayoutParams);
      paramBundle.setPadding(0, i, 0, 0);
    }
    g.azz().a(3761, (com.tencent.mm.ak.i)this);
    paramBundle = findViewById(2131297160);
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new j(this));
    }
    paramBundle = findViewById(2131303117);
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new k(this));
    }
    paramBundle = findViewById(2131306047);
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new l(this));
    }
    paramBundle = findViewById(2131307349);
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new m(this));
    }
    paramBundle = (HardTouchableLayout)findViewById(2131308821);
    if (paramBundle != null) {
      paramBundle.setOnDoubleClickListener((HardTouchableLayout.b)new n(this));
    }
    paramBundle = findViewById(2131305872);
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new o(this));
    }
    dId();
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
    com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.daN(), (LifecycleOwner)getActivity(), (Observer)new s(this));
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
    com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.daQ(), (LifecycleOwner)getActivity(), (Observer)new t(this));
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
    com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.daR(), (LifecycleOwner)getActivity(), (Observer)new u(this));
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
    com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.daT(), (LifecycleOwner)getActivity(), (Observer)new v(this));
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
    com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.daU(), (LifecycleOwner)getActivity(), (Observer)new w(this));
    Mu(1);
    paramBundle = findViewById(2131307349);
    if (paramBundle != null) {
      paramBundle.setVisibility(0);
    }
    paramBundle = findViewById(2131303117);
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = findViewById(2131306047);
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = g.ah(aj.class);
    p.g(paramBundle, "MMKernel.plugin(IPluginFinder::class.java)");
    paramBundle = ((aj)paramBundle).getFinderUtilApi();
    p.g(paramBundle, "MMKernel.plugin(IPluginF…class.java).finderUtilApi");
    if (paramBundle.dDf())
    {
      paramBundle = findViewById(2131307349);
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = findViewById(2131303117);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = findViewById(2131306047);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
    paramBundle = g.af(ad.class);
    p.g(paramBundle, "MMKernel.service(IFinder…enModeConfig::class.java)");
    if (((ad)paramBundle).dxX())
    {
      paramBundle = findViewById(2131303117);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = findViewById(2131306047);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = findViewById(2131307349);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = findViewById(2131308821);
      if (paramBundle != null) {
        paramBundle.post((Runnable)new d(this));
      }
    }
    if (this.wwv)
    {
      paramBundle = (WeImageView)getActivity().findViewById(2131297161);
      if (paramBundle != null) {
        paramBundle.setIconColor(this.wwD);
      }
      paramBundle = (WeImageView)getActivity().findViewById(2131307348);
      if (paramBundle != null) {
        paramBundle.setIconColor(this.wwD);
      }
      paramBundle = (WeImageView)getActivity().findViewById(2131306046);
      if (paramBundle != null) {
        paramBundle.setIconColor(this.wwD);
      }
      paramBundle = (WeImageView)getActivity().findViewById(2131305872);
      if (paramBundle != null) {
        paramBundle.setIconColor(this.wwD);
      }
      paramBundle = (WeImageView)getActivity().findViewById(2131303116);
      if (paramBundle != null) {
        paramBundle.setIconColor(this.wwD);
      }
      paramBundle = getActivity().findViewById(2131300730);
      if (paramBundle != null) {
        paramBundle.setBackground(null);
      }
    }
    if (this.wwv)
    {
      paramBundle = getActivity().findViewById(2131309856);
      if (paramBundle != null)
      {
        paramBundle.post((Runnable)new p(this));
        AppMethodBeat.o(255580);
        return;
      }
    }
    AppMethodBeat.o(255580);
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(255579);
    super.onCreateBefore(paramBundle);
    paramBundle = com.tencent.mm.ui.component.a.PRN;
    ((FinderHomeUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderHomeUIC.class)).wxj.add(this);
    AppMethodBeat.o(255579);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(255581);
    super.onDestroy();
    g.azz().b(3761, (com.tencent.mm.ak.i)this);
    AppMethodBeat.o(255581);
  }
  
  public final void onPageScrollStateChanged(int paramInt) {}
  
  public final void onPageScrolled(final int paramInt1, final float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(255592);
    Object localObject = y.vXH;
    if (!y.isAnyHomeTabEnableFullScreenEnjoy())
    {
      AppMethodBeat.o(255592);
      return;
    }
    localObject = (kotlin.g.a.a)new r(this, paramFloat, paramInt1);
    TabLayout localTabLayout = (TabLayout)findViewById(2131308820);
    if (localTabLayout != null) {
      paramInt1 = localTabLayout.getHeight();
    }
    while (paramInt1 <= 0)
    {
      localTabLayout = (TabLayout)findViewById(2131308820);
      if (localTabLayout != null)
      {
        localTabLayout.post((Runnable)new q((kotlin.g.a.a)localObject));
        AppMethodBeat.o(255592);
        return;
        paramInt1 = 0;
      }
      else
      {
        AppMethodBeat.o(255592);
        return;
      }
    }
    ((kotlin.g.a.a)localObject).invoke();
    AppMethodBeat.o(255592);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(255586);
    super.onPause();
    this.uPU = false;
    AppMethodBeat.o(255586);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(255585);
    super.onResume();
    this.uPU = true;
    Object localObject = c.vCb;
    int i = ((Number)c.dtX().value()).intValue();
    if (i == 2)
    {
      localObject = z.aUg();
      p.g(localObject, "ConfigStorageLogic.getMyFinderUsername()");
      if (((CharSequence)localObject).length() > 0)
      {
        i = 1;
        localObject = com.tencent.mm.plugin.report.service.h.CyF;
        if (i == 0) {
          break label116;
        }
      }
      label116:
      for (i = 1;; i = 2)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject).a(20971, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(1) });
        AppMethodBeat.o(255585);
        return;
        i = 0;
        break;
      }
    }
    if (i == 1)
    {
      localObject = com.tencent.mm.plugin.finder.report.i.vfo;
      com.tencent.mm.plugin.finder.report.i.H(true, 1);
    }
    AppMethodBeat.o(255585);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(255589);
    p.h(paramq, "scene");
    if (paramq.getType() == 3761) {
      this.wwB = false;
    }
    AppMethodBeat.o(255589);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$Companion;", "", "()V", "SHEET_MENU_POST", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$FinderTab;", "", "tab", "Landroid/support/design/widget/TabLayout$Tab;", "tabType", "", "(Landroid/support/design/widget/TabLayout$Tab;I)V", "bigTabRedIv", "Landroid/widget/ImageView;", "getBigTabRedIv", "()Landroid/widget/ImageView;", "setBigTabRedIv", "(Landroid/widget/ImageView;)V", "changeMargin", "index", "getIndex", "()I", "setIndex", "(I)V", "isAdjust", "", "()Z", "setAdjust", "(Z)V", "newTabRedDotSafeGap", "outerNewRedTv", "Landroid/widget/TextView;", "getOuterNewRedTv", "()Landroid/widget/TextView;", "setOuterNewRedTv", "(Landroid/widget/TextView;)V", "getTab", "()Landroid/support/design/widget/TabLayout$Tab;", "setTab", "(Landroid/support/design/widget/TabLayout$Tab;)V", "tabRedIcon", "Landroid/view/ViewGroup;", "getTabRedIcon", "()Landroid/view/ViewGroup;", "setTabRedIcon", "(Landroid/view/ViewGroup;)V", "tabRedIv", "getTabRedIv", "setTabRedIv", "tabRedTv", "getTabRedTv", "setTabRedTv", "getTabType", "setTabType", "titleIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getTitleIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setTitleIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "titleTv", "getTitleTv", "setTitleTv", "dismissNewRedDot", "", "isNeedExpand", "setTextBold", "isBold", "setTextColor", "id", "isUnSelected", "setTitle", "showNewRedDot", "plugin-finder_release"})
  public static final class b
  {
    int dLS;
    int index;
    TextView titleTv;
    WeImageView uPW;
    ImageView uPX;
    TabLayout.f vq;
    final int wwM;
    final int wwN;
    ImageView wwO;
    ViewGroup wwP;
    TextView wwQ;
    TextView wwR;
    boolean wwS;
    
    @SuppressLint({"ResourceType"})
    public b(TabLayout.f paramf, int paramInt)
    {
      AppMethodBeat.i(255551);
      this.vq = paramf;
      this.dLS = paramInt;
      paramf = MMApplicationContext.getContext();
      p.g(paramf, "MMApplicationContext.getContext()");
      this.wwM = ((int)paramf.getResources().getDimension(2131165299));
      paramf = MMApplicationContext.getContext();
      p.g(paramf, "MMApplicationContext.getContext()");
      this.wwN = ((int)paramf.getResources().getDimension(2131165297));
      this.vq.g(this);
      paramf = y.vXH;
      boolean bool = y.isAllHomeTabEnableFullScreenEnjoy();
      paramf = MMApplicationContext.getContext();
      p.g(paramf, "MMApplicationContext.getContext()");
      paramf = paramf.getResources();
      int i;
      if (bool)
      {
        paramInt = 2131100632;
        i = paramf.getColor(paramInt);
        if (this.dLS != 1) {
          break label337;
        }
        this.vq.aj(2131494346);
        paramf = this.vq.getCustomView();
        if (paramf == null) {
          break label317;
        }
        paramf = (TextView)paramf.findViewById(2131308826);
        label160:
        this.titleTv = paramf;
        paramf = this.titleTv;
        if (paramf != null) {
          paramf.setTextSize(1, 15.0F);
        }
        paramf = this.vq.getCustomView();
        if (paramf == null) {
          break label322;
        }
        paramf = (WeImageView)paramf.findViewById(2131308829);
        label203:
        this.uPW = paramf;
        paramf = this.vq.getCustomView();
        if (paramf == null) {
          break label327;
        }
        paramf = (ImageView)paramf.findViewById(2131308830);
        label230:
        this.uPX = paramf;
        paramf = this.vq.getCustomView();
        if (paramf == null) {
          break label332;
        }
        paramf = (ImageView)paramf.findViewById(2131297365);
        label257:
        this.wwO = paramf;
        paramf = this.uPW;
        if (paramf != null) {
          paramf.setImageResource(2131690580);
        }
      }
      label385:
      label553:
      for (;;)
      {
        paramf = this.uPW;
        if (paramf != null) {
          paramf.setIconColor(i);
        }
        paramf = this.titleTv;
        if (paramf == null) {
          break label649;
        }
        paramf.setTextColor(i);
        AppMethodBeat.o(255551);
        return;
        paramInt = 2131100245;
        break;
        label317:
        paramf = null;
        break label160;
        label322:
        paramf = null;
        break label203;
        label327:
        paramf = null;
        break label230;
        label332:
        paramf = null;
        break label257;
        label337:
        if ((this.dLS == 3) || (this.dLS == 4))
        {
          this.vq.aj(2131494345);
          paramf = this.vq.getCustomView();
          if (paramf != null)
          {
            paramf = (TextView)paramf.findViewById(2131308826);
            this.titleTv = paramf;
            paramf = this.titleTv;
            if (paramf != null) {
              paramf.setTextSize(1, 15.0F);
            }
            paramf = this.vq.getCustomView();
            if (paramf == null) {
              break label611;
            }
            paramf = (ImageView)paramf.findViewById(2131308823);
            this.uPX = paramf;
            paramf = this.vq.getCustomView();
            if (paramf == null) {
              break label616;
            }
            paramf = (ImageView)paramf.findViewById(2131297364);
            this.wwO = paramf;
            paramf = this.vq.getCustomView();
            if (paramf == null) {
              break label621;
            }
            paramf = (ViewGroup)paramf.findViewById(2131308828);
            label482:
            this.wwP = paramf;
            paramf = this.wwP;
            if (paramf != null)
            {
              paramf = (ImageView)paramf.findViewById(2131308827);
              if (paramf != null)
              {
                Object localObject = this.wwP;
                if (localObject == null) {
                  break label626;
                }
                localObject = ((ViewGroup)localObject).getContext();
                if (localObject == null) {
                  break label626;
                }
                localObject = ((Context)localObject).getResources();
                if (localObject == null) {
                  break label626;
                }
                paramInt = ((Resources)localObject).getColor(2131101424);
                com.tencent.mm.emoji.e.e.a(paramf, 2131690246, paramInt);
              }
            }
            paramf = this.vq.getCustomView();
            if (paramf == null) {
              break label631;
            }
          }
          label611:
          label616:
          label621:
          label626:
          label631:
          for (paramf = (TextView)paramf.findViewById(2131308831);; paramf = null)
          {
            this.wwQ = paramf;
            paramf = this.wwQ;
            if (paramf == null) {
              break;
            }
            paramf.setTextSize(1, 9.0F);
            break;
            paramf = null;
            break label385;
            paramf = null;
            break label428;
            paramf = null;
            break label455;
            paramf = null;
            break label482;
            paramInt = 0;
            break label553;
          }
        }
        label428:
        label455:
        this.vq.aj(2131494343);
      }
      label649:
      AppMethodBeat.o(255551);
    }
    
    public final void av(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(255548);
      Object localObject = this.vq.getCustomView();
      if (localObject == null) {
        p.hyc();
      }
      p.g(localObject, "tab.customView!!");
      localObject = ((View)localObject).getContext();
      p.g(localObject, "tab.customView!!.context");
      paramInt = ((Context)localObject).getResources().getColor(paramInt);
      localObject = this.titleTv;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(paramInt);
      }
      localObject = this.uPW;
      if (localObject != null) {
        ((WeImageView)localObject).setIconColor(paramInt);
      }
      if (!paramBoolean) {
        this.vq.vl.setSelectedTabIndicatorColor(paramInt);
      }
      AppMethodBeat.o(255548);
    }
    
    public final void dIe()
    {
      AppMethodBeat.i(255550);
      Log.i("Finder.HomeActionBarUIC", "dismissNewRedDot :" + this.dLS);
      TextView localTextView = this.wwR;
      if (localTextView != null)
      {
        localTextView.setVisibility(4);
        AppMethodBeat.o(255550);
        return;
      }
      AppMethodBeat.o(255550);
    }
    
    public final void setTextBold(boolean paramBoolean)
    {
      AppMethodBeat.i(255549);
      Object localObject = this.titleTv;
      if (localObject != null)
      {
        if (paramBoolean)
        {
          ao.a((Paint)((TextView)localObject).getPaint(), 0.8F);
          AppMethodBeat.o(255549);
          return;
        }
        TextPaint localTextPaint = ((TextView)localObject).getPaint();
        p.g(localTextPaint, "it.paint");
        localTextPaint.setFakeBoldText(false);
        localObject = ((TextView)localObject).getPaint();
        p.g(localObject, "it.paint");
        ((TextPaint)localObject).setStrokeWidth(0.0F);
        AppMethodBeat.o(255549);
        return;
      }
      AppMethodBeat.o(255549);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$FinderTab$showNewRedDot$1$1"})
    static final class a
      implements Runnable
    {
      a(TextView paramTextView, FinderHomeActionBarUIC.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(255547);
        Object localObject = this.wwU;
        TextView localTextView = ((FinderHomeActionBarUIC.b)localObject).wwR;
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
            AppMethodBeat.o(255547);
            throw ((Throwable)localObject);
          }
        }
        label260:
        for (int i = ((ViewGroup)localViewParent).getWidth();; i = 0)
        {
          Log.i("Finder.HomeActionBarUIC", "isNeedShrink gap: " + (i - localTextView.getRight()) + "  newTabRedDotSafeGap: " + ((FinderHomeActionBarUIC.b)localObject).wwM);
          if ((i != 0) && (i - localTextView.getRight() > ((FinderHomeActionBarUIC.b)localObject).wwM)) {
            i = 1;
          }
          while (i != 0)
          {
            localObject = this.wwT.getLayoutParams();
            if (localObject == null)
            {
              localObject = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
              AppMethodBeat.o(255547);
              throw ((Throwable)localObject);
              i = 0;
              continue;
              i = 0;
            }
            else
            {
              localObject = (RelativeLayout.LayoutParams)localObject;
              Log.i("Finder.HomeActionBarUIC", "showNewRedDot isNeedShrink : " + ((RelativeLayout.LayoutParams)localObject).getMarginStart());
              ((RelativeLayout.LayoutParams)localObject).setMarginStart(((RelativeLayout.LayoutParams)localObject).getMarginStart() + this.wwU.wwN);
              Log.i("Finder.HomeActionBarUIC", "showNewRedDot isNeedShrink after: " + ((RelativeLayout.LayoutParams)localObject).getMarginStart());
              this.wwT.setLayoutParams((ViewGroup.LayoutParams)localObject);
            }
          }
          this.wwT.setVisibility(0);
          AppMethodBeat.o(255547);
          return;
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$buildTab$2", "Landroid/support/design/widget/TabLayout$BaseOnTabSelectedListener;", "Landroid/support/design/widget/TabLayout$Tab;", "onTabReselected", "", "t", "onTabSelected", "onTabUnselected", "plugin-finder_release"})
  public static final class c
    implements TabLayout.b<TabLayout.f>
  {
    @SuppressLint({"ResourceType"})
    public final void i(TabLayout.f paramf)
    {
      AppMethodBeat.i(255554);
      p.h(paramf, "t");
      paramf = paramf.getTag();
      Object localObject;
      if ((paramf instanceof FinderHomeActionBarUIC.b))
      {
        if (!FinderHomeActionBarUIC.b(this.wwV)) {
          break label118;
        }
        ((FinderHomeActionBarUIC.b)paramf).av(2131100629, false);
        ((FinderHomeActionBarUIC.b)paramf).setTextBold(true);
        localObject = com.tencent.mm.ui.component.a.PRN;
        ((FinderHomeUIC)com.tencent.mm.ui.component.a.b(this.wwV.getActivity()).get(FinderHomeUIC.class)).p(((FinderHomeActionBarUIC.b)paramf).dLS, null);
        switch (((FinderHomeActionBarUIC.b)paramf).dLS)
        {
        }
      }
      label118:
      do
      {
        AppMethodBeat.o(255554);
        return;
        localObject = y.vXH;
        if (y.LY(((FinderHomeActionBarUIC.b)paramf).dLS))
        {
          ((FinderHomeActionBarUIC.b)paramf).av(2131100629, false);
          break;
        }
        ((FinderHomeActionBarUIC.b)paramf).av(2131100904, false);
        break;
        paramf = ((FinderHomeActionBarUIC.b)paramf).uPW;
        if (paramf != null)
        {
          paramf.setImageResource(2131690589);
          AppMethodBeat.o(255554);
          return;
        }
        AppMethodBeat.o(255554);
        return;
        paramf = ((FinderHomeActionBarUIC.b)paramf).uPW;
      } while (paramf == null);
      paramf.setImageResource(2131690580);
      AppMethodBeat.o(255554);
    }
    
    @SuppressLint({"ResourceType"})
    public final void j(TabLayout.f paramf)
    {
      AppMethodBeat.i(255553);
      p.h(paramf, "t");
      paramf = paramf.getTag();
      if ((paramf instanceof FinderHomeActionBarUIC.b))
      {
        if (!FinderHomeActionBarUIC.b(this.wwV)) {
          break label86;
        }
        ((FinderHomeActionBarUIC.b)paramf).av(2131100632, true);
        ((FinderHomeActionBarUIC.b)paramf).setTextBold(false);
        switch (((FinderHomeActionBarUIC.b)paramf).dLS)
        {
        }
      }
      label86:
      do
      {
        AppMethodBeat.o(255553);
        return;
        ((FinderHomeActionBarUIC.b)paramf).av(2131100245, true);
        break;
        paramf = ((FinderHomeActionBarUIC.b)paramf).uPW;
        if (paramf != null)
        {
          paramf.setImageResource(2131690826);
          AppMethodBeat.o(255553);
          return;
        }
        AppMethodBeat.o(255553);
        return;
        paramf = ((FinderHomeActionBarUIC.b)paramf).uPW;
      } while (paramf == null);
      paramf.setImageResource(2131690824);
      AppMethodBeat.o(255553);
    }
    
    @SuppressLint({"ResourceType"})
    public final void k(TabLayout.f paramf)
    {
      AppMethodBeat.i(255552);
      p.h(paramf, "t");
      AppMethodBeat.o(255552);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(255555);
      Object localObject1 = this.wwV.findViewById(2131308821);
      if (localObject1 != null)
      {
        Object localObject2 = ((View)localObject1).getLayoutParams();
        if (localObject2 == null)
        {
          localObject1 = new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(255555);
          throw ((Throwable)localObject1);
        }
        localObject2 = (LinearLayout.LayoutParams)localObject2;
        ((LinearLayout.LayoutParams)localObject2).leftMargin = 0;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        AppMethodBeat.o(255555);
        return;
      }
      AppMethodBeat.o(255555);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class e
    implements o.f
  {
    public static final e wwW;
    
    static
    {
      AppMethodBeat.i(255557);
      wwW = new e();
      AppMethodBeat.o(255557);
    }
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(255556);
      p.g(paramm, "it");
      if (paramm.gKQ()) {
        paramm.kV(1, 2131760405);
      }
      AppMethodBeat.o(255556);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class f
    implements o.g
  {
    f(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(255558);
      paramMenuItem = y.vXH;
      if (y.an((Activity)this.wwV.getActivity()))
      {
        paramMenuItem = new Intent();
        paramMenuItem.putExtra("key_create_scene", 1);
        paramMenuItem.putExtra("scene", 1);
        com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.w((Context)this.wwV.getActivity(), paramMenuItem);
      }
      AppMethodBeat.o(255558);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class g
    implements o.f
  {
    public static final g wwX;
    
    static
    {
      AppMethodBeat.i(255560);
      wwX = new g();
      AppMethodBeat.o(255560);
    }
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(255559);
      p.g(paramm, "it");
      if (paramm.gKQ())
      {
        paramm.kV(1001, 2131755822);
        paramm.kV(1002, 2131755831);
      }
      AppMethodBeat.o(255559);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class h
    implements o.g
  {
    h(String paramString, AppCompatActivity paramAppCompatActivity) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(255561);
      Intent localIntent = new Intent();
      p.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == 1001) {
        localIntent.putExtra("key_finder_post_router", 2);
      }
      for (;;)
      {
        localIntent.putExtra("key_finder_post_from", 5);
        localIntent.putExtra("key_finder_post_id", this.uPz);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)this.vao, localIntent);
        AppMethodBeat.o(255561);
        return;
        if (paramMenuItem.getItemId() == 1002) {
          localIntent.putExtra("key_finder_post_router", 3);
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss"})
  static final class i
    implements e.b
  {
    public static final i wwY;
    
    static
    {
      AppMethodBeat.i(255563);
      wwY = new i();
      AppMethodBeat.o(255563);
    }
    
    public final void onDismiss()
    {
      AppMethodBeat.i(255562);
      com.tencent.mm.plugin.finder.report.i locali = com.tencent.mm.plugin.finder.report.i.vfo;
      com.tencent.mm.plugin.finder.report.i.Ks(6);
      AppMethodBeat.o(255562);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(255564);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.wwV.getActivity().onBackPressed();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(255564);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(255565);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = com.tencent.mm.plugin.finder.report.h.veu;
      com.tencent.mm.plugin.finder.report.h.dnS();
      paramView = new Intent();
      localObject = FinderReporterUIC.wzC;
      FinderReporterUIC.a.a((Context)this.wwV.getActivity(), paramView, 0L, 0, true, 60);
      localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
      localObject = this.wwV.getActivity();
      if (localObject == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(255565);
        throw paramView;
      }
      com.tencent.mm.plugin.finder.utils.a.b((MMActivity)localObject, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(255565);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(255566);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      FinderHomeActionBarUIC.a(this.wwV);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(255566);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(255567);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = new Intent();
      localObject = FinderReporterUIC.wzC;
      FinderReporterUIC.a.a((Context)this.wwV.getActivity(), paramView, 0L, 0, false, 124);
      localObject = c.vCb;
      if (((Number)c.dwL().value()).intValue() == 1)
      {
        localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.D((Context)this.wwV.getActivity(), paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(255567);
        return;
      }
      localObject = z.aUg();
      p.g(localObject, "ConfigStorageLogic.getMyFinderUsername()");
      if (((CharSequence)localObject).length() > 0)
      {
        i = 1;
        label145:
        localObject = com.tencent.mm.plugin.report.service.h.CyF;
        if (i == 0) {
          break label213;
        }
      }
      label213:
      for (int i = 1;; i = 2)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject).a(20971, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Integer.valueOf(1) });
        localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.C((Context)this.wwV.getActivity(), paramView);
        break;
        i = 0;
        break label145;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$5", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class n
    implements HardTouchableLayout.b
  {
    public final void a(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(255569);
      p.h(paramView, "view");
      p.h(paramMotionEvent, "e");
      Log.i("Finder.HomeActionBarUIC", "onDoubleClick ...");
      com.tencent.f.h.RTc.aV((Runnable)new a(this));
      AppMethodBeat.o(255569);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(FinderHomeActionBarUIC.n paramn) {}
      
      public final void run()
      {
        AppMethodBeat.i(255568);
        com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
        ((FinderHomeUIC)com.tencent.mm.ui.component.a.b(this.wwZ.wwV.getActivity()).get(FinderHomeUIC.class)).getActiveFragment().dlm();
        AppMethodBeat.o(255568);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    o(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
    
    public final void onClick(View paramView)
    {
      Object localObject1 = null;
      AppMethodBeat.i(255570);
      Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject2).axR());
      paramView = FinderReporterUIC.wzC;
      paramView = FinderReporterUIC.a.fH((Context)this.wwV.getActivity());
      if (paramView != null)
      {
        paramView = FinderReporterUIC.c(paramView);
        if ((paramView instanceof o))
        {
          paramView = (o)paramView;
          localObject2 = com.tencent.mm.plugin.finder.report.e.vdS;
          paramView.auL(e.a.ah(ae.b(s.U("feedActionType", Integer.valueOf(3)))));
        }
        FinderHomeActionBarUIC.a(this.wwV, 2);
        localObject2 = new Intent();
        paramView = g.ah(PluginFinder.class);
        p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        k localk = ((PluginFinder)paramView).getRedDotManager().asX("TLPersonalCenter");
        paramView = localObject1;
        if (localk != null) {
          paramView = localk.atl("TLPersonalCenter");
        }
        if (paramView == null) {
          break label246;
        }
      }
      label246:
      for (boolean bool = true;; bool = false)
      {
        paramView = FinderSelfUI.vOh;
        ((Intent)localObject2).putExtra(FinderSelfUI.dAd(), bool);
        paramView = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a((Context)this.wwV.getActivity(), (Intent)localObject2, 0L, 0, false, 124);
        paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.z((Context)this.wwV.getActivity(), (Intent)localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(255570);
        return;
        paramView = null;
        break;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class p
    implements Runnable
  {
    p(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(255571);
      int i = this.wwV.getResources().getColor(2131100611);
      FinderHomeActionBarUIC.b(this.wwV, i);
      AppMethodBeat.o(255571);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class q
    implements Runnable
  {
    q(kotlin.g.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(255572);
      this.wxa.invoke();
      AppMethodBeat.o(255572);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class r
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    r(FinderHomeActionBarUIC paramFinderHomeActionBarUIC, float paramFloat, int paramInt)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class s<T>
    implements Observer<h.a>
  {
    s(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class t<T>
    implements Observer<h.a>
  {
    t(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class u<T>
    implements Observer<h.a>
  {
    u(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class v<T>
    implements Observer<h.a>
  {
    v(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class w<T>
    implements Observer<h.a>
  {
    w(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeActionBarUIC
 * JD-Core Version:    0.7.0.1
 */