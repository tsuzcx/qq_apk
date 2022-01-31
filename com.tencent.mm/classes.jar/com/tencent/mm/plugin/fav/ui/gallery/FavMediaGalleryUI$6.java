package com.tencent.mm.plugin.fav.ui.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.List;

final class FavMediaGalleryUI$6
  implements n.c
{
  FavMediaGalleryUI$6(FavMediaGalleryUI paramFavMediaGalleryUI, List paramList1, List paramList2) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(74513);
    paraml.setHeaderTitle("");
    int i = 0;
    while (i < this.loL.size())
    {
      paraml.e(((Integer)this.loL.get(i)).intValue(), (CharSequence)this.loM.get(i));
      i += 1;
    }
    AppMethodBeat.o(74513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI.6
 * JD-Core Version:    0.7.0.1
 */