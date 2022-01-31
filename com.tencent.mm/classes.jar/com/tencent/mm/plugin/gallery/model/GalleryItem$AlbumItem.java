package com.tencent.mm.plugin.gallery.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bk;

public class GalleryItem$AlbumItem
  implements Parcelable
{
  public static final Parcelable.Creator<AlbumItem> CREATOR = new GalleryItem.AlbumItem.1();
  public int bLO;
  public String kGT;
  public GalleryItem.MediaItem kGU;
  
  protected GalleryItem$AlbumItem(Parcel paramParcel)
  {
    this.kGT = paramParcel.readString();
    this.bLO = paramParcel.readInt();
    this.kGU = ((GalleryItem.MediaItem)paramParcel.readParcelable(GalleryItem.MediaItem.class.getClassLoader()));
  }
  
  public GalleryItem$AlbumItem(String paramString, int paramInt)
  {
    this.kGT = bk.pm(paramString);
    this.bLO = paramInt;
  }
  
  public final String aXs()
  {
    if (this.kGU == null) {
      return null;
    }
    return this.kGU.aXs();
  }
  
  public final long aXt()
  {
    if (this.kGU == null) {
      return -1L;
    }
    return this.kGU.kGX;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.kGT);
    paramParcel.writeInt(this.bLO);
    paramParcel.writeParcelable(this.kGU, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem
 * JD-Core Version:    0.7.0.1
 */