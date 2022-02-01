package com.tencent.mm.plugin.gallery.model;

import android.os.Parcelable;
import com.tencent.mm.loader.h.a.c;
import java.util.HashMap;

public abstract class GalleryItem$MediaItem
  implements Parcelable, c, Comparable<MediaItem>
{
  public double bNq = 91.0D;
  public double bNr = 181.0D;
  public Object hvK;
  public String mMimeType;
  public String qCJ;
  public String sKh;
  public String sKi;
  public String sKj;
  public long sKk;
  public long sKl;
  public long sKm;
  public String sKn;
  public boolean sKo = false;
  public HashMap<String, Object> sKp = new HashMap();
  
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
    this.sKk = paramLong;
    this.sKh = paramString1;
    this.qCJ = paramString2;
    this.mMimeType = paramString3;
  }
  
  public static MediaItem a(int paramInt, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    if (paramInt == 1) {
      return new GalleryItem.ImageMediaItem(paramLong, paramString1, paramString2, paramString3);
    }
    return new GalleryItem.VideoMediaItem(paramLong, paramString1, paramString2, paramString3);
  }
  
  public static MediaItem af(int paramInt, long paramLong)
  {
    if (paramInt == 1) {
      return new GalleryItem.ImageMediaItem(paramLong);
    }
    return new GalleryItem.VideoMediaItem(paramLong);
  }
  
  public final String abW()
  {
    return this.sKk + "_" + this.sKh.hashCode();
  }
  
  public abstract String auN();
  
  public final String cMQ()
  {
    return this.sKh;
  }
  
  public final String cMU()
  {
    return this.sKj;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof MediaItem))
    {
      paramObject = (MediaItem)paramObject;
      if ((this.sKh == null) || (!this.sKh.equals(paramObject.sKh)))
      {
        bool1 = bool2;
        if (this.mMimeType != null)
        {
          bool1 = bool2;
          if (this.mMimeType.equals("edit"))
          {
            bool1 = bool2;
            if (this.sKi != null)
            {
              bool1 = bool2;
              if (!this.sKi.equals(paramObject.sKh)) {}
            }
          }
        }
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final String getMimeType()
  {
    return this.mMimeType;
  }
  
  public abstract int getType();
  
  public final String toSimpleString()
  {
    return this.sKk + " " + this.mMimeType + " " + this.sKl + " | " + this.sKm;
  }
  
  public String toString()
  {
    return "MediaItem{mOriginalPath='" + this.sKh + '\'' + ", mThumbPath='" + this.qCJ + '\'' + ", origId=" + this.sKk + ", generateDate=" + this.sKl + ", mMimeType='" + this.mMimeType + '\'' + ", mLongitude='" + this.bNr + '\'' + ", mLatitude='" + this.bNq + '\'' + ", mBusinessTag='" + this.sKn + '\'' + '}';
  }
  
  public final void u(String paramString, Object paramObject)
  {
    this.sKp.put(paramString, paramObject);
  }
  
  public final <T> T v(String paramString, T paramT)
  {
    paramString = this.sKp.get(paramString);
    if (paramString != null) {
      paramT = paramString;
    }
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem
 * JD-Core Version:    0.7.0.1
 */