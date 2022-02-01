package com.tencent.mm.plugin.gallery.model;

public class GalleryItem$PrivateAlbumItem
  extends GalleryItem.AlbumItem
{
  public s.a sKq;
  
  public GalleryItem$PrivateAlbumItem(s.a parama)
  {
    super(parama.sJZ, parama.sKW);
    this.sKq = parama;
  }
  
  public final String auN()
  {
    return this.sKq.sKY;
  }
  
  public final String cMQ()
  {
    return this.sKq.sKY;
  }
  
  public final long cMR()
  {
    return this.sKq.sKX;
  }
  
  public final int cMS()
  {
    int j = 1;
    s.b localb = this.sKq.sKZ;
    int i = j;
    if (localb != null)
    {
      i = j;
      if (localb.sLb) {
        i = 2;
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.PrivateAlbumItem
 * JD-Core Version:    0.7.0.1
 */