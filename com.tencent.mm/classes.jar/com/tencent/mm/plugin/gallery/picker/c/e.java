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
import d.g.b.k;
import d.l;
import d.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/picker/loader/PickerDataLoader;", "", "()V", "TAG", "", "allMediaString", "kotlin.jvm.PlatformType", "allVideoMediaString", "currentFolderMedia", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "queryFolderListener", "Lcom/tencent/mm/plugin/gallery/picker/loader/PickerDataLoader$QueryFolderListener;", "queryListener", "Lcom/tencent/mm/plugin/gallery/picker/loader/PickerDataLoader$QueryMediaListener;", "queryService", "Lcom/tencent/mm/plugin/gallery/model/MediaQueryService;", "isNeed2Reload", "", "media", "onInit", "", "onLoad", "ticket", "", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "isSuccessfully", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "albumItems", "cost", "onLoadFolder", "Lkotlin/Function2;", "onRelease", "QueryFolderListener", "QueryMediaListener", "plugin-gallery_release"})
public final class e
{
  private static o qXi;
  private static b rDI;
  private static a rDJ;
  private static GalleryItem.AlbumItem rDK;
  private static String rDL;
  private static String rDM;
  public static final e rDN;
  
  static
  {
    AppMethodBeat.i(164910);
    rDN = new e();
    rDI = new b();
    rDJ = new a();
    Context localContext = aj.getContext();
    k.g(localContext, "MMApplicationContext.getContext()");
    rDL = localContext.getResources().getString(2131759758);
    rDM = aj.getContext().getString(2131759759);
    AppMethodBeat.o(164910);
  }
  
  public static void Ca()
  {
    AppMethodBeat.i(164905);
    o localo = new o();
    qXi = localo;
    localo.setQueryType(3);
    localo = qXi;
    if (localo == null) {
      k.fvU();
    }
    localo.a((i.c)rDI);
    localo = qXi;
    if (localo == null) {
      k.fvU();
    }
    localo.a((i.a)rDJ);
    AppMethodBeat.o(164905);
  }
  
