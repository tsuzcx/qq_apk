package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.cp.g;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.h;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.ad;
import com.tencent.mm.plugin.appbrand.config.ag;
import com.tencent.mm.plugin.appbrand.config.al;
import com.tencent.mm.plugin.appbrand.jsapi.share.y;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.protocal.protobuf.cqb;
import com.tencent.mm.protocal.protobuf.cqc;
import com.tencent.mm.protocal.protobuf.gmf;
import com.tencent.mm.protocal.protobuf.gmg;
import com.tencent.mm.protocal.protobuf.gmh;
import com.tencent.mm.protocal.protobuf.gmi;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.h.d;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class AppBrandProfileUI
  extends MMActivity
  implements MStorage.IOnStorageChange
{
  private static final int udv;
  private static final int udw;
  private static final int udx;
  private static int udy;
  private int lCR;
  private LinearLayout mContainer;
  private String qgV;
  private String sWX;
  private al tXF;
  private WxaExposedParams ucN;
  private String ucO;
  private String ucP;
  private String ucQ;
  private int ucR;
  private com.tencent.mm.ui.widget.a.f ucS;
  private ConstraintLayout ucT;
  private ImageView ucU;
  private TextView ucV;
  private LinearLayout ucW;
  private Button ucX;
  private TextView ucY;
  private TextView ucZ;
  private FrameLayout uda;
  private TextView udb;
  private LinearLayout udc;
  private TextView udd;
  private RatingBar ude;
  private LinearLayout udf;
  private LinearLayout udg;
  private TextView udh;
  private AppBrandNearbyShowcaseView udi;
  private LinearLayout udj;
  private LinearLayout udk;
  private TextView udl;
  private AppBrandNearbyShowcaseView udm;
  private TextView udn;
  private View udo;
  private TextView udp;
  private TextView udq;
  private boolean udr;
  private boolean uds;
  private boolean udt;
  private final Runnable udu;
  private b.h udz;
  
  static
  {
    AppMethodBeat.i(48769);
    udv = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 24);
    udw = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 20);
    udx = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 2);
    udy = -1;
    AppMethodBeat.o(48769);
  }
  
  public AppBrandProfileUI()
  {
    AppMethodBeat.i(48738);
    this.qgV = "";
    this.ucO = "";
    this.ucP = "";
    this.ucQ = "";
    this.ucR = 0;
    this.udr = false;
    this.udu = new AppBrandProfileUI.9(this);
    AppMethodBeat.o(48738);
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong, y paramy)
  {
    AppMethodBeat.i(322758);
    if (this.tXF == null) {}
    for (String str1 = null; Util.isNullOrNil(str1); str1 = this.tXF.appId)
    {
      Log.e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "profileOperateReport appId null");
      AppMethodBeat.o(322758);
      return;
    }
    int j = getIntent().getIntExtra("key_from_scene", 3);
    String str3 = Util.nullAsNil(getIntent().getStringExtra("key_scene_note"));
    int i = 0;
    Object localObject = n.cfc().e(str1, new String[] { "appInfo", "brandIconURL", "nickname" });
    if (localObject != null) {
      i = ((WxaAttributes)localObject).cld().serviceType;
    }
    int k = i + 1000;
    label146:
    String str2;
    label155:
    String str4;
    if (paramy == null)
    {
      localObject = "";
      if (paramy != null) {
        break label430;
      }
      i = 0;
      if (paramy != null) {
        break label440;
      }
      str2 = "";
      str4 = Util.nullAsNil(str2);
      if (paramy != null) {
        break label450;
      }
      str2 = "";
      label171:
      str2 = URLEncoder.encode(Util.nullAsNil(str2));
      if (paramy != null) {
        break label460;
      }
    }
    label430:
    label440:
    label450:
    label460:
    for (paramy = "";; paramy = paramy.svI)
    {
      paramy = URLEncoder.encode(Util.nullAsNil(paramy));
      int m = this.ucR;
      Log.d("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "stev report(%s), appId %s, scene %s, sceneNote %s, eventId %s, result %s, appType %s,shareActionId:%s, shareActionType:%d, shareTitle:%s, sharePath:%s, shareImgUrl:%s, shopGuaranteeInfo:%d", new Object[] { Integer.valueOf(13919), str1, Integer.valueOf(j), str3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(k), localObject, Integer.valueOf(i), str4, str2, paramy, Integer.valueOf(m) });
      com.tencent.mm.plugin.report.service.h.OAn.b(13919, new Object[] { str1, Integer.valueOf(j), str3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), Integer.valueOf(k), localObject, Integer.valueOf(i), str4, str2, paramy, Integer.valueOf(m) });
      AppMethodBeat.o(322758);
      return;
      localObject = paramy.hzD;
      break;
      i = paramy.svF;
      break label146;
      str2 = paramy.svG;
      break label155;
      str2 = paramy.svH;
      break label171;
    }
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2, WxaExposedParams paramWxaExposedParams, Bundle paramBundle)
  {
    AppMethodBeat.i(48739);
    a(paramContext, paramString1, paramInt, paramString2, true, paramWxaExposedParams, paramBundle, null);
    AppMethodBeat.o(48739);
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2, boolean paramBoolean, WxaExposedParams paramWxaExposedParams, Bundle paramBundle, ActivityStarterIpcDelegate paramActivityStarterIpcDelegate)
  {
    AppMethodBeat.i(322696);
    a(paramContext, paramString1, paramInt, paramString2, paramBoolean, paramWxaExposedParams, paramBundle, paramActivityStarterIpcDelegate, -1);
    AppMethodBeat.o(322696);
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt1, String paramString2, boolean paramBoolean, WxaExposedParams paramWxaExposedParams, Bundle paramBundle, ActivityStarterIpcDelegate paramActivityStarterIpcDelegate, int paramInt2)
  {
    AppMethodBeat.i(322700);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(322700);
      return;
    }
    if (paramContext == null) {
      paramContext = MMApplicationContext.getContext();
    }
    for (;;)
    {
      paramString1 = new Intent(paramContext, AppBrandProfileUI.class).putExtra("key_username", paramString1).putExtra("key_from_scene", paramInt1).putExtra("key_scene_note", paramString2).putExtra("key_can_swipe_back", paramBoolean).putExtra("key_scene_exposed_params", paramWxaExposedParams).putExtra("key_extra_bundle", paramBundle);
      if (paramWxaExposedParams != null)
      {
        paramString2 = new Bundle();
        paramString2.putInt("stat_scene", 6);
        paramString2.putString("stat_app_id", paramWxaExposedParams.appId);
        paramString2.putString("stat_url", paramWxaExposedParams.hUf);
        paramString1.putExtra("_stat_obj", paramString2);
      }
      paramString1.putExtra("KEY_DELEGATED_ACTIVITY_STARTER", paramActivityStarterIpcDelegate);
      if (!(paramContext instanceof Activity)) {
        paramString1.addFlags(268435456);
      }
      if (((paramContext instanceof Activity)) && (paramInt2 >= 0))
      {
        com.tencent.mm.hellhoundlib.a.a.a((Activity)paramContext, com.tencent.mm.hellhoundlib.b.c.a(paramInt2, new com.tencent.mm.hellhoundlib.b.a()).cG(paramString1).aYi(), "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI", "show", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;ZLcom/tencent/mm/plugin/appbrand/config/WxaExposedParams;Landroid/os/Bundle;Lcom/tencent/luggage/sdk/launching/ActivityStarterIpcDelegate;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
        AppMethodBeat.o(322700);
        return;
      }
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().cG(paramString1);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aYi(), "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI", "show", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;ZLcom/tencent/mm/plugin/appbrand/config/WxaExposedParams;Landroid/os/Bundle;Lcom/tencent/luggage/sdk/launching/ActivityStarterIpcDelegate;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI", "show", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;ZLcom/tencent/mm/plugin/appbrand/config/WxaExposedParams;Landroid/os/Bundle;Lcom/tencent/luggage/sdk/launching/ActivityStarterIpcDelegate;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(322700);
      return;
    }
  }
  
  private void a(gmg paramgmg)
  {
    AppMethodBeat.i(322725);
    if (this.udf == null)
    {
      AppMethodBeat.o(322725);
      return;
    }
    if ((paramgmg == null) || (paramgmg.achu == null) || (paramgmg.achu.isEmpty()))
    {
      this.udf.setVisibility(8);
      AppMethodBeat.o(322725);
      return;
    }
    this.udf.setVisibility(0);
    this.udi.setIconLayerCount(Math.min(paramgmg.achu.size(), 3));
    if (this.udz == null) {
      this.udz = new com.tencent.mm.plugin.appbrand.ui.widget.a(udv, udx, udy);
    }
    final boolean bool;
    int i;
    label135:
    com.tencent.mm.modelappbrand.a.b localb;
    ImageView localImageView;
    if (this.udg.getVisibility() != 0)
    {
      bool = true;
      if (bool) {
        this.udi.cOH();
      }
      i = 0;
      if (i >= this.udi.getChildCount()) {
        break label223;
      }
      localb = com.tencent.mm.modelappbrand.a.b.bEY();
      localImageView = this.udi.DS(i);
      if (paramgmg.achu.size() <= i) {
        break label217;
      }
    }
    label217:
    for (String str = ((gmf)paramgmg.achu.get(i)).icon_url;; str = null)
    {
      localb.a(localImageView, str, com.tencent.mm.modelappbrand.a.a.bEX(), this.udz);
      i += 1;
      break label135;
      bool = false;
      break;
    }
    label223:
    if (paramgmg.achu.size() == 1) {
      if (!Util.isNullOrNil(((gmf)paramgmg.achu.get(0)).title))
      {
        this.udh.setVisibility(0);
        this.udh.setText(((gmf)paramgmg.achu.get(0)).title);
      }
    }
    for (;;)
    {
      this.udf.setOnClickListener(new AppBrandProfileUI.13(this, paramgmg));
      g(this.udg, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(322579);
          if ((bool) && (AppBrandProfileUI.t(AppBrandProfileUI.this) != null)) {
            AppBrandProfileUI.t(AppBrandProfileUI.this).cOI();
          }
          AppMethodBeat.o(322579);
        }
      });
      AppMethodBeat.o(322725);
      return;
      this.udh.setVisibility(8);
      continue;
      this.udh.setVisibility(8);
    }
  }
  
  private void a(String paramString, AppBrandProfileUI.c paramc)
  {
    AppMethodBeat.i(322730);
    if (this.udj == null)
    {
      AppMethodBeat.o(322730);
      return;
    }
    int i = paramc.size();
    if (1 >= i)
    {
      this.udj.setVisibility(8);
      AppMethodBeat.o(322730);
      return;
    }
    this.udj.setVisibility(0);
    this.udm.setIconLayerCount(Math.min(i, 3));
    if (this.udz == null) {
      this.udz = new com.tencent.mm.plugin.appbrand.ui.widget.a(udv, udx, udy);
    }
    final boolean bool;
    label120:
    int j;
    label153:
    int m;
    if (this.udk.getVisibility() != 0)
    {
      bool = true;
      if (bool) {
        this.udm.cOH();
      }
      i = 0;
      if (i >= this.udm.getChildCount()) {
        break label302;
      }
      if (i >= paramc.size()) {
        break label296;
      }
      localObject = paramc.udQ.iterator();
      j = 0;
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          gmi localgmi = (gmi)((Iterator)localObject).next();
          if ((localgmi != null) && (localgmi.achw != null) && (!localgmi.achw.isEmpty()))
          {
            int k = i - j;
            m = localgmi.achw.size();
            if (k < m)
            {
              localObject = (gmh)localgmi.achw.get(k);
              label237:
              if (localObject == null) {
                break label352;
              }
            }
          }
        }
      }
    }
    label296:
    label302:
    label352:
    for (Object localObject = ((gmh)localObject).icon_url;; localObject = null)
    {
      com.tencent.mm.modelappbrand.a.b.bEY().a(this.udm.DS(i), (String)localObject, com.tencent.mm.modelappbrand.a.a.bEX(), this.udz);
      i += 1;
      break label120;
      bool = false;
      break;
      j += m;
      break label153;
      localObject = null;
      break label237;
      this.udl.setVisibility(8);
      this.udj.setOnClickListener(new AppBrandProfileUI.15(this, paramc, paramString));
      g(this.udk, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(322595);
          if ((bool) && (AppBrandProfileUI.u(AppBrandProfileUI.this) != null)) {
            AppBrandProfileUI.u(AppBrandProfileUI.this).cOI();
          }
          AppMethodBeat.o(322595);
        }
      });
      AppMethodBeat.o(322730);
      return;
    }
  }
  
  private void agg(String paramString)
  {
    AppMethodBeat.i(322704);
    Object localObject = getIntent();
    if (localObject == null)
    {
      AppMethodBeat.o(322704);
      return;
    }
    localObject = ((Intent)localObject).getExtras();
    if (localObject == null)
    {
      AppMethodBeat.o(322704);
      return;
    }
    if (((Bundle)localObject).containsKey("key_from_scene")) {
      this.lCR = ((Bundle)localObject).getInt("key_from_scene");
    }
    Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "%s, fromScene: %d", new Object[] { paramString, Integer.valueOf(this.lCR) });
    AppMethodBeat.o(322704);
  }
  
  private void cLm()
  {
    AppMethodBeat.i(322717);
    MMHandlerThread.removeRunnable(this.udu);
    MMHandlerThread.postToMainThread(this.udu);
    AppMethodBeat.o(322717);
  }
  
  private void cLn()
  {
    AppMethodBeat.i(48753);
    if (!Util.isNullOrNil(this.sWX))
    {
      Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "queryProfile start");
      cqb localcqb = new cqb();
      localcqb.username = this.sWX;
      localcqb.aaww = LocaleUtil.getApplicationLanguage();
      c.a locala = new c.a();
      locala.funcId = 2921;
      locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getprofileinfo";
      locala.otE = localcqb;
      locala.otF = new cqc();
      IPCRunCgi.a(locala.bEF(), new b(this));
    }
    AppMethodBeat.o(48753);
  }
  
  private void dK(final View paramView)
  {
    AppMethodBeat.i(48756);
    if (paramView.getVisibility() == 0) {
      paramView.animate().setDuration(200L).alpha(0.0F).withEndAction(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(322581);
          paramView.setVisibility(8);
          AppMethodBeat.o(322581);
        }
      }).start();
    }
    AppMethodBeat.o(48756);
  }
  
  private void fP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(48750);
    a(paramInt1, paramInt2, Util.nowSecond(), null);
    AppMethodBeat.o(48750);
  }
  
  private static void g(View paramView, Runnable paramRunnable)
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
  
  private void kU(final boolean paramBoolean)
  {
    AppMethodBeat.i(48752);
    g.jPX().a(this).h(new com.tencent.mm.vending.c.a() {}).a(d.UI, new d.b() {});
    AppMethodBeat.o(48752);
  }
  
  private void kV(boolean paramBoolean)
  {
    AppMethodBeat.i(322712);
    this.udt = paramBoolean;
    cLm();
    AppMethodBeat.o(322712);
  }
  
  private void kW(boolean paramBoolean)
  {
    AppMethodBeat.i(322714);
    this.uds = paramBoolean;
    cLm();
    AppMethodBeat.o(322714);
  }
  
  public final boolean convertActivityFromTranslucent()
  {
    AppMethodBeat.i(322993);
    boolean bool = getIntent().getBooleanExtra("key_can_swipe_back", true);
    AppMethodBeat.o(322993);
    return bool;
  }
  
  public final void dealContentView(View paramView)
  {
    AppMethodBeat.i(48742);
    super.dealContentView(paramView);
    ScrollView localScrollView = new ScrollView(this);
    localScrollView.setVerticalScrollBarEnabled(false);
    localScrollView.setOverScrollMode(2);
    localScrollView.setBackgroundResource(ba.c.default_background_color);
    localScrollView.setFillViewport(true);
    this.mContainer = new LinearLayout(this);
    this.mContainer.setOrientation(1);
    this.mContainer.setFocusable(true);
    this.mContainer.setFocusableInTouchMode(true);
    localScrollView.addView(this.mContainer, new FrameLayout.LayoutParams(-1, -1));
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
    if (this.udr)
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
    super.finishAfterTransition();
    fP(6, 1);
    AppMethodBeat.o(48744);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(323035);
    super.onConfigurationChanged(paramConfiguration);
    cLm();
    AppMethodBeat.o(323035);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48741);
    agg("onCreate");
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("key_username");
    this.sWX = paramBundle;
    if (Util.isNullOrNil(paramBundle))
    {
      finish();
      AppMethodBeat.o(48741);
      return;
    }
    if ((getIntent().getExtras() != null) && (!getIntent().getExtras().containsKey("key_extra_bundle"))) {
      getIntent().getExtras().putBundle("key_extra_bundle", Bundle.EMPTY);
    }
    getIntent().setExtrasClassLoader(getClassLoader());
    this.ucN = ((WxaExposedParams)getIntent().getParcelableExtra("key_scene_exposed_params"));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(322514);
        AppBrandProfileUI.this.onBackPressed();
        AppMethodBeat.o(322514);
        return true;
      }
    });
    addIconOptionMenu(0, ba.i.app_more, ba.h.icons_outlined_more, new AppBrandProfileUI.19(this));
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getContext().getResources().getColor(ba.c.BG_2));
    paramBundle = LayoutInflater.from(this).inflate(ba.g.app_brand_profile_ui_header, this.mContainer, true);
    paramBundle.setClickable(false);
    paramBundle.setLongClickable(false);
    this.ucT = ((ConstraintLayout)paramBundle.findViewById(ba.f.profile_brief_area));
    this.ucU = ((ImageView)paramBundle.findViewById(ba.f.profile_icon));
    this.ucV = ((TextView)paramBundle.findViewById(ba.f.profile_name));
    this.ucW = ((LinearLayout)paramBundle.findViewById(ba.f.profile_button_area));
    this.ucX = ((Button)paramBundle.findViewById(ba.f.profile_enter_contact));
    this.ucX.setOnClickListener(new AppBrandProfileUI.20(this));
    paramBundle.findViewById(ba.f.profile_enter_app).setOnClickListener(new AppBrandProfileUI.21(this));
    this.ucY = ((TextView)paramBundle.findViewById(ba.f.profile_description));
    this.ucZ = ((TextView)paramBundle.findViewById(ba.f.subject_info_content));
    this.uda = ((FrameLayout)paramBundle.findViewById(ba.f.profile_star_layout_container));
    this.udb = ((TextView)paramBundle.findViewById(ba.f.profile_star_not_enough));
    this.udc = ((LinearLayout)paramBundle.findViewById(ba.f.profile_star_layout));
    this.udd = ((TextView)paramBundle.findViewById(ba.f.profile_star_text));
    this.ude = ((RatingBar)paramBundle.findViewById(ba.f.profile_star_bar));
    ((LinearLayout)paramBundle.findViewById(ba.f.more_info_layout)).setOnClickListener(new AppBrandProfileUI.22(this));
    this.udf = ((LinearLayout)paramBundle.findViewById(ba.f.profile_biz_layout));
    this.udg = ((LinearLayout)paramBundle.findViewById(ba.f.profile_biz_container));
    this.udh = ((TextView)paramBundle.findViewById(ba.f.profile_biz_nickname));
    this.udi = ((AppBrandNearbyShowcaseView)paramBundle.findViewById(ba.f.profile_biz_showcase));
    this.udi.setIconGap(udw);
    this.udi.setIconSize(udv + udx * 2);
    dK(this.udg);
    this.udj = ((LinearLayout)paramBundle.findViewById(ba.f.profile_wxa_layout));
    this.udk = ((LinearLayout)paramBundle.findViewById(ba.f.profile_wxa_container));
    this.udl = ((TextView)paramBundle.findViewById(ba.f.profile_wxa_nickname));
    this.udm = ((AppBrandNearbyShowcaseView)paramBundle.findViewById(ba.f.profile_wxa_showcase));
    this.udm.setIconGap(udw);
    this.udm.setIconSize(udv + udx * 2);
    dK(this.udk);
    this.udn = ((TextView)paramBundle.findViewById(ba.f.profile_about_original));
    this.udo = paramBundle.findViewById(ba.f.profile_about_split);
    this.udp = ((TextView)paramBundle.findViewById(ba.f.profile_protect_teenager));
    Bundle localBundle = getIntent().getBundleExtra("key_extra_bundle");
    if ((localBundle != null) && (localBundle.getBoolean("key_is_embed_wxa", false)))
    {
      this.udq = ((TextView)paramBundle.findViewById(ba.f.feedback_tv));
      this.udq.setVisibility(0);
      this.udq.setOnClickListener(new AppBrandProfileUI.23(this));
    }
    udy = getContext().getResources().getColor(ba.c.icon_border_color);
    if (this.udz == null) {
      this.udz = new com.tencent.mm.plugin.appbrand.ui.widget.a(udv, udx, udy);
    }
    kU(true);
    cLn();
    AppMethodBeat.o(48741);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(48747);
    super.onDestroy();
    ad.ckY().remove(this);
    AppMethodBeat.o(48747);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(48743);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (!Util.isNullOrNil(this.sWX)) {
      ad.ckY().remove(this);
    }
    paramIntent = getIntent().getStringExtra("key_username");
    this.sWX = paramIntent;
    if (Util.isNullOrNil(paramIntent))
    {
      finish();
      AppMethodBeat.o(48743);
      return;
    }
    agg("onNewIntent");
    kU(true);
    cLn();
    AppMethodBeat.o(48743);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(48748);
    if ((paramMStorageEventData.eventId == 3) && ((paramMStorageEventData.obj instanceof String)) && (!Util.isNullOrNil(this.sWX)) && (this.sWX.equals(paramMStorageEventData.obj))) {
      kU(false);
    }
    AppMethodBeat.o(48748);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(48746);
    super.onPause();
    af.a(this, new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(48746);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(48745);
    super.onResume();
    if (getSwipeBackLayout() != null) {
      getSwipeBackLayout().setEnableGesture(getIntent().getBooleanExtra("key_can_swipe_back", true));
    }
    af.a(this, new com.tencent.mm.vending.c.a() {});
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
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(322963);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(k.class);
    paramHashSet.add(m.class);
    AppMethodBeat.o(322963);
  }
  
  static final class b
    implements IPCRunCgi.a
  {
    private final WeakReference<AppBrandProfileUI> udN;
    
    public b(AppBrandProfileUI paramAppBrandProfileUI)
    {
      AppMethodBeat.i(48732);
      this.udN = new WeakReference(paramAppBrandProfileUI);
      AppMethodBeat.o(48732);
    }
    
    public final void callback(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.c paramc)
    {
      AppMethodBeat.i(48733);
      if (this.udN.get() != null)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0) && (paramc != null) && (c.c.b(paramc.otC) != null) && ((c.c.b(paramc.otC) instanceof cqc)))
        {
          Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "queryProfile, request success");
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(48731);
              if (AppBrandProfileUI.b.a(AppBrandProfileUI.b.this).get() != null) {
                AppBrandProfileUI.a((AppBrandProfileUI)AppBrandProfileUI.b.a(AppBrandProfileUI.b.this).get(), this.udO);
              }
              AppMethodBeat.o(48731);
            }
          });
          AppMethodBeat.o(48733);
          return;
        }
        Log.e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "queryProfile, request fail");
      }
      AppMethodBeat.o(48733);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI
 * JD-Core Version:    0.7.0.1
 */