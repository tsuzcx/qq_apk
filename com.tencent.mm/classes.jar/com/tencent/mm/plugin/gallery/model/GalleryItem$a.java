package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class GalleryItem$a
{
  public String key;
  public String path;
  public String sKf;
  public int sKg;
  
  public final String toString()
  {
    AppMethodBeat.i(173737);
    String str = "key: " + this.key + " path: " + this.path + " defaultName: " + this.sKf + " bucketID: " + this.sKg;
    AppMethodBeat.o(173737);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.a
 * JD-Core Version:    0.7.0.1
 */