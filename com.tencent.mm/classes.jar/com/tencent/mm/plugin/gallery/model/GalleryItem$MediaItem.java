package com.tencent.mm.plugin.gallery.model;

import android.os.Parcelable;
import com.tencent.mm.loader.h.a.c;
import java.util.HashMap;

public abstract class GalleryItem$MediaItem
  implements Parcelable, c, Comparable<MediaItem>
{
  public double bXD = 91.0D;
  public double bXE = 181.0D;
  public Object hQS;
  public String mMimeType;
  public String ruE;
  public String tRJ;
  public String tRK;
  public String tRL;
  public long tRM;
  public long tRN;
  public long tRO;
  public String tRP;
  public boolean tRQ = false;
  public HashMap<String, Object> tRR = new HashMap();
  
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
    this.tRM = paramLong;
    this.tRJ = paramString1;
    this.ruE = paramString2;
    this.mMimeType = paramString3;
  }
  
  public static MediaItem a(int paramInt, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    if (paramInt == 1) {
      return new GalleryItem.ImageMediaItem(paramLong, paramString1, paramString2, paramString3);
    }
    return new GalleryItem.VideoMediaItem(paramLong, paramString1, paramString2, paramString3);
  }
  
  public static MediaItem aj(int paramInt, long paramLong)
  {
    if (paramInt == 1) {
      return new GalleryItem.ImageMediaItem(paramLong);
    }
    return new GalleryItem.VideoMediaItem(paramLong);
  }
  
  public final String aeM()
  {
    return this.tRM + "_" + this.tRJ.hashCode();
  }
  
  public abstract String axP();
  
  public final String cXO()
  {
    return this.tRJ;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof MediaItem))
    {
      paramObject = (MediaItem)paramObject;
      if ((this.tRJ == null) || (!this.tRJ.equals(paramObject.tRJ)))
      {
        bool1 = bool2;
        if (this.mMimeType != null)
        {
          bool1 = bool2;
          if (this.mMimeType.equals("edit"))
          {
            bool1 = bool2;
            if (this.tRK != null)
            {
              bool1 = bool2;
              if (!this.tRK.equals(paramObject.tRJ)) {}
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
  
  public abstract int getType();
  
  public final void s(String paramString, Object paramObject)
  {
    this.tRR.put(paramString, paramObject);
  }
  
  public final <T> T t(String paramString, T paramT)
  {
    paramString = this.tRR.get(paramString);
    if (paramString != null) {
      paramT = paramString;
    }
    return paramT;
  }
  
  public final String toSimpleString()
  {
    return this.tRM + " " + this.mMimeType + " " + this.tRN + " | " + this.tRO;
  }
  
  public String toString()
  {
    return "MediaItem{mOriginalPath='" + this.tRJ + '\'' + ", mThumbPath='" + this.ruE + '\'' + ", origId=" + this.tRM + ", generateDate=" + this.tRN + ", mMimeType='" + this.mMimeType + '\'' + ", mLongitude='" + this.bXE + '\'' + ", mLatitude='" + this.bXD + '\'' + ", mBusinessTag='" + this.tRP + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem
 * JD-Core Version:    0.7.0.1
 */