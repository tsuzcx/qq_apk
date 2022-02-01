package com.tencent.mm.plugin.appbrand.task;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.task.preload.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class n
{
  private final Object lock;
  int nPc;
  final String nQk;
  final Class<? extends Activity> nQl;
  public final String nQm;
  private final Class nQn;
  final Class nQo;
  final Class nQp;
  private final Class nQq;
  private final Class nQr;
  private final o nQs;
  private final Map<String, a> nQt;
  private final Map<String, AppBrandRemoteTaskController> nQu;
  g nQv;
  public final AtomicBoolean nQw;
  
  n(Class<? extends Activity> paramClass, Class paramClass1, Class paramClass2, Class paramClass3, Class paramClass4, Class paramClass5)
  {
    AppMethodBeat.i(48475);
    this.lock = new Object();
    this.nQv = g.nPF;
    this.nPc = -1;
    this.nQw = new AtomicBoolean(false);
    this.nQt = new LinkedHashMap();
    this.nQu = new LinkedHashMap();
    this.nQk = paramClass.getName();
    this.nQl = paramClass;
    this.nQn = paramClass1;
    this.nQo = paramClass2;
    this.nQp = paramClass3;
    this.nQm = aH(this.nQl);
    this.nQq = paramClass4;
    this.nQr = paramClass5;
    this.nQs = new o(this, this.nQm);
    AppMethodBeat.o(48475);
  }
  
  private static String aH(Class<?> paramClass)
  {
    AppMethodBeat.i(48481);
    PackageManager localPackageManager = MMApplicationContext.getContext().getPackageManager();
    if (localPackageManager == null)
    {
      AppMethodBeat.o(48481);
      return null;
    }
    try
    {
      paramClass = localPackageManager.getActivityInfo(new ComponentName(MMApplicationContext.getContext(), paramClass), 128).processName;
      AppMethodBeat.o(48481);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      AppMethodBeat.o(48481);
    }
    return null;
  }
  
  final void R(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(227518);
    if (this.nQn == null)
    {
      AppMethodBeat.o(227518);
      return;
    }
    q.bWB();
    try
    {
      Intent localIntent = new Intent(MMApplicationContext.getContext(), this.nQq);
      AppBrandPreloadProfiler localAppBrandPreloadProfiler = new AppBrandPreloadProfiler();
      localAppBrandPreloadProfiler.bVM();
      localIntent.putExtra("preloadProfiler", localAppBrandPreloadProfiler);
      if (paramBoolean) {
        localIntent.putExtra("EXTRA_KEY_AGGRESSIVE", true);
      }
      localIntent.putExtra("EXTRA_KEY_LEVEL", paramInt);
      localIntent.addFlags(268435456);
      localIntent.putExtra("EXTRA_KEY_TRIGGER_TIME", SystemClock.elapsedRealtime());
      this.nQv.K(localIntent);
      iE(true);
      XIPCInvoker.a(this.nQm, localIntent, d.class, new e()
      {
        public final void axY()
        {
          AppMethodBeat.i(227514);
          Log.w("MicroMsg.AppBrandUITask", "onBridgeNotFound: proc [%s]", new Object[] { n.this.nQm });
          AppMethodBeat.o(227514);
        }
        
        public final void i(Exception paramAnonymousException)
        {
          AppMethodBeat.i(227515);
          Log.e("MicroMsg.AppBrandUITask", "onCaughtInvokeException %s, process:%s", new Object[] { paramAnonymousException, n.this.nQm });
          AppMethodBeat.o(227515);
        }
      });
      AppMethodBeat.o(227518);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(227518);
    }
  }
  
  final void a(String paramString, int paramInt, AppBrandRemoteTaskController paramAppBrandRemoteTaskController)
  {
    AppMethodBeat.i(48478);
    synchronized (this.lock)
    {
      a locala = new a(paramInt, System.currentTimeMillis(), paramAppBrandRemoteTaskController);
      this.nQt.put(paramString, locala);
      this.nQu.put(paramString, paramAppBrandRemoteTaskController);
      AppMethodBeat.o(48478);
      return;
    }
  }
  
  final void afk(String paramString)
  {
    AppMethodBeat.i(227519);
    synchronized (this.lock)
    {
      this.nQt.remove(paramString);
      this.nQu.remove(paramString);
      if (this.nQt.isEmpty()) {
        this.nQv = g.nPF;
      }
      AppMethodBeat.o(227519);
      return;
    }
  }
  
  final Integer afo(String paramString)
  {
    AppMethodBeat.i(48479);
    synchronized (this.lock)
    {
      paramString = (a)this.nQt.get(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(48479);
        return null;
      }
    }
    int i = paramString.eix;
    AppMethodBeat.o(48479);
    return Integer.valueOf(i);
  }
  
  final long afp(String paramString)
  {
    AppMethodBeat.i(227521);
    synchronized (this.lock)
    {
      paramString = (a)this.nQt.get(paramString);
      if (paramString != null)
      {
        long l = paramString.nQy;
        AppMethodBeat.o(227521);
        return l;
      }
    }
    Log.w("MicroMsg.AppBrandUITask", "getStartTByAppID: find startupT=0");
    AppMethodBeat.o(227521);
    return 0L;
  }
  
  final AppBrandRemoteTaskController afq(String paramString)
  {
    AppMethodBeat.i(48480);
    synchronized (this.lock)
    {
      paramString = (AppBrandRemoteTaskController)this.nQu.get(paramString);
      AppMethodBeat.o(48480);
      return paramString;
    }
  }
  
  public final boolean bWA()
  {
    AppMethodBeat.i(258366);
    boolean bool = this.nQw.get();
    AppMethodBeat.o(258366);
    return bool;
  }
  
  final String bWo()
  {
    return this.nQm;
  }
  
  final boolean bWp()
  {
    AppMethodBeat.i(227516);
    synchronized (this.lock)
    {
      boolean bool = this.nQt.isEmpty();
      AppMethodBeat.o(227516);
      return bool;
    }
  }
  
  public final g bWq()
  {
    return this.nQv;
  }
  
  final String bWr()
  {
    return this.nQk;
  }
  
  final Class<? extends Activity> bWs()
  {
    return this.nQl;
  }
  
  final Class bWt()
  {
    return this.nQo;
  }
  
  final Class bWu()
  {
    return this.nQp;
  }
  
  final int bWv()
  {
    return this.nPc;
  }
  
  final Collection<String> bWw()
  {
    AppMethodBeat.i(227520);
    synchronized (this.lock)
    {
      ArrayList localArrayList = new ArrayList(this.nQt.keySet());
      AppMethodBeat.o(227520);
      return localArrayList;
    }
  }
  
  final Collection<AppBrandRemoteTaskController> bWx()
  {
    AppMethodBeat.i(227522);
    synchronized (this.lock)
    {
      ArrayList localArrayList = new ArrayList(this.nQu.values());
      AppMethodBeat.o(227522);
      return localArrayList;
    }
  }
  
  public final Class bWy()
  {
    return this.nQq;
  }
  
  public final Class bWz()
  {
    return this.nQr;
  }
  
  protected boolean c(g paramg)
  {
    return true;
  }
  
  void iB(boolean paramBoolean)
  {
    AppMethodBeat.i(227517);
    R(2, paramBoolean);
    AppMethodBeat.o(227517);
  }
  
  public final void iE(boolean paramBoolean)
  {
    AppMethodBeat.i(227525);
    synchronized (this.nQs)
    {
      if (!this.nQw.get())
      {
        AppBrandMainProcessService.a(this.nQs);
        this.nQs.nQC = paramBoolean;
        AppMethodBeat.o(227525);
        return;
      }
      Log.d("MicroMsg.AppBrandUITask", "preload: name = [%s], had bound!", new Object[] { this.nQm });
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(227524);
    Object localObject = new StringBuilder("AppBrandUITask{mUIProcessName='").append(this.nQm).append('\'').append(", mUsedAs=").append(this.nQv).append(", isProcExisted=").append(this.nQw.get()).append(", isAppAttached=");
    if (!bWp()) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = bool + ", attach appIds=" + this.nQt.toString() + '}';
      AppMethodBeat.o(227524);
      return localObject;
    }
  }
  
  final void z(g paramg)
  {
    AppMethodBeat.i(48476);
    if (!c(paramg))
    {
      paramg = new IllegalStateException("AppBrandUITask not support this type. [" + paramg.name() + "]");
      AppMethodBeat.o(48476);
      throw paramg;
    }
    this.nQv = paramg;
    AppMethodBeat.o(48476);
  }
  
  static final class a
  {
    public final int eix;
    public final long nQy;
    public final AppBrandRemoteTaskController nQz;
    
    public a(int paramInt, long paramLong, AppBrandRemoteTaskController paramAppBrandRemoteTaskController)
    {
      this.eix = paramInt;
      this.nQy = paramLong;
      this.nQz = paramAppBrandRemoteTaskController;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.n
 * JD-Core Version:    0.7.0.1
 */