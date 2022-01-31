package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;

final class a$2
  implements View.OnClickListener
{
  a$2(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21360);
    if (!(paramView.getTag(2131824026) instanceof Integer))
    {
      AppMethodBeat.o(21360);
      return;
    }
    Integer localInteger = (Integer)paramView.getTag(2131824026);
    if (localInteger == null)
    {
      ab.e("MicroMsg.AlbumAdapter", "[onClick] null == position!");
      AppMethodBeat.o(21360);
      return;
    }
    GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)a.a(this.ndW).get(localInteger.intValue());
    if ((localMediaItem == null) || (bo.isNullOrNil(localMediaItem.fQn)))
    {
      ab.e("MicroMsg.AlbumAdapter", "[onClick] null == item!");
      AppMethodBeat.o(21360);
      return;
    }
    ab.i("MicroMsg.AlbumAdapter", "click Image path:" + localMediaItem.fQn);
    int i;
    int j;
    if (a.b(this.ndW).contains(localMediaItem))
    {
      a.b(this.ndW).indexOf(localMediaItem);
      a.b(this.ndW).remove(localMediaItem);
      i = 1;
      j = 0;
    }
    for (;;)
    {
      if (j == 0) {
        if (a.i(this.ndW) != null) {
          a.i(this.ndW).V(this.ndW.ndN.size(), localInteger.intValue(), i);
        }
      }
      for (;;)
      {
        if (1 != i) {
          break label781;
        }
        ((CheckBox)paramView.getTag(2131824025)).setChecked(false);
        ((View)paramView.getTag(2131826764)).setVisibility(0);
        ((View)paramView.getTag(2131826764)).setBackgroundResource(2131690180);
        AppMethodBeat.o(21360);
        return;
        if ((com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 3) && (localMediaItem != null) && (localMediaItem.mMimeType.equalsIgnoreCase("image/gif")))
        {
          i = com.tencent.mm.a.e.cM(localMediaItem.fQn);
          if (!((d)g.G(d.class)).getProvider().KG(localMediaItem.fQn)) {
            try
            {
              a.c(this.ndW).aK(13459, i + ",1,,0");
              h.bO(a.d(this.ndW), a.d(this.ndW).getString(2131300305));
              AppMethodBeat.o(21360);
              return;
            }
            catch (RemoteException paramView)
            {
              for (;;)
              {
                ab.printErrStackTrace("MicroMsg.AlbumAdapter", paramView, "", new Object[0]);
              }
            }
          }
        }
        if (((a.e(this.ndW) == 2) || (a.e(this.ndW) == 3)) && ((localMediaItem instanceof GalleryItem.VideoMediaItem)) && (!bo.isNullOrNil(a.f(this.ndW))) && (a.f(this.ndW).equals("album_business_bubble_media_by_coordinate")) && (((GalleryItem.VideoMediaItem)localMediaItem).fQq >= a.g(this.ndW) * 1000 + 500))
        {
          h.bO(a.d(this.ndW), a.d(this.ndW).getResources().getString(2131300323, new Object[] { Integer.valueOf(a.g(this.ndW)) }));
          AppMethodBeat.o(21360);
          return;
        }
        if (a.b(this.ndW).size() >= a.h(this.ndW)) {
          break label829;
        }
        a.b(this.ndW).add(localMediaItem);
        a.b(this.ndW).size();
        i = 0;
        j = 0;
        break;
        if (a.e(this.ndW) == 1) {
          h.bO(a.d(this.ndW), a.d(this.ndW).getResources().getQuantityString(2131361804, a.h(this.ndW), new Object[] { Integer.valueOf(a.h(this.ndW)) }));
        } else if (a.e(this.ndW) == 2) {
          h.bO(a.d(this.ndW), a.d(this.ndW).getResources().getQuantityString(2131361806, a.h(this.ndW), new Object[] { Integer.valueOf(a.h(this.ndW)) }));
        } else {
          h.bO(a.d(this.ndW), a.d(this.ndW).getResources().getQuantityString(2131361805, a.h(this.ndW), new Object[] { Integer.valueOf(a.h(this.ndW)) }));
        }
      }
      label781:
      ((CheckBox)paramView.getTag(2131824025)).setChecked(true);
      ((View)paramView.getTag(2131826764)).setVisibility(0);
      ((View)paramView.getTag(2131826764)).setBackgroundResource(2131690159);
      AppMethodBeat.o(21360);
      return;
      label829:
      i = 1;
      j = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.a.2
 * JD-Core Version:    0.7.0.1
 */