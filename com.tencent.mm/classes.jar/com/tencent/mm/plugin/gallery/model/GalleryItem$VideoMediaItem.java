package com.tencent.mm.plugin.gallery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;

public class GalleryItem$VideoMediaItem
  extends GalleryItem.MediaItem
{
  public static final Parcelable.Creator<GalleryItem.MediaItem> CREATOR;
  public int hoy = -1;
  public String ipJ;
  public String ipK;
  public int ipL = -1;
  public int videoBitRate = -1;
  public int videoFrameRate = -1;
  public int videoHeight = -1;
  public int videoIFrameInterval = -1;
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
  
  public final String axP()
  {
    AppMethodBeat.i(111320);
    if (!bu.isNullOrNil(this.ruE))
    {
      str = this.ruE;
      AppMethodBeat.o(111320);
      return str;
    }
    String str = this.tRJ;
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
    String str = "VideoMediaItem{base=" + super.toString() + ", videoTrackMime='" + this.ipJ + '\'' + ", audioTrackMime='" + this.ipK + '\'' + ", durationMs=" + this.ipL + ", videoHeight=" + this.videoHeight + ", videoWidth=" + this.videoWidth + ", videoBitRate=" + this.videoBitRate + ", videoIFrameInterval=" + this.videoIFrameInterval + ", videoFrameRate=" + this.videoFrameRate + '}';
    AppMethodBeat.o(111322);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(111321);
    paramParcel.writeString(this.tRJ);
    paramParcel.writeString(this.ruE);
    paramParcel.writeLong(this.tRM);
    paramParcel.writeString(this.mMimeType);
    paramParcel.writeInt(this.videoWidth);
    paramParcel.writeInt(this.videoHeight);
    paramParcel.writeInt(this.ipL);
    paramParcel.writeString(this.ipJ);
    paramParcel.writeString(this.ipK);
    paramParcel.writeInt(this.videoIFrameInterval);
    paramParcel.writeInt(this.videoFrameRate);
    paramParcel.writeInt(this.videoBitRate);
    paramParcel.writeInt(this.hoy);
    paramParcel.writeLong(this.tRN);
    paramParcel.writeSerializable(this.tRR);
    AppMethodBeat.o(111321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem
 * JD-Core Version:    0.7.0.1
 */