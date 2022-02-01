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
import android.support.v7.widget.RecyclerView.s;
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
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.sb;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.protocal.protobuf.ayq;
import com.tencent.mm.protocal.protobuf.ayr;
import com.tencent.mm.protocal.protobuf.dgo;
import com.tencent.mm.protocal.protobuf.dvq;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.a.e;
import java.lang.ref.WeakReference;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class AppBrandProfileUI
  extends MMActivity
  implements k.a
{
  private static final int lAP;
  private static final int lAQ;
  private static final int lAR;
  private static int lAS;
  private static final int lAT;
  private static final int lAU;
  private static final int lAV;
  private static final int lAW;
  private LinearLayout kFc;
  private String kGt;
  private boolean lAX;
  private boolean lAY;
  private int lAZ;
  private TextView lBA;
  private View lBB;
  private TextView lBC;
  private View lBD;
  private int lBE;
  private e lBF;
  private WxaExposedParams lBG;
  private boolean lBH;
  private b.h lBI;
  private b.h lBJ;
  private b.h lBK;
  private LinkedList<dvq> lBa;
  private ImageView lBb;
  private TextView lBc;
  private TextView lBd;
  private TextView lBe;
  private RatingBar lBf;
  private TextView lBg;
  private LinearLayout lBh;
  private RecyclerView lBi;
  private LinearLayout lBj;
  private LinearLayout lBk;
  private LinearLayout lBl;
  private TextView lBm;
  private AppBrandNearbyShowcaseView lBn;
  private LinearLayout lBo;
  private LinearLayout lBp;
  private TextView lBq;
  private AppBrandNearbyShowcaseView lBr;
  private LinearLayout lBs;
  private FrameLayout lBt;
  private TextView lBu;
  private TextView lBv;
  private LinearLayout lBw;
  private ImageView lBx;
  private LinearLayout lBy;
  private AppBrandNearbyShowcaseView lBz;
  private aa lxP;
  private ImageView lyM;
  
  static
  {
    AppMethodBeat.i(48769);
    lAP = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 24);
    lAQ = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 20);
    lAR = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 2);
    lAS = -1;
    lAT = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 40);
    lAU = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 44);
    lAV = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 32);
    lAW = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 4);
    AppMethodBeat.o(48769);
  }
  
  public AppBrandProfileUI()
  {
    AppMethodBeat.i(48738);
    this.lAX = false;
    this.lAY = false;
    this.lAZ = 0;
    this.lBa = new LinkedList();
    this.lBH = false;
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
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(48740);
      return;
    }
    if (paramContext == null) {
      paramContext = aj.getContext();
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
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().bd(paramString1);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.adn(), "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI", "show", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;ZLcom/tencent/mm/plugin/appbrand/config/WxaExposedParams;Landroid/os/Bundle;Lcom/tencent/luggage/sdk/launching/ActivityStarterIpcDelegate;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI", "show", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;ZLcom/tencent/mm/plugin/appbrand/config/WxaExposedParams;Landroid/os/Bundle;Lcom/tencent/luggage/sdk/launching/ActivityStarterIpcDelegate;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(48740);
      return;
    }
  }
  
  private void bot()
  {
    AppMethodBeat.i(48753);
    if (!bt.isNullOrNil(this.kGt))
    {
      ad.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "queryProfile start");
      ayq localayq = new ayq();
      localayq.username = this.kGt;
      b.a locala = new b.a();
      locala.funcId = 2921;
      locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getprofileinfo";
      locala.gUU = localayq;
      locala.gUV = new ayr();
      IPCRunCgi.a(locala.atI(), new a(this));
    }
    AppMethodBeat.o(48753);
  }
  
  private void bou()
  {
    AppMethodBeat.i(48754);
    if ((this.lBa != null) && (this.lBa.size() > 0))
    {
      this.lBt.setVisibility(0);
      this.lBw.setVisibility(0);
      this.lBu.setVisibility(8);
      this.lBz.setIconGap(lAU);
      this.lBz.setIconSize(lAT);
      this.lBz.setIconLayerCount(Math.min(this.lBa.size(), 3));
      if (this.lBJ == null) {
        this.lBJ = new com.tencent.mm.plugin.appbrand.ui.b.a(lAV);
      }
      if (this.lBK == null) {
        this.lBK = new com.tencent.mm.plugin.appbrand.ui.b.a(lAW);
      }
      int i = 0;
      if (i < this.lBz.getChildCount())
      {
        String str;
        label167:
        com.tencent.mm.modelappbrand.a.b localb;
        ImageView localImageView;
        if (this.lBa.size() > i)
        {
          str = ((dvq)this.lBa.get(i)).sYq;
          localb = com.tencent.mm.modelappbrand.a.b.aub();
          localImageView = this.lBz.us(i);
          if ((str != null) && (!str.startsWith("http"))) {
            break label226;
          }
        }
        label226:
        for (b.h localh = this.lBJ;; localh = this.lBK)
        {
          localb.a(localImageView, str, 2131231875, localh);
          i += 1;
          break;
          str = null;
          break label167;
        }
      }
      if (this.lAZ == 1) {
        if (this.lAX)
        {
          this.lBv.setText(getString(2131755595));
          if (!this.lAX) {
            break label419;
          }
          this.lBv.setCompoundDrawablesWithIntrinsicBounds(2131231003, 0, 0, 0);
          label283:
          if (this.lAZ <= 3) {
            break label435;
          }
          this.lBx.setVisibility(0);
          this.lBy.setOnClickListener(new View.OnClickListener()
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
      this.lBu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(48721);
          AppBrandProfileUI.i(AppBrandProfileUI.this);
          AppMethodBeat.o(48721);
        }
      });
      this.lBv.setOnClickListener(new View.OnClickListener()
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
      this.lBv.setText(String.format(getString(2131755597), new Object[] { Integer.valueOf(this.lAZ) }));
      break;
      this.lBv.setText(String.format(getString(2131755597), new Object[] { Integer.valueOf(this.lAZ) }));
      break;
      label419:
      this.lBv.setCompoundDrawablesWithIntrinsicBounds(2131231002, 0, 0, 0);
      break label283;
      label435:
      this.lBx.setVisibility(8);
      this.lBy.setOnClickListener(null);
      continue;
      this.lBt.setVisibility(0);
      this.lBu.setVisibility(0);
      this.lBw.setVisibility(8);
    }
  }
  
  private static void c(View paramView, Runnable paramRunnable)
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
  
  private void cJ(final View paramView)
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
    if (this.lxP == null) {}
    for (String str1 = null; bt.isNullOrNil(str1); str1 = this.lxP.appId)
    {
      ad.e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "profileOperateReport appId null");
      AppMethodBeat.o(48751);
      return;
    }
    int j = getIntent().getIntExtra("key_from_scene", 3);
    String str2 = bt.nullAsNil(getIntent().getStringExtra("key_scene_note"));
    int i = 0;
    WxaAttributes localWxaAttributes = j.aOC().e(str1, new String[] { "appInfo", "brandIconURL", "nickname" });
    if (localWxaAttributes != null) {
      i = localWxaAttributes.aTN().cIB;
    }
    i += 1000;
    ad.d("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "stev report(%s), appId %s, scene %s, sceneNote %s, eventId %s, result %s, appType %s", new Object[] { Integer.valueOf(13919), str1, Integer.valueOf(j), str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
    com.tencent.mm.plugin.report.service.h.vKh.f(13919, new Object[] { str1, Integer.valueOf(j), str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), Integer.valueOf(i) });
    this.lBE = j;
    AppMethodBeat.o(48751);
  }
  
  private void ef(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(48750);
    e(paramInt1, paramInt2, bt.aGK());
    AppMethodBeat.o(48750);
  }
  
  private void hb(final boolean paramBoolean)
  {
    AppMethodBeat.i(48752);
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48708);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(48707);
            AppBrandProfileUI.a(AppBrandProfileUI.this, this.lBN);
            if ((AppBrandProfileUI.4.this.lBM) && (!AppBrandProfileUI.this.isFinishing()) && (!AppBrandProfileUI.this.activityHasDestroyed())) {
              com.tencent.mm.plugin.appbrand.config.u.aTL().add(AppBrandProfileUI.this);
            }
            AppMethodBeat.o(48707);
          }
        });
        if (paramBoolean) {
          com.tencent.mm.plugin.appbrand.config.w.Gp(AppBrandProfileUI.d(AppBrandProfileUI.this));
        }
        AppMethodBeat.o(48708);
      }
    }, "AppBrandProfile");
    AppMethodBeat.o(48752);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(48748);
    if ((paramm.jqR == 3) && ((paramm.obj instanceof String)) && (!bt.isNullOrNil(this.kGt)) && (this.kGt.equals((String)paramm.obj))) {
      hb(false);
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
    this.kFc = new LinearLayout(this);
    this.kFc.setOrientation(1);
    this.kFc.setFocusable(true);
    this.kFc.setFocusableInTouchMode(true);
    localScrollView.addView(this.kFc, new FrameLayout.LayoutParams(-1, -1));
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
    if (this.lBH)
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
      ef(6, 1);
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
    this.kGt = paramBundle;
    if (bt.isNullOrNil(paramBundle))
    {
      finish();
      AppMethodBeat.o(48741);
      return;
    }
    if ((getIntent().getExtras() != null) && (!getIntent().getExtras().containsKey("key_extra_bundle"))) {
      getIntent().getExtras().putBundle("key_extra_bundle", Bundle.EMPTY);
    }
    getIntent().setExtrasClassLoader(getClassLoader());
    this.lBG = ((WxaExposedParams)getIntent().getParcelableExtra("key_scene_exposed_params"));
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
    paramBundle = LayoutInflater.from(this).inflate(2131493031, this.kFc, true);
    paramBundle.setClickable(false);
    paramBundle.setLongClickable(false);
    this.lBb = ((ImageView)paramBundle.findViewById(2131303463));
    this.lBc = ((TextView)paramBundle.findViewById(2131303478));
    this.lBd = ((TextView)paramBundle.findViewById(2131303457));
    this.lBe = ((TextView)paramBundle.findViewById(2131303499));
    this.lBf = ((RatingBar)paramBundle.findViewById(2131303496));
    this.lBg = ((TextView)paramBundle.findViewById(2131303498));
    this.lBh = ((LinearLayout)paramBundle.findViewById(2131303497));
    this.lyM = ((ImageView)paramBundle.findViewById(2131303483));
    this.lBj = ((LinearLayout)paramBundle.findViewById(2131303493));
    this.lBi = ((RecyclerView)paramBundle.findViewById(2131303494));
    this.lBi.setItemAnimator(new android.support.v7.widget.v());
    Object localObject = new LinearLayoutManager();
    ((LinearLayoutManager)localObject).setOrientation(0);
    this.lBi.setLayoutManager((RecyclerView.i)localObject);
    this.lBi.a(new RecyclerView.h()
    {
      public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView, RecyclerView.s paramAnonymouss)
      {
        AppMethodBeat.i(48726);
        int i = com.tencent.mm.cd.a.ao(AppBrandProfileUI.this, 2131165829);
        int j = com.tencent.mm.cd.a.ao(AppBrandProfileUI.this, 2131165823);
        if (RecyclerView.bw(paramAnonymousView) == 0) {}
        for (paramAnonymousRect.left = i;; paramAnonymousRect.left = 0)
        {
          paramAnonymousRect.right = j;
          AppMethodBeat.o(48726);
          return;
        }
      }
    });
    this.lBk = ((LinearLayout)paramBundle.findViewById(2131303452));
    this.lBl = ((LinearLayout)paramBundle.findViewById(2131303450));
    this.lBm = ((TextView)paramBundle.findViewById(2131303454));
    this.lBn = ((AppBrandNearbyShowcaseView)paramBundle.findViewById(2131303455));
    this.lBn.setIconGap(lAQ);
    this.lBn.setIconSize(lAP + lAR * 2);
    cJ(this.lBl);
    this.lBo = ((LinearLayout)paramBundle.findViewById(2131303512));
    this.lBp = ((LinearLayout)paramBundle.findViewById(2131303511));
    this.lBq = ((TextView)paramBundle.findViewById(2131303513));
    this.lBr = ((AppBrandNearbyShowcaseView)paramBundle.findViewById(2131303514));
    this.lBr.setIconGap(lAQ);
    this.lBr.setIconSize(lAP + lAR * 2);
    cJ(this.lBp);
    this.lBt = ((FrameLayout)paramBundle.findViewById(2131303472));
    this.lBu = ((TextView)paramBundle.findViewById(2131303479));
    this.lBv = ((TextView)paramBundle.findViewById(2131303476));
    this.lBx = ((ImageView)paramBundle.findViewById(2131303469));
    this.lBz = ((AppBrandNearbyShowcaseView)paramBundle.findViewById(2131303473));
    this.lBy = ((LinearLayout)paramBundle.findViewById(2131303470));
    this.lBw = ((LinearLayout)paramBundle.findViewById(2131303477));
    this.lBs = ((LinearLayout)paramBundle.findViewById(2131303460));
    this.lBs.setVisibility(0);
    this.lBs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(48727);
        if (AppBrandProfileUI.c(AppBrandProfileUI.this) == null)
        {
          ad.e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "wxaExposedParams is null");
          AppMethodBeat.o(48727);
          return;
        }
        Intent localIntent = new Intent();
        String str = com.tencent.mm.plugin.appbrand.u.a(AppBrandProfileUI.c(AppBrandProfileUI.this));
        ad.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "feedbackUrl:%s, wxaExposedParams:%s", new Object[] { str, AppBrandProfileUI.c(AppBrandProfileUI.this).toString() });
        localIntent.putExtra("title", paramAnonymousView.getContext().getString(2131755593));
        localIntent.putExtra("rawUrl", str);
        localIntent.putExtra("forceHideShare", true);
        d.b(AppBrandProfileUI.this, "webview", ".ui.tools.WebViewUI", localIntent);
        AppBrandProfileUI.a(AppBrandProfileUI.this, 20, 1);
        AppMethodBeat.o(48727);
      }
    });
    this.lBD = paramBundle.findViewById(2131306058);
    this.lBA = ((TextView)paramBundle.findViewById(2131303441));
    this.lBB = paramBundle.findViewById(2131303442);
    this.lBC = ((TextView)paramBundle.findViewById(2131303485));
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
    lAS = getContext().getResources().getColor(2131100498);
    if (this.lBI == null) {
      this.lBI = new com.tencent.mm.plugin.appbrand.ui.widget.a(lAP, lAR, lAS);
    }
    hb(true);
    bot();
    ef(1, 1);
    AppMethodBeat.o(48741);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(48747);
    super.onDestroy();
    com.tencent.mm.plugin.appbrand.config.u.aTL().remove(this);
    AppMethodBeat.o(48747);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(48743);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (!bt.isNullOrNil(this.kGt)) {
      com.tencent.mm.plugin.appbrand.config.u.aTL().remove(this);
    }
    paramIntent = getIntent().getStringExtra("key_username");
    this.kGt = paramIntent;
    if (bt.isNullOrNil(paramIntent))
    {
      finish();
      AppMethodBeat.o(48743);
      return;
    }
    hb(true);
    bot();
    ef(1, 1);
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
    WeakReference<AppBrandProfileUI> lBU;
    
    public a(AppBrandProfileUI paramAppBrandProfileUI)
    {
      AppMethodBeat.i(48732);
      this.lBU = new WeakReference(paramAppBrandProfileUI);
      AppMethodBeat.o(48732);
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.b paramb)
    {
      AppMethodBeat.i(48733);
      if ((this.lBU != null) && (this.lBU.get() != null))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0) && (paramb != null) && (paramb.gUT.gUX != null) && ((paramb.gUT.gUX instanceof ayr)))
        {
          ad.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "queryProfile, request success");
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(48731);
              if ((AppBrandProfileUI.a.this.lBU != null) && (AppBrandProfileUI.a.this.lBU.get() != null)) {
                AppBrandProfileUI.a((AppBrandProfileUI)AppBrandProfileUI.a.this.lBU.get(), this.lBV);
              }
              AppMethodBeat.o(48731);
            }
          });
          AppMethodBeat.o(48733);
          return;
        }
        ad.e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "queryProfile, request fail");
      }
      AppMethodBeat.o(48733);
    }
  }
  
  static final class b
    implements IPCRunCgi.a
  {
    WeakReference<AppBrandProfileUI> lBU;
    
    public b(AppBrandProfileUI paramAppBrandProfileUI)
    {
      AppMethodBeat.i(48736);
      this.lBU = new WeakReference(paramAppBrandProfileUI);
      AppMethodBeat.o(48736);
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.b paramb)
    {
      AppMethodBeat.i(48737);
      if ((this.lBU != null) && (this.lBU.get() != null))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0) && (paramb != null) && (paramb.gUT.gUX != null) && ((paramb.gUT.gUX instanceof dgo)))
        {
          ad.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "cgiUpdateUserLike, request success");
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(48734);
              if ((AppBrandProfileUI.b.this.lBU != null) && (AppBrandProfileUI.b.this.lBU.get() != null))
              {
                AppBrandProfileUI localAppBrandProfileUI = (AppBrandProfileUI)AppBrandProfileUI.b.this.lBU.get();
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
                  dvq localdvq = new dvq();
                  localdvq.EJG = true;
                  localdvq.sYq = c.vN(com.tencent.mm.model.u.aqG());
                  localdvq.nickname = com.tencent.mm.model.u.aqI();
                  AppBrandProfileUI.k(localAppBrandProfileUI).addFirst(localdvq);
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
        ad.e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "cgiUpdateUserLike, request fail");
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(48735);
            if ((AppBrandProfileUI.b.this.lBU != null) && (AppBrandProfileUI.b.this.lBU.get() != null))
            {
              AppBrandProfileUI localAppBrandProfileUI = (AppBrandProfileUI)AppBrandProfileUI.b.this.lBU.get();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI
 * JD-Core Version:    0.7.0.1
 */