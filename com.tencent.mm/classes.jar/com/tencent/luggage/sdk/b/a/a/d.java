package com.tencent.luggage.sdk.b.a.a;

import com.tencent.luggage.a.e;
import com.tencent.mars.cdn.AndroidCertVerifyResult;
import com.tencent.mars.cdn.X509Util;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.m;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.websocket.libwcwss.WcwssNative;
import com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssReportListener;
import com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssWebSocketListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import javax.net.ssl.X509TrustManager;

public class d
{
  private String cnA;
  private boolean cnB;
  private String cnS;
  private int cnT;
  private com.tencent.mm.plugin.appbrand.o.a cnU;
  private boolean cnV;
  private WcwssNative cnW;
  private final d.a cnX;
  private X509TrustManager mTrustManager;
  
  public d()
  {
    AppMethodBeat.i(146775);
    this.cnS = null;
    this.cnT = -1;
    this.cnU = null;
    this.mTrustManager = null;
    this.cnV = false;
    this.cnB = true;
    this.cnA = null;
    this.cnX = new d.a(this, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146772);
        synchronized (d.this)
        {
          if (d.a(d.this) != null)
          {
            ae.i("Luggage.WcWssNativeInstallHelper", "destroyTask destroyWcWssBinding mContextId:%s", new Object[] { d.d(d.this) });
            d.a(d.this).destoryWcwss();
            d.a(d.this, null);
            AppMethodBeat.o(146772);
            return;
          }
          ae.e("Luggage.WcWssNativeInstallHelper", "destroyTask mWcwssNative is null");
        }
      }
    });
    AppMethodBeat.o(146775);
  }
  
  public static int a(String paramString, byte[][] paramArrayOfByte, X509TrustManager paramX509TrustManager)
  {
    AppMethodBeat.i(146781);
    ae.i("Luggage.WcWssNativeInstallHelper", "certifivate verify for ".concat(String.valueOf(paramString)));
    try
    {
      AndroidCertVerifyResult localAndroidCertVerifyResult2 = X509Util.verifyServerCertificates(paramArrayOfByte, "RSA", paramString, 1, paramX509TrustManager);
      ae.i("Luggage.WcWssNativeInstallHelper", "host %s rsa verify result %d, isknownroots %b, ishostmatched %b", new Object[] { paramString, Integer.valueOf(localAndroidCertVerifyResult2.getStatus()), Boolean.valueOf(localAndroidCertVerifyResult2.isIssuedByKnownRoot()), Boolean.valueOf(localAndroidCertVerifyResult2.isIssuedByHostMatched()) });
      AndroidCertVerifyResult localAndroidCertVerifyResult1 = localAndroidCertVerifyResult2;
      if (localAndroidCertVerifyResult2.getStatus() != 0)
      {
        localAndroidCertVerifyResult1 = X509Util.verifyServerCertificates(paramArrayOfByte, "ECDSA", paramString, 1, paramX509TrustManager);
        ae.i("Luggage.WcWssNativeInstallHelper", "host %s ecdsa verify result %d, isknownroots %b, ishostmatched %b", new Object[] { paramString, Integer.valueOf(localAndroidCertVerifyResult1.getStatus()), Boolean.valueOf(localAndroidCertVerifyResult1.isIssuedByKnownRoot()), Boolean.valueOf(localAndroidCertVerifyResult1.isIssuedByHostMatched()) });
      }
      if (localAndroidCertVerifyResult1.getStatus() != 0) {
        ((com.tencent.mm.plugin.appbrand.s.a)e.L(com.tencent.mm.plugin.appbrand.s.a.class)).idkeyStat(972L, 7L, 1L, false);
      }
      if ((localAndroidCertVerifyResult1.getStatus() == 0) && (!localAndroidCertVerifyResult1.isIssuedByHostMatched())) {
        ((com.tencent.mm.plugin.appbrand.s.a)e.L(com.tencent.mm.plugin.appbrand.s.a.class)).idkeyStat(972L, 8L, 1L, false);
      }
      if ((localAndroidCertVerifyResult1.getStatus() == 0) && (!localAndroidCertVerifyResult1.isIssuedByKnownRoot())) {
        ((com.tencent.mm.plugin.appbrand.s.a)e.L(com.tencent.mm.plugin.appbrand.s.a.class)).idkeyStat(972L, 9L, 1L, false);
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
      ae.printErrStackTrace("Luggage.WcWssNativeInstallHelper", paramString, "doCertificateVerify Exception", new Object[0]);
      AppMethodBeat.o(146781);
    }
    return -1;
  }
  
  public static int getStatisticsNetType()
  {
    AppMethodBeat.i(146780);
    try
    {
      int i = az.getNetType(ak.getContext());
      ae.i("Luggage.WcWssNativeInstallHelper", "getStatisticsNetType ret:%d", new Object[] { Integer.valueOf(i) });
      if (i == -1)
      {
        AppMethodBeat.o(146780);
        return -1;
      }
      boolean bool = az.is2G(ak.getContext());
      if (bool)
      {
        AppMethodBeat.o(146780);
        return 3;
      }
      bool = az.is3G(ak.getContext());
      if (bool)
      {
        AppMethodBeat.o(146780);
        return 4;
      }
      bool = az.is4G(ak.getContext());
      if (bool)
      {
        AppMethodBeat.o(146780);
        return 5;
      }
      bool = az.isWifi(i);
      if (bool)
      {
        AppMethodBeat.o(146780);
        return 1;
      }
      bool = az.isWap(i);
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
      ae.printErrStackTrace("Luggage.WcWssNativeInstallHelper", localException, "getStatisticsNetType_", new Object[0]);
      AppMethodBeat.o(146780);
    }
    return -1;
  }
  
  public final void a(final i parami, final c paramc, int paramInt)
  {
    AppMethodBeat.i(146777);
    ae.i("Luggage.WcWssNativeInstallHelper", "createWcWssBinding");
    Object localObject1 = (b)paramc.K(b.class);
    if (localObject1 != null) {
      this.cnV = ((b)localObject1).isOpen();
    }
    if (!this.cnV)
    {
      ae.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding xSwitch false");
      AppMethodBeat.o(146777);
      return;
    }
    if (parami == null)
    {
      ae.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding jsruntime is null");
      AppMethodBeat.o(146777);
      return;
    }
    this.cnA = String.valueOf(paramInt);
    d.class.getClassLoader();
    com.tencent.mm.compatible.util.j.vN("owl");
    d.class.getClassLoader();
    com.tencent.mm.compatible.util.j.vN("wcwss");
    com.tencent.mm.websocket.libwcwss.a.loadLibraries();
    localObject1 = (q)parami.P(q.class);
    if (localObject1 == null)
    {
      ae.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding jsThreadHandler is null");
      AppMethodBeat.o(146777);
      return;
    }
    final WeakReference localWeakReference = new WeakReference(localObject1);
    Object localObject2 = (b)paramc.K(b.class);
    if (localObject2 != null)
    {
      this.cnB = ((b)localObject2).EA();
      ae.i("Luggage.WcWssNativeInstallHelper", "createWcWssBinding xLibUVSwitch:%b ", new Object[] { Boolean.valueOf(this.cnB) });
    }
    localObject2 = new d.1(this);
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
            ae.e("Luggage.WcWssNativeInstallHelper", "MMWcWss doCertificateVerify getTrustManager fail");
          }
        }
        for (;;)
        {
          int i = d.a(paramAnonymousString2, paramAnonymousArrayOfByte, d.c(d.this));
          AppMethodBeat.o(146770);
          return i;
          label116:
          ae.e("Luggage.WcWssNativeInstallHelper", "MMWcWss doCertificateVerify getConfig fail");
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
            ae.d("Luggage.WcWssNativeInstallHelper", "MMWcWss jsThreadHandler run onCallBack contextId:%s", new Object[] { paramAnonymousString });
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
        ae.i("Luggage.WcWssNativeInstallHelper", "createWcWssBinding setCallback ");
        if (d.d(d.this) != null)
        {
          ae.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding mContextId != null");
          AppMethodBeat.o(146771);
          return;
        }
        v localv = (v)parami.P(v.class);
        if (localv == null)
        {
          ae.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding v8Addon is null");
          AppMethodBeat.o(146771);
          return;
        }
        d.a(d.this, new WcwssNative());
        if (d.a(d.this) != null)
        {
          if (d.e(d.this)) {
            d.a(d.this, d.a(d.this).initWcwss(localv.getIsolatePtr(), localv.Nz(), 0L));
          }
          for (;;)
          {
            d.a(d.this, d.a(d.this).setCallback(this.coc, this.cod));
            ae.i("Luggage.WcWssNativeInstallHelper", "createWcWssBinding setCallback mContextId:%s,mInitCallBack:%d", new Object[] { d.d(d.this), Integer.valueOf(d.f(d.this)) });
            AppMethodBeat.o(146771);
            return;
            d.a(d.this, d.a(d.this).initWcwss(localv.getIsolatePtr(), localv.Nz(), 0L));
          }
        }
        ae.e("Luggage.WcWssNativeInstallHelper", "createWcWssBinding mWcwssNative = null");
        AppMethodBeat.o(146771);
      }
    });
    AppMethodBeat.o(146777);
  }
  
  public final void b(i parami)
  {
    AppMethodBeat.i(146778);
    ae.i("Luggage.WcWssNativeInstallHelper", "destroyWcWssBinding mContextId:%s", new Object[] { this.cnS });
    if (!this.cnV)
    {
      ae.e("Luggage.WcWssNativeInstallHelper", "destroyWcWssBinding xSwitch false");
      AppMethodBeat.o(146778);
      return;
    }
    if (parami == null)
    {
      ae.e("Luggage.WcWssNativeInstallHelper", "destroyWcWssBinding jsruntime is null");
      AppMethodBeat.o(146778);
      return;
    }
    ((m)parami.P(m.class)).a(this.cnX);
    AppMethodBeat.o(146778);
  }
  
  public final void b(i parami, final c paramc)
  {
    AppMethodBeat.i(146779);
    ae.i("Luggage.WcWssNativeInstallHelper", "initConfigWcWss mContextId:%s", new Object[] { this.cnS });
    if (!this.cnV)
    {
      ae.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss xSwitch false");
      AppMethodBeat.o(146779);
      return;
    }
    if (parami == null)
    {
      ae.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss jsruntime is null");
      AppMethodBeat.o(146779);
      return;
    }
    parami = (q)parami.P(q.class);
    if (parami == null)
    {
      ae.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss jsThreadHandler is null");
      AppMethodBeat.o(146779);
      return;
    }
    parami.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146773);
        ae.i("Luggage.WcWssNativeInstallHelper", "initConfigWcWss initConfig mContextId:%s", new Object[] { d.d(d.this) });
        if (d.a(d.this) == null)
        {
          ae.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss mWcwssNative is null");
          AppMethodBeat.o(146773);
          return;
        }
        Object localObject = (com.tencent.mm.plugin.appbrand.o.a)paramc.ar(com.tencent.mm.plugin.appbrand.o.a.class);
        if (localObject != null)
        {
          ae.i("Luggage.WcWssNativeInstallHelper", "wcwss mbzType:%s,,websocketTimeoutMS:%d,userAgentString :%s,referer:%s,mode:%d", new Object[] { d.g(d.this), Integer.valueOf(((com.tencent.mm.plugin.appbrand.o.a)localObject).lZQ), ((com.tencent.mm.plugin.appbrand.o.a)localObject).lZX, ((com.tencent.mm.plugin.appbrand.o.a)localObject).referer, Integer.valueOf(((com.tencent.mm.plugin.appbrand.o.a)localObject).mode) });
          HashMap localHashMap = new HashMap();
          localHashMap.put("referer", ((com.tencent.mm.plugin.appbrand.o.a)localObject).referer);
          localHashMap.put("User-Agent", ((com.tencent.mm.plugin.appbrand.o.a)localObject).lZX);
          localHashMap.put("bzType", d.g(d.this));
          localHashMap.put("mode", String.valueOf(((com.tencent.mm.plugin.appbrand.o.a)localObject).mode));
          localHashMap.put("timeout", String.valueOf(((com.tencent.mm.plugin.appbrand.o.a)localObject).lZQ));
          d.a(d.this).initConfig(localHashMap);
          if (((com.tencent.mm.plugin.appbrand.o.a)localObject).mode != 0)
          {
            if (((com.tencent.mm.plugin.appbrand.o.a)localObject).mode == 1)
            {
              if ((((com.tencent.mm.plugin.appbrand.o.a)localObject).lZU == null) || (((com.tencent.mm.plugin.appbrand.o.a)localObject).lZU.size() == 0)) {
                ae.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss blacklistHeaders is null");
              }
              for (localObject = null;; localObject = ((com.tencent.mm.plugin.appbrand.o.a)localObject).lZU)
              {
                d.a(d.this).initConfigWhiteBlack(null, (ArrayList)localObject);
                AppMethodBeat.o(146773);
                return;
              }
            }
            if (((com.tencent.mm.plugin.appbrand.o.a)localObject).mode == 2)
            {
              if ((((com.tencent.mm.plugin.appbrand.o.a)localObject).lZV == null) || (((com.tencent.mm.plugin.appbrand.o.a)localObject).lZV.size() == 0)) {
                ae.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss whitelistHeaders is null");
              }
              for (localObject = null;; localObject = ((com.tencent.mm.plugin.appbrand.o.a)localObject).lZV)
              {
                d.a(d.this).initConfigWhiteBlack((ArrayList)localObject, null);
                AppMethodBeat.o(146773);
                return;
              }
            }
            ae.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss invalid mode:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.o.a)localObject).mode) });
            AppMethodBeat.o(146773);
            return;
          }
          ae.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss invalid mode:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.o.a)localObject).mode) });
          AppMethodBeat.o(146773);
          return;
        }
        ae.e("Luggage.WcWssNativeInstallHelper", "initConfigWcWss networkConfig is null");
        AppMethodBeat.o(146773);
      }
    });
    AppMethodBeat.o(146779);
  }
  
  public static abstract interface b
    extends com.tencent.luggage.a.b
  {
    public abstract boolean isOpen();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */