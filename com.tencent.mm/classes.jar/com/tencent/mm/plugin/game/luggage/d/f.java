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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;
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
  private ViewGroup rQA;
  private boolean rQB;
  private boolean rQC;
  protected GameWebPerformanceInfo rQk;
  private View rQp;
  private GameMenuImageButton rQq;
  private boolean rQr;
  private boolean rQs;
  public boolean rQt;
  private String rQu;
  public com.tencent.mm.plugin.webview.ui.tools.game.c rQv;
  private long rQw;
  public com.tencent.mm.plugin.webview.ui.tools.game.h rQx;
  public long rQy;
  private Map<String, b> rQz;
  
  public f(com.tencent.luggage.d.g paramg, k paramk, Bundle paramBundle)
  {
    super(paramg, paramk, paramBundle);
    AppMethodBeat.i(83183);
    this.rQr = false;
    this.rQs = false;
    this.rQt = false;
    this.rQy = 0L;
    this.rQz = new HashMap();
    this.rQC = false;
    this.rQv = new com.tencent.mm.plugin.webview.ui.tools.game.c()
    {
      public final void aa(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(83172);
        com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", paramAnonymousBundle, com.tencent.mm.plugin.game.luggage.e.a.class, null);
        AppMethodBeat.o(83172);
      }
    };
    ad.i("MicroMsg.GameWebPage", "initWebPageEnd, __Time__， time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    paramg = paramBundle.getString("rawUrl");
    this.rQk = GameWebPerformanceInfo.qd(paramg);
    this.rQk.fUN = cBJ();
    this.rQk.fVg = System.currentTimeMillis();
    this.rQx = acg(paramg);
    paramk = this.mParams.getString("rawUrl");
    if (!bt.isNullOrNil(paramk))
    {
      paramk = Uri.parse(paramk).getQueryParameter("nav_color");
      if (bt.isNullOrNil(paramk)) {}
    }
    try
    {
      int i = Color.parseColor("#".concat(String.valueOf(paramk)));
      this.mParams.putInt("customize_status_bar_color", i);
      label184:
      paramk = bt.Pt(paramg);
      if ((paramk != null) && (paramk.equals("game.weixin.qq.com"))) {
        this.caI.cax = com.tencent.luggage.d.a.a.caN;
      }
      cBI().BHn = new com.tencent.mm.plugin.wepkg.event.b()
      {
        public final void cBM()
        {
          AppMethodBeat.i(190164);
          e locale = (e)f.this.caI.Bj();
          if (!bt.isNullOrNil(locale.rOQ)) {
            locale.post(new e.3(locale));
          }
          AppMethodBeat.o(190164);
        }
        
        public final void cBN()
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
        
        public final void lO(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(170132);
          ad.i("MicroMsg.GameWebPage", "onPkgReady");
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
                  f.this.bZZ.Bb().j(f.this.bEx(), f.this.mParams);
                }
              }
              AppMethodBeat.o(170130);
            }
          });
          AppMethodBeat.o(170132);
        }
      };
      ((e)this.caI.Bj()).setRawUrl(paramg);
      AppMethodBeat.o(83183);
      return;
    }
    catch (IllegalArgumentException paramk)
    {
      break label184;
    }
  }
  
  public View AN()
  {
    AppMethodBeat.i(83184);
    View localView = super.AN();
    this.rQp = LayoutInflater.from(this.mContext).inflate(2131494340, this.ATe, false);
    this.rQp.setVisibility(8);
    this.ATe.addView(this.rQp, new FrameLayout.LayoutParams(-2, -2, 17));
    ad.i("MicroMsg.GameWebPage", "create vie end, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    AppMethodBeat.o(83184);
    return localView;
  }
  
  public void B(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(180146);
    long l = System.currentTimeMillis();
    ad.i("MicroMsg.GameWebPage", "onReceivedError, errorCode: %d, description: %s, failingUrl: %s , time: %d", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, Long.valueOf(l) });
    super.B(paramInt, paramString1, paramString2);
    try
    {
      paramString1 = new JSONObject();
      paramString1.put("errcode", paramInt);
      paramString1.put("errurl", paramString2);
      com.tencent.mm.game.report.api.a.fUK.a(8, URLEncoder.encode(bEx()), URLEncoder.encode(paramString1.toString()), l - this.rQx.Bnx);
      AppMethodBeat.o(180146);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(180146);
    }
  }
  
  public final boolean Em(int paramInt)
  {
    AppMethodBeat.i(83207);
    if (this.caI.Bh() == com.tencent.luggage.d.a.a.caN)
    {
      AppMethodBeat.o(83207);
      return true;
    }
    if (this.caI.Bh() == com.tencent.luggage.d.a.a.caO)
    {
      AppMethodBeat.o(83207);
      return false;
    }
    boolean bool = super.Em(paramInt);
    AppMethodBeat.o(83207);
    return bool;
  }
  
  protected com.tencent.mm.plugin.webview.ui.tools.game.h acg(String paramString)
  {
    AppMethodBeat.i(83186);
    paramString = com.tencent.mm.plugin.webview.ui.tools.game.h.ayl(paramString);
    AppMethodBeat.o(83186);
    return paramString;
  }
  
  public boolean ach(String paramString)
  {
    AppMethodBeat.i(83187);
    if ((paramString.equals(bEx())) && (this.rQk.fVl == 0L))
    {
      this.rQk.fVl = System.currentTimeMillis();
      ad.i("MicroMsg.GameWebPage", "startGetA8Key, url: %s, time: %d", new Object[] { paramString, Long.valueOf(this.rQk.fVl) });
    }
    boolean bool = super.ach(paramString);
    AppMethodBeat.o(83187);
    return bool;
  }
  
  public final boolean aci(String paramString)
  {
    AppMethodBeat.i(83195);
    e locale = (e)this.ASU;
    ad.d("MicroMsg.GameWebCoreImpl", "isWebCacheUrl, hasLoadWePkg: %b", new Object[] { Boolean.valueOf(locale.rQc) });
    if (!locale.rQc)
    {
      locale.rQb.ck(paramString, true);
      locale.rQc = true;
    }
    boolean bool = locale.rQb.azD(paramString);
    AppMethodBeat.o(83195);
    return bool;
  }
  
  public final void acj(String paramString)
  {
    AppMethodBeat.i(83199);
    super.acj(paramString);
    if (this.rQk.fVi == 0L) {
      this.rQk.fVi = System.currentTimeMillis();
    }
    AppMethodBeat.o(83199);
  }
  
  public final void ack(String paramString)
  {
    AppMethodBeat.i(83202);
    super.ack(paramString);
    if (this.rQx.BnB == 0L) {
      this.rQx.BnB = System.currentTimeMillis();
    }
    AppMethodBeat.o(83202);
  }
  
  public final void bU(String paramString)
  {
    AppMethodBeat.i(83200);
    long l = System.currentTimeMillis();
    ad.i("MicroMsg.GameWebPage", "onUrlLoadingStarted, url = %s, __Time__, time = %d", new Object[] { paramString, Long.valueOf(l) });
    super.bU(paramString);
    if (this.rQk.fVj == 0L) {
      this.rQk.fVj = l;
    }
    if (this.rQx.Bnz == 0L) {
      this.rQx.Bnz = l;
    }
    paramString = bt.Pt(paramString);
    if ((paramString != null) && (paramString.equals("game.weixin.qq.com"))) {}
    for (this.caI.cax = com.tencent.luggage.d.a.a.caN;; this.caI.cax = this.ATo)
    {
      this.rQv.BmP.epX();
      AppMethodBeat.o(83200);
      return;
    }
  }
  
  public void bV(String paramString)
  {
    AppMethodBeat.i(83201);
    long l = System.currentTimeMillis();
    ad.i("MicroMsg.GameWebPage", "onUrlLoadingFinished, url = %s, __Time__, time = %d", new Object[] { paramString, Long.valueOf(l) });
    super.bV(paramString);
    if (this.rQk.fVk == 0L) {
      this.rQk.fVk = l;
    }
    if (this.rQx.BnA == 0L) {
      this.rQx.BnA = l;
    }
    try
    {
      if (!this.rQr)
      {
        this.rQr = true;
        com.tencent.mm.game.report.api.a.fUK.a(7, URLEncoder.encode(bEx()), "", l - this.rQx.Bnx);
      }
      label117:
      com.tencent.mm.plugin.game.luggage.e.a(this.caI, this.rOQ);
      this.rQv.BmP.Bx();
      AppMethodBeat.o(83201);
      return;
    }
    catch (Exception paramString)
    {
      break label117;
    }
  }
  
  public void c(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(83203);
    super.c(paramString1, paramString2, paramMap);
    e locale = (e)this.caI.Bj();
    locale.rOQ = paramString2;
    locale.rQd = paramMap;
    if (bt.isNullOrNil(paramString2)) {
      ad.i("MicroMsg.LuggageGameUinKeyHolder", "setFullUrlAndHeaders, fullUrl is null");
    }
    for (;;)
    {
      long l = System.currentTimeMillis();
      if (paramString1.equals(bEx()))
      {
        ad.i("MicroMsg.GameWebPage", "getA8Key end, __Time__, time: %d", new Object[] { Long.valueOf(l) });
        this.rQk.fVm = l;
      }
      if (this.rQk.fVi == 0L) {
        this.rQk.fVi = l;
      }
      if (this.rQx.BnC == 0L) {
        this.rQx.BnC = System.currentTimeMillis();
      }
      com.tencent.mm.plugin.game.luggage.e.a(getWebView(), paramString2, paramMap);
      com.tencent.mm.plugin.game.luggage.e.a(this.caI, paramString2);
      this.rQt = true;
      AppMethodBeat.o(83203);
      return;
      if (!Uri.parse(paramString2).getHost().equals("game.weixin.qq.com"))
      {
        ad.i("MicroMsg.LuggageGameUinKeyHolder", "setFullUrlAndHeaders, host is not wxgame");
      }
      else
      {
        com.tencent.mm.plugin.game.luggage.d.rOQ = paramString2;
        com.tencent.mm.plugin.game.luggage.d.mHeaders = paramMap;
        com.tencent.mm.plugin.game.luggage.d.Kk = System.currentTimeMillis() / 1000L;
      }
    }
  }
  
  public final void cBB()
  {
    AppMethodBeat.i(83188);
    this.ASX.cBB();
    AppMethodBeat.o(83188);
  }
  
  public final View cBF()
  {
    AppMethodBeat.i(83185);
    this.ASX = new d(this);
    l locall = this.ASX;
    AppMethodBeat.o(83185);
    return locall;
  }
  
  public final void cBG()
  {
    AppMethodBeat.i(83194);
    de localde;
    if (!this.ATr)
    {
      this.ATs = this.mParams.getInt("customize_status_bar_color");
      if (this.ATs == 0)
      {
        localde = com.tencent.mm.plugin.game.commlib.a.cBm();
        if ((localde == null) || (bt.isNullOrNil(localde.gHT)) || (bt.isNullOrNil(localde.sdM))) {}
      }
    }
    try
    {
      if (ai.Eq()) {}
      for (this.ATs = Color.parseColor(localde.sdM);; this.ATs = Color.parseColor(localde.gHT))
      {
        if (this.ATs == 0) {
          this.ATs = android.support.v4.content.b.n(this.mContext, 2131099873);
        }
        ekQ();
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
  
  public final void cBH()
  {
    AppMethodBeat.i(83197);
    this.rQp.setVisibility(8);
    AppMethodBeat.o(83197);
  }
  
  public final com.tencent.mm.plugin.wepkg.c cBI()
  {
    AppMethodBeat.i(83205);
    com.tencent.mm.plugin.wepkg.c localc = ((e)this.ASU).getWePkgPlugin();
    AppMethodBeat.o(83205);
    return localc;
  }
  
  public final String cBJ()
  {
    AppMethodBeat.i(83206);
    String str = (hashCode() & 0x7FFFFFFF) + "_" + (bEx().hashCode() & 0x7FFFFFFF);
    AppMethodBeat.o(83206);
    return str;
  }
  
  public final Map<Integer, Object> cBK()
  {
    AppMethodBeat.i(190170);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(e.a.BmV), cBJ());
    localHashMap.put(Integer.valueOf(e.a.BmW), ay.iw(aj.getContext()));
    localHashMap.put(Integer.valueOf(e.a.BmX), String.valueOf(YearClass.get(aj.getContext())));
    String str = bEx();
    try
    {
      localHashMap.put(Integer.valueOf(e.a.BmY), com.tencent.mm.compatible.util.p.encode(bt.nullAsNil(str), "UTF-8"));
      label94:
      int j = e.a.BmZ;
      int i;
      if (aci(str))
      {
        i = 1;
        localHashMap.put(Integer.valueOf(j), Integer.valueOf(i));
        localHashMap.put(Integer.valueOf(e.a.Bna), Integer.valueOf(1));
        if (!(this instanceof g)) {
          break label211;
        }
        localHashMap.put(Integer.valueOf(e.a.Bnb), Integer.valueOf(1));
      }
      for (;;)
      {
        localHashMap.put(Integer.valueOf(e.a.Bnc), cBI().ett());
        i = e.a.Bnd;
        cBI();
        localHashMap.put(Integer.valueOf(i), com.tencent.mm.plugin.wepkg.c.etu());
        AppMethodBeat.o(190170);
        return localHashMap;
        i = 0;
        break;
        label211:
        localHashMap.put(Integer.valueOf(e.a.Bnb), Integer.valueOf(0));
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label94;
    }
  }
  
  public final Map<Integer, Object> cBL()
  {
    AppMethodBeat.i(190171);
    HashMap localHashMap = new HashMap();
    com.tencent.mm.plugin.webview.ui.tools.game.h localh = com.tencent.mm.plugin.webview.ui.tools.game.h.aym(bEx());
    if (localh != null)
    {
      localHashMap.put(Integer.valueOf(e.b.Bng), Long.valueOf(localh.Bny - localh.startTime));
      localHashMap.put(Integer.valueOf(e.b.Bnh), Long.valueOf(localh.Bnz - localh.startTime));
      localHashMap.put(Integer.valueOf(e.b.Bni), Long.valueOf(localh.BnA - localh.Bnz));
      localHashMap.put(Integer.valueOf(e.b.Bnj), Long.valueOf(localh.BnC - localh.BnB));
      localHashMap.put(Integer.valueOf(e.b.Bnk), Long.valueOf(localh.BnE - localh.BnD));
      localHashMap.put(Integer.valueOf(e.b.Bns), Long.valueOf(localh.BnF));
      localHashMap.put(Integer.valueOf(e.b.Bnu), Long.valueOf(localh.BnG));
      localHashMap.put(Integer.valueOf(e.b.Bnl), Long.valueOf(localh.BnH));
      localHashMap.put(Integer.valueOf(e.b.Bnm), Long.valueOf(localh.BnI));
      localHashMap.put(Integer.valueOf(e.b.Bnn), Long.valueOf(localh.lvA));
      localHashMap.put(Integer.valueOf(e.b.Bno), Long.valueOf(localh.BnJ));
      localHashMap.put(Integer.valueOf(e.b.Bnp), Long.valueOf(localh.BnK));
      localHashMap.put(Integer.valueOf(e.b.Bnq), Long.valueOf(localh.BnL));
      localHashMap.put(Integer.valueOf(e.b.Bnr), Long.valueOf(localh.BnM));
      localHashMap.put(Integer.valueOf(e.b.Bnv), Long.valueOf(System.currentTimeMillis()));
    }
    int j = e.b.Bnt;
    if (bt.isNullOrNil(cBI().etr())) {}
    for (int i = 0;; i = 1)
    {
      localHashMap.put(Integer.valueOf(j), Integer.valueOf(i));
      AppMethodBeat.o(190171);
      return localHashMap;
    }
  }
  
  public void cBz()
  {
    AppMethodBeat.i(83196);
    at(new Runnable()
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
  
  public final void destroy()
  {
    AppMethodBeat.i(190169);
    String str = com.tencent.mm.plugin.appbrand.aa.d.Ne("game_performance.js");
    final long l = System.currentTimeMillis();
    this.ASU.evaluateJavascript(str, new ValueCallback() {});
    AppMethodBeat.o(190169);
  }
  
  public void g(final String paramString, final Bundle paramBundle)
  {
    AppMethodBeat.i(83198);
    ad.i("MicroMsg.GameWebPage", "load url, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (this.rQx.Bny == 0L) {
      this.rQx.Bny = System.currentTimeMillis();
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
    if (AppBrandMainProcessService.aXf())
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
        localPBool.aXn();
        synchronized (paramBundle)
        {
          if (paramBundle.value)
          {
            AppMethodBeat.o(83178);
            return;
          }
          paramBundle.value = true;
          paramString.run();
          com.tencent.mm.plugin.wepkg.utils.a.b("ipcServiceStartTime", this.val$url, com.tencent.mm.plugin.wepkg.utils.d.aAg(this.val$url), null, 0L, l1 - l2, null);
          AppMethodBeat.o(83178);
          return;
        }
      }
    };
    localActiveMainProcessTask.aXm();
    AppBrandMainProcessService.a(localActiveMainProcessTask);
    com.tencent.e.h.Iye.q(new Runnable()
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
          f.a(f.this, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(190168);
              f.8.this.val$callback.run();
              AppMethodBeat.o(190168);
            }
          });
          AppMethodBeat.o(83180);
          return;
        }
      }
    }, 1000L);
    AppMethodBeat.o(83198);
  }
  
  public void lN(boolean paramBoolean)
  {
    AppMethodBeat.i(83193);
    super.lN(paramBoolean);
    if (isFullScreen())
    {
      this.rQu = this.mParams.getString("game_hv_menu_appid");
      if (!bt.isNullOrNil(this.rQu))
      {
        if (this.rQq == null)
        {
          this.rQq = new GameMenuImageButton(this.mContext);
          this.rQq.a(this.mRootView, new GameMenuImageButton.a()
          {
            public final void cBO()
            {
              AppMethodBeat.i(190167);
              f.this.cBB();
              AppMethodBeat.o(190167);
            }
          });
        }
        this.ATd.setVisibility(8);
        AppMethodBeat.o(83193);
        return;
      }
      this.ATd.setVisibility(0);
    }
    AppMethodBeat.o(83193);
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(83190);
    ad.i("MicroMsg.GameWebPage", "onBackground, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    Object localObject = this.rQk;
    ((GameWebPerformanceInfo)localObject).fVn += System.currentTimeMillis() - this.rQw;
    this.rQw = System.currentTimeMillis();
    this.rQv.BmP.onPause();
    int i = this.bZZ.Ba().indexOf(this);
    if ((i > 1) && (((com.tencent.luggage.d.e)this.bZZ.Ba().get(i - 1) instanceof a)))
    {
      AppMethodBeat.o(83190);
      return;
    }
    super.onBackground();
    localObject = this.rQz.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b)((Iterator)localObject).next()).onBackground();
    }
    AppMethodBeat.o(83190);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(83191);
    ad.i("MicroMsg.GameWebPage", "onDestroy, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    super.onDestroy();
    com.tencent.mm.plugin.webview.ui.tools.game.c.a(this.rQv.BmP.BmQ);
    Object localObject = this.rQk;
    ((GameWebPerformanceInfo)localObject).fVn += System.currentTimeMillis() - this.rQw;
    this.rQk.fVo = System.currentTimeMillis();
    if (!this.mParams.getBoolean("from_bag", false))
    {
      localObject = com.tencent.mm.game.report.api.a.fUK;
      if (localObject != null) {
        ((com.tencent.mm.game.report.api.a)localObject).a(this.rQk);
      }
      if (!this.rQC) {
        com.tencent.mm.plugin.webview.ui.tools.game.e.a(cBJ(), this);
      }
    }
    for (;;)
    {
      try
      {
        if (!this.rQs)
        {
          this.rQs = true;
          localObject = new JSONObject();
          if (this.rQy != 0L) {
            continue;
          }
          ((JSONObject)localObject).put("render_duration", 0);
          com.tencent.mm.game.report.api.a.fUK.a(9, URLEncoder.encode(bEx()), URLEncoder.encode(((JSONObject)localObject).toString()), System.currentTimeMillis() - this.rQx.Bnx);
        }
      }
      catch (Exception localException)
      {
        continue;
        if (!this.ATh.bzs()) {
          continue;
        }
        q.awk(this.ATh.AUn);
        AppMethodBeat.o(83191);
      }
      GameWebPerformanceInfo.qf(bEx());
      if (!this.rQC) {
        com.tencent.mm.plugin.webview.ui.tools.game.h.ayn(bEx());
      }
      localObject = this.rQz.values();
      if ((localObject == null) || (((Collection)localObject).size() <= 0)) {
        continue;
      }
      localObject = ((Collection)localObject).iterator();
      if (!((Iterator)localObject).hasNext()) {
        continue;
      }
      ((b)((Iterator)localObject).next()).onDestroy();
      continue;
      ((JSONObject)localObject).put("render_duration", this.rQy - this.rQx.Bnx);
    }
  }
  
  public void onForeground()
  {
    AppMethodBeat.i(83189);
    ad.i("MicroMsg.GameWebPage", "onForeground, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (this.rQk.fVe == 0L) {
      this.rQk.fVe = System.currentTimeMillis();
    }
    this.rQw = System.currentTimeMillis();
    this.rQv.BmP.onResume();
    super.onForeground();
    Iterator localIterator = this.rQz.values().iterator();
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