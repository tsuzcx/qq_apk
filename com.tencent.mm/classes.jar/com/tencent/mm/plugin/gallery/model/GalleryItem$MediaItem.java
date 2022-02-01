package com.tencent.mm.plugin.gallery.model;

import android.os.Parcelable;
import com.tencent.mm.loader.h.a.c;
import java.util.HashMap;

public abstract class GalleryItem$MediaItem
  implements Parcelable, c, Comparable<MediaItem>
{
  public double bXD = 91.0D;
  public double bXE = 181.0D;
  public Object hNZ;
  public String mMimeType;
  public String rmz;
  public String tGS;
  public String tGT;
  public String tGU;
  public long tGV;
  public long tGW;
  public long tGX;
  public String tGY;
  public boolean tGZ = false;
  public HashMap<String, Object> tHa = new HashMap();
  
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
    this.tGV = paramLong;
    this.tGS = paramString1;
    this.rmz = paramString2;
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
  
  public final String aeA()
  {
    return this.tGV + "_" + this.tGS.hashCode();
  }
  
  public abstract String axA();
  
  public final String cVj()
  {
    return this.tGS;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof MediaItem))
    {
      paramObject = (MediaItem)paramObject;
      if ((this.tGS == null) || (!this.tGS.equals(paramObject.tGS)))
      {
        bool1 = bool2;
        if (this.mMimeType != null)
        {
          bool1 = bool2;
          if (this.mMimeType.equals("edit"))
          {
            bool1 = bool2;
            if (this.tGT != null)
            {
              bool1 = bool2;
              if (!this.tGT.equals(paramObject.tGS)) {}
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
    this.tHa.put(paramString, paramObject);
  }
  
  public final <T> T t(String paramString, T paramT)
  {
    paramString = this.tHa.get(paramString);
    if (paramString != null) {
      paramT = paramString;
    }
    return paramT;
  }
  
  public final String toSimpleString()
  {
    return this.tGV + " " + this.mMimeType + " " + this.tGW + " | " + this.tGX;
  }
  
  public String toString()
  {
    return "MediaItem{mOriginalPath='" + this.tGS + '\'' + ", mThumbPath='" + this.rmz + '\'' + ", origId=" + this.tGV + ", generateDate=" + this.tGW + ", mMimeType='" + this.mMimeType + '\'' + ", mLongitude='" + this.bXE + '\'' + ", mLatitude='" + this.bXD + '\'' + ", mBusinessTag='" + this.tGY + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem
 * JD-Core Version:    0.7.0.1
 */