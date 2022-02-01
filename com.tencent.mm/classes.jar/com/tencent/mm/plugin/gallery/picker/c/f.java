package com.tencent.mm.plugin.gallery.picker.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.loader.c.e.c;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/loader/PickerLoader;", "", "()V", "DEFAULT_THREAD_POOL_SIZE", "", "DEFAULT_THREAD_PRIORITY", "HD", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "getHD", "()Lcom/tencent/mm/loader/Loader;", "MAX_HEIGHT", "MAX_THUMB_HEIGHT", "THUMB", "getTHUMB", "hdConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "hdOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "loaderCore", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "taskConfig", "Lcom/tencent/mm/loader/loader/cfg/TaskLoaderConfiguration;", "thumbConfiguration", "thumbOption", "plugin-gallery_release"})
public final class f
{
  public static final f xlA;
  private static final com.tencent.mm.loader.c.e xls;
  private static final com.tencent.mm.loader.c.e xlt;
  private static final com.tencent.mm.loader.g.a.f xlu;
  private static final com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> xlv;
  private static final com.tencent.mm.loader.c.d<GalleryItem.MediaItem, Bitmap> xlw;
  private static final com.tencent.mm.loader.c.d<GalleryItem.MediaItem, Bitmap> xlx;
  private static final com.tencent.mm.loader.d<GalleryItem.MediaItem> xly;
  private static final com.tencent.mm.loader.d<GalleryItem.MediaItem> xlz;
  
  static
  {
    AppMethodBeat.i(164911);
    xlA = new f();
    Object localObject1 = new e.a();
    ((e.a)localObject1).hZJ = false;
    ((e.a)localObject1).hZI = true;
    localObject1 = ((e.a)localObject1).a(e.c.hZX);
    ((e.a)localObject1).hZN = 480;
    ((e.a)localObject1).hZM = 480;
    Object localObject2 = MMApplicationContext.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources();
    if (localObject2 == null) {
      p.hyc();
    }
    xls = ((e.a)localObject1).w((Drawable)new ColorDrawable(((Resources)localObject2).getColor(2131099689))).aJT();
    localObject1 = new e.a();
    ((e.a)localObject1).hZJ = false;
    localObject1 = ((e.a)localObject1).a(e.c.hZX);
    ((e.a)localObject1).hZI = true;
    ((e.a)localObject1).hZN = 2160;
    ((e.a)localObject1).hZM = 2160;
    localObject2 = MMApplicationContext.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources();
    if (localObject2 == null) {
      p.hyc();
    }
    xlt = ((e.a)localObject1).w((Drawable)new ColorDrawable(((Resources)localObject2).getColor(2131099689))).aJT();
    xlu = new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(2147483647), new com.tencent.mm.loader.g.a.g(5), new com.tencent.mm.loader.g.a.g(5), new com.tencent.mm.loader.g.a.g(5), 5, "galleryLoader");
    localObject1 = com.tencent.mm.loader.g.a.e.ibM;
    xlv = com.tencent.mm.loader.g.a.e.a(xlu);
    localObject1 = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).a((com.tencent.mm.loader.b.a.d)new a()).a((com.tencent.mm.loader.d.b)new g()).b((com.tencent.mm.loader.d.d)new d()).a((com.tencent.mm.loader.b.b.e)new b()).b(xls);
    ((com.tencent.mm.loader.c.b)localObject1).hYm = xlv;
    xlw = ((com.tencent.mm.loader.c.b)localObject1).aJE();
    localObject1 = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).a((com.tencent.mm.loader.b.a.d)new a()).b((com.tencent.mm.loader.d.d)new c()).a((com.tencent.mm.loader.d.b)new g()).a((com.tencent.mm.loader.b.b.e)new b()).b(xlt);
    ((com.tencent.mm.loader.c.b)localObject1).hYm = xlv;
    xlx = ((com.tencent.mm.loader.c.b)localObject1).aJE();
    localObject1 = com.tencent.mm.loader.e.hXU;
    xly = com.tencent.mm.loader.e.a(xlw);
    localObject1 = com.tencent.mm.loader.e.hXU;
    xlz = com.tencent.mm.loader.e.a(xlx);
    AppMethodBeat.o(164911);
  }
  
  public static com.tencent.mm.loader.d<GalleryItem.MediaItem> dRD()
  {
    return xly;
  }
  
  public static com.tencent.mm.loader.d<GalleryItem.MediaItem> dRE()
  {
    return xlz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.c.f
 * JD-Core Version:    0.7.0.1
 */