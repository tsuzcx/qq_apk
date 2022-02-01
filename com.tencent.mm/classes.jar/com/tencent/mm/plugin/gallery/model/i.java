package com.tencent.mm.plugin.gallery.model;

import java.util.LinkedList;

public abstract interface i
{
  public abstract LinkedList<GalleryItem.MediaItem> a(String paramString, int paramInt, c paramc, long paramLong);
  
  public abstract LinkedList<GalleryItem.AlbumItem> dQr();
  
  public abstract void dQw();
  
  public abstract void dQx();
  
  public abstract boolean isCancelled();
  
  public static abstract interface a
  {
    public abstract void aL(LinkedList<GalleryItem.AlbumItem> paramLinkedList);
  }
  
  public static abstract interface b
  {
    public abstract void c(LinkedList<GalleryItem.MediaItem> paramLinkedList, long paramLong);
  }
  
  public static abstract interface c
  {
    public abstract void b(LinkedList<GalleryItem.MediaItem> paramLinkedList, long paramLong, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.i
 * JD-Core Version:    0.7.0.1
 */