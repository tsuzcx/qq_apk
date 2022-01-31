package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.List;

final class FavImgGalleryUI$5
  implements n.c
{
  FavImgGalleryUI$5(FavImgGalleryUI paramFavImgGalleryUI, List paramList1, List paramList2) {}
  
  public final void a(l paraml)
  {
    paraml.setHeaderTitle("");
    int i = 0;
    while (i < this.jfS.size())
    {
      paraml.e(((Integer)this.jfS.get(i)).intValue(), (CharSequence)this.jfT.get(i));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavImgGalleryUI.5
 * JD-Core Version:    0.7.0.1
 */