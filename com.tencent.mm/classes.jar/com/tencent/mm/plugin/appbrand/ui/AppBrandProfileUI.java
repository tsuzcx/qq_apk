package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.u;
import com.tencent.mm.plugin.appbrand.launching.ActivityStarterIpcDelegate;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.precondition.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.f;
import com.tencent.mm.plugin.appbrand.y.d;
import com.tencent.mm.plugin.appbrand.y.f;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.io.Serializable;
import java.util.HashMap;

public final class AppBrandProfileUI
  extends DrawStatusBarActivity
  implements View.OnClickListener, j.a
{
  private com.tencent.mm.ui.widget.a.d fnI;
  private String hcm;
  private u hco;
  private AppBrandProfileUI.a hdA;
  private WxaExposedParams hdB;
  private boolean hdC = false;
  private volatile boolean hdD = false;
  private int hdp;
  private long hdq = 0L;
  private LinearLayout hdr;
  private TableLayout hds;
  private ImageView hdt;
  private TextView hdu;
  private TextView hdv;
  private TextView hdw;
  private View hdx;
  private View hdy;
  private TextView hdz;
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2, WxaExposedParams paramWxaExposedParams, Bundle paramBundle, ActivityStarterIpcDelegate paramActivityStarterIpcDelegate)
  {
    if (bk.bl(paramString1)) {
      return;
    }
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ae.getContext();
    }
    paramContext = new Intent(localContext, AppBrandProfileUI.class).putExtra("key_username", paramString1).putExtra("key_from_scene", paramInt).putExtra("key_scene_note", paramString2).putExtra("key_can_swipe_back", true).putExtra("key_scene_exposed_params", paramWxaExposedParams).putExtra("key_extra_bundle", paramBundle);
    if (paramWxaExposedParams != null)
    {
      paramString1 = new Bundle();
      paramString1.putInt("stat_scene", 6);
      paramString1.putString("stat_app_id", paramWxaExposedParams.appId);
      paramString1.putString("stat_url", paramWxaExposedParams.bUo);
      paramContext.putExtra("_stat_obj", paramString1);
    }
    paramContext.putExtra("KEY_DELEGATED_ACTIVITY_STARTER", paramActivityStarterIpcDelegate);
    if (!(localContext instanceof Activity)) {
      paramContext.addFlags(268435456);
    }
    localContext.startActivity(paramContext);
  }
  
  private void c(int paramInt1, int paramInt2, long paramLong)
  {
    if (this.hco == null) {}
    for (String str1 = null; bk.bl(str1); str1 = this.hco.appId) {
      return;
    }
    int j = getIntent().getIntExtra("key_from_scene", 3);
    String str2 = bk.pm(getIntent().getStringExtra("key_scene_note"));
    int i = 0;
    WxaAttributes localWxaAttributes = com.tencent.mm.plugin.appbrand.app.e.aaT().e(str1, new String[] { "appInfo", "brandIconURL", "nickname" });
    if (localWxaAttributes != null) {
      i = localWxaAttributes.aen().dWx;
    }
    i += 1000;
    y.d("MicroMsg.AppBrandProfileUI", "stev report(%s), appId %s, scene %s, sceneNote %s, eventId %s, result %s, appType %s", new Object[] { Integer.valueOf(13919), str1, Integer.valueOf(j), str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
    h.nFQ.f(13919, new Object[] { str1, Integer.valueOf(j), str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), Integer.valueOf(i) });
    this.hdp = j;
  }
  
  public static void c(Context paramContext, String paramString, Bundle paramBundle)
  {
    a(paramContext, paramString, 6, null, null, paramBundle, null);
  }
  
  private void cf(int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2, bk.UX());
  }
  
  private void dD(boolean paramBoolean)
  {
    if (this.hdy == null) {
      return;
    }
    if (paramBoolean)
    {
      this.hdy.setVisibility(8);
      return;
    }
    this.hdy.setVisibility(0);
    this.hdy.setOnClickListener(this);
  }
  
  private void dE(boolean paramBoolean)
  {
    com.tencent.mm.sdk.f.e.post(new AppBrandProfileUI.6(this, paramBoolean), "AppBrandProfile");
  }
  
  public final boolean Wt()
  {
    return true;
  }
  
  public final void a(String paramString, l paraml)
  {
    if ((paraml.gbI == 3) && ((paraml.obj instanceof String)) && (!bk.bl(this.hcm)) && (this.hcm.equals((String)paraml.obj))) {
      dE(false);
    }
  }
  
  protected final void dealContentView(View paramView)
  {
    super.dealContentView(paramView);
    ScrollView localScrollView = new ScrollView(this);
    localScrollView.setBackgroundResource(y.d.app_brand_profile_background);
    this.hdr = new LinearLayout(this);
    this.hdr.setOrientation(1);
    localScrollView.addView(this.hdr, new FrameLayout.LayoutParams(-1, -2));
    ((FrameLayout)paramView).addView(localScrollView);
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  protected final void initActivityCloseAnimation()
  {
    if (this.hdC) {
      return;
    }
    super.initActivityCloseAnimation();
  }
  
  public final void onBackPressed()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      super.finishAfterTransition();
    }
    for (;;)
    {
      cf(6, 1);
      return;
      super.finish();
    }
  }
  
  public final void onClick(View paramView)
  {
    if (paramView.getId() == y.g.profile_enter_wxa_entity) {
      if ((this.hco != null) && (!bk.bl(this.hco.appId)))
      {
        com.tencent.mm.br.d.b(this.mController.uMN, "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", com.tencent.mm.plugin.appbrand.r.qM(this.hco.appId)).putExtra("forceHideShare", true));
        cf(2, 1);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramView.getId() != y.g.profile_enter_app) {
            break;
          }
        } while (this.hco == null);
        localObject1 = getIntent().getBundleExtra("_stat_obj");
        paramView = new AppBrandStatObject();
        paramView.scene = 1024;
        paramView.caB = f.g(paramView.scene, (Bundle)localObject1);
        paramView.caC = f.h(paramView.scene, (Bundle)localObject1);
        if (this.hdp == 6)
        {
          paramView.caB = 14;
          paramView.caC = getIntent().getBundleExtra("key_extra_bundle").getString("key_start_from_recommend_recommend_note");
        }
        localObject1 = (ActivityStarterIpcDelegate)getIntent().getParcelableExtra("KEY_DELEGATED_ACTIVITY_STARTER");
        localObject2 = new LaunchParcel();
        ((LaunchParcel)localObject2).username = this.hco.username;
        ((LaunchParcel)localObject2).fJy = 0;
        ((LaunchParcel)localObject2).gMm = paramView;
        ((LaunchParcel)localObject2).gJl = ((ActivityStarterIpcDelegate)localObject1);
        g.gMF.a(this, (LaunchParcel)localObject2);
        cf(4, 1);
      } while (paramView.caB != 6);
      this.hdC = true;
      finish();
      return;
    } while (paramView.getId() != y.g.profile_share_app);
    Object localObject1 = com.tencent.mm.plugin.appbrand.config.r.sq(this.hcm);
    if (localObject1 == null)
    {
      y.w("MicroMsg.AppBrandProfileUI", "attrs is null.");
      return;
    }
    Object localObject2 = new HashMap();
    ((HashMap)localObject2).put("desc", "");
    ((HashMap)localObject2).put("type", Integer.valueOf(1));
    ((HashMap)localObject2).put("title", ((u)localObject1).nickname);
    ((HashMap)localObject2).put("img_url", ((u)localObject1).fRz);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("scene_from", 3);
    localIntent.putExtra("appbrand_params", (Serializable)localObject2);
    localIntent.putExtra("Retr_Msg_Type", 2);
    com.tencent.mm.br.d.a((MMActivity)paramView.getContext(), ".ui.transmit.SelectConversationUI", localIntent, 1, new AppBrandProfileUI.5(this, (u)localObject1, paramView));
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("key_username");
    this.hcm = paramBundle;
    if (bk.bl(paramBundle))
    {
      finish();
      return;
    }
    if ((getIntent().getExtras() != null) && (!getIntent().getExtras().containsKey("key_extra_bundle"))) {
      getIntent().getExtras().putBundle("key_extra_bundle", Bundle.EMPTY);
    }
    getIntent().setExtrasClassLoader(getClassLoader());
    this.hdB = ((WxaExposedParams)getIntent().getParcelableExtra("key_scene_exposed_params"));
    setBackBtn(new AppBrandProfileUI.1(this));
    addIconOptionMenu(0, y.j.app_more, y.f.mm_title_btn_menu, new AppBrandProfileUI.2(this));
    setMMTitle("");
    czo();
    ta(-1);
    Object localObject1 = LayoutInflater.from(this);
    paramBundle = ((LayoutInflater)localObject1).inflate(y.h.app_brand_profile_ui_header, this.hdr, true);
    localObject1 = ((LayoutInflater)localObject1).inflate(y.h.app_brand_profile_ui_footer, this.hdr, true);
    this.hds = ((TableLayout)paramBundle.findViewById(y.g.profile_tl));
    TableLayout localTableLayout = this.hds;
    if (localTableLayout != null)
    {
      int j = getResources().getDisplayMetrics().widthPixels;
      int k = localTableLayout.getChildCount();
      int i = 0;
      while (i < k)
      {
        Object localObject2 = localTableLayout.getChildAt(i);
        if ((localObject2 instanceof TableRow))
        {
          localObject2 = (TableRow)localObject2;
          if (((TableRow)localObject2).getChildCount() > 1)
          {
            View localView = ((TableRow)localObject2).getChildAt(0);
            if ((localView != null) && ((localView instanceof TextView)))
            {
              int m = j / 2;
              int n = ((TableRow)localObject2).getPaddingLeft();
              ((TextView)localView).setMaxWidth(m - n);
            }
          }
        }
        i += 1;
      }
    }
    this.hdt = ((ImageView)paramBundle.findViewById(y.g.profile_icon));
    this.hdu = ((TextView)paramBundle.findViewById(y.g.profile_name));
    this.hdv = ((TextView)paramBundle.findViewById(y.g.profile_description));
    this.hdw = ((TextView)paramBundle.findViewById(y.g.profile_service_scope_content));
    this.hdx = paramBundle.findViewById(y.g.profile_service_scope_container);
    this.hdA = new AppBrandProfileUI.a(this, paramBundle.findViewById(y.g.profile_biz_item));
    this.hdy = paramBundle.findViewById(y.g.profile_enter_wxa_entity);
    this.hdz = ((TextView)this.hdy.findViewById(y.g.profile_enter_wxa_entity_content));
    dD(true);
    paramBundle.setClickable(false);
    paramBundle.setLongClickable(false);
    ((View)localObject1).setClickable(false);
    ((View)localObject1).setLongClickable(false);
    paramBundle = ((View)localObject1).findViewById(y.g.profile_enter_app);
    localObject1 = ((View)localObject1).findViewById(y.g.profile_share_app);
    paramBundle.setOnClickListener(this);
    ((View)localObject1).setOnClickListener(this);
    dE(true);
  }
  
  protected final void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.plugin.appbrand.config.r.aem().d(this);
  }
  
  protected final void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (!bk.bl(this.hcm)) {
      com.tencent.mm.plugin.appbrand.config.r.aem().d(this);
    }
    paramIntent = getIntent().getStringExtra("key_username");
    this.hcm = paramIntent;
    if (bk.bl(paramIntent))
    {
      finish();
      return;
    }
    dE(true);
  }
  
  protected final void onResume()
  {
    super.onResume();
    if (getSwipeBackLayout() != null) {
      getSwipeBackLayout().setEnableGesture(getIntent().getBooleanExtra("key_can_swipe_back", true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI
 * JD-Core Version:    0.7.0.1
 */