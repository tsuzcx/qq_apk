package com.tencent.luggage.sdk.e;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.MiniProgramNavigationBackResult;
import com.tencent.mm.plugin.appbrand.ap;
import com.tencent.mm.plugin.appbrand.appcache.AssetReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appcache.k.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.ac;
import com.tencent.mm.plugin.appbrand.appstorage.u;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.jsapi.file.ax;
import com.tencent.mm.plugin.appbrand.page.ab;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.permission.d.a;
import com.tencent.mm.plugin.appbrand.permission.d.b;
import com.tencent.mm.plugin.appbrand.permission.k;
import com.tencent.mm.plugin.appbrand.permission.l;
import com.tencent.mm.plugin.appbrand.permission.m;
import com.tencent.mm.plugin.appbrand.permission.o;
import com.tencent.mm.plugin.appbrand.q.g.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.aa;
import com.tencent.mm.plugin.appbrand.ui.aa.1;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class d
  extends AppBrandRuntime
{
  public aa evu;
  private Boolean evv = null;
  public volatile com.tencent.mm.plugin.appbrand.permission.d evw;
  
  static
  {
    AppMethodBeat.i(182987);
    WxaPkgWrappingInfo.a(g.a.tmH);
    AppMethodBeat.o(182987);
  }
  
  public d(ap paramap)
  {
    super(paramap);
  }
  
  protected d(com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    super(paramc);
  }
  
  private static boolean c(AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    AppMethodBeat.i(146913);
    if ((paramAppBrandInitConfigLU.eoX) && ((e(paramAppBrandInitConfigLU)) || (d(paramAppBrandInitConfigLU))))
    {
      AppMethodBeat.o(146913);
      return true;
    }
    AppMethodBeat.o(146913);
    return false;
  }
  
  private static boolean d(AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    return paramAppBrandInitConfigLU.epn.scene == 1101;
  }
  
  private static boolean e(AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    paramAppBrandInitConfigLU = paramAppBrandInitConfigLU.epn;
    return (paramAppBrandInitConfigLU.scene == 1011) || (paramAppBrandInitConfigLU.scene == 1012) || (paramAppBrandInitConfigLU.scene == 1013);
  }
  
  public final void a(AppBrandInitConfigLU paramAppBrandInitConfigLU, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(220230);
    if ((paramAppBrandInitConfigLU == null) || (paramAppBrandStatObject == null))
    {
      AppMethodBeat.o(220230);
      return;
    }
    ap localap = this.qsc;
    if (localap == null)
    {
      Log.e("Luggage.WXA.AppBrandRuntimeLU", "load with self.appId[%s] config[%s] stat[%d], skip by NULL container", new Object[] { this.mAppId, paramAppBrandInitConfigLU.appId, Integer.valueOf(paramAppBrandStatObject.scene) });
      AppMethodBeat.o(220230);
      return;
    }
    if ((localap instanceof b))
    {
      ((b)localap).a(this, paramAppBrandInitConfigLU, paramAppBrandStatObject);
      AppMethodBeat.o(220230);
      return;
    }
    if ((localap instanceof c))
    {
      AppMethodBeat.o(220230);
      throw null;
    }
    localap.a(this, paramAppBrandInitConfigLU);
    AppMethodBeat.o(220230);
  }
  
  public void a(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(146899);
    if (!this.mInitialized)
    {
      AppMethodBeat.o(146899);
      return;
    }
    boolean bool1 = arD();
    boolean bool2 = c((AppBrandInitConfigLU)paramAppBrandInitConfig);
    int i;
    if (((!bool1) && (bool2)) || ((bool1) && (!bool2) && (e((AppBrandInitConfigLU)paramAppBrandInitConfig))))
    {
      i = 1;
      if (i != 0)
      {
        this.evv = null;
        cbJ();
      }
      if ((!this.qsF) && (!this.qsE.get()))
      {
        if ((k.a.zn(this.qsh.eul)) && (((AppBrandInitConfigLU)paramAppBrandInitConfig).appVersion != asz().qYY.pkgVersion))
        {
          Log.w("Luggage.WXA.AppBrandRuntimeLU", String.format(Locale.ENGLISH, "Updated InitConfig.appVersion(%d) != getSysConfig().appVersion(%d), appId:%s", new Object[] { Integer.valueOf(((AppBrandInitConfigLU)paramAppBrandInitConfig).appVersion), Integer.valueOf(asz().qYY.pkgVersion), this.mAppId }));
          cbJ();
        }
        if ((!this.qsF) && (b(paramAppBrandInitConfig)))
        {
          if (!this.qsF) {
            break label238;
          }
          Log.w("MicroMsg.AppBrandRuntime", "setWillRelaunch appId:%s, ignore by willRestart", new Object[] { this.mAppId });
        }
      }
    }
    for (;;)
    {
      super.a(paramAppBrandInitConfig);
      AppMethodBeat.o(146899);
      return;
      i = 0;
      break;
      label238:
      this.qsG = true;
      Log.i("MicroMsg.AppBrandRuntime", "setWillRelaunch appId:%s", new Object[] { this.mAppId });
    }
  }
  
  public void a(AppBrandInitConfig paramAppBrandInitConfig, Object paramObject)
  {
    AppMethodBeat.i(169456);
    for (;;)
    {
      MiniProgramNavigationBackResult localMiniProgramNavigationBackResult;
      try
      {
        MiniProgramNavigationBackResult.class.cast(paramObject);
        AppBrandInitConfigLU localAppBrandInitConfigLU = asA().aqN();
        AppBrandLaunchReferrer localAppBrandLaunchReferrer1 = localAppBrandInitConfigLU.eoV;
        localMiniProgramNavigationBackResult = (MiniProgramNavigationBackResult)paramObject;
        AppBrandLaunchReferrer localAppBrandLaunchReferrer2 = new AppBrandLaunchReferrer();
        localAppBrandLaunchReferrer2.appId = paramAppBrandInitConfig.appId;
        localAppBrandLaunchReferrer2.qYE = 3;
        if (localMiniProgramNavigationBackResult == null)
        {
          paramObject = null;
          localAppBrandLaunchReferrer2.hRR = paramObject;
          if (localMiniProgramNavigationBackResult != null) {
            break label230;
          }
          paramObject = null;
          localAppBrandLaunchReferrer2.qYF = paramObject;
          localAppBrandLaunchReferrer1.a(localAppBrandLaunchReferrer2);
          paramObject = new AppBrandStatObject();
          paramObject.scene = 1038;
          if ((paramAppBrandInitConfig instanceof AppBrandInitConfigLU)) {
            paramObject.hzx = (paramAppBrandInitConfig.appId + ':' + ((AppBrandInitConfigLU)paramAppBrandInitConfig).eoP + ':' + (((AppBrandInitConfigLU)paramAppBrandInitConfig).appServiceType + 1000));
          }
          localAppBrandInitConfigLU.startTime = Util.nowMilliSecond();
          localAppBrandInitConfigLU.qAF = null;
          localAppBrandInitConfigLU.aqI();
          localAppBrandInitConfigLU.epn = paramObject;
          d(localAppBrandInitConfigLU);
          AppMethodBeat.o(169456);
          return;
        }
      }
      catch (ClassCastException paramAppBrandInitConfig)
      {
        paramAppBrandInitConfig = new IllegalStateException("Only data as MiniProgramNavigationBackResult acceptable here.", paramAppBrandInitConfig);
        AppMethodBeat.o(169456);
        throw paramAppBrandInitConfig;
      }
      paramObject = localMiniProgramNavigationBackResult.qxT.toString();
      continue;
      label230:
      paramObject = localMiniProgramNavigationBackResult.qxU.toString();
    }
  }
  
  public final <T extends com.tencent.mm.kernel.c.a> T ae(Class<T> paramClass)
  {
    AppMethodBeat.i(169457);
    if (l.class == paramClass)
    {
      paramClass = (com.tencent.mm.kernel.c.a)paramClass.cast(o.tEJ);
      AppMethodBeat.o(169457);
      return paramClass;
    }
    if (k.class == paramClass)
    {
      m localm = new m(this);
      b(k.class, localm);
      paramClass = (com.tencent.mm.kernel.c.a)paramClass.cast(localm);
      AppMethodBeat.o(169457);
      return paramClass;
    }
    paramClass = super.ae(paramClass);
    AppMethodBeat.o(169457);
    return paramClass;
  }
  
  public boolean arD()
  {
    AppMethodBeat.i(146912);
    if (this.evv != null)
    {
      bool = this.evv.booleanValue();
      AppMethodBeat.o(146912);
      return bool;
    }
    Boolean localBoolean = Boolean.valueOf(c(asA()));
    this.evv = localBoolean;
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(146912);
    return bool;
  }
  
  public AppBrandInitConfigLU asA()
  {
    AppMethodBeat.i(146904);
    AppBrandInitConfigLU localAppBrandInitConfigLU = (AppBrandInitConfigLU)super.asH();
    AppMethodBeat.o(146904);
    return localAppBrandInitConfigLU;
  }
  
  public void asB()
  {
    AppMethodBeat.i(146909);
    super.asB();
    if (ax(ICommLibReader.class) == null) {
      b(ICommLibReader.class, AssetReader.qDV);
    }
    a(new ab((ICommLibReader)ax(ICommLibReader.class), bl.R(this)));
    a(new com.tencent.luggage.sdk.config.c(this));
    if (this.evw == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Should ensure ApiPermissionController installed before init. Use #setApiPermissionController().");
      AppMethodBeat.o(146909);
      throw localIllegalStateException;
    }
    if (((asF()) || (4 == asA().appServiceType)) && (TextUtils.isEmpty(asA().qAF)) && (!TextUtils.isEmpty(asA().eoR))) {
      asA().qAF = asA().eoR;
    }
    AppMethodBeat.o(146909);
  }
  
  protected aa asC()
  {
    AppMethodBeat.i(146911);
    aa localaa = new aa(AndroidContextUtil.castActivityOrNull(this.mContext), this);
    AppMethodBeat.o(146911);
    return localaa;
  }
  
  public com.tencent.mm.plugin.appbrand.q.a asD()
  {
    AppMethodBeat.i(146914);
    if ((asz() != null) && ((!Util.isNullOrNil(asz().qYY.qHR)) || (asA().aqJ()))) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = new com.tencent.mm.plugin.appbrand.q.f(this);
      AppMethodBeat.o(146914);
      return localObject;
    }
    Object localObject = new a.a(this, (byte)0);
    AppMethodBeat.o(146914);
    return localObject;
  }
  
  public final boolean asE()
  {
    AppMethodBeat.i(220277);
    if (this.qsE.get())
    {
      AppMethodBeat.o(220277);
      return false;
    }
    boolean bool = asA().epm.arX();
    AppMethodBeat.o(220277);
    return bool;
  }
  
  public final boolean asF()
  {
    AppMethodBeat.i(220281);
    if (this.qsE.get())
    {
      AppMethodBeat.o(220281);
      return false;
    }
    if (com.tencent.luggage.sdk.launching.e.etK == asA().epm)
    {
      AppMethodBeat.o(220281);
      return true;
    }
    AppMethodBeat.o(220281);
    return false;
  }
  
  public final int asw()
  {
    AppMethodBeat.i(146897);
    if (k.a.vK(this.qsh.eul))
    {
      AppMethodBeat.o(146897);
      return 0;
    }
    int i = asA().appVersion;
    AppMethodBeat.o(146897);
    return i;
  }
  
  public final ax asx()
  {
    AppMethodBeat.i(146901);
    ax localax = (ax)super.getFileSystem();
    AppMethodBeat.o(146901);
    return localax;
  }
  
  public w asy()
  {
    AppMethodBeat.i(146902);
    Object localObject = asz();
    if (localObject == null) {
      Log.e("Luggage.WXA.AppBrandRuntimeLU", "createFileSystem but get NUL sysConfig, appId:%s", new Object[] { this.mAppId });
    }
    for (localObject = new com.tencent.mm.plugin.appbrand.jsapi.file.d();; localObject = com.tencent.mm.plugin.appbrand.config.f.a((AppBrandSysConfigLU)localObject))
    {
      localObject = new ax(this, (com.tencent.mm.plugin.appbrand.jsapi.file.d)localObject);
      AppMethodBeat.o(146902);
      return localObject;
    }
  }
  
  public AppBrandSysConfigLU asz()
  {
    AppMethodBeat.i(146903);
    AppBrandSysConfigLU localAppBrandSysConfigLU = (AppBrandSysConfigLU)d(AppBrandSysConfigLU.class, false);
    AppMethodBeat.o(146903);
    return localAppBrandSysConfigLU;
  }
  
  protected boolean b(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(146900);
    if (!TextUtils.isEmpty(paramAppBrandInitConfig.qAF))
    {
      AppMethodBeat.o(146900);
      return true;
    }
    AppMethodBeat.o(146900);
    return false;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(146908);
    super.onCreate();
    com.tencent.luggage.sdk.processes.client.a locala = com.tencent.luggage.sdk.processes.client.a.euD;
    com.tencent.luggage.sdk.processes.client.a.b(this);
    com.tencent.mm.plugin.appbrand.ipc.c.cpt();
    AppMethodBeat.o(146908);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(146910);
    super.onDestroy();
    ??? = com.tencent.luggage.sdk.processes.client.a.euD;
    com.tencent.luggage.sdk.processes.client.a.c(this);
    if (this.evu != null)
    {
      if ((this.evu.getParent() instanceof ViewGroup))
      {
        ??? = this.evu;
        AppBrandPerformanceManager.afk(((aa)???).etN.mAppId);
        ((aa)???).animate().alpha(0.0F).setDuration(500L).setListener(new aa.1((aa)???));
        ((ViewGroup)this.evu.getParent()).removeView(this.evu);
      }
      this.evu = null;
    }
    Object localObject2;
    if (this.evw != null) {
      localObject2 = this.evw;
    }
    synchronized (((com.tencent.mm.plugin.appbrand.permission.d)localObject2).tEq)
    {
      ((com.tencent.mm.plugin.appbrand.permission.d)localObject2).tEq.clear();
      this.evw = null;
      ??? = (ax)super.getFileSystem();
      if (??? != null)
      {
        localObject2 = (u)((ac)???).aR(u.class);
        if (localObject2 != null) {
          y.deleteFile(((u)localObject2).qMI + "/dir.lock");
        }
        ((ac)???).release();
      }
      AppMethodBeat.o(146910);
      return;
    }
  }
  
  public void onReady()
  {
    AppMethodBeat.i(146907);
    super.onReady();
    if ((AppBrandPerformanceManager.k(this)) && (this.evu == null))
    {
      AppBrandPerformanceManager.j(this);
      this.evu = asC();
      if (this.evu != null)
      {
        this.qsk.addView(this.evu);
        aa localaa = this.evu;
        AppBrandPerformanceManager.l(localaa.etN);
        localaa.setVisibility(0);
        localaa.setAlpha(0.0F);
        localaa.animate().alpha(1.0F).setDuration(500L).setStartDelay(500L).setListener(null);
      }
    }
    AppMethodBeat.o(146907);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(146898);
    super.onResume();
    com.tencent.mm.plugin.appbrand.permission.d locald = this.evw;
    LinkedList localLinkedList = new LinkedList();
    synchronized (locald.tEq)
    {
      localLinkedList.addAll(locald.tEq);
      locald.tEq.clear();
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((d.b)((Iterator)???).next()).a(d.a.cGP());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.e.d
 * JD-Core Version:    0.7.0.1
 */