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
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gallery/picker/loader/PickerLoader;", "", "()V", "DEFAULT_THREAD_POOL_SIZE", "", "DEFAULT_THREAD_PRIORITY", "HD", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "getHD", "()Lcom/tencent/mm/loader/Loader;", "MAX_HEIGHT", "MAX_THUMB_HEIGHT", "THUMB", "getTHUMB", "hdConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "hdOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "loaderCore", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "taskConfig", "Lcom/tencent/mm/loader/loader/cfg/TaskLoaderConfiguration;", "thumbConfiguration", "thumbOption", "plugin-gallery_release"})
public final class f
{
  private static final com.tencent.mm.loader.c.e tJp;
  private static final com.tencent.mm.loader.c.e tJq;
  private static final com.tencent.mm.loader.g.a.f tJr;
  private static final com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> tJs;
  private static final com.tencent.mm.loader.c.d<GalleryItem.MediaItem, Bitmap> tJt;
  private static final com.tencent.mm.loader.c.d<GalleryItem.MediaItem, Bitmap> tJu;
  private static final com.tencent.mm.loader.d<GalleryItem.MediaItem> tJv;
  private static final com.tencent.mm.loader.d<GalleryItem.MediaItem> tJw;
  public static final f tJx;
  
  static
  {
    AppMethodBeat.i(164911);
    tJx = new f();
    Object localObject1 = new e.a();
    ((e.a)localObject1).heb = false;
    ((e.a)localObject1).hea = true;
    localObject1 = ((e.a)localObject1).a(e.c.hep);
    ((e.a)localObject1).hef = 480;
    ((e.a)localObject1).hee = 480;
    Object localObject2 = aj.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources();
    if (localObject2 == null) {
      p.gfZ();
    }
    tJp = ((e.a)localObject1).w((Drawable)new ColorDrawable(((Resources)localObject2).getColor(2131099679))).arf();
    localObject1 = new e.a();
    ((e.a)localObject1).heb = false;
    localObject1 = ((e.a)localObject1).a(e.c.hep);
    ((e.a)localObject1).hea = true;
    ((e.a)localObject1).hef = 2160;
    ((e.a)localObject1).hee = 2160;
    localObject2 = aj.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources();
    if (localObject2 == null) {
      p.gfZ();
    }
    tJq = ((e.a)localObject1).w((Drawable)new ColorDrawable(((Resources)localObject2).getColor(2131099679))).arf();
    tJr = new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(2147483647), new com.tencent.mm.loader.g.a.g(5), new com.tencent.mm.loader.g.a.g(5), new com.tencent.mm.loader.g.a.g(5), 5, "galleryLoader");
    localObject1 = com.tencent.mm.loader.g.a.e.hgb;
    tJs = com.tencent.mm.loader.g.a.e.a(tJr);
    localObject1 = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).a((com.tencent.mm.loader.b.a.d)new a()).a((com.tencent.mm.loader.d.b)new g()).b((com.tencent.mm.loader.d.d)new d()).a((com.tencent.mm.loader.b.b.e)new b()).b(tJp);
    ((com.tencent.mm.loader.c.b)localObject1).hcE = tJs;
    tJt = ((com.tencent.mm.loader.c.b)localObject1).aqQ();
    localObject1 = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).a((com.tencent.mm.loader.b.a.d)new a()).b((com.tencent.mm.loader.d.d)new c()).a((com.tencent.mm.loader.d.b)new g()).a((com.tencent.mm.loader.b.b.e)new b()).b(tJq);
    ((com.tencent.mm.loader.c.b)localObject1).hcE = tJs;
    tJu = ((com.tencent.mm.loader.c.b)localObject1).aqQ();
    localObject1 = com.tencent.mm.loader.e.hcm;
    tJv = com.tencent.mm.loader.e.a(tJt);
    localObject1 = com.tencent.mm.loader.e.hcm;
    tJw = com.tencent.mm.loader.e.a(tJu);
    AppMethodBeat.o(164911);
  }
  
  public static com.tencent.mm.loader.d<GalleryItem.MediaItem> cVF()
  {
    return tJv;
  }
  
  public static com.tencent.mm.loader.d<GalleryItem.MediaItem> cVG()
  {
    return tJw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.c.f
 * JD-Core Version:    0.7.0.1
 */