package com.tencent.mm.plugin.gallery.model;

import android.os.Parcelable;

public abstract class GalleryItem$MediaItem
  implements Parcelable, Comparable<MediaItem>
{
  public double bnl = 181.0D;
  public double bnm = 91.0D;
  public String fQn;
  public String mMimeType;
  public String mnt;
  public String ndn;
  public String ndo;
  public long ndp;
  public long ndq;
  public long ndr;
  public String nds;
  
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
    this.ndp = paramLong;
    this.fQn = paramString1;
    this.mnt = paramString2;
    this.mMimeType = paramString3;
  }
  
  public static MediaItem S(int paramInt, long paramLong)
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
  
  public abstract String Xi();
  
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
        if (this.fQn != null)
        {
          bool1 = bool2;
          if (this.fQn.equals(paramObject.fQn)) {
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
    return "MediaItem{mOrignalPath='" + this.fQn + '\'' + ", mThumbPath='" + this.mnt + '\'' + ", origId=" + this.ndp + ", generateDate=" + this.ndq + ", mMimeType='" + this.mMimeType + '\'' + ", mLongitude='" + this.bnm + '\'' + ", mLatitude='" + this.bnl + '\'' + ", mBusinessTag='" + this.nds + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem
 * JD-Core Version:    0.7.0.1
 */