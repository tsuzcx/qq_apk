package com.tencent.mm.plugin.game.luggage.d;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.device.yearclass.YearClass;
import com.tencent.e.i;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.game.d.de;
import com.tencent.mm.plugin.webview.luggage.ipc.ActiveMainProcessTask;
import com.tencent.mm.plugin.webview.luggage.l;
import com.tencent.mm.plugin.webview.luggage.q;
import com.tencent.mm.plugin.webview.ui.tools.game.c.a;
import com.tencent.mm.plugin.webview.ui.tools.game.e.a;
import com.tencent.mm.plugin.webview.ui.tools.game.e.b;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

public class f
  extends com.tencent.mm.plugin.webview.luggage.f
  implements com.tencent.mm.plugin.webview.ui.tools.game.f
{
  protected GameWebPerformanceInfo sYb;
  private View sYg;
  private GameMenuImageButton sYh;
  private boolean sYi;
  private boolean sYj;
  public boolean sYk;
  private String sYl;
  public com.tencent.mm.plugin.webview.ui.tools.game.c sYm;
  private long sYn;
  public com.tencent.mm.plugin.webview.ui.tools.game.h sYo;
  public long sYp;
  private Map<String, b> sYq;
  private ViewGroup sYr;
  private boolean sYs;
  private boolean sYt;
  
  public f(com.tencent.luggage.d.g paramg, k paramk, Bundle paramBundle)
  {
    super(paramg, paramk, paramBundle);
    AppMethodBeat.i(83183);
    this.sYi = false;
    this.sYj = false;
    this.sYk = false;
    this.sYp = 0L;
    this.sYq = new HashMap();
    this.sYt = false;
    this.sYm = new com.tencent.mm.plugin.webview.ui.tools.game.c()
    {
      public final void ad(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(83172);
        com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", paramAnonymousBundle, com.tencent.mm.plugin.game.luggage.e.a.class, null);
        AppMethodBeat.o(83172);
      }
    };
    ac.i("MicroMsg.GameWebPage", "initWebPageEnd, __Time__， time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    paramg = paramBundle.getString("rawUrl");
    this.sYb = GameWebPerformanceInfo.tq(paramg);
    this.sYb.fYI = cOU();
    this.sYb.fZb = System.currentTimeMillis();
    this.sYo = agY(paramg);
    paramk = this.mParams.getString("rawUrl");
    if (!bs.isNullOrNil(paramk))
    {
      paramk = Uri.parse(paramk).getQueryParameter("nav_color");
      if (bs.isNullOrNil(paramk)) {}
    }
    try
    {
      int i = Color.parseColor("#".concat(String.valueOf(paramk)));
      this.mParams.putInt("customize_status_bar_color", i);
      label184:
      paramk = bs.TE(paramg);
      if ((paramk != null) && (paramk.equals("game.weixin.qq.com"))) {
        this.bXF.bXu = com.tencent.luggage.d.a.a.bXK;
      }
      cOT().CZv = new com.tencent.mm.plugin.wepkg.event.b()
      {
        public final void cOX()
        {
          AppMethodBeat.i(195146);
          e locale = (e)f.this.bXF.AN();
          if (!bs.isNullOrNil(locale.sWG)) {
            locale.post(new e.3(locale));
          }
          AppMethodBeat.o(195146);
        }
        
        public final void cOY()
        {
          AppMethodBeat.i(170131);
          f.a(f.this, true);
          f.k(f.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(170129);
              f.j(f.this);
              AppMethodBeat.o(170129);
            }
          }, 500L);
          AppMethodBeat.o(170131);
        }
        
        public final void mH(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(170132);
          ac.i("MicroMsg.GameWebPage", "onPkgReady");
          f.n(f.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(170130);
              if (f.l(f.this))
              {
                f.a(f.this, false);
                if (!((Activity)f.this.mContext).isFinishing())
                {
                  f.m(f.this);
                  f.this.bWW.AF().j(f.this.bLL(), f.this.mParams);
                }
              }
              AppMethodBeat.o(170130);
            }
          });
          AppMethodBeat.o(170132);
        }
      };
      ((e)this.bXF.AN()).setRawUrl(paramg);
      AppMethodBeat.o(83183);
      return;
    }
    catch (IllegalArgumentException paramk)
    {
      break label184;
    }
  }
  
  public View Ar()
  {
    AppMethodBeat.i(83184);
    View localView = super.Ar();
    this.sYg = LayoutInflater.from(this.mContext).inflate(2131494340, this.Clr, false);
    this.sYg.setVisibility(8);
    this.Clr.addView(this.sYg, new FrameLayout.LayoutParams(-2, -2, 17));
    ac.i("MicroMsg.GameWebPage", "create vie end, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    AppMethodBeat.o(83184);
    return localView;
  }
  
  public void B(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(180146);
    long l = System.currentTimeMillis();
    ac.i("MicroMsg.GameWebPage", "onReceivedError, errorCode: %d, description: %s, failingUrl: %s , time: %d", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, Long.valueOf(l) });
    super.B(paramInt, paramString1, paramString2);
    try
    {
      paramString1 = new JSONObject();
      paramString1.put("errcode", paramInt);
      paramString1.put("errurl", paramString2);
      com.tencent.mm.game.report.api.a.fYF.a(8, URLEncoder.encode(bLL()), URLEncoder.encode(paramString1.toString()), l - this.sYo.CFE);
      AppMethodBeat.o(180146);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(180146);
    }
  }
  
  public final boolean Gi(int paramInt)
  {
    AppMethodBeat.i(83207);
    if (this.bXF.AL() == com.tencent.luggage.d.a.a.bXK)
    {
      AppMethodBeat.o(83207);
      return true;
    }
    if (this.bXF.AL() == com.tencent.luggage.d.a.a.bXL)
    {
      AppMethodBeat.o(83207);
      return false;
    }
    boolean bool = super.Gi(paramInt);
    AppMethodBeat.o(83207);
    return bool;
  }
  
  protected com.tencent.mm.plugin.webview.ui.tools.game.h agY(String paramString)
  {
    AppMethodBeat.i(83186);
    paramString = com.tencent.mm.plugin.webview.ui.tools.game.h.aDC(paramString);
    AppMethodBeat.o(83186);
    return paramString;
  }
  
  public boolean agZ(String paramString)
  {
    AppMethodBeat.i(83187);
    if ((paramString.equals(bLL())) && (this.sYb.fZg == 0L))
    {
      this.sYb.fZg = System.currentTimeMillis();
      ac.i("MicroMsg.GameWebPage", "startGetA8Key, url: %s, time: %d", new Object[] { paramString, Long.valueOf(this.sYb.fZg) });
    }
    boolean bool = super.agZ(paramString);
    AppMethodBeat.o(83187);
    return bool;
  }
  
  public final boolean aha(String paramString)
  {
    AppMethodBeat.i(83195);
    e locale = (e)this.Clh;
    ac.d("MicroMsg.GameWebCoreImpl", "isWebCacheUrl, hasLoadWePkg: %b", new Object[] { Boolean.valueOf(locale.sXT) });
    if (!locale.sXT)
    {
      locale.sXS.cq(paramString, true);
      locale.sXT = true;
    }
    boolean bool = locale.sXS.aEU(paramString);
    AppMethodBeat.o(83195);
    return bool;
  }
  
  public final void ahb(String paramString)
  {
    AppMethodBeat.i(83199);
    super.ahb(paramString);
    if (this.sYb.fZd == 0L) {
      this.sYb.fZd = System.currentTimeMillis();
    }
    AppMethodBeat.o(83199);
  }
  
  public final void ahc(String paramString)
  {
    AppMethodBeat.i(83202);
    super.ahc(paramString);
    if (this.sYo.CFI == 0L) {
      this.sYo.CFI = System.currentTimeMillis();
    }
    AppMethodBeat.o(83202);
  }
  
  public final void bK(String paramString)
  {
    AppMethodBeat.i(83200);
    long l = System.currentTimeMillis();
    ac.i("MicroMsg.GameWebPage", "onUrlLoadingStarted, url = %s, __Time__, time = %d", new Object[] { paramString, Long.valueOf(l) });
    super.bK(paramString);
    if (this.sYb.fZe == 0L) {
      this.sYb.fZe = l;
    }
    if (this.sYo.CFG == 0L) {
      this.sYo.CFG = l;
    }
    paramString = bs.TE(paramString);
    if ((paramString != null) && (paramString.equals("game.weixin.qq.com"))) {}
    for (this.bXF.bXu = com.tencent.luggage.d.a.a.bXK;; this.bXF.bXu = this.ClB)
    {
      this.sYm.CEW.eFr();
      AppMethodBeat.o(83200);
      return;
    }
  }
  
  public void bL(String paramString)
  {
    AppMethodBeat.i(83201);
    long l = System.currentTimeMillis();
    ac.i("MicroMsg.GameWebPage", "onUrlLoadingFinished, url = %s, __Time__, time = %d", new Object[] { paramString, Long.valueOf(l) });
    super.bL(paramString);
    if (this.sYb.fZf == 0L) {
      this.sYb.fZf = l;
    }
    if (this.sYo.CFH == 0L) {
      this.sYo.CFH = l;
    }
    try
    {
      if (!this.sYi)
      {
        this.sYi = true;
        com.tencent.mm.game.report.api.a.fYF.a(7, URLEncoder.encode(bLL()), "", l - this.sYo.CFE);
      }
      label117:
      com.tencent.mm.plugin.game.luggage.e.a(this.bXF, this.sWG);
      this.sYm.CEW.Bb();
      AppMethodBeat.o(83201);
      return;
    }
    catch (Exception paramString)
    {
      break label117;
    }
  }
  
  public void cOK()
  {
    AppMethodBeat.i(83196);
    av(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83175);
        f.c(f.this).setVisibility(0);
        AppMethodBeat.o(83175);
      }
    });
    AppMethodBeat.o(83196);
  }
  
  public final void cOM()
  {
    AppMethodBeat.i(83188);
    this.Clk.cOM();
    AppMethodBeat.o(83188);
  }
  
  public final View cOQ()
  {
    AppMethodBeat.i(83185);
    this.Clk = new d(this);
    l locall = this.Clk;
    AppMethodBeat.o(83185);
    return locall;
  }
  
  public final void cOR()
  {
    AppMethodBeat.i(83194);
    de localde;
    if (!this.ClE)
    {
      this.ClF = this.mParams.getInt("customize_status_bar_color");
      if (this.ClF == 0)
      {
        localde = com.tencent.mm.plugin.game.commlib.a.cOv();
        if ((localde == null) || (bs.isNullOrNil(localde.hiu)) || (bs.isNullOrNil(localde.tlG))) {}
      }
    }
    try
    {
      if (aj.DT()) {}
      for (this.ClF = Color.parseColor(localde.tlG);; this.ClF = Color.parseColor(localde.hiu))
      {
        if (this.ClF == 0) {
          this.ClF = android.support.v4.content.b.n(this.mContext, 2131099873);
        }
        eAm();
        AppMethodBeat.o(83194);
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        ac.e("MicroMsg.GameWebPage", "parse color: " + localIllegalArgumentException.getMessage());
      }
    }
  }
  
  public final void cOS()
  {
    AppMethodBeat.i(83197);
    this.sYg.setVisibility(8);
    AppMethodBeat.o(83197);
  }
  
  public final com.tencent.mm.plugin.wepkg.c cOT()
  {
    AppMethodBeat.i(83205);
    com.tencent.mm.plugin.wepkg.c localc = ((e)this.Clh).getWePkgPlugin();
    AppMethodBeat.o(83205);
    return localc;
  }
  
  public final String cOU()
  {
    AppMethodBeat.i(83206);
    String str = (hashCode() & 0x7FFFFFFF) + "_" + (bLL().hashCode() & 0x7FFFFFFF);
    AppMethodBeat.o(83206);
    return str;
  }
  
  public final Map<Integer, Object> cOV()
  {
    AppMethodBeat.i(195152);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(e.a.CFc), cOU());
    localHashMap.put(Integer.valueOf(e.a.CFd), ax.iH(ai.getContext()));
    localHashMap.put(Integer.valueOf(e.a.CFe), String.valueOf(YearClass.get(ai.getContext())));
    String str = bLL();
    try
    {
      localHashMap.put(Integer.valueOf(e.a.CFf), com.tencent.mm.compatible.util.p.encode(bs.nullAsNil(str), "UTF-8"));
      label94:
      int j = e.a.CFg;
      int i;
      if (aha(str))
      {
        i = 1;
        localHashMap.put(Integer.valueOf(j), Integer.valueOf(i));
        localHashMap.put(Integer.valueOf(e.a.CFh), Integer.valueOf(1));
        if (!(this instanceof g)) {
          break label211;
        }
        localHashMap.put(Integer.valueOf(e.a.CFi), Integer.valueOf(1));
      }
      for (;;)
      {
        localHashMap.put(Integer.valueOf(e.a.CFj), cOT().eIM());
        i = e.a.CFk;
        cOT();
        localHashMap.put(Integer.valueOf(i), com.tencent.mm.plugin.wepkg.c.eIN());
        AppMethodBeat.o(195152);
        return localHashMap;
        i = 0;
        break;
        label211:
        localHashMap.put(Integer.valueOf(e.a.CFi), Integer.valueOf(0));
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label94;
    }
  }
  
  public final Map<Integer, Object> cOW()
  {
    AppMethodBeat.i(195153);
    HashMap localHashMap = new HashMap();
    com.tencent.mm.plugin.webview.ui.tools.game.h localh = com.tencent.mm.plugin.webview.ui.tools.game.h.aDD(bLL());
    if (localh != null)
    {
      localHashMap.put(Integer.valueOf(e.b.CFn), Long.valueOf(localh.CFF - localh.startTime));
      localHashMap.put(Integer.valueOf(e.b.CFo), Long.valueOf(localh.CFG - localh.startTime));
      localHashMap.put(Integer.valueOf(e.b.CFp), Long.valueOf(localh.CFH - localh.CFG));
      localHashMap.put(Integer.valueOf(e.b.CFq), Long.valueOf(localh.CFJ - localh.CFI));
      localHashMap.put(Integer.valueOf(e.b.CFr), Long.valueOf(localh.CFL - localh.CFK));
      localHashMap.put(Integer.valueOf(e.b.CFz), Long.valueOf(localh.CFM));
      localHashMap.put(Integer.valueOf(e.b.CFB), Long.valueOf(localh.CFN));
      localHashMap.put(Integer.valueOf(e.b.CFs), Long.valueOf(localh.CFO));
      localHashMap.put(Integer.valueOf(e.b.CFt), Long.valueOf(localh.CFP));
      localHashMap.put(Integer.valueOf(e.b.CFu), Long.valueOf(localh.lXu));
      localHashMap.put(Integer.valueOf(e.b.CFv), Long.valueOf(localh.CFQ));
      localHashMap.put(Integer.valueOf(e.b.CFw), Long.valueOf(localh.CFR));
      localHashMap.put(Integer.valueOf(e.b.CFx), Long.valueOf(localh.CFS));
      localHashMap.put(Integer.valueOf(e.b.CFy), Long.valueOf(localh.CFT));
      localHashMap.put(Integer.valueOf(e.b.CFC), Long.valueOf(System.currentTimeMillis()));
    }
    int j = e.b.CFA;
    if (bs.isNullOrNil(cOT().eIK())) {}
    for (int i = 0;; i = 1)
    {
      localHashMap.put(Integer.valueOf(j), Integer.valueOf(i));
      AppMethodBeat.o(195153);
      return localHashMap;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(195151);
    String str = com.tencent.mm.plugin.appbrand.z.d.Rn("game_performance.js");
    final long l = System.currentTimeMillis();
    this.Clh.evaluateJavascript(str, new ValueCallback() {});
    AppMethodBeat.o(195151);
  }
  
  public void e(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(83203);
    super.e(paramString1, paramString2, paramMap);
    e locale = (e)this.bXF.AN();
    locale.sWG = paramString2;
    locale.sXU = paramMap;
    if (bs.isNullOrNil(paramString2)) {
      ac.i("MicroMsg.LuggageGameUinKeyHolder", "setFullUrlAndHeaders, fullUrl is null");
    }
    for (;;)
    {
      long l = System.currentTimeMillis();
      if (paramString1.equals(bLL()))
      {
        ac.i("MicroMsg.GameWebPage", "getA8Key end, __Time__, time: %d", new Object[] { Long.valueOf(l) });
        this.sYb.fZh = l;
      }
      if (this.sYb.fZd == 0L) {
        this.sYb.fZd = l;
      }
      if (this.sYo.CFJ == 0L) {
        this.sYo.CFJ = System.currentTimeMillis();
      }
      com.tencent.mm.plugin.game.luggage.e.a(getWebView(), paramString2, paramMap);
      com.tencent.mm.plugin.game.luggage.e.a(this.bXF, paramString2);
      this.sYk = true;
      AppMethodBeat.o(83203);
      return;
      if (!Uri.parse(paramString2).getHost().equals("game.weixin.qq.com"))
      {
        ac.i("MicroMsg.LuggageGameUinKeyHolder", "setFullUrlAndHeaders, host is not wxgame");
      }
      else
      {
        com.tencent.mm.plugin.game.luggage.d.sWG = paramString2;
        com.tencent.mm.plugin.game.luggage.d.mHeaders = paramMap;
        com.tencent.mm.plugin.game.luggage.d.Lf = System.currentTimeMillis() / 1000L;
      }
    }
  }
  
  public void g(final String paramString, final Bundle paramBundle)
  {
    AppMethodBeat.i(83198);
    ac.i("MicroMsg.GameWebPage", "load url, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (this.sYo.CFF == 0L) {
      this.sYo.CFF = System.currentTimeMillis();
    }
    paramBundle = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83176);
        f.a(f.this, paramString, paramBundle);
        AppMethodBeat.o(83176);
      }
    };
    if (AppBrandMainProcessService.bed())
    {
      ac.i("MicroMsg.GameWebPage", "activeIpcTask, service is alive");
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
        ac.i("MicroMsg.GameWebPage", "activeIpcTask, callback");
        localPBool.bek();
        synchronized (paramBundle)
        {
          if (paramBundle.value)
          {
            AppMethodBeat.o(83178);
            return;
          }
          paramBundle.value = true;
          paramString.run();
          com.tencent.mm.plugin.wepkg.utils.a.b("ipcServiceStartTime", this.val$url, com.tencent.mm.plugin.wepkg.utils.d.aFy(this.val$url), null, 0L, l1 - l2, null);
          AppMethodBeat.o(83178);
          return;
        }
      }
    };
    localActiveMainProcessTask.bej();
    AppBrandMainProcessService.a(localActiveMainProcessTask);
    com.tencent.e.h.JZN.q(new Runnable()
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
          ac.i("MicroMsg.GameWebPage", "activeIpcTask, time out, callback");
          localPBool.value = true;
          f.a(f.this, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(195150);
              f.8.this.val$callback.run();
              AppMethodBeat.o(195150);
            }
          });
          AppMethodBeat.o(83180);
          return;
        }
      }
    }, 1000L);
    AppMethodBeat.o(83198);
  }
  
  public void mG(boolean paramBoolean)
  {
    AppMethodBeat.i(83193);
    super.mG(paramBoolean);
    if (isFullScreen())
    {
      this.sYl = this.mParams.getString("game_hv_menu_appid");
      if (!bs.isNullOrNil(this.sYl))
      {
        if (this.sYh == null)
        {
          this.sYh = new GameMenuImageButton(this.mContext);
          this.sYh.a(this.mRootView, new GameMenuImageButton.a()
          {
            public final void cOZ()
            {
              AppMethodBeat.i(195149);
              f.this.cOM();
              AppMethodBeat.o(195149);
            }
          });
        }
        this.Clq.setVisibility(8);
        AppMethodBeat.o(83193);
        return;
      }
      this.Clq.setVisibility(0);
    }
    AppMethodBeat.o(83193);
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(83190);
    ac.i("MicroMsg.GameWebPage", "onBackground, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    Object localObject = this.sYb;
    ((GameWebPerformanceInfo)localObject).fZi += System.currentTimeMillis() - this.sYn;
    this.sYn = System.currentTimeMillis();
    this.sYm.CEW.onPause();
    int i = this.bWW.AE().indexOf(this);
    if ((i > 1) && (((com.tencent.luggage.d.e)this.bWW.AE().get(i - 1) instanceof a)))
    {
      AppMethodBeat.o(83190);
      return;
    }
    super.onBackground();
    localObject = this.sYq.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b)((Iterator)localObject).next()).onBackground();
    }
    AppMethodBeat.o(83190);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(83191);
    ac.i("MicroMsg.GameWebPage", "onDestroy, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    super.onDestroy();
    com.tencent.mm.plugin.webview.ui.tools.game.c.a(this.sYm.CEW.CEX);
    Object localObject = this.sYb;
    ((GameWebPerformanceInfo)localObject).fZi += System.currentTimeMillis() - this.sYn;
    this.sYb.fZj = System.currentTimeMillis();
    if (!this.mParams.getBoolean("from_bag", false))
    {
      localObject = com.tencent.mm.game.report.api.a.fYF;
      if (localObject != null) {
        ((com.tencent.mm.game.report.api.a)localObject).a(this.sYb);
      }
      if (!this.sYt) {
        com.tencent.mm.plugin.webview.ui.tools.game.e.a(cOU(), this);
      }
    }
    for (;;)
    {
      try
      {
        if (!this.sYj)
        {
          this.sYj = true;
          localObject = new JSONObject();
          if (this.sYp != 0L) {
            continue;
          }
          ((JSONObject)localObject).put("render_duration", 0);
          com.tencent.mm.game.report.api.a.fYF.a(9, URLEncoder.encode(bLL()), URLEncoder.encode(((JSONObject)localObject).toString()), System.currentTimeMillis() - this.sYo.CFE);
        }
      }
      catch (Exception localException)
      {
        continue;
        if (!this.Clu.bGo()) {
          continue;
        }
        q.aBC(this.Clu.CmA);
        AppMethodBeat.o(83191);
      }
      GameWebPerformanceInfo.ts(bLL());
      if (!this.sYt) {
        com.tencent.mm.plugin.webview.ui.tools.game.h.aDE(bLL());
      }
      localObject = this.sYq.values();
      if ((localObject == null) || (((Collection)localObject).size() <= 0)) {
        continue;
      }
      localObject = ((Collection)localObject).iterator();
      if (!((Iterator)localObject).hasNext()) {
        continue;
      }
      ((b)((Iterator)localObject).next()).onDestroy();
      continue;
      ((JSONObject)localObject).put("render_duration", this.sYp - this.sYo.CFE);
    }
  }
  
  public void onForeground()
  {
    AppMethodBeat.i(83189);
    ac.i("MicroMsg.GameWebPage", "onForeground, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (this.sYb.fYZ == 0L) {
      this.sYb.fYZ = System.currentTimeMillis();
    }
    this.sYn = System.currentTimeMillis();
    this.sYm.CEW.onResume();
    super.onForeground();
    Iterator localIterator = this.sYq.values().iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).onForeground();
    }
    AppMethodBeat.o(83189);
  }
  
  public final void reload()
  {
    AppMethodBeat.i(83192);
    super.reload();
    AppMethodBeat.o(83192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.f
 * JD-Core Version:    0.7.0.1
 */