package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.t;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.aj.c;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.plugin.profile.ui.WxaBindBizInfoUI;
import com.tencent.mm.plugin.profile.ui.WxaBindWxaInfoUI;
import com.tencent.mm.protocal.protobuf.bci;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.dmd;
import com.tencent.mm.protocal.protobuf.ebh;
import com.tencent.mm.protocal.protobuf.ebq;
import com.tencent.mm.protocal.protobuf.ebr;
import com.tencent.mm.protocal.protobuf.ebs;
import com.tencent.mm.protocal.protobuf.ebt;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.a.e;
import java.lang.ref.WeakReference;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class AppBrandProfileUI
  extends MMActivity
  implements k.a
{
  private static final int mcL;
  private static final int mcM;
  private static final int mcN;
  private static int mcO;
  private static final int mcP;
  private static final int mcQ;
  private static final int mcR;
  private static final int mcS;
  private aa lZJ;
  private LinearLayout lgv;
  private String lhM;
  private ImageView maJ;
  private boolean mcT;
  private boolean mcU;
  private int mcV;
  private LinkedList<ebh> mcW;
  private ImageView mcX;
  private TextView mcY;
  private TextView mcZ;
  private int mdA;
  private e mdB;
  private WxaExposedParams mdC;
  private boolean mdD;
  private b.h mdE;
  private b.h mdF;
  private b.h mdG;
  private TextView mda;
  private RatingBar mdb;
  private TextView mdc;
  private LinearLayout mdd;
  private RecyclerView mde;
  private LinearLayout mdf;
  private LinearLayout mdg;
  private LinearLayout mdh;
  private TextView mdi;
  private AppBrandNearbyShowcaseView mdj;
  private LinearLayout mdk;
  private LinearLayout mdl;
  private TextView mdm;
  private AppBrandNearbyShowcaseView mdn;
  private LinearLayout mdo;
  private FrameLayout mdp;
  private TextView mdq;
  private TextView mdr;
  private LinearLayout mds;
  private ImageView mdt;
  private LinearLayout mdu;
  private AppBrandNearbyShowcaseView mdv;
  private TextView mdw;
  private View mdx;
  private TextView mdy;
  private View mdz;
  
  static
  {
    AppMethodBeat.i(48769);
    mcL = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 24);
    mcM = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 20);
    mcN = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 2);
    mcO = -1;
    mcP = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 40);
    mcQ = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 44);
    mcR = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 32);
    mcS = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 4);
    AppMethodBeat.o(48769);
  }
  
  public AppBrandProfileUI()
  {
    AppMethodBeat.i(48738);
    this.mcT = false;
    this.mcU = false;
    this.mcV = 0;
    this.mcW = new LinkedList();
    this.mdD = false;
    AppMethodBeat.o(48738);
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2, WxaExposedParams paramWxaExposedParams, Bundle paramBundle)
  {
    AppMethodBeat.i(48739);
    a(paramContext, paramString1, paramInt, paramString2, paramWxaExposedParams, paramBundle, null);
    AppMethodBeat.o(48739);
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2, WxaExposedParams paramWxaExposedParams, Bundle paramBundle, ActivityStarterIpcDelegate paramActivityStarterIpcDelegate)
  {
    AppMethodBeat.i(48740);
    if (bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(48740);
      return;
    }
    if (paramContext == null) {
      paramContext = ai.getContext();
    }
    for (;;)
    {
      paramString1 = new Intent(paramContext, AppBrandProfileUI.class).putExtra("key_username", paramString1).putExtra("key_from_scene", paramInt).putExtra("key_scene_note", paramString2).putExtra("key_can_swipe_back", true).putExtra("key_scene_exposed_params", paramWxaExposedParams).putExtra("key_extra_bundle", paramBundle);
      if (paramWxaExposedParams != null)
      {
        paramString2 = new Bundle();
        paramString2.putInt("stat_scene", 6);
        paramString2.putString("stat_app_id", paramWxaExposedParams.appId);
        paramString2.putString("stat_url", paramWxaExposedParams.pageId);
        paramString1.putExtra("_stat_obj", paramString2);
      }
      paramString1.putExtra("KEY_DELEGATED_ACTIVITY_STARTER", paramActivityStarterIpcDelegate);
      if (!(paramContext instanceof Activity)) {
        paramString1.addFlags(268435456);
      }
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().ba(paramString1);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.aeD(), "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI", "show", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;ZLcom/tencent/mm/plugin/appbrand/config/WxaExposedParams;Landroid/os/Bundle;Lcom/tencent/luggage/sdk/launching/ActivityStarterIpcDelegate;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI", "show", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;ZLcom/tencent/mm/plugin/appbrand/config/WxaExposedParams;Landroid/os/Bundle;Lcom/tencent/luggage/sdk/launching/ActivityStarterIpcDelegate;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(48740);
      return;
    }
  }
  
  private void bvp()
  {
    AppMethodBeat.i(48753);
    if (!bs.isNullOrNil(this.lhM))
    {
      ac.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "queryProfile start");
      bci localbci = new bci();
      localbci.username = this.lhM;
      b.a locala = new b.a();
      locala.funcId = 2921;
      locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getprofileinfo";
      locala.hvt = localbci;
      locala.hvu = new bcj();
      IPCRunCgi.a(locala.aAz(), new a(this));
    }
    AppMethodBeat.o(48753);
  }
  
  private void bvq()
  {
    AppMethodBeat.i(48754);
    if ((this.mcW != null) && (this.mcW.size() > 0))
    {
      this.mdp.setVisibility(0);
      this.mds.setVisibility(0);
      this.mdq.setVisibility(8);
      this.mdv.setIconGap(mcQ);
      this.mdv.setIconSize(mcP);
      this.mdv.setIconLayerCount(Math.min(this.mcW.size(), 3));
      if (this.mdF == null) {
        this.mdF = new com.tencent.mm.plugin.appbrand.ui.b.a(mcR);
      }
      if (this.mdG == null) {
        this.mdG = new com.tencent.mm.plugin.appbrand.ui.b.a(mcS);
      }
      int i = 0;
      if (i < this.mdv.getChildCount())
      {
        String str;
        label167:
        com.tencent.mm.modelappbrand.a.b localb;
        ImageView localImageView;
        if (this.mcW.size() > i)
        {
          str = ((ebh)this.mcW.get(i)).ugE;
          localb = com.tencent.mm.modelappbrand.a.b.aAS();
          localImageView = this.mdv.vk(i);
          if ((str != null) && (!str.startsWith("http"))) {
            break label226;
          }
        }
        label226:
        for (b.h localh = this.mdF;; localh = this.mdG)
        {
          localb.a(localImageView, str, 2131231875, localh);
          i += 1;
          break;
          str = null;
          break label167;
        }
      }
      if (this.mcV == 1) {
        if (this.mcT)
        {
          this.mdr.setText(getString(2131755595));
          if (!this.mcT) {
            break label419;
          }
          this.mdr.setCompoundDrawablesWithIntrinsicBounds(2131231003, 0, 0, 0);
          label283:
          if (this.mcV <= 3) {
            break label435;
          }
          this.mdt.setVisibility(0);
          this.mdu.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(48720);
              AppBrandProfileUI.h(AppBrandProfileUI.this);
              AppMethodBeat.o(48720);
            }
          });
        }
      }
    }
    for (;;)
    {
      this.mdq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(48721);
          AppBrandProfileUI.i(AppBrandProfileUI.this);
          AppMethodBeat.o(48721);
        }
      });
      this.mdr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(48722);
          AppBrandProfileUI.i(AppBrandProfileUI.this);
          AppMethodBeat.o(48722);
        }
      });
      AppMethodBeat.o(48754);
      return;
      this.mdr.setText(String.format(getString(2131755597), new Object[] { Integer.valueOf(this.mcV) }));
      break;
      this.mdr.setText(String.format(getString(2131755597), new Object[] { Integer.valueOf(this.mcV) }));
      break;
      label419:
      this.mdr.setCompoundDrawablesWithIntrinsicBounds(2131231002, 0, 0, 0);
      break label283;
      label435:
      this.mdt.setVisibility(8);
      this.mdu.setOnClickListener(null);
      continue;
      this.mdp.setVisibility(0);
      this.mdq.setVisibility(0);
      this.mds.setVisibility(8);
    }
  }
  
  private void cL(final View paramView)
  {
    AppMethodBeat.i(48756);
    if (paramView.getVisibility() == 0) {
      paramView.animate().setDuration(200L).alpha(0.0F).withEndAction(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(48723);
          paramView.setVisibility(8);
          AppMethodBeat.o(48723);
        }
      }).start();
    }
    AppMethodBeat.o(48756);
  }
  
  private void e(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(48751);
    if (this.lZJ == null) {}
    for (String str1 = null; bs.isNullOrNil(str1); str1 = this.lZJ.appId)
    {
      ac.e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "profileOperateReport appId null");
      AppMethodBeat.o(48751);
      return;
    }
    int j = getIntent().getIntExtra("key_from_scene", 3);
    String str2 = bs.nullAsNil(getIntent().getStringExtra("key_scene_note"));
    int i = 0;
    WxaAttributes localWxaAttributes = j.aVu().e(str1, new String[] { "appInfo", "brandIconURL", "nickname" });
    if (localWxaAttributes != null) {
      i = localWxaAttributes.baL().cFI;
    }
    i += 1000;
    ac.d("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "stev report(%s), appId %s, scene %s, sceneNote %s, eventId %s, result %s, appType %s", new Object[] { Integer.valueOf(13919), str1, Integer.valueOf(j), str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
    com.tencent.mm.plugin.report.service.h.wUl.f(13919, new Object[] { str1, Integer.valueOf(j), str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), Integer.valueOf(i) });
    this.mdA = j;
    AppMethodBeat.o(48751);
  }
  
  private static void e(View paramView, Runnable paramRunnable)
  {
    AppMethodBeat.i(48755);
    if (paramView.getVisibility() != 0)
    {
      paramView.setAlpha(0.0F);
      paramView.setVisibility(0);
    }
    paramView.animate().setDuration(200L).alpha(1.0F).withEndAction(paramRunnable).start();
    AppMethodBeat.o(48755);
  }
  
  private void eh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(48750);
    e(paramInt1, paramInt2, bs.aNx());
    AppMethodBeat.o(48750);
  }
  
  private void hy(final boolean paramBoolean)
  {
    AppMethodBeat.i(48752);
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48708);
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(48707);
            AppBrandProfileUI.a(AppBrandProfileUI.this, this.mdJ);
            if ((AppBrandProfileUI.4.this.mdI) && (!AppBrandProfileUI.this.isFinishing()) && (!AppBrandProfileUI.this.activityHasDestroyed()))
            {
              com.tencent.mm.plugin.appbrand.config.u.baJ().add(AppBrandProfileUI.this);
              AppBrandProfileUI.a(AppBrandProfileUI.this, 1, 1);
            }
            AppMethodBeat.o(48707);
          }
        });
        if (paramBoolean) {
          com.tencent.mm.plugin.appbrand.config.w.Kt(AppBrandProfileUI.d(AppBrandProfileUI.this));
        }
        AppMethodBeat.o(48708);
      }
    }, "AppBrandProfile");
    AppMethodBeat.o(48752);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(48748);
    if ((paramm.jRj == 3) && ((paramm.obj instanceof String)) && (!bs.isNullOrNil(this.lhM)) && (this.lhM.equals((String)paramm.obj))) {
      hy(false);
    }
    AppMethodBeat.o(48748);
  }
  
  public final void dealContentView(View paramView)
  {
    AppMethodBeat.i(48742);
    super.dealContentView(paramView);
    ScrollView localScrollView = new ScrollView(this);
    localScrollView.setVerticalScrollBarEnabled(false);
    localScrollView.setOverScrollMode(2);
    localScrollView.setBackgroundResource(2131100207);
    localScrollView.setFillViewport(true);
    this.lgv = new LinearLayout(this);
    this.lgv.setOrientation(1);
    this.lgv.setFocusable(true);
    this.lgv.setFocusableInTouchMode(true);
    localScrollView.addView(this.lgv, new FrameLayout.LayoutParams(-1, -1));
    ((FrameLayout)paramView).addView(localScrollView);
    AppMethodBeat.o(48742);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void initActivityCloseAnimation()
  {
    AppMethodBeat.i(48749);
    if (this.mdD)
    {
      AppMethodBeat.o(48749);
      return;
    }
    super.initActivityCloseAnimation();
    AppMethodBeat.o(48749);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(48744);
    if (Build.VERSION.SDK_INT >= 21) {
      super.finishAfterTransition();
    }
    for (;;)
    {
      eh(6, 1);
      AppMethodBeat.o(48744);
      return;
      super.finish();
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48741);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("key_username");
    this.lhM = paramBundle;
    if (bs.isNullOrNil(paramBundle))
    {
      finish();
      AppMethodBeat.o(48741);
      return;
    }
    if ((getIntent().getExtras() != null) && (!getIntent().getExtras().containsKey("key_extra_bundle"))) {
      getIntent().getExtras().putBundle("key_extra_bundle", Bundle.EMPTY);
    }
    getIntent().setExtrasClassLoader(getClassLoader());
    this.mdC = ((WxaExposedParams)getIntent().getParcelableExtra("key_scene_exposed_params"));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(48704);
        AppBrandProfileUI.this.onBackPressed();
        AppMethodBeat.o(48704);
        return true;
      }
    });
    addIconOptionMenu(0, 2131755815, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(48718);
        AppBrandProfileUI.a(AppBrandProfileUI.this);
        AppMethodBeat.o(48718);
        return true;
      }
    });
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getContext().getResources().getColor(2131099650));
    paramBundle = LayoutInflater.from(this).inflate(2131493031, this.lgv, true);
    paramBundle.setClickable(false);
    paramBundle.setLongClickable(false);
    this.mcX = ((ImageView)paramBundle.findViewById(2131303463));
    this.mcY = ((TextView)paramBundle.findViewById(2131303478));
    this.mcZ = ((TextView)paramBundle.findViewById(2131303457));
    this.mda = ((TextView)paramBundle.findViewById(2131303499));
    this.mdb = ((RatingBar)paramBundle.findViewById(2131303496));
    this.mdc = ((TextView)paramBundle.findViewById(2131303498));
    this.mdd = ((LinearLayout)paramBundle.findViewById(2131303497));
    this.maJ = ((ImageView)paramBundle.findViewById(2131303483));
    this.mdf = ((LinearLayout)paramBundle.findViewById(2131303493));
    this.mde = ((RecyclerView)paramBundle.findViewById(2131303494));
    this.mde.setItemAnimator(new android.support.v7.widget.v());
    Object localObject = new LinearLayoutManager();
    ((LinearLayoutManager)localObject).setOrientation(0);
    this.mde.setLayoutManager((RecyclerView.i)localObject);
    this.mde.a(new RecyclerView.h()
    {
      public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView, RecyclerView.t paramAnonymoust)
      {
        AppMethodBeat.i(48726);
        int i = com.tencent.mm.cc.a.au(AppBrandProfileUI.this, 2131165829);
        int j = com.tencent.mm.cc.a.au(AppBrandProfileUI.this, 2131165823);
        if (RecyclerView.bw(paramAnonymousView) == 0) {}
        for (paramAnonymousRect.left = i;; paramAnonymousRect.left = 0)
        {
          paramAnonymousRect.right = j;
          AppMethodBeat.o(48726);
          return;
        }
      }
    });
    this.mdg = ((LinearLayout)paramBundle.findViewById(2131303452));
    this.mdh = ((LinearLayout)paramBundle.findViewById(2131303450));
    this.mdi = ((TextView)paramBundle.findViewById(2131303454));
    this.mdj = ((AppBrandNearbyShowcaseView)paramBundle.findViewById(2131303455));
    this.mdj.setIconGap(mcM);
    this.mdj.setIconSize(mcL + mcN * 2);
    cL(this.mdh);
    this.mdk = ((LinearLayout)paramBundle.findViewById(2131303512));
    this.mdl = ((LinearLayout)paramBundle.findViewById(2131303511));
    this.mdm = ((TextView)paramBundle.findViewById(2131303513));
    this.mdn = ((AppBrandNearbyShowcaseView)paramBundle.findViewById(2131303514));
    this.mdn.setIconGap(mcM);
    this.mdn.setIconSize(mcL + mcN * 2);
    cL(this.mdl);
    this.mdp = ((FrameLayout)paramBundle.findViewById(2131303472));
    this.mdq = ((TextView)paramBundle.findViewById(2131303479));
    this.mdr = ((TextView)paramBundle.findViewById(2131303476));
    this.mdt = ((ImageView)paramBundle.findViewById(2131303469));
    this.mdv = ((AppBrandNearbyShowcaseView)paramBundle.findViewById(2131303473));
    this.mdu = ((LinearLayout)paramBundle.findViewById(2131303470));
    this.mds = ((LinearLayout)paramBundle.findViewById(2131303477));
    this.mdo = ((LinearLayout)paramBundle.findViewById(2131303460));
    this.mdo.setVisibility(0);
    this.mdo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(48727);
        if (AppBrandProfileUI.c(AppBrandProfileUI.this) == null)
        {
          ac.e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "wxaExposedParams is null");
          AppMethodBeat.o(48727);
          return;
        }
        Intent localIntent = new Intent();
        String str = com.tencent.mm.plugin.appbrand.u.a(AppBrandProfileUI.c(AppBrandProfileUI.this));
        ac.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "feedbackUrl:%s, wxaExposedParams:%s", new Object[] { str, AppBrandProfileUI.c(AppBrandProfileUI.this).toString() });
        localIntent.putExtra("title", paramAnonymousView.getContext().getString(2131755593));
        localIntent.putExtra("rawUrl", str);
        localIntent.putExtra("forceHideShare", true);
        d.b(AppBrandProfileUI.this, "webview", ".ui.tools.WebViewUI", localIntent);
        AppBrandProfileUI.a(AppBrandProfileUI.this, 20, 1);
        AppMethodBeat.o(48727);
      }
    });
    this.mdz = paramBundle.findViewById(2131306058);
    this.mdw = ((TextView)paramBundle.findViewById(2131303441));
    this.mdx = paramBundle.findViewById(2131303442);
    this.mdy = ((TextView)paramBundle.findViewById(2131303485));
    localObject = paramBundle.findViewById(2131303458);
    paramBundle = paramBundle.findViewById(2131303495);
    ((View)localObject).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(48724);
        AppBrandProfileUI.b(AppBrandProfileUI.this);
        AppMethodBeat.o(48724);
      }
    });
    paramBundle.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(48725);
        AppBrandProfileUI.a(AppBrandProfileUI.this, paramAnonymousView);
        AppMethodBeat.o(48725);
      }
    });
    mcO = getContext().getResources().getColor(2131100498);
    if (this.mdE == null) {
      this.mdE = new com.tencent.mm.plugin.appbrand.ui.widget.a(mcL, mcN, mcO);
    }
    hy(true);
    bvp();
    AppMethodBeat.o(48741);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(48747);
    super.onDestroy();
    com.tencent.mm.plugin.appbrand.config.u.baJ().remove(this);
    AppMethodBeat.o(48747);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(48743);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (!bs.isNullOrNil(this.lhM)) {
      com.tencent.mm.plugin.appbrand.config.u.baJ().remove(this);
    }
    paramIntent = getIntent().getStringExtra("key_username");
    this.lhM = paramIntent;
    if (bs.isNullOrNil(paramIntent))
    {
      finish();
      AppMethodBeat.o(48743);
      return;
    }
    hy(true);
    bvp();
    AppMethodBeat.o(48743);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(48746);
    super.onPause();
    s.a(this, new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(48746);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(48745);
    super.onResume();
    if (getSwipeBackLayout() != null) {
      getSwipeBackLayout().setEnableGesture(getIntent().getBooleanExtra("key_can_swipe_back", true));
    }
    s.a(this, new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(48745);
  }
  
  public final boolean onSwipeBackFinish()
  {
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    implements IPCRunCgi.a
  {
    WeakReference<AppBrandProfileUI> mdQ;
    
    public a(AppBrandProfileUI paramAppBrandProfileUI)
    {
      AppMethodBeat.i(48732);
      this.mdQ = new WeakReference(paramAppBrandProfileUI);
      AppMethodBeat.o(48732);
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(48733);
      if ((this.mdQ != null) && (this.mdQ.get() != null))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0) && (paramb != null) && (paramb.hvs.hvw != null) && ((paramb.hvs.hvw instanceof bcj)))
        {
          ac.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "queryProfile, request success");
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(48731);
              if ((AppBrandProfileUI.a.this.mdQ != null) && (AppBrandProfileUI.a.this.mdQ.get() != null)) {
                AppBrandProfileUI.a((AppBrandProfileUI)AppBrandProfileUI.a.this.mdQ.get(), this.mdR);
              }
              AppMethodBeat.o(48731);
            }
          });
          AppMethodBeat.o(48733);
          return;
        }
        ac.e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "queryProfile, request fail");
      }
      AppMethodBeat.o(48733);
    }
  }
  
  static final class b
    implements IPCRunCgi.a
  {
    WeakReference<AppBrandProfileUI> mdQ;
    
    public b(AppBrandProfileUI paramAppBrandProfileUI)
    {
      AppMethodBeat.i(48736);
      this.mdQ = new WeakReference(paramAppBrandProfileUI);
      AppMethodBeat.o(48736);
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(48737);
      if ((this.mdQ != null) && (this.mdQ.get() != null))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0) && (paramb != null) && (paramb.hvs.hvw != null) && ((paramb.hvs.hvw instanceof dmd)))
        {
          ac.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "cgiUpdateUserLike, request success");
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(48734);
              if ((AppBrandProfileUI.b.this.mdQ != null) && (AppBrandProfileUI.b.this.mdQ.get() != null))
              {
                AppBrandProfileUI localAppBrandProfileUI = (AppBrandProfileUI)AppBrandProfileUI.b.this.mdQ.get();
                if (AppBrandProfileUI.j(localAppBrandProfileUI))
                {
                  AppBrandProfileUI.k(localAppBrandProfileUI).removeFirst();
                  AppBrandProfileUI.l(localAppBrandProfileUI);
                  if (AppBrandProfileUI.j(localAppBrandProfileUI)) {
                    break label147;
                  }
                }
                label147:
                for (boolean bool = true;; bool = false)
                {
                  AppBrandProfileUI.a(localAppBrandProfileUI, bool);
                  AppBrandProfileUI.n(localAppBrandProfileUI);
                  if (!AppBrandProfileUI.o(localAppBrandProfileUI)) {
                    break label152;
                  }
                  AppBrandProfileUI.a(localAppBrandProfileUI, 17, 1);
                  AppMethodBeat.o(48734);
                  return;
                  ebh localebh = new ebh();
                  localebh.GgS = true;
                  localebh.ugE = c.zT(com.tencent.mm.model.u.axw());
                  localebh.nickname = com.tencent.mm.model.u.axy();
                  AppBrandProfileUI.k(localAppBrandProfileUI).addFirst(localebh);
                  AppBrandProfileUI.m(localAppBrandProfileUI);
                  break;
                }
                label152:
                AppBrandProfileUI.a(localAppBrandProfileUI, 18, 1);
              }
              AppMethodBeat.o(48734);
            }
          });
          AppMethodBeat.o(48737);
          return;
        }
        ac.e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "cgiUpdateUserLike, request fail");
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(48735);
            if ((AppBrandProfileUI.b.this.mdQ != null) && (AppBrandProfileUI.b.this.mdQ.get() != null))
            {
              AppBrandProfileUI localAppBrandProfileUI = (AppBrandProfileUI)AppBrandProfileUI.b.this.mdQ.get();
              if (AppBrandProfileUI.o(localAppBrandProfileUI))
              {
                Toast.makeText(localAppBrandProfileUI, 2131755594, 0).show();
                AppBrandProfileUI.a(localAppBrandProfileUI, 17, 2);
                AppMethodBeat.o(48735);
                return;
              }
              Toast.makeText(localAppBrandProfileUI, 2131755591, 0).show();
              AppBrandProfileUI.a(localAppBrandProfileUI, 18, 2);
            }
            AppMethodBeat.o(48735);
          }
        });
      }
      AppMethodBeat.o(48737);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI
 * JD-Core Version:    0.7.0.1
 */