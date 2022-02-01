package com.tencent.mm.plugin.gallery.picker.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.b.e.a;
import com.tencent.mm.loader.b.e.c;
import com.tencent.mm.loader.cache.memory.DefaultBitmapMemoryCache;
import com.tencent.mm.plugin.gallery.b.b;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/loader/PickerLoader;", "", "()V", "DEFAULT_THREAD_POOL_SIZE", "", "DEFAULT_THREAD_PRIORITY", "HD", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "getHD", "()Lcom/tencent/mm/loader/Loader;", "MAX_HEIGHT", "MAX_THUMB_HEIGHT", "THUMB", "getTHUMB", "hdConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "hdOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "loaderCore", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "taskConfig", "Lcom/tencent/mm/loader/loader/cfg/TaskLoaderConfiguration;", "thumbConfiguration", "thumbOption", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f HJZ;
  private static final com.tencent.mm.loader.b.e HKa;
  private static final com.tencent.mm.loader.b.e HKb;
  private static final com.tencent.mm.loader.f.a.f HKc;
  private static final com.tencent.mm.loader.f.d<com.tencent.mm.loader.f.c> HKd;
  private static final com.tencent.mm.loader.b.d<GalleryItem.MediaItem, Bitmap> HKe;
  private static final com.tencent.mm.loader.b.d<GalleryItem.MediaItem, Bitmap> HKf;
  private static final com.tencent.mm.loader.d<GalleryItem.MediaItem> HKg;
  private static final com.tencent.mm.loader.d<GalleryItem.MediaItem> HKh;
  
  static
  {
    AppMethodBeat.i(164911);
    HJZ = new f();
    Object localObject = new e.a();
    ((e.a)localObject).nqd = false;
    ((e.a)localObject).nqc = true;
    localObject = ((e.a)localObject).a(e.c.nqr);
    ((e.a)localObject).nqh = 480;
    ((e.a)localObject).nqg = 480;
    Resources localResources = MMApplicationContext.getContext().getResources();
    s.checkNotNull(localResources);
    HKa = ((e.a)localObject).L((Drawable)new ColorDrawable(localResources.getColor(b.b.BW_93))).blI();
    localObject = new e.a();
    ((e.a)localObject).nqd = false;
    localObject = ((e.a)localObject).a(e.c.nqr);
    ((e.a)localObject).nqc = true;
    ((e.a)localObject).nqh = 2160;
    ((e.a)localObject).nqg = 2160;
    localResources = MMApplicationContext.getContext().getResources();
    s.checkNotNull(localResources);
    HKb = ((e.a)localObject).L((Drawable)new ColorDrawable(localResources.getColor(b.b.BW_93))).blI();
    HKc = new com.tencent.mm.loader.f.a.f((com.tencent.mm.loader.f.a.c)new com.tencent.mm.loader.f.a.a(2147483647), new com.tencent.mm.loader.f.a.g(5), new com.tencent.mm.loader.f.a.g(5), new com.tencent.mm.loader.f.a.g(5), 5, "galleryLoader");
    localObject = com.tencent.mm.loader.f.a.e.nrV;
    HKd = com.tencent.mm.loader.f.a.e.a(HKc);
    localObject = new com.tencent.mm.loader.b.a().a((com.tencent.mm.loader.cache.memory.d)new DefaultBitmapMemoryCache()).a((com.tencent.mm.loader.cache.a.d)new a()).a((com.tencent.mm.loader.c.b)new g()).b((com.tencent.mm.loader.c.d)new d()).a((com.tencent.mm.loader.cache.memory.d)new b()).b(HKa);
    ((com.tencent.mm.loader.b.b)localObject).noJ = HKd;
    HKe = ((com.tencent.mm.loader.b.b)localObject).blt();
    localObject = new com.tencent.mm.loader.b.a().a((com.tencent.mm.loader.cache.memory.d)new DefaultBitmapMemoryCache()).a((com.tencent.mm.loader.cache.a.d)new a()).b((com.tencent.mm.loader.c.d)new c()).a((com.tencent.mm.loader.c.b)new g()).a((com.tencent.mm.loader.cache.memory.d)new b()).b(HKb);
    ((com.tencent.mm.loader.b.b)localObject).noJ = HKd;
    HKf = ((com.tencent.mm.loader.b.b)localObject).blt();
    localObject = com.tencent.mm.loader.e.noo;
    HKg = com.tencent.mm.loader.e.a(HKe);
    localObject = com.tencent.mm.loader.e.noo;
    HKh = com.tencent.mm.loader.e.a(HKf);
    AppMethodBeat.o(164911);
  }
  
  public static com.tencent.mm.loader.d<GalleryItem.MediaItem> fBb()
  {
    return HKg;
  }
  
  public static com.tencent.mm.loader.d<GalleryItem.MediaItem> fBc()
  {
    return HKh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.c.f
 * JD-Core Version:    0.7.0.1
 */