  public static void a(long paramLong, GalleryItem.AlbumItem paramAlbumItem, q<? super Boolean, ? super LinkedList<GalleryItem.MediaItem>, ? super Long, y> paramq)
  {
    boolean bool2 = true;
    AppMethodBeat.i(164906);
    k.h(paramAlbumItem, "media");
    k.h(paramq, "callback");
    rDI.rDO = paramq;
    rDI.hwO = paramLong;
    Object localObject = rDK;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      if ((k.g(((GalleryItem.AlbumItem)localObject).rBh, paramAlbumItem.rBh) ^ true)) {
        bool1 = bool2;
      }
    }
    else
    {
      ad.i("MicroMsg.PickerDataLoader", "[onLoad] ticket=" + paramLong + " isNeed=" + bool1);
      if (!bool1) {
        break label224;
      }
      if (!k.g(paramAlbumItem.rBh, rDL)) {
        break label150;
      }
      paramq = qXi;
      if (paramq != null) {
        paramq.j("", 3, paramLong);
      }
    }
    for (;;)
    {
      rDK = paramAlbumItem;
      AppMethodBeat.o(164906);
      return;
      bool1 = false;
      break;
      label150:
      if (k.g(paramAlbumItem.rBh, rDM))
      {
        paramq = qXi;
        if (paramq != null) {
          paramq.j("", 2, paramLong);
        }
      }
      else
      {
        paramq = qXi;
        if (paramq != null)
        {
          localObject = paramAlbumItem.rBh;
          GalleryItem.MediaItem localMediaItem = paramAlbumItem.fXP();
          k.g(localMediaItem, "media.mediaItem");
          paramq.j((String)localObject, localMediaItem.getType(), paramLong);
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
    rDK = null;
    o localo = qXi;
    if (localo != null)
    {
      localo.release();
      AppMethodBeat.o(164908);
      return;
    }
    AppMethodBeat.o(164908);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/picker/loader/PickerDataLoader$QueryFolderListener;", "Lcom/tencent/mm/plugin/gallery/model/IMediaQuery$IQueryAlbumFinished;", "()V", "callback", "Lkotlin/Function2;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "Lkotlin/ParameterName;", "name", "albumItems", "", "cost", "", "getCallback", "()Lkotlin/jvm/functions/Function2;", "setCallback", "(Lkotlin/jvm/functions/Function2;)V", "ticket", "getTicket", "()J", "setTicket", "(J)V", "onQueryAlbumFinished", "plugin-gallery_release"})
  public static final class a
    implements i.a
  {
    m<? super LinkedList<GalleryItem.AlbumItem>, ? super Long, y> fLT;
    long hwO;
    
    public a()
    {
      AppMethodBeat.i(164902);
      this.hwO = System.currentTimeMillis();
      AppMethodBeat.o(164902);
    }
    
    public final void ah(LinkedList<GalleryItem.AlbumItem> paramLinkedList)
    {
      AppMethodBeat.i(164901);
      k.h(paramLinkedList, "albumItems");
      long l1 = System.currentTimeMillis();
      long l2 = this.hwO;
      Object localObject1 = e.rDN;
      localObject1 = e.cAa();
      Object localObject2 = ((Iterable)paramLinkedList).iterator();
      for (int i = 0; ((Iterator)localObject2).hasNext(); i = ((GalleryItem.AlbumItem)((Iterator)localObject2).next()).did + i) {}
      localObject2 = new GalleryItem.AlbumItem((String)localObject1, i);
      localObject1 = (GalleryItem.AlbumItem)j.iz((List)paramLinkedList);
      if (localObject1 != null) {}
      for (localObject1 = ((GalleryItem.AlbumItem)localObject1).fXP();; localObject1 = null)
      {
        ((GalleryItem.AlbumItem)localObject2).i((GalleryItem.MediaItem)localObject1);
        paramLinkedList.add(0, localObject2);
        localObject1 = this.fLT;
        if (localObject1 == null) {
          break;
        }
        ((m)localObject1).n(paramLinkedList, Long.valueOf(l1 - l2));
        AppMethodBeat.o(164901);
        return;
      }
      AppMethodBeat.o(164901);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/picker/loader/PickerDataLoader$QueryMediaListener;", "Lcom/tencent/mm/plugin/gallery/model/IMediaQuery$IQueryMediaInAlbumFinished;", "()V", "callback", "Lkotlin/Function3;", "", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "", "", "getCallback", "()Lkotlin/jvm/functions/Function3;", "setCallback", "(Lkotlin/jvm/functions/Function3;)V", "ticket", "getTicket", "()J", "setTicket", "(J)V", "onQueryMediaFinished", "mediaItems", "t", "isFirstNotify", "plugin-gallery_release"})
  public static final class b
    implements i.c
  {
    long hwO;
    q<? super Boolean, ? super LinkedList<GalleryItem.MediaItem>, ? super Long, y> rDO;
    
    public b()
    {
      AppMethodBeat.i(164904);
      this.hwO = System.currentTimeMillis();
      AppMethodBeat.o(164904);
    }
    
    public final void b(LinkedList<GalleryItem.MediaItem> paramLinkedList, long paramLong, boolean paramBoolean)
    {
      y localy = null;
      AppMethodBeat.i(164903);
      long l = System.currentTimeMillis() - this.hwO;
      int i;
      if (this.hwO == paramLong)
      {
        i = 1;
        if (i == 0) {
          break label127;
        }
      }
      for (;;)
      {
        if (paramLinkedList != null)
        {
          q localq = this.rDO;
          if (localq != null)
          {
            localq.d(Boolean.TRUE, paramLinkedList, Long.valueOf(l));
            localy = y.JfV;
          }
          if (localy != null) {}
        }
        else
        {
          paramLinkedList = ((b)this).rDO;
          if (paramLinkedList != null)
          {
            paramLinkedList.d(Boolean.FALSE, new LinkedList(), Long.valueOf(l));
            paramLinkedList = y.JfV;
          }
        }
        AppMethodBeat.o(164903);
        return;
        i = 0;
        break;
        label127:
        paramLinkedList = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.c.e
 * JD-Core Version:    0.7.0.1
 */