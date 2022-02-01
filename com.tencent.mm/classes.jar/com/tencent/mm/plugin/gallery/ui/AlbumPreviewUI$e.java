package com.tencent.mm.plugin.gallery.ui;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.plugin.gallery.model.s;
import com.tencent.mm.plugin.gallery.model.s.g;
import com.tencent.mm.plugin.gallery.model.s.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class AlbumPreviewUI$e
  implements Runnable
{
  private String Cbw;
  private WeakReference<a> Cbx;
  private WeakReference<ProgressDialog> Cby;
  private WeakReference<RecyclerView> Cbz;
  
  AlbumPreviewUI$e(String paramString, a parama, ProgressDialog paramProgressDialog, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(241285);
    this.Cbw = paramString;
    this.Cbx = new WeakReference(parama);
    this.Cby = new WeakReference(paramProgressDialog);
    this.Cbz = new WeakReference(paramRecyclerView);
    AppMethodBeat.o(241285);
  }
  
  public final void run()
  {
    AppMethodBeat.i(111459);
    if (Util.isNullOrNil(this.Cbw))
    {
      AppMethodBeat.o(111459);
      return;
    }
    Log.i("QuerySmartGalleryAlbumMediaTask", "start query.");
    s locals = s.etX();
    Object localObject1 = this.Cbw;
    s.h local1 = new s.h()
    {
      public final void g(List<s.g> paramAnonymousList, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(161161);
        if (AlbumPreviewUI.e.a(AlbumPreviewUI.e.this) != null)
        {
          localObject = (a)AlbumPreviewUI.e.a(AlbumPreviewUI.e.this).get();
          if (localObject != null)
          {
            if ((!paramAnonymousBoolean) && (((a)localObject).BZG.size() <= paramAnonymousList.size())) {
              break label148;
            }
            AlbumPreviewUI.e.fp(paramAnonymousList);
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
            localMediaItem = GalleryItem.MediaItem.a(1, localg.BWq, localg.data, "", localg.type);
            localMediaItem.BVm = localg.BWr;
            ((LinkedList)localObject).add(localMediaItem);
            continue;
            label148:
            AlbumPreviewUI.e.fp(paramAnonymousList.subList(((a)localObject).BZG.size(), paramAnonymousList.size()));
            break;
          }
          if (localg.type.contains("video"))
          {
            localMediaItem = GalleryItem.MediaItem.a(2, localg.BWq, localg.data, "", localg.type);
            localMediaItem.BVm = localg.BWr;
            ((LinkedList)localObject).add(localMediaItem);
          }
        }
        label229:
        paramAnonymousList = new AlbumPreviewUI.d((byte)0);
        paramAnonymousList.Cbn = AlbumPreviewUI.e.a(AlbumPreviewUI.e.this);
        paramAnonymousList.Cbo = AlbumPreviewUI.e.b(AlbumPreviewUI.e.this);
        paramAnonymousList.Cbr = ((LinkedList)localObject);
        paramAnonymousList.Cbq = AlbumPreviewUI.e.c(AlbumPreviewUI.e.this);
        paramAnonymousList.Cbs = paramAnonymousBoolean;
        e.etm().postToMainThread(paramAnonymousList);
        Log.i("QuerySmartGalleryAlbumMediaTask", "finish page query.");
        AppMethodBeat.o(161161);
      }
    };
    locals.BVV = false;
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = s.BVU.buildUpon().appendEncodedPath("albumInfo").build();
    localObject1 = locals.kiH.query((Uri)localObject2, new String[] { "_id", "_data", "mime_type", "date_modified", "datetaken", "latitude", "longitude" }, "albumID=?", new String[] { localObject1 }, null);
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
        if (locals.BVV) {
          break label384;
        }
        localObject2 = new s.g();
        ((s.g)localObject2).BWq = Util.safeParseLong(((Cursor)localObject1).getString(i));
        ((s.g)localObject2).data = ((Cursor)localObject1).getString(j);
        ((s.g)localObject2).type = ((Cursor)localObject1).getString(k);
        ((s.g)localObject2).BWr = Util.safeParseLong(((Cursor)localObject1).getString(m));
        Log.d("MicroMsg.SmartGalleryQueryUtil", "mediaID:%d data:%s type:%s.", new Object[] { Long.valueOf(((s.g)localObject2).BWq), ((s.g)localObject2).data, ((s.g)localObject2).type });
        localArrayList.add(localObject2);
        if (localArrayList.size() % locals.aeh == 0)
        {
          local1.g(localArrayList, bool);
          if (bool) {
            bool = false;
          }
        }
      }
      ((Cursor)localObject1).close();
    }
    for (;;)
    {
      local1.g(localArrayList, bool);
      label384:
      AppMethodBeat.o(111459);
      return;
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.e
 * JD-Core Version:    0.7.0.1
 */