package com.tencent.mm.plugin.game.luggage.page;

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
import com.tencent.luggage.d.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.at;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.game.luggage.b.1;
import com.tencent.mm.plugin.game.luggage.j.b;
import com.tencent.mm.plugin.game.luggage.j.d;
import com.tencent.mm.plugin.game.luggage.j.f;
import com.tencent.mm.plugin.game.protobuf.ea;
import com.tencent.mm.plugin.webview.luggage.ipc.ActiveMainProcessTask;
import com.tencent.mm.plugin.webview.luggage.n;
import com.tencent.mm.plugin.webview.luggage.u;
import com.tencent.mm.plugin.webview.ui.tools.game.d.a;
import com.tencent.mm.plugin.webview.ui.tools.game.e;
import com.tencent.mm.plugin.webview.ui.tools.game.e.a;
import com.tencent.mm.plugin.webview.ui.tools.game.e.b;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.aw;
import com.tencent.xweb.WebView;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class GameWebPage
  extends com.tencent.mm.plugin.webview.luggage.g
  implements com.tencent.mm.plugin.webview.ui.tools.game.f
{
  private long Imz;
  protected GameWebPerformanceInfo IwE;
  private View IwM;
  private GameMenuImageButton IwN;
  private boolean IwO;
  private boolean IwP;
  public boolean IwQ;
  private boolean IwR;
  private String IwS;
  public com.tencent.mm.plugin.webview.ui.tools.game.d IwT;
  private long IwU;
  public com.tencent.mm.plugin.webview.ui.tools.game.h IwV;
  public long IwW;
  private Map<String, b> IwX;
  private ViewGroup IwY;
  private boolean IwZ;
  private String Iwl;
  boolean Ixa;
  private boolean Ixb;
  public f Ixc;
  public boolean Ixd;
  private boolean Ixe;
  public boolean Ixf;
  private long Ixg;
  private long Ixh;
  private IListener Ixi;
  private a Ixj;
  private com.tencent.mm.plugin.brandservice.api.a Ixk;
  
  public GameWebPage(com.tencent.luggage.d.j paramj, p paramp, Bundle paramBundle)
  {
    super(paramj, paramp, paramBundle);
    AppMethodBeat.i(83183);
    this.IwO = false;
    this.IwP = false;
    this.IwQ = false;
    this.IwR = false;
    this.IwW = 0L;
    this.IwX = new HashMap();
    this.Ixa = false;
    this.Ixb = false;
    this.Ixd = false;
    this.Ixe = true;
    this.Ixf = false;
    this.Ixg = 0L;
    this.Imz = 0L;
    this.Ixh = 0L;
    this.Ixi = null;
    this.Ixk = null;
    this.IwT = new com.tencent.mm.plugin.webview.ui.tools.game.d()
    {
      public final void az(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(83172);
        com.tencent.mm.ipcinvoker.j.a(MainProcessIPCService.PROCESS_NAME, paramAnonymousBundle, com.tencent.mm.plugin.game.luggage.g.a.class, null);
        AppMethodBeat.o(83172);
      }
    };
    Log.i("MicroMsg.GameWebPage", "initWebPageEnd, __Time__， time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    paramp = paramBundle.getString("rawUrl");
    this.IwE = GameWebPerformanceInfo.EI(paramp);
    this.IwE.mtK = fET();
    this.IwE.mud = System.currentTimeMillis();
    this.IwV = aGk(paramp);
    paramj = this.ejT.getString("rawUrl");
    if (!Util.isNullOrNil(paramj))
    {
      paramBundle = Uri.parse(paramj);
      paramj = paramBundle.getQueryParameter("nav_color");
      if (aw.isDarkMode()) {
        paramj = paramBundle.getQueryParameter("darkmode_nav_color");
      }
      if (Util.isNullOrNil(paramj)) {}
    }
    try
    {
      int i = Color.parseColor("#".concat(String.valueOf(paramj)));
      this.ejT.putInt("customize_status_bar_color", i);
      label249:
      paramj = Util.getHost(paramp);
      if ((paramj != null) && (paramj.equals(WeChatHosts.domainString(j.f.host_game_weixin_qq_com)))) {
        this.ejR.ejy = com.tencent.luggage.d.a.a.ejX;
      }
      fES().XEA = new com.tencent.mm.plugin.wepkg.event.b()
      {
        public final void fEX()
        {
          AppMethodBeat.i(277019);
          h localh = (h)GameWebPage.this.ejR.aoE();
          if (!Util.isNullOrNil(localh.ItK)) {
            localh.post(new h.3(localh));
          }
          AppMethodBeat.o(277019);
        }
        
        public final void fEY()
        {
          AppMethodBeat.i(277021);
          GameWebPage.a(GameWebPage.this, true);
          GameWebPage.p(GameWebPage.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(83177);
              GameWebPage.o(GameWebPage.this);
              AppMethodBeat.o(83177);
            }
          }, 500L);
          AppMethodBeat.o(277021);
        }
        
        public final void wo(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(277023);
          Log.i("MicroMsg.GameWebPage", "onPkgReady");
          GameWebPage.s(GameWebPage.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(277020);
              if (GameWebPage.q(GameWebPage.this))
              {
                GameWebPage.a(GameWebPage.this, false);
                if (!((Activity)GameWebPage.this.mContext).isFinishing())
                {
                  GameWebPage.r(GameWebPage.this);
                  GameWebPage.this.eje.aow().o(GameWebPage.this.dgY(), GameWebPage.this.ejT);
                }
              }
              AppMethodBeat.o(277020);
            }
          });
          AppMethodBeat.o(277023);
        }
      };
      ((h)this.ejR.aoE()).setRawUrl(paramp);
      paramj = this.WFO;
      if (paramj != null) {
        paramj.evaluateJavascript(";(function(){return window.devicePixelRatio})();", new b.1());
      }
      this.WFO.addJavascriptInterface(new com.tencent.mm.plugin.game.luggage.h.d(com.tencent.mm.plugin.webview.luggage.k.d(this)), "WxGameJsCoreNative");
      if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yGC, false))
      {
        com.tencent.mm.plugin.game.luggage.h.a.create();
        au("created", com.tencent.mm.plugin.webview.luggage.k.d(this), paramp);
      }
      AppMethodBeat.o(83183);
      return;
    }
    catch (IllegalArgumentException paramj)
    {
      break label249;
    }
  }
  
  private static boolean aGp(String paramString)
  {
    AppMethodBeat.i(277051);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(277051);
      return false;
    }
    try
    {
      new JSONObject(paramString);
      AppMethodBeat.o(277051);
      return true;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(277051);
    }
    return false;
  }
  
  private void aiO(String paramString)
  {
    AppMethodBeat.i(277058);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.GameWebPage", "startCheck fail bizUserName is null");
      AppMethodBeat.o(277058);
      return;
    }
    if (this.Ixk == null) {
      this.Ixk = ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GX(9);
    }
    this.Ixk.aiO(paramString);
    AppMethodBeat.o(277058);
  }
  
  private static void au(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(277048);
    if (com.tencent.mm.plugin.game.luggage.h.a.fFa() != null) {
      com.tencent.mm.plugin.game.luggage.h.a.fFa().av(paramString1, paramString2, paramString3);
    }
    AppMethodBeat.o(277048);
  }
  
  private void fEW()
  {
    AppMethodBeat.i(277054);
    if ((!Util.isNullOrNil(this.Iwl)) && (com.tencent.mm.plugin.game.luggage.b.fEm()))
    {
      ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).dbE();
      aiO(this.Iwl);
    }
    AppMethodBeat.o(277054);
  }
  
  public void K(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(180146);
    long l = System.currentTimeMillis();
    Log.i("MicroMsg.GameWebPage", "onReceivedError, errorCode: %d, description: %s, failingUrl: %s , time: %d", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, Long.valueOf(l) });
    super.K(paramInt, paramString1, paramString2);
    try
    {
      paramString1 = new JSONObject();
      paramString1.put("errcode", paramInt);
      paramString1.put("errurl", paramString2);
      com.tencent.mm.game.report.api.a.mtH.a(8, URLEncoder.encode(dgY()), URLEncoder.encode(paramString1.toString()), l - this.IwV.XgF);
      AppMethodBeat.o(180146);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(180146);
    }
  }
  
  public final boolean Xp(int paramInt)
  {
    AppMethodBeat.i(83207);
    if (this.ejR.aoA() == com.tencent.luggage.d.a.a.ejX)
    {
      AppMethodBeat.o(83207);
      return true;
    }
    if (this.ejR.aoA() == com.tencent.luggage.d.a.a.ejY)
    {
      AppMethodBeat.o(83207);
      return false;
    }
    boolean bool = super.Xp(paramInt);
    AppMethodBeat.o(83207);
    return bool;
  }
  
  public final void a(a parama)
  {
    this.Ixj = parama;
  }
  
  public final boolean aGj(String paramString)
  {
    AppMethodBeat.i(83195);
    boolean bool = ((h)this.WFO).aGj(paramString);
    AppMethodBeat.o(83195);
    return bool;
  }
  
  protected com.tencent.mm.plugin.webview.ui.tools.game.h aGk(String paramString)
  {
    AppMethodBeat.i(83186);
    paramString = com.tencent.mm.plugin.webview.ui.tools.game.h.bmm(paramString);
    AppMethodBeat.o(83186);
    return paramString;
  }
  
  public boolean aGl(String paramString)
  {
    AppMethodBeat.i(83187);
    if ((paramString.equals(dgY())) && (this.IwE.mui == 0L))
    {
      this.IwE.mui = System.currentTimeMillis();
      Log.i("MicroMsg.GameWebPage", "startGetA8Key, url: %s, time: %d", new Object[] { paramString, Long.valueOf(this.IwE.mui) });
    }
    boolean bool = super.aGl(paramString);
    AppMethodBeat.o(83187);
    return bool;
  }
  
  public final void aGm(String paramString)
  {
    AppMethodBeat.i(83199);
    super.aGm(paramString);
    if (this.IwE.muf == 0L) {
      this.IwE.muf = System.currentTimeMillis();
    }
    AppMethodBeat.o(83199);
  }
  
  public final WebResourceResponse aGn(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(277171);
    int i = j;
    if (paramString != null)
    {
      if (paramString.length() != 0) {
        break label84;
      }
      i = j;
    }
    for (;;)
    {
      if ((i == 0) && (!this.Ixb))
      {
        this.Ixb = true;
        if (this.Ixj != null) {
          this.Ixj.fEE();
        }
        this.mHandler.postUI(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(277024);
            if (GameWebPage.this.iuf() != null)
            {
              str1 = String.format("javascript:(function(){ window.wgclient = window.wgclient || {}; window.wgclient.__gameTopBarHeight__= %d; })()", new Object[] { Integer.valueOf(com.tencent.mm.plugin.appbrand.af.i.DA(GameWebPage.this.iuf().getTopBarHeight())) });
              Log.i("MicroMsg.GameWebPage", "gameTopHeight:%s", new Object[] { str1 });
              GameWebPage.this.eE(str1);
            }
            String str1 = GameWebPage.this.fED();
            String str2;
            if (GameWebPage.aGq(str1))
            {
              str2 = String.format("javascript:(function(){ window.wgclient = window.wgclient || {}; window.wgclient.__gamePreInjectData__= %s; })()", new Object[] { str1 });
              Log.i("MicroMsg.GameWebPage", "preInjectData, size:%d", new Object[] { Integer.valueOf(str1.getBytes().length) });
              GameWebPage.this.eE(str2);
            }
            str1 = GameWebPage.this.ejT.getString("game_liteapp_pass_data");
            if (GameWebPage.aGq(str1))
            {
              str2 = String.format("javascript:(function(){ window.wgclient = window.wgclient || {}; window.wgclient.__passbyData__= %s; })()", new Object[] { str1 });
              Log.i("MicroMsg.GameWebPage", "liteAppPassByData, size:%d", new Object[] { Integer.valueOf(str1.getBytes().length) });
              GameWebPage.this.eE(str2);
            }
            AppMethodBeat.o(277024);
          }
        });
      }
      paramString = super.aGn(paramString);
      AppMethodBeat.o(277171);
      return paramString;
      label84:
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
  
  public final void aGo(String paramString)
  {
    AppMethodBeat.i(83202);
    super.aGo(paramString);
    if (this.IwV.XgJ == 0L) {
      this.IwV.XgJ = System.currentTimeMillis();
    }
    AppMethodBeat.o(83202);
  }
  
  public final void aI(final Runnable paramRunnable)
  {
    AppMethodBeat.i(277143);
    if (!this.Ixf)
    {
      this.Ixf = true;
      this.WFO.evaluateJavascript("window.performance.getEntriesByName('first-contentful-paint')[0].startTime", new ValueCallback() {});
      AppMethodBeat.o(277143);
      return;
    }
    if (paramRunnable != null) {
      paramRunnable.run();
    }
    AppMethodBeat.o(277143);
  }
  
  public final void aoL()
  {
    AppMethodBeat.i(277139);
    if (this.mIsForeground) {
      this.Imz += System.currentTimeMillis() - this.Ixh;
    }
    aI(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83174);
        GameWebPage.d(GameWebPage.this);
        AppMethodBeat.o(83174);
      }
    });
    AppMethodBeat.o(277139);
  }
  
  public View aog()
  {
    AppMethodBeat.i(83184);
    View localView = super.aog();
    this.IwM = LayoutInflater.from(getContext()).inflate(j.d.Iup, this.WFX, false);
    this.IwM.setVisibility(8);
    this.WFX.addView(this.IwM, new FrameLayout.LayoutParams(-2, -2, 17));
    Log.i("MicroMsg.GameWebPage", "create vie end, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    AppMethodBeat.o(83184);
    return localView;
  }
  
  public void c(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(83203);
    super.c(paramString1, paramString2, paramMap);
    h localh = (h)this.ejR.aoE();
    localh.ItK = paramString2;
    localh.Iwx = paramMap;
    if (Util.isNullOrNil(paramString2)) {
      Log.i("MicroMsg.LuggageGameUinKeyHolder", "setFullUrlAndHeaders, fullUrl is null");
    }
    for (;;)
    {
      long l = System.currentTimeMillis();
      if (paramString1.equals(dgY()))
      {
        Log.i("MicroMsg.GameWebPage", "getA8Key end, __Time__, time: %d", new Object[] { Long.valueOf(l) });
        this.IwE.muj = l;
      }
      if (this.IwE.muf == 0L) {
        this.IwE.muf = l;
      }
      if (this.IwV.XgK == 0L) {
        this.IwV.XgK = System.currentTimeMillis();
      }
      com.tencent.mm.plugin.game.luggage.g.a(this.WFO, paramString2, paramMap);
      com.tencent.mm.plugin.game.luggage.g.c(this.ejR, paramString2);
      this.IwQ = true;
      AppMethodBeat.o(83203);
      return;
      if (!Uri.parse(paramString2).getHost().equals(WeChatHosts.domainString(j.f.host_game_weixin_qq_com)))
      {
        Log.i("MicroMsg.LuggageGameUinKeyHolder", "setFullUrlAndHeaders, host is not wxgame");
      }
      else
      {
        com.tencent.mm.plugin.game.luggage.e.ItK = paramString2;
        com.tencent.mm.plugin.game.luggage.e.mHeaders = paramMap;
        com.tencent.mm.plugin.game.luggage.e.dX = System.currentTimeMillis() / 1000L;
      }
    }
  }
  
  public final void cxQ()
  {
    AppMethodBeat.i(83188);
    this.WFz.cxQ();
    AppMethodBeat.o(83188);
  }
  
  public final void e(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(277200);
    this.Iwl = paramString1;
    if ((this.WFz instanceof g))
    {
      fEW();
      String str = this.ejT.getString("rawUrl");
      g localg = (g)this.WFz;
      localg.Iwl = paramString1;
      localg.Iwm = paramString2;
      localg.Iwn = paramInt;
      localg.Iwo = str;
      localg.Iwp = paramString3;
      localg.fEM();
    }
    AppMethodBeat.o(277200);
  }
  
  public final void eG(String paramString)
  {
    AppMethodBeat.i(83200);
    long l = System.currentTimeMillis();
    Log.i("MicroMsg.GameWebPage", "onUrlLoadingStarted, url = %s, __Time__, time = %d", new Object[] { paramString, Long.valueOf(l) });
    super.eG(paramString);
    if (this.IwE.mug == 0L) {
      this.IwE.mug = l;
    }
    if (this.IwV.XgH == 0L) {
      this.IwV.XgH = l;
    }
    paramString = Util.getHost(paramString);
    if ((paramString != null) && (paramString.equals(WeChatHosts.domainString(j.f.host_game_weixin_qq_com)))) {}
    for (this.ejR.ejy = com.tencent.luggage.d.a.a.ejX;; this.ejR.ejy = this.WGi)
    {
      this.IwT.XfS.iAL();
      AppMethodBeat.o(83200);
      return;
    }
  }
  
  public void eH(String paramString)
  {
    AppMethodBeat.i(83201);
    long l = System.currentTimeMillis();
    Log.i("MicroMsg.GameWebPage", "onUrlLoadingFinished, url = %s, __Time__, time = %d", new Object[] { paramString, Long.valueOf(l) });
    super.eH(paramString);
    if (this.IwE.muh == 0L) {
      this.IwE.muh = l;
    }
    if (this.IwV.XgI == 0L) {
      this.IwV.XgI = l;
    }
    try
    {
      if (!this.IwO)
      {
        this.IwO = true;
        com.tencent.mm.game.report.api.a.mtH.a(7, URLEncoder.encode(dgY()), "", l - this.IwV.XgF);
      }
      label117:
      com.tencent.mm.plugin.game.luggage.g.c(this.ejR, this.ItK);
      this.IwT.XfS.aoZ();
      AppMethodBeat.o(83201);
      return;
    }
    catch (Exception paramString)
    {
      break label117;
    }
  }
  
  public void ehG()
  {
    AppMethodBeat.i(83196);
    aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83180);
        GameWebPage.h(GameWebPage.this).setVisibility(0);
        AppMethodBeat.o(83180);
      }
    });
    AppMethodBeat.o(83196);
  }
  
  public void fEC()
  {
    AppMethodBeat.i(83197);
    this.IwM.setVisibility(8);
    AppMethodBeat.o(83197);
  }
  
  protected String fED()
  {
    AppMethodBeat.i(277225);
    String str = this.ejT.getString("game_pre_inject_data");
    AppMethodBeat.o(277225);
    return str;
  }
  
  public final View fEP()
  {
    AppMethodBeat.i(83185);
    this.WFz = new g(this);
    n localn = this.WFz;
    AppMethodBeat.o(83185);
    return localn;
  }
  
  public final void fEQ()
  {
    boolean bool = true;
    AppMethodBeat.i(83194);
    Object localObject;
    if (!this.WGl)
    {
      this.WGm = this.ejT.getInt("customize_status_bar_color");
      if (this.WGm == 0)
      {
        localObject = com.tencent.mm.plugin.game.commlib.a.fDS();
        if ((localObject == null) || (Util.isNullOrNil(((ea)localObject).nRQ)) || (Util.isNullOrNil(((ea)localObject).ILO))) {}
      }
    }
    try
    {
      if (aw.isDarkMode()) {}
      for (this.WGm = Color.parseColor(((ea)localObject).ILO);; this.WGm = Color.parseColor(((ea)localObject).nRQ))
      {
        if (this.WGm == 0) {
          this.WGm = androidx.core.content.a.w(getContext(), j.b.action_bar_color);
        }
        if (!this.IwR)
        {
          this.IwR = true;
          iuc();
        }
        localObject = this.WFz;
        if (((n)localObject).WHl != null)
        {
          com.tencent.mm.ui.statusbar.b localb = ((n)localObject).WGV;
          int i = ((n)localObject).WHl.intValue();
          if (((n)localObject).WHm) {
            break;
          }
          com.tencent.mm.ui.statusbar.a.h(localb, i, bool);
        }
        AppMethodBeat.o(83194);
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Log.e("MicroMsg.GameWebPage", "parse color: " + localIllegalArgumentException.getMessage());
        continue;
        bool = false;
      }
    }
  }
  
  public final int fER()
  {
    AppMethodBeat.i(277181);
    final int i = super.fER();
    this.mHandler.postUI(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(277018);
        String str = String.format("javascript:(function(){ window.wgclient = window.wgclient || {}; window.wgclient.__currentFontSize__= %d; })()", new Object[] { Integer.valueOf(i) });
        Log.i("MicroMsg.GameWebPage", "initFontSize, fontSize:%s", new Object[] { str });
        GameWebPage.this.eE(str);
        AppMethodBeat.o(277018);
      }
    });
    AppMethodBeat.o(277181);
    return i;
  }
  
  public final com.tencent.mm.plugin.wepkg.f fES()
  {
    AppMethodBeat.i(83205);
    com.tencent.mm.plugin.wepkg.f localf = ((h)this.WFO).getWePkgPlugin();
    AppMethodBeat.o(83205);
    return localf;
  }
  
  public final String fET()
  {
    AppMethodBeat.i(83206);
    String str = (hashCode() & 0x7FFFFFFF) + "_" + (dgY().hashCode() & 0x7FFFFFFF);
    AppMethodBeat.o(83206);
    return str;
  }
  
  public final Map<Integer, Object> fEU()
  {
    AppMethodBeat.i(277211);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(e.a.XfY), fET());
    localHashMap.put(Integer.valueOf(e.a.XfZ), NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext()));
    localHashMap.put(Integer.valueOf(e.a.Xga), String.valueOf(com.c.a.b.aH(MMApplicationContext.getContext())));
    String str = dgY();
    try
    {
      localHashMap.put(Integer.valueOf(e.a.Xgb), r.as(Util.nullAsNil(str), "UTF-8"));
      label94:
      int j = e.a.Xgc;
      int i;
      if (aGj(str))
      {
        i = 1;
        localHashMap.put(Integer.valueOf(j), Integer.valueOf(i));
        localHashMap.put(Integer.valueOf(e.a.Xgd), Integer.valueOf(1));
        if (!(this instanceof i)) {
          break label211;
        }
        localHashMap.put(Integer.valueOf(e.a.Xge), Integer.valueOf(1));
      }
      for (;;)
      {
        localHashMap.put(Integer.valueOf(e.a.Xgf), fES().iEW());
        i = e.a.Xgg;
        fES();
        localHashMap.put(Integer.valueOf(i), com.tencent.mm.plugin.wepkg.f.iEX());
        AppMethodBeat.o(277211);
        return localHashMap;
        i = 0;
        break;
        label211:
        localHashMap.put(Integer.valueOf(e.a.Xge), Integer.valueOf(0));
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label94;
    }
  }
  
  public final Map<Integer, Object> fEV()
  {
    int j = 1;
    AppMethodBeat.i(277217);
    HashMap localHashMap = new HashMap();
    com.tencent.mm.plugin.webview.ui.tools.game.h localh = com.tencent.mm.plugin.webview.ui.tools.game.h.bmn(dgY());
    if (localh != null)
    {
      localHashMap.put(Integer.valueOf(e.b.Xgj), Long.valueOf(localh.XgG - localh.startTime));
      localHashMap.put(Integer.valueOf(e.b.Xgk), Long.valueOf(localh.XgH - localh.startTime));
      localHashMap.put(Integer.valueOf(e.b.Xgl), Long.valueOf(localh.XgI - localh.XgH));
      localHashMap.put(Integer.valueOf(e.b.Xgm), Long.valueOf(localh.XgK - localh.XgJ));
      localHashMap.put(Integer.valueOf(e.b.Xgn), Long.valueOf(localh.XgM - localh.XgL));
      localHashMap.put(Integer.valueOf(e.b.Xgv), Long.valueOf(localh.XgN));
      localHashMap.put(Integer.valueOf(e.b.Xgx), Long.valueOf(localh.XgO));
      localHashMap.put(Integer.valueOf(e.b.Xgo), Long.valueOf(localh.XgP));
      localHashMap.put(Integer.valueOf(e.b.Xgp), Long.valueOf(localh.XgQ));
      localHashMap.put(Integer.valueOf(e.b.Xgq), Long.valueOf(localh.tVS));
      localHashMap.put(Integer.valueOf(e.b.Xgr), Long.valueOf(localh.XgR));
      localHashMap.put(Integer.valueOf(e.b.Xgs), Long.valueOf(localh.XgS));
      localHashMap.put(Integer.valueOf(e.b.Xgt), Long.valueOf(localh.XgT));
      localHashMap.put(Integer.valueOf(e.b.Xgu), Long.valueOf(localh.XgU));
      localHashMap.put(Integer.valueOf(e.b.Xgy), Long.valueOf(System.currentTimeMillis()));
      localHashMap.put(Integer.valueOf(e.b.Xgz), Long.valueOf(localh.XgV));
    }
    int k = e.b.Xgw;
    if (Util.isNullOrNil(fES().iEU()))
    {
      i = 0;
      localHashMap.put(Integer.valueOf(k), Integer.valueOf(i));
      k = e.b.XgA;
      if (!this.Ixe) {
        break label518;
      }
      i = 1;
      label425:
      localHashMap.put(Integer.valueOf(k), Integer.valueOf(i));
      k = e.b.XgB;
      if (!this.Ixd) {
        break label523;
      }
    }
    label518:
    label523:
    for (int i = j;; i = 0)
    {
      localHashMap.put(Integer.valueOf(k), Integer.valueOf(i));
      localHashMap.put(Integer.valueOf(e.b.XgC), Long.valueOf(this.Ixg));
      localHashMap.put(Integer.valueOf(e.b.XgD), Long.valueOf(this.Imz));
      AppMethodBeat.o(277217);
      return localHashMap;
      i = 1;
      break;
      i = 0;
      break label425;
    }
  }
  
  public void l(final String paramString, final Bundle paramBundle)
  {
    AppMethodBeat.i(83198);
    Log.i("MicroMsg.GameWebPage", "load url, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (this.IwV.XgG == 0L) {
      this.IwV.XgG = System.currentTimeMillis();
    }
    paramBundle = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83181);
        GameWebPage.a(GameWebPage.this, paramString, paramBundle);
        AppMethodBeat.o(83181);
      }
    };
    if (com.tencent.mm.plugin.appbrand.ipc.c.isLive())
    {
      Log.i("MicroMsg.GameWebPage", "activeIpcTask, service is alive");
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
        AppMethodBeat.i(83182);
        long l1 = System.currentTimeMillis();
        long l2 = l;
        Log.i("MicroMsg.GameWebPage", "activeIpcTask, callback");
        localPBool.cpx();
        synchronized (paramBundle)
        {
          if (paramBundle.value)
          {
            AppMethodBeat.o(83182);
            return;
          }
          paramBundle.value = true;
          paramString.run();
          com.tencent.mm.plugin.wepkg.utils.a.b("ipcServiceStartTime", this.val$url, com.tencent.mm.plugin.wepkg.utils.d.boB(this.val$url), null, 0L, l1 - l2, null);
          AppMethodBeat.o(83182);
          return;
        }
      }
    };
    localActiveMainProcessTask.bQt();
    com.tencent.threadpool.h.ahAA.p(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(277015);
        synchronized (localPBool)
        {
          if (localPBool.value)
          {
            AppMethodBeat.o(277015);
            return;
          }
          Log.i("MicroMsg.GameWebPage", "activeIpcTask, time out, callback");
          localPBool.value = true;
          GameWebPage.a(GameWebPage.this, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(170129);
              GameWebPage.2.this.val$callback.run();
              AppMethodBeat.o(170129);
            }
          });
          AppMethodBeat.o(277015);
          return;
        }
      }
    }, 1000L);
    AppMethodBeat.o(83198);
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(83190);
    Log.i("MicroMsg.GameWebPage", "onBackground, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (this.Ixi != null)
    {
      this.Ixi.dead();
      this.Ixi = null;
    }
    if (this.Ixk != null) {
      this.Ixk.stopCheck();
    }
    aI(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(277017);
        GameWebPage.c(GameWebPage.this);
        AppMethodBeat.o(277017);
      }
    });
    AppMethodBeat.o(83190);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(83191);
    Log.i("MicroMsg.GameWebPage", "onDestroy, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    super.onDestroy();
    com.tencent.mm.plugin.webview.ui.tools.game.d.a(this.IwT.XfS.XfT);
    Object localObject = this.IwE;
    ((GameWebPerformanceInfo)localObject).muk += System.currentTimeMillis() - this.IwU;
    this.IwE.mul = System.currentTimeMillis();
    if (!this.ejT.getBoolean("from_bag", false))
    {
      localObject = com.tencent.mm.game.report.api.a.mtH;
      if (localObject != null) {
        ((com.tencent.mm.game.report.api.a)localObject).a(this.IwE);
      }
    }
    for (;;)
    {
      try
      {
        if (!this.IwP)
        {
          this.IwP = true;
          localObject = new JSONObject();
          if (this.IwW != 0L) {
            continue;
          }
          ((JSONObject)localObject).put("render_duration", 0);
          com.tencent.mm.game.report.api.a.mtH.a(9, URLEncoder.encode(dgY()), URLEncoder.encode(((JSONObject)localObject).toString()), System.currentTimeMillis() - this.IwV.XgF);
        }
      }
      catch (Exception localException)
      {
        continue;
        if (!this.WGb.gjV()) {
          continue;
        }
        com.tencent.mm.plugin.webview.luggage.s.bkb(this.WGb.bQs());
        au("destroyed", com.tencent.mm.plugin.webview.luggage.k.d(this), null);
        AppMethodBeat.o(83191);
      }
      GameWebPerformanceInfo.EK(dgY());
      localObject = this.IwX.values();
      if ((localObject == null) || (((Collection)localObject).size() <= 0)) {
        continue;
      }
      localObject = ((Collection)localObject).iterator();
      if (!((Iterator)localObject).hasNext()) {
        continue;
      }
      ((b)((Iterator)localObject).next()).onDestroy();
      continue;
      ((JSONObject)localObject).put("render_duration", this.IwW - this.IwV.XgF);
    }
  }
  
  public void onForeground()
  {
    AppMethodBeat.i(83189);
    Log.i("MicroMsg.GameWebPage", "onForeground, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (((this.WFz instanceof g)) && (this.Ixi == null))
    {
      this.Ixi = new BizFinderLineStatusChangedEventListenerImpl((g)this.WFz);
      this.Ixi.alive();
    }
    fEW();
    if (this.IwE.mub == 0L) {
      this.IwE.mub = System.currentTimeMillis();
    }
    this.IwU = System.currentTimeMillis();
    this.IwT.XfS.onResume();
    super.onForeground();
    this.Ixh = System.currentTimeMillis();
    Iterator localIterator = this.IwX.values().iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).onForeground();
    }
    au("foreground", com.tencent.mm.plugin.webview.luggage.k.d(this), null);
    this.Ixe = false;
    AppMethodBeat.o(83189);
  }
  
  public final void reload()
  {
    AppMethodBeat.i(83192);
    super.reload();
    this.Ixb = false;
    fES().XEG = false;
    if (this.Ixc != null)
    {
      f localf = this.Ixc;
      String str = localf.b(localf.IvU);
      if (!Util.isNullOrNil(str))
      {
        localf.IvQ.remove(str);
        localf.fr(str, 1);
      }
    }
    AppMethodBeat.o(83192);
  }
  
  public void wl(boolean paramBoolean)
  {
    AppMethodBeat.i(83193);
    super.wl(paramBoolean);
    if (isFullScreen())
    {
      this.IwS = this.ejT.getString("game_hv_menu_appid");
      if (!Util.isNullOrNil(this.IwS))
      {
        if (this.IwN == null)
        {
          this.IwN = new GameMenuImageButton(getContext());
          this.IwN.a(this.mRootView, new GameMenuImageButton.a()
          {
            public final void eEp()
            {
              AppMethodBeat.i(277028);
              GameWebPage.this.cxQ();
              AppMethodBeat.o(277028);
            }
          });
        }
        this.WFW.setVisibility(8);
        AppMethodBeat.o(83193);
        return;
      }
      this.WFW.setVisibility(0);
    }
    AppMethodBeat.o(83193);
  }
  
  public final void wn(boolean paramBoolean)
  {
    AppMethodBeat.i(277206);
    if ((this.WFz instanceof g))
    {
      g localg = (g)this.WFz;
      com.tencent.threadpool.h.ahAA.bk(new g.3(localg, paramBoolean));
    }
    AppMethodBeat.o(277206);
  }
  
  static class BizFinderLineStatusChangedEventListenerImpl
    extends IListener<at>
  {
    private WeakReference<g> Ixt;
    
    public BizFinderLineStatusChangedEventListenerImpl(g paramg)
    {
      super();
      AppMethodBeat.i(277027);
      this.Ixt = new WeakReference(paramg);
      this.__eventId = at.class.getName().hashCode();
      AppMethodBeat.o(277027);
    }
  }
  
  public static abstract interface a
  {
    public abstract void fEE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.page.GameWebPage
 * JD-Core Version:    0.7.0.1
 */