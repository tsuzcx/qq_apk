package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class GalleryItem$a
{
  public String key;
  public String path;
  public String xiU;
  public int xiV;
  
  public final String toString()
  {
    AppMethodBeat.i(173737);
    String str = "key: " + this.key + " path: " + this.path + " defaultName: " + this.xiU + " bucketID: " + this.xiV;
    AppMethodBeat.o(173737);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.a
 * JD-Core Version:    0.7.0.1
 */