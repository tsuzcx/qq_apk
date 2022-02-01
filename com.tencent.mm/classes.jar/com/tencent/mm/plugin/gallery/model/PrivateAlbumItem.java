package com.tencent.mm.plugin.gallery.model;

public class PrivateAlbumItem
  extends GalleryItem.AlbumItem
{
  public t.a HIp;
  
  public PrivateAlbumItem(t.a parama)
  {
    super(parama.albumName, parama.HIy);
    this.HIp = parama;
  }
  
  public final String bud()
  {
    return this.HIp.HIA;
  }
  
  public final String fAJ()
  {
    return this.HIp.HIA;
  }
  
  public final long fAK()
  {
    return this.HIp.HIz;
  }
  
  public final int fAL()
  {
    int j = 1;
    t.b localb = this.HIp.HIB;
    int i = j;
    if (localb != null)
    {
      i = j;
      if (localb.HID) {
        i = 2;
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.PrivateAlbumItem
 * JD-Core Version:    0.7.0.1
 */