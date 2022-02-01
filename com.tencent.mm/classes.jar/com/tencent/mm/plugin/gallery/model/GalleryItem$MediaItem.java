package com.tencent.mm.plugin.gallery.model;

import android.os.Parcelable;
import com.tencent.mm.loader.h.a.c;
import java.util.HashMap;

public abstract class GalleryItem$MediaItem
  implements Parcelable, c, Comparable<MediaItem>
{
  public HashMap<String, Object> Lmm = new HashMap();
  public double bPI = 91.0D;
  public double bPJ = 181.0D;
  public Object gVl;
  public String mMimeType;
  public String pUe;
  public String rBp;
  public String rBq;
  public String rBr;
  public long rBs;
  public long rBt;
  public long rBu;
  public String rBv;
  public boolean rBw = false;
  
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
    this.rBs = paramLong;
    this.rBp = paramString1;
    this.pUe = paramString2;
    this.mMimeType = paramString3;
  }
  
  public static MediaItem a(int paramInt, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    if (paramInt == 1) {
      return new GalleryItem.ImageMediaItem(paramLong, paramString1, paramString2, paramString3);
    }
    return new GalleryItem.VideoMediaItem(paramLong, paramString1, paramString2, paramString3);
  }
  
  public static MediaItem ag(int paramInt, long paramLong)
  {
    if (paramInt == 1) {
      return new GalleryItem.ImageMediaItem(paramLong);
    }
    return new GalleryItem.VideoMediaItem(paramLong);
  }
  
  public final void D(String paramString, Object paramObject)
  {
    this.Lmm.put(paramString, paramObject);
  }
  
  public final <T> T E(String paramString, T paramT)
  {
    paramString = this.Lmm.get(paramString);
    if (paramString != null) {
      paramT = paramString;
    }
    return paramT;
  }
  
  public final String aaX()
  {
    return this.rBs + "_" + this.rBp.hashCode();
  }
  
  public abstract String anX();
  
  public final String czE()
  {
    return this.rBp;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof MediaItem))
    {
      paramObject = (MediaItem)paramObject;
      if ((this.rBp == null) || (!this.rBp.equals(paramObject.rBp)))
      {
        bool1 = bool2;
        if (this.mMimeType != null)
        {
          bool1 = bool2;
          if (this.mMimeType.equals("edit"))
          {
            bool1 = bool2;
            if (this.rBq != null)
            {
              bool1 = bool2;
              if (!this.rBq.equals(paramObject.rBp)) {}
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
  
  public final String fXR()
  {
    return this.rBr;
  }
  
  public final String getMimeType()
  {
    return this.mMimeType;
  }
  
  public abstract int getType();
  
  public final String toSimpleString()
  {
    return this.rBs + " " + this.mMimeType + " " + this.rBt + " | " + this.rBu;
  }
  
  public String toString()
  {
    return "MediaItem{mOriginalPath='" + this.rBp + '\'' + ", mThumbPath='" + this.pUe + '\'' + ", origId=" + this.rBs + ", generateDate=" + this.rBt + ", mMimeType='" + this.mMimeType + '\'' + ", mLongitude='" + this.bPJ + '\'' + ", mLatitude='" + this.bPI + '\'' + ", mBusinessTag='" + this.rBv + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem
 * JD-Core Version:    0.7.0.1
 */