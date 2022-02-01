package com.tencent.mm.plugin.gallery.model;

public class GalleryItem$PrivateAlbumItem
  extends GalleryItem.AlbumItem
{
  public s.a tHb;
  
  public GalleryItem$PrivateAlbumItem(s.a parama)
  {
    super(parama.tGK, parama.tHG);
    this.tHb = parama;
  }
  
  public final String axA()
  {
    return this.tHb.tHI;
  }
  
  public final String cVj()
  {
    return this.tHb.tHI;
  }
  
  public final long cVk()
  {
    return this.tHb.tHH;
  }
  
  public final int cVl()
  {
    int j = 1;
    s.b localb = this.tHb.tHJ;
    int i = j;
    if (localb != null)
    {
      i = j;
      if (localb.tHL) {
        i = 2;
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.PrivateAlbumItem
 * JD-Core Version:    0.7.0.1
 */