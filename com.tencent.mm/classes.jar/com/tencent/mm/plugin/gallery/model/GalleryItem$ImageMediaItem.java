package com.tencent.mm.plugin.gallery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public class GalleryItem$ImageMediaItem
  extends GalleryItem.MediaItem
{
  public static final Parcelable.Creator<GalleryItem.MediaItem> CREATOR;
  
  static
  {
    AppMethodBeat.i(21291);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(21291);
  }
  
  public GalleryItem$ImageMediaItem() {}
  
  public GalleryItem$ImageMediaItem(long paramLong)
  {
    super(paramLong);
  }
  
  public GalleryItem$ImageMediaItem(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    super(paramLong, paramString1, paramString2, paramString3);
  }
  
  public final String Xi()
  {
    AppMethodBeat.i(21289);
    if (!bo.isNullOrNil(this.mnt))
    {
      str = this.mnt;
      AppMethodBeat.o(21289);
      return str;
    }
    String str = this.fQn;
    AppMethodBeat.o(21289);
    return str;
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
    AppMethodBeat.i(21290);
    paramParcel.writeString(this.fQn);
    paramParcel.writeString(this.mnt);
    paramParcel.writeLong(this.ndp);
    paramParcel.writeLong(this.ndq);
    paramParcel.writeString(this.mMimeType);
    AppMethodBeat.o(21290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem
 * JD-Core Version:    0.7.0.1
 */