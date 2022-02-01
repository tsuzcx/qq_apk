package com.tencent.mm.plugin.fav.ui.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import java.util.List;

final class FavMediaGalleryUI$7
  implements u.g
{
  FavMediaGalleryUI$7(FavMediaGalleryUI paramFavMediaGalleryUI, List paramList1, List paramList2) {}
  
  public final void onCreateMMMenu(s params)
  {
    AppMethodBeat.i(107325);
    params.clear();
    params.setHeaderTitle("");
    int i = 0;
    while (i < this.xVu.size())
    {
      params.c(((Integer)this.xVu.get(i)).intValue(), (CharSequence)this.xVv.get(i));
      i += 1;
    }
    AppMethodBeat.o(107325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI.7
 * JD-Core Version:    0.7.0.1
 */