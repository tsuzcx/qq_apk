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
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/picker/loader/PickerLoader;", "", "()V", "DEFAULT_THREAD_POOL_SIZE", "", "DEFAULT_THREAD_PRIORITY", "HD", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "getHD", "()Lcom/tencent/mm/loader/Loader;", "MAX_HEIGHT", "MAX_THUMB_HEIGHT", "THUMB", "getTHUMB", "hdConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "hdOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "loaderCore", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "taskConfig", "Lcom/tencent/mm/loader/loader/cfg/TaskLoaderConfiguration;", "thumbConfiguration", "thumbOption", "plugin-gallery_release"})
public final class f
{
  private static final com.tencent.mm.loader.c.e rDP;
  private static final com.tencent.mm.loader.c.e rDQ;
  private static final com.tencent.mm.loader.g.a.f rDR;
  private static final com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> rDS;
  private static final com.tencent.mm.loader.c.d<GalleryItem.MediaItem, Bitmap> rDT;
  private static final com.tencent.mm.loader.c.d<GalleryItem.MediaItem, Bitmap> rDU;
  private static final com.tencent.mm.loader.d<GalleryItem.MediaItem> rDV;
  private static final com.tencent.mm.loader.d<GalleryItem.MediaItem> rDW;
  public static final f rDX;
  
  static
  {
    AppMethodBeat.i(164911);
    rDX = new f();
    Object localObject1 = new e.a();
    ((e.a)localObject1).gjE = false;
    ((e.a)localObject1).gjD = true;
    localObject1 = ((e.a)localObject1).a(e.c.gjR);
    ((e.a)localObject1).gjI = 480;
    ((e.a)localObject1).gjH = 480;
    Object localObject2 = aj.getContext();
    k.g(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources();
    if (localObject2 == null) {
      k.fvU();
    }
    rDP = ((e.a)localObject1).w((Drawable)new ColorDrawable(((Resources)localObject2).getColor(2131099679))).ahr();
    localObject1 = new e.a();
    ((e.a)localObject1).gjE = false;
    localObject1 = ((e.a)localObject1).a(e.c.gjR);
    ((e.a)localObject1).gjD = true;
    ((e.a)localObject1).gjI = 2160;
    ((e.a)localObject1).gjH = 2160;
    localObject2 = aj.getContext();
    k.g(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources();
    if (localObject2 == null) {
      k.fvU();
    }
    rDQ = ((e.a)localObject1).w((Drawable)new ColorDrawable(((Resources)localObject2).getColor(2131099679))).ahr();
    rDR = new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(2147483647), new com.tencent.mm.loader.g.a.g(5), new com.tencent.mm.loader.g.a.g(5), new com.tencent.mm.loader.g.a.g(5), 5, "galleryLoader");
    localObject1 = com.tencent.mm.loader.g.a.e.glr;
    rDS = com.tencent.mm.loader.g.a.e.a(rDR);
    localObject1 = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).a((com.tencent.mm.loader.b.a.d)new a()).a((com.tencent.mm.loader.d.b)new g()).b((com.tencent.mm.loader.d.d)new d()).a((com.tencent.mm.loader.b.b.e)new b()).b(rDP);
    ((com.tencent.mm.loader.c.b)localObject1).gik = rDS;
    rDT = ((com.tencent.mm.loader.c.b)localObject1).ahb();
    localObject1 = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).a((com.tencent.mm.loader.b.a.d)new a()).b((com.tencent.mm.loader.d.d)new c()).a((com.tencent.mm.loader.d.b)new g()).a((com.tencent.mm.loader.b.b.e)new b()).b(rDQ);
    ((com.tencent.mm.loader.c.b)localObject1).gik = rDS;
    rDU = ((com.tencent.mm.loader.c.b)localObject1).ahb();
    localObject1 = com.tencent.mm.loader.e.ghT;
    rDV = com.tencent.mm.loader.e.a(rDT);
    localObject1 = com.tencent.mm.loader.e.ghT;
    rDW = com.tencent.mm.loader.e.a(rDU);
    AppMethodBeat.o(164911);
  }
  
  public static com.tencent.mm.loader.d<GalleryItem.MediaItem> cAb()
  {
    return rDV;
  }
  
  public static com.tencent.mm.loader.d<GalleryItem.MediaItem> cAc()
  {
    return rDW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.c.f
 * JD-Core Version:    0.7.0.1
 */