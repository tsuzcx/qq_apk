package com.tencent.luggage.sdk.b.a.a;

import com.tencent.luggage.a.e;
import com.tencent.mars.cdn.AndroidCertVerifyResult;
import com.tencent.mars.cdn.X509Util;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.m;
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

public class d
{
  private String czC;
  private boolean czD;
  private String czU;
  private int czV;
  private com.tencent.mm.plugin.appbrand.s.a czW;
  private boolean czX;
  private WcwssNative czY;
  private final d.a czZ;
  private X509TrustManager mTrustManager;
  
  public d()
  {
    AppMethodBeat.i(146775);
    this.czU = null;
    this.czV = -1;
    this.czW = null;
    this.mTrustManager = null;
    this.czX = false;
    this.czD = true;
    this.czC = null;
    this.czZ = new d.a(this, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146772);
        synchronized (d.this)
        {
          if (d.a(d.this) != null)
          {
            Log.i("Luggage.WcWssNativeInstallHelper", "destroyTask destroyWcWssBinding mContextId:%s", new Object[] { d.d(d.this) });
            d.a(d.this).destoryWcwss();
            d.a(d.this, null);
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
        ((com.tencent.mm.plugin.appbrand.w.a)e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(972L, 7L, 1L, false);
      }
      if ((localAndroidCertVerifyResult1.getStatus() == 0) && (!localAndroidCertVerifyResult1.isIssuedByHostMatched())) {
        ((com.tencent.mm.plugin.appbrand.w.a)e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(972L, 8L, 1L, false);
      }
      if ((localAndroidCertVerifyResult1.getStatus() == 0) && (!localAndroidCertVerifyResult1.isIssuedByKnownRoot())) {
        ((com.tencent.mm.plugin.appbrand.w.a)e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(972L, 9L, 1L, false);
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
  
  public final void a(final i parami, final f paramf, int paramInt)
  {
    AppMethodBeat.i(146777);
    Log.i("Luggage.WcWssNativeInstallHelper", "createWcWssBinding");
    Object localObject1 = (b)paramf.M(b.class);
    if (localObject1 != null) {
      this.czX = ((b)localObject1).isOpen();
    }
    if (!this.czX)
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
    this.czC = String.valueOf(paramInt);
    d.class.getClassLoader();
    com.tencent.mm.compatible.util.j.Ed("owl");
    d.class.getClassLoader();
    com.tencent.mm.compatible.util.j.Ed("wcwss");
    com.tencent.mm.websocket.libwcwss.a.loadLibraries();
    localObject1 = (q)parami.R(q.class);
    if (localObject1 == null)
    {
      Log.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding jsThreadHandler is null");
      AppMethodBeat.o(146777);
      return;
    }
    final WeakReference localWeakReference = new WeakReference(localObject1);
    Object localObject2 = (b)paramf.M(b.class);
    if (localObject2 != null)
    {
      this.czD = ((b)localObject2).Oa();
      Log.i("Luggage.WcWssNativeInstallHelper", "createWcWssBinding xLibUVSwitch:%b ", new Object[] { Boolean.valueOf(this.czD) });
    }
    localObject2 = new d.1(this);
    ((q)localObject1).post(new Runnable()
    {
      public final int doCertificateVerify(String paramAnonymousString1, long paramAnonymousLong, String paramAnonymousString2, byte[][] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(146770);
        if ((d.b(d.this) == null) || (d.c(d.this) == null))
        {
          d.a(d.this, (com.tencent.mm.plugin.appbrand.s.a)paramf.av(com.tencent.mm.plugin.appbrand.s.a.class));
          if (d.b(d.this) == null) {
            break label116;
          }
          d.a(d.this, com.tencent.mm.plugin.appbrand.s.j.b(d.b(d.this)));
          if (d.c(d.this) == null) {
            Log.e("Luggage.WcWssNativeInstallHelper", "MMWcWss doCertificateVerify getTrustManager fail");
          }
        }
        for (;;)
        {
          int i = d.a(paramAnonymousString2, paramAnonymousArrayOfByte, d.c(d.this));
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
            d.a(d.this).updateInterface(paramAnonymousLong, this.te);
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
        if (d.d(d.this) != null)
        {
          Log.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding mContextId != null");
          AppMethodBeat.o(146771);
          return;
        }
        v localv = (v)parami.R(v.class);
        if (localv == null)
        {
          Log.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding v8Addon is null");
          AppMethodBeat.o(146771);
          return;
        }
        d.a(d.this, new WcwssNative());
        if (d.a(d.this) != null)
        {
          if (d.e(d.this)) {
            d.a(d.this, d.a(d.this).initWcwss(localv.getIsolatePtr(), localv.XK(), 0L));
          }
          for (;;)
          {
            d.a(d.this, d.a(d.this).setCallback(this.cAe, this.cAf));
            Log.i("Luggage.WcWssNativeInstallHelper", "createWcWssBinding setCallback mContextId:%s,mInitCallBack:%d", new Object[] { d.d(d.this), Integer.valueOf(d.f(d.this)) });
            AppMethodBeat.o(146771);
            return;
            d.a(d.this, d.a(d.this).initWcwss(localv.getIsolatePtr(), localv.XK(), 0L));
          }
        }
        Log.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding mWcwssNative = null");
        AppMethodBeat.o(146771);
      }
    });
    AppMethodBeat.o(146777);
  }
  
  public final void a(final i parami, final k paramk)
  {
    AppMethodBeat.i(229843);
    Log.i("Luggage.WcWssNativeInstallHelper", "initConfigWcWss mContextId:%s", new Object[] { this.czU });
    if (!this.czX)
    {
      Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss xSwitch false");
      AppMethodBeat.o(229843);
      return;
    }
    if (parami == null)
    {
      Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss jsruntime is null");
      AppMethodBeat.o(229843);
      return;
    }
    parami = (q)parami.R(q.class);
    if (parami == null)
    {
      Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss jsThreadHandler is null");
      AppMethodBeat.o(229843);
      return;
    }
    b localb = (b)paramk.M(b.class);
    if ((localb != null) && (localb.Ob())) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("Luggage.WcWssNativeInstallHelper", "initConfigWcWss appId:%s, closeWcWssSocketsWhenSuspend:%b", new Object[] { paramk.getAppId(), Boolean.valueOf(bool) });
      if (bool) {
        paramk.getRuntime().kAH.a(new c.a()
        {
          public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
          {
            AppMethodBeat.i(229841);
            if ((com.tencent.mm.plugin.appbrand.a.b.kQJ == paramAnonymousb) && (d.a(d.this) != null)) {
              parami.a(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(229840);
                  if (d.a(d.this) != null) {
                    d.a(d.this).doOnRunningState();
                  }
                  AppMethodBeat.o(229840);
                }
              }, true);
            }
            AppMethodBeat.o(229841);
          }
        });
      }
      parami.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(229842);
          Log.i("Luggage.WcWssNativeInstallHelper", "initConfigWcWss initConfig mContextId:%s", new Object[] { d.d(d.this) });
          if (d.a(d.this) == null)
          {
            Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss mWcwssNative is null");
            AppMethodBeat.o(229842);
            return;
          }
          Object localObject = (com.tencent.mm.plugin.appbrand.s.a)paramk.av(com.tencent.mm.plugin.appbrand.s.a.class);
          if (localObject != null)
          {
            Log.i("Luggage.WcWssNativeInstallHelper", "wcwss mbzType:%s,,websocketTimeoutMS:%d,userAgentString :%s,referer:%s,mode:%d", new Object[] { d.g(d.this), Integer.valueOf(((com.tencent.mm.plugin.appbrand.s.a)localObject).nhF), ((com.tencent.mm.plugin.appbrand.s.a)localObject).nhM, ((com.tencent.mm.plugin.appbrand.s.a)localObject).referer, Integer.valueOf(((com.tencent.mm.plugin.appbrand.s.a)localObject).mode) });
            HashMap localHashMap = new HashMap();
            localHashMap.put("referer", ((com.tencent.mm.plugin.appbrand.s.a)localObject).referer);
            localHashMap.put("User-Agent", ((com.tencent.mm.plugin.appbrand.s.a)localObject).nhM);
            localHashMap.put("bzType", d.g(d.this));
            localHashMap.put("mode", String.valueOf(((com.tencent.mm.plugin.appbrand.s.a)localObject).mode));
            localHashMap.put("timeout", String.valueOf(((com.tencent.mm.plugin.appbrand.s.a)localObject).nhF));
            d.a(d.this).initConfig(localHashMap);
            if (((com.tencent.mm.plugin.appbrand.s.a)localObject).mode != 0)
            {
              if (((com.tencent.mm.plugin.appbrand.s.a)localObject).mode == 1)
              {
                if ((((com.tencent.mm.plugin.appbrand.s.a)localObject).nhJ == null) || (((com.tencent.mm.plugin.appbrand.s.a)localObject).nhJ.size() == 0)) {
                  Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss blacklistHeaders is null");
                }
                for (localObject = null;; localObject = ((com.tencent.mm.plugin.appbrand.s.a)localObject).nhJ)
                {
                  d.a(d.this).initConfigWhiteBlack(null, (ArrayList)localObject);
                  AppMethodBeat.o(229842);
                  return;
                }
              }
              if (((com.tencent.mm.plugin.appbrand.s.a)localObject).mode == 2)
              {
                if ((((com.tencent.mm.plugin.appbrand.s.a)localObject).nhK == null) || (((com.tencent.mm.plugin.appbrand.s.a)localObject).nhK.size() == 0)) {
                  Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss whitelistHeaders is null");
                }
                for (localObject = null;; localObject = ((com.tencent.mm.plugin.appbrand.s.a)localObject).nhK)
                {
                  d.a(d.this).initConfigWhiteBlack((ArrayList)localObject, null);
                  AppMethodBeat.o(229842);
                  return;
                }
              }
              Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss invalid mode:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.s.a)localObject).mode) });
              AppMethodBeat.o(229842);
              return;
            }
            Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss invalid mode:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.s.a)localObject).mode) });
            AppMethodBeat.o(229842);
            return;
          }
          Log.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss networkConfig is null");
          AppMethodBeat.o(229842);
        }
      });
      AppMethodBeat.o(229843);
      return;
    }
  }
  
  public final void b(i parami)
  {
    AppMethodBeat.i(146778);
    Log.i("Luggage.WcWssNativeInstallHelper", "destroyWcWssBinding mContextId:%s", new Object[] { this.czU });
    if (!this.czX)
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
    ((m)parami.R(m.class)).a(this.czZ);
    AppMethodBeat.o(146778);
  }
  
  public static abstract interface b
    extends com.tencent.luggage.a.b
  {
    public abstract boolean Ob();
    
    public abstract boolean isOpen();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */