package com.tencent.mm.plugin.gallery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public class GalleryItem$VideoMediaItem
  extends GalleryItem.MediaItem
{
  public static final Parcelable.Creator<GalleryItem.MediaItem> CREATOR;
  public int gta = -1;
  public String hsS;
  public String hsT;
  public int hsU = -1;
  public int hsV = -1;
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
  
  public final String anX()
  {
    AppMethodBeat.i(111320);
    if (!bt.isNullOrNil(this.pUe))
    {
      str = this.pUe;
      AppMethodBeat.o(111320);
      return str;
    }
    String str = this.rBp;
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
    String str = "VideoMediaItem{base=" + super.toString() + ", videoTrackMime='" + this.hsS + '\'' + ", audioTrackMime='" + this.hsT + '\'' + ", durationMs=" + this.hsU + ", videoHeight=" + this.videoHeight + ", videoWidth=" + this.videoWidth + ", videoBitRate=" + this.videoBitRate + ", videoIFrameInterval=" + this.hsV + ", videoFrameRate=" + this.videoFrameRate + '}';
    AppMethodBeat.o(111322);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(111321);
    paramParcel.writeString(this.rBp);
    paramParcel.writeString(this.pUe);
    paramParcel.writeLong(this.rBs);
    paramParcel.writeString(this.mMimeType);
    paramParcel.writeInt(this.videoWidth);
    paramParcel.writeInt(this.videoHeight);
    paramParcel.writeInt(this.hsU);
    paramParcel.writeString(this.hsS);
    paramParcel.writeString(this.hsT);
    paramParcel.writeInt(this.hsV);
    paramParcel.writeInt(this.videoFrameRate);
    paramParcel.writeInt(this.videoBitRate);
    paramParcel.writeInt(this.gta);
    paramParcel.writeLong(this.rBt);
    paramParcel.writeSerializable(this.Lmm);
    AppMethodBeat.o(111321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem
 * JD-Core Version:    0.7.0.1
 */