package com.tencent.mm.plugin.gallery.picker.c;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.i.a;
import com.tencent.mm.plugin.gallery.model.i.c;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.a.j;
import d.g.a.m;
import d.g.a.q;
import d.g.b.p;
import d.l;
import d.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gallery/picker/loader/PickerDataLoader;", "", "()V", "TAG", "", "allMediaString", "kotlin.jvm.PlatformType", "allVideoMediaString", "currentFolderMedia", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "queryFolderListener", "Lcom/tencent/mm/plugin/gallery/picker/loader/PickerDataLoader$QueryFolderListener;", "queryListener", "Lcom/tencent/mm/plugin/gallery/picker/loader/PickerDataLoader$QueryMediaListener;", "queryService", "Lcom/tencent/mm/plugin/gallery/model/MediaQueryService;", "isNeed2Reload", "", "media", "onInit", "", "onLoad", "ticket", "", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "isSuccessfully", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "albumItems", "cost", "onLoadFolder", "Lkotlin/Function2;", "onRelease", "QueryFolderListener", "QueryMediaListener", "plugin-gallery_release"})
public final class e
{
  private static o sUE;
  private static e.b tJi;
  private static a tJj;
  private static GalleryItem.AlbumItem tJk;
  private static String tJl;
  private static String tJm;
  public static final e tJn;
  
  static
  {
    AppMethodBeat.i(164910);
    tJn = new e();
    tJi = new e.b();
    tJj = new a();
    Context localContext = aj.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    tJl = localContext.getResources().getString(2131759758);
    tJm = aj.getContext().getString(2131759759);
    AppMethodBeat.o(164910);
  }
  
  public static void Dd()
  {
    AppMethodBeat.i(164905);
    o localo = new o();
    sUE = localo;
    localo.setQueryType(3);
    localo = sUE;
    if (localo == null) {
      p.gfZ();
    }
    localo.a((i.c)tJi);
    localo = sUE;
    if (localo == null) {
      p.gfZ();
    }
    localo.a((i.a)tJj);
    AppMethodBeat.o(164905);
  }
  
  public static void a(long paramLong, GalleryItem.AlbumItem paramAlbumItem, q<? super Boolean, ? super LinkedList<GalleryItem.MediaItem>, ? super Long, z> paramq)
  {
    boolean bool2 = true;
    AppMethodBeat.i(164906);
    p.h(paramAlbumItem, "media");
    p.h(paramq, "callback");
    tJi.tJo = paramq;
    tJi.iqK = paramLong;
    Object localObject = tJk;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      if ((p.i(((GalleryItem.AlbumItem)localObject).tGK, paramAlbumItem.tGK) ^ true)) {
        bool1 = bool2;
      }
    }
    else
    {
      ad.i("MicroMsg.PickerDataLoader", "[onLoad] ticket=" + paramLong + " isNeed=" + bool1);
      if (!bool1) {
        break label224;
      }
      if (!p.i(paramAlbumItem.tGK, tJl)) {
        break label150;
      }
      paramq = sUE;
      if (paramq != null) {
        paramq.F("", 3, paramLong);
      }
    }
    for (;;)
    {
      tJk = paramAlbumItem;
      AppMethodBeat.o(164906);
      return;
      bool1 = false;
      break;
      label150:
      if (p.i(paramAlbumItem.tGK, tJm))
      {
        paramq = sUE;
        if (paramq != null) {
          paramq.F("", 2, paramLong);
        }
      }
      else
      {
        paramq = sUE;
        if (paramq != null)
        {
          localObject = paramAlbumItem.tGK;
          GalleryItem.MediaItem localMediaItem = paramAlbumItem.fsN();
          p.g(localMediaItem, "media.mediaItem");
          paramq.F((String)localObject, localMediaItem.getType(), paramLong);
          continue;
          label224:
          long l = System.currentTimeMillis();
          paramq.d(Boolean.FALSE, new LinkedList(), Long.valueOf(l - paramLong));
        }
      }
    }
  }
  
  public static void onRelease()
  {
    AppMethodBeat.i(164908);
    tJk = null;
    o localo = sUE;
    if (localo != null)
    {
      localo.release();
      AppMethodBeat.o(164908);
      return;
    }
    AppMethodBeat.o(164908);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gallery/picker/loader/PickerDataLoader$QueryFolderListener;", "Lcom/tencent/mm/plugin/gallery/model/IMediaQuery$IQueryAlbumFinished;", "()V", "callback", "Lkotlin/Function2;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "Lkotlin/ParameterName;", "name", "albumItems", "", "cost", "", "getCallback", "()Lkotlin/jvm/functions/Function2;", "setCallback", "(Lkotlin/jvm/functions/Function2;)V", "ticket", "getTicket", "()J", "setTicket", "(J)V", "onQueryAlbumFinished", "plugin-gallery_release"})
  public static final class a
    implements i.a
  {
    m<? super LinkedList<GalleryItem.AlbumItem>, ? super Long, z> gjf;
    long iqK;
    
    public a()
    {
      AppMethodBeat.i(164902);
      this.iqK = System.currentTimeMillis();
      AppMethodBeat.o(164902);
    }
    
    public final void aq(LinkedList<GalleryItem.AlbumItem> paramLinkedList)
    {
      AppMethodBeat.i(164901);
      p.h(paramLinkedList, "albumItems");
      long l1 = System.currentTimeMillis();
      long l2 = this.iqK;
      Object localObject1 = e.tJn;
      localObject1 = e.cVE();
      Object localObject2 = ((Iterable)paramLinkedList).iterator();
      for (int i = 0; ((Iterator)localObject2).hasNext(); i = ((GalleryItem.AlbumItem)((Iterator)localObject2).next()).dqU + i) {}
      localObject2 = new GalleryItem.AlbumItem((String)localObject1, i);
      localObject1 = (GalleryItem.AlbumItem)j.jd((List)paramLinkedList);
      if (localObject1 != null) {}
      for (localObject1 = ((GalleryItem.AlbumItem)localObject1).fsN();; localObject1 = null)
      {
        ((GalleryItem.AlbumItem)localObject2).b((GalleryItem.MediaItem)localObject1);
        paramLinkedList.add(0, localObject2);
        localObject1 = this.gjf;
        if (localObject1 == null) {
          break;
        }
        ((m)localObject1).p(paramLinkedList, Long.valueOf(l1 - l2));
        AppMethodBeat.o(164901);
        return;
      }
      AppMethodBeat.o(164901);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.c.e
 * JD-Core Version:    0.7.0.1
 */