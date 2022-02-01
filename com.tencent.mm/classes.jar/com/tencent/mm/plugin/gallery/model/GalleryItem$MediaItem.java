package com.tencent.mm.plugin.gallery.model;

import android.os.Parcelable;
import com.tencent.mm.loader.g.a.c;
import java.util.HashMap;

public abstract class GalleryItem$MediaItem
  implements Parcelable, c, Comparable<MediaItem>
{
  public String Gcc;
  public String HHH;
  public String HHI;
  public long HHJ;
  public long HHK;
  public String HHL;
  public long HHM;
  public double HHN = 181.0D;
  public double HHO = 91.0D;
  public String HHP;
  public boolean HHQ = false;
  public HashMap<String, Object> HHR = new HashMap();
  public Object extra;
  public boolean idG = false;
  public String mMimeType;
  public String zWJ;
  
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
    this.HHJ = paramLong;
    this.Gcc = paramString1;
    this.zWJ = paramString2;
    this.mMimeType = paramString3;
  }
  
  public static MediaItem a(int paramInt, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    if (paramInt == 1) {
      return new GalleryItem.ImageMediaItem(paramLong, paramString1, paramString2, paramString3);
    }
    return new GalleryItem.VideoMediaItem(paramLong, paramString1, paramString2, paramString3);
  }
  
  public static MediaItem aD(int paramInt, long paramLong)
  {
    if (paramInt == 1) {
      return new GalleryItem.ImageMediaItem(paramLong);
    }
    return new GalleryItem.VideoMediaItem(paramLong);
  }
  
  public final void G(String paramString, Object paramObject)
  {
    this.HHR.put(paramString, paramObject);
  }
  
  public final <T> T H(String paramString, T paramT)
  {
    paramString = this.HHR.get(paramString);
    if (paramString != null) {
      paramT = paramString;
    }
    return paramT;
  }
  
  public final String aUt()
  {
    return this.HHJ + "_" + this.Gcc.hashCode();
  }
  
  public abstract String bud();
  
  public final int c(MediaItem paramMediaItem)
  {
    return (int)((this.HHK - paramMediaItem.HHK) / 1000L);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof MediaItem))
    {
      paramObject = (MediaItem)paramObject;
      if ((this.Gcc == null) || (!this.Gcc.equals(paramObject.Gcc)))
      {
        bool1 = bool2;
        if (this.mMimeType != null)
        {
          bool1 = bool2;
          if (this.mMimeType.equals("edit"))
          {
            bool1 = bool2;
            if (this.HHH != null)
            {
              bool1 = bool2;
              if (!this.HHH.equals(paramObject.Gcc)) {}
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
    return this.HHJ + " " + this.mMimeType + " " + this.HHK + "| " + this.HHL + " | " + this.HHM + " | " + this.idG;
  }
  
  public String toString()
  {
    return "MediaItem{mOriginalPath='" + this.Gcc + '\'' + ", mThumbPath='" + this.zWJ + '\'' + ", origId=" + this.HHJ + ", generateDate=" + this.HHK + ", dateTag=" + this.HHL + ", isChecked=" + this.idG + ", mMimeType='" + this.mMimeType + '\'' + ", mLongitude='" + this.HHN + '\'' + ", mLatitude='" + this.HHO + '\'' + ", mBusinessTag='" + this.HHP + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem
 * JD-Core Version:    0.7.0.1
 */