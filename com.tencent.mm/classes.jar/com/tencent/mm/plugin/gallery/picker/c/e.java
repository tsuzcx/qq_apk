package com.tencent.mm.plugin.gallery.picker.c;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/loader/PickerDataLoader;", "", "()V", "TAG", "", "allMediaString", "allVideoMediaString", "currentFolderMedia", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "queryFolderListener", "Lcom/tencent/mm/plugin/gallery/picker/loader/PickerDataLoader$QueryFolderListener;", "queryListener", "Lcom/tencent/mm/plugin/gallery/picker/loader/PickerDataLoader$QueryMediaListener;", "queryService", "Lcom/tencent/mm/plugin/gallery/model/MediaQueryService;", "isNeed2Reload", "", "media", "onInit", "", "onLoad", "ticket", "", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "isSuccessfully", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "albumItems", "cost", "onLoadFolder", "Lkotlin/Function2;", "onRelease", "QueryFolderListener", "QueryMediaListener", "plugin-gallery_release"})
public final class e
{
  private static o wmZ;
  private static b xll;
  private static a xlm;
  private static GalleryItem.AlbumItem xln;
  private static String xlo;
  private static String xlp;
  public static final e xlq;
  
  static
  {
    AppMethodBeat.i(164910);
    xlq = new e();
    xll = new b();
    xlm = new a();
    Object localObject = MMApplicationContext.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources().getString(2131761082);
    p.g(localObject, "MMApplicationContext.get…allery_all_pic_and_video)");
    xlo = (String)localObject;
    localObject = MMApplicationContext.getContext().getString(2131761083);
    p.g(localObject, "MMApplicationContext.get…string.gallery_all_video)");
    xlp = (String)localObject;
    AppMethodBeat.o(164910);
  }
  
  public static void MC()
  {
    AppMethodBeat.i(164905);
    o localo = new o();
    wmZ = localo;
    localo.setQueryType(3);
    localo = wmZ;
    if (localo == null) {
      p.hyc();
    }
    localo.a((i.c)xll);
    localo = wmZ;
    if (localo == null) {
      p.hyc();
    }
    localo.a((i.a)xlm);
    AppMethodBeat.o(164905);
  }
  
