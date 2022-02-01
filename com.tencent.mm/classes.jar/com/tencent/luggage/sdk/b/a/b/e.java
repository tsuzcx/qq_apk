package com.tencent.luggage.sdk.b.a.b;

import com.tencent.mars.cdn.AndroidCertVerifyResult;
import com.tencent.mars.cdn.X509Util;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.af.n;
import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.n.m;
import com.tencent.mm.plugin.appbrand.n.m.a;
import com.tencent.mm.plugin.appbrand.n.q;
import com.tencent.mm.plugin.appbrand.n.v;
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
  private String eqY;
  private boolean eqZ;
  private final a erA;
  private String erv;
  private int erw;
  private com.tencent.mm.plugin.appbrand.t.a erx;
  private boolean ery;
  private WcwssNative erz;
  private X509TrustManager mTrustManager;
  
  public e()
  {
    AppMethodBeat.i(146775);
    this.erv = null;
    this.erw = -1;
    this.erx = null;
    this.mTrustManager = null;
    this.ery = false;
    this.eqZ = true;
    this.eqY = null;
    this.erA = new a(new Runnable()
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
        ((com.tencent.mm.plugin.appbrand.x.a)com.tencent.luggage.a.e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(972L, 7L, 1L, false);
      }
      if ((localAndroidCertVerifyResult1.getStatus() == 0) && (!localAndroidCertVerifyResult1.isIssuedByHostMatched())) {
        ((com.tencent.mm.plugin.appbrand.x.a)com.tencent.luggage.a.e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(972L, 8L, 1L, false);
      }
      if ((localAndroidCertVerifyResult1.getStatus() == 0) && (!localAndroidCertVerifyResult1.isIssuedByKnownRoot())) {
        ((com.tencent.mm.plugin.appbrand.x.a)com.tencent.luggage.a.e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(972L, 9L, 1L, false);
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
  
  public final void a(final com.tencent.mm.plugin.appbrand.n.i parami, final com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt)
  {
    AppMethodBeat.i(146777);
    Log.i("Luggage.WcWssNativeInstallHelper", "createWcWssBinding");
    Object localObject1 = (b)paramf.T(b.class);
    if (localObject1 != null) {
      this.ery = ((b)localObject1).isOpen();
    }
    if (!this.ery)
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
    this.eqY = String.valueOf(paramInt);
    e.class.getClassLoader();
    com.tencent.mm.compatible.util.k.DA("owl");
    e.class.getClassLoader();
    com.tencent.mm.compatible.util.k.DA("wcwss");
    com.tencent.mm.websocket.libwcwss.a.loadLibraries();
    localObject1 = (q)parami.Z(q.class);
    if (localObject1 == null)
    {
      Log.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding jsThreadHandler is null");
      AppMethodBeat.o(146777);
      return;
    }
    final WeakReference localWeakReference = new WeakReference(localObject1);
    Object localObject2 = (b)paramf.T(b.class);
    if (localObject2 != null)
    {
      this.eqZ = ((b)localObject2).aro();
      Log.i("Luggage.WcWssNativeInstallHelper", "createWcWssBinding xLibUVSwitch:%b ", new Object[] { Boolean.valueOf(this.eqZ) });
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
        ((com.tencent.mm.plugin.appbrand.x.a)com.tencent.luggage.a.e.U(com.tencent.mm.plugin.appbrand.x.a.class)).b(localArrayList, false);
        AppMethodBeat.o(146767);
      }
      
      public final void onKvStat(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(146766);
        Log.d("Luggage.WcWssNativeInstallHelper", "MMWcWss onKvStat logId:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        ((com.tencent.mm.plugin.appbrand.x.b)com.tencent.luggage.a.e.U(com.tencent.mm.plugin.appbrand.x.b.class)).kvStat(paramAnonymousInt, paramAnonymousString);
        AppMethodBeat.o(146766);
      }
    }, (m)parami.Z(m.class));
    ((q)localObject1).post(new Runnable()
    {
      public final int doCertificateVerify(String paramAnonymousString1, long paramAnonymousLong, String paramAnonymousString2, byte[][] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(146770);
        if ((e.b(e.this) == null) || (e.c(e.this) == null))
        {
          e.a(e.this, (com.tencent.mm.plugin.appbrand.t.a)paramf.aN(com.tencent.mm.plugin.appbrand.t.a.class));
          if (e.b(e.this) == null) {
            break label116;
          }
          e.a(e.this, com.tencent.mm.plugin.appbrand.t.i.b(e.b(e.this)));
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
        v localv = (v)parami.Z(v.class);
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
            e.a(e.this, e.a(e.this).initWcwss(localv.getIsolatePtr(), localv.aEn(), localv.getUVLoopPtr()));
          }
          for (;;)
          {
            e.a(e.this, e.a(e.this).setCallback(this.erF, this.erG));
            Log.i("Luggage.WcWssNativeInstallHelper", "createWcWssBinding setCallback mContextId:%s,mInitCallBack:%d", new Object[] { e.d(e.this), Integer.valueOf(e.f(e.this)) });
            AppMethodBeat.o(146771);
            return;
            e.a(e.this, e.a(e.this).initWcwss(localv.getIsolatePtr(), localv.aEn(), 0L));
          }
        }
        Log.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding mWcwssNative = null");
        AppMethodBeat.o(146771);
      }
    });
    AppMethodBeat.o(146777);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.n.i parami, final com.tencent.mm.plugin.appbrand.jsapi.k paramk)
  {
    AppMethodBeat.i(220342);
    Log.i("Luggage.WcWssNativeInstallHelper", "initConfigWcWss mContextId:%s", new Object[] { this.erv });
    if (!this.ery)
    {
      Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss xSwitch false");
      AppMethodBeat.o(220342);
      return;
    }
    if (parami == null)
    {
      Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss jsruntime is null");
      AppMethodBeat.o(220342);
      return;
    }
    parami = (q)parami.Z(q.class);
    if (parami == null)
    {
      Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss jsThreadHandler is null");
      AppMethodBeat.o(220342);
      return;
    }
    b localb = (b)paramk.T(b.class);
    if ((localb != null) && (localb.arp())) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("Luggage.WcWssNativeInstallHelper", "initConfigWcWss appId:%s, closeWcWssSocketsWhenSuspend:%b", new Object[] { paramk.getAppId(), Boolean.valueOf(bool) });
      if (bool) {
        paramk.getRuntime().qsB.a(new c.a()
        {
          public final void onRunningStateChanged(String paramAnonymousString, com.tencent.mm.plugin.appbrand.b.b paramAnonymousb)
          {
            AppMethodBeat.i(220267);
            if ((com.tencent.mm.plugin.appbrand.b.b.qKy == paramAnonymousb) && (e.a(e.this) != null)) {
              parami.a(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(220264);
                  if (e.a(e.this) != null) {
                    e.a(e.this).doOnRunningState();
                  }
                  AppMethodBeat.o(220264);
                }
              }, true);
            }
            AppMethodBeat.o(220267);
          }
        });
      }
      parami.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(220279);
          Log.i("Luggage.WcWssNativeInstallHelper", "initConfigWcWss initConfig mContextId:%s", new Object[] { e.d(e.this) });
          if (e.a(e.this) == null)
          {
            Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss mWcwssNative is null");
            AppMethodBeat.o(220279);
            return;
          }
          Object localObject = (com.tencent.mm.plugin.appbrand.t.a)paramk.aN(com.tencent.mm.plugin.appbrand.t.a.class);
          if (localObject != null)
          {
            Log.i("Luggage.WcWssNativeInstallHelper", "wcwss mbzType:%s,,websocketTimeoutMS:%d,userAgentString :%s,referer:%s,mode:%d", new Object[] { e.g(e.this), Integer.valueOf(((com.tencent.mm.plugin.appbrand.t.a)localObject).tna), ((com.tencent.mm.plugin.appbrand.t.a)localObject).tnh, ((com.tencent.mm.plugin.appbrand.t.a)localObject).referer, Integer.valueOf(((com.tencent.mm.plugin.appbrand.t.a)localObject).mode) });
            HashMap localHashMap = new HashMap();
            localHashMap.put("referer", ((com.tencent.mm.plugin.appbrand.t.a)localObject).referer);
            localHashMap.put("User-Agent", ((com.tencent.mm.plugin.appbrand.t.a)localObject).tnh);
            localHashMap.put("bzType", e.g(e.this));
            localHashMap.put("mode", String.valueOf(((com.tencent.mm.plugin.appbrand.t.a)localObject).mode));
            localHashMap.put("timeout", String.valueOf(((com.tencent.mm.plugin.appbrand.t.a)localObject).tna));
            e.a(e.this).initConfig(localHashMap);
            if (((com.tencent.mm.plugin.appbrand.t.a)localObject).mode != 0)
            {
              if (((com.tencent.mm.plugin.appbrand.t.a)localObject).mode == 1)
              {
                if ((((com.tencent.mm.plugin.appbrand.t.a)localObject).tne == null) || (((com.tencent.mm.plugin.appbrand.t.a)localObject).tne.size() == 0)) {
                  Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss blacklistHeaders is null");
                }
                for (localObject = null;; localObject = ((com.tencent.mm.plugin.appbrand.t.a)localObject).tne)
                {
                  e.a(e.this).initConfigWhiteBlack(null, (ArrayList)localObject);
                  AppMethodBeat.o(220279);
                  return;
                }
              }
              if (((com.tencent.mm.plugin.appbrand.t.a)localObject).mode == 2)
              {
                if ((((com.tencent.mm.plugin.appbrand.t.a)localObject).tnf == null) || (((com.tencent.mm.plugin.appbrand.t.a)localObject).tnf.size() == 0)) {
                  Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss whitelistHeaders is null");
                }
                for (localObject = null;; localObject = ((com.tencent.mm.plugin.appbrand.t.a)localObject).tnf)
                {
                  e.a(e.this).initConfigWhiteBlack((ArrayList)localObject, null);
                  AppMethodBeat.o(220279);
                  return;
                }
              }
              Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss invalid mode:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.t.a)localObject).mode) });
              AppMethodBeat.o(220279);
              return;
            }
            Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss invalid mode:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.t.a)localObject).mode) });
            AppMethodBeat.o(220279);
            return;
          }
          Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss networkConfig is null");
          AppMethodBeat.o(220279);
        }
      });
      AppMethodBeat.o(220342);
      return;
    }
  }
  
  public final void c(com.tencent.mm.plugin.appbrand.n.i parami)
  {
    AppMethodBeat.i(146778);
    Log.i("Luggage.WcWssNativeInstallHelper", "destroyWcWssBinding mContextId:%s", new Object[] { this.erv });
    if (!this.ery)
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
    ((m)parami.Z(m.class)).a(this.erA);
    AppMethodBeat.o(146778);
  }
  
  final class a
    extends n
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
    public abstract boolean arp();
    
    public abstract boolean isOpen();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.b.e
 * JD-Core Version:    0.7.0.1
 */