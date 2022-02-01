package com.tencent.mm.plugin.gallery.picker.c;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.b.i;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.l.a;
import com.tencent.mm.plugin.gallery.model.l.c;
import com.tencent.mm.plugin.gallery.model.q;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/loader/PickerDataLoader;", "", "()V", "TAG", "", "allMediaString", "allVideoMediaString", "currentFolderMedia", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "queryFolderListener", "Lcom/tencent/mm/plugin/gallery/picker/loader/PickerDataLoader$QueryFolderListener;", "queryListener", "Lcom/tencent/mm/plugin/gallery/picker/loader/PickerDataLoader$QueryMediaListener;", "queryService", "Lcom/tencent/mm/plugin/gallery/model/MediaQueryService;", "isNeed2Reload", "", "media", "onInit", "", "onLoad", "ticket", "", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "isSuccessfully", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "albumItems", "cost", "onLoadFolder", "Lkotlin/Function2;", "onRelease", "QueryFolderListener", "QueryMediaListener", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private static q GzD;
  public static final e HJS;
  private static e.b HJT;
  private static a HJU;
  private static GalleryItem.AlbumItem HJV;
  private static String HJW;
  private static String HJX;
  
  static
  {
    AppMethodBeat.i(164910);
    HJS = new e();
    HJT = new e.b();
    HJU = new a();
    String str = MMApplicationContext.getContext().getResources().getString(b.i.gallery_all_pic_and_video);
    s.s(str, "getContext().resources.g…allery_all_pic_and_video)");
    HJW = str;
    str = MMApplicationContext.getContext().getString(b.i.gallery_all_video);
    s.s(str, "getContext().getString(R.string.gallery_all_video)");
    HJX = str;
    AppMethodBeat.o(164910);
  }
  
  public static void apC()
  {
    AppMethodBeat.i(164905);
    q localq = new q();
    GzD = localq;
    s.checkNotNull(localq);
    localq.setQueryType(3);
    localq = GzD;
    s.checkNotNull(localq);
    localq.a((l.c)HJT);
    localq = GzD;
    s.checkNotNull(localq);
    localq.a((l.a)HJU);
    AppMethodBeat.o(164905);
  }
  
  public static void onRelease()
  {
    AppMethodBeat.i(164908);
    HJV = null;
    q localq = GzD;
    if (localq != null)
    {
      if (localq.HHV != null) {
        localq.HHV.clear();
      }
      if (localq.HHX != null) {
        localq.HHX.clear();
      }
      if (localq.HHY != null) {
        localq.HHY.clear();
      }
    }
    AppMethodBeat.o(164908);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/loader/PickerDataLoader$QueryFolderListener;", "Lcom/tencent/mm/plugin/gallery/model/IMediaQuery$IQueryAlbumFinished;", "()V", "callback", "Lkotlin/Function2;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "Lkotlin/ParameterName;", "name", "albumItems", "", "cost", "", "getCallback", "()Lkotlin/jvm/functions/Function2;", "setCallback", "(Lkotlin/jvm/functions/Function2;)V", "ticket", "getTicket", "()J", "setTicket", "(J)V", "onQueryAlbumFinished", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements l.a
  {
    m<? super LinkedList<GalleryItem.AlbumItem>, ? super Long, ah> mgM;
    long oXa;
    
    public a()
    {
      AppMethodBeat.i(164902);
      this.oXa = System.currentTimeMillis();
      AppMethodBeat.o(164902);
    }
    
    public final void bm(LinkedList<GalleryItem.AlbumItem> paramLinkedList)
    {
      AppMethodBeat.i(164901);
      s.u(paramLinkedList, "albumItems");
      long l1 = System.currentTimeMillis();
      long l2 = this.oXa;
      Object localObject1 = e.fBa();
      Object localObject2 = ((Iterable)paramLinkedList).iterator();
      for (int i = 0; ((Iterator)localObject2).hasNext(); i = ((GalleryItem.AlbumItem)((Iterator)localObject2).next()).hGP + i) {}
      localObject2 = new GalleryItem.AlbumItem((String)localObject1, i);
      localObject1 = (GalleryItem.AlbumItem)p.oL((List)paramLinkedList);
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = ((GalleryItem.AlbumItem)localObject1).HHB)
      {
        ((GalleryItem.AlbumItem)localObject2).HHB = ((GalleryItem.MediaItem)localObject1);
        paramLinkedList.add(0, localObject2);
        localObject1 = this.mgM;
        if (localObject1 != null) {
          ((m)localObject1).invoke(paramLinkedList, Long.valueOf(l1 - l2));
        }
        AppMethodBeat.o(164901);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.c.e
 * JD-Core Version:    0.7.0.1
 */