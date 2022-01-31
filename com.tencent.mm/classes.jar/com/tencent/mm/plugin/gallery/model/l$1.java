package com.tencent.mm.plugin.gallery.model;

import java.util.ArrayList;
import java.util.HashSet;

final class l$1
  implements Runnable
{
  l$1(l paraml) {}
  
  public final void run()
  {
    ArrayList localArrayList = this.kHq.kHo.aXv();
    l locall = this.kHq;
    g.a[] arrayOfa = new g.a[locall.kHm.size()];
    locall.kHm.toArray(arrayOfa);
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      arrayOfa[i].z(localArrayList);
      i += 1;
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|queryAlbums";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.l.1
 * JD-Core Version:    0.7.0.1
 */