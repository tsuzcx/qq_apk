package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.sdk.b.a.c.a;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandMenuFooter;
import com.tencent.mm.plugin.appbrand.ao.1;
import com.tencent.mm.plugin.appbrand.ao.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.backgroundrunning.a.1;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.jsruntime.z;
import com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper;
import com.tencent.mm.plugin.appbrand.menu.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.c;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.d.b;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.af;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class ae
  extends com.tencent.luggage.sdk.b.a.c
{
  private com.tencent.mm.plugin.appbrand.o iEx;
  private List<com.tencent.mm.plugin.appbrand.menu.p> iIP;
  private final AtomicBoolean lbA;
  public volatile boolean lbB;
  private s lbC;
  public ao lbD;
  private Boolean lbE;
  private final com.tencent.mm.plugin.appbrand.s.a.a.o lbF;
  private AppBrandRecentView lbu;
  private com.tencent.mm.plugin.appbrand.widget.actionbar.g lbv;
  public final com.tencent.mm.plugin.appbrand.report.f lbw;
  private boolean lbx;
  public boolean lby;
  public com.tencent.mm.plugin.appbrand.aa.i<Boolean> lbz;
  
  public ae()
  {
    this(ad.class);
  }
  
  public ae(Class<? extends ac> paramClass)
  {
    super(paramClass);
    AppMethodBeat.i(47884);
    this.lbw = new com.tencent.mm.plugin.appbrand.report.f(aOd());
    this.lbA = new AtomicBoolean(false);
    this.lbB = false;
    this.lbF = new com.tencent.mm.plugin.appbrand.s.a.a.o();
    if ((bu.eGT()) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED)) {
      bool = true;
    }
    this.iDV = bool;
    AppMethodBeat.o(47884);
  }
  
  private boolean Eq()
  {
    AppMethodBeat.i(180349);
    if (this.lbE == null) {
      this.lbE = Boolean.valueOf(ai.Eq());
    }
    boolean bool = this.lbE.booleanValue();
    AppMethodBeat.o(180349);
    return bool;
  }
  
  public final void DH()
  {
    AppMethodBeat.i(196071);
    super.DH();
    if (z.f(this))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewWC", "page initNativeTransLogic");
      if (!com.tencent.mm.plugin.appbrand.xweb_ext.d.moL) {
        break label175;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.XWebNativeTransInitLogic", "bind already");
    }
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.jsruntime.i locali = aOf();
      int i = aOd();
      com.tencent.mm.sdk.platformtools.ad.i("Luggage.NativeTransLogic", "enableXwebNativeTrans componentId:%s ,appId:%s , stack:%s", new Object[] { Integer.valueOf(i), getAppId(), Log.getStackTraceString(new Throwable()) });
      locali.evaluateJavascript("console.log('enableXwebNativeTrans. ntrans:' + typeof ntrans + ' componentId :" + i + "')", null);
      locali.evaluateJavascript("xweb.enableNativeTrans()", null);
      locali.evaluateJavascript("console.log('enableXwebNativeTrans. end ntrans:' + typeof ntrans  + ' componentId :" + i + "')", null);
      z.a(aOf(), aOd(), getAppId());
      AppMethodBeat.o(196071);
      return;
      label175:
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.XWebNativeTransInitLogic", "bind");
      af.xq(com.tencent.mm.appbrand.v8.f.getNativeTransManager());
      com.tencent.mm.plugin.appbrand.xweb_ext.d.moL = true;
    }
  }
  
  public final View Dn()
  {
    AppMethodBeat.i(175036);
    if (com.tencent.mm.plugin.appbrand.ao.w(getRuntime()))
    {
      AppMethodBeat.o(175036);
      return null;
    }
    AppBrandMenuHeader localAppBrandMenuHeader = new AppBrandMenuHeader(getContext());
    localAppBrandMenuHeader.setPage(this);
    AppMethodBeat.o(175036);
    return localAppBrandMenuHeader;
  }
  
  public void Do()
  {
    AppMethodBeat.i(47889);
    a(null);
    super.Do();
    if (this.lbu != null) {
      this.lbu.release();
    }
    if (this.lbv != null)
    {
      com.tencent.mm.plugin.appbrand.widget.actionbar.g localg = this.lbv;
      localg.dismiss();
      if (localg.lRC != null)
      {
        localg.lRC.removeAllViews();
        localg.lRC = null;
      }
    }
    this.lbC = null;
    AppMethodBeat.o(47889);
  }
  
  public final void Dt()
  {
    AppMethodBeat.i(47904);
    if (getRuntime().aMT()) {
      bjH().setNavHidden(false);
    }
    for (;;)
    {
      if ((com.tencent.mm.plugin.appbrand.ac.g.as(this.iEx)) || (com.tencent.mm.plugin.appbrand.ao.w(getRuntime()))) {
        bjH().ho(true);
      }
      if ((this.lby) && (bjH() != null) && (!bjH().isFullscreenMode())) {
        bjH().setNavHidden(this.lbB);
      }
      AppMethodBeat.o(47904);
      return;
      super.Dt();
    }
  }
  
  public void a(final Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(47885);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewWC", "AppBrandPageViewProfile| init start");
    this.lbx = false;
    this.lby = false;
    this.lbz = null;
    this.iEx = ((com.tencent.mm.plugin.appbrand.o)paramAppBrandRuntime);
    if (aLC() == null) {
      a(((com.tencent.mm.plugin.appbrand.o)paramAppBrandRuntime).aLC());
    }
    super.a(paramContext, paramAppBrandRuntime);
    this.lbw.mAppId = paramAppBrandRuntime.mAppId;
    bjH().setCapsuleHomeButtonLongClickListener(new View.OnLongClickListener()
    {
      private void cE(View paramAnonymousView)
      {
        AppMethodBeat.i(47875);
        if ((ae.j(ae.this) == null) || (ae.j(ae.this).getCount() == 0))
        {
          AppMethodBeat.o(47875);
          return;
        }
        ae.j(ae.this).refresh();
        ae.k(ae.this).showAsDropDown(paramAnonymousView);
        com.tencent.mm.plugin.appbrand.report.h.a(ae.this.getAppId(), ae.this.jzm, 21, "", bt.aGK(), 1, 0);
        AppMethodBeat.o(47875);
      }
      
      public final boolean onLongClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(47874);
        if (!ae.i(ae.this).getAndSet(true))
        {
          ae.this.bhD();
          if (ae.j(ae.this) != null)
          {
            ae.j(ae.this).setRefreshListener(new AppBrandRecentView.e()
            {
              public final void tu(int paramAnonymous2Int)
              {
                AppMethodBeat.i(47873);
                ae.j(ae.this).setRefreshListener(null);
                ae.10.a(ae.10.this, paramAnonymousView);
                AppMethodBeat.o(47873);
              }
            });
            ae.j(ae.this).refresh();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(47874);
          return true;
          cE(paramAnonymousView);
        }
      }
    });
    bjH().setCloseButtonClickListener(new ae.1(this));
    if ((paramAppBrandRuntime.iDV) && (((com.tencent.mm.plugin.appbrand.o)paramAppBrandRuntime).aMT())) {
      bjH().setNavButtonLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(47871);
          ae.this.bke();
          AppMethodBeat.o(47871);
          return true;
        }
      });
    }
    this.jvC = new com.tencent.mm.plugin.appbrand.permission.a((com.tencent.mm.plugin.appbrand.o)paramAppBrandRuntime, this);
    if (com.tencent.mm.plugin.appbrand.ao.w(getRuntime()))
    {
      paramContext = getRuntime();
      paramAppBrandRuntime = paramContext.mAppId;
      com.tencent.mm.plugin.appbrand.g.a(paramAppBrandRuntime, new ao.1(paramAppBrandRuntime, paramContext));
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewWC", "decorateActionBarToSinglePageMode");
      if (this.laV != null)
      {
        paramContext = getContext();
        this.laV.ho(true);
        this.laV.setNavResetStyleListener(new b.c()
        {
          public final void a(ImageView paramAnonymousImageView, View paramAnonymousView1, View paramAnonymousView2)
          {
            AppMethodBeat.i(196060);
            if (paramAnonymousImageView != null)
            {
              paramAnonymousImageView.clearColorFilter();
              if ((!ae.l(ae.this)) && (!ae.this.getRuntime().CZ())) {
                break label92;
              }
            }
            label92:
            for (int i = 2131689499;; i = 2131689492)
            {
              paramAnonymousImageView.setImageDrawable(com.tencent.mm.svg.a.a.g(paramContext.getResources(), i));
              paramAnonymousView2 = paramAnonymousImageView.getLayoutParams();
              paramAnonymousView2.height = -1;
              paramAnonymousView2.width = -2;
              paramAnonymousImageView.setLayoutParams(paramAnonymousView2);
              if (paramAnonymousView1 != null) {
                paramAnonymousView1.setBackground(null);
              }
              AppMethodBeat.o(196060);
              return;
            }
          }
          
          public final int bkf()
          {
            return lRp;
          }
        });
        if ((!Eq()) && (!getRuntime().CZ())) {
          break label303;
        }
      }
    }
    label303:
    for (int i = 2131689500;; i = 2131689493)
    {
      paramContext = com.tencent.mm.svg.a.a.h(paramContext.getResources(), i);
      this.laV.a(paramContext, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(196061);
          ae.this.by(ae.this.bjG());
          AppMethodBeat.o(196061);
        }
      });
      this.laV.hd(false);
      this.laV.bre();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewWC", "AppBrandPageViewProfile| init end");
      AppMethodBeat.o(47885);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.s.a.c paramc)
  {
    AppMethodBeat.i(175037);
    long l;
    if (paramc == null)
    {
      paramc = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).ca;
      if ((this.lbF.getContext() == paramc) && (this.lbF == this.iGU))
      {
        AppMethodBeat.o(175037);
        return;
      }
      l = bt.GC();
      this.lbF.av(paramc);
      super.a(this.lbF);
      av(paramc);
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrandPageViewWC", "setWindowAndroid, impl==null, appId:%s, url:%s, isRunning:%b, cost:%dms", new Object[] { getAppId(), this.jzm, Boolean.valueOf(isRunning()), Long.valueOf(bt.aS(l)) });
      AppMethodBeat.o(175037);
      return;
    }
    if (paramc.compareTo(this.iGU) != 0)
    {
      l = bt.GC();
      super.a(paramc);
      if ((getRuntime() != null) && (com.tencent.mm.sdk.f.a.iV(getRuntime().mContext) != null)) {
        av(com.tencent.mm.sdk.f.a.iV(getRuntime().mContext));
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewWC", "setWindowAndroid changed, old:%s, new:%s, appId:%s, url:%s, cost:%dms, stack:%s", new Object[] { this.iGU, paramc, getAppId(), this.jzm, Long.valueOf(bt.aS(l)), Log.getStackTraceString(new Throwable()) });
    }
    AppMethodBeat.o(175037);
  }
  
  public final com.tencent.mm.plugin.appbrand.service.c aNe()
  {
    AppMethodBeat.i(47888);
    com.tencent.mm.plugin.appbrand.service.c localc = (com.tencent.mm.plugin.appbrand.service.c)super.Dm();
    AppMethodBeat.o(47888);
    return localc;
  }
  
  protected final void av(Context paramContext)
  {
    AppMethodBeat.i(47886);
    super.av(paramContext);
    if (this.kWU != null) {
      this.kWU.av(paramContext);
    }
    com.tencent.mm.plugin.appbrand.jsapi.z.a locala = bkd();
    if (locala != null)
    {
      if (paramContext == null)
      {
        AppMethodBeat.o(47886);
        return;
      }
      if ((locala.getContext() instanceof MutableContextWrapper)) {
        ((MutableContextWrapper)locala.getContext()).setBaseContext(paramContext);
      }
      locala.gQk.av(paramContext);
    }
    AppMethodBeat.o(47886);
  }
  
  protected void bhD()
  {
    AppMethodBeat.i(47890);
    com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
    if (getRuntime().aMT())
    {
      AppMethodBeat.o(47890);
      return;
    }
    try
    {
      this.lbu = ((com.tencent.mm.plugin.appbrand.widget.recentview.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.widget.recentview.d.class)).a(getContext(), d.b.mlW, new ae.11(this));
      if (this.lbu == null)
      {
        AppMethodBeat.o(47890);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.AppBrandPageViewWC", localException, "appId[%s]", new Object[] { getAppId() });
      }
      this.lbv = new com.tencent.mm.plugin.appbrand.widget.actionbar.g(getContext());
      this.lbv.setWidth(-1);
      this.lbv.setBackgroundDrawable(new ColorDrawable());
      this.lbu.refresh();
      this.lbv.setHeight(this.lbu.getLayoutParams().height);
      this.lbu.setBackground(com.tencent.mm.cd.a.l(getContext(), 2131230981));
      this.lbv.setContentView(this.lbu);
      this.lbu.setOnItemClickListener(new AppBrandRecentView.b()
      {
        public final boolean a(View paramAnonymousView, com.tencent.mm.plugin.appbrand.widget.recentview.a paramAnonymousa, float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          AppMethodBeat.i(47879);
          aq.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(47878);
              ae.k(ae.this).dismiss();
              AppMethodBeat.o(47878);
            }
          }, 100L);
          if (paramAnonymousa.type == 1)
          {
            paramAnonymousView = paramAnonymousa.lVq;
            paramAnonymousa = new AppBrandStatObject();
            paramAnonymousa.scene = 1090;
            paramAnonymousa.dbt = ae.this.getAppId();
            com.tencent.mm.plugin.appbrand.launching.e.f.kOI.a(ae.this.getContext(), paramAnonymousView.username, null, null, paramAnonymousView.gXn, -1, paramAnonymousa, null, null);
            AppMethodBeat.o(47879);
            return true;
          }
          AppMethodBeat.o(47879);
          return false;
        }
        
        public final boolean b(View paramAnonymousView, com.tencent.mm.plugin.appbrand.widget.recentview.a paramAnonymousa, float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          return false;
        }
      });
      AppMethodBeat.o(47890);
    }
  }
  
  public final List<com.tencent.mm.plugin.appbrand.menu.p> bjF()
  {
    AppMethodBeat.i(47897);
    if (com.tencent.mm.plugin.appbrand.ao.w(getRuntime()))
    {
      bool = getRuntime().CZ();
      localLinkedList = new LinkedList();
      WxaMenuHelper.a(localLinkedList, q.kSb.ordinal(), true, true);
      WxaMenuHelper.a(localLinkedList, q.kSc.ordinal(), true, true);
      WxaMenuHelper.a(localLinkedList, q.kSA.ordinal(), true, false);
      WxaMenuHelper.a(localLinkedList, q.kSl.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, q.kSw.ordinal(), false, false);
      if (bool) {
        WxaMenuHelper.a(localLinkedList, q.kSx.ordinal(), false, false);
      }
      this.iIP = localLinkedList;
      AppMethodBeat.o(47897);
      return localLinkedList;
    }
    Object localObject = getAppId();
    LinkedList localLinkedList = new LinkedList();
    WxaMenuHelper.a(localLinkedList, q.kSb.ordinal(), true, true);
    WxaMenuHelper.a(localLinkedList, q.kSc.ordinal(), true, true);
    WxaMenuHelper.a(localLinkedList, q.kSA.ordinal(), true, false);
    WxaMenuHelper.a(localLinkedList, q.kSk.ordinal(), true, false);
    localObject = com.tencent.mm.plugin.appbrand.a.CS((String)localObject);
    if ((!com.tencent.mm.sdk.a.b.eEQ()) && ((localObject == null) || (((k)localObject).jdS.iOQ == 1))) {}
    for (boolean bool = true;; bool = false)
    {
      WxaMenuHelper.a(localLinkedList, q.kSj.ordinal(), true, bool);
      WxaMenuHelper.a(localLinkedList, q.kRZ.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, q.kSu.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, q.kSv.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, q.kSi.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, q.kSw.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, q.kSz.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, q.kSx.ordinal(), false, false);
      WxaMenuHelper.a(localLinkedList, q.kSy.ordinal(), false, false);
      this.iIP = localLinkedList;
      AppMethodBeat.o(47897);
      return localLinkedList;
    }
  }
  
  public final void bjK()
  {
    AppMethodBeat.i(47891);
    super.bjK();
    Object localObject = getPageConfig();
    boolean bool2 = getRuntime().cif.a(this, new c.a());
    boolean bool1;
    if ((!((a.d)localObject).jbW) || (!bool2))
    {
      bool1 = true;
      super.bt(bool1);
      if ((bool2) && (((a.d)localObject).jbW) && (getRuntime().aNc().cfd == 7) && (!bjH().isFullscreenMode())) {
        break label192;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewWC", "hasPermission:" + bool2 + " navigationBarRightButtonHide:" + ((a.d)localObject).jbW + " appServiceType:" + getRuntime().aNc().cfd + " isFullscreenMode:" + bjH().isFullscreenMode());
    }
    for (;;)
    {
      if (!com.tencent.mm.plugin.appbrand.ao.w(getRuntime())) {
        break label231;
      }
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(196062);
          ae.this.Hx(ae.this.getRuntime().aNc().iJm);
          if (!"squeezed".equals(ae.m(ae.this))) {}
          for (boolean bool = true;; bool = false)
          {
            ae.this.gA(bool);
            ae.this.laV.hd(false);
            ae.this.laV.setFullscreenMode(false);
            ae.this.laV.ho(true);
            if (!ae.l(ae.this)) {
              break;
            }
            ae.this.laV.setForegroundStyle(false);
            ae.this.laV.uw(ae.this.getContext().getResources().getColor(2131099967));
            AppMethodBeat.o(196062);
            return;
          }
          ae.this.laV.setForegroundStyle(true);
          ae.this.laV.uw(ae.this.getContext().getResources().getColor(2131099968));
          AppMethodBeat.o(196062);
        }
      });
      AppMethodBeat.o(47891);
      return;
      bool1 = false;
      break;
      label192:
      localObject = new com.tencent.mm.plugin.appbrand.widget.tabbar.b(((a.d)localObject).jbV, new ae.14(this));
      ((com.tencent.mm.plugin.appbrand.widget.tabbar.b)localObject).a(new ae.15(this));
      ((com.tencent.mm.plugin.appbrand.widget.tabbar.b)localObject).buM();
    }
    label231:
    if (com.tencent.mm.plugin.appbrand.ac.g.as(getRuntime())) {
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(180330);
          if (ae.this.laV != null)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewWC", "weishi customActionBar");
            ae.this.laV.setNavResetStyleListener(new b.c()
            {
              public final void a(ImageView paramAnonymous2ImageView, View paramAnonymous2View1, View paramAnonymous2View2)
              {
                AppMethodBeat.i(196063);
                if (paramAnonymous2ImageView != null)
                {
                  paramAnonymous2ImageView.clearColorFilter();
                  paramAnonymous2ImageView.setImageDrawable(com.tencent.mm.svg.a.a.g(ae.this.getContext().getResources(), 2131689682));
                  paramAnonymous2View2 = paramAnonymous2ImageView.getLayoutParams();
                  paramAnonymous2View2.height = -1;
                  paramAnonymous2View2.width = -2;
                  paramAnonymous2ImageView.setLayoutParams(paramAnonymous2View2);
                }
                if (paramAnonymous2View1 != null) {
                  paramAnonymous2View1.setBackground(null);
                }
                AppMethodBeat.o(196063);
              }
              
              public final int bkf()
              {
                return lRp;
              }
            });
            ae.this.laV.setFullscreenMode(true);
            ae.this.laV.setForegroundStyle(false);
            ae.this.laV.hd(false);
            ae.this.laV.ho(true);
            ae.this.laV.setBackButtonClickListener(new ae.5.2(this));
          }
          if (ae.this.laU != null) {
            ae.this.laU.setForceTopInsetsHeight(ae.this.getContext().getResources().getDimensionPixelSize(2131165880));
          }
          ae.n(ae.this);
          AppMethodBeat.o(180330);
        }
      });
    }
    AppMethodBeat.o(47891);
  }
  
  protected final void bjM()
  {
    AppMethodBeat.i(47899);
    super.bjM();
    Object localObject = this.lbw;
    ((com.tencent.mm.plugin.appbrand.report.model.b)localObject).lqG = (bt.eGO() - ((com.tencent.mm.plugin.appbrand.report.model.b)localObject).lqF);
    if (aLC().compareTo(getRuntime().aLC()) != 0)
    {
      localObject = new IllegalStateException(String.format(Locale.ENGLISH, "onPageReady appId[%s] mismatch libReader, self[%s] runtime[%s]", new Object[] { getAppId(), aLC().aPa(), getRuntime().aLC().aPa() }));
      AppMethodBeat.o(47899);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(47899);
  }
  
  protected final void bjN()
  {
    AppMethodBeat.i(47900);
    super.bjN();
    if (getRuntime().CZ())
    {
      com.tencent.mm.plugin.appbrand.report.f localf = this.lbw;
      if (getRuntime().iDN) {}
      for (String str = getRuntime().aLS();; str = getRuntime().aNd().getCurrentUrl())
      {
        localf.Mr(str);
        AppMethodBeat.o(47900);
        return;
      }
    }
    this.lbw.onForeground();
    AppMethodBeat.o(47900);
  }
  
  protected final void bjO()
  {
    AppMethodBeat.i(47901);
    super.bjO();
    if (this.lbv != null) {
      this.lbv.dismiss();
    }
    this.lbw.onBackground();
    AppMethodBeat.o(47901);
  }
  
  public final boolean bjP()
  {
    AppMethodBeat.i(47895);
    if (this.lbx)
    {
      AppMethodBeat.o(47895);
      return true;
    }
    boolean bool = super.bjP();
    AppMethodBeat.o(47895);
    return bool;
  }
  
  protected final void bjQ()
  {
    AppMethodBeat.i(47902);
    super.bjQ();
    this.lbw.onDestroy();
    AppMethodBeat.o(47902);
  }
  
  public final View bjU()
  {
    AppMethodBeat.i(47893);
    if (com.tencent.mm.plugin.appbrand.ad.d.d(this))
    {
      localObject = new com.tencent.mm.plugin.appbrand.ad.a.b();
      ((com.tencent.mm.plugin.appbrand.ad.a.b)localObject).source = "menu";
      ((com.tencent.mm.plugin.appbrand.ad.a.b)localObject).type = "menu";
      ((com.tencent.mm.plugin.appbrand.ad.a.b)localObject).c((com.tencent.mm.plugin.appbrand.service.c)super.Dm());
      localObject = new AppBrandMenuFooter(getContext());
      ((AppBrandMenuFooter)localObject).setPageView(this);
      ((AppBrandMenuFooter)localObject).setOnClickListener(new ae.13(this));
      AppMethodBeat.o(47893);
      return localObject;
    }
    Object localObject = super.bjU();
    AppMethodBeat.o(47893);
    return localObject;
  }
  
  public final Bitmap bjW()
  {
    AppMethodBeat.i(196070);
    Object localObject1 = (com.tencent.luggage.game.page.d)Q(com.tencent.luggage.game.page.d.class);
    if (localObject1 == null)
    {
      localObject1 = super.bjW();
      AppMethodBeat.o(196070);
      return localObject1;
    }
    try
    {
      localObject1 = ((com.tencent.luggage.game.page.d)localObject1).Cn().getMagicBrush().cpg.h(((com.tencent.luggage.game.page.d)localObject1).Cn().getVirtualElementId(), -1, true);
      AppMethodBeat.o(196070);
      return localObject1;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.AppBrandPageViewWC", localNullPointerException, "hy: exception in get snapshot", new Object[0]);
        Object localObject2 = null;
      }
    }
  }
  
  public final ap bka()
  {
    AppMethodBeat.i(47903);
    if ((bjA() instanceof ad))
    {
      ap localap = ((ad)bjA()).bka();
      AppMethodBeat.o(47903);
      return localap;
    }
    AppMethodBeat.o(47903);
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.report.f bkc()
  {
    return this.lbw;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.z.a bkd()
  {
    AppMethodBeat.i(47896);
    try
    {
      Object localObject = this.jhz.findViewById(2131296782);
      if ((localObject instanceof com.tencent.mm.plugin.appbrand.jsapi.z.a))
      {
        localObject = (com.tencent.mm.plugin.appbrand.jsapi.z.a)localObject;
        AppMethodBeat.o(47896);
        return localObject;
      }
      AppMethodBeat.o(47896);
      return null;
    }
    catch (NullPointerException localNullPointerException)
    {
      AppMethodBeat.o(47896);
    }
    return null;
  }
  
  public final void bke()
  {
    AppMethodBeat.i(47906);
    if ((this.iIP == null) || (this.iIP.size() <= 0))
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrandPageViewWC", "showPageActionSheet appId[%s], url[%s], empty list skip", new Object[] { getAppId(), this.jzm });
      AppMethodBeat.o(47906);
      return;
    }
    by(this.iIP);
    AppMethodBeat.o(47906);
  }
  
  protected final void by(List<com.tencent.mm.plugin.appbrand.menu.p> paramList)
  {
    AppMethodBeat.i(47905);
    this.lbC = new s(this, paramList);
    this.lbC.aOh();
    AppMethodBeat.o(47905);
  }
  
  public final boolean ct(String paramString)
  {
    AppMethodBeat.i(47898);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewWC", "AppBrandPageViewProfile| loadURL");
    com.tencent.mm.plugin.appbrand.report.f localf = this.lbw;
    localf.lqF = bt.eGO();
    localf.lqE = paramString;
    a(getRuntime().getWindowAndroid());
    boolean bool = super.ct(paramString);
    AppMethodBeat.o(47898);
    return bool;
  }
  
  public final void d(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(47907);
    super.d(paramJSONObject);
    c(paramJSONObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.CpK));
    com.tencent.mm.plugin.appbrand.i.a.a(com.tencent.mm.plugin.appbrand.xweb_ext.c.buQ(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.i.a.e(com.tencent.mm.plugin.appbrand.xweb_ext.c.buW(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.i.a.b(com.tencent.mm.plugin.appbrand.xweb_ext.c.buS(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.i.a.f(com.tencent.mm.plugin.appbrand.xweb_ext.c.bvc(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.i.a.h(com.tencent.mm.plugin.appbrand.xweb_ext.c.buY(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.i.a.g(com.tencent.mm.plugin.appbrand.xweb_ext.c.buZ(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.i.a.c(com.tencent.mm.plugin.appbrand.xweb_ext.c.buV(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.i.a.d(com.tencent.mm.plugin.appbrand.xweb_ext.c.buU(), paramJSONObject);
    c(paramJSONObject, "useXWebWebGLCanvas", Boolean.valueOf(com.tencent.mm.plugin.appbrand.xweb_ext.c.bva()));
    AppMethodBeat.o(47907);
  }
  
  protected final void g(TextView paramTextView)
  {
    AppMethodBeat.i(47908);
    Object localObject = this.laZ;
    if ((paramTextView != null) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      localObject = new a.1(this);
      Drawable localDrawable = com.tencent.mm.svg.a.a.g(getContext().getResources(), 2131689598);
      paramTextView.setCompoundDrawablePadding(com.tencent.mm.cd.a.fromDPToPix(getContext(), 4));
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable, null);
      paramTextView.setOnClickListener((View.OnClickListener)localObject);
    }
    AppMethodBeat.o(47908);
  }
  
  public final void gB(boolean paramBoolean)
  {
    AppMethodBeat.i(47894);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewWC", "setHideHomeButton: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((com.tencent.mm.plugin.appbrand.ac.g.as(getRuntime())) || (com.tencent.mm.plugin.appbrand.ao.w(getRuntime())))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewWC", "skip setHideHomeButton, weishi app");
      AppMethodBeat.o(47894);
      return;
    }
    if (this.laV == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewWC", "skip setHideHomeButton, ActionBar hasn't init");
      AppMethodBeat.o(47894);
      return;
    }
    if (this.laV.isFullscreenMode())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewWC", "skip setHideHomeButton, is in fullscreen mode now");
      AppMethodBeat.o(47894);
      return;
    }
    this.lbB = paramBoolean;
    if (this.lbz != null) {
      this.lbB = ((Boolean)this.lbz.value).booleanValue();
    }
    if (!this.lby)
    {
      if (this.laV != null)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewWC", "not homepage enter customActionBar");
        this.laV.setNavResetStyleListener(new b.c()
        {
          public final void a(ImageView paramAnonymousImageView, final View paramAnonymousView1, View paramAnonymousView2)
          {
            AppMethodBeat.i(196066);
            if (paramAnonymousImageView != null)
            {
              LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramAnonymousImageView.getLayoutParams();
              i = ae.this.getContext().getResources().getDimensionPixelOffset(2131165746);
              localLayoutParams.height = i;
              localLayoutParams.width = i;
              localLayoutParams.gravity = 17;
              paramAnonymousImageView.setLayoutParams(localLayoutParams);
              localLayoutParams.leftMargin = 0;
              localLayoutParams.rightMargin = 0;
              paramAnonymousImageView.clearColorFilter();
              paramAnonymousImageView.setImageDrawable(com.tencent.mm.svg.a.a.g(ae.this.getContext().getResources(), 2131689590));
              paramAnonymousImageView.setColorFilter(ae.this.laV.getForegroundColor(), PorterDuff.Mode.SRC_ATOP);
              paramAnonymousImageView.setBackgroundResource(2131230957);
              i = ae.this.getContext().getResources().getDimensionPixelOffset(2131165568);
              paramAnonymousImageView.setPadding(i, paramAnonymousImageView.getPaddingTop(), i, paramAnonymousImageView.getPaddingBottom());
            }
            if (paramAnonymousView1 != null)
            {
              paramAnonymousImageView = (LinearLayout.LayoutParams)paramAnonymousView1.getLayoutParams();
              i = ae.this.getContext().getResources().getDimensionPixelOffset(2131165743);
              paramAnonymousImageView.height = i;
              paramAnonymousImageView.width = i;
              paramAnonymousImageView.gravity = 17;
              paramAnonymousImageView.leftMargin = ae.this.getContext().getResources().getDimensionPixelOffset(2131165744);
              paramAnonymousImageView.rightMargin = ae.this.getContext().getResources().getDimensionPixelOffset(2131165745);
              paramAnonymousView1.setLayoutParams(paramAnonymousImageView);
              if (ae.this.laV.getForegroundColor() != -1) {
                break label290;
              }
            }
            label290:
            for (int i = 2131230978;; i = 2131230979)
            {
              paramAnonymousView1.setBackgroundResource(i);
              if (paramAnonymousView2 != null) {
                paramAnonymousView2.setOnTouchListener(new View.OnTouchListener()
                {
                  public final boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
                  {
                    AppMethodBeat.i(196065);
                    if (paramAnonymousView1 != null)
                    {
                      paramAnonymousView1.onTouchEvent(paramAnonymous2MotionEvent);
                      AppMethodBeat.o(196065);
                      return true;
                    }
                    AppMethodBeat.o(196065);
                    return false;
                  }
                });
              }
              AppMethodBeat.o(196066);
              return;
            }
          }
          
          public final int bkf()
          {
            return 2131165744;
          }
        });
        this.laV.setBackButtonClickListener(new ae.7(this));
        this.laV.bre();
        this.lbx = true;
      }
      if (this.iEx == null)
      {
        str = "";
        com.tencent.mm.plugin.appbrand.report.h.D(str, this.jzm, 1);
        this.lby = true;
      }
    }
    else
    {
      bjH().setNavHidden(this.lbB);
      if ((this.lbB) && (this.kWU != null)) {
        if (this.iEx != null) {
          break label288;
        }
      }
    }
    label288:
    for (String str = "";; str = this.iEx.mAppId)
    {
      com.tencent.mm.plugin.appbrand.report.h.D(str, this.jzm, 2);
      AppMethodBeat.o(47894);
      return;
      str = this.iEx.mAppId;
      break;
    }
  }
  
  public com.tencent.mm.plugin.appbrand.o getRuntime()
  {
    AppMethodBeat.i(47887);
    com.tencent.mm.plugin.appbrand.o localo = (com.tencent.mm.plugin.appbrand.o)super.Dl();
    AppMethodBeat.o(47887);
    return localo;
  }
  
  protected final View j(ViewGroup paramViewGroup)
  {
    int i = 1;
    int k = 0;
    AppMethodBeat.i(180347);
    if ((this.iEx == null) || (!com.tencent.mm.plugin.appbrand.ao.w(this.iEx)) || (!(paramViewGroup instanceof RelativeLayout)))
    {
      AppMethodBeat.o(180347);
      return null;
    }
    if (this.lbD == null) {
      this.lbD = new ao(getContext());
    }
    Object localObject1 = this.lbD;
    Object localObject2 = this.iEx.aNc().iconUrl;
    String str1 = this.iEx.aNc().dfM;
    String str2 = com.tencent.mm.plugin.appbrand.appcache.e.qC(this.iEx.aNb().jdS.iOQ);
    boolean bool = this.iEx.aNc().CZ();
    int j;
    if (this.iEx.aNc().originalFlag == 1)
    {
      com.tencent.mm.modelappbrand.a.b.aub().a(((ao)localObject1).jFL, (String)localObject2, com.tencent.mm.modelappbrand.a.a.aua(), com.tencent.mm.modelappbrand.a.g.gSK);
      localObject2 = ((ao)localObject1).ldV;
      if (!bool) {
        break label310;
      }
      j = 2131759360;
      label175:
      ((Button)localObject2).setText(j);
      ((ao)localObject1).jFM.setText(str1);
      if (!bt.isNullOrNil(str2)) {
        break label323;
      }
      ((ao)localObject1).ldU.setVisibility(8);
      localObject1 = ((ao)localObject1).ldW;
      if (i == 0) {
        break label317;
      }
      i = k;
      label223:
      ((ImageView)localObject1).setVisibility(i);
    }
    for (;;)
    {
      this.lbD.setJumpBtnOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(196068);
          paramAnonymousView = ae.h(ae.this);
          String str = ae.this.kWX;
          ao.a locala = new ao.a();
          HashMap localHashMap = new HashMap(1);
          localHashMap.put("currentPath", str);
          locala.B(localHashMap).g(paramAnonymousView.aNe()).aXQ();
          AppMethodBeat.o(196068);
        }
      });
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(12);
      ((RelativeLayout.LayoutParams)localObject1).topMargin = (-getContext().getResources().getDimensionPixelSize(2131165852));
      paramViewGroup.addView(this.lbD, (ViewGroup.LayoutParams)localObject1);
      paramViewGroup = this.lbD;
      AppMethodBeat.o(180347);
      return paramViewGroup;
      i = 0;
      break;
      label310:
      j = 2131756060;
      break label175;
      label317:
      i = 8;
      break label223;
      label323:
      ((ao)localObject1).ldU.setText(str2);
      ((ao)localObject1).ldU.setVisibility(0);
      ((ao)localObject1).ldW.setVisibility(8);
    }
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(180348);
    if ((this.iEx != null) && (com.tencent.mm.plugin.appbrand.ao.w(this.iEx)))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPageViewWC", "SinglePageModeLogic onBackPressed");
      com.tencent.mm.plugin.appbrand.g.a(getAppId(), g.d.iDd);
      this.iEx.close();
      AppMethodBeat.o(180348);
      return true;
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(180348);
    return bool;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(180350);
    super.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(180350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ae
 * JD-Core Version:    0.7.0.1
 */