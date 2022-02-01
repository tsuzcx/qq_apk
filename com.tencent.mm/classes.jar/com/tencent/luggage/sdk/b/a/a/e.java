package com.tencent.luggage.sdk.b.a.a;

import com.tencent.mars.cdn.AndroidCertVerifyResult;
import com.tencent.mars.cdn.X509Util;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.ac.l;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.m;
import com.tencent.mm.plugin.appbrand.m.m.a;
import com.tencent.mm.plugin.appbrand.m.q;
import com.tencent.mm.plugin.appbrand.m.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.websocket.libwcwss.WcwssNative;
import com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssReportListener;
import com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssWebSocketListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import javax.net.ssl.X509TrustManager;

public class e
{
  private String cyV;
  private int cyW;
  private com.tencent.mm.plugin.appbrand.s.a cyX;
  private boolean cyY;
  private WcwssNative cyZ;
  private String cyy;
  private boolean cyz;
  private final a cza;
  private X509TrustManager mTrustManager;
  
  public e()
  {
    AppMethodBeat.i(146775);
    this.cyV = null;
    this.cyW = -1;
    this.cyX = null;
    this.mTrustManager = null;
    this.cyY = false;
    this.cyz = true;
    this.cyy = null;
    this.cza = new a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146772);
        synchronized (e.this)
        {
          if (e.a(e.this) != null)
          {
            Log.i("Luggage.WcWssNativeInstallHelper", "destroyTask destroyWcWssBinding mContextId:%s", new Object[] { e.d(e.this) });
            e.a(e.this).destoryWcwss();
            e.a(e.this, null);
            AppMethodBeat.o(146772);
            return;
          }
          Log.e("Luggage.WcWssNativeInstallHelper", "destroyTask mWcwssNative is null");
        }
      }
    });
    AppMethodBeat.o(146775);
  }
  
  public static int a(String paramString, byte[][] paramArrayOfByte, X509TrustManager paramX509TrustManager)
  {
    AppMethodBeat.i(146781);
    Log.i("Luggage.WcWssNativeInstallHelper", "certifivate verify for ".concat(String.valueOf(paramString)));
    try
    {
      AndroidCertVerifyResult localAndroidCertVerifyResult2 = X509Util.verifyServerCertificates(paramArrayOfByte, "RSA", paramString, 1, paramX509TrustManager);
      Log.i("Luggage.WcWssNativeInstallHelper", "host %s rsa verify result %d, isknownroots %b, ishostmatched %b", new Object[] { paramString, Integer.valueOf(localAndroidCertVerifyResult2.getStatus()), Boolean.valueOf(localAndroidCertVerifyResult2.isIssuedByKnownRoot()), Boolean.valueOf(localAndroidCertVerifyResult2.isIssuedByHostMatched()) });
      AndroidCertVerifyResult localAndroidCertVerifyResult1 = localAndroidCertVerifyResult2;
      if (localAndroidCertVerifyResult2.getStatus() != 0)
      {
        localAndroidCertVerifyResult1 = X509Util.verifyServerCertificates(paramArrayOfByte, "ECDSA", paramString, 1, paramX509TrustManager);
        Log.i("Luggage.WcWssNativeInstallHelper", "host %s ecdsa verify result %d, isknownroots %b, ishostmatched %b", new Object[] { paramString, Integer.valueOf(localAndroidCertVerifyResult1.getStatus()), Boolean.valueOf(localAndroidCertVerifyResult1.isIssuedByKnownRoot()), Boolean.valueOf(localAndroidCertVerifyResult1.isIssuedByHostMatched()) });
      }
      if (localAndroidCertVerifyResult1.getStatus() != 0) {
        ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(972L, 7L, 1L, false);
      }
      if ((localAndroidCertVerifyResult1.getStatus() == 0) && (!localAndroidCertVerifyResult1.isIssuedByHostMatched())) {
        ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(972L, 8L, 1L, false);
      }
      if ((localAndroidCertVerifyResult1.getStatus() == 0) && (!localAndroidCertVerifyResult1.isIssuedByKnownRoot())) {
        ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(972L, 9L, 1L, false);
      }
      if ((localAndroidCertVerifyResult1.getStatus() == 0) && (localAndroidCertVerifyResult1.isIssuedByKnownRoot()))
      {
        AppMethodBeat.o(146781);
        return 0;
      }
      AppMethodBeat.o(146781);
      return -1;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("Luggage.WcWssNativeInstallHelper", paramString, "doCertificateVerify Exception", new Object[0]);
      AppMethodBeat.o(146781);
    }
    return -1;
  }
  
  public static int getStatisticsNetType()
  {
    AppMethodBeat.i(146780);
    try
    {
      int i = NetStatusUtil.getNetType(MMApplicationContext.getContext());
      Log.i("Luggage.WcWssNativeInstallHelper", "getStatisticsNetType ret:%d", new Object[] { Integer.valueOf(i) });
      if (i == -1)
      {
        AppMethodBeat.o(146780);
        return -1;
      }
      boolean bool = NetStatusUtil.is2G(MMApplicationContext.getContext());
      if (bool)
      {
        AppMethodBeat.o(146780);
        return 3;
      }
      bool = NetStatusUtil.is3G(MMApplicationContext.getContext());
      if (bool)
      {
        AppMethodBeat.o(146780);
        return 4;
      }
      bool = NetStatusUtil.is4G(MMApplicationContext.getContext());
      if (bool)
      {
        AppMethodBeat.o(146780);
        return 5;
      }
      bool = NetStatusUtil.isWifi(i);
      if (bool)
      {
        AppMethodBeat.o(146780);
        return 1;
      }
      bool = NetStatusUtil.isWap(i);
      if (bool)
      {
        AppMethodBeat.o(146780);
        return 2;
      }
      AppMethodBeat.o(146780);
      return 6;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("Luggage.WcWssNativeInstallHelper", localException, "getStatisticsNetType_", new Object[0]);
      AppMethodBeat.o(146780);
    }
    return -1;
  }
  
  public final void a(final i parami, final com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt)
  {
    AppMethodBeat.i(146777);
    Log.i("Luggage.WcWssNativeInstallHelper", "createWcWssBinding");
    Object localObject1 = (b)parame.K(b.class);
    if (localObject1 != null) {
      this.cyY = ((b)localObject1).isOpen();
    }
    if (!this.cyY)
    {
      Log.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding xSwitch false");
      AppMethodBeat.o(146777);
      return;
    }
    if (parami == null)
    {
      Log.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding jsruntime is null");
      AppMethodBeat.o(146777);
      return;
    }
    this.cyy = String.valueOf(paramInt);
    e.class.getClassLoader();
    com.tencent.mm.compatible.util.j.KW("owl");
    e.class.getClassLoader();
    com.tencent.mm.compatible.util.j.KW("wcwss");
    com.tencent.mm.websocket.libwcwss.a.loadLibraries();
    localObject1 = (q)parami.Q(q.class);
    if (localObject1 == null)
    {
      Log.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding jsThreadHandler is null");
      AppMethodBeat.o(146777);
      return;
    }
    final WeakReference localWeakReference = new WeakReference(localObject1);
    Object localObject2 = (b)parame.K(b.class);
    if (localObject2 != null)
    {
      this.cyz = ((b)localObject2).QY();
      Log.i("Luggage.WcWssNativeInstallHelper", "createWcWssBinding xLibUVSwitch:%b ", new Object[] { Boolean.valueOf(this.cyz) });
    }
    localObject2 = f.a(new WcwssNative.IWcWssReportListener()
    {
      public final int getNetworkType()
      {
        AppMethodBeat.i(146765);
        int i = e.getStatisticsNetType();
        AppMethodBeat.o(146765);
        return i;
      }
      
      public final void onIdKeyStat(int[] paramAnonymousArrayOfInt1, int[] paramAnonymousArrayOfInt2, int[] paramAnonymousArrayOfInt3)
      {
        AppMethodBeat.i(146767);
        Log.d("Luggage.WcWssNativeInstallHelper", "MMWcWss onIdKeyStat");
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < paramAnonymousArrayOfInt1.length)
        {
          localArrayList.add(new IDKey(paramAnonymousArrayOfInt1[i], paramAnonymousArrayOfInt2[i], paramAnonymousArrayOfInt3[i]));
          i += 1;
        }
        ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).b(localArrayList, false);
        AppMethodBeat.o(146767);
      }
      
      public final void onKvStat(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(146766);
        Log.d("Luggage.WcWssNativeInstallHelper", "MMWcWss onKvStat logId:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        ((com.tencent.mm.plugin.appbrand.w.b)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.b.class)).kvStat(paramAnonymousInt, paramAnonymousString);
        AppMethodBeat.o(146766);
      }
    }, (m)parami.Q(m.class));
    ((q)localObject1).post(new Runnable()
    {
      public final int doCertificateVerify(String paramAnonymousString1, long paramAnonymousLong, String paramAnonymousString2, byte[][] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(146770);
        if ((e.b(e.this) == null) || (e.c(e.this) == null))
        {
          e.a(e.this, (com.tencent.mm.plugin.appbrand.s.a)parame.au(com.tencent.mm.plugin.appbrand.s.a.class));
          if (e.b(e.this) == null) {
            break label116;
          }
          e.a(e.this, com.tencent.mm.plugin.appbrand.s.j.b(e.b(e.this)));
          if (e.c(e.this) == null) {
            Log.e("Luggage.WcWssNativeInstallHelper", "MMWcWss doCertificateVerify getTrustManager fail");
          }
        }
        for (;;)
        {
          int i = e.a(paramAnonymousString2, paramAnonymousArrayOfByte, e.c(e.this));
          AppMethodBeat.o(146770);
          return i;
          label116:
          Log.e("Luggage.WcWssNativeInstallHelper", "MMWcWss doCertificateVerify getConfig fail");
        }
      }
      
      public final void onStateChange(final String paramAnonymousString, final long paramAnonymousLong, int paramAnonymousInt)
      {
        AppMethodBeat.i(146769);
        ((q)localWeakReference.get()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(146768);
            Log.d("Luggage.WcWssNativeInstallHelper", "MMWcWss jsThreadHandler run onCallBack contextId:%s", new Object[] { paramAnonymousString });
            e.a(e.this).updateInterface(paramAnonymousLong, this.cl);
            AppMethodBeat.o(146768);
          }
        });
        AppMethodBeat.o(146769);
      }
    }
    {
      public final void run()
      {
        AppMethodBeat.i(146771);
        Log.i("Luggage.WcWssNativeInstallHelper", "createWcWssBinding setCallback ");
        if (e.d(e.this) != null)
        {
          Log.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding mContextId != null");
          AppMethodBeat.o(146771);
          return;
        }
        v localv = (v)parami.Q(v.class);
        if (localv == null)
        {
          Log.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding v8Addon is null");
          AppMethodBeat.o(146771);
          return;
        }
        e.a(e.this, new WcwssNative());
        if (e.a(e.this) != null)
        {
          if (e.e(e.this)) {
            e.a(e.this, e.a(e.this).initWcwss(localv.getIsolatePtr(), localv.acn(), 0L));
          }
          for (;;)
          {
            e.a(e.this, e.a(e.this).setCallback(this.czf, this.czg));
            Log.i("Luggage.WcWssNativeInstallHelper", "createWcWssBinding setCallback mContextId:%s,mInitCallBack:%d", new Object[] { e.d(e.this), Integer.valueOf(e.f(e.this)) });
            AppMethodBeat.o(146771);
            return;
            e.a(e.this, e.a(e.this).initWcwss(localv.getIsolatePtr(), localv.acn(), 0L));
          }
        }
        Log.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding mWcwssNative = null");
        AppMethodBeat.o(146771);
      }
    });
    AppMethodBeat.o(146777);
  }
  
  public final void a(final i parami, final com.tencent.mm.plugin.appbrand.jsapi.j paramj)
  {
    AppMethodBeat.i(235629);
    Log.i("Luggage.WcWssNativeInstallHelper", "initConfigWcWss mContextId:%s", new Object[] { this.cyV });
    if (!this.cyY)
    {
      Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss xSwitch false");
      AppMethodBeat.o(235629);
      return;
    }
    if (parami == null)
    {
      Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss jsruntime is null");
      AppMethodBeat.o(235629);
      return;
    }
    parami = (q)parami.Q(q.class);
    if (parami == null)
    {
      Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss jsThreadHandler is null");
      AppMethodBeat.o(235629);
      return;
    }
    b localb = (b)paramj.K(b.class);
    if ((localb != null) && (localb.QZ())) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("Luggage.WcWssNativeInstallHelper", "initConfigWcWss appId:%s, closeWcWssSocketsWhenSuspend:%b", new Object[] { paramj.getAppId(), Boolean.valueOf(bool) });
      if (bool) {
        paramj.getRuntime().ntR.a(new c.a()
        {
          public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
          {
            AppMethodBeat.i(246893);
            if ((com.tencent.mm.plugin.appbrand.a.b.nKR == paramAnonymousb) && (e.a(e.this) != null)) {
              parami.a(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(244331);
                  if (e.a(e.this) != null) {
                    e.a(e.this).doOnRunningState();
                  }
                  AppMethodBeat.o(244331);
                }
              }, true);
            }
            AppMethodBeat.o(246893);
          }
        });
      }
      parami.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(234715);
          Log.i("Luggage.WcWssNativeInstallHelper", "initConfigWcWss initConfig mContextId:%s", new Object[] { e.d(e.this) });
          if (e.a(e.this) == null)
          {
            Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss mWcwssNative is null");
            AppMethodBeat.o(234715);
            return;
          }
          Object localObject = (com.tencent.mm.plugin.appbrand.s.a)paramj.au(com.tencent.mm.plugin.appbrand.s.a.class);
          if (localObject != null)
          {
            Log.i("Luggage.WcWssNativeInstallHelper", "wcwss mbzType:%s,,websocketTimeoutMS:%d,userAgentString :%s,referer:%s,mode:%d", new Object[] { e.g(e.this), Integer.valueOf(((com.tencent.mm.plugin.appbrand.s.a)localObject).qio), ((com.tencent.mm.plugin.appbrand.s.a)localObject).qiv, ((com.tencent.mm.plugin.appbrand.s.a)localObject).referer, Integer.valueOf(((com.tencent.mm.plugin.appbrand.s.a)localObject).mode) });
            HashMap localHashMap = new HashMap();
            localHashMap.put("referer", ((com.tencent.mm.plugin.appbrand.s.a)localObject).referer);
            localHashMap.put("User-Agent", ((com.tencent.mm.plugin.appbrand.s.a)localObject).qiv);
            localHashMap.put("bzType", e.g(e.this));
            localHashMap.put("mode", String.valueOf(((com.tencent.mm.plugin.appbrand.s.a)localObject).mode));
            localHashMap.put("timeout", String.valueOf(((com.tencent.mm.plugin.appbrand.s.a)localObject).qio));
            e.a(e.this).initConfig(localHashMap);
            if (((com.tencent.mm.plugin.appbrand.s.a)localObject).mode != 0)
            {
              if (((com.tencent.mm.plugin.appbrand.s.a)localObject).mode == 1)
              {
                if ((((com.tencent.mm.plugin.appbrand.s.a)localObject).qis == null) || (((com.tencent.mm.plugin.appbrand.s.a)localObject).qis.size() == 0)) {
                  Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss blacklistHeaders is null");
                }
                for (localObject = null;; localObject = ((com.tencent.mm.plugin.appbrand.s.a)localObject).qis)
                {
                  e.a(e.this).initConfigWhiteBlack(null, (ArrayList)localObject);
                  AppMethodBeat.o(234715);
                  return;
                }
              }
              if (((com.tencent.mm.plugin.appbrand.s.a)localObject).mode == 2)
              {
                if ((((com.tencent.mm.plugin.appbrand.s.a)localObject).qit == null) || (((com.tencent.mm.plugin.appbrand.s.a)localObject).qit.size() == 0)) {
                  Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss whitelistHeaders is null");
                }
                for (localObject = null;; localObject = ((com.tencent.mm.plugin.appbrand.s.a)localObject).qit)
                {
                  e.a(e.this).initConfigWhiteBlack((ArrayList)localObject, null);
                  AppMethodBeat.o(234715);
                  return;
                }
              }
              Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss invalid mode:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.s.a)localObject).mode) });
              AppMethodBeat.o(234715);
              return;
            }
            Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss invalid mode:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.s.a)localObject).mode) });
            AppMethodBeat.o(234715);
            return;
          }
          Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss networkConfig is null");
          AppMethodBeat.o(234715);
        }
      });
      AppMethodBeat.o(235629);
      return;
    }
  }
  
  public final void c(i parami)
  {
    AppMethodBeat.i(146778);
    Log.i("Luggage.WcWssNativeInstallHelper", "destroyWcWssBinding mContextId:%s", new Object[] { this.cyV });
    if (!this.cyY)
    {
      Log.e("Luggage.WcWssNativeInstallHelper", "destroyWcWssBinding xSwitch false");
      AppMethodBeat.o(146778);
      return;
    }
    if (parami == null)
    {
      Log.e("Luggage.WcWssNativeInstallHelper", "destroyWcWssBinding jsruntime is null");
      AppMethodBeat.o(146778);
      return;
    }
    ((m)parami.Q(m.class)).a(this.cza);
    AppMethodBeat.o(146778);
  }
  
  final class a
    extends l
    implements m.a
  {
    a(Runnable paramRunnable)
    {
      super();
    }
    
    public final void onDestroy()
    {
      AppMethodBeat.i(146774);
      run();
      AppMethodBeat.o(146774);
    }
  }
  
  public static abstract interface b
    extends com.tencent.luggage.a.b
  {
    public abstract boolean QZ();
    
    public abstract boolean isOpen();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.e
 * JD-Core Version:    0.7.0.1
 */