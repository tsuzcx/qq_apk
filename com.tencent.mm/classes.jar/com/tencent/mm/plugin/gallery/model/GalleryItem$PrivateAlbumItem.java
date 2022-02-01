package com.tencent.mm.plugin.gallery.model;

public class GalleryItem$PrivateAlbumItem
  extends GalleryItem.AlbumItem
{
  public s.a tRS;
  
  public GalleryItem$PrivateAlbumItem(s.a parama)
  {
    super(parama.tRB, parama.tSx);
    this.tRS = parama;
  }
  
  public final String axP()
  {
    return this.tRS.tSz;
  }
  
  public final String cXO()
  {
    return this.tRS.tSz;
  }
  
  public final long cXP()
  {
    return this.tRS.tSy;
  }
  
  public final int cXQ()
  {
    int j = 1;
    s.b localb = this.tRS.tSA;
    int i = j;
    if (localb != null)
    {
      i = j;
      if (localb.tSC) {
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