package com.tencent.mm.plugin.gallery.ui;

import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;

final class e
{
  int UL = -1;
  private c kJB;
  
  public e(c paramc)
  {
    this.kJB = paramc;
  }
  
  final void sb(int paramInt)
  {
    c localc = this.kJB;
    if ((localc.kHC == null) || (localc.kHC.size() <= paramInt) || (paramInt < 0)) {
      return;
    }
    long l = ((GalleryItem.MediaItem)localc.kHC.get(paramInt)).kGX;
    String str3 = ((GalleryItem.MediaItem)localc.kHC.get(paramInt)).jSX;
    String str2 = ((GalleryItem.MediaItem)localc.kHC.get(paramInt)).eAu;
    String str1 = str3;
    if (bk.bl(str3)) {
      str1 = str2;
    }
    com.tencent.mm.plugin.gallery.model.c.aXa().b(str1, ((GalleryItem.MediaItem)localc.kHC.get(paramInt)).getType(), str2, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.e
 * JD-Core Version:    0.7.0.1
 */