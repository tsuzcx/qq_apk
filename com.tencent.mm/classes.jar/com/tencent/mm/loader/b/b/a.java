package com.tencent.mm.loader.b.b;

import android.graphics.Bitmap;
import com.tencent.mm.f.a.mv;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.event.IListener;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/loader/cache/memory/DefaultBitmapMemoryCache;", "T", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "Landroid/graphics/Bitmap;", "()V", "defaultImageMemoryCache", "Lcom/tencent/mm/memory/cache/BitmapResource;", "getDefaultImageMemoryCache", "()Lcom/tencent/mm/memory/cache/BitmapResource;", "clear", "", "get", "Lcom/tencent/mm/loader/model/Resource;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "head", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "put", "value", "remove", "Companion", "MMTrimMemoryEventListener", "libimageloader_release"})
public class a<T>
  extends e<T, Bitmap>
{
  private static final String TAG = "MicroMsg.Loader.DefaultImageMemoryCacheListener";
  private static b kNq;
  private static final int kNr = 50;
  public static final a kNs = new a((byte)0);
  protected final b<Bitmap> kNp;
  
  public a()
  {
    b localb = kNq;
    if (localb != null) {
      localb.dead();
    }
    localb = new b(new WeakReference(this));
    kNq = localb;
    localb.alive();
    this.kNp = new b(kNr, getClass());
  }
  
  public com.tencent.mm.loader.h.e<Bitmap> a(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.e.c.a<Bitmap> parama1)
  {
    p.k(parama, "url");
    parama = b(parama, parama1);
    parama = (Bitmap)this.kNp.get(parama);
    if (parama != null) {
      return new com.tencent.mm.loader.h.e(parama);
    }
    return null;
  }
  
  public final void a(com.tencent.mm.loader.h.a.a<T> parama)
  {
    p.k(parama, "url");
    this.kNp.remove(b(parama, null));
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/loader/cache/memory/DefaultBitmapMemoryCache$Companion;", "", "()V", "MAX_DEFAULT_BITMAP_SIZE", "", "getMAX_DEFAULT_BITMAP_SIZE", "()I", "TAG", "", "sTrimMemoryEventListener", "Lcom/tencent/mm/loader/cache/memory/DefaultBitmapMemoryCache$MMTrimMemoryEventListener;", "libimageloader_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/loader/cache/memory/DefaultBitmapMemoryCache$MMTrimMemoryEventListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MMTrimMemoryEvent;", "weakTarget", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/loader/cache/memory/DefaultBitmapMemoryCache;", "(Ljava/lang/ref/WeakReference;)V", "getWeakTarget", "()Ljava/lang/ref/WeakReference;", "setWeakTarget", "callback", "", "event", "libimageloader_release"})
  static final class b
    extends IListener<mv>
  {
    private WeakReference<a<?>> kNt;
    
    public b(WeakReference<a<?>> paramWeakReference)
    {
      this.kNt = paramWeakReference;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.b.b.a
 * JD-Core Version:    0.7.0.1
 */