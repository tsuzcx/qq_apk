package com.tencent.mm.plugin.finder.live.plugin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.ar;
import com.tencent.mm.plugin.finder.report.live.s.ay;
import com.tencent.mm.plugin.finder.report.live.s.c;
import com.tencent.mm.plugin.finder.report.live.s.f;
import com.tencent.mm.plugin.finder.report.live.s.r;
import com.tencent.mm.plugin.finder.report.live.s.u;
import com.tencent.mm.plugin.finder.report.live.s.y;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.utils.ac;
import com.tencent.mm.plugin.finder.utils.ae;
import com.tencent.mm.plugin.finder.utils.af;
import com.tencent.mm.plugin.finder.utils.fake.d.b;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.base.u.b;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.z.d;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreActionPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/ui/MMActivity;)V", "SHEET_MORE_ACTION_AUDIO_LINK", "", "SHEET_MORE_ACTION_BAN_COMMENT", "SHEET_MORE_ACTION_COST_TIME_LOG", "SHEET_MORE_ACTION_GIFT", "SHEET_MORE_ACTION_GIFTS_MOCK_SINGLE", "SHEET_MORE_ACTION_GIFTS_MOCK_TCASE", "SHEET_MORE_ACTION_LINK_MIC", "SHEET_MORE_ACTION_LIVE_DEBUG", "SHEET_MORE_ACTION_LOTTERY_RECORD", "SHEET_MORE_ACTION_MINI_WINDOW", "SHEET_MORE_ACTION_REPORT", "SHEET_MORE_ACTION_SCREEN_CLEAR", "SHEET_MORE_ACTION_SHARE_2_FRIEMD", "SHEET_MORE_ACTION_SHARE_2_SNS", "SHEET_MORE_ACTION_SHARE_2_STATUS", "SHEET_MORE_ACTION_SHOW_STATISTICS", "SHEET_MORE_ACTION_STOP_LINK", "SHEET_MORE_ACTION_VIDEO_LINK", "SHEET_MORE_ACTION_WIN_LOTTERY_RECORD", "TAG", "", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "isLiving", "", "menuItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "moreActionBtn", "Landroid/widget/RelativeLayout;", "banComment", "", "menuItem", "Landroid/view/MenuItem;", "buildConfirmDialog", "canClearScreen", "expose", "exposeImpl", "hideMoreActionBottomSheet", "miniWindow", "onPortraitAction", "actionInfo", "Landroid/os/Bundle;", "postDelayForDialogDismiss", "action", "prepareLinkMenuItems", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "prepareMenuItems", "prepareSecondMenuItems", "screenClearAction", "setJumpWithoutMiniWindow", "share2Friend", "share2FriendImpl", "share2SNS", "share2SNSImpl", "share2Status", "share2StatusImpl", "showDebugLiveInfo", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Companion", "plugin-finder_release"})
public final class at
  extends d
{
  private static final String ute = "PORTRAIT_ACTION_SHARE_2_FRIEND";
  private static final String utf = "PORTRAIT_ACTION_SHARE_2_SNS";
  private static final String utg = "PORTRAIT_ACTION_SHARE_2_STATUS";
  private static final String uth = "PORTRAIT_ACTION_EXPOSE";
  public static final a uti;
  private final String TAG;
  private final MMActivity activity;
  private final com.tencent.mm.live.c.b hOp;
  private e hOv;
  private boolean hSh;
  private o.g uhx;
  private final int urZ;
  private final int usM;
  private final int usN;
  private final int usO;
  private final int usP;
  private final int usQ;
  private final int usR;
  private final int usS;
  private final int usT;
  private final int usU;
  private final int usV;
  private final int usW;
  private final int usX;
  private final int usY;
  private final int usZ;
  private final int usc;
  private final int uta;
  private final int utb;
  private final int utc;
  private final RelativeLayout utd;
  
  static
  {
    AppMethodBeat.i(246923);
    uti = new a((byte)0);
    ute = "PORTRAIT_ACTION_SHARE_2_FRIEND";
    utf = "PORTRAIT_ACTION_SHARE_2_SNS";
    utg = "PORTRAIT_ACTION_SHARE_2_STATUS";
    uth = "PORTRAIT_ACTION_EXPOSE";
    AppMethodBeat.o(246923);
  }
  
  public at(final ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb, MMActivity paramMMActivity)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(246922);
    this.hOp = paramb;
    this.activity = paramMMActivity;
    this.TAG = "Finder.FinderLiveMoreActionPlugin";
    this.usN = 1;
    this.usO = 2;
    this.urZ = 3;
    this.usP = 4;
    this.usQ = 5;
    this.usc = 6;
    this.usR = 7;
    this.usS = 8;
    this.usT = 9;
    this.usU = 10;
    this.usV = 500;
    this.usW = 501;
    this.usX = 502;
    this.usY = 1000;
    this.usZ = 1001;
    this.uta = 1002;
    this.utb = 1003;
    this.utc = 1004;
    paramb = paramViewGroup.findViewById(2131301203);
    p.g(paramb, "root.findViewById(R.id.f…ve_more_action_btn_group)");
    this.utd = ((RelativeLayout)paramb);
    this.utd.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(246901);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreActionPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        com.tencent.mm.live.c.b.b.a(at.b(this.utj), com.tencent.mm.live.c.b.c.hNn);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreActionPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(246901);
      }
    });
    paramb = com.tencent.mm.plugin.finder.utils.m.vVH;
    com.tencent.mm.plugin.finder.utils.m.a((d)this);
    this.uhx = ((o.g)new f(this, paramViewGroup));
    AppMethodBeat.o(246922);
  }
  
  private final void dhC()
  {
    AppMethodBeat.i(246913);
    getLiveData().uDS = false;
    AppMethodBeat.o(246913);
  }
  
  private final void dhE()
  {
    AppMethodBeat.i(246916);
    com.tencent.mm.live.c.b.b.a(this.hOp, com.tencent.mm.live.c.b.c.hNo);
    e locale = this.hOv;
    if (locale != null)
    {
      locale.bMo();
      AppMethodBeat.o(246916);
      return;
    }
    AppMethodBeat.o(246916);
  }
  
  private final void dhF()
  {
    AppMethodBeat.i(246917);
    Log.i(this.TAG, "share2FriendImpl");
    FinderObject localFinderObject = getLiveData().uDz;
    if (localFinderObject != null)
    {
      com.tencent.mm.plugin.finder.utils.s.a locala = com.tencent.mm.plugin.finder.utils.s.vWt;
      AppCompatActivity localAppCompatActivity = (AppCompatActivity)this.activity;
      FinderItem.a locala1 = FinderItem.Companion;
      com.tencent.mm.plugin.finder.utils.s.a.a(locala, localAppCompatActivity, FinderItem.a.a(localFinderObject, 16384), 0, 12);
      dhC();
      AppMethodBeat.o(246917);
      return;
    }
    AppMethodBeat.o(246917);
  }
  
  private final void dhG()
  {
    AppMethodBeat.i(246918);
    Log.i(this.TAG, "share2SNSImpl");
    FinderObject localFinderObject = getLiveData().uDz;
    if (localFinderObject != null)
    {
      Object localObject = com.tencent.mm.plugin.finder.utils.s.vWt;
      localObject = (AppCompatActivity)this.activity;
      FinderItem.a locala = FinderItem.Companion;
      com.tencent.mm.plugin.finder.utils.s.a.a((AppCompatActivity)localObject, (BaseFinderFeed)new w(FinderItem.a.a(localFinderObject, 16384)), 0, 0, 28);
      dhC();
      AppMethodBeat.o(246918);
      return;
    }
    AppMethodBeat.o(246918);
  }
  
  private final void dhH()
  {
    AppMethodBeat.i(246919);
    Log.i(this.TAG, "share2StatusImpl");
    Object localObject3 = getLiveData().uDz;
    if (localObject3 != null)
    {
      Object localObject1 = c.sFa;
      Object localObject2 = getLiveData().hwd;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = ((FinderObject)localObject3).username;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      c.apr((String)localObject2);
      localObject1 = com.tencent.mm.plugin.finder.utils.s.vWt;
      localObject1 = (AppCompatActivity)this.activity;
      localObject2 = FinderItem.Companion;
      localObject2 = (BaseFinderFeed)new w(FinderItem.a.a((FinderObject)localObject3, 16384));
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("FINDER_LIVE_SHARE_KEY_STATUS_VERIFY", getLiveData().uFc);
      com.tencent.mm.plugin.finder.utils.s.a.a((AppCompatActivity)localObject1, (BaseFinderFeed)localObject2, (Bundle)localObject3);
      dhC();
      AppMethodBeat.o(246919);
      return;
    }
    AppMethodBeat.o(246919);
  }
  
  private final void dhI()
  {
    AppMethodBeat.i(246920);
    Log.i(this.TAG, "exposeImpl");
    Object localObject = o.ujN;
    localObject = o.getFinderLiveAssistant();
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.finder.live.model.s)localObject).b((Context)this.activity, getLiveData().liveInfo.liveId, getLiveData().hwd, null, 62);
      AppMethodBeat.o(246920);
      return;
    }
    AppMethodBeat.o(246920);
  }
  
  public final void ai(Bundle paramBundle)
  {
    AppMethodBeat.i(246921);
    if (paramBundle != null)
    {
      String str = paramBundle.getString("POST_PORTRAIT_ACTION", "");
      paramBundle = str;
      if (str != null) {}
    }
    else
    {
      paramBundle = "";
    }
    if (p.j(paramBundle, ute))
    {
      dhF();
      AppMethodBeat.o(246921);
      return;
    }
    if (p.j(paramBundle, utf))
    {
      dhG();
      AppMethodBeat.o(246921);
      return;
    }
    if (p.j(paramBundle, utg))
    {
      dhH();
      AppMethodBeat.o(246921);
      return;
    }
    if (p.j(paramBundle, uth)) {
      dhI();
    }
    AppMethodBeat.o(246921);
  }
  
  public final boolean dgK()
  {
    return true;
  }
  
  public final void dhD()
  {
    AppMethodBeat.i(246914);
    if (this.hOv == null)
    {
      this.hOv = new e(this.hwr.getContext(), 0, true);
      locale = this.hOv;
      if (locale != null) {
        locale.Do(isLandscape());
      }
      locale = this.hOv;
      if (locale != null) {
        locale.hbs();
      }
    }
    e locale = this.hOv;
    if (locale != null) {
      locale.hbr();
    }
    locale = this.hOv;
    if (locale != null) {
      locale.Dp(false);
    }
    locale = this.hOv;
    if (locale != null) {
      locale.a((o.f)new c(this));
    }
    locale = this.hOv;
    if (locale != null) {
      locale.b((o.f)new d(this));
    }
    locale = this.hOv;
    if (locale != null) {
      locale.a(this.uhx);
    }
    locale = this.hOv;
    if (locale != null) {
      locale.b(this.uhx);
    }
    locale = this.hOv;
    if (locale != null) {
      locale.b((e.b)new e(this));
    }
    locale = this.hOv;
    if (locale != null)
    {
      locale.dGm();
      AppMethodBeat.o(246914);
      return;
    }
    AppMethodBeat.o(246914);
  }
  
  public final void statusChange(com.tencent.mm.live.c.b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(246915);
    p.h(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (au.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(246915);
      return;
      rg(4);
      this.hSh = false;
      AppMethodBeat.o(246915);
      return;
      this.hSh = true;
      AppMethodBeat.o(246915);
      return;
      paramc = com.tencent.mm.plugin.finder.utils.m.vVH;
      com.tencent.mm.plugin.finder.utils.m.a((d)this);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreActionPlugin$Companion;", "", "()V", "PORTRAIT_ACTION_EXPOSE", "", "getPORTRAIT_ACTION_EXPOSE", "()Ljava/lang/String;", "PORTRAIT_ACTION_SHARE_2_FRIEND", "getPORTRAIT_ACTION_SHARE_2_FRIEND", "PORTRAIT_ACTION_SHARE_2_SNS", "getPORTRAIT_ACTION_SHARE_2_SNS", "PORTRAIT_ACTION_SHARE_2_STATUS", "getPORTRAIT_ACTION_SHARE_2_STATUS", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreActionPlugin$banComment$callBack$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveAnchorStatus$CallBack;", "onFail", "", "errType", "", "errCode", "errMsg", "", "anchorStatus", "onSuccess", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.plugin.finder.cgi.s.a
  {
    public final void b(int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      AppMethodBeat.i(246905);
      if (!com.tencent.mm.ac.d.cW(paramInt3, 8))
      {
        paramInt3 = 1;
        if (paramInt3 == 0) {
          break label150;
        }
        localObject = this.utj.hwr.getContext();
        p.g(localObject, "root.context");
      }
      for (Object localObject = ((Context)localObject).getResources().getString(2131760091);; localObject = ((Context)localObject).getResources().getString(2131760093))
      {
        p.g(localObject, "if (enable) root.context…_more_action_ban_comment)");
        u.makeText(this.utj.hwr.getContext(), (CharSequence)((String)localObject + "失败"), 0).show();
        localObject = ae.vZW;
        String str = ae.dEi();
        localObject = paramString;
        if (paramString == null) {
          localObject = "";
        }
        ae.a(str, paramInt2, paramInt1, (String)localObject, this.utj.getLiveData());
        AppMethodBeat.o(246905);
        return;
        paramInt3 = 0;
        break;
        label150:
        localObject = this.utj.hwr.getContext();
        p.g(localObject, "root.context");
      }
    }
    
    @SuppressLint({"ResourceType"})
    public final void onSuccess(int paramInt)
    {
      AppMethodBeat.i(246904);
      Object localObject;
      label47:
      z.d locald;
      if (!com.tencent.mm.ac.d.cW(paramInt, 8))
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label109;
        }
        localObject = this.utj.hwr.getContext();
        p.g(localObject, "root.context");
        localObject = ((Context)localObject).getResources().getString(2131760092);
        p.g(localObject, "if (enable) {\n          …t_done)\n                }");
        locald = new z.d();
        if (paramInt == 0) {
          break label139;
        }
      }
      label139:
      for (paramInt = 2131690775;; paramInt = 2131690454)
      {
        locald.SYE = paramInt;
        u.a(this.utj.hwr.getContext(), (String)localObject, (u.b)new a(locald));
        AppMethodBeat.o(246904);
        return;
        paramInt = 0;
        break;
        label109:
        localObject = this.utj.hwr.getContext();
        p.g(localObject, "root.context");
        localObject = ((Context)localObject).getResources().getString(2131760094);
        break label47;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
    static final class a
      implements u.b
    {
      a(z.d paramd) {}
      
      public final void dU(View paramView)
      {
        AppMethodBeat.i(246903);
        if (paramView != null) {
          paramView.findViewById(2131309260);
        }
        if (paramView != null)
        {
          paramView = (WeImageView)paramView.findViewById(2131309259);
          if (paramView != null)
          {
            paramView.setImageResource(this.utk.SYE);
            AppMethodBeat.o(246903);
            return;
          }
        }
        AppMethodBeat.o(246903);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class c
    implements o.f
  {
    c(at paramat) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(246906);
      Object localObject = at.c(this.utj);
      if (localObject != null) {
        ((e)localObject).setFooterView(null);
      }
      paramm.clear();
      localObject = this.utj;
      p.g(paramm, "menu");
      at.a((at)localObject, paramm);
      AppMethodBeat.o(246906);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class d
    implements o.f
  {
    d(at paramat) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(246907);
      Object localObject = at.c(this.utj);
      if (localObject != null) {
        ((e)localObject).setFooterView(null);
      }
      paramm.clear();
      localObject = this.utj;
      p.g(paramm, "menu");
      at.b((at)localObject, paramm);
      AppMethodBeat.o(246907);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss"})
  static final class e
    implements e.b
  {
    e(at paramat) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(246908);
      com.tencent.mm.live.c.b.b.a(at.b(this.utj), com.tencent.mm.live.c.b.c.hNo);
      at.d(this.utj);
      AppMethodBeat.o(246908);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
  static final class f
    implements o.g
  {
    f(at paramat, ViewGroup paramViewGroup) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      boolean bool = false;
      AppMethodBeat.i(246909);
      Object localObject;
      if (paramMenuItem != null)
      {
        localObject = Integer.valueOf(paramMenuItem.getItemId());
        paramInt = at.f(this.utj);
        if (localObject != null) {
          break label249;
        }
        label35:
        paramInt = at.h(this.utj);
        if (localObject != null) {
          break label271;
        }
        label48:
        paramInt = at.j(this.utj);
        if (localObject != null) {
          break label293;
        }
        label61:
        paramInt = at.l(this.utj);
        if (localObject != null) {
          break label315;
        }
        label74:
        paramInt = at.n(this.utj);
        if (localObject != null) {
          break label335;
        }
        label87:
        paramInt = at.p(this.utj);
        if (localObject != null) {
          break label354;
        }
        label100:
        paramInt = at.r(this.utj);
        if (localObject != null) {
          break label410;
        }
        label113:
        paramInt = at.t(this.utj);
        if (localObject != null) {
          break label439;
        }
      }
      label152:
      label165:
      label178:
      label191:
      label217:
      label230:
      label249:
      while (((Integer)localObject).intValue() != paramInt)
      {
        paramInt = at.u(this.utj);
        if (localObject != null) {
          break label555;
        }
        paramInt = at.v(this.utj);
        if (localObject != null) {
          break label615;
        }
        paramInt = at.w(this.utj);
        if (localObject != null) {
          break label697;
        }
        paramInt = at.x(this.utj);
        if (localObject != null) {
          break label729;
        }
        paramInt = at.y(this.utj);
        if (localObject != null) {
          break label795;
        }
        paramInt = at.z(this.utj);
        if (localObject != null) {
          break label1004;
        }
        paramInt = at.A(this.utj);
        if (localObject != null) {
          break label1054;
        }
        paramInt = at.C(this.utj);
        if (localObject != null) {
          break label1410;
        }
        at.m(this.utj);
        do
        {
          AppMethodBeat.o(246909);
          return;
          localObject = null;
          break;
          if (((Integer)localObject).intValue() != paramInt) {
            break label35;
          }
          at.g(this.utj);
          AppMethodBeat.o(246909);
          return;
          if (((Integer)localObject).intValue() != paramInt) {
            break label48;
          }
          at.i(this.utj);
          AppMethodBeat.o(246909);
          return;
          if (((Integer)localObject).intValue() != paramInt) {
            break label61;
          }
          at.k(this.utj);
          AppMethodBeat.o(246909);
          return;
          if (((Integer)localObject).intValue() != paramInt) {
            break label74;
          }
          at.a(this.utj, paramMenuItem);
          break label230;
          if (((Integer)localObject).intValue() != paramInt) {
            break label87;
          }
          at.o(this.utj);
          break label230;
          if (((Integer)localObject).intValue() != paramInt) {
            break label100;
          }
          at.q(this.utj);
        } while (at.b(this.utj).getLiveRole() != 0);
        paramMenuItem = com.tencent.mm.plugin.finder.report.live.m.vli;
        com.tencent.mm.plugin.finder.report.live.m.a(s.ar.vrm, null);
        com.tencent.mm.plugin.finder.report.live.m.vkv += 1;
        AppMethodBeat.o(246909);
        return;
        if (((Integer)localObject).intValue() != paramInt) {
          break label113;
        }
        at.m(this.utj);
        at.s(this.utj);
        AppMethodBeat.o(246909);
        return;
      }
      label271:
      label293:
      label315:
      label335:
      label354:
      paramMenuItem = com.tencent.mm.plugin.finder.utils.m.vVH;
      label410:
      label439:
      if (com.tencent.mm.plugin.finder.utils.m.dBP())
      {
        paramMenuItem = ac.vYp;
        paramMenuItem = ac.dDk();
      }
      for (;;)
      {
        localObject = FinderDebugUIC.wvw;
        FinderDebugUIC.a.aG((Context)at.e(this.utj), paramMenuItem);
        break label230;
        paramMenuItem = af.waa;
        paramMenuItem = af.dEo();
        localObject = new StringBuilder();
        af localaf = af.waa;
        paramMenuItem = (String)paramMenuItem.get(af.dEm() + this.utj.getLiveData().liveInfo.liveId);
        if (paramMenuItem == null)
        {
          paramMenuItem = "";
          continue;
          label555:
          if (((Integer)localObject).intValue() != paramInt) {
            break;
          }
          paramMenuItem = y.vXH;
          if (y.dCM())
          {
            paramMenuItem = this.utj.getLiveData();
            if (!this.utj.getLiveData().uEN) {
              bool = true;
            }
            paramMenuItem.uEN = bool;
          }
          at.m(this.utj);
          AppMethodBeat.o(246909);
          return;
          label615:
          if (((Integer)localObject).intValue() != paramInt) {
            break label152;
          }
          paramMenuItem = new com.tencent.mm.plugin.finder.utils.fake.b(at.e(this.utj));
          localObject = new e((Context)paramMenuItem.activity, 1, false);
          ((e)localObject).a((o.f)new com.tencent.mm.plugin.finder.utils.fake.b.b(paramMenuItem));
          ((e)localObject).a((o.g)new com.tencent.mm.plugin.finder.utils.fake.b.c(paramMenuItem));
          ((e)localObject).dGm();
          break label230;
          label697:
          if (((Integer)localObject).intValue() != paramInt) {
            break label165;
          }
          at.a(this.utj, this.utj.getLiveData().uDz);
          AppMethodBeat.o(246909);
          return;
          label729:
          if (((Integer)localObject).intValue() != paramInt) {
            break label178;
          }
          paramMenuItem = new com.tencent.mm.plugin.finder.utils.fake.d(at.e(this.utj));
          localObject = new e((Context)paramMenuItem.activity, 1, false);
          ((e)localObject).a((o.f)new d.b(paramMenuItem));
          ((e)localObject).dGm();
          break label230;
          label795:
          if (((Integer)localObject).intValue() != paramInt) {
            break label191;
          }
          label804:
          localObject = new Intent();
          if (paramMenuItem.getItemId() == at.z(this.utj)) {}
          for (paramInt = 1;; paramInt = 2)
          {
            ((Intent)localObject).putExtra("KEY_LOTTERY_HISTORY_SCENE", paramInt);
            ((Intent)localObject).putExtra("KEY_LOTTERY_HISTORY_LIVE_ID", this.utj.getLiveData().liveInfo.liveId);
            ((Intent)localObject).putExtra("KEY_LOTTERY_HISTORY_OBJECT_ID", this.utj.getLiveData().hFK);
            ((Intent)localObject).putExtra("KEY_LOTTERY_HISTORY_OBJECT_NONCE_ID", this.utj.getLiveData().hwg);
            ((Intent)localObject).putExtra("KEY_LIVE_ANCHOR_USERNAME", this.utj.getLiveData().hwd);
            paramMenuItem = FinderReporterUIC.wzC;
            FinderReporterUIC.a.a((Context)at.e(this.utj), (Intent)localObject, 0L, 0, false, 124);
            paramMenuItem = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.f((Activity)at.e(this.utj), (Intent)localObject);
            at.m(this.utj);
            if (at.b(this.utj).getLiveRole() != 1) {
              break label1021;
            }
            paramMenuItem = k.vkd;
            k.a(s.f.vnw, "");
            AppMethodBeat.o(246909);
            return;
            label1004:
            if (((Integer)localObject).intValue() != paramInt) {
              break;
            }
            break label804;
          }
          label1021:
          if (at.b(this.utj).getLiveRole() == 0)
          {
            paramMenuItem = com.tencent.mm.plugin.finder.report.live.m.vli;
            com.tencent.mm.plugin.finder.report.live.m.a(s.ay.vsO, "");
          }
          AppMethodBeat.o(246909);
          return;
          label1054:
          if (((Integer)localObject).intValue() != paramInt) {
            break label217;
          }
          Log.i(at.B(this.utj), "enable/disable link mic. curEnableLinkMic:" + this.utj.getLiveData().diZ());
          at.m(this.utj);
          if (this.utj.getLiveData().diZ())
          {
            this.utj.getLiveData().uDA &= 0xFFFFFFBF;
            paramMenuItem = paramViewGroup.getContext();
            localObject = paramViewGroup.getContext();
            p.g(localObject, "root.context");
            u.cG(paramMenuItem, ((Context)localObject).getResources().getString(2131759984));
            paramMenuItem = new Bundle();
            paramMenuItem.putBoolean("PARAM_FINDER_LIVE_LINK_MIC_ENABLE", false);
            at.b(this.utj).statusChange(com.tencent.mm.live.c.b.c.hNS, paramMenuItem);
            if (at.b(this.utj).getLiveRole() == 1)
            {
              paramMenuItem = k.vkd;
              k.a(s.c.vne, String.valueOf(s.y.vpD.action));
            }
          }
          for (;;)
          {
            this.utj.getLiveData();
            g.EP(this.utj.getLiveData().uDA);
            AppMethodBeat.o(246909);
            return;
            this.utj.getLiveData().uDA |= 0x40;
            paramMenuItem = paramViewGroup.getContext();
            localObject = paramViewGroup.getContext();
            p.g(localObject, "root.context");
            u.cG(paramMenuItem, ((Context)localObject).getResources().getString(2131759986));
            paramMenuItem = new Bundle();
            paramMenuItem.putBoolean("PARAM_FINDER_LIVE_LINK_MIC_ENABLE", true);
            at.b(this.utj).statusChange(com.tencent.mm.live.c.b.c.hNS, paramMenuItem);
            if (at.b(this.utj).getLiveRole() == 1)
            {
              paramMenuItem = k.vkd;
              k.a(s.c.vne, String.valueOf(s.y.vpC.action));
            }
          }
          label1410:
          if (((Integer)localObject).intValue() != paramInt) {
            break label230;
          }
          Log.i(at.B(this.utj), "enable/disable gift. curEnableGift:" + this.utj.getLiveData().dja());
          at.m(this.utj);
          if (this.utj.getLiveData().dja())
          {
            this.utj.getLiveData().uDA &= 0xFFFFFF7F;
            paramMenuItem = paramViewGroup.getContext();
            localObject = paramViewGroup.getContext();
            p.g(localObject, "root.context");
            u.cG(paramMenuItem, ((Context)localObject).getResources().getString(2131759941));
            if (at.b(this.utj).getLiveRole() == 1)
            {
              paramMenuItem = k.vkd;
              k.a(s.c.vng, String.valueOf(s.u.vpk.action));
            }
          }
          for (;;)
          {
            this.utj.getLiveData();
            g.EP(this.utj.getLiveData().uDA);
            paramMenuItem = o.ujN;
            paramMenuItem = o.getFinderLiveAssistant();
            if (paramMenuItem == null) {
              break;
            }
            com.tencent.mm.plugin.finder.live.model.s.a.a(paramMenuItem, this.utj.getLiveData().liveInfo.liveId, this.utj.getLiveData().hFK, this.utj.getLiveData().uDA);
            AppMethodBeat.o(246909);
            return;
            this.utj.getLiveData().uDA |= 0x80;
            paramMenuItem = paramViewGroup.getContext();
            localObject = paramViewGroup.getContext();
            p.g(localObject, "root.context");
            u.cG(paramMenuItem, ((Context)localObject).getResources().getString(2131759943));
            if (at.b(this.utj).getLiveRole() == 1)
            {
              paramMenuItem = k.vkd;
              k.a(s.c.vng, String.valueOf(s.u.vpl.action));
            }
          }
          AppMethodBeat.o(246909);
          return;
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreActionPlugin$miniWindow$1", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog$OverlayPermissionResultCallBack;", "onResultAllow", "", "dialog", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog;", "onResultCancel", "onResultRefuse", "plugin-finder_release"})
  public static final class g
    implements RequestFloatWindowPermissionDialog.a
  {
    public final void onResultAllow(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(246910);
      p.h(paramRequestFloatWindowPermissionDialog, "dialog");
      paramRequestFloatWindowPermissionDialog.finish();
      if (at.a(this.utj))
      {
        if (at.b(this.utj).getLiveRole() == 1)
        {
          paramRequestFloatWindowPermissionDialog = com.tencent.mm.live.core.core.a.b.hyv;
          this.utj.hwr.getContext();
        }
        for (com.tencent.mm.live.core.core.a.b.a.aDo().hAz.hzz = true;; com.tencent.mm.live.core.core.d.b.a.aEf().hAz.hzz = true)
        {
          paramRequestFloatWindowPermissionDialog = new Bundle();
          paramRequestFloatWindowPermissionDialog.putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 2);
          paramRequestFloatWindowPermissionDialog.putInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 12);
          at.b(this.utj).statusChange(com.tencent.mm.live.c.b.c.hLQ, paramRequestFloatWindowPermissionDialog);
          if (at.b(this.utj).getLiveRole() != 1) {
            break;
          }
          paramRequestFloatWindowPermissionDialog = k.vkd;
          k.dpl().vmk = true;
          paramRequestFloatWindowPermissionDialog = k.vkd;
          k.dpl().vml = false;
          paramRequestFloatWindowPermissionDialog = k.vkd;
          k.a(s.c.vmQ, String.valueOf(s.r.voX.type));
          AppMethodBeat.o(246910);
          return;
          paramRequestFloatWindowPermissionDialog = com.tencent.mm.live.core.core.d.b.hCo;
          this.utj.hwr.getContext();
        }
        paramRequestFloatWindowPermissionDialog = com.tencent.mm.plugin.finder.report.live.m.vli;
        com.tencent.mm.plugin.finder.report.live.m.a(true, s.r.voX);
      }
      AppMethodBeat.o(246910);
    }
    
    public final void onResultCancel(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(246912);
      p.h(paramRequestFloatWindowPermissionDialog, "dialog");
      com.tencent.mm.live.c.b.b.a(at.b(this.utj), com.tencent.mm.live.c.b.c.hLU);
      AppMethodBeat.o(246912);
    }
    
    public final void onResultRefuse(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(246911);
      p.h(paramRequestFloatWindowPermissionDialog, "dialog");
      paramRequestFloatWindowPermissionDialog.finish();
      com.tencent.mm.live.c.b.b.a(at.b(this.utj), com.tencent.mm.live.c.b.c.hLT);
      AppMethodBeat.o(246911);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.at
 * JD-Core Version:    0.7.0.1
 */