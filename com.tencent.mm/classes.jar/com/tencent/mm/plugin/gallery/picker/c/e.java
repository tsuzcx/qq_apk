package com.tencent.mm.plugin.gallery.picker.c;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.b.i;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.i.a;
import com.tencent.mm.plugin.gallery.model.i.c;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/loader/PickerDataLoader;", "", "()V", "TAG", "", "allMediaString", "allVideoMediaString", "currentFolderMedia", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "queryFolderListener", "Lcom/tencent/mm/plugin/gallery/picker/loader/PickerDataLoader$QueryFolderListener;", "queryListener", "Lcom/tencent/mm/plugin/gallery/picker/loader/PickerDataLoader$QueryMediaListener;", "queryService", "Lcom/tencent/mm/plugin/gallery/model/MediaQueryService;", "isNeed2Reload", "", "media", "onInit", "", "onLoad", "ticket", "", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "isSuccessfully", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "albumItems", "cost", "onLoadFolder", "Lkotlin/Function2;", "onRelease", "QueryFolderListener", "QueryMediaListener", "plugin-gallery_release"})
public final class e
{
  private static o AYc;
  private static e.b BXG;
  private static a BXH;
  private static GalleryItem.AlbumItem BXI;
  private static String BXJ;
  private static String BXK;
  public static final e BXL;
  
  static
  {
    AppMethodBeat.i(164910);
    BXL = new e();
    BXG = new e.b();
    BXH = new a();
    Object localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources().getString(b.i.gallery_all_pic_and_video);
    p.j(localObject, "MMApplicationContext.get…allery_all_pic_and_video)");
    BXJ = (String)localObject;
    localObject = MMApplicationContext.getContext().getString(b.i.gallery_all_video);
    p.j(localObject, "MMApplicationContext.get…string.gallery_all_video)");
    BXK = (String)localObject;
    AppMethodBeat.o(164910);
  }
  
  public static void Pu()
  {
    AppMethodBeat.i(164905);
    o localo = new o();
    AYc = localo;
    localo.setQueryType(3);
    localo = AYc;
    if (localo == null) {
      p.iCn();
    }
    localo.a((i.c)BXG);
    localo = AYc;
    if (localo == null) {
      p.iCn();
    }
    localo.a((i.a)BXH);
    AppMethodBeat.o(164905);
  }
  
  public static void a(long paramLong, GalleryItem.AlbumItem paramAlbumItem, q<? super Boolean, ? super LinkedList<GalleryItem.MediaItem>, ? super Long, x> paramq)
  {
    boolean bool2 = true;
    AppMethodBeat.i(164906);
    p.k(paramAlbumItem, "media");
    p.k(paramq, "callback");
    BXG.nmO = paramq;
    BXG.meh = paramLong;
    Object localObject = BXI;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      if ((p.h(((GalleryItem.AlbumItem)localObject).albumName, paramAlbumItem.albumName) ^ true)) {
        bool1 = bool2;
      }
    }
    else
    {
      Log.i("MicroMsg.PickerDataLoader", "[onLoad] ticket=" + paramLong + " isNeed=" + bool1);
      if (!bool1) {
        break label224;
      }
      if (!p.h(paramAlbumItem.albumName, BXJ)) {
        break label150;
      }
      paramq = AYc;
      if (paramq != null) {
        paramq.E("", 3, paramLong);
      }
    }
    for (;;)
    {
      BXI = paramAlbumItem;
      AppMethodBeat.o(164906);
      return;
      bool1 = false;
      break;
      label150:
      if (p.h(paramAlbumItem.albumName, BXK))
      {
        paramq = AYc;
        if (paramq != null) {
          paramq.E("", 2, paramLong);
        }
      }
      else
      {
        paramq = AYc;
        if (paramq != null)
        {
          localObject = paramAlbumItem.albumName;
          GalleryItem.MediaItem localMediaItem = paramAlbumItem.evX();
          p.j(localMediaItem, "media.mediaItem");
          paramq.E((String)localObject, localMediaItem.getType(), paramLong);
          continue;
          label224:
          long l = System.currentTimeMillis();
          paramq.c(Boolean.FALSE, new LinkedList(), Long.valueOf(l - paramLong));
        }
      }
    }
  }
  
  public static void onRelease()
  {
    AppMethodBeat.i(164908);
    BXI = null;
    o localo = AYc;
    if (localo != null)
    {
      localo.release();
      AppMethodBeat.o(164908);
      return;
    }
    AppMethodBeat.o(164908);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/loader/PickerDataLoader$QueryFolderListener;", "Lcom/tencent/mm/plugin/gallery/model/IMediaQuery$IQueryAlbumFinished;", "()V", "callback", "Lkotlin/Function2;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "Lkotlin/ParameterName;", "name", "albumItems", "", "cost", "", "getCallback", "()Lkotlin/jvm/functions/Function2;", "setCallback", "(Lkotlin/jvm/functions/Function2;)V", "ticket", "getTicket", "()J", "setTicket", "(J)V", "onQueryAlbumFinished", "plugin-gallery_release"})
  public static final class a
    implements i.a
  {
    m<? super LinkedList<GalleryItem.AlbumItem>, ? super Long, x> jHk;
    long meh;
    
    public a()
    {
      AppMethodBeat.i(164902);
      this.meh = System.currentTimeMillis();
      AppMethodBeat.o(164902);
    }
    
    public final void be(LinkedList<GalleryItem.AlbumItem> paramLinkedList)
    {
      AppMethodBeat.i(164901);
      p.k(paramLinkedList, "albumItems");
      long l1 = System.currentTimeMillis();
      long l2 = this.meh;
      Object localObject1 = e.BXL;
      localObject1 = e.eue();
      Object localObject2 = ((Iterable)paramLinkedList).iterator();
      for (int i = 0; ((Iterator)localObject2).hasNext(); i = ((GalleryItem.AlbumItem)((Iterator)localObject2).next()).fCa + i) {}
      localObject2 = new GalleryItem.AlbumItem((String)localObject1, i);
      localObject1 = (GalleryItem.AlbumItem)j.lp((List)paramLinkedList);
      if (localObject1 != null) {}
      for (localObject1 = ((GalleryItem.AlbumItem)localObject1).evX();; localObject1 = null)
      {
        ((GalleryItem.AlbumItem)localObject2).c((GalleryItem.MediaItem)localObject1);
        paramLinkedList.add(0, localObject2);
        localObject1 = this.jHk;
        if (localObject1 == null) {
          break;
        }
        ((m)localObject1).invoke(paramLinkedList, Long.valueOf(l1 - l2));
        AppMethodBeat.o(164901);
        return;
      }
      AppMethodBeat.o(164901);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.c.e
 * JD-Core Version:    0.7.0.1
 */