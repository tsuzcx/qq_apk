package com.tencent.mm.plugin.gallery.model;

public class GalleryItem$PrivateAlbumItem
  extends GalleryItem.AlbumItem
{
  public s.a BVu;
  
  public GalleryItem$PrivateAlbumItem(s.a parama)
  {
    super(parama.albumName, parama.BWa);
    this.BVu = parama;
  }
  
  public final String aZe()
  {
    return this.BVu.BWc;
  }
  
  public final String etI()
  {
    return this.BVu.BWc;
  }
  
  public final long etJ()
  {
    return this.BVu.BWb;
  }
  
  public final int etK()
  {
    int j = 1;
    s.b localb = this.BVu.BWd;
    int i = j;
    if (localb != null)
    {
      i = j;
      if (localb.BWf) {
        i = 2;
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.PrivateAlbumItem
 * JD-Core Version:    0.7.0.1
 */