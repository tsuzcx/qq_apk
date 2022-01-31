package com.tencent.mm.plugin.gallery.model;

import java.util.ArrayList;
import java.util.HashSet;

final class l$2$1
  implements g.c
{
  l$2$1(l.2 param2) {}
  
  public final void a(ArrayList<GalleryItem.MediaItem> paramArrayList, long paramLong)
  {
    l locall = this.kHs.kHq;
    g.b[] arrayOfb = new g.b[locall.kHn.size()];
    locall.kHn.toArray(arrayOfb);
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      arrayOfb[i].a(paramArrayList, paramLong);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.l.2.1
 * JD-Core Version:    0.7.0.1
 */