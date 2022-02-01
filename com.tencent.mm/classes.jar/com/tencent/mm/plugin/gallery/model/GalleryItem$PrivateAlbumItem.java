package com.tencent.mm.plugin.gallery.model;

public class GalleryItem$PrivateAlbumItem
  extends GalleryItem.AlbumItem
{
  public s.a rBx;
  
  public GalleryItem$PrivateAlbumItem(s.a parama)
  {
    super(parama.rBh, parama.rCd);
    this.rBx = parama;
  }
  
  public final String anX()
  {
    return this.rBx.rCf;
  }
  
  public final String czE()
  {
    return this.rBx.rCf;
  }
  
  public final long czF()
  {
    return this.rBx.rCe;
  }
  
  public final int czG()
  {
    int j = 1;
    s.b localb = this.rBx.rCg;
    int i = j;
    if (localb != null)
    {
      i = j;
      if (localb.rCi) {
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