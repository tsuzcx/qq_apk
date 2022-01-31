package com.tencent.mm.plugin.gallery.model;

import android.os.Parcelable;

public abstract class GalleryItem$MediaItem
  implements Parcelable, Comparable<MediaItem>
{
  public String eAu;
  public String jSX;
  public String kGV;
  public String kGW;
  public long kGX;
  public long kGY;
  public String mMimeType;
  
  public GalleryItem$MediaItem()
  {
    this(0L, "", "", "");
  }
  
  public GalleryItem$MediaItem(long paramLong)
  {
    this(paramLong, "", "", "");
  }
  
  public GalleryItem$MediaItem(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    this.kGX = paramLong;
    this.eAu = paramString1;
    this.jSX = paramString2;
    this.mMimeType = paramString3;
  }
  
  public static MediaItem B(int paramInt, long paramLong)
  {
    if (paramInt == 1) {
      return new GalleryItem.ImageMediaItem(paramLong);
    }
    return new GalleryItem.VideoMediaItem(paramLong);
  }
  
  public static MediaItem a(int paramInt, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    if (paramInt == 1) {
      return new GalleryItem.ImageMediaItem(paramLong, paramString1, paramString2, paramString3);
    }
    return new GalleryItem.VideoMediaItem(paramLong, paramString1, paramString2, paramString3);
  }
  
  public final int a(MediaItem paramMediaItem)
  {
    int i = -1;
    if (this.kGY > paramMediaItem.kGY) {
      i = 1;
    }
    while (this.kGY >= paramMediaItem.kGY) {
      return i;
    }
    return -1;
  }
  
  public abstract String aXs();
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      bool1 = bool2;
      if ((paramObject instanceof MediaItem))
      {
        paramObject = (MediaItem)paramObject;
        bool1 = bool2;
        if (this.eAu != null)
        {
          bool1 = bool2;
          if (this.eAu.equals(paramObject.eAu)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public abstract int getType();
  
  public String toString()
  {
    return "MediaItem{mOrignalPath='" + this.eAu + '\'' + ", mThumbPath='" + this.jSX + '\'' + ", origId=" + this.kGX + ", addDate=" + this.kGY + ", mMimeType='" + this.mMimeType + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem
 * JD-Core Version:    0.7.0.1
 */