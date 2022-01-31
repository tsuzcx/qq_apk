package com.tencent.mm.plugin.gallery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bk;

public class GalleryItem$ImageMediaItem
  extends GalleryItem.MediaItem
{
  public static final Parcelable.Creator<GalleryItem.MediaItem> CREATOR = new Parcelable.Creator() {};
  
  public GalleryItem$ImageMediaItem() {}
  
  public GalleryItem$ImageMediaItem(long paramLong)
  {
    super(paramLong);
  }
  
  public GalleryItem$ImageMediaItem(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    super(paramLong, paramString1, paramString2, paramString3);
  }
  
  public final String aXs()
  {
    if (!bk.bl(this.jSX)) {
      return this.jSX;
    }
    return this.eAu;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final int getType()
  {
    return 1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.eAu);
    paramParcel.writeString(this.jSX);
    paramParcel.writeLong(this.kGX);
    paramParcel.writeLong(this.kGY);
    paramParcel.writeString(this.mMimeType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem
 * JD-Core Version:    0.7.0.1
 */