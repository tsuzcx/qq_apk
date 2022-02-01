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
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.ab;
import com.tencent.mm.plugin.appbrand.config.x;
import com.tencent.mm.plugin.appbrand.utils.ac;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.protocal.protobuf.bgm;
import com.tencent.mm.protocal.protobuf.bgn;
import com.tencent.mm.protocal.protobuf.dru;
import com.tencent.mm.protocal.protobuf.ehl;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
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
  private static final int mCT;
  private static final int mCU;
  private static final int mCV;
  private static int mCW;
  private static final int mCX;
  private static final int mCY;
  private static final int mCZ;
  private static final int mDa;
  private String jqQ;
  private LinearLayout lDt;
  private String lEN;
  private TextView mDA;
  private TextView mDC;
  private LinearLayout mDD;
  private ImageView mDE;
  private LinearLayout mDF;
  private AppBrandNearbyShowcaseView mDG;
  private TextView mDH;
  private View mDI;
  private TextView mDJ;
  private int mDK;
  private e mDL;
  private WxaExposedParams mDM;
  private boolean mDN;
  private b.h mDO;
  private b.h mDP;
  private b.h mDQ;
  private boolean mDR;
  private boolean mDS;
  private boolean mDT;
  private String mDU;
  private String mDV;
  private String mDW;
  private Runnable mDX;
  private boolean mDc;
  private boolean mDd;
  private int mDe;
  private LinkedList<ehl> mDf;
  private ImageView mDg;
  private TextView mDh;
  private TextView mDi;
  private TextView mDj;
  private RatingBar mDk;
  private TextView mDl;
  private LinearLayout mDm;
  private RecyclerView mDn;
  private LinearLayout mDo;
  private LinearLayout mDp;
  private LinearLayout mDq;
  private TextView mDr;
  private AppBrandNearbyShowcaseView mDs;
  private LinearLayout mDt;
  private LinearLayout mDu;
  private TextView mDv;
  private AppBrandNearbyShowcaseView mDw;
  private LinearLayout mDx;
  private TextView mDy;
  private FrameLayout mDz;
  private ab mzE;
  
  static
  {
    AppMethodBeat.i(48769);
    mCT = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 24);
    mCU = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 20);
    mCV = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 2);
    mCW = -1;
    mCX = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 40);
    mCY = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 44);
    mCZ = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 32);
    mDa = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 4);
    AppMethodBeat.o(48769);
  }
  
  public AppBrandProfileUI()
  {
    AppMethodBeat.i(48738);
    this.mDc = false;
    this.mDd = false;
    this.mDe = 0;
    this.mDf = new LinkedList();
    this.mDN = false;
    this.jqQ = "";
    this.mDU = "";
    this.mDV = "";
    this.mDW = "";
    this.mDX = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(188881);
        AppBrandProfileUI.f(AppBrandProfileUI.this).setHighlightColor(AppBrandProfileUI.this.getResources().getColor(17170445));
        AppBrandProfileUI.f(AppBrandProfileUI.this).setText(AppBrandProfileUI.g(AppBrandProfileUI.this));
        AppBrandProfileUI.f(AppBrandProfileUI.this).requestLayout();
        AppBrandProfileUI.f(AppBrandProfileUI.this).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public final void onGlobalLayout()
          {
            AppMethodBeat.i(188880);
            AppBrandProfileUI.f(AppBrandProfileUI.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
            Object localObject2 = new ArrayList();
            Object localObject1;
            if (AppBrandProfileUI.h(AppBrandProfileUI.this))
            {
              localObject1 = ac.a(AppBrandProfileUI.this.getContext(), 2131234977, 36, 20, new ClickableSpan()
              {
                public final void onClick(View paramAnonymous3View)
                {
                  AppMethodBeat.i(188877);
                  if (TextUtils.isEmpty(AppBrandProfileUI.i(AppBrandProfileUI.this)))
                  {
                    AppMethodBeat.o(188877);
                    return;
                  }
                  AppBrandProfileUI.a(AppBrandProfileUI.this, 25, 1);
                  d.b(AppBrandProfileUI.this, "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", AppBrandProfileUI.i(AppBrandProfileUI.this)).putExtra("forceHideShare", true));
                  ad.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "click official icon");
                  AppMethodBeat.o(188877);
                }
              });
              ((List)localObject2).add(((Pair)localObject1).first);
            }
            for (int j = ((Integer)((Pair)localObject1).second).intValue() + 0;; j = 0)
            {
              int i = j;
              if (AppBrandProfileUI.j(AppBrandProfileUI.this))
              {
                localObject1 = ac.a(AppBrandProfileUI.this.getContext(), 2131232342, 36, 20, new ClickableSpan()
                {
                  public final void onClick(View paramAnonymous3View)
                  {
                    AppMethodBeat.i(188878);
                    if (TextUtils.isEmpty(AppBrandProfileUI.k(AppBrandProfileUI.this)))
                    {
                      AppMethodBeat.o(188878);
                      return;
                    }
                    try
                    {
                      paramAnonymous3View = com.tencent.mm.plugin.appbrand.u.bY(AppBrandProfileUI.k(AppBrandProfileUI.this), "appid=" + AppBrandProfileUI.l(AppBrandProfileUI.this).appId);
                      paramAnonymous3View = new Intent().putExtra("rawUrl", paramAnonymous3View).putExtra("forceHideShare", true);
                      d.b(AppBrandProfileUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymous3View);
                      AppBrandProfileUI.a(AppBrandProfileUI.this, 21, 1);
                      ad.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "click original icon");
                      AppMethodBeat.o(188878);
                      return;
                    }
                    catch (URISyntaxException paramAnonymous3View)
                    {
                      for (;;)
                      {
                        ad.printErrStackTrace("MicroMsg.AppBrand.Profile.AppBrandProfileUI", paramAnonymous3View, "URISyntaxException with originalRedirectUrl %s", new Object[] { AppBrandProfileUI.k(AppBrandProfileUI.this) });
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
                localObject1 = ac.a(AppBrandProfileUI.this.getContext(), 2131232380, 16, 16, new ClickableSpan()
                {
                  public final void onClick(View paramAnonymous3View)
                  {
                    AppMethodBeat.i(188879);
                    if (TextUtils.isEmpty(AppBrandProfileUI.n(AppBrandProfileUI.this)))
                    {
                      AppMethodBeat.o(188879);
                      return;
                    }
                    AppBrandProfileUI.a(AppBrandProfileUI.this, 26, 1);
                    d.b(AppBrandProfileUI.this, "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", AppBrandProfileUI.n(AppBrandProfileUI.this)).putExtra("forceHideShare", true));
                    ad.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "click guarantee icon");
                    AppMethodBeat.o(188879);
                  }
                });
                ((List)localObject2).add(((Pair)localObject1).first);
                j = i + ((Integer)((Pair)localObject1).second).intValue();
              }
              ((List)localObject2).add(ac.dR(AppBrandProfileUI.this.getContext()).first);
              i = AppBrandProfileUI.f(AppBrandProfileUI.this).getWidth() - AppBrandProfileUI.f(AppBrandProfileUI.this).getPaddingLeft() - AppBrandProfileUI.f(AppBrandProfileUI.this).getPaddingRight();
              TextPaint localTextPaint = AppBrandProfileUI.f(AppBrandProfileUI.this).getPaint();
              List localList = ac.a(localTextPaint, AppBrandProfileUI.g(AppBrandProfileUI.this), i);
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
              AppMethodBeat.o(188880);
              return;
            }
          }
        });
        AppBrandProfileUI.f(AppBrandProfileUI.this).setMovementMethod(LinkMovementMethod.getInstance());
        AppMethodBeat.o(188881);
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
    AppMethodBeat.i(188884);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(188884);
      return;
    }
    if (paramContext == null) {
      paramContext = aj.getContext();
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
        AppMethodBeat.o(188884);
        return;
      }
      paramString1 = new com.tencent.mm.hellhoundlib.b.a().bc(paramString1);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.ahp(), "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI", "show", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;ZLcom/tencent/mm/plugin/appbrand/config/WxaExposedParams;Landroid/os/Bundle;Lcom/tencent/luggage/sdk/launching/ActivityStarterIpcDelegate;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString1.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI", "show", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;ZLcom/tencent/mm/plugin/appbrand/config/WxaExposedParams;Landroid/os/Bundle;Lcom/tencent/luggage/sdk/launching/ActivityStarterIpcDelegate;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(188884);
      return;
    }
  }
  
  private void bzv()
  {
    AppMethodBeat.i(188889);
    aq.aA(this.mDX);
    aq.f(this.mDX);
    AppMethodBeat.o(188889);
  }
  
  private void bzw()
  {
    AppMethodBeat.i(48753);
    if (!bt.isNullOrNil(this.lEN))
    {
      ad.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "queryProfile start");
      bgm localbgm = new bgm();
      localbgm.username = this.lEN;
      b.a locala = new b.a();
      locala.funcId = 2921;
      locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getprofileinfo";
      locala.hNM = localbgm;
      locala.hNN = new bgn();
      IPCRunCgi.a(locala.aDC(), new a(this));
    }
    AppMethodBeat.o(48753);
  }
  
  private void bzx()
  {
    AppMethodBeat.i(48754);
    if ((this.mDf != null) && (this.mDf.size() > 0))
    {
      this.mDz.setVisibility(0);
      this.mDD.setVisibility(0);
      this.mDA.setVisibility(8);
      this.mDG.setIconGap(mCY);
      this.mDG.setIconSize(mCX);
      this.mDG.setIconLayerCount(Math.min(this.mDf.size(), 3));
      if (this.mDP == null) {
        this.mDP = new com.tencent.mm.plugin.appbrand.ui.b.a(mCZ);
      }
      if (this.mDQ == null) {
        this.mDQ = new com.tencent.mm.plugin.appbrand.ui.b.a(mDa);
      }
      int i = 0;
      if (i < this.mDG.getChildCount())
      {
        String str;
        label167:
        com.tencent.mm.modelappbrand.a.b localb;
        ImageView localImageView;
        if (this.mDf.size() > i)
        {
          str = ((ehl)this.mDf.get(i)).vjo;
          localb = com.tencent.mm.modelappbrand.a.b.aDV();
          localImageView = this.mDG.vQ(i);
          if ((str != null) && (!str.startsWith("http"))) {
            break label226;
          }
        }
        label226:
        for (b.h localh = this.mDP;; localh = this.mDQ)
        {
          localb.a(localImageView, str, 2131231875, localh);
          i += 1;
          break;
          str = null;
          break label167;
        }
      }
      if (this.mDe == 1) {
        if (this.mDc)
        {
          this.mDC.setText(getString(2131755595));
          if (!this.mDc) {
            break label419;
          }
          this.mDC.setCompoundDrawablesWithIntrinsicBounds(2131231003, 0, 0, 0);
          label283:
          if (this.mDe <= 3) {
            break label435;
          }
          this.mDE.setVisibility(0);
          this.mDF.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(48720);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              AppBrandProfileUI.q(AppBrandProfileUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(48720);
            }
          });
        }
      }
    }
    for (;;)
    {
      this.mDA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(48721);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          AppBrandProfileUI.r(AppBrandProfileUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(48721);
        }
      });
      this.mDC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(48722);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          AppBrandProfileUI.r(AppBrandProfileUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(48722);
        }
      });
      AppMethodBeat.o(48754);
      return;
      this.mDC.setText(String.format(getString(2131755597), new Object[] { Integer.valueOf(this.mDe) }));
      break;
      this.mDC.setText(String.format(getString(2131755597), new Object[] { Integer.valueOf(this.mDe) }));
      break;
      label419:
      this.mDC.setCompoundDrawablesWithIntrinsicBounds(2131231002, 0, 0, 0);
      break label283;
      label435:
      this.mDE.setVisibility(8);
      this.mDF.setOnClickListener(null);
      continue;
      this.mDz.setVisibility(0);
      this.mDA.setVisibility(0);
      this.mDD.setVisibility(8);
    }
  }
  
  private void cN(final View paramView)
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
    if (this.mzE == null) {}
    for (String str1 = null; bt.isNullOrNil(str1); str1 = this.mzE.appId)
    {
      ad.e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "profileOperateReport appId null");
      AppMethodBeat.o(48751);
      return;
    }
    int j = getIntent().getIntExtra("key_from_scene", 3);
    String str2 = bt.nullAsNil(getIntent().getStringExtra("key_scene_note"));
    int i = 0;
    WxaAttributes localWxaAttributes = j.aYP().e(str1, new String[] { "appInfo", "brandIconURL", "nickname" });
    if (localWxaAttributes != null) {
      i = localWxaAttributes.bel().cQN;
    }
    i += 1000;
    ad.d("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "stev report(%s), appId %s, scene %s, sceneNote %s, eventId %s, result %s, appType %s", new Object[] { Integer.valueOf(13919), str1, Integer.valueOf(j), str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
    com.tencent.mm.plugin.report.service.g.yhR.f(13919, new Object[] { str1, Integer.valueOf(j), str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), Integer.valueOf(i) });
    this.mDK = j;
    AppMethodBeat.o(48751);
  }
  
  private void ej(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(48750);
    e(paramInt1, paramInt2, bt.aQJ());
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
  
  private void hF(final boolean paramBoolean)
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
            AppBrandProfileUI.a(AppBrandProfileUI.this, this.mEa);
            if ((AppBrandProfileUI.4.this.mDZ) && (!AppBrandProfileUI.this.isFinishing()) && (!AppBrandProfileUI.this.activityHasDestroyed()))
            {
              com.tencent.mm.plugin.appbrand.config.v.bej().add(AppBrandProfileUI.this);
              AppBrandProfileUI.a(AppBrandProfileUI.this, 1, 1);
            }
            AppMethodBeat.o(48707);
          }
        });
        if (paramBoolean) {
          x.NM(AppBrandProfileUI.d(AppBrandProfileUI.this));
        }
        AppMethodBeat.o(48708);
      }
    }, "AppBrandProfile");
    AppMethodBeat.o(48752);
  }
  
  private void hG(boolean paramBoolean)
  {
    AppMethodBeat.i(188886);
    this.mDS = paramBoolean;
    bzv();
    AppMethodBeat.o(188886);
  }
  
  private void hH(boolean paramBoolean)
  {
    AppMethodBeat.i(188887);
    this.mDT = paramBoolean;
    bzv();
    AppMethodBeat.o(188887);
  }
  
  private void hI(boolean paramBoolean)
  {
    AppMethodBeat.i(188888);
    this.mDR = paramBoolean;
    bzv();
    AppMethodBeat.o(188888);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(48748);
    if ((paramm.dtK == 3) && ((paramm.obj instanceof String)) && (!bt.isNullOrNil(this.lEN)) && (this.lEN.equals((String)paramm.obj))) {
      hF(false);
    }
    AppMethodBeat.o(48748);
  }
  
  public final boolean convertActivityFromTranslucent()
  {
    AppMethodBeat.i(188885);
    boolean bool = getIntent().getBooleanExtra("key_can_swipe_back", true);
    AppMethodBeat.o(188885);
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
    this.lDt = new LinearLayout(this);
    this.lDt.setOrientation(1);
    this.lDt.setFocusable(true);
    this.lDt.setFocusableInTouchMode(true);
    localScrollView.addView(this.lDt, new FrameLayout.LayoutParams(-1, -1));
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
    if (this.mDN)
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
    AppMethodBeat.i(188890);
    super.onConfigurationChanged(paramConfiguration);
    bzv();
    AppMethodBeat.o(188890);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48741);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("key_username");
    this.lEN = paramBundle;
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
    this.mDM = ((WxaExposedParams)getIntent().getParcelableExtra("key_scene_exposed_params"));
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
    paramBundle = LayoutInflater.from(this).inflate(2131493031, this.lDt, true);
    paramBundle.setClickable(false);
    paramBundle.setLongClickable(false);
    this.mDg = ((ImageView)paramBundle.findViewById(2131303463));
    this.mDh = ((TextView)paramBundle.findViewById(2131303478));
    this.mDi = ((TextView)paramBundle.findViewById(2131303457));
    this.mDj = ((TextView)paramBundle.findViewById(2131303499));
    this.mDk = ((RatingBar)paramBundle.findViewById(2131303496));
    this.mDl = ((TextView)paramBundle.findViewById(2131303498));
    this.mDm = ((LinearLayout)paramBundle.findViewById(2131303497));
    this.mDo = ((LinearLayout)paramBundle.findViewById(2131303493));
    this.mDn = ((RecyclerView)paramBundle.findViewById(2131303494));
    this.mDn.setItemAnimator(new android.support.v7.widget.v());
    Object localObject = new LinearLayoutManager();
    ((LinearLayoutManager)localObject).setOrientation(0);
    this.mDn.setLayoutManager((RecyclerView.i)localObject);
    this.mDn.a(new AppBrandProfileUI.21(this));
    this.mDp = ((LinearLayout)paramBundle.findViewById(2131303452));
    this.mDq = ((LinearLayout)paramBundle.findViewById(2131303450));
    this.mDr = ((TextView)paramBundle.findViewById(2131303454));
    this.mDs = ((AppBrandNearbyShowcaseView)paramBundle.findViewById(2131303455));
    this.mDs.setIconGap(mCU);
    this.mDs.setIconSize(mCT + mCV * 2);
    cN(this.mDq);
    this.mDt = ((LinearLayout)paramBundle.findViewById(2131303512));
    this.mDu = ((LinearLayout)paramBundle.findViewById(2131303511));
    this.mDv = ((TextView)paramBundle.findViewById(2131303513));
    this.mDw = ((AppBrandNearbyShowcaseView)paramBundle.findViewById(2131303514));
    this.mDw.setIconGap(mCU);
    this.mDw.setIconSize(mCT + mCV * 2);
    cN(this.mDu);
    this.mDz = ((FrameLayout)paramBundle.findViewById(2131303472));
    this.mDA = ((TextView)paramBundle.findViewById(2131303479));
    this.mDC = ((TextView)paramBundle.findViewById(2131303476));
    this.mDE = ((ImageView)paramBundle.findViewById(2131303469));
    this.mDG = ((AppBrandNearbyShowcaseView)paramBundle.findViewById(2131303473));
    this.mDF = ((LinearLayout)paramBundle.findViewById(2131303470));
    this.mDD = ((LinearLayout)paramBundle.findViewById(2131303477));
    this.mDx = ((LinearLayout)paramBundle.findViewById(2131308155));
    this.mDy = ((TextView)paramBundle.findViewById(2131308215));
    this.mDx.setOnClickListener(new AppBrandProfileUI.18(this));
    this.mDH = ((TextView)paramBundle.findViewById(2131303441));
    this.mDI = paramBundle.findViewById(2131303442);
    this.mDJ = ((TextView)paramBundle.findViewById(2131303485));
    localObject = paramBundle.findViewById(2131303458);
    paramBundle = paramBundle.findViewById(2131303495);
    ((View)localObject).setOnClickListener(new AppBrandProfileUI.19(this));
    paramBundle.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(188882);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        AppBrandProfileUI.a(AppBrandProfileUI.this, paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(188882);
      }
    });
    mCW = getContext().getResources().getColor(2131100498);
    if (this.mDO == null) {
      this.mDO = new com.tencent.mm.plugin.appbrand.ui.widget.a(mCT, mCV, mCW);
    }
    hF(true);
    bzw();
    AppMethodBeat.o(48741);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(48747);
    super.onDestroy();
    com.tencent.mm.plugin.appbrand.config.v.bej().remove(this);
    AppMethodBeat.o(48747);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(48743);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (!bt.isNullOrNil(this.lEN)) {
      com.tencent.mm.plugin.appbrand.config.v.bej().remove(this);
    }
    paramIntent = getIntent().getStringExtra("key_username");
    this.lEN = paramIntent;
    if (bt.isNullOrNil(paramIntent))
    {
      finish();
      AppMethodBeat.o(48743);
      return;
    }
    hF(true);
    bzw();
    AppMethodBeat.o(48743);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(48746);
    super.onPause();
    t.a(this, new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(48746);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(48745);
    super.onResume();
    if (getSwipeBackLayout() != null) {
      getSwipeBackLayout().setEnableGesture(getIntent().getBooleanExtra("key_can_swipe_back", true));
    }
    t.a(this, new com.tencent.mm.vending.c.a() {});
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
    WeakReference<AppBrandProfileUI> mEj;
    
    public a(AppBrandProfileUI paramAppBrandProfileUI)
    {
      AppMethodBeat.i(48732);
      this.mEj = new WeakReference(paramAppBrandProfileUI);
      AppMethodBeat.o(48732);
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.b paramb)
    {
      AppMethodBeat.i(48733);
      if ((this.mEj != null) && (this.mEj.get() != null))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0) && (paramb != null) && (paramb.hNL.hNQ != null) && ((paramb.hNL.hNQ instanceof bgn)))
        {
          ad.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "queryProfile, request success");
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(48731);
              if ((AppBrandProfileUI.a.this.mEj != null) && (AppBrandProfileUI.a.this.mEj.get() != null)) {
                AppBrandProfileUI.a((AppBrandProfileUI)AppBrandProfileUI.a.this.mEj.get(), this.mEk);
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
    WeakReference<AppBrandProfileUI> mEj;
    
    public b(AppBrandProfileUI paramAppBrandProfileUI)
    {
      AppMethodBeat.i(48736);
      this.mEj = new WeakReference(paramAppBrandProfileUI);
      AppMethodBeat.o(48736);
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.b paramb)
    {
      AppMethodBeat.i(48737);
      if ((this.mEj != null) && (this.mEj.get() != null))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0) && (paramb != null) && (paramb.hNL.hNQ != null) && ((paramb.hNL.hNQ instanceof dru)))
        {
          ad.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "cgiUpdateUserLike, request success");
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(48734);
              if ((AppBrandProfileUI.b.this.mEj != null) && (AppBrandProfileUI.b.this.mEj.get() != null))
              {
                AppBrandProfileUI localAppBrandProfileUI = (AppBrandProfileUI)AppBrandProfileUI.b.this.mEj.get();
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
                  ehl localehl = new ehl();
                  localehl.HSf = true;
                  localehl.vjo = c.CS(com.tencent.mm.model.u.aAm());
                  localehl.nickname = com.tencent.mm.model.u.aAo();
                  AppBrandProfileUI.t(localAppBrandProfileUI).addFirst(localehl);
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
        ad.e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "cgiUpdateUserLike, request fail");
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(48735);
            if ((AppBrandProfileUI.b.this.mEj != null) && (AppBrandProfileUI.b.this.mEj.get() != null))
            {
              AppBrandProfileUI localAppBrandProfileUI = (AppBrandProfileUI)AppBrandProfileUI.b.this.mEj.get();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI
 * JD-Core Version:    0.7.0.1
 */