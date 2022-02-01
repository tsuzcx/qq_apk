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
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/picker/loader/PickerLoader;", "", "()V", "DEFAULT_THREAD_POOL_SIZE", "", "DEFAULT_THREAD_PRIORITY", "HD", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "getHD", "()Lcom/tencent/mm/loader/Loader;", "MAX_HEIGHT", "MAX_THUMB_HEIGHT", "THUMB", "getTHUMB", "hdConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "hdOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "loaderCore", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "taskConfig", "Lcom/tencent/mm/loader/loader/cfg/TaskLoaderConfiguration;", "thumbConfiguration", "thumbOption", "plugin-gallery_release"})
public final class f
{
  private static final com.tencent.mm.loader.c.e tUg;
  private static final com.tencent.mm.loader.c.e tUh;
  private static final com.tencent.mm.loader.g.a.f tUi;
  private static final com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> tUj;
  private static final com.tencent.mm.loader.c.d<GalleryItem.MediaItem, Bitmap> tUk;
  private static final com.tencent.mm.loader.c.d<GalleryItem.MediaItem, Bitmap> tUl;
  private static final com.tencent.mm.loader.d<GalleryItem.MediaItem> tUm;
  private static final com.tencent.mm.loader.d<GalleryItem.MediaItem> tUn;
  public static final f tUo;
  
  static
  {
    AppMethodBeat.i(164911);
    tUo = new f();
    Object localObject1 = new e.a();
    ((e.a)localObject1).hgP = false;
    ((e.a)localObject1).hgO = true;
    localObject1 = ((e.a)localObject1).a(e.c.hhd);
    ((e.a)localObject1).hgT = 480;
    ((e.a)localObject1).hgS = 480;
    Object localObject2 = ak.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources();
    if (localObject2 == null) {
      p.gkB();
    }
    tUg = ((e.a)localObject1).w((Drawable)new ColorDrawable(((Resources)localObject2).getColor(2131099679))).aru();
    localObject1 = new e.a();
    ((e.a)localObject1).hgP = false;
    localObject1 = ((e.a)localObject1).a(e.c.hhd);
    ((e.a)localObject1).hgO = true;
    ((e.a)localObject1).hgT = 2160;
    ((e.a)localObject1).hgS = 2160;
    localObject2 = ak.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources();
    if (localObject2 == null) {
      p.gkB();
    }
    tUh = ((e.a)localObject1).w((Drawable)new ColorDrawable(((Resources)localObject2).getColor(2131099679))).aru();
    tUi = new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(2147483647), new com.tencent.mm.loader.g.a.g(5), new com.tencent.mm.loader.g.a.g(5), new com.tencent.mm.loader.g.a.g(5), 5, "galleryLoader");
    localObject1 = com.tencent.mm.loader.g.a.e.hiP;
    tUj = com.tencent.mm.loader.g.a.e.a(tUi);
    localObject1 = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).a((com.tencent.mm.loader.b.a.d)new a()).a((com.tencent.mm.loader.d.b)new g()).b((com.tencent.mm.loader.d.d)new d()).a((com.tencent.mm.loader.b.b.e)new b()).b(tUg);
    ((com.tencent.mm.loader.c.b)localObject1).hfs = tUj;
    tUk = ((com.tencent.mm.loader.c.b)localObject1).arf();
    localObject1 = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).a((com.tencent.mm.loader.b.a.d)new a()).b((com.tencent.mm.loader.d.d)new c()).a((com.tencent.mm.loader.d.b)new g()).a((com.tencent.mm.loader.b.b.e)new b()).b(tUh);
    ((com.tencent.mm.loader.c.b)localObject1).hfs = tUj;
    tUl = ((com.tencent.mm.loader.c.b)localObject1).arf();
    localObject1 = com.tencent.mm.loader.e.hfa;
    tUm = com.tencent.mm.loader.e.a(tUk);
    localObject1 = com.tencent.mm.loader.e.hfa;
    tUn = com.tencent.mm.loader.e.a(tUl);
    AppMethodBeat.o(164911);
  }
  
  public static com.tencent.mm.loader.d<GalleryItem.MediaItem> cYk()
  {
    return tUm;
  }
  
  public static com.tencent.mm.loader.d<GalleryItem.MediaItem> cYl()
  {
    return tUn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.c.f
 * JD-Core Version:    0.7.0.1
 */