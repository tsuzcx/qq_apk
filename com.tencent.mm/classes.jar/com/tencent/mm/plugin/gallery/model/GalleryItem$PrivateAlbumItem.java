package com.tencent.mm.plugin.gallery.model;

public class GalleryItem$PrivateAlbumItem
  extends GalleryItem.AlbumItem
{
  public s.a xjf;
  
  public GalleryItem$PrivateAlbumItem(s.a parama)
  {
    super(parama.albumName, parama.xjK);
    this.xjf = parama;
  }
  
  public final String aQn()
  {
    return this.xjf.xjM;
  }
  
  public final String dRh()
  {
    return this.xjf.xjM;
  }
  
  public final long dRi()
  {
    return this.xjf.xjL;
  }
  
  public final int dRj()
  {
    int j = 1;
    s.b localb = this.xjf.xjN;
    int i = j;
    if (localb != null)
    {
      i = j;
      if (localb.xjP) {
        i = 2;
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.PrivateAlbumItem
 * JD-Core Version:    0.7.0.1
 */