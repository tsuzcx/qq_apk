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
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/loader/PickerLoader;", "", "()V", "DEFAULT_THREAD_POOL_SIZE", "", "DEFAULT_THREAD_PRIORITY", "HD", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "getHD", "()Lcom/tencent/mm/loader/Loader;", "MAX_HEIGHT", "MAX_THUMB_HEIGHT", "THUMB", "getTHUMB", "hdConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "hdOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "loaderCore", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "taskConfig", "Lcom/tencent/mm/loader/loader/cfg/TaskLoaderConfiguration;", "thumbConfiguration", "thumbOption", "plugin-gallery_release"})
public final class f
{
  private static final com.tencent.mm.loader.c.e sMH;
  private static final com.tencent.mm.loader.c.e sMI;
  private static final com.tencent.mm.loader.g.a.f sMJ;
  private static final com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> sMK;
  private static final com.tencent.mm.loader.c.d<GalleryItem.MediaItem, Bitmap> sML;
  private static final com.tencent.mm.loader.c.d<GalleryItem.MediaItem, Bitmap> sMM;
  private static final com.tencent.mm.loader.d<GalleryItem.MediaItem> sMN;
  private static final com.tencent.mm.loader.d<GalleryItem.MediaItem> sMO;
  public static final f sMP;
  
  static
  {
    AppMethodBeat.i(164911);
    sMP = new f();
    Object localObject1 = new e.a();
    ((e.a)localObject1).gKq = false;
    ((e.a)localObject1).gKp = true;
    localObject1 = ((e.a)localObject1).a(e.c.gKE);
    ((e.a)localObject1).gKu = 480;
    ((e.a)localObject1).gKt = 480;
    Object localObject2 = ai.getContext();
    k.g(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources();
    if (localObject2 == null) {
      k.fOy();
    }
    sMH = ((e.a)localObject1).w((Drawable)new ColorDrawable(((Resources)localObject2).getColor(2131099679))).aot();
    localObject1 = new e.a();
    ((e.a)localObject1).gKq = false;
    localObject1 = ((e.a)localObject1).a(e.c.gKE);
    ((e.a)localObject1).gKp = true;
    ((e.a)localObject1).gKu = 2160;
    ((e.a)localObject1).gKt = 2160;
    localObject2 = ai.getContext();
    k.g(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources();
    if (localObject2 == null) {
      k.fOy();
    }
    sMI = ((e.a)localObject1).w((Drawable)new ColorDrawable(((Resources)localObject2).getColor(2131099679))).aot();
    sMJ = new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(2147483647), new com.tencent.mm.loader.g.a.g(5), new com.tencent.mm.loader.g.a.g(5), new com.tencent.mm.loader.g.a.g(5), 5, "galleryLoader");
    localObject1 = com.tencent.mm.loader.g.a.e.gMe;
    sMK = com.tencent.mm.loader.g.a.e.a(sMJ);
    localObject1 = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).a((com.tencent.mm.loader.b.a.d)new a()).a((com.tencent.mm.loader.d.b)new g()).b((com.tencent.mm.loader.d.d)new d()).a((com.tencent.mm.loader.b.b.e)new b()).b(sMH);
    ((com.tencent.mm.loader.c.b)localObject1).gIT = sMK;
    sML = ((com.tencent.mm.loader.c.b)localObject1).aod();
    localObject1 = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).a((com.tencent.mm.loader.b.a.d)new a()).b((com.tencent.mm.loader.d.d)new c()).a((com.tencent.mm.loader.d.b)new g()).a((com.tencent.mm.loader.b.b.e)new b()).b(sMI);
    ((com.tencent.mm.loader.c.b)localObject1).gIT = sMK;
    sMM = ((com.tencent.mm.loader.c.b)localObject1).aod();
    localObject1 = com.tencent.mm.loader.e.gIC;
    sMN = com.tencent.mm.loader.e.a(sML);
    localObject1 = com.tencent.mm.loader.e.gIC;
    sMO = com.tencent.mm.loader.e.a(sMM);
    AppMethodBeat.o(164911);
  }
  
  public static com.tencent.mm.loader.d<GalleryItem.MediaItem> cNn()
  {
    return sMN;
  }
  
  public static com.tencent.mm.loader.d<GalleryItem.MediaItem> cNo()
  {
    return sMO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.c.f
 * JD-Core Version:    0.7.0.1
 */