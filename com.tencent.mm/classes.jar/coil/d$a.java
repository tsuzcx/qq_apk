package coil;

import android.content.Context;
import coil.b.e;
import coil.b.g;
import coil.b.h;
import coil.j.c;
import coil.memory.n;
import coil.memory.p;
import coil.memory.r;
import coil.memory.r.a;
import coil.util.j;
import coil.util.k;
import coil.util.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import okhttp3.e.a;

@Metadata(d1={""}, d2={"Lcoil/ImageLoader$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "imageLoader", "Lcoil/RealImageLoader;", "(Lcoil/RealImageLoader;)V", "applicationContext", "availableMemoryPercentage", "", "bitmapPoolPercentage", "bitmapPoolingEnabled", "", "callFactory", "Lokhttp3/Call$Factory;", "componentRegistry", "Lcoil/ComponentRegistry;", "defaults", "Lcoil/request/DefaultRequestOptions;", "eventListenerFactory", "Lcoil/EventListener$Factory;", "logger", "Lcoil/util/Logger;", "memoryCache", "Lcoil/memory/RealMemoryCache;", "options", "Lcoil/util/ImageLoaderOptions;", "trackWeakReferences", "addLastModifiedToFileCacheKey", "enable", "allowHardware", "allowRgb565", "percent", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "build", "Lcoil/ImageLoader;", "buildDefaultCallFactory", "buildDefaultMemoryCache", "initializer", "Lkotlin/Function0;", "registry", "builder", "Lkotlin/Function1;", "Lcoil/ComponentRegistry$Builder;", "", "Lkotlin/ExtensionFunctionType;", "crossfade", "durationMillis", "", "diskCachePolicy", "policy", "Lcoil/request/CachePolicy;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "error", "drawable", "Landroid/graphics/drawable/Drawable;", "drawableResId", "eventListener", "listener", "Lcoil/EventListener;", "factory", "fallback", "launchInterceptorChainOnMainThread", "Lcoil/memory/MemoryCache;", "memoryCachePolicy", "networkCachePolicy", "networkObserverEnabled", "okHttpClient", "Lokhttp3/OkHttpClient;", "placeholder", "precision", "Lcoil/size/Precision;", "transition", "Lcoil/transition/Transition;", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$a
{
  final Context applicationContext;
  public c cld;
  private e.a cle;
  private c.c clf;
  public b clg;
  private j clh;
  private k cli;
  private n clj;
  private double clk;
  private double cll;
  private boolean clm;
  private boolean cln;
  
  public d$a(Context paramContext)
  {
    AppMethodBeat.i(187952);
    paramContext = paramContext.getApplicationContext();
    s.s(paramContext, "context.applicationContext");
    this.applicationContext = paramContext;
    this.cld = c.cpo;
    this.cle = null;
    this.clf = null;
    this.clg = null;
    this.clh = new j((byte)0);
    this.cli = null;
    this.clj = null;
    paramContext = m.cqA;
    this.clk = m.aD(this.applicationContext);
    paramContext = m.cqA;
    this.cll = m.Nl();
    this.clm = true;
    this.cln = true;
    AppMethodBeat.o(187952);
  }
  
  public final d MC()
  {
    AppMethodBeat.i(187965);
    Object localObject2 = this.clj;
    Object localObject1 = localObject2;
    double d;
    int i;
    int j;
    if (localObject2 == null)
    {
      localObject1 = m.cqA;
      long l = m.a(this.applicationContext, this.clk);
      if (!this.clm) {
        break label300;
      }
      d = this.cll;
      i = (int)(d * l);
      j = (int)(l - i);
      if (i != 0) {
        break label305;
      }
      localObject1 = (coil.b.b)new e();
      label81:
      if (!this.cln) {
        break label325;
      }
      localObject2 = (coil.memory.u)new p(this.cli);
      label104:
      if (!this.clm) {
        break label336;
      }
    }
    label300:
    label305:
    label325:
    label336:
    for (Object localObject3 = (coil.b.d)new h((coil.memory.u)localObject2, (coil.b.b)localObject1, this.cli);; localObject3 = (coil.b.d)coil.b.f.clJ)
    {
      Object localObject4 = r.coG;
      localObject1 = new n(r.a.a((coil.memory.u)localObject2, (coil.b.d)localObject3, j, this.cli), (coil.memory.u)localObject2, (coil.b.d)localObject3, (coil.b.b)localObject1);
      Context localContext = this.applicationContext;
      c localc = this.cld;
      coil.b.b localb1 = ((n)localObject1).clr;
      localObject3 = this.cle;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = coil.util.d.n((a)new a(this));
      }
      localObject4 = this.clf;
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = c.c.cla;
      }
      b localb = this.clg;
      localObject4 = localb;
      if (localb == null) {
        localObject4 = new b();
      }
      localObject1 = (d)new f(localContext, localc, localb1, (n)localObject1, (e.a)localObject2, (c.c)localObject3, (b)localObject4, this.clh, this.cli);
      AppMethodBeat.o(187965);
      return localObject1;
      d = 0.0D;
      break;
      localObject1 = (coil.b.b)new g(i, this.cli);
      break label81;
      localObject2 = (coil.memory.u)coil.memory.d.coh;
      break label104;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lokhttp3/Call$Factory;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements a<e.a>
  {
    a(d.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     coil.d.a
 * JD-Core Version:    0.7.0.1
 */