package com.tencent.mm.plugin.gallery.model;

import java.util.LinkedList;

public abstract interface i
{
  public abstract LinkedList<GalleryItem.MediaItem> a(String paramString, int paramInt, i.c paramc, long paramLong);
  
  public abstract int aIp(String paramString);
  
  public abstract int aIq(String paramString);
  
  public abstract LinkedList<GalleryItem.AlbumItem> esR();
  
  public abstract void esX();
  
  public abstract void esY();
  
  public abstract boolean isCancelled();
  
  public static abstract interface a
  {
    public abstract void be(LinkedList<GalleryItem.AlbumItem> paramLinkedList);
  }
  
  public static abstract interface b
  {
    public abstract void c(LinkedList<GalleryItem.MediaItem> paramLinkedList, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.i
 * JD-Core Version:    0.7.0.1
 */