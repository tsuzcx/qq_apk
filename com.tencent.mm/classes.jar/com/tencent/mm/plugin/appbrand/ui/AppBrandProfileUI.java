package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.v;
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
import android.view.View.OnClickListener;
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
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.w.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.config.ae;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.utils.af;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.plugin.profile.model.WxaRegisterInfo;
import com.tencent.mm.plugin.profile.ui.WxaBindBizInfoUI;
import com.tencent.mm.plugin.profile.ui.WxaBindWxaInfoUI;
import com.tencent.mm.protocal.protobuf.bta;
import com.tencent.mm.protocal.protobuf.btb;
import com.tencent.mm.protocal.protobuf.emp;
import com.tencent.mm.protocal.protobuf.fdu;
import com.tencent.mm.protocal.protobuf.fee;
import com.tencent.mm.protocal.protobuf.fef;
import com.tencent.mm.protocal.protobuf.feh;
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
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
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
  private static final String nUV;
  private static final String nUW;
  private static final int nUX;
  private static final int nUY;
  private static final int nUZ;
  private static int nVa;
  private static final int nVb;
  private static final int nVc;
  private static final int nVd;
  private static final int nVe;
  private String krY;
  private LinearLayout mPH;
  private String mRa;
  private ae nRv;
  private LinearLayout nVA;
  private TextView nVB;
  private FrameLayout nVC;
  private TextView nVD;
  private TextView nVE;
  private LinearLayout nVF;
  private ImageView nVG;
  private LinearLayout nVH;
  private AppBrandNearbyShowcaseView nVI;
  private TextView nVJ;
  private View nVK;
  private TextView nVL;
  private int nVM;
  private e nVN;
  private WxaExposedParams nVO;
  private boolean nVP;
  private b.h nVQ;
  private b.h nVR;
  private b.h nVS;
  private boolean nVT;
  private boolean nVU;
  private boolean nVV;
  private String nVW;
  private String nVX;
  private String nVY;
  private Runnable nVZ;
  private boolean nVf;
  private boolean nVg;
  private int nVh;
  private LinkedList<fdu> nVi;
  private ImageView nVj;
  private TextView nVk;
  private TextView nVl;
  private TextView nVm;
  private RatingBar nVn;
  private TextView nVo;
  private LinearLayout nVp;
  private RecyclerView nVq;
  private LinearLayout nVr;
  private LinearLayout nVs;
  private LinearLayout nVt;
  private TextView nVu;
  private AppBrandNearbyShowcaseView nVv;
  private LinearLayout nVw;
  private LinearLayout nVx;
  private TextView nVy;
  private AppBrandNearbyShowcaseView nVz;
  
  static
  {
    AppMethodBeat.i(48769);
    nUV = "https://" + WeChatHosts.domainString(2131761726) + "/mp/wapreportwxadevlog?action=get_page&appid=%s#wechat_redirect";
    nUW = "https://" + WeChatHosts.domainString(2131761713) + "/wap/guard/dist/main/index.html#/Index?source=mini_game";
    nUX = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 24);
    nUY = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 20);
    nUZ = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 2);
    nVa = -1;
    nVb = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 40);
    nVc = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 44);
    nVd = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 32);
    nVe = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 4);
    AppMethodBeat.o(48769);
  }
  
  public AppBrandProfileUI()
  {
    AppMethodBeat.i(48738);
    this.nVf = false;
    this.nVg = false;
    this.nVh = 0;
    this.nVi = new LinkedList();
    this.nVP = false;
    this.krY = "";
    this.nVW = "";
    this.nVX = "";
    this.nVY = "";
    this.nVZ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(227637);
        AppBrandProfileUI.f(AppBrandProfileUI.this).setHighlightColor(AppBrandProfileUI.this.getResources().getColor(17170445));
        AppBrandProfileUI.f(AppBrandProfileUI.this).setText(AppBrandProfileUI.g(AppBrandProfileUI.this));
        AppBrandProfileUI.f(AppBrandProfileUI.this).requestLayout();
        AppBrandProfileUI.f(AppBrandProfileUI.this).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public final void onGlobalLayout()
          {
            AppMethodBeat.i(227636);
            AppBrandProfileUI.f(AppBrandProfileUI.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
            Object localObject2 = new ArrayList();
            Object localObject1;
            if (AppBrandProfileUI.h(AppBrandProfileUI.this))
            {
              localObject1 = af.a(AppBrandProfileUI.this.getContext(), 2131231086, 36, 20, new ClickableSpan()
              {
                public final void onClick(View paramAnonymous3View)
                {
                  AppMethodBeat.i(227633);
                  if (TextUtils.isEmpty(AppBrandProfileUI.i(AppBrandProfileUI.this)))
                  {
                    AppMethodBeat.o(227633);
                    return;
                  }
                  AppBrandProfileUI.a(AppBrandProfileUI.this, 25, 1);
                  com.tencent.mm.br.c.b(AppBrandProfileUI.this, "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", AppBrandProfileUI.i(AppBrandProfileUI.this)).putExtra("forceHideShare", true));
                  Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "click official icon");
                  AppMethodBeat.o(227633);
                }
              });
              ((List)localObject2).add(((Pair)localObject1).first);
            }
            for (int j = ((Integer)((Pair)localObject1).second).intValue() + 0;; j = 0)
            {
              int i = j;
              if (AppBrandProfileUI.j(AppBrandProfileUI.this))
              {
                localObject1 = af.a(AppBrandProfileUI.this.getContext(), 2131231037, 36, 20, new ClickableSpan()
                {
                  public final void onClick(View paramAnonymous3View)
                  {
                    AppMethodBeat.i(227634);
                    if (TextUtils.isEmpty(AppBrandProfileUI.k(AppBrandProfileUI.this)))
                    {
                      AppMethodBeat.o(227634);
                      return;
                    }
                    try
                    {
                      paramAnonymous3View = com.tencent.mm.plugin.appbrand.w.cl(AppBrandProfileUI.k(AppBrandProfileUI.this), "appid=" + AppBrandProfileUI.l(AppBrandProfileUI.this).appId);
                      paramAnonymous3View = new Intent().putExtra("rawUrl", paramAnonymous3View).putExtra("forceHideShare", true);
                      com.tencent.mm.br.c.b(AppBrandProfileUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymous3View);
                      AppBrandProfileUI.a(AppBrandProfileUI.this, 21, 1);
                      Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "click original icon");
                      AppMethodBeat.o(227634);
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
                localObject1 = af.a(AppBrandProfileUI.this.getContext(), 2131231064, 16, 16, new ClickableSpan()
                {
                  public final void onClick(View paramAnonymous3View)
                  {
                    AppMethodBeat.i(227635);
                    if (TextUtils.isEmpty(AppBrandProfileUI.n(AppBrandProfileUI.this)))
                    {
                      AppMethodBeat.o(227635);
                      return;
                    }
                    AppBrandProfileUI.a(AppBrandProfileUI.this, 26, 1);
                    com.tencent.mm.br.c.b(AppBrandProfileUI.this, "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", AppBrandProfileUI.n(AppBrandProfileUI.this)).putExtra("forceHideShare", true));
                    Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "click guarantee icon");
                    AppMethodBeat.o(227635);
                  }
                });
                ((List)localObject2).add(((Pair)localObject1).first);
                j = i + ((Integer)((Pair)localObject1).second).intValue();
              }
              ((List)localObject2).add(af.es(AppBrandProfileUI.this.getContext()).first);
              i = AppBrandProfileUI.f(AppBrandProfileUI.this).getWidth() - AppBrandProfileUI.f(AppBrandProfileUI.this).getPaddingLeft() - AppBrandProfileUI.f(AppBrandProfileUI.this).getPaddingRight();
              TextPaint localTextPaint = AppBrandProfileUI.f(AppBrandProfileUI.this).getPaint();
              if (AppBrandProfileUI.g(AppBrandProfileUI.this) == null) {}
              for (localObject1 = "";; localObject1 = AppBrandProfileUI.g(AppBrandProfileUI.this))
              {
                List localList = af.a(localTextPaint, (CharSequence)localObject1, i);
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
              AppMethodBeat.o(227636);
              return;
            }
          }
        });
        AppBrandProfileUI.f(AppBrandProfileUI.this).setMovementMethod(LinkMovementMethod.getInstance());
        AppMethodBeat.o(227637);
      }
    };
    AppMethodBeat.o(48738);
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong, com.tencent.mm.plugin.appbrand.jsapi.share.z paramz)
  {
    AppMethodBeat.i(227649);
    if (this.nRv == null) {}
    for (String str1 = null; Util.isNullOrNil(str1); str1 = this.nRv.appId)
    {
      Log.e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "profileOperateReport appId null");
      AppMethodBeat.o(227649);
      return;
    }
    int j = getIntent().getIntExtra("key_from_scene", 3);
    String str3 = Util.nullAsNil(getIntent().getStringExtra("key_scene_note"));
    int i = 0;
    Object localObject = n.buC().e(str1, new String[] { "appInfo", "brandIconURL", "nickname" });
    if (localObject != null) {
      i = ((WxaAttributes)localObject).bAn().serviceType;
    }
    int k = i + 1000;
    label153:
    String str2;
    label162:
    String str4;
    if (paramz == null)
    {
      localObject = "";
      if (paramz != null) {
        break label421;
      }
      i = 0;
      if (paramz != null) {
        break label431;
      }
      str2 = "";
      str4 = Util.nullAsNil(str2);
      if (paramz != null) {
        break label441;
      }
      str2 = "";
      label178:
      str2 = URLEncoder.encode(Util.nullAsNil(str2));
      if (paramz != null) {
        break label451;
      }
    }
    label421:
    label431:
    label441:
    label451:
    for (paramz = "";; paramz = paramz.msP)
    {
      paramz = URLEncoder.encode(Util.nullAsNil(paramz));
      Log.d("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "stev report(%s), appId %s, scene %s, sceneNote %s, eventId %s, result %s, appType %s,shareActionId:%s, shareActionType:%d, shareTitle:%s, sharePath:%s, shareImgUrl:%s", new Object[] { Integer.valueOf(13919), str1, Integer.valueOf(j), str3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(k), localObject, Integer.valueOf(i), str4, str2, paramz });
      com.tencent.mm.plugin.report.service.h.CyF.a(13919, new Object[] { str1, Integer.valueOf(j), str3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), Integer.valueOf(k), localObject, Integer.valueOf(i), str4, str2, paramz });
      this.nVM = j;
      AppMethodBeat.o(227649);
      return;
      localObject = paramz.dCC;
      break;
      i = paramz.msM;
      break label153;
      str2 = paramz.msN;
      break label162;
      str2 = paramz.msO;
      break label178;
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
    AppMethodBeat.i(227647);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(227647);
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
        AppMethodBeat.o(227647);
        return;
      }
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().bl(paramString1);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.axQ(), "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI", "show", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;ZLcom/tencent/mm/plugin/appbrand/config/WxaExposedParams;Landroid/os/Bundle;Lcom/tencent/luggage/sdk/launching/ActivityStarterIpcDelegate;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI", "show", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;ZLcom/tencent/mm/plugin/appbrand/config/WxaExposedParams;Landroid/os/Bundle;Lcom/tencent/luggage/sdk/launching/ActivityStarterIpcDelegate;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(227647);
      return;
    }
  }
  
  private void bXp()
  {
    AppMethodBeat.i(227653);
    MMHandlerThread.removeRunnable(this.nVZ);
    MMHandlerThread.postToMainThread(this.nVZ);
    AppMethodBeat.o(227653);
  }
  
  private void bXq()
  {
    AppMethodBeat.i(48753);
    if (!Util.isNullOrNil(this.mRa))
    {
      Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "queryProfile start");
      bta localbta = new bta();
      localbta.username = this.mRa;
      d.a locala = new d.a();
      locala.funcId = 2921;
      locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getprofileinfo";
      locala.iLN = localbta;
      locala.iLO = new btb();
      IPCRunCgi.a(locala.aXF(), new a(this));
    }
    AppMethodBeat.o(48753);
  }
  
  private void bXr()
  {
    AppMethodBeat.i(48754);
    if ((this.nVi != null) && (this.nVi.size() > 0))
    {
      this.nVC.setVisibility(0);
      this.nVF.setVisibility(0);
      this.nVD.setVisibility(8);
      this.nVI.setIconGap(nVc);
      this.nVI.setIconSize(nVb);
      this.nVI.setIconLayerCount(Math.min(this.nVi.size(), 3));
      if (this.nVR == null) {
        this.nVR = new com.tencent.mm.plugin.appbrand.ui.b.a(nVd);
      }
      if (this.nVS == null) {
        this.nVS = new com.tencent.mm.plugin.appbrand.ui.b.a(nVe);
      }
      int i = 0;
      if (i < this.nVI.getChildCount())
      {
        String str;
        label167:
        com.tencent.mm.modelappbrand.a.b localb;
        ImageView localImageView;
        if (this.nVi.size() > i)
        {
          str = ((fdu)this.nVi.get(i)).yPH;
          localb = com.tencent.mm.modelappbrand.a.b.aXY();
          localImageView = this.nVI.zK(i);
          if ((str != null) && (!str.startsWith("http"))) {
            break label226;
          }
        }
        label226:
        for (b.h localh = this.nVR;; localh = this.nVS)
        {
          localb.a(localImageView, str, 2131231957, localh);
          i += 1;
          break;
          str = null;
          break label167;
        }
      }
      if (this.nVh == 1) {
        if (this.nVf)
        {
          this.nVE.setText(getString(2131755639));
          if (!this.nVf) {
            break label419;
          }
          this.nVE.setCompoundDrawablesWithIntrinsicBounds(2131231034, 0, 0, 0);
          label283:
          if (this.nVh <= 3) {
            break label435;
          }
          this.nVG.setVisibility(0);
          this.nVH.setOnClickListener(new AppBrandProfileUI.15(this));
        }
      }
    }
    for (;;)
    {
      this.nVD.setOnClickListener(new AppBrandProfileUI.16(this));
      this.nVE.setOnClickListener(new AppBrandProfileUI.17(this));
      AppMethodBeat.o(48754);
      return;
      this.nVE.setText(String.format(getString(2131755641), new Object[] { Integer.valueOf(this.nVh) }));
      break;
      this.nVE.setText(String.format(getString(2131755641), new Object[] { Integer.valueOf(this.nVh) }));
      break;
      label419:
      this.nVE.setCompoundDrawablesWithIntrinsicBounds(2131231033, 0, 0, 0);
      break label283;
      label435:
      this.nVG.setVisibility(8);
      this.nVH.setOnClickListener(null);
      continue;
      this.nVC.setVisibility(0);
      this.nVD.setVisibility(0);
      this.nVF.setVisibility(8);
    }
  }
  
  private void cH(View paramView)
  {
    AppMethodBeat.i(48756);
    if (paramView.getVisibility() == 0) {
      paramView.animate().setDuration(200L).alpha(0.0F).withEndAction(new AppBrandProfileUI.18(this, paramView)).start();
    }
    AppMethodBeat.o(48756);
  }
  
  private void ex(int paramInt1, int paramInt2)
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
  
  private void iJ(final boolean paramBoolean)
  {
    AppMethodBeat.i(48752);
    com.tencent.mm.co.g.hio().a(this).h(new com.tencent.mm.vending.c.a() {}).a(com.tencent.mm.vending.h.d.UI, new d.b() {});
    AppMethodBeat.o(48752);
  }
  
  private void iK(boolean paramBoolean)
  {
    AppMethodBeat.i(227650);
    this.nVU = paramBoolean;
    bXp();
    AppMethodBeat.o(227650);
  }
  
  private void iL(boolean paramBoolean)
  {
    AppMethodBeat.i(227651);
    this.nVV = paramBoolean;
    bXp();
    AppMethodBeat.o(227651);
  }
  
  private void iM(boolean paramBoolean)
  {
    AppMethodBeat.i(227652);
    this.nVT = paramBoolean;
    bXp();
    AppMethodBeat.o(227652);
  }
  
  public final boolean convertActivityFromTranslucent()
  {
    AppMethodBeat.i(227648);
    boolean bool = getIntent().getBooleanExtra("key_can_swipe_back", true);
    AppMethodBeat.o(227648);
    return bool;
  }
  
  public final void dealContentView(View paramView)
  {
    AppMethodBeat.i(48742);
    super.dealContentView(paramView);
    ScrollView localScrollView = new ScrollView(this);
    localScrollView.setVerticalScrollBarEnabled(false);
    localScrollView.setOverScrollMode(2);
    localScrollView.setBackgroundResource(2131100240);
    localScrollView.setFillViewport(true);
    this.mPH = new LinearLayout(this);
    this.mPH.setOrientation(1);
    this.mPH.setFocusable(true);
    this.mPH.setFocusableInTouchMode(true);
    localScrollView.addView(this.mPH, new FrameLayout.LayoutParams(-1, -1));
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
    if (this.nVP)
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
      ex(6, 1);
      AppMethodBeat.o(48744);
      return;
      super.finish();
    }
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(227654);
    super.onConfigurationChanged(paramConfiguration);
    bXp();
    AppMethodBeat.o(227654);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48741);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("key_username");
    this.mRa = paramBundle;
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
    this.nVO = ((WxaExposedParams)getIntent().getParcelableExtra("key_scene_exposed_params"));
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
    addIconOptionMenu(0, 2131755899, 2131690843, new MenuItem.OnMenuItemClickListener()
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
    setActionbarColor(getContext().getResources().getColor(2131099650));
    paramBundle = LayoutInflater.from(this).inflate(2131493070, this.mPH, true);
    paramBundle.setClickable(false);
    paramBundle.setLongClickable(false);
    this.nVj = ((ImageView)paramBundle.findViewById(2131306203));
    this.nVk = ((TextView)paramBundle.findViewById(2131306237));
    this.nVl = ((TextView)paramBundle.findViewById(2131306194));
    this.nVm = ((TextView)paramBundle.findViewById(2131306262));
    this.nVn = ((RatingBar)paramBundle.findViewById(2131306259));
    this.nVo = ((TextView)paramBundle.findViewById(2131306261));
    this.nVp = ((LinearLayout)paramBundle.findViewById(2131306260));
    this.nVr = ((LinearLayout)paramBundle.findViewById(2131306256));
    this.nVq = ((RecyclerView)paramBundle.findViewById(2131306257));
    this.nVq.setItemAnimator(new v());
    Object localObject = new LinearLayoutManager();
    ((LinearLayoutManager)localObject).setOrientation(0);
    this.nVq.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.nVq.a(new AppBrandProfileUI.22(this));
    this.nVs = ((LinearLayout)paramBundle.findViewById(2131306187));
    this.nVt = ((LinearLayout)paramBundle.findViewById(2131306185));
    this.nVu = ((TextView)paramBundle.findViewById(2131306189));
    this.nVv = ((AppBrandNearbyShowcaseView)paramBundle.findViewById(2131306190));
    this.nVv.setIconGap(nUY);
    this.nVv.setIconSize(nUX + nUZ * 2);
    cH(this.nVt);
    this.nVw = ((LinearLayout)paramBundle.findViewById(2131306278));
    this.nVx = ((LinearLayout)paramBundle.findViewById(2131306277));
    this.nVy = ((TextView)paramBundle.findViewById(2131306279));
    this.nVz = ((AppBrandNearbyShowcaseView)paramBundle.findViewById(2131306280));
    this.nVz.setIconGap(nUY);
    this.nVz.setIconSize(nUX + nUZ * 2);
    cH(this.nVx);
    this.nVC = ((FrameLayout)paramBundle.findViewById(2131306214));
    this.nVD = ((TextView)paramBundle.findViewById(2131306238));
    this.nVE = ((TextView)paramBundle.findViewById(2131306218));
    this.nVG = ((ImageView)paramBundle.findViewById(2131306211));
    this.nVI = ((AppBrandNearbyShowcaseView)paramBundle.findViewById(2131306215));
    this.nVH = ((LinearLayout)paramBundle.findViewById(2131306212));
    this.nVF = ((LinearLayout)paramBundle.findViewById(2131306219));
    this.nVA = ((LinearLayout)paramBundle.findViewById(2131304885));
    this.nVB = ((TextView)paramBundle.findViewById(2131308725));
    this.nVA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(48724);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((AppBrandProfileUI.b(AppBrandProfileUI.this) != null) && (!Util.isNullOrNil(AppBrandProfileUI.b(AppBrandProfileUI.this).appId)))
        {
          com.tencent.mm.br.c.b(AppBrandProfileUI.this, "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", com.tencent.mm.plugin.appbrand.w.Uq(AppBrandProfileUI.b(AppBrandProfileUI.this).appId)).putExtra("forceHideShare", true));
          AppBrandProfileUI.a(AppBrandProfileUI.this, 16, 1);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(48724);
      }
    });
    this.nVJ = ((TextView)paramBundle.findViewById(2131306175));
    this.nVK = paramBundle.findViewById(2131306176);
    this.nVL = ((TextView)paramBundle.findViewById(2131306243));
    localObject = paramBundle.findViewById(2131306200);
    paramBundle = paramBundle.findViewById(2131306258);
    ((View)localObject).setOnClickListener(new AppBrandProfileUI.20(this));
    paramBundle.setOnClickListener(new AppBrandProfileUI.21(this));
    nVa = getContext().getResources().getColor(2131100633);
    if (this.nVQ == null) {
      this.nVQ = new com.tencent.mm.plugin.appbrand.ui.widget.a(nUX, nUZ, nVa);
    }
    iJ(true);
    bXq();
    AppMethodBeat.o(48741);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(48747);
    super.onDestroy();
    com.tencent.mm.plugin.appbrand.config.y.bAj().remove(this);
    AppMethodBeat.o(48747);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(48743);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (!Util.isNullOrNil(this.mRa)) {
      com.tencent.mm.plugin.appbrand.config.y.bAj().remove(this);
    }
    paramIntent = getIntent().getStringExtra("key_username");
    this.mRa = paramIntent;
    if (Util.isNullOrNil(paramIntent))
    {
      finish();
      AppMethodBeat.o(48743);
      return;
    }
    iJ(true);
    bXq();
    AppMethodBeat.o(48743);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(48748);
    if ((paramMStorageEventData.eventId == 3) && ((paramMStorageEventData.obj instanceof String)) && (!Util.isNullOrNil(this.mRa)) && (this.mRa.equals((String)paramMStorageEventData.obj))) {
      iJ(false);
    }
    AppMethodBeat.o(48748);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(48746);
    super.onPause();
    z.a(this, new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(48746);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(48745);
    super.onResume();
    if (getSwipeBackLayout() != null) {
      getSwipeBackLayout().setEnableGesture(getIntent().getBooleanExtra("key_can_swipe_back", true));
    }
    z.a(this, new com.tencent.mm.vending.c.a() {});
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
    WeakReference<AppBrandProfileUI> nWl;
    
    public a(AppBrandProfileUI paramAppBrandProfileUI)
    {
      AppMethodBeat.i(48732);
      this.nWl = new WeakReference(paramAppBrandProfileUI);
      AppMethodBeat.o(48732);
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.d paramd)
    {
      AppMethodBeat.i(48733);
      if ((this.nWl != null) && (this.nWl.get() != null))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0) && (paramd != null) && (paramd.iLL.iLR != null) && ((paramd.iLL.iLR instanceof btb)))
        {
          Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "queryProfile, request success");
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(48731);
              if ((AppBrandProfileUI.a.this.nWl != null) && (AppBrandProfileUI.a.this.nWl.get() != null)) {
                AppBrandProfileUI.a((AppBrandProfileUI)AppBrandProfileUI.a.this.nWl.get(), this.nWm);
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
    WeakReference<AppBrandProfileUI> nWl;
    
    public b(AppBrandProfileUI paramAppBrandProfileUI)
    {
      AppMethodBeat.i(48736);
      this.nWl = new WeakReference(paramAppBrandProfileUI);
      AppMethodBeat.o(48736);
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.d paramd)
    {
      AppMethodBeat.i(48737);
      if ((this.nWl != null) && (this.nWl.get() != null))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0) && (paramd != null) && (paramd.iLL.iLR != null) && ((paramd.iLL.iLR instanceof emp)))
        {
          Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "cgiUpdateUserLike, request success");
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(48734);
              if ((AppBrandProfileUI.b.this.nWl != null) && (AppBrandProfileUI.b.this.nWl.get() != null))
              {
                AppBrandProfileUI localAppBrandProfileUI = (AppBrandProfileUI)AppBrandProfileUI.b.this.nWl.get();
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
                  fdu localfdu = new fdu();
                  localfdu.Nzp = true;
                  localfdu.yPH = com.tencent.mm.aj.c.Me(com.tencent.mm.model.z.aTY());
                  localfdu.nickname = com.tencent.mm.model.z.aUa();
                  AppBrandProfileUI.t(localAppBrandProfileUI).addFirst(localfdu);
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
            if ((AppBrandProfileUI.b.this.nWl != null) && (AppBrandProfileUI.b.this.nWl.get() != null))
            {
              AppBrandProfileUI localAppBrandProfileUI = (AppBrandProfileUI)AppBrandProfileUI.b.this.nWl.get();
              if (AppBrandProfileUI.x(localAppBrandProfileUI))
              {
                Toast.makeText(localAppBrandProfileUI, 2131755638, 0).show();
                AppBrandProfileUI.a(localAppBrandProfileUI, 17, 2);
                AppMethodBeat.o(48735);
                return;
              }
              Toast.makeText(localAppBrandProfileUI, 2131755635, 0).show();
              AppBrandProfileUI.a(localAppBrandProfileUI, 18, 2);
            }
            AppMethodBeat.o(48735);
          }
        });
      }
      AppMethodBeat.o(48737);
    }
  }
  
  static final class c
  {
    public final List<feh> nWp;
    
    public c(List<feh> paramList)
    {
      this.nWp = paramList;
    }
    
    public final int size()
    {
      AppMethodBeat.i(227646);
      if ((this.nWp == null) || (this.nWp.isEmpty()))
      {
        AppMethodBeat.o(227646);
        return 0;
      }
      Iterator localIterator = this.nWp.iterator();
      label43:
      feh localfeh;
      for (int i = 0; localIterator.hasNext(); i = localfeh.Nzy.size() + i)
      {
        localfeh = (feh)localIterator.next();
        if ((localfeh == null) || (localfeh.Nzy == null) || (localfeh.Nzy.isEmpty())) {
          break label43;
        }
      }
      AppMethodBeat.o(227646);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI
 * JD-Core Version:    0.7.0.1
 */