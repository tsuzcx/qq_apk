package com.tencent.mm.plugin.gallery.picker.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.loader.c.e.c;
import com.tencent.mm.plugin.gallery.b.b;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/loader/PickerLoader;", "", "()V", "DEFAULT_THREAD_POOL_SIZE", "", "DEFAULT_THREAD_PRIORITY", "HD", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "getHD", "()Lcom/tencent/mm/loader/Loader;", "MAX_HEIGHT", "MAX_THUMB_HEIGHT", "THUMB", "getTHUMB", "hdConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "hdOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "loaderCore", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "taskConfig", "Lcom/tencent/mm/loader/loader/cfg/TaskLoaderConfiguration;", "thumbConfiguration", "thumbOption", "plugin-gallery_release"})
public final class f
{
  private static final com.tencent.mm.loader.c.e BXM;
  private static final com.tencent.mm.loader.c.e BXN;
  private static final com.tencent.mm.loader.g.a.f BXO;
  private static final com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> BXP;
  private static final com.tencent.mm.loader.c.d<GalleryItem.MediaItem, Bitmap> BXQ;
  private static final com.tencent.mm.loader.c.d<GalleryItem.MediaItem, Bitmap> BXR;
  private static final com.tencent.mm.loader.d<GalleryItem.MediaItem> BXS;
  private static final com.tencent.mm.loader.d<GalleryItem.MediaItem> BXT;
  public static final f BXU;
  
  static
  {
    AppMethodBeat.i(164911);
    BXU = new f();
    Object localObject1 = new e.a();
    ((e.a)localObject1).kOp = false;
    ((e.a)localObject1).kOo = true;
    localObject1 = ((e.a)localObject1).a(e.c.kOD);
    ((e.a)localObject1).kOt = 480;
    ((e.a)localObject1).kOs = 480;
    Object localObject2 = MMApplicationContext.getContext();
    p.j(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources();
    if (localObject2 == null) {
      p.iCn();
    }
    BXM = ((e.a)localObject1).B((Drawable)new ColorDrawable(((Resources)localObject2).getColor(b.b.BW_93))).aRT();
    localObject1 = new e.a();
    ((e.a)localObject1).kOp = false;
    localObject1 = ((e.a)localObject1).a(e.c.kOD);
    ((e.a)localObject1).kOo = true;
    ((e.a)localObject1).kOt = 2160;
    ((e.a)localObject1).kOs = 2160;
    localObject2 = MMApplicationContext.getContext();
    p.j(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources();
    if (localObject2 == null) {
      p.iCn();
    }
    BXN = ((e.a)localObject1).B((Drawable)new ColorDrawable(((Resources)localObject2).getColor(b.b.BW_93))).aRT();
    BXO = new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(2147483647), new com.tencent.mm.loader.g.a.g(5), new com.tencent.mm.loader.g.a.g(5), new com.tencent.mm.loader.g.a.g(5), 5, "galleryLoader");
    localObject1 = com.tencent.mm.loader.g.a.e.kQt;
    BXP = com.tencent.mm.loader.g.a.e.a(BXO);
    localObject1 = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).a((com.tencent.mm.loader.b.a.d)new a()).a((com.tencent.mm.loader.d.b)new g()).b((com.tencent.mm.loader.d.d)new d()).a((com.tencent.mm.loader.b.b.e)new b()).b(BXM);
    ((com.tencent.mm.loader.c.b)localObject1).kMQ = BXP;
    BXQ = ((com.tencent.mm.loader.c.b)localObject1).aRE();
    localObject1 = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).a((com.tencent.mm.loader.b.a.d)new a()).b((com.tencent.mm.loader.d.d)new c()).a((com.tencent.mm.loader.d.b)new g()).a((com.tencent.mm.loader.b.b.e)new b()).b(BXN);
    ((com.tencent.mm.loader.c.b)localObject1).kMQ = BXP;
    BXR = ((com.tencent.mm.loader.c.b)localObject1).aRE();
    localObject1 = com.tencent.mm.loader.e.kMy;
    BXS = com.tencent.mm.loader.e.a(BXQ);
    localObject1 = com.tencent.mm.loader.e.kMy;
    BXT = com.tencent.mm.loader.e.a(BXR);
    AppMethodBeat.o(164911);
  }
  
  public static com.tencent.mm.loader.d<GalleryItem.MediaItem> euf()
  {
    return BXS;
  }
  
  public static com.tencent.mm.loader.d<GalleryItem.MediaItem> eug()
  {
    return BXT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.c.f
 * JD-Core Version:    0.7.0.1
 */