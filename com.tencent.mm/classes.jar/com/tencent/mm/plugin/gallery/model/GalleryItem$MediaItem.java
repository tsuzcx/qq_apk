package com.tencent.mm.plugin.gallery.model;

import android.os.Parcelable;
import com.tencent.mm.loader.h.a.c;
import java.util.HashMap;

public abstract class GalleryItem$MediaItem
  implements Parcelable, c, Comparable<MediaItem>
{
  public String AAz;
  public String BVj;
  public String BVk;
  public long BVl;
  public long BVm;
  public String BVn;
  public long BVo;
  public double BVp = 181.0D;
  public double BVq = 91.0D;
  public String BVr;
  public boolean BVs = false;
  public HashMap<String, Object> BVt = new HashMap();
  public boolean fXF = false;
  public Object lCh;
  public String mMimeType;
  public String wAy;
  
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
    this.BVl = paramLong;
    this.AAz = paramString1;
    this.wAy = paramString2;
    this.mMimeType = paramString3;
  }
  
  public static MediaItem a(int paramInt, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    if (paramInt == 1) {
      return new GalleryItem.ImageMediaItem(paramLong, paramString1, paramString2, paramString3);
    }
    return new GalleryItem.VideoMediaItem(paramLong, paramString1, paramString2, paramString3);
  }
  
  public static MediaItem aw(int paramInt, long paramLong)
  {
    if (paramInt == 1) {
      return new GalleryItem.ImageMediaItem(paramLong);
    }
    return new GalleryItem.VideoMediaItem(paramLong);
  }
  
  public final String aBv()
  {
    return this.BVl + "_" + this.AAz.hashCode();
  }
  
  public abstract String aZe();
  
  public final int d(MediaItem paramMediaItem)
  {
    return (int)((this.BVm - paramMediaItem.BVm) / 1000L);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof MediaItem))
    {
      paramObject = (MediaItem)paramObject;
      if ((this.AAz == null) || (!this.AAz.equals(paramObject.AAz)))
      {
        bool1 = bool2;
        if (this.mMimeType != null)
        {
          bool1 = bool2;
          if (this.mMimeType.equals("edit"))
          {
            bool1 = bool2;
            if (this.BVj != null)
            {
              bool1 = bool2;
              if (!this.BVj.equals(paramObject.AAz)) {}
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
  
  public final String etI()
  {
    return this.AAz;
  }
  
  public final String etM()
  {
    return this.BVk;
  }
  
  public final String getMimeType()
  {
    return this.mMimeType;
  }
  
  public abstract int getType();
  
  public final void t(String paramString, Object paramObject)
  {
    this.BVt.put(paramString, paramObject);
  }
  
  public final String toSimpleString()
  {
    return this.BVl + " " + this.mMimeType + " " + this.BVm + "| " + this.BVn + " | " + this.BVo + " | " + this.fXF;
  }
  
  public String toString()
  {
    return "MediaItem{mOriginalPath='" + this.AAz + '\'' + ", mThumbPath='" + this.wAy + '\'' + ", origId=" + this.BVl + ", generateDate=" + this.BVm + ", dateTag=" + this.BVn + ", isChecked=" + this.fXF + ", mMimeType='" + this.mMimeType + '\'' + ", mLongitude='" + this.BVp + '\'' + ", mLatitude='" + this.BVq + '\'' + ", mBusinessTag='" + this.BVr + '\'' + '}';
  }
  
  public final <T> T u(String paramString, T paramT)
  {
    paramString = this.BVt.get(paramString);
    if (paramString != null) {
      paramT = paramString;
    }
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem
 * JD-Core Version:    0.7.0.1
 */