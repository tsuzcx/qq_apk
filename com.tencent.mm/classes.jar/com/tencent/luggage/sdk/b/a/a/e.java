package com.tencent.luggage.sdk.b.a.a;

import com.tencent.mars.cdn.AndroidCertVerifyResult;
import com.tencent.mars.cdn.X509Util;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.m;
import com.tencent.mm.plugin.appbrand.jsruntime.m.a;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.p.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.websocket.libwcwss.WcwssNative;
import com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssReportListener;
import com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssWebSocketListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.net.ssl.X509TrustManager;

public final class e
{
  String cdA;
  int cdB;
  com.tencent.mm.plugin.appbrand.p.a cdC;
  private boolean cdD;
  private final a cdE;
  String cdh;
  private boolean cdi;
  X509TrustManager mTrustManager;
  
  public e()
  {
    AppMethodBeat.i(146775);
    this.cdA = null;
    this.cdB = -1;
    this.cdC = null;
    this.mTrustManager = null;
    this.cdD = false;
    this.cdi = true;
    this.cdh = null;
    this.cdE = new a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146772);
        synchronized (e.this)
        {
          if (e.this.cdA != null)
          {
            ac.i("Luggage.WcWssNativeInstallHelper", "destroyTask destroyWcWssBinding mContextId:%s", new Object[] { e.this.cdA });
            WcwssNative.destoryWcwss(e.this.cdA);
            e.this.cdA = null;
            AppMethodBeat.o(146772);
            return;
          }
          ac.e("Luggage.WcWssNativeInstallHelper", "destroyTask mContextId is null");
        }
      }
    });
    AppMethodBeat.o(146775);
  }
  
  public static int a(String paramString, byte[][] paramArrayOfByte, X509TrustManager paramX509TrustManager)
  {
    AppMethodBeat.i(146781);
    ac.i("Luggage.WcWssNativeInstallHelper", "certifivate verify for ".concat(String.valueOf(paramString)));
    try
    {
      AndroidCertVerifyResult localAndroidCertVerifyResult2 = X509Util.verifyServerCertificates(paramArrayOfByte, "RSA", paramString, 1, paramX509TrustManager);
      ac.i("Luggage.WcWssNativeInstallHelper", "host %s rsa verify result %d, isknownroots %b, ishostmatched %b", new Object[] { paramString, Integer.valueOf(localAndroidCertVerifyResult2.getStatus()), Boolean.valueOf(localAndroidCertVerifyResult2.isIssuedByKnownRoot()), Boolean.valueOf(localAndroidCertVerifyResult2.isIssuedByHostMatched()) });
      AndroidCertVerifyResult localAndroidCertVerifyResult1 = localAndroidCertVerifyResult2;
      if (localAndroidCertVerifyResult2.getStatus() != 0)
      {
        localAndroidCertVerifyResult1 = X509Util.verifyServerCertificates(paramArrayOfByte, "ECDSA", paramString, 1, paramX509TrustManager);
        ac.i("Luggage.WcWssNativeInstallHelper", "host %s ecdsa verify result %d, isknownroots %b, ishostmatched %b", new Object[] { paramString, Integer.valueOf(localAndroidCertVerifyResult1.getStatus()), Boolean.valueOf(localAndroidCertVerifyResult1.isIssuedByKnownRoot()), Boolean.valueOf(localAndroidCertVerifyResult1.isIssuedByHostMatched()) });
      }
      if (localAndroidCertVerifyResult1.getStatus() != 0) {
        ((com.tencent.mm.plugin.appbrand.t.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(972L, 7L, 1L, false);
      }
      if ((localAndroidCertVerifyResult1.getStatus() == 0) && (!localAndroidCertVerifyResult1.isIssuedByHostMatched())) {
        ((com.tencent.mm.plugin.appbrand.t.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(972L, 8L, 1L, false);
      }
      if ((localAndroidCertVerifyResult1.getStatus() == 0) && (!localAndroidCertVerifyResult1.isIssuedByKnownRoot())) {
        ((com.tencent.mm.plugin.appbrand.t.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(972L, 9L, 1L, false);
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
      ac.printErrStackTrace("Luggage.WcWssNativeInstallHelper", paramString, "doCertificateVerify Exception", new Object[0]);
      AppMethodBeat.o(146781);
    }
    return -1;
  }
  
  public static int getStatisticsNetType()
  {
    AppMethodBeat.i(146780);
    try
    {
      int i = ax.getNetType(ai.getContext());
      ac.i("Luggage.WcWssNativeInstallHelper", "getStatisticsNetType ret:%d", new Object[] { Integer.valueOf(i) });
      if (i == -1)
      {
        AppMethodBeat.o(146780);
        return -1;
      }
      boolean bool = ax.is2G(ai.getContext());
      if (bool)
      {
        AppMethodBeat.o(146780);
        return 3;
      }
      bool = ax.is3G(ai.getContext());
      if (bool)
      {
        AppMethodBeat.o(146780);
        return 4;
      }
      bool = ax.is4G(ai.getContext());
      if (bool)
      {
        AppMethodBeat.o(146780);
        return 5;
      }
      bool = ax.isWifi(i);
      if (bool)
      {
        AppMethodBeat.o(146780);
        return 1;
      }
      bool = ax.isWap(i);
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
      ac.printErrStackTrace("Luggage.WcWssNativeInstallHelper", localException, "getStatisticsNetType_", new Object[0]);
      AppMethodBeat.o(146780);
    }
    return -1;
  }
  
  public final void a(final i parami, final com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
  {
    AppMethodBeat.i(146777);
    ac.i("Luggage.WcWssNativeInstallHelper", "createWcWssBinding");
    Object localObject1 = (e.b)paramc.K(e.b.class);
    if (localObject1 != null) {
      this.cdD = ((e.b)localObject1).isOpen();
    }
    if (!this.cdD)
    {
      ac.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding xSwitch false");
      AppMethodBeat.o(146777);
      return;
    }
    if (parami == null)
    {
      ac.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding jsruntime is null");
      AppMethodBeat.o(146777);
      return;
    }
    this.cdh = String.valueOf(paramInt);
    com.tencent.mm.websocket.libwcwss.a.loadLibraries();
    localObject1 = (q)parami.P(q.class);
    if (localObject1 == null)
    {
      ac.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding jsThreadHandler is null");
      AppMethodBeat.o(146777);
      return;
    }
    Object localObject2 = (b)paramc.K(b.class);
    if (localObject2 != null)
    {
      this.cdi = ((b)localObject2).CZ();
      ac.i("Luggage.WcWssNativeInstallHelper", "createWcWssBinding xLibUVSwitch:%b ", new Object[] { Boolean.valueOf(this.cdi) });
    }
    localObject2 = new WcwssNative.IWcWssReportListener()
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
        ac.d("Luggage.WcWssNativeInstallHelper", "MMWcWss onIdKeyStat");
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < paramAnonymousArrayOfInt1.length)
        {
          localArrayList.add(new IDKey(paramAnonymousArrayOfInt1[i], paramAnonymousArrayOfInt2[i], paramAnonymousArrayOfInt3[i]));
          i += 1;
        }
        ((com.tencent.mm.plugin.appbrand.t.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.t.a.class)).b(localArrayList, false);
        AppMethodBeat.o(146767);
      }
      
      public final void onKvStat(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(146766);
        ac.d("Luggage.WcWssNativeInstallHelper", "MMWcWss onKvStat logId:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        ((com.tencent.mm.plugin.appbrand.t.b)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.t.b.class)).kvStat(paramAnonymousInt, paramAnonymousString);
        AppMethodBeat.o(146766);
      }
    };
    ((q)localObject1).post(new Runnable()
    {
      public final int doCertificateVerify(String paramAnonymousString1, long paramAnonymousLong, String paramAnonymousString2, byte[][] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(146770);
        if ((e.this.cdC == null) || (e.this.mTrustManager == null))
        {
          e.this.cdC = ((com.tencent.mm.plugin.appbrand.p.a)paramc.ar(com.tencent.mm.plugin.appbrand.p.a.class));
          if (e.this.cdC == null) {
            break label114;
          }
          e.this.mTrustManager = j.b(e.this.cdC);
          if (e.this.mTrustManager == null) {
            ac.e("Luggage.WcWssNativeInstallHelper", "MMWcWss doCertificateVerify getTrustManager fail");
          }
        }
        for (;;)
        {
          int i = e.a(paramAnonymousString2, paramAnonymousArrayOfByte, e.this.mTrustManager);
          AppMethodBeat.o(146770);
          return i;
          label114:
          ac.e("Luggage.WcWssNativeInstallHelper", "MMWcWss doCertificateVerify getConfig fail");
        }
      }
      
      public final void onStateChange(final String paramAnonymousString, final long paramAnonymousLong, int paramAnonymousInt)
      {
        AppMethodBeat.i(146769);
        this.cdG.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(146768);
            ac.d("Luggage.WcWssNativeInstallHelper", "MMWcWss jsThreadHandler run onCallBack contextId:%s", new Object[] { paramAnonymousString });
            WcwssNative.updateInterface(paramAnonymousString, paramAnonymousLong, this.rf);
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
        ac.i("Luggage.WcWssNativeInstallHelper", "createWcWssBinding setCallback ");
        if (e.this.cdA != null)
        {
          ac.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding mContextId != null");
          AppMethodBeat.o(146771);
          return;
        }
        v localv = (v)parami.P(v.class);
        if (localv == null)
        {
          ac.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding v8Addon is null");
          AppMethodBeat.o(146771);
          return;
        }
        e.this.cdA = WcwssNative.initWcwss(localv.getIsolatePtr(), localv.LS(), 0L);
        if (e.this.cdA != null) {
          e.this.cdB = WcwssNative.setCallback(e.this.cdA, this.cdK, this.cdL);
        }
        ac.i("Luggage.WcWssNativeInstallHelper", "createWcWssBinding setCallback mContextId:%s,mInitCallBack:%d", new Object[] { e.this.cdA, Integer.valueOf(e.this.cdB) });
        AppMethodBeat.o(146771);
      }
    });
    AppMethodBeat.o(146777);
  }
  
  public final void b(i parami)
  {
    AppMethodBeat.i(146778);
    ac.i("Luggage.WcWssNativeInstallHelper", "destroyWcWssBinding mContextId:%s", new Object[] { this.cdA });
    if (!this.cdD)
    {
      ac.e("Luggage.WcWssNativeInstallHelper", "destroyWcWssBinding xSwitch false");
      AppMethodBeat.o(146778);
      return;
    }
    if (parami == null)
    {
      ac.e("Luggage.WcWssNativeInstallHelper", "destroyWcWssBinding jsruntime is null");
      AppMethodBeat.o(146778);
      return;
    }
    ((m)parami.P(m.class)).a(this.cdE);
    AppMethodBeat.o(146778);
  }
  
  public final void b(i parami, final com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(146779);
    ac.i("Luggage.WcWssNativeInstallHelper", "initConfigWcWss mContextId:%s", new Object[] { this.cdA });
    if (!this.cdD)
    {
      ac.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss xSwitch false");
      AppMethodBeat.o(146779);
      return;
    }
    if (parami == null)
    {
      ac.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss jsruntime is null");
      AppMethodBeat.o(146779);
      return;
    }
    parami = (q)parami.P(q.class);
    if (parami == null)
    {
      ac.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss jsThreadHandler is null");
      AppMethodBeat.o(146779);
      return;
    }
    parami.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146773);
        ac.i("Luggage.WcWssNativeInstallHelper", "initConfigWcWss initConfig mContextId:%s", new Object[] { e.this.cdA });
        if (e.this.cdA == null)
        {
          ac.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss mContextId is null");
          AppMethodBeat.o(146773);
          return;
        }
        Object localObject = (com.tencent.mm.plugin.appbrand.p.a)paramc.ar(com.tencent.mm.plugin.appbrand.p.a.class);
        if (localObject != null)
        {
          ac.i("Luggage.WcWssNativeInstallHelper", "wcwss mbzType:%s,,websocketTimeoutMS:%d,userAgentString :%s,referer:%s,mode:%d", new Object[] { e.this.cdh, Integer.valueOf(((com.tencent.mm.plugin.appbrand.p.a)localObject).lwa), ((com.tencent.mm.plugin.appbrand.p.a)localObject).lwh, ((com.tencent.mm.plugin.appbrand.p.a)localObject).referer, Integer.valueOf(((com.tencent.mm.plugin.appbrand.p.a)localObject).mode) });
          HashMap localHashMap = new HashMap();
          localHashMap.put("referer", ((com.tencent.mm.plugin.appbrand.p.a)localObject).referer);
          localHashMap.put("User-Agent", ((com.tencent.mm.plugin.appbrand.p.a)localObject).lwh);
          localHashMap.put("bzType", e.this.cdh);
          localHashMap.put("mode", String.valueOf(((com.tencent.mm.plugin.appbrand.p.a)localObject).mode));
          localHashMap.put("timeout", String.valueOf(((com.tencent.mm.plugin.appbrand.p.a)localObject).lwa));
          WcwssNative.initConfig(e.this.cdA, localHashMap);
          if (((com.tencent.mm.plugin.appbrand.p.a)localObject).mode != 0)
          {
            if (((com.tencent.mm.plugin.appbrand.p.a)localObject).mode == 1)
            {
              if ((((com.tencent.mm.plugin.appbrand.p.a)localObject).lwe == null) || (((com.tencent.mm.plugin.appbrand.p.a)localObject).lwe.size() == 0)) {
                ac.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss blacklistHeaders is null");
              }
              for (localObject = null;; localObject = ((com.tencent.mm.plugin.appbrand.p.a)localObject).lwe)
              {
                WcwssNative.initConfigWhiteBlack(e.this.cdA, null, (ArrayList)localObject);
                AppMethodBeat.o(146773);
                return;
              }
            }
            if (((com.tencent.mm.plugin.appbrand.p.a)localObject).mode == 2)
            {
              if ((((com.tencent.mm.plugin.appbrand.p.a)localObject).lwf == null) || (((com.tencent.mm.plugin.appbrand.p.a)localObject).lwf.size() == 0)) {
                ac.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss whitelistHeaders is null");
              }
              for (localObject = null;; localObject = ((com.tencent.mm.plugin.appbrand.p.a)localObject).lwf)
              {
                WcwssNative.initConfigWhiteBlack(e.this.cdA, (ArrayList)localObject, null);
                AppMethodBeat.o(146773);
                return;
              }
            }
            ac.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss invalid mode:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.p.a)localObject).mode) });
            AppMethodBeat.o(146773);
            return;
          }
          ac.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss invalid mode:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.p.a)localObject).mode) });
          AppMethodBeat.o(146773);
          return;
        }
        ac.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss networkConfig is null");
        AppMethodBeat.o(146773);
      }
    });
    AppMethodBeat.o(146779);
  }
  
  final class a
    extends c
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.e
 * JD-Core Version:    0.7.0.1
 */