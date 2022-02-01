package com.tencent.mm.plugin.fav.ui.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import java.util.List;

final class FavMediaGalleryUI$7
  implements n.d
{
  FavMediaGalleryUI$7(FavMediaGalleryUI paramFavMediaGalleryUI, List paramList1, List paramList2) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(107325);
    paraml.clear();
    paraml.setHeaderTitle("");
    int i = 0;
    while (i < this.pMa.size())
    {
      paraml.c(((Integer)this.pMa.get(i)).intValue(), (CharSequence)this.pMb.get(i));
      i += 1;
    }
    AppMethodBeat.o(107325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI.7
 * JD-Core Version:    0.7.0.1
 */