package com.tencent.mm.plugin.gallery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public class GalleryItem$ImageMediaItem
  extends GalleryItem.MediaItem
{
  public static final Parcelable.Creator<GalleryItem.MediaItem> CREATOR;
  
  static
  {
    AppMethodBeat.i(111318);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(111318);
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
  
  public final String aQn()
  {
    AppMethodBeat.i(111316);
    if (!Util.isNullOrNil(this.sUB))
    {
      str = this.sUB;
      AppMethodBeat.o(111316);
      return str;
    }
    String str = this.xiW;
    AppMethodBeat.o(111316);
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
    AppMethodBeat.i(111317);
    paramParcel.writeString(this.xiW);
    paramParcel.writeString(this.sUB);
    paramParcel.writeLong(this.xiZ);
    paramParcel.writeLong(this.xja);
    paramParcel.writeString(this.mMimeType);
    paramParcel.writeSerializable(this.xje);
    AppMethodBeat.o(111317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem
 * JD-Core Version:    0.7.0.1
 */