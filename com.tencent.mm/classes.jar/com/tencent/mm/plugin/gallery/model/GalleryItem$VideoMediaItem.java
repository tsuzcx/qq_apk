package com.tencent.mm.plugin.gallery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public class GalleryItem$VideoMediaItem
  extends GalleryItem.MediaItem
{
  public static final Parcelable.Creator<GalleryItem.MediaItem> CREATOR;
  public int eWL = -1;
  public String fQo;
  public String fQp;
  public int fQq = -1;
  public int fQr = -1;
  public int videoBitRate = -1;
  public int videoFrameRate = -1;
  public int videoHeight = -1;
  public int videoWidth = -1;
  
  static
  {
    AppMethodBeat.i(21296);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(21296);
  }
  
  public GalleryItem$VideoMediaItem() {}
  
  public GalleryItem$VideoMediaItem(long paramLong)
  {
    super(paramLong);
  }
  
  public GalleryItem$VideoMediaItem(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    super(paramLong, paramString1, paramString2, paramString3);
  }
  
  public final String Xi()
  {
    AppMethodBeat.i(21293);
    if (!bo.isNullOrNil(this.mnt))
    {
      str = this.mnt;
      AppMethodBeat.o(21293);
      return str;
    }
    String str = this.fQn;
    AppMethodBeat.o(21293);
    return str;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final int getType()
  {
    return 2;
  }
  
  public String toString()
  {
    AppMethodBeat.i(21295);
    String str = "VideoMediaItem{base=" + super.toString() + ", videoTrackMime='" + this.fQo + '\'' + ", audioTrackMime='" + this.fQp + '\'' + ", durationMs=" + this.fQq + ", videoHeight=" + this.videoHeight + ", videoWidth=" + this.videoWidth + ", videoBitRate=" + this.videoBitRate + ", videoIFrameInterval=" + this.fQr + ", videoFrameRate=" + this.videoFrameRate + '}';
    AppMethodBeat.o(21295);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(21294);
    paramParcel.writeString(this.fQn);
    paramParcel.writeString(this.mnt);
    paramParcel.writeLong(this.ndp);
    paramParcel.writeString(this.mMimeType);
    paramParcel.writeInt(this.videoWidth);
    paramParcel.writeInt(this.videoHeight);
    paramParcel.writeInt(this.fQq);
    paramParcel.writeString(this.fQo);
    paramParcel.writeString(this.fQp);
    paramParcel.writeInt(this.fQr);
    paramParcel.writeInt(this.videoFrameRate);
    paramParcel.writeInt(this.videoBitRate);
    paramParcel.writeInt(this.eWL);
    AppMethodBeat.o(21294);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem
 * JD-Core Version:    0.7.0.1
 */