  public static void a(long paramLong, GalleryItem.AlbumItem paramAlbumItem, q<? super Boolean, ? super LinkedList<GalleryItem.MediaItem>, ? super Long, x> paramq)
  {
    boolean bool2 = true;
    AppMethodBeat.i(164906);
    p.h(paramAlbumItem, "media");
    p.h(paramq, "callback");
    xll.xlr = paramq;
    xll.joR = paramLong;
    Object localObject = xln;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      if ((p.j(((GalleryItem.AlbumItem)localObject).albumName, paramAlbumItem.albumName) ^ true)) {
        bool1 = bool2;
      }
    }
    else
    {
      Log.i("MicroMsg.PickerDataLoader", "[onLoad] ticket=" + paramLong + " isNeed=" + bool1);
      if (!bool1) {
        break label224;
      }
      if (!p.j(paramAlbumItem.albumName, xlo)) {
        break label150;
      }
      paramq = wmZ;
      if (paramq != null) {
        paramq.D("", 3, paramLong);
      }
    }
    for (;;)
    {
      xln = paramAlbumItem;
      AppMethodBeat.o(164906);
      return;
      bool1 = false;
      break;
      label150:
      if (p.j(paramAlbumItem.albumName, xlp))
      {
        paramq = wmZ;
        if (paramq != null) {
          paramq.D("", 2, paramLong);
        }
      }
      else
      {
        paramq = wmZ;
        if (paramq != null)
        {
          localObject = paramAlbumItem.albumName;
          GalleryItem.MediaItem localMediaItem = paramAlbumItem.gEB();
          p.g(localMediaItem, "media.mediaItem");
          paramq.D((String)localObject, localMediaItem.getType(), paramLong);
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
    xln = null;
    o localo = wmZ;
    if (localo != null)
    {
      localo.release();
      AppMethodBeat.o(164908);
      return;
    }
    AppMethodBeat.o(164908);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/loader/PickerDataLoader$QueryFolderListener;", "Lcom/tencent/mm/plugin/gallery/model/IMediaQuery$IQueryAlbumFinished;", "()V", "callback", "Lkotlin/Function2;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "Lkotlin/ParameterName;", "name", "albumItems", "", "cost", "", "getCallback", "()Lkotlin/jvm/functions/Function2;", "setCallback", "(Lkotlin/jvm/functions/Function2;)V", "ticket", "getTicket", "()J", "setTicket", "(J)V", "onQueryAlbumFinished", "plugin-gallery_release"})
  public static final class a
    implements i.a
  {
    m<? super LinkedList<GalleryItem.AlbumItem>, ? super Long, x> gWp;
    long joR;
    
    public a()
    {
      AppMethodBeat.i(164902);
      this.joR = System.currentTimeMillis();
      AppMethodBeat.o(164902);
    }
    
    public final void aL(LinkedList<GalleryItem.AlbumItem> paramLinkedList)
    {
      AppMethodBeat.i(164901);
      p.h(paramLinkedList, "albumItems");
      long l1 = System.currentTimeMillis();
      long l2 = this.joR;
      Object localObject1 = e.xlq;
      localObject1 = e.dRC();
      Object localObject2 = ((Iterable)paramLinkedList).iterator();
      for (int i = 0; ((Iterator)localObject2).hasNext(); i = ((GalleryItem.AlbumItem)((Iterator)localObject2).next()).dJl + i) {}
      localObject2 = new GalleryItem.AlbumItem((String)localObject1, i);
      localObject1 = (GalleryItem.AlbumItem)j.kt((List)paramLinkedList);
      if (localObject1 != null) {}
      for (localObject1 = ((GalleryItem.AlbumItem)localObject1).gEB();; localObject1 = null)
      {
        ((GalleryItem.AlbumItem)localObject2).c((GalleryItem.MediaItem)localObject1);
        paramLinkedList.add(0, localObject2);
        localObject1 = this.gWp;
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/loader/PickerDataLoader$QueryMediaListener;", "Lcom/tencent/mm/plugin/gallery/model/IMediaQuery$IQueryMediaInAlbumFinished;", "()V", "callback", "Lkotlin/Function3;", "", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "", "", "getCallback", "()Lkotlin/jvm/functions/Function3;", "setCallback", "(Lkotlin/jvm/functions/Function3;)V", "ticket", "getTicket", "()J", "setTicket", "(J)V", "onQueryMediaFinished", "mediaItems", "t", "isFirstNotify", "plugin-gallery_release"})
  public static final class b
    implements i.c
  {
    long joR;
    q<? super Boolean, ? super LinkedList<GalleryItem.MediaItem>, ? super Long, x> xlr;
    
    public b()
    {
      AppMethodBeat.i(164904);
      this.joR = System.currentTimeMillis();
      AppMethodBeat.o(164904);
    }
    
    public final void b(LinkedList<GalleryItem.MediaItem> paramLinkedList, long paramLong, boolean paramBoolean)
    {
      x localx = null;
      AppMethodBeat.i(164903);
      long l = System.currentTimeMillis() - this.joR;
      int i;
      if (this.joR == paramLong)
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
          q localq = this.xlr;
          if (localq != null)
          {
            localq.d(Boolean.TRUE, paramLinkedList, Long.valueOf(l));
            localx = x.SXb;
          }
          if (localx != null) {}
        }
        else
        {
          paramLinkedList = ((b)this).xlr;
          if (paramLinkedList != null)
          {
            paramLinkedList.d(Boolean.FALSE, new LinkedList(), Long.valueOf(l));
            paramLinkedList = x.SXb;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.c.e
 * JD-Core Version:    0.7.0.1
 */