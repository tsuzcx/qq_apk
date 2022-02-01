package com.tencent.mm.plugin.game.luggage.g;

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
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.game.luggage.b.1;
import com.tencent.mm.plugin.game.luggage.j.b;
import com.tencent.mm.plugin.game.luggage.j.d;
import com.tencent.mm.plugin.game.luggage.j.f;
import com.tencent.mm.plugin.game.protobuf.dw;
import com.tencent.mm.plugin.webview.luggage.ipc.ActiveMainProcessTask;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.plugin.webview.luggage.r;
import com.tencent.mm.plugin.webview.luggage.t;
import com.tencent.mm.plugin.webview.ui.tools.game.d.a;
import com.tencent.mm.plugin.webview.ui.tools.game.e;
import com.tencent.mm.plugin.webview.ui.tools.game.e.a;
import com.tencent.mm.plugin.webview.ui.tools.game.e.b;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.ar;
import com.tencent.xweb.WebView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class i
  extends com.tencent.mm.plugin.webview.luggage.g
  implements com.tencent.mm.plugin.webview.ui.tools.game.f
{
  protected GameWebPerformanceInfo CCD;
  private View CCL;
  private GameMenuImageButton CCM;
  private boolean CCN;
  private boolean CCO;
  public boolean CCP;
  private boolean CCQ;
  private String CCR;
  public com.tencent.mm.plugin.webview.ui.tools.game.d CCS;
  private long CCT;
  public com.tencent.mm.plugin.webview.ui.tools.game.h CCU;
  public long CCV;
  private Map<String, b> CCW;
  private ViewGroup CCX;
  private boolean CCY;
  boolean CCZ;
  private boolean CDa;
  public f CDb;
  public boolean CDc;
  private boolean CDd;
  public boolean CDe;
  private long CDf;
  private long CDg;
  private a CDh;
  private long CvJ;
  
  public i(com.tencent.luggage.d.j paramj, p paramp, Bundle paramBundle)
  {
    super(paramj, paramp, paramBundle);
    AppMethodBeat.i(83183);
    this.CCN = false;
    this.CCO = false;
    this.CCP = false;
    this.CCQ = false;
    this.CCV = 0L;
    this.CCW = new HashMap();
    this.CCZ = false;
    this.CDa = false;
    this.CDc = false;
    this.CDd = true;
    this.CDe = false;
    this.CDf = 0L;
    this.CvJ = 0L;
    this.CDg = 0L;
    this.CCS = new com.tencent.mm.plugin.webview.ui.tools.game.d()
    {
      public final void ah(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(83172);
        com.tencent.mm.ipcinvoker.j.a(MainProcessIPCService.PROCESS_NAME, paramAnonymousBundle, com.tencent.mm.plugin.game.luggage.h.a.class, null);
        AppMethodBeat.o(83172);
      }
    };
    Log.i("MicroMsg.GameWebPage", "initWebPageEnd, __Time__， time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    paramp = paramBundle.getString("rawUrl");
    this.CCD = GameWebPerformanceInfo.LZ(paramp);
    this.CCD.jTs = ewX();
    this.CCD.jTL = System.currentTimeMillis();
    this.CCU = aJw(paramp);
    paramj = this.mParams.getString("rawUrl");
    if (!Util.isNullOrNil(paramj))
    {
      paramBundle = Uri.parse(paramj);
      paramj = paramBundle.getQueryParameter("nav_color");
      if (ar.isDarkMode()) {
        paramj = paramBundle.getQueryParameter("darkmode_nav_color");
      }
      if (Util.isNullOrNil(paramj)) {}
    }
    try
    {
      int i = Color.parseColor("#".concat(String.valueOf(paramj)));
      this.mParams.putInt("customize_status_bar_color", i);
      label239:
      paramj = Util.getHost(paramp);
      if ((paramj != null) && (paramj.equals(WeChatHosts.domainString(j.f.host_game_weixin_qq_com)))) {
        this.crX.crG = com.tencent.luggage.d.a.a.csc;
      }
      ewW().QLb = new com.tencent.mm.plugin.wepkg.event.b()
      {
        public final void exa()
        {
          AppMethodBeat.i(231162);
          h localh = (h)i.this.crX.Ow();
          if (!Util.isNullOrNil(localh.CzZ)) {
            localh.post(new h.3(localh));
          }
          AppMethodBeat.o(231162);
        }
        
        public final void exb()
        {
          AppMethodBeat.i(231164);
          i.a(i.this, true);
          i.p(i.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(231930);
              i.o(i.this);
              AppMethodBeat.o(231930);
            }
          }, 500L);
          AppMethodBeat.o(231164);
        }
        
        public final void si(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(231165);
          Log.i("MicroMsg.GameWebPage", "onPkgReady");
          i.s(i.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(231852);
              if (i.q(i.this))
              {
                i.a(i.this, false);
                if (!((Activity)i.this.mContext).isFinishing())
                {
                  i.r(i.this);
                  i.this.crm.Oo().o(i.this.cDu(), i.this.mParams);
                }
              }
              AppMethodBeat.o(231852);
            }
          });
          AppMethodBeat.o(231165);
        }
      };
      ((h)this.crX.Ow()).setRawUrl(paramp);
      paramj = this.PPv;
      if (paramj != null) {
        paramj.evaluateJavascript(";(function(){return window.devicePixelRatio})();", new b.1());
      }
      this.PPv.addJavascriptInterface(new com.tencent.mm.plugin.game.luggage.i.d(com.tencent.mm.plugin.webview.luggage.j.d(this)), "WxGameJsCoreNative");
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vtY, false))
      {
        com.tencent.mm.plugin.game.luggage.i.a.create();
        ak("created", com.tencent.mm.plugin.webview.luggage.j.d(this), paramp);
      }
      AppMethodBeat.o(83183);
      return;
    }
    catch (IllegalArgumentException paramj)
    {
      break label239;
    }
  }
  
  private static boolean aJB(String paramString)
  {
    AppMethodBeat.i(232226);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(232226);
      return false;
    }
    try
    {
      new JSONObject(paramString);
      AppMethodBeat.o(232226);
      return true;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(232226);
    }
    return false;
  }
  
  private static void ak(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(232225);
    if (com.tencent.mm.plugin.game.luggage.i.a.exd() != null) {
      com.tencent.mm.plugin.game.luggage.i.a.exd().al(paramString1, paramString2, paramString3);
    }
    AppMethodBeat.o(232225);
  }
  
  public void G(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(180146);
    long l = System.currentTimeMillis();
    Log.i("MicroMsg.GameWebPage", "onReceivedError, errorCode: %d, description: %s, failingUrl: %s , time: %d", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, Long.valueOf(l) });
    super.G(paramInt, paramString1, paramString2);
    try
    {
      paramString1 = new JSONObject();
      paramString1.put("errcode", paramInt);
      paramString1.put("errurl", paramString2);
      com.tencent.mm.game.report.api.a.jTp.a(8, URLEncoder.encode(cDu()), URLEncoder.encode(paramString1.toString()), l - this.CCU.Qor);
      AppMethodBeat.o(180146);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(180146);
    }
  }
  
  public View NW()
  {
    AppMethodBeat.i(83184);
    View localView = super.NW();
    this.CCL = LayoutInflater.from(getContext()).inflate(j.d.CAD, this.PPE, false);
    this.CCL.setVisibility(8);
    this.PPE.addView(this.CCL, new FrameLayout.LayoutParams(-2, -2, 17));
    Log.i("MicroMsg.GameWebPage", "create vie end, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    AppMethodBeat.o(83184);
    return localView;
  }
  
  public final void OD()
  {
    AppMethodBeat.i(232195);
    if (this.mIsForeground) {
      this.CvJ += System.currentTimeMillis() - this.CDg;
    }
    ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83174);
        i.d(i.this);
        AppMethodBeat.o(83174);
      }
    });
    AppMethodBeat.o(232195);
  }
  
  public final boolean Tv(int paramInt)
  {
    AppMethodBeat.i(83207);
    if (this.crX.Os() == com.tencent.luggage.d.a.a.csc)
    {
      AppMethodBeat.o(83207);
      return true;
    }
    if (this.crX.Os() == com.tencent.luggage.d.a.a.csd)
    {
      AppMethodBeat.o(83207);
      return false;
    }
    boolean bool = super.Tv(paramInt);
    AppMethodBeat.o(83207);
    return bool;
  }
  
  public final void a(a parama)
  {
    this.CDh = parama;
  }
  
  public final void aJA(String paramString)
  {
    AppMethodBeat.i(83202);
    super.aJA(paramString);
    if (this.CCU.Qov == 0L) {
      this.CCU.Qov = System.currentTimeMillis();
    }
    AppMethodBeat.o(83202);
  }
  
  public final boolean aJv(String paramString)
  {
    AppMethodBeat.i(83195);
    boolean bool = ((h)this.PPv).aJv(paramString);
    AppMethodBeat.o(83195);
    return bool;
  }
  
  protected com.tencent.mm.plugin.webview.ui.tools.game.h aJw(String paramString)
  {
    AppMethodBeat.i(83186);
    paramString = com.tencent.mm.plugin.webview.ui.tools.game.h.bmI(paramString);
    AppMethodBeat.o(83186);
    return paramString;
  }
  
  public boolean aJx(String paramString)
  {
    AppMethodBeat.i(83187);
    if ((paramString.equals(cDu())) && (this.CCD.jTQ == 0L))
    {
      this.CCD.jTQ = System.currentTimeMillis();
      Log.i("MicroMsg.GameWebPage", "startGetA8Key, url: %s, time: %d", new Object[] { paramString, Long.valueOf(this.CCD.jTQ) });
    }
    boolean bool = super.aJx(paramString);
    AppMethodBeat.o(83187);
    return bool;
  }
  
  public final void aJy(String paramString)
  {
    AppMethodBeat.i(83199);
    super.aJy(paramString);
    if (this.CCD.jTN == 0L) {
      this.CCD.jTN = System.currentTimeMillis();
    }
    AppMethodBeat.o(83199);
  }
  
  public final WebResourceResponse aJz(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(232208);
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
      if ((i == 0) && (!this.CDa))
      {
        this.CDa = true;
        if (this.CDh != null) {
          this.CDh.ewM();
        }
        this.mHandler.postUI(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(231827);
            if (i.this.gUx() != null)
            {
              str1 = String.format("javascript:(function(){ window.wgclient = window.wgclient || {}; window.wgclient.__gameTopBarHeight__= %d; })()", new Object[] { Integer.valueOf(com.tencent.mm.plugin.appbrand.ac.g.Dg(i.this.gUx().getTopBarHeight())) });
              Log.i("MicroMsg.GameWebPage", "gameTopHeight:%s", new Object[] { str1 });
              i.this.dt(str1);
            }
            String str1 = i.this.ewL();
            if (i.aJC(str1))
            {
              String str2 = String.format("javascript:(function(){ window.wgclient = window.wgclient || {}; window.wgclient.__gamePreInjectData__= %s; })()", new Object[] { str1 });
              Log.i("MicroMsg.GameWebPage", "preInjectData, size:%d", new Object[] { Integer.valueOf(str1.getBytes().length) });
              i.this.dt(str2);
            }
            AppMethodBeat.o(231827);
          }
        });
      }
      paramString = super.aJz(paramString);
      AppMethodBeat.o(232208);
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
  
  public final void ay(final Runnable paramRunnable)
  {
    AppMethodBeat.i(232197);
    if (!this.CDe)
    {
      this.CDe = true;
      this.PPv.evaluateJavascript("window.performance.getEntriesByName('first-contentful-paint')[0].startTime", new ValueCallback() {});
      AppMethodBeat.o(232197);
      return;
    }
    if (paramRunnable != null) {
      paramRunnable.run();
    }
    AppMethodBeat.o(232197);
  }
  
  public final void bXF()
  {
    AppMethodBeat.i(83188);
    this.PPg.bXF();
    AppMethodBeat.o(83188);
  }
  
  public void c(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(83203);
    super.c(paramString1, paramString2, paramMap);
    h localh = (h)this.crX.Ow();
    localh.CzZ = paramString2;
    localh.CCw = paramMap;
    if (Util.isNullOrNil(paramString2)) {
      Log.i("MicroMsg.LuggageGameUinKeyHolder", "setFullUrlAndHeaders, fullUrl is null");
    }
    for (;;)
    {
      long l = System.currentTimeMillis();
      if (paramString1.equals(cDu()))
      {
        Log.i("MicroMsg.GameWebPage", "getA8Key end, __Time__, time: %d", new Object[] { Long.valueOf(l) });
        this.CCD.jTR = l;
      }
      if (this.CCD.jTN == 0L) {
        this.CCD.jTN = l;
      }
      if (this.CCU.Qow == 0L) {
        this.CCU.Qow = System.currentTimeMillis();
      }
      com.tencent.mm.plugin.game.luggage.g.a(this.PPv, paramString2, paramMap);
      com.tencent.mm.plugin.game.luggage.g.c(this.crX, paramString2);
      this.CCP = true;
      AppMethodBeat.o(83203);
      return;
      if (!Uri.parse(paramString2).getHost().equals(WeChatHosts.domainString(j.f.host_game_weixin_qq_com)))
      {
        Log.i("MicroMsg.LuggageGameUinKeyHolder", "setFullUrlAndHeaders, host is not wxgame");
      }
      else
      {
        com.tencent.mm.plugin.game.luggage.e.CzZ = paramString2;
        com.tencent.mm.plugin.game.luggage.e.mHeaders = paramMap;
        com.tencent.mm.plugin.game.luggage.e.dX = System.currentTimeMillis() / 1000L;
      }
    }
  }
  
  public final void dv(String paramString)
  {
    AppMethodBeat.i(83200);
    long l = System.currentTimeMillis();
    Log.i("MicroMsg.GameWebPage", "onUrlLoadingStarted, url = %s, __Time__, time = %d", new Object[] { paramString, Long.valueOf(l) });
    super.dv(paramString);
    if (this.CCD.jTO == 0L) {
      this.CCD.jTO = l;
    }
    if (this.CCU.Qot == 0L) {
      this.CCU.Qot = l;
    }
    paramString = Util.getHost(paramString);
    if ((paramString != null) && (paramString.equals(WeChatHosts.domainString(j.f.host_game_weixin_qq_com)))) {}
    for (this.crX.crG = com.tencent.luggage.d.a.a.csc;; this.crX.crG = this.PPP)
    {
      this.CCS.QnE.hay();
      AppMethodBeat.o(83200);
      return;
    }
  }
  
  public void dw(String paramString)
  {
    AppMethodBeat.i(83201);
    long l = System.currentTimeMillis();
    Log.i("MicroMsg.GameWebPage", "onUrlLoadingFinished, url = %s, __Time__, time = %d", new Object[] { paramString, Long.valueOf(l) });
    super.dw(paramString);
    if (this.CCD.jTP == 0L) {
      this.CCD.jTP = l;
    }
    if (this.CCU.Qou == 0L) {
      this.CCU.Qou = l;
    }
    try
    {
      if (!this.CCN)
      {
        this.CCN = true;
        com.tencent.mm.game.report.api.a.jTp.a(7, URLEncoder.encode(cDu()), "", l - this.CCU.Qor);
      }
      label117:
      com.tencent.mm.plugin.game.luggage.g.c(this.crX, this.CzZ);
      this.CCS.QnE.OR();
      AppMethodBeat.o(83201);
      return;
    }
    catch (Exception paramString)
    {
      break label117;
    }
  }
  
  public void dwZ()
  {
    AppMethodBeat.i(83196);
    aI(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83180);
        i.h(i.this).setVisibility(0);
        AppMethodBeat.o(83180);
      }
    });
    AppMethodBeat.o(83196);
  }
  
  public void ewK()
  {
    AppMethodBeat.i(83197);
    this.CCL.setVisibility(8);
    AppMethodBeat.o(83197);
  }
  
  protected String ewL()
  {
    AppMethodBeat.i(232227);
    String str = this.mParams.getString("game_pre_inject_data");
    AppMethodBeat.o(232227);
    return str;
  }
  
  public final View ewU()
  {
    AppMethodBeat.i(83185);
    this.PPg = new g(this);
    m localm = this.PPg;
    AppMethodBeat.o(83185);
    return localm;
  }
  
  public final void ewV()
  {
    boolean bool = true;
    AppMethodBeat.i(83194);
    Object localObject;
    if (!this.PPS)
    {
      this.PPT = this.mParams.getInt("customize_status_bar_color");
      if (this.PPT == 0)
      {
        localObject = com.tencent.mm.plugin.game.commlib.a.ewc();
        if ((localObject == null) || (Util.isNullOrNil(((dw)localObject).lmL)) || (Util.isNullOrNil(((dw)localObject).CRy))) {}
      }
    }
    try
    {
      if (ar.isDarkMode()) {}
      for (this.PPT = Color.parseColor(((dw)localObject).CRy);; this.PPT = Color.parseColor(((dw)localObject).lmL))
      {
        if (this.PPT == 0) {
          this.PPT = androidx.core.content.a.w(getContext(), j.b.action_bar_color);
        }
        if (!this.CCQ)
        {
          this.CCQ = true;
          gUu();
        }
        localObject = this.PPg;
        if (((m)localObject).PQO != null)
        {
          com.tencent.mm.ui.statusbar.b localb = ((m)localObject).PQz;
          int i = ((m)localObject).PQO.intValue();
          if (((m)localObject).PQP) {
            break;
          }
          com.tencent.mm.ui.statusbar.a.f(localb, i, bool);
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
  
  public final com.tencent.mm.plugin.wepkg.f ewW()
  {
    AppMethodBeat.i(83205);
    com.tencent.mm.plugin.wepkg.f localf = ((h)this.PPv).getWePkgPlugin();
    AppMethodBeat.o(83205);
    return localf;
  }
  
  public final String ewX()
  {
    AppMethodBeat.i(83206);
    String str = (hashCode() & 0x7FFFFFFF) + "_" + (cDu().hashCode() & 0x7FFFFFFF);
    AppMethodBeat.o(83206);
    return str;
  }
  
  public final Map<Integer, Object> ewY()
  {
    AppMethodBeat.i(232220);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(e.a.QnK), ewX());
    localHashMap.put(Integer.valueOf(e.a.QnL), NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext()));
    localHashMap.put(Integer.valueOf(e.a.QnM), String.valueOf(YearClass.get(MMApplicationContext.getContext())));
    String str = cDu();
    try
    {
      localHashMap.put(Integer.valueOf(e.a.QnN), q.an(Util.nullAsNil(str), "UTF-8"));
      label94:
      int j = e.a.QnO;
      int i;
      if (aJv(str))
      {
        i = 1;
        localHashMap.put(Integer.valueOf(j), Integer.valueOf(i));
        localHashMap.put(Integer.valueOf(e.a.QnP), Integer.valueOf(1));
        if (!(this instanceof j)) {
          break label211;
        }
        localHashMap.put(Integer.valueOf(e.a.QnQ), Integer.valueOf(1));
      }
      for (;;)
      {
        localHashMap.put(Integer.valueOf(e.a.QnR), ewW().heo());
        i = e.a.QnS;
        ewW();
        localHashMap.put(Integer.valueOf(i), com.tencent.mm.plugin.wepkg.f.hep());
        AppMethodBeat.o(232220);
        return localHashMap;
        i = 0;
        break;
        label211:
        localHashMap.put(Integer.valueOf(e.a.QnQ), Integer.valueOf(0));
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label94;
    }
  }
  
  public final Map<Integer, Object> ewZ()
  {
    int j = 1;
    AppMethodBeat.i(232224);
    HashMap localHashMap = new HashMap();
    com.tencent.mm.plugin.webview.ui.tools.game.h localh = com.tencent.mm.plugin.webview.ui.tools.game.h.bmJ(cDu());
    if (localh != null)
    {
      localHashMap.put(Integer.valueOf(e.b.QnV), Long.valueOf(localh.Qos - localh.startTime));
      localHashMap.put(Integer.valueOf(e.b.QnW), Long.valueOf(localh.Qot - localh.startTime));
      localHashMap.put(Integer.valueOf(e.b.QnX), Long.valueOf(localh.Qou - localh.Qot));
      localHashMap.put(Integer.valueOf(e.b.QnY), Long.valueOf(localh.Qow - localh.Qov));
      localHashMap.put(Integer.valueOf(e.b.QnZ), Long.valueOf(localh.Qoy - localh.Qox));
      localHashMap.put(Integer.valueOf(e.b.Qoh), Long.valueOf(localh.Qoz));
      localHashMap.put(Integer.valueOf(e.b.Qoj), Long.valueOf(localh.QoA));
      localHashMap.put(Integer.valueOf(e.b.Qoa), Long.valueOf(localh.QoB));
      localHashMap.put(Integer.valueOf(e.b.Qob), Long.valueOf(localh.QoC));
      localHashMap.put(Integer.valueOf(e.b.Qoc), Long.valueOf(localh.qRk));
      localHashMap.put(Integer.valueOf(e.b.Qod), Long.valueOf(localh.QoD));
      localHashMap.put(Integer.valueOf(e.b.Qoe), Long.valueOf(localh.QoE));
      localHashMap.put(Integer.valueOf(e.b.Qof), Long.valueOf(localh.QoF));
      localHashMap.put(Integer.valueOf(e.b.Qog), Long.valueOf(localh.QoG));
      localHashMap.put(Integer.valueOf(e.b.Qok), Long.valueOf(System.currentTimeMillis()));
      localHashMap.put(Integer.valueOf(e.b.Qol), Long.valueOf(localh.QoH));
    }
    int k = e.b.Qoi;
    if (Util.isNullOrNil(ewW().hem()))
    {
      i = 0;
      localHashMap.put(Integer.valueOf(k), Integer.valueOf(i));
      k = e.b.Qom;
      if (!this.CDd) {
        break label518;
      }
      i = 1;
      label425:
      localHashMap.put(Integer.valueOf(k), Integer.valueOf(i));
      k = e.b.Qon;
      if (!this.CDc) {
        break label523;
      }
    }
    label518:
    label523:
    for (int i = j;; i = 0)
    {
      localHashMap.put(Integer.valueOf(k), Integer.valueOf(i));
      localHashMap.put(Integer.valueOf(e.b.Qoo), Long.valueOf(this.CDf));
      localHashMap.put(Integer.valueOf(e.b.Qop), Long.valueOf(this.CvJ));
      AppMethodBeat.o(232224);
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
    if (this.CCU.Qos == 0L) {
      this.CCU.Qos = System.currentTimeMillis();
    }
    paramBundle = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83181);
        i.a(i.this, paramString, paramBundle);
        AppMethodBeat.o(83181);
      }
    };
    if (com.tencent.mm.plugin.appbrand.ipc.b.isLive())
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
        localPBool.bPk();
        synchronized (paramBundle)
        {
          if (paramBundle.value)
          {
            AppMethodBeat.o(83182);
            return;
          }
          paramBundle.value = true;
          paramString.run();
          com.tencent.mm.plugin.wepkg.utils.a.b("ipcServiceStartTime", this.val$url, com.tencent.mm.plugin.wepkg.utils.d.boN(this.val$url), null, 0L, l1 - l2, null);
          AppMethodBeat.o(83182);
          return;
        }
      }
    };
    localActiveMainProcessTask.bsM();
    com.tencent.e.h.ZvG.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(231653);
        synchronized (localPBool)
        {
          if (localPBool.value)
          {
            AppMethodBeat.o(231653);
            return;
          }
          Log.i("MicroMsg.GameWebPage", "activeIpcTask, time out, callback");
          localPBool.value = true;
          i.a(i.this, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(170129);
              i.2.this.val$callback.run();
              AppMethodBeat.o(170129);
            }
          });
          AppMethodBeat.o(231653);
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
    ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(231355);
        i.c(i.this);
        AppMethodBeat.o(231355);
      }
    });
    AppMethodBeat.o(83190);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(83191);
    Log.i("MicroMsg.GameWebPage", "onDestroy, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    super.onDestroy();
    com.tencent.mm.plugin.webview.ui.tools.game.d.a(this.CCS.QnE.QnF);
    Object localObject = this.CCD;
    ((GameWebPerformanceInfo)localObject).jTS += System.currentTimeMillis() - this.CCT;
    this.CCD.jTT = System.currentTimeMillis();
    if (!this.mParams.getBoolean("from_bag", false))
    {
      localObject = com.tencent.mm.game.report.api.a.jTp;
      if (localObject != null) {
        ((com.tencent.mm.game.report.api.a)localObject).a(this.CCD);
      }
    }
    for (;;)
    {
      try
      {
        if (!this.CCO)
        {
          this.CCO = true;
          localObject = new JSONObject();
          if (this.CCV != 0L) {
            continue;
          }
          ((JSONObject)localObject).put("render_duration", 0);
          com.tencent.mm.game.report.api.a.jTp.a(9, URLEncoder.encode(cDu()), URLEncoder.encode(((JSONObject)localObject).toString()), System.currentTimeMillis() - this.CCU.Qor);
        }
      }
      catch (Exception localException)
      {
        continue;
        if (!this.PPI.faQ()) {
          continue;
        }
        r.bkr(this.PPI.bsL());
        ak("destroyed", com.tencent.mm.plugin.webview.luggage.j.d(this), null);
        AppMethodBeat.o(83191);
      }
      GameWebPerformanceInfo.Mb(cDu());
      localObject = this.CCW.values();
      if ((localObject == null) || (((Collection)localObject).size() <= 0)) {
        continue;
      }
      localObject = ((Collection)localObject).iterator();
      if (!((Iterator)localObject).hasNext()) {
        continue;
      }
      ((b)((Iterator)localObject).next()).onDestroy();
      continue;
      ((JSONObject)localObject).put("render_duration", this.CCV - this.CCU.Qor);
    }
  }
  
  public void onForeground()
  {
    AppMethodBeat.i(83189);
    Log.i("MicroMsg.GameWebPage", "onForeground, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (this.CCD.jTJ == 0L) {
      this.CCD.jTJ = System.currentTimeMillis();
    }
    this.CCT = System.currentTimeMillis();
    this.CCS.QnE.onResume();
    super.onForeground();
    this.CDg = System.currentTimeMillis();
    Iterator localIterator = this.CCW.values().iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).onForeground();
    }
    ak("foreground", com.tencent.mm.plugin.webview.luggage.j.d(this), null);
    this.CDd = false;
    AppMethodBeat.o(83189);
  }
  
  public final void reload()
  {
    AppMethodBeat.i(83192);
    super.reload();
    this.CDa = false;
    ewW().QLh = false;
    if (this.CDb != null)
    {
      f localf = this.CDb;
      String str = localf.b(localf.CCf);
      if (!Util.isNullOrNil(str))
      {
        localf.CCb.remove(str);
        localf.eB(str, 1);
      }
    }
    AppMethodBeat.o(83192);
  }
  
  public void sg(boolean paramBoolean)
  {
    AppMethodBeat.i(83193);
    super.sg(paramBoolean);
    if (QT())
    {
      this.CCR = this.mParams.getString("game_hv_menu_appid");
      if (!Util.isNullOrNil(this.CCR))
      {
        if (this.CCM == null)
        {
          this.CCM = new GameMenuImageButton(getContext());
          this.CCM.a(this.mRootView, new GameMenuImageButton.a()
          {
            public final void dLs()
            {
              AppMethodBeat.i(231918);
              i.this.bXF();
              AppMethodBeat.o(231918);
            }
          });
        }
        this.PPD.setVisibility(8);
        AppMethodBeat.o(83193);
        return;
      }
      this.PPD.setVisibility(0);
    }
    AppMethodBeat.o(83193);
  }
  
  public static abstract interface a
  {
    public abstract void ewM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.g.i
 * JD-Core Version:    0.7.0.1
 */