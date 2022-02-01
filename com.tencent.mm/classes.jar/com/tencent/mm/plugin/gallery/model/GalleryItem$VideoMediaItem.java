package com.tencent.mm.plugin.gallery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;

public class GalleryItem$VideoMediaItem
  extends GalleryItem.MediaItem
{
  public static final Parcelable.Creator<GalleryItem.MediaItem> CREATOR;
  public int gTI = -1;
  public String hTu;
  public String hTv;
  public int hTw = -1;
  public int hTx = -1;
  public int videoBitRate = -1;
  public int videoFrameRate = -1;
  public int videoHeight = -1;
  public int videoWidth = -1;
  
  static
  {
    AppMethodBeat.i(111323);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(111323);
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
  
  public final String auN()
  {
    AppMethodBeat.i(111320);
    if (!bs.isNullOrNil(this.qCJ))
    {
      str = this.qCJ;
      AppMethodBeat.o(111320);
      return str;
    }
    String str = this.sKh;
    AppMethodBeat.o(111320);
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
    AppMethodBeat.i(111322);
    String str = "VideoMediaItem{base=" + super.toString() + ", videoTrackMime='" + this.hTu + '\'' + ", audioTrackMime='" + this.hTv + '\'' + ", durationMs=" + this.hTw + ", videoHeight=" + this.videoHeight + ", videoWidth=" + this.videoWidth + ", videoBitRate=" + this.videoBitRate + ", videoIFrameInterval=" + this.hTx + ", videoFrameRate=" + this.videoFrameRate + '}';
    AppMethodBeat.o(111322);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(111321);
    paramParcel.writeString(this.sKh);
    paramParcel.writeString(this.qCJ);
    paramParcel.writeLong(this.sKk);
    paramParcel.writeString(this.mMimeType);
    paramParcel.writeInt(this.videoWidth);
    paramParcel.writeInt(this.videoHeight);
    paramParcel.writeInt(this.hTw);
    paramParcel.writeString(this.hTu);
    paramParcel.writeString(this.hTv);
    paramParcel.writeInt(this.hTx);
    paramParcel.writeInt(this.videoFrameRate);
    paramParcel.writeInt(this.videoBitRate);
    paramParcel.writeInt(this.gTI);
    paramParcel.writeLong(this.sKl);
    paramParcel.writeSerializable(this.sKp);
    AppMethodBeat.o(111321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem
 * JD-Core Version:    0.7.0.1
 */