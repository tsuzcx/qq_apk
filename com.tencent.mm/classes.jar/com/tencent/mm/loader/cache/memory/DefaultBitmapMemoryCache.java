package com.tencent.mm.loader.cache.memory;

import android.graphics.Bitmap;
import androidx.lifecycle.q;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.oc;
import com.tencent.mm.loader.g.e;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.event.IListener;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/cache/memory/DefaultBitmapMemoryCache;", "T", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "Landroid/graphics/Bitmap;", "()V", "defaultImageMemoryCache", "Lcom/tencent/mm/memory/cache/BitmapResource;", "getDefaultImageMemoryCache", "()Lcom/tencent/mm/memory/cache/BitmapResource;", "clear", "", "get", "Lcom/tencent/mm/loader/model/Resource;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "head", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "put", "value", "remove", "Companion", "MMTrimMemoryEventListener", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public class DefaultBitmapMemoryCache<T>
  extends d<T, Bitmap>
{
  private static final String TAG = "MicroMsg.Loader.DefaultImageMemoryCacheListener";
  public static final DefaultBitmapMemoryCache.a npd = new DefaultBitmapMemoryCache.a((byte)0);
  private static MMTrimMemoryEventListener npf;
  private static final int npg = 50;
  protected final b<Bitmap> npe;
  
  public DefaultBitmapMemoryCache()
  {
    MMTrimMemoryEventListener localMMTrimMemoryEventListener = npf;
    if (localMMTrimMemoryEventListener != null) {
      localMMTrimMemoryEventListener.dead();
    }
    localMMTrimMemoryEventListener = new MMTrimMemoryEventListener(new WeakReference(this));
    npf = localMMTrimMemoryEventListener;
    s.checkNotNull(localMMTrimMemoryEventListener);
    localMMTrimMemoryEventListener.alive();
    this.npe = new b(npg, getClass());
  }
  
  public e<Bitmap> a(com.tencent.mm.loader.g.a.a<T> parama, com.tencent.mm.loader.d.c.a<Bitmap> parama1)
  {
    s.u(parama, "url");
    parama = b(parama, parama1);
    parama = (Bitmap)this.npe.get(parama);
    if (parama != null) {
      return new e(parama);
    }
    return null;
  }
  
  public final void c(com.tencent.mm.loader.g.a.a<T> parama)
  {
    s.u(parama, "url");
    this.npe.remove(b(parama, null));
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/cache/memory/DefaultBitmapMemoryCache$MMTrimMemoryEventListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MMTrimMemoryEvent;", "weakTarget", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/loader/cache/memory/DefaultBitmapMemoryCache;", "(Ljava/lang/ref/WeakReference;)V", "getWeakTarget", "()Ljava/lang/ref/WeakReference;", "setWeakTarget", "callback", "", "event", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class MMTrimMemoryEventListener
    extends IListener<oc>
  {
    private WeakReference<DefaultBitmapMemoryCache<?>> nph;
    
    public MMTrimMemoryEventListener(WeakReference<DefaultBitmapMemoryCache<?>> paramWeakReference)
    {
      super();
      this.nph = paramWeakReference;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.cache.memory.DefaultBitmapMemoryCache
 * JD-Core Version:    0.7.0.1
 */