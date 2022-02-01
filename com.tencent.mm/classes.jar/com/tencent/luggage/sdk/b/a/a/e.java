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
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.websocket.libwcwss.WcwssNative;
import com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssReportListener;
import com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssWebSocketListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.net.ssl.X509TrustManager;

public final class e
{
  String cgE;
  int cgF;
  com.tencent.mm.plugin.appbrand.q.a cgG;
  private boolean cgH;
  private final a cgI;
  String cgl;
  private boolean cgm;
  X509TrustManager mTrustManager;
  
  public e()
  {
    AppMethodBeat.i(146775);
    this.cgE = null;
    this.cgF = -1;
    this.cgG = null;
    this.mTrustManager = null;
    this.cgH = false;
    this.cgm = true;
    this.cgl = null;
    this.cgI = new a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146772);
        synchronized (e.this)
        {
          if (e.this.cgE != null)
          {
            ad.i("Luggage.WcWssNativeInstallHelper", "destroyTask destroyWcWssBinding mContextId:%s", new Object[] { e.this.cgE });
            WcwssNative.destoryWcwss(e.this.cgE);
            e.this.cgE = null;
            AppMethodBeat.o(146772);
            return;
          }
          ad.e("Luggage.WcWssNativeInstallHelper", "destroyTask mContextId is null");
        }
      }
    });
    AppMethodBeat.o(146775);
  }
  
  public static int a(String paramString, byte[][] paramArrayOfByte, X509TrustManager paramX509TrustManager)
  {
    AppMethodBeat.i(146781);
    ad.i("Luggage.WcWssNativeInstallHelper", "certifivate verify for ".concat(String.valueOf(paramString)));
    try
    {
      AndroidCertVerifyResult localAndroidCertVerifyResult2 = X509Util.verifyServerCertificates(paramArrayOfByte, "RSA", paramString, 1, paramX509TrustManager);
      ad.i("Luggage.WcWssNativeInstallHelper", "host %s rsa verify result %d, isknownroots %b, ishostmatched %b", new Object[] { paramString, Integer.valueOf(localAndroidCertVerifyResult2.getStatus()), Boolean.valueOf(localAndroidCertVerifyResult2.isIssuedByKnownRoot()), Boolean.valueOf(localAndroidCertVerifyResult2.isIssuedByHostMatched()) });
      AndroidCertVerifyResult localAndroidCertVerifyResult1 = localAndroidCertVerifyResult2;
      if (localAndroidCertVerifyResult2.getStatus() != 0)
      {
        localAndroidCertVerifyResult1 = X509Util.verifyServerCertificates(paramArrayOfByte, "ECDSA", paramString, 1, paramX509TrustManager);
        ad.i("Luggage.WcWssNativeInstallHelper", "host %s ecdsa verify result %d, isknownroots %b, ishostmatched %b", new Object[] { paramString, Integer.valueOf(localAndroidCertVerifyResult1.getStatus()), Boolean.valueOf(localAndroidCertVerifyResult1.isIssuedByKnownRoot()), Boolean.valueOf(localAndroidCertVerifyResult1.isIssuedByHostMatched()) });
      }
      if (localAndroidCertVerifyResult1.getStatus() != 0) {
        ((com.tencent.mm.plugin.appbrand.u.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.u.a.class)).idkeyStat(972L, 7L, 1L, false);
      }
      if ((localAndroidCertVerifyResult1.getStatus() == 0) && (!localAndroidCertVerifyResult1.isIssuedByHostMatched())) {
        ((com.tencent.mm.plugin.appbrand.u.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.u.a.class)).idkeyStat(972L, 8L, 1L, false);
      }
      if ((localAndroidCertVerifyResult1.getStatus() == 0) && (!localAndroidCertVerifyResult1.isIssuedByKnownRoot())) {
        ((com.tencent.mm.plugin.appbrand.u.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.u.a.class)).idkeyStat(972L, 9L, 1L, false);
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
      ad.printErrStackTrace("Luggage.WcWssNativeInstallHelper", paramString, "doCertificateVerify Exception", new Object[0]);
      AppMethodBeat.o(146781);
    }
    return -1;
  }
  
  public static int getStatisticsNetType()
  {
    AppMethodBeat.i(146780);
    try
    {
      int i = ay.getNetType(aj.getContext());
      ad.i("Luggage.WcWssNativeInstallHelper", "getStatisticsNetType ret:%d", new Object[] { Integer.valueOf(i) });
      if (i == -1)
      {
        AppMethodBeat.o(146780);
        return -1;
      }
      boolean bool = ay.is2G(aj.getContext());
      if (bool)
      {
        AppMethodBeat.o(146780);
        return 3;
      }
      bool = ay.is3G(aj.getContext());
      if (bool)
      {
        AppMethodBeat.o(146780);
        return 4;
      }
      bool = ay.is4G(aj.getContext());
      if (bool)
      {
        AppMethodBeat.o(146780);
        return 5;
      }
      bool = ay.isWifi(i);
      if (bool)
      {
        AppMethodBeat.o(146780);
        return 1;
      }
      bool = ay.isWap(i);
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
      ad.printErrStackTrace("Luggage.WcWssNativeInstallHelper", localException, "getStatisticsNetType_", new Object[0]);
      AppMethodBeat.o(146780);
    }
    return -1;
  }
  
  public final void a(final i parami, final com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
  {
    AppMethodBeat.i(146777);
    ad.i("Luggage.WcWssNativeInstallHelper", "createWcWssBinding");
    Object localObject1 = (e.b)paramc.K(e.b.class);
    if (localObject1 != null) {
      this.cgH = ((e.b)localObject1).isOpen();
    }
    if (!this.cgH)
    {
      ad.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding xSwitch false");
      AppMethodBeat.o(146777);
      return;
    }
    if (parami == null)
    {
      ad.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding jsruntime is null");
      AppMethodBeat.o(146777);
      return;
    }
    this.cgl = String.valueOf(paramInt);
    com.tencent.mm.websocket.libwcwss.a.loadLibraries();
    localObject1 = (q)parami.P(q.class);
    if (localObject1 == null)
    {
      ad.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding jsThreadHandler is null");
      AppMethodBeat.o(146777);
      return;
    }
    Object localObject2 = (b)paramc.K(b.class);
    if (localObject2 != null)
    {
      this.cgm = ((b)localObject2).Dw();
      ad.i("Luggage.WcWssNativeInstallHelper", "createWcWssBinding xLibUVSwitch:%b ", new Object[] { Boolean.valueOf(this.cgm) });
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
        ad.d("Luggage.WcWssNativeInstallHelper", "MMWcWss onIdKeyStat");
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < paramAnonymousArrayOfInt1.length)
        {
          localArrayList.add(new IDKey(paramAnonymousArrayOfInt1[i], paramAnonymousArrayOfInt2[i], paramAnonymousArrayOfInt3[i]));
          i += 1;
        }
        ((com.tencent.mm.plugin.appbrand.u.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.u.a.class)).b(localArrayList, false);
        AppMethodBeat.o(146767);
      }
      
      public final void onKvStat(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(146766);
        ad.d("Luggage.WcWssNativeInstallHelper", "MMWcWss onKvStat logId:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        ((com.tencent.mm.plugin.appbrand.u.b)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.u.b.class)).kvStat(paramAnonymousInt, paramAnonymousString);
        AppMethodBeat.o(146766);
      }
    };
    ((q)localObject1).post(new Runnable()
    {
      public final int doCertificateVerify(String paramAnonymousString1, long paramAnonymousLong, String paramAnonymousString2, byte[][] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(146770);
        if ((e.this.cgG == null) || (e.this.mTrustManager == null))
        {
          e.this.cgG = ((com.tencent.mm.plugin.appbrand.q.a)paramc.ar(com.tencent.mm.plugin.appbrand.q.a.class));
          if (e.this.cgG == null) {
            break label114;
          }
          e.this.mTrustManager = j.b(e.this.cgG);
          if (e.this.mTrustManager == null) {
            ad.e("Luggage.WcWssNativeInstallHelper", "MMWcWss doCertificateVerify getTrustManager fail");
          }
        }
        for (;;)
        {
          int i = e.a(paramAnonymousString2, paramAnonymousArrayOfByte, e.this.mTrustManager);
          AppMethodBeat.o(146770);
          return i;
          label114:
          ad.e("Luggage.WcWssNativeInstallHelper", "MMWcWss doCertificateVerify getConfig fail");
        }
      }
      
      public final void onStateChange(final String paramAnonymousString, final long paramAnonymousLong, int paramAnonymousInt)
      {
        AppMethodBeat.i(146769);
        this.cgK.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(146768);
            ad.d("Luggage.WcWssNativeInstallHelper", "MMWcWss jsThreadHandler run onCallBack contextId:%s", new Object[] { paramAnonymousString });
            WcwssNative.updateInterface(paramAnonymousString, paramAnonymousLong, this.qf);
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
        ad.i("Luggage.WcWssNativeInstallHelper", "createWcWssBinding setCallback ");
        if (e.this.cgE != null)
        {
          ad.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding mContextId != null");
          AppMethodBeat.o(146771);
          return;
        }
        v localv = (v)parami.P(v.class);
        if (localv == null)
        {
          ad.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding v8Addon is null");
          AppMethodBeat.o(146771);
          return;
        }
        e.this.cgE = WcwssNative.initWcwss(localv.getIsolatePtr(), localv.LU(), 0L);
        if (e.this.cgE != null) {
          e.this.cgF = WcwssNative.setCallback(e.this.cgE, this.cgO, this.cgP);
        }
        ad.i("Luggage.WcWssNativeInstallHelper", "createWcWssBinding setCallback mContextId:%s,mInitCallBack:%d", new Object[] { e.this.cgE, Integer.valueOf(e.this.cgF) });
        AppMethodBeat.o(146771);
      }
    });
    AppMethodBeat.o(146777);
  }
  
  public final void b(i parami)
  {
    AppMethodBeat.i(146778);
    ad.i("Luggage.WcWssNativeInstallHelper", "destroyWcWssBinding mContextId:%s", new Object[] { this.cgE });
    if (!this.cgH)
    {
      ad.e("Luggage.WcWssNativeInstallHelper", "destroyWcWssBinding xSwitch false");
      AppMethodBeat.o(146778);
      return;
    }
    if (parami == null)
    {
      ad.e("Luggage.WcWssNativeInstallHelper", "destroyWcWssBinding jsruntime is null");
      AppMethodBeat.o(146778);
      return;
    }
    ((m)parami.P(m.class)).a(this.cgI);
    AppMethodBeat.o(146778);
  }
  
  public final void b(i parami, final com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(146779);
    ad.i("Luggage.WcWssNativeInstallHelper", "initConfigWcWss mContextId:%s", new Object[] { this.cgE });
    if (!this.cgH)
    {
      ad.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss xSwitch false");
      AppMethodBeat.o(146779);
      return;
    }
    if (parami == null)
    {
      ad.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss jsruntime is null");
      AppMethodBeat.o(146779);
      return;
    }
    parami = (q)parami.P(q.class);
    if (parami == null)
    {
      ad.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss jsThreadHandler is null");
      AppMethodBeat.o(146779);
      return;
    }
    parami.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146773);
        ad.i("Luggage.WcWssNativeInstallHelper", "initConfigWcWss initConfig mContextId:%s", new Object[] { e.this.cgE });
        if (e.this.cgE == null)
        {
          ad.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss mContextId is null");
          AppMethodBeat.o(146773);
          return;
        }
        Object localObject = (com.tencent.mm.plugin.appbrand.q.a)paramc.ar(com.tencent.mm.plugin.appbrand.q.a.class);
        if (localObject != null)
        {
          ad.i("Luggage.WcWssNativeInstallHelper", "wcwss mbzType:%s,,websocketTimeoutMS:%d,userAgentString :%s,referer:%s,mode:%d", new Object[] { e.this.cgl, Integer.valueOf(((com.tencent.mm.plugin.appbrand.q.a)localObject).kUq), ((com.tencent.mm.plugin.appbrand.q.a)localObject).kUx, ((com.tencent.mm.plugin.appbrand.q.a)localObject).referer, Integer.valueOf(((com.tencent.mm.plugin.appbrand.q.a)localObject).mode) });
          HashMap localHashMap = new HashMap();
          localHashMap.put("referer", ((com.tencent.mm.plugin.appbrand.q.a)localObject).referer);
          localHashMap.put("User-Agent", ((com.tencent.mm.plugin.appbrand.q.a)localObject).kUx);
          localHashMap.put("bzType", e.this.cgl);
          localHashMap.put("mode", String.valueOf(((com.tencent.mm.plugin.appbrand.q.a)localObject).mode));
          localHashMap.put("timeout", String.valueOf(((com.tencent.mm.plugin.appbrand.q.a)localObject).kUq));
          WcwssNative.initConfig(e.this.cgE, localHashMap);
          if (((com.tencent.mm.plugin.appbrand.q.a)localObject).mode != 0)
          {
            if (((com.tencent.mm.plugin.appbrand.q.a)localObject).mode == 1)
            {
              if ((((com.tencent.mm.plugin.appbrand.q.a)localObject).kUu == null) || (((com.tencent.mm.plugin.appbrand.q.a)localObject).kUu.size() == 0)) {
                ad.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss blacklistHeaders is null");
              }
              for (localObject = null;; localObject = ((com.tencent.mm.plugin.appbrand.q.a)localObject).kUu)
              {
                WcwssNative.initConfigWhiteBlack(e.this.cgE, null, (ArrayList)localObject);
                AppMethodBeat.o(146773);
                return;
              }
            }
            if (((com.tencent.mm.plugin.appbrand.q.a)localObject).mode == 2)
            {
              if ((((com.tencent.mm.plugin.appbrand.q.a)localObject).kUv == null) || (((com.tencent.mm.plugin.appbrand.q.a)localObject).kUv.size() == 0)) {
                ad.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss whitelistHeaders is null");
              }
              for (localObject = null;; localObject = ((com.tencent.mm.plugin.appbrand.q.a)localObject).kUv)
              {
                WcwssNative.initConfigWhiteBlack(e.this.cgE, (ArrayList)localObject, null);
                AppMethodBeat.o(146773);
                return;
              }
            }
            ad.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss invalid mode:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.q.a)localObject).mode) });
            AppMethodBeat.o(146773);
            return;
          }
          ad.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss invalid mode:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.q.a)localObject).mode) });
          AppMethodBeat.o(146773);
          return;
        }
        ad.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss networkConfig is null");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.e
 * JD-Core Version:    0.7.0.1
 */