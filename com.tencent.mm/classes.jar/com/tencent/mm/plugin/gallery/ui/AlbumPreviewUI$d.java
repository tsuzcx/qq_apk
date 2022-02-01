package com.tencent.mm.plugin.gallery.ui;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.plugin.gallery.model.s;
import com.tencent.mm.plugin.gallery.model.s.g;
import com.tencent.mm.plugin.gallery.model.s.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class AlbumPreviewUI$d
  implements Runnable
{
  private String tNc;
  private WeakReference<a> tNd;
  private WeakReference<ProgressDialog> tNe;
  private WeakReference<RecyclerView> tNf;
  
  AlbumPreviewUI$d(String paramString, a parama, ProgressDialog paramProgressDialog, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(111458);
    this.tNc = paramString;
    this.tNd = new WeakReference(parama);
    this.tNe = new WeakReference(paramProgressDialog);
    this.tNf = new WeakReference(paramRecyclerView);
    AppMethodBeat.o(111458);
  }
  
  public final void run()
  {
    AppMethodBeat.i(111459);
    if (bt.isNullOrNil(this.tNc))
    {
      AppMethodBeat.o(111459);
      return;
    }
    ad.i("QuerySmartGalleryAlbumMediaTask", "start query.");
    s locals = s.cVx();
    Object localObject1 = this.tNc;
    s.h local1 = new s.h()
    {
      public final void b(List<s.g> paramAnonymousList, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(161161);
        if (AlbumPreviewUI.d.a(AlbumPreviewUI.d.this) != null)
        {
          localObject = (a)AlbumPreviewUI.d.a(AlbumPreviewUI.d.this).get();
          if (localObject != null)
          {
            if ((!paramAnonymousBoolean) && (((a)localObject).tLn.size() <= paramAnonymousList.size())) {
              break label148;
            }
            AlbumPreviewUI.d.ec(paramAnonymousList);
          }
        }
        Object localObject = new LinkedList();
        paramAnonymousList = paramAnonymousList.iterator();
        for (;;)
        {
          if (!paramAnonymousList.hasNext()) {
            break label229;
          }
          s.g localg = (s.g)paramAnonymousList.next();
          GalleryItem.MediaItem localMediaItem;
          if (localg.type.contains("image"))
          {
            localMediaItem = GalleryItem.MediaItem.a(1, localg.tHS, localg.data, "", localg.type);
            localMediaItem.tGW = localg.tHT;
            ((LinkedList)localObject).add(localMediaItem);
            continue;
            label148:
            AlbumPreviewUI.d.ec(paramAnonymousList.subList(((a)localObject).tLn.size(), paramAnonymousList.size()));
            break;
          }
          if (localg.type.contains("video"))
          {
            localMediaItem = GalleryItem.MediaItem.a(2, localg.tHS, localg.data, "", localg.type);
            localMediaItem.tGW = localg.tHT;
            ((LinkedList)localObject).add(localMediaItem);
          }
        }
        label229:
        paramAnonymousList = new AlbumPreviewUI.c((byte)0);
        paramAnonymousList.tMS = AlbumPreviewUI.d.a(AlbumPreviewUI.d.this);
        paramAnonymousList.tMT = AlbumPreviewUI.d.b(AlbumPreviewUI.d.this);
        paramAnonymousList.tMW = ((LinkedList)localObject);
        paramAnonymousList.tMV = AlbumPreviewUI.d.c(AlbumPreviewUI.d.this);
        paramAnonymousList.tMY = paramAnonymousBoolean;
        e.cUN().f(paramAnonymousList);
        ad.i("QuerySmartGalleryAlbumMediaTask", "finish page query.");
        AppMethodBeat.o(161161);
      }
    };
    locals.tHB = false;
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = s.BASE_URI.buildUpon().appendEncodedPath("albumInfo").build();
    localObject1 = locals.gGN.query((Uri)localObject2, new String[] { "_id", "_data", "mime_type", "date_modified", "datetaken", "latitude", "longitude" }, "albumID=?", new String[] { localObject1 }, null);
    boolean bool;
    if (localObject1 != null)
    {
      int i = ((Cursor)localObject1).getColumnIndex("_id");
      int j = ((Cursor)localObject1).getColumnIndex("_data");
      int k = ((Cursor)localObject1).getColumnIndex("mime_type");
      int m = ((Cursor)localObject1).getColumnIndex("datetaken");
      bool = true;
      while (((Cursor)localObject1).moveToNext())
      {
        if (locals.tHB) {
          break label384;
        }
        localObject2 = new s.g();
        ((s.g)localObject2).tHS = bt.aRf(((Cursor)localObject1).getString(i));
        ((s.g)localObject2).data = ((Cursor)localObject1).getString(j);
        ((s.g)localObject2).type = ((Cursor)localObject1).getString(k);
        ((s.g)localObject2).tHT = bt.aRf(((Cursor)localObject1).getString(m));
        ad.d("MicroMsg.SmartGalleryQueryUtil", "mediaID:%d data:%s type:%s.", new Object[] { Long.valueOf(((s.g)localObject2).tHS), ((s.g)localObject2).data, ((s.g)localObject2).type });
        localArrayList.add(localObject2);
        if (localArrayList.size() % locals.eU == 0)
        {
          local1.b(localArrayList, bool);
          if (bool) {
            bool = false;
          }
        }
      }
      ((Cursor)localObject1).close();
    }
    for (;;)
    {
      local1.b(localArrayList, bool);
      label384:
      AppMethodBeat.o(111459);
      return;
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.d
 * JD-Core Version:    0.7.0.1
 */