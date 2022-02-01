package com.tencent.mm.plugin.gallery.model;

import android.os.Parcelable;
import com.tencent.mm.loader.h.a.c;
import java.util.HashMap;

public abstract class GalleryItem$MediaItem
  implements Parcelable, c, Comparable<MediaItem>
{
  public double cik = 91.0D;
  public double cil = 181.0D;
  public Object iMa;
  public String mMimeType;
  public String sUB;
  public String xiW;
  public String xiX;
  public String xiY;
  public long xiZ;
  public long xja;
  public long xjb;
  public String xjc;
  public boolean xjd = false;
  public HashMap<String, Object> xje = new HashMap();
  
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
    this.xiZ = paramLong;
    this.xiW = paramString1;
    this.sUB = paramString2;
    this.mMimeType = paramString3;
  }
  
  public static MediaItem a(int paramInt, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    if (paramInt == 1) {
      return new GalleryItem.ImageMediaItem(paramLong, paramString1, paramString2, paramString3);
    }
    return new GalleryItem.VideoMediaItem(paramLong, paramString1, paramString2, paramString3);
  }
  
  public static MediaItem ap(int paramInt, long paramLong)
  {
    if (paramInt == 1) {
      return new GalleryItem.ImageMediaItem(paramLong);
    }
    return new GalleryItem.VideoMediaItem(paramLong);
  }
  
  public abstract String aQn();
  
  public final String auA()
  {
    return this.xiZ + "_" + this.xiW.hashCode();
  }
  
  public final String dRh()
  {
    return this.xiW;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof MediaItem))
    {
      paramObject = (MediaItem)paramObject;
      if ((this.xiW == null) || (!this.xiW.equals(paramObject.xiW)))
      {
        bool1 = bool2;
        if (this.mMimeType != null)
        {
          bool1 = bool2;
          if (this.mMimeType.equals("edit"))
          {
            bool1 = bool2;
            if (this.xiX != null)
            {
              bool1 = bool2;
              if (!this.xiX.equals(paramObject.xiW)) {}
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
  
  public final String toSimpleString()
  {
    return this.xiZ + " " + this.mMimeType + " " + this.xja + " | " + this.xjb;
  }
  
  public String toString()
  {
    return "MediaItem{mOriginalPath='" + this.xiW + '\'' + ", mThumbPath='" + this.sUB + '\'' + ", origId=" + this.xiZ + ", generateDate=" + this.xja + ", mMimeType='" + this.mMimeType + '\'' + ", mLongitude='" + this.cil + '\'' + ", mLatitude='" + this.cik + '\'' + ", mBusinessTag='" + this.xjc + '\'' + '}';
  }
  
  public final void u(String paramString, Object paramObject)
  {
    this.xje.put(paramString, paramObject);
  }
  
  public final <T> T w(String paramString, T paramT)
  {
    paramString = this.xje.get(paramString);
    if (paramString != null) {
      paramT = paramString;
    }
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem
 * JD-Core Version:    0.7.0.1
 */