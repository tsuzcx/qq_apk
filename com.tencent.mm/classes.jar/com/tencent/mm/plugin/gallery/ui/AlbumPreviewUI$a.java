package com.tencent.mm.plugin.gallery.ui;

import android.app.ProgressDialog;
import android.widget.GridView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

final class AlbumPreviewUI$a
  implements Runnable
{
  public WeakReference<a> nfd;
  public WeakReference<ProgressDialog> nfe;
  public WeakReference<TextView> nff;
  public WeakReference<GridView> nfg;
  public LinkedList<GalleryItem.MediaItem> nfh;
  public WeakReference<String> nfi;
  
  public final void run()
  {
    AppMethodBeat.i(21415);
    if (this.nfh == null) {}
    for (int i = -1;; i = this.nfh.size())
    {
      ab.d("MicroMsg.AlbumPreviewUI", "on NotifyMediaItemsChanged, size %d", new Object[] { Integer.valueOf(i) });
      if (this.nfd != null) {
        break;
      }
      ab.w("MicroMsg.AlbumPreviewUI", "null == adapterRef");
      AppMethodBeat.o(21415);
      return;
    }
    Object localObject1 = (a)this.nfd.get();
    if (localObject1 == null)
    {
      ab.w("MicroMsg.AlbumPreviewUI", "null == adapter");
      AppMethodBeat.o(21415);
      return;
    }
    AlbumPreviewUI.W(this.nfh);
    Object localObject2 = this.nfh;
    if (((a)localObject1).ndT)
    {
      ((a)localObject1).ndT = false;
      ((a)localObject1).ndM.clear();
    }
    ((a)localObject1).ndM.addAll((Collection)localObject2);
    ((a)localObject1).notifyDataSetChanged();
    if (this.nfe == null)
    {
      AppMethodBeat.o(21415);
      return;
    }
    localObject2 = (ProgressDialog)this.nfe.get();
    if ((localObject2 != null) && (((ProgressDialog)localObject2).isShowing()))
    {
      ((ProgressDialog)localObject2).dismiss();
      ab.i("MicroMsg.AlbumPreviewUI", "[NotifyMediaItemsChanged] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - AlbumPreviewUI.start) });
    }
    if ((this.nff == null) || (this.nfg == null) || (this.nfi == null))
    {
      AppMethodBeat.o(21415);
      return;
    }
    localObject2 = (TextView)this.nff.get();
    GridView localGridView = (GridView)this.nfg.get();
    String str = (String)this.nfi.get();
    if ((localObject2 != null) && (localGridView != null) && (str != null))
    {
      localObject1 = ((a)localObject1).wP(localGridView.getFirstVisiblePosition());
      if ((!bo.isNullOrNil((String)localObject1)) && (((String)localObject1).equals("album_business_bubble_media_by_coordinate")))
      {
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(str + "附近的照片和视频");
        ((TextView)localObject2).postDelayed(new AlbumPreviewUI.a.1(this, (TextView)localObject2), 2000L);
      }
    }
    AppMethodBeat.o(21415);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(21416);
    String str = super.toString() + "|notifyRunnable";
    AppMethodBeat.o(21416);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.a
 * JD-Core Version:    0.7.0.1
 */