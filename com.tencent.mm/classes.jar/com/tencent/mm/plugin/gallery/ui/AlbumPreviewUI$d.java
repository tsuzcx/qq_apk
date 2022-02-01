package com.tencent.mm.plugin.gallery.ui;

import android.app.ProgressDialog;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.p;
import com.tencent.mm.plugin.gallery.model.p.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;

final class AlbumPreviewUI$d
  implements Runnable
{
  String CaH;
  WeakReference<ImageFolderMgrView> Cbl;
  WeakReference<a> Cbn;
  WeakReference<ProgressDialog> Cbo;
  WeakReference<TextView> Cbp;
  WeakReference<RecyclerView> Cbq;
  LinkedList<GalleryItem.MediaItem> Cbr;
  boolean Cbs = false;
  
  public final void run()
  {
    AppMethodBeat.i(111455);
    if (this.Cbr == null) {}
    for (int i = -1;; i = this.Cbr.size())
    {
      Log.d("MicroMsg.AlbumPreviewUI", "on NotifyMediaItemsChanged, size %d", new Object[] { Integer.valueOf(i) });
      AlbumPreviewUI.bh(this.Cbr);
      if (this.Cbn != null) {
        break;
      }
      Log.w("MicroMsg.AlbumPreviewUI", "null == adapterRef");
      AppMethodBeat.o(111455);
      return;
    }
    Object localObject1 = (a)this.Cbn.get();
    if (localObject1 == null)
    {
      Log.w("MicroMsg.AlbumPreviewUI", "null == adapter");
      AppMethodBeat.o(111455);
      return;
    }
    if (this.Cbq == null)
    {
      AppMethodBeat.o(111455);
      return;
    }
    RecyclerView localRecyclerView = (RecyclerView)this.Cbq.get();
    if (localRecyclerView == null)
    {
      AppMethodBeat.o(111455);
      return;
    }
    Log.d("MicroMsg.AlbumPreviewUI", "isSwitchAlbum: %s.", new Object[] { Boolean.valueOf(this.Cbs) });
    Object localObject2 = p.BVL;
    p.etV().fk(this.Cbr);
    if (this.Cbs)
    {
      this.Cbs = false;
      localObject2 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$NotifyMediaItemsChanged", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
      localRecyclerView.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$NotifyMediaItemsChanged", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((a)localObject1).bf(this.Cbr);
      localObject2 = p.BVL;
      localObject2 = p.etV();
      p.c localc = p.c.BVO;
      if (this.Cbr.size() > 32)
      {
        i = 32;
        ((p)localObject2).a(localc, 0, i, ((a)localObject1).BZG.size());
      }
    }
    for (;;)
    {
      if (this.Cbo != null) {
        break label335;
      }
      AppMethodBeat.o(111455);
      return;
      i = this.Cbr.size();
      break;
      ((a)localObject1).bg(this.Cbr);
    }
    label335:
    localObject2 = (ProgressDialog)this.Cbo.get();
    if ((localObject2 != null) && (((ProgressDialog)localObject2).isShowing()))
    {
      ((ProgressDialog)localObject2).dismiss();
      Log.i("MicroMsg.AlbumPreviewUI", "[NotifyMediaItemsChanged] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - AlbumPreviewUI.start) });
    }
    if (this.Cbl != null)
    {
      localObject2 = (ImageFolderMgrView)this.Cbl.get();
      if (localObject2 != null) {
        ((ImageFolderMgrView)localObject2).setFavItemCount(this.Cbr.size());
      }
    }
    if ((this.Cbp == null) || (Util.isNullOrNil(this.CaH)))
    {
      AppMethodBeat.o(111455);
      return;
    }
    localObject2 = (TextView)this.Cbp.get();
    if (localObject2 != null)
    {
      localObject1 = ((a)localObject1).SZ(((GridLayoutManager)localRecyclerView.getLayoutManager()).kJ());
      if ((!Util.isNullOrNil((String)localObject1)) && (((String)localObject1).equals("album_business_bubble_media_by_coordinate")))
      {
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.CaH.concat("附近的照片和视频"));
        ((TextView)localObject2).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(111454);
            if (8 == this.Cbt.getVisibility())
            {
              AppMethodBeat.o(111454);
              return;
            }
            this.Cbt.animate().alpha(0.0F).setDuration(300L).withEndAction(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(111453);
                AlbumPreviewUI.d.1.this.Cbt.setVisibility(8);
                AlbumPreviewUI.d.1.this.Cbt.setAlpha(1.0F);
                AppMethodBeat.o(111453);
              }
            });
            AppMethodBeat.o(111454);
          }
        }, 2000L);
      }
    }
    AppMethodBeat.o(111455);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(111456);
    String str = super.toString() + "|NotifyMediaItemsChanged";
    AppMethodBeat.o(111456);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.d
 * JD-Core Version:    0.7.0.1
 */