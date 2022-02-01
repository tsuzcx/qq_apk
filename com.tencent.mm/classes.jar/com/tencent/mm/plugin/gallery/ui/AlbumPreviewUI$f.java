package com.tencent.mm.plugin.gallery.ui;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.plugin.gallery.model.i.c;
import com.tencent.mm.plugin.gallery.model.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class AlbumPreviewUI$f
  implements Runnable
{
  boolean CbB;
  WeakReference<ImageFolderMgrView> Cbl;
  WeakReference<a> Cbn;
  WeakReference<ProgressDialog> Cbo;
  List<Long> idList;
  int type;
  
  public final void run()
  {
    AppMethodBeat.i(111462);
    s locals = s.etX();
    i.c local1 = new i.c()
    {
      public final void b(LinkedList<GalleryItem.MediaItem> paramAnonymousLinkedList, long paramAnonymousLong, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(111461);
        Log.i("MicroMsg.AlbumPreviewUI", "RetrieveFavMediaTask onQueryMediaFinished cancelUINotify: %s.", new Object[] { Boolean.valueOf(AlbumPreviewUI.f.this.CbB) });
        if (AlbumPreviewUI.f.this.CbB)
        {
          AppMethodBeat.o(111461);
          return;
        }
        LinkedList localLinkedList = new LinkedList();
        if (paramAnonymousLinkedList != null) {
          localLinkedList.addAll(paramAnonymousLinkedList);
        }
        paramAnonymousLinkedList = localLinkedList.iterator();
        while (paramAnonymousLinkedList.hasNext())
        {
          GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)paramAnonymousLinkedList.next();
          Log.d("MicroMsg.AlbumPreviewUI", "type: %s path: %s", new Object[] { localMediaItem.mMimeType, localMediaItem.AAz });
        }
        paramAnonymousLinkedList = new AlbumPreviewUI.d((byte)0);
        paramAnonymousLinkedList.Cbn = AlbumPreviewUI.f.this.Cbn;
        paramAnonymousLinkedList.Cbo = AlbumPreviewUI.f.this.Cbo;
        paramAnonymousLinkedList.Cbr = localLinkedList;
        paramAnonymousLinkedList.Cbl = AlbumPreviewUI.f.this.Cbl;
        e.etm().postToMainThread(paramAnonymousLinkedList);
        AppMethodBeat.o(111461);
      }
    };
    Object localObject2 = this.idList;
    int n = this.type;
    locals.BVW = false;
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = localObject2;
    if (Util.isNullOrNil((List)localObject2))
    {
      Log.i("MicroMsg.SmartGalleryQueryUtil", "query fav media id list now.");
      Log.i("MicroMsg.SmartGalleryQueryUtil", "query fav media id, type: %d.", new Object[] { Integer.valueOf(n) });
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      switch (n)
      {
      default: 
        ((List)localObject2).add(Integer.valueOf(2));
      }
      for (;;)
      {
        localObject2 = ((ag)h.ag(ag.class)).getFavSearchStorage().b(null, null, (List)localObject2);
        if (!Util.isNullOrNil((List)localObject2))
        {
          Log.i("MicroMsg.SmartGalleryQueryUtil", "fav list contains img or video.");
          ((List)localObject1).addAll((Collection)localObject2);
        }
        if (!Util.isNullOrNil((List)localObject1)) {
          break;
        }
        Log.i("MicroMsg.SmartGalleryQueryUtil", "fav list do not contain img or video.");
        local1.b(localLinkedList, -1L, true);
        AppMethodBeat.o(111462);
        return;
        ((List)localObject2).add(Integer.valueOf(2));
        continue;
        ((List)localObject2).add(Integer.valueOf(4));
        continue;
        ((List)localObject2).add(Integer.valueOf(21));
      }
    }
    int i1 = ((List)localObject1).size();
    Log.i("MicroMsg.SmartGalleryQueryUtil", "fav count: %d.", new Object[] { Integer.valueOf(i1) });
    int j = 0;
    int k = Math.min(i1, 100);
    int i = k + 0;
    boolean bool1 = true;
    boolean bool2;
    if (!locals.BVW)
    {
      Log.i("MicroMsg.SmartGalleryQueryUtil", "get fav, count: %d.", new Object[] { Integer.valueOf(k) });
      localLinkedList.addAll(s.v(((List)localObject1).subList(j, i), n));
      local1.b(localLinkedList, -1L, bool1);
      bool2 = bool1;
      if (bool1) {
        bool2 = false;
      }
      int m = i1 - localLinkedList.size();
      if (m <= 0) {
        break label442;
      }
      k = Math.min(m, 100);
      m = i + k;
      j = i;
      i = m;
    }
    label442:
    for (;;)
    {
      if (i >= i1)
      {
        AppMethodBeat.o(111462);
        return;
      }
      bool1 = bool2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.f
 * JD-Core Version:    0.7.0.1
 */