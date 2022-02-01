package com.tencent.luggage.sdk.b.a.a;

import com.tencent.luggage.a.e;
import com.tencent.mars.cdn.AndroidCertVerifyResult;
import com.tencent.mars.cdn.X509Util;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.m;
import com.tencent.mm.plugin.appbrand.jsruntime.m.a;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.z.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.websocket.libwcwss.WcwssNative;
import com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssReportListener;
import com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssWebSocketListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import javax.net.ssl.X509TrustManager;

public class d
{
  private String cnQ;
  private int cnR;
  private com.tencent.mm.plugin.appbrand.o.a cnS;
  private boolean cnT;
  private WcwssNative cnU;
  private final a cnV;
  private String cny;
  private boolean cnz;
  private X509TrustManager mTrustManager;
  
  public d()
  {
    AppMethodBeat.i(146775);
    this.cnQ = null;
    this.cnR = -1;
    this.cnS = null;
    this.mTrustManager = null;
    this.cnT = false;
    this.cnz = true;
    this.cny = null;
    this.cnV = new a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146772);
        synchronized (d.this)
        {
          if (d.a(d.this) != null)
          {
            ad.i("Luggage.WcWssNativeInstallHelper", "destroyTask destroyWcWssBinding mContextId:%s", new Object[] { d.d(d.this) });
            d.a(d.this).destoryWcwss();
            d.a(d.this, null);
            AppMethodBeat.o(146772);
            return;
          }
          ad.e("Luggage.WcWssNativeInstallHelper", "destroyTask mWcwssNative is null");
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
        ((com.tencent.mm.plugin.appbrand.t.a)e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(972L, 7L, 1L, false);
      }
      if ((localAndroidCertVerifyResult1.getStatus() == 0) && (!localAndroidCertVerifyResult1.isIssuedByHostMatched())) {
        ((com.tencent.mm.plugin.appbrand.t.a)e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(972L, 8L, 1L, false);
      }
      if ((localAndroidCertVerifyResult1.getStatus() == 0) && (!localAndroidCertVerifyResult1.isIssuedByKnownRoot())) {
        ((com.tencent.mm.plugin.appbrand.t.a)e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(972L, 9L, 1L, false);
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
  
  public final void a(final i parami, final c paramc, int paramInt)
  {
    AppMethodBeat.i(146777);
    ad.i("Luggage.WcWssNativeInstallHelper", "createWcWssBinding");
    Object localObject1 = (d.b)paramc.K(d.b.class);
    if (localObject1 != null) {
      this.cnT = ((d.b)localObject1).isOpen();
    }
    if (!this.cnT)
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
    this.cny = String.valueOf(paramInt);
    d.class.getClassLoader();
    com.tencent.mm.compatible.util.j.vr("owl");
    d.class.getClassLoader();
    com.tencent.mm.compatible.util.j.vr("wcwss");
    com.tencent.mm.websocket.libwcwss.a.loadLibraries();
    localObject1 = (q)parami.P(q.class);
    if (localObject1 == null)
    {
      ad.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding jsThreadHandler is null");
      AppMethodBeat.o(146777);
      return;
    }
    final WeakReference localWeakReference = new WeakReference(localObject1);
    Object localObject2 = (b)paramc.K(b.class);
    if (localObject2 != null)
    {
      this.cnz = ((b)localObject2).Ey();
      ad.i("Luggage.WcWssNativeInstallHelper", "createWcWssBinding xLibUVSwitch:%b ", new Object[] { Boolean.valueOf(this.cnz) });
    }
    localObject2 = new WcwssNative.IWcWssReportListener()
    {
      public final int getNetworkType()
      {
        AppMethodBeat.i(146765);
        int i = d.getStatisticsNetType();
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
        ((com.tencent.mm.plugin.appbrand.t.a)e.L(com.tencent.mm.plugin.appbrand.t.a.class)).b(localArrayList, false);
        AppMethodBeat.o(146767);
      }
      
      public final void onKvStat(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(146766);
        ad.d("Luggage.WcWssNativeInstallHelper", "MMWcWss onKvStat logId:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        ((com.tencent.mm.plugin.appbrand.t.b)e.L(com.tencent.mm.plugin.appbrand.t.b.class)).kvStat(paramAnonymousInt, paramAnonymousString);
        AppMethodBeat.o(146766);
      }
    };
    ((q)localObject1).post(new Runnable()
    {
      public final int doCertificateVerify(String paramAnonymousString1, long paramAnonymousLong, String paramAnonymousString2, byte[][] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(146770);
        if ((d.b(d.this) == null) || (d.c(d.this) == null))
        {
          d.a(d.this, (com.tencent.mm.plugin.appbrand.o.a)paramc.ar(com.tencent.mm.plugin.appbrand.o.a.class));
          if (d.b(d.this) == null) {
            break label116;
          }
          d.a(d.this, com.tencent.mm.plugin.appbrand.o.j.b(d.b(d.this)));
          if (d.c(d.this) == null) {
            ad.e("Luggage.WcWssNativeInstallHelper", "MMWcWss doCertificateVerify getTrustManager fail");
          }
        }
        for (;;)
        {
          int i = d.a(paramAnonymousString2, paramAnonymousArrayOfByte, d.c(d.this));
          AppMethodBeat.o(146770);
          return i;
          label116:
          ad.e("Luggage.WcWssNativeInstallHelper", "MMWcWss doCertificateVerify getConfig fail");
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
            ad.d("Luggage.WcWssNativeInstallHelper", "MMWcWss jsThreadHandler run onCallBack contextId:%s", new Object[] { paramAnonymousString });
            d.a(d.this).updateInterface(paramAnonymousLong, this.ta);
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
        if (d.d(d.this) != null)
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
        d.a(d.this, new WcwssNative());
        if (d.a(d.this) != null)
        {
          if (d.e(d.this)) {
            d.a(d.this, d.a(d.this).initWcwss(localv.getIsolatePtr(), localv.NB(), 0L));
          }
          for (;;)
          {
            d.a(d.this, d.a(d.this).setCallback(this.coa, this.cob));
            ad.i("Luggage.WcWssNativeInstallHelper", "createWcWssBinding setCallback mContextId:%s,mInitCallBack:%d", new Object[] { d.d(d.this), Integer.valueOf(d.f(d.this)) });
            AppMethodBeat.o(146771);
            return;
            d.a(d.this, d.a(d.this).initWcwss(localv.getIsolatePtr(), localv.NB(), 0L));
          }
        }
        ad.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding mWcwssNative = null");
        AppMethodBeat.o(146771);
      }
    });
    AppMethodBeat.o(146777);
  }
  
  public final void b(i parami)
  {
    AppMethodBeat.i(146778);
    ad.i("Luggage.WcWssNativeInstallHelper", "destroyWcWssBinding mContextId:%s", new Object[] { this.cnQ });
    if (!this.cnT)
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
    ((m)parami.P(m.class)).a(this.cnV);
    AppMethodBeat.o(146778);
  }
  
  public final void b(i parami, final c paramc)
  {
    AppMethodBeat.i(146779);
    ad.i("Luggage.WcWssNativeInstallHelper", "initConfigWcWss mContextId:%s", new Object[] { this.cnQ });
    if (!this.cnT)
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
        ad.i("Luggage.WcWssNativeInstallHelper", "initConfigWcWss initConfig mContextId:%s", new Object[] { d.d(d.this) });
        if (d.a(d.this) == null)
        {
          ad.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss mWcwssNative is null");
          AppMethodBeat.o(146773);
          return;
        }
        Object localObject = (com.tencent.mm.plugin.appbrand.o.a)paramc.ar(com.tencent.mm.plugin.appbrand.o.a.class);
        if (localObject != null)
        {
          ad.i("Luggage.WcWssNativeInstallHelper", "wcwss mbzType:%s,,websocketTimeoutMS:%d,userAgentString :%s,referer:%s,mode:%d", new Object[] { d.g(d.this), Integer.valueOf(((com.tencent.mm.plugin.appbrand.o.a)localObject).lVn), ((com.tencent.mm.plugin.appbrand.o.a)localObject).lVu, ((com.tencent.mm.plugin.appbrand.o.a)localObject).referer, Integer.valueOf(((com.tencent.mm.plugin.appbrand.o.a)localObject).mode) });
          HashMap localHashMap = new HashMap();
          localHashMap.put("referer", ((com.tencent.mm.plugin.appbrand.o.a)localObject).referer);
          localHashMap.put("User-Agent", ((com.tencent.mm.plugin.appbrand.o.a)localObject).lVu);
          localHashMap.put("bzType", d.g(d.this));
          localHashMap.put("mode", String.valueOf(((com.tencent.mm.plugin.appbrand.o.a)localObject).mode));
          localHashMap.put("timeout", String.valueOf(((com.tencent.mm.plugin.appbrand.o.a)localObject).lVn));
          d.a(d.this).initConfig(localHashMap);
          if (((com.tencent.mm.plugin.appbrand.o.a)localObject).mode != 0)
          {
            if (((com.tencent.mm.plugin.appbrand.o.a)localObject).mode == 1)
            {
              if ((((com.tencent.mm.plugin.appbrand.o.a)localObject).lVr == null) || (((com.tencent.mm.plugin.appbrand.o.a)localObject).lVr.size() == 0)) {
                ad.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss blacklistHeaders is null");
              }
              for (localObject = null;; localObject = ((com.tencent.mm.plugin.appbrand.o.a)localObject).lVr)
              {
                d.a(d.this).initConfigWhiteBlack(null, (ArrayList)localObject);
                AppMethodBeat.o(146773);
                return;
              }
            }
            if (((com.tencent.mm.plugin.appbrand.o.a)localObject).mode == 2)
            {
              if ((((com.tencent.mm.plugin.appbrand.o.a)localObject).lVs == null) || (((com.tencent.mm.plugin.appbrand.o.a)localObject).lVs.size() == 0)) {
                ad.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss whitelistHeaders is null");
              }
              for (localObject = null;; localObject = ((com.tencent.mm.plugin.appbrand.o.a)localObject).lVs)
              {
                d.a(d.this).initConfigWhiteBlack((ArrayList)localObject, null);
                AppMethodBeat.o(146773);
                return;
              }
            }
            ad.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss invalid mode:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.o.a)localObject).mode) });
            AppMethodBeat.o(146773);
            return;
          }
          ad.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss invalid mode:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.o.a)localObject).mode) });
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */