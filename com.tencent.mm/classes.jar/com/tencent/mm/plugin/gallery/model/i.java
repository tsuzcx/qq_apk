package com.tencent.mm.plugin.gallery.model;

import java.util.LinkedList;

public abstract interface i
{
  public abstract LinkedList<GalleryItem.MediaItem> a(String paramString, int paramInt, i.d paramd, long paramLong);
  
  public abstract LinkedList<GalleryItem.AlbumItem> bDJ();
  
  public abstract void bDK();
  
  public abstract void bDM();
  
  public static abstract interface b
  {
    public abstract void b(LinkedList<GalleryItem.MediaItem> paramLinkedList, long paramLong);
  }
  
  public static abstract interface c
  {
    public abstract void c(LinkedList<GalleryItem.MediaItem> paramLinkedList, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.i
 * JD-Core Version:    0.7.0.1
 */