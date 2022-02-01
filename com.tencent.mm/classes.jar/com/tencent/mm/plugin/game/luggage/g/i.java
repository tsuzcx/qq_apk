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
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.game.protobuf.dv;
import com.tencent.mm.plugin.webview.luggage.ipc.ActiveMainProcessTask;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.plugin.webview.luggage.r;
import com.tencent.mm.plugin.webview.luggage.t;
import com.tencent.mm.plugin.webview.ui.tools.game.c;
import com.tencent.mm.plugin.webview.ui.tools.game.c.a;
import com.tencent.mm.plugin.webview.ui.tools.game.d.a;
import com.tencent.mm.plugin.webview.ui.tools.game.d.b;
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
import com.tencent.mm.ui.ao;
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
  implements com.tencent.mm.plugin.webview.ui.tools.game.e
{
  private View xyD;
  private GameMenuImageButton xyE;
  private boolean xyF;
  private boolean xyG;
  public boolean xyH;
  private boolean xyI;
  private String xyJ;
  public c xyK;
  private long xyL;
  public com.tencent.mm.plugin.webview.ui.tools.game.g xyM;
  public long xyN;
  private Map<String, b> xyO;
  private ViewGroup xyP;
  private boolean xyQ;
  private boolean xyR;
  private boolean xyS;
  public f xyT;
  public boolean xyU;
  private boolean xyV;
  public boolean xyW;
  private long xyX;
  private long xyY;
  private long xyZ;
  protected GameWebPerformanceInfo xyv;
  a xza;
  
  public i(com.tencent.luggage.d.j paramj, p paramp, Bundle paramBundle)
  {
    super(paramj, paramp, paramBundle);
    AppMethodBeat.i(83183);
    this.xyF = false;
    this.xyG = false;
    this.xyH = false;
    this.xyI = false;
    this.xyN = 0L;
    this.xyO = new HashMap();
    this.xyR = false;
    this.xyS = false;
    this.xyU = false;
    this.xyV = true;
    this.xyW = false;
    this.xyX = 0L;
    this.xyY = 0L;
    this.xyZ = 0L;
    this.xyK = new c()
    {
      public final void an(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(83172);
        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, paramAnonymousBundle, com.tencent.mm.plugin.game.luggage.h.a.class, null);
        AppMethodBeat.o(83172);
      }
    };
    Log.i("MicroMsg.GameWebPage", "initWebPageEnd, __Time__， time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    paramp = paramBundle.getString("rawUrl");
    this.xyv = GameWebPerformanceInfo.Fd(paramp);
    this.xyv.hhu = dTQ();
    this.xyv.hhN = System.currentTimeMillis();
    this.xyM = azK(paramp);
    paramj = this.mParams.getString("rawUrl");
    if (!Util.isNullOrNil(paramj))
    {
      paramBundle = Uri.parse(paramj);
      paramj = paramBundle.getQueryParameter("nav_color");
      if (ao.isDarkMode()) {
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
      if ((paramj != null) && (paramj.equals(WeChatHosts.domainString(2131761707)))) {
        this.ctS.ctB = com.tencent.luggage.d.a.a.ctX;
      }
      dTP().JLI = new com.tencent.mm.plugin.wepkg.event.b()
      {
        public final void dTT()
        {
          AppMethodBeat.i(186962);
          h localh = (h)i.this.ctS.LG();
          if (!Util.isNullOrNil(localh.xwe)) {
            localh.post(new h.3(localh));
          }
          AppMethodBeat.o(186962);
        }
        
        public final void dTU()
        {
          AppMethodBeat.i(186963);
          i.a(i.this, true);
          i.p(i.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(186960);
              i.o(i.this);
              AppMethodBeat.o(186960);
            }
          }, 500L);
          AppMethodBeat.o(186963);
        }
        
        public final void pL(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(186964);
          Log.i("MicroMsg.GameWebPage", "onPkgReady");
          i.s(i.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(186961);
              if (i.q(i.this))
              {
                i.a(i.this, false);
                if (!((Activity)i.this.mContext).isFinishing())
                {
                  i.r(i.this);
                  i.this.ctg.Ly().j(i.this.coX(), i.this.mParams);
                }
              }
              AppMethodBeat.o(186961);
            }
          });
          AppMethodBeat.o(186964);
        }
      };
      ((h)this.ctS.LG()).setRawUrl(paramp);
      this.ITd.addJavascriptInterface(new com.tencent.mm.plugin.game.luggage.i.d(com.tencent.mm.plugin.webview.luggage.j.d(this)), "WxGameJsCoreNative");
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rOe, false))
      {
        com.tencent.mm.plugin.game.luggage.i.a.create();
        aq("created", com.tencent.mm.plugin.webview.luggage.j.d(this), paramp);
      }
      AppMethodBeat.o(83183);
      return;
    }
    catch (IllegalArgumentException paramj)
    {
      break label239;
    }
  }
  
  private static void aq(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(186976);
    if (com.tencent.mm.plugin.game.luggage.i.a.dTW() != null) {
      com.tencent.mm.plugin.game.luggage.i.a.dTW().ar(paramString1, paramString2, paramString3);
    }
    AppMethodBeat.o(186976);
  }
  
  private static boolean azP(String paramString)
  {
    AppMethodBeat.i(186977);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(186977);
      return false;
    }
    try
    {
      new JSONObject(paramString);
      AppMethodBeat.o(186977);
      return true;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(186977);
    }
    return false;
  }
  
  public void D(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(180146);
    long l = System.currentTimeMillis();
    Log.i("MicroMsg.GameWebPage", "onReceivedError, errorCode: %d, description: %s, failingUrl: %s , time: %d", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, Long.valueOf(l) });
    super.D(paramInt, paramString1, paramString2);
    try
    {
      paramString1 = new JSONObject();
      paramString1.put("errcode", paramInt);
      paramString1.put("errurl", paramString2);
      com.tencent.mm.game.report.api.a.hhr.a(8, URLEncoder.encode(coX()), URLEncoder.encode(paramString1.toString()), l - this.xyM.JqU);
      AppMethodBeat.o(180146);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(180146);
    }
  }
  
  public final void LM()
  {
    AppMethodBeat.i(186971);
    if (this.mIsForeground) {
      this.xyY += System.currentTimeMillis() - this.xyZ;
    }
    at(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83174);
        i.d(i.this);
        AppMethodBeat.o(83174);
      }
    });
    AppMethodBeat.o(186971);
  }
  
  public View Lf()
  {
    AppMethodBeat.i(83184);
    View localView = super.Lf();
    this.xyD = LayoutInflater.from(this.mContext).inflate(2131494905, this.ITm, false);
    this.xyD.setVisibility(8);
    this.ITm.addView(this.xyD, new FrameLayout.LayoutParams(-2, -2, 17));
    Log.i("MicroMsg.GameWebPage", "create vie end, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    AppMethodBeat.o(83184);
    return localView;
  }
  
  public final boolean Oc(int paramInt)
  {
    AppMethodBeat.i(83207);
    if (this.ctS.LC() == com.tencent.luggage.d.a.a.ctX)
    {
      AppMethodBeat.o(83207);
      return true;
    }
    if (this.ctS.LC() == com.tencent.luggage.d.a.a.ctY)
    {
      AppMethodBeat.o(83207);
      return false;
    }
    boolean bool = super.Oc(paramInt);
    AppMethodBeat.o(83207);
    return bool;
  }
  
  public final void at(final Runnable paramRunnable)
  {
    AppMethodBeat.i(186972);
    if (!this.xyW)
    {
      this.xyW = true;
      this.ITd.evaluateJavascript("window.performance.getEntriesByName('first-contentful-paint')[0].startTime", new ValueCallback() {});
      AppMethodBeat.o(186972);
      return;
    }
    if (paramRunnable != null) {
      paramRunnable.run();
    }
    AppMethodBeat.o(186972);
  }
  
  public final boolean azJ(String paramString)
  {
    AppMethodBeat.i(83195);
    boolean bool = ((h)this.ITd).azJ(paramString);
    AppMethodBeat.o(83195);
    return bool;
  }
  
  protected com.tencent.mm.plugin.webview.ui.tools.game.g azK(String paramString)
  {
    AppMethodBeat.i(83186);
    paramString = com.tencent.mm.plugin.webview.ui.tools.game.g.baK(paramString);
    AppMethodBeat.o(83186);
    return paramString;
  }
  
  public boolean azL(String paramString)
  {
    AppMethodBeat.i(83187);
    if ((paramString.equals(coX())) && (this.xyv.hhS == 0L))
    {
      this.xyv.hhS = System.currentTimeMillis();
      Log.i("MicroMsg.GameWebPage", "startGetA8Key, url: %s, time: %d", new Object[] { paramString, Long.valueOf(this.xyv.hhS) });
    }
    boolean bool = super.azL(paramString);
    AppMethodBeat.o(83187);
    return bool;
  }
  
  public final void azM(String paramString)
  {
    AppMethodBeat.i(83199);
    super.azM(paramString);
    if (this.xyv.hhP == 0L) {
      this.xyv.hhP = System.currentTimeMillis();
    }
    AppMethodBeat.o(83199);
  }
  
  public final WebResourceResponse azN(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(186973);
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
      if ((i == 0) && (!this.xyS))
      {
        this.xyS = true;
        if (this.xza != null) {
          this.xza.dTD();
        }
        this.mHandler.postUI(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(186965);
            if (i.this.gbC() != null)
            {
              str1 = String.format("javascript:(function(){ window.wgclient = window.wgclient || {}; window.wgclient.__gameTopBarHeight__= %d; })()", new Object[] { Integer.valueOf(com.tencent.mm.plugin.appbrand.ac.g.zB(i.this.gbC().getTopBarHeight())) });
              Log.i("MicroMsg.GameWebPage", "gameTopHeight:%s", new Object[] { str1 });
              i.this.cT(str1);
            }
            String str1 = i.this.dTC();
            if (i.azQ(str1))
            {
              String str2 = String.format("javascript:(function(){ window.wgclient = window.wgclient || {}; window.wgclient.__gamePreInjectData__= %s; })()", new Object[] { str1 });
              Log.i("MicroMsg.GameWebPage", "preInjectData, size:%d", new Object[] { Integer.valueOf(str1.getBytes().length) });
              i.this.cT(str2);
            }
            AppMethodBeat.o(186965);
          }
        });
      }
      paramString = super.azN(paramString);
      AppMethodBeat.o(186973);
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
  
  public final void azO(String paramString)
  {
    AppMethodBeat.i(83202);
    super.azO(paramString);
    if (this.xyM.JqY == 0L) {
      this.xyM.JqY = System.currentTimeMillis();
    }
    AppMethodBeat.o(83202);
  }
  
  public void c(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(83203);
    super.c(paramString1, paramString2, paramMap);
    h localh = (h)this.ctS.LG();
    localh.xwe = paramString2;
    localh.xyn = paramMap;
    if (Util.isNullOrNil(paramString2)) {
      Log.i("MicroMsg.LuggageGameUinKeyHolder", "setFullUrlAndHeaders, fullUrl is null");
    }
    for (;;)
    {
      long l = System.currentTimeMillis();
      if (paramString1.equals(coX()))
      {
        Log.i("MicroMsg.GameWebPage", "getA8Key end, __Time__, time: %d", new Object[] { Long.valueOf(l) });
        this.xyv.hhT = l;
      }
      if (this.xyv.hhP == 0L) {
        this.xyv.hhP = l;
      }
      if (this.xyM.JqZ == 0L) {
        this.xyM.JqZ = System.currentTimeMillis();
      }
      com.tencent.mm.plugin.game.luggage.g.a(this.ITd, paramString2, paramMap);
      com.tencent.mm.plugin.game.luggage.g.b(this.ctS, paramString2);
      this.xyH = true;
      AppMethodBeat.o(83203);
      return;
      if (!Uri.parse(paramString2).getHost().equals(WeChatHosts.domainString(2131761707)))
      {
        Log.i("MicroMsg.LuggageGameUinKeyHolder", "setFullUrlAndHeaders, host is not wxgame");
      }
      else
      {
        com.tencent.mm.plugin.game.luggage.e.xwe = paramString2;
        com.tencent.mm.plugin.game.luggage.e.mHeaders = paramMap;
        com.tencent.mm.plugin.game.luggage.e.Nh = System.currentTimeMillis() / 1000L;
      }
    }
  }
  
  public final void cV(String paramString)
  {
    AppMethodBeat.i(83200);
    long l = System.currentTimeMillis();
    Log.i("MicroMsg.GameWebPage", "onUrlLoadingStarted, url = %s, __Time__, time = %d", new Object[] { paramString, Long.valueOf(l) });
    super.cV(paramString);
    if (this.xyv.hhQ == 0L) {
      this.xyv.hhQ = l;
    }
    if (this.xyM.JqW == 0L) {
      this.xyM.JqW = l;
    }
    paramString = Util.getHost(paramString);
    if ((paramString != null) && (paramString.equals(WeChatHosts.domainString(2131761707)))) {}
    for (this.ctS.ctB = com.tencent.luggage.d.a.a.ctX;; this.ctS.ctB = this.ITx)
    {
      this.xyK.Jqh.ghf();
      AppMethodBeat.o(83200);
      return;
    }
  }
  
  public void cW(String paramString)
  {
    AppMethodBeat.i(83201);
    long l = System.currentTimeMillis();
    Log.i("MicroMsg.GameWebPage", "onUrlLoadingFinished, url = %s, __Time__, time = %d", new Object[] { paramString, Long.valueOf(l) });
    super.cW(paramString);
    if (this.xyv.hhR == 0L) {
      this.xyv.hhR = l;
    }
    if (this.xyM.JqX == 0L) {
      this.xyM.JqX = l;
    }
    try
    {
      if (!this.xyF)
      {
        this.xyF = true;
        com.tencent.mm.game.report.api.a.hhr.a(7, URLEncoder.encode(coX()), "", l - this.xyM.JqU);
      }
      label117:
      com.tencent.mm.plugin.game.luggage.g.b(this.ctS, this.xwe);
      this.xyK.Jqh.LZ();
      AppMethodBeat.o(83201);
      return;
    }
    catch (Exception paramString)
    {
      break label117;
    }
  }
  
  public void dTA()
  {
    AppMethodBeat.i(83196);
    aC(new Runnable()
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
  
  protected String dTC()
  {
    AppMethodBeat.i(186978);
    String str = this.mParams.getString("game_pre_inject_data");
    AppMethodBeat.o(186978);
    return str;
  }
  
  public final void dTH()
  {
    AppMethodBeat.i(83188);
    this.ISN.dTH();
    AppMethodBeat.o(83188);
  }
  
  public final View dTM()
  {
    AppMethodBeat.i(83185);
    this.ISN = new g(this);
    m localm = this.ISN;
    AppMethodBeat.o(83185);
    return localm;
  }
  
  public final void dTN()
  {
    boolean bool = true;
    AppMethodBeat.i(83194);
    Object localObject;
    if (!this.ITA)
    {
      this.ITB = this.mParams.getInt("customize_status_bar_color");
      if (this.ITB == 0)
      {
        localObject = com.tencent.mm.plugin.game.commlib.a.dSU();
        if ((localObject == null) || (Util.isNullOrNil(((dv)localObject).ixw)) || (Util.isNullOrNil(((dv)localObject).xNo))) {}
      }
    }
    try
    {
      if (ao.isDarkMode()) {}
      for (this.ITB = Color.parseColor(((dv)localObject).xNo);; this.ITB = Color.parseColor(((dv)localObject).ixw))
      {
        if (this.ITB == 0) {
          this.ITB = android.support.v4.content.b.n(this.mContext, 2131099891);
        }
        if (!this.xyI)
        {
          this.xyI = true;
          gbA();
        }
        localObject = this.ISN;
        if (((m)localObject).IUx != null)
        {
          com.tencent.mm.ui.statusbar.b localb = ((m)localObject).IUh;
          int i = ((m)localObject).IUx.intValue();
          if (((m)localObject).IUy) {
            break;
          }
          com.tencent.mm.ui.statusbar.a.e(localb, i, bool);
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
  
  public final void dTO()
  {
    AppMethodBeat.i(83197);
    this.xyD.setVisibility(8);
    AppMethodBeat.o(83197);
  }
  
  public final com.tencent.mm.plugin.wepkg.e dTP()
  {
    AppMethodBeat.i(83205);
    com.tencent.mm.plugin.wepkg.e locale = ((h)this.ITd).getWePkgPlugin();
    AppMethodBeat.o(83205);
    return locale;
  }
  
  public final String dTQ()
  {
    AppMethodBeat.i(83206);
    String str = (hashCode() & 0x7FFFFFFF) + "_" + (coX().hashCode() & 0x7FFFFFFF);
    AppMethodBeat.o(83206);
    return str;
  }
  
  public final Map<Integer, Object> dTR()
  {
    AppMethodBeat.i(186974);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(d.a.Jqn), dTQ());
    localHashMap.put(Integer.valueOf(d.a.Jqo), NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext()));
    localHashMap.put(Integer.valueOf(d.a.Jqp), String.valueOf(YearClass.get(MMApplicationContext.getContext())));
    String str = coX();
    try
    {
      localHashMap.put(Integer.valueOf(d.a.Jqq), q.encode(Util.nullAsNil(str), "UTF-8"));
      label94:
      int j = d.a.Jqr;
      int i;
      if (azJ(str))
      {
        i = 1;
        localHashMap.put(Integer.valueOf(j), Integer.valueOf(i));
        localHashMap.put(Integer.valueOf(d.a.Jqs), Integer.valueOf(1));
        if (!(this instanceof j)) {
          break label211;
        }
        localHashMap.put(Integer.valueOf(d.a.Jqt), Integer.valueOf(1));
      }
      for (;;)
      {
        localHashMap.put(Integer.valueOf(d.a.Jqu), dTP().gkx());
        i = d.a.Jqv;
        dTP();
        localHashMap.put(Integer.valueOf(i), com.tencent.mm.plugin.wepkg.e.gky());
        AppMethodBeat.o(186974);
        return localHashMap;
        i = 0;
        break;
        label211:
        localHashMap.put(Integer.valueOf(d.a.Jqt), Integer.valueOf(0));
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label94;
    }
  }
  
  public final Map<Integer, Object> dTS()
  {
    int j = 1;
    AppMethodBeat.i(186975);
    HashMap localHashMap = new HashMap();
    com.tencent.mm.plugin.webview.ui.tools.game.g localg = com.tencent.mm.plugin.webview.ui.tools.game.g.baL(coX());
    if (localg != null)
    {
      localHashMap.put(Integer.valueOf(d.b.Jqy), Long.valueOf(localg.JqV - localg.startTime));
      localHashMap.put(Integer.valueOf(d.b.Jqz), Long.valueOf(localg.JqW - localg.startTime));
      localHashMap.put(Integer.valueOf(d.b.JqA), Long.valueOf(localg.JqX - localg.JqW));
      localHashMap.put(Integer.valueOf(d.b.JqB), Long.valueOf(localg.JqZ - localg.JqY));
      localHashMap.put(Integer.valueOf(d.b.JqC), Long.valueOf(localg.Jrb - localg.Jra));
      localHashMap.put(Integer.valueOf(d.b.JqK), Long.valueOf(localg.Jrc));
      localHashMap.put(Integer.valueOf(d.b.JqM), Long.valueOf(localg.Jrd));
      localHashMap.put(Integer.valueOf(d.b.JqD), Long.valueOf(localg.Jre));
      localHashMap.put(Integer.valueOf(d.b.JqE), Long.valueOf(localg.Jrf));
      localHashMap.put(Integer.valueOf(d.b.JqF), Long.valueOf(localg.nOC));
      localHashMap.put(Integer.valueOf(d.b.JqG), Long.valueOf(localg.Jrg));
      localHashMap.put(Integer.valueOf(d.b.JqH), Long.valueOf(localg.Jrh));
      localHashMap.put(Integer.valueOf(d.b.JqI), Long.valueOf(localg.Jri));
      localHashMap.put(Integer.valueOf(d.b.JqJ), Long.valueOf(localg.Jrj));
      localHashMap.put(Integer.valueOf(d.b.JqN), Long.valueOf(System.currentTimeMillis()));
      localHashMap.put(Integer.valueOf(d.b.JqO), Long.valueOf(localg.Jrk));
    }
    int k = d.b.JqL;
    if (Util.isNullOrNil(dTP().gkv()))
    {
      i = 0;
      localHashMap.put(Integer.valueOf(k), Integer.valueOf(i));
      k = d.b.JqP;
      if (!this.xyV) {
        break label518;
      }
      i = 1;
      label425:
      localHashMap.put(Integer.valueOf(k), Integer.valueOf(i));
      k = d.b.JqQ;
      if (!this.xyU) {
        break label523;
      }
    }
    label518:
    label523:
    for (int i = j;; i = 0)
    {
      localHashMap.put(Integer.valueOf(k), Integer.valueOf(i));
      localHashMap.put(Integer.valueOf(d.b.JqR), Long.valueOf(this.xyX));
      localHashMap.put(Integer.valueOf(d.b.JqS), Long.valueOf(this.xyY));
      AppMethodBeat.o(186975);
      return localHashMap;
      i = 1;
      break;
      i = 0;
      break label425;
    }
  }
  
  public void g(final String paramString, final Bundle paramBundle)
  {
    AppMethodBeat.i(83198);
    Log.i("MicroMsg.GameWebPage", "load url, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (this.xyM.JqV == 0L) {
      this.xyM.JqV = System.currentTimeMillis();
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
    if (AppBrandMainProcessService.isLive())
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
        localPBool.bDK();
        synchronized (paramBundle)
        {
          if (paramBundle.value)
          {
            AppMethodBeat.o(83182);
            return;
          }
          paramBundle.value = true;
          paramString.run();
          com.tencent.mm.plugin.wepkg.utils.a.b("ipcServiceStartTime", this.val$url, com.tencent.mm.plugin.wepkg.utils.d.bcO(this.val$url), null, 0L, l1 - l2, null);
          AppMethodBeat.o(83182);
          return;
        }
      }
    };
    localActiveMainProcessTask.bDJ();
    AppBrandMainProcessService.a(localActiveMainProcessTask);
    com.tencent.f.h.RTc.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186957);
        synchronized (localPBool)
        {
          if (localPBool.value)
          {
            AppMethodBeat.o(186957);
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
          AppMethodBeat.o(186957);
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
    at(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186966);
        i.c(i.this);
        AppMethodBeat.o(186966);
      }
    });
    AppMethodBeat.o(83190);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(83191);
    Log.i("MicroMsg.GameWebPage", "onDestroy, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    super.onDestroy();
    c.a(this.xyK.Jqh.Jqi);
    Object localObject = this.xyv;
    ((GameWebPerformanceInfo)localObject).hhU += System.currentTimeMillis() - this.xyL;
    this.xyv.hhV = System.currentTimeMillis();
    if (!this.mParams.getBoolean("from_bag", false))
    {
      localObject = com.tencent.mm.game.report.api.a.hhr;
      if (localObject != null) {
        ((com.tencent.mm.game.report.api.a)localObject).a(this.xyv);
      }
      if (!this.xyR) {
        com.tencent.mm.plugin.webview.ui.tools.game.d.a(dTQ(), this);
      }
    }
    for (;;)
    {
      try
      {
        if (!this.xyG)
        {
          this.xyG = true;
          localObject = new JSONObject();
          if (this.xyN != 0L) {
            continue;
          }
          ((JSONObject)localObject).put("render_duration", 0);
          com.tencent.mm.game.report.api.a.hhr.a(9, URLEncoder.encode(coX()), URLEncoder.encode(((JSONObject)localObject).toString()), System.currentTimeMillis() - this.xyM.JqU);
        }
      }
      catch (Exception localException)
      {
        continue;
        if (!this.ITq.eqW()) {
          continue;
        }
        r.aYw(this.ITq.bjl());
        aq("destroyed", com.tencent.mm.plugin.webview.luggage.j.d(this), null);
        AppMethodBeat.o(83191);
      }
      GameWebPerformanceInfo.Ff(coX());
      if (!this.xyR) {
        com.tencent.mm.plugin.webview.ui.tools.game.g.baM(coX());
      }
      localObject = this.xyO.values();
      if ((localObject == null) || (((Collection)localObject).size() <= 0)) {
        continue;
      }
      localObject = ((Collection)localObject).iterator();
      if (!((Iterator)localObject).hasNext()) {
        continue;
      }
      ((b)((Iterator)localObject).next()).onDestroy();
      continue;
      ((JSONObject)localObject).put("render_duration", this.xyN - this.xyM.JqU);
    }
  }
  
  public void onForeground()
  {
    AppMethodBeat.i(83189);
    Log.i("MicroMsg.GameWebPage", "onForeground, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (this.xyv.hhL == 0L) {
      this.xyv.hhL = System.currentTimeMillis();
    }
    this.xyL = System.currentTimeMillis();
    this.xyK.Jqh.onResume();
    super.onForeground();
    this.xyZ = System.currentTimeMillis();
    Iterator localIterator = this.xyO.values().iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).onForeground();
    }
    aq("foreground", com.tencent.mm.plugin.webview.luggage.j.d(this), null);
    this.xyV = false;
    AppMethodBeat.o(83189);
  }
  
  public void pJ(boolean paramBoolean)
  {
    AppMethodBeat.i(83193);
    super.pJ(paramBoolean);
    if (isFullScreen())
    {
      this.xyJ = this.mParams.getString("game_hv_menu_appid");
      if (!Util.isNullOrNil(this.xyJ))
      {
        if (this.xyE == null)
        {
          this.xyE = new GameMenuImageButton(this.mContext);
          this.xyE.a(this.mRootView, new GameMenuImageButton.a()
          {
            public final void dlk()
            {
              AppMethodBeat.i(186970);
              i.this.dTH();
              AppMethodBeat.o(186970);
            }
          });
        }
        this.ITl.setVisibility(8);
        AppMethodBeat.o(83193);
        return;
      }
      this.ITl.setVisibility(0);
    }
    AppMethodBeat.o(83193);
  }
  
  public final void reload()
  {
    AppMethodBeat.i(83192);
    super.reload();
    this.xyS = false;
    dTP().JLO = false;
    if (this.xyT != null)
    {
      f localf = this.xyT;
      String str = localf.b(localf.xxV);
      if (!Util.isNullOrNil(str))
      {
        localf.xxR.remove(str);
        localf.ed(str, 1);
      }
    }
    AppMethodBeat.o(83192);
  }
  
  public static abstract interface a
  {
    public abstract void dTD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.g.i
 * JD-Core Version:    0.7.0.1
 */