package com.tencent.mm.plugin.gallery.picker.c;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.i.a;
import com.tencent.mm.plugin.gallery.model.i.c;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.a.j;
import d.g.a.m;
import d.g.a.q;
import d.g.b.k;
import d.l;
import d.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/loader/PickerDataLoader;", "", "()V", "TAG", "", "allMediaString", "kotlin.jvm.PlatformType", "allVideoMediaString", "currentFolderMedia", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "queryFolderListener", "Lcom/tencent/mm/plugin/gallery/picker/loader/PickerDataLoader$QueryFolderListener;", "queryListener", "Lcom/tencent/mm/plugin/gallery/picker/loader/PickerDataLoader$QueryMediaListener;", "queryService", "Lcom/tencent/mm/plugin/gallery/model/MediaQueryService;", "isNeed2Reload", "", "media", "onInit", "", "onLoad", "ticket", "", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "isSuccessfully", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "albumItems", "cost", "onLoadFolder", "Lkotlin/Function2;", "onRelease", "QueryFolderListener", "QueryMediaListener", "plugin-gallery_release"})
public final class e
{
  private static o rXK;
  private static b sMA;
  private static a sMB;
  private static GalleryItem.AlbumItem sMC;
  private static String sMD;
  private static String sME;
  public static final e sMF;
  
  static
  {
    AppMethodBeat.i(164910);
    sMF = new e();
    sMA = new b();
    sMB = new a();
    Context localContext = ai.getContext();
    k.g(localContext, "MMApplicationContext.getContext()");
    sMD = localContext.getResources().getString(2131759758);
    sME = ai.getContext().getString(2131759759);
    AppMethodBeat.o(164910);
  }
  
  public static void BE()
  {
    AppMethodBeat.i(164905);
    o localo = new o();
    rXK = localo;
    localo.setQueryType(3);
    localo = rXK;
    if (localo == null) {
      k.fOy();
    }
    localo.a((i.c)sMA);
    localo = rXK;
    if (localo == null) {
      k.fOy();
    }
    localo.a((i.a)sMB);
    AppMethodBeat.o(164905);
  }
  
  public static void a(long paramLong, GalleryItem.AlbumItem paramAlbumItem, q<? super Boolean, ? super LinkedList<GalleryItem.MediaItem>, ? super Long, y> paramq)
  {
    boolean bool2 = true;
    AppMethodBeat.i(164906);
    k.h(paramAlbumItem, "media");
    k.h(paramq, "callback");
    sMA.sMG = paramq;
    sMA.hXp = paramLong;
    Object localObject = sMC;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      if ((k.g(((GalleryItem.AlbumItem)localObject).sJZ, paramAlbumItem.sJZ) ^ true)) {
        bool1 = bool2;
      }
    }
    else
    {
      ac.i("MicroMsg.PickerDataLoader", "[onLoad] ticket=" + paramLong + " isNeed=" + bool1);
      if (!bool1) {
        break label224;
      }
      if (!k.g(paramAlbumItem.sJZ, sMD)) {
        break label150;
      }
      paramq = rXK;
      if (paramq != null) {
        paramq.j("", 3, paramLong);
      }
    }
    for (;;)
    {
      sMC = paramAlbumItem;
      AppMethodBeat.o(164906);
      return;
      bool1 = false;
      break;
      label150:
      if (k.g(paramAlbumItem.sJZ, sME))
      {
        paramq = rXK;
        if (paramq != null) {
          paramq.j("", 2, paramLong);
        }
      }
      else
      {
        paramq = rXK;
        if (paramq != null)
        {
          localObject = paramAlbumItem.sJZ;
          GalleryItem.MediaItem localMediaItem = paramAlbumItem.cWr();
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
    sMC = null;
    o localo = rXK;
    if (localo != null)
    {
      localo.release();
      AppMethodBeat.o(164908);
      return;
    }
    AppMethodBeat.o(164908);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/loader/PickerDataLoader$QueryFolderListener;", "Lcom/tencent/mm/plugin/gallery/model/IMediaQuery$IQueryAlbumFinished;", "()V", "callback", "Lkotlin/Function2;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "Lkotlin/ParameterName;", "name", "albumItems", "", "cost", "", "getCallback", "()Lkotlin/jvm/functions/Function2;", "setCallback", "(Lkotlin/jvm/functions/Function2;)V", "ticket", "getTicket", "()J", "setTicket", "(J)V", "onQueryAlbumFinished", "plugin-gallery_release"})
  public static final class a
    implements i.a
  {
    m<? super LinkedList<GalleryItem.AlbumItem>, ? super Long, y> fPF;
    long hXp;
    
    public a()
    {
      AppMethodBeat.i(164902);
      this.hXp = System.currentTimeMillis();
      AppMethodBeat.o(164902);
    }
    
    public final void ao(LinkedList<GalleryItem.AlbumItem> paramLinkedList)
    {
      AppMethodBeat.i(164901);
      k.h(paramLinkedList, "albumItems");
      long l1 = System.currentTimeMillis();
      long l2 = this.hXp;
      Object localObject1 = e.sMF;
      localObject1 = e.cNm();
      Object localObject2 = ((Iterable)paramLinkedList).iterator();
      for (int i = 0; ((Iterator)localObject2).hasNext(); i = ((GalleryItem.AlbumItem)((Iterator)localObject2).next()).dfy + i) {}
      localObject2 = new GalleryItem.AlbumItem((String)localObject1, i);
      localObject1 = (GalleryItem.AlbumItem)j.iP((List)paramLinkedList);
      if (localObject1 != null) {}
      for (localObject1 = ((GalleryItem.AlbumItem)localObject1).cWr();; localObject1 = null)
      {
        ((GalleryItem.AlbumItem)localObject2).b((GalleryItem.MediaItem)localObject1);
        paramLinkedList.add(0, localObject2);
        localObject1 = this.fPF;
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/loader/PickerDataLoader$QueryMediaListener;", "Lcom/tencent/mm/plugin/gallery/model/IMediaQuery$IQueryMediaInAlbumFinished;", "()V", "callback", "Lkotlin/Function3;", "", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "", "", "getCallback", "()Lkotlin/jvm/functions/Function3;", "setCallback", "(Lkotlin/jvm/functions/Function3;)V", "ticket", "getTicket", "()J", "setTicket", "(J)V", "onQueryMediaFinished", "mediaItems", "t", "isFirstNotify", "plugin-gallery_release"})
  public static final class b
    implements i.c
  {
    long hXp;
    q<? super Boolean, ? super LinkedList<GalleryItem.MediaItem>, ? super Long, y> sMG;
    
    public b()
    {
      AppMethodBeat.i(164904);
      this.hXp = System.currentTimeMillis();
      AppMethodBeat.o(164904);
    }
    
    public final void b(LinkedList<GalleryItem.MediaItem> paramLinkedList, long paramLong, boolean paramBoolean)
    {
      y localy = null;
      AppMethodBeat.i(164903);
      long l = System.currentTimeMillis() - this.hXp;
      int i;
      if (this.hXp == paramLong)
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
          q localq = this.sMG;
          if (localq != null)
          {
            localq.d(Boolean.TRUE, paramLinkedList, Long.valueOf(l));
            localy = y.KTp;
          }
          if (localy != null) {}
        }
        else
        {
          paramLinkedList = ((b)this).sMG;
          if (paramLinkedList != null)
          {
            paramLinkedList.d(Boolean.FALSE, new LinkedList(), Long.valueOf(l));
            paramLinkedList = y.KTp;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.c.e
 * JD-Core Version:    0.7.0.1
 */