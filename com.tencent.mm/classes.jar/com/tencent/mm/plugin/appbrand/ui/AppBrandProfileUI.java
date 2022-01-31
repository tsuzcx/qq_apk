package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
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
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.plugin.profile.ui.WxaBindWxaInfoUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.aok;
import com.tencent.mm.protocal.protobuf.dat;
import com.tencent.mm.protocal.protobuf.dbc;
import com.tencent.mm.protocal.protobuf.dbd;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class AppBrandProfileUI
  extends MMActivity
  implements k.a
{
  private static final int iNq;
  private static final int iNr;
  private static final int iNs;
  private static final int iNt;
  private static final int iNu;
  private static final int iNv;
  private static final int iNw;
  private ImageView iLT;
  private com.tencent.mm.plugin.appbrand.config.v iLz;
  private LinkedList<dat> iNA;
  private LinearLayout iNB;
  private ImageView iNC;
  private TextView iND;
  private TextView iNE;
  private TextView iNF;
  private RatingBar iNG;
  private TextView iNH;
  private LinearLayout iNI;
  private RecyclerView iNJ;
  private LinearLayout iNK;
  private LinearLayout iNL;
  private LinearLayout iNM;
  private TextView iNN;
  private AppBrandNearbyShowcaseView iNO;
  private LinearLayout iNP;
  private LinearLayout iNQ;
  private TextView iNR;
  private AppBrandNearbyShowcaseView iNS;
  private LinearLayout iNT;
  private FrameLayout iNU;
  private TextView iNV;
  private TextView iNW;
  private LinearLayout iNX;
  private ImageView iNY;
  private LinearLayout iNZ;
  private boolean iNx;
  private boolean iNy;
  private int iNz;
  private AppBrandNearbyShowcaseView iOa;
  private TextView iOb;
  private int iOc;
  private com.tencent.mm.ui.widget.b.d iOd;
  private WxaExposedParams iOe;
  private boolean iOf;
  private b.f iOg;
  private b.f iOh;
  private b.f iOi;
  private String ikj;
  
  static
  {
    AppMethodBeat.i(133082);
    iNq = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 24);
    iNr = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 20);
    iNs = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 2);
    iNt = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 40);
    iNu = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 44);
    iNv = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 32);
    iNw = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 4);
    AppMethodBeat.o(133082);
  }
  
  public AppBrandProfileUI()
  {
    AppMethodBeat.i(133055);
    this.iNx = false;
    this.iNy = false;
    this.iNz = 0;
    this.iNA = new LinkedList();
    this.iOf = false;
    AppMethodBeat.o(133055);
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2, WxaExposedParams paramWxaExposedParams, Bundle paramBundle)
  {
    AppMethodBeat.i(143601);
    a(paramContext, paramString1, paramInt, paramString2, paramWxaExposedParams, paramBundle, null);
    AppMethodBeat.o(143601);
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2, WxaExposedParams paramWxaExposedParams, Bundle paramBundle, ActivityStarterIpcDelegate paramActivityStarterIpcDelegate)
  {
    AppMethodBeat.i(133056);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(133056);
      return;
    }
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ah.getContext();
    }
    paramContext = new Intent(localContext, AppBrandProfileUI.class).putExtra("key_username", paramString1).putExtra("key_from_scene", paramInt).putExtra("key_scene_note", paramString2).putExtra("key_can_swipe_back", true).putExtra("key_scene_exposed_params", paramWxaExposedParams).putExtra("key_extra_bundle", paramBundle);
    if (paramWxaExposedParams != null)
    {
      paramString1 = new Bundle();
      paramString1.putInt("stat_scene", 6);
      paramString1.putString("stat_app_id", paramWxaExposedParams.appId);
      paramString1.putString("stat_url", paramWxaExposedParams.pageId);
      paramContext.putExtra("_stat_obj", paramString1);
    }
    paramContext.putExtra("KEY_DELEGATED_ACTIVITY_STARTER", paramActivityStarterIpcDelegate);
    if (!(localContext instanceof Activity)) {
      paramContext.addFlags(268435456);
    }
    localContext.startActivity(paramContext);
    AppMethodBeat.o(133056);
  }
  
  private void aMk()
  {
    AppMethodBeat.i(133069);
    if (!bo.isNullOrNil(this.ikj))
    {
      ab.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "queryProfile start");
      aoj localaoj = new aoj();
      localaoj.username = this.ikj;
      b.a locala = new b.a();
      locala.funcId = 2921;
      locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getprofileinfo";
      locala.fsX = localaoj;
      locala.fsY = new aok();
      com.tencent.mm.ipcinvoker.wx_extension.b.a(locala.ado(), new AppBrandProfileUI.a(this));
    }
    AppMethodBeat.o(133069);
  }
  
  private void aMl()
  {
    AppMethodBeat.i(133070);
    if ((this.iNA != null) && (this.iNA.size() > 0))
    {
      this.iNU.setVisibility(0);
      this.iNX.setVisibility(0);
      this.iNV.setVisibility(8);
      this.iOa.setIconGap(iNu);
      this.iOa.setIconSize(iNt);
      this.iOa.setIconLayerCount(Math.min(this.iNA.size(), 3));
      if (this.iOh == null) {
        this.iOh = new com.tencent.mm.plugin.appbrand.ui.a.a(iNv);
      }
      if (this.iOi == null) {
        this.iOi = new com.tencent.mm.plugin.appbrand.ui.a.a(iNw);
      }
      int i = 0;
      if (i < this.iOa.getChildCount())
      {
        String str;
        label167:
        com.tencent.mm.modelappbrand.a.b localb;
        ImageView localImageView;
        if (this.iNA.size() > i)
        {
          str = ((dat)this.iNA.get(i)).oiD;
          localb = com.tencent.mm.modelappbrand.a.b.acD();
          localImageView = this.iOa.pU(i);
          if ((str != null) && (!str.startsWith("http"))) {
            break label226;
          }
        }
        label226:
        for (b.f localf = this.iOh;; localf = this.iOi)
        {
          localb.a(localImageView, str, 2130838493, localf);
          i += 1;
          break;
          str = null;
          break label167;
        }
      }
      if (this.iNz == 1) {
        if (this.iNx)
        {
          this.iNW.setText(getString(2131296804));
          if (!this.iNx) {
            break label419;
          }
          this.iNW.setCompoundDrawablesWithIntrinsicBounds(2130837757, 0, 0, 0);
          label283:
          if (this.iNz <= 3) {
            break label435;
          }
          this.iNY.setVisibility(0);
          this.iNZ.setOnClickListener(new AppBrandProfileUI.13(this));
        }
      }
    }
    for (;;)
    {
      this.iNV.setOnClickListener(new AppBrandProfileUI.14(this));
      this.iNW.setOnClickListener(new AppBrandProfileUI.15(this));
      AppMethodBeat.o(133070);
      return;
      this.iNW.setText(String.format(getString(2131296806), new Object[] { Integer.valueOf(this.iNz) }));
      break;
      this.iNW.setText(String.format(getString(2131296806), new Object[] { Integer.valueOf(this.iNz) }));
      break;
      label419:
      this.iNW.setCompoundDrawablesWithIntrinsicBounds(2130837756, 0, 0, 0);
      break label283;
      label435:
      this.iNY.setVisibility(8);
      this.iNZ.setOnClickListener(null);
      continue;
      this.iNU.setVisibility(0);
      this.iNV.setVisibility(0);
      this.iNX.setVisibility(8);
    }
  }
  
  private static void c(View paramView, Runnable paramRunnable)
  {
    AppMethodBeat.i(143602);
    if (paramView.getVisibility() != 0)
    {
      paramView.setAlpha(0.0F);
      paramView.setVisibility(0);
    }
    paramView.animate().setDuration(200L).alpha(1.0F).withEndAction(paramRunnable).start();
    AppMethodBeat.o(143602);
  }
  
  private void cx(View paramView)
  {
    AppMethodBeat.i(143603);
    if (paramView.getVisibility() == 0) {
      paramView.animate().setDuration(200L).alpha(0.0F).withEndAction(new AppBrandProfileUI.16(this, paramView)).start();
    }
    AppMethodBeat.o(143603);
  }
  
  private void d(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(133067);
    if (this.iLz == null) {}
    for (String str1 = null; bo.isNullOrNil(str1); str1 = this.iLz.appId)
    {
      AppMethodBeat.o(133067);
      return;
    }
    int j = getIntent().getIntExtra("key_from_scene", 3);
    String str2 = bo.nullAsNil(getIntent().getStringExtra("key_scene_note"));
    int i = 0;
    WxaAttributes localWxaAttributes = g.auF().e(str1, new String[] { "appInfo", "brandIconURL", "nickname" });
    if (localWxaAttributes != null) {
      i = localWxaAttributes.ayC().fmF;
    }
    i += 1000;
    ab.d("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "stev report(%s), appId %s, scene %s, sceneNote %s, eventId %s, result %s, appType %s", new Object[] { Integer.valueOf(13919), str1, Integer.valueOf(j), str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
    h.qsU.e(13919, new Object[] { str1, Integer.valueOf(j), str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), Integer.valueOf(i) });
    this.iOc = j;
    AppMethodBeat.o(133067);
  }
  
  private void jdMethod_do(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133066);
    d(paramInt1, paramInt2, bo.aox());
    AppMethodBeat.o(133066);
  }
  
  private void eQ(boolean paramBoolean)
  {
    AppMethodBeat.i(133068);
    com.tencent.mm.sdk.g.d.post(new AppBrandProfileUI.4(this, paramBoolean), "AppBrandProfile");
    AppMethodBeat.o(133068);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(133064);
    if ((paramm.htj == 3) && ((paramm.obj instanceof String)) && (!bo.isNullOrNil(this.ikj)) && (this.ikj.equals((String)paramm.obj))) {
      eQ(false);
    }
    AppMethodBeat.o(133064);
  }
  
  public final void dealContentView(View paramView)
  {
    AppMethodBeat.i(133058);
    super.dealContentView(paramView);
    ScrollView localScrollView = new ScrollView(this);
    localScrollView.setVerticalScrollBarEnabled(false);
    localScrollView.setOverScrollMode(2);
    localScrollView.setBackgroundResource(2131689714);
    localScrollView.setFillViewport(true);
    this.iNB = new LinearLayout(this);
    this.iNB.setOrientation(1);
    this.iNB.setFocusable(true);
    this.iNB.setFocusableInTouchMode(true);
    localScrollView.addView(this.iNB, new FrameLayout.LayoutParams(-1, -1));
    ((FrameLayout)paramView).addView(localScrollView);
    AppMethodBeat.o(133058);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void initActivityCloseAnimation()
  {
    AppMethodBeat.i(133065);
    if (this.iOf)
    {
      AppMethodBeat.o(133065);
      return;
    }
    super.initActivityCloseAnimation();
    AppMethodBeat.o(133065);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(133060);
    if (Build.VERSION.SDK_INT >= 21) {
      super.finishAfterTransition();
    }
    for (;;)
    {
      jdMethod_do(6, 1);
      AppMethodBeat.o(133060);
      return;
      super.finish();
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(133057);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("key_username");
    this.ikj = paramBundle;
    if (bo.isNullOrNil(paramBundle))
    {
      finish();
      AppMethodBeat.o(133057);
      return;
    }
    if ((getIntent().getExtras() != null) && (!getIntent().getExtras().containsKey("key_extra_bundle"))) {
      getIntent().getExtras().putBundle("key_extra_bundle", Bundle.EMPTY);
    }
    getIntent().setExtrasClassLoader(getClassLoader());
    this.iOe = ((WxaExposedParams)getIntent().getParcelableExtra("key_scene_exposed_params"));
    setBackBtn(new AppBrandProfileUI.1(this));
    addIconOptionMenu(0, 2131296998, 2130839668, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(133036);
        AppBrandProfileUI.a(AppBrandProfileUI.this);
        AppMethodBeat.o(133036);
        return true;
      }
    });
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(-1);
    paramBundle = LayoutInflater.from(this).inflate(2130968712, this.iNB, true);
    paramBundle.setClickable(false);
    paramBundle.setLongClickable(false);
    this.iNC = ((ImageView)paramBundle.findViewById(2131821298));
    this.iND = ((TextView)paramBundle.findViewById(2131821299));
    this.iNE = ((TextView)paramBundle.findViewById(2131821301));
    this.iNF = ((TextView)paramBundle.findViewById(2131821304));
    this.iNG = ((RatingBar)paramBundle.findViewById(2131821305));
    this.iNH = ((TextView)paramBundle.findViewById(2131821302));
    this.iNI = ((LinearLayout)paramBundle.findViewById(2131821303));
    this.iLT = ((ImageView)paramBundle.findViewById(2131821300));
    this.iNK = ((LinearLayout)paramBundle.findViewById(2131821315));
    this.iNJ = ((RecyclerView)paramBundle.findViewById(2131821316));
    this.iNJ.setItemAnimator(new android.support.v7.widget.v());
    Object localObject = new LinearLayoutManager();
    ((LinearLayoutManager)localObject).setOrientation(0);
    this.iNJ.setLayoutManager((RecyclerView.i)localObject);
    this.iNJ.a(new AppBrandProfileUI.19(this));
    this.iNL = ((LinearLayout)paramBundle.findViewById(2131821317));
    this.iNM = ((LinearLayout)paramBundle.findViewById(2131821318));
    this.iNN = ((TextView)paramBundle.findViewById(2131821320));
    this.iNO = ((AppBrandNearbyShowcaseView)paramBundle.findViewById(2131821319));
    this.iNO.setIconGap(iNr);
    this.iNO.setIconSize(iNq + iNs * 2);
    cx(this.iNM);
    this.iNP = ((LinearLayout)paramBundle.findViewById(2131821322));
    this.iNQ = ((LinearLayout)paramBundle.findViewById(2131821323));
    this.iNR = ((TextView)paramBundle.findViewById(2131821325));
    this.iNS = ((AppBrandNearbyShowcaseView)paramBundle.findViewById(2131821324));
    this.iNS.setIconGap(iNr);
    this.iNS.setIconSize(iNq + iNs * 2);
    cx(this.iNQ);
    this.iNU = ((FrameLayout)paramBundle.findViewById(2131821308));
    this.iNV = ((TextView)paramBundle.findViewById(2131821309));
    this.iNW = ((TextView)paramBundle.findViewById(2131821311));
    this.iNY = ((ImageView)paramBundle.findViewById(2131821314));
    this.iOa = ((AppBrandNearbyShowcaseView)paramBundle.findViewById(2131821313));
    this.iNZ = ((LinearLayout)paramBundle.findViewById(2131821312));
    this.iNX = ((LinearLayout)paramBundle.findViewById(2131821310));
    this.iOb = ((TextView)paramBundle.findViewById(2131821331));
    this.iNT = ((LinearLayout)paramBundle.findViewById(2131821327));
    this.iNT.setVisibility(0);
    this.iNT.setOnClickListener(new AppBrandProfileUI.20(this));
    localObject = paramBundle.findViewById(2131821306);
    paramBundle = paramBundle.findViewById(2131821307);
    ((View)localObject).setOnClickListener(new AppBrandProfileUI.17(this));
    paramBundle.setOnClickListener(new AppBrandProfileUI.18(this));
    if (this.iOg == null) {
      this.iOg = new com.tencent.mm.plugin.appbrand.ui.widget.a(iNq, iNs);
    }
    eQ(true);
    aMk();
    jdMethod_do(1, 1);
    AppMethodBeat.o(133057);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(133063);
    super.onDestroy();
    q.ayA().remove(this);
    AppMethodBeat.o(133063);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(133059);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (!bo.isNullOrNil(this.ikj)) {
      q.ayA().remove(this);
    }
    paramIntent = getIntent().getStringExtra("key_username");
    this.ikj = paramIntent;
    if (bo.isNullOrNil(paramIntent))
    {
      finish();
      AppMethodBeat.o(133059);
      return;
    }
    eQ(true);
    aMk();
    jdMethod_do(1, 1);
    AppMethodBeat.o(133059);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(133062);
    super.onPause();
    p.a(this, new AppBrandProfileUI.22(this));
    AppMethodBeat.o(133062);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(133061);
    super.onResume();
    if (getSwipeBackLayout() != null) {
      getSwipeBackLayout().setEnableGesture(getIntent().getBooleanExtra("key_can_swipe_back", true));
    }
    p.a(this, new AppBrandProfileUI.21(this));
    AppMethodBeat.o(133061);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI
 * JD-Core Version:    0.7.0.1
 */