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
import com.tencent.mm.plugin.game.d.dv;
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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class g
  extends com.tencent.mm.plugin.webview.luggage.g
  implements com.tencent.mm.plugin.webview.ui.tools.game.e
{
  private ViewGroup ugA;
  private boolean ugB;
  private boolean ugC;
  private boolean ugD;
  public d ugE;
  a ugF;
  protected GameWebPerformanceInfo ugi;
  private View ugo;
  private GameMenuImageButton ugp;
  private boolean ugq;
  private boolean ugr;
  public boolean ugs;
  private boolean ugt;
  private String ugu;
  public c ugv;
  private long ugw;
  public com.tencent.mm.plugin.webview.ui.tools.game.g ugx;
  public long ugy;
  private Map<String, b> ugz;
  
  public g(com.tencent.luggage.d.j paramj, p paramp, Bundle paramBundle)
  {
    super(paramj, paramp, paramBundle);
    AppMethodBeat.i(83183);
    this.ugq = false;
    this.ugr = false;
    this.ugs = false;
    this.ugt = false;
    this.ugy = 0L;
    this.ugz = new HashMap();
    this.ugC = false;
    this.ugD = false;
    this.ugv = new c()
    {
      public final void ah(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(83172);
        com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", paramAnonymousBundle, com.tencent.mm.plugin.game.luggage.g.a.class, null);
        AppMethodBeat.o(83172);
      }
    };
    ae.i("MicroMsg.GameWebPage", "initWebPageEnd, __Time__， time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    paramj = paramBundle.getString("rawUrl");
    this.ugi = GameWebPerformanceInfo.wP(paramj);
    this.ugi.guF = dah();
    this.ugi.guY = System.currentTimeMillis();
    this.ugx = amv(paramj);
    paramp = this.mParams.getString("rawUrl");
    if (!bu.isNullOrNil(paramp))
    {
      paramp = Uri.parse(paramp).getQueryParameter("nav_color");
      if (bu.isNullOrNil(paramp)) {}
    }
    try
    {
      int i = Color.parseColor("#".concat(String.valueOf(paramp)));
      this.mParams.putInt("customize_status_bar_color", i);
      label194:
      paramp = bu.XY(paramj);
      if ((paramp != null) && (paramp.equals("game.weixin.qq.com"))) {
        this.chX.chG = com.tencent.luggage.d.a.a.cic;
      }
      dag().EVP = new com.tencent.mm.plugin.wepkg.event.b()
      {
        public final void dak()
        {
          AppMethodBeat.i(193071);
          f localf = (f)g.this.chX.Cp();
          if (!bu.isNullOrNil(localf.uee)) {
            localf.post(new f.3(localf));
          }
          AppMethodBeat.o(193071);
        }
        
        public final void dal()
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
        
        public final void nf(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(170132);
          ae.i("MicroMsg.GameWebPage", "onPkgReady");
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
                  g.this.chm.Ch().j(g.this.bRn(), g.this.mParams);
                }
              }
              AppMethodBeat.o(170130);
            }
          });
          AppMethodBeat.o(170132);
        }
      };
      ((f)this.chX.Cp()).setRawUrl(paramj);
      this.Egt.addJavascriptInterface(new com.tencent.mm.plugin.game.luggage.h.d(com.tencent.mm.plugin.webview.luggage.j.d(this)), "WxGameJsCoreNative");
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwt, false))
      {
        com.tencent.mm.plugin.game.luggage.h.a.create();
        ai("created", com.tencent.mm.plugin.webview.luggage.j.d(this), paramj);
      }
      AppMethodBeat.o(83183);
      return;
    }
    catch (IllegalArgumentException paramp)
    {
      break label194;
    }
  }
  
  private static void ai(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(193081);
    if (com.tencent.mm.plugin.game.luggage.h.a.dao() != null) {
      com.tencent.mm.plugin.game.luggage.h.a.dao().aj(paramString1, paramString2, paramString3);
    }
    AppMethodBeat.o(193081);
  }
  
  private static boolean amA(String paramString)
  {
    AppMethodBeat.i(193082);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(193082);
      return false;
    }
    try
    {
      new JSONObject(paramString);
      AppMethodBeat.o(193082);
      return true;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(193082);
    }
    return false;
  }
  
  public void A(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(180146);
    long l = System.currentTimeMillis();
    ae.i("MicroMsg.GameWebPage", "onReceivedError, errorCode: %d, description: %s, failingUrl: %s , time: %d", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, Long.valueOf(l) });
    super.A(paramInt, paramString1, paramString2);
    try
    {
      paramString1 = new JSONObject();
      paramString1.put("errcode", paramInt);
      paramString1.put("errurl", paramString2);
      com.tencent.mm.game.report.api.a.guC.a(8, URLEncoder.encode(bRn()), URLEncoder.encode(paramString1.toString()), l - this.ugx.EBt);
      AppMethodBeat.o(180146);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(180146);
    }
  }
  
  public View BR()
  {
    AppMethodBeat.i(83184);
    View localView = super.BR();
    this.ugo = LayoutInflater.from(this.mContext).inflate(2131494340, this.EgC, false);
    this.ugo.setVisibility(8);
    this.EgC.addView(this.ugo, new FrameLayout.LayoutParams(-2, -2, 17));
    ae.i("MicroMsg.GameWebPage", "create vie end, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    AppMethodBeat.o(83184);
    return localView;
  }
  
  public final boolean HZ(int paramInt)
  {
    AppMethodBeat.i(83207);
    if (this.chX.Cl() == com.tencent.luggage.d.a.a.cic)
    {
      AppMethodBeat.o(83207);
      return true;
    }
    if (this.chX.Cl() == com.tencent.luggage.d.a.a.cid)
    {
      AppMethodBeat.o(83207);
      return false;
    }
    boolean bool = super.HZ(paramInt);
    AppMethodBeat.o(83207);
    return bool;
  }
  
  public final boolean amu(String paramString)
  {
    AppMethodBeat.i(83195);
    boolean bool = ((f)this.Egt).amu(paramString);
    AppMethodBeat.o(83195);
    return bool;
  }
  
  protected com.tencent.mm.plugin.webview.ui.tools.game.g amv(String paramString)
  {
    AppMethodBeat.i(83186);
    paramString = com.tencent.mm.plugin.webview.ui.tools.game.g.aKw(paramString);
    AppMethodBeat.o(83186);
    return paramString;
  }
  
  public boolean amw(String paramString)
  {
    AppMethodBeat.i(83187);
    if ((paramString.equals(bRn())) && (this.ugi.gvd == 0L))
    {
      this.ugi.gvd = System.currentTimeMillis();
      ae.i("MicroMsg.GameWebPage", "startGetA8Key, url: %s, time: %d", new Object[] { paramString, Long.valueOf(this.ugi.gvd) });
    }
    boolean bool = super.amw(paramString);
    AppMethodBeat.o(83187);
    return bool;
  }
  
  public final void amx(String paramString)
  {
    AppMethodBeat.i(83199);
    super.amx(paramString);
    if (this.ugi.gva == 0L) {
      this.ugi.gva = System.currentTimeMillis();
    }
    AppMethodBeat.o(83199);
  }
  
  public final WebResourceResponse amy(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(193078);
    int i = j;
    if (paramString != null)
    {
      if (paramString.length() != 0) {
        break label89;
      }
      i = j;
    }
    for (;;)
    {
      if ((i == 0) && (!this.ugD))
      {
        this.ugD = true;
        if (this.ugF != null)
        {
          this.ugF.cZV();
          this.ugF = null;
        }
        this.mHandler.postUI(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(193072);
            String str1 = g.this.cZU();
            if (g.amB(str1))
            {
              String str2 = String.format("javascript:(function(){ window.wgclient = window.wgclient || {}; window.wgclient.__gamePreInjectData__= %s; })()", new Object[] { str1 });
              ae.i("MicroMsg.GameWebPage", "preInjectData, size:%d", new Object[] { Integer.valueOf(str1.getBytes().length) });
              g.this.cC(str2);
            }
            AppMethodBeat.o(193072);
          }
        });
      }
      paramString = super.amy(paramString);
      AppMethodBeat.o(193078);
      return paramString;
      label89:
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
  
  public final void amz(String paramString)
  {
    AppMethodBeat.i(83202);
    super.amz(paramString);
    if (this.ugx.EBx == 0L) {
      this.ugx.EBx = System.currentTimeMillis();
    }
    AppMethodBeat.o(83202);
  }
  
  public final void cE(String paramString)
  {
    AppMethodBeat.i(83200);
    long l = System.currentTimeMillis();
    ae.i("MicroMsg.GameWebPage", "onUrlLoadingStarted, url = %s, __Time__, time = %d", new Object[] { paramString, Long.valueOf(l) });
    super.cE(paramString);
    if (this.ugi.gvb == 0L) {
      this.ugi.gvb = l;
    }
    if (this.ugx.EBv == 0L) {
      this.ugx.EBv = l;
    }
    paramString = bu.XY(paramString);
    if ((paramString != null) && (paramString.equals("game.weixin.qq.com"))) {}
    for (this.chX.chG = com.tencent.luggage.d.a.a.cic;; this.chX.chG = this.EgM)
    {
      this.ugv.EAK.eYa();
      AppMethodBeat.o(83200);
      return;
    }
  }
  
  public void cF(String paramString)
  {
    AppMethodBeat.i(83201);
    long l = System.currentTimeMillis();
    ae.i("MicroMsg.GameWebPage", "onUrlLoadingFinished, url = %s, __Time__, time = %d", new Object[] { paramString, Long.valueOf(l) });
    super.cF(paramString);
    if (this.ugi.gvc == 0L) {
      this.ugi.gvc = l;
    }
    if (this.ugx.EBw == 0L) {
      this.ugx.EBw = l;
    }
    try
    {
      if (!this.ugq)
      {
        this.ugq = true;
        com.tencent.mm.game.report.api.a.guC.a(7, URLEncoder.encode(bRn()), "", l - this.ugx.EBt);
      }
      label117:
      com.tencent.mm.plugin.game.luggage.g.a(this.chX, this.uee);
      this.ugv.EAK.CD();
      AppMethodBeat.o(83201);
      return;
    }
    catch (Exception paramString)
    {
      break label117;
    }
  }
  
  public void cZT()
  {
    AppMethodBeat.i(83196);
    as(new Runnable()
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
  
  protected String cZU()
  {
    AppMethodBeat.i(193083);
    String str = this.mParams.getString("game_pre_inject_data");
    AppMethodBeat.o(193083);
    return str;
  }
  
  public final void cZZ()
  {
    AppMethodBeat.i(83188);
    this.Ege.cZZ();
    AppMethodBeat.o(83188);
  }
  
  public final View dad()
  {
    AppMethodBeat.i(83185);
    this.Ege = new e(this);
    m localm = this.Ege;
    AppMethodBeat.o(83185);
    return localm;
  }
  
  public final void dae()
  {
    AppMethodBeat.i(83194);
    dv localdv;
    if (!this.EgP)
    {
      this.EgQ = this.mParams.getInt("customize_status_bar_color");
      if (this.EgQ == 0)
      {
        localdv = com.tencent.mm.plugin.game.commlib.a.cZu();
        if ((localdv == null) || (bu.isNullOrNil(localdv.hDr)) || (bu.isNullOrNil(localdv.uvn))) {}
      }
    }
    try
    {
      if (al.isDarkMode()) {}
      for (this.EgQ = Color.parseColor(localdv.uvn);; this.EgQ = Color.parseColor(localdv.hDr))
      {
        if (this.EgQ == 0) {
          this.EgQ = android.support.v4.content.b.n(this.mContext, 2131099873);
        }
        if (!this.ugt)
        {
          this.ugt = true;
          eSO();
        }
        AppMethodBeat.o(83194);
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        ae.e("MicroMsg.GameWebPage", "parse color: " + localIllegalArgumentException.getMessage());
      }
    }
  }
  
  public final void daf()
  {
    AppMethodBeat.i(83197);
    this.ugo.setVisibility(8);
    AppMethodBeat.o(83197);
  }
  
  public final com.tencent.mm.plugin.wepkg.d dag()
  {
    AppMethodBeat.i(83205);
    com.tencent.mm.plugin.wepkg.d locald = ((f)this.Egt).getWePkgPlugin();
    AppMethodBeat.o(83205);
    return locald;
  }
  
  public final String dah()
  {
    AppMethodBeat.i(83206);
    String str = (hashCode() & 0x7FFFFFFF) + "_" + (bRn().hashCode() & 0x7FFFFFFF);
    AppMethodBeat.o(83206);
    return str;
  }
  
  public final Map<Integer, Object> dai()
  {
    AppMethodBeat.i(193079);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(d.a.EAQ), dah());
    localHashMap.put(Integer.valueOf(d.a.EAR), az.iW(ak.getContext()));
    localHashMap.put(Integer.valueOf(d.a.EAS), String.valueOf(YearClass.get(ak.getContext())));
    String str = bRn();
    try
    {
      localHashMap.put(Integer.valueOf(d.a.EAT), com.tencent.mm.compatible.util.q.encode(bu.nullAsNil(str), "UTF-8"));
      label94:
      int j = d.a.EAU;
      int i;
      if (amu(str))
      {
        i = 1;
        localHashMap.put(Integer.valueOf(j), Integer.valueOf(i));
        localHashMap.put(Integer.valueOf(d.a.EAV), Integer.valueOf(1));
        if (!(this instanceof h)) {
          break label211;
        }
        localHashMap.put(Integer.valueOf(d.a.EAW), Integer.valueOf(1));
      }
      for (;;)
      {
        localHashMap.put(Integer.valueOf(d.a.EAX), dag().fbr());
        i = d.a.EAY;
        dag();
        localHashMap.put(Integer.valueOf(i), com.tencent.mm.plugin.wepkg.d.fbs());
        AppMethodBeat.o(193079);
        return localHashMap;
        i = 0;
        break;
        label211:
        localHashMap.put(Integer.valueOf(d.a.EAW), Integer.valueOf(0));
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label94;
    }
  }
  
  public final Map<Integer, Object> daj()
  {
    AppMethodBeat.i(193080);
    HashMap localHashMap = new HashMap();
    com.tencent.mm.plugin.webview.ui.tools.game.g localg = com.tencent.mm.plugin.webview.ui.tools.game.g.aKx(bRn());
    if (localg != null)
    {
      localHashMap.put(Integer.valueOf(d.b.EBb), Long.valueOf(localg.EBu - localg.startTime));
      localHashMap.put(Integer.valueOf(d.b.EBc), Long.valueOf(localg.EBv - localg.startTime));
      localHashMap.put(Integer.valueOf(d.b.EBd), Long.valueOf(localg.EBw - localg.EBv));
      localHashMap.put(Integer.valueOf(d.b.EBe), Long.valueOf(localg.EBy - localg.EBx));
      localHashMap.put(Integer.valueOf(d.b.EBf), Long.valueOf(localg.EBA - localg.EBz));
      localHashMap.put(Integer.valueOf(d.b.EBn), Long.valueOf(localg.EBB));
      localHashMap.put(Integer.valueOf(d.b.EBp), Long.valueOf(localg.EBC));
      localHashMap.put(Integer.valueOf(d.b.EBg), Long.valueOf(localg.EBD));
      localHashMap.put(Integer.valueOf(d.b.EBh), Long.valueOf(localg.EBE));
      localHashMap.put(Integer.valueOf(d.b.EBi), Long.valueOf(localg.mCg));
      localHashMap.put(Integer.valueOf(d.b.EBj), Long.valueOf(localg.EBF));
      localHashMap.put(Integer.valueOf(d.b.EBk), Long.valueOf(localg.EBG));
      localHashMap.put(Integer.valueOf(d.b.EBl), Long.valueOf(localg.EBH));
      localHashMap.put(Integer.valueOf(d.b.EBm), Long.valueOf(localg.EBI));
      localHashMap.put(Integer.valueOf(d.b.EBq), Long.valueOf(System.currentTimeMillis()));
      localHashMap.put(Integer.valueOf(d.b.EBr), Long.valueOf(localg.EBJ));
    }
    int j = d.b.EBo;
    if (bu.isNullOrNil(dag().fbp())) {}
    for (int i = 0;; i = 1)
    {
      localHashMap.put(Integer.valueOf(j), Integer.valueOf(i));
      AppMethodBeat.o(193080);
      return localHashMap;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(193077);
    String str = com.tencent.mm.plugin.appbrand.y.d.VE("game_performance.js");
    final long l = System.currentTimeMillis();
    this.Egt.evaluateJavascript(str, new ValueCallback() {});
    AppMethodBeat.o(193077);
  }
  
  public void e(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(83203);
    super.e(paramString1, paramString2, paramMap);
    f localf = (f)this.chX.Cp();
    localf.uee = paramString2;
    localf.ugb = paramMap;
    if (bu.isNullOrNil(paramString2)) {
      ae.i("MicroMsg.LuggageGameUinKeyHolder", "setFullUrlAndHeaders, fullUrl is null");
    }
    for (;;)
    {
      long l = System.currentTimeMillis();
      if (paramString1.equals(bRn()))
      {
        ae.i("MicroMsg.GameWebPage", "getA8Key end, __Time__, time: %d", new Object[] { Long.valueOf(l) });
        this.ugi.gve = l;
      }
      if (this.ugi.gva == 0L) {
        this.ugi.gva = l;
      }
      if (this.ugx.EBy == 0L) {
        this.ugx.EBy = System.currentTimeMillis();
      }
      com.tencent.mm.plugin.game.luggage.g.a(getWebView(), paramString2, paramMap);
      com.tencent.mm.plugin.game.luggage.g.a(this.chX, paramString2);
      this.ugs = true;
      AppMethodBeat.o(83203);
      return;
      if (!Uri.parse(paramString2).getHost().equals("game.weixin.qq.com"))
      {
        ae.i("MicroMsg.LuggageGameUinKeyHolder", "setFullUrlAndHeaders, host is not wxgame");
      }
      else
      {
        com.tencent.mm.plugin.game.luggage.e.uee = paramString2;
        com.tencent.mm.plugin.game.luggage.e.mHeaders = paramMap;
        com.tencent.mm.plugin.game.luggage.e.MX = System.currentTimeMillis() / 1000L;
      }
    }
  }
  
  public void g(final String paramString, final Bundle paramBundle)
  {
    AppMethodBeat.i(83198);
    ae.i("MicroMsg.GameWebPage", "load url, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (this.ugx.EBu == 0L) {
      this.ugx.EBu = System.currentTimeMillis();
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
    if (AppBrandMainProcessService.bip())
    {
      ae.i("MicroMsg.GameWebPage", "activeIpcTask, service is alive");
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
        ae.i("MicroMsg.GameWebPage", "activeIpcTask, callback");
        localPBool.bix();
        synchronized (paramBundle)
        {
          if (paramBundle.value)
          {
            AppMethodBeat.o(83178);
            return;
          }
          paramBundle.value = true;
          paramString.run();
          com.tencent.mm.plugin.wepkg.utils.a.b("ipcServiceStartTime", this.val$url, com.tencent.mm.plugin.wepkg.utils.d.aMu(this.val$url), null, 0L, l1 - l2, null);
          AppMethodBeat.o(83178);
          return;
        }
      }
    };
    localActiveMainProcessTask.biw();
    AppBrandMainProcessService.a(localActiveMainProcessTask);
    com.tencent.e.h.MqF.r(new Runnable()
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
          ae.i("MicroMsg.GameWebPage", "activeIpcTask, time out, callback");
          localPBool.value = true;
          g.a(g.this, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(193076);
              g.9.this.val$callback.run();
              AppMethodBeat.o(193076);
            }
          });
          AppMethodBeat.o(83180);
          return;
        }
      }
    }, 1000L);
    AppMethodBeat.o(83198);
  }
  
  public void ne(boolean paramBoolean)
  {
    AppMethodBeat.i(83193);
    super.ne(paramBoolean);
    if (isFullScreen())
    {
      this.ugu = this.mParams.getString("game_hv_menu_appid");
      if (!bu.isNullOrNil(this.ugu))
      {
        if (this.ugp == null)
        {
          this.ugp = new GameMenuImageButton(this.mContext);
          this.ugp.a(this.mRootView, new GameMenuImageButton.a()
          {
            public final void dam()
            {
              AppMethodBeat.i(193075);
              g.this.cZZ();
              AppMethodBeat.o(193075);
            }
          });
        }
        this.EgB.setVisibility(8);
        AppMethodBeat.o(83193);
        return;
      }
      this.EgB.setVisibility(0);
    }
    AppMethodBeat.o(83193);
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(83190);
    ae.i("MicroMsg.GameWebPage", "onBackground, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    Object localObject = this.ugi;
    ((GameWebPerformanceInfo)localObject).gvf += System.currentTimeMillis() - this.ugw;
    this.ugw = System.currentTimeMillis();
    this.ugv.EAK.onPause();
    int i = this.chm.Cg().indexOf(this);
    if ((i > 1) && (((com.tencent.luggage.d.h)this.chm.Cg().get(i - 1) instanceof a)))
    {
      AppMethodBeat.o(83190);
      return;
    }
    super.onBackground();
    localObject = this.ugz.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b)((Iterator)localObject).next()).onBackground();
    }
    ai("background", com.tencent.mm.plugin.webview.luggage.j.d(this), null);
    AppMethodBeat.o(83190);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(83191);
    ae.i("MicroMsg.GameWebPage", "onDestroy, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    super.onDestroy();
    c.a(this.ugv.EAK.EAL);
    Object localObject = this.ugi;
    ((GameWebPerformanceInfo)localObject).gvf += System.currentTimeMillis() - this.ugw;
    this.ugi.gvg = System.currentTimeMillis();
    if (!this.mParams.getBoolean("from_bag", false))
    {
      localObject = com.tencent.mm.game.report.api.a.guC;
      if (localObject != null) {
        ((com.tencent.mm.game.report.api.a)localObject).a(this.ugi);
      }
      if (!this.ugC) {
        com.tencent.mm.plugin.webview.ui.tools.game.d.a(dah(), this);
      }
    }
    for (;;)
    {
      try
      {
        if (!this.ugr)
        {
          this.ugr = true;
          localObject = new JSONObject();
          if (this.ugy != 0L) {
            continue;
          }
          ((JSONObject)localObject).put("render_duration", 0);
          com.tencent.mm.game.report.api.a.guC.a(9, URLEncoder.encode(bRn()), URLEncoder.encode(((JSONObject)localObject).toString()), System.currentTimeMillis() - this.ugx.EBt);
        }
      }
      catch (Exception localException)
      {
        continue;
        if (!this.EgF.bLw()) {
          continue;
        }
        r.aIu(this.EgF.EhV);
        ai("destroyed", com.tencent.mm.plugin.webview.luggage.j.d(this), null);
        AppMethodBeat.o(83191);
      }
      GameWebPerformanceInfo.wR(bRn());
      if (!this.ugC) {
        com.tencent.mm.plugin.webview.ui.tools.game.g.aKy(bRn());
      }
      localObject = this.ugz.values();
      if ((localObject == null) || (((Collection)localObject).size() <= 0)) {
        continue;
      }
      localObject = ((Collection)localObject).iterator();
      if (!((Iterator)localObject).hasNext()) {
        continue;
      }
      ((b)((Iterator)localObject).next()).onDestroy();
      continue;
      ((JSONObject)localObject).put("render_duration", this.ugy - this.ugx.EBt);
    }
  }
  
  public void onForeground()
  {
    AppMethodBeat.i(83189);
    ae.i("MicroMsg.GameWebPage", "onForeground, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (this.ugi.guW == 0L) {
      this.ugi.guW = System.currentTimeMillis();
    }
    this.ugw = System.currentTimeMillis();
    this.ugv.EAK.onResume();
    super.onForeground();
    Iterator localIterator = this.ugz.values().iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).onForeground();
    }
    ai("foreground", com.tencent.mm.plugin.webview.luggage.j.d(this), null);
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
    public abstract void cZV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.f.g
 * JD-Core Version:    0.7.0.1
 */