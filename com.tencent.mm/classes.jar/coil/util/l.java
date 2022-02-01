package coil.util;

import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import coil.b.b;
import coil.f;
import coil.memory.n;
import coil.memory.r;
import coil.memory.u;
import coil.network.c;
import coil.network.c.a;
import coil.network.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/util/SystemCallbacks;", "Landroid/content/ComponentCallbacks2;", "Lcoil/network/NetworkObserver$Listener;", "imageLoader", "Lcoil/RealImageLoader;", "context", "Landroid/content/Context;", "isNetworkObserverEnabled", "", "(Lcoil/RealImageLoader;Landroid/content/Context;Z)V", "_isOnline", "_isShutdown", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getImageLoader$coil_base_release$annotations", "()V", "getImageLoader$coil_base_release", "()Ljava/lang/ref/WeakReference;", "isOnline", "()Z", "isShutdown", "networkObserver", "Lcoil/network/NetworkObserver;", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onConnectivityChange", "onLowMemory", "onTrimMemory", "level", "", "shutdown", "Companion", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  implements ComponentCallbacks2, c.b
{
  public static final l.a cqv;
  private final Context context;
  private final WeakReference<f> cqw;
  private final c cqx;
  public volatile boolean cqy;
  private final AtomicBoolean cqz;
  
  static
  {
    AppMethodBeat.i(188112);
    cqv = new l.a((byte)0);
    AppMethodBeat.o(188112);
  }
  
  public l(f paramf, Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(188096);
    this.context = paramContext;
    this.cqw = new WeakReference(paramf);
    paramContext = c.coT;
    this.cqx = c.a.a(this.context, paramBoolean, (c.b)this, paramf.cli);
    this.cqy = this.cqx.MX();
    this.cqz = new AtomicBoolean(false);
    this.context.registerComponentCallbacks((ComponentCallbacks)this);
    AppMethodBeat.o(188096);
  }
  
  private void shutdown()
  {
    AppMethodBeat.i(188104);
    if (this.cqz.getAndSet(true))
    {
      AppMethodBeat.o(188104);
      return;
    }
    this.context.unregisterComponentCallbacks((ComponentCallbacks)this);
    this.cqx.shutdown();
    AppMethodBeat.o(188104);
  }
  
  public final void bp(boolean paramBoolean)
  {
    AppMethodBeat.i(188154);
    if ((f)this.cqw.get() == null)
    {
      shutdown();
      AppMethodBeat.o(188154);
      return;
    }
    this.cqy = paramBoolean;
    AppMethodBeat.o(188154);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(188125);
    s.u(paramConfiguration, "newConfig");
    if ((f)this.cqw.get() == null) {
      shutdown();
    }
    AppMethodBeat.o(188125);
  }
  
  public final void onLowMemory()
  {
    AppMethodBeat.i(188144);
    onTrimMemory(80);
    AppMethodBeat.o(188144);
  }
  
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(188136);
    Object localObject = (f)this.cqw.get();
    if (localObject == null) {}
    for (localObject = null;; localObject = ah.aiuX)
    {
      if (localObject == null) {
        shutdown();
      }
      AppMethodBeat.o(188136);
      return;
      ((f)localObject).clj.cnR.trimMemory(paramInt);
      ((f)localObject).clj.clU.trimMemory(paramInt);
      ((f)localObject).clr.trimMemory(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     coil.util.l
 * JD-Core Version:    0.7.0.1
 */