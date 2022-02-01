package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.w;
import com.tencent.mm.aj.w.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.uz;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.e;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.au.h;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.ae;
import com.tencent.mm.plugin.appbrand.utils.ah;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.ewx;
import com.tencent.mm.protocal.protobuf.fov;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vending.g.d.b;
import java.lang.ref.WeakReference;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class AppBrandProfileUI
  extends MMActivity
  implements MStorage.IOnStorageChange
{
  private static int qWA;
  private static final int qWB;
  private static final int qWC;
  private static final int qWD;
  private static final int qWE;
  private static final String qWv;
  private static final String qWw;
  private static final int qWx;
  private static final int qWy;
  private static final int qWz;
  private String njH;
  private LinearLayout pQA;
  private String pRV;
  private ae qSY;
  private boolean qWF;
  private boolean qWG;
  private int qWH;
  private LinkedList<fov> qWI;
  private ImageView qWJ;
  private TextView qWK;
  private TextView qWL;
  private TextView qWM;
  private RatingBar qWN;
  private TextView qWO;
  private LinearLayout qWP;
  private RecyclerView qWQ;
  private LinearLayout qWR;
  private LinearLayout qWS;
  private LinearLayout qWT;
  private TextView qWU;
  private AppBrandNearbyShowcaseView qWV;
  private LinearLayout qWW;
  private LinearLayout qWX;
  private TextView qWY;
  private AppBrandNearbyShowcaseView qWZ;
  private LinearLayout qXa;
  private TextView qXb;
  private FrameLayout qXc;
  private TextView qXd;
  private TextView qXe;
  private LinearLayout qXf;
  private ImageView qXg;
  private LinearLayout qXh;
  private AppBrandNearbyShowcaseView qXi;
  private TextView qXj;
  private View qXk;
  private TextView qXl;
  private int qXm;
  private e qXn;
  private WxaExposedParams qXo;
  private boolean qXp;
  private b.h qXq;
  private b.h qXr;
  private b.h qXs;
  private boolean qXt;
  private boolean qXu;
  private boolean qXv;
  private String qXw;
  private String qXx;
  private String qXy;
  private Runnable qXz;
  
  static
  {
    AppMethodBeat.i(48769);
    qWv = "https://" + WeChatHosts.domainString(au.i.host_mp_weixin_qq_com) + "/mp/wapreportwxadevlog?action=get_page&appid=%s#wechat_redirect";
    qWw = "https://" + WeChatHosts.domainString(au.i.host_jiazhang_qq_com) + "/wap/guard/dist/main/index.html#/Index?source=mini_game";
    qWx = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 24);
    qWy = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 20);
    qWz = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 2);
    qWA = -1;
    qWB = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 40);
    qWC = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 44);
    qWD = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 32);
    qWE = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 4);
    AppMethodBeat.o(48769);
  }
  
  public AppBrandProfileUI()
  {
    AppMethodBeat.i(48738);
    this.qWF = false;
    this.qWG = false;
    this.qWH = 0;
    this.qWI = new LinkedList();
    this.qXp = false;
    this.njH = "";
    this.qXw = "";
    this.qXx = "";
    this.qXy = "";
    this.qXz = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(283263);
        AppBrandProfileUI.f(AppBrandProfileUI.this).setHighlightColor(AppBrandProfileUI.this.getResources().getColor(17170445));
        AppBrandProfileUI.f(AppBrandProfileUI.this).setText(AppBrandProfileUI.g(AppBrandProfileUI.this));
        AppBrandProfileUI.f(AppBrandProfileUI.this).requestLayout();
        AppBrandProfileUI.f(AppBrandProfileUI.this).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public final void onGlobalLayout()
          {
            AppMethodBeat.i(273544);
            AppBrandProfileUI.f(AppBrandProfileUI.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
            Object localObject2 = new ArrayList();
            Object localObject1;
            if (AppBrandProfileUI.h(AppBrandProfileUI.this))
            {
              localObject1 = ah.a(AppBrandProfileUI.this.getContext(), au.e.appbrand_brand_official_icon, 36, 20, new ClickableSpan()
              {
                public final void onClick(View paramAnonymous3View)
                {
                  AppMethodBeat.i(273899);
                  if (TextUtils.isEmpty(AppBrandProfileUI.i(AppBrandProfileUI.this)))
                  {
                    AppMethodBeat.o(273899);
                    return;
                  }
                  AppBrandProfileUI.a(AppBrandProfileUI.this, 25, 1);
                  c.b(AppBrandProfileUI.this, "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", AppBrandProfileUI.i(AppBrandProfileUI.this)).putExtra("forceHideShare", true));
                  Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "click official icon");
                  AppMethodBeat.o(273899);
                }
              });
              ((List)localObject2).add(((Pair)localObject1).first);
            }
            for (int j = ((Integer)((Pair)localObject1).second).intValue() + 0;; j = 0)
            {
              int i = j;
              if (AppBrandProfileUI.j(AppBrandProfileUI.this))
              {
                localObject1 = ah.a(AppBrandProfileUI.this.getContext(), au.e.app_brand_profile_game_original, 36, 20, new ClickableSpan()
                {
                  public final void onClick(View paramAnonymous3View)
                  {
                    AppMethodBeat.i(275038);
                    if (TextUtils.isEmpty(AppBrandProfileUI.k(AppBrandProfileUI.this)))
                    {
                      AppMethodBeat.o(275038);
                      return;
                    }
                    try
                    {
                      paramAnonymous3View = com.tencent.mm.plugin.appbrand.z.cq(AppBrandProfileUI.k(AppBrandProfileUI.this), "appid=" + AppBrandProfileUI.l(AppBrandProfileUI.this).appId);
                      paramAnonymous3View = new Intent().putExtra("rawUrl", paramAnonymous3View).putExtra("forceHideShare", true);
                      c.b(AppBrandProfileUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymous3View);
                      AppBrandProfileUI.a(AppBrandProfileUI.this, 21, 1);
                      Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "click original icon");
                      AppMethodBeat.o(275038);
                      return;
                    }
                    catch (URISyntaxException paramAnonymous3View)
                    {
                      for (;;)
                      {
                        Log.printErrStackTrace("MicroMsg.AppBrand.Profile.AppBrandProfileUI", paramAnonymous3View, "URISyntaxException with originalRedirectUrl %s", new Object[] { AppBrandProfileUI.k(AppBrandProfileUI.this) });
                      }
                    }
                  }
                });
                ((List)localObject2).add(((Pair)localObject1).first);
                i = j + ((Integer)((Pair)localObject1).second).intValue();
              }
              j = i;
              if (AppBrandProfileUI.m(AppBrandProfileUI.this))
              {
                localObject1 = ah.a(AppBrandProfileUI.this.getContext(), au.e.app_brand_trading_guarantee_icon, 16, 16, new ClickableSpan()
                {
                  public final void onClick(View paramAnonymous3View)
                  {
                    AppMethodBeat.i(274034);
                    if (TextUtils.isEmpty(AppBrandProfileUI.n(AppBrandProfileUI.this)))
                    {
                      AppMethodBeat.o(274034);
                      return;
                    }
                    AppBrandProfileUI.a(AppBrandProfileUI.this, 26, 1);
                    c.b(AppBrandProfileUI.this, "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", AppBrandProfileUI.n(AppBrandProfileUI.this)).putExtra("forceHideShare", true));
                    Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "click guarantee icon");
                    AppMethodBeat.o(274034);
                  }
                });
                ((List)localObject2).add(((Pair)localObject1).first);
                j = i + ((Integer)((Pair)localObject1).second).intValue();
              }
              ((List)localObject2).add(ah.et(AppBrandProfileUI.this.getContext()).first);
              i = AppBrandProfileUI.f(AppBrandProfileUI.this).getWidth() - AppBrandProfileUI.f(AppBrandProfileUI.this).getPaddingLeft() - AppBrandProfileUI.f(AppBrandProfileUI.this).getPaddingRight();
              TextPaint localTextPaint = AppBrandProfileUI.f(AppBrandProfileUI.this).getPaint();
              if (AppBrandProfileUI.g(AppBrandProfileUI.this) == null) {}
              for (localObject1 = "";; localObject1 = AppBrandProfileUI.g(AppBrandProfileUI.this))
              {
                List localList = ah.a(localTextPaint, (CharSequence)localObject1, i);
                localObject1 = AppBrandProfileUI.g(AppBrandProfileUI.this);
                if (localList.size() >= AppBrandProfileUI.f(AppBrandProfileUI.this).getMaxLines())
                {
                  int k = Math.min(AppBrandProfileUI.f(AppBrandProfileUI.this).getMaxLines() - 1, localList.size() - 1);
                  localObject1 = TextUtils.ellipsize(AppBrandProfileUI.g(AppBrandProfileUI.this).substring(((Point)localList.get(k)).x), localTextPaint, i - j, TextUtils.TruncateAt.END);
                  localObject1 = AppBrandProfileUI.g(AppBrandProfileUI.this).substring(0, ((Point)localList.get(k)).x) + localObject1;
                }
                AppBrandProfileUI.f(AppBrandProfileUI.this).setText((CharSequence)localObject1);
                localObject1 = ((List)localObject2).iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (SpannableString)((Iterator)localObject1).next();
                  AppBrandProfileUI.f(AppBrandProfileUI.this).append((CharSequence)localObject2);
                }
              }
              AppMethodBeat.o(273544);
              return;
            }
          }
        });
        AppBrandProfileUI.f(AppBrandProfileUI.this).setMovementMethod(LinkMovementMethod.getInstance());
        AppMethodBeat.o(283263);
      }
    };
    AppMethodBeat.o(48738);
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong, com.tencent.mm.plugin.appbrand.jsapi.share.aa paramaa)
  {
    AppMethodBeat.i(268047);
    if (this.qSY == null) {}
    for (String str1 = null; Util.isNullOrNil(str1); str1 = this.qSY.appId)
    {
      Log.e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "profileOperateReport appId null");
      AppMethodBeat.o(268047);
      return;
    }
    int j = getIntent().getIntExtra("key_from_scene", 3);
    String str3 = Util.nullAsNil(getIntent().getStringExtra("key_scene_note"));
    int i = 0;
    Object localObject = m.bFF().d(str1, new String[] { "appInfo", "brandIconURL", "nickname" });
    if (localObject != null) {
      i = ((WxaAttributes)localObject).bLF().serviceType;
    }
    int k = i + 1000;
    label151:
    String str2;
    label160:
    String str4;
    if (paramaa == null)
    {
      localObject = "";
      if (paramaa != null) {
        break label418;
      }
      i = 0;
      if (paramaa != null) {
        break label428;
      }
      str2 = "";
      str4 = Util.nullAsNil(str2);
      if (paramaa != null) {
        break label438;
      }
      str2 = "";
      label176:
      str2 = URLEncoder.encode(Util.nullAsNil(str2));
      if (paramaa != null) {
        break label448;
      }
    }
    label418:
    label428:
    label438:
    label448:
    for (paramaa = "";; paramaa = paramaa.pqY)
    {
      paramaa = URLEncoder.encode(Util.nullAsNil(paramaa));
      Log.d("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "stev report(%s), appId %s, scene %s, sceneNote %s, eventId %s, result %s, appType %s,shareActionId:%s, shareActionType:%d, shareTitle:%s, sharePath:%s, shareImgUrl:%s", new Object[] { Integer.valueOf(13919), str1, Integer.valueOf(j), str3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(k), localObject, Integer.valueOf(i), str4, str2, paramaa });
      com.tencent.mm.plugin.report.service.h.IzE.a(13919, new Object[] { str1, Integer.valueOf(j), str3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), Integer.valueOf(k), localObject, Integer.valueOf(i), str4, str2, paramaa });
      this.qXm = j;
      AppMethodBeat.o(268047);
      return;
      localObject = paramaa.fvj;
      break;
      i = paramaa.pqV;
      break label151;
      str2 = paramaa.pqW;
      break label160;
      str2 = paramaa.pqX;
      break label176;
    }
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
    a(paramContext, paramString1, paramInt, paramString2, true, paramWxaExposedParams, paramBundle, paramActivityStarterIpcDelegate, -1);
    AppMethodBeat.o(48740);
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt1, String paramString2, boolean paramBoolean, WxaExposedParams paramWxaExposedParams, Bundle paramBundle, ActivityStarterIpcDelegate paramActivityStarterIpcDelegate, int paramInt2)
  {
    AppMethodBeat.i(268043);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(268043);
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
        paramString2.putString("stat_url", paramWxaExposedParams.pageId);
        paramString1.putExtra("_stat_obj", paramString2);
      }
      paramString1.putExtra("KEY_DELEGATED_ACTIVITY_STARTER", paramActivityStarterIpcDelegate);
      if (!(paramContext instanceof Activity)) {
        paramString1.addFlags(268435456);
      }
      if (((paramContext instanceof Activity)) && (paramInt2 >= 0))
      {
        ((Activity)paramContext).startActivityForResult(paramString1, paramInt2);
        AppMethodBeat.o(268043);
        return;
      }
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().bm(paramString1);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aFh(), "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI", "show", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;ZLcom/tencent/mm/plugin/appbrand/config/WxaExposedParams;Landroid/os/Bundle;Lcom/tencent/luggage/sdk/launching/ActivityStarterIpcDelegate;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI", "show", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;ZLcom/tencent/mm/plugin/appbrand/config/WxaExposedParams;Landroid/os/Bundle;Lcom/tencent/luggage/sdk/launching/ActivityStarterIpcDelegate;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(268043);
      return;
    }
  }
  
  private void cjU()
  {
    AppMethodBeat.i(268051);
    MMHandlerThread.removeRunnable(this.qXz);
    MMHandlerThread.postToMainThread(this.qXz);
    AppMethodBeat.o(268051);
  }
  
  private void cjV()
  {
    AppMethodBeat.i(48753);
    if (!Util.isNullOrNil(this.pRV))
    {
      Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "queryProfile start");
      cas localcas = new cas();
      localcas.username = this.pRV;
      d.a locala = new d.a();
      locala.funcId = 2921;
      locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getprofileinfo";
      locala.lBU = localcas;
      locala.lBV = new cat();
      IPCRunCgi.a(locala.bgN(), new a(this));
    }
    AppMethodBeat.o(48753);
  }
  
  private void cjW()
  {
    AppMethodBeat.i(48754);
    if ((this.qWI != null) && (this.qWI.size() > 0))
    {
      this.qXc.setVisibility(0);
      this.qXf.setVisibility(0);
      this.qXd.setVisibility(8);
      this.qXi.setIconGap(qWC);
      this.qXi.setIconSize(qWB);
      this.qXi.setIconLayerCount(Math.min(this.qWI.size(), 3));
      if (this.qXr == null) {
        this.qXr = new com.tencent.mm.plugin.appbrand.ui.b.a(qWD);
      }
      if (this.qXs == null) {
        this.qXs = new com.tencent.mm.plugin.appbrand.ui.b.a(qWE);
      }
      int i = 0;
      if (i < this.qXi.getChildCount())
      {
        String str;
        label167:
        com.tencent.mm.modelappbrand.a.b localb;
        ImageView localImageView;
        int j;
        if (this.qWI.size() > i)
        {
          str = ((fov)this.qWI.get(i)).EtG;
          localb = com.tencent.mm.modelappbrand.a.b.bhh();
          localImageView = this.qXi.Dt(i);
          j = au.e.default_avatar;
          if ((str != null) && (!str.startsWith("http"))) {
            break label230;
          }
        }
        label230:
        for (b.h localh = this.qXr;; localh = this.qXs)
        {
          localb.a(localImageView, str, j, localh);
          i += 1;
          break;
          str = null;
          break label167;
        }
      }
      if (this.qWH == 1) {
        if (this.qWF)
        {
          this.qXe.setText(getString(au.i.app_brand_profile_mine_like));
          if (!this.qWF) {
            break label424;
          }
          this.qXe.setCompoundDrawablesWithIntrinsicBounds(au.e.app_brand_profile_action_like_pressed, 0, 0, 0);
          label288:
          if (this.qWH <= 3) {
            break label440;
          }
          this.qXg.setVisibility(0);
          this.qXh.setOnClickListener(new AppBrandProfileUI.15(this));
        }
      }
    }
    for (;;)
    {
      this.qXd.setOnClickListener(new AppBrandProfileUI.16(this));
      this.qXe.setOnClickListener(new AppBrandProfileUI.17(this));
      AppMethodBeat.o(48754);
      return;
      this.qXe.setText(String.format(getString(au.i.app_brand_profile_more_like), new Object[] { Integer.valueOf(this.qWH) }));
      break;
      this.qXe.setText(String.format(getString(au.i.app_brand_profile_more_like), new Object[] { Integer.valueOf(this.qWH) }));
      break;
      label424:
      this.qXe.setCompoundDrawablesWithIntrinsicBounds(au.e.app_brand_profile_action_like_normal, 0, 0, 0);
      break label288;
      label440:
      this.qXg.setVisibility(8);
      this.qXh.setOnClickListener(null);
      continue;
      this.qXc.setVisibility(0);
      this.qXd.setVisibility(0);
      this.qXf.setVisibility(8);
    }
  }
  
  private void db(View paramView)
  {
    AppMethodBeat.i(48756);
    if (paramView.getVisibility() == 0) {
      paramView.animate().setDuration(200L).alpha(0.0F).withEndAction(new AppBrandProfileUI.18(this, paramView)).start();
    }
    AppMethodBeat.o(48756);
  }
  
  private void eW(int paramInt1, int paramInt2)
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
  
  private void jF(final boolean paramBoolean)
  {
    AppMethodBeat.i(48752);
    com.tencent.mm.cw.g.ijP().a(this).h(new com.tencent.mm.vending.c.a() {}).a(com.tencent.mm.vending.h.d.UI, new d.b() {});
    AppMethodBeat.o(48752);
  }
  
  private void jG(boolean paramBoolean)
  {
    AppMethodBeat.i(268048);
    this.qXu = paramBoolean;
    cjU();
    AppMethodBeat.o(268048);
  }
  
  private void jH(boolean paramBoolean)
  {
    AppMethodBeat.i(268049);
    this.qXv = paramBoolean;
    cjU();
    AppMethodBeat.o(268049);
  }
  
  private void jI(boolean paramBoolean)
  {
    AppMethodBeat.i(268050);
    this.qXt = paramBoolean;
    cjU();
    AppMethodBeat.o(268050);
  }
  
  public final boolean convertActivityFromTranslucent()
  {
    AppMethodBeat.i(268044);
    boolean bool = getIntent().getBooleanExtra("key_can_swipe_back", true);
    AppMethodBeat.o(268044);
    return bool;
  }
  
  public final void dealContentView(View paramView)
  {
    AppMethodBeat.i(48742);
    super.dealContentView(paramView);
    ScrollView localScrollView = new ScrollView(this);
    localScrollView.setVerticalScrollBarEnabled(false);
    localScrollView.setOverScrollMode(2);
    localScrollView.setBackgroundResource(au.c.default_background_color);
    localScrollView.setFillViewport(true);
    this.pQA = new LinearLayout(this);
    this.pQA.setOrientation(1);
    this.pQA.setFocusable(true);
    this.pQA.setFocusableInTouchMode(true);
    localScrollView.addView(this.pQA, new FrameLayout.LayoutParams(-1, -1));
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
    if (this.qXp)
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
      eW(6, 1);
      AppMethodBeat.o(48744);
      return;
      super.finish();
    }
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(268052);
    super.onConfigurationChanged(paramConfiguration);
    cjU();
    AppMethodBeat.o(268052);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48741);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("key_username");
    this.pRV = paramBundle;
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
    this.qXo = ((WxaExposedParams)getIntent().getParcelableExtra("key_scene_exposed_params"));
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
    addIconOptionMenu(0, au.i.app_more, au.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(48718);
        AppBrandProfileUI.a(AppBrandProfileUI.this);
        AppBrandProfileUI.a(AppBrandProfileUI.this, 27, 1);
        AppMethodBeat.o(48718);
        return true;
      }
    });
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getContext().getResources().getColor(au.c.BG_2));
    paramBundle = LayoutInflater.from(this).inflate(au.g.app_brand_profile_ui_header, this.pQA, true);
    paramBundle.setClickable(false);
    paramBundle.setLongClickable(false);
    this.qWJ = ((ImageView)paramBundle.findViewById(au.f.profile_icon));
    this.qWK = ((TextView)paramBundle.findViewById(au.f.profile_name));
    this.qWL = ((TextView)paramBundle.findViewById(au.f.profile_description));
    this.qWM = ((TextView)paramBundle.findViewById(au.f.profile_star_text));
    this.qWN = ((RatingBar)paramBundle.findViewById(au.f.profile_star_bar));
    this.qWO = ((TextView)paramBundle.findViewById(au.f.profile_star_not_enough));
    this.qWP = ((LinearLayout)paramBundle.findViewById(au.f.profile_star_layout));
    this.qWR = ((LinearLayout)paramBundle.findViewById(au.f.profile_service_layout));
    this.qWQ = ((RecyclerView)paramBundle.findViewById(au.f.profile_service_recycler));
    this.qWQ.setItemAnimator(new androidx.recyclerview.widget.g());
    Object localObject = new LinearLayoutManager();
    ((LinearLayoutManager)localObject).setOrientation(0);
    this.qWQ.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.qWQ.a(new AppBrandProfileUI.22(this));
    this.qWS = ((LinearLayout)paramBundle.findViewById(au.f.profile_biz_layout));
    this.qWT = ((LinearLayout)paramBundle.findViewById(au.f.profile_biz_container));
    this.qWU = ((TextView)paramBundle.findViewById(au.f.profile_biz_nickname));
    this.qWV = ((AppBrandNearbyShowcaseView)paramBundle.findViewById(au.f.profile_biz_showcase));
    this.qWV.setIconGap(qWy);
    this.qWV.setIconSize(qWx + qWz * 2);
    db(this.qWT);
    this.qWW = ((LinearLayout)paramBundle.findViewById(au.f.profile_wxa_layout));
    this.qWX = ((LinearLayout)paramBundle.findViewById(au.f.profile_wxa_container));
    this.qWY = ((TextView)paramBundle.findViewById(au.f.profile_wxa_nickname));
    this.qWZ = ((AppBrandNearbyShowcaseView)paramBundle.findViewById(au.f.profile_wxa_showcase));
    this.qWZ.setIconGap(qWy);
    this.qWZ.setIconSize(qWx + qWz * 2);
    db(this.qWX);
    this.qXc = ((FrameLayout)paramBundle.findViewById(au.f.profile_like_layout));
    this.qXd = ((TextView)paramBundle.findViewById(au.f.profile_none_like));
    this.qXe = ((TextView)paramBundle.findViewById(au.f.profile_more_like));
    this.qXg = ((ImageView)paramBundle.findViewById(au.f.profile_like_arrow));
    this.qXi = ((AppBrandNearbyShowcaseView)paramBundle.findViewById(au.f.profile_like_showcase));
    this.qXh = ((LinearLayout)paramBundle.findViewById(au.f.profile_like_container));
    this.qXf = ((LinearLayout)paramBundle.findViewById(au.f.profile_more_like_layout));
    this.qXa = ((LinearLayout)paramBundle.findViewById(au.f.more_info_layout));
    this.qXb = ((TextView)paramBundle.findViewById(au.f.subject_info_content));
    this.qXa.setOnClickListener(new AppBrandProfileUI.19(this));
    this.qXj = ((TextView)paramBundle.findViewById(au.f.profile_about_original));
    this.qXk = paramBundle.findViewById(au.f.profile_about_split);
    this.qXl = ((TextView)paramBundle.findViewById(au.f.profile_protect_teenager));
    localObject = paramBundle.findViewById(au.f.profile_enter_app);
    paramBundle = paramBundle.findViewById(au.f.profile_share_app);
    ((View)localObject).setOnClickListener(new AppBrandProfileUI.20(this));
    paramBundle.setOnClickListener(new AppBrandProfileUI.21(this));
    qWA = getContext().getResources().getColor(au.c.icon_border_color);
    if (this.qXq == null) {
      this.qXq = new com.tencent.mm.plugin.appbrand.ui.widget.a(qWx, qWz, qWA);
    }
    jF(true);
    cjV();
    AppMethodBeat.o(48741);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(48747);
    super.onDestroy();
    com.tencent.mm.plugin.appbrand.config.y.bLB().remove(this);
    AppMethodBeat.o(48747);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(48743);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (!Util.isNullOrNil(this.pRV)) {
      com.tencent.mm.plugin.appbrand.config.y.bLB().remove(this);
    }
    paramIntent = getIntent().getStringExtra("key_username");
    this.pRV = paramIntent;
    if (Util.isNullOrNil(paramIntent))
    {
      finish();
      AppMethodBeat.o(48743);
      return;
    }
    jF(true);
    cjV();
    AppMethodBeat.o(48743);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(48748);
    if ((paramMStorageEventData.eventId == 3) && ((paramMStorageEventData.obj instanceof String)) && (!Util.isNullOrNil(this.pRV)) && (this.pRV.equals((String)paramMStorageEventData.obj))) {
      jF(false);
    }
    AppMethodBeat.o(48748);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(48746);
    super.onPause();
    y.a(this, new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(48746);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(48745);
    super.onResume();
    if (getSwipeBackLayout() != null) {
      getSwipeBackLayout().setEnableGesture(getIntent().getBooleanExtra("key_can_swipe_back", true));
    }
    y.a(this, new com.tencent.mm.vending.c.a() {});
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
    WeakReference<AppBrandProfileUI> qXL;
    
    public a(AppBrandProfileUI paramAppBrandProfileUI)
    {
      AppMethodBeat.i(48732);
      this.qXL = new WeakReference(paramAppBrandProfileUI);
      AppMethodBeat.o(48732);
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.d paramd)
    {
      AppMethodBeat.i(48733);
      if ((this.qXL != null) && (this.qXL.get() != null))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0) && (paramd != null) && (d.c.b(paramd.lBS) != null) && ((d.c.b(paramd.lBS) instanceof cat)))
        {
          Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "queryProfile, request success");
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(48731);
              if ((AppBrandProfileUI.a.this.qXL != null) && (AppBrandProfileUI.a.this.qXL.get() != null)) {
                AppBrandProfileUI.a((AppBrandProfileUI)AppBrandProfileUI.a.this.qXL.get(), this.qXM);
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
  
  static final class b
    implements IPCRunCgi.a
  {
    WeakReference<AppBrandProfileUI> qXL;
    
    public b(AppBrandProfileUI paramAppBrandProfileUI)
    {
      AppMethodBeat.i(48736);
      this.qXL = new WeakReference(paramAppBrandProfileUI);
      AppMethodBeat.o(48736);
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.d paramd)
    {
      AppMethodBeat.i(48737);
      if ((this.qXL != null) && (this.qXL.get() != null))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0) && (paramd != null) && (d.c.b(paramd.lBS) != null) && ((d.c.b(paramd.lBS) instanceof ewx)))
        {
          Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "cgiUpdateUserLike, request success");
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(48734);
              if ((AppBrandProfileUI.b.this.qXL != null) && (AppBrandProfileUI.b.this.qXL.get() != null))
              {
                AppBrandProfileUI localAppBrandProfileUI = (AppBrandProfileUI)AppBrandProfileUI.b.this.qXL.get();
                if (AppBrandProfileUI.s(localAppBrandProfileUI))
                {
                  AppBrandProfileUI.t(localAppBrandProfileUI).removeFirst();
                  AppBrandProfileUI.u(localAppBrandProfileUI);
                  if (AppBrandProfileUI.s(localAppBrandProfileUI)) {
                    break label147;
                  }
                }
                label147:
                for (boolean bool = true;; bool = false)
                {
                  AppBrandProfileUI.a(localAppBrandProfileUI, bool);
                  AppBrandProfileUI.w(localAppBrandProfileUI);
                  if (!AppBrandProfileUI.x(localAppBrandProfileUI)) {
                    break label152;
                  }
                  AppBrandProfileUI.a(localAppBrandProfileUI, 17, 1);
                  AppMethodBeat.o(48734);
                  return;
                  fov localfov = new fov();
                  localfov.UMS = true;
                  localfov.EtG = com.tencent.mm.am.d.Tz(com.tencent.mm.model.z.bcZ());
                  localfov.nickname = com.tencent.mm.model.z.bdb();
                  AppBrandProfileUI.t(localAppBrandProfileUI).addFirst(localfov);
                  AppBrandProfileUI.v(localAppBrandProfileUI);
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
        Log.e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "cgiUpdateUserLike, request fail");
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(48735);
            if ((AppBrandProfileUI.b.this.qXL != null) && (AppBrandProfileUI.b.this.qXL.get() != null))
            {
              AppBrandProfileUI localAppBrandProfileUI = (AppBrandProfileUI)AppBrandProfileUI.b.this.qXL.get();
              if (AppBrandProfileUI.x(localAppBrandProfileUI))
              {
                Toast.makeText(localAppBrandProfileUI, au.i.app_brand_profile_like_fail, 0).show();
                AppBrandProfileUI.a(localAppBrandProfileUI, 17, 2);
                AppMethodBeat.o(48735);
                return;
              }
              Toast.makeText(localAppBrandProfileUI, au.i.app_brand_profile_dislike_fail, 0).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI
 * JD-Core Version:    0.7.0.1
 */