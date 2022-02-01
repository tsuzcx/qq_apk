package com.tencent.mm.plugin.fav.ui.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import java.util.List;

final class FavMediaGalleryUI$8
  implements o.f
{
  FavMediaGalleryUI$8(FavMediaGalleryUI paramFavMediaGalleryUI, List paramList1, List paramList2) {}
  
  public final void onCreateMMMenu(m paramm)
  {
    AppMethodBeat.i(107325);
    paramm.clear();
    paramm.setHeaderTitle("");
    int i = 0;
    while (i < this.rjE.size())
    {
      paramm.d(((Integer)this.rjE.get(i)).intValue(), (CharSequence)this.rjF.get(i));
      i += 1;
    }
    AppMethodBeat.o(107325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI.8
 * JD-Core Version:    0.7.0.1
 */