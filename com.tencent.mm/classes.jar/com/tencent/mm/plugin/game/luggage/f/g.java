package com.tencent.mm.plugin.game.luggage.f;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebResourceResponse;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.device.yearclass.YearClass;
import com.tencent.e.i;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.game.d.dm;
import com.tencent.mm.plugin.webview.luggage.ipc.ActiveMainProcessTask;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.plugin.webview.luggage.r;
import com.tencent.mm.plugin.webview.ui.tools.game.c;
import com.tencent.mm.plugin.webview.ui.tools.game.c.a;
import com.tencent.mm.plugin.webview.ui.tools.game.d.a;
import com.tencent.mm.plugin.webview.ui.tools.game.d.b;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

public class g
  extends com.tencent.mm.plugin.webview.luggage.g
  implements com.tencent.mm.plugin.webview.ui.tools.game.e
{
  public com.tencent.mm.plugin.webview.ui.tools.game.g tVA;
  public long tVB;
  private Map<String, b> tVC;
  private ViewGroup tVD;
  private boolean tVE;
  private boolean tVF;
  public d tVG;
  a tVH;
  protected GameWebPerformanceInfo tVm;
  private View tVs;
  private GameMenuImageButton tVt;
  private boolean tVu;
  private boolean tVv;
  public boolean tVw;
  private String tVx;
  public c tVy;
  private long tVz;
  
  public g(com.tencent.luggage.d.j paramj, p paramp, Bundle paramBundle)
  {
    super(paramj, paramp, paramBundle);
    AppMethodBeat.i(83183);
    this.tVu = false;
    this.tVv = false;
    this.tVw = false;
    this.tVB = 0L;
    this.tVC = new HashMap();
    this.tVF = false;
    this.tVy = new c()
    {
      public final void ag(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(83172);
        com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", paramAnonymousBundle, com.tencent.mm.plugin.game.luggage.g.a.class, null);
        AppMethodBeat.o(83172);
      }
    };
    ad.i("MicroMsg.GameWebPage", "initWebPageEnd, __Time__， time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    paramj = paramBundle.getString("rawUrl");
    this.tVm = GameWebPerformanceInfo.wg(paramj);
    this.tVm.gse = cXx();
    this.tVm.gsx = System.currentTimeMillis();
    this.tVA = alx(paramj);
    paramp = this.mParams.getString("rawUrl");
    if (!bt.isNullOrNil(paramp))
    {
      paramp = Uri.parse(paramp).getQueryParameter("nav_color");
      if (bt.isNullOrNil(paramp)) {}
    }
    try
    {
      int i = Color.parseColor("#".concat(String.valueOf(paramp)));
      this.mParams.putInt("customize_status_bar_color", i);
      label184:
      paramp = bt.Xm(paramj);
      if ((paramp != null) && (paramp.equals("game.weixin.qq.com"))) {
        this.chX.chG = com.tencent.luggage.d.a.a.cic;
      }
      cXw().EDt = new com.tencent.mm.plugin.wepkg.event.b()
      {
        public final void cXA()
        {
          AppMethodBeat.i(211676);
          f localf = (f)g.this.chX.Cm();
          if (!bt.isNullOrNil(localf.tTn)) {
            localf.post(new f.3(localf));
          }
          AppMethodBeat.o(211676);
        }
        
        public final void cXB()
        {
          AppMethodBeat.i(170131);
          g.a(g.this, true);
          g.k(g.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(170129);
              g.j(g.this);
              AppMethodBeat.o(170129);
            }
          }, 500L);
          AppMethodBeat.o(170131);
        }
        
        public final void nb(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(170132);
          ad.i("MicroMsg.GameWebPage", "onPkgReady");
          g.n(g.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(170130);
              if (g.l(g.this))
              {
                g.a(g.this, false);
                if (!((Activity)g.this.mContext).isFinishing())
                {
                  g.m(g.this);
                  g.this.chm.Ce().j(g.this.bQm(), g.this.mParams);
                }
              }
              AppMethodBeat.o(170130);
            }
          });
          AppMethodBeat.o(170132);
        }
      };
      ((f)this.chX.Cm()).setRawUrl(paramj);
      this.DOt.addJavascriptInterface(new com.tencent.mm.plugin.game.luggage.h.d(com.tencent.mm.plugin.webview.luggage.j.d(this)), "WxGameJsCoreNative");
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qpM, false))
      {
        com.tencent.mm.plugin.game.luggage.h.a.create();
        ah("created", com.tencent.mm.plugin.webview.luggage.j.d(this), paramj);
      }
      AppMethodBeat.o(83183);
      return;
    }
    catch (IllegalArgumentException paramp)
    {
      break label184;
    }
  }
  
  private static void ah(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(211685);
    if (com.tencent.mm.plugin.game.luggage.h.a.cXE() != null) {
      com.tencent.mm.plugin.game.luggage.h.a.cXE().ai(paramString1, paramString2, paramString3);
    }
    AppMethodBeat.o(211685);
  }
  
  public void A(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(180146);
    long l = System.currentTimeMillis();
    ad.i("MicroMsg.GameWebPage", "onReceivedError, errorCode: %d, description: %s, failingUrl: %s , time: %d", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, Long.valueOf(l) });
    super.A(paramInt, paramString1, paramString2);
    try
    {
      paramString1 = new JSONObject();
      paramString1.put("errcode", paramInt);
      paramString1.put("errurl", paramString2);
      com.tencent.mm.game.report.api.a.gsb.a(8, URLEncoder.encode(bQm()), URLEncoder.encode(paramString1.toString()), l - this.tVA.Ejp);
      AppMethodBeat.o(180146);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(180146);
    }
  }
  
  public View BQ()
  {
    AppMethodBeat.i(83184);
    View localView = super.BQ();
    this.tVs = LayoutInflater.from(this.mContext).inflate(2131494340, this.DOC, false);
    this.tVs.setVisibility(8);
    this.DOC.addView(this.tVs, new FrameLayout.LayoutParams(-2, -2, 17));
    ad.i("MicroMsg.GameWebPage", "create vie end, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    AppMethodBeat.o(83184);
    return localView;
  }
  
  public final boolean HC(int paramInt)
  {
    AppMethodBeat.i(83207);
    if (this.chX.Ci() == com.tencent.luggage.d.a.a.cic)
    {
      AppMethodBeat.o(83207);
      return true;
    }
    if (this.chX.Ci() == com.tencent.luggage.d.a.a.cid)
    {
      AppMethodBeat.o(83207);
      return false;
    }
    boolean bool = super.HC(paramInt);
    AppMethodBeat.o(83207);
    return bool;
  }
  
  public final WebResourceResponse alA(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(211682);
    int i = j;
    if (paramString != null)
    {
      if (paramString.length() != 0) {
        break label62;
      }
      i = j;
    }
    for (;;)
    {
      if ((i == 0) && (this.tVH != null))
      {
        this.tVH.cXl();
        this.tVH = null;
      }
      paramString = super.alA(paramString);
      AppMethodBeat.o(211682);
      return paramString;
      label62:
      String str = Uri.parse(paramString).getPath();
      i = j;
      if (str != null)
      {
        i = j;
        if (str.trim().endsWith("html")) {
          i = 1;
        }
      }
    }
  }
  
  public final void alB(String paramString)
  {
    AppMethodBeat.i(83202);
    super.alB(paramString);
    if (this.tVA.Ejt == 0L) {
      this.tVA.Ejt = System.currentTimeMillis();
    }
    AppMethodBeat.o(83202);
  }
  
  public final boolean alw(String paramString)
  {
    AppMethodBeat.i(83195);
    boolean bool = ((f)this.DOt).alw(paramString);
    AppMethodBeat.o(83195);
    return bool;
  }
  
  protected com.tencent.mm.plugin.webview.ui.tools.game.g alx(String paramString)
  {
    AppMethodBeat.i(83186);
    paramString = com.tencent.mm.plugin.webview.ui.tools.game.g.aJd(paramString);
    AppMethodBeat.o(83186);
    return paramString;
  }
  
  public boolean aly(String paramString)
  {
    AppMethodBeat.i(83187);
    if ((paramString.equals(bQm())) && (this.tVm.gsC == 0L))
    {
      this.tVm.gsC = System.currentTimeMillis();
      ad.i("MicroMsg.GameWebPage", "startGetA8Key, url: %s, time: %d", new Object[] { paramString, Long.valueOf(this.tVm.gsC) });
    }
    boolean bool = super.aly(paramString);
    AppMethodBeat.o(83187);
    return bool;
  }
  
  public final void alz(String paramString)
  {
    AppMethodBeat.i(83199);
    super.alz(paramString);
    if (this.tVm.gsz == 0L) {
      this.tVm.gsz = System.currentTimeMillis();
    }
    AppMethodBeat.o(83199);
  }
  
  public final void cD(String paramString)
  {
    AppMethodBeat.i(83200);
    long l = System.currentTimeMillis();
    ad.i("MicroMsg.GameWebPage", "onUrlLoadingStarted, url = %s, __Time__, time = %d", new Object[] { paramString, Long.valueOf(l) });
    super.cD(paramString);
    if (this.tVm.gsA == 0L) {
      this.tVm.gsA = l;
    }
    if (this.tVA.Ejr == 0L) {
      this.tVA.Ejr = l;
    }
    paramString = bt.Xm(paramString);
    if ((paramString != null) && (paramString.equals("game.weixin.qq.com"))) {}
    for (this.chX.chG = com.tencent.luggage.d.a.a.cic;; this.chX.chG = this.DOM)
    {
      this.tVy.EiG.eUn();
      AppMethodBeat.o(83200);
      return;
    }
  }
  
  public void cE(String paramString)
  {
    AppMethodBeat.i(83201);
    long l = System.currentTimeMillis();
    ad.i("MicroMsg.GameWebPage", "onUrlLoadingFinished, url = %s, __Time__, time = %d", new Object[] { paramString, Long.valueOf(l) });
    super.cE(paramString);
    if (this.tVm.gsB == 0L) {
      this.tVm.gsB = l;
    }
    if (this.tVA.Ejs == 0L) {
      this.tVA.Ejs = l;
    }
    try
    {
      if (!this.tVu)
      {
        this.tVu = true;
        com.tencent.mm.game.report.api.a.gsb.a(7, URLEncoder.encode(bQm()), "", l - this.tVA.Ejp);
      }
      label117:
      com.tencent.mm.plugin.game.luggage.g.a(this.chX, this.tTn);
      this.tVy.EiG.CA();
      AppMethodBeat.o(83201);
      return;
    }
    catch (Exception paramString)
    {
      break label117;
    }
  }
  
  public void cXk()
  {
    AppMethodBeat.i(83196);
    au(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83175);
        g.c(g.this).setVisibility(0);
        AppMethodBeat.o(83175);
      }
    });
    AppMethodBeat.o(83196);
  }
  
  public final void cXp()
  {
    AppMethodBeat.i(83188);
    this.DOe.cXp();
    AppMethodBeat.o(83188);
  }
  
  public final View cXt()
  {
    AppMethodBeat.i(83185);
    this.DOe = new e(this);
    m localm = this.DOe;
    AppMethodBeat.o(83185);
    return localm;
  }
  
  public final void cXu()
  {
    AppMethodBeat.i(83194);
    dm localdm;
    if (!this.DOP)
    {
      this.DOQ = this.mParams.getInt("customize_status_bar_color");
      if (this.DOQ == 0)
      {
        localdm = com.tencent.mm.plugin.game.commlib.a.cWQ();
        if ((localdm == null) || (bt.isNullOrNil(localdm.hAD)) || (bt.isNullOrNil(localdm.ujP))) {}
      }
    }
    try
    {
      if (al.isDarkMode()) {}
      for (this.DOQ = Color.parseColor(localdm.ujP);; this.DOQ = Color.parseColor(localdm.hAD))
      {
        if (this.DOQ == 0) {
          this.DOQ = android.support.v4.content.b.n(this.mContext, 2131099873);
        }
        ePc();
        AppMethodBeat.o(83194);
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        ad.e("MicroMsg.GameWebPage", "parse color: " + localIllegalArgumentException.getMessage());
      }
    }
  }
  
  public final void cXv()
  {
    AppMethodBeat.i(83197);
    this.tVs.setVisibility(8);
    AppMethodBeat.o(83197);
  }
  
  public final com.tencent.mm.plugin.wepkg.d cXw()
  {
    AppMethodBeat.i(83205);
    com.tencent.mm.plugin.wepkg.d locald = ((f)this.DOt).getWePkgPlugin();
    AppMethodBeat.o(83205);
    return locald;
  }
  
  public final String cXx()
  {
    AppMethodBeat.i(83206);
    String str = (hashCode() & 0x7FFFFFFF) + "_" + (bQm().hashCode() & 0x7FFFFFFF);
    AppMethodBeat.o(83206);
    return str;
  }
  
  public final Map<Integer, Object> cXy()
  {
    AppMethodBeat.i(211683);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(d.a.EiM), cXx());
    localHashMap.put(Integer.valueOf(d.a.EiN), ay.iR(aj.getContext()));
    localHashMap.put(Integer.valueOf(d.a.EiO), String.valueOf(YearClass.get(aj.getContext())));
    String str = bQm();
    try
    {
      localHashMap.put(Integer.valueOf(d.a.EiP), com.tencent.mm.compatible.util.q.encode(bt.nullAsNil(str), "UTF-8"));
      label94:
      int j = d.a.EiQ;
      int i;
      if (alw(str))
      {
        i = 1;
        localHashMap.put(Integer.valueOf(j), Integer.valueOf(i));
        localHashMap.put(Integer.valueOf(d.a.EiR), Integer.valueOf(1));
        if (!(this instanceof h)) {
          break label211;
        }
        localHashMap.put(Integer.valueOf(d.a.EiS), Integer.valueOf(1));
      }
      for (;;)
      {
        localHashMap.put(Integer.valueOf(d.a.EiT), cXw().eXF());
        i = d.a.EiU;
        cXw();
        localHashMap.put(Integer.valueOf(i), com.tencent.mm.plugin.wepkg.d.eXG());
        AppMethodBeat.o(211683);
        return localHashMap;
        i = 0;
        break;
        label211:
        localHashMap.put(Integer.valueOf(d.a.EiS), Integer.valueOf(0));
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label94;
    }
  }
  
  public final Map<Integer, Object> cXz()
  {
    AppMethodBeat.i(211684);
    HashMap localHashMap = new HashMap();
    com.tencent.mm.plugin.webview.ui.tools.game.g localg = com.tencent.mm.plugin.webview.ui.tools.game.g.aJe(bQm());
    if (localg != null)
    {
      localHashMap.put(Integer.valueOf(d.b.EiX), Long.valueOf(localg.Ejq - localg.startTime));
      localHashMap.put(Integer.valueOf(d.b.EiY), Long.valueOf(localg.Ejr - localg.startTime));
      localHashMap.put(Integer.valueOf(d.b.EiZ), Long.valueOf(localg.Ejs - localg.Ejr));
      localHashMap.put(Integer.valueOf(d.b.Eja), Long.valueOf(localg.Eju - localg.Ejt));
      localHashMap.put(Integer.valueOf(d.b.Ejb), Long.valueOf(localg.Ejw - localg.Ejv));
      localHashMap.put(Integer.valueOf(d.b.Ejj), Long.valueOf(localg.Ejx));
      localHashMap.put(Integer.valueOf(d.b.Ejl), Long.valueOf(localg.Ejy));
      localHashMap.put(Integer.valueOf(d.b.Ejc), Long.valueOf(localg.Ejz));
      localHashMap.put(Integer.valueOf(d.b.Ejd), Long.valueOf(localg.EjA));
      localHashMap.put(Integer.valueOf(d.b.Eje), Long.valueOf(localg.mxj));
      localHashMap.put(Integer.valueOf(d.b.Ejf), Long.valueOf(localg.EjB));
      localHashMap.put(Integer.valueOf(d.b.Ejg), Long.valueOf(localg.EjC));
      localHashMap.put(Integer.valueOf(d.b.Ejh), Long.valueOf(localg.EjD));
      localHashMap.put(Integer.valueOf(d.b.Eji), Long.valueOf(localg.EjE));
      localHashMap.put(Integer.valueOf(d.b.Ejm), Long.valueOf(System.currentTimeMillis()));
      localHashMap.put(Integer.valueOf(d.b.Ejn), Long.valueOf(localg.EjF));
    }
    int j = d.b.Ejk;
    if (bt.isNullOrNil(cXw().eXD())) {}
    for (int i = 0;; i = 1)
    {
      localHashMap.put(Integer.valueOf(j), Integer.valueOf(i));
      AppMethodBeat.o(211684);
      return localHashMap;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(211681);
    String str = com.tencent.mm.plugin.appbrand.z.d.UT("game_performance.js");
    final long l = System.currentTimeMillis();
    this.DOt.evaluateJavascript(str, new ValueCallback() {});
    AppMethodBeat.o(211681);
  }
  
  public void e(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(83203);
    super.e(paramString1, paramString2, paramMap);
    f localf = (f)this.chX.Cm();
    localf.tTn = paramString2;
    localf.tVf = paramMap;
    if (bt.isNullOrNil(paramString2)) {
      ad.i("MicroMsg.LuggageGameUinKeyHolder", "setFullUrlAndHeaders, fullUrl is null");
    }
    for (;;)
    {
      long l = System.currentTimeMillis();
      if (paramString1.equals(bQm()))
      {
        ad.i("MicroMsg.GameWebPage", "getA8Key end, __Time__, time: %d", new Object[] { Long.valueOf(l) });
        this.tVm.gsD = l;
      }
      if (this.tVm.gsz == 0L) {
        this.tVm.gsz = l;
      }
      if (this.tVA.Eju == 0L) {
        this.tVA.Eju = System.currentTimeMillis();
      }
      com.tencent.mm.plugin.game.luggage.g.a(getWebView(), paramString2, paramMap);
      com.tencent.mm.plugin.game.luggage.g.a(this.chX, paramString2);
      this.tVw = true;
      AppMethodBeat.o(83203);
      return;
      if (!Uri.parse(paramString2).getHost().equals("game.weixin.qq.com"))
      {
        ad.i("MicroMsg.LuggageGameUinKeyHolder", "setFullUrlAndHeaders, host is not wxgame");
      }
      else
      {
        com.tencent.mm.plugin.game.luggage.e.tTn = paramString2;
        com.tencent.mm.plugin.game.luggage.e.mHeaders = paramMap;
        com.tencent.mm.plugin.game.luggage.e.MX = System.currentTimeMillis() / 1000L;
      }
    }
  }
  
  public void g(final String paramString, final Bundle paramBundle)
  {
    AppMethodBeat.i(83198);
    ad.i("MicroMsg.GameWebPage", "load url, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (this.tVA.Ejq == 0L) {
      this.tVA.Ejq = System.currentTimeMillis();
    }
    paramBundle = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83176);
        g.a(g.this, paramString, paramBundle);
        AppMethodBeat.o(83176);
      }
    };
    if (AppBrandMainProcessService.bhH())
    {
      ad.i("MicroMsg.GameWebPage", "activeIpcTask, service is alive");
      paramBundle.run();
      AppMethodBeat.o(83198);
      return;
    }
    final long l = System.currentTimeMillis();
    final PBool localPBool = new PBool();
    ActiveMainProcessTask localActiveMainProcessTask = new ActiveMainProcessTask();
    localActiveMainProcessTask.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83178);
        long l1 = System.currentTimeMillis();
        long l2 = l;
        ad.i("MicroMsg.GameWebPage", "activeIpcTask, callback");
        localPBool.bhO();
        synchronized (paramBundle)
        {
          if (paramBundle.value)
          {
            AppMethodBeat.o(83178);
            return;
          }
          paramBundle.value = true;
          paramString.run();
          com.tencent.mm.plugin.wepkg.utils.a.b("ipcServiceStartTime", this.val$url, com.tencent.mm.plugin.wepkg.utils.d.aKY(this.val$url), null, 0L, l1 - l2, null);
          AppMethodBeat.o(83178);
          return;
        }
      }
    };
    localActiveMainProcessTask.bhN();
    AppBrandMainProcessService.a(localActiveMainProcessTask);
    com.tencent.e.h.LTJ.r(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83180);
        synchronized (localPBool)
        {
          if (localPBool.value)
          {
            AppMethodBeat.o(83180);
            return;
          }
          ad.i("MicroMsg.GameWebPage", "activeIpcTask, time out, callback");
          localPBool.value = true;
          g.a(g.this, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(211680);
              g.8.this.val$callback.run();
              AppMethodBeat.o(211680);
            }
          });
          AppMethodBeat.o(83180);
          return;
        }
      }
    }, 1000L);
    AppMethodBeat.o(83198);
  }
  
  public void na(boolean paramBoolean)
  {
    AppMethodBeat.i(83193);
    super.na(paramBoolean);
    if (isFullScreen())
    {
      this.tVx = this.mParams.getString("game_hv_menu_appid");
      if (!bt.isNullOrNil(this.tVx))
      {
        if (this.tVt == null)
        {
          this.tVt = new GameMenuImageButton(this.mContext);
          this.tVt.a(this.mRootView, new GameMenuImageButton.a()
          {
            public final void cXC()
            {
              AppMethodBeat.i(211679);
              g.this.cXp();
              AppMethodBeat.o(211679);
            }
          });
        }
        this.DOB.setVisibility(8);
        AppMethodBeat.o(83193);
        return;
      }
      this.DOB.setVisibility(0);
    }
    AppMethodBeat.o(83193);
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(83190);
    ad.i("MicroMsg.GameWebPage", "onBackground, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    Object localObject = this.tVm;
    ((GameWebPerformanceInfo)localObject).gsE += System.currentTimeMillis() - this.tVz;
    this.tVz = System.currentTimeMillis();
    this.tVy.EiG.onPause();
    int i = this.chm.Cd().indexOf(this);
    if ((i > 1) && (((com.tencent.luggage.d.h)this.chm.Cd().get(i - 1) instanceof a)))
    {
      AppMethodBeat.o(83190);
      return;
    }
    super.onBackground();
    localObject = this.tVC.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b)((Iterator)localObject).next()).onBackground();
    }
    ah("background", com.tencent.mm.plugin.webview.luggage.j.d(this), null);
    AppMethodBeat.o(83190);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(83191);
    ad.i("MicroMsg.GameWebPage", "onDestroy, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    super.onDestroy();
    c.a(this.tVy.EiG.EiH);
    Object localObject = this.tVm;
    ((GameWebPerformanceInfo)localObject).gsE += System.currentTimeMillis() - this.tVz;
    this.tVm.gsF = System.currentTimeMillis();
    if (!this.mParams.getBoolean("from_bag", false))
    {
      localObject = com.tencent.mm.game.report.api.a.gsb;
      if (localObject != null) {
        ((com.tencent.mm.game.report.api.a)localObject).a(this.tVm);
      }
      if (!this.tVF) {
        com.tencent.mm.plugin.webview.ui.tools.game.d.a(cXx(), this);
      }
    }
    for (;;)
    {
      try
      {
        if (!this.tVv)
        {
          this.tVv = true;
          localObject = new JSONObject();
          if (this.tVB != 0L) {
            continue;
          }
          ((JSONObject)localObject).put("render_duration", 0);
          com.tencent.mm.game.report.api.a.gsb.a(9, URLEncoder.encode(bQm()), URLEncoder.encode(((JSONObject)localObject).toString()), System.currentTimeMillis() - this.tVA.Ejp);
        }
      }
      catch (Exception localException)
      {
        continue;
        if (!this.DOF.bKz()) {
          continue;
        }
        r.aHa(this.DOF.DPV);
        ah("destroyed", com.tencent.mm.plugin.webview.luggage.j.d(this), null);
        AppMethodBeat.o(83191);
      }
      GameWebPerformanceInfo.wi(bQm());
      if (!this.tVF) {
        com.tencent.mm.plugin.webview.ui.tools.game.g.aJf(bQm());
      }
      localObject = this.tVC.values();
      if ((localObject == null) || (((Collection)localObject).size() <= 0)) {
        continue;
      }
      localObject = ((Collection)localObject).iterator();
      if (!((Iterator)localObject).hasNext()) {
        continue;
      }
      ((b)((Iterator)localObject).next()).onDestroy();
      continue;
      ((JSONObject)localObject).put("render_duration", this.tVB - this.tVA.Ejp);
    }
  }
  
  public void onForeground()
  {
    AppMethodBeat.i(83189);
    ad.i("MicroMsg.GameWebPage", "onForeground, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (this.tVm.gsv == 0L) {
      this.tVm.gsv = System.currentTimeMillis();
    }
    this.tVz = System.currentTimeMillis();
    this.tVy.EiG.onResume();
    super.onForeground();
    Iterator localIterator = this.tVC.values().iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).onForeground();
    }
    ah("foreground", com.tencent.mm.plugin.webview.luggage.j.d(this), null);
    AppMethodBeat.o(83189);
  }
  
  public final void reload()
  {
    AppMethodBeat.i(83192);
    super.reload();
    AppMethodBeat.o(83192);
  }
  
  public static abstract interface a
  {
    public abstract void cXl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.f.g
 * JD-Core Version:    0.7.0.1
 */