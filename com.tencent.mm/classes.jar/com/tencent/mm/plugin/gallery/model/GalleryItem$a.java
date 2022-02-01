package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class GalleryItem$a
{
  public String HHF;
  public int HHG;
  public String key;
  public String path;
  
  public final String toString()
  {
    AppMethodBeat.i(173737);
    String str = "key: " + this.key + " path: " + this.path + " defaultName: " + this.HHF + " bucketID: " + this.HHG;
    AppMethodBeat.o(173737);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.a
 * JD-Core Version:    0.7.0.1
 */