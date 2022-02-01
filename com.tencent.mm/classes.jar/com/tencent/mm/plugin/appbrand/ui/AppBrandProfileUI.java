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
import android.support.v7.widget.RecyclerView.i;
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
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.br.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.ab;
import com.tencent.mm.plugin.appbrand.config.w;
import com.tencent.mm.plugin.appbrand.config.x;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.appbrand.utils.af;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.protocal.protobuf.bhc;
import com.tencent.mm.protocal.protobuf.bhd;
import com.tencent.mm.protocal.protobuf.dsr;
import com.tencent.mm.protocal.protobuf.ejc;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
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
  private static final int mHY;
  private static final int mHZ;
  private static final int mIa;
  private static int mIb;
  private static final int mIc;
  private static final int mIe;
  private static final int mIf;
  private static final int mIg;
  private String jtJ;
  private LinearLayout lHS;
  private String lJm;
  private ab mEE;
  private TextView mIA;
  private AppBrandNearbyShowcaseView mIB;
  private LinearLayout mIC;
  private TextView mIE;
  private FrameLayout mIF;
  private TextView mIG;
  private TextView mIH;
  private LinearLayout mII;
  private ImageView mIJ;
  private LinearLayout mIK;
  private AppBrandNearbyShowcaseView mIL;
  private TextView mIM;
  private View mIN;
  private TextView mIO;
  private int mIP;
  private e mIQ;
  private WxaExposedParams mIR;
  private boolean mIS;
  private b.h mIT;
  private b.h mIU;
  private b.h mIV;
  private boolean mIW;
  private boolean mIX;
  private boolean mIY;
  private String mIZ;
  private boolean mIh;
  private boolean mIi;
  private int mIj;
  private LinkedList<ejc> mIk;
  private ImageView mIl;
  private TextView mIm;
  private TextView mIn;
  private TextView mIo;
  private RatingBar mIp;
  private TextView mIq;
  private LinearLayout mIr;
  private RecyclerView mIs;
  private LinearLayout mIt;
  private LinearLayout mIu;
  private LinearLayout mIv;
  private TextView mIw;
  private AppBrandNearbyShowcaseView mIx;
  private LinearLayout mIy;
  private LinearLayout mIz;
  private String mJa;
  private String mJb;
  private Runnable mJc;
  
  static
  {
    AppMethodBeat.i(48769);
    mHY = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 24);
    mHZ = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 20);
    mIa = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 2);
    mIb = -1;
    mIc = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 40);
    mIe = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 44);
    mIf = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 32);
    mIg = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 4);
    AppMethodBeat.o(48769);
  }
  
  public AppBrandProfileUI()
  {
    AppMethodBeat.i(48738);
    this.mIh = false;
    this.mIi = false;
    this.mIj = 0;
    this.mIk = new LinkedList();
    this.mIS = false;
    this.jtJ = "";
    this.mIZ = "";
    this.mJa = "";
    this.mJb = "";
    this.mJc = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(223113);
        AppBrandProfileUI.f(AppBrandProfileUI.this).setHighlightColor(AppBrandProfileUI.this.getResources().getColor(17170445));
        AppBrandProfileUI.f(AppBrandProfileUI.this).setText(AppBrandProfileUI.g(AppBrandProfileUI.this));
        AppBrandProfileUI.f(AppBrandProfileUI.this).requestLayout();
        AppBrandProfileUI.f(AppBrandProfileUI.this).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public final void onGlobalLayout()
          {
            AppMethodBeat.i(223112);
            AppBrandProfileUI.f(AppBrandProfileUI.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
            Object localObject2 = new ArrayList();
            Object localObject1;
            if (AppBrandProfileUI.h(AppBrandProfileUI.this))
            {
              localObject1 = af.a(AppBrandProfileUI.this.getContext(), 2131234977, 36, 20, new ClickableSpan()
              {
                public final void onClick(View paramAnonymous3View)
                {
                  AppMethodBeat.i(223109);
                  if (TextUtils.isEmpty(AppBrandProfileUI.i(AppBrandProfileUI.this)))
                  {
                    AppMethodBeat.o(223109);
                    return;
                  }
                  AppBrandProfileUI.a(AppBrandProfileUI.this, 25, 1);
                  d.b(AppBrandProfileUI.this, "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", AppBrandProfileUI.i(AppBrandProfileUI.this)).putExtra("forceHideShare", true));
                  ae.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "click official icon");
                  AppMethodBeat.o(223109);
                }
              });
              ((List)localObject2).add(((Pair)localObject1).first);
            }
            for (int j = ((Integer)((Pair)localObject1).second).intValue() + 0;; j = 0)
            {
              int i = j;
              if (AppBrandProfileUI.j(AppBrandProfileUI.this))
              {
                localObject1 = af.a(AppBrandProfileUI.this.getContext(), 2131232342, 36, 20, new ClickableSpan()
                {
                  public final void onClick(View paramAnonymous3View)
                  {
                    AppMethodBeat.i(223110);
                    if (TextUtils.isEmpty(AppBrandProfileUI.k(AppBrandProfileUI.this)))
                    {
                      AppMethodBeat.o(223110);
                      return;
                    }
                    try
                    {
                      paramAnonymous3View = com.tencent.mm.plugin.appbrand.v.bY(AppBrandProfileUI.k(AppBrandProfileUI.this), "appid=" + AppBrandProfileUI.l(AppBrandProfileUI.this).appId);
                      paramAnonymous3View = new Intent().putExtra("rawUrl", paramAnonymous3View).putExtra("forceHideShare", true);
                      d.b(AppBrandProfileUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymous3View);
                      AppBrandProfileUI.a(AppBrandProfileUI.this, 21, 1);
                      ae.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "click original icon");
                      AppMethodBeat.o(223110);
                      return;
                    }
                    catch (URISyntaxException paramAnonymous3View)
                    {
                      for (;;)
                      {
                        ae.printErrStackTrace("MicroMsg.AppBrand.Profile.AppBrandProfileUI", paramAnonymous3View, "URISyntaxException with originalRedirectUrl %s", new Object[] { AppBrandProfileUI.k(AppBrandProfileUI.this) });
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
                localObject1 = af.a(AppBrandProfileUI.this.getContext(), 2131232380, 16, 16, new ClickableSpan()
                {
                  public final void onClick(View paramAnonymous3View)
                  {
                    AppMethodBeat.i(223111);
                    if (TextUtils.isEmpty(AppBrandProfileUI.n(AppBrandProfileUI.this)))
                    {
                      AppMethodBeat.o(223111);
                      return;
                    }
                    AppBrandProfileUI.a(AppBrandProfileUI.this, 26, 1);
                    d.b(AppBrandProfileUI.this, "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", AppBrandProfileUI.n(AppBrandProfileUI.this)).putExtra("forceHideShare", true));
                    ae.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "click guarantee icon");
                    AppMethodBeat.o(223111);
                  }
                });
                ((List)localObject2).add(((Pair)localObject1).first);
                j = i + ((Integer)((Pair)localObject1).second).intValue();
              }
              ((List)localObject2).add(af.dV(AppBrandProfileUI.this.getContext()).first);
              i = AppBrandProfileUI.f(AppBrandProfileUI.this).getWidth() - AppBrandProfileUI.f(AppBrandProfileUI.this).getPaddingLeft() - AppBrandProfileUI.f(AppBrandProfileUI.this).getPaddingRight();
              TextPaint localTextPaint = AppBrandProfileUI.f(AppBrandProfileUI.this).getPaint();
              List localList = af.a(localTextPaint, AppBrandProfileUI.g(AppBrandProfileUI.this), i);
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
              AppMethodBeat.o(223112);
              return;
            }
          }
        });
        AppBrandProfileUI.f(AppBrandProfileUI.this).setMovementMethod(LinkMovementMethod.getInstance());
        AppMethodBeat.o(223113);
      }
    };
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
    a(paramContext, paramString1, paramInt, paramString2, true, paramWxaExposedParams, paramBundle, paramActivityStarterIpcDelegate, -1);
    AppMethodBeat.o(48740);
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt1, String paramString2, boolean paramBoolean, WxaExposedParams paramWxaExposedParams, Bundle paramBundle, ActivityStarterIpcDelegate paramActivityStarterIpcDelegate, int paramInt2)
  {
    AppMethodBeat.i(223116);
    if (bu.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(223116);
      return;
    }
    if (paramContext == null) {
      paramContext = ak.getContext();
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
        AppMethodBeat.o(223116);
        return;
      }
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().bc(paramString1);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.ahE(), "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI", "show", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;ZLcom/tencent/mm/plugin/appbrand/config/WxaExposedParams;Landroid/os/Bundle;Lcom/tencent/luggage/sdk/launching/ActivityStarterIpcDelegate;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI", "show", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;ZLcom/tencent/mm/plugin/appbrand/config/WxaExposedParams;Landroid/os/Bundle;Lcom/tencent/luggage/sdk/launching/ActivityStarterIpcDelegate;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(223116);
      return;
    }
  }
  
  private void bAq()
  {
    AppMethodBeat.i(223121);
    ar.ay(this.mJc);
    ar.f(this.mJc);
    AppMethodBeat.o(223121);
  }
  
  private void bAr()
  {
    AppMethodBeat.i(48753);
    if (!bu.isNullOrNil(this.lJm))
    {
      ae.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "queryProfile start");
      bhc localbhc = new bhc();
      localbhc.username = this.lJm;
      b.a locala = new b.a();
      locala.funcId = 2921;
      locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getprofileinfo";
      locala.hQF = localbhc;
      locala.hQG = new bhd();
      IPCRunCgi.a(locala.aDS(), new a(this));
    }
    AppMethodBeat.o(48753);
  }
  
  private void bAs()
  {
    AppMethodBeat.i(48754);
    if ((this.mIk != null) && (this.mIk.size() > 0))
    {
      this.mIF.setVisibility(0);
      this.mII.setVisibility(0);
      this.mIG.setVisibility(8);
      this.mIL.setIconGap(mIe);
      this.mIL.setIconSize(mIc);
      this.mIL.setIconLayerCount(Math.min(this.mIk.size(), 3));
      if (this.mIU == null) {
        this.mIU = new com.tencent.mm.plugin.appbrand.ui.b.a(mIf);
      }
      if (this.mIV == null) {
        this.mIV = new com.tencent.mm.plugin.appbrand.ui.b.a(mIg);
      }
      int i = 0;
      if (i < this.mIL.getChildCount())
      {
        String str;
        label167:
        com.tencent.mm.modelappbrand.a.b localb;
        ImageView localImageView;
        if (this.mIk.size() > i)
        {
          str = ((ejc)this.mIk.get(i)).vvt;
          localb = com.tencent.mm.modelappbrand.a.b.aEl();
          localImageView = this.mIL.vV(i);
          if ((str != null) && (!str.startsWith("http"))) {
            break label226;
          }
        }
        label226:
        for (b.h localh = this.mIU;; localh = this.mIV)
        {
          localb.a(localImageView, str, 2131231875, localh);
          i += 1;
          break;
          str = null;
          break label167;
        }
      }
      if (this.mIj == 1) {
        if (this.mIh)
        {
          this.mIH.setText(getString(2131755595));
          if (!this.mIh) {
            break label419;
          }
          this.mIH.setCompoundDrawablesWithIntrinsicBounds(2131231003, 0, 0, 0);
          label283:
          if (this.mIj <= 3) {
            break label435;
          }
          this.mIJ.setVisibility(0);
          this.mIK.setOnClickListener(new AppBrandProfileUI.14(this));
        }
      }
    }
    for (;;)
    {
      this.mIG.setOnClickListener(new AppBrandProfileUI.15(this));
      this.mIH.setOnClickListener(new AppBrandProfileUI.16(this));
      AppMethodBeat.o(48754);
      return;
      this.mIH.setText(String.format(getString(2131755597), new Object[] { Integer.valueOf(this.mIj) }));
      break;
      this.mIH.setText(String.format(getString(2131755597), new Object[] { Integer.valueOf(this.mIj) }));
      break;
      label419:
      this.mIH.setCompoundDrawablesWithIntrinsicBounds(2131231002, 0, 0, 0);
      break label283;
      label435:
      this.mIJ.setVisibility(8);
      this.mIK.setOnClickListener(null);
      continue;
      this.mIF.setVisibility(0);
      this.mIG.setVisibility(0);
      this.mII.setVisibility(8);
    }
  }
  
  private void cO(View paramView)
  {
    AppMethodBeat.i(48756);
    if (paramView.getVisibility() == 0) {
      paramView.animate().setDuration(200L).alpha(0.0F).withEndAction(new AppBrandProfileUI.17(this, paramView)).start();
    }
    AppMethodBeat.o(48756);
  }
  
  private void e(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(48751);
    if (this.mEE == null) {}
    for (String str1 = null; bu.isNullOrNil(str1); str1 = this.mEE.appId)
    {
      ae.e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "profileOperateReport appId null");
      AppMethodBeat.o(48751);
      return;
    }
    int j = getIntent().getIntExtra("key_from_scene", 3);
    String str2 = bu.nullAsNil(getIntent().getStringExtra("key_scene_note"));
    int i = 0;
    WxaAttributes localWxaAttributes = j.aZl().e(str1, new String[] { "appInfo", "brandIconURL", "nickname" });
    if (localWxaAttributes != null) {
      i = localWxaAttributes.beT().cRx;
    }
    i += 1000;
    ae.d("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "stev report(%s), appId %s, scene %s, sceneNote %s, eventId %s, result %s, appType %s", new Object[] { Integer.valueOf(13919), str1, Integer.valueOf(j), str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
    com.tencent.mm.plugin.report.service.g.yxI.f(13919, new Object[] { str1, Integer.valueOf(j), str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), Integer.valueOf(i) });
    this.mIP = j;
    AppMethodBeat.o(48751);
  }
  
  private void ej(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(48750);
    e(paramInt1, paramInt2, bu.aRi());
    AppMethodBeat.o(48750);
  }
  
  private static void f(View paramView, Runnable paramRunnable)
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
  
  private void hG(final boolean paramBoolean)
  {
    AppMethodBeat.i(48752);
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48708);
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(48707);
            AppBrandProfileUI.a(AppBrandProfileUI.this, this.mJf);
            if ((AppBrandProfileUI.4.this.mJe) && (!AppBrandProfileUI.this.isFinishing()) && (!AppBrandProfileUI.this.activityHasDestroyed()))
            {
              com.tencent.mm.plugin.appbrand.config.v.beQ().add(AppBrandProfileUI.this);
              AppBrandProfileUI.a(AppBrandProfileUI.this, 1, 1);
            }
            AppMethodBeat.o(48707);
          }
        });
        if (paramBoolean) {
          x.Ou(AppBrandProfileUI.d(AppBrandProfileUI.this));
        }
        AppMethodBeat.o(48708);
      }
    }, "AppBrandProfile");
    AppMethodBeat.o(48752);
  }
  
  private void hH(boolean paramBoolean)
  {
    AppMethodBeat.i(223118);
    this.mIX = paramBoolean;
    bAq();
    AppMethodBeat.o(223118);
  }
  
  private void hI(boolean paramBoolean)
  {
    AppMethodBeat.i(223119);
    this.mIY = paramBoolean;
    bAq();
    AppMethodBeat.o(223119);
  }
  
  private void hJ(boolean paramBoolean)
  {
    AppMethodBeat.i(223120);
    this.mIW = paramBoolean;
    bAq();
    AppMethodBeat.o(223120);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(48748);
    if ((paramm.duP == 3) && ((paramm.obj instanceof String)) && (!bu.isNullOrNil(this.lJm)) && (this.lJm.equals((String)paramm.obj))) {
      hG(false);
    }
    AppMethodBeat.o(48748);
  }
  
  public final boolean convertActivityFromTranslucent()
  {
    AppMethodBeat.i(223117);
    boolean bool = getIntent().getBooleanExtra("key_can_swipe_back", true);
    AppMethodBeat.o(223117);
    return bool;
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
    this.lHS = new LinearLayout(this);
    this.lHS.setOrientation(1);
    this.lHS.setFocusable(true);
    this.lHS.setFocusableInTouchMode(true);
    localScrollView.addView(this.lHS, new FrameLayout.LayoutParams(-1, -1));
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
    if (this.mIS)
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
      ej(6, 1);
      AppMethodBeat.o(48744);
      return;
      super.finish();
    }
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(223122);
    super.onConfigurationChanged(paramConfiguration);
    bAq();
    AppMethodBeat.o(223122);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48741);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("key_username");
    this.lJm = paramBundle;
    if (bu.isNullOrNil(paramBundle))
    {
      finish();
      AppMethodBeat.o(48741);
      return;
    }
    if ((getIntent().getExtras() != null) && (!getIntent().getExtras().containsKey("key_extra_bundle"))) {
      getIntent().getExtras().putBundle("key_extra_bundle", Bundle.EMPTY);
    }
    getIntent().setExtrasClassLoader(getClassLoader());
    this.mIR = ((WxaExposedParams)getIntent().getParcelableExtra("key_scene_exposed_params"));
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
        AppBrandProfileUI.a(AppBrandProfileUI.this, 27, 1);
        AppMethodBeat.o(48718);
        return true;
      }
    });
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getContext().getResources().getColor(2131099650));
    paramBundle = LayoutInflater.from(this).inflate(2131493031, this.lHS, true);
    paramBundle.setClickable(false);
    paramBundle.setLongClickable(false);
    this.mIl = ((ImageView)paramBundle.findViewById(2131303463));
    this.mIm = ((TextView)paramBundle.findViewById(2131303478));
    this.mIn = ((TextView)paramBundle.findViewById(2131303457));
    this.mIo = ((TextView)paramBundle.findViewById(2131303499));
    this.mIp = ((RatingBar)paramBundle.findViewById(2131303496));
    this.mIq = ((TextView)paramBundle.findViewById(2131303498));
    this.mIr = ((LinearLayout)paramBundle.findViewById(2131303497));
    this.mIt = ((LinearLayout)paramBundle.findViewById(2131303493));
    this.mIs = ((RecyclerView)paramBundle.findViewById(2131303494));
    this.mIs.setItemAnimator(new android.support.v7.widget.v());
    Object localObject = new LinearLayoutManager();
    ((LinearLayoutManager)localObject).setOrientation(0);
    this.mIs.setLayoutManager((RecyclerView.i)localObject);
    this.mIs.a(new AppBrandProfileUI.21(this));
    this.mIu = ((LinearLayout)paramBundle.findViewById(2131303452));
    this.mIv = ((LinearLayout)paramBundle.findViewById(2131303450));
    this.mIw = ((TextView)paramBundle.findViewById(2131303454));
    this.mIx = ((AppBrandNearbyShowcaseView)paramBundle.findViewById(2131303455));
    this.mIx.setIconGap(mHZ);
    this.mIx.setIconSize(mHY + mIa * 2);
    cO(this.mIv);
    this.mIy = ((LinearLayout)paramBundle.findViewById(2131303512));
    this.mIz = ((LinearLayout)paramBundle.findViewById(2131303511));
    this.mIA = ((TextView)paramBundle.findViewById(2131303513));
    this.mIB = ((AppBrandNearbyShowcaseView)paramBundle.findViewById(2131303514));
    this.mIB.setIconGap(mHZ);
    this.mIB.setIconSize(mHY + mIa * 2);
    cO(this.mIz);
    this.mIF = ((FrameLayout)paramBundle.findViewById(2131303472));
    this.mIG = ((TextView)paramBundle.findViewById(2131303479));
    this.mIH = ((TextView)paramBundle.findViewById(2131303476));
    this.mIJ = ((ImageView)paramBundle.findViewById(2131303469));
    this.mIL = ((AppBrandNearbyShowcaseView)paramBundle.findViewById(2131303473));
    this.mIK = ((LinearLayout)paramBundle.findViewById(2131303470));
    this.mII = ((LinearLayout)paramBundle.findViewById(2131303477));
    this.mIC = ((LinearLayout)paramBundle.findViewById(2131308155));
    this.mIE = ((TextView)paramBundle.findViewById(2131308215));
    this.mIC.setOnClickListener(new AppBrandProfileUI.18(this));
    this.mIM = ((TextView)paramBundle.findViewById(2131303441));
    this.mIN = paramBundle.findViewById(2131303442);
    this.mIO = ((TextView)paramBundle.findViewById(2131303485));
    localObject = paramBundle.findViewById(2131303458);
    paramBundle = paramBundle.findViewById(2131303495);
    ((View)localObject).setOnClickListener(new AppBrandProfileUI.19(this));
    paramBundle.setOnClickListener(new AppBrandProfileUI.20(this));
    mIb = getContext().getResources().getColor(2131100498);
    if (this.mIT == null) {
      this.mIT = new com.tencent.mm.plugin.appbrand.ui.widget.a(mHY, mIa, mIb);
    }
    hG(true);
    bAr();
    AppMethodBeat.o(48741);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(48747);
    super.onDestroy();
    com.tencent.mm.plugin.appbrand.config.v.beQ().remove(this);
    AppMethodBeat.o(48747);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(48743);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (!bu.isNullOrNil(this.lJm)) {
      com.tencent.mm.plugin.appbrand.config.v.beQ().remove(this);
    }
    paramIntent = getIntent().getStringExtra("key_username");
    this.lJm = paramIntent;
    if (bu.isNullOrNil(paramIntent))
    {
      finish();
      AppMethodBeat.o(48743);
      return;
    }
    hG(true);
    bAr();
    AppMethodBeat.o(48743);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(48746);
    super.onPause();
    u.a(this, new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(48746);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(48745);
    super.onResume();
    if (getSwipeBackLayout() != null) {
      getSwipeBackLayout().setEnableGesture(getIntent().getBooleanExtra("key_can_swipe_back", true));
    }
    u.a(this, new com.tencent.mm.vending.c.a() {});
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
    WeakReference<AppBrandProfileUI> mJo;
    
    public a(AppBrandProfileUI paramAppBrandProfileUI)
    {
      AppMethodBeat.i(48732);
      this.mJo = new WeakReference(paramAppBrandProfileUI);
      AppMethodBeat.o(48732);
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(48733);
      if ((this.mJo != null) && (this.mJo.get() != null))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0) && (paramb != null) && (paramb.hQE.hQJ != null) && ((paramb.hQE.hQJ instanceof bhd)))
        {
          ae.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "queryProfile, request success");
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(48731);
              if ((AppBrandProfileUI.a.this.mJo != null) && (AppBrandProfileUI.a.this.mJo.get() != null)) {
                AppBrandProfileUI.a((AppBrandProfileUI)AppBrandProfileUI.a.this.mJo.get(), this.mJp);
              }
              AppMethodBeat.o(48731);
            }
          });
          AppMethodBeat.o(48733);
          return;
        }
        ae.e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "queryProfile, request fail");
      }
      AppMethodBeat.o(48733);
    }
  }
  
  static final class b
    implements IPCRunCgi.a
  {
    WeakReference<AppBrandProfileUI> mJo;
    
    public b(AppBrandProfileUI paramAppBrandProfileUI)
    {
      AppMethodBeat.i(48736);
      this.mJo = new WeakReference(paramAppBrandProfileUI);
      AppMethodBeat.o(48736);
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(48737);
      if ((this.mJo != null) && (this.mJo.get() != null))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0) && (paramb != null) && (paramb.hQE.hQJ != null) && ((paramb.hQE.hQJ instanceof dsr)))
        {
          ae.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "cgiUpdateUserLike, request success");
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(48734);
              if ((AppBrandProfileUI.b.this.mJo != null) && (AppBrandProfileUI.b.this.mJo.get() != null))
              {
                AppBrandProfileUI localAppBrandProfileUI = (AppBrandProfileUI)AppBrandProfileUI.b.this.mJo.get();
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
                  ejc localejc = new ejc();
                  localejc.Imm = true;
                  localejc.vvt = c.Du(com.tencent.mm.model.v.aAC());
                  localejc.nickname = com.tencent.mm.model.v.aAE();
                  AppBrandProfileUI.t(localAppBrandProfileUI).addFirst(localejc);
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
        ae.e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "cgiUpdateUserLike, request fail");
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(48735);
            if ((AppBrandProfileUI.b.this.mJo != null) && (AppBrandProfileUI.b.this.mJo.get() != null))
            {
              AppBrandProfileUI localAppBrandProfileUI = (AppBrandProfileUI)AppBrandProfileUI.b.this.mJo.get();
              if (AppBrandProfileUI.x(localAppBrandProfileUI))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI
 * JD-Core Version:    0.7.0.1
 */